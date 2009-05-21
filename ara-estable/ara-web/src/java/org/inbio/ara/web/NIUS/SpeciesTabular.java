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
 * SpeciesTabular.java
 *
 * Created on September 29, 2007, 5:39 PM
 * Copyright mvargas
 */
package org.inbio.ara.web.NIUS;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
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
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PanelGroup;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.component.UIColumn;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlMessages;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.species.TaxonDescriptionRemote;
//import org.inbio.ara.persistence.species.SpeciesRecord;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.taxon.service.TaxonServiceRemote;
import org.inbio.ara.web.*;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class SpeciesTabular extends AbstractPageBean {
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

    private PanelGroup groupPanel1 = new PanelGroup();

    public PanelGroup getGroupPanel1() {
        return groupPanel1;
    }

    public void setGroupPanel1(PanelGroup pg) {
        this.groupPanel1 = pg;
    }

    private Button button1 = new Button();

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button b) {
        this.button1 = b;
    }

    private Button button4 = new Button();

    public Button getButton4() {
        return button4;
    }

    public void setButton4(Button b) {
        this.button4 = b;
    }

    private Button button5 = new Button();

    public Button getButton5() {
        return button5;
    }

    public void setButton5(Button b) {
        this.button5 = b;
    }

    private Button button6 = new Button();

    public Button getButton6() {
        return button6;
    }

    public void setButton6(Button b) {
        this.button6 = b;
    }

    private TableColumn tableColumn3 = new TableColumn();

    public TableColumn getTableColumn3() {
        return tableColumn3;
    }

    public void setTableColumn3(TableColumn tc) {
        this.tableColumn3 = tc;
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

    private TableColumn tableColumn4 = new TableColumn();

    public TableColumn getTableColumn4() {
        return tableColumn4;
    }

    public void setTableColumn4(TableColumn tc) {
        this.tableColumn4 = tc;
    }

    private DropDown dropDown1 = new DropDown();

    public DropDown getDropDown1() {
        return dropDown1;
    }

    public void setDropDown1(DropDown dd) {
        this.dropDown1 = dd;
    }

    private TableColumn tableColumn5 = new TableColumn();

    public TableColumn getTableColumn5() {
        return tableColumn5;
    }

    public void setTableColumn5(TableColumn tc) {
        this.tableColumn5 = tc;
    }

    private StaticText staticText3 = new StaticText();

    public StaticText getStaticText3() {
        return staticText3;
    }

    public void setStaticText3(StaticText st) {
        this.staticText3 = st;
    }

    private TableColumn tableColumn6 = new TableColumn();

    public TableColumn getTableColumn6() {
        return tableColumn6;
    }

    public void setTableColumn6(TableColumn tc) {
        this.tableColumn6 = tc;
    }

    private StaticText staticText4 = new StaticText();

    public StaticText getStaticText4() {
        return staticText4;
    }

    public void setStaticText4(StaticText st) {
        this.staticText4 = st;
    }

    private TableColumn tableColumn7 = new TableColumn();

    public TableColumn getTableColumn7() {
        return tableColumn7;
    }

    public void setTableColumn7(TableColumn tc) {
        this.tableColumn7 = tc;
    }

    private StaticText staticText5 = new StaticText();

    public StaticText getStaticText5() {
        return staticText5;
    }

    public void setStaticText5(StaticText st) {
        this.staticText5 = st;
    }

    private TableColumn tableColumn8 = new TableColumn();

    public TableColumn getTableColumn8() {
        return tableColumn8;
    }

    public void setTableColumn8(TableColumn tc) {
        this.tableColumn8 = tc;
    }

    private Button button2 = new Button();

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button b) {
        this.button2 = b;
    }

    private TableColumn tableColumn9 = new TableColumn();

    public TableColumn getTableColumn9() {
        return tableColumn9;
    }

    public void setTableColumn9(TableColumn tc) {
        this.tableColumn9 = tc;
    }

    private Button button3 = new Button();

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button b) {
        this.button3 = b;
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

    private UIColumn column1 = new UIColumn();

    public UIColumn getColumn1() {
        return column1;
    }

    public void setColumn1(UIColumn uic) {
        this.column1 = uic;
    }

    private Hyperlink hlink_showWelcome1 = new Hyperlink();

    public Hyperlink getHlink_showWelcome1() {
        return hlink_showWelcome1;
    }

    public void setHlink_showWelcome1(Hyperlink h) {
        this.hlink_showWelcome1 = h;
    }

    private UIColumn column8 = new UIColumn();

    public UIColumn getColumn8() {
        return column8;
    }

    public void setColumn8(UIColumn uic) {
        this.column8 = uic;
    }

    private HtmlOutputText outputText1 = new HtmlOutputText();

    public HtmlOutputText getOutputText1() {
        return outputText1;
    }

    public void setOutputText1(HtmlOutputText hot) {
        this.outputText1 = hot;
    }

    private HtmlDataTable dataTable2 = new HtmlDataTable();

    public HtmlDataTable getDataTable2() {
        return dataTable2;
    }

    public void setDataTable2(HtmlDataTable hdt) {
        this.dataTable2 = hdt;
    }

    private UIColumn column9 = new UIColumn();

    public UIColumn getColumn9() {
        return column9;
    }

    public void setColumn9(UIColumn uic) {
        this.column9 = uic;
    }

    private HtmlOutputText outputText2 = new HtmlOutputText();

    public HtmlOutputText getOutputText2() {
        return outputText2;
    }

    public void setOutputText2(HtmlOutputText hot) {
        this.outputText2 = hot;
    }

    private HtmlDataTable dataTable3 = new HtmlDataTable();

    public HtmlDataTable getDataTable3() {
        return dataTable3;
    }

    public void setDataTable3(HtmlDataTable hdt) {
        this.dataTable3 = hdt;
    }

    private UIColumn column2 = new UIColumn();

    public UIColumn getColumn2() {
        return column2;
    }

    public void setColumn2(UIColumn uic) {
        this.column2 = uic;
    }

    private Hyperlink hlink_exit1 = new Hyperlink();

    public Hyperlink getHlink_exit1() {
        return hlink_exit1;
    }

    public void setHlink_exit1(Hyperlink h) {
        this.hlink_exit1 = h;
    }

    private UIColumn column3 = new UIColumn();

    public UIColumn getColumn3() {
        return column3;
    }

    public void setColumn3(UIColumn uic) {
        this.column3 = uic;
    }

    private HtmlMessages messageList1 = new HtmlMessages();

    public HtmlMessages getMessageList1() {
        return messageList1;
    }

    public void setMessageList1(HtmlMessages hm) {
        this.messageList1 = hm;
    }
    
    private Button btn_search = new Button();    
    
    public Button getBtn_search() {
        return btn_search;
    }

    public void setBtn_search(Button btn_search) {
        this.btn_search = btn_search;
    }

    private Label label1 = new Label();

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label l) {
        this.label1 = l;
    }

    private Button btn_remove = new Button();

    public Button getBtn_remove() {
        return btn_remove;
    }

    public void setBtn_remove(Button b) {
        this.btn_remove = b;
    }

    private TableColumn tableColumn10 = new TableColumn();

    public TableColumn getTableColumn10() {
        return tableColumn10;
    }

    public void setTableColumn10(TableColumn tc) {
        this.tableColumn10 = tc;
    }
    
    // </editor-fold>
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public SpeciesTabular() {
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
        
        // this.setSpeciesRecordVersionOptions();
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("SpeciesTabular Initialization Failure", e);
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
        //getAraSessionBean().getTaxonDataProvider().refreshDP();
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
        this.getspecies$SpeciesSessionBean().initDataProvider();
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
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean)getBean("AraRequestBean");
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

    public String button1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        getspecies$SpeciesSessionBean().getTaxonDataProvider().setStartPosition(0);
        return null;
    }
    
    public String showDetailBtn_action() {
        String taxonId;
        RowKey rowKey = tableRowGroup1.getRowKey();
        Taxon editTaxon;
        
        // getAraRequestBean().setTaxonId(getAraSessionBean().getTaxonDataProvider().getValue("taxonId", rowKey).toString());
        taxonId = getspecies$SpeciesSessionBean().getTaxonDataProvider().getValue("taxonId", rowKey).toString();
        editTaxon = lookupTaxonServiceBean().findTaxonById(new Long(taxonId));
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        Application app = ctx.getApplication();
        ValueBinding binding = app.createValueBinding("#{species$SpeciesSessionBean.currentTaxon}");
        binding.setValue(ctx, editTaxon);
        
        Long taxon_id = Long.parseLong(taxonId);
        //Long species_record_version = Long.parseLong(this.getSpeciesRecordVersion());
        Long species_record_version = Long.parseLong(this.getspecies$SpeciesSessionBean().getSelectTaxonDescriptionSequence());
        
        TaxonDescription currentTaxonDescription = this.lookupTaxonDescriptionBean().getTaxonDescription(taxon_id,species_record_version);
        if (currentTaxonDescription != null) {
            this.getspecies$SpeciesSessionBean().setCurrentTaxonDescription(currentTaxonDescription);
            this.getspecies$SpeciesSessionBean().populateList();
            this.getspecies$SpeciesSessionBean().setCurrentTaxonDescriptionCategoryId(-1);
            return "case2";
        } else {
            //System.out.println(lookupTaxonDescriptionBean().getMessage());
            this.getutil$MessageBean().addErrorMessage(lookupTaxonDescriptionBean().getMessage());
            //this.getspecies$SpeciesSessionBean().addErrorMessage(lookupTaxonDescriptionBean().getMessage());
            return null;
        }
    }      
    
    private TaxonServiceRemote lookupTaxonServiceBean() {
        try {
            Context c = new InitialContext();
            return (TaxonServiceRemote) c.lookup("TaxonServiceBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public String taxonKingdomName = "animalia";
    public String getTaxonKingdomName() {
        RowKey rowKey  = tableRowGroup1.getRowKey();
        return ((Taxon) getspecies$SpeciesSessionBean().getTaxonDataProvider().getValue("kingdomTaxon", rowKey)).getDefaultName();
        
//        Taxon taxon = (Taxon) getAraSessionBean().getTaxonDataProvider().getValue("kingdomTaxon", rowKey);
//        String kingdomTaxonName = taxon.getDefaultName();
//        return kingdomTaxonName;
    }    
    
    public String taxonFamilyName = "felidae";
    public String getTaxonFamilyName() {
        RowKey rowKey  = tableRowGroup1.getRowKey();
//        String taxonId = (String) getAraSessionBean().getTaxonDataProvider().getValue("taxonId", rowKey);

        Taxon taxon = (Taxon) getspecies$SpeciesSessionBean().getTaxonDataProvider().getValue("familyTaxon", rowKey);        
        String familyTaxonName = taxon.getDefaultName();        
        return familyTaxonName;
        
        
//        return getAraApplicationBean().getTaxonFamilyName("51323");
        // return "Felidae";
    }        
    
    public String taxonAuthorName = "autor";
    public String getTaxonAuthorName() {
//        RowKey rowKey  = tableRowGroup1.getRowKey();
//        String taxonId = (String) getAraSessionBean().getTaxonDataProvider().getValue("taxonId", rowKey);
//
//        return getAraApplicationBean().getTaxonKingdomName(taxonId);
        return "Autor";
    }        
    
    public String button4_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        getspecies$SpeciesSessionBean().getTaxonDataProvider().previous();
        return null;
    }

    public String button5_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        getspecies$SpeciesSessionBean().getTaxonDataProvider().next();
        return null;
    }

    public ArrayList<Option> getSpeciesRecordVersionOptions() {
        RowKey rowKey  = tableRowGroup1.getRowKey();
        
        ArrayList<Option> speciesRecordVersionOptions = new ArrayList<Option>();
        TreeSet<String> optionValues = new TreeSet();
        
        Set<TaxonDescription> taxonDescriptionSet = (Set<TaxonDescription>) getspecies$SpeciesSessionBean().getTaxonDataProvider().getValue("taxonDescriptionSet", rowKey);

        if (taxonDescriptionSet.isEmpty()) {
            speciesRecordVersionOptions.add(new Option("1", "Sin registros de especies"));
        } else {
            for(Iterator i = taxonDescriptionSet.iterator();i.hasNext();) {
                TaxonDescription taxonDescription = (TaxonDescription) i.next();
                
                
                String option = "" + taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence();
                String key = "" + taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence();
                /* RA. Cambiada la construccion
                String option = taxonDescription.getCreatedBy() + " " + taxonDescription.getCreationDate().toString();
                String key = taxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence().toString();
                 */
                //String option = taxonDescription.getCreatedBy() + " " + taxonDescription..getCreationDate().toString();
                //String option = taxonDescription.getSpeciesRecord().getCreatedBy() + " " + taxonDescription.getSpeciesRecord().getCreationDate().toString();
                // String option = taxonDescription.getSpeciesRecord().getSpeciesRecordPK().toString();
                
                if (!optionValues.contains(option)) {
                    speciesRecordVersionOptions.add(new Option(key, option));
                    optionValues.add(option);
                }
            }
        }
       
        return speciesRecordVersionOptions;
    }
    
    private Option[] speciesRecordVersionOptions;

    /*
    public ArrayList<Option> getSpeciesRecordVersionOptions() {
        RowKey rowKey  = tableRowGroup1.getRowKey();
        
        ArrayList<Option> speciesRecordVersionOptions = new ArrayList<Option>();
        TreeSet<String> optionValues = new TreeSet();
        
        Set<TaxonDescription> taxonDescriptionSet = (Set<TaxonDescription>) getAraSessionBean().getTaxonDataProvider().getValue("taxonDescriptionSet", rowKey);

        if (taxonDescriptionSet.isEmpty()) {
            speciesRecordVersionOptions.add(new Option("1", "Sin registros de especies"));
        } else {
            for(Iterator i = taxonDescriptionSet.iterator();i.hasNext();) {
                TaxonDescription taxonDescription = (TaxonDescription) i.next();
                
                // String option = taxonDescription.getSpeciesRecord().getCreatedBy() + " " + taxonDescription.getSpeciesRecord().getCreationDate().toString();
                //String option = taxonDescription.getSpeciesRecord().getSpeciesRecordPK().toString();
                String option = "";
                
                if (!optionValues.contains(option)) {
                    speciesRecordVersionOptions.add(new Option(option, option));
                    optionValues.add(option);
                }
            }
        }
       
        return speciesRecordVersionOptions;
    } 
     */   

//    public void setSpeciesRecordVersionOptions() {
//        // this.speciesRecordOptions = speciesRecordOptions;
//        
//        speciesRecordVersionOptions = new Option[] {
//            new Option("1", "Linnaeus 1800"),
//            new Option("2", "Zamora 2007")
//        };        
//    }    
    
    
    private String speciesRecordVersion;

    public String getSpeciesRecordVersion() {
        return speciesRecordVersion;
    }

    public void setSpeciesRecordVersion(String speciesRecordVersion) {
        this.speciesRecordVersion = speciesRecordVersion;
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

    public String button6_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return null;
    }

    public String button3_action() {
        String taxonId;
        Taxon currentTaxon;
        RowKey rowKey = tableRowGroup1.getRowKey();
        
        taxonId = getspecies$SpeciesSessionBean().getTaxonDataProvider().getValue("taxonId", rowKey).toString();
        currentTaxon = lookupTaxonServiceBean().findTaxonById(new Long(taxonId));
        
        this.getspecies$SpeciesSessionBean().setCurrentTaxon(currentTaxon);
        
        return "newSpecies";
    }

    public String hlink_showWelcome_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return "cancelSpeciesTabular";
    }

    public String hlink_species_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return null;
    }

    public String hlink_person_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return null;
    }

    public String hlink_profile_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return null;
    }

    public String hlink_institution_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return null;
    }

    public String hlink_user_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return null;
    }

    public String hlink_changePwd_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return null;
    }

    public String hlink_exit1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return "exit";
    }
    
    public String btn_search_action() {
        return "search";
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
    protected GroupSessionBean getgroup$GroupSessionBean() {
        return (GroupSessionBean)getBean("group$GroupSessionBean");
    }

    private TaxonDescriptionRemote lookupTaxonDescriptionBean() {
        try {
            Context c = new InitialContext();
            return (TaxonDescriptionRemote) c.lookup("TaxonDescriptionBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
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
    protected org.inbio.ara.web.references.ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (org.inbio.ara.web.references.ReferenceSessionBean)getBean("references$ReferenceSessionBean");
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

    public String btn_remove_action() {
        Long taxonId, taxonDescriptionSequence;
        RowKey rowKey = tableRowGroup1.getRowKey();
        //taxonId = (Long)getAraSessionBean().getTaxonDataProvider().getValue("taxonId", rowKey);
        //taxonDescriptionSequence = (Long)getAraSessionBean().getTaxonDataProvider().getValue("taxonDescriptionSequence", rowKey);
        taxonId = 51323L;
        taxonDescriptionSequence = 1L;
        this.getspecies$SpeciesSessionBean().remove(taxonId, taxonDescriptionSequence);
        return null;
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
    
}

