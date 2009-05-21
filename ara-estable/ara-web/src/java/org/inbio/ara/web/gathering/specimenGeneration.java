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
 * specimenGeneration.java
 *
 * Created on June 12, 2008, 5:36 PM
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
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlMessages;
import javax.faces.convert.IntegerConverter;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.LongRangeValidator;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.util.SelectionListBean;
import org.inbio.ara.facade.specimen.LifeStageSexSimple;
import org.inbio.ara.web.util.BundleHelper;
/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class specimenGeneration extends AbstractPageBean {

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
    private int __placeholder;
    private SpecimenGenParms genParms = new SpecimenGenParms();

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        longRangeValidator1.setMinimum(1);
        longRangeValidator1.setMaximum(10000);
        dd_hourDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[] {new com.sun.webui.jsf.model.Option("0", "00"), new com.sun.webui.jsf.model.Option("1", "01"), new com.sun.webui.jsf.model.Option("2", "02"), new com.sun.webui.jsf.model.Option("3", "03"), new com.sun.webui.jsf.model.Option("4", "04"), new com.sun.webui.jsf.model.Option("5", "05"), new com.sun.webui.jsf.model.Option("6", "06"), new com.sun.webui.jsf.model.Option("7", "07"), new com.sun.webui.jsf.model.Option("8", "08"), new com.sun.webui.jsf.model.Option("09", "09"), new com.sun.webui.jsf.model.Option("10", "10"), new com.sun.webui.jsf.model.Option("11", "11"), new com.sun.webui.jsf.model.Option("12", "12"), new com.sun.webui.jsf.model.Option("13", "13"), new com.sun.webui.jsf.model.Option("14", "14"), new com.sun.webui.jsf.model.Option("15", "15"), new com.sun.webui.jsf.model.Option("16", "16"), new com.sun.webui.jsf.model.Option("17", "17"), new com.sun.webui.jsf.model.Option("18", "18"), new com.sun.webui.jsf.model.Option("19", "19"), new com.sun.webui.jsf.model.Option("20", "20"), new com.sun.webui.jsf.model.Option("21", "21"), new com.sun.webui.jsf.model.Option("22", "22"), new com.sun.webui.jsf.model.Option("23", "23"), new com.sun.webui.jsf.model.Option("24", "24")});
        dd_minuteDefaultOptions.setOptions(new com.sun.webui.jsf.model.Option[] {new com.sun.webui.jsf.model.Option("0", "00"), new com.sun.webui.jsf.model.Option("1", "01"), new com.sun.webui.jsf.model.Option("2", "02"), new com.sun.webui.jsf.model.Option("3", "03"), new com.sun.webui.jsf.model.Option("4", "04"), new com.sun.webui.jsf.model.Option("5", "05"), new com.sun.webui.jsf.model.Option("6", "06"), new com.sun.webui.jsf.model.Option("7", "07"), new com.sun.webui.jsf.model.Option("8", "08"), new com.sun.webui.jsf.model.Option("9", "09"), new com.sun.webui.jsf.model.Option("10", "10"), new com.sun.webui.jsf.model.Option("11", "11"), new com.sun.webui.jsf.model.Option("12", "12"), new com.sun.webui.jsf.model.Option("13", "13"), new com.sun.webui.jsf.model.Option("14", "14"), new com.sun.webui.jsf.model.Option("15", "15"), new com.sun.webui.jsf.model.Option("16", "16"), new com.sun.webui.jsf.model.Option("17", "17"), new com.sun.webui.jsf.model.Option("18", "18"), new com.sun.webui.jsf.model.Option("19", "19"), new com.sun.webui.jsf.model.Option("20", "20"), new com.sun.webui.jsf.model.Option("21", "21"), new com.sun.webui.jsf.model.Option("22", "22"), new com.sun.webui.jsf.model.Option("23", "23"), new com.sun.webui.jsf.model.Option("24", "24"), new com.sun.webui.jsf.model.Option("25", "25"), new com.sun.webui.jsf.model.Option("26", "26"), new com.sun.webui.jsf.model.Option("27", "27"), new com.sun.webui.jsf.model.Option("28", "28"), new com.sun.webui.jsf.model.Option("29", "29"), new com.sun.webui.jsf.model.Option("30", "30"), new com.sun.webui.jsf.model.Option("31", "31"), new com.sun.webui.jsf.model.Option("32", "32"), new com.sun.webui.jsf.model.Option("33", "33"), new com.sun.webui.jsf.model.Option("34", "34"), new com.sun.webui.jsf.model.Option("35", "35"), new com.sun.webui.jsf.model.Option("36", "36"), new com.sun.webui.jsf.model.Option("37", "37"), new com.sun.webui.jsf.model.Option("38", "38"), new com.sun.webui.jsf.model.Option("39", "39"), new com.sun.webui.jsf.model.Option("40", "40"), new com.sun.webui.jsf.model.Option("41", "41"), new com.sun.webui.jsf.model.Option("42", "42"), new com.sun.webui.jsf.model.Option("43", "43"), new com.sun.webui.jsf.model.Option("44", "44"), new com.sun.webui.jsf.model.Option("45", "45"), new com.sun.webui.jsf.model.Option("46", "46"), new com.sun.webui.jsf.model.Option("47", "47"), new com.sun.webui.jsf.model.Option("48", "48"), new com.sun.webui.jsf.model.Option("49", "49"), new com.sun.webui.jsf.model.Option("50", "50"), new com.sun.webui.jsf.model.Option("51", "51"), new com.sun.webui.jsf.model.Option("52", "52"), new com.sun.webui.jsf.model.Option("53", "53"), new com.sun.webui.jsf.model.Option("54", "54"), new com.sun.webui.jsf.model.Option("55", "55"), new com.sun.webui.jsf.model.Option("56", "56"), new com.sun.webui.jsf.model.Option("57", "57"), new com.sun.webui.jsf.model.Option("58", "58"), new com.sun.webui.jsf.model.Option("59", "59")});
        ad_taxonList1.setWidth("480");
        ar_identifier1.setWidth("310");
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

    private HtmlMessages messageList1 = new HtmlMessages();

    public HtmlMessages getMessageList1() {
        return messageList1;
    }

    public void setMessageList1(HtmlMessages hm) {
        this.messageList1 = hm;
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

    private StaticText st_gatheringDesc = new StaticText();

    public StaticText getSt_gatheringDesc() {
        return st_gatheringDesc;
    }

    public void setSt_gatheringDesc(StaticText st) {
        this.st_gatheringDesc = st;
    }

    private Button btn_generate = new Button();

    public Button getBtn_generate() {
        return btn_generate;
    }

    public void setBtn_generate(Button b) {
        this.btn_generate = b;
    }

    private Button btn_cancel = new Button();

    public Button getBtn_cancel() {
        return btn_cancel;
    }

    public void setBtn_cancel(Button b) {
        this.btn_cancel = b;
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

    private StaticText staticText3 = new StaticText();

    public StaticText getStaticText3() {
        return staticText3;
    }

    public void setStaticText3(StaticText st) {
        this.staticText3 = st;
    }

    private TableColumn tableColumn2 = new TableColumn();

    public TableColumn getTableColumn2() {
        return tableColumn2;
    }

    public void setTableColumn2(TableColumn tc) {
        this.tableColumn2 = tc;
    }

    private StaticText staticText4 = new StaticText();

    public StaticText getStaticText4() {
        return staticText4;
    }

    public void setStaticText4(StaticText st) {
        this.staticText4 = st;
    }

    private TableColumn tableColumn3 = new TableColumn();

    public TableColumn getTableColumn3() {
        return tableColumn3;
    }

    public void setTableColumn3(TableColumn tc) {
        this.tableColumn3 = tc;
    }

    private StaticText staticText5 = new StaticText();

    public StaticText getStaticText5() {
        return staticText5;
    }

    public void setStaticText5(StaticText st) {
        this.staticText5 = st;
    }

    private Label label_Stadium = new Label();

    public Label getLabel_Stadium() {
        return label_Stadium;
    }

    public void setLabel_Stadium(Label l) {
        this.label_Stadium = l;
    }

    private DropDown dd_stadium1 = new DropDown();

    public DropDown getDd_stadium1() {
        return dd_stadium1;
    }

    public void setDd_stadium1(DropDown dd) {
        this.dd_stadium1 = dd;
    }

    private Label label_Sex = new Label();

    public Label getLabel_Sex() {
        return label_Sex;
    }

    public void setLabel_Sex(Label l) {
        this.label_Sex = l;
    }

    private DropDown dd_sex1 = new DropDown();

    public DropDown getDd_sex1() {
        return dd_sex1;
    }

    public void setDd_sex1(DropDown dd) {
        this.dd_sex1 = dd;
    }

    private Label specimensQuantity = new Label();

    public Label getSpecimensQuantity() {
        return specimensQuantity;
    }

    public void setSpecimensQuantity(Label l) {
        this.specimensQuantity = l;
    }

    private TextField txt_ssQuantity = new TextField();

    public TextField getTxt_ssQuantity() {
        return txt_ssQuantity;
    }

    public void setTxt_ssQuantity(TextField tf) {
        this.txt_ssQuantity = tf;
    }

    private Button btn_addStadiumSex1 = new Button();

    public Button getBtn_addStadiumSex1() {
        return btn_addStadiumSex1;
    }

    public void setBtn_addStadiumSex1(Button b) {
        this.btn_addStadiumSex1 = b;
    }

    private Button btn_removeStadiumSex1 = new Button();

    public Button getBtn_removeStadiumSex1() {
        return btn_removeStadiumSex1;
    }

    public void setBtn_removeStadiumSex1(Button b) {
        this.btn_removeStadiumSex1 = b;
    }

    private PanelLayout lyt_basicOptions1 = new PanelLayout();

    public PanelLayout getLyt_basicOptions1() {
        return lyt_basicOptions1;
    }

    public void setLyt_basicOptions1(PanelLayout pl) {
        this.lyt_basicOptions1 = pl;
    }

    private Label label_specimensQuantity = new Label();

    public Label getLabel_specimensQuantity() {
        return label_specimensQuantity;
    }

    public void setLabel_specimensQuantity(Label l) {
        this.label_specimensQuantity = l;
    }

    private TextField txt_quantity1 = new TextField();

    public TextField getTxt_quantity1() {
        return txt_quantity1;
    }

    public void setTxt_quantity1(TextField tf) {
        this.txt_quantity1 = tf;
    }

    private Label label_specimenCategory = new Label();

    public Label getLabel_specimenCategory() {
        return label_specimenCategory;
    }

    public void setLabel_specimenCategory(Label l) {
        this.label_specimenCategory = l;
    }

    private DropDown dd_specimenCategory1 = new DropDown();

    public DropDown getDd_specimenCategory1() {
        return dd_specimenCategory1;
    }

    public void setDd_specimenCategory1(DropDown dd) {
        this.dd_specimenCategory1 = dd;
    }

    private Label label_specimenType = new Label();

    public Label getLabel_specimenType() {
        return label_specimenType;
    }

    public void setLabel_specimenType(Label l) {
        this.label_specimenType = l;
    }

    private DropDown dd_specimenType1 = new DropDown();

    public DropDown getDd_specimenType1() {
        return dd_specimenType1;
    }

    public void setDd_specimenType1(DropDown dd) {
        this.dd_specimenType1 = dd;
    }

    private Label label_specimenOrigin = new Label();

    public Label getLabel_specimenOrigin() {
        return label_specimenOrigin;
    }

    public void setLabel_specimenOrigin(Label l) {
        this.label_specimenOrigin = l;
    }

    private DropDown dd_origin1 = new DropDown();

    public DropDown getDd_origin1() {
        return dd_origin1;
    }

    public void setDd_origin1(DropDown dd) {
        this.dd_origin1 = dd;
    }

    private Label label_preservationMedium = new Label();

    public Label getLabel_preservationMedium() {
        return label_preservationMedium;
    }

    public void setLabel_preservationMedium(Label l) {
        this.label_preservationMedium = l;
    }

    private DropDown dd_preservationMedium1 = new DropDown();

    public DropDown getDd_preservationMedium1() {
        return dd_preservationMedium1;
    }

    public void setDd_preservationMedium1(DropDown dd) {
        this.dd_preservationMedium1 = dd;
    }

    private Label label_Storage = new Label();

    public Label getLabel_Storage() {
        return label_Storage;
    }

    public void setLabel_Storage(Label l) {
        this.label_Storage = l;
    }

    private DropDown dd_storageType1 = new DropDown();

    public DropDown getDd_storageType1() {
        return dd_storageType1;
    }

    public void setDd_storageType1(DropDown dd) {
        this.dd_storageType1 = dd;
    }

    private Label label_Substrate = new Label();

    public Label getLabel_Substrate() {
        return label_Substrate;
    }

    public void setLabel_Substrate(Label l) {
        this.label_Substrate = l;
    }

    private DropDown dd_substrate1 = new DropDown();

    public DropDown getDd_substrate1() {
        return dd_substrate1;
    }

    public void setDd_substrate1(DropDown dd) {
        this.dd_substrate1 = dd;
    }

    private Label label_taxonomicalRange = new Label();

    public Label getLabel_taxonomicalRange() {
        return label_taxonomicalRange;
    }

    public void setLabel_taxonomicalRange(Label l) {
        this.label_taxonomicalRange = l;
    }

    private Label label_taxonCategory = new Label();

    public Label getLabel_taxonCategory() {
        return label_taxonCategory;
    }

    public void setLabel_taxonCategory(Label l) {
        this.label_taxonCategory = l;
    }

    private DropDown dd_taxonomicalRange1 = new DropDown();

    public DropDown getDd_taxonomicalRange1() {
        return dd_taxonomicalRange1;
    }

    public void setDd_taxonomicalRange1(DropDown dd) {
        this.dd_taxonomicalRange1 = dd;
    }

    private DropDown dd_taxonomicalCategory1 = new DropDown();

    public DropDown getDd_taxonomicalCategory1() {
        return dd_taxonomicalCategory1;
    }

    public void setDd_taxonomicalCategory1(DropDown dd) {
        this.dd_taxonomicalCategory1 = dd;
    }

    private AddRemove ad_taxonList1 = new AddRemove();

    public AddRemove getAd_taxonList1() {
        return ad_taxonList1;
    }

    public void setAd_taxonList1(AddRemove ar) {
        this.ad_taxonList1 = ar;
    }

    private Label label_identificationDate = new Label();

    public Label getLabel_identificationDate() {
        return label_identificationDate;
    }

    public void setLabel_identificationDate(Label l) {
        this.label_identificationDate = l;
    }

    private Calendar cal_identificationDate1 = new Calendar();

    public Calendar getCal_identificationDate1() {
        return cal_identificationDate1;
    }

    public void setCal_identificationDate1(Calendar c) {
        this.cal_identificationDate1 = c;
    }

    private Label label_Status = new Label();

    public Label getLabel_Status() {
        return label_Status;
    }

    public void setLabel_Status(Label l) {
        this.label_Status = l;
    }

    private DropDown dd_identificationStatus1 = new DropDown();

    public DropDown getDd_identificationStatus1() {
        return dd_identificationStatus1;
    }

    public void setDd_identificationStatus1(DropDown dd) {
        this.dd_identificationStatus1 = dd;
    }

    private Label label_identificationType = new Label();

    public Label getLabel_identificationType() {
        return label_identificationType;
    }

    public void setLabel_identificationType(Label l) {
        this.label_identificationType = l;
    }

    private DropDown dd_identificationType1 = new DropDown();

    public DropDown getDd_identificationType1() {
        return dd_identificationType1;
    }

    public void setDd_identificationType1(DropDown dd) {
        this.dd_identificationType1 = dd;
    }

    private Label label_identificationValidator = new Label();

    public Label getLabel_identificationValidator() {
        return label_identificationValidator;
    }

    public void setLabel_identificationValidator(Label l) {
        this.label_identificationValidator = l;
    }

    private DropDown dd_validator1 = new DropDown();

    public DropDown getDd_validator1() {
        return dd_validator1;
    }

    public void setDd_validator1(DropDown dd) {
        this.dd_validator1 = dd;
    }

    private AddRemove ar_identifier1 = new AddRemove();

    public AddRemove getAr_identifier1() {
        return ar_identifier1;
    }

    public void setAr_identifier1(AddRemove ar) {
        this.ar_identifier1 = ar;
    }

    private TableColumn tableColumn4 = new TableColumn();

    public TableColumn getTableColumn4() {
        return tableColumn4;
    }

    public void setTableColumn4(TableColumn tc) {
        this.tableColumn4 = tc;
    }

    private LongRangeValidator longRangeValidator1 = new LongRangeValidator();

    public LongRangeValidator getLongRangeValidator1() {
        return longRangeValidator1;
    }

    public void setLongRangeValidator1(LongRangeValidator lrv) {
        this.longRangeValidator1 = lrv;
    }

    private Label label_Fragments = new Label();

    public Label getLabel_Fragments() {
        return label_Fragments;
    }

    public void setLabel_Fragments(Label l) {
        this.label_Fragments = l;
    }

    private TextField txt_numberWhole1 = new TextField();

    public TextField getTxt_numberWhole1() {
        return txt_numberWhole1;
    }

    public void setTxt_numberWhole1(TextField tf) {
        this.txt_numberWhole1 = tf;
    }

    private TextField txt_numberFragment1 = new TextField();

    public TextField getTxt_numberFragment1() {
        return txt_numberFragment1;
    }

    public void setTxt_numberFragment1(TextField tf) {
        this.txt_numberFragment1 = tf;
    }

    private Label label_Wholes = new Label();

    public Label getLabel_Wholes() {
        return label_Wholes;
    }

    public void setLabel_Wholes(Label l) {
        this.label_Wholes = l;
    }

    private IntegerConverter integerConverter1 = new IntegerConverter();

    public IntegerConverter getIntegerConverter1() {
        return integerConverter1;
    }

    public void setIntegerConverter1(IntegerConverter ic) {
        this.integerConverter1 = ic;
    }

    private Label label_extractionMethod = new Label();

    public Label getLabel_extractionMethod() {
        return label_extractionMethod;
    }

    public void setLabel_extractionMethod(Label l) {
        this.label_extractionMethod = l;
    }

    private DropDown dd_extractionType = new DropDown();

    public DropDown getDd_extractionType() {
        return dd_extractionType;
    }

    public void setDd_extractionType(DropDown dd) {
        this.dd_extractionType = dd;
    }

    private SingleSelectOptionsList dd_extractionTypeDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDd_extractionTypeDefaultOptions() {
        return dd_extractionTypeDefaultOptions;
    }

    public void setDd_extractionTypeDefaultOptions(SingleSelectOptionsList ssol) {
        this.dd_extractionTypeDefaultOptions = ssol;
    }

    private Label label_gatheringMethod = new Label();

    public Label getLabel_gatheringMethod() {
        return label_gatheringMethod;
    }

    public void setLabel_gatheringMethod(Label l) {
        this.label_gatheringMethod = l;
    }

    private DropDown dd_gatheringObservationMethod = new DropDown();

    public DropDown getDd_gatheringObservationMethod() {
        return dd_gatheringObservationMethod;
    }

    public void setDd_gatheringObservationMethod(DropDown dd) {
        this.dd_gatheringObservationMethod = dd;
    }

    private TextField txt_certaintyLevel1 = new TextField();

    public TextField getTxt_certaintyLevel1() {
        return txt_certaintyLevel1;
    }

    public void setTxt_certaintyLevel1(TextField tf) {
        this.txt_certaintyLevel1 = tf;
    }

    private Calendar cal_ObsDate1 = new Calendar();

    public Calendar getCal_ObsDate1() {
        return cal_ObsDate1;
    }

    public void setCal_ObsDate1(Calendar c) {
        this.cal_ObsDate1 = c;
    }

    private Label label_observationTime = new Label();

    public Label getLabel_observationTime() {
        return label_observationTime;
    }

    public void setLabel_observationTime(Label l) {
        this.label_observationTime = l;
    }

    private Label label_observationDate = new Label();

    public Label getLabel_observationDate() {
        return label_observationDate;
    }

    public void setLabel_observationDate(Label l) {
        this.label_observationDate = l;
    }

    private Label label_certaintyLevel = new Label();

    public Label getLabel_certaintyLevel() {
        return label_certaintyLevel;
    }

    public void setLabel_certaintyLevel(Label l) {
        this.label_certaintyLevel = l;
    }

    private Listbox lst_lifeForm1 = new Listbox();

    public Listbox getLst_lifeForm1() {
        return lst_lifeForm1;
    }

    public void setLst_lifeForm1(Listbox l) {
        this.lst_lifeForm1 = l;
    }

    private Label label_lifeForm = new Label();

    public Label getLabel_lifeForm() {
        return label_lifeForm;
    }

    public void setLabel_lifeForm(Label l) {
        this.label_lifeForm = l;
    }

    private Label label_Taxa = new Label();

    public Label getLabel_Taxa() {
        return label_Taxa;
    }

    public void setLabel_Taxa(Label l) {
        this.label_Taxa = l;
    }

    private Label label_identifiers = new Label();

    public Label getLabel_identifiers() {
        return label_identifiers;
    }

    public void setLabel_identifiers(Label l) {
        this.label_identifiers = l;
    }

    private DropDown dd_hour = new DropDown();

    public DropDown getDd_hour() {
        return dd_hour;
    }

    public void setDd_hour(DropDown dd) {
        this.dd_hour = dd;
    }

    private SingleSelectOptionsList dd_hourDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDd_hourDefaultOptions() {
        return dd_hourDefaultOptions;
    }

    public void setDd_hourDefaultOptions(SingleSelectOptionsList ssol) {
        this.dd_hourDefaultOptions = ssol;
    }

    private DropDown dd_minute = new DropDown();

    public DropDown getDd_minute() {
        return dd_minute;
    }

    public void setDd_minute(DropDown dd) {
        this.dd_minute = dd;
    }

    private SingleSelectOptionsList dd_minuteDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDd_minuteDefaultOptions() {
        return dd_minuteDefaultOptions;
    }

    public void setDd_minuteDefaultOptions(SingleSelectOptionsList ssol) {
        this.dd_minuteDefaultOptions = ssol;
    }

    private Button btn_showSpecimenList = new Button();

    public Button getBtn_showSpecimenList() {
        return btn_showSpecimenList;
    }

    public void setBtn_showSpecimenList(Button b) {
        this.btn_showSpecimenList = b;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public specimenGeneration() {
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
            log("specimenGeneration Initialization Failure", e);
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
            this.lst_lifeForm1.setRendered(false);
        } else {
            this.lst_lifeForm1.setRendered(true);
        }

        /* Configuraciones de acuerdo a la categor�a de espec�men seleccionada */
        Long category = this.getgathering$SpecimenGenerationSessionBean().getSelectedSpecimenCategory();
        if (category != -1L) {
            if (category == 1L) {
                this.dd_storageType1.setDisabled(true);
                this.dd_origin1.setDisabled(true);
                this.dd_preservationMedium1.setDisabled(true);
                this.txt_numberWhole1.setDisabled(true);
                this.txt_numberFragment1.setDisabled(true);
                this.txt_certaintyLevel1.setDisabled(false);
                this.dd_hour.setDisabled(false);
                this.dd_minute.setDisabled(false);
                this.cal_ObsDate1.setDisabled(false);
            } else {
                this.dd_storageType1.setDisabled(false);
                this.dd_origin1.setDisabled(false);
                this.dd_preservationMedium1.setDisabled(false);
                this.txt_numberWhole1.setDisabled(false);
                this.txt_numberFragment1.setDisabled(false);
                this.txt_certaintyLevel1.setDisabled(true);
                this.dd_hour.setDisabled(false);
                this.dd_minute.setDisabled(false);
                this.cal_ObsDate1.setDisabled(true);
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
    protected UserSessionBean getuser$UserSessionBean() {
        return (UserSessionBean)getBean("user$UserSessionBean");
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
    protected GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean)getBean("gathering$GatheringDetailSessionBean");
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
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
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
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
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
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean)getBean("references$ReferenceSessionBean");
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
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean)getBean("AraRequestBean");
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
    protected SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean)getBean("gathering$SpecimenGenerationSessionBean");
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
            String value = txt_ssQuantity.getValue().toString();
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
        if (this.txt_numberFragment1.getValue() != null) {
            if (!this.txt_numberFragment1.getValue().toString().trim().equals("")) {
                try {
                    Long numberFragment = Long.parseLong(this.txt_numberFragment1.getValue().toString());
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
                this.genParms.setIdentificationDate(this.getCal_identificationDate1().getSelectedDate());
                // Tipo de identificaci�n
                this.genParms.setIdentificationTypeId(this.getgathering$SpecimenGenerationSessionBean().getSelectedIdentificationType());
                // Estado de la identificaci�n
                this.genParms.setIdentificationStatusId(this.getgathering$SpecimenGenerationSessionBean().getSelectedIdentificationStatus());
                // Validador de la identificaci�n
                this.genParms.setValuerPersonId(this.getgathering$SpecimenGenerationSessionBean().getSelectedIdentificationValidator());
            }
        }

        // Validaciones para la categor�a de especimen "Observaci�n"
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedSpecimenCategory().equals(1L) && this.getgathering$SpecimenGenerationSessionBean().getObservationDate() != null) {
            try {
                //this.genParms.setDateTime(getgathering$SpecimenGenerationSessionBean().getObservationDate());
                Date tmp = getgathering$SpecimenGenerationSessionBean().getObservationDate();
                GregorianCalendar gc;
                gc = new GregorianCalendar(tmp.getYear(),tmp.getMonth(),tmp.getDate(), this.getgathering$SpecimenGenerationSessionBean().getHour(), this.getgathering$SpecimenGenerationSessionBean().getMinute());
                this.genParms.setDateTime(gc.getInstance().getTime());
            } catch (NullPointerException ex) {
                this.getutil$MessageBean().addErrorMessage(EMPTY_DATE);
            }
            /*
            this.genParms.getDateTime().setHours(this.getgathering$SpecimenGenerationSessionBean().getHour());
            this.genParms.getDateTime().setMinutes(this.getgathering$SpecimenGenerationSessionBean().getMinute());
             */
        }
    }

    public String btn_generate_action() {
        if (validate()) {
            setGenerationParms();
            try {
                if (this.lookupSpecimenIdentificationGeneratorBean().generate(this.genParms)) {
                    this.getutil$MessageBean().addSuccessMessage(SPECIMEN_GENERATION_SUCCESS);
                    this.genParms = new SpecimenGenParms();
                    this.getgathering$SpecimenGenerationSessionBean().cleanParameters();
                    this.getgathering$GatheringSessionBeanV2().setEditMode(false);
                } else {
                    this.getutil$MessageBean().addErrorMessage(SPECIMEN_GENERATION_FAILED + lookupSpecimenIdentificationGeneratorBean().getMessage());
                }
            } catch (Exception ex1) {
                this.getutil$MessageBean().addErrorMessage(ex1.getMessage());
                this.getutil$MessageBean().addErrorMessage(SPECIMEN_GENERATION_FAILED + lookupSpecimenIdentificationGeneratorBean().getMessage());
            }
        }
        return null;
    }

    private boolean validate() {
        Long specimenCategory;

        // Validaciones generales
        // N�mero de espec�menes no nulo
        if (this.txt_quantity1.getValue() == null) {
            this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_REQUIRED);
            return false;
        }

        // N�mero de espec�menes entero v�lido
        try {
            int quantity = Integer.parseInt(this.txt_quantity1.getValue().toString());
            if (quantity <= 0) {
                this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_ZERO);
                return false;
            }
        } catch (NumberFormatException ex) {
            this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_INVALID_VALUE);
            return false;
        }

        // Cantidad de especimenes es valida, definir el valor
        this.genParms.setQuantity(Integer.parseInt(this.txt_quantity1.getValue().toString()));

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

            // Verificar que la fecha de observaci�n no sea nula
            // if (this.getgathering$SpecimenGenerationSessionBean().getObservationDate() == null) {
            //     this.getutil$MessageBean().addErrorMessage(EMPTY_DATE);
            //     return false;
            // }
        }

        // Validaciones para la categor�a de especimen "Individual"
        if (specimenCategory.equals(2L)) {

            // this.genParms.setUseMultipleLifeStageSex(false);

//            // N�mero de enteros - entero v�lido
//            try {
//                if (this.txt_numberWhole1.getValue() != null) {
//                    int wholeNumber = Integer.parseInt(this.txt_numberWhole1.getValue().toString());
//                    if (wholeNumber <= 0) {
//                        this.getutil$MessageBean().addErrorMessage("El valor para n�mero de enteros debe ser mayor a cero.");
//                        return false;
//                    }
//                }
//                this.genParms.setNumberWhole(Long.parseLong(this.txt_numberWhole1.getValue().toString()));
//            } catch (NumberFormatException ex) {
//                this.getutil$MessageBean().addErrorMessage("El valor para n�mero de enteros no es v�lido. Digite solo n�mero enteros.");
//                return false;
//            } catch (NullPointerException ex) {
//                this.getutil$MessageBean().addErrorMessage("El valor para n�mero de enteros es nulo.");
//                return false;
//            }
//
//            // N�mero de fragmentos - entero v�lido
//            try {
//                if (this.txt_numberFragment1.getValue() != null) {
//                    int fragmentNumber = Integer.parseInt(this.txt_numberFragment1.getValue().toString());
//                    if (fragmentNumber <= 0) {
//                        this.getutil$MessageBean().addErrorMessage("El valor para n�mero de fragmentos debe ser mayor a cero.");
//                        return false;
//                    }
//                }
//                this.genParms.setNumberWhole(Long.parseLong(this.txt_numberFragment1.getValue().toString()));
//            } catch (NumberFormatException ex) {
//                this.getutil$MessageBean().addErrorMessage("El valor para n�mero de fragmentos no es v�lido. Digite solo n�mero enteros.");
//                return false;
//            } catch (NullPointerException ex) {
//                this.getutil$MessageBean().addErrorMessage("El valor para n�mero de fragmentos es nulo.");
//                return false;
//            }

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
            if (this.txt_numberWhole1.getValue() == null) {
                this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_REQUIRED);
                return false;
            }

            // N�mero de enteros - entero v�lido
            try {
                int wholeNumber = Integer.parseInt(this.txt_numberWhole1.getValue().toString());
                if (wholeNumber <= 0) {
                    this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_ZERO);
                    return false;
                }
            } catch (NumberFormatException ex) {
                this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_INVALID_VALUE);
                return false;
            }

            this.genParms.setNumberWhole(Long.parseLong(this.txt_numberWhole1.getValue().toString()));
        }

        // Validaciones para la categor�a de especimen "Agrupados multitax�n"
        if (specimenCategory.equals(4L)) {
            this.genParms.setUseMultipleLifeStageSex(true);
            // N�mero de espec�menes no nulo
            if (this.txt_numberWhole1.getValue() == null) {
                this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_REQUIRED);
                return false;
            }

            // N�mero de enteros - entero v�lido
            try {
                int wholeNumber = Integer.parseInt(this.txt_numberWhole1.getValue().toString());
                if (wholeNumber <=0) {
                    this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_ZERO);
                    return false;
                }
            } catch (NumberFormatException ex) {
                this.getutil$MessageBean().addErrorMessage(SPECIMEN_AMOUNT_INVALID_VALUE);
                return false;
            }
            this.genParms.setNumberWhole(Long.parseLong(this.txt_numberWhole1.getValue().toString()));
        }

        // Identificaciones
        // Si hay taxones seleccionados, validar los valores requeridos
        if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon()!= null) {
            if (this.getgathering$SpecimenGenerationSessionBean().getSelectedTaxon().length > 0) {
                // Fecha de identificaci�n
                if (this.getCal_identificationDate1().getSelectedDate()==null) {
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1)getBean("RequestBean1");
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.identification.IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (org.inbio.ara.web.identification.IdentificationSessionBean)getBean("identification$IdentificationSessionBean");
    }

    public void dd_taxonomicalRange1_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code

    }

    public void dd_specimenCategory1_processValueChange(ValueChangeEvent event) {
        // TODO: Replace with your code

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
    protected org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean getnomenclaturalgroup$NomenclaturalGroupSessionBean() {
        return (org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean)getBean("nomenclaturalgroup$NomenclaturalGroupSessionBean");
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

    public String btn_showSpecimenList_action() {
        return "showGeneratedSpecimen";
    }
}
