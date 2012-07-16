/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.germplasm.PassportDTO;
import org.inbio.ara.dto.germplasm.PassportNomenclaturalGroupDTO;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.inventory.GatheringObservationDTO;
import org.inbio.ara.facade.germplasm.GermplasmFacadeRemote;
import org.inbio.ara.facade.gis.GisFacadeRemote;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.search.SearchFacadeRemote;
import org.inbio.ara.facade.taxonomy.TaxonomyFacadeRemote;
import org.inbio.ara.util.AddRemoveList;
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
 * @version PassportSessionBean.java
 * @version Created on 18/01/2010, 03:40:27 PM
 * @author dasolano
 */

public class PassportSessionBean extends AbstractSessionBean implements PaginationCoreInterface{
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    @EJB
    private GermplasmFacadeRemote germplasmFacadeRemote;

    @EJB
    private TaxonomyFacadeRemote taxonomyFacadeRemote;

    @EJB
    private InventoryFacadeRemote inventoryFacadeRemote;

    @EJB
    private SearchFacadeRemote searchFacade;

    @EJB
    private GisFacadeRemote gisFacadeRemote;



    private Date selectedHarvestingSeasonDate = null;
    private Date selectedPlantNurseryDate = null;
    private Date selectedPlantingSeasonDate = null;

    private PassportDTO passportDTO = new PassportDTO();


    private Long selectedTaxonomicLevel = null; //taxonomical range

    /*componentes para el manejo de las listas de recolecciones**/
    private Long selectedCountry = null;
    private Long selectedProvince = null;

    //Objeto que controla la paginacion de la informacion de gatherings
    private PaginationControllerRemix pagination = null;



    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;

    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    //Bandera para indicarle al paginador que trabaje en modo busqueda avanzada
    private boolean queryMode = false;
    //Gatthering observation DTO utilizado para realizar las consultas
    private GatheringObservationDTO queryGatheringDTO = new GatheringObservationDTO();
    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    //String que indica la consulta del usuario en la busqueda simple
    private String consultaSimple = new String("");


    /**Add remove**/
    private AddRemoveList arNomenclaturalGroups = new AddRemoveList();

    /*Indica si es la primera vez que se carga la pagina de Editar*/
    private boolean firstTime = true;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public PassportSessionBean() {
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

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("PassportSessionBean Initialization Failure", e);
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
     * @return un String que contiene el detalle de la paginacion
     */
    public String getQuantityTotal() {
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  " + (actualPage + 1) + " - " + (actualPage + resultsPerPage) + "  | " + totalResults + "  ";
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


    public void resetValues()
    {
        this.passportDTO = new PassportDTO();
        this.selectedTaxonomicLevel = null;
        this.selectedHarvestingSeasonDate = null;
        this.selectedPlantNurseryDate = null;
        this.selectedPlantingSeasonDate = null;
        this.selectedTaxonomicLevel = null;
        this.arNomenclaturalGroups = new AddRemoveList();
        this.firstTime = true;
        if(this.pagination != null)
            this.pagination.refreshList();


    }



    /**
     * @return the germplasmFacadeRemote
     */
    public GermplasmFacadeRemote getGermplasmFacadeRemote() {
        return germplasmFacadeRemote;
    }

    /**
     * @param germplasmFacadeRemote the germplasmFacadeRemote to set
     */
    public void setGermplasmFacadeRemote(GermplasmFacadeRemote germplasmFacadeRemote) {
        this.germplasmFacadeRemote = germplasmFacadeRemote;
    }



    /**
     * @return the taxonomyFacadeRemote
     */
    public TaxonomyFacadeRemote getTaxonomyFacadeRemote() {
        return taxonomyFacadeRemote;
    }

    /**
     * @param taxonomyFacadeRemote the taxonomyFacadeRemote to set
     */
    public void setTaxonomyFacadeRemote(TaxonomyFacadeRemote taxonomyFacadeRemote) {
        this.taxonomyFacadeRemote = taxonomyFacadeRemote;
    }


    /**
     * @return the selectedHarvestingSeasonDate
     */
    public Date getSelectedHarvestingSeasonDate() {
        return selectedHarvestingSeasonDate;
    }

    /**
     * @param selectedHarvestingSeasonDate the selectedHarvestingSeasonDate to set
     */
    public void setSelectedHarvestingSeasonDate(Date selectedHarvestingSeasonDate) {
        this.selectedHarvestingSeasonDate = selectedHarvestingSeasonDate;
    }

    /**
     * @return the selectedPlantNurseryDate
     */
    public Date getSelectedPlantNurseryDate() {
        return selectedPlantNurseryDate;
    }

    /**
     * @param selectedPlantNurseryDate the selectedPlantNurseryDate to set
     */
    public void setSelectedPlantNurseryDate(Date selectedPlantNurseryDate) {
        this.selectedPlantNurseryDate = selectedPlantNurseryDate;
    }

    /**
     * @return the selectedPlantingSeasonDate
     */
    public Date getSelectedPlantingSeasonDate() {
        return selectedPlantingSeasonDate;
    }

    /**
     * @param selectedPlantingSeasonDate the selectedPlantingSeasonDate to set
     */
    public void setSelectedPlantingSeasonDate(Date selectedPlantingSeasonDate) {
        this.selectedPlantingSeasonDate = selectedPlantingSeasonDate;
    }



    /**
     * @return the passportDTO
     */
    public PassportDTO getPassportDTO() {
        return passportDTO;
    }

    /**
     * @param passportDTO the passportDTO to set
     */
    public void setPassportDTO(PassportDTO passportDTO) {
        this.passportDTO = passportDTO;
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
     * @return the advancedSearch
     */
    public boolean isAdvancedSearch() {
        return advancedSearch;
    }

    /**
     * @param advancedSearch the advancedSearch to set
     */
    public void setAdvancedSearch(boolean advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    /**
     * Inicializar el data provider de especimenes
     */
    public void initDataProvider() {        
        this.setPagination(new PaginationControllerRemix(this.getInventoryFacadeRemote().countGatheringObservations().intValue(), quantity, this));
        this.getPagination().firstResults();
    }

    /**
     * @return the inventoryFacadeRemote
     */
    public InventoryFacadeRemote getInventoryFacadeRemote() {
        return inventoryFacadeRemote;
    }

    /**
     * @param inventoryFacadeRemote the inventoryFacadeRemote to set
     */
    public void setInventoryFacadeRemote(InventoryFacadeRemote inventoryFacadeRemote) {
        this.inventoryFacadeRemote = inventoryFacadeRemote;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    /**
     * Para evitar que retorne null al data provider del paginador
     * @param l lista retornada para el paginador
     * @return
     */
    public List myReturn(List l) {
        if (l == null) {
            return new ArrayList<GatheringObservationDTO>();
        } else {
            return l;
        }
    }

     /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    public List getResults(int firstResult, int maxResults) {


        Long collectionId = getAraSessionBean().getGlobalCollectionId();

            List<GatheringObservationDTO> auxResult =
                    new ArrayList<GatheringObservationDTO>();

            List<GatheringObservationDTO> gListDTO;
            if (isQueryMode()) { //En caso de que sea busqueda avanzada
                //Set the collectionId into the DTO
                //It is a mandatory filter
                GatheringObservationDTO gdto = getQueryGatheringDTO();
                gdto.setCollectionId(collectionId);
                try {
                    getPagination().setTotalResults(getSearchFacade().countGathObsByCriteria(gdto).intValue());
                    gListDTO =  myReturn(getSearchFacade().searchGathObsByCriteria(gdto,
                            firstResult, maxResults));
                    return gListDTO;
                } catch (Exception e) {
                    return auxResult;
                }
            } else if (isQueryModeSimple()) { //En caso de que sea busqueda simple
                try {
                    getPagination().setTotalResults(getSearchFacade().countGathObsByCriteria(getConsultaSimple(),collectionId).intValue());
                    gListDTO =  myReturn(getSearchFacade().
                            searchGathObsByCriteria(getConsultaSimple(), collectionId, firstResult,
                            maxResults));
                    return gListDTO;
                } catch (Exception e) {
                    return auxResult;
                }
            } else //Valores default
            {
                try {
                    getPagination().setTotalResults(getInventoryFacadeRemote().countGatheringObservations(collectionId).intValue());
                    gListDTO =
                            myReturn(
                            getInventoryFacadeRemote().
                            getAllGatheringObservationPaginated(
                            firstResult, maxResults, collectionId));
                    return gListDTO;
                } catch (Exception e) {
                    return auxResult;
                }
            }
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
     * @return the queryGatheringDTO
     */
    public GatheringObservationDTO getQueryGatheringDTO() {
        return queryGatheringDTO;
    }

    /**
     * @param queryGatheringDTO the queryGatheringDTO to set
     */
    public void setQueryGatheringDTO(GatheringObservationDTO queryGatheringDTO) {
        this.queryGatheringDTO = queryGatheringDTO;
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
     * Obtener los datos para el drop down de paises
     */
    public List<GeographicLayerDTO> SetCountryDropDownData() {
        return this.getGisFacadeRemote().getAllCountries();
    }

    /**
     * Metodo ejecutado por el drop down de paises para calcular las provincias correspondientes
     */
    public List<GeographicLayerDTO> SetProvincesDropDownData() {
        if (this.getSelectedCountry() == null) {
            return null;
        } else {
            Long countryid = new Long(this.getSelectedCountry());
            return this.gisFacadeRemote.getProvincesByCountry(countryid);
        }
    }

    /**
     * @return the gisFacadeRemote
     */
    public GisFacadeRemote getGisFacadeRemote() {
        return gisFacadeRemote;
    }

    /**
     * @param gisFacadeRemote the gisFacadeRemote to set
     */
    public void setGisFacadeRemote(GisFacadeRemote gisFacadeRemote) {
        this.gisFacadeRemote = gisFacadeRemote;
    }

    /**
     * @return the selectedTaxonomicLevel
     */
    public Long getSelectedTaxonomicLevel() {
        return selectedTaxonomicLevel;
    }

    /**
     * @param selectedTaxonomicLevel the selectedTaxonomicLevel to set
     */
    public void setSelectedTaxonomicLevel(Long selectedTaxonomicLevel) {
        this.selectedTaxonomicLevel = selectedTaxonomicLevel;
    }

    /**
     * @return the arNomenclaturalGroups
     */
    public AddRemoveList getArNomenclaturalGroups() {
        return arNomenclaturalGroups;
    }

    /**
     * @param arNomenclaturalGroups the arNomenclaturalGroups to set
     */
    public void setArNomenclaturalGroups(AddRemoveList arNomenclaturalGroups) {
        this.arNomenclaturalGroups = arNomenclaturalGroups;
    }

    public void updateAddRemoveSelectedItems(List<PassportNomenclaturalGroupDTO> pngDTOList)
    {
        if(pngDTOList != null && !pngDTOList.isEmpty())
        {
            //create a Long array
            Long[] newList = new Long[pngDTOList.size()];
            //fill the array with the nomenclatural groups ids
            for (int i = 0; i < pngDTOList.size(); i++)
                newList[i] = pngDTOList.get(i).getNomenclaturalGroupId();
            
            arNomenclaturalGroups.setLeftSelected(newList);
            arNomenclaturalGroups.addSelectedOptions();
        }
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
}