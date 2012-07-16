/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.samplemanage;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.taxonomy.TaxonomySessionBean;
import org.inbio.ara.taxonomy.NomenclaturalGroupSessionBean;
import org.inbio.ara.label.LabelSessionBean;
import org.inbio.ara.germplasm.AccessionMovementSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.germplasm.SementalSessionBean;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.reports.ReportsSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.label.SessionBean1;
import org.inbio.ara.taxonomy.SpeciesSessionBean;
import org.inbio.ara.dublincore.DublinCoreSessionBean;
import org.inbio.ara.germplasm.AccessionSessionBean;
import org.inbio.ara.admin.AdminGeographicLayersSessionBean;
import org.inbio.ara.germplasm.BreedSessionBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListSample.java
 * @version Created on 02/05/2011, 03:55:58 PM
 * @author dasolano
 */

public class ListSample extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private HtmlPanelGrid mainPanel = new HtmlPanelGrid();
    private HtmlDataTable dataTableSamples = new HtmlDataTable();

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListSample() {
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
            log("ListSample Initialization Failure", e);
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

        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(getsamplemanage$SampleManageSessionBean().isAdvancedSearch()){
            //this.getGridpAdvancedSearchAccession().setRendered(true);//Muestra el panel de busqueda avanzada
        }
        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        if (getsamplemanage$SampleManageSessionBean().getPagination()==null) {
            getsamplemanage$SampleManageSessionBean().initDataProvider();
        }
        //Actualizar los datos del paginador
        else
            getsamplemanage$SampleManageSessionBean().getPagination().refreshList();
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
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("inventory$SpecimenGenerationSessionBean");
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
    protected LabelSessionBean getlabel$LabelSessionBean() {
        return (LabelSessionBean) getBean("label$LabelSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AccessionMovementSessionBean getgermplasm$AccessionMovementSessionBean() {
        return (AccessionMovementSessionBean) getBean("germplasm$AccessionMovementSessionBean");
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
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SementalSessionBean getgermplasm$SementalSessionBean() {
        return (SementalSessionBean) getBean("germplasm$SementalSessionBean");
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
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
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
    protected ReportsSessionBean getreports$ReportsSessionBean() {
        return (ReportsSessionBean) getBean("reports$ReportsSessionBean");
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
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getlabel$SessionBean1() {
        return (SessionBean1) getBean("label$SessionBean1");
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
    protected SampleManageSessionBean getsamplemanage$SampleManageSessionBean() {
        return (SampleManageSessionBean) getBean("samplemanage$SampleManageSessionBean");
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
    protected AccessionSessionBean getgermplasm$AccessionSessionBean() {
        return (AccessionSessionBean) getBean("germplasm$AccessionSessionBean");
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
    protected BreedSessionBean getgermplasm$BreedSessionBean() {
        return (BreedSessionBean) getBean("germplasm$BreedSessionBean");
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
     * @return the dataTableSamples
     */
    public HtmlDataTable getDataTableSamples() {
        return dataTableSamples;
    }

    /**
     * @param dataTableSamples the dataTableSamples to set
     */
    public void setDataTableSamples(HtmlDataTable dataTableSamples) {
        this.dataTableSamples = dataTableSamples;
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        /*quantityTotal = this.getgermplasm$BreedSessionBean().getQuantityTotal();
        return quantityTotal;*/
        return quantityTotal;
    }
    
    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public String btn_new_action()
    {
        return "new";
    }

    public String btn_new_partition_action()
    {
        return "new_partition";
    }

    public String btn_deliver_action()
    {
        return "deliver";
    }

    public String btn_edit_action()
    {
        return "edit";
    }

    public String btn_delete_action()
    {
        return "delete";
    }
}

