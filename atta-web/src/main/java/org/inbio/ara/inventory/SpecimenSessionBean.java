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

package org.inbio.ara.inventory;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import org.inbio.ara.facade.gis.GisFacadeRemote;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.search.SearchFacadeRemote;
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
 * @version SpecimenSessionBean.java
 * @version Created on 02/07/2009, 05:11:28 PM
 * @author esmata
 */

public class SpecimenSessionBean extends AbstractSessionBean implements PaginationCoreInterface{
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
    private InventoryFacadeRemote inventoryFacade;
    @EJB
    private AdminFacadeRemote adminFacade;
    @EJB
    private GisFacadeRemote gisFacade;
    @EJB
    private SearchFacadeRemote searchFacade;


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
    //Bandera que indica si el especimen es valido para ser persistido
    private boolean specimenValid = true;

    //Value binding para los drop downs
    private Long selectedInstitution = null;
    private Long selectedCountry = null;
    private Long selectedProvince = null;
    private Long selectedDiscarded;

    //Specimen DTO seleccionado por el usuario para editar
    private SpecimenDTO currentSpecimenDTO = new SpecimenDTO();
    //SpecimenDTO que sera convertido en entidad y sera persistido
    private SpecimenDTO querySpecimenDTO = new SpecimenDTO();
    //String que indica la consulta del usuario en la busqueda simple
    private String consultaSimple = new String("");

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SpecimenSessionBean() {
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
            log("SpecimenSessionBean Initialization Failure", e);
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

    /**
     * Inicializar el data provider de especimenes
     */
    public void initDataProvider() {
        this.setPagination(new PaginationControllerRemix(getInventoryFacade().countSpecimens(this.getAraSessionBean().getGlobalCollectionId()).intValue(), getQuantity(), this));
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
     * @return the inventoryFacade
     */
    public InventoryFacadeRemote getInventoryFacade() {
        return inventoryFacade;
    }

    /**
     * @param inventoryFacade the inventoryFacade to set
     */
    public void setInventoryFacade(InventoryFacadeRemote inventoryFacade) {
        this.inventoryFacade = inventoryFacade;
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
     * Obtener los datos del drop down de instituciones
     */
    public List<InstitutionDTO> SetInstitutionDropDownData(){
         return this.adminFacade.getAllInstitutions();
    }

    /**
     * Obtener los datos para el drop down de colecciones
     */
    public List<CollectionDTO> SetCollectionDropDownData(){
         return this.adminFacade.getAllCollections();
    }

     /**
     * Metodo ejecutado por el drop down de paises para calcular las provincias correspondientes
     */
    public List<GeographicLayerDTO> SetProvincesDropDownData(){
        if(this.getSelectedCountry()==null){
            return null;
        }
        else{
            Long countryid = new Long(this.getSelectedCountry());
            return this.getGisFacade().getProvincesByCountry(countryid);
        }
    }

    /**
     * Obtener los datos para el drop down de paises
     */
    public List<GeographicLayerDTO> SetCountryDropDownData(){
        return this.getGisFacade().getAllCountries();
    }

     /**
     * Obtener los datos para los drop downs de listas de seleccion
     */
    public List<SelectionListDTO> setSelectionListDropDownData(Long selectionListEntityId,Long collection){
        return this.inventoryFacade.getAllSelectionListElementsByCollection(selectionListEntityId,collection);
    }

    /**
     * @param advancedSearch the advancedSearch to set
     */
    public void setAdvancedSearch(boolean advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    /**
     * @return the adminFacade
     */
    public AdminFacadeRemote getAdminFacade() {
        return adminFacade;
    }

    /**
     * @param adminFacade the adminFacade to set
     */
    public void setAdminFacade(AdminFacadeRemote adminFacade) {
        this.adminFacade = adminFacade;
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
     * @return the selectedInstitution
     */
    public Long getSelectedInstitution() {
        return selectedInstitution;
    }

    /**
     * @param selectedInstitution the selectedInstitution to set
     */
    public void setSelectedInstitution(Long selectedInstitution) {
        this.selectedInstitution = selectedInstitution;
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
     * @return the currentSpecimenDTO
     */
    public SpecimenDTO getCurrentSpecimenDTO() {
        return currentSpecimenDTO;
    }

    /**
     * @param currentSpecimenDTO the currentSpecimenDTO to set
     */
    public void setCurrentSpecimenDTO(SpecimenDTO currentSpecimenDTO) {
        this.currentSpecimenDTO = currentSpecimenDTO;
    }

    /**
     * @return the querySpecimenDTO
     */
    public SpecimenDTO getQuerySpecimenDTO() {
        return querySpecimenDTO;
    }

    /**
     * @param querySpecimenDTO the querySpecimenDTO to set
     */
    public void setQuerySpecimenDTO(SpecimenDTO querySpecimenDTO) {
        this.querySpecimenDTO = querySpecimenDTO;
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
     * @return the specimenValid
     */
    public boolean isSpecimenValid() {
        return specimenValid;
    }

    /**
     * @param specimenValid the specimenValid to set
     */
    public void setSpecimenValid(boolean specimenValid) {
        this.specimenValid = specimenValid;
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
     * Para evitar que retorne null al data provider del paginador
     * @param l lista retornada para el paginador
     * @return
     */
    public List myReturn(List l){
        if(l==null)
            return new ArrayList<SpecimenDTO>();
        else
            return l;
    }


    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
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
       
        Long collectionId = getAraSessionBean().getGlobalCollectionId();
            List<SpecimenDTO> auxResult =
                    new ArrayList<SpecimenDTO>();

            if(isQueryMode()){ //En caso de que sea busqueda avanzada
                //Set the collectionId into the DTO
                //It is a mandatory filter
                SpecimenDTO s = getQuerySpecimenDTO();
                s.setCollectionId(collectionId);
                try{
                    getPagination().setTotalResults(getSearchFacade().countSpecimensByCriteria(s).intValue());
                    return myReturn(searchFacade.searchSpecimenByCriteria
                            (s, firstResult, maxResults));
                }
                catch(Exception e){return auxResult;}
            }
            else if(isQueryModeSimple()){ //En caso de que sea busqueda simple
                try{
                    getPagination().setTotalResults(getSearchFacade().countSpecimensByCriteria(getConsultaSimple(), collectionId).intValue());
                    return myReturn(searchFacade.searchSpecimenByCriteria
                            (getConsultaSimple(), collectionId, firstResult,
                            maxResults));
                }
                catch(Exception e){return auxResult;}
            }
            else { //Valores default
                try{
                    
                    getPagination().setTotalResults(getInventoryFacade().countSpecimens(this.getAraSessionBean().getGlobalCollectionId()).intValue());
                    
                    return myReturn(inventoryFacade.getAllSpecimenPaginated
                            (firstResult, maxResults, collectionId));
                    
                }
                catch(Exception e){return auxResult;}
            }
    }
   
   
      /**
     * La idea de este metodo es poder preguntar si determinado protocolo esta activado o no
     * para una determinada colleccion
     * @param collectionId
     * @param protocolAtributeId
     * @param value corresponde a alguno de los valores posibles para saber si el protocolo esta
     * "activado" o "desactivado"
     * @return
     */
    public boolean matchCollectionProtocol(Long collectionId, Long protocolAtributeId, String value) {
        return this.inventoryFacade.matchCollectionProtocol(collectionId, protocolAtributeId, value);
    }
    
    
}
