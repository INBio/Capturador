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
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.gis.SiteDTO;
import org.inbio.ara.dto.inventory.GatheringObservationDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.ProjectDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.gathering.CollectionProtocolValuesEntity;
import org.inbio.ara.persistence.gathering.ProtocolAtributeEntity;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewGathering.java
 * @version Created on 20/08/2009, 04:46:02 PM
 * @author esmata
 */

public class NewGathering extends AbstractPageBean {
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

    //Binding de los componenetes graficos
    private DropDown ddLocalities = new DropDown();
    private DropDown ddResponsible = new DropDown();
    private DropDown ddExposition = new DropDown();
    private Calendar initial_date = new com.sun.webui.jsf.component.Calendar();
    private Calendar final_date = new com.sun.webui.jsf.component.Calendar();
    private TextField txGradient = new TextField();
    private TextField txElevationMin = new TextField();
    private TextField txElevationMax = new TextField();
    private TextField txDepthMin = new TextField();
    private TextField txDepthMax = new TextField();
    private TextArea txaSurrounding = new TextArea();
    private TextArea txaSiteDescription = new TextArea();

    //En esta variable se setearan los datos del drop down de localidades
    private SingleSelectOptionsList localitiesData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de responsables
    private SingleSelectOptionsList responsibleData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de expocision
    private SingleSelectOptionsList expositionData = new SingleSelectOptionsList();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewGathering() {
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
            log("NewGathering Initialization Failure", e);
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
        // Cargar los valores de los dropdowns y add remove components 
        this.getExpositionData().setOptions(setExpositionDropDownData(SelectionListEntity.EXPOSITION.getId()));
        this.getResponsibleData().setOptions(SetResponsibleDropDownData());
        this.getLocalitiesData().setOptions(SetSitesDropDownData());
        // Metodo encargado de cargar los datos de los distintos add remove
        this.loadAddRemoveData();
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
     * ventana de new que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    private Option[] setExpositionDropDownData(Long selectionListEntityId){
        Long collection = this.getAraSessionBean().getGlobalCollectionId();
        List<SelectionListDTO> DTOList = this.getinventory$GatheringSessionBean()
                .setExpositionDropDownData(selectionListEntityId,collection);
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(SelectionListDTO slDTO : DTOList){
            option = new Option(slDTO.getValueId(), slDTO.getValueName().trim());
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
        List<PersonDTO> instDTOList = this.getinventory$GatheringSessionBean().SetResponsibleDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
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
     * Obtener los datos del drop down de sitios
     */
    public Option[] SetSitesDropDownData(){
        List<SiteDTO> instDTOList = this.getinventory$GatheringSessionBean().SetSitesDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(SiteDTO sDTO : instDTOList){
            option = new Option(sDTO.getSiteId(), sDTO.getDescription().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Metodo encargado de cargar los datos de los distintos add remove de la
     * ventana de nueva recoleccion
     */
    private void loadAddRemoveData() {
        GatheringSessionBean gsb = this.getinventory$GatheringSessionBean();
        //Cargar datos del add remove de colecciones
        if (gsb.getArCollections().getAvailableOptions() == null ||
                gsb.getArCollections().getAvailableOptions().length == 0) {

            List<CollectionDTO> collectionsList = gsb.SetCollectionDropDownData();
            List<Option> list = new ArrayList<Option>();

            for (CollectionDTO coll : collectionsList) {
                list.add(new Option(coll.getCollectionId(), coll.getCollectionName()));
            }
            gsb.getArCollections().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Cargar los datos del add remove de colectores
        if (gsb.getArCollectors().getAvailableOptions() == null ||
                gsb.getArCollectors().getAvailableOptions().length == 0) {

            List<PersonDTO> collectorsList = gsb.SetColectorsDropDownData();
            List<Option> list = new ArrayList<Option>();

            for (PersonDTO per : collectorsList) {
                list.add(new Option(per.getPersonKey(), per.getNaturalLongName()));
            }
            gsb.getArCollectors().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Cargar los datos del add remove de proyectos
        if (gsb.getArProjects().getAvailableOptions() == null ||
                gsb.getArProjects().getAvailableOptions().length == 0) {

            List<ProjectDTO> proList = gsb.SetProjectsDropDownData();
            List<Option> list = new ArrayList<Option>();

            for (ProjectDTO pro : proList) {
                list.add(new Option(pro.getProjectId(), pro.getDescription()));
            }
            gsb.getArProjects().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Setea los labels del componente add remove
        gsb.getArCollections().setLbTitle(BundleHelper.getDefaultBundleValue("associated_collections", this.getMyLocale()));
        gsb.getArCollections().setLbAvailable(BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));
        gsb.getArCollections().setLbSelected(BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));

        gsb.getArCollectors().setLbTitle(BundleHelper.getDefaultBundleValue("collectors_list", this.getMyLocale()));
        gsb.getArCollectors().setLbAvailable(BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));
        gsb.getArCollectors().setLbSelected(BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));

        gsb.getArProjects().setLbTitle(BundleHelper.getDefaultBundleValue("projects_list", this.getMyLocale()));
        gsb.getArProjects().setLbAvailable(BundleHelper.getDefaultBundleValue("available", this.getMyLocale()));
        gsb.getArProjects().setLbSelected(BundleHelper.getDefaultBundleValue("selected", this.getMyLocale()));
    }

    /**
     * Metodo que ejecuta el boton de guardar nueva recoleccion
     * @return
     */
    public String btnSaveGathering_action() {
        //Variables para maximos y minimos
        String eleMax = (String) this.getTxElevationMax().getText();
        String eleMin = (String) this.getTxElevationMin().getText();
        String deMax = (String) this.getTxDepthMax().getText();
        String deMin = (String) this.getTxDepthMin().getText();
        Double elevationMax = null, elevationMin = null, depthMax = null, depthMin = null;
        if (eleMax != null) {
            elevationMax = Double.valueOf(eleMax);
        }
        if (eleMin != null) {
            elevationMin = Double.valueOf(eleMin);
        }
        if (deMax != null) {
            depthMax = Double.valueOf(deMax);
        }
        if (deMin != null) {
            depthMin = Double.valueOf(deMin);
        }
        //Validar maximos y minimos
        if (elevationMax != null && elevationMin != null) {
            if (elevationMax < elevationMin) {
                MessageBean.setErrorMessageFromBundle("error_max_min", this.getMyLocale());
                return null;
            }
        }
        if (depthMax != null && depthMin != null) {
            if (depthMax < depthMin) {
                MessageBean.setErrorMessageFromBundle("error_max_min", this.getMyLocale());
                return null;
            }
        }
        //Crear un nuevo DTO y setearlo con la informacion introducida en la GUI
        GatheringObservationDTO gdto = new GatheringObservationDTO();
        gdto.setLocalityId(this.getinventory$GatheringSessionBean().getSelectedLocality());
        gdto.setResponsibleId(this.getinventory$GatheringSessionBean().getSelectedResponsible());
        gdto.setExpositionId(this.getinventory$GatheringSessionBean().getSelectedExposition());

        GregorianCalendar iniCal = new GregorianCalendar();
        GregorianCalendar finCal = new GregorianCalendar();
        Date iniDate = this.getInitial_date().getSelectedDate();
        Date finDate = this.getFinal_date().getSelectedDate();
        if (iniDate != null) {
            iniCal.setTime(iniDate);
            gdto.setInitialDateTime(iniCal);
        }
        if (finDate != null) {
            finCal.setTime(finDate);
            gdto.setFinalDateTime(finCal);
        }
        String gra = (String) this.getTxGradient().getText();
        if (gra != null) {
            gdto.setGradient(Long.valueOf(gra));
        }
        gdto.setMaximumElevation(elevationMax);
        gdto.setMinimumElevation(elevationMin);
        gdto.setMaximumDepth(depthMax);
        gdto.setMinimumDepth(depthMin);
        gdto.setSiteDescription((String) this.getTxaSiteDescription().getText());
        gdto.setSurroundingDescription((String) this.getTxaSurrounding().getText());

        Long currentCollection  = this.getAraSessionBean().getGlobalCollectionId();
        gdto.setCollectionId(currentCollection);

        gdto.setColectorsList(colectorsAsDTO());
        gdto.setProjectsList(projectsAsDTO());
        gdto.setCollectionsList(collectionsAsDTO());
        //Limpiar la pantalla de new gathering
        this.getinventory$GatheringSessionBean().setSelectedExposition(null);
        this.getinventory$GatheringSessionBean().setSelectedLocality(null);
        this.getinventory$GatheringSessionBean().setSelectedResponsible(null);
        this.getTxGradient().setText(null);
        this.getTxElevationMax().setText(null);
        this.getTxElevationMin().setText(null);
        this.getTxDepthMax().setText(null);
        this.getTxDepthMin().setText(null);
        this.getTxaSiteDescription().setText(null);
        this.getTxaSurrounding().setText(null);
        //Reestablecer el valor default de los repositorios de datos
        this.getinventory$GatheringSessionBean().setExpositionData(null);
        this.getinventory$GatheringSessionBean().setResponsibleData(null);
        this.getinventory$GatheringSessionBean().setLocalityData(null);
        this.getinventory$GatheringSessionBean().setCollectionData(null);
        this.getinventory$GatheringSessionBean().setColectorData(null);
        this.getinventory$GatheringSessionBean().setProjectData(null);
        
        try{
            //Llamar metodo que persiste el DTO
            GatheringObservationDTO DTOwithId = this.
                    getinventory$GatheringSessionBean().getInventoryFacade().saveGathering(gdto);        
            //Setear el current gatheringDTO utilizado para el edit
            this.getinventory$GatheringSessionBean().setCurrentGatheringDTO(DTOwithId);
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Refrescar la lista de recolecciones
        this.getinventory$GatheringSessionBean().getPagination().refreshList();

        /*Indicar a la pantalla de edit que cargue 1 sola ves los datos
        seleccionados de los AddRemove*/
        this.getinventory$GatheringSessionBean().setFirstTime(true);

        //Dependiendo del valor la variable UseDetail, asi se va a renderizar en el editGathering
        Long currentColl = this.getAraSessionBean().getGlobalCollectionId();
        boolean useDetail = this.getinventory$GatheringSessionBean().matchCollectionProtocol(currentColl,
                ProtocolAtributeEntity.USE_GATHERING_DETAIL.getId(),
                CollectionProtocolValuesEntity.TRUE_VALUE.getValue());
        this.getinventory$GatheringSessionBean().setUseDetail(useDetail);

        //Retornar regla de navegacion para generar especimenes de la nueva recoleccion
        return "edit";
    }

    /**
     * Metodo que toma los valores seleccionados en el add remove de colectores
     * y los transforma en una lista de PersonDTO
     */
    private List<PersonDTO> colectorsAsDTO(){
        GatheringSessionBean gsb = this.getinventory$GatheringSessionBean();
        List<PersonDTO> result = new ArrayList();
        Long[] opList = gsb.getArCollectors().getSelectedOptions();


		int arrayLength = 0;

		if(opList != null){
			arrayLength = opList.length;
			for(int i = 0; i < arrayLength; i++){
			   PersonDTO aux = new PersonDTO();
				aux.setPersonKey(opList[i]);
				result.add(aux);
			}
		}
		
        return result;
    }

    /**
     * Metodo que toma los valores seleccionados en el add remove de projectos
     * y los transforma en una lista de PersonDTO
     */
    private List<ProjectDTO> projectsAsDTO(){
        GatheringSessionBean gsb = this.getinventory$GatheringSessionBean();
        List<ProjectDTO> result = new ArrayList();
        Long[] opList = gsb.getArProjects().getSelectedOptions();


		int arrayLength = 0;

		if(opList != null){
			arrayLength = opList.length;
			for(int i = 0; i < arrayLength; i++){
				ProjectDTO aux = new ProjectDTO();
				aux.setProjectId(opList[i]);
				result.add(aux);
			}
		}

        return result;
    }

    /**
     * Metodo que toma los valores seleccionados en el add remove de colecciones asociadas
     * y los transforma en una lista de PersonDTO
     */
    private List<CollectionDTO> collectionsAsDTO(){
        GatheringSessionBean gsb = this.getinventory$GatheringSessionBean();
        List<CollectionDTO> result = new ArrayList();
        Long[] opList = gsb.getArCollections().getSelectedOptions();

		int arrayLength = 0;

		if(opList != null){
			arrayLength = opList.length;
			for(int i = 0; i < arrayLength; i++){
				CollectionDTO aux = new CollectionDTO();
				aux.setCollectionId(opList[i]);
				result.add(aux);
			}
		}

        return result;
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
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
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
     * @return the ddLocalities
     */
    public DropDown getDdLocalities() {
        return ddLocalities;
    }

    /**
     * @param ddLocalities the ddLocalities to set
     */
    public void setDdLocalities(DropDown ddLocalities) {
        this.ddLocalities = ddLocalities;
    }

    /**
     * @return the ddResponsible
     */
    public DropDown getDdResponsible() {
        return ddResponsible;
    }

    /**
     * @param ddResponsible the ddResponsible to set
     */
    public void setDdResponsible(DropDown ddResponsible) {
        this.ddResponsible = ddResponsible;
    }

    /**
     * @return the ddExposition
     */
    public DropDown getDdExposition() {
        return ddExposition;
    }

    /**
     * @param ddExposition the ddExposition to set
     */
    public void setDdExposition(DropDown ddExposition) {
        this.ddExposition = ddExposition;
    }

    /**
     * @return the localitiesData
     */
    public SingleSelectOptionsList getLocalitiesData() {
        return localitiesData;
    }

    /**
     * @param localitiesData the localitiesData to set
     */
    public void setLocalitiesData(SingleSelectOptionsList localitiesData) {
        this.localitiesData = localitiesData;
    }

    /**
     * @return the responsibleData
     */
    public SingleSelectOptionsList getResponsibleData() {
        return responsibleData;
    }

    /**
     * @param responsibleData the responsibleData to set
     */
    public void setResponsibleData(SingleSelectOptionsList responsibleData) {
        this.responsibleData = responsibleData;
    }

    /**
     * @return the expositionData
     */
    public SingleSelectOptionsList getExpositionData() {
        return expositionData;
    }

    /**
     * @param expositionData the expositionData to set
     */
    public void setExpositionData(SingleSelectOptionsList expositionData) {
        this.expositionData = expositionData;
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
     * @return the txGradient
     */
    public TextField getTxGradient() {
        return txGradient;
    }

    /**
     * @param txGradient the txGradient to set
     */
    public void setTxGradient(TextField txGradient) {
        this.txGradient = txGradient;
    }

    /**
     * @return the txElevationMin
     */
    public TextField getTxElevationMin() {
        return txElevationMin;
    }

    /**
     * @param txElevationMin the txElevationMin to set
     */
    public void setTxElevationMin(TextField txElevationMin) {
        this.txElevationMin = txElevationMin;
    }

    /**
     * @return the txElevationMax
     */
    public TextField getTxElevationMax() {
        return txElevationMax;
    }

    /**
     * @param txElevationMax the txElevationMax to set
     */
    public void setTxElevationMax(TextField txElevationMax) {
        this.txElevationMax = txElevationMax;
    }

    /**
     * @return the txDepthMin
     */
    public TextField getTxDepthMin() {
        return txDepthMin;
    }

    /**
     * @param txDepthMin the txDepthMin to set
     */
    public void setTxDepthMin(TextField txDepthMin) {
        this.txDepthMin = txDepthMin;
    }

    /**
     * @return the txDepthMax
     */
    public TextField getTxDepthMax() {
        return txDepthMax;
    }

    /**
     * @param txDepthMax the txDepthMax to set
     */
    public void setTxDepthMax(TextField txDepthMax) {
        this.txDepthMax = txDepthMax;
    }

    /**
     * @return the txaSurrounding
     */
    public TextArea getTxaSurrounding() {
        return txaSurrounding;
    }

    /**
     * @param txaSurrounding the txaSurrounding to set
     */
    public void setTxaSurrounding(TextArea txaSurrounding) {
        this.txaSurrounding = txaSurrounding;
    }

    /**
     * @return the txaSiteDescription
     */
    public TextArea getTxaSiteDescription() {
        return txaSiteDescription;
    }

    /**
     * @param txaSiteDescription the txaSiteDescription to set
     */
    public void setTxaSiteDescription(TextArea txaSiteDescription) {
        this.txaSiteDescription = txaSiteDescription;
    }
}

