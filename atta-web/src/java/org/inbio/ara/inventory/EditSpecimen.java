/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.RadioButtonGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.component.html.HtmlInputHidden;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.dto.inventory.LifeStageSexDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.label.LabelSessionBean;
import org.inbio.ara.persistence.specimen.SpecimenCategoryEntity;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditSpecimen.java
 * @version Created on 04/08/2009, 10:46:32 AM
 * @author esmata
 */

public class EditSpecimen extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;
    //Binding para el valor default de los drop downs de sexo y estadio
    private Long invalidValueSex = null;
    private Long invalidValueStage = null;
    //Binding de los componentes graficos de la ficha de especimen
    private TextField txCatalogNumber = new TextField();
    private TextField txInstitution = new TextField();
    private TextField txCollection = new TextField();
    private TextField txGatheringId = new TextField();
    private TextField txWhole = new TextField();
    private TextField txFragments = new TextField();
    private Label lbTitleEdit = new Label();
    private DropDown ddCategory = new DropDown();
    private DropDown ddExtraction = new DropDown();
    private DropDown ddType = new DropDown();
    private DropDown ddOrigin = new DropDown();
    private DropDown ddGatheringMethod = new DropDown();
    private DropDown ddPreservationMedium = new DropDown();
    private DropDown ddSubstrate = new DropDown();
    private DropDown ddStorage = new DropDown();
    private DropDown ddSex = new DropDown();
    private DropDown ddStage = new DropDown();
    private TextField txQuantity = new TextField();
    private RadioButtonGroup rbDiscarded = new RadioButtonGroup();
    //Binding de la tabla para mostrar los sexos y estadios
    private HtmlDataTable dataTableSexStage = new HtmlDataTable();
    //En esta variable se setearan los datos del drop down de gathering observation
    private SingleSelectOptionsList gatheringObservationData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de gathering observation
    private SingleSelectOptionsList specimenCategoryData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de specimenType
    private SingleSelectOptionsList specimenTypeData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de origen
    private SingleSelectOptionsList originData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de medio de preserva
    private SingleSelectOptionsList preservationMediumData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de tipo de almacenamiento
    private SingleSelectOptionsList storageTypeData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de life stage
    private SingleSelectOptionsList lifeStageData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de sex
    private SingleSelectOptionsList sexData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de straction type
    private SingleSelectOptionsList extractionTypeData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de substrate
    private SingleSelectOptionsList substrateData = new SingleSelectOptionsList();

    private HtmlInputHidden deleteConfirmationText = new HtmlInputHidden();
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditSpecimen() {
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
            log("EditSpecimen Initialization Failure", e);
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


        this.deleteConfirmationText.setValue(BundleHelper.getDefaultBundleValue

                    ("delete_confirmation", this.getMyLocale()));
        
        // --- Cargar los valores de los dropdowns y del radio button group de discarded ---------------------
        this.getGatheringObservationData().
                setOptions(setSelectionListDropDownData(SelectionListEntity.GATHERING_METHOD_OBSERVATION.getId()));
        this.getSpecimenCategoryData().
                setOptions(setSelectionListDropDownData(SelectionListEntity.SPECIMEN_CATEGORY.getId()));
        this.getSpecimenTypeData().
                setOptions(setSelectionListDropDownData(SelectionListEntity.SPECIMEN_TYPE.getId()));
        this.getOriginData().
                setOptions(setSelectionListDropDownData(SelectionListEntity.ORIGIN.getId()));
        this.getPreservationMediumData().
                setOptions(setSelectionListDropDownData(SelectionListEntity.PRESERVATION_MEDIUM.getId()));
        this.getStorageTypeData().
                setOptions(setSelectionListDropDownData(SelectionListEntity.STORAGE_TYPE.getId()));
        this.getLifeStageData().
                setOptions(setSelectionListDropDownData(SelectionListEntity.LIFE_STAGE.getId()));
        this.getSexData().
                setOptions(setSelectionListDropDownData(SelectionListEntity.SEX.getId()));
        this.getStractionTypeData().
                setOptions(setSelectionListDropDownData(SelectionListEntity.EXTRACTION_TYPE.getId()));
        this.getSubstrateData().
                setOptions(setSelectionListDropDownData(SelectionListEntity.SUBSTRATE.getId()));
        setDiscardedOptions(); //Opciones para el radioButtonGroup de discarded
        // --------------------------------------------------------------------------------------------------
        //Obtener el SpecimenDTO actual
        SpecimenDTO s = this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO();
        //Cargar el texto del titulo de edicion
        this.getLbTitleEdit().setText(BundleHelper.getDefaultBundleValue
                ("editing_specimen",this.getMyLocale())+" "+s.getCatalogNumber()+"   "+
                BundleHelper.getDefaultBundleValue("collection", this.getMyLocale())+": "+s.getCollectionName());
        //Mostrar la ficha del especimen a editar
        this.txCatalogNumber.setText(s.getCatalogNumber());
        this.txCollection.setText(s.getCollectionName());
        this.txGatheringId.setText(s.getGatheringObsevationId());
        this.txInstitution.setText(s.getInstitutionCode());
        this.txWhole.setText(s.getNumberWhole());
        this.txFragments.setText(s.getNumberFragments());
        //Verificar la categoria, si es individual deshabilitar el campo cantidad
        Long category = s.getCategoryId();
        if(category!=null){
            if (category.equals(SpecimenCategoryEntity.INDIVIDUAL.getId())) {
                this.txQuantity.setText(new Long(1));
                this.txQuantity.setDisabled(true);
            }
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
     * Metodo para obtener los datos a mostrar en los drop downs de la
     * ventana de edit que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    public Option[] setSelectionListDropDownData(Long selectionListEntityId){
        Long currentCollection = this.getAraSessionBean().getGlobalCollectionId();
        List<SelectionListDTO> DTOList = this.getinventory$SpecimenSessionBean().
                setSelectionListDropDownData(selectionListEntityId,currentCollection);
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue(
                "drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(SelectionListDTO slDTO : DTOList){
            option = new Option(slDTO.getValueId(), slDTO.getValueName());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Metodo que carga las opciones para discarded
     */
    private void setDiscardedOptions(){
        SingleSelectOptionsList aux = new SingleSelectOptionsList();
        Option op1 = new Option(false, BundleHelper.getDefaultBundleValue(
                "no", this.getMyLocale()));
        Option op2 = new Option(true, BundleHelper.getDefaultBundleValue(
                "yes", this.getMyLocale()));
        Option options[] = {op1,op2};
        aux.setOptions(options);
        this.rbDiscarded.setItems(aux.getOptions());
    }

    /**
     * Metodo ejecutado por el drop down de categorias para validar lo siguiente:
     * a) Si se selecciona categoria individual, se debe verificar que la lista de sexos y estadios
     *    tenga solo una fila
     * b) En categoria individual, deshabilitar campo de cantidad
     */
    public String validateCategoryByStageAndSex(){

        //Mostrar campo de cantidad, en caso de que estuviera desactivado
        this.txQuantity.setDisabled(false);

        int countStageSex = this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO().
                getLifeStageSexList().size();
        Long category = this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO().getCategoryId();
        if(category!=null){
            // Si es individual,solo debe haber una entrada
            if(countStageSex > 1 && category.equals(SpecimenCategoryEntity.INDIVIDUAL.getId())){
                this.getinventory$SpecimenSessionBean().setSpecimenValid(false);
                this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO().setCategoryId(null);
                MessageBean.setErrorMessageFromBundle("error_category_sex_stage", this.getMyLocale());
                return null;
            }
            // Si es individual, no debe haber cantidad en sexos y estadios
             else if(category.equals(SpecimenCategoryEntity.INDIVIDUAL.getId())){
                 this.txQuantity.setText(new Long(1));
                 this.txQuantity.setDisabled(true);
             }

             this.getinventory$SpecimenSessionBean().setSpecimenValid(true);
        }
        return null;
    }


    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
   protected LabelSessionBean getlabel$LabelSessionBean() {
        return (LabelSessionBean) getBean("label$LabelSessionBean");
    }


    /**
     * Metodo encargado de mandar a persistir el SpecimenDTO editado por el usuario
     */
    public String btnSaveEdit_action() {

        if(this.getinventory$SpecimenSessionBean().isSpecimenValid()){
            //Persistir
            this.getinventory$SpecimenSessionBean().getInventoryFacade().saveSpecimen(
                    this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO());
            //Actualizar los datos del currentSpecimenDTO
            Long specimenId = this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO().getSpecimenKey();
            this.getinventory$SpecimenSessionBean().setCurrentSpecimenDTO(
                    this.getinventory$SpecimenSessionBean().getInventoryFacade().getSpecimenById(specimenId));
            //Mostrar mensage de operacion exitosa
            MessageBean.setSuccessMessageFromBundle("success_editing_specimen", this.getMyLocale());
            //Refrescar el data provider del paginador
            this.getinventory$SpecimenSessionBean().getPagination().setTotalResults
                    (this.getinventory$SpecimenSessionBean().getInventoryFacade().countSpecimens().intValue());
            this.getinventory$SpecimenSessionBean().getPagination().refreshList();
        }
        else{
            //Mostrar mensaje de que no se puede persistir el currentSpecimenDTO
            MessageBean.setErrorMessageFromBundle("error_saving_specimen", this.getMyLocale());
        }
        return null;
        //Agregado por Paula Corrales
        /*this.getlabel$LabelSessionBean().setCurrentSpecimenDTO(this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO());
        return "edit";*/
    }

    /**
     * Metodo encargado de agregar nuevos sexos y estadio al specimenDTO que
     * esta siendo editado por el usuario
     */
    public String btnAddStageSex_action() {
        //Obtener los datos de estadio, sexo y cantidad
        Long quantity = null;
        if (this.getTxQuantity().getText() != null) {
            quantity = Long.valueOf(this.getTxQuantity().getText().toString());
        }
        Long sex = (Long) this.getDdSex().getSelected();
        Long stage = (Long) this.getDdStage().getSelected();
        Long category = this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO().getCategoryId();
        //Si alguno de los tres es nulo, mandar error
        if (sex==null || stage==null || quantity == null) {
            MessageBean.setErrorMessageFromBundle("error_stage_sex_add", this.getMyLocale());
            return null;
        }
        //Debe haber una categoria seleccionada
        if(category==null){
            MessageBean.setErrorMessageFromBundle("choose_category", this.getMyLocale());
            return null;
        }
        //Si el tipo de especimen es individual, solo puede tener un sexo y estadio
        if (category.equals(SpecimenCategoryEntity.INDIVIDUAL.getId()) &&
                this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO().getLifeStageSexList().size() >= 1) {
            // No se pueden agregar mas sexos y estadios
            //this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO().setCategoryId(null);
            MessageBean.setErrorMessageFromBundle("error_stage_sex_add_individual", this.getMyLocale());
            return null;
        }
        else {
            String sexName = getSexLabel(sex);
            String stageName = getStageLabel(stage);
            LifeStageSexDTO lssDTO = new LifeStageSexDTO();
            lssDTO.setQuantity(quantity);
            SelectionListDTO sexDTO = new SelectionListDTO();
            sexDTO.setSelectionListEntityId(SelectionListEntity.SEX.getId());
            sexDTO.setValueId(sex);
            sexDTO.setValueName(sexName);
            SelectionListDTO stageDTO = new SelectionListDTO();
            stageDTO.setSelectionListEntityId(SelectionListEntity.LIFE_STAGE.getId());
            stageDTO.setValueId(stage);
            stageDTO.setValueName(stageName);
            lssDTO.setLifeStageDTO(stageDTO);
            lssDTO.setSexDTO(sexDTO);
            this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO().getLifeStageSexList().add(lssDTO);
            return null;
        }
    }
    
    /**
     * @param sex id
     * @return la etiqueta correspondiente a ese sex id
     */
    private String getSexLabel(Long id){
        Option[] my_options = this.setSelectionListDropDownData(SelectionListEntity.SEX.getId());
        String result = "";
        for (int i = 0; i < my_options.length; i++) {
            if (my_options[i].getValue() != null) {
                Long my_id = Long.valueOf(my_options[i].getValue().toString());
                if (my_id.equals(id)) {
                    result = my_options[i].getLabel();
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * @param stage id
     * @return la etiqueta correspondiente a ese stage id
     */
    private String getStageLabel(Long id){
        Option[] my_options = this.setSelectionListDropDownData(SelectionListEntity.LIFE_STAGE.getId());
        String result = "";
        for (int i = 0; i < my_options.length; i++) {
            if (my_options[i].getValue() != null) {
                Long my_id = Long.valueOf(my_options[i].getValue().toString());
                if (my_id.equals(id)) {
                    result = my_options[i].getLabel();
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
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
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
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
     * @return the txInstitution
     */
    public TextField getTxInstitution() {
        return txInstitution;
    }

    /**
     * @param txInstitution the txInstitution to set
     */
    public void setTxInstitution(TextField txInstitution) {
        this.txInstitution = txInstitution;
    }

    /**
     * @return the txCollection
     */
    public TextField getTxCollection() {
        return txCollection;
    }

    /**
     * @param txCollection the txCollection to set
     */
    public void setTxCollection(TextField txCollection) {
        this.txCollection = txCollection;
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
     * @return the ddCategory
     */
    public DropDown getDdCategory() {
        return ddCategory;
    }

    /**
     * @param ddCategory the ddCategory to set
     */
    public void setDdCategory(DropDown ddCategory) {
        this.ddCategory = ddCategory;
    }

    /**
     * @return the ddExtraction
     */
    public DropDown getDdExtraction() {
        return ddExtraction;
    }

    /**
     * @param ddExtraction the ddExtraction to set
     */
    public void setDdExtraction(DropDown ddExtraction) {
        this.ddExtraction = ddExtraction;
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
     * @return the ddOrigin
     */
    public DropDown getDdOrigin() {
        return ddOrigin;
    }

    /**
     * @param ddOrigin the ddOrigin to set
     */
    public void setDdOrigin(DropDown ddOrigin) {
        this.ddOrigin = ddOrigin;
    }

    /**
     * @return the ddGatheringMethod
     */
    public DropDown getDdGatheringMethod() {
        return ddGatheringMethod;
    }

    /**
     * @param ddGatheringMethod the ddGatheringMethod to set
     */
    public void setDdGatheringMethod(DropDown ddGatheringMethod) {
        this.ddGatheringMethod = ddGatheringMethod;
    }

    /**
     * @return the ddPreservationMedium
     */
    public DropDown getDdPreservationMedium() {
        return ddPreservationMedium;
    }

    /**
     * @param ddPreservationMedium the ddPreservationMedium to set
     */
    public void setDdPreservationMedium(DropDown ddPreservationMedium) {
        this.ddPreservationMedium = ddPreservationMedium;
    }

    /**
     * @return the ddSubstrate
     */
    public DropDown getDdSubstrate() {
        return ddSubstrate;
    }

    /**
     * @param ddSubstrate the ddSubstrate to set
     */
    public void setDdSubstrate(DropDown ddSubstrate) {
        this.ddSubstrate = ddSubstrate;
    }

    /**
     * @return the ddStorage
     */
    public DropDown getDdStorage() {
        return ddStorage;
    }

    /**
     * @param ddStorage the ddStorage to set
     */
    public void setDdStorage(DropDown ddStorage) {
        this.ddStorage = ddStorage;
    }

    /**
     * @return the lbTitleEdit
     */
    public Label getLbTitleEdit() {
        return lbTitleEdit;
    }

    /**
     * @param lbTitleEdit the lbTitleEdit to set
     */
    public void setLbTitleEdit(Label lbTitleEdit) {
        this.lbTitleEdit = lbTitleEdit;
    }

    /**
     * @return the txWhole
     */
    public TextField getTxWhole() {
        return txWhole;
    }

    /**
     * @param txWhole the txWhole to set
     */
    public void setTxWhole(TextField txWhole) {
        this.txWhole = txWhole;
    }

    /**
     * @return the txFragments
     */
    public TextField getTxFragments() {
        return txFragments;
    }

    /**
     * @param txFragments the txFragments to set
     */
    public void setTxFragments(TextField txFragments) {
        this.txFragments = txFragments;
    }

    /**
     * @return the rbDiscarted
     */
    public RadioButtonGroup getRbDiscarded() {
        return rbDiscarded;
    }

    /**
     * @param rbDiscarted the rbDiscarted to set
     */
    public void setRbDiscarded(RadioButtonGroup rbDiscarded) {
        this.rbDiscarded = rbDiscarded;
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
     * @return the dataTableSexStage
     */
    public HtmlDataTable getDataTableSexStage() {
        return dataTableSexStage;
    }

    /**
     * @param dataTableSexStage the dataTableSexStage to set
     */
    public void setDataTableSexStage(HtmlDataTable dataTableSexStage) {
        this.dataTableSexStage = dataTableSexStage;
    }

    /**
     * @return the gatheringObservationData
     */
    public SingleSelectOptionsList getGatheringObservationData() {
        return gatheringObservationData;
    }

    /**
     * @param gatheringObservationData the gatheringObservationData to set
     */
    public void setGatheringObservationData(SingleSelectOptionsList gatheringObservationData) {
        this.gatheringObservationData = gatheringObservationData;
    }

    /**
     * @return the specimenCategoryData
     */
    public SingleSelectOptionsList getSpecimenCategoryData() {
        return specimenCategoryData;
    }

    /**
     * @param specimenCategoryData the specimenCategoryData to set
     */
    public void setSpecimenCategoryData(SingleSelectOptionsList specimenCategoryData) {
        this.specimenCategoryData = specimenCategoryData;
    }

    /**
     * @return the specimenTypeData
     */
    public SingleSelectOptionsList getSpecimenTypeData() {
        return specimenTypeData;
    }

    /**
     * @param specimenTypeData the specimenTypeData to set
     */
    public void setSpecimenTypeData(SingleSelectOptionsList specimenTypeData) {
        this.specimenTypeData = specimenTypeData;
    }

    /**
     * @return the originData
     */
    public SingleSelectOptionsList getOriginData() {
        return originData;
    }

    /**
     * @param originData the originData to set
     */
    public void setOriginData(SingleSelectOptionsList originData) {
        this.originData = originData;
    }

    /**
     * @return the preservationMediumData
     */
    public SingleSelectOptionsList getPreservationMediumData() {
        return preservationMediumData;
    }

    /**
     * @param preservationMediumData the preservationMediumData to set
     */
    public void setPreservationMediumData(SingleSelectOptionsList preservationMediumData) {
        this.preservationMediumData = preservationMediumData;
    }

    /**
     * @return the storageTypeData
     */
    public SingleSelectOptionsList getStorageTypeData() {
        return storageTypeData;
    }

    /**
     * @param storageTypeData the storageTypeData to set
     */
    public void setStorageTypeData(SingleSelectOptionsList storageTypeData) {
        this.storageTypeData = storageTypeData;
    }

    /**
     * @return the lifeStageData
     */
    public SingleSelectOptionsList getLifeStageData() {
        return lifeStageData;
    }

    /**
     * @param lifeStageData the lifeStageData to set
     */
    public void setLifeStageData(SingleSelectOptionsList lifeStageData) {
        this.lifeStageData = lifeStageData;
    }

    /**
     * @return the sexData
     */
    public SingleSelectOptionsList getSexData() {
        return sexData;
    }

    /**
     * @param sexData the sexData to set
     */
    public void setSexData(SingleSelectOptionsList sexData) {
        this.sexData = sexData;
    }

    /**
     * @return the stractionTypeData
     */
    public SingleSelectOptionsList getStractionTypeData() {
        return extractionTypeData;
    }

    /**
     * @param stractionTypeData the stractionTypeData to set
     */
    public void setStractionTypeData(SingleSelectOptionsList stractionTypeData) {
        this.extractionTypeData = stractionTypeData;
    }

    /**
     * @return the substrateData
     */
    public SingleSelectOptionsList getSubstrateData() {
        return substrateData;
    }

    /**
     * @param substrateData the substrateData to set
     */
    public void setSubstrateData(SingleSelectOptionsList substrateData) {
        this.substrateData = substrateData;
    }

    /**
     * @return the ddSex
     */
    public DropDown getDdSex() {
        return ddSex;
    }

    /**
     * @param ddSex the ddSex to set
     */
    public void setDdSex(DropDown ddSex) {
        this.ddSex = ddSex;
    }

    /**
     * @return the ddStage
     */
    public DropDown getDdStage() {
        return ddStage;
    }

    /**
     * @param ddStage the ddStage to set
     */
    public void setDdStage(DropDown ddStage) {
        this.ddStage = ddStage;
    }

    /**
     * @return the txQuantity
     */
    public TextField getTxQuantity() {
        return txQuantity;
    }

    /**
     * @param txQuantity the txQuantity to set
     */
    public void setTxQuantity(TextField txQuantity) {
        this.txQuantity = txQuantity;
    }

    /**
     * @return the invalidValueSex
     */
    public Long getInvalidValueSex() {
        return invalidValueSex;
    }

    /**
     * @param invalidValueSex the invalidValueSex to set
     */
    public void setInvalidValueSex(Long invalidValueSex) {
        this.invalidValueSex = invalidValueSex;
    }

    /**
     * @return the invalidValueStage
     */
    public Long getInvalidValueStage() {
        return invalidValueStage;
    }

    /**
     * @param invalidValueStage the invalidValueStage to set
     */
    public void setInvalidValueStage(Long invalidValueStage) {
        this.invalidValueStage = invalidValueStage;
    }

    /**
     * Metodo encargado de eliminar filas de la tabla de sexos y estadios
     * @return
     */
    public String btnDeleteStageSex_action() {
        // Se elimina el ultimo sexo y estadio ingresado
        int elements = this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO().getLifeStageSexList().size();
        //No se puede eliminar un elemento si no hay nada que borrar
        if(elements==0){
            MessageBean.setErrorMessageFromBundle("error_delete_generic", this.getMyLocale());
            return null;
        }
        else{
            this.getinventory$SpecimenSessionBean().getCurrentSpecimenDTO().getLifeStageSexList().remove(elements-1);
            return null;
        }
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
}

