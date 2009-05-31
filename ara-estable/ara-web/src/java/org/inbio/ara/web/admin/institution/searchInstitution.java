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
 * searchInstitution.java
 *
 * Created on 7 de febrero de 2008, 05:21 PM
 * Copyright herson
 */
package org.inbio.ara.web.admin.institution;

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
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PageAlert;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.TextField;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.facade.util.SearchManagerRemote;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.AraRequestBean;
import org.inbio.ara.web.RequestBean1;
import org.inbio.ara.web.gathering.GatheringDetailSessionBean;
import org.inbio.ara.web.gathering.SpecimenGenerationSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.NIUS.SpeciesTabular;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
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
public class searchInstitution extends AbstractPageBean {
	
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

    private ImageComponent image1 = new ImageComponent();

    public ImageComponent getImage1() {
        return image1;
    }

    public void setImage1(ImageComponent ic) {
        this.image1 = ic;
    }
    
    private ImageComponent image2 = new ImageComponent();

    public ImageComponent getImage2() {
        return image2;
    }

    public void setImage2(ImageComponent ic) {
        this.image2 = ic;
    }

    private Label label1 = new Label();

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label l) {
        this.label1 = l;
    }

    private PanelLayout layoutPanel1 = new PanelLayout();

    public PanelLayout getLayoutPanel1() {
        return layoutPanel1;
    }

    public void setLayoutPanel1(PanelLayout pl) {
        this.layoutPanel1 = pl;
    }

    private Label name_label = new Label();

    public Label getName_label() {
        return name_label;
    }

    public void setName_label(Label l) {
        this.name_label = l;
    }

    private TextField institutionNameTF = new TextField();

    public TextField getInstitutionNameTF() {
        return institutionNameTF;
    }

    public void setInstitutionNameTF(TextField tf) {
        this.institutionNameTF = tf;
    }

    private Label acronym_label = new Label();

    public Label getAcronym_label() {
        return acronym_label;
    }

    public void setAcronym_label(Label l) {
        this.acronym_label = l;
    }

    private TextField acronymTF = new TextField();

    public TextField getAcronymTF() {
        return acronymTF;
    }

    public void setAcronymTF(TextField tf) {
        this.acronymTF = tf;
    }

    private Label city_label = new Label();

    public Label getCity_label() {
        return city_label;
    }

    public void setCity_label(Label l) {
        this.city_label = l;
    }

    private TextField cityTF = new TextField();

    public TextField getCityTF() {
        return cityTF;
    }

    public void setCityTF(TextField tf) {
        this.cityTF = tf;
    }

    private Label state_province = new Label();

    public Label getState_province() {
        return state_province;
    }

    public void setState_province(Label l) {
        this.state_province = l;
    }

    private TextField stateProvinceTF = new TextField();

    public TextField getStateProvinceTF() {
        return stateProvinceTF;
    }

    public void setStateProvinceTF(TextField tf) {
        this.stateProvinceTF = tf;
    }

    private Label country = new Label();

    public Label getCountry() {
        return country;
    }

    public void setCountry(Label l) {
        this.country = l;
    }

    private TextField countryTF = new TextField();

    public TextField getCountryTF() {
        return countryTF;
    }

    public void setCountryTF(TextField tf) {
        this.countryTF = tf;
    }

    private Button searchButton = new Button();

    public Button getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(Button b) {
        this.searchButton = b;
    }

    private PageAlert searchAlert = new PageAlert();

    public PageAlert getSearchAlert() {
        return searchAlert;
    }

    public void setSearchAlert(PageAlert pa) {
        this.searchAlert = pa;
    }

    private Button cancelButton = new Button();

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button b) {
        this.cancelButton = b;
    }
    
    // </editor-fold>
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public searchInstitution() {
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
            log("Module searchInstitution initialization Failure", e);
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
    protected GroupSessionBean getgroup$GroupSessionBean() {
        return (GroupSessionBean)getBean("group$GroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpeciesTabular getNIUS$SpeciesTabular() {
        return (SpeciesTabular)getBean("NIUS$SpeciesTabular");
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
    protected UserSessionBean getuser$UserSessionBean() {
        return (UserSessionBean)getBean("user$UserSessionBean");
    }

    public String searchButton_action() {
        if (!isValidInput())
            return null;
        Hashtable searchCriteria = new Hashtable();
        if(getInstitutionNameTF().getText() != null) {
            searchCriteria.put("lower(table.name) like ", 
            "'%" + getInstitutionNameTF().getText().toString().toLowerCase() + "%'");
        }
        if(getAcronymTF().getText() != null) {
            searchCriteria.put("lower(table.acronym) like ", 
            "'%" + getAcronymTF().getText().toString().toLowerCase() + "%'");
        }
        if(getCityTF().getText() != null) {
            searchCriteria.put("lower(table.city) like ", 
            "'%" + getCityTF().getText().toString().toLowerCase() + "%'");
        }
        if(getStateProvinceTF().getText() != null) {
            searchCriteria.put("lower(table.stateProvince) like ", 
            "'%" + getStateProvinceTF().getText().toString().toLowerCase() + "%'");
        }
        if(getCountryTF().getText() != null) {
            searchCriteria.put("lower(table.country) like ", 
            "'%" + getCountryTF().getText().toString().toLowerCase() + "%'");
        }   
        SearchManagerRemote smr = getadmin$institution$InstitutionSessionBean().getSearchManager();
        List resultSet = smr.makeQuery(Institution.class, searchCriteria);
        if (resultSet != null) {
            getadmin$institution$InstitutionSessionBean().setIsFiltered(true);
            getadmin$institution$InstitutionSessionBean().getInstitutionDataProvider().clearObjectList();
            getadmin$institution$InstitutionSessionBean().getInstitutionDataProvider().setList(resultSet);
            return "case1";
        }
        return null;
    }

    private boolean isValidInput() {
        boolean isValid = true;
        String message = "";
        
        if(getInstitutionNameTF().getText() != null) {
            String institutionName = getInstitutionNameTF().getText().toString();
            if (!institutionName.matches("[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ -]*")) {
                message += BundleHelper.getDefaultBundleValue("institution_name_error");
                isValid = false;
            }
        }
        if(getAcronymTF().getText() != null) {
            String acronym = getAcronymTF().getText().toString();
            if (!acronym.matches("[0-9a-zA-Z ]*")) {
                message += BundleHelper.getDefaultBundleValue("acronym_error");
                isValid = false;
            }
        }
        if(getCityTF().getText() != null) {
            String city = getCityTF().getText().toString();
            if (!city.matches("[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ -]*")) {
                message += BundleHelper.getDefaultBundleValue("city_error");
                isValid = false;
            }
        }
        if(getStateProvinceTF().getText() != null) {
            String state = getStateProvinceTF().getText().toString();
            if (!state.matches("[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ -]*")) {
                message += BundleHelper.getDefaultBundleValue("state_error");
                isValid = false;
            }
        }
        if(getCountryTF().getText() != null) {
            String country = getCountryTF().getText().toString();
            if (!country.matches("[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ -]*")) {
                message += BundleHelper.getDefaultBundleValue("country_error");
                isValid = false;
            }
        } 
        if (!isValid) {
            searchAlert.setRendered(true);
            searchAlert.setType("error");
            searchAlert.setSummary(BundleHelper.getDefaultBundleValue("validation_error"));
            searchAlert.setDetail(message);
        }
        
        return isValid;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean)getBean("references$ReferenceSessionBean");
    }

    public String cancelButton_action() {
        return "cancel";
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
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
    protected org.inbio.ara.web.gathering.GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
        return (org.inbio.ara.web.gathering.GatheringSessionBeanV2)getBean("gathering$GatheringSessionBeanV2");
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
    protected SpecimenSessionBean getspecimen$SpecimenSessionBean() {
        return (SpecimenSessionBean)getBean("specimen$SpecimenSessionBean");
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
    protected GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean)getBean("gathering$GatheringDetailSessionBean");
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
}

