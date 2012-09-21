/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.dto.inventory.GatheringObservationDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.ProjectDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import org.inbio.ara.facade.gis.GisFacadeRemote;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.search.SearchFacadeRemote;
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
 * @version GatheringSessionBean.java
 * @version Created on 17/08/2009, 05:14:08 PM
 * @author esmata
 */
public class GatheringSessionBean extends AbstractSessionBean implements Serializable, PaginationCoreInterface {
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
    private GisFacadeRemote gisFacade;
    @EJB
    private SearchFacadeRemote searchFacade;
    @EJB
    private AdminFacadeRemote adminFacade;

    //Objeto que controla la paginacion de la informacion de passport
    private PaginationControllerRemix pagination = null;
    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    //Value binding para los drop downs
    private Long selectedCountry = null;
    private Long selectedProvince = null;
    private Long selectedExposition = null;
    private Long selectedLocality = null;
    private Long selectedResponsible = null;
    //Bandera para saber si se utiliza o no detalles de recoleccion
    private boolean useDetail = false;
    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;
    //Bandera para indicarle al paginador que trabaje en modo busqueda avanzada
    private boolean queryMode = false;
    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    //Gatthering observation DTO utilizado para realizar las consultas
    private GatheringObservationDTO queryGatheringDTO = new GatheringObservationDTO();
    //String que indica la consulta del usuario en la busqueda simple
    private String consultaSimple = new String("");
    //Objeto AddRemoveList para manejar los valores del tab de colectores (ventana new gathering)
    private AddRemoveList arCollectors = new AddRemoveList();
    //Objeto AddRemoveList para manejar los valores del tab de proyectos (ventana new gathering)
    private AddRemoveList arProjects = new AddRemoveList();
    //Objeto AddRemoveList para manejar los valores del tab de colecciones (ventana new gathering)
    private AddRemoveList arCollections = new AddRemoveList();
    //Objeto AddRemoveList para manejar los valores del tab de colectores (ventana edit gathering)
    private AddRemoveList arCollectorsEdit = new AddRemoveList();
    //Objeto AddRemoveList para manejar los valores del tab de proyectos (ventana edit gathering)
    private AddRemoveList arProjectsEdit = new AddRemoveList();
    //Objeto AddRemoveList para manejar los valores del tab de colecciones (ventana edit gathering)
    private AddRemoveList arCollectionsEdit = new AddRemoveList();
    //Current GatheringObservationDTO utilizado en la ventana de edicion
    private GatheringObservationDTO currentGatheringDTO = new GatheringObservationDTO();

    /* Variables para almacenar los datos de los drop downs y de los add remove, esto
     * con el fin de no recalcularlos cada vez que se cambia de tab */
    private List<SelectionListDTO> expositionData = null;
    private List<PersonDTO> responsibleData = null;
    private List<SiteDTO> localityData = null;
    private List<CollectionDTO> collectionData = null;
    private List<PersonDTO> colectorData = null;
    private List<ProjectDTO> projectData = null;

    /**
     * Bandera muy importante para el correcto funcionamiento de los
     * AddRemove components de la pantalla de editar
     * Le indica al prerender de la pantalla de edit que cargue los
     * datos seleccionados de los AddRemove solamnete UNA vez
     * true = cargar datos
     * false = ignorar la carga de datos seleccionados
     */
    private boolean firstTime = true;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public GatheringSessionBean() {
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
            log("GatheringSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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
     * Obtener los datos para los drop downs de listas de seleccion
     */
    public List<SelectionListDTO> setSelectionListDropDownData(Long selectionListEntityId, Long collection) {
        return this.inventoryFacade.getAllSelectionListElementsByCollection(selectionListEntityId, collection);
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

    /**
     * Obtener los datos para el drop down de exposition
     */
    public List<SelectionListDTO> setExpositionDropDownData(Long selectionListEntityId, Long collection) {
        /*if (this.getExpositionData() == null) {
            this.setExpositionData(setSelectionListDropDownData(selectionListEntityId, collection));
            return this.getExpositionData();
        } else {
            return this.getExpositionData();
        }*/
        return setSelectionListDropDownData(selectionListEntityId, collection);
    }

    /**
     * Obtener los datos para el drop down de colecciones
     */
    public List<CollectionDTO> SetCollectionDropDownData() {
        /*if (this.getCollectionData() == null) {
            this.setCollectionData(adminFacade.getAllCollections());
            return this.getCollectionData();
        } else {
            return this.getCollectionData();
        }*/
        return adminFacade.getAllCollections();
    }

    /**
     * Obtener los datos para el drop down de responsables
     */
    public List<PersonDTO> SetResponsibleDropDownData() {
        /*if (this.getResponsibleData() == null) {
            this.setResponsibleData(inventoryFacade.getAllResponsibles());
            return this.getResponsibleData();
        } else {
            return this.getResponsibleData();
        }*/
        return inventoryFacade.getAllResponsibles();
    }

    /**
     * Obtener los datos para el drop down de colectores
     */
    public List<PersonDTO> SetColectorsDropDownData() {
        /*if (this.getColectorData() == null) {
            this.setColectorData(inventoryFacade.getAllColectors());
            return this.getColectorData();
        } else {
            return this.getColectorData();
        }*/
        return inventoryFacade.getAllColectors();
    }

    /**
     * Obtener los datos para el drop down de proyectos
     */
    public List<ProjectDTO> SetProjectsDropDownData() {
        /*if (this.getProjectData() == null) {
            this.setProjectData(inventoryFacade.getAllProjects());
            return this.getProjectData();
        } else {
            return this.getProjectData();
        }*/
        return inventoryFacade.getAllProjects();
    }

    /**
     * Obtener los datos para el drop down de sitios
     */
    public List<SiteDTO> SetSitesDropDownData() {
        /*if (this.getLocalityData() == null) {
            this.setLocalityData(gisFacade.getAllSites());
            return this.getLocalityData();
        } else {
            return this.getLocalityData();
        }*/
        return gisFacade.getAllSites();
    }

    /**
     * Inicializar el data provider de especimenes
     */
    public void initDataProvider() {
        Long collectionId = getAraSessionBean().getGlobalCollectionId();
        this.setPagination(new PaginationControllerRemix(getInventoryFacade().countGatheringObservations(collectionId).intValue(),
                getQuantity(), this));
        this.getPagination().firstResults();
    }

    /**
     * Obtener los datos para el drop down de paises
     */
    public List<GeographicLayerDTO> SetCountryDropDownData() {
        return this.getGisFacade().getAllCountries();
    }

    /**
     * Metodo ejecutado por el drop down de paises para calcular las provincias correspondientes
     */
    public List<GeographicLayerDTO> SetProvincesDropDownData() {
        if (this.getSelectedCountry() == null) {
            return null;
        } else {
            Long countryid = new Long(this.getSelectedCountry());
            return this.gisFacade.getProvincesByCountry(countryid);
        }
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
     * @return the arCollectors
     */
    public AddRemoveList getArCollectors() {
        return arCollectors;
    }

    /**
     * @param arCollectors the arCollectors to set
     */
    public void setArCollectors(AddRemoveList arCollectors) {
        this.arCollectors = arCollectors;
    }

    /**
     * @return the arProjects
     */
    public AddRemoveList getArProjects() {
        return arProjects;
    }

    /**
     * @param arProjects the arProjects to set
     */
    public void setArProjects(AddRemoveList arProjects) {
        this.arProjects = arProjects;
    }

    /**
     * @return the arCollections
     */
    public AddRemoveList getArCollections() {
        return arCollections;
    }

    /**
     * @param arCollections the arCollections to set
     */
    public void setArCollections(AddRemoveList arCollections) {
        this.arCollections = arCollections;
    }

    /**
     * @return the arCollectorsEdit
     */
    public AddRemoveList getArCollectorsEdit() {
        return arCollectorsEdit;
    }

    /**
     * @param arCollectorsEdit the arCollectorsEdit to set
     */
    public void setArCollectorsEdit(AddRemoveList arCollectorsEdit) {
        this.arCollectorsEdit = arCollectorsEdit;
    }

    /**
     * @return the arProjectsEdit
     */
    public AddRemoveList getArProjectsEdit() {
        return arProjectsEdit;
    }

    /**
     * @param arProjectsEdit the arProjectsEdit to set
     */
    public void setArProjectsEdit(AddRemoveList arProjectsEdit) {
        this.arProjectsEdit = arProjectsEdit;
    }

    /**
     * @return the arCollectionsEdit
     */
    public AddRemoveList getArCollectionsEdit() {
        return arCollectionsEdit;
    }

    /**
     * @param arCollectionsEdit the arCollectionsEdit to set
     */
    public void setArCollectionsEdit(AddRemoveList arCollectionsEdit) {
        this.arCollectionsEdit = arCollectionsEdit;
    }

    /**
     * @return the selectedExposition
     */
    public Long getSelectedExposition() {
        return selectedExposition;
    }

    /**
     * @param selectedExposition the selectedExposition to set
     */
    public void setSelectedExposition(Long selectedExposition) {
        this.selectedExposition = selectedExposition;
    }

    /**
     * @return the selectedResponsible
     */
    public Long getSelectedResponsible() {
        return selectedResponsible;
    }

    /**
     * @param selectedResponsible the selectedResponsible to set
     */
    public void setSelectedResponsible(Long selectedResponsible) {
        this.selectedResponsible = selectedResponsible;
    }

    /**
     * @return the selectedLocality
     */
    public Long getSelectedLocality() {
        return selectedLocality;
    }

    /**
     * @param selectedLocality the selectedLocality to set
     */
    public void setSelectedLocality(Long selectedLocality) {
        this.selectedLocality = selectedLocality;
    }

    /**
     * @return the currentGatheringDTO
     */
    public //Current GatheringObservationDTO utilizado en la ventana de edicion
            GatheringObservationDTO getCurrentGatheringDTO() {
        return currentGatheringDTO;
    }

    /**
     * @param currentGatheringDTO the currentGatheringDTO to set
     */
    public void setCurrentGatheringDTO(GatheringObservationDTO currentGatheringDTO) {
        this.currentGatheringDTO = currentGatheringDTO;
    }

    /**
     * @return the expositionData
     */
    public /* Variables para almacenar los datos de los drop downs y de los add remove, esto
             * con el fin de no recalcularlos cada vez que se cambia de tab */ List<SelectionListDTO> getExpositionData() {
        return expositionData;
    }

    /**
     * @param expositionData the expositionData to set
     */
    public void setExpositionData(List<SelectionListDTO> expositionData) {
        this.expositionData = expositionData;
    }

    /**
     * @return the responsibleData
     */
    public List<PersonDTO> getResponsibleData() {
        return responsibleData;
    }

    /**
     * @param responsibleData the responsibleData to set
     */
    public void setResponsibleData(List<PersonDTO> responsibleData) {
        this.responsibleData = responsibleData;
    }

    /**
     * @return the localityData
     */
    public List<SiteDTO> getLocalityData() {
        return localityData;
    }

    /**
     * @param localityData the localityData to set
     */
    public void setLocalityData(List<SiteDTO> localityData) {
        this.localityData = localityData;
    }

    /**
     * @return the collectionData
     */
    public List<CollectionDTO> getCollectionData() {
        return collectionData;
    }

    /**
     * @param collectionData the collectionData to set
     */
    public void setCollectionData(List<CollectionDTO> collectionData) {
        this.collectionData = collectionData;
    }

    /**
     * @return the colectorData
     */
    public List<PersonDTO> getColectorData() {
        return colectorData;
    }

    /**
     * @param colectorData the colectorData to set
     */
    public void setColectorData(List<PersonDTO> colectorData) {
        this.colectorData = colectorData;
    }

    /**
     * @return the projectData
     */
    public List<ProjectDTO> getProjectData() {
        return projectData;
    }

    /**
     * @param projectData the projectData to set
     */
    public void setProjectData(List<ProjectDTO> projectData) {
        this.projectData = projectData;
    }

    /**
     * @return the useDetail
     */
    public boolean isUseDetail() {
        return useDetail;
    }

    /**
     * @param useDetail the useDetail to set
     */
    public void setUseDetail(boolean useDetail) {
        this.useDetail = useDetail;
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

            List<GatheringObservationDTO> auxResult =
                    new ArrayList<GatheringObservationDTO>();

            if (isQueryMode()) { //En caso de que sea busqueda avanzada
                //Set the collectionId into the DTO
                //It is a mandatory filter
                GatheringObservationDTO gdto = getQueryGatheringDTO();
                gdto.setCollectionId(collectionId); //Used to filter by collection
                try {
                    getPagination().setTotalResults(getSearchFacade().countGathObsByCriteria(gdto).intValue());
                    return myReturn(searchFacade.searchGathObsByCriteria(gdto,
                            firstResult, maxResults));
                } catch (Exception e) {
                    return auxResult;
                }
            } else if (isQueryModeSimple()) { //En caso de que sea busqueda simple
                try {
                    getPagination().setTotalResults(getSearchFacade().countGathObsByCriteria(getConsultaSimple(),collectionId).intValue());
                    return myReturn(searchFacade.
                            searchGathObsByCriteria(getConsultaSimple(), collectionId, firstResult,
                            maxResults));
                } catch (Exception e) {
                    return auxResult;
                }
            } else //Valores default
            {
                try {
                    getPagination().setTotalResults(getInventoryFacade().countGatheringObservations(collectionId).intValue());
                    return myReturn(getInventoryFacade().getAllGatheringObservationPaginated(firstResult, maxResults, collectionId));
                } catch (Exception e) {
                    return auxResult;
                }
            }
    }


    public List<PersonDTO> getPersonByFilterProfile(Long profileId, String filter)
    {
        return this.getInventoryFacade().getPersonByFilterProfile(profileId, filter);
    }

    public String getSiteDescriptionById(Long siteId)
    {
        return gisFacade.getSiteDescriptionById(siteId);
    }


    public String getPersonById(Long personId)
    {
        return inventoryFacade.getPersonById(personId);
    }
}
