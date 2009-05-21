/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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
/*
 * identificationGenerationFragment.java
 *
 * Created on June 11, 2008, 11:37 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.gathering;

import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import com.sun.webui.jsf.component.AddRemove;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Listbox;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.model.DefaultOptionsList;
import com.sun.webui.jsf.model.MultipleSelectOptionsList;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import javax.faces.FacesException;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.AraRequestBean;
import org.inbio.ara.web.RequestBean1;
import org.inbio.ara.web.SessionBean1;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.util.SelectionListBean;

/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class identificationGenerationFragment extends AbstractFragmentBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization. <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    private PanelLayout layoutPanel1 = new PanelLayout();

    public PanelLayout getLayoutPanel1() {
        return layoutPanel1;
    }

    public void setLayoutPanel1(PanelLayout pl) {
        this.layoutPanel1 = pl;
    }

    private Label label1 = new Label();

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label l) {
        this.label1 = l;
    }

    private Label label2 = new Label();

    public Label getLabel2() {
        return label2;
    }

    public void setLabel2(Label l) {
        this.label2 = l;
    }

    private DropDown dd_taxonomicalRange = new DropDown();

    public DropDown getDd_taxonomicalRange() {
        return dd_taxonomicalRange;
    }

    public void setDd_taxonomicalRange(DropDown dd) {
        this.dd_taxonomicalRange = dd;
    }

    private SingleSelectOptionsList dd_taxonomicalRangeDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDd_taxonomicalRangeDefaultOptions() {
        return dd_taxonomicalRangeDefaultOptions;
    }

    public void setDd_taxonomicalRangeDefaultOptions(SingleSelectOptionsList ssol) {
        this.dd_taxonomicalRangeDefaultOptions = ssol;
    }

    private DropDown dd_taxonomicalCategory = new DropDown();

    public DropDown getDd_taxonomicalCategory() {
        return dd_taxonomicalCategory;
    }

    public void setDd_taxonomicalCategory(DropDown dd) {
        this.dd_taxonomicalCategory = dd;
    }

    private SingleSelectOptionsList dd_taxonomicalCategoryDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDd_taxonomicalCategoryDefaultOptions() {
        return dd_taxonomicalCategoryDefaultOptions;
    }

    public void setDd_taxonomicalCategoryDefaultOptions(SingleSelectOptionsList ssol) {
        this.dd_taxonomicalCategoryDefaultOptions = ssol;
    }

    private AddRemove ad_taxonList = new AddRemove();

    public AddRemove getAd_taxonList() {
        return ad_taxonList;
    }

    public void setAd_taxonList(AddRemove ar) {
        this.ad_taxonList = ar;
    }

    private MultipleSelectOptionsList ad_taxonListDefaultOptions = new MultipleSelectOptionsList();

    public MultipleSelectOptionsList getAd_taxonListDefaultOptions() {
        return ad_taxonListDefaultOptions;
    }

    public void setAd_taxonListDefaultOptions(MultipleSelectOptionsList msol) {
        this.ad_taxonListDefaultOptions = msol;
    }

    private Label label3 = new Label();

    public Label getLabel3() {
        return label3;
    }

    public void setLabel3(Label l) {
        this.label3 = l;
    }

    private Calendar cal_identificationDate = new Calendar();

    public Calendar getCal_identificationDate() {
        return cal_identificationDate;
    }

    public void setCal_identificationDate(Calendar c) {
        this.cal_identificationDate = c;
    }

    private Label label4 = new Label();

    public Label getLabel4() {
        return label4;
    }

    public void setLabel4(Label l) {
        this.label4 = l;
    }

    private DropDown dd_identificationStatus = new DropDown();

    public DropDown getDd_identificationStatus() {
        return dd_identificationStatus;
    }

    public void setDd_identificationStatus(DropDown dd) {
        this.dd_identificationStatus = dd;
    }

    private SingleSelectOptionsList dd_identificationStatusDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDd_identificationStatusDefaultOptions() {
        return dd_identificationStatusDefaultOptions;
    }

    public void setDd_identificationStatusDefaultOptions(SingleSelectOptionsList ssol) {
        this.dd_identificationStatusDefaultOptions = ssol;
    }

    private Label label5 = new Label();

    public Label getLabel5() {
        return label5;
    }

    public void setLabel5(Label l) {
        this.label5 = l;
    }

    private DropDown dd_identificationType = new DropDown();

    public DropDown getDd_identificationType() {
        return dd_identificationType;
    }

    public void setDd_identificationType(DropDown dd) {
        this.dd_identificationType = dd;
    }

    private SingleSelectOptionsList dd_identificationTypeDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDd_identificationTypeDefaultOptions() {
        return dd_identificationTypeDefaultOptions;
    }

    public void setDd_identificationTypeDefaultOptions(SingleSelectOptionsList ssol) {
        this.dd_identificationTypeDefaultOptions = ssol;
    }

    private Label label6 = new Label();

    public Label getLabel6() {
        return label6;
    }

    public void setLabel6(Label l) {
        this.label6 = l;
    }

    private DropDown dd_validator = new DropDown();

    public DropDown getDd_validator() {
        return dd_validator;
    }

    public void setDd_validator(DropDown dd) {
        this.dd_validator = dd;
    }

    private SingleSelectOptionsList dd_validatorDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDd_validatorDefaultOptions() {
        return dd_validatorDefaultOptions;
    }

    public void setDd_validatorDefaultOptions(SingleSelectOptionsList ssol) {
        this.dd_validatorDefaultOptions = ssol;
    }

    private AddRemove ar_identifier = new AddRemove();

    public AddRemove getAr_identifier() {
        return ar_identifier;
    }

    public void setAr_identifier(AddRemove ar) {
        this.ar_identifier = ar;
    }

    private MultipleSelectOptionsList ar_identifierDefaultOptions = new MultipleSelectOptionsList();

    public MultipleSelectOptionsList getAr_identifierDefaultOptions() {
        return ar_identifierDefaultOptions;
    }

    public void setAr_identifierDefaultOptions(MultipleSelectOptionsList msol) {
        this.ar_identifierDefaultOptions = msol;
    }

    private Label label7 = new Label();

    public Label getLabel7() {
        return label7;
    }

    public void setLabel7(Label l) {
        this.label7 = l;
    }
    // </editor-fold>
    
    public identificationGenerationFragment() {
    }
    
    /**
     * <p>Callback method that is called whenever a page containing
     * this page fragment is navigated to, either directly via a URL,
     * or indirectly via page navigation.  Override this method to acquire
     * resources that will be needed for event handlers and lifecycle methods.</p>
     *
     * <p>The default implementation does nothing.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        
        // <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }
    
    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called.  Override this
     * method to release resources acquired in the <code>init()</code>
     * resources that will be needed for event handlers and lifecycle methods.</p>
     *
     * <p>The default implementation does nothing.</p>
     */
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected UserSessionBean getuser$UserSessionBean() {
        return (UserSessionBean)getBean("user$UserSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AudienceSessionBean getaudience$AudienceSessionBean() {
        return (AudienceSessionBean)getBean("audience$AudienceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
        return (InstitutionSessionBean)getBean("admin$institution$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected PersonSessionBean getadmin$person$PersonSessionBean() {
        return (PersonSessionBean)getBean("admin$person$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
        return (GatheringSessionBeanV2)getBean("gathering$GatheringSessionBeanV2");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GroupSessionBean getgroup$GroupSessionBean() {
        return (GroupSessionBean)getBean("group$GroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
        return (ProfileSessionBean)getBean("admin$profile$ProfileSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean)getBean("references$ReferenceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SelectionListBean getutil$SelectionListBean() {
        return (SelectionListBean)getBean("util$SelectionListBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (SpeciesSessionBean)getBean("species$SpeciesSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean)getBean("AraRequestBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1)getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean)getBean("gathering$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.gathering.SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
        return (org.inbio.ara.web.gathering.SpecimenGenerationSessionBean)getBean("gathering$SpecimenGenerationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1)getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.identification.IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (org.inbio.ara.web.identification.IdentificationSessionBean)getBean("identification$IdentificationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.site.SiteSessionBean getsite$SiteSessionBean() {
        return (org.inbio.ara.web.site.SiteSessionBean)getBean("site$SiteSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected NomenclaturalGroupSessionBean getnomenclaturalgroup$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean)getBean("nomenclaturalgroup$NomenclaturalGroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.identification.IdentificationSearchSessionBean getidentification$IdentificationSearchSessionBean() {
        return (org.inbio.ara.web.identification.IdentificationSearchSessionBean)getBean("identification$IdentificationSearchSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.specimen.SpecimenSessionBean getspecimen$SpecimenSessionBean() {
        return (org.inbio.ara.web.specimen.SpecimenSessionBean)getBean("specimen$SpecimenSessionBean");
    }
}
