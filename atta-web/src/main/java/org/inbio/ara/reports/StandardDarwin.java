 /*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.reports;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.reports.DwcElementDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;
import org.inbio.ara.util.QueryNode;
import org.inbio.ara.util.StandardNode;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version StandardDarwin.java
 * @version Created on 05/11/2009, 11:18:45 AM
 * @author esmata
 */

public class StandardDarwin extends AbstractPageBean {
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

    //Binding de los componentes graficos
    private HtmlPanelGrid elementsPanel = new HtmlPanelGrid();
    private HtmlPanelGrid filtersPanel = new HtmlPanelGrid();
    Option[] comparator =
    {new Option(1, BundleHelper.getDefaultBundleValue
             ("dwc_equal",this.getMyLocale())),
     new Option(2, BundleHelper.getDefaultBundleValue
             ("dwc_like",this.getMyLocale()))};
    Option[] logicalOperator =
    {new Option(1, BundleHelper.getDefaultBundleValue
             ("dwc_and",this.getMyLocale())),
     new Option(2, BundleHelper.getDefaultBundleValue
             ("dwc_or",this.getMyLocale()))};
    // List of checkboxs components
    List<UIComponent> MycheckBoxList = elementsPanel.getChildren();

    //Constantes
    public static final int FILTER_COLUMNS = 5;
    public static final int LOG_OP_CLMN = 0;
    public static final int DWC_CLMN = 1;
    public static final int COMPARATOR_CLMN = 2;
    public static final int INPUT_CLMN = 3;

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public StandardDarwin() {
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
            log("StandardDarwin Initialization Failure", e);
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
        //---------- Rendering the darwin core elements checkboxs ---------
        this.MycheckBoxList.clear();
        //Create and load the list with elements of DC standard
        LinkedList<StandardNode> ElementList = this.getSnapshotSessionBean().
                findDwCElements();
        //Generate the ckeckboxs and load the list of checkbox
        for(int i=0;i<ElementList.size();i++){
            StandardNode node = ElementList.get(i);
            drawElement(node,i);
        }
        //---------- Rendering the darwin core filters ----------
        this.filtersPanel.getChildren().clear();
        LinkedList<QueryNode> sessionQueryList = this.getSnapshotSessionBean().
                getQueryList();
        if(sessionQueryList.size() == 0) {
            QueryNode qn = createQueryNode();
            sessionQueryList.add(qn);
        }
         //Draw the first row
        drawFirstFilterRow(sessionQueryList.getFirst());
        if(sessionQueryList.size() > 1) {
            for (int i=1; i<sessionQueryList.size(); i++) {
                QueryNode queryNode = sessionQueryList.get(i);
                //Draw the rest of rows
                drawExtraFilterRows(queryNode, i); 
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
    @Override
    public void destroy() {
    }

    //Method to draw the checkbox on elementsPanel
    private void drawElement(StandardNode sn, int id) {
        //CheckBox elements
        Checkbox chb = new Checkbox();
        chb.setId(sn.getKeyword());
        chb.setStyle("font-size: 11px");
        String label = BundleHelper.getDefaultBundleValue(sn.getKeyword(),
                this.getMyLocale());
        if (sn.getSelected().equals("1")) {
            chb.setLabel(label);
            chb.setDisabled(true);
            chb.setSelected("true");
            this.MycheckBoxList.add(chb);
        } else {
            chb.setLabel(label);
            this.MycheckBoxList.add(chb);
        }
    }

    //Create an instance of QueryNode class with DwC default element
    private QueryNode createQueryNode() {
        DwcElementDTO e = this.getSnapshotSessionBean().getReportsFacade().
                findDwcElementById(new Long(1));
        return new QueryNode("or", 2,e.getElementKeyword(), e.getElementId(),
                            "like", 2, "");
    }

    //Draw the first row of information filters
    private void drawFirstFilterRow(QueryNode firstNode) {
        this.filtersPanel.getChildren().add(new HiddenField());
        drawCommonWidgets(firstNode, 0);
        this.filtersPanel.getChildren().add(new HiddenField());
    }

    //Draw the components for filters
    private void drawCommonWidgets(QueryNode qn, int row) {
        //DwCElements
        DropDown dwcDD = createDwCDropDown();
        dwcDD.setId("dwcDD-" + row);
        dwcDD.setSelected(qn.getDwcElementId());
        this.filtersPanel.getChildren().add(dwcDD);

        //ComparatorElements
        DropDown dwcComp = createComparatorDropDown();
        dwcComp.setId("dwcComp-" + row);
        dwcComp.setSelected(qn.getComparatorId());
        this.filtersPanel.getChildren().add(dwcComp);

        //User Input
        TextField tf = new TextField();
        tf.setId("tf-" + row);
        tf.setText(qn.getUserEntry());
        //tf.setRequired(true);
        tf.setOnChange(null);

        this.filtersPanel.getChildren().add(tf);
    }

    //Create the drop down to compare information
    private DropDown createComparatorDropDown() {
        DropDown dd = new DropDown();
        dd.setItems(this.comparator);
        return dd;
    }

    //Create the drop down component with DwC elements
    private DropDown createDwCDropDown() {
        DropDown dd = new DropDown();
        dd.setItems(getDwCElementsInOptionForm());
        return dd;
    }
    private ArrayList<Option> getDwCElementsInOptionForm(){
        ArrayList<Option> dwcElements = new ArrayList();
        List<DwcElementDTO> rawElements = this.getSnapshotSessionBean().
                getReportsFacade().findDwCElements();
        for (DwcElementDTO dwcElement : rawElements) {
            dwcElements.add (new Option(dwcElement.getElementId(),
                    BundleHelper.getDefaultBundleValue(dwcElement.
                        getElementKeyword(),this.getMyLocale())));
        }
        return dwcElements;
    }

    //Draw the rest of filter rows of information filters
    private void drawExtraFilterRows(QueryNode qn, int row) {
        //Logical operators
        DropDown logicalOperatorsDD = createLogicalOperatorsDD();
        logicalOperatorsDD.setId("logicalOperator-"+row);
        logicalOperatorsDD.setSelected(qn.getLogicalOperatorId());
        this.filtersPanel.getChildren().add(logicalOperatorsDD);
        //Common Widgets
        drawCommonWidgets(qn, row);
        //Delete link
        drawDeleteLink(row);
    }
    private DropDown createLogicalOperatorsDD() {
        DropDown dd = new DropDown();
        dd.setItems(this.logicalOperator);
        return dd;
    }
    private void drawDeleteLink(int row) {
        ExpressionFactory expressionFactory = this.getApplication().
                getExpressionFactory();
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        MethodExpression actionMethod = expressionFactory.createMethodExpression
                (elContext,"#{reports$StandardDarwin.deleteClickHandler}",
                String.class, new Class[]{});

        MethodExpression listenerMethod = expressionFactory.
                createMethodExpression(elContext,
                "#{reports$StandardDarwin.deleteClickHandler}",
                null, new Class[]{ActionEvent.class});

        Hyperlink deleteLink = new Hyperlink();
        deleteLink.setId("deleteLink-" + row);
        deleteLink.setText(BundleHelper.getDefaultBundleValue("delete",
                this.getMyLocale()));

        deleteLink.setActionExpression(actionMethod);
        deleteLink.setActionListenerExpression(listenerMethod);
        this.filtersPanel.getChildren().add(deleteLink);
    }

    //Handler for the delete event
    public void deleteClickHandler(ActionEvent ae) {
        saveInputInfo();
        String deleteLink = ((Hyperlink)ae.getComponent()).getId();
        String[] partsId = deleteLink.split("-");
        int index = Integer.parseInt(partsId[1]);
        this.getSnapshotSessionBean().getQueryList().remove(index);
    }
        public String deleteClickHandler() {
        return null;
    }

    //Code execution for "share info" button event
    public String bshareAll_action() {
        //Setear la lista de elementos y la lista de consulta
        getSnapshotSessionBean().setQueryList(new LinkedList<QueryNode>());
        //Con todos los elementos
        getSnapshotSessionBean().setElementList(getAllElementsDwc());

        //Crear archivo temporal para guardar el dump de dwc_snapshot
        File currentFile = null;
        try {
            // Create temp file.
            currentFile = File.createTempFile("dwcSnapshot", ".csv");
            // Delete temp file when program exits.
            currentFile.deleteOnExit();
            currentFile.setWritable(true);
        } catch (Exception e) {}

        //Crear el snapshot
        boolean result1 = getSnapshotSessionBean().createDwcSnapshot(this.getAraSessionBean().getGlobalDataBaseSchema());
        boolean result2 = getSnapshotSessionBean().getReportsFacade().
                export(currentFile,
                this.getAraSessionBean().getGlobalDataSource(),
                this.getAraSessionBean().getGlobalDataBaseSchema());
        if (result1 && result2) {
            //Set to null the query  list (filters)
            getSnapshotSessionBean().setQueryList(new LinkedList<QueryNode>());
            //Descargar el archivo
            downloadFile(currentFile);
        } else {
            MessageBean.setErrorMessageFromBundle("dwc_snapshot_error",
                    this.getMyLocale());
        }
        return null;
    }

    private void downloadFile(File f){
            //Descargar el archivo exportado
            HttpServletResponse response = (HttpServletResponse)
                    getExternalContext().getResponse();
            response.setContentType("text/csv");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + f.getPath() + "\"");
            byte[] buf = new byte[1024];
            try{
              long length = f.length();
              BufferedInputStream in = new BufferedInputStream
                      (new FileInputStream(f));
              ServletOutputStream out = response.getOutputStream();
              response.setContentLength((int)length);
              while ((in != null) && ((length = in.read(buf)) != -1)) {
                out.write(buf, 0, (int)length);
              }
              in.close();
              out.close();
            }catch (Exception exc){
                exc.printStackTrace();
            }
    }

    //Metodo que trae todos los elementos darwin core en una lista de strings
    public LinkedList<String> getAllElementsDwc(){
        return getSnapshotSessionBean().getReportsFacade().getAllElementsDwc();
    }

    //Code execution for "share info" button event
    public String bshare_action() {
        //Save the filter info
        int validate = saveInputInfo();
        if (validate == 1 || validate == 2) {
            System.out.println("validate = "+validate);
            //Iterate over MycheckBoxList to get the selected elements (element id)
            LinkedList<String> selectedElements = getSelectedelements();
            getSnapshotSessionBean().setElementList(selectedElements);

            //Crear archivo temporal para guardar el dump de dwc_snapshot
            File currentFile = null;
            try {
                System.out.println("Se crea el archvo dwcSnapshot.csv");
                // Create temp file.
                currentFile = File.createTempFile("dwcSnapshot", ".csv");
                // Delete temp file when program exits.
                currentFile.deleteOnExit();
                currentFile.setWritable(true);
            } catch (Exception e) {}

            //Create the snapshot
            System.out.println("Se va a crear el Snapshot DwC");
            boolean result1 = getSnapshotSessionBean().createDwcSnapshot(this.getAraSessionBean().getGlobalDataBaseSchema());
            System.out.println("Se va a exportar");
            boolean result2 = getSnapshotSessionBean().getReportsFacade().
                export(currentFile, 
                this.getAraSessionBean().getGlobalDataSource(),
                this.getAraSessionBean().getGlobalDataBaseSchema());

            if (result1&&result2) {
                //Set to null the query  list (filters)
                LinkedList<QueryNode> llaux = new LinkedList();
                getSnapshotSessionBean().setQueryList(llaux);
                //Descargar el archivo
                downloadFile(currentFile);
            }
            else {
                MessageBean.setErrorMessageFromBundle("dwc_snapshot_error",
                        this.getMyLocale());
                        return null;
            }
            return null;
            
        } else {
            MessageBean.setErrorMessageFromBundle("dwc_empty_error",
                    this.getMyLocale());
            return null;
        }
    }

     //Method to create a list with selected items by user
    public LinkedList<String> getSelectedelements() {
        LinkedList<String> result = new LinkedList();
        List<UIComponent> list_components = this.getElementsPanel().getChildren();
        for (int i = 0; i < list_components.size(); i++) {
            if (((Checkbox) list_components.get(i)).isChecked()) {
                String aux = ((Checkbox) list_components.get(i)).getId();
                result.add(aux);
            }
        }
        return result;
    }

    public String buttonReload_action() {
        //Individuales, observaciones, agrupados unitaxon
        boolean result = this.getSnapshotSessionBean().
                getReportsFacade().reloadDarwinCoreTable(getAraSessionBean().getGlobalDataBaseSchema());
        //Agrupados multitaxon
        //TODO
        if(result){
            MessageBean.setSuccessMessageFromBundle("dwc_14_success",
                    this.getMyLocale());
            return null;
        }
        else{
            MessageBean.setErrorMessageFromBundle("error",
                    this.getMyLocale());
            return null;
        }
    }

    //Code execution for "add filter" button event
    public String hyperlinkAdd_action() {
        QueryNode qn = createQueryNode();
        int validate = saveInputInfo();
        if (validate == 1) {
            LinkedList<QueryNode> sessionQueryList =
                    getSnapshotSessionBean().getQueryList();
            sessionQueryList.add(qn);
            return null;
        } else {
            MessageBean.setErrorMessageFromBundle("dwc_empty_error",
                    this.getMyLocale());
            return null;
        }
    }

    //Update de linked list of filter rows
    private int saveInputInfo() {
        LinkedList<QueryNode> sessionQueryList = getSnapshotSessionBean().
                getQueryList();
        List<UIComponent> panelChildren = filtersPanel.getChildren();
        int filterRows = panelChildren.size() / FILTER_COLUMNS;

        QueryNode qn = sessionQueryList.getFirst();

        //The first filter (mandatory)
        if (isEmpty(qn, 0)) { //Validate the empty input
            saveInfoCommonWidgets(qn, 0);
            return 2;
        }
        saveInfoCommonWidgets(qn, 0);

        //...other filters (optional)
        for (int i = 1; i < filterRows; i++) {
            int offset = i * FILTER_COLUMNS;
            qn = sessionQueryList.get(i);
            //Logical operator
            int log_op_value = ((Integer) ((DropDown) panelChildren.get
                    (offset + LOG_OP_CLMN)).getSelected()).intValue();
            qn.setLogicalOperatorId(log_op_value);
            qn.setLogicalOperator((log_op_value == 1) ? "and" : "or");
            //CommonWidgets
            if (isEmpty(qn, offset)) {//Validate the empty input
                return 0;
            }
            saveInfoCommonWidgets(qn, offset);
        }
        return 1; //Everything OK
    }

    //Method to ask if the filter's textfield is empty or not
    private boolean isEmpty(QueryNode qn, int offset) {
        List<UIComponent> panelChildren = filtersPanel.getChildren();
        String input = ((TextField) panelChildren.get(offset + INPUT_CLMN)).
                getText().toString();
        if (input.equals("") || input == null) {
            return true;
        } else {
            return false;
        }
    }

    private void saveInfoCommonWidgets(QueryNode qn, int offset) {
        List<UIComponent> panelChildren = filtersPanel.getChildren();
        //DwCElement
        Long bd = (Long) ((DropDown) panelChildren.
                get(offset + DWC_CLMN)).getSelected();
        qn.setDwcElementId(bd);
        qn.setDwcElement(getSnapshotSessionBean().getReportsFacade().
                findDwcElementById(bd).getElementKeyword());
        //Comparator
        int comparatorValue = ((Integer) ((DropDown) panelChildren.get
                (offset + COMPARATOR_CLMN)).getSelected()).intValue();
        qn.setComparatorId(comparatorValue);
        qn.setComparator((comparatorValue == 1) ? "=" : "like");
        //Input
        String inputValue = ((TextField) panelChildren.get
                (offset + INPUT_CLMN)).getText().toString();
        qn.setUserEntry(inputValue);
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SnapshotSessionBean getSnapshotSessionBean() {
        return (SnapshotSessionBean) getBean("reports$SnapshotSessionBean");
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
     * @return the elementsPanel
     */
    public HtmlPanelGrid getElementsPanel() {
        return elementsPanel;
    }

    /**
     * @param elementsPanel the elementsPanel to set
     */
    public void setElementsPanel(HtmlPanelGrid elementsPanel) {
        this.elementsPanel = elementsPanel;
    }

    /**
     * @return the filtersPanel
     */
    public HtmlPanelGrid getFiltersPanel() {
        return filtersPanel;
    }

    /**
     * @param filtersPanel the filtersPanel to set
     */
    public void setFiltersPanel(HtmlPanelGrid filtersPanel) {
        this.filtersPanel = filtersPanel;
    }
    
}

