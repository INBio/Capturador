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
 * EditStages.java
 *
 * Created on 27 de marzo de 2008, 03:44 PM
 * Copyright herson
 */
package org.inbio.ara.web.stage;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.AddRemove;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageComponent;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Listbox;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.DefaultOptionsList;
import com.sun.webui.jsf.model.MultipleSelectOptionsList;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlMessages;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import org.inbio.ara.persistence.person.Profile;
import org.inbio.ara.persistence.species.SpeciesRecordStageProfile;
import org.inbio.ara.persistence.species.StageTransitionDigraph;
import org.inbio.ara.persistence.species.StageTransitionDigraphPK;
import org.inbio.ara.persistence.species.TaxonDescriptionStage;
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
import org.inbio.ara.web.gathering.GatheringDetailSessionBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.gathering.SpecimenGenerationSessionBean;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.identification.IdentificationSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.site.SiteSessionBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
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
public class EditStages extends AbstractPageBean {
	
	public static final String CREATE_RECORD_FAILED = BundleHelper.getDefaultBundleValue("create_record_failed");
	public static final String DELETE = BundleHelper.getDefaultBundleValue("delete");
	public static final String EDIT = BundleHelper.getDefaultBundleValue("edit");
	public static final String FIELD_DESCRIPTION_ERROR = BundleHelper.getDefaultBundleValue("field_description_error");
	public static final String FIELD_NAME_ERROR = BundleHelper.getDefaultBundleValue("field_name_error");
	public static final String INVALID_NAME = BundleHelper.getDefaultBundleValue("invalid_name");
	public static final String SESSION_INIT_REQUIRE = BundleHelper.getDefaultBundleValue("session_init_require");
	public static final String UPDATE_REGISTER_FAILED = BundleHelper.getDefaultBundleValue("update_register_failed");
	public static final String UPDATE_STAGE_FAILED = BundleHelper.getDefaultBundleValue("update_stage_failed");
	public static final String UPDATE_STAGE_SUCCESS = BundleHelper.getDefaultBundleValue("update_stage_success");
	public static final String VIEW = BundleHelper.getDefaultBundleValue("view");
	private static final String UPDATE_RECORD_AUTH_OPTIONS = BundleHelper.getDefaultBundleValue("update_record_auth_options");
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    private Object from;
    
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

    private Label main_label = new Label();

    public Label getMain_label() {
        return main_label;
    }

    public void setMain_label(Label l) {
        this.main_label = l;
    }

    private TabSet tabSet1 = new TabSet();

    public TabSet getTabSet1() {
        return tabSet1;
    }

    public void setTabSet1(TabSet ts) {
        this.tabSet1 = ts;
    }

    private Tab tab1 = new Tab();

    public Tab getTab1() {
        return tab1;
    }

    public void setTab1(Tab t) {
        this.tab1 = t;
    }

    private HtmlPanelGrid digraph_gridPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getDigraph_gridPanel() {
        return digraph_gridPanel;
    }

    public void setDigraph_gridPanel(HtmlPanelGrid hpg) {
        this.digraph_gridPanel = hpg;
    }

    private Button btn_cancel = new Button();

    public Button getBtn_cancel() {
        return btn_cancel;
    }

    public void setBtn_cancel(Button b) {
        this.btn_cancel = b;
    }

    private Button btn_save = new Button();

    public Button getBtn_save() {
        return btn_save;
    }

    public void setBtn_save(Button b) {
        this.btn_save = b;
    }

    private SingleSelectOptionsList selected_stageDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getSelected_stageDefaultOptions() {
        return selected_stageDefaultOptions;
    }

    public void setSelected_stageDefaultOptions(SingleSelectOptionsList ssol) {
        this.selected_stageDefaultOptions = ssol;
    }

    private DefaultOptionsList list_toDefaultOptions = new DefaultOptionsList();

    public DefaultOptionsList getList_toDefaultOptions() {
        return list_toDefaultOptions;
    }

    public void setList_toDefaultOptions(DefaultOptionsList dol) {
        this.list_toDefaultOptions = dol;
    }

    private Tab tab2 = new Tab();

    public Tab getTab2() {
        return tab2;
    }

    public void setTab2(Tab t) {
        this.tab2 = t;
    }

    private HtmlPanelGrid gridPanel1 = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanel1() {
        return gridPanel1;
    }

    public void setGridPanel1(HtmlPanelGrid hpg) {
        this.gridPanel1 = hpg;
    }

    private HtmlPanelGrid auth_gridPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getAuth_gridPanel() {
        return auth_gridPanel;
    }

    public void setAuth_gridPanel(HtmlPanelGrid hpg) {
        this.auth_gridPanel = hpg;
    }

    private HtmlPanelGrid stage_gridPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getStage_gridPanel() {
        return stage_gridPanel;
    }

    public void setStage_gridPanel(HtmlPanelGrid hpg) {
        this.stage_gridPanel = hpg;
    }

    private Label label_stage = new Label();

    public Label getLabel_stage() {
        return label_stage;
    }

    public void setLabel_stage(Label l) {
        this.label_stage = l;
    }

    private SingleSelectOptionsList profileDropDownDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getProfileDropDownDefaultOptions() {
        return profileDropDownDefaultOptions;
    }

    public void setProfileDropDownDefaultOptions(SingleSelectOptionsList ssol) {
        this.profileDropDownDefaultOptions = ssol;
    }

    private HtmlPanelGrid profile_gridPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getProfile_gridPanel() {
        return profile_gridPanel;
    }

    public void setProfile_gridPanel(HtmlPanelGrid hpg) {
        this.profile_gridPanel = hpg;
    }

    private Label label_profile = new Label();

    public Label getLabel_profile() {
        return label_profile;
    }

    public void setLabel_profile(Label l) {
        this.label_profile = l;
    }

    private DropDown profileDropDown = new DropDown();

    public DropDown getProfileDropDown() {
        return profileDropDown;
    }

    public void setProfileDropDown(DropDown dd) {
        this.profileDropDown = dd;
    }

    private MultipleSelectOptionsList auth_listDefaultOptions = new MultipleSelectOptionsList();

    public MultipleSelectOptionsList getAuth_listDefaultOptions() {
        return auth_listDefaultOptions;
    }

    public void setAuth_listDefaultOptions(MultipleSelectOptionsList msol) {
        this.auth_listDefaultOptions = msol;
    }

    private StaticText staticText3 = new StaticText();

    public StaticText getStaticText3() {
        return staticText3;
    }

    public void setStaticText3(StaticText st) {
        this.staticText3 = st;
    }

    private StaticText staticText4 = new StaticText();

    public StaticText getStaticText4() {
        return staticText4;
    }

    public void setStaticText4(StaticText st) {
        this.staticText4 = st;
    }

    private HtmlPanelGrid buttons_gridPanel = new HtmlPanelGrid();

    public HtmlPanelGrid getButtons_gridPanel() {
        return buttons_gridPanel;
    }

    public void setButtons_gridPanel(HtmlPanelGrid hpg) {
        this.buttons_gridPanel = hpg;
    }

    private Button btn_cancel1 = new Button();

    public Button getBtn_cancel1() {
        return btn_cancel1;
    }

    public void setBtn_cancel1(Button b) {
        this.btn_cancel1 = b;
    }

    private Button btn_guardar = new Button();

    public Button getBtn_guardar() {
        return btn_guardar;
    }

    public void setBtn_guardar(Button b) {
        this.btn_guardar = b;
    }
    /*
    private long[] selectedFrom;

    public long[] getSelectedFrom() {
        return selectedFrom;
    }

    public void setSelectedFrom(long[] selectedFrom) {
        this.selectedFrom = selectedFrom;
    }*/
    
    private long[] selectedTo;

    public long[] getSelectedTo() {
        return selectedTo;
    }

    public void setSelectedTo(long[] selectedTo) {
        this.selectedTo = selectedTo;
    }    
    
    private long[] authSelections;

    public long[] getAuthSelections() {
        return authSelections;
    }

    public void setAuthSelections(long[] authSelections) {
        this.authSelections = authSelections;
    }

    private Listbox auth_listbox = new Listbox();

    public Listbox getAuth_listbox() {
        return auth_listbox;
    }

    public void setAuth_listbox(Listbox l) {
        this.auth_listbox = l;
    }

    private Tab tab3 = new Tab();

    public Tab getTab3() {
        return tab3;
    }

    public void setTab3(Tab t) {
        this.tab3 = t;
    }

    private PanelLayout layoutPanel2 = new PanelLayout();

    public PanelLayout getLayoutPanel2() {
        return layoutPanel2;
    }

    public void setLayoutPanel2(PanelLayout pl) {
        this.layoutPanel2 = pl;
    }

    private Label label3 = new Label();

    public Label getLabel3() {
        return label3;
    }

    public void setLabel3(Label l) {
        this.label3 = l;
    }

    private TextField name_field = new TextField();

    public TextField getName_field() {
        return name_field;
    }

    public void setName_field(TextField tf) {
        this.name_field = tf;
    }

    private Label label4 = new Label();

    public Label getLabel4() {
        return label4;
    }

    public void setLabel4(Label l) {
        this.label4 = l;
    }

    private TextArea description_area = new TextArea();

    public TextArea getDescription_area() {
        return description_area;
    }

    public void setDescription_area(TextArea ta) {
        this.description_area = ta;
    }

    private Button btn_edit1 = new Button();

    public Button getBtn_edit1() {
        return btn_edit1;
    }

    public void setBtn_edit1(Button b) {
        this.btn_edit1 = b;
    }

    private Label selectedStageName = new Label();

    public Label getSelectedStageName() {
        return selectedStageName;
    }

    public void setSelectedStageName(Label l) {
        this.selectedStageName = l;
    }
    
    private String stageName;

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
    
    private String stageDescription;
    
    public String getStageDescription() {
        return stageDescription;
    }

    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }

    private AddRemove addRemoveList1 = new AddRemove();

    public AddRemove getAddRemoveList1() {
        return addRemoveList1;
    }

    public void setAddRemoveList1(AddRemove ar) {
        this.addRemoveList1 = ar;
    }

    private MultipleSelectOptionsList addRemoveList1DefaultOptions = new MultipleSelectOptionsList();

    public MultipleSelectOptionsList getAddRemoveList1DefaultOptions() {
        return addRemoveList1DefaultOptions;
    }

    public void setAddRemoveList1DefaultOptions(MultipleSelectOptionsList msol) {
        this.addRemoveList1DefaultOptions = msol;
    }

    private Label label1 = new Label();

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label l) {
        this.label1 = l;
    }

    private Button btn_cancel3 = new Button();

    public Button getBtn_cancel3() {
        return btn_cancel3;
    }

    public void setBtn_cancel3(Button b) {
        this.btn_cancel3 = b;
    }

    private HtmlMessages messageList1 = new HtmlMessages();

    public HtmlMessages getMessageList1() {
        return messageList1;
    }

    public void setMessageList1(HtmlMessages hm) {
        this.messageList1 = hm;
    }

    private Hyperlink englishLink1 = new Hyperlink();

    public Hyperlink getEnglishLink1() {
        return englishLink1;
    }

    public void setEnglishLink1(Hyperlink h) {
        this.englishLink1 = h;
    }

    private Hyperlink spanishLink1 = new Hyperlink();

    public Hyperlink getSpanishLink1() {
        return spanishLink1;
    }

    public void setSpanishLink1(Hyperlink h) {
        this.spanishLink1 = h;
    }
    
    
    // </editor-fold>
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditStages() {
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
            log("Module editStages Initialization Failure", e);
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
        //Traer los datos de la pestanya de edicion
        this.setStageName(getAraRequestBean().
                getTaxonDescriptionStageBean().find(getspecies$SpeciesSessionBean().
                                          getSelectedStage()).getName());
        this.setStageDescription(getAraRequestBean().
                getTaxonDescriptionStageBean().find(getspecies$SpeciesSessionBean().
                                          getSelectedStage()).getDescription());

        //Traer la lista de Estados para editar el digrafo
        List<TaxonDescriptionStage> stagesList = 
                getAraRequestBean().getTaxonDescriptionStageBean().findAll();
        if(stagesList != null) {
            int counter = 0;
            Option stagesOptions[] = new Option[stagesList.size()];
            for(TaxonDescriptionStage tds : stagesList){
                stagesOptions[counter] = new Option(tds.getId(), tds.getName());
                counter++;
            }
            selected_stageDefaultOptions.setOptions(stagesOptions);
            //selected_stageDefaultOptions.setSelectedValue(getAraRequestBean().getSelectedStage());
        }
        updateFromTo();
        //En la pestanya de perfiles
        // traer los perfiles
        List<Profile> profilesList = 
                    this.getAraApplicationBean().getProfileRemote().findAll();
        if(profilesList != null){
            int counter = 0;
            Option profilesOptions[] = new Option[profilesList.size()];
            for (Profile profile : profilesList) {
                profilesOptions[counter] = new Option(profile.getId(), profile.getName());
                counter++;
            }
            this.profileDropDownDefaultOptions.setOptions(profilesOptions);
            if(getAraRequestBean().getSelectedProfile() == 0) {
                getAraRequestBean().setSelectedProfile(profilesList.get(0).getId());
            }
            //profileDropDownDefaultOptions.setSelectedValue(getAraRequestBean().getSelectedProfile());
        }
        // llenar los campos de autorizacion
        createAuthOptions();
    }
    
    private void createAuthOptions(){
        Option authOptions[] = new Option[3];
        authOptions[0] = new Option(0L, EDIT);
        authOptions[1] = new Option(1L, DELETE);
        authOptions[2] = new Option(2L, VIEW);
        this.auth_listDefaultOptions.setOptions(authOptions);
        setSelectedAuthOptions();
    }
    
    private void setSelectedAuthOptions(){
        SpeciesRecordStageProfile srsp = getAraRequestBean().
                            getSpeciesRecordStageProfileBean().
                            find(getspecies$SpeciesSessionBean().getSelectedStage(),
                                    getAraRequestBean().getSelectedProfile());
        //Si no es nulo preselecciona las opciones editable, borrable, visible
        if (srsp != null) {
            System.out.println("srsp != null");
            long flags[] = new long[srsp.getEditable()+srsp.getErasable()+srsp.getVisible()];
            int contador = 0;
            if (srsp.getEditable() == 1) flags[contador++] = 0L;
            if (srsp.getErasable() == 1) flags[contador++] = 1L;
            if (srsp.getVisible() == 1) flags[contador++] = 2L;
            this.setAuthSelections(flags);
        } //si es nulo deja las 3 posibles opciones en blanco
        else {
            System.out.println("srsp == null");
            this.setAuthSelections(null);
        }
    }
    
    private void updateFromTo(){
        Option stageOptions[] = selected_stageDefaultOptions.getOptions();
        Option fromOptions[] = new Option[stageOptions.length-1];
        Option toOptions[] = new Option[stageOptions.length-1];
        for (int i = 0, j = 0; i < stageOptions.length; j++, i++) {
            if(((Long)stageOptions[i].getValue()) == getspecies$SpeciesSessionBean().getSelectedStage()){
                j--;
            } else {
                fromOptions[j] = stageOptions[i];
                toOptions[j] = stageOptions[i];
            }
        }
        //list_fromDefaultOptions.setOptions(fromOptions);
        list_toDefaultOptions.setOptions(toOptions);        
        //setFromOptions();
        setToOptions();        
    }
  /*  
    private void setFromOptions(){
        //Seleccionar las opciones actuales
        List selectionsList;
        long[] selections;
        selectionsList = getAraRequestBean().getStageTransitionDigraphBean().
                getFromList(getAraRequestBean().getSelectedStage());
        selections = new long[selectionsList.size()];
        for (int i = 0; i < selections.length; i++) {
            selections[i] = ((StageTransitionDigraph)selectionsList.get(i)).getStageTransitionDigraphPK().getSpeciesRecordStageFromId();
        }
        this.setSelectedFrom(selections);
    }
    */
    private void setToOptions(){
        //Seleccionar las opciones actuales
        List selectionsList;
        long[] selections;
        selectionsList = getAraRequestBean().getStageTransitionDigraphBean().
                getToList(getspecies$SpeciesSessionBean().getSelectedStage());
        selections = new long[selectionsList.size()];
        for (int i = 0; i < selections.length; i++) {
            selections[i] = ((StageTransitionDigraph)selectionsList.get(i)).getStageTransitionDigraphPK().getSpeciesRecordStageToId();
        }
        this.setSelectedTo(selections);
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
    protected PersonSessionBean getadmin$person$PersonSessionBean() {
        return (PersonSessionBean)getBean("admin$person$PersonSessionBean");
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
    protected AudienceSessionBean getaudience$AudienceSessionBean() {
        return (AudienceSessionBean)getBean("audience$AudienceSessionBean");
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
    protected UserSessionBean getuser$UserSessionBean() {
        return (UserSessionBean)getBean("user$UserSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean)getBean("references$ReferenceSessionBean");
    }

    public String btn_digraphSave_action() {
        ArrayList<StageTransitionDigraph> list = new ArrayList<StageTransitionDigraph>();
        if(selectedTo != null){
            for (int i = 0; i < selectedTo.length; i++) {
                StageTransitionDigraph newRelation = new StageTransitionDigraph();
                StageTransitionDigraphPK pk = new StageTransitionDigraphPK();
                
                pk.setSpeciesRecordStageFromId(getspecies$SpeciesSessionBean().getSelectedStage());
                pk.setSpeciesRecordStageToId(selectedTo[i]);
                newRelation.setCreatedBy(getSessionManager().getUser().getUserName());
                newRelation.setLastModificationBy(getSessionManager().getUser().getUserName());
                newRelation.setStageTransitionDigraphPK(pk);
                list.add(newRelation);
            }
        }
        this.getAraRequestBean().getStageTransitionDigraphBean().
                            save(list, getspecies$SpeciesSessionBean().getSelectedStage());
        return null;
    }

    public String btn_cancel_action() {
        return "cancel";
    }

    public String btn_authSave_action() {
        long stageId = this.getspecies$SpeciesSessionBean().getSelectedStage();
        long profileId = this.getAraRequestBean().getSelectedProfile();

		SpeciesRecordStageProfile srsp = getAraRequestBean().getSpeciesRecordStageProfileBean().find(stageId, profileId);

		if (srsp == null) {

			if(this.getAuthSelections() == null || this.getAuthSelections().length == 0){
				this.getutil$MessageBean().addErrorMessage(UPDATE_RECORD_AUTH_OPTIONS);
				return null;
			}

            SpeciesRecordStageProfile srspNew = new SpeciesRecordStageProfile(profileId, stageId);
            setBasicProperties(srspNew);
            srspNew.setCreatedBy(getSessionManager().getUser().getUserName());

			if(!getAraRequestBean().getSpeciesRecordStageProfileBean().create(srspNew)){
				this.getutil$MessageBean().addErrorMessage(CREATE_RECORD_FAILED);
                System.out.println(CREATE_RECORD_FAILED);
            }else{
				this.getutil$MessageBean().addSuccessMessage(UPDATE_STAGE_SUCCESS);
			}
        } else {
            if(this.getAuthSelections().length == 0){
                getAraRequestBean().getSpeciesRecordStageProfileBean().remove(srsp);
            } else {
                setBasicProperties(srsp);
                if(!getAraRequestBean().getSpeciesRecordStageProfileBean().update(srsp)){
					this.getutil$MessageBean().addErrorMessage(UPDATE_REGISTER_FAILED);
                    System.out.println(	UPDATE_REGISTER_FAILED);
                }else{
					this.getutil$MessageBean().addSuccessMessage(UPDATE_STAGE_SUCCESS);
				}
            }
        }
        return null;
    }
    
    private void setBasicProperties(SpeciesRecordStageProfile srsp){
        long[] authLevel = this.getAuthSelections();
        
        srsp.setLastModificationBy(getSessionManager().getUser().getUserName());
        srsp.setEditable(0);
        srsp.setErasable(0);
        srsp.setVisible(0);
        for (int i = 0; i < authLevel.length; i++) {
            if (authLevel[i] == 0) srsp.setEditable(1);
            if (authLevel[i] == 1) srsp.setErasable(1);
            if (authLevel[i] == 2) srsp.setVisible(1);
        }
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (SpeciesSessionBean)getBean("species$SpeciesSessionBean");
    }

    public String btn_edit_action() {
        if(!isValidInput())
            return null;
        TaxonDescriptionStage TDStage = getAraRequestBean().
                getTaxonDescriptionStageBean().find(getspecies$SpeciesSessionBean().
                                          getSelectedStage());
        TDStage.setName(getName_field().getText().toString());
        TDStage.setDescription(getDescription_area().getText().toString());
        try {
            TDStage.setLastModificationBy(getSessionManager().getUser().getUserName());
        } catch (Exception e) {
            this.getutil$MessageBean().addErrorMessage(SESSION_INIT_REQUIRE);
            System.err.println(SESSION_INIT_REQUIRE + e.toString());
        }
        if (getAraRequestBean().getTaxonDescriptionStageBean().update(TDStage)){
            this.getutil$MessageBean().addSuccessMessage(UPDATE_STAGE_SUCCESS);
            getAraApplicationBean().getStagesDP().refreshDataList();
        } else {
            this.getutil$MessageBean().addErrorMessage(UPDATE_STAGE_FAILED);
            System.out.println(getAraRequestBean().getTaxonDescriptionStageBean().getMessage());
        }
        
        return null;
    }

    private boolean isValidInput() {
        boolean isValid = true;

        if(getName_field().getText() != null) {
            if(getName_field().getText().toString().trim() == ""){
                this.getutil$MessageBean().addErrorMessage(INVALID_NAME);
                isValid = false;
            }
            String name = getName_field().getText().toString();
            if (!name.matches("[a-zA-Záéíóú�?É�?ÓÚñÑ0-9 -]*")) {
                this.getutil$MessageBean().addErrorMessage(FIELD_NAME_ERROR);
                isValid = false;
            }
        } else {
            isValid = false;
            this.getutil$MessageBean().addErrorMessage(INVALID_NAME);
        }
        if(getDescription_area().getText() != null) {
            String desc = getDescription_area().getText().toString();
            if (!desc.matches("[a-zA-Záéíóú�?É�?ÓÚñÑ0-9 -]*")) {
                this.getutil$MessageBean().addErrorMessage(FIELD_DESCRIPTION_ERROR);
                isValid = false;
            }
        }
        return isValid;
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
    protected SelectionListBean getutil$SelectionListBean() {
        return (SelectionListBean)getBean("util$SelectionListBean");
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
    protected IdentificationSearchSessionBean getidentification$IdentificationSearchSessionBean() {
        return (IdentificationSearchSessionBean)getBean("identification$IdentificationSearchSessionBean");
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
    protected NomenclaturalGroupSessionBean getnomenclaturalgroup$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean)getBean("nomenclaturalgroup$NomenclaturalGroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SiteSessionBean getsite$SiteSessionBean() {
        return (SiteSessionBean)getBean("site$SiteSessionBean");
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
    protected IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (IdentificationSessionBean)getBean("identification$IdentificationSessionBean");
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

