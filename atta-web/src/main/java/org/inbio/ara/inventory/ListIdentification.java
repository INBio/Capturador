/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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
package org.inbio.ara.inventory;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.OptionTitle;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.component.html.HtmlInputHidden;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.inventory.IdentificationDTO;
import org.inbio.ara.dto.inventory.IdentificationStatusDTO;
import org.inbio.ara.dto.inventory.IdentificationTypeDTO;
import org.inbio.ara.dto.inventory.IdentifierDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.label.LabelSessionBean;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListIdentification.java
 * @version Created on 09/07/2009, 03:09:43 PM
 * @author esmata
 */
public class ListIdentification extends AbstractPageBean {

    public static final long ROOT_TAXONOMICAL_RANGE_ID = 1L;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    //Bindings para la tabla que se utiliza para listar los especimenes
    private Table identificationTable = new Table();
    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;
    //Componentes graficos utilizados para las busquedas de especimenes
    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();
    private HtmlPanelGrid gridpReIdentify = new HtmlPanelGrid();
    private HtmlInputText txSearch = new HtmlInputText();
    private HtmlCommandButton btnSeach = new HtmlCommandButton();
    private HtmlCommandButton btnAdvSeach = new HtmlCommandButton();
    private HtmlCommandButton btnReIdentify = new HtmlCommandButton();
    private TextField txCatalogNumber = new TextField();
    private TextField txTaxonName = new TextField();
    private TextField txIdentifierName = new TextField();
    // DropDown
    private DropDown ddStatus = new DropDown();
    // Datos de la lista
    SingleSelectOptionsList ddStatusData = new SingleSelectOptionsList();
    //objeto selecionado.
    private Long ddStatusSelected = null;
    // Datos para asignar a los dropdown
    private DropDown ddType = new DropDown();
    // Datos de la lista
    private SingleSelectOptionsList ddTypeData = new SingleSelectOptionsList();
    // opción selecionada.
    private Long ddTypeSelected = null;
    // Datos para asignar a los dropdown
    private DropDown ddTaxonomicalRange = new DropDown();
    // Datos de la lista
    private SingleSelectOptionsList ddTaxonomicalRangeData = new SingleSelectOptionsList();
    // opción selecionada.
    private Long ddTaxonomicalRangeSelected = null;
    //Data table binding para la tabla que muetra los especimnes
    private HtmlDataTable dataTableIdentifications = new HtmlDataTable();
    private DropDown ddValidatorsData = new DropDown();
    private Long ddValidatorSelected = null;


    private HtmlInputHidden deleteConfirmationText = new HtmlInputHidden();
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListIdentification() {
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

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ListIdentification Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialize
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
        System.out.println("*********** HIZO PRERENDER ***********");
        IdentificationSessionBean isb = this.getIdentificationSessionBean();
        //Load required data
        long inicioT = System.currentTimeMillis();
        this.setStatusData();
        
        this.setTypeData();
        
        this.setTaxonomicLevelData();
        
        this.loadValidatorData();
        
        this.loadAddRemoveData(false);
        
        this.getDeleteConfirmationText().setValue(BundleHelper.getDefaultBundleValue("delete_confirmation", this.getMyLocale()));
        
        //------------------------------ Control de GUI -------------------------------
        if (isb.isAdvancedSearch()) {
            //Muestra el panel de busqueda avanzada
            this.gridpAdvancedSearch.setRendered(true);
        } //Verifica si esta re-identificando y muestra el panel
        else if (isb.isReIdentify()) {
            //Muestra el panel de reidentificacion
            this.gridpReIdentify.setRendered(true);
        }
        
        //-------------------------- Control de Paginador ------------------------------
        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        //long inicioT = System.currentTimeMillis();
        long finalT;
        if (isb.getPagination()==null) {
        //    System.out.println("Entro donde la paginacion es nula");
            isb.initDataProvider();
        }
        //Actualizar los datos del paginador
        else
        {
          //  System.out.println("Entro donde la paginacion NO es nula");
            isb.getPagination().refreshList();
        }
        //finalT = System.currentTimeMillis();
        //System.out.println("Tiempo al finalizar el prerender = "+(finalT-inicioT));
        //finalT=inicioT;
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
     * Load the Validators (person whith validator rol) into a DropDown component
     * on the interface
     */
    public void loadValidatorData() {

        Option option = null;
        String optionTitle = null;
        Option[] allOptionsInArray = null;
        IdentificationSessionBean isb = this.getIdentificationSessionBean();


        List<PersonDTO> aPList = isb.getValidatorsList();

        ArrayList<Option> allOptions = new ArrayList<Option>();

        // retrieve the default (no validator) option from the properties file.
        optionTitle = BundleHelper.getDefaultBundleValue("drop_down_default",
                                                         getMyLocale());
        option = new OptionTitle(optionTitle);

        allOptions.add(option);

        // Create the options on the dropdown
        for (PersonDTO aPDTO : aPList) {

            option = new Option(aPDTO.getPersonKey(),
                                aPDTO.getNaturalLongName());

            allOptions.add(option);
        }
        
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.ddValidatorsData.setItems(allOptions.toArray(allOptionsInArray));
    }

    /**
     * Load the Types information from the database into a dropdown component.
     */
    public void setTypeData() {


        IdentificationSessionBean isb = this.getIdentificationSessionBean();
        Option[] allOptionsInArray = null;
        String optionTitle = null;
        Option option = null;

        List<IdentificationTypeDTO> aITList = isb.getIdentificationTypeList();

        ArrayList<Option> allOptions = new ArrayList<Option>();
        
        // retrieve the default (no type) option from the properties file.
        optionTitle = BundleHelper.getDefaultBundleValue("drop_down_default",
                                                         getMyLocale());
        option = new OptionTitle(optionTitle);

        allOptions.add(option);

        // Populate the options on the dropdown
        for (IdentificationTypeDTO itDTO : aITList) {

            option = new Option(itDTO.getIdentificationTypeKey(),
                                itDTO.getName());

            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.ddTypeData.setOptions(allOptions.toArray(allOptionsInArray));
    }

    /**
     * Load the Identification Status information from the database to a
     * DropDown component
     */
    public void setStatusData() {

        IdentificationSessionBean isb = this.getIdentificationSessionBean();
        Option[] allOptionsInArray = null;
        String optionTitle = null;
        Option option = null;

        List<IdentificationStatusDTO> aITList = isb.getIdentificationStatusList();

        ArrayList<Option> allOptions = new ArrayList<Option>();
        
        // retrieve the default (No Status) option from the properties file.
        optionTitle = BundleHelper.getDefaultBundleValue("drop_down_default",
                                                         getMyLocale());
        option = new OptionTitle(optionTitle);

        allOptions.add(option);

        // Populate the options on the dropdown
        for (IdentificationStatusDTO isDTO : aITList) {

            option = new Option(isDTO.getIdentificationStatusKey(),
                                isDTO.getName());

            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.ddStatusData.setOptions(allOptions.toArray(allOptionsInArray));
    }

    /**
     * Load the Taxonomical hierarchy ranges to a DropDown in the GUI.
     */
    public void setTaxonomicLevelData() {

        IdentificationSessionBean isb = this.getIdentificationSessionBean();
        Option[] allOptionsInArray = null;
        String optionTitle = null;
        Option option = null;

        List<TaxonomicalRangeDTO> aTRList = isb.getTaxonomicalRangeList();

        ArrayList<Option> allOptions = new ArrayList<Option>();

        optionTitle = BundleHelper.getDefaultBundleValue("drop_down_default",
                                                         getMyLocale());
        option = new OptionTitle(optionTitle);

        allOptions.add(option);

        // Populate the options on the dropdown
        for (TaxonomicalRangeDTO trDTO : aTRList) {
            option = new Option(trDTO.getTaxonomicalRangeKey(), trDTO.getName());
            allOptions.add(option);
        }

        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.ddTaxonomicalRangeData.setOptions(allOptions.toArray(allOptionsInArray));
    }

    /**
     * Load or Clean the AddRemove components (Taxon and Identificator).
     * @param reset (if true, AddRemove components becomes empty)
     */
    public void loadAddRemoveData(boolean reset) {

        List<PersonDTO> identifierList = null;
        List<TaxonDTO> taxonList = null;
        List<Option> list = null;

        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        // Make AddRemove components empty.
        if (reset) {

            isb.getArIdentifierList().setAvailableOptions(new Option[0]);
            isb.getArIdentifierList().setSelectedOptions(new Long[0]);

            isb.getArTaxonList().setAvailableOptions(new Option[0]);
            isb.getArTaxonList().setSelectedOptions(new Long[0]);

        }

        // Taxon AddRemove
        if (isb.getArTaxonList() == null || isb.getArTaxonList().getAvailableOptions().length == 0) {

            // Retrieve taxons
            taxonList = isb.getAllTaxonByTaxonomicalRange(ROOT_TAXONOMICAL_RANGE_ID);
            this.setTaxonListOptions(taxonList);
        }

        // AddRemove de Identificadores
        if (isb.getArIdentifierList().getAvailableOptions() == null ||
            isb.getArIdentifierList().getAvailableOptions().length == 0) {

            list = new ArrayList<Option>();

            // Retrieve identifiers.
            identifierList = isb.getIdentifiersList();

            for (PersonDTO identifier : identifierList) {
                list.add(new Option(identifier.getPersonKey(),
                                    identifier.getNaturalLongName()));
            }

            isb.getArIdentifierList().setAvailableOptions(list.toArray(new Option[list.size()]));
        }

        // Set the titles
        isb.getArTaxonList().setLbTitle(
            BundleHelper.getDefaultBundleValue("taxon", this.getMyLocale()));

        isb.getArTaxonList().setLbAvailable(
            BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));

        isb.getArTaxonList().setLbSelected(
            BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));

        isb.getArIdentifierList().setLbTitle(
            BundleHelper.getDefaultBundleValue("person_identifier", this.getMyLocale()));

        isb.getArIdentifierList().setLbAvailable(
            BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));

        isb.getArIdentifierList().setLbSelected(
            BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));

    }

    /**
     * Show the advance search area.
     * @return null
     */
    public String btnAdvSeachAction() {

        IdentificationSessionBean isb = this.getIdentificationSessionBean();
        boolean advanced = isb.isAdvancedSearch();

        // sets all the necesary flags
        isb.setReIdentify(false);

        if (advanced == false) { //Mostrar panel de busqueda avanzada
            isb.setAdvancedSearch(true);
            this.gridpReIdentify.setRendered(false);

            //Deshabilitar busqueda simple
            this.txSearch.setRendered(false);
            this.btnSeach.setRendered(false);
            this.btnReIdentify.setRendered(false);

            //Cambia el text del boton de busqueda avanzada
            this.btnAdvSeach.setValue(
                    BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",
                    getMyLocale()));

        } else if (advanced == true) {
            isb.setAdvancedSearch(false);

            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            this.gridpReIdentify.setRendered(false);

            //Habilitar busqueda simple
            this.txSearch.setRendered(true);
            this.btnSeach.setRendered(true);
            this.btnReIdentify.setRendered(true);

            //Cambia el text del boton de busqueda avanzada
            this.btnAdvSeach.setValue(
                    BundleHelper.getDefaultBundleValue("advanced_search_specimen",
                    getMyLocale()));
        }

        return null;
    }

    /**
     * Show/Hide the Re-Identification box
     * @return null
     */
    public String btnReIdentifyAction() {

        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        boolean reIdentify = isb.isReIdentify();
        isb.setAdvancedSearch(false);

        if (reIdentify == false) { //Mostrar panel de Reidentificacion

            //Limpiar los add-remove components
            isb.setArTaxonList(new AddRemoveList());
            isb.setArIdentifierList(new AddRemoveList());

            isb.setReIdentify(true);
            this.gridpAdvancedSearch.setRendered(false);

            //Deshabilitar busqueda simple
            this.txSearch.setRendered(false);
            this.btnSeach.setRendered(false);
            this.btnAdvSeach.setRendered(false);

            //Cambia el text del boton de busqueda avanzada
            this.btnReIdentify.setValue(
                BundleHelper.getDefaultBundleValue("re_identify_back",
                                                   getMyLocale()));

            this.btnReIdentify.setStyle("width:190px");
            this.gridpReIdentify.setRendered(true);

        } else if (reIdentify == true) {

            isb.setReIdentify(false);

            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            isb.setSpecimenBarcodeList(new Option[0]);
            this.gridpReIdentify.setRendered(false);

            //Habilitar busqueda simple
            this.txSearch.setRendered(true);
            this.btnSeach.setRendered(true);
            this.btnAdvSeach.setRendered(true);

            //Cambia el text del boton de busqueda avanzada
            this.btnReIdentify.setValue(
                BundleHelper.getDefaultBundleValue("re_identify",
                                                   getMyLocale()));

            this.btnReIdentify.setStyle("width:160px");
            this.loadAddRemoveData(true);
        }

        return null;
    }

    /**
     * Process and execute the text of the search box. Results end being paginated
     * in the interface.
     * @return null
     */
    public String btnSearchAction() {

        String userImput = "";
        int totalResults = 0;
        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        // sets all the necesary flags
        isb.setAdvancedSearch(false);
        isb.setReIdentify(false);


        if (txSearch.getValue() != null) {
            userImput = this.txSearch.getValue().toString();
        }

        userImput = userImput.trim();

        if (userImput.length() == 0) {
            //Se desabilitan las banderas de busqueda simple y avanzada
            isb.setQueryModeSimple(false);
            isb.setQueryMode(false);

        } else {

            //Setear el string para consulta simple del SessionBean
            isb.setConsultaSimple(userImput);

            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            isb.setQueryModeSimple(true);

            //Desabilitar la bandera de busqueda avanzada
            isb.setQueryMode(false);
        }

        isb.getPagination().firstResults();

        return null;
    }

    /**
     * Process and execute the parameters of an advance search, results are returned
     * paginated
     * @return null
     */
    public String btnProceedSearcAction() {

        String indentifiersString = "";
        IdentificationDTO consulta = new IdentificationDTO();
        List<IdentifierDTO> identifierList = new ArrayList();

        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        // retrieve the necesary values from the interface bindings.
        String catalogNumber = (String) txCatalogNumber.getValue();
        String taxonName = (String) txTaxonName.getValue();

        if (catalogNumber != null && !catalogNumber.isEmpty()) {
            consulta.setCatalogNumber(catalogNumber);
        }

        if (taxonName != null && !taxonName.isEmpty()) {
            consulta.setTaxonString(taxonName);
        }

        consulta.setStatusId(this.ddStatusSelected);
        consulta.setTypeId(this.ddTypeSelected);

        indentifiersString = (String) txIdentifierName.getValue();

        if (indentifiersString != null && !indentifiersString.isEmpty()) {
            String[] tokens = indentifiersString.split(" ");

            for (String token : tokens) {
                identifierList.add(new IdentifierDTO(token));
            }

            consulta.setIdentifiers(identifierList);
        }

        //Setear el SpecimenDTO del SessionBean utilizado para realizar la consulta
        isb.setQueryIdentificationDTO(consulta);

        //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        isb.setQueryMode(true);

        //Desabilitar la bandera de busqueda simple
        isb.setQueryModeSimple(false);


        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        isb.getPagination().firstResults();

        this.getTxSearch().setValue("");

        return null;
    }

    /**
     * Update the taxon addRemove component depending on the taxonomical level
     * DropDown
     * @return null
     */
    public String updateTaxonListAction() {
        List<TaxonDTO> taxonList = null;
        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        // retrieve all links by its taxonomical range/level.
        taxonList = isb.getAllTaxonByTaxonomicalRange(this.ddTaxonomicalRangeSelected);
        this.setTaxonListOptions(taxonList);

        return null;
    }

    /**
     * Populate the taxon AddRemove GUI component wthi the taxon list passed by
     * parameter
     * @param Taxon List.
     */
    private void setTaxonListOptions(List<TaxonDTO> taxonList) {

        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        List<Option> list = new ArrayList<Option>();
        AddRemoveList arTaxon = isb.getArTaxonList();

        for (TaxonDTO taxon : taxonList) {
            list.add(new Option(taxon.getTaxonKey(), taxon.getDefaultName()));
        }

        arTaxon.setAvailableOptions(list.toArray(new Option[list.size()]));
    }

/**
 * Return a list of the selected identifications of the Table (selected by checkbox).
 * @return List<IdentificationDTO>
 */
    public List<IdentificationDTO> selectedDataTableIdenfications(){

        IdentificationDTO aIdentification = null;

        ArrayList<IdentificationDTO> selectedIdentifications =
            new ArrayList<IdentificationDTO>();

        int rowCount = this.getDataTableIdentifications().getRowCount();

        for (int i = 0; i < rowCount; i++) { //Obtener elementos seleccionados
            this.getDataTableIdentifications().setRowIndex(i);
            aIdentification = (IdentificationDTO) this.getDataTableIdentifications().getRowData();

            if (aIdentification.isSelected()) {
                selectedIdentifications.add(aIdentification);
            }
        }
        return selectedIdentifications;
    }

/**
 * Retrieve a list of the identifications introduced in the system trough the
 * Bar code list GUI component
 * @return List<IdentificationDTO>
 */
    public List<IdentificationDTO> processBarcodeListIdenfications(){

        IdentificationDTO aIdentification = null;

        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        ArrayList<IdentificationDTO> selectedIdentifications =
            new ArrayList<IdentificationDTO>();

        for(Option op : isb.getSpecimenBarcodeList()){

            aIdentification =
                (IdentificationDTO) isb.getInventoryFacade()
                    .getIdentificationByCatalogNumber(op.getLabel());

            if(aIdentification == null){
                MessageBean.
                        setErrorMessageFromBundle( "identification_does_not_exists"
                        ,this.getMyLocale()
                        , op.getLabel());
                continue;
            }

            selectedIdentifications.add(aIdentification);
        }

    return selectedIdentifications;
}


    /**
     * Process the parameters and execute the reidentification with the selected
     * items.
     * @return null
     */
    public String btnProceedReIdentifyAction() {

        List<IdentificationDTO> selectedIdentifications = null;

        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        Long[] selectedIdentifiers = isb.getArIdentifierList().getSelectedOptions();
        Long[] selectedTaxons = isb.getArTaxonList().getSelectedOptions();

        Long selectedValidator = this.ddValidatorSelected;
        Long selectedStatus = this.ddStatusSelected;
        Long selectedType = this.ddTypeSelected;

        IdentifierDTO newIdentifier = null;
        TaxonDTO newTaxon = null;

        int arrayLength = -1;

        //En caso de que no se seleccione ningun elemento
        if ( (selectedStatus == null || selectedStatus == -1) && isb.getSpecimenBarcodeList().length < 1) {
            MessageBean.setErrorMessageFromBundle("not_status_selected",
                                                  this.getMyLocale());
            return null;
        }

        //En caso de que no se seleccione ningun elemento
        if (selectedTaxons == null || selectedTaxons.length == 0) {
            MessageBean.setErrorMessageFromBundle("not_taxon_selected",
                                                  this.getMyLocale());
            return null;
        }

        if(isb.getSpecimenBarcodeList().length < 1){
           selectedIdentifications = this.selectedDataTableIdenfications();
        }else{
           selectedIdentifications = this.processBarcodeListIdenfications();
        }

        for(IdentificationDTO iDTO: selectedIdentifications){

            iDTO.setTypeId(selectedType);
            iDTO.setStatusId(selectedStatus);
            iDTO.setValuerPerson(new PersonDTO(selectedValidator));

            arrayLength = selectedTaxons.length;

            if(arrayLength > 1 && !iDTO.isMultitaxon() ){
                MessageBean.setErrorMessageFromBundle( "cant_reidentify_single_taxon" ,this.getMyLocale());
                return null;
            }

            iDTO.setIdentificationDate(Calendar.getInstance());
            iDTO.setTaxa(new ArrayList<TaxonDTO>());

            // Add taxons
            for (int t = 0; t < arrayLength; t++) {
                newTaxon = new TaxonDTO(selectedTaxons[t]);
                iDTO.getTaxa().add(newTaxon);
            }

            iDTO.setIdentifiers(new ArrayList<IdentifierDTO>());

            // Agrega identificadores
            if (selectedIdentifiers != null) {
                arrayLength = selectedIdentifiers.length;
                // Agrega taxones
                for (int t = 0; t < arrayLength; t++) {
                    newIdentifier = new IdentifierDTO(selectedIdentifiers[t]);
                    iDTO.getIdentifiers().add(newIdentifier);
                }
            }
        }

        //En caso de que no se seleccione ningun elemento
        if (selectedIdentifications == null || selectedIdentifications.size() == 0) {
            MessageBean.setErrorMessageFromBundle("not_identification_selected",
                                                  this.getMyLocale());
            return null;
        }

        //Realiza la re-identificación
        isb.reidentify(selectedIdentifications);

        //Cierra el panel de reidentificación.
        this.btnReIdentifyAction();

        //Refresca los datos cargados.
        this.getIdentificationSessionBean().getPagination().refreshList();
              
        this.loadAddRemoveData(true);

        return null;

        // print the label (Agregado por Pula corrales)
        /*String  Id = this.getIdentificationSessionBean().getCurrentIdentificationDTO().getCatalogNumber();
        SpecimenDTO current =   this.getlabel$LabelSessionBean().getCurrentSpecimenDTO();
        this.getlabel$LabelSessionBean().setCurrentSpecimenDTO(current);
        return "edit";*/
    }

    /**
 * Add a new barcode to the list that will be procesated after.
 * @return
 */
     public String btnAddBarcodeAction() {

        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        Option[] optList = isb.getSpecimenBarcodeList();
        
        List<Option> newList = new ArrayList<Option>();
        
        if(optList == null)
            optList = new Option[1];

        for (Option op : optList)
            newList.add(op);

        String barcode = isb.getSpecimenBarcode();

        Option opt = new Option(new Long(optList.length), barcode);
        newList.add(opt);

        isb.setSpecimenBarcodeList(newList.toArray(new Option[newList.size()]));
        isb.setSpecimenBarcode("");
        
        return null;
    }

    /**
     * Delete from the SpecimenBarcodeList  the selected items.
     * @return null
     */
     public String btnDeleteBarcodeAction() {

        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        Option[] optList = isb.getSpecimenBarcodeList();
        Long[] selectedList = isb.getSpecimenBarcodeSelected();

        List<Option> newList = new ArrayList<Option>();

        if(optList == null)
            return null;

        for (Option op : optList)
            newList.add(op);

        Option op = null;
        for (Long selected: selectedList){
            for(int i = 0; i < newList.size(); i++){
                op = newList.get(i);
                if(selected.equals(op.getValue())){
                    newList.remove(op);
                }
            }
        }


        
        isb.setSpecimenBarcodeList(newList.toArray(new Option[newList.size()]));
        
        return null;
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        IdentificationSessionBean isb = this.getIdentificationSessionBean();
        return isb.getQuantityTotal();
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IdentificationSessionBean getIdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("inventory$IdentificationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

// <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public HtmlCommandButton getBtnAdvSeach() {
        return btnAdvSeach;
    }

    public void setBtnAdvSeach(HtmlCommandButton btnAdvSeach) {
        this.btnAdvSeach = btnAdvSeach;
    }

    public HtmlCommandButton getBtnSeach() {
        return btnSeach;
    }

    public void setBtnSeach(HtmlCommandButton btnSeach) {
        this.btnSeach = btnSeach;
    }

    public HtmlDataTable getDataTableIdentifications() {
        return dataTableIdentifications;
    }

    public void setDataTableIdentifications(HtmlDataTable dataTableIdentifications) {
        this.dataTableIdentifications = dataTableIdentifications;
    }

    public HtmlPanelGrid getGridpAdvancedSearch() {
        return gridpAdvancedSearch;
    }

    public void setGridpAdvancedSearch(HtmlPanelGrid gridpAdvancedSearch) {
        this.gridpAdvancedSearch = gridpAdvancedSearch;
    }

    public HtmlPanelGrid getGridpReIdentify() {
        return gridpReIdentify;
    }

    public void setGridpReIdentify(HtmlPanelGrid gridpReIdentify) {
        this.gridpReIdentify = gridpReIdentify;
    }

    public Table getIdentificationTable() {
        return identificationTable;
    }

    public void setIdentificationTable(Table identificationTable) {
        this.identificationTable = identificationTable;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }

    public void setMyLocale(Locale myLocale) {
        this.myLocale = myLocale;
    }

    public HtmlInputText getTxSearch() {
        return txSearch;
    }

    public void setTxSearch(HtmlInputText txSearch) {
        this.txSearch = txSearch;
    }

    public HtmlCommandButton getBtnReIdentify() {
        return btnReIdentify;
    }

    public void setBtnReIdentify(HtmlCommandButton btnReIdentify) {
        this.btnReIdentify = btnReIdentify;
    }

    public TextField getTxCatalogNumber() {
        return txCatalogNumber;
    }

    public void setTxCatalogNumber(TextField txCatalogNumber) {
        this.txCatalogNumber = txCatalogNumber;
    }

    public TextField getTxIdentifierName() {
        return txIdentifierName;
    }

    public void setTxIdentifierName(TextField txIdentifierName) {
        this.txIdentifierName = txIdentifierName;
    }

    public TextField getTxTaxonName() {
        return txTaxonName;
    }

    public void setTxTaxonName(TextField txTaxonName) {
        this.txTaxonName = txTaxonName;
    }

    public DropDown getDdStatus() {
        return ddStatus;
    }

    public void setDdStatus(DropDown ddStatus) {
        this.ddStatus = ddStatus;
    }

    public DropDown getDdType() {
        return ddType;
    }

    public void setDdType(DropDown ddType) {
        this.ddType = ddType;
    }

    public SingleSelectOptionsList getDdStatusData() {
        return ddStatusData;
    }

    public void setDdStatusData(SingleSelectOptionsList ddStatusData) {
        this.ddStatusData = ddStatusData;
    }

    public SingleSelectOptionsList getDdTypeData() {
        return ddTypeData;
    }

    public void setDdTypeData(SingleSelectOptionsList ddTypeData) {
        this.ddTypeData = ddTypeData;
    }

    public Long getDdStatusSelected() {
        return ddStatusSelected;
    }

    public void setDdStatusSelected(Long ddStatusSelected) {
        this.ddStatusSelected = ddStatusSelected;
    }

    public Long getDdTypeSelected() {
        return ddTypeSelected;
    }

    public void setDdTypeSelected(Long ddTypeSelected) {
        this.ddTypeSelected = ddTypeSelected;
    }

    public SingleSelectOptionsList getDdTaxonomicalRangeData() {
        return ddTaxonomicalRangeData;
    }

    public void setDdTaxonomicalRangeData(SingleSelectOptionsList ddTaxonomicalRangeData) {
        this.ddTaxonomicalRangeData = ddTaxonomicalRangeData;
    }

    public DropDown getDdTaxonomicalRange() {
        return ddTaxonomicalRange;
    }

    public void setDdTaxonomicalRange(DropDown ddTaxonomicalRange) {
        this.ddTaxonomicalRange = ddTaxonomicalRange;
    }

    public Long getDdTaxonomicalRangeSelected() {
        return ddTaxonomicalRangeSelected;
    }

    public void setDdTaxonomicalRangeSelected(Long ddTaxonomicalRangeSelected) {
        this.ddTaxonomicalRangeSelected = ddTaxonomicalRangeSelected;
    }

    public Long getDdValidatorSelected() {
        return ddValidatorSelected;
    }

    public void setDdValidatorSelected(Long ddValidatorSelected) {
        this.ddValidatorSelected = ddValidatorSelected;
    }

    public DropDown getDdValidatorsData() {
        return ddValidatorsData;
    }

    public void setDdValidatorsData(DropDown ddValidatorsData) {
        this.ddValidatorsData = ddValidatorsData;
    }

    /**
     * @return the deleteConfirmationText
     */
    public HtmlInputHidden getDeleteConfirmationText() {
        return deleteConfirmationText;
    }

    public void setDeleteConfirmationText(HtmlInputHidden deleteConfirmationText) {
        this.deleteConfirmationText = deleteConfirmationText;
    }

    

   // </editor-fold>
}

