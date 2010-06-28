/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.transaction;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.event.ValueChangeEvent;
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
 * @version EditTransaction.java
 * @version Created on Feb 18, 2010, 4:52:59 PM
 * @author echinchilla
 */

public class EditTransaction extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Variables "bindeadas" con interfaz">
    private Calendar clTransactionDate = new Calendar();
    private Calendar clExpirationDate = new Calendar();
    private Calendar clDeliveryDate = new Calendar();
    private Calendar clReceivingDate = new Calendar();
    // </editor-fold>

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

    private SingleSelectOptionsList transactedSpecimenStatusData = new SingleSelectOptionsList();
    // </editor-fold>

    //Para mostrar en el título de la página el número de Transacción
    //que se está modificando
    private Label lbTitle = new Label();
    
    private TabSet tabSet = new TabSet();
    private Tab tabAddTransactedSpecimens = new Tab();

    private HtmlDataTable transactedSpecimensTable = new HtmlDataTable();
    private String quantityTotal = new String();

//    private HiddenField hfIsEnter = new HiddenField();

    private HtmlInputHidden deleteConfirmationText = new HtmlInputHidden();

    private HtmlInputText txCatalogNumber = new HtmlInputText();
    
    private HtmlInputTextarea transactedSpecimenDescription = new HtmlInputTextarea();



    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditTransaction() {
        //txCatalogNumber.addValueChangeListener(this);
        
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
            log("EditTransaction Initialization Failure", e);
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

        if(this.getTransactionSessionBean().getPagination()==null || this.getTransactionSessionBean().isTransactionPaginator()){
            this.getTransactionSessionBean().setTransactionPaginator(false);
            this.getTransactionSessionBean().initDataProvider();
        }

        this.deleteConfirmationText.setValue(BundleHelper.getDefaultBundleValue
                    ("delete_confirmation", this.getMyLocale()));


        
        /*if(this.getTransactionSessionBean().getCurrentTransaction().getTransactionId() == null) {
        //this.getBtnAddSpecimens().setRendered(false);
        this.getTabAddTransactedSpecimens().setDisabled(true);
        this.getTabSet().setSelected("tabTransactionInfo");
        System.out.println("TransactionID == null -> La transaccion no ha sido creada. No se debe habilitar el tab");
        }
        else {
        //this.getBtnAddSpecimens().setRendered(true);
        this.getTabAddTransactedSpecimens().setDisabled(false);
        this.getTabSet().setSelected("tabAddTransactedSpecimen");
        System.out.println("TransactionID != null -> La transaccion ya fue creada. Se debe habilitar el tab");
        System.out.println(this.getTransactionSessionBean().getCurrentTransaction().getTransactionId());
        }*/

        //Para drop down de personas e instituciones
        this.getInstitutionData().setOptions(setInstitutionDropDownData());
        this.getSenderPersonData().setOptions(setSenderPersonDropDownData());
        this.getReceiverPersonData().setOptions(setReceiverPersonDropDownData());
        //Para el DropDown/selectionList
        this.getTransactionTypeData().setOptions(getSelectionListDropDownData
                (SelectionListEntity.TRANSACTION_TYPE.getId()));

        this.getTransactedSpecimenStatusData().setOptions(getSelectionListDropDownData
                (SelectionListEntity.TRANSACTED_SPECIMEN_STATUS.getId()));

        if(this.getTransactionSessionBean().isFirstTime()){
            // Se setea el título de la página con el transactionId
            Long tId = this.getTransactionSessionBean().getCurrentTransaction().
                    getTransactionId();
            getLbTitle().setText(BundleHelper.getDefaultBundleValue
                    ("title_transaction_edit", this.getMyLocale())+"  "+tId);
            //Mostrar datos actuales en la pantalla

            /**
             * Cuando se estaban implementando los dropdown para institution, cuando se hizo
             * para sender institution la siguiente línea de código estaba aquí. Cuando se
             * hace para el receiver institution no funciona más, por lo que se mueven antes del IF
             */
            //this.getSenderInstitutionData().setOptions(setSenderInstitutionDropDownData());
            //this.getReceiverInstitutionData().setOptions(setReceiverInstitutionDropDownData());

            TransactionDTO aux = this.getTransactionSessionBean().getCurrentTransaction();
            
            this.getClTransactionDate().setSelectedDate(aux.getTransactionDate().getTime());
            // <editor-fold defaultstate="collapsed" desc="Borrar">
            //this.getTxInvoiceNumber().setText(aux.getInvoiceNumber());
            //this.getTxEstimatedNumberSpecimens().setText(aux.getEstimatedSpecimenCount());
            // this.getTxDescription().setText(aux.getDescription());// </editor-fold>
            if (aux.getExpirationDate() != null) {
                this.getClExpirationDate().setSelectedDate(aux.getExpirationDate().getTime());
            }
            
            this.getTransactionSessionBean().setFirstTime(false);
        }

        if(this.getTransactionSessionBean().isTransactionJustCreated()) {
            this.getTabSet().setSelected("tabAddTransactedSpecimen");
            this.getTransactionSessionBean().setTransactionJustCreated(false);
            MessageBean.setSuccessMessageFromBundle("create_transaction_succces", this.getMyLocale());
            //System.out.println("<><><><><><><><><><><><><><>Se pone como tab seleccionada la de agregar especímenes\n" +
              //      this.getTabSet().getSelected());
        }

        if(this.getTabSet().getSelected() == null) {
            this.getTabSet().setSelected("tabTransactionInfo");
        }
            
        if(this.getTabSet().getSelected().equals("tabAddTransactedSpecimen")) {
            //System.out.println("Segunda Pestaña");
            this.getTabSet().setStyle("height: 200px; width: 835px");
        }
        else {
            //System.out.println("Primer Pestaña");
            this.getTabSet().setStyle("height: 220px; width: 835px");
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
     *
     * @return reference to the scoped data bean
     */
    protected TransactionSessionBean getTransactionSessionBean() {
        return (TransactionSessionBean) getBean("transaction$TransactionSessionBean");
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
     * Metodo que realiza el update con los nuevos valores.
     * Los datos asociados a un DropDown no se actualizan aqui.
     */
    public String btnUpdateTransaction_action() {

        /*if(this.hfIsEnter.getText().toString().equals("true")) {
        this.hfIsEnter.setText("false");
        return btnAddTransactedSpecimen_action();
        }*/

        GregorianCalendar transactionDateGC = new GregorianCalendar();
        Date transactionDateD = null;//this.getClTransactionDate().getSelectedDate();

        GregorianCalendar expirationDateGC = new GregorianCalendar();
        Date expirationDateD = null;//this.getClExpirationDate().getSelectedDate();

        transactionDateD = this.getClTransactionDate().getSelectedDate();
        expirationDateD = this.getClExpirationDate().getSelectedDate();
        
        TransactionDTO transactionDTO = this.getTransactionSessionBean().getCurrentTransaction();
        if (transactionDateD != null) {
            transactionDateGC.setTime(transactionDateD);
            transactionDTO.setTransactionDate(transactionDateGC);
        }

        if (expirationDateD != null) {
            expirationDateGC.setTime(expirationDateD);
            transactionDTO.setExpirationDate(expirationDateGC);
        }
        else {
            transactionDTO.setExpirationDate(null);
        }

        if (transactionDateD != null && expirationDateD != null) {
            if (transactionDateD.getTime() > expirationDateD.getTime()) {
                MessageBean.setErrorMessageFromBundle("error_transaction_date_expiration_date", this.getMyLocale());
                return null;
            }
        }

        transactionDTO.setUserName(this.getAraSessionBean().getGlobalUserName());

        try {
            if (transactionDateD == null) {
                MessageBean.setErrorMessageFromBundle("error_transaction_date", this.getMyLocale());
                return null;
            }
            else if (transactionDTO.getSenderPersonId() == null) {
                MessageBean.setErrorMessageFromBundle("error_sender_person", this.getMyLocale());
                return null;
            }
            else if (transactionDTO.getTransactionTypeId() == null) {
                MessageBean.setErrorMessageFromBundle("error_transaction_type", this.getMyLocale());
                return null;
            }
            this.getTransactionSessionBean().updateTransaction(transactionDTO);
            this.getTransactionSessionBean().setCurrentTransaction(transactionDTO);
        } catch (Exception e) {
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Refrescar la lista de personas
        this.getTransactionSessionBean().getPagination().refreshList();

        //Notificar al usuario
        MessageBean.setSuccessMessageFromBundle("edit_transaction_succces", this.getMyLocale());

        return null;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    public String btnAddTransactedSpecimen_action() {
        if(this.txCatalogNumber.getValue() != null) {
            GregorianCalendar deliveryDateGC = new GregorianCalendar();
            Date deliveryDateD = null;//this.getClTransactionDate().getSelectedDate();

            GregorianCalendar receivingDateGC = new GregorianCalendar();
            Date recievingDateD = null;//this.getClExpirationDate().getSelectedDate();

            deliveryDateD = this.getClDeliveryDate().getSelectedDate();
            recievingDateD = this.getClReceivingDate().getSelectedDate();

            TransactedSpecimenDTO transactedSpecimenDTO = this.getTransactionSessionBean().getCurrentTransactedSpecimen();
            if (deliveryDateD != null) {
                deliveryDateGC.setTime(deliveryDateD);
                transactedSpecimenDTO.setDeliveryDate(deliveryDateGC);
            }
            
            if (recievingDateD != null) {
                receivingDateGC.setTime(recievingDateD);
                transactedSpecimenDTO.setReceivingDate(receivingDateGC);
            }
            else {
                transactedSpecimenDTO.setReceivingDate(null);
            }
            if (deliveryDateD != null && recievingDateD != null) {
                if (deliveryDateD.getTime() > recievingDateD.getTime()) {
                    MessageBean.setErrorMessageFromBundle("error_delivery_date_receiving_date", this.getMyLocale());
                    return null;
                }
            }

            transactedSpecimenDTO.setCatalogNumber(this.txCatalogNumber.getValue().toString().trim());
            try {
                if (transactedSpecimenDTO.getCatalogNumber() == null) {
                    MessageBean.setErrorMessageFromBundle("error_catalog_number", this.getMyLocale());
                    return null;
                }
                else if (deliveryDateD == null) {
                    MessageBean.setErrorMessageFromBundle("error_delivery_date", this.getMyLocale());
                    return null;
                }
                else if (this.getTransactionSessionBean().getTransactedSpecimenStatusId() == null) {
                    MessageBean.setErrorMessageFromBundle("error_transacted_specimen_status", this.getMyLocale());
                    return null;
                }
                
                TransactedSpecimenDTO tsDTO = this.getTransactionSessionBean().saveTransactedSpecimen();
                if (tsDTO==null) {
                    MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
                    return null;
                }
            }
            catch (Exception e){
                MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
                    return null;
            }

            MessageBean.setSuccessMessageFromBundle("add_transacted_specimen_succces", this.getMyLocale());

            //Refrescar la lista de transacciones
            this.getTransactionSessionBean().getPagination().addItem();
            this.getTransactionSessionBean().getPagination().refreshList();
            this.txCatalogNumber.setValue(null);
        }
        else {
            MessageBean.setErrorMessageFromBundle("missing_catalog_number", this.getMyLocale());
        }
        return null;
    }

    public String btnTransactedSpecimenDelete_action() {
        int totalTransactedSpecimens = this.getTransactedSpecimensTable().getRowCount();
        ArrayList<TransactedSpecimenDTO> selectedTransactedSpecimens = new ArrayList();
        for (int i = 0; i < totalTransactedSpecimens; i++) { //Obtener elementos seleccionados
            this.getTransactedSpecimensTable().setRowIndex(i);
            TransactedSpecimenDTO aux = (TransactedSpecimenDTO) this.getTransactedSpecimensTable().getRowData();
            if (aux.isSelected()) {
                selectedTransactedSpecimens.add(aux);
            }
        }
        if(selectedTransactedSpecimens == null || selectedTransactedSpecimens.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else { //En caso de que solo se seleccione un elemento
            //TransactionDTO selected = selectedTransactedSpecimens.get(0);
            //Mandar a borrar la transaccion
            try{
                
                /**
                 * Aquí probablemente es mejor enviar un ArrayList de Long con los ID's y no todo el DTO.
                 */
                this.getTransactionSessionBean().deleteTransactedSpecimens(selectedTransactedSpecimens);
            }
            catch(Exception e){
                MessageBean.setErrorMessageFromBundle("imposible_to_delete", this.getMyLocale());
                return null;
            }
            //Refrescar la lista de audiencias
            for (int i = 0; i < selectedTransactedSpecimens.size(); i++)
                this.getTransactionSessionBean().getPagination().deleteItem();
            this.getTransactionSessionBean().getPagination().refreshList();
            //Notificar al usuario
            MessageBean.setSuccessMessageFromBundle("delete_success", this.getMyLocale());
            return null;
        }
    }

    public String btnTransactedSpecimenEdit_action() {
        GregorianCalendar deliveryDateGC = new GregorianCalendar();
        Date deliveryDateD = null;//this.getClTransactionDate().getSelectedDate();

        GregorianCalendar receivingDateGC = new GregorianCalendar();
        Date recievingDateD = null;//this.getClExpirationDate().getSelectedDate();

        deliveryDateD = this.getClDeliveryDate().getSelectedDate();
        recievingDateD = this.getClReceivingDate().getSelectedDate();

        TransactedSpecimenDTO transactedSpecimenDTO = this.getTransactionSessionBean().getCurrentTransactedSpecimen();
        if (deliveryDateD != null) {
            deliveryDateGC.setTime(deliveryDateD);
            transactedSpecimenDTO.setDeliveryDate(deliveryDateGC);
        }

        if (recievingDateD != null) {
            receivingDateGC.setTime(recievingDateD);
            transactedSpecimenDTO.setReceivingDate(receivingDateGC);
        }
        else {
            transactedSpecimenDTO.setReceivingDate(null);
        }
        if (deliveryDateD != null && recievingDateD != null) {
            if (deliveryDateD.getTime() > recievingDateD.getTime()) {
                MessageBean.setErrorMessageFromBundle("error_delivery_date_receiving_date", this.getMyLocale());
                return null;
            }
        }


        transactedSpecimenDTO.setDescription(this.getTransactionSessionBean().getTransactedSpecimenDescription());
        transactedSpecimenDTO.setTransactedSpecimenStatusId(this.getTransactionSessionBean().getTransactedSpecimenStatusId());

        int totalTransactedSpecimens = this.getTransactedSpecimensTable().getRowCount();
        ArrayList<TransactedSpecimenDTO> selectedTransactedSpecimens = new ArrayList();
        for (int i = 0; i < totalTransactedSpecimens; i++) { //Obtener elementos seleccionados
            this.getTransactedSpecimensTable().setRowIndex(i);
            TransactedSpecimenDTO aux = (TransactedSpecimenDTO) this.getTransactedSpecimensTable().getRowData();
            if (aux.isSelected()) {
                selectedTransactedSpecimens.add(aux);
            }
        }
        if(selectedTransactedSpecimens == null || selectedTransactedSpecimens.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else { //En caso de que solo se seleccione un elemento
            //TransactionDTO selected = selectedTransactedSpecimens.get(0);
            //Mandar a borrar la transaccion
            try{
                //this.getTransactionSessionBean().deleteTransaction(selected.getTransactionId());
                this.getTransactionSessionBean().editTransactedSpecimens(selectedTransactedSpecimens, transactedSpecimenDTO);
            }
            catch(Exception e){
                MessageBean.setErrorMessageFromBundle("imposible_to_edit", this.getMyLocale());
                return null;
            }
            //Refrescar la lista de audiencias
            
            this.getTransactionSessionBean().getPagination().refreshList();
            //Notificar al usuario
            MessageBean.setSuccessMessageFromBundle("edit_success", this.getMyLocale());
            return null;
        }
    }

    /**
     * Metodo para mostrar u ocultar el campo de descripcion.
     * @return
     */
    public String cbDescription_change() {
        //return null;
        System.out.println("Checkbox");
        return null;
    }

    /**
     * Metodo para obtener los datos a mostrar en los drop downs de la
     * ventana de generacion que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    public Option[] getSelectionListDropDownData(Long selectionListEntityId) {

        //getAllSelectionListElementsByCollection
        List<SelectionListDTO> DTOList = this.getTransactionSessionBean().
                //getTransactionFacade().
                getInventoryFacade().
                getAllSelectionListElementsByCollection
                (selectionListEntityId, getAraSessionBean().getGlobalCollectionId());
        /*List<SelectionListDTO> DTOList = this.getPassportSessionBean().
                getGermoplasmaFacadeRemote().getElementsForSelectionList(selectionListEntityId);*/


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

    /**
     * @return the clTransactionDate
     */
    public Calendar getClTransactionDate() {
        return clTransactionDate;
    }

    /**
     * @param clTransactionDate the clTransactionDate to set
     */
    public void setClTransactionDate(Calendar clTransactionDate) {
        this.clTransactionDate = clTransactionDate;
    }

    /**
     * @return the clExpirationDate
     */
    public Calendar getClExpirationDate() {
        return clExpirationDate;
    }

    /**
     * @param clExpirationDate the clExpirationDate to set
     */
    public void setClExpirationDate(Calendar clExpirationDate) {
        this.clExpirationDate = clExpirationDate;
    }

    /**
     * @return the clDeliveryDate
     */
    public Calendar getClDeliveryDate() {
        return clDeliveryDate;
    }

    /**
     * @param clDeliveryDate the clDeliveryDate to set
     */
    public void setClDeliveryDate(Calendar clDeliveryDate) {
        this.clDeliveryDate = clDeliveryDate;
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

    /**
     * @return the lbTitle
     */
    public Label getLbTitle() {
        return lbTitle;
    }

    /**
     * @param lbTitle the lbTitle to set
     */
    public void setLbTitle(Label lbTitle) {
        this.lbTitle = lbTitle;
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
                tsb.setSenderPersonDropDownData(tsb.getCurrentTransaction().getSenderInstitutionId());
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
                tsb.setReceiverPersonDropDownData(tsb.getCurrentTransaction().getReceiverInstitutionId());
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


    public String updateSenderPersonListAction() {

	TransactionSessionBean tsb =
        this.getTransactionSessionBean();

	List<PersonDTO> personList =
            //tsb.getInventoryFacade().getInstitutionsByPersonId(tsb.getCurrentTransaction().
            //getSenderPersonId());
              tsb.getTransactionFacade().getPersonsByInstitutionId(tsb.getCurrentTransaction().
              getSenderInstitutionId());
        //tsb.getAllTaxonByTaxonomicalRange(tsb.getSelectedTaxonomicLevel());
        this.setSenderPersonListOptions(personList);

        return null;
    }

    private void setSenderPersonListOptions(List<PersonDTO> personList) {

         List<Option> list = new ArrayList<Option>();

        for (PersonDTO personDTO : personList) {
                list.add(new Option(personDTO.getPersonKey(), personDTO.getNaturalLongName()));
        }

        //tsb.getArTaxonList().setAvailableOptions(list.toArray(new Option[list.size()]));
        this.getSenderPersonData().setOptions(list.toArray(new Option[list.size()]));
    }

    public String updateReceiverPersonListAction() {

	TransactionSessionBean tsb =
        this.getTransactionSessionBean();

	List<PersonDTO> personList =
            //tsb.getInventoryFacade().getInstitutionsByPersonId(tsb.getCurrentTransaction().
            //getReceiverPersonId());
              tsb.getTransactionFacade().getPersonsByInstitutionId(tsb.getCurrentTransaction().
              getReceiverInstitutionId());
        //tsb.getAllTaxonByTaxonomicalRange(tsb.getSelectedTaxonomicLevel());
        this.setReceiverPersonListOptions(personList);

        return null;
    }

    private void setReceiverPersonListOptions(List<PersonDTO> personList) {

        List<Option> list = new ArrayList<Option>();

        for (PersonDTO personDTO : personList) {
                list.add(new Option(personDTO.getPersonKey(), personDTO.getNaturalLongName()));
        }

        //tsb.getArTaxonList().setAvailableOptions(list.toArray(new Option[list.size()]));
        this.getSenderPersonData().setOptions(list.toArray(new Option[list.size()]));
    }

    /**
     * @return the tabSet
     */
    public TabSet getTabSet() {
        return tabSet;
    }

    /**
     * @param tabSet the tabSet to set
     */
    public void setTabSet(TabSet tabSet) {
        this.tabSet = tabSet;
    }

    /**
     * @return the tabAddTransactedSpecimens
     */
    public Tab getTabAddTransactedSpecimens() {
        return tabAddTransactedSpecimens;
    }

    /**
     * @param tabAddTransactedSpecimens the tabAddTransactedSpecimens to set
     */
    public void setTabAddTransactedSpecimens(Tab tabAddTransactedSpecimens) {
        this.tabAddTransactedSpecimens = tabAddTransactedSpecimens;
    }

    /**
     * @return the transactedSpecimensTable
     */
    public HtmlDataTable getTransactedSpecimensTable() {
        return transactedSpecimensTable;
    }

    /**
     * @param transactedSpecimensTable the transactedSpecimensTable to set
     */
    public void setTransactedSpecimensTable(HtmlDataTable transactedSpecimensTable) {
        this.transactedSpecimensTable = transactedSpecimensTable;
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
     * @return the transactedSpecimenDescription
     */
    public HtmlInputTextarea getTransactedSpecimenDescription() {
        return transactedSpecimenDescription;
    }

    /**
     * @param transactedSpecimenDescription the transactedSpecimenDescription to set
     */
    public void setTransactedSpecimenDescription(HtmlInputTextarea transactedSpecimenDescription) {
        this.transactedSpecimenDescription = transactedSpecimenDescription;
    }

}
