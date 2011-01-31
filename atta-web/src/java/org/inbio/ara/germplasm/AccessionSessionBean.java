/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.germplasm.AccessionDTO;
import org.inbio.ara.facade.germplasm.GermplasmFacadeRemote;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
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
 * @version AccessionSessionBean.java
 * @version Created on 02/03/2010, 03:55:15 PM
 * @author dasolano
 */

public class AccessionSessionBean extends AbstractSessionBean implements PaginationCoreInterface{
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
    private InventoryFacadeRemote inventoryFacadeRemote;
    
    private AccessionDTO accessionDTO = new AccessionDTO();

    private AccessionDTO editAccessionDTO = new AccessionDTO();

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

    private AccessionDTO queryAccessionDTO = new AccessionDTO();

    private Long deleteAccession = null;
    
    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public AccessionSessionBean() {
    }


    public void resetValues()
    {
        accessionDTO = new AccessionDTO();
        editAccessionDTO = new AccessionDTO();
        pagination.refreshList();
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
     * Inicializar el data provider de especimenes
     */
    public void initDataProvider() {
        //pagination = new PaginationControllerImpl(getInventoryFacadeRemote().countGatheringObservations().intValue(), this.getQuantity());
        setPagination(new PaginationControllerRemix(this.getGermplasmFacadeRemote().countAccessions().intValue(), getQuantity(), this));
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
            log("AccessionSessionBean Initialization Failure", e);
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
     * @return the accessionDTO
     */
    public // </editor-fold>
    AccessionDTO getAccessionDTO() {
        return accessionDTO;
    }

    /**
     * @param accessionDTO the accessionDTO to set
     */
    public void setAccessionDTO(AccessionDTO accessionDTO) {
        this.accessionDTO = accessionDTO;
    }

    /**
     * Para evitar que retorne null al data provider del paginador
     * @param l lista retornada para el paginador
     * @return
     */
    public List myReturn(List l) {
        if (l == null) {
            return new ArrayList<AccessionDTO>();
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
     * get the results for the list of accessions
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List getResults(int firstResult, int maxResults) {
        List<AccessionDTO> auxResult = new ArrayList<AccessionDTO>();

        List<AccessionDTO> aListDTO;

        if (isQueryMode()) { //En caso de que sea busqueda avanzada
            //Set the collectionId into the DTO
            try {
                aListDTO =  myReturn(getGermplasmFacadeRemote().
                        getAccessionAdvancedSearch(getQueryAccessionDTO(),
                        getAraSessionBean().getGlobalCollectionId(),
                        firstResult, maxResults));

                /*if(accessionDTO.getAccessionId() != null && aListDTO != null && !aListDTO.isEmpty())
                {
                    for (AccessionDTO accessionDTO1 : aListDTO)
                    {
                        if(accessionDTO1.getAccessionId().equals(accessionDTO.getAccessionId()))
                            accessionDTO1.setSelected(true);
                    }
                }*/
                return aListDTO;

                
            } catch (Exception e) {
                return auxResult;
            }
        } else if (isQueryModeSimple()) { //En caso de que sea busqueda simple
            try {
            
                aListDTO =  myReturn(getGermplasmFacadeRemote().
                        getAccessionSimpleSearch(getConsultaSimple(),
                        getAraSessionBean().getGlobalCollectionId(),
                        firstResult, maxResults));

                /*if(accessionDTO.getAccessionId() != null && aListDTO != null && !aListDTO.isEmpty())
                {
                    for (AccessionDTO accessionDTO1 : aListDTO)
                    {
                        if(accessionDTO1.getAccessionId().equals(accessionDTO.getAccessionId()))
                            accessionDTO1.setSelected(true);
                    }
                }*/
                return aListDTO;

            } catch (Exception e) {
                return auxResult;
            }
        } else //Valores default
        {
            try {
                aListDTO =  myReturn(getGermplasmFacadeRemote().
                        getAccessionListPaginated(firstResult, maxResults));

                /*if(accessionDTO.getAccessionId() != null && aListDTO != null && !aListDTO.isEmpty())
                {
                    for (AccessionDTO accessionDTO1 : aListDTO)
                    {
                        if(accessionDTO1.getAccessionId().equals(accessionDTO.getAccessionId()))
                            accessionDTO1.setSelected(true);
                    }
                }*/
                return aListDTO;
            } catch (Exception e) {
                return auxResult;
            }
        }
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
     * @return the queryAccessionDTO
     */
    public AccessionDTO getQueryAccessionDTO() {
        return queryAccessionDTO;
    }

    /**
     * @param queryAccessionDTO the queryAccessionDTO to set
     */
    public void setQueryAccessionDTO(AccessionDTO queryAccessionDTO) {
        this.queryAccessionDTO = queryAccessionDTO;
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
     * @return the editAccessionDTO
     */
    public AccessionDTO getEditAccessionDTO() {
        return editAccessionDTO;
    }

    /**
     * @param editAccessionDTO the editAccessionDTO to set
     */
    public void setEditAccessionDTO(AccessionDTO editAccessionDTO) {
        this.editAccessionDTO = editAccessionDTO;
    }

    /**
     * @return the deleteAccession
     */
    public Long getDeleteAccession() {
        return deleteAccession;
    }

    /**
     * @param deleteAccession the deleteAccession to set
     */
    public void setDeleteAccession(Long deleteAccession) {
        this.deleteAccession = deleteAccession;
    }
    
}
