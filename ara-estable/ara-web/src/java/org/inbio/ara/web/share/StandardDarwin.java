/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.web.share;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.inbio.ara.persistence.specimen.DwcElement;
import org.inbio.ara.util.QueryNode;
import org.inbio.ara.util.StandardNode;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.admin.selectionlist.SelectionListSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.util.SelectionListBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.RequestBean1;
import org.inbio.ara.web.admin.collection.AdminCollectionSessionBean;
import org.inbio.ara.web.gathering.GatheringDetailSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.AraRequestBean;
import org.inbio.ara.web.SessionBean1;
import org.inbio.ara.web.identification.IdentificationSessionBean;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.site.SiteSessionBean;
import org.inbio.ara.web.specimen.EditSpecimenSessionBean;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.gathering.SpecimenGenerationSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.util.BundleHelper;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version StandardDarwin.java
 * @version Created on 23/03/2009, 08:31:40 AM
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

    //Variables defined by developer
    private HtmlPanelGrid filtersPanel = new HtmlPanelGrid();
    private HtmlPanelGrid elementsPanel = new HtmlPanelGrid();
    Option[] comparator = {new Option(1, BundleHelper.getDefaultBundleValue("dwc_equal")),new Option(2, BundleHelper.getDefaultBundleValue("dwc_like"))};
    Option[] logicalOperator = {new Option(1, BundleHelper.getDefaultBundleValue("dwc_and")),new Option(2, BundleHelper.getDefaultBundleValue("dwc_or"))};
    List<UIComponent> MycheckBoxList = elementsPanel.getChildren(); // List of checkboxs components

    //Constants defined by developer
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
        LinkedList<StandardNode> ElementList = getshare$SessionBeanShare().findDwCElements();
        //Generate the ckeckboxs and load the list of checkbox
        for(int i=0;i<ElementList.size();i++){
            StandardNode node = ElementList.get(i);
            drawElement(node,i);
        }
        //---------- Rendering the darwin core filters ----------
        this.filtersPanel.getChildren().clear();
        LinkedList<QueryNode> sessionQueryList = getshare$SessionBeanShare().getQueryList();
        if(sessionQueryList.size() == 0) {
            QueryNode qn = createQueryNode();
            sessionQueryList.add(qn);
        }
        drawFirstFilterRow(sessionQueryList.getFirst()); //Draw the first row
        if(sessionQueryList.size() > 1) {
            for (int i=1; i<sessionQueryList.size(); i++) {
                QueryNode queryNode = sessionQueryList.get(i);
                drawExtraFilterRows(queryNode, i); //Draw the rest of rows
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean) getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SelectionListSessionBean getadmin$selectionlist$SelectionListSessionBean() {
        return (SelectionListSessionBean) getBean("admin$selectionlist$SelectionListSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
        return (ProfileSessionBean) getBean("admin$profile$ProfileSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SelectionListBean getutil$SelectionListBean() {
        return (SelectionListBean) getBean("util$SelectionListBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
        return (GatheringSessionBeanV2) getBean("gathering$GatheringSessionBeanV2");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AudienceSessionBean getaudience$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("audience$AudienceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBeanShare getshare$SessionBeanShare() {
        return (SessionBeanShare) getBean("share$SessionBeanShare");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PersonSessionBean getadmin$person$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$person$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AdminCollectionSessionBean getadmin$collection$AdminCollectionSessionBean() {
        return (AdminCollectionSessionBean) getBean("admin$collection$AdminCollectionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("gathering$GatheringDetailSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean) getBean("references$ReferenceSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected NomenclaturalGroupSessionBean getnomenclaturalgroup$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean) getBean("nomenclaturalgroup$NomenclaturalGroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean) getBean("AraRequestBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("identification$IdentificationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpecimenSessionBean getspecimen$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("specimen$SpecimenSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SiteSessionBean getsite$SiteSessionBean() {
        return (SiteSessionBean) getBean("site$SiteSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected EditSpecimenSessionBean getspecimen$EditSpecimenSessionBean() {
        return (EditSpecimenSessionBean) getBean("specimen$EditSpecimenSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
        return (InstitutionSessionBean) getBean("admin$institution$InstitutionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (SpeciesSessionBean) getBean("species$SpeciesSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean) getBean("AraApplicationBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("gathering$SpecimenGenerationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IdentificationSearchSessionBean getidentification$IdentificationSearchSessionBean() {
        return (IdentificationSearchSessionBean) getBean("identification$IdentificationSearchSessionBean");
    }

    //-----------------------------------------------------------------------------------------------------

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

    //Create an instance of QueryNode class with DwC default element
    private QueryNode createQueryNode() {
        DwcElement e = this.getshare$SessionBeanShare().getShareBR().getDwCElementByIdB(new BigDecimal(1));
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
        List<DwcElement> rawElements = this.getshare$SessionBeanShare().getShareBR().getDwCElementsB();
        for (DwcElement dwcElement : rawElements) {
            dwcElements.add (new Option(dwcElement.getElementId(),
                    BundleHelper.getDefaultBundleValue(dwcElement.
                        getElementKeyword())));
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
        ExpressionFactory expressionFactory = this.getApplication().getExpressionFactory();
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        MethodExpression actionMethod = expressionFactory.createMethodExpression(elContext,
                "#{share$StandardDarwin.deleteClickHandler}", String.class, new Class[]{});

        MethodExpression listenerMethod = expressionFactory.createMethodExpression(elContext,
                "#{share$StandardDarwin.deleteClickHandler}",
                null, new Class[]{ActionEvent.class});

        Hyperlink deleteLink = new Hyperlink();
        deleteLink.setId("deleteLink-" + row);
        deleteLink.setText(BundleHelper.getDefaultBundleValue("delete"));

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
        getshare$SessionBeanShare().getQueryList().remove(index);
    }
        public String deleteClickHandler() {
        return null;
    }
    //Update de linked list of filter rows
    private int saveInputInfo() {
        LinkedList<QueryNode> sessionQueryList = getshare$SessionBeanShare().getQueryList();
        List<UIComponent> panelChildren = filtersPanel.getChildren();
        int filterRows = panelChildren.size() / FILTER_COLUMNS;

        QueryNode qn = sessionQueryList.getFirst();

        //the first filter (mandatory)
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
            int log_op_value = ((Integer) ((DropDown) panelChildren.get(offset + LOG_OP_CLMN)).getSelected()).intValue();
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
        String input = ((TextField) panelChildren.get(offset + INPUT_CLMN)).getText().toString();
        if (input.equals("") || input == null) {
            return true;
        } else {
            return false;
        }
    }
    private void saveInfoCommonWidgets(QueryNode qn, int offset) {
        List<UIComponent> panelChildren = filtersPanel.getChildren();
        //DwCElement
        BigDecimal bd = (BigDecimal) ((DropDown) panelChildren.get(offset + DWC_CLMN)).getSelected();
        qn.setDwcElementId(bd);
        qn.setDwcElement(getshare$SessionBeanShare().getShareBR().getDwCElementByIdB(bd).getElementKeyword());
        //Comparator
        int comparatorValue = ((Integer) ((DropDown) panelChildren.get(offset + COMPARATOR_CLMN)).getSelected()).intValue();
        qn.setComparatorId(comparatorValue);
        qn.setComparator((comparatorValue == 1) ? "=" : "like");
        //Input
        String inputValue = ((TextField) panelChildren.get(offset + INPUT_CLMN)).getText().toString();
        qn.setUserEntry(inputValue);
    }

    //Method to draw the checkbox on elementsPanel
    private void drawElement(StandardNode sn, int id) {
        //CheckBox elements
        Checkbox chb = new Checkbox();
        chb.setId(sn.getKeyword());
        chb.setStyle("font-size: 11px");
        String label = BundleHelper.getDefaultBundleValue(sn.getKeyword());
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

    //Code execution for "share info" button event
    public String bshareAll_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        String result = getshare$SessionBeanShare().createDwcSnapshotAll();
        if (result.equals("success")) {
            //Set to null the query  list (filters)
            LinkedList<QueryNode> llaux = new LinkedList();
            getshare$SessionBeanShare().setQueryList(llaux);
            return "dwcSuccess";
        }
        if (result.equals("fail")) {
            MessageBean.setErrorMessageFromBundle("dwc_snapshot_error");
        }
        return null;
    }

    //Code execution for "share info" button event
    public String bshare_action() {
        //Save the filter info
        int validate = saveInputInfo();
        if (validate == 1 || validate == 2) {
            //Iterate over MycheckBoxList to get the selected elements (element id)
            LinkedList<String> selectedElements = getSelectedelements();
            getshare$SessionBeanShare().setElementList(selectedElements);
            //Create the snapshot
            String result = getshare$SessionBeanShare().createDwcSnapshot(validate);
            if (result.equals("success")) {
                //Set to null the query  list (filters)
                LinkedList<QueryNode> llaux = new LinkedList();
                getshare$SessionBeanShare().setQueryList(llaux);
                return "dwcSuccess";
            }
            if (result.equals("fail")) {
                MessageBean.setErrorMessageFromBundle("dwc_snapshot_error");
            }
            //Finally
            return null;
        } else {
            MessageBean.setErrorMessageFromBundle("dwc_empty_error");
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

    //Code execution for "add filter" button event
    public String hyperlinkAdd_action() {
        QueryNode qn = createQueryNode();
        int validate = saveInputInfo();
        if (validate == 1) {
            LinkedList<QueryNode> sessionQueryList = getshare$SessionBeanShare().getQueryList();
            sessionQueryList.add(qn);
            return null;
        } else {
            MessageBean.setErrorMessageFromBundle("dwc_empty_error");
            return null;
        }
    }

    public String buttonReload_action() {
        String result = getshare$SessionBeanShare().getShareBR().createDwCTable();
        if (result.equals("success")) {
            MessageBean.setSuccessMessageFromBundle("dwc_14_success");
        } else {
            MessageBean.setErrorMessageFromBundle("dwc_14_fail");
        }
        return null;
    }
}
