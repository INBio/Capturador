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
 * speciesEdit.java
 *
 * Created on January 15, 2008, 5:41 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.species;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.AddRemove;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageComponent;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Listbox;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.Script;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.TabSet;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.component.Tree;
import com.sun.webui.jsf.component.TreeNode;
import com.sun.webui.jsf.model.DefaultOptionsList;
import com.sun.webui.jsf.model.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlMessages;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.convert.LongConverter;
import javax.faces.event.ValueChangeEvent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.PredefinedValuesRemote;
import org.inbio.ara.facade.TaxonDescriptionCategoryFacadeRemote;
import org.inbio.ara.persistence.species.TaxonDescriptionRecord;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionCategory;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionElement;
import org.inbio.ara.persistence.util.Language;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.AraRequestBean;
import org.inbio.ara.web.MathUtils;
import org.inbio.ara.web.NIUS.borrar;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.NIUS.SpeciesTabular;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.admin.person.searchPerson;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.uimanagers.DynamicPanelForm;
import org.inbio.ara.web.util.BundleHelper;
import org.inbio.ara.web.util.BundleHelper;
import static org.inbio.ara.web.uimanagers.Components.*;
import org.inbio.ara.web.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class speciesEdit extends AbstractPageBean {


    public static final String ADD_NEW = BundleHelper.getDefaultBundleValue("add_new");
    public static final String CATEGORY_ELEMENTS = BundleHelper.getDefaultBundleValue("category_elements");
    public static final String DELETE = BundleHelper.getDefaultBundleValue("delete");
    public static final String EDIT = BundleHelper.getDefaultBundleValue("edit");
    public static final String EMPTY_LANGUAGE = BundleHelper.getDefaultBundleValue("empty_language");
    public static final String EMPTY_STAGE = BundleHelper.getDefaultBundleValue("empty_stage");
    public static final String EMPTY_VERSION = BundleHelper.getDefaultBundleValue("empty_version");
    public static final String ID = BundleHelper.getDefaultBundleValue("id");
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private Option[] audienceOptions;
    private Option[] authorOptions;
    private Option[] institutionOptions;
    private Option[] taxonDescriptionStages;
    private Option[] languageOptions;
    private Option[] taxonHierarchy;
    private Option[] referenceOptions;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    /**
     * Create the MethodExpressions for the tree nodes
     */
    ExpressionFactory expressionFactory = this.getApplication().getExpressionFactory();
    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    MethodExpression actionMethod = expressionFactory.createMethodExpression(elContext,
            "#{species$speciesEdit.treeItemClickHandler}", String.class, new Class[]{});
    MethodExpression actionMethod2 = expressionFactory.createMethodExpression(elContext,
            "#{species$speciesEdit.btn_EditRecordRow_action}", String.class, new Class[]{});
    MethodExpression actionMethod3 = expressionFactory.createMethodExpression(elContext,
            "#{species$speciesEdit.btn_RemoveRecordRow_action}", String.class, new Class[]{});
    private MethodExpression actionMethod4 = expressionFactory.createMethodExpression(elContext,
            "#{species$speciesEdit.btn_AddRecordRow_action}", String.class, new Class[]{});
    private MethodExpression actionMethod5 = expressionFactory.createMethodExpression(elContext,
            "#{species$speciesEdit.saveRecordData_action}", String.class, new Class[]{});
    private MethodExpression actionMethod6 = expressionFactory.createMethodExpression(elContext,
            "#{species$speciesEdit.saveRepeatableRecordData_action}", String.class, new Class[]{});
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
    private TabSet tabSet1 = new TabSet();

    public TabSet getTabSet1() {
        return tabSet1;
    }

    public void setTabSet1(TabSet ts) {
        this.tabSet1 = ts;
    }
    private Tab tab_Descriptions = new Tab();

    public Tab getTab_Descriptions() {
        return tab_Descriptions;
    }

    public void setTab_Descriptions(Tab t) {
        this.tab_Descriptions = t;
    }
    private PanelLayout layoutPanel1 = new PanelLayout();

    public PanelLayout getLayoutPanel1() {
        return layoutPanel1;
    }

    public void setLayoutPanel1(PanelLayout pl) {
        this.layoutPanel1 = pl;
    }
    private Tab tab_Audiences = new Tab();

    public Tab getTab_Audiences() {
        return tab_Audiences;
    }

    public void setTab_Audiences(Tab t) {
        this.tab_Audiences = t;
    }
    private PanelLayout layoutPanel2 = new PanelLayout();

    public PanelLayout getLayoutPanel2() {
        return layoutPanel2;
    }

    public void setLayoutPanel2(PanelLayout pl) {
        this.layoutPanel2 = pl;
    }
    private Tab tab_Authors = new Tab();

    public Tab getTab_Authors() {
        return tab_Authors;
    }

    public void setTab_Authors(Tab t) {
        this.tab_Authors = t;
    }
    private PanelLayout layoutPanel3 = new PanelLayout();

    public PanelLayout getLayoutPanel3() {
        return layoutPanel3;
    }

    public void setLayoutPanel3(PanelLayout pl) {
        this.layoutPanel3 = pl;
    }
    private Tab tab_Institutions = new Tab();

    public Tab getTab_Institutions() {
        return tab_Institutions;
    }

    public void setTab_Institutions(Tab t) {
        this.tab_Institutions = t;
    }
    private PanelLayout layoutPanel4 = new PanelLayout();

    public PanelLayout getLayoutPanel4() {
        return layoutPanel4;
    }

    public void setLayoutPanel4(PanelLayout pl) {
        this.layoutPanel4 = pl;
    }
    private Tab tab_stages = new Tab();

    public Tab getTab_stages() {
        return tab_stages;
    }

    public void setTab_stages(Tab t) {
        this.tab_stages = t;
    }
    private PanelLayout layoutPanel5 = new PanelLayout();

    public PanelLayout getLayoutPanel5() {
        return layoutPanel5;
    }

    public void setLayoutPanel5(PanelLayout pl) {
        this.layoutPanel5 = pl;
    }
    private Tab tab_TaxonomicalHierarchy = new Tab();

    public Tab getTab_TaxonomicalHierarchy() {
        return tab_TaxonomicalHierarchy;
    }

    public void setTab_TaxonomicalHierarchy(Tab t) {
        this.tab_TaxonomicalHierarchy = t;
    }
    private PanelLayout layoutPanel6 = new PanelLayout();

    public PanelLayout getLayoutPanel6() {
        return layoutPanel6;
    }

    public void setLayoutPanel6(PanelLayout pl) {
        this.layoutPanel6 = pl;
    }
    private Tab tab_NomenclaturalGroups = new Tab();

    public Tab getTab_NomenclaturalGroups() {
        return tab_NomenclaturalGroups;
    }

    public void setTab_NomenclaturalGroups(Tab t) {
        this.tab_NomenclaturalGroups = t;
    }
    private PanelLayout layoutPanel7 = new PanelLayout();

    public PanelLayout getLayoutPanel7() {
        return layoutPanel7;
    }

    public void setLayoutPanel7(PanelLayout pl) {
        this.layoutPanel7 = pl;
    }
    
    private PanelLayout ly_Header = new PanelLayout();

    public PanelLayout getLy_Header() {
        return ly_Header;
    }

    public void setLy_Header(PanelLayout pl) {
        this.ly_Header = pl;
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
    private TextField txt_SpeciesVersion = new TextField();

    public TextField getTxt_SpeciesVersion() {
        return txt_SpeciesVersion;
    }

    public void setTxt_SpeciesVersion(TextField tf) {
        this.txt_SpeciesVersion = tf;
    }
    private TextField txt_Title = new TextField();

    public TextField getTxt_Title() {
        return txt_Title;
    }

    public void setTxt_Title(TextField tf) {
        this.txt_Title = tf;
    }
    private DropDown dp_Language = new DropDown();

    public DropDown getDp_Language() {
        return dp_Language;
    }

    public void setDp_Language(DropDown dd) {
        this.dp_Language = dd;
    }
    private AddRemove ar_audience = new AddRemove();

    public AddRemove getAr_audience() {
        return ar_audience;
    }

    public void setAr_audience(AddRemove ar) {
        this.ar_audience = ar;
    }
    private AddRemove addRemoveList1 = new AddRemove();

    public AddRemove getAddRemoveList1() {
        return addRemoveList1;
    }

    public void setAddRemoveList1(AddRemove ar) {
        this.addRemoveList1 = ar;
    }
    private AddRemove addRemoveList2 = new AddRemove();

    public AddRemove getAddRemoveList2() {
        return addRemoveList2;
    }

    public void setAddRemoveList2(AddRemove ar) {
        this.addRemoveList2 = ar;
    }
    private Listbox listbox1 = new Listbox();

    public Listbox getListbox1() {
        return listbox1;
    }

    public void setListbox1(Listbox l) {
        this.listbox1 = l;
    }
    private Tree tree1 = new Tree();

    public Tree getTree1() {
        return tree1;
    }

    public void setTree1(Tree t) {
        this.tree1 = t;
    }
    private Listbox listbox2 = new Listbox();

    public Listbox getListbox2() {
        return listbox2;
    }

    public void setListbox2(Listbox l) {
        this.listbox2 = l;
    }
    private DefaultOptionsList listbox2DefaultOptions = new DefaultOptionsList();

    public DefaultOptionsList getListbox2DefaultOptions() {
        return listbox2DefaultOptions;
    }

    public void setListbox2DefaultOptions(DefaultOptionsList dol) {
        this.listbox2DefaultOptions = dol;
    }
    private StaticText staticText1 = new StaticText();

    public StaticText getStaticText1() {
        return staticText1;
    }

    public void setStaticText1(StaticText st) {
        this.staticText1 = st;
    }
    private StaticText st_SpeciesName = new StaticText();

    public StaticText getSt_SpeciesName() {
        return st_SpeciesName;
    }

    public void setSt_SpeciesName(StaticText st) {
        this.st_SpeciesName = st;
    }
    private Button btn_save = new Button();

    public Button getBtn_save() {
        return btn_save;
    }

    public void setBtn_save(Button b) {
        this.btn_save = b;
    }
    private Button btn_cancel = new Button();

    public Button getBtn_cancel() {
        return btn_cancel;
    }

    public void setBtn_cancel(Button b) {
        this.btn_cancel = b;
    }
    private Tree tree2 = new Tree();

    public Tree getTree2() {
        return tree2;
    }

    public void setTree2(Tree t) {
        this.tree2 = t;
    }
    private LongConverter longConverter1 = new LongConverter();

    public LongConverter getLongConverter1() {
        return longConverter1;
    }

    public void setLongConverter1(LongConverter lc) {
        this.longConverter1 = lc;
    }
    private DynamicPanelForm dynamicPanelForm = new DynamicPanelForm();

    public HtmlPanelGrid getDynamicPanelForm() {
        return dynamicPanelForm.getPanel();
    }

    public void setDynamicPanelForm(HtmlPanelGrid panel) {
        this.dynamicPanelForm.setPanel(panel);
    }
    private StaticText st_CategoryName = new StaticText();

    public StaticText getSt_CategoryName() {
        return st_CategoryName;
    }

    public void setSt_CategoryName(StaticText st) {
        this.st_CategoryName = st;
    }
    private HtmlMessages messageList1 = new HtmlMessages();

    public HtmlMessages getMessageList1() {
        return messageList1;
    }

    public void setMessageList1(HtmlMessages hm) {
        this.messageList1 = hm;
    }
    private Label label6 = new Label();

    public Label getLabel6() {
        return label6;
    }

    public void setLabel6(Label l) {
        this.label6 = l;
    }
    private DropDown dp_stage = new DropDown();

    public DropDown getDp_stage() {
        return dp_stage;
    }

    public void setDp_stage(DropDown dd) {
        this.dp_stage = dd;
    }
    private Script script1 = new Script();

    public Script getScript1() {
        return script1;
    }

    public void setScript1(Script s) {
        this.script1 = s;
    }
    private Label label7 = new Label();

    public Label getLabel7() {
        return label7;
    }

    public void setLabel7(Label l) {
        this.label7 = l;
    }
    private StaticText st_actualStageName = new StaticText();

    public StaticText getSt_actualStageName() {
        return st_actualStageName;
    }

    public void setSt_actualStageName(StaticText st) {
        this.st_actualStageName = st;
    }
    private Button previewButton = new Button();

    public Button getPreviewButton() {
        return previewButton;
    }

    public void setPreviewButton(Button b) {
        this.previewButton = b;
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
    
    private ImageComponent imageComponent = new ImageComponent();    

    /**
     * @return the imageComponent
     */
    public ImageComponent getImageComponent() {
        return imageComponent;
    }

    /**
     * @param imageComponent the imageComponent to set
     */
    public void setImageComponent(ImageComponent imageComponent) {
        this.imageComponent = imageComponent;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public speciesEdit() {
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
            log("Module speciesEdit Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
        cleanWidgetsArea();
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
        fillHeaderInfo();
        this.initCategoriesTree();
        this.createHierarchyTree();
//        this.loadImages();
    }

    private void fillHeaderInfo() {
        String speciesName = this.getspecies$SpeciesSessionBean().getCurrentTaxon().getDefaultName();
        String speciesVersion = this.getspecies$SpeciesSessionBean().getCurrentTaxonDescription().getTaxonDescriptionPK().getTaxonDescriptionSequence().toString();
        String title = this.getspecies$SpeciesSessionBean().getCurrentTaxonDescription().getTitle();
        String url = this.getspecies$SpeciesSessionBean().getCurrentTaxonDescription().getUrl();
        String stageName = this.getspecies$SpeciesSessionBean().getCurrentTaxonDescription().getTaxonDescriptionStage().getName();

        st_SpeciesName.setText(speciesName);
        this.st_actualStageName.setText(stageName);
        txt_SpeciesVersion.setText(speciesVersion);
        txt_Title.setText(title);
        this.st_actualStageName.setText(stageName);

        this.setAudienceOptions(this.getspecies$SpeciesSessionBean().getAudience());
        this.setAuthorOptions(this.getspecies$SpeciesSessionBean().getAuthor());
        this.setInstitutionOptions(this.getspecies$SpeciesSessionBean().getInstitution());
        this.setTaxonDescriptionStages(this.getspecies$SpeciesSessionBean().getAvailableStage());
        this.setLanguageOptions(this.getspecies$SpeciesSessionBean().getLanguage());
        this.setReferenceOptions(this.getspecies$SpeciesSessionBean().getReference());
        //this.setTaxonHierarchy(this.getAraSessionBean().getTaxonHierarchy());
        this.tree2.setExpanded(true);
    }

    private void initCategoriesTree() {
        // List of nodes
        List treeItems = this.getTree2().getChildren();
        if (treeItems.size() == 0) {
            //asks the DB for the categories with ancestor == 0
            //List categories = TDCFacade.getChilds(Long.parseLong("0"));
            List categories = this.lookupTaxonDescriptionCategoryFacade().getChilds(Long.parseLong("0"));
            treeItems = createTree(treeItems, categories);
        }
    }

    /**
     *Inserts in a tree (or subtree) new items. This is a recursive method
     *in order to mantain the dynamic nature of the management of the categories.
     *The id of the items would be the concatenation of the string "treeNode-"
     * and the database id of each category.
     *
     * @param treeItems List where the new items of the tree should be added
     * @param toBeInsertItems a list of objects with [0]=id, [1]=name and [2]=sequence
     * @return the List of nodes(TreeNode) of the tree
     */
    private List createTree(List treeItems, List toBeInsertItems) {
        final int CATEGORY_ID = 0;
        final int CATEGORY_NAME = 1;
        Object[] item;
        String selectedNode = "";
        String tempNodeId = "";
        for (int i = 0; i < toBeInsertItems.size(); i++) {
            //System.out.println(" en la i="+i+" hay "+toBeInsertItems.size()+" por insertar");
            item = (Object[]) toBeInsertItems.get(i);

            TreeNode itemNode = new TreeNode();
            itemNode.setId("treeNode-" + item[CATEGORY_ID]);
            itemNode.setText((String) item[CATEGORY_NAME]);
            itemNode.setActionExpression(actionMethod);

            tempNodeId = "" + item[CATEGORY_ID];
            /*
            int tmpCategoryId = Integer.parseInt(tempNodeId);
            if (tmpCategoryId == this.getAraSessionBean().getCurrentTaxonDescriptionCategoryId()) {
            itemNode.setExpanded(true);
            selectedNode = itemNode.getId();
            }*/
            treeItems.add(itemNode);
            if (selectedNode != "") {
                //tree2.setSelected(selectedNode);
            }
            //List sonsToBeInserted = TDCFacade.getChilds((Long)item[CATEGORY_ID]);
            List sonsToBeInserted = lookupTaxonDescriptionCategoryFacade().getChilds((Long) item[CATEGORY_ID]);

            if (sonsToBeInserted.size() != 0) {
                List itemNodeSons = itemNode.getChildren();
                createTree(itemNodeSons, sonsToBeInserted);
            }
        }
        return treeItems;
    }

    /**
     * Decides which form has to be set visible
     */
    public String treeItemClickHandler() {
        final int ID_POSITION = 1;

        cleanWidgetsArea();
        String nodeId = tree2.getSelected();
        // Find the tree node component with the given id
        TreeNode clickItem = (TreeNode) this.getForm1().findComponentById(nodeId);
        //TreeNode clickItem = (TreeNode)this.getLayoutPanel1().findComponent(nodeId);
        //(TreeNode) this.getCategoriesTreeForm().findComponentById(nodeId);
        //clickItem.getId() -> "treeNode-#"
        String[] treeNodeIdTokens = clickItem.getId().split("-");
        try {
            int categoryId = Integer.parseInt(treeNodeIdTokens[ID_POSITION]);
            this.st_CategoryName.setText(clickItem.getText());
            TaxonDescriptionCategory taxonDescriptionCategory = this.getspecies$SpeciesSessionBean().getTaxonDescriptionCategory(Long.parseLong(treeNodeIdTokens[ID_POSITION]));
            if (taxonDescriptionCategory != null) {
                if (taxonDescriptionCategory.getRepeatable().equals(0L)) {
                    // La categorúa no usa repeticiones, se dibuja solamente el formulario dinúmico.
                    this.getspecies$SpeciesSessionBean().setCurrentTaxonDescriptionCategoryId(categoryId);
                    this.getspecies$SpeciesSessionBean().setCategoryRepeatable(false);
                    this.saveRecordDataButton.setActionExpression(actionMethod5);
                    selectLeaf(categoryId);
                //this.getAraSessionBean().setIsDynamicFormPanelActive(true);
                } else {
                    // La categor�a usa repeticiones, se dibuja solamente la tabla din�mica.
                    /*
                    dynamicPanelForm.getPanel().getChildren().clear();
                    Button btnAddTemp  = new Button();
                    //btnAddTemp.setAction(getApplication().createMethodBinding("#{species$speciesEdit.btn_AddRecordRow_action}", null));
                    btnAddTemp.setActionExpression(actionMethod4);
                    btnAddTemp.setText("Agregar nuevo");
                    //btnAddTemp.setOnClick("window.open('newTaxonDescriptionRecord.jsp','name','height=510px,width=500px,toolbar=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no ,modal=yes');");
                    dynamicPanelForm.getPanel().getChildren().add(btnAddTemp);
                    dynamicPanelForm.getPanel().getChildren().add(createDynamicTable(categoryId));
                     */
                    this.saveRecordDataButton.setActionExpression(actionMethod6);
                    this.getspecies$SpeciesSessionBean().setCurrentTaxonDescriptionCategoryId(categoryId);
                    this.getspecies$SpeciesSessionBean().setCategoryRepeatable(true);
                    this.drawDynamicTable();
                }
            }
        } catch (NumberFormatException e1) {
            System.err.println(e1.getLocalizedMessage());
        }
        return null;
    }

    private String drawDynamicTable() {
        dynamicPanelForm.getPanel().getChildren().clear();
        Button btnAddTemp = new Button();

        btnAddTemp.setActionExpression(actionMethod4);
        btnAddTemp.setText(ADD_NEW);

        dynamicPanelForm.getPanel().getChildren().add(btnAddTemp);
        dynamicPanelForm.getPanel().getChildren().add(createDynamicTable(this.getspecies$SpeciesSessionBean().getCurrentTaxonDescriptionCategoryId()));
        return null;
    }
    private Table table = new Table();
    private TableRowGroup rowGroup = new TableRowGroup();

    private Table createDynamicTable(int category) {

        Long categoryId = Long.parseLong(Integer.toString(category));
        this.getSaveRecordDataButton().setVisible(false);
        // Obtener los elementos asociados a la categorúa seleccionada
        List<TaxonDescriptionElement> list = getspecies$SpeciesSessionBean().getPVR().getElements(category);
        getspecies$SpeciesSessionBean().initTaxonDescriptionRowDataProvider(categoryId, this.getspecies$SpeciesSessionBean().getCurrentTaxonDescription().getTaxonDescriptionPK().getTaxonId(), this.getspecies$SpeciesSessionBean().getCurrentTaxonDescription().getTaxonDescriptionPK().getTaxonDescriptionSequence());
        // Crear la tabla dinúmica
        table.setId("dynamicElementTable");
        table.setTitle(CATEGORY_ELEMENTS);
        table.setPaginateButton(true);
        table.setPaginationControls(true);

        // Crear el rowGroup dinámico
        rowGroup.setId("rowGroup1");
        rowGroup.setSourceVar("currentRow");
        rowGroup.setValueBinding("sourceData", getApplication().createValueBinding("#{species$SpeciesSessionBean.taxonDescriptionRowDataProvider}"));
        rowGroup.setRows(5);

        // Agregar el rowGroup a la tabla como un elemento hijo.
        table.getChildren().add(rowGroup);
        System.out.println("Elementos a escribir en columnas: " + list.size());
        // Iterar sobre todos los elementos para agregarlos como columnas
        int i = 1;

        // 
        TableColumn tableColumn0 = new TableColumn();
        tableColumn0.setId("tableColumn0");
        tableColumn0.setHeaderText(ID);

        // Add the first table Column to the table row group
        rowGroup.getChildren().add(tableColumn0);

        // Create the Static text and set its value as TRIPID
        StaticText staticText0 = new StaticText();
        staticText0.setValueBinding("text", getApplication().createValueBinding("#{currentRow.value['rowId']}"));
        HiddenField hiddenId = new HiddenField();
        hiddenId.setValueBinding("text", getApplication().createValueBinding("#{currentRow.value['rowId']}"));
        hiddenId.setId("hiddenId");

        // Add the static text to the table column1
        tableColumn0.getChildren().add(staticText0);
        tableColumn0.getChildren().add(hiddenId);


        for (TaxonDescriptionElement element : list) {
            // Create the first table Column
            TableColumn tableColumn1 = new TableColumn();
            tableColumn1.setId("tableColumn" + i);
            tableColumn1.setHeaderText(element.getName());

            // Add the first table Column to the table row group
            rowGroup.getChildren().add(tableColumn1);

            // Create the Static text and set its value as TRIPID
            StaticText staticText1 = new StaticText();
            staticText1.setValueBinding("text", getApplication().createValueBinding("#{currentRow.value['value" + i + "']}"));
            // Add the static text to the table column1
            tableColumn1.getChildren().add(staticText1);
            i++;
        }

        // Create the fourth table Column
        TableColumn tableColumn4 = new TableColumn();
        tableColumn4.setId("tableColumn" + i);
        // Add the fourth table Column to the table row group
        rowGroup.getChildren().add(tableColumn4);

        // Create the button and set its action binding as button1_action
        Button btnEditTemp = new Button();
        btnEditTemp.setId("btnEditTaxonDescriptionRecord");
        btnEditTemp.setText(EDIT);
        btnEditTemp.setActionExpression(actionMethod2);
        tableColumn4.getChildren().add(btnEditTemp);

        /*
        Button btnRemoveTemp  = new Button();        btnRemoveTemp.setId("btnRemoveTaxoDescriptionRecordRow");
        btnRemoveTemp.setText("Eliminar");
        btnRemoveTemp.setValue("Eliminar");
        btnRemoveTemp.setStyleClass("commandExButton");
        MethodBinding mbButton = getApplication().createMethodBinding("#{species$speciesEdit.btn_RemoveRecordRow_action}", null);
        btnRemoveTemp.setAction(mbButton);
         */
        Button btnRemoveTemp = new Button();
        btnRemoveTemp.setText(DELETE);
        btnRemoveTemp.setId("button2");
        //btnRemoveTemp.setAction(getApplication().createMethodBinding("#{species$speciesEdit.btn_RemoveRecordRow_action}", null));
        btnRemoveTemp.setActionExpression(actionMethod3);


        tableColumn4.getChildren().add(btnRemoveTemp);


        /*
        Button btnRemoveTemp  = new Button();
        btnEditTemp.setId("btnRemoveTaxonDescriptionRecord");
        btnRemoveTemp.setText("Eliminar");
        btnRemoveTemp.setActionExpression(actionMethod3);
        tableColumn4.getChildren().add(btnRemoveTemp);
         */
        return table;
    }

    /**
     * sets all forms invisible
     */
    public void cleanWidgetsArea() {
        getSaveRecordDataButton().setVisible(false);
        //this.getAraSessionBean().setIsDynamicFormPanelActive(false);
        this.st_CategoryName.setText("");
    }

    /**
     * Despliega los elementos que pertenecen a una categoria.
     * @param category Categoria seleccionada en el arbol
     * @return null Se queda en la misma pagina y actualiza el formulario 
     * dinamico 
     */
    private String drawDynamicForm(final int category) {
        final Long taxonId = getspecies$SpeciesSessionBean().getCurrentTaxon().getTaxonId();
        List<TaxonDescriptionElement> list = getspecies$SpeciesSessionBean().getPVR().getElements(category);
        Long taxonDescriptionRecordId = 0L;

        if (list.size() > 0) {
            getSaveRecordDataButton().setVisible(true);
        }
        //Establece las columnas, lineas, espacios y borde
        this.setPanelProperties();
        //getSaveRecordDataButton().setVisible(true);
        //En este for se realiza la construccion del panel
        for (TaxonDescriptionElement tde : list) {
            TaxonDescriptionRecord taxonDescriptionRecord;
            Long TDEId = tde.getId();
            Long contentNumber = 0L;
            String elementName = tde.getName();

            TaxonDescription currentTaxonDescription = getspecies$SpeciesSessionBean().getCurrentTaxonDescription();
            /*
            if (this.getAraSessionBean().isCategoryRepeatable()) {
            taxonDescriptionRecord = getAraSessionBean().getTDR().getTaxonDescriptionRecordByRowId(taxonId,currentTaxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence(),TDEId, this.getAraSessionBean().getSelectedTaxonDescriptionRecordSequence());
            } else {
            taxonDescriptionRecord = getAraSessionBean().getTDR().getTaxonDescriptionRecordByTaxonDescription(taxonId,currentTaxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence(),TDEId);
            }*/

            taxonDescriptionRecord = null;
            if (taxonDescriptionRecord != null) {
                dynamicPanelForm.setComponent(HIDDENFIELD, setValueProperty(taxonDescriptionRecord.getId()));
                contentNumber = taxonDescriptionRecord.getContentsNumeric();
                taxonDescriptionRecordId = taxonDescriptionRecord.getId();
            } else {  //si hay un 0 en el hiddenField el TaxonDescr no existe
                dynamicPanelForm.setComponent(HIDDENFIELD, setValueProperty(0));
            }

            //Coloca el TaxonDescriptionElement Id
            dynamicPanelForm.setComponent(HIDDENFIELD, setValueProperty(tde.getId()));
            //Coloca el label
            this.setLabel(elementName);

            //Aqui se debe cargar el hash con las propiedades de los componentes
            //Si NO es nulo el tableName de la instancia TDE
            if (tde.getTableName() != null) {
                if (tde.getTaxonDescriptionDataType().getId() != 15L) {
                    String tableName = tde.getTableName();
                    if (tde.getTableName() == "Reference") {
                        this.getspecies$SpeciesSessionBean().getTaxonDescriptionRecordReference(taxonDescriptionRecordId);
                    }
                    setComponentWithPredifinedInfo(tde, contentNumber);
                } else {

                    if (taxonDescriptionRecordId != 0) {
                        this.getspecies$SpeciesSessionBean().getTaxonDescriptionRecordReference(taxonDescriptionRecordId);
                    }

                    AddRemove tmp = new AddRemove();
                    tmp.setValueBinding("items", getApplication().createValueBinding("#{species$speciesEdit.referenceOptions}"));
                    tmp.setValueBinding("selected", getApplication().createValueBinding("#{species$SpeciesSessionBean.selectedReference}"));
                    tmp.setValueBinding("converter", getApplication().createValueBinding("#{species$speciesEdit.longConverter1}"));
                    tmp.setVertical(true);
                    this.dynamicPanelForm.getPanel().getChildren().add(tmp);

                    System.out.println("AddRemove agregado!");
                }
            } else { //buscar info en taxon_description
                Long componentId = tde.getTaxonDescriptionDataType().getId();
                if (taxonDescriptionRecord != null) {
                    dynamicPanelForm.setComponent(componentId,
                            setValueProperty(taxonDescriptionRecord.getContentsText()));
				
                } else {
                    System.out.println(getspecies$SpeciesSessionBean().getTDR().getMessage());
                    dynamicPanelForm.setComponent(componentId, setValueProperty(""));
                }
            }
        }//Fin de la construccion del panel
        this.getspecies$SpeciesSessionBean().setIsDynamicFormPanelActive(true);
        return null;
    }

    private String selectLeaf(final int category) {
        final Long taxonId = getspecies$SpeciesSessionBean().getCurrentTaxon().getTaxonId();
        List<TaxonDescriptionElement> list = getspecies$SpeciesSessionBean().getPVR().getElements(category);
        Long taxonDescriptionRecordId = 0L;

        if (list.size() > 0) {
            getSaveRecordDataButton().setVisible(true);
        }
        //Establece las columnas, lineas, espacios y borde
        this.setPanelProperties();
        //getSaveRecordDataButton().setVisible(true);
        //En este for se realiza la construccion del panel
        for (TaxonDescriptionElement tde : list) {
            TaxonDescriptionRecord taxonDescriptionRecord;
            Long TDEId = tde.getId();
            Long contentNumber = 0L;
            String elementName = tde.getName();

            TaxonDescription currentTaxonDescription = getspecies$SpeciesSessionBean().getCurrentTaxonDescription();
            if (this.getspecies$SpeciesSessionBean().isCategoryRepeatable()) {
                taxonDescriptionRecord = getspecies$SpeciesSessionBean().getTDR().getTaxonDescriptionRecordByRowId(taxonId, currentTaxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence(), TDEId, this.getspecies$SpeciesSessionBean().getSelectedTaxonDescriptionRecordSequence());
            } else {
                taxonDescriptionRecord = getspecies$SpeciesSessionBean().getTDR().getTaxonDescriptionRecordByTaxonDescription(taxonId, currentTaxonDescription.getTaxonDescriptionPK().getTaxonDescriptionSequence(), TDEId);
            }
            if (taxonDescriptionRecord != null) {
                dynamicPanelForm.setComponent(HIDDENFIELD, setValueProperty(taxonDescriptionRecord.getId()));
                contentNumber = taxonDescriptionRecord.getContentsNumeric();
                taxonDescriptionRecordId = taxonDescriptionRecord.getId();
            } else {  //si hay un 0 en el hiddenField el TaxonDescr no existe
                dynamicPanelForm.setComponent(HIDDENFIELD, setValueProperty(0));
            }

            //Coloca el TaxonDescriptionElement Id
            dynamicPanelForm.setComponent(HIDDENFIELD, setValueProperty(tde.getId()));
            //Coloca el label
            this.setLabel(elementName);

            //Aqui se debe cargar el hash con las propiedades de los componentes
            //Si NO es nulo el tableName de la instancia TDE
            if (tde.getTableName() != null) {
                if (tde.getTaxonDescriptionDataType().getId() != 15L) {
                    String tableName = tde.getTableName();
                    if (tde.getTableName() == "Reference") {
                        this.getspecies$SpeciesSessionBean().getTaxonDescriptionRecordReference(taxonDescriptionRecordId);
                    }
                    setComponentWithPredifinedInfo(tde, contentNumber);
                } else {

                    if (taxonDescriptionRecordId != 0) {
                        this.getspecies$SpeciesSessionBean().getTaxonDescriptionRecordReference(taxonDescriptionRecordId);
                    }

                    AddRemove tmp = new AddRemove();
                    tmp.setValueBinding("items", getApplication().createValueBinding("#{species$speciesEdit.referenceOptions}"));
                    tmp.setValueBinding("selected", getApplication().createValueBinding("#{species$SpeciesSessionBean.selectedReference}"));
                    tmp.setValueBinding("converter", getApplication().createValueBinding("#{species$speciesEdit.longConverter1}"));
                    tmp.setVertical(true);
                    this.dynamicPanelForm.getPanel().getChildren().add(tmp);

                    System.out.println("AddRemove agregado!");
                }
            } else { //buscar info en taxon_description
                Long componentId = tde.getTaxonDescriptionDataType().getId();
                if (taxonDescriptionRecord != null) {
                    dynamicPanelForm.setComponent(componentId,
                            setValueProperty(taxonDescriptionRecord.getContentsText()));
                } else {
                    System.out.println(getspecies$SpeciesSessionBean().getTDR().getMessage());
                    dynamicPanelForm.setComponent(componentId, setValueProperty(""));
                }
            }
        }//Fin de la construccion del panel
        this.getspecies$SpeciesSessionBean().setIsDynamicFormPanelActive(true);
        return null;
    }

    /**
     * Sirve para asignarle las propiedades a diferentes componentes
     * @param value Object que retorna el hash con la llave "value"
     * @return HashMap la propiedad "value" con el objeto asignado.
     */
    private HashMap setValueProperty(Object value) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", value);
        return hashMap;
    }

    private void setLabel(String text) {
        HashMap hash = new HashMap();
        try {
            hash.put("value", ResourceBundle.getBundle("org/inbio/ara/Bundle").
                    getString(text));
        } catch (Exception e) {
            hash.put("value", text);
        }
        dynamicPanelForm.setComponent(LABEL, hash);
        hash.clear();
    }

    private void setPanelProperties() {
        HashMap p = new HashMap();
        dynamicPanelForm.getPanel().getChildren().clear();

        p.put("columns", 4);
        p.put("border", 1);
        p.put("rules", "rows");

        dynamicPanelForm.setPanelProperties(p);
    /*
    dynamicPanelForm.getPanel().getChildren().clear();
    //1) hiddenField_Tid 2) hiddenField_TDEid 3) label 4) graphicalComponent
    dynamicPanelForm.getPanel().setColumns(4);
    dynamicPanelForm.getPanel().setBorder(1);
    dynamicPanelForm.getPanel().setRules("rows");
    dynamicPanelForm.getPanel().setCellspacing("5");
    dynamicPanelForm.getPanel().setCellpadding("5");
     */
    }

    private void setComponentWithPredifinedInfo(TaxonDescriptionElement tde,
            Long contentNumber) {
        HashMap hash = new HashMap();
        Long componentId = tde.getTaxonDescriptionDataType().getId();

        if (MathUtils.isOdd(componentId)) {
            HashMap options = getspecies$SpeciesSessionBean().getPVR().hashMapListBox(tde.getTableName(),
                    tde.getKeyField(), tde.getMainFieldName());
            hash.clear();
            System.out.println("Cont Number " + contentNumber);
            hash.put("value", contentNumber);
            dynamicPanelForm.setComponent(componentId, hash, UI_SELECT_ITEMS, options);
        } else {
            System.err.println("Error en el datatypeId de un TDE");
        }
    }

    private PredefinedValuesRemote lookupTheBean() {
        try {
            Context c = new InitialContext();
            return (PredefinedValuesRemote) c.lookup("PredefinedValuesBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private void saveTaxonDescriptionRecord() {
        ArrayList<TaxonDescriptionRecord> TDRsToSave = new ArrayList();
        List<UIComponent> graphicalComponents = dynamicPanelForm.getPanel().getChildren();
        Language language = new Language();
        language.setLanguageId(1L);
        //
        //*Por cada TaxonDescription se imprime 1) Tid 2) TDE id 3) etiqueta (omitir)
        //*4) el valor del textfield
        //*Se deben conservar el valor del 1 y el 3 para crear un nuevo taxonDesc
        //*o para modificar uno ya existente.
        //
        for (int i = 0; i < graphicalComponents.size(); i++) {
            UIComponent c = graphicalComponents.get(i);
            if ((i % 4) == 0) {
                Long taxonDescriptionRecordId = getIdFromGUIComponent(c);

                //Si el id del TDR es 0 significa q es uno nuevo!
                if (taxonDescriptionRecordId.toString().equals("0")) {
                    TaxonDescriptionRecord TDR = new TaxonDescriptionRecord();
                    TaxonDescriptionElement TDE;
                    try {
                        TDR.setCreatedBy(this.getSessionManager().getUser().getUserName());
                        TDR.setLastModificationBy(this.getSessionManager().getUser().getUserName());
                    } catch (Exception e) {
                        System.err.println("Debe iniciar sesion. " + e.toString());
                    }
                    TDR.setSequence(2L);
                    TDR.setTaxonomicalTimestamp(new Date());
                    TDR.setTaxonDescription(getspecies$SpeciesSessionBean().getCurrentTaxonDescription());
                    i++;
                    c = graphicalComponents.get(i);

                    Long tdeId = getIdFromGUIComponent(c);
                    if (tdeId != null) {
                        TDE = getspecies$SpeciesSessionBean().getTDER().find(tdeId);
                        i += 2;
                        c = graphicalComponents.get(i);
                        try {
                            TDR.setTaxonDescriptionElement(TDE);
                            if (TDE.getTableName() == null) {
                                TDR.setContentsNumeric(0L);
                                TDR.setContentsText(c.getAttributes().get("value").toString());
                                TDRsToSave.add(TDR);
                            } else {
                                Long foreignId = getIdFromGUIComponent(c);
                                if (foreignId != null) {
                                    TDR.setContentsNumeric(foreignId);
                                    TDRsToSave.add(TDR);
                                }
                            }
                        } catch (Exception e) {
                            System.err.println("Error -> " + e.toString() + " " + e.getLocalizedMessage() + " " + e.getMessage());
                        }
                    }
                } else {  //Guardar un TaxonDescription que ya existe -> EDITAR
                    TaxonDescriptionRecord TDR;
                    TaxonDescriptionElement tde = new TaxonDescriptionElement();

                    TDR = getspecies$SpeciesSessionBean().getTDR().find(taxonDescriptionRecordId);
                    if (TDR != null) {
                        System.out.println(TDR.getId());
                    } else {
                        System.err.println("No recupere el TD");
                    }
                    i += 3;
                    c = graphicalComponents.get(i);
                    if (TDR.getContentsNumeric() == 0L) {
                        String modifiedValue =
                                c.getAttributes().get("value").toString();
                        TDR.setContentsText(modifiedValue);
                        TDRsToSave.add(TDR);
                    } else {
                        Long foreignId = getIdFromGUIComponent(c);
                        if (foreignId != null) {
                            TDR.setContentsNumeric(foreignId);
                            TDRsToSave.add(TDR);
                        }
                    }
                }
            }
        }

        try {
            this.getspecies$SpeciesSessionBean().saveTaxonDescriptionRecords(TDRsToSave);
            this.selectLeaf(this.getspecies$SpeciesSessionBean().getCurrentTaxonDescriptionCategoryId());
        } catch (Exception e) {
            //
        }
    }

    public String saveRepeatableRecordData_action() {
        ArrayList<TaxonDescriptionRecord> TDRsToSave = new ArrayList();
        List<UIComponent> graphicalComponents = dynamicPanelForm.getPanel().getChildren();
        Language language = new Language();
        language.setLanguageId(1L);
        //
        //*Por cada TaxonDescription se imprime 1) Tid 2) TDE id 3) etiqueta (omitir)
        //*4) el valor del textfield
        //*Se deben conservar el valor del 1 y el 3 para crear un nuevo taxonDesc
        //*o para modificar uno ya existente.
        //
        for (int i = 0; i < graphicalComponents.size(); i++) {
            UIComponent c = graphicalComponents.get(i);
            if ((i % 4) == 0) {
                Long taxonDescriptionRecordId = getIdFromGUIComponent(c);

                //Si el id del TDR es 0 significa q es uno nuevo!
                if (taxonDescriptionRecordId.toString().equals("0")) {
                    TaxonDescriptionRecord TDR = new TaxonDescriptionRecord();
                    TaxonDescriptionElement TDE;
                    try {
                        TDR.setCreatedBy(this.getSessionManager().getUser().getUserName());
                        TDR.setLastModificationBy(this.getSessionManager().getUser().getUserName());
                    } catch (Exception e) {
                        System.err.println("Debe iniciar sesion. " + e.toString());
                    }
                    TDR.setSequence(this.getspecies$SpeciesSessionBean().getNextSequence());
                    TDR.setTaxonomicalTimestamp(new Date());
                    TDR.setTaxonDescription(getspecies$SpeciesSessionBean().getCurrentTaxonDescription());
                    i++;
                    c = graphicalComponents.get(i);

                    Long tdeId = getIdFromGUIComponent(c);
                    if (tdeId != null) {
                        TDE = getspecies$SpeciesSessionBean().getTDER().find(tdeId);
                        i += 2;
                        c = graphicalComponents.get(i);
                        try {

                            if (TDE.getTaxonDescriptionDataType().getId() == 15L) {
                                // En esta sección se administran las referencias asociadas a un taxonDescriptionRecord
                                this.manageReferences(TDE);
                            } else {
                                // 
                                TDR.setTaxonDescriptionElement(TDE);
                                if (TDE.getTableName() == null) {
                                    TDR.setContentsNumeric(0L);
                                    TDR.setContentsText(c.getAttributes().get("value").toString());
                                    TDRsToSave.add(TDR);
                                } else {
                                    Long foreignId = getIdFromGUIComponent(c);
                                    if (foreignId != null) {
                                        TDR.setContentsNumeric(foreignId);
                                        TDRsToSave.add(TDR);
                                    }
                                }
                            }


                        } catch (Exception e) {
                            System.err.println("Error -> " + e.toString() + " " + e.getLocalizedMessage() + " " + e.getMessage());
                        }
                    }
                }
            }
        }

        try {
            this.getspecies$SpeciesSessionBean().saveTaxonDescriptionRecords(TDRsToSave);
        } catch (Exception e) {
            //
        }
        this.drawDynamicTable();
        return null;
    }

    private void manageReferences(TaxonDescriptionElement taxonDescriptionElement) {
        TaxonDescriptionRecord taxonDescriptionRecord = new TaxonDescriptionRecord();

        taxonDescriptionRecord.setTaxonDescription(this.getspecies$SpeciesSessionBean().getCurrentTaxonDescription());
        taxonDescriptionRecord.setContentsNumeric(0L);
        taxonDescriptionRecord.setContentsText("");
        taxonDescriptionRecord.setCreatedBy(this.getSessionManager().getUser().getUserName());
        taxonDescriptionRecord.setLastModificationBy(this.getSessionManager().getUser().getUserName());
        if (this.getspecies$SpeciesSessionBean().isCategoryRepeatable()) {
            taxonDescriptionRecord.setSequence(this.getspecies$SpeciesSessionBean().getNextSequence());
        } else {
            taxonDescriptionRecord.setSequence(0L);
        }
        taxonDescriptionRecord.setTaxonDescriptionElement(taxonDescriptionElement);
        this.getspecies$SpeciesSessionBean().saveTaxonDescriptionRecord(taxonDescriptionRecord);
    }

    public String saveRecordData_action() {
        ArrayList<TaxonDescriptionRecord> TDRsToSave = new ArrayList();
        List<UIComponent> graphicalComponents = dynamicPanelForm.getPanel().getChildren();
        Language language = new Language();
        language.setLanguageId(1L);
        //
        //*Por cada TaxonDescription se imprime 1) Tid 2) TDE id 3) etiqueta (omitir)
        //*4) el valor del textfield
        //*Se deben conservar el valor del 1 y el 3 para crear un nuevo taxonDesc
        //*o para modificar uno ya existente.
        //
        for (int i = 0; i < graphicalComponents.size(); i++) {
            UIComponent c = graphicalComponents.get(i);
            if ((i % 4) == 0) {
                Long taxonDescriptionRecordId = getIdFromGUIComponent(c);

                //Si el id del TDR es 0 significa q es uno nuevo!
                if (taxonDescriptionRecordId.toString().equals("0")) {
                    TaxonDescriptionRecord TDR = new TaxonDescriptionRecord();
                    TaxonDescriptionElement TDE;
                    try {
                        TDR.setCreatedBy(this.getSessionManager().getUser().getUserName());
                        TDR.setLastModificationBy(this.getSessionManager().getUser().getUserName());
                    } catch (Exception e) {
                        System.err.println("Debe iniciar sesion. " + e.toString());
                    }

                    /*
                    if (this.getAraSessionBean().isCategoryRepeatable()) {
                    TDR.setSequence(this.getAraSessionBean().getNextSequence());
                    } else {
                    TDR.setSequence(0L); // RA: Importante, este valor siempre debe ser 0L para las descripciones asociadas a una categorúa no repetible.
                    }
                     */

                    TDR.setSequence(0L); // RA: Importante, este valor siempre debe ser 0L para las descripciones asociadas a una categorúa no repetible.
                    TDR.setTaxonomicalTimestamp(new Date());
                    TDR.setTaxonDescription(getspecies$SpeciesSessionBean().getCurrentTaxonDescription());
                    i++;
                    c = graphicalComponents.get(i);

                    Long tdeId = getIdFromGUIComponent(c);
                    if (tdeId != null) {
                        TDE = getspecies$SpeciesSessionBean().getTDER().find(tdeId);
                        i += 2;
                        c = graphicalComponents.get(i);
                        try {
                            if (TDE.getTaxonDescriptionDataType().getId() == 15L) {
                                // En esta sección se administran las referencias asociadas a un taxonDescriptionRecord
                                this.manageReferences(TDE);
                            } else {
                                TDR.setTaxonDescriptionElement(TDE);
                                if (TDE.getTableName() == null) {
                                    TDR.setContentsNumeric(0L);
                                    TDR.setContentsText(c.getAttributes().get("value").toString());
                                    TDRsToSave.add(TDR);
                                } else {
                                    Long foreignId = getIdFromGUIComponent(c);
                                    if (foreignId != null) {
                                        TDR.setContentsNumeric(foreignId);
                                        TDRsToSave.add(TDR);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.err.println("Error -> " + e.toString() + " " + e.getLocalizedMessage() + " " + e.getMessage());
                        }
                    }
                } else {  //Guardar un TaxonDescription que ya existe -> EDITAR
                    TaxonDescriptionRecord TDR;
                    TaxonDescriptionElement tde = new TaxonDescriptionElement();

                    TDR = getspecies$SpeciesSessionBean().getTDR().find(taxonDescriptionRecordId);
                    if (TDR != null) {
                        System.out.println(TDR.getId());
                    } else {
                        System.err.println("No recupere el TD");
                    }
                    i += 3;
                    c = graphicalComponents.get(i);
                    if (TDR.getContentsNumeric() == 0L) {
                        String modifiedValue =
                                c.getAttributes().get("value").toString();
                        TDR.setContentsText(modifiedValue);
                        TDRsToSave.add(TDR);
                    } else {
                        Long foreignId = getIdFromGUIComponent(c);
                        if (foreignId != null) {
                            TDR.setContentsNumeric(foreignId);
                            TDRsToSave.add(TDR);
                        }
                    }
                }
            }
        }

        try {
            this.getspecies$SpeciesSessionBean().saveTaxonDescriptionRecords(TDRsToSave);
        //this.selectLeaf(this.getAraSessionBean().getCurrentTaxonDescriptionCategoryId());
        } catch (Exception e) {
            //
        }

        if (this.getspecies$SpeciesSessionBean().isCategoryRepeatable()) {
            this.saveRecordDataButton.setActionExpression(actionMethod6);
            this.drawDynamicTable();
        }
        return null;
    }

    private Long getIdFromGUIComponent(UIComponent comp) {
        try {
            return Long.parseLong(comp.getAttributes().get("value").toString());
        } catch (NumberFormatException e) {
            System.err.println("ID invalido: " + e.getLocalizedMessage());
        } catch (Exception e) {
        }
        return null;
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
        return (AudienceSessionBean) getBean("audience$AudienceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected PersonSessionBean getadmin$person$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$person$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GroupSessionBean getgroup$GroupSessionBean() {
        return (GroupSessionBean) getBean("group$GroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean) getBean("AraRequestBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (SpeciesSessionBean) getBean("species$SpeciesSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
        return (ProfileSessionBean) getBean("admin$profile$ProfileSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected UserSessionBean getuser$UserSessionBean() {
        return (UserSessionBean) getBean("user$UserSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean) getBean("AraApplicationBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
        return (InstitutionSessionBean) getBean("admin$institution$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpeciesTabular getNIUS$SpeciesTabular() {
        return (SpeciesTabular) getBean("NIUS$SpeciesTabular");
    }

    public Option[] getAudienceOptions() {
        return audienceOptions;
    }

    public void setAudienceOptions(Option[] audienceOptions) {
        this.audienceOptions = audienceOptions;
    }

    public Option[] getAuthorOptions() {
        return authorOptions;
    }

    public void setAuthorOptions(Option[] authorOptions) {
        this.authorOptions = authorOptions;
    }

    public Option[] getInstitutionOptions() {
        return institutionOptions;
    }

    public void setInstitutionOptions(Option[] institutionOptions) {
        this.institutionOptions = institutionOptions;
    }

    public String tab_Descriptions_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public String tab_Audiences_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public Option[] getTaxonDescriptionStages() {
        return taxonDescriptionStages;
    }

    public void setTaxonDescriptionStages(Option[] taxonDescriptionStages) {
        this.taxonDescriptionStages = taxonDescriptionStages;
    }

    public Option[] getLanguageOptions() {
        return languageOptions;
    }

    public void setLanguageOptions(Option[] languageOptions) {
        this.languageOptions = languageOptions;
    }

    public String tab_Authors_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public String tab_Institutions_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public String btn_cancel_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.getspecies$SpeciesSessionBean().setCurrentTaxonDescriptionCategoryId(-1);
        return "cancelSpeciesEdit";
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean) getBean("references$ReferenceSessionBean");
    }

    public Option[] getTaxonHierarchy() {
        return taxonHierarchy;
    }

    public void setTaxonHierarchy(Option[] taxonHierarchy) {
        this.taxonHierarchy = taxonHierarchy;
    }

    public void createHierarchyTree() {
        tree1.setExpanded(true);
        List children = this.getTree1().getChildren();
        if (children.size() == 0) {
            List<Taxon> taxonList = this.getspecies$SpeciesSessionBean().getHierarchy();
            for (int i = taxonList.size() - 1; i >= 0; i--) {
                Taxon tmp = taxonList.get(i);
                TreeNode currentNode = new TreeNode();
                currentNode.setId("treeNode-" + tmp.getTaxonId().toString());
                currentNode.setText(tmp.getDefaultName() + " (" + tmp.getTaxonomicalRange().getName() + ")");
                currentNode.setExpanded(true);
                children.add(currentNode);
                children = currentNode.getChildren();
            }
        /*for (Taxon tmp: taxonList) {
        TreeNode currentNode = new TreeNode();
        currentNode.setId("treeNode-" + tmp.getTaxonId().toString());
        currentNode.setText(tmp.getDefaultName());
        children.add(currentNode);
        children = currentNode.getChildren();
        }*/
        }
    }

    private boolean validate() {
        boolean ok = true;
        if (this.txt_SpeciesVersion.getValue() == null) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_VERSION);
            //getspecies$SpeciesSessionBean().addErrorMessage("Falta el número de registro o versión");
            ok = false;
        }
        Long languageId = Long.parseLong(this.dp_Language.getValue().toString());
        if (languageId == -1L) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_LANGUAGE);
            //getspecies$SpeciesSessionBean().addErrorMessage("Falta el lenguaje");
            ok = false;
        }
        if (this.dp_stage.getValue() == null) {
            this.getutil$MessageBean().addErrorMessage(EMPTY_STAGE);
            //getspecies$SpeciesSessionBean().addErrorMessage("Falta la etapa");
            ok = false;
        }
        return ok;
    }

    public String btn_save_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        if (validate()) {
            TaxonDescription taxonDescription = getspecies$SpeciesSessionBean().getCurrentTaxonDescription();

            taxonDescription.setLanguage(this.getspecies$SpeciesSessionBean().getLanguage((Long) this.dp_Language.getSelected()));
            taxonDescription.setTaxonDescriptionStage(this.getspecies$SpeciesSessionBean().getStage(1L));

            String userName = this.getSessionManager().getUser().getUserName();
            taxonDescription.setLastModificationBy(userName);

            if (this.txt_Title.getValue() != null) {
                taxonDescription.setTitle((String) txt_Title.getValue());
            }
            if (getspecies$SpeciesSessionBean().update(taxonDescription)) {
                /*
                if (this.getAraSessionBean().isIsDynamicFormPanelActive()) {
                this.saveTaxonDescriptionRecord();
                this.getAraSessionBean().setIsDynamicFormPanelActive(false);
                }*/
                return null;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public String btn_AddRecordRow_action() {
        cleanWidgetsArea();
        //selectLeaf(this.getAraSessionBean().getCurrentTaxonDescriptionCategoryId());
        this.drawDynamicForm(this.getspecies$SpeciesSessionBean().getCurrentTaxonDescriptionCategoryId());
        return null;
    }

    public String btn_EditRecordRow_action() {
        this.saveRecordDataButton.setActionExpression(actionMethod5);
        Long rowId = (Long) getValue("#{currentRow.value[\'rowId\']}");
        this.getspecies$SpeciesSessionBean().setSelectedTaxonDescriptionRecordSequence(rowId);
        selectLeaf(this.getspecies$SpeciesSessionBean().getCurrentTaxonDescriptionCategoryId());
        return null;
    }

    public String btn_RemoveRecordRow_action() {
        Long rowId = (Long) getValue("#{currentRow.value[\'rowId\']}");
        this.getspecies$SpeciesSessionBean().deleteTaxonDescriptionRecordRow(rowId);
        this.drawDynamicTable();
        return null;
    }
    private Button saveRecordDataButton = new Button();

    public Button getSaveRecordDataButton() {
        return saveRecordDataButton;
    }

    public void setSaveRecordDataButton(Button b) {
        this.saveRecordDataButton = b;
    }

    public String saveRecordDataButton_action() {
        // TODO: Replace with your code

        return null;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected searchPerson getadmin$person$searchPerson() {
        return (searchPerson) getBean("admin$person$searchPerson");
    }

    private TaxonDescriptionCategoryFacadeRemote lookupTaxonDescriptionCategoryFacade() {
        try {
            Context c = new InitialContext();
            return (TaxonDescriptionCategoryFacadeRemote) c.lookup("TaxonDescriptionCategoryFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.SessionBean1 getSessionBean1() {
        return (org.inbio.ara.web.SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.ApplicationBean1 getApplicationBean1() {
        return (org.inbio.ara.web.ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.RequestBean1 getRequestBean1() {
        return (org.inbio.ara.web.RequestBean1) getBean("RequestBean1");
    }

    public String previewButton_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return "case2";
    }

    public String tab_stages_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public String tab_TaxonomicalHierarchy_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public String tab_NomenclaturalGroups_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        return null;
    }

    public Option[] getReferenceOptions() {
        return referenceOptions;
    }

    public void setReferenceOptions(Option[] referenceOptions) {
        this.referenceOptions = referenceOptions;
    }

    public MethodExpression getActionMethod4() {
        return actionMethod4;
    }

    public void setActionMethod4(MethodExpression actionMethod4) {
        this.actionMethod4 = actionMethod4;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected borrar getNIUS$borrar() {
        return (borrar) getBean("NIUS$borrar");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean) getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.util.SelectionListBean getutil$SelectionListBean() {
        return (org.inbio.ara.web.util.SelectionListBean) getBean("util$SelectionListBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
        return (GatheringSessionBeanV2) getBean("gathering$GatheringSessionBeanV2");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected newTaxonDescriptionRecord getspecies$newTaxonDescriptionRecord() {
        return (newTaxonDescriptionRecord) getBean("species$newTaxonDescriptionRecord");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.gathering.GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (org.inbio.ara.web.gathering.GatheringDetailSessionBean) getBean("gathering$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.gathering.SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
        return (org.inbio.ara.web.gathering.SpecimenGenerationSessionBean) getBean("gathering$SpecimenGenerationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.identification.IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (org.inbio.ara.web.identification.IdentificationSessionBean) getBean("identification$IdentificationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.site.SiteSessionBean getsite$SiteSessionBean() {
        return (org.inbio.ara.web.site.SiteSessionBean) getBean("site$SiteSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected NomenclaturalGroupSessionBean getnomenclaturalgroup$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean) getBean("nomenclaturalgroup$NomenclaturalGroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected IdentificationSearchSessionBean getidentification$IdentificationSearchSessionBean() {
        return (IdentificationSearchSessionBean) getBean("identification$IdentificationSearchSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpecimenSessionBean getspecimen$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("specimen$SpecimenSessionBean");
    }

    public void ar_audience_processValueChange(ValueChangeEvent vce) {
        // TODO: Replace with your code
    }
/*
    private void loadImages() {
        long TAXONOMICAL_RANGE_KINGDOM = 1;
        long TAXONOMICAL_RANGE_SPECIE = 18;
        String kingdom = "Plantae";
        String scName = "Iresine%20diffusa";
 * */
   /* hesquivel Este codigo esta bien pero para probar el parser los voy a comentar
        List<Taxon> hierarchy = getspecies$SpeciesSessionBean().getHierarchy();
        for (Taxon taxon : hierarchy) {
        if(taxon.getTaxonomicalRange().getId() == TAXONOMICAL_RANGE_KINGDOM)
        kingdom = taxon.getDefaultName();
        else if(taxon.getTaxonomicalRange().getId() == TAXONOMICAL_RANGE_SPECIE)
        ScName =  taxon.getDefaultName().replace(" ", "%20");
    }*/
	/*
        String URL_QUERY = "http://10.0.1.227:8080/m3sINBio/getInfo?taxonomy=" + scName + "&kingdom=" + kingdom;
        System.out.println(URL_QUERY);
        AraDOMParser ADP = new AraDOMParser(URL_QUERY);
        //int[] mediaIds = ADP.processDocument(scName, kingdom);
        int[][] mediaIds = {{100162,1}, {100163,2}, {100164,3}, {100165,1}, {100166,2}};
        this.imagesPanel.getChildren().clear();
        for (int[] i : mediaIds) {
            System.out.println("id  " + i[0]);
            System.out.println("cat " + i[1]);
            //urlList.add("http://10.0.1.227:8080/m3sINBio/getImage?size=thumb&id="+i);
            ImageComponent type = new ImageComponent();
            if(i[1] == Category.IMAGE.getValue())
                type.setUrl("http://larus.inbio.ac.cr/m3sINBio/images/emblem-camera.png");
            if(i[1] == Category.VIDEO.getValue())
                type.setUrl("http://larus.inbio.ac.cr/m3sINBio/images/emblem-multimedia.png");
            if(i[1] == Category.AUDIO.getValue())
                type.setUrl("http://larus.inbio.ac.cr/m3sINBio/images/emblem-multimedia.png");
            ImageComponent img = new ImageComponent();
            img.setUrl("http://larus.inbio.ac.cr/m3sINBio/getImage?size=thumb&id="+i[0]);
            this.imagesPanel.getChildren().add(type);
            this.imagesPanel.getChildren().add(img);
            this.imagesPanel.getChildren().add(new com.sun.webui.jsf.component.Checkbox());
        }
    }
*/
    
    public enum Category {
        IMAGE (1),
        AUDIO (2),
        VIDEO (3);

        private int value;

        Category(int i) { value = i; }

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }
    }

    public String btn_associate_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        info(ResourceBundle.getBundle(BundleHelper.getDefaultBundle(), getFacesContext().getViewRoot().getLocale()).
                    getString("save_success"));
        return null;
    }

}

