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
package org.inbio.ara.web.admin.person;

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
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.facade.util.SearchManagerRemote;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.AraRequestBean;
import org.inbio.ara.web.gathering.GatheringDetailSessionBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.gathering.SpecimenGenerationSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.NIUS.SpeciesTabular;
import org.inbio.ara.web.StringUtils;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import java.util.Hashtable;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.web.util.BundleHelper;
import org.inbio.ara.web.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class searchPerson extends AbstractPageBean {
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

    private Label label3 = new Label();

    public Label getLabel3() {
        return label3;
    }

    public void setLabel3(Label l) {
        this.label3 = l;
    }

    private Label label4 = new Label();

    public Label getLabel4() {
        return label4;
    }

    public void setLabel4(Label l) {
        this.label4 = l;
    }

    private Label label5 = new Label();

    public Label getLabel5() {
        return label5;
    }

    public void setLabel5(Label l) {
        this.label5 = l;
    }

    private Label label8 = new Label();

    public Label getLabel8() {
        return label8;
    }

    public void setLabel8(Label l) {
        this.label8 = l;
    }

    private TextField personIdTF = new TextField();

    public TextField getPersonIdTF() {
        return personIdTF;
    }

    public void setPersonIdTF(TextField tf) {
        this.personIdTF = tf;
    }

    private TextField firstNameTF = new TextField();

    public TextField getFirstNameTF() {
        return firstNameTF;
    }

    public void setFirstNameTF(TextField tf) {
        this.firstNameTF = tf;
    }

    private TextField lastNameTF = new TextField();

    public TextField getLastNameTF() {
        return lastNameTF;
    }

    public void setLastNameTF(TextField tf) {
        this.lastNameTF = tf;
    }

    private TextField initialsTF = new TextField();

    public TextField getInitialsTF() {
        return initialsTF;
    }

    public void setInitialsTF(TextField tf) {
        this.initialsTF = tf;
    }

    private TextField occupationTF = new TextField();

    public TextField getOccupationTF() {
        return occupationTF;
    }

    public void setOccupationTF(TextField tf) {
        this.occupationTF = tf;
    }

    private Button searchButton = new Button();

    public Button getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(Button b) {
        this.searchButton = b;
    }

    private TextField secondLastNameTF = new TextField();

    public TextField getSecondLastNameTF() {
        return secondLastNameTF;
    }

    public void setSecondLastNameTF(TextField tf) {
        this.secondLastNameTF = tf;
    }

    private Label label9 = new Label();

    public Label getLabel9() {
        return label9;
    }

    public void setLabel9(Label l) {
        this.label9 = l;
    }

    private Label label10 = new Label();

    public Label getLabel10() {
        return label10;
    }

    public void setLabel10(Label l) {
        this.label10 = l;
    }

    private Label label11 = new Label();

    public Label getLabel11() {
        return label11;
    }

    public void setLabel11(Label l) {
        this.label11 = l;
    }

    private Label label12 = new Label();

    public Label getLabel12() {
        return label12;
    }

    public void setLabel12(Label l) {
        this.label12 = l;
    }

    private TextField cityTF = new TextField();

    public TextField getCityTF() {
        return cityTF;
    }

    public void setCityTF(TextField tf) {
        this.cityTF = tf;
    }

    private TextField stateNameTF = new TextField();

    public TextField getStateNameTF() {
        return stateNameTF;
    }

    public void setStateNameTF(TextField tf) {
        this.stateNameTF = tf;
    }

    private TextField countryTF = new TextField();

    public TextField getCountryTF() {
        return countryTF;
    }

    public void setCountryTF(TextField tf) {
        this.countryTF = tf;
    }

    private PanelLayout layoutPanel1 = new PanelLayout();

    public PanelLayout getLayoutPanel1() {
        return layoutPanel1;
    }

    public void setLayoutPanel1(PanelLayout pl) {
        this.layoutPanel1 = pl;
    }

    private PageAlert searchAlert = new PageAlert();

    public PageAlert getSearchAlert() {
        return searchAlert;
    }

    public void setSearchAlert(PageAlert pa) {
        this.searchAlert = pa;
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
    public searchPerson() {
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
            log("Modification searchPerson initialization Failure", e);
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
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
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
    protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (SpeciesSessionBean)getBean("species$SpeciesSessionBean");
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
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean)getBean("AraRequestBean");
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
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
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
        if(getPersonIdTF().getText() != null) {
            searchCriteria.put("table.id = ",
                        getPersonIdTF().getText().toString());
        }
        if(getFirstNameTF().getText() != null) {
            searchCriteria.put("lower(table.firstName) like ", 
            "'%" + getFirstNameTF().getText().toString().toLowerCase() + "%'");
        }
        if(getLastNameTF().getText() != null) {
            searchCriteria.put("lower(table.lastName) like ",
            "'%" + getLastNameTF().getText().toString().toLowerCase() + "%'");
        }
        if(getSecondLastNameTF().getText() != null) {
            searchCriteria.put("lower(table.secondLastName) like ", 
            "'%" + getSecondLastNameTF().getText().toString().toLowerCase() + "%'");
        }
        if(getInitialsTF().getText() != null) {
            searchCriteria.put("lower(table.initials) like ", 
            "'%" + getInitialsTF().getText().toString().toLowerCase() + "%'");
        }
        if(getOccupationTF().getText() != null) {
            searchCriteria.put("lower(table.occupation) like ",
            "'%" + getOccupationTF().getText().toString().toLowerCase() + "%'");
        }
        if(getCityTF().getText() != null) {
            searchCriteria.put("lower(table.city) like ",
            "'%" + getCityTF().getText().toString().toLowerCase() + "%'");
        }
        if(getStateNameTF().getText() != null) {
            searchCriteria.put("lower(table.stateName) like ", 
            "'%" + getStateNameTF().getText().toString().toLowerCase() + "%'");
        }
        if(getCountryTF().getText() != null) {
            searchCriteria.put("lower(table.country) like ",
            "'%" + getCountryTF().getText().toString().toLowerCase() + "%'");
        }
        SearchManagerRemote smr = getadmin$person$PersonSessionBean().getSearchManager();
        List resultSet = smr.makeQuery(Person.class, searchCriteria);
        if (resultSet != null) {
            getadmin$person$PersonSessionBean().setIsFiltered(true);
            getadmin$person$PersonSessionBean().getPersonDataProvider().clearObjectList();
            getadmin$person$PersonSessionBean().getPersonDataProvider().setList(resultSet);
            return "case1";
        }
        return null;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean)getBean("references$ReferenceSessionBean");
    }

    private boolean isValidInput() {
        boolean isValid = true;
        String message = "";
        
        if(getPersonIdTF().getText() != null) {
            String id = getPersonIdTF().getText().toString();
            if (!StringUtils.isNumeric(id)){
                message += BundleHelper.getDefaultBundleValue("id_error");
                isValid = false;
            }
        }
        if(getFirstNameTF().getText() != null) {
            String first = getFirstNameTF().getText().toString();
            if (!first.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ -]*")) {
                message += BundleHelper.getDefaultBundleValue("first_name_error");
                isValid = false;
            }
        }
        if(getLastNameTF().getText() != null) {
            String last = getLastNameTF().getText().toString();
            if (!last.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ -]*")) {
                message += BundleHelper.getDefaultBundleValue("last_name_error");
                isValid = false;
            }
        }
        if(getSecondLastNameTF().getText() != null) {
            String second = getSecondLastNameTF().getText().toString();
            if (!second.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ -]*")) {
                message += BundleHelper.getDefaultBundleValue("second_name_error");
                isValid = false;
            }
        }
        if(getInitialsTF().getText() != null) {
            String initials = getInitialsTF().getText().toString();
            if (!initials.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ. ]*")) {
                message += BundleHelper.getDefaultBundleValue("initials_error");
                isValid = false;
            }
        }
        if(getOccupationTF().getText() != null) {
            String occupation = getOccupationTF().getText().toString();
            if (!occupation.matches("[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ -]*")) {
                message += BundleHelper.getDefaultBundleValue("occupation_error");
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
        if(getStateNameTF().getText() != null) {
            String state = getStateNameTF().getText().toString();
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

    public String cancelButton_action() {
        return "cancel";
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.SessionBean1 getSessionBean1() {
        return (org.inbio.ara.web.SessionBean1)getBean("SessionBean1");
    }

    public String spanishLink_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale l = new Locale("ES");
        context.getViewRoot().setLocale(l);
        return null;
    }

    public String englishLink_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(Locale.ENGLISH);
        return null;
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
    protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
        return (GatheringSessionBeanV2)getBean("gathering$GatheringSessionBeanV2");
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
    protected org.inbio.ara.web.specimen.SpecimenSessionBean getspecimen$SpecimenSessionBean() {
        return (org.inbio.ara.web.specimen.SpecimenSessionBean)getBean("specimen$SpecimenSessionBean");
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

