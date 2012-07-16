/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.TextField;
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
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.admin.AdminGeographicLayersSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.reports.SnapshotSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.gis.MapController;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.admin.InstitutionSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.germplasm.PassportDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListPassport.java
 * @version Created on 09/02/2010, 09:49:31 AM
 * @author dasolano
 */

public class ListPassport extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();
    //Data table binding para la tabla que muetra los passport
    private HtmlDataTable dataTablePassport = new HtmlDataTable();

    private HtmlPanelGrid alertMessage = new HtmlPanelGrid();
    private HtmlPanelGrid mainPanel = new HtmlPanelGrid();

    /*Componentes para las busquedas*/
    private HtmlInputText txSearch = new HtmlInputText(); //Input text de busqueda simple
    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();
    private HtmlCommandButton btnSearch = new HtmlCommandButton(); //Boton busqueda simple
    private HtmlCommandButton btnAdvSearch = new HtmlCommandButton(); //Boton busqueda avanzada

    //componentes para busuqedas avanzadas
    private TextField textfieldGatheringId = new TextField();
    private TextField textfieldPassportId = new TextField();
    private Calendar plantNurseryDate = new Calendar();
    private Calendar plantingSeasonDate = new Calendar();
    private Calendar harvestingSeasonDate = new Calendar();
    private SingleSelectOptionsList donorPersons = new SingleSelectOptionsList();
    private SingleSelectOptionsList donorInstitutions = new SingleSelectOptionsList();
    private SingleSelectOptionsList materialTypes = new SingleSelectOptionsList();
    private SingleSelectOptionsList sampleStatus = new SingleSelectOptionsList();


    

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListPassport() {
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
            log("ListPassport Initialization Failure", e);
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

        this.donorPersons.setOptions(SetResponsibleDropDownData());
        this.donorInstitutions.setOptions(SetInstitutionDropDownData());
        this.materialTypes.setOptions(getSelectionListDropDownData
                (SelectionListEntity.MATERIAL_TYPE.getId()));
        this.sampleStatus.setOptions(getSelectionListDropDownData
                (SelectionListEntity.SAMPLE_STATUS.getId()));
        
        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(getPassportListSessionBean().isAdvancedSearch()){
            this.getGridpAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
        }

        if (getPassportListSessionBean().getPagination()==null) {
            getPassportListSessionBean().initDataProvider();
        }
        //Actualizar los datos del paginador
        else
            getPassportListSessionBean().getPagination().refreshList();
    }

    /**
     * Metodo para obtener los datos a mostrar en los drop downs de la
     * ventana de generacion que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    public Option[] getSelectionListDropDownData(Long selectionListEntityId) {

        //getAllSelectionListElementsByCollection
        List<SelectionListDTO> DTOList = this.getPassportSessionBean().
                getInventoryFacadeRemote().
                getAllSelectionListElementsByCollection
                (selectionListEntityId, getAraSessionBean().getGlobalCollectionId());
        /*List<SelectionListDTO> DTOList = this.getPassportSessionBean().
                getGermplasmFacadeRemote().getElementsForSelectionList(selectionListEntityId);*/


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
     * Obtener los datos del drop down de Instituciones
     */
    public Option[] SetInstitutionDropDownData(){
        List<InstitutionDTO> instDTOList = this.getadmin$AudienceSessionBean().getAdminFacade().getAllInstitutions();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(InstitutionDTO instDTO : instDTOList){
            option = new Option(instDTO.getInstitutionId(), instDTO.getInstitutionName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    
    /**
     * Obtener los datos del drop down de responsables
     */
    public Option[] SetResponsibleDropDownData(){
        List<PersonDTO> personDTOList = this.getPassportSessionBean().
                getGermplasmFacadeRemote().getDonorPersons();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(PersonDTO perDTO : personDTOList){

            option = new Option(perDTO.getPersonKey(), perDTO.getNaturalLongName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }
    

    /**
     * Metodo ejecutado por el boton de busqueda simple
     * @return
     */
    public String btnPassportSearch_action() {
        String userInput = "";
        if(this.getTxSearch().getValue()!= null)
            userInput = this.getTxSearch().getValue().toString();
        userInput = userInput.trim();
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getPassportListSessionBean().setQueryModeSimple(false);
            this.getPassportListSessionBean().setQueryMode(false);
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.getPassportListSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getPassportListSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getPassportListSessionBean().setQueryMode(false);
        }
        //set the first result of the query
        this.getPassportListSessionBean().getPagination().firstResults();
        return null;
    }

    /**
     * Metodo ejecutado por el boton de proceder con la busqueda avanzada
     * este boton es el que esta dentro del panel de busqueda avanzada
     * @return
     */
    public String btnAdvSearchPassport_action() {


        PassportDTO passportDTO = getPassportListSessionBean().getQueryPassportDTO();


        GregorianCalendar plantNurseryDateGC = new GregorianCalendar();
        GregorianCalendar plantationDateGC = new GregorianCalendar();
        GregorianCalendar harvestingDateGC = new GregorianCalendar();

        Date plantNurseryDateD = this.getPlantNurseryDate().getSelectedDate();
        Date plantationDateD = this.getPlantingSeasonDate().getSelectedDate();
        Date harvestingDateD = this.getHarvestingSeasonDate().getSelectedDate();


        if (plantNurseryDateD != null) {
            plantNurseryDateGC.setTime(plantNurseryDateD);
            passportDTO.setPlantNurseryDate(plantNurseryDateGC);
        }
        if (plantationDateD != null) {
            plantationDateGC.setTime(plantationDateD);
            passportDTO.setPlantingSeasonDate(plantationDateGC);
        }
        if (harvestingDateD != null) {
            harvestingDateGC.setTime(harvestingDateD);
            passportDTO.setHarvestingSeasonDate(harvestingDateGC);
        }

        //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getPassportListSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getPassportListSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getPassportListSessionBean().getPagination().firstResults();
        this.getTxSearch().setValue("");

        return null;
    }

    /**
     * Metodo ejecutado por el boton que muestra el panel de busqueda avanzada
     * Su funcion es mostrar y esconder dicho panel
     * @return
     */
    public String btnAdvPassportSearch_action() {
        boolean advanced = getPassportListSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            getPassportListSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearch().setRendered(false);
            this.getBtnSearch().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getPassportListSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearch().setRendered(true);
            this.getBtnSearch().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search",getMyLocale()));
            
            //Reestablecer los valores por defecto de los textfields
            getPassportListSessionBean().setQueryPassportDTO(new PassportDTO());
            this.getPlantNurseryDate().setText(null);
            this.getPlantingSeasonDate().setText(null);
            this.getHarvestingSeasonDate().setText(null);
        }
        return null;
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
    protected AudienceSessionBean getadmin$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("admin$AudienceSessionBean");
    }

    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringDetailSessionBean getinventory$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("inventory$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AdminGeographicLayersSessionBean getadmin$AdminGeographicLayersSessionBean() {
        return (AdminGeographicLayersSessionBean) getBean("admin$AdminGeographicLayersSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ProfileSessionBean getadmin$ProfileSessionBean() {
        return (ProfileSessionBean) getBean("admin$ProfileSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IdentificationSessionBean getinventory$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("inventory$IdentificationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
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
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SnapshotSessionBean getreports$SnapshotSessionBean() {
        return (SnapshotSessionBean) getBean("reports$SnapshotSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringSessionBean getinventory$GatheringSessionBean() {
        return (GatheringSessionBean) getBean("inventory$GatheringSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MapController getgis$MapController() {
        return (MapController) getBean("gis$MapController");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PersonSessionBean getadmin$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected InstitutionSessionBean getadmin$InstitutionSessionBean() {
        return (InstitutionSessionBean) getBean("admin$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PassportSessionBean getPassportSessionBean() {
        return (PassportSessionBean) getBean("germplasm$PassportSessionBean");
    }


    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PassportListSessionBean getPassportListSessionBean() {
        return (PassportListSessionBean) getBean("germplasm$PassportListSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AccessionSessionBean getAccessionListSessionBean() {
        return (AccessionSessionBean) getBean("germplasm$AccessionSessionBean");
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal= this.getPassportListSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the dataTablePassport
     */
    public HtmlDataTable getDataTablePassport() {
        return dataTablePassport;
    }

    /**
     * @param dataTablePassport the dataTablePassport to set
     */
    public void setDataTablePassport(HtmlDataTable dataTablePassport) {
        this.dataTablePassport = dataTablePassport;
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
     * Redirect to New Passport
     * @return
     */
    public String btn_new_action() {
        getPassportSessionBean().resetValues();
        return "new";
    }



    public String btn_edit_action(){
        int n = this.getDataTablePassport().getRowCount();
        ArrayList<PassportDTO> selectedPassport = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTablePassport().setRowIndex(i);
            PassportDTO aux = (PassportDTO) this.
                    getDataTablePassport().getRowData();
            if (aux.isSelected()) {
                selectedPassport.add(aux);
            }
        }
        if(selectedPassport == null || selectedPassport.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedPassport.size() == 1){ //En caso de que solo se seleccione un elemento

            //reset values
            getPassportSessionBean().resetValues();
            //set the passportDTO
            getPassportSessionBean().setPassportDTO(selectedPassport.get(0));
            //set the taxonomical range (level)
            getPassportSessionBean().setSelectedTaxonomicLevel(
                    getPassportSessionBean().getGermplasmFacadeRemote().
                    getTaxonomicalLevelForTaxon(selectedPassport.get(0).
                    getTaxonId()));
            //set the left selected option of the add remove
            /*getPassportSessionBean().updateAddRemoveSelectedItems(
                    selectedPassport.get(0).
                    getPassportNomenclaturalGroupList());*/

            //Llamada al jsp encargado de la edicion de recolecciones
            return "edit";

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    public String btn_delete_action()
    {
        int n = this.getDataTablePassport().getRowCount();
        ArrayList<PassportDTO> selectedPassport = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTablePassport().setRowIndex(i);
            PassportDTO aux = (PassportDTO) this.
                    getDataTablePassport().getRowData();
            if (aux.isSelected()) {
                selectedPassport.add(aux);
            }
        }
        if(selectedPassport == null || selectedPassport.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedPassport.size() == 1)
        { //En caso de que solo se seleccione un elemento, lo elimina
            //si tiene hijos o asociacions despliega el mensaje de alerta
            if(getPassportListSessionBean().getGermplasmFacadeRemote().
                    haveAccessions(selectedPassport.get(0).getPassportId()))
            {
                this.getAlertMessage().setRendered(true);
                this.getMainPanel().setRendered(false);
                getPassportListSessionBean().setDeletePassport(
                        selectedPassport.get(0).getPassportId());
            }
            else
            {
                //delete the passport
                getPassportListSessionBean().getGermplasmFacadeRemote().
                        deletePassport(selectedPassport.get(0).getPassportId());
                //refresh the list
                getPassportListSessionBean().getPagination().refreshList();

                MessageBean.setSuccessMessageFromBundle("delete_passports", this.getMyLocale());

            }
            return null;

        }
        else
        { //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    public String btn_confirm_delete_action()
    {
        //delete the accession
        getPassportListSessionBean().getGermplasmFacadeRemote().
                deletePassport(
                getPassportListSessionBean().getDeletePassport());

        //refresh the list
        getPassportListSessionBean().getPagination().deleteItem();
        getPassportListSessionBean().getPagination().refreshList();

        getAccessionListSessionBean().setPagination(null);
        //getAccessionListSessionBean().getPagination().refreshList();


        //show and hidde panels
        this.getMainPanel().setRendered(true);
        this.getAlertMessage().setRendered(false);

        MessageBean.setSuccessMessageFromBundle("delete_passports", this.getMyLocale());

        return null;
    }

    public String btn_cancel_delete_action()
    {
        //show and hidde panels
        this.getMainPanel().setRendered(true);
        this.getAlertMessage().setRendered(false);
        return null;
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
     * @return the btnSearch
     */
    public HtmlCommandButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @param btnSearch the btnSearch to set
     */
    public void setBtnSearch(HtmlCommandButton btnSearch) {
        this.btnSearch = btnSearch;
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
     * @return the textfieldGatheringId
     */
    public TextField getTextfieldGatheringId() {
        return textfieldGatheringId;
    }

    /**
     * @param textfieldGatheringId the textfieldGatheringId to set
     */
    public void setTextfieldGatheringId(TextField textfieldGatheringId) {
        this.textfieldGatheringId = textfieldGatheringId;
    }

    /**
     * @return the textfieldPassportId
     */
    public TextField getTextfieldPassportId() {
        return textfieldPassportId;
    }

    /**
     * @param textfieldPassportId the textfieldPassportId to set
     */
    public void setTextfieldPassportId(TextField textfieldPassportId) {
        this.textfieldPassportId = textfieldPassportId;
    }

    /**
     * @return the plantNurseryDate
     */
    public Calendar getPlantNurseryDate() {
        return plantNurseryDate;
    }

    /**
     * @param plantNurseryDate the plantNurseryDate to set
     */
    public void setPlantNurseryDate(Calendar plantNurseryDate) {
        this.plantNurseryDate = plantNurseryDate;
    }

    /**
     * @return the plantingSeasonDate
     */
    public Calendar getPlantingSeasonDate() {
        return plantingSeasonDate;
    }

    /**
     * @param plantingSeasonDate the plantingSeasonDate to set
     */
    public void setPlantingSeasonDate(Calendar plantingSeasonDate) {
        this.plantingSeasonDate = plantingSeasonDate;
    }

    /**
     * @return the harvestingSeasonDate
     */
    public Calendar getHarvestingSeasonDate() {
        return harvestingSeasonDate;
    }

    /**
     * @param harvestingSeasonDate the harvestingSeasonDate to set
     */
    public void setHarvestingSeasonDate(Calendar harvestingSeasonDate) {
        this.harvestingSeasonDate = harvestingSeasonDate;
    }

    /**
     * @return the donorPersons
     */
    public SingleSelectOptionsList getDonorPersons() {
        return donorPersons;
    }

    /**
     * @param donorPersons the donorPersons to set
     */
    public void setDonorPersons(SingleSelectOptionsList donorPersons) {
        this.donorPersons = donorPersons;
    }

    /**
     * @return the donorInstitutions
     */
    public SingleSelectOptionsList getDonorInstitutions() {
        return donorInstitutions;
    }

    /**
     * @param donorInstitutions the donorInstitutions to set
     */
    public void setDonorInstitutions(SingleSelectOptionsList donorInstitutions) {
        this.donorInstitutions = donorInstitutions;
    }

    /**
     * @return the materialTypes
     */
    public SingleSelectOptionsList getMaterialTypes() {
        return materialTypes;
    }

    /**
     * @param materialTypes the materialTypes to set
     */
    public void setMaterialTypes(SingleSelectOptionsList materialTypes) {
        this.materialTypes = materialTypes;
    }

    /**
     * @return the sampleStatus
     */
    public SingleSelectOptionsList getSampleStatus() {
        return sampleStatus;
    }

    /**
     * @param sampleStatus the sampleStatus to set
     */
    public void setSampleStatus(SingleSelectOptionsList sampleStatus) {
        this.sampleStatus = sampleStatus;
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
}
