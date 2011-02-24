/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.inbio.ara.gis;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.gis.GeoreferencedSitePKDTO;
import org.inbio.ara.dto.gis.SiteCoordinateDTO;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.dto.inventory.GatheringObservationDTO;
import org.inbio.ara.facade.gis.GisFacadeRemote;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.search.SearchFacadeRemote;
import org.inbio.ara.facade.taxonomy.TaxonomyFacadeRemote;
import org.inbio.ara.util.PaginationControllerRemix;
import org.inbio.ara.util.PaginationCoreInterface;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version SiteSessionBean.java
 * @version Created on 14/09/2009, 05:11:28 PM
 * @author mvargas
 */


public class SiteSessionBean extends AbstractSessionBean implements PaginationCoreInterface{
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    //Injections
    @EJB
    private GisFacadeRemote gisFacade;
    @EJB
    private SearchFacadeRemote searchFacade;
    @EJB
    private TaxonomyFacadeRemote taxonFacade;
    @EJB
    private InventoryFacadeRemote inventoryFacade;

    //Objeto que controla la paginacion de la informacion de passport
    private PaginationControllerRemix pagination = null;

    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;
    //Bandera para indicarle al paginador que trabaje en modo busqueda avanzada
    private boolean queryMode = false;
    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    //Bandera que indica si el sitio es valido para ser persistido
    private boolean siteValid = true;

    //Value binding for drop downs de busquedas
    private Long selectedCountry = null;
    private Long selectedProvince = null;
    private Long selectedDiscarded;

    //Value binding for drop down de creacion de sitios
    private Long selectedType = null;
    private Long selectedBaseProjection = null;
    private Long selectedDeterminationMethod = null;
    private Long selectedOriginProjection = null;
    private Long selectedCountryId = null;
    private Long selectedProvinceId = null;

    //Site DTO seleccionado por el usuario para editar
    private SiteDTO currentSiteDTO = new SiteDTO();
    //SiteDTO que sera convertido en entidad y sera persistido
    private SiteDTO querySiteDTO = new SiteDTO();
    //String que indica la consulta del usuario en la busqueda simple
    private String consultaSimple = new String("");

    //Data provider para las coordenadas del sitio
    private List<SiteCoordinateDTO> coordinateDataProvider =
            new ArrayList<SiteCoordinateDTO>();

    private Long INVALID_VALUE_ID = new Long(-1);

    /**
     * Le indica al prerender de la pantalla de edit que cargue los
     * datos actuales solamnete UNA vez
     * true = cargar datos
     * false = ignorar la carga de datos seleccionados
     */
    private boolean firstTime = true;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SiteSessionBean() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     *
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        setSelectedDiscarded(new Long(1));

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("SiteSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     *
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }
    
//*************** Operaciones del data provider de coordenadas *****************

    public boolean addElement(SiteCoordinateDTO object) {
        if (objectExists(object)==false) {
            this.getCoordinateDataProvider().add(object);
            return true;
        } else {
            return false;
        }
    }

    public boolean objectExists(SiteCoordinateDTO object) {
        //List<LifeStageSexSimple> tList = this.getList();
        List<SiteCoordinateDTO> tList = this.getCoordinateDataProvider();
        //Long newLifeStageId = object.getLifeStage().getId();
        Double longitude = object.getLongitude();
        //Long newSexId = object.getSex().getId();
        Double latitude = object.getLatitude();
        for (SiteCoordinateDTO tObject : tList) {
            if (tObject.getLongitude().compareTo(longitude)== 0) {
                if (tObject.getLatitude().compareTo(latitude)==0) {
                    return true;
                }
            }
        }
        return false;
    }

//******************************************************************************

    /**
     * Guardar el nuevo sitio, sus coordenadas y division politica
     */
    public void saveNewSite(){
        SiteDTO newDTO = this.getGisFacade().saveNewSite(this.getCurrentSiteDTO(),
                this.getCoordinateDataProvider(),
                getGeoreferencedSitePKListForCreate());
        this.setCurrentSiteDTO(newDTO);
    }

    /**
     * Actualizar el sitio, sus coordenadas y division politica
     */
    public void updateNewSite(){
        SiteDTO newDTO = this.getGisFacade().updateSite(this.getCurrentSiteDTO(),
                this.getCoordinateDataProvider(),
                getGeoreferencedSitePKListForCreate());
        this.setCurrentSiteDTO(newDTO);
    }

    /**
     * Metodo para eliminar Localidades por su id
     * @param Id
     */
    public void deleteSite(Long Id){
        this.gisFacade.deleteSite(Id);
    }

    /**
     * Devuelve la lista de GeoreferencedSitePKDTO con el siteId en null.
     * @return
     */
    public List<GeoreferencedSitePKDTO> getGeoreferencedSitePKListForCreate(){
        List<GeoreferencedSitePKDTO> gsPKs = new ArrayList<GeoreferencedSitePKDTO>();

        if (!getSelectedProvinceId().equals(INVALID_VALUE_ID)){
            GeoreferencedSitePKDTO auxProvince = new GeoreferencedSitePKDTO();
            auxProvince.setSiteId(null);
            auxProvince.setGeographicLayerId(getGisFacade().PROVINCE_LAYER);
            auxProvince.setGeographicSiteId(selectedProvinceId);
            gsPKs.add(auxProvince);
        }

        if (!getSelectedCountryId().equals(INVALID_VALUE_ID)){
            GeoreferencedSitePKDTO auxCountry = new GeoreferencedSitePKDTO();
            auxCountry.setSiteId(null);
            auxCountry.setGeographicLayerId(getGisFacade().COUNTRY_LAYER);
            auxCountry.setGeographicSiteId(selectedCountryId);
            gsPKs.add(auxCountry);
        }
        return gsPKs;
    }

    /**
     * Inicializar el data provider de especimenes
     */
    public void initDataProvider() {
        this.setPagination(new PaginationControllerRemix(this.getGisFacade().countSites().intValue(), getQuantity(), this));
        this.getPagination().firstResults();
    }    

    /**
     *
     * @return un String que contiene el detalle de la paginacion
     */
    public String getQuantityTotal() {
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  "+(actualPage+1)+" - "+(actualPage+resultsPerPage)+"  | "+totalResults+"  ";
    }

    /**
     * @return the quantity
     */
    public //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the advancedSearch
     */
    public boolean isAdvancedSearch() {
        return advancedSearch;
    }

     /**
     * Metodo ejecutado por el drop down de paises para calcular las provincias correspondientes
     */
    public List<GeographicLayerDTO> SetProvincesDropDownData() {
        if(this.getSelectedCountry()==null){
            return null;
        }
        else{
            Long countryid = new Long(this.getSelectedCountry());
            return this.gisFacade.getProvincesByCountry(countryid);
        }
    }

    /**
     * Obtener los datos para el drop down de paises
     */
    public List<GeographicLayerDTO> SetCountryDropDownData() {
        return this.gisFacade.getAllCountries();
    }

    public List<String> getDefaultNameByGathObsId(Long gathObsId)
    {
        return this.taxonFacade.getDefaultNameByGathObsId(gathObsId);
    }

    public List<GatheringObservationDTO> getGathObsBySideId(Long siteId)
    {
        return this.inventoryFacade.getGathObsBySiteId(siteId);
    }


    /**
     * @param advancedSearch the advancedSearch to set
     */
    public void setAdvancedSearch(boolean advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    /**
     * @return the gisFacade
     */
    public GisFacadeRemote getGisFacade() {
        return gisFacade;
    }

    /**
     * @param gisFacade the gisFacade to set
     */
    public void setGisFacade(GisFacadeRemote gisFacade) {
        this.gisFacade = gisFacade;
    }

    /**
     * @return the selectedCountry
     */
    public Long getSelectedCountry() {
        return selectedCountry;
    }

    /**
     * @param selectedCountry the selectedCountry to set
     */
    public void setSelectedCountry(Long selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    /**
     * @return the selectedProvince
     */
    public Long getSelectedProvince() {
        return selectedProvince;
    }

    /**
     * @param selectedProvince the selectedProvince to set
     */
    public void setSelectedProvince(Long selectedProvince) {
        this.selectedProvince = selectedProvince;
    }

    /**
     * @return the currentSiteDTO
     */
    public SiteDTO getCurrentSiteDTO() {
        return currentSiteDTO;
    }

    /**
     * @param currentSiteDTO the currentSiteDTO to set
     */
    public void setCurrentSiteDTO(SiteDTO currentSiteDTO) {
        this.currentSiteDTO = currentSiteDTO;
    }

    /**
     * @return the querySiteDTO
     */
    public SiteDTO getQuerySiteDTO() {
        return querySiteDTO;
    }

    /**
     * @param querySiteDTO the querySiteDTO to set
     */
    public void setQuerySiteDTO(SiteDTO querySiteDTO) {
        this.querySiteDTO = querySiteDTO;
    }

    /**
     * @return the queryMode
     */
    public boolean isQueryMode() {
        return queryMode;
    }

    /**
     * @param queryMode the queryMode to set
     */
    public void setQueryMode(boolean queryMode) {
        this.queryMode = queryMode;
    }

    /**
     * @return the selectedDiscarded
     */
    public Long getSelectedDiscarded() {
        return selectedDiscarded;
    }

    /**
     * @param selectedDiscarded the selectedDiscarded to set
     */
    public void setSelectedDiscarded(Long selectedDiscarded) {
        this.selectedDiscarded = selectedDiscarded;
    }

    /**
     * @return the queryModeSimple
     */
    public boolean isQueryModeSimple() {
        return queryModeSimple;
    }

    /**
     * @param queryModeSimple the queryModeSimple to set
     */
    public void setQueryModeSimple(boolean queryModeSimple) {
        this.queryModeSimple = queryModeSimple;
    }

    /**
     * @return the consultaSimple
     */
    public String getConsultaSimple() {
        return consultaSimple;
    }

    /**
     * @param consultaSimple the consultaSimple to set
     */
    public void setConsultaSimple(String consultaSimple) {
        this.consultaSimple = consultaSimple;
    }

    /**
     * @return the siteValid
     */
    public boolean isSiteValid() {
        return siteValid;
    }

    /**
     * @param siteValid the siteValid to set
     */
    public void setSiteValid(boolean siteValid) {
        this.siteValid = siteValid;
    }

    /**
     * @return the searchFacade
     */
    public SearchFacadeRemote getSearchFacade() {
        return searchFacade;
    }

    /**
     * @param searchFacade the searchFacade to set
     */
    public void setSearchFacade(SearchFacadeRemote searchFacade) {
        this.searchFacade = searchFacade;
    }

    /**
     * @return the selectedType
     */
    public Long getSelectedType() {
        return selectedType;
    }

    /**
     * @param selectedType the selectedType to set
     */
    public void setSelectedType(Long selectedType) {
        this.selectedType = selectedType;
    }

    /**
     * @return the selectedBaseProjection
     */
    public Long getSelectedBaseProjection() {
        return selectedBaseProjection;
    }

    /**
     * @param selectedBaseProjection the selectedBaseProjection to set
     */
    public void setSelectedBaseProjection(Long selectedBaseProjection) {
        this.selectedBaseProjection = selectedBaseProjection;
    }

    /**
     * @return the selectedDeterminationMethod
     */
    public Long getSelectedDeterminationMethod() {
        return selectedDeterminationMethod;
    }

    /**
     * @param selectedDeterminationMethod the selectedDeterminationMethod to set
     */
    public void setSelectedDeterminationMethod(Long selectedDeterminationMethod) {
        this.selectedDeterminationMethod = selectedDeterminationMethod;
    }

    /**
     * @return the selectedOriginProjection
     */
    public Long getSelectedOriginProjection() {
        return selectedOriginProjection;
    }

    /**
     * @param selectedOriginProjection the selectedOriginProjection to set
     */
    public void setSelectedOriginProjection(Long selectedOriginProjection) {
        this.selectedOriginProjection = selectedOriginProjection;
    }

    /**
     * @return the coordinateDataProvider
     */
    public List<SiteCoordinateDTO> getCoordinateDataProvider() {
        return coordinateDataProvider;
    }

    /**
     * @param coordinateDataProvider the coordinateDataProvider to set
     */
    public void setCoordinateDataProvider(List<SiteCoordinateDTO> coordinateDataProvider) {
        this.coordinateDataProvider = coordinateDataProvider;
    }

    /**
     * @return the selectedCountryId
     */
    public Long getSelectedCountryId() {
        return selectedCountryId;
    }

    /**
     * @param selectedCountryId the selectedCountryId to set
     */
    public void setSelectedCountryId(Long selectedCountryId) {
        this.selectedCountryId = selectedCountryId;
    }

    /**
     * @return the selectedProvinceId
     */
    public Long getSelectedProvinceId() {
        return selectedProvinceId;
    }

    /**
     * @param selectedProvinceId the selectedProvinceId to set
     */
    public void setSelectedProvinceId(Long selectedProvinceId) {
        this.selectedProvinceId = selectedProvinceId;
    }

    /**
     * @return the firstTime
     */
    public boolean isFirstTime() {
        return firstTime;
    }

    /**
     * @param firstTime the firstTime to set
     */
    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }

    /**
     * @return the pagination
     */
    public PaginationControllerRemix getPagination() {
        return pagination;
    }

    /**
     * @param pagination the pagination to set
     */
    public void setPagination(PaginationControllerRemix pagination) {
        this.pagination = pagination;
    }

    public List getResults(int firstResult, int maxResults) {
        if(isQueryMode()){ //En caso de que sea busqueda avanzada
            getPagination().setTotalResults(getSearchFacade().countSitesByCriteria(getQuerySiteDTO()).intValue());
            return searchFacade.searchSiteByCriteria(getQuerySiteDTO(), firstResult, maxResults);
        }
        else if(isQueryModeSimple()){ //En caso de que sea busqueda simple
            getPagination().setTotalResults(getSearchFacade().countSitesByCriteria(getConsultaSimple()).intValue());
            return searchFacade.searchSiteByCriteria(getConsultaSimple(), firstResult, maxResults);
        }
        else { //Valores defaul
            getPagination().setTotalResults(getGisFacade().countSites().intValue());
            return gisFacade.getAllSitePaginated(firstResult, maxResults);
        }
    }

}
