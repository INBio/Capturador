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

package org.inbio.ara.indicator;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.facade.indicator.IndicatorFacadeRemote;
import org.inbio.ara.util.PaginationControllerRemix;
import org.inbio.ara.util.PaginationCoreInterface;


import org.inbio.commons.dublincore.dto.DublinCoreDTO;
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
 * @version IndicatorSessionBean.java
 * @version Created on 26/03/2010, 10:06:48 AM
 * @author gsulca
 */

public class IndicatorSessionBean extends AbstractSessionBean implements PaginationCoreInterface {

     //Injections
    @EJB
    private IndicatorFacadeRemote indicatorFacade;

    
    @EJB
    private DublinCoreFacadeRemote dublinCoreFacade;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    //Nodo actual sobre el que se efectua la acción
    private String nodeId = "0"; //
    //Ruta para llegar al nodo actual desde la raíz
    private String pathNode = "0"; //

    //Seleccion del estandar a utilizar
    private Long resultRadioGroup = 1L;

    //Contiene el IndicatorDTO sobre que que se efectúa la acción
    private IndicatorDTO currentIndicatorDTO = new IndicatorDTO();


    //Objeto que controla la paginacion de las referencias
    private PaginationControllerRemix pagination = null;

    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;
    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    //Bandera para indicarle al paginador que trabaje en modo busqueda avanzada
    private boolean queryMode = false;
    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    //Bandera para indicar al paginador que trabaje solo con las relaciones existentes en la BD
    private boolean editMode = false;
    //String que indica la consulta del usuario en la busqueda simple
    private String simpleConsult = new String("");
    //Objeto usado para la consulta del usuario en la búsqueda avanzada
    private DublinCoreDTO queryDublinCoreDTO = new DublinCoreDTO();

    //contiene las referencias seleccionadas por el usuario
    private Map<String, ReferenceDTO> selectedResourcesId = new HashMap<String, ReferenceDTO>();

    /*     
     * Map contiene las relaciones existentes en la bd, se carga al cambiar de indicador
     */
    private Map<String, ReferenceDTO> dbRelationsDublinCore = new HashMap<String, ReferenceDTO>();

    private final int DATA_BASE = 0;

        /**
     * <p>Construct a new session data bean instance.</p>
     */
    public IndicatorSessionBean() {
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
            log("IndicatorSessionBean Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /*
     * Calcula el String con la información de paginación
     * registro inicial en la pagina - registro final en la pagina | total de resultado a mostrar
     */
    public String getQuantityTotal() {
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  " + (actualPage + 1) + " - " + (actualPage + resultsPerPage) + "  | " + totalResults + "  ";
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
     * @return the nodeId
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId the nodeId to set
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return the pathNode
     */
    public String getPathNode() {
        return pathNode;
    }

    /**
     * @param pathNode the pathNode to set
     */
    public void setPathNode(String pathNode) {
        this.pathNode = pathNode;
    }

    /**
     * @return the resultRadioGroup
     */
    public Long getResultRadioGroup() {
        return resultRadioGroup;
    }

    /**
     * @param resultRadioGroup the resultRadioGroup to set
     */
    public void setResultRadioGroup(Long resultRadioGroup) {
        this.resultRadioGroup = resultRadioGroup;
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
     * @return the currentIndicatorDTO
     */
    public IndicatorDTO getCurrentIndicatorDTO() {
        return currentIndicatorDTO;
    }

    /**
     * @param currentIndicatorDTO the currentIndicatorDTO to set
     */
    public void setCurrentIndicatorDTO(IndicatorDTO currentIndicatorDTO) {
        this.currentIndicatorDTO = currentIndicatorDTO;
    }


    /*
     * Cuenta la cantidad de Indicadores relacionados con un Indicador Padre
     */
    public Long countChildrenByIndicatorId(Long indicatorId) {
       return this.indicatorFacade.countChildrenByIndicatorId(indicatorId);
    }


    /*
     * Crea un nuevo indicador
     */
    public void saveNewIndicator(){
      
        IndicatorDTO newDTO = this.getIndicatorFacade().saveNewIndicator(this.getCurrentIndicatorDTO());
        this.setCurrentIndicatorDTO(newDTO);
    }


    /*
     * Actualiza la información de un indicador
     */
    public void updateIndicator(){
      
        this.getIndicatorFacade().updateIndicator(this.getCurrentIndicatorDTO());
      
    }

    /*
     * Borra un indicador de acuerdo a su id
     */
    public void deleteIndicator(Long indicatorId)
    {
        this.indicatorFacade.deleteIndicator(indicatorId);
    }


    public void deleteIndicatorDublinCoreByIds(Long indicatorId, List<String> dublinCoreIds)
    {
        this.indicatorFacade.deleteIndicatorDublinCoreByIds(indicatorId, dublinCoreIds);
    }

    /*
     * Crea las n relaciones de acuerdo a las n referencias que escogio el usuario
     * y al id del indicador con el que se está trabajando
     */
    public void saveIndicatorDublinCoreIds (Long indicatorId, List<String> dublinCoreIds, String userName)
    {
        this.getIndicatorFacade().saveIndicatorDublinCores(indicatorId, dublinCoreIds, userName);
    }

    /*
     * Obtener los datos de un indicador de acuerdo al id
     */
    public IndicatorDTO getIndicatorDTOByIndicatorId(Long indicatorId)
    {
       return indicatorFacade.getIndicatorByIndicatorId(indicatorId);
    }


    /*
     * Obtener los datos de una Referencia en formato dublin core de acuerdo al id del recurso
     */
    public DublinCoreDTO getDublinCoreMetadataByResourceId(Long resuorceId)
    {
       return dublinCoreFacade.getMetadataByResourceKey(resuorceId.toString());
    }


   /**
     * Inicializar el data provider
     */
    public void initDataProvider() {
       
        setPagination(new PaginationControllerRemix(getDublinCoreFacade().countResourceByTypeId(ResourceTypeEnum.REFERENCE.getId()).intValue(), getQuantity(), this));
    }


    /**
     * Inicializar el data provider para el edit
     */
    public void initEditDataProvider(Long indicatorId) {

        setPagination(new PaginationControllerRemix(getIndicatorFacade().countDublinCoreByIndicator(indicatorId).intValue(), getQuantity(), this));


    }


    public void initEditReferenceMap()
    {
        dbRelationsDublinCore = new HashMap<String, ReferenceDTO>();
        
    }

    /**
     * @return the indicatorFacade
     */
    public IndicatorFacadeRemote getIndicatorFacade() {
        return indicatorFacade;
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
     * @return the dublinCoreFacade
     */
    public DublinCoreFacadeRemote getDublinCoreFacade() {
        return dublinCoreFacade;
    }

    /**
     * @param dublinCoreFacade the dublinCoreFacade to set
     */
    public void setDublinCoreFacade(DublinCoreFacadeRemote dublinCoreFacade) {
        this.dublinCoreFacade = dublinCoreFacade;
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
                        this.getDublinCoreFacade().getDublinCoreAdvancedSearch
                        (getQueryDublinCoreDTO(), firstResult, maxResults));
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                 * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacade.dublinCoreDTOsToReferenceDTOs(aListDTO);
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
                aListDTO =  myReturn(this.getDublinCoreFacade().getReferenceSimpleSearch(this.getSimpleConsult(), firstResult, maxResults));
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                 * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacade.dublinCoreDTOsToReferenceDTOs(aListDTO);
                //Seleccionar los elemento que han sido seleccionados antes en la interfaz
                this.setSelectedResources(results, selectedResourcesId);
                return results;

            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        } else if(isEditMode()) //En caso de que sean relaciones Dublin Core utilizados para editar un indicador
        {
            try {
                /*
                 * Se realiza la consulta para traer todas las relaciones indicator-dublinCore dado
                 * el nodo indicador actual sobre el cual se está editando
                 */
                List<Long> dublinCoreIds = this.indicatorFacade.getDublinCoreIdsByIndicator(new Long(nodeId));
                //obtener la lista de DublinCoreDTO de acuerdo a la lista de DublinCoreIds
                aListDTO = this.dublinCoreFacade.getDublinCoreDTOsByIds(dublinCoreIds);
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacade.dublinCoreDTOsToReferenceDTOs(aListDTO);
                // Seleccionar en la interfaz todas las relaciones dublin core del indicador
                this.setEditRestults(results, selectedResourcesId);
                // Dejar el modo edit en false para poder hacer búsquedas
                editMode = false;
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
                aListDTO =  myReturn(this.getDublinCoreFacade().getAllDublinCorePaginated(firstResult, maxResults));
                /* Se convierte el resultado de la consulta de DublinCoreDTO a ReferenceDTO
                * para poder mostrar los datos en la tabla utilizada en la interfaz
                */
                results = this.dublinCoreFacade.dublinCoreDTOsToReferenceDTOs(aListDTO);
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
     * Selecciona en la interfaz las relaciones existentes indicador-dublinCore que se muestran al
     * realizar la edición de datos de un indicador.
     */
    public void setEditRestults(List<ReferenceDTO> indicatorReferences, Map<String,ReferenceDTO> selectedRef)
    {
        initEditReferenceMap();

        
        for(ReferenceDTO indicatorReference : indicatorReferences)
        {
            selectedRef.put(indicatorReference.getKey(), indicatorReference);
            dbRelationsDublinCore.put(indicatorReference.getKey(), indicatorReference);
            indicatorReference.setSelected(true);
        }
    }

    /*
     * Valida si la lista es nula para o no, para retornar un objeto no nulo
     */
    public List myReturn(List l) {
        if (l == null) {
            return new ArrayList<DublinCoreDTO>();
        } else {
            return l;
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
     * @return the editMode
     */
    public boolean isEditMode() {
        return editMode;
    }

    /**
     * @param editMode the editMode to set
     */
    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }


   /*
    * Convierte los datos contenido del map en un string
    */
   public String mapToString(Map<String,ReferenceDTO> map)
   {
        String result = "";
        Collection<ReferenceDTO> references = map.values();
        for(ReferenceDTO reference: references)
        {
            result += reference.getKey() +"\t"+reference.getTitle()+"\n";
        }
        return result;
    }

    /**
     * @return the editReference
     */
    public Map<String, ReferenceDTO> getDBRelationsDublinCore() {
        return dbRelationsDublinCore;
    }

    /**
     * @param editReference the editReference to set
     */
    public void setDBRelationsDublinCore(Map<String, ReferenceDTO> editReference) {
        this.dbRelationsDublinCore = editReference;
    }

    
}
