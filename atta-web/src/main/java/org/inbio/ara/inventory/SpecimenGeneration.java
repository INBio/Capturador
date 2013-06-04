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
package org.inbio.ara.inventory;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.inventory.IdentificationDTO;
import org.inbio.ara.dto.inventory.IdentificationStatusDTO;
import org.inbio.ara.dto.inventory.IdentificationTypeDTO;
import org.inbio.ara.dto.inventory.IdentifierDTO;
import org.inbio.ara.dto.inventory.LifeStageSexDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.dto.inventory.SpecimenDTO;
import org.inbio.ara.dto.inventory.TaxonCategoryDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
import org.inbio.ara.persistence.gathering.CollectionProtocolValuesEntity;
import org.inbio.ara.persistence.gathering.ProtocolAtributeEntity;
import org.inbio.ara.persistence.specimen.SpecimenCategoryEntity;
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
 * @version SpecimenGeneration.java
 * @version Created on 02/09/2009, 09:09:05 AM
 * @author esmata
 */
public class SpecimenGeneration extends AbstractPageBean {
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

    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;

    //En esta variable se setearan los datos del drop down de metodo de recoleccion
    private SingleSelectOptionsList gatheringMethodData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de categorias
    private SingleSelectOptionsList categoryData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de tipos
    private SingleSelectOptionsList typeData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de origen
    private SingleSelectOptionsList originData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de medio de preserva
    private SingleSelectOptionsList preservationMediunData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de medio de almacenamiento
    private SingleSelectOptionsList storageData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de medio de sbstrato
    private SingleSelectOptionsList subtrateData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de medio de extraccion
    private SingleSelectOptionsList extractionData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de institucions
    private SingleSelectOptionsList institutionsData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de horas
    private SingleSelectOptionsList hourData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de minutos
    private SingleSelectOptionsList minutesData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de life stage
    private SingleSelectOptionsList lifeStageData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de sex
    private SingleSelectOptionsList sexData = new SingleSelectOptionsList();

	//En esta variable se setearan los datos del drop down nivel taxonomico (identificaciones)
	private SingleSelectOptionsList ddTaxonomicalRangeData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down status (identificaciones)
    private SingleSelectOptionsList statusIdentificationData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down tipo (identificaciones)
    private SingleSelectOptionsList typeIdentificationData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down validadores (identificaciones)
    private SingleSelectOptionsList validatorsData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down category (identificaciones)
    private SingleSelectOptionsList taxonCategoryData = new SingleSelectOptionsList();

    //Binding de los componentes graficos del panel de detalles
    private TextField txInitialCatalog = new TextField();
    private TextField txQuantity = new TextField();
    private TextField txCertainty = new TextField();
    private TextField txWhole = new TextField();
    private TextField txFragments = new TextField();
    private DropDown ddGatheringMethod = new DropDown();
    private DropDown ddCategory = new DropDown();
    private DropDown ddType = new DropDown();
    private DropDown ddOrigin = new DropDown();
    private DropDown ddPreservationMediun = new DropDown();
    private DropDown ddStorage = new DropDown();
    private DropDown ddSubtrate = new DropDown();
    private DropDown ddExtraction = new DropDown();
    private DropDown ddInstitutions = new DropDown();
    private DropDown ddHour = new DropDown();
    private DropDown ddMinutes = new DropDown();
    private Calendar calDateObservation = new Calendar();
    private Label lbDateObservation = new Label();
    private Label lbTimeObservation = new Label();
    private Label lbPoints = new Label();
    private Label lbWhole = new Label();
    private Label lbFragments = new Label();
    private Tab tabLifeForm = new Tab();
    private Calendar calIdentificationDate = new Calendar();

    //Binding de los componentes graficos del tab de sexos y estadios
    private DropDown ddStage = new DropDown();
    private DropDown ddSex = new DropDown();
    private TextField txQuantitySexStage = new TextField();

    //Binding para almacenar el valor de los drop downs de sexos y estadios
    private Long valueSex = null;
    private Long valueStage = null;
    
    //Result table
    private HtmlDataTable dataTableSpecimens = new HtmlDataTable();
    
    private boolean showSpecimens = false;

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SpecimenGeneration() {
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
            log("SpecimenGeneration Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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
        //Cargando datos de especimen
        this.getGatheringMethodData().
                setOptions(getSelectionListDropDownData
                (SelectionListEntity.GATHERING_METHOD_OBSERVATION.getId()));
        this.getCategoryData().
                setOptions(this.getSelectionListDropDownData
                (SelectionListEntity.SPECIMEN_CATEGORY.getId()));
        this.getTypeData().
                setOptions(this.getSelectionListDropDownData
                (SelectionListEntity.SPECIMEN_TYPE.getId()));
        this.getOriginData().
                setOptions(this.getSelectionListDropDownData
                (SelectionListEntity.ORIGIN.getId()));
        this.getPreservationMediunData().
                setOptions(this.getSelectionListDropDownData
                (SelectionListEntity.PRESERVATION_MEDIUM.getId()));
        this.getStorageData().
                setOptions(this.getSelectionListDropDownData
                (SelectionListEntity.STORAGE_TYPE.getId()));
        this.getSubtrateData().
                setOptions(this.getSelectionListDropDownData
                (SelectionListEntity.SUBSTRATE.getId()));
        this.getExtractionData().
                setOptions(this.getSelectionListDropDownData
                (SelectionListEntity.EXTRACTION_TYPE.getId()));
        this.getInstitutionsData().
                setOptions(this.getInstitutionDropDownData());
        this.getHourData().setOptions(this.getNumberList(23));
        this.getMinutesData().setOptions(this.getNumberList(59));
        //Cargando datos de sexos y estadios
        this.getLifeStageData().
                setOptions(this.getSelectionListDropDownData
                (SelectionListEntity.LIFE_STAGE.getId()));
        this.getSexData().
                setOptions(this.getSelectionListDropDownData
                (SelectionListEntity.SEX.getId()));
        //Cargando datos de identificaciones
        this.getDdTaxonomicalRangeData().setOptions(this.getTaxonomicLevelData());
        this.loadAddRemoveData(false);
        this.getStatusIdentificationData().
                setOptions(this.getStatusData());
        this.getTypeIdentificationData().
                setOptions(this.getIdentificationTypeData());
        this.getValidatorsData().setOptions(this.getValidatorsDropDownData());
        this.getTaxonCategoryData().setOptions(getTaxonCategoryDropDownData());

        /* Filtrado de funcionalidad, dependiendo del protocolo de recoleccion
         * especificamente el atributo "Utiliza formas de vida" */
        Long currentColllection = this.getAraSessionBean().getGlobalCollectionId();
        boolean useLifeForm = this.getinventory$GatheringSessionBean().matchCollectionProtocol(currentColllection,
                ProtocolAtributeEntity.USE_LIFE_FORM.getId(), CollectionProtocolValuesEntity.TRUE_VALUE.getValue());
        if(useLifeForm==true){
            this.tabLifeForm.setRendered(true);
        }
        else
            this.tabLifeForm.setRendered(false);
        
        java.util.Calendar cal = java.util.Calendar.getInstance(); 
        cal.set(java.util.Calendar.YEAR, 1700); 
        cal.set(java.util.Calendar.MONTH, 1); //June
        cal.set(java.util.Calendar.DAY_OF_MONTH, 1); 
        cal.set(java.util.Calendar.HOUR_OF_DAY, 0); 
        cal.set(java.util.Calendar.MINUTE, 0); 
        
        calDateObservation.setMinDate(cal.getTime());
        System.out.println("Min date = "+calDateObservation.getMinDate());
        
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
     * ventana de generacion que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    public Option[] getSelectionListDropDownData(Long selectionListEntityId) {
        Long currentCollection = this.getAraSessionBean().getGlobalCollectionId();
        List<SelectionListDTO> DTOList = this.getinventory$SpecimenSessionBean()
                .setSelectionListDropDownData(selectionListEntityId,currentCollection);
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
     * Metodo para obtener los datos a mostrar en los drop downs de la
     * ventana de generacion que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    public List<Option> getSelectionListAddRemoveDataAsList(Long selectionListEntityId) {
        Long currentCollection = this.getAraSessionBean().getGlobalCollectionId();
        List<SelectionListDTO> DTOList = this.getinventory$SpecimenSessionBean()
                .setSelectionListDropDownData(selectionListEntityId,currentCollection);
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option option;
        //Crear todas las opciones del add remove
        for (SelectionListDTO slDTO : DTOList) {
            option = new Option(slDTO.getValueId(), slDTO.getValueName());
            allOptions.add(option);
        }
        return allOptions;
    }

   /**
     * Obtener los datos del drop down de instituciones
     */
    public Option[] getInstitutionDropDownData(){
        List<InstitutionDTO> instDTOList = this.getinventory$SpecimenSessionBean()
                .SetInstitutionDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(InstitutionDTO instDTO : instDTOList){
            option = new Option(instDTO.getInstitutionId(), instDTO.getInstitutionName());
            allOptions.add(option);
        }
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

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

	public void loadAddRemoveData(boolean reset) {
		SpecimenGenerationSessionBean sgsb = this.getinventory$SpecimenGenerationSessionBean();
		if (reset) {
			sgsb.getArIdentifierList().setAvailableOptions(new Option[0]);
			sgsb.getArTaxonList().setAvailableOptions(new Option[0]);
            sgsb.getArLifeFormList().setAvailableOptions(new Option[0]);

			sgsb.getArIdentifierList().setSelectedOptions(new Long[0]);
			sgsb.getArTaxonList().setSelectedOptions(new Long[0]);
            sgsb.getArLifeFormList().setSelectedOptions(new Long[0]);
		}

		// AddRemove de Taxones
		if (sgsb.getArTaxonList().getAvailableOptions() == null ||
			sgsb.getArTaxonList().getAvailableOptions().length == 0) {

			List<TaxonDTO> taxonList =
                    sgsb.getAllTaxonByTaxonomicalRange(ROOT_TAXONOMICAL_RANGE_ID);
			this.setTaxonListOptions(taxonList);
		}

		// AddRemove de Identificadores
		if (sgsb.getArIdentifierList().getAvailableOptions() == null ||
			sgsb.getArIdentifierList().getAvailableOptions().length == 0) {

			List<PersonDTO> identifierList = sgsb.getIdentifiersList();
			List<Option> list = new ArrayList<Option>();

			for (PersonDTO identifier : identifierList) {
				list.add(new Option(identifier.getPersonKey(), identifier.getNaturalLongName()));
			}
			sgsb.getArIdentifierList().setAvailableOptions
                    (list.toArray(new Option[list.size()]));
		}

        //AddRemove de formas de vida
        if (sgsb.getArLifeFormList().getAvailableOptions() == null ||
			sgsb.getArLifeFormList().getAvailableOptions().length == 0) {

			List<Option> list = this.getSelectionListAddRemoveDataAsList
                    (SelectionListEntity.LIFE_FORM.getId());

            sgsb.getArLifeFormList().setAvailableOptions(
					list.toArray(new Option[list.size()]));
        }

		// Configurar los títulos
		sgsb.getArTaxonList().setLbTitle
                (BundleHelper.getDefaultBundleValue("taxon", this.getMyLocale()));
		sgsb.getArTaxonList().setLbAvailable
                (BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));
		sgsb.getArTaxonList().setLbSelected
                (BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));

		sgsb.getArIdentifierList().setLbTitle
                (BundleHelper.getDefaultBundleValue("person_identifier", this.getMyLocale()));
		sgsb.getArIdentifierList().setLbAvailable
                (BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));
		sgsb.getArIdentifierList().setLbSelected
                (BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));

		sgsb.getArLifeFormList().setLbTitle
                (BundleHelper.getDefaultBundleValue("life_forms", this.getMyLocale()));
		sgsb.getArLifeFormList().setLbAvailable
                (BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));
		sgsb.getArLifeFormList().setLbSelected
                (BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));
	}

	private void setTaxonListOptions(List<TaxonDTO> taxonList) {

		SpecimenGenerationSessionBean sgsb =
                this.getinventory$SpecimenGenerationSessionBean();
		List<Option> list = new ArrayList<Option>();

		for (TaxonDTO taxon : taxonList) {
			list.add(new Option(taxon.getTaxonKey(), taxon.getDefaultName()));
		}

		sgsb.getArTaxonList().setAvailableOptions
                (list.toArray(new Option[list.size()]));
	}

	public String updateTaxonListAction() {

		SpecimenGenerationSessionBean sgsb =
                this.getinventory$SpecimenGenerationSessionBean();

		List<TaxonDTO> taxonList =
                sgsb.getAllTaxonByTaxonomicalRange(sgsb.getSelectedTaxonomicLevel());
		this.setTaxonListOptions(taxonList);

		return null;
	}

	public Option[] getStatusData() {
		Option[] allOptionsInArray = null;
		Option option = null;
		List<IdentificationStatusDTO> aITList =
				this.getinventory$IdentificationSessionBean().getIdentificationStatusList();
		ArrayList<Option> allOptions = new ArrayList<Option>();
        String optionTitle = BundleHelper.
						getDefaultBundleValue( "drop_down_default",
												getMyLocale());
		//Crear opcion titulo
		option = new Option(null," -- "+optionTitle+" -- ");
		allOptions.add(option);
		//Crear todas las opciones del drop down
		for (IdentificationStatusDTO isDTO : aITList) {
			option = new Option(isDTO.getIdentificationStatusKey(), isDTO.getName());
			allOptions.add(option);
		}
		//Sets the elements in the SingleSelectedOptionList Object
		allOptionsInArray = new Option[allOptions.size()];
		return allOptions.toArray(allOptionsInArray);
	}

	public Option[] getIdentificationTypeData() {
		Option[] allOptionsInArray = null;
		Option option = null;
		List<IdentificationTypeDTO> aITList =
				this.getinventory$IdentificationSessionBean().getIdentificationTypeList();
		ArrayList<Option> allOptions = new ArrayList<Option>();
		String optionTitle =
				BundleHelper.getDefaultBundleValue( "drop_down_default",
												getMyLocale());
		//Crear opcion titulo
		option = new Option(null," -- "+optionTitle+" -- ");
		allOptions.add(option);
		//Crear todas las opciones del drop down
		for (IdentificationTypeDTO itDTO : aITList) {
			option = new Option(itDTO.getIdentificationTypeKey(), itDTO.getName());
			allOptions.add(option);
		}
		//Sets the elements in the SingleSelectedOptionList Object
		allOptionsInArray = new Option[allOptions.size()];
		return allOptions.toArray(allOptionsInArray);
	}

    /**
     * Obtener los datos del drop down de validadores
     */
    public Option[] getValidatorsDropDownData(){
        List<PersonDTO> instDTOList =
                this.getinventory$SpecimenGenerationSessionBean().getValidatorsList();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(PersonDTO perDTO : instDTOList){
            option = new Option(perDTO.getPersonKey(), perDTO.getNaturalLongName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Obtener los datos del drop down de responsables
     */
    public Option[] getTaxonCategoryDropDownData(){
        List<TaxonCategoryDTO> DTOList =
                this.getinventory$SpecimenGenerationSessionBean().getTaxonCategories();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(TaxonCategoryDTO myDTO : DTOList){
            option = new Option(myDTO.getTaxonCategoryId(), myDTO.getName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Retorna una lista que contiene los nuemeros desde 0 hasta el max
     * @param max es el limite para generar los numeros
     * @return
     */
    public Option[] getNumberList(int max){
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(int i=0;i<=max;i++){
            if(i<10){
                option = new Option(new Long(i), "0"+i);
                allOptions.add(option);
            }
            else{
                option = new Option(new Long(i), ""+i);
                allOptions.add(option);
            }
        }
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Metodo ejecutado al seleccionarse la categoria de especimen
     * @return
     */
     public String validateCategoryOptions(){
         //Bean de sesion para la generacion de especimenes
         SpecimenGenerationSessionBean sgsb =
                 this.getinventory$SpecimenGenerationSessionBean();

         //Poner la GUI default, osea, que no se muetren las particularidades
         this.lbDateObservation.setRendered(false);
         this.calDateObservation.setRendered(false);
         this.lbTimeObservation.setRendered(false);
         this.ddHour.setRendered(false);
         this.lbPoints.setRendered(false);
         this.ddMinutes.setRendered(false);
         this.lbWhole.setRendered(false);
         this.txWhole.setRendered(false);
         this.lbFragments.setRendered(false);
         this.txFragments.setRendered(false);
         this.txQuantitySexStage.setDisabled(false);

         //Capturo la categoria seleccionada por el ususario
         Long category = sgsb.getSpecimenDTO().getCategoryId();
         int countStageSex = 0;
         if(sgsb.getSpecimenDTO().getLifeStageSexList()!=null)
             countStageSex = sgsb.getSpecimenDTO().getLifeStageSexList().size();

         //Diferentes posibilidades
         if(category!=null){
             //La fecha y la hora exactas solo se muetra para observaciones
             if(category.equals(SpecimenCategoryEntity.OBSERVACION.getId())){
                 this.lbDateObservation.setRendered(true);
                 this.calDateObservation.setRendered(true);
                 this.lbTimeObservation.setRendered(true);
                 this.ddHour.setRendered(true);
                 this.lbPoints.setRendered(true);
                 this.ddMinutes.setRendered(true);
             }
             //Enteros y fragmentos solo para agrupados
             else if(category.equals
                     (SpecimenCategoryEntity.AGRUPADO_UNITAXON.getId()) ||
                     category.equals
                     (SpecimenCategoryEntity.AGRUPADO_MULTITAXON.getId())){
                 this.lbWhole.setRendered(true);
                 this.txWhole.setRendered(true);
                 this.lbFragments.setRendered(true);
                 this.txFragments.setRendered(true);
             }
             // Si es individual, no debe existir cantidad en sexos y estadios
             // y solo debe haber una fila
             else if (countStageSex > 1 && category.equals
                     (SpecimenCategoryEntity.INDIVIDUAL.getId())) {
                 this.getinventory$SpecimenGenerationSessionBean().setReadyToSave(false);
                 sgsb.getSpecimenDTO().setCategoryId(null);
                 MessageBean.setErrorMessageFromBundle
                         ("error_category_sex_stage", this.getMyLocale());
                 return null;
             }
             else if(category.equals(SpecimenCategoryEntity.INDIVIDUAL.getId())){
                 this.txQuantitySexStage.setText(new Long(1));
                 this.txQuantitySexStage.setDisabled(true);
             }
         }

         this.getinventory$SpecimenGenerationSessionBean().setReadyToSave(true);
         return null;
     }

    /**
     * Metodo encargado de agregar nuevos sexos y estadio al specimenDTO que
     * esta siendo editado por el usuario
     */
    public String btnAddStageSex_action() {
        //Bean de sesion para la generacion de especimenes
        SpecimenGenerationSessionBean sgsb =
                this.getinventory$SpecimenGenerationSessionBean();

        if (sgsb.getSpecimenDTO().getLifeStageSexList() == null) {
            sgsb.getSpecimenDTO().setLifeStageSexList
                    (new ArrayList<LifeStageSexDTO>());
        }
        int countStageSex = sgsb.getSpecimenDTO().getLifeStageSexList().size();

        //Obtener los datos de estadio, sexo y cantidad
        Long quantity = null;
        if (this.getTxQuantitySexStage().getText() != null) {
            quantity = Long.valueOf
                    (this.getTxQuantitySexStage().getText().toString());
        }
        Long sex = (Long) this.getDdSex().getSelected();
        Long stage = (Long) this.getDdStage().getSelected();
        Long category = sgsb.getSpecimenDTO().getCategoryId();
        //Si alguno de los tres es nulo, mandar error
        if (sex==null || stage==null || quantity == null) {
            MessageBean.setErrorMessageFromBundle
                    ("error_stage_sex_add", this.getMyLocale());
            return null;
        }
        //Debe haber una categoria seleccionada
        if(category==null){
            MessageBean.setErrorMessageFromBundle
                    ("choose_category", this.getMyLocale());
            return null;
        }
        //Si el tipo de especimen es individual, solo puede tener un sexo y estadio
        if (category.equals(SpecimenCategoryEntity.INDIVIDUAL.getId())
                && countStageSex >= 1) {
            // No se pueden agregar mas sexos y estadios
            //sgsb.getSpecimenDTO().setCategoryId(null);
            MessageBean.setErrorMessageFromBundle
                    ("error_stage_sex_add_individual", this.getMyLocale());
            return null;
        }
        else {
            String sexName = getSexLabel(sex);
            String stageName = getStageLabel(stage);

            SelectionListDTO sexDTO = new SelectionListDTO();
            sexDTO.setSelectionListEntityId(SelectionListEntity.SEX.getId());
            sexDTO.setValueId(sex);
            sexDTO.setValueName(sexName);

            SelectionListDTO stageDTO = new SelectionListDTO();
            stageDTO.setSelectionListEntityId
                    (SelectionListEntity.LIFE_STAGE.getId());
            stageDTO.setValueId(stage);
            stageDTO.setValueName(stageName);

            LifeStageSexDTO lssDTO = new LifeStageSexDTO();
            lssDTO.setQuantity(quantity);
            lssDTO.setLifeStageDTO(stageDTO);
            lssDTO.setSexDTO(sexDTO);

            //Agregamos el dto a la lista de sexos y estadios del specimenDTO
            sgsb.getSpecimenDTO().getLifeStageSexList().add(lssDTO);

            return null;
        }
    }

    /**
     * @param sex id
     * @return la etiqueta correspondiente a ese sex id
     */
    private String getSexLabel(Long id){
        Option[] my_options = this.getSelectionListDropDownData
                (SelectionListEntity.SEX.getId());
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
        Option[] my_options = this.getSelectionListDropDownData
                (SelectionListEntity.LIFE_STAGE.getId());
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
     * Metodo encargado de eliminar filas de la tabla de sexos y estadios
     * @return
     */
    public String btnDeleteStageSex_action() {
         //Bean de sesion para la generacion de especimenes
         SpecimenGenerationSessionBean sgsb =
                 this.getinventory$SpecimenGenerationSessionBean();

        // Se elimina el ultimo sexo y estadio ingresado
        int elements = sgsb.getSpecimenDTO().getLifeStageSexList().size();
        //No se puede eliminar un elemento si no hay nada que borrar
        if(elements==0){
            MessageBean.setErrorMessageFromBundle
                    ("error_delete_generic", this.getMyLocale());
            return null;
        }
        else{
            sgsb.getSpecimenDTO().getLifeStageSexList().remove(elements-1);
            return null;
        }
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
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
    }

    /**
     * To get the sessionBean for specimen generation
     * @return
     */
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean)
                getBean("inventory$SpecimenGenerationSessionBean");
    }

    /**
     * To get the sessionBean for specimen generation
     * @return
     */
    protected IdentificationSessionBean getinventory$IdentificationSessionBean() {
        return (IdentificationSessionBean)
                getBean("inventory$IdentificationSessionBean");
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
     * @return the gatheringMethodData
     */
    public SingleSelectOptionsList getGatheringMethodData() {
        return gatheringMethodData;
    }

    /**
     * @param gatheringMethodData the gatheringMethodData to set
     */
    public void setGatheringMethodData
            (SingleSelectOptionsList gatheringMethodData) {
        this.gatheringMethodData = gatheringMethodData;
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
     * @return the categoryData
     */
    public SingleSelectOptionsList getCategoryData() {
        return categoryData;
    }

    /**
     * @param categoryData the categoryData to set
     */
    public void setCategoryData(SingleSelectOptionsList categoryData) {
        this.categoryData = categoryData;
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
     * @return the typeData
     */
    public SingleSelectOptionsList getTypeData() {
        return typeData;
    }

    /**
     * @param typeData the typeData to set
     */
    public void setTypeData(SingleSelectOptionsList TypeData) {
        this.typeData = TypeData;
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
    public void setOriginData(SingleSelectOptionsList OriginData) {
        this.originData = OriginData;
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
     * @return the txInitialCatalog
     */
    public TextField getTxInitialCatalog() {
        return txInitialCatalog;
    }

    /**
     * @param txInitialCatalog the txInitialCatalog to set
     */
    public void setTxInitialCatalog(TextField txInitialCatalog) {
        this.txInitialCatalog = txInitialCatalog;
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
     * @return the preservationMediunData
     */
    public SingleSelectOptionsList getPreservationMediunData() {
        return preservationMediunData;
    }

    /**
     * @param preservationMediunData the preservationMediunData to set
     */
    public void setPreservationMediunData
            (SingleSelectOptionsList PreservationMediunData) {
        this.preservationMediunData = PreservationMediunData;
    }

    /**
     * @return the ddPreservationMediun
     */
    public DropDown getDdPreservationMediun() {
        return ddPreservationMediun;
    }

    /**
     * @param ddPreservationMediun the ddPreservationMediun to set
     */
    public void setDdPreservationMediun(DropDown ddPreservationMediun) {
        this.ddPreservationMediun = ddPreservationMediun;
    }

    /**
     * @return the storageData
     */
    public SingleSelectOptionsList getStorageData() {
        return storageData;
    }

    /**
     * @param storageData the storageData to set
     */
    public void setStorageData(SingleSelectOptionsList storageData) {
        this.storageData = storageData;
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
     * @return the ddSubtrate
     */
    public DropDown getDdSubtrate() {
        return ddSubtrate;
    }

    /**
     * @param ddSubtrate the ddSubtrate to set
     */
    public void setDdSubtrate(DropDown ddSubtrate) {
        this.ddSubtrate = ddSubtrate;
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
     * @return the subtrateData
     */
    public SingleSelectOptionsList getSubtrateData() {
        return subtrateData;
    }

    /**
     * @param subtrateData the subtrateData to set
     */
    public void setSubtrateData(SingleSelectOptionsList subtrateData) {
        this.subtrateData = subtrateData;
    }

    /**
     * @return the extractionData
     */
    public SingleSelectOptionsList getExtractionData() {
        return extractionData;
    }

    /**
     * @param extractionData the extractionData to set
     */
    public void setExtractionData(SingleSelectOptionsList extractionData) {
        this.extractionData = extractionData;
    }

    /**
     * @return the txCertainty
     */
    public TextField getTxCertainty() {
        return txCertainty;
    }

    /**
     * @param txCertainty the txCertainty to set
     */
    public void setTxCertainty(TextField txCertainty) {
        this.txCertainty = txCertainty;
    }

    /**
     * @return the ddInstitutions
     */
    public DropDown getDdInstitutions() {
        return ddInstitutions;
    }

    /**
     * @param ddInstitutions the ddInstitutions to set
     */
    public void setDdInstitutions(DropDown ddInstitutions) {
        this.ddInstitutions = ddInstitutions;
    }

    /**
     * @return the institutionsData
     */
    public SingleSelectOptionsList getInstitutionsData() {
        return institutionsData;
    }

    /**
     * @param institutionsData the institutionsData to set
     */
    public void setInstitutionsData(SingleSelectOptionsList institutionsData) {
        this.institutionsData = institutionsData;
    }

    /**
     * @return the calDateObservation
     */
    public Calendar getCalDateObservation() {
        return calDateObservation;
    }

    /**
     * @param calDateObservation the calDateObservation to set
     */
    public void setCalDateObservation(Calendar calDateObservation) {
        this.calDateObservation = calDateObservation;
    }

    /**
     * @return the ddHour
     */
    public DropDown getDdHour() {
        return ddHour;
    }

    /**
     * @param ddHour the ddHour to set
     */
    public void setDdHour(DropDown ddHour) {
        this.ddHour = ddHour;
    }

    /**
     * @return the ddMinutes
     */
    public DropDown getDdMinutes() {
        return ddMinutes;
    }

    /**
     * @param ddMinutes the ddMinutes to set
     */
    public void setDdMinutes(DropDown ddMinutes) {
        this.ddMinutes = ddMinutes;
    }

    /**
     * @return the hourData
     */
    public SingleSelectOptionsList getHourData() {
        return hourData;
    }

    /**
     * @param hourData the hourData to set
     */
    public void setHourData(SingleSelectOptionsList hourData) {
        this.hourData = hourData;
    }

    /**
     * @return the minutesData
     */
    public SingleSelectOptionsList getMinutesData() {
        return minutesData;
    }

    /**
     * @param minutesData the minutesData to set
     */
    public void setMinutesData(SingleSelectOptionsList minutesData) {
        this.minutesData = minutesData;
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
     * @return the lbDateObservation
     */
    public Label getLbDateObservation() {
        return lbDateObservation;
    }

    /**
     * @param lbDateObservation the lbDateObservation to set
     */
    public void setLbDateObservation(Label lbDateObservation) {
        this.lbDateObservation = lbDateObservation;
    }

    /**
     * @return the lbTimeObservation
     */
    public Label getLbTimeObservation() {
        return lbTimeObservation;
    }

    /**
     * @param lbTimeObservation the lbTimeObservation to set
     */
    public void setLbTimeObservation(Label lbTimeObservation) {
        this.lbTimeObservation = lbTimeObservation;
    }

    /**
     * @return the lbPoints
     */
    public Label getLbPoints() {
        return lbPoints;
    }

    /**
     * @param lbPoints the lbPoints to set
     */
    public void setLbPoints(Label lbPoints) {
        this.lbPoints = lbPoints;
    }

    /**
     * @return the lbWhole
     */
    public Label getLbWhole() {
        return lbWhole;
    }

    /**
     * @param lbWhole the lbWhole to set
     */
    public void setLbWhole(Label lbWhole) {
        this.lbWhole = lbWhole;
    }

    /**
     * @return the lbFragments
     */
    public Label getLbFragments() {
        return lbFragments;
    }

    /**
     * @param lbFragments the lbFragments to set
     */
    public void setLbFragments(Label lbFragments) {
        this.lbFragments = lbFragments;
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
     * @return the valueSex
     */
    public Long getValueSex() {
        return valueSex;
    }

    /**
     * @param valueSex the valueSex to set
     */
    public void setValueSex(Long valueSex) {
        this.valueSex = valueSex;
    }

    /**
     * @return the valueStage
     */
    public Long getValueStage() {
        return valueStage;
    }

    /**
     * @param valueStage the valueStage to set
     */
    public void setValueStage(Long valueStage) {
        this.valueStage = valueStage;
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
     * @return the txQuantitySexStage
     */
    public TextField getTxQuantitySexStage() {
        return txQuantitySexStage;
    }

    /**
     * @param txQuantitySexStage the txQuantitySexStage to set
     */
    public void setTxQuantitySexStage(TextField txQuantitySexStage) {
        this.txQuantitySexStage = txQuantitySexStage;
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
    public void setDdTaxonomicalRangeData
            (SingleSelectOptionsList ddTaxonomicalRangeData) {
        this.ddTaxonomicalRangeData = ddTaxonomicalRangeData;
    }

    /**
     * @return the statusIdentificationData
     */
    public SingleSelectOptionsList getStatusIdentificationData() {
        return statusIdentificationData;
    }

    /**
     * @param statusIdentificationData the statusIdentificationData to set
     */
    public void setStatusIdentificationData
            (SingleSelectOptionsList statusIdentificationData) {
        this.statusIdentificationData = statusIdentificationData;
    }

    /**
     * @return the typeIdentificationData
     */
    public SingleSelectOptionsList getTypeIdentificationData() {
        return typeIdentificationData;
    }

    /**
     * @param typeIdentificationData the typeIdentificationData to set
     */
    public void setTypeIdentificationData
            (SingleSelectOptionsList typeIdentificationData) {
        this.typeIdentificationData = typeIdentificationData;
    }

    /**
     * @return the validatorsData
     */
    public SingleSelectOptionsList getValidatorsData() {
        return validatorsData;
    }

    /**
     * @param validatorsData the validatorsData to set
     */
    public void setValidatorsData(SingleSelectOptionsList validatorsData) {
        this.validatorsData = validatorsData;
    }

    /**
     * @return the taxonCategoryData
     */
    public SingleSelectOptionsList getTaxonCategoryData() {
        return taxonCategoryData;
    }

    /**
     * @param taxonCategoryData the taxonCategoryData to set
     */
    public void setTaxonCategoryData
            (SingleSelectOptionsList taxonCategoryData) {
        this.taxonCategoryData = taxonCategoryData;
    }

    /**
     * @return the tabLifeForm
     */
    public Tab getTabLifeForm() {
        return tabLifeForm;
    }

    /**
     * @param tabLifeForm the tabLifeForm to set
     */
    public void setTabLifeForm(Tab tabLifeForm) {
        this.tabLifeForm = tabLifeForm;
    }

    /**
     * Metodo ejecutado por el boton de generar especimenes
     * @return
     */
    public String btnSpecimenGeneration_action() {

        SpecimenGenerationSessionBean sgsb = this.
                getinventory$SpecimenGenerationSessionBean();

        /* (1) Specimen DTO */
        //Obtener datos de la pantalla para el DTO de especimen
        Date dateTime = new Date();
        Long certaintyLevel=null,whole = null,fragments = null;
        String initialCatalog = null;
        initialCatalog = (String)this.getTxInitialCatalog().getText();
        String levelAux = (String)this.getTxCertainty().getText();
        if(levelAux!=null)
            certaintyLevel = Long.parseLong(levelAux);        
        String wholelAux = (String)this.getTxWhole().getText();
        if(wholelAux!=null)
            whole = Long.parseLong(wholelAux);                
        String fragAux = (String)this.getTxFragments().getText();
        if(fragAux!=null)
            fragments = Long.parseLong(fragAux);
        if(this.getCalDateObservation().getSelectedDate() != null) {
            dateTime = this.getCalDateObservation().getSelectedDate();
            dateTime.setMinutes(sgsb.getSelectedMinute().intValue());
            dateTime.setHours(sgsb.getSelectedHour().intValue());
        }
        //Obtener el dato de cuantos especimenes se generaran
        Long specimensQuantity = new Long(0);
        String quanAux = (String)this.getTxQuantity().getText();
        if(quanAux!=null&&!quanAux.equals(""))
            specimensQuantity = Long.parseLong(quanAux);

        /**
         * Verificar que el número de catálogo inicial sea un número, si es un
         * número todo bien, sino, se verifica que la cantidad a generar sea 1.
         *
         * La idea es que si NO es un numero entero, el sistema solo podrá generar
         * los especmenes de uno en uno. Ya que la funcionalidad de generar en bloque
         * solo funciona para números de catálogo enteros.
         */
        if (!(initialCatalog==null)&&!initialCatalog.isEmpty()) {
            try {
                Long.parseLong(initialCatalog);
            } catch (Exception e) {
                if (specimensQuantity > 1L) {
                    MessageBean.setErrorMessageFromBundle("generation_catalog_num_error", this.getMyLocale());
                    return null;
                }
            }
        }

        //Setear los valores del specimenDTO
        sgsb.getSpecimenDTO().setCatalogNumber(initialCatalog);
        sgsb.getSpecimenDTO().setCertaintyLevel(certaintyLevel);
        sgsb.getSpecimenDTO().setNumberFragments(fragments);
        sgsb.getSpecimenDTO().setNumberWhole(whole);
        sgsb.getSpecimenDTO().setDateTime(dateTime);
        sgsb.getSpecimenDTO().setGatheringObsevationId(
                sgsb.getGatheringObservationId());
        sgsb.getSpecimenDTO().setGatheringObservationDetailId(
                sgsb.getGatheringDetailObservationId());
        Long colId = this.getAraSessionBean().getGlobalCollectionId();
        sgsb.getSpecimenDTO().setCollectionId(colId);
        //**************************** (1) **********************************

        /* (2) IdentificationDTO */
        //Obtener los datos de la pantalla para el dto de identificaciones
        PersonDTO valuerPerson = new PersonDTO(sgsb.getSelecctedValidator());
        sgsb.getIdentificationDTO().setValuerPerson(valuerPerson);
        java.util.Calendar utilCal = new GregorianCalendar();
        Date identiDate = this.getCalIdentificationDate().getSelectedDate();
        if(identiDate!=null){
            utilCal.setTime(identiDate);
        }
        sgsb.getIdentificationDTO().setIdentificationDate(utilCal);
        //Taxons
        Long[] taxonsOp = sgsb.getArTaxonList().getSelectedOptions();
        List<TaxonDTO> taxonsDto = new ArrayList<TaxonDTO>();

		int arrayLength = 0;

		if(taxonsOp != null){
			arrayLength = taxonsOp.length;
			for(int i = 0; i < arrayLength; i++){
				TaxonDTO tAux = new TaxonDTO();
				tAux.setTaxonKey(taxonsOp[i]);
				taxonsDto.add(tAux);
			}
		}

        sgsb.getIdentificationDTO().setTaxa(taxonsDto);
        sgsb.getIdentificationDTO().setUserName(this.getAraSessionBean().getGlobalUserName());
        
        //Identifiers
        Long[] identifiersOp = sgsb.getArIdentifierList().getSelectedOptions();
        List<IdentifierDTO> identifiersDTO = new ArrayList<IdentifierDTO>();
		
		if(identifiersOp != null){
			arrayLength = identifiersOp.length;
			for(int i = 0; i < arrayLength; i++){
				IdentifierDTO iAux = new IdentifierDTO();
				iAux.setIdentifierKey(identifiersOp[i]);
                                iAux.setUserName(this.getAraSessionBean().getGlobalUserName());
				identifiersDTO.add(iAux);
			}
		}		

        sgsb.getIdentificationDTO().setIdentifiers(identifiersDTO);
        //**************************** (2) **********************************

        /* (3) Life Stage Sex DTO */
        // La lista de sexos y estadios esta "bindeada" al DTO desde el jsp
        //**************************** (3) **********************************
        
        /* (4) Cantidad a generar */
        //Setear la variable del session bean
        sgsb.setSpecimenQuantity(specimensQuantity);
        //***************************** (4) ********************************

        /* (5) Lista de formas de vida */
        Long[] lifeformIdsOp = sgsb.getArLifeFormList().getSelectedOptions();
        List<Long> lifeformIdsLong = new ArrayList<Long>();

		if(lifeformIdsOp != null){
			arrayLength = lifeformIdsOp.length;
			for(int i = 0; i < arrayLength; i++){
				lifeformIdsLong.add(lifeformIdsOp[i]);
			}
		}
		
        sgsb.setLifeFormList(lifeformIdsLong);
        //*************************** (5) **********************************

        //Llamada para generar especimenes
        try {
            
            int gen = sgsb.generateSpecimens();
            
            /*  0 means everything is ok
             *  1 means Null specimenDTO
             *  2 means Not quantity specified
             *  3 means Catalog Number not available
             *  4 means Multiple taxa selected
             */
            switch(gen){
                case 0:                    
                    //Limpiar pantalla de generación
                    this.cleanGenerationPage();
                    this.setShowSpecimens(true);
                    
                    //Succes message
                    MessageBean.setSuccessMessageFromBundle
                    ("specimen_generation_success", this.getMyLocale());
                    break;
                case 1:
                    MessageBean.setErrorMessageFromBundle                            
                    ("generation_error", this.getMyLocale());
                    this.setShowSpecimens(false);
                    break;
                case 2:
                    MessageBean.setErrorMessageFromBundle
                    ("generation_quantity_error", this.getMyLocale());
                    this.setShowSpecimens(false);
                    break;
                case 3:
                    MessageBean.setErrorMessageFromBundle
                    ("generation_catalog_error", this.getMyLocale());                    
                    this.setShowSpecimens(false);
                    break;
                default:
                    MessageBean.setErrorMessageFromBundle
                    ("generation_multiple_taxa_error", this.getMyLocale());
                    this.setShowSpecimens(false);
                    break;
            }
        } catch (Exception e) {
            MessageBean.setErrorMessageFromBundle("generation_error", this.getMyLocale());
            this.setShowSpecimens(false);
        }

        return null;
    }

    private void cleanGenerationPage(){
        SpecimenGenerationSessionBean sgsb = this.
                getinventory$SpecimenGenerationSessionBean();
        sgsb.setSpecimenDTO(new SpecimenDTO());
        sgsb.setIdentificationDTO(new IdentificationDTO());
        sgsb.setLifeFormList(new ArrayList<Long>());
        sgsb.setSpecimenQuantity(new Long(0));
        sgsb.setArTaxonList(new AddRemoveList());
        sgsb.setArIdentifierList(new AddRemoveList());
        sgsb.setArLifeFormList(new AddRemoveList());
        sgsb.setSelectedHour(null);
        sgsb.setSelectedMinute(null);
        sgsb.setSelecctedValidator(null);
        sgsb.setSelectedTaxonomicLevel(null);
        this.getTxQuantity().setText(null);
        this.getTxInitialCatalog().setText(null);
        this.getTxCertainty().setText(null);
        this.getCalDateObservation().setSelectedDate(new Date());
        this.getCalDateObservation().setText(null);
        this.getTxFragments().setText(null);
        this.getTxWhole().setText(null);
        this.getCalIdentificationDate().setSelectedDate(new Date());
        this.getCalIdentificationDate().setText(null);
    }

    /**
     * @return the calIdentificationDate
     */
    public Calendar getCalIdentificationDate() {
        return calIdentificationDate;
    }

    /**
     * @param calIdentificationDate the calIdentificationDate to set
     */
    public void setCalIdentificationDate(Calendar calIdentificationDate) {
        this.calIdentificationDate = calIdentificationDate;
    }

    /**
     * @return the dataTableSpecimens
     */
    public HtmlDataTable getDataTableSpecimens() {
        return dataTableSpecimens;
    }

    /**
     * @param dataTableSpecimens the dataTableSpecimens to set
     */
    public void setDataTableSpecimens(HtmlDataTable dataTableSpecimens) {
        this.dataTableSpecimens = dataTableSpecimens;
    }

    /**
     * @return the showSpecimens
     */
    public boolean isShowSpecimens() {
        return showSpecimens;
    }

    /**
     * @param showSpecimens the showSpecimens to set
     */
    public void setShowSpecimens(boolean showSpecimens) {
        this.showSpecimens = showSpecimens;
    }
}

