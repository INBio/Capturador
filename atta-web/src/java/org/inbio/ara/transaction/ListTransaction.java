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

package org.inbio.ara.transaction;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.dto.transaction.TransactedSpecimenDTO;
import org.inbio.ara.dto.transaction.TransactionDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListTransaction.java
 * @version Created on Feb 18, 2010, 4:52:31 PM
 * @author echinchilla
 */

public class ListTransaction extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    //Table binding
    private HtmlDataTable TransactionTable = new HtmlDataTable();

    //Buttons binding
    private HtmlCommandButton btnTransactionSearch = new HtmlCommandButton();
    private HtmlCommandButton btnAdvTransactionSearch = new HtmlCommandButton();

    // Advanced Search elements
    private HtmlPanelGrid pgAdvancedSearch = new HtmlPanelGrid();
    private HtmlInputText txSearch = new HtmlInputText();

    private Calendar clInitialTransactionDate = new Calendar();
    private Calendar clFinalTransactionDate = new Calendar();
    
    private Calendar clInitialExpirationDate = new Calendar();
    private Calendar clFinalExpirationDate = new Calendar();

    private HtmlInputHidden deleteConfirmationText = new HtmlInputHidden();

    // <editor-fold defaultstate="collapsed" desc="OptionsList's">
    /**
     * En esta variable se setearan los datos del drop down de sender person.
     *
     * NOTA: institutionData se está usando tanto para senderInstitution como para
     * receiverInstitution. Esto, probablemete, deba cambiar.
     */
    private SingleSelectOptionsList institutionData = new SingleSelectOptionsList();
    private SingleSelectOptionsList senderPersonData = new SingleSelectOptionsList();
    private SingleSelectOptionsList receiverPersonData = new SingleSelectOptionsList();
    private SingleSelectOptionsList transactionTypeData = new SingleSelectOptionsList();
    // </editor-fold>

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();

    private HtmlInputText txCatalogNumber = new HtmlInputText();
    private Calendar clReceivingDate = new Calendar();
    private SingleSelectOptionsList transactedSpecimenStatusData = new SingleSelectOptionsList();
    private HtmlCommandButton btnReturnTransactedSpecimen = new HtmlCommandButton();

    private Calendar clInitialDeliveryDate = new Calendar();
    private Calendar clFinalDeliveryDate = new Calendar();

    private Calendar clInitialReceivingDate = new Calendar();
    private Calendar clFinalReceivingDate = new Calendar();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListTransaction() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
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
            log("ListTransaction Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
        TransactionSessionBean tsb = getTransactionSessionBean();
        //Load required data
        this.deleteConfirmationText.setValue(BundleHelper.getDefaultBundleValue("delete_confirmation", this.getMyLocale()));
        this.getInstitutionData().setOptions(setInstitutionDropDownData());
        this.getSenderPersonData().setOptions(setSenderPersonDropDownData());
        this.getReceiverPersonData().setOptions(setReceiverPersonDropDownData());
        this.getTransactionTypeData().setOptions(getSelectionListDropDownData
                (SelectionListEntity.TRANSACTION_TYPE.getId()));
        this.getTransactedSpecimenStatusData().setOptions(getSelectionListDropDownData
                (SelectionListEntity.TRANSACTED_SPECIMEN_STATUS.getId()));
        java.util.Calendar currentDate = java.util.Calendar.getInstance();
        this.clReceivingDate.setSelectedDate(currentDate.getTime());
        //------------------------------ Control de GUI -------------------------------
        //Preguntar si la bandera de busqueda avanzada esta seteada
        if(tsb.isAdvancedSearch()){
            this.getPgAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
        }
        //-------------------------- Control de Paginador ------------------------------
        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        if(tsb.getPagination()==null || !tsb.isTransactionPaginator()){
            tsb.setTransactionPaginator(true);
            tsb.initDataProvider();
        }
        //Actualizar los datos del paginador si no es nula ni es ninguna búsqueda (osea, listado base)
        else if(!tsb.isAdvancedSearch() && !tsb.isSimpleSearch()){
            Long collectionId = getAraSessionBean().getGlobalCollectionId();
            tsb.getPagination().setTotalResults(tsb.getTransactionFacade().
                    countTransaction(collectionId).intValue());
            tsb.getPagination().refreshList();
        }
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     * @return reference to the scoped data bean
     */
    protected TransactionSessionBean getTransactionSessionBean() {
        return (TransactionSessionBean) getBean("transaction$TransactionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    // <editor-fold defaultstate="collapsed" desc="GETS & SETS">
    /**
     * @return the TransactionTable
     */
    public HtmlDataTable getTransactionTable() {
        return TransactionTable;
    }

    /**
     * @param TransactionTable the TransactionTable to set
     */
    public void setTransactionTable(HtmlDataTable TransactionTable) {
        this.TransactionTable = TransactionTable;
    }

    /**
     * @return the btnTransactionSearch
     */
    public HtmlCommandButton getBtnTransactionSearch() {
        return btnTransactionSearch;
    }

    /**
     * @param btnTransactionSearch the btnTransactionSearch to set
     */
    public void setBtnTransactionSearch(HtmlCommandButton btnTransactionSearch) {
        this.btnTransactionSearch = btnTransactionSearch;
    }

    /**
     * @return the btnAdvTransactionSearch
     */
    public HtmlCommandButton getBtnAdvTransactionSearch() {
        return btnAdvTransactionSearch;
    }

    /**
     * @param btnAdvTransactionSearch the btnAdvTransactionSearch to set
     */
    public void setBtnAdvTransactionSearch(HtmlCommandButton btnAdvTransactionSearch) {
        this.btnAdvTransactionSearch = btnAdvTransactionSearch;
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal = this.getTransactionSessionBean().getPaginatorQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the pgAdvancedSearch
     */
    public HtmlPanelGrid getPgAdvancedSearch() {
        return pgAdvancedSearch;
    }

    /**
     * @param pgAdvancedSearch the pgAdvancedSearch to set
     */
    public void setPgAdvancedSearch(HtmlPanelGrid pgAdvancedSearch) {
        this.pgAdvancedSearch = pgAdvancedSearch;
    }

    /**
     * @return the txSearch
     */
    public HtmlInputText getTxSearch() {
        return txSearch;
    }

    /**
     * @param txSearch the txSearch to set
     */
    public void setTxSearch(HtmlInputText txSearch) {
        this.txSearch = txSearch;
    }

    /**
     * @return the clInitialTransactionDate
     */
    public Calendar getClInitialTransactionDate() {
        return clInitialTransactionDate;
    }

    /**
     * @param clInitialTransactionDate the clInitialTransactionDate to set
     */
    public void setClInitialTransactionDate(Calendar clInitialTransactionDate) {
        this.clInitialTransactionDate = clInitialTransactionDate;
    }

    /**
     * @return the clFinalTransactionDate
     */
    public Calendar getClFinalTransactionDate() {
        return clFinalTransactionDate;
    }

    /**
     * @param clFinalTransactionDate the clFinalTransactionDate to set
     */
    public void setClFinalTransactionDate(Calendar clFinalTransactionDate) {
        this.clFinalTransactionDate = clFinalTransactionDate;
    }

    /**
     * @return the clInitialExpirationDate
     */
    public Calendar getClInitialExpirationDate() {
        return clInitialExpirationDate;
    }

    /**
     * @param clInitialExpirationDate the clInitialExpirationDate to set
     */
    public void setClInitialExpirationDate(Calendar clInitialExpirationDate) {
        this.clInitialExpirationDate = clInitialExpirationDate;
    }

    /**
     * @return the clFinalExpirationDate
     */
    public Calendar getClFinalExpirationDate() {
        return clFinalExpirationDate;
    }

    /**
     * @param clFinalExpirationDate the clFinalExpirationDate to set
     */
    public void setClFinalExpirationDate(Calendar clFinalExpirationDate) {
        this.clFinalExpirationDate = clFinalExpirationDate;
    }

    /**
     * @return the deleteConfirmationText
     */
    public HtmlInputHidden getDeleteConfirmationText() {
        return deleteConfirmationText;
    }

    /**
     * @param deleteConfirmationText the deleteConfirmationText to set
     */
    public void setDeleteConfirmationText(HtmlInputHidden deleteConfirmationText) {
        this.deleteConfirmationText = deleteConfirmationText;
    }


    /**
     * @return the institutionData
     */
    public SingleSelectOptionsList getInstitutionData() {
        return institutionData;
    }

    /**
     * @param institutionData the institutionData to set
     */
    public void setInstitutionData(SingleSelectOptionsList institutionData) {
        this.institutionData = institutionData;
    }

    /**
     * @return the senderPersonData
     */
    public SingleSelectOptionsList getSenderPersonData() {
        return senderPersonData;
    }

    /**
     * @param senderPersonData the senderPersonData to set
     */
    public void setSenderPersonData(SingleSelectOptionsList senderPersonData) {
        this.senderPersonData = senderPersonData;
    }

    /**
     * @return the receiverPersonData
     */
    public SingleSelectOptionsList getReceiverPersonData() {
        return receiverPersonData;
    }

    /**
     * @param receiverPersonData the receiverPersonData to set
     */
    public void setReceiverPersonData(SingleSelectOptionsList receiverPersonData) {
        this.receiverPersonData = receiverPersonData;
    }

    /**
     * @return the transactionTypeData
     */
    public SingleSelectOptionsList getTransactionTypeData() {
        return transactionTypeData;
    }

    /**
     * @param transactionTypeData the transactionTypeData to set
     */
    public void setTransactionTypeData(SingleSelectOptionsList transactionTypeData) {
        this.transactionTypeData = transactionTypeData;
    }

    /**
     * @return the btnReturnTransactedSpecimen
     */
    public HtmlCommandButton getBtnReturnTransactedSpecimen() {
        return btnReturnTransactedSpecimen;
    }

    /**
     * @param btnReturnTransactedSpecimen the btnReturnTransactedSpecimen to set
     */
    public void setBtnReturnTransactedSpecimen(HtmlCommandButton btnReturnTransactedSpecimen) {
        this.btnReturnTransactedSpecimen = btnReturnTransactedSpecimen;
    }

    /**
     * @return the clInitialDeliveryDate
     */
    public Calendar getClInitialDeliveryDate() {
        return clInitialDeliveryDate;
    }

    /**
     * @param clInitialDeliveryDate the clInitialDeliveryDate to set
     */
    public void setClInitialDeliveryDate(Calendar clInitialDeliveryDate) {
        this.clInitialDeliveryDate = clInitialDeliveryDate;
    }

    /**
     * @return the clFinalDeliveryDate
     */
    public Calendar getClFinalDeliveryDate() {
        return clFinalDeliveryDate;
    }

    /**
     * @param clFinalDeliveryDate the clFinalDeliveryDate to set
     */
    public void setClFinalDeliveryDate(Calendar clFinalDeliveryDate) {
        this.clFinalDeliveryDate = clFinalDeliveryDate;
    }

    /**
     * @return the clInitialReceivingDate
     */
    public Calendar getClInitialReceivingDate() {
        return clInitialReceivingDate;
    }

    /**
     * @param clInitialReceivingDate the clInitialReceivingDate to set
     */
    public void setClInitialReceivingDate(Calendar clInitialReceivingDate) {
        this.clInitialReceivingDate = clInitialReceivingDate;
    }

    /**
     * @return the clFinalReceivingDate
     */
    public Calendar getClFinalReceivingDate() {
        return clFinalReceivingDate;
    }

    /**
     * @param clFinalReceivingDate the clFinalReceivingDate to set
     */
    public void setClFinalReceivingDate(Calendar clFinalReceivingDate) {
        this.clFinalReceivingDate = clFinalReceivingDate;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }
    // </editor-fold>

    /***************************************************************************
     ******************* === BUTTON FUNCTIONS === ******************************
     **************************************************************************/
    // <editor-fold defaultstate="collapsed" desc="BUTTON FUNCTIONS">

    /**
     * Metodo ejecutado por el boton de busqueda simple
     * @return
     */
    public String btnTransactionSearch_action() {
        String userInput = "";
        if(this.getTxSearch().getValue()!= null)
            userInput = this.getTxSearch().getValue().toString();
        userInput = userInput.trim();
        TransactionSessionBean tsb = this.getTransactionSessionBean();
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            tsb.setSimpleSearch(false);
            tsb.setAdvancedSearch(false);
            //Finalmente se setea el data provider del paginador con los datos por default
            tsb.getPagination().setTotalResults
                    (tsb.getTransactionFacade().
                    countTransaction(this.getAraSessionBean().getGlobalCollectionId()).intValue());
        }
        else{
            //Setear el string para consulta simple del SessionBean
            tsb.setSimpleSearchText(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            tsb.setSimpleSearch(true);
            //Desabilitar la bandera de busqueda avanzada
            tsb.setAdvancedSearch(false);
            //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
            tsb.getPagination().setTotalResults
                    (tsb.getSearchFacade().
                    countTransactionsByCriteria(userInput, this.getAraSessionBean().getGlobalCollectionId()).intValue());
        }
        tsb.getPagination().firstResults();
        return null;
    }

    /**
     * Metodo ejecutado por el boton que muestra el panel de busqueda avanzada
     * Su funcion es mostrar y esconder dicho panel
     * @return
     */
    public String btnAdvTransactionSearch_action() {
        boolean advanced = this.getTransactionSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            this.getTransactionSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearch().setRendered(false);
            this.getBtnTransactionSearch().setRendered(false);
            this.getBtnReturnTransactedSpecimen().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvTransactionSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){//Ocultar panel de búsqueda avanzada
            this.getTransactionSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.getPgAdvancedSearch().setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearch().setRendered(true);
            this.getBtnTransactionSearch().setRendered(true);
            this.getBtnReturnTransactedSpecimen().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvTransactionSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search",getMyLocale()));
            //Reestablecer los valores por defecto de los drop downs
            this.getTransactionSessionBean().setSearchDataDTO(new TransactionDTO());
        }
        return null;
    }

    /**
     * Metodo ejecutado por el boton de proceder con la busqueda avanzada
     * este boton es el que esta dentro del panel de busqueda avanzada
     * @return
     */
    public String btnAdvSearchGO_action() {
        
        GregorianCalendar gcInitialTransactionDate = new GregorianCalendar();
        GregorianCalendar gcInitialExpirationDate = new GregorianCalendar();
        GregorianCalendar gcInitialDeliveryDate = new GregorianCalendar();
        GregorianCalendar gcInitialReceivingDate = new GregorianCalendar();
        GregorianCalendar gcFinalTransactionDate = new GregorianCalendar();
        GregorianCalendar gcFinalExpirationDate = new GregorianCalendar();
        GregorianCalendar gcFinalDeliveryDate = new GregorianCalendar();
        GregorianCalendar gcFinalReceivingDate = new GregorianCalendar();


        Date dtInitialTransactionDate = this.getClInitialTransactionDate().getSelectedDate();
        Date dtInitialExpirationDate = this.getClInitialExpirationDate().getSelectedDate();
        Date dtInitialDeliveryDate = this.getClInitialDeliveryDate().getSelectedDate();
        Date dtInitialReceivingDate = this.getClInitialReceivingDate().getSelectedDate();
        Date dtFinalTransactionDate = this.getClFinalTransactionDate().getSelectedDate();
        Date dtFinalExpirationDate = this.getClFinalExpirationDate().getSelectedDate();
        Date dtFinalDeliveryDate = this.getClFinalDeliveryDate().getSelectedDate();
        Date dtFinalReceivingDate = this.getClFinalReceivingDate().getSelectedDate();
        
        if(dtInitialTransactionDate!=null) {
            gcInitialTransactionDate.setTime(dtInitialTransactionDate);
            this.getTransactionSessionBean().getSearchDataDTO().setTransactionDate(gcInitialTransactionDate);
        }
        else {
            this.getTransactionSessionBean().getSearchDataDTO().setTransactionDate(null);
        }
        if(dtInitialExpirationDate!=null) {
            gcInitialExpirationDate.setTime(dtInitialExpirationDate);
            this.getTransactionSessionBean().getSearchDataDTO().setExpirationDate(gcInitialExpirationDate);
        }
        else {
            this.getTransactionSessionBean().getSearchDataDTO().setExpirationDate(null);
        }
        if(dtInitialDeliveryDate!=null) {
            gcInitialDeliveryDate.setTime(dtInitialDeliveryDate);
            this.getTransactionSessionBean().getTransactedSpecimenSearchDataDTO().setDeliveryDate(gcInitialDeliveryDate);
        }
        else {
            this.getTransactionSessionBean().getTransactedSpecimenSearchDataDTO().setDeliveryDate(null);
        }
        if(dtInitialReceivingDate!=null) {
            gcInitialReceivingDate.setTime(dtInitialReceivingDate);
            this.getTransactionSessionBean().getTransactedSpecimenSearchDataDTO().setReceivingDate(gcInitialReceivingDate);
        }
        else {
            this.getTransactionSessionBean().getTransactedSpecimenSearchDataDTO().setReceivingDate(null);
        }

        if(dtFinalTransactionDate!=null) {
            gcFinalTransactionDate.setTime(dtFinalTransactionDate);
            this.getTransactionSessionBean().getSearchDataDTO().setFinalTransactionDate(gcFinalTransactionDate);
        }
        else {
            this.getTransactionSessionBean().getSearchDataDTO().setFinalTransactionDate(null);
        }
        if(dtFinalExpirationDate!=null) {
            gcFinalExpirationDate.setTime(dtFinalExpirationDate);
            this.getTransactionSessionBean().getSearchDataDTO().setFinalExpirationDate(gcFinalExpirationDate);
        }
        else {
            this.getTransactionSessionBean().getSearchDataDTO().setFinalExpirationDate(null);
        }
        if(dtFinalDeliveryDate!=null) {
            gcFinalDeliveryDate.setTime(dtFinalDeliveryDate);
            this.getTransactionSessionBean().getTransactedSpecimenSearchDataDTO().setFinalDeliveryDate(gcFinalDeliveryDate);
        }
        else {
            this.getTransactionSessionBean().getTransactedSpecimenSearchDataDTO().setFinalDeliveryDate(null);
        }
        if(dtFinalReceivingDate!=null) {
            gcFinalReceivingDate.setTime(dtFinalReceivingDate);
            this.getTransactionSessionBean().getTransactedSpecimenSearchDataDTO().setFinalReceivingDate(gcFinalReceivingDate);
        }
        else {
            this.getTransactionSessionBean().getTransactedSpecimenSearchDataDTO().setFinalReceivingDate(null);
        }
        this.getTransactionSessionBean().getSearchDataDTO().setCollectionId(this.getAraSessionBean().getGlobalCollectionId());

        //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getTransactionSessionBean().setAdvancedSearch(true);
        //Desabilitar la bandera de busqueda simple
        this.getTransactionSessionBean().setSimpleSearch(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getTransactionSessionBean().getPagination().setTotalResults (this.getTransactionSessionBean().getSearchFacade().
            countTransactionsByCriteria(this.getTransactionSessionBean().getSearchDataDTO(),
                this.getTransactionSessionBean().getTransactedSpecimenSearchDataDTO()).intValue());
        this.getTransactionSessionBean().getPagination().firstResults();
        this.getTxSearch().setValue("");

        return null;
    }

    public String btnTransactionNew_action() {
        //Limpiar el current DTO
        this.getTransactionSessionBean().setCurrentTransaction(new TransactionDTO());
        this.getTransactionSessionBean().setFirstTime(true);
        return "new";
    }

    public String btnTransactionEdit_action() {
        int n = this.getTransactionTable().getRowCount();
        ArrayList<TransactionDTO> selectedTransactions = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getTransactionTable().setRowIndex(i);
            TransactionDTO aux = (TransactionDTO) this.getTransactionTable().getRowData();
            if (aux.isSelected()) {
                selectedTransactions.add(aux);
            }
        }
        if(selectedTransactions == null || selectedTransactions.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedTransactions.size() == 1){ //En caso de que solo se seleccione un elemento
            this.getTransactionSessionBean().setCurrentTransaction(selectedTransactions.get(0));
            
            // Se limpian variables utilizadas en EditTransaction
            this.getTransactionSessionBean().setTransactedSpecimenStatusId(null);
            this.getTransactionSessionBean().setTransactedSpecimenDescription(null);
            this.getTransactionSessionBean().setCurrentTransactedSpecimen(new TransactedSpecimenDTO());
            this.getTransactionSessionBean().setFirstTime(true);
            return "edit";
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    public String btnTransactionDelete_action() {
        int totalTransactions = this.getTransactionTable().getRowCount();
        ArrayList<TransactionDTO> selectedTransactions = new ArrayList();
        for (int i = 0; i < totalTransactions; i++) { //Obtener elementos seleccionados
            this.getTransactionTable().setRowIndex(i);
            TransactionDTO aux = (TransactionDTO) this.getTransactionTable().getRowData();
            if (aux.isSelected()) {
                selectedTransactions.add(aux);
            }
        }
        if(selectedTransactions == null || selectedTransactions.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedTransactions.size() == 1){ //En caso de que solo se seleccione un elemento
            TransactionDTO selected = selectedTransactions.get(0);
            //Mandar a borrar la transaccion
            try{
                this.getTransactionSessionBean().deleteTransaction(selected.getTransactionId());
            }
            catch(Exception e){
                MessageBean.setErrorMessageFromBundle("imposible_to_delete", this.getMyLocale());
                return null;
            }
            //Refrescar la paginacion
            Long collectionId = getAraSessionBean().getGlobalCollectionId();
            this.getTransactionSessionBean().getPagination().setTotalResults(this.getTransactionSessionBean().
                    getTransactionFacade().countTransaction(collectionId).intValue());
            this.getTransactionSessionBean().getPagination().refreshList();
            //Notificar al usuario
            MessageBean.setSuccessMessageFromBundle("delete_success", this.getMyLocale());
            return null;
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    public String btnReturnTransactedSpecimen_action() {
        return "returnSpecimen";
    }
    // </editor-fold>

    /***************************************************************************
     ****************** === DROPDOWN FUNCTIONS === *****************************
     **************************************************************************/
    // <editor-fold defaultstate="collapsed" desc="DROPDOWN FUNCTIONS">

    public Option[] setInstitutionDropDownData(){
        List<InstitutionDTO> institutionDTOList = this.getTransactionSessionBean().
                setInstitutionDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(InstitutionDTO institutionDTO : institutionDTOList){
            option = new Option(institutionDTO.getInstitutionId(), institutionDTO.getInstitutionCode().trim());
            allOptions.add(option);
        }
        option = new Option(new Long(-1)," -- "+BundleHelper.getDefaultBundleValue
                ("no_institution_associated",getMyLocale())+" --");
        allOptions.add(option);
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    public Option[] setSenderPersonDropDownData(){
        TransactionSessionBean tsb = this.getTransactionSessionBean();
        List<PersonDTO> personDTOList =
                tsb.setSenderPersonDropDownData(tsb.getSearchDataDTO().getSenderInstitutionId());
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(PersonDTO personDTO : personDTOList){
            option = new Option(personDTO.getPersonKey(), personDTO.getNaturalLongName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    public Option[] setReceiverPersonDropDownData(){
        TransactionSessionBean tsb = this.getTransactionSessionBean();
        List<PersonDTO> personDTOList =
                tsb.setReceiverPersonDropDownData(tsb.getSearchDataDTO().getReceiverInstitutionId());
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(PersonDTO personDTO : personDTOList){
            option = new Option(personDTO.getPersonKey(), personDTO.getNaturalLongName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Metodo para obtener los datos a mostrar en los drop downs de la
     * ventana de generacion que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    public Option[] getSelectionListDropDownData(Long selectionListEntityId) {

        List<SelectionListDTO> DTOList = this.getTransactionSessionBean().
                getInventoryFacade().
                getAllSelectionListElementsByCollection
                (selectionListEntityId, getAraSessionBean().getGlobalCollectionId());
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null, " -- " + BundleHelper.getDefaultBundleValue
                ("drop_down_default", getMyLocale()) + " --");
        allOptions.add(option);

        //Crear todas las opciones del drop down
        for (SelectionListDTO slDTO : DTOList) {
            option = new Option(slDTO.getValueId(), slDTO.getValueName());
            allOptions.add(option);
        }

        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    public String updateSenderPersonListAction() {
	TransactionSessionBean tsb =
        this.getTransactionSessionBean();

	List<PersonDTO> personList =
              tsb.getTransactionFacade().getPersonsByInstitutionId(tsb.getSearchDataDTO().
              getSenderInstitutionId());
        this.setSenderPersonListOptions(personList);

        return null;
    }

    private void setSenderPersonListOptions(List<PersonDTO> personList) {

         List<Option> list = new ArrayList<Option>();

        for (PersonDTO personDTO : personList) {
                list.add(new Option(personDTO.getPersonKey(), personDTO.getNaturalLongName()));
        }
        this.getSenderPersonData().setOptions(list.toArray(new Option[list.size()]));
    }

    public String updateReceiverPersonListAction() {

	TransactionSessionBean tsb =
        this.getTransactionSessionBean();

	List<PersonDTO> personList =
              tsb.getTransactionFacade().getPersonsByInstitutionId(tsb.getSearchDataDTO().
              getReceiverInstitutionId());
        this.setReceiverPersonListOptions(personList);

        return null;
    }

    private void setReceiverPersonListOptions(List<PersonDTO> personList) {

        List<Option> list = new ArrayList<Option>();

        for (PersonDTO personDTO : personList) {
                list.add(new Option(personDTO.getPersonKey(), personDTO.getNaturalLongName()));
        }
        this.getSenderPersonData().setOptions(list.toArray(new Option[list.size()]));
    }

    /**
     * @return the txCatalogNumber
     */
    public HtmlInputText getTxCatalogNumber() {
        return txCatalogNumber;
    }

    /**
     * @param txCatalogNumber the txCatalogNumber to set
     */
    public void setTxCatalogNumber(HtmlInputText txCatalogNumber) {
        this.txCatalogNumber = txCatalogNumber;
    }

    /**
     * @return the clReceivingDate
     */
    public Calendar getClReceivingDate() {
        return clReceivingDate;
    }

    /**
     * @param clReceivingDate the clReceivingDate to set
     */
    public void setClReceivingDate(Calendar clReceivingDate) {
        this.clReceivingDate = clReceivingDate;
    }

    /**
     * @return the transactedSpecimenStatusData
     */
    public SingleSelectOptionsList getTransactedSpecimenStatusData() {
        return transactedSpecimenStatusData;
    }

    /**
     * @param transactedSpecimenStatusData the transactedSpecimenStatusData to set
     */
    public void setTransactedSpecimenStatusData(SingleSelectOptionsList transactedSpecimenStatusData) {
        this.transactedSpecimenStatusData = transactedSpecimenStatusData;
    }
    // </editor-fold>
}

