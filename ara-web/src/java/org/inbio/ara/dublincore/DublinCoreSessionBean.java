/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dublincore;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.util.PaginationControllerRemix;
import org.inbio.ara.util.PaginationCoreInterface;
import org.inbio.commons.dublincore.dto.DublinCoreDTO;
import org.inbio.commons.dublincore.dto.ElementTypeDTO;
import org.inbio.commons.dublincore.dto.ara.InterfaceDublinCoreDTO;
import org.inbio.commons.dublincore.dto.ara.ReferenceDTO;
import org.inbio.commons.dublincore.facade.ara.DublinCoreFacadeRemote;
import org.inbio.commons.dublincore.model.ResourceTypeEnum;

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
 * @version DublinCoreSessionBean.java
 * @version Created on 03/09/2010, 11:34:00 AM
 * @author dasolano
 */

public class DublinCoreSessionBean extends AbstractSessionBean implements PaginationCoreInterface{
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>



    private InterfaceDublinCoreDTO dublinCoreDTO = new InterfaceDublinCoreDTO();

    @EJB
    private DublinCoreFacadeRemote dublinCoreFacadeRemote;


    //Objeto que controla la paginacion de la informacion de passport
    private PaginationControllerRemix pagination = null;

    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;
    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    //Bandera para indicarle al paginador que trabaje en modo busqueda avanzada
    private boolean queryMode = false;

    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    //String que indica la consulta del usuario en la busqueda simple
    private String consultaSimple = new String("");

    //private DublincoreDTO querySementalDTO = new SementalDTO();

    //String que indica la consulta del usuario en la busqueda simple
    private String simpleConsult = new String("");

    private boolean firstTime = true;

    private Long deleteDublinCore = null;

    //Objeto usado para la consulta del usuario en la búsqueda avanzada
    private DublinCoreDTO queryDublinCoreDTO = new DublinCoreDTO();

    //contiene las referencias seleccionadas por el usuario
    private Map<String, ReferenceDTO> selectedResourcesId = new HashMap<String, ReferenceDTO>();

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public DublinCoreSessionBean() {
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

    public void resetValues()
    {
        dublinCoreDTO = new InterfaceDublinCoreDTO();
        queryDublinCoreDTO = new DublinCoreDTO();
        consultaSimple = new String("");
        queryModeSimple = false;
        queryMode = false;
        advancedSearch = false;
        firstTime = true;
    }

    /**
     * Inicializar el data provider
     */
    public void initDataProvider() {

        setPagination(new PaginationControllerRemix(dublinCoreFacadeRemote.countResourceByTypeId(-1).intValue(), getQuantity(), this));
    }
    
    /**
     * Para evitar que retorne null al data provider del paginador
     * @param l lista retornada para el paginador
     * @return
     */
    public List myReturn(List l) {
        if (l == null) {
            return new ArrayList<InterfaceDublinCoreDTO>();
        } else {
            return l;
        }
    }

    /*
     * Retorna la lista de elementos que se van a mostrar en la tabla paginada
     */
    public List getResults(int firstResult, int maxResults) {


        List<ReferenceDTO> auxResult = new ArrayList<ReferenceDTO>();

        //Contiene el resultado de las busquedas
        List<DublinCoreDTO> aListDTO;

        //contiene la lista resultado que será devuelta
        List<ReferenceDTO> results = new ArrayList<ReferenceDTO>();

        if (isQueryMode()) { //En caso de que sea busqueda avanzada
            try {
                //Se realiza la consulta utilizando los datos del query en un DublinCoreDTO
                aListDTO =  myReturn(
                        this.getDublinCoreFacadeRemote().getDublinCoreAdvancedSearch
                        (getQueryDublinCoreDTO(), firstResult, maxResults));
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                 * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacadeRemote.dublinCoreDTOsToFullReferenceDTOs(aListDTO);
                //Seleccionar los elemento que han sido seleccionados antes en la interfaz
                this.setSelectedResources(results, selectedResourcesId);
                return results;

            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        } else if (isQueryModeSimple()) { //En caso de que sea busqueda simple
            try { 
                //Se realiza la consulta utilizando el String que el usuario ingresó
                aListDTO =  myReturn(this.getDublinCoreFacadeRemote().getReferenceSimpleSearch(this.getSimpleConsult(), firstResult, maxResults));
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                 * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacadeRemote.dublinCoreDTOsToFullReferenceDTOs(aListDTO);
                //Seleccionar los elemento que han sido seleccionados antes en la interfaz
                this.setSelectedResources(results, selectedResourcesId);
                return results;

            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        }
        else//Valores default
        {
            try {
                // Se traen todas las referencias Dublin Core
                aListDTO =  myReturn(this.getDublinCoreFacadeRemote().findAllDublinCorePaginated(-1, firstResult, maxResults));
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacadeRemote.dublinCoreDTOsToFullReferenceDTOs(aListDTO);
                // Seleccionar en la interfaz todas las relaciones dublin core del indicador
                this.setSelectedResources(results, selectedResourcesId);
                return results;
            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        }
    }

    /*
     * Selecciona en la interfaz los elementos seleccinados por el usuario.
     * Es utilizado cuando se hace un prerender donde se pierden los elementos que habian seleccionados desde
     * la interfaz
     */
    public void setSelectedResources (List<ReferenceDTO> resources, Map<String, ReferenceDTO> selectedResourcesId)
    {
        for (ReferenceDTO aux: resources) {

            if(selectedResourcesId.containsKey(aux.getKey()))
            {
                aux.setSelected(true);
            }

        }
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
            log("DublinCoreSessionBean Initialization Failure", e);
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
     * @return the dublinCoreDTO
     */
    public InterfaceDublinCoreDTO getDublinCoreDTO() {
        return dublinCoreDTO;
    }

    /**
     * @param dublinCoreDTO the dublinCoreDTO to set
     */
    public void setDublinCoreDTO(InterfaceDublinCoreDTO dublinCoreDTO) {
        this.dublinCoreDTO = dublinCoreDTO;
    }

    /**
     * @return the dublinCoreFacadeRemote
     */
    public DublinCoreFacadeRemote getDublinCoreFacadeRemote() {
        return dublinCoreFacadeRemote;
    }

    /**
     * @param dublinCoreFacadeRemote the dublinCoreFacadeRemote to set
     */
    public void setDublinCoreFacadeRemote(DublinCoreFacadeRemote dublinCoreFacadeRemote) {
        this.dublinCoreFacadeRemote = dublinCoreFacadeRemote;
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
     * @return the deleteDublinCore
     */
    public Long getDeleteDublinCore() {
        return deleteDublinCore;
    }

    /**
     * @param deleteDublinCore the deleteDublinCore to set
     */
    public void setDeleteDublinCore(Long deleteDublinCore) {
        this.deleteDublinCore = deleteDublinCore;
    }

    /**
     * @return the queryDublinCoreDTO
     */
    public DublinCoreDTO getQueryDublinCoreDTO() {
        return queryDublinCoreDTO;
    }

    /**
     * @param queryDublinCoreDTO the queryDublinCoreDTO to set
     */
    public void setQueryDublinCoreDTO(DublinCoreDTO queryDublinCoreDTO) {
        this.queryDublinCoreDTO = queryDublinCoreDTO;
    }

    /**
     * @return the selectedResourcesId
     */
    public Map<String, ReferenceDTO> getSelectedResourcesId() {
        return selectedResourcesId;
    }

    /**
     * @param selectedResourcesId the selectedResourcesId to set
     */
    public void setSelectedResourcesId(Map<String, ReferenceDTO> selectedResourcesId) {
        this.selectedResourcesId = selectedResourcesId;
    }

    /**
     * @return the simpleConsult
     */
    public String getSimpleConsult() {
        return simpleConsult;
    }

    /**
     * @param simpleConsult the simpleConsult to set
     */
    public void setSimpleConsult(String simpleConsult) {
        this.simpleConsult = simpleConsult;
    }
    
}
