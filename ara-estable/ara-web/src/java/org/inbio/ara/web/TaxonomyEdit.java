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
 * TaxonomyEdit.java
 *
 * Created on November 26, 2007, 6:05 PM
 * Copyright mvargas
 */
package org.inbio.ara.web;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.component.Tree;
import com.sun.webui.jsf.component.TreeNode;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.collection.CollectionRemote;
import org.inbio.ara.facade.taxonomy.TaxonCategoryRemote;
import org.inbio.ara.facade.taxonomy.TaxonomicalRangeRemote;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.persistence.taxonomy.TaxonCategory;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRange;
import org.inbio.ara.taxon.service.TaxonServiceRemote;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.converters.CollectionsConverter;
import org.inbio.ara.web.gathering.identificationGenerationFragment;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.species.newTaxonDescriptionRecord;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.util.BundleHelper;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TaxonomyEdit extends AbstractPageBean {
	
	public static final String ADD = BundleHelper.getDefaultBundleValue("add");
	public static final String CLASS = BundleHelper.getDefaultBundleValue("class");
	public static final String DELETE = BundleHelper.getDefaultBundleValue("delete");
	public static final String DOMINIUM = BundleHelper.getDefaultBundleValue("dominium");
	public static final String FAMILY = BundleHelper.getDefaultBundleValue("family");
	public static final String FILUM = BundleHelper.getDefaultBundleValue("filum");
	public static final String GENUS = BundleHelper.getDefaultBundleValue("genus");
	public static final String KINGDOM = BundleHelper.getDefaultBundleValue("kingdom");
	public static final String ORDER = BundleHelper.getDefaultBundleValue("order");
	public static final String SPECIE = BundleHelper.getDefaultBundleValue("specie");
    List kingdomChildren  = null;
    List phylumChildren   = null;
    List classChildren    = null;
    List orderChildren    = null;
    List familyChildren   = null;
    List genusChildren    = null;
    List speciesChildren  = null;

    //jgutierez
    //FIXME: esto no tiene porque estar aca....
   private DropDown collectionsListDropDown = new DropDown();
    /** Datos del DropDown **/
    private SingleSelectOptionsList collectionsListDropDownData = new SingleSelectOptionsList();
    @EJB
    private CollectionRemote collectionManager;
    
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

    private ArrayList taxaList = new ArrayList(); 
    
    private Tree displayTree = new Tree();

    public Tree getDisplayTree() {
        return displayTree;
    }

    public void setDisplayTree(Tree t) {
        this.displayTree = t;
    }

    private Button button1 = new Button();

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button b) {
        this.button1 = b;
    }

    private TextField textField1 = new TextField();

    public TextField getTextField1() {
        return textField1;
    }

    public void setTextField1(TextField tf) {
        this.textField1 = tf;
    }

    private Button button2 = new Button();

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button b) {
        this.button2 = b;
    }

    private Button btn_cancel = new Button();

    public Button getBtn_cancel() {
        return btn_cancel;
    }

    public void setBtn_cancel(Button b) {
        this.btn_cancel = b;
    }

    private Label label1 = new Label();

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label l) {
        this.label1 = l;
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
    public TaxonomyEdit() {
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
            log("Module TaxonomyEdit Initialization Failure", e);
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
     * Create the MethodExpressions for the tree nodes
     */
    ExpressionFactory expressionFactory = this.getApplication().getExpressionFactory();
    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    
    
    MethodExpression actionMethod = expressionFactory.createMethodExpression(elContext, "#{TaxonomyEdit.treeItemClickHandler}", String.class, new Class[] {});    
    

    public void initTaxaList() {
        getspecies$SpeciesSessionBean().clearTaxaList();
        getspecies$SpeciesSessionBean().getTaxaList().addAll(getspecies$SpeciesSessionBean().getTaxonDataProvider().getTheTopTaxon(1));
    }
    
    public void addToTaxaList(List list) {
        taxaList.addAll(list);
    }
    
    public void addToTaxaList(int pos, List list) {
        taxaList.addAll(pos, list);
    }    
    
    public int getTaxaListSize() {
        return taxaList.size();
    }
    
    public int indexOf(long taxonId) {
        int pos = -1;
        System.out.println("Size of indexOf: " + getTaxaListSize());
        
        for (int i=0, n=getTaxaListSize(); i < n; i++) {
            Object [] names = (Object[]) taxaList.get(i);

            
            System.out.println("indexOf pos " + i + " = " + ((Long) names[1]).longValue());
            if (((Long) names[1]).longValue() == taxonId) {                    
                pos = i;
            }
        }
        
        System.out.println("indexOf: " + pos);
        return pos;
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
        try {
            // Set up the variables we will need
            // If nbrChildren is not 0 then this is a
            // postback and we have our tree already
            
            int nbrChildren = displayTree.getChildCount();
            if (nbrChildren == 0) {
                System.out.println("nbrChildren == 0");
                initTaxaList();
            }

            renderTree(); 
            System.out.println("Tamaño de TaxaList al salir de prerender: " + getspecies$SpeciesSessionBean().getTaxaListSize());
        } catch (Exception ex) {
            log("Exception gathering tree data", ex);
            error("Exception gathering tree data: " + ex);
        }

        //testf
        setAllCollections();
    }        
    
    
    public void renderTree() {
        try {
            // Set up the variables we will need
            Long currentDominiumId = new Long(-1);
            Long currentKingdomId  = new Long(-1);
            Long currentPhylumId   = new Long(-1);
            Long currentClassId    = new Long(-1);       
            Long currentOrderId    = new Long(-1); 
            Long currentFamilyId   = new Long(-1); 
            Long currentGenusId    = new Long(-1); 
            Long currentSpeciesId  = new Long(-1); 
            // If nbrChildren is not 0 then this is a
            // postback and we have our tree already
            int nbrChildren = displayTree.getChildCount();
            System.out.println("nbrChildren en renderTree: " + nbrChildren);
            
            // if (nbrChildren == 0) {
                // List of outer (dominium) nodes
                List dominiumChildren = displayTree.getChildren();
                // Erase previous contents
                dominiumChildren.clear();
                // List of inner (kingdom, class) nodes


                System.out.println("Tamaño de TaxaList al inicio de renderTree: " + getspecies$SpeciesSessionBean().getTaxaListSize());
                
                for (int i=0, n=getspecies$SpeciesSessionBean().getTaxaListSize(); i < n; i++) {
                    // Object [] names = (Object[]) taxaList.get(i);
                    // Object [] names = (Object[]) getAraSessionBean().getTaxaListElement(i);
                    Object [] names = (Object[]) getspecies$SpeciesSessionBean().getTaxaList().get(i);

                    if (((Long) names[0]) == 23) {                    
                        Long newDominiumId = (Long) names[1];
                        // System.out.println("Nivel de dominio");
                        
                        if (!newDominiumId.equals(currentDominiumId)) {
                            currentDominiumId = newDominiumId;
                            TreeNode dominiumNode = new TreeNode();
                            dominiumNode.setId("dom" + newDominiumId.toString());
                            dominiumNode.setText((String) names[2] + " " + DOMINIUM);
                            dominiumNode.setActionExpression(actionMethod);
                            dominiumNode.setVisible(true);
                            dominiumNode.setExpanded(true);
                            System.out.println("Acabo de expander el dominio");

                            dominiumChildren.add(dominiumNode);
                            kingdomChildren = dominiumNode.getChildren();
                        }
                    }
                    
                    
                    if (((Long) names[0]) == 1) {
                        Long newKingdomId  = (Long) names[1];      
                        // System.out.println("Nivel de reino");                    

                        if (!newKingdomId.equals(currentKingdomId)) {
                            // Create a new kingdom node
                            currentKingdomId = newKingdomId;
                            TreeNode kingdomNode = new TreeNode();
                            kingdomNode.setId("kin" + newKingdomId.toString());
                            kingdomNode.setText((String) names[2]  + " " + KINGDOM);
                            kingdomNode.setActionExpression(actionMethod);
                            kingdomNode.setVisible(true);
                            kingdomNode.setExpanded(true);

                            kingdomChildren.add(kingdomNode);
                            phylumChildren = kingdomNode.getChildren();
                        }
                    }
                    
                    if (((Long) names[0]) == 2) {
                        Long newPhylumId   = (Long) names[1];                    
                        // System.out.println("Nivel de filo/division");

                        if (!newPhylumId.equals(currentPhylumId)) {
                            // Create a new phylum node
                            currentPhylumId = newPhylumId;
                            TreeNode phylumNode = new TreeNode();
                            phylumNode.setId("phy" + newPhylumId.toString());
                            phylumNode.setText((String) names[2] + " " + FILUM);
                            phylumNode.setActionExpression(actionMethod);
                            phylumNode.setVisible(true);
                            phylumNode.setExpanded(true);

                            phylumChildren.add(phylumNode);        
                            classChildren = phylumNode.getChildren();
                        }      
                    }
                    
                    if (((Long) names[0]) == 4) {
                        Long newClassId    = (Long) names[1];                    
                        // System.out.println("Nivel de clase");

                        if (!newClassId.equals(currentClassId)) {
                            // Create a new class node
                            currentClassId = newClassId;
                            TreeNode classNode = new TreeNode();
                            classNode.setId("cla" + newClassId.toString());
                            classNode.setText((String) names[2] + " " + CLASS);
                            classNode.setActionExpression(actionMethod);
                            classNode.setExpanded(true);

                            classChildren.add(classNode);
                            orderChildren = classNode.getChildren();
                        }
                    }                    
                    
                    if (((Long) names[0]) == 6) {
                        Long newOrderId    = (Long) names[1];                    
                        // System.out.println("Nivel de orden");

                        if (!newOrderId.equals(currentOrderId)) {
                            // Create a new order node
                            currentOrderId = newOrderId;
                            TreeNode orderNode = new TreeNode();
                            orderNode.setId("ord" + newOrderId.toString());
                            orderNode.setText((String) names[2] + " " + ORDER);
                            orderNode.setActionExpression(actionMethod);
                            orderNode.setExpanded(true);

                            orderChildren.add(orderNode);
                            familyChildren = orderNode.getChildren();
                        }                       
                    } 
                    
                    if (((Long) names[0]) == 9) {                    
                        Long newFamilyId   = (Long) names[1];                    
                        // System.out.println("Nivel de familia");

                        if (!newFamilyId.equals(currentFamilyId)) {
                            // Create a new Family node
                            currentFamilyId = newFamilyId;
                            TreeNode familyNode = new TreeNode();
                            familyNode.setId("fam" + newFamilyId.toString());
                            familyNode.setText((String) names[2] + " " + FAMILY);
                            familyNode.setActionExpression(actionMethod);
                            familyNode.setExpanded(true);

                            familyChildren.add(familyNode);
                            genusChildren = familyNode.getChildren();
                        } 
                    }                    
                    
                    if (((Long) names[0]) == 13) {
                        Long newGenusId    = (Long) names[1];                    
                        // System.out.println("Nivel de genero");

                        if (!newGenusId.equals(currentGenusId)) {
                            // Create a new Genus node
                            currentGenusId = newGenusId;
                            TreeNode genusNode = new TreeNode();
                            genusNode.setId("gen" + newGenusId.toString());
                            genusNode.setText((String) names[2] + " " + GENUS);
                            genusNode.setActionExpression(actionMethod);
                            genusNode.setExpanded(true);

                            genusChildren.add(genusNode);
                            speciesChildren = genusNode.getChildren();
                        } 
                    }                    
                    
                    if (((Long) names[0]) == 18) {
                        Long newSpeciesId  = (Long) names[1];
                        // System.out.println("Nivel de especie");
                        
                        if (!newSpeciesId.equals(currentSpeciesId)) {
                            // Create a new Species node
                            currentSpeciesId = newSpeciesId;
                            TreeNode speciesNode = new TreeNode();
                            speciesNode.setId("spe" + newSpeciesId.toString());
                            speciesNode.setText((String) names[2] + " " + SPECIE);
                            speciesNode.setActionExpression(actionMethod);

                            speciesChildren.add(speciesNode);
                        }
                    }                    
                    
                    
                }
                
                System.out.println("Tamano de TaxaList al salir de renderTree: " + getspecies$SpeciesSessionBean().getTaxaListSize());
            // }
        } catch (Exception ex) {
            log("Exception gathering tree data", ex);
            error("Exception gathering tree data: " + ex);
        }         
        
    }
    
    public String expandTreeItem(long taxonId) {
        String taxonLevelName  = "";

        int pos = -1;        
        for (int i=0, n=getspecies$SpeciesSessionBean().getTaxaListSize(); i < n; i++) {
            Object [] names = (Object[]) getspecies$SpeciesSessionBean().getTaxaList().get(i);
            
            System.out.println("indexOf pos " + i + " = " + ((Long) names[1]).longValue());
            if (((Long) names[1]).longValue() == taxonId) {                    
                pos = i;
                break;
            }
        }        
        
        if (pos != -1) {
            System.out.println("pos=" + pos + "   taxon=" + taxonId);
            getspecies$SpeciesSessionBean().getTaxaList().addAll(pos + 1, getspecies$SpeciesSessionBean().getTaxonDataProvider().getTheSons(taxonId));
        }

        
        Taxon selectedTaxon = lookupTaxonServiceBean().findTaxonById(taxonId);            
        Long selectedTaxonRange = selectedTaxon.getTaxonomicalRange().getId();

        if (selectedTaxonRange == 23) {
            taxonLevelName = KINGDOM;
            button1.setText(ADD + " " + taxonLevelName);
            button1.setDisabled(false);
        } else if (selectedTaxonRange == 1) {
            taxonLevelName = FILUM;
            button1.setText(ADD + " " + taxonLevelName);
            button1.setDisabled(false);
        } else if (selectedTaxonRange == 2) {
            taxonLevelName = CLASS;
            button1.setText(ADD + " " + taxonLevelName);
            button1.setDisabled(false);
        } else if (selectedTaxonRange == 4) {
            taxonLevelName = ORDER;
            button1.setText(ADD + " " + taxonLevelName);
            button1.setDisabled(false);
        } else if (selectedTaxonRange == 6) {
            taxonLevelName = FAMILY;
            button1.setText(ADD + " " + taxonLevelName);
            button1.setDisabled(false);
        } else if (selectedTaxonRange == 9) {
            taxonLevelName = GENUS;
            button1.setText(ADD + " " + taxonLevelName);
            button1.setDisabled(false);
        } else if (selectedTaxonRange == 13) {
            taxonLevelName = SPECIE;
            button1.setText(ADD + " " + taxonLevelName);
            button1.setDisabled(false);
        } else if (selectedTaxonRange == 18) {            
            button1.setText(ADD + " " + taxonLevelName);
            button1.setDisabled(true);
        }
        
        button2.setText(DELETE);
        
        if (lookupTaxonServiceBean().getChildCount(taxonId) == 0) {
            button2.setText(DELETE  + selectedTaxon.getDefaultName());
            button2.setDisabled(false);
        } else {
            button2.setDisabled(true);
        }


        //esto no debería estar aca...
        //FIXME:tiene un pulgón
        if(selectedTaxon.getCollection().getId() != null)
            this.collectionsListDropDownData.setSelectedValue(selectedTaxon.getCollection().getId());
        this.collectionsListDropDown.setDisabled(false);


        return null;
    }
    
    
    public String treeItemClickHandler(){        
        String nodeId          = displayTree.getSelected();
        String selectedTaxonId = nodeId.substring(3);
        
        return expandTreeItem(Long.parseLong(selectedTaxonId));
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
        Taxon newTaxon = new Taxon();
        
        String currentName;
        currentName = (String) textField1.getText();
        newTaxon.setCurrentName(currentName);
        
        newTaxon.setCreatedBy("roagullar");
        newTaxon.setLastModificationBy("roagullar");
        
        Date currentDate;        
        currentDate = new Date();
        newTaxon.setCurrentNameTimestamp(currentDate);
        System.out.println(currentDate);
        
        String defaultName;
        defaultName = (String) textField1.getText();
        newTaxon.setDefaultName(defaultName);
        
        TaxonCategory currentTaxonCategory;
        currentTaxonCategory = lookupTaxonCategoryBean().findTaxonCategoryById(new Long(1));
        newTaxon.setTaxonCategory(currentTaxonCategory);
        System.out.println(currentTaxonCategory.getName());
        
        newTaxon.setAuthorFormatParenthesis(new Long(1));

        String nodeId = displayTree.getSelected();
        String selectedTaxonId = nodeId.substring(3);

        Taxon selectedTaxon = lookupTaxonServiceBean().findTaxonById(new Long(selectedTaxonId));            
        Long selectedTaxonRange = selectedTaxon.getTaxonomicalRange().getId();

        newTaxon.setAncestor(selectedTaxon);

        // jgutierrez:
        //FIXME: esta clase necesita refactoring urgente: mucha de la lógica que está acá,
        //debería ocurrir en otras clases.
        //sets the collection
                //esto no debería estar aca...
        Long collectionId = Long.valueOf((String) this.getCollectionsListDropDownData().getSelectedValue());
        Collection collection = collectionManager.getCollection(collectionId);
        newTaxon.setCollection(collection);
        
        TaxonomicalRange newTaxonRange;        

        if (selectedTaxonRange == 23) {
            newTaxonRange = lookupTaxonomicalRangeBean().findTaxonomicalRangeById(new Long(1));
            newTaxon.setTaxonomicalRange(newTaxonRange);
            
            
            Taxon newTaxonDominium = lookupTaxonServiceBean().findTaxonById(new Long(selectedTaxonId));
            newTaxon.setDominiumTaxon(newTaxonDominium);
        } else if (selectedTaxonRange == 1) {
            newTaxonRange = lookupTaxonomicalRangeBean().findTaxonomicalRangeById(new Long(2));
            newTaxon.setTaxonomicalRange(newTaxonRange);
            
            Taxon newTaxonKingdom = lookupTaxonServiceBean().findTaxonById(new Long(selectedTaxonId));
            newTaxon.setKingdomTaxon(newTaxonKingdom);
            
            
            Taxon newTaxonDominium = lookupTaxonServiceBean().findTaxonById(newTaxonKingdom.getDominiumTaxon().getTaxonId());
            newTaxon.setDominiumTaxon(newTaxonDominium);
        } else if (selectedTaxonRange == 2) {
            newTaxonRange = lookupTaxonomicalRangeBean().findTaxonomicalRangeById(new Long(4));
            newTaxon.setTaxonomicalRange(newTaxonRange);

            Taxon newTaxonPhylumDivision = lookupTaxonServiceBean().findTaxonById(new Long(selectedTaxonId));
            newTaxon.setPhylumDivisionTaxon(newTaxonPhylumDivision);
            
            
            
            Taxon newTaxonKingdom = lookupTaxonServiceBean().findTaxonById(newTaxonPhylumDivision.getKingdomTaxon().getTaxonId());
            newTaxon.setKingdomTaxon(newTaxonKingdom);
            
            Taxon newTaxonDominium = lookupTaxonServiceBean().findTaxonById(newTaxonPhylumDivision.getDominiumTaxon().getTaxonId());
            newTaxon.setDominiumTaxon(newTaxonDominium);
        } else if (selectedTaxonRange == 4) {
            newTaxonRange = lookupTaxonomicalRangeBean().findTaxonomicalRangeById(new Long(6));
            newTaxon.setTaxonomicalRange(newTaxonRange);

            Taxon newTaxonClass = lookupTaxonServiceBean().findTaxonById(new Long(selectedTaxonId));
            newTaxon.setClassTaxon(newTaxonClass);
            
            
            Taxon newTaxonPhylumDivision = lookupTaxonServiceBean().findTaxonById(newTaxonClass.getPhylumDivisionTaxon().getTaxonId());
            newTaxon.setPhylumDivisionTaxon(newTaxonPhylumDivision);
            
            Taxon newTaxonKingdom = lookupTaxonServiceBean().findTaxonById(newTaxonClass.getKingdomTaxon().getTaxonId());
            newTaxon.setKingdomTaxon(newTaxonKingdom);
            
            Taxon newTaxonDominium = lookupTaxonServiceBean().findTaxonById(newTaxonClass.getDominiumTaxon().getTaxonId());
            newTaxon.setDominiumTaxon(newTaxonDominium);
        } else if (selectedTaxonRange == 6) {
            newTaxonRange = lookupTaxonomicalRangeBean().findTaxonomicalRangeById(new Long(9));
            newTaxon.setTaxonomicalRange(newTaxonRange);

            Taxon newTaxonOrder = lookupTaxonServiceBean().findTaxonById(new Long(selectedTaxonId));
            newTaxon.setOrderTaxon(newTaxonOrder);
            

            Taxon newTaxonClass = lookupTaxonServiceBean().findTaxonById(newTaxonOrder.getClassTaxon().getTaxonId());
            newTaxon.setClassTaxon(newTaxonClass);
            
            Taxon newTaxonPhylumDivision = lookupTaxonServiceBean().findTaxonById(newTaxonOrder.getPhylumDivisionTaxon().getTaxonId());
            newTaxon.setPhylumDivisionTaxon(newTaxonPhylumDivision);
            
            Taxon newTaxonKingdom = lookupTaxonServiceBean().findTaxonById(newTaxonOrder.getKingdomTaxon().getTaxonId());
            newTaxon.setKingdomTaxon(newTaxonKingdom);
            
            Taxon newTaxonDominium = lookupTaxonServiceBean().findTaxonById(newTaxonOrder.getDominiumTaxon().getTaxonId());
            newTaxon.setDominiumTaxon(newTaxonDominium);
        } else if (selectedTaxonRange == 9) {
            newTaxonRange = lookupTaxonomicalRangeBean().findTaxonomicalRangeById(new Long(13));
            newTaxon.setTaxonomicalRange(newTaxonRange);

            Taxon newTaxonFamily = lookupTaxonServiceBean().findTaxonById(new Long(selectedTaxonId));
            newTaxon.setFamilyTaxon(newTaxonFamily);

            
            Taxon newTaxonOrder = lookupTaxonServiceBean().findTaxonById(newTaxonFamily.getOrderTaxon().getTaxonId());
            newTaxon.setOrderTaxon(newTaxonOrder);
            
            Taxon newTaxonClass = lookupTaxonServiceBean().findTaxonById(newTaxonFamily.getClassTaxon().getTaxonId());
            newTaxon.setClassTaxon(newTaxonClass);
            
            Taxon newTaxonPhylumDivision = lookupTaxonServiceBean().findTaxonById(newTaxonFamily.getPhylumDivisionTaxon().getTaxonId());
            newTaxon.setPhylumDivisionTaxon(newTaxonPhylumDivision);
            
            Taxon newTaxonKingdom = lookupTaxonServiceBean().findTaxonById(newTaxonFamily.getKingdomTaxon().getTaxonId());
            newTaxon.setKingdomTaxon(newTaxonKingdom);
            
            Taxon newTaxonDominium = lookupTaxonServiceBean().findTaxonById(newTaxonFamily.getDominiumTaxon().getTaxonId());
            newTaxon.setDominiumTaxon(newTaxonDominium);
        }  else if (selectedTaxonRange == 13) {
            newTaxonRange = lookupTaxonomicalRangeBean().findTaxonomicalRangeById(new Long(18));
            newTaxon.setTaxonomicalRange(newTaxonRange);

            Taxon newTaxonGenus = lookupTaxonServiceBean().findTaxonById(new Long(selectedTaxonId));
            newTaxon.setGenusTaxon(newTaxonGenus);

            
            Taxon newTaxonFamily = lookupTaxonServiceBean().findTaxonById(newTaxonGenus.getFamilyTaxon().getTaxonId());
            newTaxon.setFamilyTaxon(newTaxonFamily);            
            
            Taxon newTaxonOrder = lookupTaxonServiceBean().findTaxonById(newTaxonGenus.getOrderTaxon().getTaxonId());
            newTaxon.setOrderTaxon(newTaxonOrder);
            
            Taxon newTaxonClass = lookupTaxonServiceBean().findTaxonById(newTaxonGenus.getClassTaxon().getTaxonId());
            newTaxon.setClassTaxon(newTaxonClass);
            
            Taxon newTaxonPhylumDivision = lookupTaxonServiceBean().findTaxonById(newTaxonGenus.getPhylumDivisionTaxon().getTaxonId());
            newTaxon.setPhylumDivisionTaxon(newTaxonPhylumDivision);
            
            Taxon newTaxonKingdom = lookupTaxonServiceBean().findTaxonById(newTaxonGenus.getKingdomTaxon().getTaxonId());
            newTaxon.setKingdomTaxon(newTaxonKingdom);
            
            Taxon newTaxonDominium = lookupTaxonServiceBean().findTaxonById(newTaxonGenus.getDominiumTaxon().getTaxonId());
            newTaxon.setDominiumTaxon(newTaxonDominium);
            
            newTaxon.setDefaultName(selectedTaxon.getDefaultName() + " " + newTaxon.getCurrentName());
        }
        
        lookupTaxonServiceBean().create(newTaxon);
        displayTree.getChildren().clear();

        prerender();



        
        ArrayList AncestorList = (ArrayList) lookupTaxonServiceBean().getTaxonHierarchy(new Long(newTaxon.getAncestor().getTaxonId()));
        
        for (int i = AncestorList.size() - 1; i > 0; i--) {
            expandTreeItem(((Taxon) AncestorList.get(i)).getTaxonId());
        }
        
        expandTreeItem((newTaxon.getAncestor()).getTaxonId());
        
        return null;
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

    private TaxonomicalRangeRemote lookupTaxonomicalRangeBean() {
        try {
            Context c = new InitialContext();
            return (TaxonomicalRangeRemote) c.lookup("TaxonomicalRangeBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    private TaxonCategoryRemote lookupTaxonCategoryBean() {
        try {
            Context c = new InitialContext();
            return (TaxonCategoryRemote) c.lookup("TaxonCategoryBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
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
    protected UserSessionBean getuser$UserSessionBean() {
        return (UserSessionBean)getBean("user$UserSessionBean");
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
    protected GroupSessionBean getgroup$GroupSessionBean() {
        return (GroupSessionBean)getBean("group$GroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected PersonSessionBean getadmin$person$PersonSessionBean() {
        return (PersonSessionBean)getBean("admin$person$PersonSessionBean");
    }

    public String button2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.

        String nodeId = displayTree.getSelected();
        String selectedTaxonId = nodeId.substring(3);
        
        Taxon selectedTaxon = lookupTaxonServiceBean().findTaxonById(new Long(selectedTaxonId));   
        Long  ancestorId = selectedTaxon.getAncestor().getTaxonId();

        lookupTaxonServiceBean().remove(new Long(selectedTaxonId));
        
        
        displayTree.getChildren().clear();
        
        List kingdomChildren  = null;
        List phylumChildren   = null;
        List classChildren    = null;
        List orderChildren    = null;
        List familyChildren   = null;
        List genusChildren    = null;
        List speciesChildren  = null;        
        
        prerender();
        
        ArrayList AncestorList = (ArrayList) lookupTaxonServiceBean().getTaxonHierarchy(ancestorId);
        
        for (int i = AncestorList.size() - 1; i >= 0; i--) {
            expandTreeItem(((Taxon) AncestorList.get(i)).getTaxonId());
        }
        
        
        return null;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean)getBean("references$ReferenceSessionBean");
    }

    public String btn_cancel_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return "case1";
    }


        /**
     * Este metodo busca las colleciones las devuelve en formato de dataProvider
     * listos para ser empotrados en algun elemento de la GUI.
     *
     * @return
     */
    public void setAllCollections(){

        Option[] collectionList = this.getCollectionConverter().getCollectionsInOptionArray();
        this.collectionsListDropDownData.setOptions(collectionList);

        /*

        //define la coleccion que esta como seleccionada
        if(this.actualCollection  == null){
            this.setActualCollection(collectionsList.get(0));
        }
        this.getCollectionsRadioButtonGroup().setSelectedValue(this.actualCollection.getId());
        */
    }

        /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CollectionsConverter getCollectionConverter() {
        return (CollectionsConverter) getBean("CollectionsConverterBean");
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.util.MessageBean getutil$MessageBean() {
        return (org.inbio.ara.web.util.MessageBean)getBean("util$MessageBean");
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
    protected newTaxonDescriptionRecord getspecies$newTaxonDescriptionRecord() {
        return (newTaxonDescriptionRecord)getBean("species$newTaxonDescriptionRecord");
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
    protected identificationGenerationFragment getgathering$identificationGenerationFragment() {
        return (identificationGenerationFragment)getBean("gathering$identificationGenerationFragment");
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

    /**
     * @return the collectionsListDropDown
     */
    public //jgutierez
    //FIXME: esto no tiene porque estar aca....
    DropDown getCollectionsListDropDown() {
        return collectionsListDropDown;
    }

    /**
     * @param collectionsListDropDown the collectionsListDropDown to set
     */
    public void setCollectionsListDropDown(DropDown collectionsListDropDown) {
        this.collectionsListDropDown = collectionsListDropDown;
    }

    /**
     * @return the collectionsListDropDownData
     */
    public SingleSelectOptionsList getCollectionsListDropDownData() {
        return collectionsListDropDownData;
    }

    /**
     * @param collectionsListDropDownData the collectionsListDropDownData to set
     */
    public void setCollectionsListDropDownData(SingleSelectOptionsList collectionsListDropDownData) {
        this.collectionsListDropDownData = collectionsListDropDownData;
    }

    /**
     * @return the collectionManager
     */
    public CollectionRemote getCollectionManager() {
        return collectionManager;
    }

    /**
     * @param collectionManager the collectionManager to set
     */
    public void setCollectionManager(CollectionRemote collectionManager) {
        this.collectionManager = collectionManager;
    }
}
