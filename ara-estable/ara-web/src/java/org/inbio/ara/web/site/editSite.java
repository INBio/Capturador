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
 * editSite.java
 *
 * Created on June 27, 2008, 3:36 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.site;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlMessages;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.gis.SiteCoordinate;
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
public class editSite extends AbstractPageBean {
	
//	
	public static final String DUPLICATED_COORDINATES = BundleHelper.getDefaultBundleValue("duplicated_coordinates");
	public static final String EMPTY_COORIDNATES = BundleHelper.getDefaultBundleValue("empty_cooridnates");
	public static final String EMPTY_DESCRIPTION = BundleHelper.getDefaultBundleValue("empty_description");
	public static final String EMPTY_METHOD = BundleHelper.getDefaultBundleValue("empty_method");
	public static final String EMPTY_ORIGINAL_PROYECTION = BundleHelper.getDefaultBundleValue("empty_original_proyection");
	public static final String EMPTY_PROYECTION = BundleHelper.getDefaultBundleValue("empty_proyection");
	public static final String EMPTY_TYPE = BundleHelper.getDefaultBundleValue("empty_type");
	public static final String INVALID_LATITUDE = BundleHelper.getDefaultBundleValue("invalid_latitude");
	public static final String INVALID_LATITUDE_RANGE = BundleHelper.getDefaultBundleValue("invalid_latitude_range");
	public static final String INVALID_LONGITUDE = BundleHelper.getDefaultBundleValue("invalid_longitude");
	public static final String INVALID_LONGITUDE_RANGE = BundleHelper.getDefaultBundleValue("invalid_longitude_range");
	public static final String ONLY_ONE_COORDINATE_ALLOWED = BundleHelper.getDefaultBundleValue("only_one_coordinate_allowed");
	public static final String THREE_COORDINATES_REQUIRED = BundleHelper.getDefaultBundleValue("three_coordinates_required");
	public static final String TWO_COORIDNATES_REQUIRED = BundleHelper.getDefaultBundleValue("two_cooridnates_required");
    public static final String ONE_COORIDNATE_REQUIRED = BundleHelper.getDefaultBundleValue("one_cooridnates_required");
    private TextField txt_longitude_minutes = new TextField();
    private TextField txt_longitude_seconds = new TextField();
    private TextField txt_latitude_minutes = new TextField();
    private TextField txt_latitude_seconds = new TextField();
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
    
    private Link link1 = new Link();
    
    public Link getLink1() {
        return link1;
    }
    
    public void setLink1(Link l) {
        this.link1 = l;
    }

    private HtmlMessages messageList1 = new HtmlMessages();

    public HtmlMessages getMessageList1() {
        return messageList1;
    }

    public void setMessageList1(HtmlMessages hm) {
        this.messageList1 = hm;
    }

    private DropDown dd_siteCalculationMethod = new DropDown();

    public DropDown getDd_siteCalculationMethod() {
        return dd_siteCalculationMethod;
    }

    public void setDd_siteCalculationMethod(DropDown dd) {
        this.dd_siteCalculationMethod = dd;
    }


    private Tab tab1 = new Tab();

    public Tab getTab1() {
        return tab1;
    }

    public void setTab1(Tab t) {
        this.tab1 = t;
    }

    private PanelLayout layoutPanel1 = new PanelLayout();

    public PanelLayout getLayoutPanel1() {
        return layoutPanel1;
    }

    public void setLayoutPanel1(PanelLayout pl) {
        this.layoutPanel1 = pl;
    }

    private TextField txt_longitude_degrees = new TextField();

    public TextField getTxt_longitude_degrees() {
        return txt_longitude_degrees;
    }

    public void setTxt_longitude_degrees(TextField tf) {
        this.txt_longitude_degrees = tf;
    }

    private TextField txt_latitude_degrees = new TextField();

    public TextField getTxt_latitude_degrees() {
        return txt_latitude_degrees;
    }

    public void setTxt_latitude_degrees(TextField tf) {
        this.txt_latitude_degrees = tf;
    }

    private Button btn_addCoordinate = new Button();

    public Button getBtn_addCoordinate() {
        return btn_addCoordinate;
    }

    public void setBtn_addCoordinate(Button b) {
        this.btn_addCoordinate = b;
    }

    private Table table1 = new Table();

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table t) {
        this.table1 = t;
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

    private Button btn_removeCoord1 = new Button();

    public Button getBtn_removeCoord1() {
        return btn_removeCoord1;
    }

    public void setBtn_removeCoord1(Button b) {
        this.btn_removeCoord1 = b;
    }

    private DropDown dd_featureType = new DropDown();

    public DropDown getDd_featureType() {
        return dd_featureType;
    }

    public void setDd_featureType(DropDown dd) {
        this.dd_featureType = dd;
    }

    private Label label5 = new Label();

    public Label getLabel5() {
        return label5;
    }

    public void setLabel5(Label l) {
        this.label5 = l;
    }

    private TextField txt_precision = new TextField();

    public TextField getTxt_precision() {
        return txt_precision;
    }

    public void setTxt_precision(TextField tf) {
        this.txt_precision = tf;
    }

    private Button btn_cancel = new Button();

    public Button getBtn_cancel() {
        return btn_cancel;
    }

    public void setBtn_cancel(Button b) {
        this.btn_cancel = b;
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

    private TextArea txt_description = new TextArea();

    public TextArea getTxt_description() {
        return txt_description;
    }

    public void setTxt_description(TextArea ta) {
        this.txt_description = ta;
    }

    private Label label8 = new Label();

    public Label getLabel8() {
        return label8;
    }

    public void setLabel8(Label l) {
        this.label8 = l;
    }

    private TextField txt_datum = new TextField();

    public TextField getTxt_datum() {
        return txt_datum;
    }

    public void setTxt_datum(TextField tf) {
        this.txt_datum = tf;
    }

    private DropDown dd_originalProjection = new DropDown();

    public DropDown getDd_originalProjection() {
        return dd_originalProjection;
    }

    public void setDd_originalProjection(DropDown dd) {
        this.dd_originalProjection = dd;
    }

    private Label label9 = new Label();

    public Label getLabel9() {
        return label9;
    }

    public void setLabel9(Label l) {
        this.label9 = l;
    }

    private DropDown dd_baseProjection = new DropDown();

    public DropDown getDd_baseProjection() {
        return dd_baseProjection;
    }

    public void setDd_baseProjection(DropDown dd) {
        this.dd_baseProjection = dd;
    }

    private Label label10 = new Label();

    public Label getLabel10() {
        return label10;
    }

    public void setLabel10(Label l) {
        this.label10 = l;
    }

    private Button btn_save = new Button();

    public Button getBtn_save() {
        return btn_save;
    }

    public void setBtn_save(Button b) {
        this.btn_save = b;
    }

    private Label label11 = new Label();

    public Label getLabel11() {
        return label11;
    }

    public void setLabel11(Label l) {
        this.label11 = l;
    }

    private StaticText st_siteId = new StaticText();

    public StaticText getSt_siteId() {
        return st_siteId;
    }

    public void setSt_siteId(StaticText st) {
        this.st_siteId = st;
    }
    
    // </editor-fold>
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public editSite() {
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
            log("editSite Initialization Failure", e);
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
        if (!this.getsite$SiteSessionBean().isEditMode()) {
            this.getsite$SiteSessionBean().setEditMode(true);
            this.st_siteId.setValue(this.getsite$SiteSessionBean().getSite().getId());
            this.txt_datum.setValue(String.valueOf((Long)this.getsite$SiteSessionBean().getSite().getGeodeticDatum()));
            this.txt_description.setValue(this.getsite$SiteSessionBean().getSite().getDescription());
            this.txt_precision.setValue(String.valueOf((Long)this.getsite$SiteSessionBean().getSite().getPrecision()));

            //jgutierrez  <--> Division Politica, limpia los valores para cuando se entra por 1era vez
            this.getsite$SiteSessionBean().setSelectedCountryId(null);
            this.getsite$SiteSessionBean().setSelectedProvinceId(null);
        }
         //jgutierrez  <--> Division Politica
            this.getsite$SiteSessionBean().setActualPoliticValuesToDropDowns(this.getsite$SiteSessionBean().getSite().getId());
            this.getsite$SiteSessionBean().setCountriesDropDownData();
            this.getsite$SiteSessionBean().setProvincesDropDownData();
            System.out.println("prerender");

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
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (IdentificationSessionBean)getBean("identification$IdentificationSessionBean");
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
    protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
        return (GatheringSessionBeanV2)getBean("gathering$GatheringSessionBeanV2");
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
    protected GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean)getBean("gathering$GatheringDetailSessionBean");
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1)getBean("RequestBean1");
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
    protected PersonSessionBean getadmin$person$PersonSessionBean() {
        return (PersonSessionBean)getBean("admin$person$PersonSessionBean");
    }

    private boolean validateLongitude() {
        Float tmp;
        String coordinate;
        if (this.txt_longitude_degrees.getValue() == null) {
            this.getutil$MessageBean().addErrorMessage(INVALID_LONGITUDE);
            return false;
        }        
        coordinate = this.txt_longitude_degrees.getValue().toString();
        if (coordinate.length() <= 0) {
            this.getutil$MessageBean().addErrorMessage(INVALID_LONGITUDE);
            return false;
        }
        try {
            tmp = Float.parseFloat(coordinate);
            if ((tmp >= -190) & (tmp <= 190)) {
                return true;
            } else {
                this.getutil$MessageBean().addErrorMessage(INVALID_LONGITUDE_RANGE);
                return false;
            }
        } catch (NumberFormatException ex) {
            this.getutil$MessageBean().addErrorMessage(INVALID_LONGITUDE);
            return false;
        }
    }
    
    private boolean validateLatitude() {
        Float tmp;
        String coordinate;
        if (this.txt_latitude_degrees.getValue() == null) {
            this.getutil$MessageBean().addErrorMessage(INVALID_LATITUDE);
            return false;
        }        
        coordinate = this.txt_latitude_degrees.getValue().toString();
        if (coordinate.length() <= 0) {
            this.getutil$MessageBean().addErrorMessage(INVALID_LATITUDE);
            return false;
        }
        try {
            tmp = Float.parseFloat(coordinate);
            if ((tmp >= -90) & (tmp <= 90)) {
                return true;
            } else {
                this.getutil$MessageBean().addErrorMessage(INVALID_LATITUDE_RANGE);
                return false;
            }
        } catch (NumberFormatException ex) {
            this.getutil$MessageBean().addErrorMessage(INVALID_LATITUDE);
            return false;
        }
    }

    //Validate minutes and seconds (MandS)
    private boolean validateMandS(Object in) {
        Float tmp;
        String time;
        if (in == null) {
            MessageBean.setErrorMessageFromBundle("invalid_coor_ms");
            return false;
        }
        time = in.toString();
        try {
            tmp = Float.parseFloat(time);
            if ((tmp >= 0) & (tmp <= 59)) {
                return true;
            } else {
                MessageBean.setErrorMessageFromBundle("invalid_coor_ms");
                return false;
            }
        } catch (NumberFormatException ex) {
            MessageBean.setErrorMessageFromBundle("invalid_coor_ms");
            return false;
        }
    }
    
    private Float getFloatValue(String value) {
        try {
            Float tmp = Float.parseFloat(value);
            return tmp;
        } catch (NumberFormatException ex) {
            return null;
        }
    }
    
    private boolean canAddCoordinate() {
        if (this.getsite$SiteSessionBean().getSelectedFeatureType().equals(1L)) {
            if (this.getsite$SiteSessionBean().getCoordinateDataProvider().getList().size() == 1) {
                this.getutil$MessageBean().addErrorMessage(ONLY_ONE_COORDINATE_ALLOWED);
                return false;
            }
        }
        return true;
    }

    //Method to translate from sexagecimal to decimal notation
    public String translateCoor(String degrees,String minutes,String seconds){
        Float d,m,s,result;
        try{
            //Get float values
            d = Float.parseFloat(degrees);
            m = Float.parseFloat(minutes);
            s = Float.parseFloat(seconds);
            result = Math.abs(d)+Math.abs((m*60)/3600)+Math.abs(s/3600);
            if(d>=0)
                return result.toString();
            else{
                result = result * -1;
                return result.toString();
            }
        }
        catch(NumberFormatException e){return "";}
    }
    
    public String btn_addCoordinate_action() {
        if (canAddCoordinate()) {
            Object lon_degrees = this.getTxt_longitude_degrees().getValue();
            Object lon_minutes = this.getTxt_longitude_minutes().getValue();
            Object lon_seconds = this.getTxt_longitude_seconds().getValue();
            Object lat_degrees = this.getTxt_latitude_degrees().getValue();
            Object lat_minutes = this.getTxt_latitude_minutes().getValue();
            Object lat_seconds = this.getTxt_latitude_seconds().getValue();
            if (validateLongitude()) {
                if (validateLatitude()) {
                    //All data (degrees, minutes and seconds)
                    if(validateMandS(lon_minutes) && validateMandS(lon_seconds) && validateMandS(lat_minutes) && validateMandS(lat_seconds)){
                        //Translate from sexagecimal to decimal notation
                        String lon_result,lat_result;
                        lon_result = translateCoor(lon_degrees.toString(),lon_minutes.toString(),lon_seconds.toString());
                        lat_result = translateCoor(lat_degrees.toString(),lat_minutes.toString(),lat_seconds.toString());
                        SiteCoordinate coord = new SiteCoordinate();
                        coord.setLongitude(getFloatValue(lon_result));
                        coord.setLatitude(getFloatValue(lat_result));
                         if (!this.getsite$SiteSessionBean().getCoordinateDataProvider().addElement(coord)) {
                            this.getutil$MessageBean().addErrorMessage(DUPLICATED_COORDINATES);
                        this.txt_longitude_degrees.setValue("");
                        this.txt_longitude_minutes.setValue("0");
                        this.txt_longitude_seconds.setValue("0");
                        this.txt_latitude_degrees.setValue("");
                        this.txt_latitude_minutes.setValue("0");
                        this.txt_latitude_seconds.setValue("0");
                         }
                        this.txt_longitude_degrees.setValue("");
                        this.txt_longitude_minutes.setValue("0");
                        this.txt_longitude_seconds.setValue("0");
                        this.txt_latitude_degrees.setValue("");
                        this.txt_latitude_minutes.setValue("0");
                        this.txt_latitude_seconds.setValue("0");
                    }
                }
            }
        }
        return null;
    }

    public String btn_removeCoord_action() {
        this.getsite$SiteSessionBean().getCoordinateDataProvider().removeElement(this.tableRowGroup1.getRowKey());
        return null;
    }

    public String btn_save_action() {
        if (validate()) {
            Site site = this.getsite$SiteSessionBean().getSite();
            site.setDescription(this.txt_description.getValue().toString());
            site.setLastModificationBy(this.getSessionManager().getUser().getUserName());
            if (this.txt_datum.getValue() != null) {
                site.setGeodeticDatum(Long.parseLong(this.txt_datum.getValue().toString()));
            }
            if (this.txt_precision.getValue() != null) {
                site.setPrecision(Long.parseLong(this.txt_precision.getValue().toString()));
            }
            if (this.getsite$SiteSessionBean().update(site)) {
                this.getsite$SiteSessionBean().cleanParameters();

                //politic division values
                System.out.println("btnSavePoliticDivision");
                this.getsite$SiteSessionBean().createOrUpdatePolicDivision(site.getId());
                

                return "saveSite";
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public String btn_cancel_action() {
        this.getsite$SiteSessionBean().cleanParameters();
        return "cancelEditSite";
    }
    
    private boolean validate() {
        if (this.txt_description.getValue() == null) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_DESCRIPTION);
            return false;
        }
        
        if (this.txt_description.getValue().equals("")) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_DESCRIPTION);
            return false;
        }

        if ((Long)this.dd_featureType.getSelected() == -1L) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_TYPE);
            return false;
        }
        
        if ((Long)this.dd_baseProjection.getSelected() == -1L) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_PROYECTION);
            return false;
        }
        
        if ((Long)this.dd_siteCalculationMethod.getSelected()==-1L) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_METHOD);
            return false;
        }
        
        if ((Long)this.dd_originalProjection.getSelected()==-1L) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_ORIGINAL_PROYECTION);
            return false;
        }

//        if (this.getsite$SiteSessionBean().getCoordinateDataProvider().getList().size()<=0) {
//            this.getutil$MessageBean().addErrorMessage(EMPTY_COORIDNATES);
//            return false;
//        }

        if (this.getsite$SiteSessionBean().getSelectedFeatureType().equals(1L)) {
            if (this.getsite$SiteSessionBean().getCoordinateDataProvider().getList().size()!=1) {
                this.getutil$MessageBean().addErrorMessage(ONE_COORIDNATE_REQUIRED);
                return false;
            }
        }

        if (this.getsite$SiteSessionBean().getSelectedFeatureType().equals(3L)) {
            if (this.getsite$SiteSessionBean().getCoordinateDataProvider().getList().size()!=2) {
                this.getutil$MessageBean().addErrorMessage(TWO_COORIDNATES_REQUIRED);
                return false;
            }
        }
        
        if (this.getsite$SiteSessionBean().getSelectedFeatureType().equals(2L)) {
            if (this.getsite$SiteSessionBean().getCoordinateDataProvider().getList().size()<3) {
                this.getutil$MessageBean().addErrorMessage(THREE_COORDINATES_REQUIRED);
                return false;
            }
        }
        return true;
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

    /**
     * @return the txt_longitude_minutes
     */
    public TextField getTxt_longitude_minutes() {
        return txt_longitude_minutes;
    }

    /**
     * @param txt_longitude_minutes the txt_longitude_minutes to set
     */
    public void setTxt_longitude_minutes(TextField txt_longitude_minutes) {
        this.txt_longitude_minutes = txt_longitude_minutes;
    }

    /**
     * @return the txt_longitude_seconds
     */
    public TextField getTxt_longitude_seconds() {
        return txt_longitude_seconds;
    }

    /**
     * @param txt_longitude_seconds the txt_longitude_seconds to set
     */
    public void setTxt_longitude_seconds(TextField txt_longitude_seconds) {
        this.txt_longitude_seconds = txt_longitude_seconds;
    }

    /**
     * @return the txt_latitude_minutes
     */
    public TextField getTxt_latitude_minutes() {
        return txt_latitude_minutes;
    }

    /**
     * @param txt_latitude_minutes the txt_latitude_minutes to set
     */
    public void setTxt_latitude_minutes(TextField txt_latitude_minutes) {
        this.txt_latitude_minutes = txt_latitude_minutes;
    }

    /**
     * @return the txt_latitude_seconds
     */
    public TextField getTxt_latitude_seconds() {
        return txt_latitude_seconds;
    }

    /**
     * @param txt_latitude_seconds the txt_latitude_seconds to set
     */
    public void setTxt_latitude_seconds(TextField txt_latitude_seconds) {
        this.txt_latitude_seconds = txt_latitude_seconds;
    }
}

