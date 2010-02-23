/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germoplasma;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.germoplasma.PassportDTO;
import org.inbio.ara.facade.germoplasma.GermoplasmaFacadeRemote;
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
 * @version PassportListSessionBean.java
 * @version Created on 09/02/2010, 01:28:17 PM
 * @author dasolano
 */

public class PassportListSessionBean extends AbstractSessionBean  implements PaginationCoreInterface{
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
    private GermoplasmaFacadeRemote germoplasmaFacadeRemote;

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


    private PassportDTO passportDTO = new PassportDTO();

    //Passport DTO utilizado para realizar las consultas
    private PassportDTO queryPassportDTO = new PassportDTO();

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public PassportListSessionBean() {
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
            log("PassportListSessionBean Initialization Failure", e);
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
        //pagination = new PaginationControllerImpl(getInventoryFacadeRemote().countGatheringObservations().intValue(), this.getQuantity());
        setPagination(new PaginationControllerRemix(this.getGermoplasmaFacadeRemote().countPassport().intValue(), quantity, this));
    }

    /**
     * Para evitar que retorne null al data provider del paginador
     * @param l lista retornada para el paginador
     * @return
     */
    public List myReturn(List l) {
        if (l == null) {
            return new ArrayList<PassportDTO>();
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

        List<PassportDTO> auxResult = new ArrayList<PassportDTO>();


        if (isQueryMode()) { //En caso de que sea busqueda avanzada
            //Set the collectionId into the DTO
            //It is a mandatory filter
            PassportDTO pdto = getQueryPassportDTO();
            try {
                return myReturn(getGermoplasmaFacadeRemote().
                        getPassportListPaginated(firstResult, maxResults));
            } catch (Exception e) {
                return auxResult;
            }
        } else if (isQueryModeSimple()) { //En caso de que sea busqueda simple
            try {
                return myReturn(getGermoplasmaFacadeRemote().
                        getPassportListPaginated(firstResult, maxResults));

                /*return myReturn(searchFacade.
                            searchGathObsByCriteria(getConsultaSimple(), collectionId, firstResult,
                            maxResults));*/

            } catch (Exception e) {
                return auxResult;
            }
        } else //Valores default
        {
            try {
                return myReturn(getGermoplasmaFacadeRemote().
                        getPassportListPaginated(firstResult, maxResults));
            } catch (Exception e) {
                return auxResult;
            }
        }
    }

    /**
     * @return the germoplasmaFacadeRemote
     */
    public GermoplasmaFacadeRemote getGermoplasmaFacadeRemote() {
        return germoplasmaFacadeRemote;
    }

    /**
     * @param germoplasmaFacadeRemote the germoplasmaFacadeRemote to set
     */
    public void setGermoplasmaFacadeRemote(GermoplasmaFacadeRemote germoplasmaFacadeRemote) {
        this.germoplasmaFacadeRemote = germoplasmaFacadeRemote;
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
     * @return the queryPassportDTO
     */
    public PassportDTO getQueryPassportDTO() {
        return queryPassportDTO;
    }

    /**
     * @param queryPassportDTO the queryPassportDTO to set
     */
    public void setQueryPassportDTO(PassportDTO queryPassportDTO) {
        this.queryPassportDTO = queryPassportDTO;
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

}