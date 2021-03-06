/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import org.inbio.ara.util.BundleHelper;

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
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.taxonomy.NomenclaturalGroupSessionBean;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.reports.ReportsSessionBean;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.admin.AdminGeographicLayersSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.germplasm.PassportDTO;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.dto.inventory.GatheringObservationDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.taxonomy.SpeciesSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.util.MessageBean;
/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewPassport.java
 * @version Created on 18/01/2010, 03:24:13 PM
 * @author dasolano
 */

public class NewPassport extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>


    private DefaultSelectItemsArray dropdown1DefaultItems = new DefaultSelectItemsArray();

    

    //variables with information of the selector option
    private SingleSelectOptionsList donorPersons = new SingleSelectOptionsList();
    private SingleSelectOptionsList donorInstitutions = new SingleSelectOptionsList();
    private SingleSelectOptionsList gatheringSource = new SingleSelectOptionsList();
    private SingleSelectOptionsList soilColosr = new SingleSelectOptionsList();
    private SingleSelectOptionsList soilTextures = new SingleSelectOptionsList();
    private SingleSelectOptionsList materialTypes = new SingleSelectOptionsList();
    private SingleSelectOptionsList sampleStatus = new SingleSelectOptionsList();
    private SingleSelectOptionsList cultivationPractice = new SingleSelectOptionsList();
    private SingleSelectOptionsList cropTypes = new SingleSelectOptionsList();
    private SingleSelectOptionsList cropSystems = new SingleSelectOptionsList();


    private SingleSelectOptionsList taxonomicLevels = new SingleSelectOptionsList();
    private SingleSelectOptionsList scientificNames = new SingleSelectOptionsList();
    //private SingleSelectOptionsList nomenclaturalGroups = new SingleSelectOptionsList();


    private Calendar plantNurseryDate = new Calendar();
    private Calendar plantationDate = new Calendar();
    private Calendar harvestingDate = new Calendar();


    /*Componentes para listar los gathering*/
    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();

    private TextField txGatheringId = new TextField();
    private TextField txResponsible = new TextField();
    private TextField txLocality = new TextField();
    private TextField txLatitudeShort = new TextField();
    private TextField txLongitudeShort = new TextField();
    private HtmlInputText txSearch = new HtmlInputText(); //Input text de busqueda simple
    private HtmlCommandButton btnSeach = new HtmlCommandButton(); //Boton busqueda simple
    private HtmlCommandButton btnAdvSeach = new HtmlCommandButton(); //Boton busqueda avanzada
    private TextField txRadio = new TextField();
    private Calendar initial_date = new com.sun.webui.jsf.component.Calendar();
    private Calendar final_date = new com.sun.webui.jsf.component.Calendar();

    //En esta variable se setearan los datos del drop down de provincias
    private SingleSelectOptionsList provincesData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de psises
    private SingleSelectOptionsList countryData = new SingleSelectOptionsList();

    private DropDown ddCountry = new DropDown();
    private DropDown ddProvince = new DropDown();

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();
    //Data table binding para la tabla que muetra los especimnes
    private HtmlDataTable dataTableGathering = new HtmlDataTable();

    /*--------------------------------------------------*/


    public DefaultSelectItemsArray getDropdown1DefaultItems() {
        return dropdown1DefaultItems;
    }

    public void setDropdown1DefaultItems(DefaultSelectItemsArray dsia) {
        this.dropdown1DefaultItems = dsia;
    }




    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewPassport() {
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
            log("NewPassport Initialization Failure", e);
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

        this.gatheringSource.setOptions(getSelectionListDropDownData(
                SelectionListEntity.GATHERING_SOURCE.getId()));
        this.soilColosr.setOptions(getSelectionListDropDownData
                (SelectionListEntity.SOIL_COLOR.getId()));
        this.soilTextures.setOptions(getSelectionListDropDownData
                (SelectionListEntity.SOIL_TEXTURE.getId()));
        this.materialTypes.setOptions(getSelectionListDropDownData
                (SelectionListEntity.MATERIAL_TYPE.getId()));
        this.sampleStatus.setOptions(getSelectionListDropDownData
                (SelectionListEntity.SAMPLE_STATUS.getId()));
        this.cultivationPractice.setOptions(getSelectionListDropDownData
                (SelectionListEntity.CULTIVATION_PRACTICE.getId()));
        this.cropTypes.setOptions(getSelectionListDropDownData
                (SelectionListEntity.CROP_TYPE.getId()));
        this.cropSystems.setOptions(getSelectionListDropDownData
                (SelectionListEntity.CROP_SYSTEM.getId()));

        //Cargando datos de identificaciones
        this.taxonomicLevels.setOptions(this.getTaxonomicLevelData());
        this.scientificNames.setOptions(this.updateTaxonListAction(
                getPassportSessionBean().getSelectedTaxonomicLevel()));
        /*this.nomenclaturalGroups.setOptions(
                this.getAllNomenclaturalGroupsForTaxonDropDownData(
                getPassportSessionBean().getSelectedScientificName()));*/


        this.loadAddRemoveData(false);


        this.SetCountryDropDownData(); //Cargar valores del DD de paises
        this.SetProvincesDropDownData();//Cargar valores del DD de provincias


        setGathering();


        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(getPassportSessionBean().isAdvancedSearch()){
            this.getGridpAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
        }
        //Inicializar el dataprovider si la paginacion es nula y no es filtrado por busquedas
        else if (getPassportSessionBean().getPagination()==null) {
            getPassportSessionBean().initDataProvider();
        }
    }

    /**
     * Load the information to the add remove nomenclatural groups for a taxon
     * @param reset
     */
    public void loadAddRemoveData(boolean reset) {
        PassportSessionBean psb = this.getPassportSessionBean();

        if (reset)
        {
            psb.getArNomenclaturalGroups().setAvailableOptions(new Option[0]);
        }
        // AddRemove de nomenclaturalGroups
        if (psb.getArNomenclaturalGroups().getAvailableOptions() == null ||
                psb.getArNomenclaturalGroups().getAvailableOptions().length == 0)
        {
            if(psb.getPassportDTO().getTaxonId() != null)
            {
                List<NomenclaturalGroupDTO> listNG =
                        psb.getGermplasmFacadeRemote().
                        getNomenclaturalGroupsByTaxon(psb.getPassportDTO().getTaxonId());
                this.setNomenclaturalGroupListOptions(listNG);
            }
        }

        // Configurar los títulos

        psb.getArNomenclaturalGroups().setLbTitle
                (BundleHelper.getDefaultBundleValue("nomenclatural_groups", this.getMyLocale()));
        psb.getArNomenclaturalGroups().setLbAvailable
                (BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));
        psb.getArNomenclaturalGroups().setLbSelected
                (BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));
    }

    /**
     * Method that reset or load the information to de AddRemoveList
     * @return
     */
    public String updateNomenclaturalGroupListAction()
    {

            PassportSessionBean psb = this.getPassportSessionBean();

            List<NomenclaturalGroupDTO> listNG =
                        psb.getGermplasmFacadeRemote().
                        getNomenclaturalGroupsByTaxon(psb.getPassportDTO().getTaxonId());

            psb.getArNomenclaturalGroups().setRightOptions(new Option[0]);

            this.setNomenclaturalGroupListOptions(listNG);

            return null;
    }


        /**
     * Method that reset or load the information to de AddRemoveList
         * for the taxonomical range
     * @return
     */
    public String updateNomenclaturalGroupListActionForTaxonomicalLevelChange()
    {
        getPassportSessionBean().getPassportDTO().setTaxonId(null);
        PassportSessionBean psb = this.getPassportSessionBean();

        List<NomenclaturalGroupDTO> listNG =
                    psb.getGermplasmFacadeRemote().
                    getNomenclaturalGroupsByTaxon(psb.getPassportDTO().getTaxonId());

        psb.getArNomenclaturalGroups().setRightOptions(new Option[0]);

        this.setNomenclaturalGroupListOptions(listNG);

        return null;
    }

    /**
     * Set the available nomenclaturalGroupList to the addRemoveComponent
     * @param taxonList
     */
    private void setNomenclaturalGroupListOptions(List<NomenclaturalGroupDTO> nomenclaturalGroupDTOList)
    {
        PassportSessionBean psb = this.getPassportSessionBean();

        List<Option> list = new ArrayList<Option>();

        if(nomenclaturalGroupDTOList == null || nomenclaturalGroupDTOList.isEmpty())
        {
            psb.getArNomenclaturalGroups().setAvailableOptions(new Option[0]);
        }
        else
        {
            for (NomenclaturalGroupDTO nomenclaturalGroupDTO : nomenclaturalGroupDTOList)
            {
                list.add(new Option(nomenclaturalGroupDTO.getNomenclaturalGroupId(),
                        nomenclaturalGroupDTO.getName()));
            }
            psb.getArNomenclaturalGroups().setAvailableOptions(
                    (list.toArray(new Option[list.size()])));
        }
    }

    /**
     * Method that set The gathering id to the passportDTO in the PassportSessionBean
     */
    public void setGathering()
    {
        try{
            if(getSelectedGathering() != null)
            {
                getPassportSessionBean().getPassportDTO().setGatheringId(getSelectedGathering());
            }
        }
        catch(Exception e )
        {
            e.printStackTrace();
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
     * Set the taxon list for a taxonomic level
     * @param taxonList
     */
    private Option[] setTaxonListOptions(List<TaxonDTO> taxonList)
    {

        Option[] allOptionsInArray = null;
        Option option = null;
        ArrayList<Option> allOptions = new ArrayList<Option>();
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        if(taxonList != null)
        {
            for (TaxonDTO taxon : taxonList) {
                //System.out.println(taxon.getDefaultName());
                option = new Option(taxon.getTaxonKey(), taxon.getDefaultName());
                allOptions.add(option);

            }

        }
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Get the taxonomic levels
     * @return
     */
    public Option[] getTaxonomicLevelData() {


            Option[] allOptionsInArray = null;
            Option option = null;
            List<TaxonomicalRangeDTO> aTRList = this.getinventory$IdentificationSessionBean()
            .getTaxonomicalRangeList();
            ArrayList<Option> allOptions = new ArrayList<Option>();
            //Crear opcion titulo
            option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
            ("drop_down_default", getMyLocale())+" -- ");
            allOptions.add(option);
            //Crear todas las opciones del drop down
            for (TaxonomicalRangeDTO trDTO : aTRList) {
                    option = new Option(trDTO.getTaxonomicalRangeKey(), trDTO.getName());
                    allOptions.add(option);
            }
            //Sets the elements in the SingleSelectedOptionList Object
            allOptionsInArray = new Option[allOptions.size()];
            return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Update the taxon drop down
     * @return
     */
    public Option[] updateTaxonListAction(Long taxonomicLevel) {

        /*List<TaxonDTO> taxonList = getPassportSessionBean().
                getGermplasmFacadeRemote().
                getAllTaxonsByCollectionIdAndTaxonomicalRangeId(
                getAraSessionBean().getGlobalCollectionId(), taxonomicLevel);*/

        List<TaxonDTO> taxonList = getPassportSessionBean().
                getGermplasmFacadeRemote().
                getAllTaxonsByPlantaeKingdomAndTaxonomicalRangeId(taxonomicLevel);

            return this.setTaxonListOptions(taxonList);

    }




    /**
     * Metodo ejecutado por el boton que muestra el panel de busqueda avanzada
     * Su funcion es mostrar y esconder dicho panel
     * @return
     */
    public String btnAdvGatheringSearch_action() {
        boolean advanced = this.getPassportSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            this.getPassportSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearch().setRendered(false);
            this.getBtnSeach().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSeach().setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getPassportSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearch().setRendered(true);
            this.getBtnSeach().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSeach().setValue(BundleHelper.getDefaultBundleValue("advanced_search",getMyLocale()));
            //Reestablecer los valores por defecto de los drop downs
            Long auxDefault = new Long(-1);
            this.getPassportSessionBean().setSelectedCountry(auxDefault);
            this.getPassportSessionBean().setSelectedProvince(auxDefault);
            //Reestablecer los valores por defecto de los textfields
            this.getTxGatheringId().setText(null);
            this.getTxResponsible().setText(null);
            this.getTxLocality().setText(null);
            this.getTxLatitudeShort().setText(null);
            this.getTxLongitudeShort().setText(null);
            this.getTxRadio().setText(null);
            this.getInitial_date().setText(null);
            this.getFinal_date().setText(null);
        }
        return null;
    }

    /**
     * Return all nomenclatural groups for a taxon id
     * @return
     */
    public Option[] getAllNomenclaturalGroupsForTaxonDropDownData(Long taxonId)
    {
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        if(taxonId != null)
        {
            List<NomenclaturalGroupDTO> ngList = this.getPassportSessionBean().
                    getGermplasmFacadeRemote().getNomenclaturalGroupsByTaxon(taxonId);
            //Crear todas las opciones del drop down
            for(NomenclaturalGroupDTO ngDTO : ngList){

                option = new Option(ngDTO.getNomenclaturalGroupId(), ngDTO.getName());
                allOptions.add(option);
            }
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Metodo ejecutado por el boton de proceder con la busqueda avanzada
     * este boton es el que esta dentro del panel de busqueda avanzada
     * @return
     */
    public String btnAdvSearchGO_action() {
        //Capturar el dato de gatheringId
        Long gatheringId = null;
        String gId = (String)this.getTxGatheringId().getText();
        if(gId!=null){
            gatheringId = Long.parseLong(gId);
        }

        //Crear el DTO para la consulta
        GatheringObservationDTO consulta = new GatheringObservationDTO();
        consulta.setResponsibleName((String)this.getTxResponsible().getText());
        consulta.setLocalityDescription((String)this.getTxLocality().getText());
        consulta.setGatheringObservationId(gatheringId);
        //----------------------------------------------------------------------
        Double latitude_short = null;
        Double longitude_short = null;
        Integer radio = null;
        try{
            latitude_short = Double.valueOf(this.getTxLatitudeShort().getText().
                    toString());
            longitude_short = Double.valueOf(this.getTxLongitudeShort().getText().
                    toString());
            radio = Integer.valueOf(this.getTxRadio().getText().toString());
        }
        catch(Exception e){}
        if(latitude_short!=null&&longitude_short!=null&&radio!=null){
            consulta.setLatitude(latitude_short);
            consulta.setLongitude(longitude_short);
            consulta.setRadio(radio);
        }
        //En caso de que alguno de los tres sea nulo
        if((latitude_short==null||longitude_short==null||radio==null)&&(latitude_short!=null||longitude_short!=null||radio!=null)){
            MessageBean.setErrorMessageFromBundle("error_coordinates_search", this.getMyLocale());
        }
        //----------------------------------------------------------------------
        consulta.setCountryId(this.getPassportSessionBean().
                getSelectedCountry());
        consulta.setProvinceId(this.getPassportSessionBean().
                getSelectedProvince());
        GregorianCalendar iniCal = new GregorianCalendar();
        GregorianCalendar finCal = new GregorianCalendar();
        Date iniDate = this.getInitial_date().getSelectedDate();
        Date finDate = this.getFinal_date().getSelectedDate();
        if(iniDate!=null){
            iniCal.setTime(iniDate);
            consulta.setInitialDateTime(iniCal);
        }
        if(finDate!=null){
            finCal.setTime(finDate);
            consulta.setFinalDateTime(finCal);
        }
        //Setear el GatheringDTO del SessionBean utilizado para realizar la consulta
        this.getPassportSessionBean().setQueryGatheringDTO(consulta);
        //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getPassportSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getPassportSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getPassportSessionBean().getPagination().firstResults();
        this.getTxSearch().setValue("");

        return null;
    }

    /**
     * Get all taxons and add them to the drop down
     * @return
     */
    public Option[] getAllTaxonsDropDownData()
    {
        List<TaxonDTO> taxonList = this.getPassportSessionBean().getTaxonomyFacadeRemote().getAllTaxon();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(TaxonDTO taxDTO : taxonList){

            option = new Option(taxDTO.getTaxonKey(), taxDTO.getCurrentName());
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
     * Metodo ejecutado por el drop down de paises para calcular las provincias correspondientes
     */
    public String setProvinces(){
        this.setProvincesData(new SingleSelectOptionsList());
        this.SetProvincesDropDownData();
        return null;
    }

         /**
     * Metodo ejecutado por el drop down de paises para calcular las provincias correspondientes
     */
    public void SetProvincesDropDownData(){
        List<GeographicLayerDTO> geoDTOList =
                this.getPassportSessionBean().SetProvincesDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;

        if(geoDTOList!=null){
            //Crear opcion titulo
            option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                    ("drop_down_default",getMyLocale())+" --");
            allOptions.add(option);
            //Crear todas las opciones del drop down
            for(GeographicLayerDTO geoDTO : geoDTOList){
                option = new Option(geoDTO.getGeographicalLayerKey(), geoDTO.getName());
                allOptions.add(option);
            }
            //Sets the elements in the SingleSelectedOptionList Object
            allOptionsInArray = new Option[allOptions.size()];
            this.getProvincesData().setOptions(allOptions.toArray(allOptionsInArray));
        }
        else{
            //Crear opcion titulo
            option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                    ("drop_down_default",getMyLocale())+" --");
            allOptions.add(option);
            //Sets the elements in the SingleSelectedOptionList Object
            allOptionsInArray = new Option[allOptions.size()];
            this.getProvincesData().setOptions(allOptions.toArray(allOptionsInArray));
        }
    }

     /**
     * Obtener los datos para el drop down de paises
     */
    public void SetCountryDropDownData(){
        List<GeographicLayerDTO> geoDTOList =
                this.getPassportSessionBean().SetCountryDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(GeographicLayerDTO geoDTO : geoDTOList){
            option = new Option(geoDTO.getGeographicalLayerKey(), geoDTO.getName());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.getCountryData().setOptions(allOptions.toArray(allOptionsInArray));
    }

    /**
     * Metodo ejecutado por el boton de busqueda simple
     * @return
     */
    public String btnGatheringSearch_action() {
        String userInput = "";
        if(this.getTxSearch().getValue()!= null)
            userInput = this.getTxSearch().getValue().toString();
        userInput = userInput.trim();
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getPassportSessionBean().setQueryModeSimple(false);
            this.getPassportSessionBean().setQueryMode(false);
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.getPassportSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getPassportSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getPassportSessionBean().setQueryMode(false);
        }
        this.getPassportSessionBean().getPagination().firstResults();
        return null;
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
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected NomenclaturalGroupSessionBean gettaxonomy$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean) getBean("taxonomy$NomenclaturalGroupSessionBean");
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
    protected PersonSessionBean getadmin$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CollectionSessionBean getadmin$CollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ReportsSessionBean getreports$ReportsSessionBean() {
        return (ReportsSessionBean) getBean("reports$ReportsSessionBean");
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
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("inventory$SpecimenGenerationSessionBean");
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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpeciesSessionBean gettaxonomy$SpeciesSessionBean() {
        return (SpeciesSessionBean) getBean("taxonomy$SpeciesSessionBean");
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
    protected SystemUserSessionBean getsecurity$SystemUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
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
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
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
     * @return the collectionSourcse
     */
    public SingleSelectOptionsList getGatheringSource() {
        return gatheringSource;
    }

    /**
     * @param collectionSourcse the collectionSourcse to set
     */
    public void setGaheringSource(SingleSelectOptionsList collectionSourcse) {
        this.gatheringSource = collectionSourcse;
    }

    /**
     * @return the soilColosr
     */
    public SingleSelectOptionsList getSoilColosr() {
        return soilColosr;
    }

    /**
     * @param soilColosr the soilColosr to set
     */
    public void setSoilColosr(SingleSelectOptionsList soilColosr) {
        this.soilColosr = soilColosr;
    }

    /**
     * @return the soilTextures
     */
    public SingleSelectOptionsList getSoilTextures() {
        return soilTextures;
    }

    /**
     * @param soilTextures the soilTextures to set
     */
    public void setSoilTextures(SingleSelectOptionsList soilTextures) {
        this.soilTextures = soilTextures;
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
     * @return the cultivationPractice
     */
    public SingleSelectOptionsList getCultivationPractice() {
        return cultivationPractice;
    }

    /**
     * @param cultivationPractice the cultivationPractice to set
     */
    public void setCultivationPractice(SingleSelectOptionsList cultivationPractice) {
        this.cultivationPractice = cultivationPractice;
    }

    /**
     * @return the cropTypes
     */
    public SingleSelectOptionsList getCropTypes() {
        return cropTypes;
    }

    /**
     * @param cropTypes the cropTypes to set
     */
    public void setCropTypes(SingleSelectOptionsList cropTypes) {
        this.cropTypes = cropTypes;
    }

    /**
     * @return the cropSystems
     */
    public SingleSelectOptionsList getCropSystems() {
        return cropSystems;
    }

    /**
     * @param cropSystems the cropSystems to set
     */
    public void setCropSystems(SingleSelectOptionsList cropSystems) {
        this.cropSystems = cropSystems;
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
     * @return the scientificNames
     */
    public SingleSelectOptionsList getScientificNames() {
        return scientificNames;
    }

    /**
     * @param scientificNames the scientificNames to set
     */
    public void setScientificNames(SingleSelectOptionsList scientificNames) {
        this.scientificNames = scientificNames;
    }

    /**
     * @return the nomenclaturalGroups
     */
    /*public SingleSelectOptionsList getNomenclaturalGroups() {
        return nomenclaturalGroups;
    }*/

    /**
     * @param nomenclaturalGroups the nomenclaturalGroups to set
     */
   /* public void setNomenclaturalGroups(SingleSelectOptionsList nomenclaturalGroups) {
        this.nomenclaturalGroups = nomenclaturalGroups;
    }*/

  

    public void dropdownScientificName_processValueChange() {
        /*nomenclaturalGroups.setOptions(null);
        nomenclaturalGroups.setOptions(
                getAllNomenclaturalGroupsForTaxonDropDownData(
                getPassportSessionBean().getSelectedScientificName()));*/
    }

    public String savePassportButton_action() {

        PassportDTO passportDTO = getPassportSessionBean().getPassportDTO();


        GregorianCalendar plantNurseryDateGC = new GregorianCalendar();
        GregorianCalendar plantationDateGC = new GregorianCalendar();
        GregorianCalendar harvestingDateGC = new GregorianCalendar();

        Date plantNurseryDateD = this.getPlantNurseryDate().getSelectedDate();
        Date plantationDateD = this.getPlantationDate().getSelectedDate();
        Date harvestingDateD = this.getHarvestingDate().getSelectedDate();


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

        passportDTO.setUserName(getAraSessionBean().getGlobalUserName());



        try
        {
            //assign the gathering id
            Long selectedGathering = getSelectedGathering();
            passportDTO.setGatheringId(selectedGathering);

            //si alguna de las 3 opciones no ha sido seleccionada avisa el error
            if(     selectedGathering == null &&
                    getPassportSessionBean().getPassportDTO().getDonorInstitutionId() == null &&
                    getPassportSessionBean().getPassportDTO().getDonorPersonId() == null)
            {
                MessageBean.setErrorMessageFromBundle("error_donor_gathering", this.getMyLocale());
            }
            else
            {
                if(passportDTO.getMaterialTypeId() != null)
                {
                    Long[] selectedNomenclaturalGroups =
                            getPassportSessionBean().getArNomenclaturalGroups().
                            getSelectedOptions();

                    getPassportSessionBean().getGermplasmFacadeRemote().
                            savePassport(
                            getPassportSessionBean().getPassportDTO(),
                            selectedNomenclaturalGroups);
                    //Notificar al usuario
                    MessageBean.setSuccessMessageFromBundle("create_passport_succces", this.getMyLocale());

                    getPassportSessionBean().resetValues();
                    //Refrescar la lista de recolecciones
                    this.getPassportListSessionBean().getPagination().refreshList();
                }
                else
                    MessageBean.setErrorMessageFromBundle("error_material_type_required", this.getMyLocale());
            }

            return null;

        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

    }

    private Long getSelectedGathering() throws Exception
    {
        int n = this.getDataTableGathering().getRowCount();
        ArrayList<GatheringObservationDTO> selectedGathering = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableGathering().setRowIndex(i);
            GatheringObservationDTO aux = (GatheringObservationDTO) this.
                    getDataTableGathering().getRowData();
            if (aux.isSelected()) {
                selectedGathering.add(aux);
            }
        }
        if(selectedGathering == null || selectedGathering.size() == 0){
            return null;
        }
        else if(selectedGathering.size() == 1){ //En caso de que solo se seleccione un elemento

            GatheringObservationDTO goDTO = selectedGathering.get(0);
            return goDTO.getGatheringObservationId();

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            throw new Exception("not_implemented");
            //return null;
        }
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
     * @return the plantationDate
     */
    public Calendar getPlantationDate() {
        return plantationDate;
    }

    /**
     * @param plantationDate the plantationDate to set
     */
    public void setPlantationDate(Calendar plantationDate) {
        this.plantationDate = plantationDate;
    }

    /**
     * @return the harvestingDate
     */
    public Calendar getHarvestingDate() {
        return harvestingDate;
    }

    /**
     * @param harvestingDate the harvestingDate to set
     */
    public void setHarvestingDate(Calendar harvestingDate) {
        this.harvestingDate = harvestingDate;
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
     * @return the txGatheringId
     */
    public TextField getTxGatheringId() {
        return txGatheringId;
    }

    /**
     * @param txGatheringId the txGatheringId to set
     */
    public void setTxGatheringId(TextField txGatheringId) {
        this.txGatheringId = txGatheringId;
    }

    /**
     * @return the txResponsible
     */
    public TextField getTxResponsible() {
        return txResponsible;
    }

    /**
     * @param txResponsible the txResponsible to set
     */
    public void setTxResponsible(TextField txResponsible) {
        this.txResponsible = txResponsible;
    }

    /**
     * @return the txLocality
     */
    public TextField getTxLocality() {
        return txLocality;
    }

    /**
     * @param txLocality the txLocality to set
     */
    public void setTxLocality(TextField txLocality) {
        this.txLocality = txLocality;
    }

    /**
     * @return the txLatitudeShort
     */
    public TextField getTxLatitudeShort() {
        return txLatitudeShort;
    }

    /**
     * @param txLatitudeShort the txLatitudeShort to set
     */
    public void setTxLatitudeShort(TextField txLatitudeShort) {
        this.txLatitudeShort = txLatitudeShort;
    }

    /**
     * @return the txLongitudeShort
     */
    public TextField getTxLongitudeShort() {
        return txLongitudeShort;
    }

    /**
     * @param txLongitudeShort the txLongitudeShort to set
     */
    public void setTxLongitudeShort(TextField txLongitudeShort) {
        this.txLongitudeShort = txLongitudeShort;
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
     * @return the btnSeach
     */
    public HtmlCommandButton getBtnSeach() {
        return btnSeach;
    }

    /**
     * @param btnSeach the btnSeach to set
     */
    public void setBtnSeach(HtmlCommandButton btnSeach) {
        this.btnSeach = btnSeach;
    }

    /**
     * @return the btnAdvSeach
     */
    public HtmlCommandButton getBtnAdvSeach() {
        return btnAdvSeach;
    }

    /**
     * @param btnAdvSeach the btnAdvSeach to set
     */
    public void setBtnAdvSeach(HtmlCommandButton btnAdvSeach) {
        this.btnAdvSeach = btnAdvSeach;
    }

    /**
     * @return the txRadio
     */
    public TextField getTxRadio() {
        return txRadio;
    }

    /**
     * @param txRadio the txRadio to set
     */
    public void setTxRadio(TextField txRadio) {
        this.txRadio = txRadio;
    }

    /**
     * @return the initial_date
     */
    public Calendar getInitial_date() {
        return initial_date;
    }

    /**
     * @param initial_date the initial_date to set
     */
    public void setInitial_date(Calendar initial_date) {
        this.initial_date = initial_date;
    }

    /**
     * @return the final_date
     */
    public Calendar getFinal_date() {
        return final_date;
    }

    /**
     * @param final_date the final_date to set
     */
    public void setFinal_date(Calendar final_date) {
        this.final_date = final_date;
    }

    /**
     * @return the provincesData
     */
    public SingleSelectOptionsList getProvincesData() {
        return provincesData;
    }

    /**
     * @param provincesData the provincesData to set
     */
    public void setProvincesData(SingleSelectOptionsList provincesData) {
        this.provincesData = provincesData;
    }

    /**
     * @return the countryData
     */
    public SingleSelectOptionsList getCountryData() {
        return countryData;
    }

    /**
     * @param countryData the countryData to set
     */
    public void setCountryData(SingleSelectOptionsList countryData) {
        this.countryData = countryData;
    }

    /**
     * @return the ddProvince
     */
    public DropDown getDdProvince() {
        return ddProvince;
    }

    /**
     * @param ddProvince the ddProvince to set
     */
    public void setDdProvince(DropDown ddProvince) {
        this.ddProvince = ddProvince;
    }

    /**
     * @return the ddCountry
     */
    public DropDown getDdCountry() {
        return ddCountry;
    }

    /**
     * @param ddCountry the ddCountry to set
     */
    public void setDdCountry(DropDown ddCountry) {
        this.ddCountry = ddCountry;
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal= this.getPassportSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the dataTableGathering
     */
    public HtmlDataTable getDataTableGathering() {
        return dataTableGathering;
    }

    /**
     * @param dataTableGathering the dataTableGathering to set
     */
    public void setDataTableGathering(HtmlDataTable dataTableGathering) {
        this.dataTableGathering = dataTableGathering;
    }

  

    /**
     * @return the taxonomicLevels
     */
    public SingleSelectOptionsList getTaxonomicLevels() {
        return taxonomicLevels;
    }

    /**
     * @param taxonomicLevels the taxonomicLevels to set
     */
    public void setTaxonomicLevels(SingleSelectOptionsList taxonomicLevels) {
        this.taxonomicLevels = taxonomicLevels;
    }

}
