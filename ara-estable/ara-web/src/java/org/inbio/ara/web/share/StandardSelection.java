/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.web.share;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.RadioButtonGroup;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import javax.faces.FacesException;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.admin.selectionlist.SelectionListSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.util.SelectionListBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.RequestBean1;
import org.inbio.ara.web.admin.collection.AdminCollectionSessionBean;
import org.inbio.ara.web.gathering.GatheringDetailSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.AraRequestBean;
import org.inbio.ara.web.SessionBean1;
import org.inbio.ara.web.identification.IdentificationSessionBean;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.site.SiteSessionBean;
import org.inbio.ara.web.specimen.EditSpecimenSessionBean;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.gathering.SpecimenGenerationSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.util.BundleHelper;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version StandardSelection.java
 * @version Created on 23/03/2009, 08:30:47 AM
 * @author esmata
 */

public class StandardSelection extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private SingleSelectOptionsList radioButtonGroup1DefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getRadioButtonGroup1DefaultOptions() {
        return radioButtonGroup1DefaultOptions;
    }

    public void setRadioButtonGroup1DefaultOptions(SingleSelectOptionsList ssol) {
        this.radioButtonGroup1DefaultOptions = ssol;
    }

    // </editor-fold>
    //My variables
    private RadioButtonGroup radioButtonGroup1 = new RadioButtonGroup();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public StandardSelection() {
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
            log("StandardSelection Initialization Failure", e);
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
        //Inicialization of radio button group options
        Option op1 = new Option(1,BundleHelper.getDefaultBundleValue("standard_plinian"));
        Option op2 = new Option(2,BundleHelper.getDefaultBundleValue("standard_darwin"));
        Option options[] = {op1,op2};
        this.radioButtonGroup1.setItems(options);
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
    protected MessageBean getutil$MessageBean() {
        return (MessageBean) getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SelectionListSessionBean getadmin$selectionlist$SelectionListSessionBean() {
        return (SelectionListSessionBean) getBean("admin$selectionlist$SelectionListSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
        return (ProfileSessionBean) getBean("admin$profile$ProfileSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SelectionListBean getutil$SelectionListBean() {
        return (SelectionListBean) getBean("util$SelectionListBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
        return (GatheringSessionBeanV2) getBean("gathering$GatheringSessionBeanV2");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AudienceSessionBean getaudience$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("audience$AudienceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBeanShare getshare$SessionBeanShare() {
        return (SessionBeanShare) getBean("share$SessionBeanShare");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PersonSessionBean getadmin$person$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$person$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AdminCollectionSessionBean getadmin$collection$AdminCollectionSessionBean() {
        return (AdminCollectionSessionBean) getBean("admin$collection$AdminCollectionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("gathering$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean) getBean("references$ReferenceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected NomenclaturalGroupSessionBean getnomenclaturalgroup$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean) getBean("nomenclaturalgroup$NomenclaturalGroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean) getBean("AraRequestBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("identification$IdentificationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpecimenSessionBean getspecimen$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("specimen$SpecimenSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SiteSessionBean getsite$SiteSessionBean() {
        return (SiteSessionBean) getBean("site$SiteSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected EditSpecimenSessionBean getspecimen$EditSpecimenSessionBean() {
        return (EditSpecimenSessionBean) getBean("specimen$EditSpecimenSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
        return (InstitutionSessionBean) getBean("admin$institution$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (SpeciesSessionBean) getBean("species$SpeciesSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean) getBean("AraApplicationBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("gathering$SpecimenGenerationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IdentificationSearchSessionBean getidentification$IdentificationSearchSessionBean() {
        return (IdentificationSearchSessionBean) getBean("identification$IdentificationSearchSessionBean");
    }

    public String button1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        int selected_item = this.getshare$SessionBeanShare().getResult_radio_group();
        if (selected_item == 1){
            //return "irPlinian";
            MessageBean.setSuccessMessageFromBundle("not_yet");
            return null;
        }
        else if(selected_item == 2)
            return "irDarwin";
        else return "";
    }

    /**
     * @return the radioButtonGroup1
     */
    public // </editor-fold>
    //My variables
    RadioButtonGroup getRadioButtonGroup1() {
        return radioButtonGroup1;
    }

    /**
     * @param radioButtonGroup1 the radioButtonGroup1 to set
     */
    public void setRadioButtonGroup1(RadioButtonGroup radioButtonGroup1) {
        this.radioButtonGroup1 = radioButtonGroup1;
    }
    
}

