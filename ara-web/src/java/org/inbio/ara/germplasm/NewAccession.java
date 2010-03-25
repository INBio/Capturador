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
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.germplasm.PassportDTO;
import org.inbio.ara.util.BundleHelper;
import java.util.Locale;
import javax.faces.component.html.HtmlDataTable;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.germplasm.AccessionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewAccession.java
 * @version Created on 01/03/2010, 10:14:29 AM
 * @author dasolano
 */

public class NewAccession extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    //variables with information of the selector option
    private SingleSelectOptionsList responsablePerson = new SingleSelectOptionsList();
    private SingleSelectOptionsList collectionType = new SingleSelectOptionsList();
    private SingleSelectOptionsList germinationMethodType = new SingleSelectOptionsList();
    private SingleSelectOptionsList moistureMethodType = new SingleSelectOptionsList();

    private Calendar germinationDate = new Calendar();
    private Calendar storageDate = new Calendar();



    /******* componentes para las busquedas de pasaportes ************************/

    //listado
    //Data table binding para la tabla que muetra los passport
    private HtmlDataTable dataTablePassport = new HtmlDataTable();

    private String quantityTotalPassport = new String();

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



    /******* componentes para las busquedas de accessiones ************************/

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotalAccession = new String();
    //Data table binding para la tabla que muetra los passport
    private HtmlDataTable dataTableAccession = new HtmlDataTable();


    /*Componentes para las busquedas*/
    private HtmlInputText txSearchAccession = new HtmlInputText(); //Input text de busqueda simple
    private HtmlPanelGrid gridpAdvancedSearchAccession = new HtmlPanelGrid();
    private HtmlCommandButton btnSearchAccession = new HtmlCommandButton(); //Boton busqueda simple
    private HtmlCommandButton btnAdvSearchAccession = new HtmlCommandButton(); //Boton busqueda avanzada

    //componentes para busuqedas avanzadas


    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewAccession() {
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
            log("NewAccession Initialization Failure", e);
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

        //pasaporte -------------------------------------------------------------

        this.donorPersons.setOptions(SetResponsibleDropDownData());
        this.donorInstitutions.setOptions(SetInstitutionDropDownData());
        this.materialTypes.setOptions(getSelectionListDropDownData
                (SelectionListEntity.MATERIAL_TYPE.getId()));
        this.sampleStatus.setOptions(getSelectionListDropDownData
                (SelectionListEntity.SAMPLE_STATUS.getId()));

        setPassport();
        setAccession();
        
        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(getPassportListSessionBean().isAdvancedSearch()){
            this.getGridpAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
        }
        //Inicializar el dataprovider si la paginacion es nula y no es filtrado por busquedas
        else if (getPassportListSessionBean().getPagination()==null) {
            getPassportListSessionBean().initDataProvider();
        }

        //accesion --------------------------------------------------------------

        responsablePerson.setOptions(this.SetResponsibleDropDownData());
        germinationMethodType.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.GERMINATION_METHOD_TYPE.getId()));
        collectionType.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.COLLECTION_TYPE.getId()));
        moistureMethodType.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.MOISTURE_METHOD_TYPE.getId()));

        
        
        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(getgermplasm$AccessionSessionBean().isAdvancedSearch()){
            this.getGridpAdvancedSearchAccession().setRendered(true);//Muestra el panel de busqueda avanzada
        }
        //Inicializar el dataprovider si la paginacion es nula y no es filtrado por busquedas
        else if (getgermplasm$AccessionSessionBean().getPagination()==null) {
            getgermplasm$AccessionSessionBean().initDataProvider();
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



    public String saveAccessionButton_action() {

        AccessionDTO accessionDTO = getgermplasm$AccessionSessionBean().getAccessionDTO();

        //reset the accession Id because it save the accession parent just in this case
        accessionDTO.setAccessionId(null);
        //store the accession parent id
        

        GregorianCalendar germinationDateGC = new GregorianCalendar();
        GregorianCalendar storageDateGC = new GregorianCalendar();

        Date germinationDateD = this.getGerminationDate().getSelectedDate();
        Date storageDateD = this.getStorageDate().getSelectedDate();


        if (germinationDateD != null) {
            germinationDateGC.setTime(germinationDateD);
            accessionDTO.setGerminationDate(germinationDateGC);
        }
        if (storageDateD != null) {
            storageDateGC.setTime(storageDateD);
            accessionDTO.setStorageDate(storageDateGC);
        }

        //set the current weight
        accessionDTO.setCurrentWeigth(accessionDTO.getOriginalWeigth());

        accessionDTO.setUserName(getAraSessionBean().getGlobalUserName());



        try
        {

            accessionDTO.setPassportId(getSelectedPassport());
            AccessionDTO aux = getSelectedAccession();
            if(aux != null)
                accessionDTO.setAccessionParentId(aux.getAccessionId());
            //si los 2 estan llenos debe de dejarse uno
            if(accessionDTO.getAccessionParentId() != null &&
                    accessionDTO.getPassportId() != null  )
            {
                MessageBean.setErrorMessageFromBundle("error_passportId_and_accessionParentId", this.getMyLocale());
                return null;
            }
            else
            {
                if(accessionDTO.getAccessionParentId() == null &&
                    accessionDTO.getPassportId() == null )
                {
                    MessageBean.setErrorMessageFromBundle("error_passportId_and_accessionParentId_null", this.getMyLocale());
                    return null;
                }

                else
                {
                    accessionDTO.setAccessionId(getgermplasm$AccessionSessionBean().
                            getGermplasmFacadeRemote().
                            saveAccession(accessionDTO));
                    getgermplasm$AccessionSessionBean().resetValues();
                    getgermplasm$AccessionSessionBean().setEditAccessionDTO(accessionDTO);

                    //Refrescar la lista de recolecciones
                    this.getgermplasm$AccessionSessionBean().getPagination().addItem();
                    this.getgermplasm$AccessionSessionBean().getPagination().refreshList();

                    return "edit";
                }

            }
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

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
        List<PersonDTO> personDTOList = this.getgermplasm$AccessionSessionBean().
                getGermplasmFacadeRemote().getResponsablePersons();
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
     * Metodo para obtener los datos a mostrar en los drop downs de la
     * ventana de generacion que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    public Option[] getSelectionListDropDownData(Long selectionListEntityId) {

        //getAllSelectionListElementsByCollection
        List<SelectionListDTO> DTOList = this.getgermplasm$AccessionSessionBean().
                getInventoryFacadeRemote().
                getAllSelectionListElementsByCollection(selectionListEntityId, getAraSessionBean().getGlobalCollectionId());
        /*List<SelectionListDTO> DTOList = this.getPassportSessionBean().
        getGermplasmFacadeRemote().getElementsForSelectionList(selectionListEntityId);*/

        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null, " -- " + BundleHelper.getDefaultBundleValue("drop_down_default", getMyLocale()) + " --");
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
            //Finalmente se setea el data provider del paginador con los datos por default
            this.getPassportListSessionBean().getPagination().setTotalResults
                    (getPassportListSessionBean().getGermplasmFacadeRemote().
                    countPassport().intValue());
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.getPassportListSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getPassportListSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getPassportListSessionBean().setQueryMode(false);
            //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
            this.getPassportListSessionBean().getPagination().setTotalResults
                    (getPassportListSessionBean().getGermplasmFacadeRemote().
                    countPassportSimpleSearch(
                    userInput,
                    getAraSessionBean().getGlobalCollectionId()).intValue());
        }
        //set the first result of the query
        this.getPassportListSessionBean().getPagination().firstResults();
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
        this.getPassportListSessionBean().getPagination().setTotalResults(
                this.getPassportListSessionBean().getGermplasmFacadeRemote().
                countPassportAdvancedSearch(
                passportDTO,
                this.getAraSessionBean().getGlobalCollectionId()).intValue());
        this.getPassportListSessionBean().getPagination().firstResults();
        this.getTxSearch().setValue("");
        

        return null;
    }

    /**
     * Metodo ejecutado por el boton de busqueda simple
     * @return
     */
    public String btnAccessionSearch_action() {
        String userInput = "";
        if(this.getTxSearchAccession().getValue()!= null)
            userInput = this.getTxSearchAccession().getValue().toString();
        userInput = userInput.trim();
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getgermplasm$AccessionSessionBean().setQueryModeSimple(false);
            this.getgermplasm$AccessionSessionBean().setQueryMode(false);
            //Finalmente se setea el data provider del paginador con los datos por default
            this.getgermplasm$AccessionSessionBean().getPagination().setTotalResults
                    (getgermplasm$AccessionSessionBean().getGermplasmFacadeRemote().
                    countAccessions().intValue());
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.getgermplasm$AccessionSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getgermplasm$AccessionSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getgermplasm$AccessionSessionBean().setQueryMode(false);
            //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
            this.getgermplasm$AccessionSessionBean().getPagination().setTotalResults
                    (getgermplasm$AccessionSessionBean().getGermplasmFacadeRemote().
                    countAccessionSimpleSearch(
                    userInput,
                    getAraSessionBean().getGlobalCollectionId()).intValue());
        }
        //set the first result of the query
        this.getgermplasm$AccessionSessionBean().getPagination().firstResults();
        return null;
    }


    /**
     * Metodo ejecutado por el boton que muestra el panel de busqueda avanzada
     * Su funcion es mostrar y esconder dicho panel
     * @return
     */
    public String btnAdvAccessiontSearch_action() {
        boolean advanced = getgermplasm$AccessionSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            getgermplasm$AccessionSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearchAccession().setRendered(false);
            this.getBtnSearchAccession().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearchAccession().setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getgermplasm$AccessionSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearchAccession.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearchAccession().setRendered(true);
            this.getBtnSearchAccession().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearchAccession().setValue(BundleHelper.getDefaultBundleValue("advanced_search",getMyLocale()));

            //Reestablecer los valores por defecto de los textfields
            getgermplasm$AccessionSessionBean().setQueryAccessionDTO(new AccessionDTO());
        }
        return null;
    }

    /**
     * Method that set The gathering id to the passportDTO in the PassportSessionBean
     */
    public void setAccession()
    {
        try{
            AccessionDTO selected = getSelectedAccession();
            if(selected != null)
            {
                getgermplasm$AccessionSessionBean().getAccessionDTO().setAccessionId(selected.getAccessionId());
                getgermplasm$AccessionSessionBean().getAccessionDTO().
                        setAccessionParentId(
                        getgermplasm$AccessionSessionBean().getAccessionDTO().
                        getAccessionId());
                getgermplasm$AccessionSessionBean().getAccessionDTO().
                        setAccessionParent(selected.getAccessionNumber());
            }
            else
            {
                getgermplasm$AccessionSessionBean().getAccessionDTO().
                        setAccessionParentId(null);
                getgermplasm$AccessionSessionBean().getAccessionDTO().
                        setAccessionParent(null);
            }
        }
        catch(Exception e ){}
    }

    private AccessionDTO getSelectedAccession() throws Exception
    {
        int n = this.getDataTableAccession().getRowCount();
        ArrayList<AccessionDTO> selectedAccession = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableAccession().setRowIndex(i);
            AccessionDTO aux = (AccessionDTO) this.
                    getDataTableAccession().getRowData();
            if (aux.isSelected()) {
                selectedAccession.add(aux);
            }
        }
        if(selectedAccession == null || selectedAccession.size() == 0){
            return null;
        }
        else if(selectedAccession.size() == 1){ //En caso de que solo se seleccione un elemento

            AccessionDTO accessionDTOaux = selectedAccession.get(0);
            return accessionDTOaux;

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            throw new Exception("not_implemented");
            //return null;
        }
    }


    public String btnAdvSearchAccession_action()
    {
        //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getgermplasm$AccessionSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getgermplasm$AccessionSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getgermplasm$AccessionSessionBean().getPagination().setTotalResults(
                this.getgermplasm$AccessionSessionBean().
                getGermplasmFacadeRemote().
                countAccessionAdvancedSearch(
                getgermplasm$AccessionSessionBean().
                getQueryAccessionDTO(), getAraSessionBean().
                getGlobalCollectionId()).intValue());

        this.getgermplasm$AccessionSessionBean().getPagination().firstResults();

        this.getTxSearchAccession().setValue("");

        return null;
    }
    
    /**
     * Method that set The gathering id to the passportDTO in the PassportSessionBean
     */
    public void setPassport()
    {
        try{
            if(getSelectedPassport() != null)
            {
                getPassportListSessionBean().getPassportDTO().setPassportId(getSelectedPassport());
                getgermplasm$AccessionSessionBean().getAccessionDTO().
                        setPassportId(
                        getPassportListSessionBean().getPassportDTO().getPassportId());
            }
            else
                getgermplasm$AccessionSessionBean().getAccessionDTO().
                        setPassportId(null);
        }
        catch(Exception e ){}
    }

    private Long getSelectedPassport() throws Exception
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
            return null;
        }
        else if(selectedPassport.size() == 1){ //En caso de que solo se seleccione un elemento

            PassportDTO passportDTOaux = selectedPassport.get(0);
            return passportDTOaux.getPassportId();

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            throw new Exception("not_implemented");
            //return null;
        }
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
    protected AudienceSessionBean getadmin$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("admin$AudienceSessionBean");
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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
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
     * @return the responsablePerson
     */
    public SingleSelectOptionsList getResponsablePerson() {
        return responsablePerson;
    }

    /**
     * @param responsablePerson the responsablePerson to set
     */
    public void setResponsablePerson(SingleSelectOptionsList responsablePerson) {
        this.responsablePerson = responsablePerson;
    }

    /**
     * @return the collectionType
     */
    public SingleSelectOptionsList getCollectionType() {
        return collectionType;
    }

    /**
     * @param collectionType the collectionType to set
     */
    public void setCollectionType(SingleSelectOptionsList collectionType) {
        this.collectionType = collectionType;
    }

    /**
     * @return the germinationMethodType
     */
    public SingleSelectOptionsList getGerminationMethodType() {
        return germinationMethodType;
    }

    /**
     * @param germinationMethodType the germinationMethodType to set
     */
    public void setGerminationMethodType(SingleSelectOptionsList germinationMethodType) {
        this.germinationMethodType = germinationMethodType;
    }

    /**
     * @return the moistureMethodType
     */
    public SingleSelectOptionsList getMoistureMethodType() {
        return moistureMethodType;
    }

    /**
     * @param moistureMethodType the moistureMethodType to set
     */
    public void setMoistureMethodType(SingleSelectOptionsList moistureMethodType) {
        this.moistureMethodType = moistureMethodType;
    }

    /**
     * @return the germinationDate
     */
    public Calendar getGerminationDate() {
        return germinationDate;
    }

    /**
     * @param germinationDate the germinationDate to set
     */
    public void setGerminationDate(Calendar germinationDate) {
        this.germinationDate = germinationDate;
    }

    /**
     * @return the storageDate
     */
    public Calendar getStorageDate() {
        return storageDate;
    }

    /**
     * @param storageDate the storageDate to set
     */
    public void setStorageDate(Calendar storageDate) {
        this.storageDate = storageDate;
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
     * @return the quantityTotalAccession
     */
    public String getQuantityTotalAccession() {
        quantityTotalAccession= this.getgermplasm$AccessionSessionBean().getQuantityTotal();
        return quantityTotalAccession;
    }

    /**
     * @param quantityTotalAccession the quantityTotalAccession to set
     */
    public void setQuantityTotalAccession(String quantityTotalAccession) {
        this.quantityTotalAccession = quantityTotalAccession;
    }

    /**
     * @return the dataTableAccession
     */
    public HtmlDataTable getDataTableAccession() {
        return dataTableAccession;
    }

    /**
     * @param dataTableAccession the dataTableAccession to set
     */
    public void setDataTableAccession(HtmlDataTable dataTableAccession) {
        this.dataTableAccession = dataTableAccession;
    }

    /**
     * @return the gridpAdvancedSearchAccession
     */
    public HtmlPanelGrid getGridpAdvancedSearchAccession() {
        return gridpAdvancedSearchAccession;
    }

    /**
     * @param gridpAdvancedSearchAccession the gridpAdvancedSearchAccession to set
     */
    public void setGridpAdvancedSearchAccession(HtmlPanelGrid gridpAdvancedSearchAccession) {
        this.gridpAdvancedSearchAccession = gridpAdvancedSearchAccession;
    }

    /**
     * @return the txSearchAccession
     */
    public HtmlInputText getTxSearchAccession() {
        return txSearchAccession;
    }

    /**
     * @param txSearchAccession the txSearchAccession to set
     */
    public void setTxSearchAccession(HtmlInputText txSearchAccession) {
        this.txSearchAccession = txSearchAccession;
    }

    /**
     * @return the btnSearchAccession
     */
    public HtmlCommandButton getBtnSearchAccession() {
        return btnSearchAccession;
    }

    /**
     * @param btnSearchAccession the btnSearchAccession to set
     */
    public void setBtnSearchAccession(HtmlCommandButton btnSearchAccession) {
        this.btnSearchAccession = btnSearchAccession;
    }

    /**
     * @return the btnAdvSearchAccession
     */
    public HtmlCommandButton getBtnAdvSearchAccession() {
        return btnAdvSearchAccession;
    }

    /**
     * @param btnAdvSearchAccession the btnAdvSearchAccession to set
     */
    public void setBtnAdvSearchAccession(HtmlCommandButton btnAdvSearchAccession) {
        this.btnAdvSearchAccession = btnAdvSearchAccession;
    }

    /**
     * @return the quantityTotalPassport
     */
    public String getQuantityTotalPassport() {
        quantityTotalPassport= this.getPassportListSessionBean().getQuantityTotal();
        return quantityTotalPassport;
    }

    /**
     * @param quantityTotalPassport the quantityTotalPassport to set
     */
    public void setQuantityTotalPassport(String quantityTotalPassport) {
        this.quantityTotalPassport = quantityTotalPassport;
    }

  
}

