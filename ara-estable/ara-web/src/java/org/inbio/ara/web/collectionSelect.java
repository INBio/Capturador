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
 * collectionSelect.java
 *
 * Created on April 28, 2008, 9:52 AM
 * Copyright roaguilar
 */
package org.inbio.ara.web;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageComponent;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Listbox;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.model.Option;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlMessages;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.collection.CollectionRemote;
import org.inbio.ara.facade.util.SelectionListManagerRemote;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.gathering.GatheringDetailSessionBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.gathering.SpecimenGenerationSessionBean;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.species.newTaxonDescriptionRecord;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.util.BundleHelper;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.util.SelectionListBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class collectionSelect extends AbstractPageBean {
	
	public static final String NOTHING_SELECTED = BundleHelper.getDefaultBundleValue("nothing_selected");
	public static final String NO_TAXON_ASSOCIATED = BundleHelper.getDefaultBundleValue("no_taxon_associated");
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private Option[] taxonOptions;
    private Option[] groupOptions;
    private Long selectedTaxon;
    private Long selectedGroup;
    
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
    
    private ImageComponent image1 = new ImageComponent();
    
    public ImageComponent getImage1() {
        return image1;
    }
    
    public void setImage1(ImageComponent ic) {
        this.image1 = ic;
    }
    
    private Label lb_title1 = new Label();
    
    public Label getLb_title1() {
        return lb_title1;
    }
    
    public void setLb_title1(Label l) {
        this.lb_title1 = l;
    }
    
    private HtmlMessages messageList1 = new HtmlMessages();
    
    public HtmlMessages getMessageList1() {
        return messageList1;
    }
    
    public void setMessageList1(HtmlMessages hm) {
        this.messageList1 = hm;
    }
    
    private Listbox lb_taxon = new Listbox();
    
    public Listbox getLb_taxon() {
        return lb_taxon;
    }
    
    public void setLb_taxon(Listbox l) {
        this.lb_taxon = l;
    }
    
    private Listbox lb_group = new Listbox();
    
    public Listbox getLb_group() {
        return lb_group;
    }
    
    public void setLb_group(Listbox l) {
        this.lb_group = l;
    }
    
    private StaticText staticText1 = new StaticText();
    
    public StaticText getStaticText1() {
        return staticText1;
    }
    
    public void setStaticText1(StaticText st) {
        this.staticText1 = st;
    }
    
    private StaticText staticText2 = new StaticText();
    
    public StaticText getStaticText2() {
        return staticText2;
    }
    
    public void setStaticText2(StaticText st) {
        this.staticText2 = st;
    }
    
    private Button btn_continue = new Button();
    
    public Button getBtn_continue() {
        return btn_continue;
    }
    
    public void setBtn_continue(Button b) {
        this.btn_continue = b;
    }
    
    // </editor-fold>
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public collectionSelect() {
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
            log("Module collectionSelect Initialization Failure", e);
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
        this.taxonOptions = this.lookupSelectionListManagerBean2().getUserTaxonList(this.getSessionManager().getUser().getId());
        this.groupOptions = this.lookupSelectionListManagerBean2().getNomenclaturalGroupList(this.getSessionManager().getUser().getId());
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
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
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
    protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
        return (ProfileSessionBean)getBean("admin$profile$ProfileSessionBean");
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
    protected AudienceSessionBean getaudience$AudienceSessionBean() {
        return (AudienceSessionBean)getBean("audience$AudienceSessionBean");
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
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean)getBean("AraRequestBean");
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
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
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
    protected GroupSessionBean getgroup$GroupSessionBean() {
        return (GroupSessionBean)getBean("group$GroupSessionBean");
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
    protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (SpeciesSessionBean)getBean("species$SpeciesSessionBean");
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected UserSessionBean getuser$UserSessionBean() {
        return (UserSessionBean)getBean("user$UserSessionBean");
    }
    
    public Option[] getTaxonOptions() {
        return taxonOptions;
    }
    
    public void setTaxonOptions(Option[] taxonOptions) {
        this.taxonOptions = taxonOptions;
    }
    
    public Option[] getGroupOptions() {
        return groupOptions;
    }
    
    public void setGroupOptions(Option[] groupOptions) {
        this.groupOptions = groupOptions;
    }
    
    public Long getSelectedTaxon() {
        return selectedTaxon;
    }
    
    public void setSelectedTaxon(Long selectedTaxon) {
        this.selectedTaxon = selectedTaxon;
    }
    
    public Long getSelectedGroup() {
        return selectedGroup;
    }
    
    public void setSelectedGroup(Long selectedGroup) {
        this.selectedGroup = selectedGroup;
    }
    
    public void lb_group_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code
        
    }
    
    private SelectionListManagerRemote lookupSelectionListManagerBean2() {
        try {
            Context c = new InitialContext();
            return (SelectionListManagerRemote) c.lookup("SelectionListManagerBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SelectionListBean getutil$SelectionListBean() {
        return (SelectionListBean)getBean("util$SelectionListBean");
    }
    
    public void lb_taxon_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code
        
    }
    
    public String btn_continue_action() {
        Long taxonId;
        Long groupId;
        
        if (validate()) {
            taxonId = this.getSelectedTaxon();
            groupId = this.getSelectedGroup();
            if (taxonId != null) {
                if (taxonId != -1L) {
                    this.getSessionManager().setCurrentTaxon(this.getutil$SelectionListBean().getTaxon(taxonId));
                    this.getSessionManager().setCollection(this.getutil$SelectionListBean().getCollectionByTaxon(taxonId));
					this.getSessionManager().setCurrentNomenclaturalGroup(null);
                    return "accessGranted";
                }
            }
            if (groupId != null) {
                if (groupId != -1L) {
                    if (this.getutil$SelectionListBean().getNomenclaturalGroupById(groupId).getFirstTaxon() != null) {
                        this.getSessionManager().setCurrentTaxon(this.getutil$SelectionListBean().getNomenclaturalGroupById(groupId).getFirstTaxon());
                        this.getSessionManager().setCollection(this.getutil$SelectionListBean().getCollectionByNomenclaturalGroup(groupId));
						this.getSessionManager().setCurrentNomenclaturalGroup(this.getutil$SelectionListBean().getNomenclaturalGroupById(groupId));
                        return "accessGranted";
                    } else {
                        this.getutil$MessageBean().addErrorMessage(NO_TAXON_ASSOCIATED);
                        return null;
                    }
                }
            }
            return null;
        } else {
            return null;
        }
    }
    
    private boolean validate() {
        Long taxonId;
        Long groupId;
        
        taxonId = (Long)this.lb_taxon.getSelected();
        groupId = (Long)this.lb_group.getSelected();
        
        if (taxonId == null && groupId == null) {
            this.getutil$MessageBean().addErrorMessage(NOTHING_SELECTED);
            return false;
        }
        return true;
    }
    
    private CollectionRemote lookupCollectionBean() {
        try {
            javax.naming.Context c = new javax.naming.InitialContext();
            return (org.inbio.ara.facade.collection.CollectionRemote) c.lookup("CollectionBean");
        } catch(javax.naming.NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
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
    protected GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean)getBean("gathering$GatheringDetailSessionBean");
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean)getBean("gathering$SpecimenGenerationSessionBean");
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

