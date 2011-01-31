/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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


package org.inbio.ara.taxonomy;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.AddRemove;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.component.Tree;
import com.sun.webui.jsf.component.TreeNode;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.convert.LongConverter;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.AudienceDTO;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.taxonomy.LanguageDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionCategoryDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionElementDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionRecordDTO;
import org.inbio.ara.dto.taxonomy.TaxonDescriptionStageDTO;
import org.inbio.ara.guimanagers.Components;
import org.inbio.ara.guimanagers.DynamicPanelForm;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MathUtils;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditSpecies.java
 * @version Created on 13/10/2009, 03:07:12 PM
 * @author esmata
 */

public class EditSpecies extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

	//Contexto utilizado para obtener el current locale
	private FacesContext context;
	private Locale myLocale;

    //Bindings de los componentes graficos
    private DropDown ddLanguage = new DropDown();
    private DropDown ddStatus = new DropDown();
    private DropDown ddInstitutions = new DropDown();
    private TextField txSequence = new TextField();
    private TextField txTitle = new TextField();
    private Tree descriptionTree = new Tree();
    private DynamicPanelForm dynamicPanelForm = new DynamicPanelForm();
    private HtmlCommandButton saveRecordDataButton = new HtmlCommandButton();
    private StaticText stCategoryName = new StaticText();
    private Form form1 = new Form();

    //Variables auxiliares
    private Table table = new Table();
    private TableRowGroup rowGroup = new TableRowGroup();
    private LongConverter longConverter1 = new LongConverter();
    private Option[] referenceOptions;

    //En esta variable se setearan los datos del drop down de idioma
    private SingleSelectOptionsList languageData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de estado
    private SingleSelectOptionsList statusData = new SingleSelectOptionsList();
    //En esta variable se setearan los datos del drop down de instituciones
    private SingleSelectOptionsList institutionsData = new SingleSelectOptionsList();

    //Metodos utilizados en el arbol de plinian core
    ExpressionFactory expressionFactory = this.getApplication().
            getExpressionFactory();
    ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    private MethodExpression actionMethodNode = expressionFactory.
            createMethodExpression(elContext,
            "#{taxonomy$EditSpecies.treeItemClickHandler}",
            String.class, new Class[]{});
    private MethodExpression actionMethod2 = expressionFactory.
            createMethodExpression(elContext,
            "#{taxonomy$EditSpecies.btn_EditRecordRow_action}",
            String.class, new Class[]{});
    private MethodExpression actionMethod3 = expressionFactory.
            createMethodExpression(elContext,
            "#{taxonomy$EditSpecies.btn_RemoveRecordRow_action}",
            String.class, new Class[]{});
    private MethodExpression actionMethod4 = expressionFactory.
            createMethodExpression(elContext,
            "#{taxonomy$EditSpecies.btn_AddRecordRow_action}",
            String.class, new Class[]{});
    private MethodExpression actionMethod5 = expressionFactory.
            createMethodExpression(elContext,
            "#{taxonomy$EditSpecies.saveRecordData_action}",
            String.class, new Class[]{});
    private MethodExpression actionMethod6 = expressionFactory.
            createMethodExpression(elContext,
            "#{taxonomy$EditSpecies.saveRepeatableRecordData_action}",
            String.class, new Class[]{});

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditSpecies() {
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
    @Override
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
            log("EditSpecies Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
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
    @Override
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
    @Override
    public void prerender() {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();

        //Inicializar el arbol de plinian core
        initCategoriesTree();
        
        //Get all drop down options
        this.languageData.setOptions(getLanguagesDropDownData());
        this.statusData.setOptions(getTaxonDescriptionStatusDropDownData());
        this.institutionsData.setOptions(getInstitutionDropDownData());

        //Get AddRemove options
        this.loadAddRemoveData();
        
        //Metodo se ejecuta solamente la primer ves para cargar datos
        if(this.gettaxonomy$SpeciesSessionBean().isFirstTime()){
            //Set current TextField data
            this.txSequence.setText(ssb.getCurrentTaxDescripDTO().
                    getTaxonDescriptionSequence()+"");
            this.txTitle.setText(ssb.getCurrentTaxDescripDTO().getTitle());
            //Set current AddRemoves selected data
            this.loadAddRemoveSelectedData();
            //Set the flag to false
            this.gettaxonomy$SpeciesSessionBean().setFirstTime(false);
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
    @Override
    public void destroy() {
    }

    /**
     * No mostrar inicialmente los campos para ingresar las descripciones
     */
    public void cleanWidgetsArea() {
        this.getSaveRecordDataButton().setRendered(false);
        this.getStCategoryName().setText("");
    }

    /**
     * Metodo encargado de inicializar el arbol de plinian core
     */
    private void initCategoriesTree() {
        // List of nodes
        List treeItems = this.getDescriptionTree().getChildren();
        if (treeItems.size() == 0) {
            //Asks the DB for the categories with ancestor == 0
            List categories = this.gettaxonomy$SpeciesSessionBean().
                    getTaxonDescriptionsByAncestorId(new Long(0));
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
     * @param toBeInsertItems a list of TaxonDescriptionCategoryDTO
     * @return the List of nodes(TreeNode) of the tree
     */
    private List createTree
            (List treeItems, List<TaxonDescriptionCategoryDTO> toBeInsertItems) {

        for (TaxonDescriptionCategoryDTO item :toBeInsertItems ) {

            TreeNode itemNode = new TreeNode();
            itemNode.setId("treeNode-" + item.getTaxonDescriptionCategoryId());

            //Internacionalizar (ej: "Base elements")
            itemNode.setText(item.getName());

            itemNode.setActionExpression(actionMethodNode);
            treeItems.add(itemNode);

            List sonsToBeInserted = this.gettaxonomy$SpeciesSessionBean().
                    getTaxonDescriptionsByAncestorId
                    (item.getTaxonDescriptionCategoryId());

            if (sonsToBeInserted.size() != 0) {
                List itemNodeSons = itemNode.getChildren();
                createTree(itemNodeSons, sonsToBeInserted);
            }
        }
        return treeItems;
    }

    /**
     * Decides which form has to be set visible
     * ActionMethodNode
     */
    public String treeItemClickHandler() {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        final int ID_POSITION = 1;
        cleanWidgetsArea();
        String nodeId = descriptionTree.getSelected();
        // Find the tree node component with the given id
        TreeNode clickItem = (TreeNode) this.getForm1().findComponentById
                (nodeId);

        //clickItem.getId() -> "treeNode-#"
        String[] treeNodeIdTokens = clickItem.getId().split("-");
        try {
            Long categoryId = Long.parseLong(treeNodeIdTokens[ID_POSITION]);

            this.stCategoryName.setText(clickItem.getText());

            TaxonDescriptionCategoryDTO taxonDescriptionCategory =
                   ssb.getTaxonomyFacadeImpl().getTaxonDescriptionCategoryByid
                   (categoryId);
            if (taxonDescriptionCategory != null) {
                //Repeatable 1=true 0=false
                if (!taxonDescriptionCategory.isRepeatable()) {
                    // No usa repeticiones, se dibuja solamente el formulario dinamico.
                    ssb.setCurrentTaxonDescriptionCategoryId(categoryId);
                    ssb.setCategoryRepeatable(false);
                    this.saveRecordDataButton.setActionExpression
                            (actionMethod5);
                    selectLeaf(categoryId);
                } else {
                    // Usa repeticiones, se dibuja solamente la tabla dinamica.
                    this.saveRecordDataButton.setActionExpression
                            (actionMethod6);
                    ssb.setCurrentTaxonDescriptionCategoryId(categoryId);
                    ssb.setCategoryRepeatable(true);
                    this.drawDynamicTable();
                }
            }
        } catch (NumberFormatException e1) {
            System.err.println(e1.getLocalizedMessage());
        }
        return null;
    }

    private String drawDynamicTable() {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();

        dynamicPanelForm.getPanel().getChildren().clear();
        dynamicPanelForm.getPanel().setColumns(1);
        HtmlCommandButton btnAddTemp = new HtmlCommandButton();
        btnAddTemp.setActionExpression(actionMethod4);
        btnAddTemp.setValue(BundleHelper.getDefaultBundleValue
                ("add_new", this.getMyLocale()));
        btnAddTemp.setStyleClass("My_Button_record");
        dynamicPanelForm.getPanel().getChildren().add(btnAddTemp);
        dynamicPanelForm.getPanel().getChildren().add(createDynamicTable
                (ssb.getCurrentTaxonDescriptionCategoryId()));
        return null;
    }

     private Table createDynamicTable(Long category) {
         SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();

        this.saveRecordDataButton.setRendered(false);
        // Obtener los elementos asociados a la categoria seleccionada
        List<TaxonDescriptionElementDTO> list =
                ssb.getTaxonomyFacadeImpl().getTDElementsByCategoryId(category);

        ssb.initTaxonDescriptionRowDataProvider
                (category, ssb.getCurrentTaxDescripDTO().getTaxonId(),
                ssb.getCurrentTaxDescripDTO().getTaxonDescriptionSequence());
        // Crear la tabla dinamica
        this.table.setId("dynamicElementTable");
        this.table.setTitle(BundleHelper.getDefaultBundleValue
                ("category_elements", this.getMyLocale()));

        // Crear el rowGroup dinámico
        this.rowGroup.setId("rowGroup1");
        this.rowGroup.setSourceVar("currentRow");
        this.rowGroup.setValueBinding
                ("sourceData", getApplication().createValueBinding
                ("#{taxonomy$SpeciesSessionBean.taxonDescriptionRowDataProvider}"));
        this.rowGroup.setRows(5);

        // Agregar el rowGroup a la tabla como un elemento hijo.
        this.table.getChildren().add(rowGroup);

        // Iterar sobre todos los elementos para agregarlos como columnas
        int i = 1;

        TableColumn tableColumn0 = new TableColumn();
        tableColumn0.setId("tableColumn0");
        tableColumn0.setHeaderText(BundleHelper.getDefaultBundleValue
                ("id", this.getMyLocale()));

        // Add the first table Column to the table row group
        rowGroup.getChildren().add(tableColumn0);

        // Create the Static text and set its value as TRIPID
        StaticText staticText0 = new StaticText();
        staticText0.setValueBinding
                ("text", getApplication().createValueBinding
                ("#{currentRow.value['rowId']}"));
        HiddenField hiddenId = new HiddenField();
        hiddenId.setValueBinding
                ("text", getApplication().createValueBinding
                ("#{currentRow.value['rowId']}"));
        hiddenId.setId("hiddenId");

        // Add the static text to the table column1
        tableColumn0.getChildren().add(staticText0);
        tableColumn0.getChildren().add(hiddenId);

        for (TaxonDescriptionElementDTO element : list) {
            // Create the first table Column
            TableColumn tableColumn1 = new TableColumn();
            tableColumn1.setId("tableColumn" + i);
            tableColumn1.setHeaderText(element.getName());

            // Add the first table Column to the table row group
            rowGroup.getChildren().add(tableColumn1);

            // Create the Static text and set its value as TRIPID
            StaticText staticText1 = new StaticText();
            staticText1.setValueBinding
                    ("text", getApplication().createValueBinding
                    ("#{currentRow.value['value" + i + "']}"));
            // Add the static text to the table column1
            tableColumn1.getChildren().add(staticText1);
            i++;
        }

        // Create the fourth table Column
        TableColumn tableColumn4 = new TableColumn();
        tableColumn4.setId("tableColumn" + i);

        // Create the button and set its action binding as button1_action
        Button btnEditTemp = new Button();
        btnEditTemp.setId("btnEditTaxonDescriptionRecord");
        btnEditTemp.setText(BundleHelper.getDefaultBundleValue
                ("edit", this.getMyLocale()));
        btnEditTemp.setActionExpression(actionMethod2);
        tableColumn4.getChildren().add(btnEditTemp);

        Button btnRemoveTemp = new Button();
        btnRemoveTemp.setText(BundleHelper.getDefaultBundleValue
                ("delete", this.getMyLocale()));
        btnRemoveTemp.setId("button2");        
        btnRemoveTemp.setActionExpression(actionMethod3);
        tableColumn4.getChildren().add(btnRemoveTemp);

        // Add the fourth table Column to the table row group
        rowGroup.getChildren().add(tableColumn4);

        return table;
    }
     
    private void setPanelProperties() {
        HashMap p = new HashMap();
        dynamicPanelForm.getPanel().getChildren().clear();

        p.put("columns", 4);
        //p.put("rules", "rows");

        dynamicPanelForm.setPanelProperties(p);
    }

    private String selectLeaf(final Long category) {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();

        final Long taxonId = ssb.getCurrentTaxDescripDTO().getTaxonId();
        List<TaxonDescriptionElementDTO> list =
                ssb.getTaxonomyFacadeImpl().getTDElementsByCategoryId(category);
        Long taxonDescriptionRecordId = 0L;

        if (list.size() > 0) {
            getSaveRecordDataButton().setRendered(true);
        }

        //Establece las columnas, lineas, espacios y borde
        this.setPanelProperties();

        //En este for se realiza la construccion del panel
        for (TaxonDescriptionElementDTO tde : list) {
            TaxonDescriptionRecordDTO taxonDescriptionRecord;
            Long TDEId = tde.getTaxonDescriptionElementId();
            Long contentNumber = 0L;
            String elementName = tde.getName();

            TaxonDescriptionDTO currentTaxonDescription =
                    ssb.getCurrentTaxDescripDTO();
            if (ssb.isCategoryRepeatable()) {
                taxonDescriptionRecord = 
                        ssb.getTaxonomyFacadeImpl().getTaxonDescriptionRecordByRowId
                        (taxonId, currentTaxonDescription.getTaxonDescriptionSequence(),
                        TDEId, ssb.getSelectedTaxonDescriptionRecordSequence());                        
            } else {
                taxonDescriptionRecord = ssb.getTaxonomyFacadeImpl().
                        getTaxonDescriptionRecordByTaxonDescription
                        (taxonId, currentTaxonDescription.getTaxonDescriptionSequence(), TDEId);
            }
            if (taxonDescriptionRecord != null) {
                dynamicPanelForm.setComponent(Components.HIDDENFIELD,
                        setValueProperty(taxonDescriptionRecord.getTaxonDescriptionRecordId()));
                contentNumber = taxonDescriptionRecord.getContentsNumeric();
                taxonDescriptionRecordId = taxonDescriptionRecord.
                        getTaxonDescriptionRecordId();
            } else {  //si hay un 0 en el hiddenField el TaxonDescr no existe
                dynamicPanelForm.setComponent(Components.HIDDENFIELD,
                        setValueProperty(0));
            }
            //Coloca el TaxonDescriptionElement Id
            dynamicPanelForm.setComponent(Components.HIDDENFIELD,
                    setValueProperty(tde.getTaxonDescriptionElementId()));
            //Coloca el label
            this.setLabel(elementName);

            //Aqui se debe cargar el hash con las propiedades de los componentes
            //Si NO es nulo el tableName de la instancia TDE
            if (tde.getTableName() != null) {
                if (tde.getTaxonDescriptionDatatypeId() != 15L) {
                    //FIXME: What this "if" means?
                    if (tde.getTableName().equals("Reference")) {
                        ssb.getTaxonDescriptionRecordReference(taxonDescriptionRecordId);
                    }
                    setComponentWithPredifinedInfo(tde, contentNumber);
                } else {

                    if (taxonDescriptionRecordId != 0) {
                        ssb.getTaxonDescriptionRecordReference(taxonDescriptionRecordId);
                    }

                    AddRemove tmp = new AddRemove();
                    tmp.setValueBinding
                            ("items", getApplication().createValueBinding
                            ("#{taxonomy$EditSpecies.referenceOptions}"));
                    tmp.setValueBinding
                            ("selected", getApplication().createValueBinding
                            ("#{taxonomy$SpeciesSessionBean.selectedReference}"));
                    tmp.setValueBinding
                            ("converter", getApplication().createValueBinding
                            ("#{taxonomy$EditSpecies.longConverter1}"));
                    tmp.setVertical(true);
                    this.dynamicPanelForm.getPanel().getChildren().add(tmp);
                    System.out.println("AddRemove agregado!");
                }
            } else { //buscar info en taxon_description
                Long componentId = tde.getTaxonDescriptionDatatypeId();
                if (taxonDescriptionRecord != null) {
                    dynamicPanelForm.setComponent(componentId,
                            setValueProperty(taxonDescriptionRecord.getContentsText()));
                } else {
                    dynamicPanelForm.setComponent(componentId, setValueProperty(""));
                }
            }
        }//Fin de la construccion del panel
        ssb.setIsDynamicFormPanelActive(true);
        return null;
    }

    /**
     * Despliega los elementos que pertenecen a una categoria.
     * @param category Categoria seleccionada en el arbol
     * @return null Se queda en la misma pagina y actualiza el formulario
     * dinamico
     */
    private String drawDynamicForm(final Long category) {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        List<TaxonDescriptionElementDTO> list =
                ssb.getTaxonomyFacadeImpl().getTDElementsByCategoryId(category);
        Long taxonDescriptionRecordId = 0L;

        if (list.size() > 0) {
            getSaveRecordDataButton().setRendered(true);
        }
        //Establece las columnas, lineas, espacios y borde
        this.setPanelProperties();

        //En este for se realiza la construccion del panel
        for (TaxonDescriptionElementDTO tde : list) {
            TaxonDescriptionRecordDTO taxonDescriptionRecord;
            Long contentNumber = 0L;
            String elementName = tde.getName();

            //FIXME: Por que se pone taxonDescriptionRecord = null ???
            taxonDescriptionRecord = null;
            if (taxonDescriptionRecord != null) {
                dynamicPanelForm.setComponent(Components.HIDDENFIELD,
                        setValueProperty
                        (taxonDescriptionRecord.getTaxonDescriptionRecordId()));
                contentNumber = taxonDescriptionRecord.getContentsNumeric();
                taxonDescriptionRecordId =
                        taxonDescriptionRecord.getTaxonDescriptionRecordId();
            } else {  //si hay un 0 en el hiddenField el TaxonDescr no existe
                dynamicPanelForm.setComponent
                        (Components.HIDDENFIELD, setValueProperty(0));
            }

            //Coloca el TaxonDescriptionElement Id
            dynamicPanelForm.setComponent
                    (Components.HIDDENFIELD, setValueProperty
                    (tde.getTaxonDescriptionElementId()));

            //Coloca el label
            this.setLabel(elementName);

            //Aqui se debe cargar el hash con las propiedades de los componentes
            //Si NO es nulo el tableName de la instancia TDE
            if (tde.getTableName() != null) {
                if (tde.getTaxonDescriptionDatatypeId() != 15L) {
                    String tableName = tde.getTableName();
                    if (tableName.equals("Reference")) {
                        ssb.getTaxonDescriptionRecordReference
                                (taxonDescriptionRecordId);
                    }
                    setComponentWithPredifinedInfo(tde, contentNumber);
                } else {

                    if (taxonDescriptionRecordId != 0) {
                        ssb.getTaxonDescriptionRecordReference(taxonDescriptionRecordId);
                    }

                    AddRemove tmp = new AddRemove();
                    tmp.setValueBinding
                            ("items", getApplication().
                            createValueBinding("#{taxonomy$EditSpecies.referenceOptions}"));
                    tmp.setValueBinding
                            ("selected", getApplication().
                            createValueBinding("#{taxonomy$SpeciesSessionBean.selectedReference}"));
                    tmp.setValueBinding
                            ("converter", getApplication().
                            createValueBinding("#{taxonomy$EditSpecies.longConverter1}"));
                    tmp.setVertical(true);
                    this.dynamicPanelForm.getPanel().getChildren().add(tmp);

                }
            } else { //buscar info en taxon_description
                Long componentId = tde.getTaxonDescriptionDatatypeId();
                if (taxonDescriptionRecord != null) {
                    //Internacionalizar
                    dynamicPanelForm.setComponent(componentId,
                            setValueProperty(taxonDescriptionRecord.getContentsText()));                   

                } else {
                    dynamicPanelForm.setComponent(componentId, setValueProperty(""));
                }
            }
        }//Fin de la construccion del panel
        ssb.setIsDynamicFormPanelActive(true);
        return null;
    }


    private void setComponentWithPredifinedInfo(TaxonDescriptionElementDTO tde,
            Long contentNumber) {

        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();

        HashMap hash = new HashMap();
        Long componentId = tde.getTaxonDescriptionDatatypeId();

        if (MathUtils.isOdd(componentId)) {
            HashMap options = ssb.getTaxonomyFacadeImpl().hashMapListBox(tde.getTableName(),
                    tde.getKeyField(), tde.getMainFieldName());
            hash.clear();
            System.out.println("Content Number " + contentNumber);
            hash.put("value", contentNumber);
            dynamicPanelForm.setComponent(componentId, hash, Components.UI_SELECT_ITEMS, options);
        } else {
            System.err.println("Error en el datatypeId de un TDE");
        }
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
            //hash.put("value", ResourceBundle.getBundle("org/inbio/ara/Bundle").
                    //getString(text));
            hash.put("value", BundleHelper.getDefaultBundleValue
                    (text, this.getMyLocale()));
        } catch (Exception e) {
            hash.put("value", text);
        }
        dynamicPanelForm.setComponent(Components.LABEL, hash);
        hash.clear();
    }

    /**
     * ActionMethod2
     * @return
     */
    public String btn_EditRecordRow_action() {
        this.saveRecordDataButton.setActionExpression(actionMethod5);
        Long rowId = (Long) getValue("#{currentRow.value[\'rowId\']}");
        this.gettaxonomy$SpeciesSessionBean().
                setSelectedTaxonDescriptionRecordSequence(rowId);
        selectLeaf(this.gettaxonomy$SpeciesSessionBean().
                getCurrentTaxonDescriptionCategoryId());
        return null;
    }

    /**
     * ActionMethod3
     * @return
     */
    public String btn_RemoveRecordRow_action() {
        Long rowId = (Long) getValue("#{currentRow.value[\'rowId\']}");
        boolean result = this.gettaxonomy$SpeciesSessionBean().
                deleteTaxonDescriptionRecordRow(rowId);
        if(result){
            MessageBean.setSuccessMessageFromBundle
                    ("delete_descriptioons_success", this.getMyLocale());
        }
        this.drawDynamicTable();
        return null;
    }

    /**
     * ActionMethod4
     * @return
     */
    public String btn_AddRecordRow_action() {
        cleanWidgetsArea();
        this.drawDynamicForm(this.gettaxonomy$SpeciesSessionBean().
                getCurrentTaxonDescriptionCategoryId());
        return null;
    }

    /**
     * Metodo encargado de cargar los datos de los distintos add remove de la
     * ventana de nueva recoleccion, carga los disponibles
     */
    private void loadAddRemoveData(){
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        //Cargar datos del add remove de Audiencias (Disponibles)
        if (ssb.getArAudiences().getAvailableOptions() == null ||
                ssb.getArAudiences().getAvailableOptions().length == 0) {

            List<AudienceDTO> audiencesList = ssb.getAllAudiences();
            List<Option> list = new ArrayList<Option>();
            for (AudienceDTO audi : audiencesList) {
                list.add(new Option(audi.getAudienceId(), audi.getName()));
            }
            ssb.getArAudiences().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Cargar los datos del add remove de Autores (Disponibles)
        if (ssb.getArAuthors().getAvailableOptions() == null ||
                ssb.getArAuthors().getAvailableOptions().length == 0) {

            List<PersonDTO> authorsList = ssb.getAllSpeciesRecordAuthors();
            List<Option> list = new ArrayList<Option>();
            for (PersonDTO per : authorsList) {
                list.add(new Option(per.getPersonKey(), per.getNaturalLongName()));
            }
            ssb.getArAuthors().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Cargar los datos del add remove de Instituciones (Disponibles)
        if (ssb.getArInstitutions().getAvailableOptions() == null ||
                ssb.getArInstitutions().getAvailableOptions().length == 0) {

            List<InstitutionDTO> instList = ssb.getAllInstitutions();
            List<Option> list = new ArrayList<Option>();
            for (InstitutionDTO ins : instList) {
                list.add(new Option(ins.getInstitutionId(), ins.getInstitutionName()));
            }
            ssb.getArInstitutions().setAvailableOptions(list.toArray(new Option[list.size()]));
        }
        //Setea los labels del componente add remove
        ssb.getArAudiences().setLbTitle(BundleHelper.getDefaultBundleValue
                ("menuModuleAudiences", this.getMyLocale()));
        ssb.getArAudiences().setLbAvailable(BundleHelper.getDefaultBundleValue
                ("available", this.getMyLocale()));
        ssb.getArAudiences().setLbSelected(BundleHelper.getDefaultBundleValue
                ("selected", this.getMyLocale()));

        ssb.getArAuthors().setLbTitle(BundleHelper.getDefaultBundleValue
                ("authors", this.getMyLocale()));
        ssb.getArAuthors().setLbAvailable(BundleHelper.getDefaultBundleValue
                ("available", this.getMyLocale()));
        ssb.getArAuthors().setLbSelected(BundleHelper.getDefaultBundleValue
                ("selected", this.getMyLocale()));

        ssb.getArInstitutions().setLbTitle(BundleHelper.getDefaultBundleValue
                ("menuModuleInstitutions", this.getMyLocale()));
        ssb.getArInstitutions().setLbAvailable(BundleHelper.getDefaultBundleValue
                ("available", this.getMyLocale()));
        ssb.getArInstitutions().setLbSelected(BundleHelper.getDefaultBundleValue
                ("selected", this.getMyLocale()));
    }

    /**
     * Metodo encargado de cargar los datos de los distintos add remove de la
     * ventana de nueva recoleccion, carga los seleccionados segun el
     * currenGatheringObservationDTO para edicion
     */
    private void loadAddRemoveSelectedData(){
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        //Cargar datos del add remove de audiencias (Seleccionados)
        List<AudienceDTO> audiencesList = ssb.getTaxonomyFacadeImpl().
                getAudiencesByTaxonDescription(ssb.getCurrentTaxDescripDTO().getTaxonId(),
                ssb.getCurrentTaxDescripDTO().getTaxonDescriptionSequence());
        List<Long> list = new ArrayList<Long>();
        for (AudienceDTO audi : audiencesList) {
              list.add(audi.getAudienceId());
         }
        ssb.getArAudiences().setSelectedOptions(list.toArray(new Long[list.size()]));

		//Cargar los datos del add remove de autores (Seleccionados)
        List<PersonDTO> authorsList = ssb.getTaxonomyFacadeImpl().
                getPersonsByTaxonDescription(ssb.getCurrentTaxDescripDTO().getTaxonId(),
                ssb.getCurrentTaxDescripDTO().getTaxonDescriptionSequence());
        List<Long> listP = new ArrayList<Long>();
        for (PersonDTO per : authorsList) {
            listP.add(per.getPersonKey());
         }
        ssb.getArAuthors().setSelectedOptions(listP.toArray(new Long[listP.size()]));

		//Cargar los datos del add remove de instituciones (Seleccionados)
        List<InstitutionDTO> insList = ssb.getTaxonomyFacadeImpl().
                getInstitutionsByTaxonDescription(ssb.getCurrentTaxDescripDTO().getTaxonId(),
                ssb.getCurrentTaxDescripDTO().getTaxonDescriptionSequence());
        List<Long> listProy = new ArrayList<Long>();
        for (InstitutionDTO ins : insList) {
            listProy.add(ins.getInstitutionId());
        }
        ssb.getArInstitutions().setSelectedOptions(listProy.toArray(new Long[listProy.size()]));
    }

   /**
     * Obtener los datos del drop down de idiomas
     */
    public Option[] getLanguagesDropDownData(){
        List<LanguageDTO> DTOList = this.gettaxonomy$SpeciesSessionBean().
                getAllLanguages();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(LanguageDTO myDTO : DTOList){
            option = new Option(myDTO.getLanguageId(), myDTO.getConcepName().trim());
            allOptions.add(option);
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

   /**
     * Obtener los datos del drop down de estados
     */
    public Option[] getTaxonDescriptionStatusDropDownData(){
        List<TaxonDescriptionStageDTO> DTOList = this.gettaxonomy$SpeciesSessionBean().
                getAllTaxonDescriptionStages();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(TaxonDescriptionStageDTO myDTO : DTOList){
            option = new Option(myDTO.getTaxonDescriptionStageId(),
                    myDTO.getName().trim());
            allOptions.add(option);
        }
        //return the elements
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

   /**
     * Obtener los datos del drop down de instituciones
     */
    public Option[] getInstitutionDropDownData(){
        List<InstitutionDTO> instDTOList = this.gettaxonomy$SpeciesSessionBean()
                .SetInstitutionDropDownData();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue
                ("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(InstitutionDTO instDTO : instDTOList){
            option = new Option(instDTO.getInstitutionId(), instDTO.getInstitutionName());
            allOptions.add(option);
        }
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected StatisticsSessionBean getstatistics$StatisticsSessionBean() {
        return (StatisticsSessionBean) getBean("statistics$StatisticsSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SystemUserSessionBean getsecurity$SystemUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AudienceSessionBean getadmin$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("admin$AudienceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpeciesSessionBean gettaxonomy$SpeciesSessionBean() {
        return (SpeciesSessionBean) getBean("taxonomy$SpeciesSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CollectionSessionBean getadmin$CollectionSessionBean() {
        return (CollectionSessionBean) getBean("admin$CollectionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringDetailSessionBean getinventory$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("inventory$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ProfileSessionBean getadmin$ProfileSessionBean() {
        return (ProfileSessionBean) getBean("admin$ProfileSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the ddLanguage
     */
    public DropDown getDdLanguage() {
        return ddLanguage;
    }

    /**
     * @param ddLanguage the ddLanguage to set
     */
    public void setDdLanguage(DropDown ddLanguage) {
        this.ddLanguage = ddLanguage;
    }

    /**
     * @return the ddStatus
     */
    public DropDown getDdStatus() {
        return ddStatus;
    }

    /**
     * @param ddStatus the ddStatus to set
     */
    public void setDdStatus(DropDown ddStatus) {
        this.ddStatus = ddStatus;
    }

    /**
     * @return the txSequence
     */
    public TextField getTxSequence() {
        return txSequence;
    }

    /**
     * @param txSequence the txSequence to set
     */
    public void setTxSequence(TextField txSequence) {
        this.txSequence = txSequence;
    }

    /**
     * @return the txTitle
     */
    public TextField getTxTitle() {
        return txTitle;
    }

    /**
     * @param txTitle the txTitle to set
     */
    public void setTxTitle(TextField txTitle) {
        this.txTitle = txTitle;
    }

    /**
     * @return the languageData
     */
    public SingleSelectOptionsList getLanguageData() {
        return languageData;
    }

    /**
     * @param languageData the languageData to set
     */
    public void setLanguageData(SingleSelectOptionsList languageData) {
        this.languageData = languageData;
    }

    /**
     * @return the statusData
     */
    public SingleSelectOptionsList getStatusData() {
        return statusData;
    }

    /**
     * @param statusData the statusData to set
     */
    public void setStatusData(SingleSelectOptionsList statusData) {
        this.statusData = statusData;
    }

    /**
     * @return the descriptionTree
     */
    public Tree getDescriptionTree() {
        return descriptionTree;
    }

    /**
     * @param descriptionTree the descriptionTree to set
     */
    public void setDescriptionTree(Tree descriptionTree) {
        this.descriptionTree = descriptionTree;
    }

    public HtmlPanelGrid getDynamicPanelForm() {
        return dynamicPanelForm.getPanel();
    }

    public void setDynamicPanelForm(HtmlPanelGrid panel) {
        this.dynamicPanelForm.setPanel(panel);
    }

    /**
     * Metodo ejecutado por el boton del panel de descripciones
     * ActionMethod5
     */
     public String saveRecordData_action() {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();

        List<UIComponent> graphicalComponents =
                dynamicPanelForm.getPanel().getChildren();

        for (int i = 0; i < graphicalComponents.size(); i++) {
            UIComponent c = graphicalComponents.get(i);
            if ((i % 4) == 0) {
                Long taxonDescriptionRecordId = getIdFromGUIComponent(c);

                //Si el id del TDR es 0 significa q es uno nuevo!
                if (taxonDescriptionRecordId.equals(new Long(0))) {

                    TaxonDescriptionRecordDTO TDR = new TaxonDescriptionRecordDTO();
                    TaxonDescriptionElementDTO TDE;
                    try {
                        TDR.setUserName(this.getAraSessionBean().getGlobalUserName());
                    } catch (Exception e) {
                        System.err.println("Debe iniciar sesion. " + e.toString());
                    }
                    //Este valor siempre debe ser 0L para las descripciones asociadas a una categorúa no repetible.
                    TDR.setSequence(0L);
                    TDR.setTaxonomicalTimestamp(new GregorianCalendar());
                    i++;
                    c = graphicalComponents.get(i);

                    Long tdeId = getIdFromGUIComponent(c);
                    if (tdeId != null) {
                        TDE = ssb.getTaxonomyFacadeImpl().getElementById(tdeId);
                        i += 2;
                        c = graphicalComponents.get(i);
                        try {
                            if (TDE.getTaxonDescriptionDatatypeId() == 15L) {
                                // En esta sección se administran las referencias asociadas a un taxonDescriptionRecord
                                this.manageReferences(TDE);
                            } else {
                                TDR.setTaxonDescriptionElementId(TDE.getTaxonDescriptionElementId());
                                if (TDE.getTableName() == null) {
                                    TDR.setContentsNumeric(0L);
                                    TDR.setContentsText(c.getAttributes().get("value").toString());
                                } else {
                                    Long foreignId = getIdFromGUIComponent(c);
                                    if (foreignId != null) {
                                        TDR.setContentsNumeric(foreignId);
                                    }
                                }
                                //Mandar a persistir el nuevo taxon descriptin record
                                ssb.getTaxonomyFacadeImpl().saveTaxonDescriptionRecord
                                (TDR, ssb.getCurrentTaxDescripDTO());
                                
                            }
                        } catch (Exception e) {
                            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
                            return null;
                        }
                    }
                    //Actualizar estado (Ya no es para crear nuevo, sino, para editar el que ya existe)
                    this.treeItemClickHandler();
                }//Fin: Si el id del TDR es 0 significa q es uno nuevo!

                else {  //Guardar un TaxonDescription que ya existe -> EDITAR
                    TaxonDescriptionRecordDTO TDR;

                    TDR = ssb.getTaxonomyFacadeImpl().
                            getTaxonDescriptionRecordById(taxonDescriptionRecordId);
                    i += 3;
                    c = graphicalComponents.get(i);
                    if (TDR.getContentsNumeric() == 0L) {
                        String modifiedValue =
                                c.getAttributes().get("value").toString();
                        TDR.setContentsText(modifiedValue);
                    } else {
                        Long foreignId = getIdFromGUIComponent(c);
                        if (foreignId != null) {
                            TDR.setContentsNumeric(foreignId);
                        }
                    }
                    try{
                        //Mandar a realizar el update
                        ssb.getTaxonomyFacadeImpl().updateTaxonDescriptionRecord(TDR);                        
                    }
                    catch(Exception e){
                        MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
                        return null;
                    }

                } //Fin: Guardar un TaxonDescription que ya existe -> EDITAR
            }
        }

        //Notificar al usuario que la operacion se llevo con exito
        MessageBean.setSuccessMessageFromBundle("successfull_operation", this.getMyLocale());

        if (ssb.isCategoryRepeatable()) {
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

    private void manageReferences(TaxonDescriptionElementDTO taxonDescriptionElement) {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();
        TaxonDescriptionRecordDTO taxonDescriptionRecord = new TaxonDescriptionRecordDTO();

        taxonDescriptionRecord.setTaxonomicalTimestamp(new GregorianCalendar());
        taxonDescriptionRecord.setContentsNumeric(0L);
        taxonDescriptionRecord.setContentsText("");
        taxonDescriptionRecord.setUserName(this.getAraSessionBean().getGlobalUserName());
        if (ssb.isCategoryRepeatable()) {
            taxonDescriptionRecord.setSequence(ssb.getNextSequence());
        } else {
            taxonDescriptionRecord.setSequence(0L);
        }
        taxonDescriptionRecord.setTaxonDescriptionElementId
                (taxonDescriptionElement.getTaxonDescriptionElementId());
        ssb.getTaxonomyFacadeImpl().saveTaxonDescriptionRecord
                                (taxonDescriptionRecord, ssb.getCurrentTaxDescripDTO());
        MessageBean.setSuccessMessageFromBundle("created_successfully", this.getMyLocale());
    }

     /**
      * ActionMetho6
      * @return
      */
     public String saveRepeatableRecordData_action() {
         SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();

        List<UIComponent> graphicalComponents = dynamicPanelForm.getPanel().
                getChildren();

        //*Por cada TaxonDescription se imprime 1) Tid 2) TDE id 3) etiqueta (omitir)
        //*4) el valor del textfield
        //*Se deben conservar el valor del 1 y el 3 para crear un nuevo taxonDesc
        //*o para modificar uno ya existente.
        Long aux = ssb.getNextSequence();
        for (int i = 0; i < graphicalComponents.size(); i++) {
            UIComponent c = graphicalComponents.get(i);
            if ((i % 4) == 0) {
                Long taxonDescriptionRecordId = getIdFromGUIComponent(c);

                //Si el id del TDR es 0 significa q es uno nuevo!
                if (taxonDescriptionRecordId.equals(new Long(0))) {
                    TaxonDescriptionRecordDTO TDR = new TaxonDescriptionRecordDTO();
                    TaxonDescriptionElementDTO TDE;
                    try {
                        TDR.setUserName(this.getAraSessionBean().getGlobalUserName());
                    } catch (Exception e) {
                        System.err.println("Debe iniciar sesion. " + e.toString());
                    }
                    TDR.setSequence(aux);
                    TDR.setTaxonomicalTimestamp(new GregorianCalendar());
                    i++;
                    c = graphicalComponents.get(i);

                    Long tdeId = getIdFromGUIComponent(c);
                    if (tdeId != null) {
                        TDE = ssb.getTaxonomyFacadeImpl().getElementById(tdeId);
                        i += 2;
                        c = graphicalComponents.get(i);
                        try {

                            if (TDE.getTaxonDescriptionDatatypeId() == 15L) {
                                // En esta sección se administran las referencias asociadas a un taxonDescriptionRecord
                                this.manageReferences(TDE);
                            } else {
                                TDR.setTaxonDescriptionElementId(TDE.getTaxonDescriptionElementId());
                                if (TDE.getTableName() == null) {
                                    TDR.setContentsNumeric(0L);
                                    TDR.setContentsText(c.getAttributes().get("value").toString());
                                } else {
                                    Long foreignId = getIdFromGUIComponent(c);
                                    if (foreignId != null) {
                                        TDR.setContentsNumeric(foreignId);
                                    }
                                }
                                //Mandar a persistir el nuevo taxon descriptin record
                                ssb.getTaxonomyFacadeImpl().saveTaxonDescriptionRecord
                                (TDR, ssb.getCurrentTaxDescripDTO());                                
                            }
                        }
                        catch (Exception e) {
                            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
                            return null;
                        }
                    }
                }
            }
        }

        //Notificar al usuario que la operacion se llevo con exito
        MessageBean.setSuccessMessageFromBundle("successfull_operation", this.getMyLocale());
        
        this.drawDynamicTable();
        return null;
     }

    /**
     * @return the saveRecordDataButton
     */
    public HtmlCommandButton getSaveRecordDataButton() {
        return saveRecordDataButton;
    }

    /**
     * @param saveRecordDataButton the saveRecordDataButton to set
     */
    public void setSaveRecordDataButton(HtmlCommandButton saveRecordDataButton) {
        this.saveRecordDataButton = saveRecordDataButton;
    }

    /**
     * @return the stCategoryName
     */
    public StaticText getStCategoryName() {
        return stCategoryName;
    }

    /**
     * @param stCategoryName the stCategoryName to set
     */
    public void setStCategoryName(StaticText stCategoryName) {
        this.stCategoryName = stCategoryName;
    }

    /**
     * @return the form1
     */
    public Form getForm1() {
        return form1;
    }

    /**
     * @param form1 the form1 to set
     */
    public void setForm1(Form form1) {
        this.form1 = form1;
    }

    /**
     * @return the longConverter1
     */
    public LongConverter getLongConverter1() {
        return longConverter1;
    }

    /**
     * @param longConverter1 the longConverter1 to set
     */
    public void setLongConverter1(LongConverter longConverter1) {
        this.longConverter1 = longConverter1;
    }

    /**
     * @return the referenceOptions
     */
    public Option[] getReferenceOptions() {
        return referenceOptions;
    }

    /**
     * @param referenceOptions the referenceOptions to set
     */
    public void setReferenceOptions(Option[] referenceOptions) {
        this.referenceOptions = referenceOptions;
    }

    /**
     * Metodo ejecutado por el boton de guardar edicion de taxonDescriptionRecord
     * @return
     */
    public String btnEditSpeciesRecord_action() {
        SpeciesSessionBean ssb = this.gettaxonomy$SpeciesSessionBean();

        //Capturar datos de la pantalla (Ficha de descripcion taxonomica)
        String title = (String)this.getTxTitle().getText();
        Long sequence = null;
        String sequenceAux = (String)this.getTxSequence().getText();
        if(sequenceAux!=null){
            sequence = Long.parseLong(sequenceAux);
        }
        //Setear el current DTO
        ssb.getCurrentTaxDescripDTO().setTaxonDescriptionSequence
                (sequence);
        ssb.getCurrentTaxDescripDTO().setTitle(title);

        //Persistir los cambios realizados
        try {
            ssb.updateTaxonDescription();
        } catch (Exception e) {
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Refrescar el paginador
        ssb.getPagination().refreshList();

        //Notificar al usuario
        MessageBean.setSuccessMessageFromBundle("modified_successfully", this.getMyLocale());

        return null;
    }

    /**
     * @return the institutionsData
     */
    public SingleSelectOptionsList getInstitutionsData() {
        return institutionsData;
    }

    /**
     * @param institutionsData the institutionsData to set
     */
    public void setInstitutionsData(SingleSelectOptionsList institutionsData) {
        this.institutionsData = institutionsData;
    }

    /**
     * @return the ddInstitutions
     */
    public DropDown getDdInstitutions() {
        return ddInstitutions;
    }

    /**
     * @param ddInstitutions the ddInstitutions to set
     */
    public void setDdInstitutions(DropDown ddInstitutions) {
        this.ddInstitutions = ddInstitutions;
    }
}

