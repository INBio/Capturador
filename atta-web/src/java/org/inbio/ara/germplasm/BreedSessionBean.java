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
import org.inbio.ara.dto.germplasm.BreedDTO;
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
 * @version BreedSessionBean.java
 * @version Created on 08/04/2010, 10:26:00 AM
 * @author dasolano
 */

public class BreedSessionBean extends AbstractSessionBean implements PaginationCoreInterface{
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

    private BreedDTO breedDTO = new BreedDTO();
    
    //Objeto que controla la paginacion de la informacion de passport
    private PaginationControllerRemix pagination = null;

    //Bandera para saber si se activo el panel de busqueda avanzada
    private boolean advancedSearch = false;
    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos
    

    //Bandera para indicarle al paginador que trabaje en modo busqueda simple
    private boolean queryModeSimple = false;
    //String que indica la consulta del usuario en la busqueda simple
    private String consultaSimple = new String("");

    private BreedDTO queryBreedDTO = new BreedDTO();

    private boolean firstTime = true;

    private Long deleteBreed = null;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public BreedSessionBean() {
    }

    public void resetValues()
    {
        breedDTO = new BreedDTO();
        queryBreedDTO = new BreedDTO();
        consultaSimple = new String("");
        queryModeSimple = false;
        advancedSearch = false;
        firstTime = true;
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
            log("BreedSessionBean Initialization Failure", e);
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
     * @return the breedDTO
     */
    public BreedDTO getBreedDTO() {
        return breedDTO;
    }

    /**
     * @param breedDTO the breedDTO to set
     */
    public void setBreedDTO(BreedDTO breedDTO) {
        this.breedDTO = breedDTO;
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
     * @return the queryBreedDTO
     */
    public BreedDTO getQueryBreedDTO() {
        return queryBreedDTO;
    }

    /**
     * @param queryBreedDTO the queryBreedDTO to set
     */
    public void setQueryBreedDTO(BreedDTO queryBreedDTO) {
        this.queryBreedDTO = queryBreedDTO;
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
            return new ArrayList<BreedDTO>();
        } else {
            return l;
        }
    }
    
    public List getResults(int firstResult, int maxResults)
    {
        List<BreedDTO> auxResult = new ArrayList<BreedDTO>();

        List<BreedDTO> aListDTO;

        if (isQueryModeSimple())
        { //En caso de que sea busqueda simple
            try
            {
                getPagination().setTotalResults(getGermplasmFacadeRemote().countBreedSimpleSearch(consultaSimple).intValue());
                aListDTO =  myReturn(getGermplasmFacadeRemote().
                        getBreedSimpleSearch(consultaSimple, firstResult, maxResults));

                return aListDTO;

            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        } else //Valores default
        {
            try {
                getPagination().setTotalResults(getGermplasmFacadeRemote().countAllBreed().intValue());
                aListDTO =  myReturn(getGermplasmFacadeRemote().
                        getAllBreedPaginated(firstResult, maxResults));

                return aListDTO;
            } catch (Exception e) {
                e.printStackTrace();
                return auxResult;
            }
        }
    }

    /**
     * Inicializar el data provider de especimenes
     */
    public void initDataProvider() {
        setPagination(new PaginationControllerRemix(
                getGermplasmFacadeRemote().countAllBreed().intValue(), this.quantity, this));
        getPagination().firstResults();
    }

    /**
     * @return the deleteBreed
     */
    public Long getDeleteBreed() {
        return deleteBreed;
    }

    /**
     * @param deleteBreed the deleteBreed to set
     */
    public void setDeleteBreed(Long deleteBreed) {
        this.deleteBreed = deleteBreed;
    }

    
}
