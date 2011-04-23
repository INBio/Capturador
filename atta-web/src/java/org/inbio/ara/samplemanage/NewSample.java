/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.samplemanage;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.germplasm.BreedSessionBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.germplasm.PassportSessionBean;
import org.inbio.ara.transaction.TransactionSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.taxonomy.TaxonomySessionBean;
import org.inbio.ara.taxonomy.NomenclaturalGroupSessionBean;
import org.inbio.ara.gis.MapController;
import org.inbio.ara.germplasm.PassportListSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.dublincore.DublinCoreSessionBean;
import org.inbio.ara.reports.SnapshotSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.admin.AdminGeographicLayersSessionBean;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.taxonomy.TaxonAutoCompleteSessionBean;
import org.inbio.ara.util.BundleHelper;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version NewSample.java
 * @version Created on 23/03/2011, 09:17:51 AM
 * @author dasolano
 */

public class NewSample extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private TabSet sampleTabs= new TabSet();


    //En esta variable se setearan los datos del drop down de 
    private SingleSelectOptionsList sampleClassData = new SingleSelectOptionsList();
    private SingleSelectOptionsList permissionData = new SingleSelectOptionsList();
    private SingleSelectOptionsList microSourceTypeData = new SingleSelectOptionsList();
    private SingleSelectOptionsList microMethodData = new SingleSelectOptionsList();
    private SingleSelectOptionsList microFomeData = new SingleSelectOptionsList();
    private SingleSelectOptionsList microQualityData = new SingleSelectOptionsList();
    private SingleSelectOptionsList forestTypeData = new SingleSelectOptionsList();
    private SingleSelectOptionsList verticalStrataData = new SingleSelectOptionsList();
    private SingleSelectOptionsList vegetationTypeData = new SingleSelectOptionsList();


    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public NewSample() {
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
            log("NewSample Initialization Failure", e);
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
        getTaxonAutoCompleteSessionBean().setKingdomId(null);
        getTaxonAutoCompleteSessionBean().setCategoryId(null);
        
        sampleClassData.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.SAMPLE_CLASS.getId()));
        permissionData.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.PERMISSION.getId()));
        microSourceTypeData.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.MICRO_SOURCE_TYPE.getId()));
        microMethodData.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.MICRO_METHOD.getId()));
        microFomeData.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.MICRO_FOME.getId()));
        microQualityData.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.MICRO_QUALITY.getId()));
        forestTypeData.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.FOREST_TYPE.getId()));
        verticalStrataData.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.VERTICAL_STRATA.getId()));
        vegetationTypeData.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.VEGETATION_TYPE.getId()));

        
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

        //getAllSelectionListElementsByCollection
        List<SelectionListDTO> DTOList = this.getSampleManageSessionBean().
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
    protected TaxonAutoCompleteSessionBean getTaxonAutoCompleteSessionBean() {
        return (TaxonAutoCompleteSessionBean) getBean("taxonomy$TaxonAutoCompleteBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SampleManageSessionBean getSampleManageSessionBean() {
        return (SampleManageSessionBean) getBean("samplemanage$SampleManageSessionBean");
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PersonSessionBean getadmin$PersonSessionBean() {
        return (PersonSessionBean) getBean("t$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected BreedSessionBean getgermplasm$BreedSessionBean() {
        return (BreedSessionBean) getBean("germplasm$BreedSessionBean");
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
    protected AudienceSessionBean getadmin$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("admin$AudienceSessionBean");
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
    protected IdentificationSessionBean getinventory$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("inventory$IdentificationSessionBean");
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
    protected PassportSessionBean getgermplasm$PassportSessionBean() {
        return (PassportSessionBean) getBean("germplasm$PassportSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected TransactionSessionBean gettransaction$TransactionSessionBean() {
        return (TransactionSessionBean) getBean("transaction$TransactionSessionBean");
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
    protected TaxonomySessionBean gettaxonomy$TaxonomySessionBean() {
        return (TaxonomySessionBean) getBean("taxonomy$TaxonomySessionBean");
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
    protected MapController getgis$MapController() {
        return (MapController) getBean("gis$MapController");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PassportListSessionBean getgermplasm$PassportListSessionBean() {
        return (PassportListSessionBean) getBean("germplasm$PassportListSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ValidatorBean getutil$ValidatorBean() {
        return (ValidatorBean) getBean("util$ValidatorBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected DublinCoreSessionBean getdublincore$DublinCoreSessionBean() {
        return (DublinCoreSessionBean) getBean("dublincore$DublinCoreSessionBean");
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
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
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
    protected AdminGeographicLayersSessionBean getadmin$AdminGeographicLayersSessionBean() {
        return (AdminGeographicLayersSessionBean) getBean("admin$AdminGeographicLayersSessionBean");
    }

    /**
     * @return the sampleTabs
     */
    public TabSet getSampleTabs() {
        return sampleTabs;
    }

    /**
     * @param sampleTabs the sampleTabs to set
     */
    public void setSampleTabs(TabSet sampleTabs) {
        this.sampleTabs = sampleTabs;
    }

    /**
     * @return the sampleClassData
     */
    public SingleSelectOptionsList getSampleClassData() {
        return sampleClassData;
    }

    /**
     * @param sampleClassData the sampleClassData to set
     */
    public void setSampleClassData(SingleSelectOptionsList sampleClassData) {
        this.sampleClassData = sampleClassData;
    }

    /**
     * @return the permissionData
     */
    public SingleSelectOptionsList getPermissionData() {
        return permissionData;
    }

    /**
     * @param permissionData the permissionData to set
     */
    public void setPermissionData(SingleSelectOptionsList permissionData) {
        this.permissionData = permissionData;
    }

    /**
     * @return the microSourceTypeData
     */
    public SingleSelectOptionsList getMicroSourceTypeData() {
        return microSourceTypeData;
    }

    /**
     * @param microSourceTypeData the microSourceTypeData to set
     */
    public void setMicroSourceTypeData(SingleSelectOptionsList microSourceTypeData) {
        this.microSourceTypeData = microSourceTypeData;
    }

    /**
     * @return the microMethodData
     */
    public SingleSelectOptionsList getMicroMethodData() {
        return microMethodData;
    }

    /**
     * @param microMethodData the microMethodData to set
     */
    public void setMicroMethodData(SingleSelectOptionsList microMethodData) {
        this.microMethodData = microMethodData;
    }

    /**
     * @return the microFomeData
     */
    public SingleSelectOptionsList getMicroFomeData() {
        return microFomeData;
    }

    /**
     * @param microFomeData the microFomeData to set
     */
    public void setMicroFomeData(SingleSelectOptionsList microFomeData) {
        this.microFomeData = microFomeData;
    }

    /**
     * @return the microQualityData
     */
    public SingleSelectOptionsList getMicroQualityData() {
        return microQualityData;
    }

    /**
     * @param microQualityData the microQualityData to set
     */
    public void setMicroQualityData(SingleSelectOptionsList microQualityData) {
        this.microQualityData = microQualityData;
    }

    /**
     * @return the forestTypeData
     */
    public SingleSelectOptionsList getForestTypeData() {
        return forestTypeData;
    }

    /**
     * @param forestTypeData the forestTypeData to set
     */
    public void setForestTypeData(SingleSelectOptionsList forestTypeData) {
        this.forestTypeData = forestTypeData;
    }

    /**
     * @return the verticalStrataData
     */
    public SingleSelectOptionsList getVerticalStrataData() {
        return verticalStrataData;
    }

    /**
     * @param verticalStrataData the verticalStrataData to set
     */
    public void setVerticalStrataData(SingleSelectOptionsList verticalStrataData) {
        this.verticalStrataData = verticalStrataData;
    }

    /**
     * @return the vegetationTypeData
     */
    public SingleSelectOptionsList getVegetationTypeData() {
        return vegetationTypeData;
    }

    /**
     * @param vegetationTypeData the vegetationTypeData to set
     */
    public void setVegetationTypeData(SingleSelectOptionsList vegetationTypeData) {
        this.vegetationTypeData = vegetationTypeData;
    }

   
}

