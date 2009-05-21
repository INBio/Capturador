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
 * specimenGenerationV2.java
 *
 * Created on June 19, 2008, 2:08 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.gathering;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.AddRemove;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Listbox;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlMessages;
import javax.faces.event.ValueChangeEvent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.specimen.LifeStageSexSimple;
import org.inbio.ara.facade.specimen.SpecimenGenParms;
import org.inbio.ara.facade.specimen.SpecimenIdentificationGeneratorRemote;
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
public class specimenGenerationV2 extends AbstractPageBean {
	
	private static final String EMPTY_STAGE = BundleHelper.getDefaultBundleValue("empty_stage");
	private static final String EMPTY_DATE = BundleHelper.getDefaultBundleValue("empty_date");
	private static final String MANY_IDENTIFICATIONS_NOT_ALLOWED = BundleHelper.getDefaultBundleValue("many_identifications_not_allowed");
	private static final String CHOOSE_STAGE = BundleHelper.getDefaultBundleValue("choose_stage");
	private static final String SPECIMEN_AMOUNT_ZERO = BundleHelper.getDefaultBundleValue("specimen_amount_zero");
	private static final String ADD_STAGE_FAILED = BundleHelper.getDefaultBundleValue("add_stage_failed");
	private static final String CHOOSE_CATEGORY = BundleHelper.getDefaultBundleValue("choose_category");
	private static final String CHOOSE_METHOD = BundleHelper.getDefaultBundleValue("choose_method");
	private static final String CHOOSE_SEX = BundleHelper.getDefaultBundleValue("choose_sex");
	private static final String CHOOSE_SPECIMEN = BundleHelper.getDefaultBundleValue("choose_specimen");
	private static final String CHOOSE_TYPE = BundleHelper.getDefaultBundleValue("choose_type");
	private static final String DUPLICATED_DATA = BundleHelper.getDefaultBundleValue("duplicated_data");
	private static final String SPECIMEN_ACCOUNT_REQUIRED = BundleHelper.getDefaultBundleValue("specimen_account_required");
	private static final String SPECIMEN_AMOUNT_INVALID_VALUE = BundleHelper.getDefaultBundleValue("specimen_amount_invalid_value");
	private static final String SPECIMEN_AMOUNT_REQUIRED = BundleHelper.getDefaultBundleValue("specimen_amount_required");
	private static final String SPECIMEN_GENERATION_FAILED = BundleHelper.getDefaultBundleValue("specimen_generation_failed");
	private static final String SPECIMEN_GENERATION_SUCCESS = BundleHelper.getDefaultBundleValue("specimen_generation_success");
	private static final String STAGE_AMOUNT_NOT_NUMERIC = BundleHelper.getDefaultBundleValue("stage_amount_not_numeric");
	private static final String STAGE_AMOUNT_OUT_OF_RANGE = BundleHelper.getDefaultBundleValue("stage_amount_out_of_range");
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private SpecimenGenParms genParms = new SpecimenGenParms();
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

    private Button btn_cancel = new Button();

    public Button getBtn_cancel() {
        return btn_cancel;
    }

    public void setBtn_cancel(Button b) {
        this.btn_cancel = b;
    }

    private Label label2 = new Label();

    public Label getLabel2() {
        return label2;
    }

    public void setLabel2(Label l) {
        this.label2 = l;
    }

    private StaticText st_gatheringDesc = new StaticText();

    public StaticText getSt_gatheringDesc() {
        return st_gatheringDesc;
    }

    public void setSt_gatheringDesc(StaticText st) {
        this.st_gatheringDesc = st;
    }

    private Label label3 = new Label();

    public Label getLabel3() {
        return label3;
    }

    public void setLabel3(Label l) {
        this.label3 = l;
    }

    private Button btn_generate = new Button();

    public Button getBtn_generate() {
        return btn_generate;
    }

    public void setBtn_generate(Button b) {
        this.btn_generate = b;
    }

    private HtmlMessages messageList1 = new HtmlMessages();

    public HtmlMessages getMessageList1() {
        return messageList1;
    }

    public void setMessageList1(HtmlMessages hm) {
        this.messageList1 = hm;
    }

    private TabSet tabSet1 = new TabSet();

    public TabSet getTabSet1() {
        return tabSet1;
    }

    public void setTabSet1(TabSet ts) {
        this.tabSet1 = ts;
    }

    private Tab tab_specimenInfo = new Tab();

    public Tab getTab_specimenInfo() {
        return tab_specimenInfo;
    }

    public void setTab_specimenInfo(Tab t) {
        this.tab_specimenInfo = t;
    }

    private PanelLayout layoutPanel1 = new PanelLayout();

    public PanelLayout getLayoutPanel1() {
        return layoutPanel1;
    }

    public void setLayoutPanel1(PanelLayout pl) {
        this.layoutPanel1 = pl;
    }

    private Tab tab_identificationInfo = new Tab();

    public Tab getTab_identificationInfo() {
        return tab_identificationInfo;
    }

    public void setTab_identificationInfo(Tab t) {
        this.tab_identificationInfo = t;
    }

    private PanelLayout layoutPanel2 = new PanelLayout();

    public PanelLayout getLayoutPanel2() {
        return layoutPanel2;
    }

    public void setLayoutPanel2(PanelLayout pl) {
        this.layoutPanel2 = pl;
    }

    private TabSet tabSet2 = new TabSet();

    public TabSet getTabSet2() {
        return tabSet2;
    }

    public void setTabSet2(TabSet ts) {
        this.tabSet2 = ts;
    }

    private Tab tab1 = new Tab();

    public Tab getTab1() {
        return tab1;
    }

    public void setTab1(Tab t) {
        this.tab1 = t;
    }

    private PanelLayout layoutPanel3 = new PanelLayout();

    public PanelLayout getLayoutPanel3() {
        return layoutPanel3;
    }

    public void setLayoutPanel3(PanelLayout pl) {
        this.layoutPanel3 = pl;
    }

    private Tab tab2 = new Tab();

    public Tab getTab2() {
        return tab2;
    }

    public void setTab2(Tab t) {
        this.tab2 = t;
    }

    private PanelLayout layoutPanel4 = new PanelLayout();

    public PanelLayout getLayoutPanel4() {
        return layoutPanel4;
    }

    public void setLayoutPanel4(PanelLayout pl) {
        this.layoutPanel4 = pl;
    }

    private TabSet tabSet3 = new TabSet();

    public TabSet getTabSet3() {
        return tabSet3;
    }

    public void setTabSet3(TabSet ts) {
        this.tabSet3 = ts;
    }

    private Tab tab3 = new Tab();

    public Tab getTab3() {
        return tab3;
    }

    public void setTab3(Tab t) {
        this.tab3 = t;
    }

    private PanelLayout layoutPanel5 = new PanelLayout();

    public PanelLayout getLayoutPanel5() {
        return layoutPanel5;
    }

    public void setLayoutPanel5(PanelLayout pl) {
        this.layoutPanel5 = pl;
    }

    private Tab tab4 = new Tab();

    public Tab getTab4() {
        return tab4;
    }

    public void setTab4(Tab t) {
        this.tab4 = t;
    }

    private PanelLayout layoutPanel6 = new PanelLayout();

    public PanelLayout getLayoutPanel6() {
        return layoutPanel6;
    }

    public void setLayoutPanel6(PanelLayout pl) {
        this.layoutPanel6 = pl;
    }

    private TextField txt_certaintyLevel = new TextField();

    public TextField getTxt_certaintyLevel() {
        return txt_certaintyLevel;
    }

    public void setTxt_certaintyLevel(TextField tf) {
        this.txt_certaintyLevel = tf;
    }

    private DropDown dd_extractionType = new DropDown();

    public DropDown getDd_extractionType() {
        return dd_extractionType;
    }

    public void setDd_extractionType(DropDown dd) {
        this.dd_extractionType = dd;
    }

    private Label label1 = new Label();

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label l) {
        this.label1 = l;
    }

    private TextField txt_quantity = new TextField();

    public TextField getTxt_quantity() {
        return txt_quantity;
    }

    public void setTxt_quantity(TextField tf) {
        this.txt_quantity = tf;
    }

    private TextField txt_numberFragment = new TextField();

    public TextField getTxt_numberFragment() {
        return txt_numberFragment;
    }

    public void setTxt_numberFragment(TextField tf) {
        this.txt_numberFragment = tf;
    }

    private DropDown dd_preservationMedium = new DropDown();

    public DropDown getDd_preservationMedium() {
        return dd_preservationMedium;
    }

    public void setDd_preservationMedium(DropDown dd) {
        this.dd_preservationMedium = dd;
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

    private Listbox lst_lifeForm = new Listbox();

    public Listbox getLst_lifeForm() {
        return lst_lifeForm;
    }

    public void setLst_lifeForm(Listbox l) {
        this.lst_lifeForm = l;
    }

    private Label label6 = new Label();

    public Label getLabel6() {
        return label6;
    }

    public void setLabel6(Label l) {
        this.label6 = l;
    }

    private Label label7 = new Label();

    public Label getLabel7() {
        return label7;
    }

    public void setLabel7(Label l) {
        this.label7 = l;
    }

    private Label label8 = new Label();

    public Label getLabel8() {
        return label8;
    }

    public void setLabel8(Label l) {
        this.label8 = l;
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

    private DropDown dd_specimenCategory = new DropDown();

    public DropDown getDd_specimenCategory() {
        return dd_specimenCategory;
    }

    public void setDd_specimenCategory(DropDown dd) {
        this.dd_specimenCategory = dd;
    }

    private Label label12 = new Label();

    public Label getLabel12() {
        return label12;
    }

    public void setLabel12(Label l) {
        this.label12 = l;
    }

    private DropDown dd_gatheringObservationMethod = new DropDown();

    public DropDown getDd_gatheringObservationMethod() {
        return dd_gatheringObservationMethod;
    }

    public void setDd_gatheringObservationMethod(DropDown dd) {
        this.dd_gatheringObservationMethod = dd;
    }

    private TextField txt_numberWhole = new TextField();

    public TextField getTxt_numberWhole() {
        return txt_numberWhole;
    }

    public void setTxt_numberWhole(TextField tf) {
        this.txt_numberWhole = tf;
    }

    private Label label13 = new Label();

    public Label getLabel13() {
        return label13;
    }

    public void setLabel13(Label l) {
        this.label13 = l;
    }

    private Calendar cal_ObsDate = new Calendar();

    public Calendar getCal_ObsDate() {
        return cal_ObsDate;
    }

    public void setCal_ObsDate(Calendar c) {
        this.cal_ObsDate = c;
    }

    private Label label14 = new Label();

    public Label getLabel14() {
        return label14;
    }

    public void setLabel14(Label l) {
        this.label14 = l;
    }

    private DropDown dd_origin = new DropDown();

    public DropDown getDd_origin() {
        return dd_origin;
    }

    public void setDd_origin(DropDown dd) {
        this.dd_origin = dd;
    }

    private DropDown dd_specimenType = new DropDown();

    public DropDown getDd_specimenType() {
        return dd_specimenType;
    }

    public void setDd_specimenType(DropDown dd) {
        this.dd_specimenType = dd;
    }

    private Label label15 = new Label();

    public Label getLabel15() {
        return label15;
    }

    public void setLabel15(Label l) {
        this.label15 = l;
    }

    private Label label16 = new Label();

    public Label getLabel16() {
        return label16;
    }

    public void setLabel16(Label l) {
        this.label16 = l;
    }

    private TextField txt_ObsTime = new TextField();

    public TextField getTxt_ObsTime() {
        return txt_ObsTime;
    }

    public void setTxt_ObsTime(TextField tf) {
        this.txt_ObsTime = tf;
    }

    private DropDown dd_storageType = new DropDown();

    public DropDown getDd_storageType() {
        return dd_storageType;
    }

    public void setDd_storageType(DropDown dd) {
        this.dd_storageType = dd;
    }

    private Label label17 = new Label();

    public Label getLabel17() {
        return label17;
    }

    public void setLabel17(Label l) {
        this.label17 = l;
    }

    private DropDown dd_substrate = new DropDown();

    public DropDown getDd_substrate() {
        return dd_substrate;
    }

    public void setDd_substrate(DropDown dd) {
        this.dd_substrate = dd;
    }

    private TextField txt_ssQuantity = new TextField();

    public TextField getTxt_ssQuantity() {
        return txt_ssQuantity;
    }

    public void setTxt_ssQuantity(TextField tf) {
        this.txt_ssQuantity = tf;
    }

    private Label label18 = new Label();

    public Label getLabel18() {
        return label18;
    }

    public void setLabel18(Label l) {
        this.label18 = l;
    }

    private Label label19 = new Label();

    public Label getLabel19() {
        return label19;
    }

    public void setLabel19(Label l) {
        this.label19 = l;
    }

    private DropDown dd_stadium = new DropDown();

    public DropDown getDd_stadium() {
        return dd_stadium;
    }

    public void setDd_stadium(DropDown dd) {
        this.dd_stadium = dd;
    }

    private Table t_stadiumSex1 = new Table();

    public Table getT_stadiumSex1() {
        return t_stadiumSex1;
    }

    public void setT_stadiumSex1(Table t) {
        this.t_stadiumSex1 = t;
    }

    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }

    private TableColumn tableColumn1 = new TableColumn();

    public TableColumn getTableColumn1() {
        return tableColumn1;
    }

    public void setTableColumn1(TableColumn tc) {
        this.tableColumn1 = tc;
    }

    private StaticText staticText1 = new StaticText();

    public StaticText getStaticText1() {
        return staticText1;
    }

    public void setStaticText1(StaticText st) {
        this.staticText1 = st;
    }

    private TableColumn tableColumn2 = new TableColumn();

    public TableColumn getTableColumn2() {
        return tableColumn2;
    }

    public void setTableColumn2(TableColumn tc) {
        this.tableColumn2 = tc;
    }

    private StaticText staticText2 = new StaticText();

    public StaticText getStaticText2() {
        return staticText2;
    }

    public void setStaticText2(StaticText st) {
        this.staticText2 = st;
    }

    private TableColumn tableColumn3 = new TableColumn();

    public TableColumn getTableColumn3() {
        return tableColumn3;
    }

    public void setTableColumn3(TableColumn tc) {
        this.tableColumn3 = tc;
    }

    private StaticText staticText3 = new StaticText();

    public StaticText getStaticText3() {
        return staticText3;
    }

    public void setStaticText3(StaticText st) {
        this.staticText3 = st;
    }

    private TableColumn tableColumn4 = new TableColumn();

    public TableColumn getTableColumn4() {
        return tableColumn4;
    }

    public void setTableColumn4(TableColumn tc) {
        this.tableColumn4 = tc;
    }

    private Button btn_removeStadiumSex = new Button();

    public Button getBtn_removeStadiumSex() {
        return btn_removeStadiumSex;
    }

    public void setBtn_removeStadiumSex(Button b) {
        this.btn_removeStadiumSex = b;
    }

    private Button btn_addStadiumSex = new Button();

    public Button getBtn_addStadiumSex() {
        return btn_addStadiumSex;
    }

    public void setBtn_addStadiumSex(Button b) {
        this.btn_addStadiumSex = b;
    }

    private DropDown dd_sex = new DropDown();

    public DropDown getDd_sex() {
        return dd_sex;
    }

    public void setDd_sex(DropDown dd) {
        this.dd_sex = dd;
    }

    private Label label20 = new Label();

    public Label getLabel20() {
        return label20;
    }

    public void setLabel20(Label l) {
        this.label20 = l;
    }

    private Label label21 = new Label();

    public Label getLabel21() {
        return label21;
    }

    public void setLabel21(Label l) {
        this.label21 = l;
    }

    private Label label22 = new Label();

    public Label getLabel22() {
        return label22;
    }

    public void setLabel22(Label l) {
        this.label22 = l;
    }

    private AddRemove ad_taxonList = new AddRemove();

    public AddRemove getAd_taxonList() {
        return ad_taxonList;
    }

    public void setAd_taxonList(AddRemove ar) {
        this.ad_taxonList = ar;
    }

    private Label label23 = new Label();

    public Label getLabel23() {
        return label23;
    }

    public void setLabel23(Label l) {
        this.label23 = l;
    }

    private Label label24 = new Label();

    public Label getLabel24() {
        return label24;
    }

    public void setLabel24(Label l) {
        this.label24 = l;
    }

    private Label label25 = new Label();

    public Label getLabel25() {
        return label25;
    }

    public void setLabel25(Label l) {
        this.label25 = l;
    }

    private DropDown dd_taxonomicalCategory = new DropDown();

    public DropDown getDd_taxonomicalCategory() {
        return dd_taxonomicalCategory;
    }

    public void setDd_taxonomicalCategory(DropDown dd) {
        this.dd_taxonomicalCategory = dd;
    }

    private DropDown dd_validator = new DropDown();

    public DropDown getDd_validator() {
        return dd_validator;
    }

    public void setDd_validator(DropDown dd) {
        this.dd_validator = dd;
    }

    private DropDown dd_identificationStatus = new DropDown();

    public DropDown getDd_identificationStatus() {
        return dd_identificationStatus;
    }

    public void setDd_identificationStatus(DropDown dd) {
        this.dd_identificationStatus = dd;
    }

    private Label label26 = new Label();

    public Label getLabel26() {
        return label26;
    }

    public void setLabel26(Label l) {
        this.label26 = l;
    }

    private DropDown dd_taxonomicalRange = new DropDown();

    public DropDown getDd_taxonomicalRange() {
        return dd_taxonomicalRange;
    }

    public void setDd_taxonomicalRange(DropDown dd) {
        this.dd_taxonomicalRange = dd;
    }

    private DropDown dd_identificationType = new DropDown();

    public DropDown getDd_identificationType() {
        return dd_identificationType;
    }

    public void setDd_identificationType(DropDown dd) {
        this.dd_identificationType = dd;
    }

    private Calendar cal_identificationDate = new Calendar();

    public Calendar getCal_identificationDate() {
        return cal_identificationDate;
    }

    public void setCal_identificationDate(Calendar c) {
        this.cal_identificationDate = c;
    }

    private Label label27 = new Label();

    public Label getLabel27() {
        return label27;
    }

    public void setLabel27(Label l) {
        this.label27 = l;
    }

    private AddRemove ar_identifier = new AddRemove();

    public AddRemove getAr_identifier() {
        return ar_identifier;
    }

    public void setAr_identifier(AddRemove ar) {
        this.ar_identifier = ar;
    }
    
    // </editor-fold>
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public specimenGenerationV2() {
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
            log("Module specimenGenerationV2 initialization Failure", e);
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
        this.getgathering$SpecimenGenerationSessionBean().populateOptions();

        String desc;
        desc = this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getSummary();
        
        if (this.getSessionManager().useGatheringDetail()) {
            desc += ", " + this.getgathering$GatheringDetailSessionBean().getDetail().getSummary();
        } else {
            desc += ", " + this.getgathering$GatheringSessionBeanV2().getGatheringObservation().getFirstCollectorObserverName();
        }
        this.st_gatheringDesc.setValue(desc);
        
        /* Verificar si la colecci�n usa formas de vida */
        if (!this.getSessionManager().useLifeForms()) {
            // No usa formas de vida, esconder el componente
            this.lst_lifeForm.setRendered(false);
        } else {
            this.lst_lifeForm.setRendered(true);
        }
                
        /* Configuraciones de acuerdo a la categor�a de espec�men seleccionada */
        Long category = this.getgathering$SpecimenGenerationSessionBean().getSelectedSpecimenCategory();
        if (category != -1L) {
            if (category == 1L) {
                this.dd_storageType.setDisabled(true);
                this.dd_origin.setDisabled(true);
                this.dd_preservationMedium.setDisabled(true);
                this.txt_numberWhole.setDisabled(true);
                this.txt_numberFragment.setDisabled(true);
                this.txt_certaintyLevel.setDisabled(false);
                this.txt_ObsTime.setDisabled(false);
                this.cal_ObsDate.setDisabled(false);
            } else {
                this.dd_storageType.setDisabled(false);
                this.dd_origin.setDisabled(false);
                this.dd_preservationMedium.setDisabled(false);
                this.txt_numberWhole.setDisabled(false);
                this.txt_numberFragment.setDisabled(false);
                this.txt_certaintyLevel.setDisabled(true);
                this.txt_ObsTime.setDisabled(true);
                this.cal_ObsDate.setDisabled(true);
            }
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
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1)getBean("SessionBean1");
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
    protected SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean)getBean("gathering$SpecimenGenerationSessionBean");
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
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean)getBean("references$ReferenceSessionBean");
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
    protected UserSessionBean getuser$UserSessionBean() {
        return (UserSessionBean)getBean("user$UserSessionBean");
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
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
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
    protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
        return (GatheringSessionBeanV2)getBean("gathering$GatheringSessionBeanV2");
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

    public void dd_taxonomicalCategory1_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code
        
    }

    public void dd_validator1_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code
        
    }

    public void dd_identificationStatus1_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code
        
    }

    public void dd_taxonomicalRange1_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code
        
    }

    public void dd_identificationType1_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code
        
    }

    public void cal_identificationDate1_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code
        
    }
    
    public String btn_addStadiumSex1_action() {
        if (this.canAddLifeStageSex()) {
            LifeStageSexSimple object = new LifeStageSexSimple();
            object.setQuantity(Long.parseLong(txt_ssQuantity.getValue().toString()));
            object.setLifeStage(this.getutil$SelectionListBean().getLifeStageById(this.getgathering$SpecimenGenerationSessionBean().getSelectedLifeStage()));
            object.setSex(this.getutil$SelectionListBean().getSexById(this.getgathering$SpecimenGenerationSessionBean().getSelectedSex()));
            if (this.getgathering$SpecimenGenerationSessionBean().getLifeStageSexSimpleDataProvider().addElement(object)==false) {
                this.getutil$MessageBean().addErrorMessage(DUPLICATED_DATA);
            }
        }
        return null;
    }
    
    private boolean canAddLifeStageSex() {
        
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedSpecimenType().equals(-1L)) {
            this.getutil$MessageBean().addErrorMessage(CHOOSE_SPECIMEN);
            return false;
        }
        
        if ((this.getgathering$SpecimenGenerationSessionBean().getLifeStageSexSimpleDataProvider().getList().size() == 1) & (!this.getgathering$SpecimenGenerationSessionBean().getSelectedSpecimenType().equals(2L))) {
            this.getutil$MessageBean().addErrorMessage(ADD_STAGE_FAILED);
            return false;
        }
        
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedLifeStage() == -1L) {
            this.getutil$MessageBean().addErrorMessage(CHOOSE_STAGE);
            return false;
        }
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedSex() == -1L) {
            this.getutil$MessageBean().addErrorMessage(CHOOSE_SEX);
            return false;
        }
        if (this.txt_ssQuantity.getValue() == null) {
            this.getutil$MessageBean().addErrorMessage(SPECIMEN_ACCOUNT_REQUIRED);
            return false;
        } else {
            // Validaci�n de tipo de dato
            String value = (String)txt_ssQuantity.getValue();
            try {
                Integer ssQuantity = Integer.parseInt(value);
                if ((ssQuantity < 1) | (ssQuantity > 10000)) {
                    this.getutil$MessageBean().addErrorMessage(STAGE_AMOUNT_OUT_OF_RANGE);
                    return false;
                }
            } catch (NumberFormatException ex) {
                this.getutil$MessageBean().addErrorMessage(STAGE_AMOUNT_NOT_NUMERIC);
                return false;
            }
        }
        return true;
    }
    
    public String btn_removeStadiumSex1_action() {
        LifeStageSexSimple object = (LifeStageSexSimple)this.getgathering$SpecimenGenerationSessionBean().getLifeStageSexSimpleDataProvider().getObject(this.tableRowGroup1.getRowKey());
        this.getgathering$SpecimenGenerationSessionBean().setSelectedLifeStage(object.getLifeStage().getId());
        this.getgathering$SpecimenGenerationSessionBean().setSelectedSex(object.getSex().getId());
        this.txt_ssQuantity.setValue(object.getQuantity());
        this.getgathering$SpecimenGenerationSessionBean().getLifeStageSexSimpleDataProvider().removeElement(this.tableRowGroup1.getRowKey());
        return null;
    }

    public String btn_cancel_action() {
        this.getgathering$SpecimenGenerationSessionBean().cleanParameters();
        this.getgathering$GatheringSessionBeanV2().setEditMode(false);
        if (this.getSessionManager().useGatheringDetail()){
            return "cancelSpecimenGeneration2";
        } else {
            return "cancelSpecimenGeneration1";
        }
    }

    private void setGenerationParms() {
        
        // Informaci�n obligatoria
        // Recolecci�n / observaci�n
        this.genParms.setGatheringObservation(this.getgathering$GatheringSessionBeanV2().getGatheringObservation());
        
        // Usuario
        this.genParms.setCreatedBy(this.getSessionManager().getUser().getUserName());
        
        // Detalle de colecta
        if (this.getSessionManager().useGatheringDetail()) {
            this.genParms.setUseGatheringDetail(true);
            this.genParms.setGatheringObservationDetail(this.getgathering$GatheringDetailSessionBean().getDetail());
        } else {
            this.genParms.setUseGatheringDetail(false);
            this.genParms.setGatheringObservationDetail(null);
        }
        
        // Colecci�n biol�gica
        this.genParms.setCollection(this.getSessionManager().getCollection());

        // M�todo de recolecci�n
        //this.genParms.setGatheringObservationMethod(this.getgathering$GatheringSessionBeanV2().getGatheringObservation())
        this.genParms.setGatheringObservationMethod(this.getgathering$SpecimenGenerationSessionBean().getSelectedGatheringMethod());
        
        // Informaci�n opcional
        // Tipo de almacenamiento
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedStorageType() != -1L) {
            this.genParms.setStorageType(this.getgathering$SpecimenGenerationSessionBean().getSelectedStorageType());
        }
        
        // Sustrato
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedSubstrate() != -1L) {
            this.genParms.setSubstrate(this.getgathering$SpecimenGenerationSessionBean().getSelectedSubstrate());
        }
        
        // Origin
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedOrigin() != -1L) {
            this.genParms.setOrigin(this.getgathering$SpecimenGenerationSessionBean().getSelectedOrigin());
        }
        
        // Medio de preservaci�n
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedPreservationMedium() != -1L) {
            this.genParms.setPreservationMedium(this.getgathering$SpecimenGenerationSessionBean().getSelectedPreservationMedium());
        }
        
        // Tipo de extracci�n
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedExtractionMethod() != -1L) {
            this.genParms.setExtractionType(this.getgathering$SpecimenGenerationSessionBean().getSelectedExtractionMethod());
        }

        // Estadios / Sexos
        //if (this.genParms.useMultipleLifeStageSex()) {
            if (this.getgathering$SpecimenGenerationSessionBean().getLifeStageSexSimpleDataProvider().getList() != null) {
                if (this.getgathering$SpecimenGenerationSessionBean().getLifeStageSexSimpleDataProvider().getList().size() > 0) {
                    this.genParms.setLifeStageSexSimple(this.getgathering$SpecimenGenerationSessionBean().getLifeStageSexSimpleDataProvider().getList());
                }
            }
        //}
        
        // Formas de vida
        if (this.getSessionManager().useLifeForms()) {
            if (this.getgathering$SpecimenGenerationSessionBean().getSelectedLifeForm() != null) {
                if (this.getgathering$SpecimenGenerationSessionBean().getSelectedLifeForm().length > 0) {
                    this.genParms.setLifeForm(this.getgathering$SpecimenGenerationSessionBean().getSelectedLifeForm());
                }
            }
        }
        
        // N�mero de fragmentos
        if (this.txt_numberFragment.getValue() != null) {
            if (!this.txt_numberFragment.getValue().toString().trim().equals("")) {
                try {
                    Long numberFragment = Long.parseLong(this.txt_numberFragment.getValue().toString());
                    this.genParms.setNumberFragment(numberFragment);
                } catch (NumberFormatException ex) {
                    // Do nothing
                }
            }
        }        
        this.genParms.setUseLifeForm(this.getSessionManager().useLifeForms());
        this.genParms.setUseGatheringDetail(this.getSessionManager().useGatheringDetail());
        
        // Datos de la identificaci�n
        // Agregar los datos solamente si hay taxones seleccionados
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon()!=null) {
            if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon().length > 0) {
                // Asignar los taxones seleccionados
                this.genParms.setTaxonArray(this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon());
                // Identificadores
                if (this.getgathering$SpecimenGenerationSessionBean().getSelectedIdentifier()!=null) {
                    if (this.getgathering$SpecimenGenerationSessionBean().getSelectedIdentifier().length > 0) {
                        this.genParms.setIdentifierArray(this.getgathering$SpecimenGenerationSessionBean().getSelectedIdentifier());
                    }
                }
                // Fecha de la identificaci�n
                this.genParms.setIdentificationDate(this.getCal_identificationDate().getSelectedDate());
                // Tipo de identificaci�n
                this.genParms.setIdentificationTypeId(this.getgathering$SpecimenGenerationSessionBean().getSelectedIdentificationType());
                // Estado de la identificaci�n
                this.genParms.setIdentificationStatusId(this.getgathering$SpecimenGenerationSessionBean().getSelectedIdentificationStatus());
                // Validador de la identificaci�n
                this.genParms.setValuerPersonId(this.getgathering$SpecimenGenerationSessionBean().getSelectedIdentificationValidator());
            }
        }
    }
    
    public String btn_generate_action() {
        if (validate()) {
            setGenerationParms();
            try {
                if (this.lookupSpecimenIdentificationGeneratorBean().generate(this.genParms)) {
                    this.getutil$MessageBean().addSuccessMessage(SPECIMEN_GENERATION_SUCCESS);
                } else {
                    this.getutil$MessageBean().addErrorMessage(SPECIMEN_GENERATION_FAILED + lookupSpecimenIdentificationGeneratorBean().getMessage());
                }
            } catch (Exception ex1) {
                
            }            
        }
        this.genParms = new SpecimenGenParms();
        this.getgathering$SpecimenGenerationSessionBean().cleanParameters();
        this.getgathering$GatheringSessionBeanV2().setEditMode(false);
        return null;
    }
    
    private boolean validate() {
        Long specimenCategory;
        
        // Validaciones generales
        // N�mero de espec�menes no nulo
        if (this.txt_quantity.getValue() == null) {
            this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_REQUIRED);
            return false;
        }
        
        // N�mero de espec�menes entero v�lido
        try {
            int quantity = Integer.parseInt(this.txt_quantity.getValue().toString());
            if (quantity <=0) {
                this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_ZERO);
                return false;
            }
        } catch (NumberFormatException ex) {
            this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_INVALID_VALUE);
            return false;
        }

        // Cantidad de especimenes es valida, definir el valor
        this.genParms.setQuantity(Integer.parseInt(this.txt_quantity.getValue().toString()));

        // M�todo de colecta
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedGatheringMethod().equals(-1L)) {
            this.getutil$MessageBean().addErrorMessage(CHOOSE_METHOD);
            return false;
        }
        
        // Categor�a de especimen
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedSpecimenCategory().equals(-1L)) {
            this.getutil$MessageBean().addErrorMessage(CHOOSE_CATEGORY);
            return false;
        }        
        specimenCategory = this.getgathering$SpecimenGenerationSessionBean().getSelectedSpecimenCategory();
        this.genParms.setSpecimenCategory(specimenCategory);
        
        // Tipo de especimen
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedSpecimenType().equals(-1L)) {
            this.getutil$MessageBean().addErrorMessage(CHOOSE_TYPE);
            return false;
        }
        this.genParms.setSpecimenType(this.getgathering$SpecimenGenerationSessionBean().getSelectedSpecimenType());
        
        // Validaciones para la categor�a de especimen "Observaci�n"
        if (specimenCategory.equals(1L)) {
            this.genParms.setUseMultipleLifeStageSex(true);
            // No se permite identificar con varios taxones un mismo especimen.
            if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon() != null) {
                if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon().length > 1) {
                    this.getutil$MessageBean().addErrorMessage(MANY_IDENTIFICATIONS_NOT_ALLOWED);
                    return false;
                }
            }
        }

        // Validaciones para la categor�a de especimen "Individual"
        if (specimenCategory.equals(2L)) {            
            this.genParms.setUseMultipleLifeStageSex(false);
            // No se permite identificar con varios taxones un mismo especimen.
            if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon() != null) {
                if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon().length > 1) {
                    this.getutil$MessageBean().addErrorMessage(MANY_IDENTIFICATIONS_NOT_ALLOWED);
                    return false;
                }
            }
        }
        
        // Validaciones para la categor�a de especimen "Agrupados unitax�n"
        if (specimenCategory.equals(3L)) {
            this.genParms.setUseMultipleLifeStageSex(true);
            // No se permite identificar con varios taxones un mismo especimen.
            if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon() != null) {
                if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon().length > 1) {
                    this.getutil$MessageBean().addErrorMessage(MANY_IDENTIFICATIONS_NOT_ALLOWED);
                    return false;
                }
            }

            // N�mero de espec�menes no nulo
            if (this.txt_numberWhole.getValue() == null) {
                this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_REQUIRED);
                return false;
            }

            // N�mero de enteros - entero v�lido
            try {
                int wholeNumber = Integer.parseInt(this.txt_numberWhole.getValue().toString());
                if (wholeNumber <=0) {
                    this.getutil$MessageBean().addErrorMessage("El valor para n�mero de enteros debe ser mayor a cero.");
                    return false;
                }
            } catch (NumberFormatException ex) {
                this.getutil$MessageBean().addErrorMessage("El valor para n�mero de enteros no es v�lido. Digite solo n�mero enteros.");
                return false;
            }
            
            this.genParms.setNumberWhole(Long.parseLong(this.txt_numberWhole.getValue().toString()));
        }
        
        // Validaciones para la categor�a de especimen "Agrupados multitax�n"
        if (specimenCategory.equals(4L)) {
            this.genParms.setUseMultipleLifeStageSex(true);
            // N�mero de espec�menes no nulo
            if (this.txt_numberWhole.getValue() == null) {
                this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_REQUIRED);
                return false;
            }

            // N�mero de enteros - entero v�lido
            try {
                int wholeNumber = Integer.parseInt(this.txt_numberWhole.getValue().toString());
                if (wholeNumber <=0) {
                    this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_ZERO);
                    return false;
                }
            } catch (NumberFormatException ex) {
                this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_INVALID_VALUE);
                return false;
            }
            this.genParms.setNumberWhole(Long.parseLong(this.txt_numberWhole.getValue().toString()));
        }
        
        // Identificaciones
        // Si hay taxones seleccionados, validar los valores requeridos
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon()!= null) {
            if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon().length > 0) {
                // Fecha de identificaci�n
                if (this.getCal_identificationDate().getSelectedDate()==null) {
                    this.getutil$MessageBean().addErrorMessage(EMPTY_DATE);
                    return false;
                }
                // Estado de la identificaci�n
                if (this.getgathering$SpecimenGenerationSessionBean().getSelectedIdentificationStatus() == -1L) {
                    this.getutil$MessageBean().addErrorMessage(EMPTY_STAGE);
                    return false;
                }
            }
        }

        
        // Todas las validaciones fueron correctas
        return true;
    }

    private SpecimenIdentificationGeneratorRemote lookupSpecimenIdentificationGeneratorBean() {
        try {
            Context c = new InitialContext();
            return (SpecimenIdentificationGeneratorRemote) c.lookup("SpecimenIdentificationGeneratorBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
}

