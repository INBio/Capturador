/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dublincore;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.FacesException;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.germplasm.SementalSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.taxonomy.TaxonSessionBean;
import org.inbio.ara.reports.ReportsSessionBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.germplasm.AccessionSessionBean;
import org.inbio.ara.germplasm.PassportSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.germplasm.BreedSessionBean;
import org.inbio.ara.germplasm.PassportListSessionBean;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.indicator.IndicatorSessionBean;
import org.inbio.ara.transaction.TransactionSessionBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.admin.InstitutionSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.admin.AdminGeographicLayersSessionBean;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.taxonomy.SpeciesSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.taxonomy.NomenclaturalGroupSessionBean;
import org.inbio.ara.gis.SiteSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.germplasm.SemenGatheringSessionBean;
import org.inbio.ara.taxonomy.TaxonomySessionBean;
import org.inbio.ara.reports.SnapshotSessionBean;
import org.inbio.ara.germplasm.AccessionMovementSessionBean;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;
import org.inbio.commons.dublincore.model.ResourceTypeEnum;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditDublinCore.java
 * @version Created on 03/09/2010, 11:32:56 AM
 * @author dasolano
 */

public class EditDublinCore extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private SingleSelectOptionsList resourceType = new SingleSelectOptionsList();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditDublinCore() {
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
            log("EditDublinCore Initialization Failure", e);
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
        getResourceType().setOptions(updateResourceType());
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
     * Update the taxon drop down
     * @return
     */
    public Option[] updateResourceType() {

        Option[] allOptionsInArray = null;
        Option option = null;
        ArrayList<Option> allOptions = new ArrayList<Option>();
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);

        option = new Option(new Long(ResourceTypeEnum.DATAPROVIDER.id), BundleHelper.getDefaultBundleValue(ResourceTypeEnum.DATAPROVIDER.name,getMyLocale()));
        allOptions.add(option);
        option = new Option(new Long(ResourceTypeEnum.DATARESOURCE.id),BundleHelper.getDefaultBundleValue(ResourceTypeEnum.DATARESOURCE.name,getMyLocale()));
        allOptions.add(option);
        option = new Option(new Long(ResourceTypeEnum.REFERENCE.id),BundleHelper.getDefaultBundleValue(ResourceTypeEnum.REFERENCE.name,getMyLocale()));
        allOptions.add(option);

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
     * Performed the create breed action
     * @return
     */
    public String updateDublinCore()
    {
        try
        {
            //set the username
            getdublincore$DublinCoreSessionBean().getDublinCoreDTO().
                    setUserName(getAraSessionBean().getGlobalUserName());
            //save the data
            getdublincore$DublinCoreSessionBean().getDublinCoreFacadeRemote().
                    updateDublinCore(
                    getdublincore$DublinCoreSessionBean().getDublinCoreDTO());

            getdublincore$DublinCoreSessionBean().getPagination().refreshList();
            
            MessageBean.setSuccessMessageFromBundle("edit_dublin_core_successfull", this.getMyLocale());
        }
        catch(Exception e)
        {
            MessageBean.setErrorMessageFromBundle("error_dc_repeated_field", this.getMyLocale());
            e.printStackTrace();

        }
        return null;
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
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("inventory$SpecimenGenerationSessionBean");
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
    protected CollectionSessionBean getadmin$CollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected TaxonSessionBean gettaxonomy$TaxonSessionBean() {
        return (TaxonSessionBean) getBean("taxonomy$TaxonSessionBean");
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
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
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
    protected PassportSessionBean getgermplasm$PassportSessionBean() {
        return (PassportSessionBean) getBean("germplasm$PassportSessionBean");
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
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
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
    protected PassportListSessionBean getgermplasm$PassportListSessionBean() {
        return (PassportListSessionBean) getBean("germplasm$PassportListSessionBean");
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
    protected IndicatorSessionBean getindicator$IndicatorSessionBean() {
        return (IndicatorSessionBean) getBean("indicator$IndicatorSessionBean");
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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
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
    protected InstitutionSessionBean getadmin$InstitutionSessionBean() {
        return (InstitutionSessionBean) getBean("admin$InstitutionSessionBean");
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
    protected IdentificationSessionBean getinventory$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("inventory$IdentificationSessionBean");
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
    protected AudienceSessionBean getadmin$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("admin$AudienceSessionBean");
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
    protected SpeciesSessionBean gettaxonomy$SpeciesSessionBean() {
        return (SpeciesSessionBean) getBean("taxonomy$SpeciesSessionBean");
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
    protected NomenclaturalGroupSessionBean gettaxonomy$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean) getBean("taxonomy$NomenclaturalGroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SiteSessionBean getgis$SiteSessionBean() {
        return (SiteSessionBean) getBean("gis$SiteSessionBean");
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
    protected SemenGatheringSessionBean getgermplasm$SemenGatheringSessionBean() {
        return (SemenGatheringSessionBean) getBean("germplasm$SemenGatheringSessionBean");
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
    protected SnapshotSessionBean getreports$SnapshotSessionBean() {
        return (SnapshotSessionBean) getBean("reports$SnapshotSessionBean");
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
     * @return the resourceType
     */
    public SingleSelectOptionsList getResourceType() {
        return resourceType;
    }

    /**
     * @param resourceType the resourceType to set
     */
    public void setResourceType(SingleSelectOptionsList resourceType) {
        this.resourceType = resourceType;
    }
    
}

