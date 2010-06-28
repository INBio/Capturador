/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.transaction;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.transaction.TransactedSpecimenDTO;
import org.inbio.ara.dto.transaction.TransactionDTO;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.search.SearchFacadeRemote;
import org.inbio.ara.facade.transaction.TransactionFacadeRemote;
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
 * @version TransactionSessionBean.java
 * @version Created on Feb 18, 2010, 4:54:12 PM
 * @author echinchilla
 */

public class TransactionSessionBean extends AbstractSessionBean implements PaginationCoreInterface {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    //Injection
    @EJB
    private TransactionFacadeRemote transactionFacade;

    @EJB
    private InventoryFacadeRemote inventoryFacade;

    @EJB
    private SearchFacadeRemote searchFacade;

    //Objeto que controla la paginacion de transacciones
    //private PaginationController pagination = null;
    private PaginationControllerRemix pagination = null;

    //Entero que indica la cantidad de elementos que el usuario desea mostrar en los resultados
    private int quantity = 10; //Por defecto se mostraran 10 elementos

    //Current DTO para el manejo de transacciones
    private TransactionDTO currentTransaction = new TransactionDTO();

    private TransactedSpecimenDTO currentTransactedSpecimen = new TransactedSpecimenDTO();

    //TransactionDTO containing the search data
    private TransactionDTO searchDataDTO = new TransactionDTO();

    private String simpleSearchText = "";

    private boolean advancedSearch = false;

    private boolean simpleSearch = false;

    //booleano utilizado para refrescar algunos componentes.
    private boolean firstTime;

    private boolean transactionJustCreated;

    // true en caso de que el paginador sea el de transacción
    // false en caso de que el paginador sea el de especímenes transados
    private boolean transactionPaginator = false;

    // NO SE USA??? REVISAR!
    private boolean[] selectedTransactedSpecimens;


    private String transactedSpecimenDescription;
    private Long transactedSpecimenStatusId;


    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public TransactionSessionBean() {
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
            log("TransactionSessionBean Initialization Failure", e);
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

    public void nextResults() {
        System.out.println("Valores del paginador: ----base: " +
                this.pagination.getActualPage());
        System.out.println("Valores del paginador: ----offset: " +
                this.pagination.getResultsPerPage());
        System.out.println("Valores del paginador: ----total: " +
                this.pagination.getTotalResults());
        this.pagination.nextResults();
    }

    /**
     * @return the transactionFacade
     */
    public TransactionFacadeRemote getTransactionFacade() {
        return transactionFacade;
    }

    /**
     * @param transactionFacade the transactionFacade to set
     */
    public void setTransactionFacade(TransactionFacadeRemote transactionFacade) {
        this.transactionFacade = transactionFacade;
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
     * @return the currentTransaction
     */
    public TransactionDTO getCurrentTransaction() {
        return currentTransaction;
    }

    /**
     * @param currentTransaction the currentTransaction to set
     */
    public void setCurrentTransaction(TransactionDTO currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    /**
     * @return the currentTransactedSpecimen
     */
    public TransactedSpecimenDTO getCurrentTransactedSpecimen() {
        return currentTransactedSpecimen;
    }

    /**
     * @param currentTransactedSpecimen the currentTransactedSpecimen to set
     */
    public void setCurrentTransactedSpecimen(TransactedSpecimenDTO currentTransactedSpecimen) {
        this.currentTransactedSpecimen = currentTransactedSpecimen;
    }

    /**
     * @return the searchDataDTO
     */
    public TransactionDTO getSearchDataDTO() {
        return searchDataDTO;
    }

    /**
     * @param searchDataDTO the searchDataDTO to set
     */
    public void setSearchDataDTO(TransactionDTO searchDataDTO) {
        this.searchDataDTO = searchDataDTO;
    }

    /**
     * @return the simpleSearchText
     */
    public String getSimpleSearchText() {
        return simpleSearchText;
    }

    /**
     * @param simpleSearchText the simpleSearchText to set
     */
    public void setSimpleSearchText(String simpleSearchText) {
        this.simpleSearchText = simpleSearchText;
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
     * @return the transactionJustCreated
     */
    public boolean isTransactionJustCreated() {
        return transactionJustCreated;
    }

    /**
     * @param transactionJustCreated the transactionJustCreated to set
     */
    public void setTransactionJustCreated(boolean transactionJustCreated) {
        this.transactionJustCreated = transactionJustCreated;
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
     * Inicializar el data provider
     */
    public void initDataProvider() {
        if(isTransactionPaginator()) {
            //setPagination(new PaginationControllerImpl(this.getTransactionFacade().countTransaction().intValue(), this.getQuantity()));
            setPagination(new PaginationControllerRemix(this.getTransactionFacade().
                    countTransaction(this.getAraSessionBean().getGlobalCollectionId()).intValue(), getQuantity(), this));
        }
        else {
            int totalResults = this.getTransactionFacade().
                    countTransactedSpecimen(this.currentTransaction.getTransactionId()).intValue();
            selectedTransactedSpecimens = new boolean[totalResults];

            setPagination(new PaginationControllerRemix(totalResults, this.getQuantity(), this));
        }
    }

    /**
     * @return un String que contiene el detalle de la paginacion
     */
    public String getPaginatorQuantityTotal() {
        int actualPage = this.getPagination().getActualPage();
        int resultsPerPage = this.getPagination().getResultsPerPage();
        int totalResults = this.getPagination().getTotalResults();
        return "  " + (actualPage + 1) + " - " +
                ((actualPage + resultsPerPage) > totalResults ? totalResults : (actualPage + resultsPerPage)) +
                "  | " + totalResults +"  ";
    }

    /**
     * Metodo para mandar a persistir el currentTransaction
     * @param transactionDTO
     */
    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
        return this.transactionFacade.saveTransaction(transactionDTO);
    }

   /**
     * Metodo para eliminar transacciones por su id
     * @param transactionId
     */
    public void deleteTransaction(Long transactionId){
        this.transactionFacade.deleteTransaction(transactionId);
    }

    public void deleteTransactedSpecimens(ArrayList<TransactedSpecimenDTO> selectedTransactedSpecimens){
        this.transactionFacade.deleteTransactedSpecimens(selectedTransactedSpecimens);
    }

    public void editTransactedSpecimens(ArrayList<TransactedSpecimenDTO> selectedTransactedSpecimens, TransactedSpecimenDTO tsDTO){
        this.transactionFacade.editTransactedSpecimens(selectedTransactedSpecimens, tsDTO);
    }

    /**
     * Metodo para actualizar una transaccion
     * @param tDTO
     */
    public void updateTransaction(TransactionDTO tDTO) {
        this.transactionFacade.updateTransaction(tDTO);
    }

    /**
     * Obtener la lista de todas las instituciones para el dropdown de isntituciones
     */
    public List<InstitutionDTO> setInstitutionDropDownData() {
        return getTransactionFacade().getAllInstitutions();
    }

    /**
     * Obtener la lista de personas asociadas al SenderInstitution escogido
     */
    public List<PersonDTO> setSenderPersonDropDownData(Long senderInstitutionId) {

        return getTransactionFacade().
//                getPersonsByInstitutionId(this.getCurrentTransaction().getSenderInstitutionId());
                getPersonsByInstitutionId(senderInstitutionId);
    }

    /**
     * Obtener la lista de personas asociadas al ReceiverInstitution escogido
     */
    public List<PersonDTO> setReceiverPersonDropDownData(Long receiverInstitutionId) {
        return getTransactionFacade().
//                getPersonsByInstitutionId(this.getCurrentTransaction().getReceiverInstitutionId());
                getPersonsByInstitutionId(receiverInstitutionId);
    }

    public TransactedSpecimenDTO saveTransactedSpecimen() {
        this.currentTransactedSpecimen.setDescription(this.transactedSpecimenDescription);
        this.currentTransactedSpecimen.setTransactedSpecimenStatusId(this.transactedSpecimenStatusId);
        return this.getTransactionFacade().saveTransactedSpecimen
                (this.getCurrentTransaction(), currentTransactedSpecimen, this.getAraSessionBean().getGlobalUserName());
    }

    /**
     * @return the transactionPaginator
     */
    public boolean isTransactionPaginator() {
        return transactionPaginator;
    }

    /**
     * @param transactionPaginator the transactionPaginator to set
     */
    public void setTransactionPaginator(boolean paginatorNeeded) {
        this.transactionPaginator = paginatorNeeded;
    }

    /**
     * @return the transactedSpecimenDescription
     */
    public String getTransactedSpecimenDescription() {
        return transactedSpecimenDescription;
    }

    /**
     * @param transactedSpecimenDescription the transactedSpecimenDescription to set
     */
    public void setTransactedSpecimenDescription(String transactedSpecimenDescription) {
        this.transactedSpecimenDescription = transactedSpecimenDescription;
    }

    /**
     * @return the transactedSpecimenStatusId
     */
    public Long getTransactedSpecimenStatusId() {
        return transactedSpecimenStatusId;
    }

    /**
     * @param transactedSpecimenStatusId the transactedSpecimenStatusId to set
     */
    public void setTransactedSpecimenStatusId(Long transactedSpecimenStatusId) {
        this.transactedSpecimenStatusId = transactedSpecimenStatusId;
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
     * @return the simpleSearch
     */
    public boolean isSimpleSearch() {
        return simpleSearch;
    }

    /**
     * @param simpleSearch the simpleSearch to set
     */
    public void setSimpleSearch(boolean simpleSearch) {
        this.simpleSearch = simpleSearch;
    }

    public List getResults(int firstResult, int maxResults) {
        Long collectionId = getAraSessionBean().getGlobalCollectionId();
        if(isTransactionPaginator()) {

            List<TransactionDTO> auxResult = new ArrayList<TransactionDTO>();
            if (isAdvancedSearch()) {
                this.searchDataDTO.setCollectionId(collectionId);
                try {
                    return this.searchFacade.searchTransactionsByCriteria(this.searchDataDTO, firstResult, maxResults);
                }
                catch (Exception e) {
                    return auxResult;
                }
            }
            else if (isSimpleSearch()) {
                try {
                    return this.searchFacade.searchTransactionsByCriteria(this.simpleSearchText, collectionId, firstResult, maxResults);
                }
                catch (Exception e) {
                    return auxResult;
                }
            }
            else {
                return transactionFacade.getAllTransactionPaginated(firstResult, maxResults, collectionId);
            }
        }
        else {
            return transactionFacade.getAllTransactedSpecimenPaginated(firstResult, maxResults, this.getCurrentTransaction().getTransactionId());
            //throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    /**
     * @return the searchResults
     */
    /*public List<TransactionDTO> getSearchResults() {
    return searchResults;
    }*/

    /**
     * @param searchResults the searchResults to set
     */
    /*public void setSearchResults(List<TransactionDTO> searchResults) {
    this.searchResults = searchResults;
    }*/

}
