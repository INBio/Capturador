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
 * ediGathering.java
 *
 * Created on May 26, 2008, 12:49 AM
 * Copyright roaguilar
 */
package org.inbio.ara.web.gathering;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.AddRemove;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.ImageComponent;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlMessages;
import javax.faces.convert.LongConverter;
import javax.faces.event.ValueChangeEvent;
import org.inbio.ara.persistence.gathering.GatheringObservation;
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
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
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
public class editGathering extends AbstractPageBean {
	
	
	public static final String EMPTY_COLLECTORS_LIST = BundleHelper.getDefaultBundleValue("empty_collectors_list");
	public static final String EMPTY_GATHERING_FINAL_DATE = BundleHelper.getDefaultBundleValue("empty_gathering_final_date");
	public static final String EMPTY_GATHERING_INITIAL_DATE = BundleHelper.getDefaultBundleValue("empty_gathering_initial_date");
	public static final String EMPTY_GATHERING_REPONSIBLE = BundleHelper.getDefaultBundleValue("empty_gathering_reponsible");
	public static final String EMPTY_LOCATION = BundleHelper.getDefaultBundleValue("empty_location");
	public static final String INVALID_GRADIENT_VALUE = BundleHelper.getDefaultBundleValue("invalid_gradient_value");
	public static final String MAXIMUN_DEEP_INVALID_VALUE = BundleHelper.getDefaultBundleValue("maximun_deep_invalid_value");
	public static final String MAXIMUN_ELEVATION_INVALID_VALUE = BundleHelper.getDefaultBundleValue("maximun_elevation_invalid_value");
	public static final String MINIMUM = BundleHelper.getDefaultBundleValue("minimum");
	public static final String MINIMUN_DEEP_HIGHER_THAN_MAXIMUN = BundleHelper.getDefaultBundleValue("minimun_deep_higher_than_maximun");
	public static final String MINIMUN_ELEVATION_HIGHER_THAN_MAXIMUN = BundleHelper.getDefaultBundleValue("minimun_elevation_higher_than_maximun");
	public static final String MININUM_DEEP_INVALID_VALUE = BundleHelper.getDefaultBundleValue("mininum_deep_invalid_value");
	public static final String MININUM_ELEVATION_INVALID_VALUE = BundleHelper.getDefaultBundleValue("mininum_elevation_invalid_value");
	public static final String NEWER_INITIAL_DATE = BundleHelper.getDefaultBundleValue("newer_initial_date");
	public static final String NUMERIC_REQUIRED = BundleHelper.getDefaultBundleValue("numeric_required");
	
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
		t_gatheringDetail.setStyle("left: 0px; top: 48px; position: absolute; width: 100%");
        ar_Collectors.setWidth("790");
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

    private HtmlMessages messageList1 = new HtmlMessages();

    public HtmlMessages getMessageList1() {
        return messageList1;
    }

    public void setMessageList1(HtmlMessages hm) {
        this.messageList1 = hm;
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

    private DropDown dd_site = new DropDown();

    public DropDown getDd_site() {
        return dd_site;
    }

    public void setDd_site(DropDown dd) {
        this.dd_site = dd;
    }

    private Calendar cal_initialDate = new Calendar();

    public Calendar getCal_initialDate() {
        return cal_initialDate;
    }

    public void setCal_initialDate(Calendar c) {
        this.cal_initialDate = c;
    }

    private Calendar cal_finalDate = new Calendar();

    public Calendar getCal_finalDate() {
        return cal_finalDate;
    }

    public void setCal_finalDate(Calendar c) {
        this.cal_finalDate = c;
    }

    private DropDown dd_responsiblePerson = new DropDown();

    public DropDown getDd_responsiblePerson() {
        return dd_responsiblePerson;
    }

    public void setDd_responsiblePerson(DropDown dd) {
        this.dd_responsiblePerson = dd;
    }

    private Label label6 = new Label();

    public Label getLabel6() {
        return label6;
    }

    public void setLabel6(Label l) {
        this.label6 = l;
    }

    private TextField txt_minElevation = new TextField();

    public TextField getTxt_minElevation() {
        return txt_minElevation;
    }

    public void setTxt_minElevation(TextField tf) {
        this.txt_minElevation = tf;
    }

    private TextField txt_maxElevation = new TextField();

    public TextField getTxt_maxElevation() {
        return txt_maxElevation;
    }

    public void setTxt_maxElevation(TextField tf) {
        this.txt_maxElevation = tf;
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

    private Label label7 = new Label();

    public Label getLabel7() {
        return label7;
    }

    public void setLabel7(Label l) {
        this.label7 = l;
    }

    private StaticText staticText3 = new StaticText();

    public StaticText getStaticText3() {
        return staticText3;
    }

    public void setStaticText3(StaticText st) {
        this.staticText3 = st;
    }

    private TextField txt_minDepth = new TextField();

    public TextField getTxt_minDepth() {
        return txt_minDepth;
    }

    public void setTxt_minDepth(TextField tf) {
        this.txt_minDepth = tf;
    }

    private StaticText staticText4 = new StaticText();

    public StaticText getStaticText4() {
        return staticText4;
    }

    public void setStaticText4(StaticText st) {
        this.staticText4 = st;
    }

    private TextField txt_maxDept = new TextField();

    public TextField getTxt_maxDept() {
        return txt_maxDept;
    }

    public void setTxt_maxDept(TextField tf) {
        this.txt_maxDept = tf;
    }

    private Label label8 = new Label();

    public Label getLabel8() {
        return label8;
    }

    public void setLabel8(Label l) {
        this.label8 = l;
    }

    private TextField txt_Gradient = new TextField();

    public TextField getTxt_Gradient() {
        return txt_Gradient;
    }

    public void setTxt_Gradient(TextField tf) {
        this.txt_Gradient = tf;
    }

    private Label label9 = new Label();

    public Label getLabel9() {
        return label9;
    }

    public void setLabel9(Label l) {
        this.label9 = l;
    }

    private DropDown dd_Exposition = new DropDown();

    public DropDown getDd_Exposition() {
        return dd_Exposition;
    }

    public void setDd_Exposition(DropDown dd) {
        this.dd_Exposition = dd;
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

    private TextArea txt_surroundings = new TextArea();

    public TextArea getTxt_surroundings() {
        return txt_surroundings;
    }

    public void setTxt_surroundings(TextArea ta) {
        this.txt_surroundings = ta;
    }

    private TextArea txt_siteDesc = new TextArea();

    public TextArea getTxt_siteDesc() {
        return txt_siteDesc;
    }

    public void setTxt_siteDesc(TextArea ta) {
        this.txt_siteDesc = ta;
    }

    private TabSet tabSet_gathering = new TabSet();

    public TabSet getTabSet_gathering() {
        return tabSet_gathering;
    }

    public void setTabSet_gathering(TabSet ts) {
        this.tabSet_gathering = ts;
    }

    private Tab tab_Collectors = new Tab();

    public Tab getTab_Collectors() {
        return tab_Collectors;
    }

    public void setTab_Collectors(Tab t) {
        this.tab_Collectors = t;
    }

    private PanelLayout layoutPanel2 = new PanelLayout();

    public PanelLayout getLayoutPanel2() {
        return layoutPanel2;
    }

    public void setLayoutPanel2(PanelLayout pl) {
        this.layoutPanel2 = pl;
    }

    private AddRemove ar_Collectors = new AddRemove();

    public AddRemove getAr_Collectors() {
        return ar_Collectors;
    }

    public void setAr_Collectors(AddRemove ar) {
        this.ar_Collectors = ar;
    }

    private Tab tab_Proyectos = new Tab();

    public Tab getTab_Proyectos() {
        return tab_Proyectos;
    }

    public void setTab_Proyectos(Tab t) {
        this.tab_Proyectos = t;
    }

    private PanelLayout layoutPanel3 = new PanelLayout();

    public PanelLayout getLayoutPanel3() {
        return layoutPanel3;
    }

    public void setLayoutPanel3(PanelLayout pl) {
        this.layoutPanel3 = pl;
    }

    private AddRemove ar_Projects = new AddRemove();

    public AddRemove getAr_Projects() {
        return ar_Projects;
    }

    public void setAr_Projects(AddRemove ar) {
        this.ar_Projects = ar;
    }

    private Tab tab_Collections = new Tab();

    public Tab getTab_Collections() {
        return tab_Collections;
    }

    public void setTab_Collections(Tab t) {
        this.tab_Collections = t;
    }

    private PanelLayout layoutPanel4 = new PanelLayout();

    public PanelLayout getLayoutPanel4() {
        return layoutPanel4;
    }

    public void setLayoutPanel4(PanelLayout pl) {
        this.layoutPanel4 = pl;
    }

    private AddRemove ar_Collections = new AddRemove();

    public AddRemove getAr_Collections() {
        return ar_Collections;
    }

    public void setAr_Collections(AddRemove ar) {
        this.ar_Collections = ar;
    }

    private Tab tab_GatheringDetails = new Tab();

    public Tab getTab_GatheringDetails() {
        return tab_GatheringDetails;
    }

    public void setTab_GatheringDetails(Tab t) {
        this.tab_GatheringDetails = t;
    }

    private PanelLayout layoutPanel5 = new PanelLayout();

    public PanelLayout getLayoutPanel5() {
        return layoutPanel5;
    }

    public void setLayoutPanel5(PanelLayout pl) {
        this.layoutPanel5 = pl;
    }

    private StaticText staticText5 = new StaticText();

    public StaticText getStaticText5() {
        return staticText5;
    }

    public void setStaticText5(StaticText st) {
        this.staticText5 = st;
    }

    private Label label12 = new Label();

    public Label getLabel12() {
        return label12;
    }

    public void setLabel12(Label l) {
        this.label12 = l;
    }

    private StaticText st_id = new StaticText();

    public StaticText getSt_id() {
        return st_id;
    }

    public void setSt_id(StaticText st) {
        this.st_id = st;
    }

    private Table t_gatheringDetail = new Table();

    public Table getT_gatheringDetail() {
        return t_gatheringDetail;
    }

    public void setT_gatheringDetail(Table t) {
        this.t_gatheringDetail = t;
    }

    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }

    private DefaultTableDataProvider defaultTableDataProvider = new DefaultTableDataProvider();

    public DefaultTableDataProvider getDefaultTableDataProvider() {
        return defaultTableDataProvider;
    }

    public void setDefaultTableDataProvider(DefaultTableDataProvider dtdp) {
        this.defaultTableDataProvider = dtdp;
    }

    private TableColumn tableColumn1 = new TableColumn();

    public TableColumn getTableColumn1() {
        return tableColumn1;
    }

    public void setTableColumn1(TableColumn tc) {
        this.tableColumn1 = tc;
    }

    private StaticText staticText6 = new StaticText();

    public StaticText getStaticText6() {
        return staticText6;
    }

    public void setStaticText6(StaticText st) {
        this.staticText6 = st;
    }

    private TableColumn tableColumn2 = new TableColumn();

    public TableColumn getTableColumn2() {
        return tableColumn2;
    }

    public void setTableColumn2(TableColumn tc) {
        this.tableColumn2 = tc;
    }

    private StaticText staticText7 = new StaticText();

    public StaticText getStaticText7() {
        return staticText7;
    }

    public void setStaticText7(StaticText st) {
        this.staticText7 = st;
    }

    private TableColumn tableColumn3 = new TableColumn();

    public TableColumn getTableColumn3() {
        return tableColumn3;
    }

    public void setTableColumn3(TableColumn tc) {
        this.tableColumn3 = tc;
    }

    private StaticText staticText8 = new StaticText();

    public StaticText getStaticText8() {
        return staticText8;
    }

    public void setStaticText8(StaticText st) {
        this.staticText8 = st;
    }

    private TableColumn tableColumn4 = new TableColumn();

    public TableColumn getTableColumn4() {
        return tableColumn4;
    }

    public void setTableColumn4(TableColumn tc) {
        this.tableColumn4 = tc;
    }

    private StaticText staticText9 = new StaticText();

    public StaticText getStaticText9() {
        return staticText9;
    }

    public void setStaticText9(StaticText st) {
        this.staticText9 = st;
    }

    private TableColumn tableColumn5 = new TableColumn();

    public TableColumn getTableColumn5() {
        return tableColumn5;
    }

    public void setTableColumn5(TableColumn tc) {
        this.tableColumn5 = tc;
    }

    private Button btn_edit = new Button();

    public Button getBtn_edit() {
        return btn_edit;
    }

    public void setBtn_edit(Button b) {
        this.btn_edit = b;
    }

    private Button btn_remove = new Button();

    public Button getBtn_remove() {
        return btn_remove;
    }

    public void setBtn_remove(Button b) {
        this.btn_remove = b;
    }

    private Button btn_newDetail = new Button();

    public Button getBtn_newDetail() {
        return btn_newDetail;
    }

    public void setBtn_newDetail(Button b) {
        this.btn_newDetail = b;
    }

    private LongConverter longConverter1 = new LongConverter();

    public LongConverter getLongConverter1() {
        return longConverter1;
    }

    public void setLongConverter1(LongConverter lc) {
        this.longConverter1 = lc;
    }

    private Button btn_specimenGeneration1 = new Button();

    public Button getBtn_specimenGeneration1() {
        return btn_specimenGeneration1;
    }

    public void setBtn_specimenGeneration1(Button b) {
        this.btn_specimenGeneration1 = b;
    }
    
    // </editor-fold>
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public editGathering() {
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
            log("ediGathering Initialization Failure", e);
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
        if (!this.getgathering$GatheringSessionBeanV2().isEditMode()) {
            this.getgathering$GatheringSessionBeanV2().setEditMode(true);
            this.st_id.setText(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getId());
            this.txt_Gradient.setValue(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getGradientPercentage());
            this.txt_maxDept.setText(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getMaximumDepth());
            this.txt_maxElevation.setText(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getMaximumElevation());
            this.txt_minDepth.setText(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getMinimumDepth());
            this.txt_minElevation.setText(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getMinimumElevation());
            this.txt_siteDesc.setText(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getGatheringSiteDescription());
            this.txt_surroundings.setText(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getSurroundingsDescription());
            this.getgathering$GatheringSessionBeanV2().setSelectedExposition(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getExposition().getId());
            this.getgathering$GatheringSessionBeanV2().setSelectedResponsiblePerson(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getResponsiblePerson().getId());
            this.getgathering$GatheringSessionBeanV2().setSelectedSite(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getSite().getId());
            this.cal_initialDate.setSelectedDate(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getInitialDate());
            this.cal_finalDate.setSelectedDate(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getFinalDate());
            Long id = this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getId();
            this.getgathering$GatheringSessionBeanV2().setSelectedCollectors(this.getutil$SelectionListBean().getCollectorsByGatheringId(id));
            this.getgathering$GatheringSessionBeanV2().setSelectedProjects(this.getutil$SelectionListBean().getProjectByGatheringId(id));
            this.getgathering$GatheringSessionBeanV2().setSelectedCollections(this.getutil$SelectionListBean().getCollectionsByGatheringId(id));
        }
        
        if (this.getSessionManager().useGatheringDetail()) {
            this.tab_GatheringDetails.setRendered(true);
            this.btn_specimenGeneration1.setRendered(false);
        } else {
            this.tab_GatheringDetails.setRendered(false);
            this.btn_specimenGeneration1.setRendered(true);
        }
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
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
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
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean)getBean("references$ReferenceSessionBean");
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
    protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
        return (ProfileSessionBean)getBean("admin$profile$ProfileSessionBean");
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
    protected SelectionListBean getutil$SelectionListBean() {
        return (SelectionListBean)getBean("util$SelectionListBean");
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
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1)getBean("SessionBean1");
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
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
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
    protected InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
        return (InstitutionSessionBean)getBean("admin$institution$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean)getBean("AraRequestBean");
    }

    public String btn_cancel_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.getgathering$GatheringSessionBeanV2().setEditMode(false);
        this.getgathering$GatheringSessionBeanV2().cleanParameters();
        return "cancelEditGathering";
    }

    public String btn_save_action() {
        if (validate()) {
            // Create a new instance of GatheringObservation
            GatheringObservation newObj = this.getgathering$GatheringSessionBeanV2().getGatheringObservation();
            
            // Assign the required values/entities
            newObj.setCollection(this.getSessionManager().getCollection());
            newObj.setSite(this.getutil$SelectionListBean().getSite(this.getgathering$GatheringSessionBeanV2().getSelectedSite()));
            newObj.setResponsiblePerson(this.getutil$SelectionListBean().getPerson(this.getgathering$GatheringSessionBeanV2().getSelectedResponsiblePerson()));
            newObj.setLastModificationBy(this.getSessionManager().getUser().getUserName());
            newObj.setInitialDate(this.cal_initialDate.getSelectedDate());
            newObj.setFinalDate(this.cal_finalDate.getSelectedDate());
            
            // Assign the optional values/entities
            if (this.getgathering$GatheringSessionBeanV2().getSelectedExposition() != null) {
                newObj.setExposition(this.getutil$SelectionListBean().getExpositionById(this.getgathering$GatheringSessionBeanV2().getSelectedExposition()));
            }
            if (this.txt_Gradient.getValue() != null) {
                //newObj.setGradientPercentage(Long.parseLong((String)this.txt_Gradient.getValue()));
                newObj.setGradientPercentage((Long)this.txt_Gradient.getValue());
            }
            if (this.txt_minElevation.getValue() != null) {
                //newObj.setMinimumElevation(Long.parseLong((String)this.txt_minElevation.getValue()));
                newObj.setMinimumElevation((Long)this.txt_minElevation.getValue());
            }
            if (this.txt_maxElevation.getValue() != null) {
                //newObj.setMaximumElevation(Long.parseLong((String)this.txt_maxElevation.getValue()));
                newObj.setMaximumElevation((Long)this.txt_maxElevation.getValue());
            }
            if (this.txt_minDepth.getValue() != null) {
                //newObj.setMinimumDepth(Long.parseLong((String)this.txt_minDepth.getValue()));
                newObj.setMinimumDepth((Long)this.txt_minDepth.getValue());
            }
            if (this.txt_maxDept.getValue() != null) {
                //newObj.setMaximumDepth(Long.parseLong((String)txt_maxDept.getValue()));
                newObj.setMaximumDepth((Long)txt_maxDept.getValue());
            }
            if (this.txt_surroundings.getValue() != null) {
                newObj.setSurroundingsDescription((String)this.txt_surroundings.getValue());
            }
            if (this.txt_siteDesc.getValue() != null) {
                newObj.setGatheringSiteDescription((String)this.txt_siteDesc.getValue());
            }
            this.getgathering$GatheringSessionBeanV2().update(newObj);
        }
        //this.getgathering$GatheringSessionBeanV2().setEditMode(false);
        return null;
    } 
    
	@SuppressWarnings("static-access")
    public boolean validate() {
        if (this.dd_site.getSelected() == null) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_LOCATION);
            return false;
        }
        if (this.dd_responsiblePerson.getSelected() == null) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_GATHERING_REPONSIBLE);
            return false;
        }
        if (this.cal_initialDate.getSelectedDate() == null) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_GATHERING_INITIAL_DATE);
            return false;
        }
        if (this.cal_finalDate.getSelectedDate() == null) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_GATHERING_FINAL_DATE);
            return false;
        }        
        if (this.cal_initialDate.getSelectedDate().compareTo(this.cal_finalDate.getSelectedDate()) == 1) {
            this.getutil$MessageBean().addErrorMessage(NEWER_INITIAL_DATE);
            return false;
        }
        
        Long minElevation, maxElevation, minDepth, maxDepth;
        
        if (!this.txt_minElevation.getValue().equals("0")) {
            try {
                //tmp = Float.parseFloat(coordinate);
                minElevation = Long.parseLong(this.txt_minElevation.getValue().toString());
            } catch (NumberFormatException ex) {
                this.getutil$MessageBean().addErrorMessage(MAXIMUN_ELEVATION_INVALID_VALUE);
                return false;
            }
        } else {
            minElevation = Long.parseLong(this.txt_minElevation.getValue().toString());
        }
        
	if (!this.txt_maxElevation.getValue().equals("0")) {
            try {
                //tmp = Float.parseFloat(coordinate);
                maxElevation = Long.parseLong(this.txt_maxElevation.getValue().toString());
            } catch (NumberFormatException ex) {
                this.getutil$MessageBean().addErrorMessage(MAXIMUN_ELEVATION_INVALID_VALUE);
                return false;
            }
        } else {
            maxElevation = Long.parseLong(this.txt_maxElevation.getValue().toString());
        }
        
        if (!this.txt_minDepth.getValue().equals("0")) {
            try {
                //tmp = Float.parseFloat(coordinate);
                minDepth = Long.parseLong(this.txt_minDepth.getValue().toString());
            } catch (NumberFormatException ex) {
                this.getutil$MessageBean().addErrorMessage(MININUM_DEEP_INVALID_VALUE);
                return false;
            }
        } else {
            minDepth = Long.parseLong(this.txt_minDepth.getValue().toString());
        }
        
        if (!this.txt_maxDept.getValue().equals("0")) {
            try {
                //tmp = Float.parseFloat(coordinate);
                maxDepth = Long.parseLong(this.txt_maxDept.getValue().toString());
            } catch (NumberFormatException ex) {
                this.getutil$MessageBean().addErrorMessage(MAXIMUN_DEEP_INVALID_VALUE);
                return false;
            }
        } else {
            maxDepth = Long.parseLong(this.txt_maxDept.getValue().toString());
        }
        
        if (!this.txt_Gradient.getValue().equals("0")) {
            try {
                //tmp = Float.parseFloat(coordinate);
                Long tmp = Long.parseLong(this.txt_Gradient.getValue().toString());
            } catch (NumberFormatException ex) {
                this.getutil$MessageBean().addErrorMessage(INVALID_GRADIENT_VALUE);
                return false;
            }
        }
        	
        if (maxDepth.equals(0L)) {
            if (minDepth > 0L) {
                maxDepth = minDepth;
                this.txt_maxDept.setValue(maxDepth);
            }
        }
        
        if (maxElevation.equals(0L)) {
            if (minElevation >0L) {
                maxElevation = minElevation;
                this.txt_maxElevation.setValue(maxElevation);
            }
        }
        
        if (maxDepth < minDepth) {
            this.getutil$MessageBean().addErrorMessage(MINIMUN_DEEP_HIGHER_THAN_MAXIMUN);
            return false;
        }
        
        if (maxElevation < minElevation) {
            this.getutil$MessageBean().addErrorMessage(MINIMUN_ELEVATION_HIGHER_THAN_MAXIMUN);
            return false;
        }
        return true;
    }

    public String btn_edit_action() {
        RowKey rowKey = this.tableRowGroup1.getRowKey();
        this.getgathering$GatheringSessionBeanV2().setEditMode(false);
        this.getgathering$GatheringDetailSessionBean().setDetail(this.getgathering$GatheringSessionBeanV2().getGatheringObservationDetail(rowKey));
        this.getgathering$GatheringDetailSessionBean().setCollectors(this.getutil$SelectionListBean().getCollectorsByGatheringObservation(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getId()));        
        this.getgathering$GatheringDetailSessionBean().setDescriptors(this.getutil$SelectionListBean().getDescriptors());
        return "editGatheringDetail";
    }

    public String btn_remove_action() {
        RowKey rowKey = this.tableRowGroup1.getRowKey();
        this.getgathering$GatheringDetailSessionBean().setDetail(this.getgathering$GatheringSessionBeanV2().getGatheringObservationDetail(rowKey));    
        this.getgathering$GatheringDetailSessionBean().delete();
        this.getgathering$GatheringSessionBeanV2().getGatherinDetailDataProvider().refreshDataList();
        return null;
    }

    public String btn_newDetail_action() {
        if (this.getutil$SelectionListBean().getCollectorsByGatheringId(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getId()).length > 0) {
            this.getgathering$GatheringSessionBeanV2().setEditMode(false);
            this.getgathering$GatheringDetailSessionBean().setCollectors(this.getutil$SelectionListBean().getCollectorsByGatheringObservation(this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getId()));
            return "newGatheringDetail";
        } else {
            this.getutil$MessageBean().addErrorMessage(EMPTY_COLLECTORS_LIST);
            return null;
        }
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean)getBean("gathering$GatheringDetailSessionBean");
    }

    public String btn_generateSpecimen_action() {
        return "specimenGeneration";
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.gathering.SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
        return (org.inbio.ara.web.gathering.SpecimenGenerationSessionBean)getBean("gathering$SpecimenGenerationSessionBean");
    }

    public String btn_specimenGeneration_action() {
        this.getgathering$GatheringSessionBeanV2().setEditMode(false);
        return "specimenGeneration";
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

    public void dd_site_processValueChange(ValueChangeEvent event) {
    }
}

