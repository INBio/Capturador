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
import com.sun.webui.jsf.component.AddRemove;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.MultipleSelectOptionsList;
import com.sun.webui.jsf.model.Option;
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
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.reports.DwcElementDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;
import org.inbio.ara.util.QueryNode;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version PreviewSpecimen.java
 * @version Created on 12/11/2009, 10:54:52 AM
 * @author esmata
 */

public class PreviewSpecimen extends AbstractPageBean {
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

    //Bindings
    private AddRemove addRemoveList1 = new AddRemove();
    private MultipleSelectOptionsList addRemoveList1DefaultOptions =
            new MultipleSelectOptionsList();
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

    //Constantes
    public static final int FILTER_COLUMNS = 5;
    public static final int LOG_OP_CLMN = 0;
    public static final int DWC_CLMN = 1;
    public static final int COMPARATOR_CLMN = 2;
    public static final int INPUT_CLMN = 3;

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PreviewSpecimen() {
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
            log("PreviewSpecimen Initialization Failure", e);
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
        this.filtersPanel.getChildren().clear();
        LinkedList<QueryNode> sessionQueryList =
                              getReportsSessionBean().getQueryList();
        if (sessionQueryList.size() == 0) {
            QueryNode qn = createQueryNode();
            sessionQueryList.add(qn);
        }
        drawFirstFilterRow(sessionQueryList.getFirst());

        if (sessionQueryList.size() > 1) {
            for (int i = 1; i < sessionQueryList.size(); i++) {
                QueryNode queryNode = sessionQueryList.get(i);
                drawExtraFilterRows(queryNode, i);
            }
        }
        this.getReportsSessionBean().setDwcFiltered(false);
        this.addRemoveList1DefaultOptions.setOptions
                (findDwCElements());
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

    public Option[] findDwCElements() {
        List<DwcElementDTO> dwcElements = this.getReportsSessionBean().
                getReportsFacadeImpl().findDwCElements();
        Option[] dwcElementOptions = new Option[dwcElements.size()];
        int i = 0;
        for (DwcElementDTO dwcElement : dwcElements) {
            dwcElementOptions[i] = new Option(dwcElement.getElementId(),
                                              BundleHelper.getDefaultBundleValue
                                              (dwcElement.getElementKeyword(),
                                              this.getMyLocale()));
            i++;
        }
        return dwcElementOptions;
    }

    /**
     * Boton para recargar el snapshot utilizado para realizar el reporte
     * @return
     */
    public String reloadButton_action() {
        //Individuales, observaciones, agrupados unitaxon
        boolean result = this.getReportsSessionBean().
                getReportsFacadeImpl().reloadDarwinCoreTable();
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

    public String addButton_action() {
        QueryNode qn = createQueryNode();
        saveInputInfo();
        LinkedList<QueryNode> sessionQueryList =
                              getReportsSessionBean().getQueryList();
        sessionQueryList.add(qn);

        return null;
    }

    public String searchButton_action() {

        boolean filtered = false;

        LinkedList<QueryNode> sessionQueryList =
                              getReportsSessionBean().getQueryList();
        filtered = saveInputInfo();
        //Print
        for (QueryNode queryNode : sessionQueryList) {
            queryNode.printNode();
        }
        //If columns weren't selected
        Object[] columns =
                 getReportsSessionBean().getDwcSelectedElements();
        if (columns == null) {
            MessageBean.setErrorMessageFromBundle("select_columns_error",
                    this.getMyLocale());
            return null;
        }
        this.getReportsSessionBean().setDwcFiltered(filtered);

        //Dejar listo el data provider para la siguiente consulta
        if(this.getReportsSessionBean().getPagination() != null){
            this.getReportsSessionBean().setPagination(null);
        }

        return "report";
    }

    private QueryNode createQueryNode() {
        DwcElementDTO e = this.getReportsSessionBean().getReportsFacadeImpl().
            findDwcElementById(new Long(1)); //default value
        return new QueryNode("or", 2, e.getElementKeyword(), e.getElementId(),
                             "like", 2, "");
    }

private void drawFirstFilterRow(QueryNode firstNode) {
        this.filtersPanel.getChildren().add(new HiddenField());
        //****************************************************
        drawCommonWidgets(firstNode, 0);
        //****************************************************
        this.filtersPanel.getChildren().add(new HiddenField());
    }

    private void drawCommonWidgets(QueryNode qn, int row) {
        //DwCElements  ******************
        DropDown dwcDD = createDwCDropDown();
        dwcDD.setId("dwcDD-" + row);
        dwcDD.setSelected(qn.getDwcElementId());
        this.filtersPanel.getChildren().add(dwcDD);

        //ComparatorElements  ******************
        DropDown dwcComp = createComparatorDropDown();
        dwcComp.setId("dwcComp-" + row);
        dwcComp.setSelected(qn.getComparatorId());
        this.filtersPanel.getChildren().add(dwcComp);

        //User Input *************************
        TextField tf = new TextField();
        tf.setId("tf-" + row);
        tf.setText(qn.getUserEntry());
        this.filtersPanel.getChildren().add(tf);
    }

    private DropDown createComparatorDropDown() {
        DropDown dd = new DropDown();
        dd.setItems(this.comparator);
        return dd;
    }

    private DropDown createDwCDropDown() {
        DropDown dd = new DropDown();
        dd.setItems(getDwCElementsInOptionForm());
        return dd;
    }

    private ArrayList<Option> getDwCElementsInOptionForm() {
        ArrayList<Option> dwcElements = new ArrayList();
        List<DwcElementDTO> rawElements = this.getReportsSessionBean().
            getReportsFacadeImpl().findDwCElements();
        for (DwcElementDTO dwcElement : rawElements) {
            dwcElements.add(new Option(dwcElement.getElementId(),
                                       BundleHelper.getDefaultBundleValue
                                       (dwcElement.getElementKeyword(),
                                       this.getMyLocale())));
        }
        return dwcElements;
    }

    private void drawExtraFilterRows(QueryNode qn, int row) {
        //Logical operators  ******************
        DropDown logicalOperatorsDD = createLogicalOperatorsDD();
        logicalOperatorsDD.setId("logicalOperator-" + row);
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
        ExpressionFactory expressionFactory = this.getApplication().getExpressionFactory();
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        MethodExpression actionMethod = expressionFactory.createMethodExpression
                (elContext,"#{reports$PreviewSpecimen.deleteClickHandler}",
                String.class, new Class[]{});

        MethodExpression listenerMethod = expressionFactory.createMethodExpression
                (elContext,"#{reports$PreviewSpecimen.deleteClickHandler}",
                null, new Class[]{ActionEvent.class});

        Hyperlink deleteLink = new Hyperlink();
        deleteLink.setId("deleteLink-" + row);
        deleteLink.setText(BundleHelper.getDefaultBundleValue("delete",
                this.getMyLocale()));

        deleteLink.setActionExpression(actionMethod);
        deleteLink.setActionListenerExpression(listenerMethod);
        this.filtersPanel.getChildren().add(deleteLink);
    }

    public String deleteClickHandler() {
        return null;
    }

    public void deleteClickHandler(ActionEvent ae) {
        saveInputInfo();
        String deleteLink = ((Hyperlink) ae.getComponent()).getId();
        String[] partsId = deleteLink.split("-");
        int index = Integer.parseInt(partsId[1]);
        getReportsSessionBean().getQueryList().remove(index);
    }

    private boolean saveInputInfo() {

        boolean result = false;

        LinkedList<QueryNode> sessionQueryList =
                              getReportsSessionBean().getQueryList();
        List<UIComponent> panelChildren = filtersPanel.getChildren();
        int filterRows = panelChildren.size() / FILTER_COLUMNS;
        //The first filter (mandatory)
        QueryNode qn = sessionQueryList.getFirst();
        if (saveInfoCommonWidgets(qn, 0)) {
            result = true;
        }

        //...other filters (optional)
        for (int i = 1; i < filterRows; i++) {
            int offset = i * FILTER_COLUMNS;
            qn = sessionQueryList.get(i);
            //Logical operator
            int log_op_value = ((Integer) ((DropDown) panelChildren.get(offset + LOG_OP_CLMN)).getSelected()).intValue();
            qn.setLogicalOperatorId(log_op_value);
            qn.setLogicalOperator((log_op_value == 1) ? "and" : "or");
            //CommonWidgets
            saveInfoCommonWidgets(qn, offset);
        }

        return result;
    }

    private boolean saveInfoCommonWidgets(QueryNode qn, int offset) {
        List<UIComponent> panelChildren = filtersPanel.getChildren();
        //DwCElementDTO
        Long bd = (Long) ((DropDown) panelChildren.get(offset + DWC_CLMN)).
                getSelected();
        qn.setDwcElementId(bd);
        qn.setDwcElement(getReportsSessionBean().getReportsFacadeImpl().
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

        if (inputValue != null && !inputValue.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ReportsSessionBean getReportsSessionBean() {
        return (ReportsSessionBean) getBean("reports$ReportsSessionBean");
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
     * @return the addRemoveList1
     */
    public AddRemove getAddRemoveList1() {
        return addRemoveList1;
    }

    /**
     * @param addRemoveList1 the addRemoveList1 to set
     */
    public void setAddRemoveList1(AddRemove addRemoveList1) {
        this.addRemoveList1 = addRemoveList1;
    }

    /**
     * @return the addRemoveList1DefaultOptions
     */
    public MultipleSelectOptionsList getAddRemoveList1DefaultOptions() {
        return addRemoveList1DefaultOptions;
    }

    /**
     * @param addRemoveList1DefaultOptions the addRemoveList1DefaultOptions to set
     */
    public void setAddRemoveList1DefaultOptions(MultipleSelectOptionsList addRemoveList1DefaultOptions) {
        this.addRemoveList1DefaultOptions = addRemoveList1DefaultOptions;
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

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }
    
}

