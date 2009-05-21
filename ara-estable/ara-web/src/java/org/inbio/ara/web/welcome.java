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
 * welcome.java
 *
 * Created on October 2, 2007, 3:03 AM
 * Copyright roaguilar
 */
package org.inbio.ara.web;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageComponent;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.StaticText;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.UIColumn;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.species.newTaxonDescriptionRecord;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.util.BundleHelper;
import org.inbio.ara.web.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class welcome extends AbstractPageBean {
	
	public static final String WELCOME_SYSTEM = BundleHelper.getDefaultBundleValue("welcome_system");
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    
    private Page page1 = new Page();
    
    public Page getPage1() {
        return page1;
    }
    
    public void setPage1(Page p) {
        this.page1 = p;
    }
    
    private Html html1 = new Html();
    
    public Html getHtml1() {
        return html1;
    }
    
    public void setHtml1(Html h) {
        this.html1 = h;
    }
    
    private Head head1 = new Head();
    
    public Head getHead1() {
        return head1;
    }
    
    public void setHead1(Head h) {
        this.head1 = h;
    }
    
    private Link link1 = new Link();
    
    public Link getLink1() {
        return link1;
    }
    
    public void setLink1(Link l) {
        this.link1 = l;
    }
    
    private Body body1 = new Body();
    
    public Body getBody1() {
        return body1;
    }
    
    public void setBody1(Body b) {
        this.body1 = b;
    }
    
    private Form form1 = new Form();
    
    public Form getForm1() {
        return form1;
    }
    
    public void setForm1(Form f) {
        this.form1 = f;
    }

    private StaticText staticText1 = new StaticText();

    public StaticText getStaticText1() {
        return staticText1;
    }

    public void setStaticText1(StaticText st) {
        this.staticText1 = st;
    }

    private ImageComponent image1 = new ImageComponent();

    public ImageComponent getImage1() {
        return image1;
    }

    public void setImage1(ImageComponent ic) {
        this.image1 = ic;
    }

    private HtmlDataTable dataTable1 = new HtmlDataTable();

    public HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setDataTable1(HtmlDataTable hdt) {
        this.dataTable1 = hdt;
    }
    
    private UIColumn column12 = new UIColumn();

    public UIColumn getColumn12() {
        return column12;
    }

    public void setColumn12(UIColumn uic) {
        this.column12 = uic;
    }

    private UIColumn column1 = new UIColumn();

    public UIColumn getColumn1() {
        return column1;
    }

    public void setColumn1(UIColumn uic) {
        this.column1 = uic;
    }

    private HtmlOutputText outputText1 = new HtmlOutputText();

    public HtmlOutputText getOutputText1() {
        return outputText1;
    }

    public void setOutputText1(HtmlOutputText hot) {
        this.outputText1 = hot;
    }

    private UIColumn column2 = new UIColumn();

    public UIColumn getColumn2() {
        return column2;
    }

    public void setColumn2(UIColumn uic) {
        this.column2 = uic;
    }

    private HtmlDataTable dataTable2 = new HtmlDataTable();

    public HtmlDataTable getDataTable2() {
        return dataTable2;
    }

    public void setDataTable2(HtmlDataTable hdt) {
        this.dataTable2 = hdt;
    }

    private UIColumn column3 = new UIColumn();

    public UIColumn getColumn3() {
        return column3;
    }

    public void setColumn3(UIColumn uic) {
        this.column3 = uic;
    }

    private Hyperlink hlink_especies = new Hyperlink();

    public Hyperlink getHlink_especies() {
        return hlink_especies;
    }

    public void setHlink_especies(Hyperlink h) {
        this.hlink_especies = h;
    }

    private UIColumn column4 = new UIColumn();

    public UIColumn getColumn4() {
        return column4;
    }

    public void setColumn4(UIColumn uic) {
        this.column4 = uic;
    }

    private Hyperlink hlink_person1 = new Hyperlink();

    public Hyperlink getHlink_person1() {
        return hlink_person1;
    }

    public void setHlink_person1(Hyperlink h) {
        this.hlink_person1 = h;
    }

    private UIColumn column5 = new UIColumn();

    public UIColumn getColumn5() {
        return column5;
    }

    public void setColumn5(UIColumn uic) {
        this.column5 = uic;
    }

    private Hyperlink hlink_profile1 = new Hyperlink();

    public Hyperlink getHlink_profile1() {
        return hlink_profile1;
    }

    public void setHlink_profile1(Hyperlink h) {
        this.hlink_profile1 = h;
    }

    private UIColumn column6 = new UIColumn();

    public UIColumn getColumn6() {
        return column6;
    }

    public void setColumn6(UIColumn uic) {
        this.column6 = uic;
    }

    private Hyperlink hlink_institution1 = new Hyperlink();

    public Hyperlink getHlink_institution1() {
        return hlink_institution1;
    }

    public void setHlink_institution1(Hyperlink h) {
        this.hlink_institution1 = h;
    }

    private UIColumn column7 = new UIColumn();

    public UIColumn getColumn7() {
        return column7;
    }

    public void setColumn7(UIColumn uic) {
        this.column7 = uic;
    }

    private Hyperlink hlink_user1 = new Hyperlink();

    public Hyperlink getHlink_user1() {
        return hlink_user1;
    }

    public void setHlink_user1(Hyperlink h) {
        this.hlink_user1 = h;
    }

    private UIColumn column8 = new UIColumn();

    public UIColumn getColumn8() {
        return column8;
    }

    public void setColumn8(UIColumn uic) {
        this.column8 = uic;
    }

    private Hyperlink hlink_changePwd1 = new Hyperlink();

    public Hyperlink getHlink_changePwd1() {
        return hlink_changePwd1;
    }

    public void setHlink_changePwd1(Hyperlink h) {
        this.hlink_changePwd1 = h;
    }

    private UIColumn column11 = new UIColumn();

    public UIColumn getColumn11() {
        return column11;
    }

    public void setColumn11(UIColumn uic) {
        this.column11 = uic;
    }

    private Hyperlink hlink_showWelcome = new Hyperlink();

    public Hyperlink getHlink_showWelcome() {
        return hlink_showWelcome;
    }

    public void setHlink_showWelcome(Hyperlink h) {
        this.hlink_showWelcome = h;
    }

    private Hyperlink hlink_groups = new Hyperlink();

    public Hyperlink getHlink_groups() {
        return hlink_groups;
    }

    public void setHlink_groups(Hyperlink h) {
        this.hlink_groups = h;
    }

    private Hyperlink hlink_taxonomy = new Hyperlink();

    public Hyperlink getHlink_taxonomy() {
        return hlink_taxonomy;
    }

    public void setHlink_taxonomy(Hyperlink h) {
        this.hlink_taxonomy = h;
    }

    private UIColumn column13 = new UIColumn();

    public UIColumn getColumn13() {
        return column13;
    }

    public void setColumn13(UIColumn uic) {
        this.column13 = uic;
    }

    private UIColumn column14 = new UIColumn();

    public UIColumn getColumn14() {
        return column14;
    }

    public void setColumn14(UIColumn uic) {
        this.column14 = uic;
    }

    private Hyperlink hlink_estados = new Hyperlink();

    public Hyperlink getHlink_estados() {
        return hlink_estados;
    }

    public void setHlink_estados(Hyperlink h) {
        this.hlink_estados = h;
    }

    private StaticText staticText2 = new StaticText();

    public StaticText getStaticText2() {
        return staticText2;
    }

    public void setStaticText2(StaticText st) {
        this.staticText2 = st;
    }

    private StaticText staticText3 = new StaticText();

    public StaticText getStaticText3() {
        return staticText3;
    }

    public void setStaticText3(StaticText st) {
        this.staticText3 = st;
    }

    private StaticText st_1 = new StaticText();

    public StaticText getSt_1() {
        return st_1;
    }

    public void setSt_1(StaticText st) {
        this.st_1 = st;
    }

    private StaticText staticText4 = new StaticText();

    public StaticText getStaticText4() {
        return staticText4;
    }

    public void setStaticText4(StaticText st) {
        this.staticText4 = st;
    }

    private StaticText staticText5 = new StaticText();

    public StaticText getStaticText5() {
        return staticText5;
    }

    public void setStaticText5(StaticText st) {
        this.staticText5 = st;
    }

    private StaticText staticText6 = new StaticText();

    public StaticText getStaticText6() {
        return staticText6;
    }

    public void setStaticText6(StaticText st) {
        this.staticText6 = st;
    }

    private StaticText staticText7 = new StaticText();

    public StaticText getStaticText7() {
        return staticText7;
    }

    public void setStaticText7(StaticText st) {
        this.staticText7 = st;
    }

    private StaticText staticText8 = new StaticText();

    public StaticText getStaticText8() {
        return staticText8;
    }

    public void setStaticText8(StaticText st) {
        this.staticText8 = st;
    }

    private StaticText staticText9 = new StaticText();

    public StaticText getStaticText9() {
        return staticText9;
    }

    public void setStaticText9(StaticText st) {
        this.staticText9 = st;
    }

    private StaticText staticText10 = new StaticText();

    public StaticText getStaticText10() {
        return staticText10;
    }

    public void setStaticText10(StaticText st) {
        this.staticText10 = st;
    }

    private StaticText staticText11 = new StaticText();

    public StaticText getStaticText11() {
        return staticText11;
    }

    public void setStaticText11(StaticText st) {
        this.staticText11 = st;
    }

    private StaticText st_2 = new StaticText();

    public StaticText getSt_2() {
        return st_2;
    }

    public void setSt_2(StaticText st) {
        this.st_2 = st;
    }

    private StaticText st_3 = new StaticText();

    public StaticText getSt_3() {
        return st_3;
    }

    public void setSt_3(StaticText st) {
        this.st_3 = st;
    }

    private StaticText st_4 = new StaticText();

    public StaticText getSt_4() {
        return st_4;
    }

    public void setSt_4(StaticText st) {
        this.st_4 = st;
    }

    private StaticText st_5 = new StaticText();

    public StaticText getSt_5() {
        return st_5;
    }

    public void setSt_5(StaticText st) {
        this.st_5 = st;
    }

    private StaticText st_6 = new StaticText();

    public StaticText getSt_6() {
        return st_6;
    }

    public void setSt_6(StaticText st) {
        this.st_6 = st;
    }

    private StaticText st_7 = new StaticText();

    public StaticText getSt_7() {
        return st_7;
    }

    public void setSt_7(StaticText st) {
        this.st_7 = st;
    }

    private StaticText st_8 = new StaticText();

    public StaticText getSt_8() {
        return st_8;
    }

    public void setSt_8(StaticText st) {
        this.st_8 = st;
    }

    private StaticText st_9 = new StaticText();

    public StaticText getSt_9() {
        return st_9;
    }

    public void setSt_9(StaticText st) {
        this.st_9 = st;
    }

    private Hyperlink spanishLink1 = new Hyperlink();

    public Hyperlink getSpanishLink1() {
        return spanishLink1;
    }

    public void setSpanishLink1(Hyperlink h) {
        this.spanishLink1 = h;
    }

    private Hyperlink englishLink1 = new Hyperlink();

    public Hyperlink getEnglishLink1() {
        return englishLink1;
    }

    public void setEnglishLink1(Hyperlink h) {
        this.englishLink1 = h;
    }
    
    // </editor-fold>
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public welcome() {
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
            log("welcome Initialization Failure", e);
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
    public void prerender() {
        this.staticText1.setText(WELCOME_SYSTEM + this.getSessionManager().getUser().getFullName());
        this.staticText2.setText(this.getSessionManager().getCollection().getName());
        this.st_1.setText(this.getSessionManager().useGatheringDetail());
        this.st_2.setText(this.getSessionManager().getDefaultProjection());
        this.st_3.setText(this.getSessionManager().getDefaultGatheringMethod());
        this.st_4.setText(this.getSessionManager().canIdentifyWithSynonyms());
        this.st_5.setText(this.getSessionManager().useLifeForms());
        this.st_6.setText(this.getSessionManager().morphologicalDescriptionModuleName());
        this.st_7.setText(this.getSessionManager().reIdentifyOnTaxonRename());
        this.st_8.setText(this.getSessionManager().useCultures());
        this.st_9.setText(this.getSessionManager().sharesGatheringDetailNumber());
    }
    
    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
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
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
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
    protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
        return (ProfileSessionBean)getBean("admin$profile$ProfileSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.AraRequestBean getAraRequestBean() {
        return (org.inbio.ara.web.AraRequestBean)getBean("AraRequestBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.species.SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (org.inbio.ara.web.species.SpeciesSessionBean)getBean("species$SpeciesSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
    }

    public String hlink_species_action() {
        this.getspecies$SpeciesSessionBean().setFiltered(false);
        return "showSpeciesList";
    }
    
    public String hlink_stages_action() {
        return "listStages";
    }

    public String hlink_person_action() {
        this.getadmin$person$PersonSessionBean().setIsFiltered(false);
        return "case1";
    }

    public String hlink_profile_action() {
        this.getadmin$profile$ProfileSessionBean().setIsFiltered(false);
        return "case3";
    }

    public String hlink_institution_action() {
        this.getadmin$institution$InstitutionSessionBean().setIsFiltered(false);
        return "case2";
    }

    public String hlink_user_action() {
        return "showUser";
    }

    public String hlink_changePwd_action() {
        return "showChangePassword";
    }

    public String hlink_showWelcome_action() {
        return "showAudienceList";
    }

    public String hlink_exit_action() {
        this.getSessionManager().doLogoff();
        return "exit";
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.admin.institution.InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
        return (org.inbio.ara.web.admin.institution.InstitutionSessionBean)getBean("admin$institution$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GroupSessionBean getgroup$GroupSessionBean() {
        return (GroupSessionBean)getBean("group$GroupSessionBean");
    }

    public String hlink_groups_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return "showGroup";
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AudienceSessionBean getaudience$AudienceSessionBean() {
        return (AudienceSessionBean)getBean("audience$AudienceSessionBean");
    }

    public String hyperlink1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return null;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.NIUS.SpeciesTabular getNIUS$SpeciesTabular() {
        return (org.inbio.ara.web.NIUS.SpeciesTabular)getBean("NIUS$SpeciesTabular");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.references.ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (org.inbio.ara.web.references.ReferenceSessionBean)getBean("references$ReferenceSessionBean");
    }

    public String hlink_taxonomy_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return "case4";
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.SessionBean1 getSessionBean1() {
        return (org.inbio.ara.web.SessionBean1)getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.ApplicationBean1 getApplicationBean1() {
        return (org.inbio.ara.web.ApplicationBean1)getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.RequestBean1 getRequestBean1() {
        return (org.inbio.ara.web.RequestBean1)getBean("RequestBean1");
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
    protected org.inbio.ara.web.util.SelectionListBean getutil$SelectionListBean() {
        return (org.inbio.ara.web.util.SelectionListBean)getBean("util$SelectionListBean");
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
    protected newTaxonDescriptionRecord getspecies$newTaxonDescriptionRecord() {
        return (newTaxonDescriptionRecord)getBean("species$newTaxonDescriptionRecord");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.gathering.GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (org.inbio.ara.web.gathering.GatheringDetailSessionBean)getBean("gathering$GatheringDetailSessionBean");
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
    protected IdentificationSearchSessionBean getidentification$IdentificationSearchSessionBean() {
        return (IdentificationSearchSessionBean)getBean("identification$IdentificationSearchSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpecimenSessionBean getspecimen$SpecimenSessionBean() {
        return (SpecimenSessionBean)getBean("specimen$SpecimenSessionBean");
    }


    public String englishLink_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(Locale.ENGLISH);
        return null;
    }

    public String spanishLink_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale l = new Locale("ES");
        context.getViewRoot().setLocale(l);
        return null;
    }
}

