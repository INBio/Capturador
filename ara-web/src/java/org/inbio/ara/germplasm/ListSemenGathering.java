/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.dto.germplasm.SemenGatheringDTO;
import org.inbio.ara.util.MessageBean;
import java.util.Locale;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.util.BundleHelper;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListSemenGathering.java
 * @version Created on 08/04/2010, 09:51:29 AM
 * @author dasolano
 */

public class ListSemenGathering extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private String quantityTotal = new String();

    private HtmlDataTable dataTableSemenGathering = new HtmlDataTable();

    private HtmlPanelGrid alertMessage = new HtmlPanelGrid();
    private HtmlPanelGrid mainPanel = new HtmlPanelGrid();

    /*Componentes para las busquedas*/
    private HtmlInputText txSimpleSearch = new HtmlInputText(); //Input text de busqueda simple
    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();
    private HtmlCommandButton btnSimpleSearch = new HtmlCommandButton(); //Boton busqueda simple
    private HtmlCommandButton btnAdvSearch = new HtmlCommandButton(); //Boton busqueda avanzada


    //componentes para busuqedas avanzadas
    private SingleSelectOptionsList hourDropDown = new SingleSelectOptionsList();
    private SingleSelectOptionsList minutesDropDown = new SingleSelectOptionsList();




    private Calendar initialGatheringDate = new Calendar();
    private Calendar finalGatheringDate = new Calendar();

    private Label lbTitle = new Label();
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListSemenGathering() {
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
            log("ListSemenGathering Initialization Failure", e);
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

        if(getgermplasm$SemenGatheringSessionBean().getSementalId() != null)
            getLbTitle().setText(BundleHelper.getDefaultBundleValue("semen_gathering", this.getMyLocale()) + "  " +
                    getgermplasm$SementalSessionBean().getSementalDTO().getAnimalCode() + " | " +
                    BundleHelper.getDefaultBundleValue("cumulative_straw_quantity", this.getMyLocale()) + " " +
                    + getgermplasm$SemenGatheringSessionBean().getGermplasmFacadeRemote().
                    cumulativeStrawQuantity(getgermplasm$SemenGatheringSessionBean().getSementalId()));

        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(getgermplasm$SemenGatheringSessionBean().isAdvancedSearch()){
            hourDropDown.setOptions(getHourDropDownData());
            minutesDropDown.setOptions(getMinutesDropDownData());
            this.getGridpAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
        }
        //Inicializar el dataprovider si la paginacion es nula y no es filtrado por busquedas
        else if (getgermplasm$SemenGatheringSessionBean().getPagination()==null) {

            getgermplasm$SemenGatheringSessionBean().initDataProvider();
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
    protected AccessionSessionBean getgermplasm$AccessionSessionBean() {
        return (AccessionSessionBean) getBean("germplasm$AccessionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SelectionListSessionBean getadmin$SelectionListSessionBean() {
        return (SelectionListSessionBean) getBean("admin$SelectionListSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PersonSessionBean getadmin$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$PersonSessionBean");
    }

    protected SemenGatheringSessionBean getgermplasm$SemenGatheringSessionBean() {
        return (SemenGatheringSessionBean) getBean("germplasm$SemenGatheringSessionBean");
    }

    protected SementalSessionBean getgermplasm$SementalSessionBean() {
        return (SementalSessionBean) getBean("germplasm$SementalSessionBean");
    }

    /**
     * Redirect to NewSemenGathering.jsp
     * @return
     */
    public String btn_new_action()
    {
        getgermplasm$SemenGatheringSessionBean().resetValues();
        return "new";
    }

    /**
     * Redirect to EditSemenGathering.jsp
     * @return
     */
    public String btn_edit_action()
    {
        int n = this.getDataTableSemenGathering().getRowCount();
        ArrayList<SemenGatheringDTO> selected = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableSemenGathering().setRowIndex(i);
            SemenGatheringDTO aux = (SemenGatheringDTO) this.
                    getDataTableSemenGathering().getRowData();
            if (aux.isSelected()) {
                selected.add(aux);
            }
        }
        if(selected == null || selected.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selected.size() == 1){ //En caso de que solo se seleccione un elemento


            getgermplasm$SemenGatheringSessionBean().setSemenGatheringDTO(selected.get(0));

            //Llamada al jsp encargado de la edicion de accessiones
            return "edit";

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Choose the selected semenGathering and delete it
     * @return
     */
    public String btn_delete_action()
    {
        int n = this.getDataTableSemenGathering().getRowCount();
        ArrayList<SemenGatheringDTO> selected = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableSemenGathering().setRowIndex(i);
            SemenGatheringDTO aux = (SemenGatheringDTO) this.
                    getDataTableSemenGathering().getRowData();
            if (aux.isSelected()) {
                selected.add(aux);
            }
        }
        if(selected == null || selected.size() == 0)
        {
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selected.size() == 1)
        { //En caso de que solo se seleccione un elemento

            //delete the semen gathering
            getgermplasm$SemenGatheringSessionBean().getGermplasmFacadeRemote().
                    deleteSemenGathering(selected.get(0).getSemenGatheringId());
            //refresh the list
            getgermplasm$SemenGatheringSessionBean().getPagination().deleteItem();
            getgermplasm$SemenGatheringSessionBean().getPagination().refreshList();

            MessageBean.setSuccessMessageFromBundle("delete_semen_gathering_success", this.getMyLocale());
            return null;
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    public String btn_view_action()
    {
        return "view";
    }

    /**
     * Performed the simple search for semen gathering
     * @return
     */
   public String btnSimpleSearch_action()
    {
        String userInput = "";
        if(this.getTxSimpleSearch().getValue()!= null)
            userInput = this.getTxSimpleSearch().getValue().toString();
        userInput = userInput.trim();
        System.out.println(1);
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getgermplasm$SemenGatheringSessionBean().setQueryModeSimple(false);
            this.getgermplasm$SemenGatheringSessionBean().setQueryMode(false);
            //Finalmente se setea el data provider del paginador con los datos por default
            this.getgermplasm$SemenGatheringSessionBean().getPagination().setTotalResults
                    (getgermplasm$SemenGatheringSessionBean().getGermplasmFacadeRemote().
                    countAllSemenGathering(getgermplasm$SemenGatheringSessionBean().getSementalId()).intValue());
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.getgermplasm$SemenGatheringSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getgermplasm$SemenGatheringSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getgermplasm$SemenGatheringSessionBean().setQueryMode(false);
            //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
            this.getgermplasm$SemenGatheringSessionBean().getPagination().setTotalResults
                    (getgermplasm$SemenGatheringSessionBean().getGermplasmFacadeRemote().
                    countSemenGatheringSimpleSearch(userInput,
                    getgermplasm$SemenGatheringSessionBean().getSementalId()).intValue());
        }
        //set the first result of the query
        this.getgermplasm$SemenGatheringSessionBean().getPagination().firstResults();
        return null;
    }

   /**
    * Display the advance search options
    * @return
    */
    public String btnAdvSearch_action()
    {
        boolean advanced = getgermplasm$SemenGatheringSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            getgermplasm$SemenGatheringSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSimpleSearch().setRendered(false);
            this.getBtnSimpleSearch().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getgermplasm$SemenGatheringSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSimpleSearch().setRendered(true);
            this.getBtnSimpleSearch().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search",getMyLocale()));

            //Reestablecer los valores por defecto de los textfields
            getgermplasm$SemenGatheringSessionBean().setQuerySemenGatheringDTO(new SemenGatheringDTO());
        }
        return null;
    }

    /**
     * Performed the advance search
     * @return
     */
    public String btnAdvSearchSemenGathering_action()
    {
        getgermplasm$SemenGatheringSessionBean().getSemenGatheringDTO().setUserName(getAraSessionBean().getGlobalUserName());


        //Set the date
        GregorianCalendar semenGatheringDateGC = new GregorianCalendar();
        Date semenGatheringDate = this.getInitialGatheringDate().getSelectedDate();

        if (semenGatheringDate != null)
        {
            semenGatheringDateGC.setTime(semenGatheringDate);
            getgermplasm$SemenGatheringSessionBean().getQuerySemenGatheringDTO().
                    setSemenGatheringDate(semenGatheringDateGC);
        }

        //Set the date
        GregorianCalendar semenGatheringDateGCfinal = new GregorianCalendar();
        Date semenGatheringDatefinal = this.getFinalGatheringDate().getSelectedDate();

        if (semenGatheringDatefinal != null)
        {
            semenGatheringDateGCfinal.setTime(semenGatheringDatefinal);
            getgermplasm$SemenGatheringSessionBean().getQuerySemenGatheringDTO().
                    setFinalSemenGatheringDate(semenGatheringDateGCfinal);
        }
        


        //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getgermplasm$SemenGatheringSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getgermplasm$SemenGatheringSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getgermplasm$SemenGatheringSessionBean().getPagination().setTotalResults(
                this.getgermplasm$SemenGatheringSessionBean().
                getGermplasmFacadeRemote().
                countSemenGatheringAdvancedSearch(
                getgermplasm$SemenGatheringSessionBean().
                getQuerySemenGatheringDTO(),
                getgermplasm$SemenGatheringSessionBean().getSementalId()).intValue());

        this.getgermplasm$SemenGatheringSessionBean().getPagination().firstResults();
        this.getgermplasm$SemenGatheringSessionBean().getPagination().refreshList();

        this.getTxSimpleSearch().setValue("");

        return null;
    }

    /**
     * Fill the options for the hour drop down
     * @return
     */
    public Option[] getHourDropDownData()
    {
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null, " -- ");
        allOptions.add(option);

        option = new Option(0L, "00");
        allOptions.add(option);
        option = new Option(1L, "01");
        allOptions.add(option);
        option = new Option(2L, "02");
        allOptions.add(option);
        option = new Option(3L, "03");
        allOptions.add(option);
        option = new Option(4L, "04");
        allOptions.add(option);
        option = new Option(5L, "05");
        allOptions.add(option);
        option = new Option(6L, "06");
        allOptions.add(option);
        option = new Option(7L, "07");
        allOptions.add(option);
        option = new Option(8L, "08");
        allOptions.add(option);
        option = new Option(9L, "09");
        allOptions.add(option);

        for(int i = 10; i <= 23; i ++)
        {
            option = new Option(new Long(i), Integer.toString(i));
            allOptions.add(option);
        }


        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Fill the options for the minutes drop down
     * @return
     */
    public Option[] getMinutesDropDownData()
    {
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null, " -- ");
        allOptions.add(option);


        option = new Option(0L, "00");
        allOptions.add(option);
        option = new Option(1L, "01");
        allOptions.add(option);
        option = new Option(2L, "02");
        allOptions.add(option);
        option = new Option(3L, "03");
        allOptions.add(option);
        option = new Option(4L, "04");
        allOptions.add(option);
        option = new Option(5L, "05");
        allOptions.add(option);
        option = new Option(6L, "06");
        allOptions.add(option);
        option = new Option(7L, "07");
        allOptions.add(option);
        option = new Option(8L, "08");
        allOptions.add(option);
        option = new Option(9L, "09");
        allOptions.add(option);

        for(int i = 10; i <=59; i ++)
        {
            option = new Option(new Long(i), Integer.toString(i));
            allOptions.add(option);
        }


        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }
    
    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
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
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal = this.getgermplasm$SemenGatheringSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }


    /**
     * @return the gridpAdvancedSearch
     */
    public HtmlPanelGrid getGridpAdvancedSearch() {
        return gridpAdvancedSearch;
    }

    /**
     * @param gridpAdvancedSearch the gridpAdvancedSearch to set
     */
    public void setGridpAdvancedSearch(HtmlPanelGrid gridpAdvancedSearch) {
        this.gridpAdvancedSearch = gridpAdvancedSearch;
    }

    /**
     * @return the dataTableSemenGathering
     */
    public HtmlDataTable getDataTableSemenGathering() {
        return dataTableSemenGathering;
    }

    /**
     * @param dataTableSemenGathering the dataTableSemenGathering to set
     */
    public void setDataTableSemenGathering(HtmlDataTable dataTableSemenGathering) {
        this.dataTableSemenGathering = dataTableSemenGathering;
    }

    /**
     * @return the alertMessage
     */
    public HtmlPanelGrid getAlertMessage() {
        return alertMessage;
    }

    /**
     * @param alertMessage the alertMessage to set
     */
    public void setAlertMessage(HtmlPanelGrid alertMessage) {
        this.alertMessage = alertMessage;
    }

    /**
     * @return the mainPanel
     */
    public HtmlPanelGrid getMainPanel() {
        return mainPanel;
    }

    /**
     * @param mainPanel the mainPanel to set
     */
    public void setMainPanel(HtmlPanelGrid mainPanel) {
        this.mainPanel = mainPanel;
    }

    /**
     * @return the txSimpleSearch
     */
    public HtmlInputText getTxSimpleSearch() {
        return txSimpleSearch;
    }

    /**
     * @param txSimpleSearch the txSimpleSearch to set
     */
    public void setTxSimpleSearch(HtmlInputText txSimpleSearch) {
        this.txSimpleSearch = txSimpleSearch;
    }

    /**
     * @return the btnSimpleSearch
     */
    public HtmlCommandButton getBtnSimpleSearch() {
        return btnSimpleSearch;
    }

    /**
     * @param btnSimpleSearch the btnSimpleSearch to set
     */
    public void setBtnSimpleSearch(HtmlCommandButton btnSimpleSearch) {
        this.btnSimpleSearch = btnSimpleSearch;
    }

    /**
     * @return the btnAdvSearch
     */
    public HtmlCommandButton getBtnAdvSearch() {
        return btnAdvSearch;
    }

    /**
     * @param btnAdvSearch the btnAdvSearch to set
     */
    public void setBtnAdvSearch(HtmlCommandButton btnAdvSearch) {
        this.btnAdvSearch = btnAdvSearch;
    }

    /**
     * @return the hourDropDown
     */
    public SingleSelectOptionsList getHourDropDown() {
        return hourDropDown;
    }

    /**
     * @param hourDropDown the hourDropDown to set
     */
    public void setHourDropDown(SingleSelectOptionsList hourDropDown) {
        this.hourDropDown = hourDropDown;
    }

    /**
     * @return the minutesDropDown
     */
    public SingleSelectOptionsList getMinutesDropDown() {
        return minutesDropDown;
    }

    /**
     * @param minutesDropDown the minutesDropDown to set
     */
    public void setMinutesDropDown(SingleSelectOptionsList minutesDropDown) {
        this.minutesDropDown = minutesDropDown;
    }

    /**
     * @return the initialGatheringDate
     */
    public Calendar getInitialGatheringDate() {
        return initialGatheringDate;
    }

    /**
     * @param initialGatheringDate the initialGatheringDate to set
     */
    public void setInitialGatheringDate(Calendar initialGatheringDate) {
        this.initialGatheringDate = initialGatheringDate;
    }

    /**
     * @return the finalGatheringDate
     */
    public Calendar getFinalGatheringDate() {
        return finalGatheringDate;
    }

    /**
     * @param finalGatheringDate the finalGatheringDate to set
     */
    public void setFinalGatheringDate(Calendar finalGatheringDate) {
        this.finalGatheringDate = finalGatheringDate;
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

   

}

