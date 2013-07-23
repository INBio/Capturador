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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.component.html.HtmlInputHidden;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.inventory.*;
import org.inbio.ara.label.LabelSessionBean;
import org.inbio.ara.persistence.gathering.CollectionProtocolValuesEntity;
import org.inbio.ara.persistence.gathering.ProtocolAtributeEntity;
import org.inbio.ara.persistence.identification.PatternEntity;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;


/**
 *
 * @author gsulca
 */
public class NewIdentification extends AbstractPageBean {
    
private static long ROOT_TAXONOMICAL_RANGE_ID = 1L;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * @return the ROOT_TAXONOMICAL_RANGE_ID
     */
    public static long getROOT_TAXONOMICAL_RANGE_ID() {
        return ROOT_TAXONOMICAL_RANGE_ID;
    }

    /**
     * @param aROOT_TAXONOMICAL_RANGE_ID the ROOT_TAXONOMICAL_RANGE_ID to set
     */
    public static void setROOT_TAXONOMICAL_RANGE_ID(long aROOT_TAXONOMICAL_RANGE_ID) {
        ROOT_TAXONOMICAL_RANGE_ID = aROOT_TAXONOMICAL_RANGE_ID;
    }

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
    
    private HtmlPanelGrid gridpReIdentify = new HtmlPanelGrid();
    private TextField txCatalogNumber = new TextField();
    private TextField txTaxonName = new TextField();
    private TextField txIdentifierName = new TextField();
    // DropDown
    private DropDown ddStatus = new DropDown();
    // Datos de la lista
    private SingleSelectOptionsList ddStatusData = new SingleSelectOptionsList();
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
    
    public NewIdentification()
    {
        
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
        //System.out.println("*********** HIZO PRERENDER ***********");
        IdentificationSessionBean isb = this.getIdentificationSessionBean();
        //Load required data        
      
        this.setStatusData();
        
        this.setTypeData();
        
        //Load taxonomical range
        this.setTaxonomicLevelData();
        //load validator person
        this.loadValidatorData();
        
        //load addremove elements
        this.loadAddRemoveData(false);
        
        this.getDeleteConfirmationText().setValue(BundleHelper.getDefaultBundleValue("delete_confirmation", this.getMyLocale()));
        
        //if(isb.getSpecimenBarcodeList().length < 1 && isb.isResetReidentification())
        if(isb.isResetReidentification())
        {
            //System.out.println("Limpieza de variables desde el prerender");
            //limpiar variables
            this.ddStatusSelected = null;
            this.ddTypeSelected = null;
            this.ddTaxonomicalRangeSelected = null;
            this.ddValidatorSelected = null;
            isb.getArTaxonList().removeSelectedOptions();
            this.loadAddRemoveData(true);
            this.loadIdentificationsSelected(isb.getSelectedIdentifications());
            
            isb.setResetReidentification(false);
        }
        
        this.gridpReIdentify.setRendered(true);
       
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

    public void loadIdentificationsSelected(List<IdentificationDTO> identificationsSelected)
    {
        IdentificationSessionBean isb = this.getIdentificationSessionBean();
        Option[] optList = new Option[1];
        List<Option> newList = new ArrayList<Option>();
        
        int pos = 0;
        for(IdentificationDTO idDTO : identificationsSelected)
        {
             
             Option opt = new Option(new Long(optList.length), idDTO.getCatalogNumber());
             newList.add(opt);
             
             pos++;             
        }
        //isb.getArIdentifierList().setSelectedOptions(identificationIds);
        
        isb.setSpecimenBarcodeList(newList.toArray(new Option[newList.size()]));
        isb.setSpecimenBarcode("");
        isb.setSelectedIdentifications(null);
        
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

            
            //isb.getArIdentifierList().setAvailableOptions(new Option[0]);
            //isb.getArIdentifierList().setSelectedOptions(new Long[0]);
            
            //isb.getArTaxonList().setAvailableOptions(new Option[0]);
            //isb.getArTaxonList().setSelectedOptions(new Long[0]);
            isb.setArIdentifierList(new AddRemoveList());
            isb.setArTaxonList(new AddRemoveList());

        }

        // Taxon AddRemove
        if (isb.getArTaxonList() == null || isb.getArTaxonList().getAvailableOptions().length == 0 && this.ddTaxonomicalRangeSelected == null) {

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
        //System.out.println("Cantidad de elementos por rango =  "+taxonList.size());
        

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

        //En caso de que no se seleccione ningun "Status"
        if ( (selectedStatus == null || selectedStatus == -1) && isb.getSpecimenBarcodeList().length < 1) {
            MessageBean.setErrorMessageFromBundle("not_status_selected",
                                                  this.getMyLocale());
            return null;
        }

        //En caso de que no se seleccione ningun "Taxon"
        if (selectedTaxons == null || selectedTaxons.length == 0) {
            MessageBean.setErrorMessageFromBundle("not_taxon_selected",
                                                  this.getMyLocale());
            return null;
        }

        if(isb.getSpecimenBarcodeList().length < 1){
           selectedIdentifications = this.selectedDataTableIdenfications();//esto no se usa
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
            
            iDTO.setUserName(this.getAraSessionBean().getGlobalUserName());

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
        //this.btnReIdentifyAction();

        //Refresca los datos cargados.
        //this.getIdentificationSessionBean().getPagination().refreshList();              
         //Notificar al usuario
        MessageBean.setSuccessMessageFromBundle("create_identification_succes",
                this.getMyLocale());

        return null;

        // print the label (Agregado por Pula corrales)
        /*String  Id = this.getIdentificationSessionBean().getCurrentIdentificationDTO().getCatalogNumber();
        SpecimenDTO current =   this.getlabel$LabelSessionBean().getCurrentSpecimenDTO();
        this.getlabel$LabelSessionBean().setCurrentSpecimenDTO(current);
        return "edit";*/
    }

    /**
 * Retrieve a list of the identifications introduced in the system trough the
 * Bar code list GUI component
 * @return List<IdentificationDTO>
 */
    public List<IdentificationDTO> processBarcodeListIdenfications(){
       
        IdentificationDTO aIdentification = null;
        SpecimenDTO specimenTmp = null;

        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        ArrayList<IdentificationDTO> selectedIdentifications =
            new ArrayList<IdentificationDTO>();

        for(Option op : isb.getSpecimenBarcodeList()){
            
            aIdentification =
                (IdentificationDTO) isb.getInventoryFacade()
                    .getIdentificationByCatalogNumber(op.getLabel());
            
            //poner codigo de si es nulo buscar por specimenId
            if(aIdentification == null)//Si es nulo buscarlo en los especimenes
            {
                
                
                specimenTmp = isb.getInventoryFacade().getSpecimenByCatalogueNumber(op.getLabel());
                
                aIdentification = new IdentificationDTO();
                aIdentification.setCatalogNumber(op.getLabel());
                aIdentification.setCollectionId(specimenTmp.getCollectionId());
                aIdentification.setSpecimenKey(specimenTmp.getSpecimenKey());
            }
            
            if(aIdentification == null){ // si sigue siendo nulo entonces no existe
                
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
        Long currentColl = this.getAraSessionBean().getGlobalCollectionId();
        boolean useAlphanumericCatalogNumber = this.getIdentificationSessionBean().matchCollectionProtocol(currentColl,
                    ProtocolAtributeEntity.USE_ALPHANUMERIC_CATALOG_NUMBER.getId(),
                    CollectionProtocolValuesEntity.TRUE_VALUE.getValue());
        //probando el barcode
        String catalogueNumber = "";
        
            if(!useAlphanumericCatalogNumber && !isStringParseNumber(barcode))
            {
                
                Pattern p = Pattern.compile(PatternEntity.ALPHANUMERIC.getPattern());
            
                Matcher m = p.matcher(barcode);
            
                if (m.find()) {
                    catalogueNumber = m.group(1);

                }
            
        }
        else
        {
            catalogueNumber = barcode;
        }
        
        Option opt = new Option(new Long(optList.length), catalogueNumber);
        newList.add(opt);

        isb.setSpecimenBarcodeList(newList.toArray(new Option[newList.size()]));
        isb.setSpecimenBarcode("");
        
        return null;
    }
     
   
     private boolean isStringParseNumber(String str) {
        try {
            //Long.parseLong(str);
            Float.parseFloat(str);
            return true;
        } catch (Exception e){}
        return false;
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
     * Delete from the SpecimenBarcodeList  the selected items.
     * @return null
     */
     public String btnDeleteAllBarcodeAction() {

        IdentificationSessionBean isb = this.getIdentificationSessionBean();

        isb.setSpecimenBarcodeList(new Option[0]);
        isb.setSpecimenBarcodeSelected(new Long[0]);
        
        return null;
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

    
    /**
     * @return the identificationTable
     */
    public Table getIdentificationTable() {
        return identificationTable;
    }

    /**
     * @param identificationTable the identificationTable to set
     */
    public void setIdentificationTable(Table identificationTable) {
        this.identificationTable = identificationTable;
    }

    /**
     * @return the context
     */
    public FacesContext getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(FacesContext context) {
        this.context = context;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @param myLocale the myLocale to set
     */
    public void setMyLocale(Locale myLocale) {
        this.myLocale = myLocale;
    }

    /**
     * @return the txCatalogNumber
     */
    public TextField getTxCatalogNumber() {
        return txCatalogNumber;
    }

    /**
     * @param txCatalogNumber the txCatalogNumber to set
     */
    public void setTxCatalogNumber(TextField txCatalogNumber) {
        this.txCatalogNumber = txCatalogNumber;
    }

    /**
     * @return the txTaxonName
     */
    public TextField getTxTaxonName() {
        return txTaxonName;
    }

    /**
     * @param txTaxonName the txTaxonName to set
     */
    public void setTxTaxonName(TextField txTaxonName) {
        this.txTaxonName = txTaxonName;
    }

    /**
     * @return the txIdentifierName
     */
    public TextField getTxIdentifierName() {
        return txIdentifierName;
    }

    /**
     * @param txIdentifierName the txIdentifierName to set
     */
    public void setTxIdentifierName(TextField txIdentifierName) {
        this.txIdentifierName = txIdentifierName;
    }

    /**
     * @return the ddStatus
     */
    public DropDown getDdStatus() {
        return ddStatus;
    }

    /**
     * @param ddStatus the ddStatus to set
     */
    public void setDdStatus(DropDown ddStatus) {
        this.ddStatus = ddStatus;
    }

    /**
     * @return the ddStatusData
     */
    public SingleSelectOptionsList getDdStatusData() {
        return ddStatusData;
    }

    /**
     * @param ddStatusData the ddStatusData to set
     */
    public void setDdStatusData(SingleSelectOptionsList ddStatusData) {
        this.ddStatusData = ddStatusData;
    }

    /**
     * @return the ddStatusSelected
     */
    public Long getDdStatusSelected() {
        return ddStatusSelected;
    }

    /**
     * @param ddStatusSelected the ddStatusSelected to set
     */
    public void setDdStatusSelected(Long ddStatusSelected) {
        this.ddStatusSelected = ddStatusSelected;
    }

    /**
     * @return the ddType
     */
    public DropDown getDdType() {
        return ddType;
    }

    /**
     * @param ddType the ddType to set
     */
    public void setDdType(DropDown ddType) {
        this.ddType = ddType;
    }

    /**
     * @return the ddTypeData
     */
    public SingleSelectOptionsList getDdTypeData() {
        return ddTypeData;
    }

    /**
     * @param ddTypeData the ddTypeData to set
     */
    public void setDdTypeData(SingleSelectOptionsList ddTypeData) {
        this.ddTypeData = ddTypeData;
    }

    /**
     * @return the ddTypeSelected
     */
    public Long getDdTypeSelected() {
        return ddTypeSelected;
    }

    /**
     * @param ddTypeSelected the ddTypeSelected to set
     */
    public void setDdTypeSelected(Long ddTypeSelected) {
        this.ddTypeSelected = ddTypeSelected;
    }

    /**
     * @return the ddTaxonomicalRange
     */
    public DropDown getDdTaxonomicalRange() {
        return ddTaxonomicalRange;
    }

    /**
     * @param ddTaxonomicalRange the ddTaxonomicalRange to set
     */
    public void setDdTaxonomicalRange(DropDown ddTaxonomicalRange) {
        this.ddTaxonomicalRange = ddTaxonomicalRange;
    }

    /**
     * @return the ddTaxonomicalRangeData
     */
    public SingleSelectOptionsList getDdTaxonomicalRangeData() {
        return ddTaxonomicalRangeData;
    }

    /**
     * @param ddTaxonomicalRangeData the ddTaxonomicalRangeData to set
     */
    public void setDdTaxonomicalRangeData(SingleSelectOptionsList ddTaxonomicalRangeData) {
        this.ddTaxonomicalRangeData = ddTaxonomicalRangeData;
    }

    /**
     * @return the ddTaxonomicalRangeSelected
     */
    public Long getDdTaxonomicalRangeSelected() {
        return ddTaxonomicalRangeSelected;
    }

    /**
     * @param ddTaxonomicalRangeSelected the ddTaxonomicalRangeSelected to set
     */
    public void setDdTaxonomicalRangeSelected(Long ddTaxonomicalRangeSelected) {
        this.ddTaxonomicalRangeSelected = ddTaxonomicalRangeSelected;
    }

    /**
     * @return the dataTableIdentifications
     */
    public HtmlDataTable getDataTableIdentifications() {
        return dataTableIdentifications;
    }

    /**
     * @param dataTableIdentifications the dataTableIdentifications to set
     */
    public void setDataTableIdentifications(HtmlDataTable dataTableIdentifications) {
        this.dataTableIdentifications = dataTableIdentifications;
    }

    /**
     * @return the ddValidatorsData
     */
    public DropDown getDdValidatorsData() {
        return ddValidatorsData;
    }

    /**
     * @param ddValidatorsData the ddValidatorsData to set
     */
    public void setDdValidatorsData(DropDown ddValidatorsData) {
        this.ddValidatorsData = ddValidatorsData;
    }

    /**
     * @return the ddValidatorSelected
     */
    public Long getDdValidatorSelected() {
        return ddValidatorSelected;
    }

    /**
     * @param ddValidatorSelected the ddValidatorSelected to set
     */
    public void setDdValidatorSelected(Long ddValidatorSelected) {
        this.ddValidatorSelected = ddValidatorSelected;
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
     * @return the gridpReIdentify
     */
    public HtmlPanelGrid getGridpReIdentify() {
        return gridpReIdentify;
    }

    /**
     * @param gridpReIdentify the gridpReIdentify to set
     */
    public void setGridpReIdentify(HtmlPanelGrid gridpReIdentify) {
        this.gridpReIdentify = gridpReIdentify;
    }
    
}
