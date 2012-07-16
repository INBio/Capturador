/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.label;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Tab;
import com.sun.webui.jsf.component.TabSet;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.taxonomy.NomenclaturalGroupSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.reports.ReportsSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.germplasm.AccessionSessionBean;
import org.inbio.ara.taxonomy.TaxonomySessionBean;
import org.inbio.ara.germplasm.PassportListSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.germplasm.PassportSessionBean;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.gis.SiteSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import javax.faces.component.html.HtmlInputTextarea;
import com.sun.webui.jsf.component.Table;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import org.inbio.ara.dto.label.HistoryLabelDTO;
import org.inbio.ara.dto.label.LabelDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditLabel.java
 * @version Created on 16/04/2010, 09:37:37 AM
 * @author paulacorrales
 */
public class EditLabel extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    private HtmlInputTextarea txaLabelHistory = new HtmlInputTextarea();
    private HtmlInputTextarea txaOriginalLabel = new HtmlInputTextarea();
    private HtmlInputTextarea txaCorrectLabel = new HtmlInputTextarea();
    private HtmlInputTextarea txaLabel = new HtmlInputTextarea();

    private HtmlCommandButton btnCancel = new HtmlCommandButton();


    //Data table binding for table who show the  history labels
    private HtmlDataTable dataTableHistoryLabels = new HtmlDataTable();


    //Data table binding para la tabla que muetra los especimnes
    private HtmlDataTable dataTableReviserLabels = new HtmlDataTable();


    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();

    //TabSet binding  for taba set who contains the tab
    private TabSet tabSet = new TabSet();

    private  Tab  tabLabel = new Tab();
    private  Tab  tabHistory = new Tab();
    private  Tab  tabOriginal = new Tab();
    private  Tab  tabCorrection = new Tab();

    //Bindings para la tabla que se utiliza para listar los especimenes
    private Table specimenTable = new Table();

     //Bindings 
    private Table labelTable = new Table();

     //Bindings 
    private Table originalLabelTable = new Table();

    private com.sun.webui.jsf.component.Label  labelTitle = new  com.sun.webui.jsf.component.Label();

    



    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditLabel() {

        
        //show the number  or id of specimen  selected
        String value =  BundleHelper.getDefaultBundleValue("LabelNumber",getMyLocale()) + this.getlabel$LabelSessionBean().getCurrentSpecimenDTO().getLabelId().toString();
        this.getLabelTitle().setText(value);

         //this.getlabel$LabelSessionBean().setBanderaInit(true);
         //this.getlabel$LabelSessionBean().setVisualizeHistoryLabel(false);
         //this.getlabel$LabelSessionBean().setVisualizeCorrectionLabel(false);

          //this.getlabel$LabelSessionBean().initDataProvider();

        
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

        String value =    BundleHelper.getDefaultBundleValue("LabelNumber",getMyLocale())  + this.getlabel$LabelSessionBean().getCurrentSpecimenDTO().getLabelId().toString();
        this.getLabelTitle().setText(value);

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
            log("EditLabel Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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

        String value =    BundleHelper.getDefaultBundleValue("LabelNumber",getMyLocale())  + this.getlabel$LabelSessionBean().getCurrentSpecimenDTO().getLabelId().toString();
        this.getLabelTitle().setText(value);


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


        String value =    BundleHelper.getDefaultBundleValue("LabelNumber",getMyLocale())  + this.getlabel$LabelSessionBean().getCurrentSpecimenDTO().getLabelId().toString();
        this.getLabelTitle().setText(value);

        //cargar los datos del specimen sellecionado

        String contenidoLabel = this.getlabel$LabelSessionBean().findLabelById().getContents();
        String contenidoOriginalLabel = this.getlabel$LabelSessionBean().findOriginalLabelById().getContents();

        this.getTxaLabel().setValue(contenidoLabel);
        this.getTxaOriginalLabel().setValue(contenidoOriginalLabel);

        this.getlabel$LabelSessionBean().setBanderaInit(false);
        this.getlabel$LabelSessionBean().initDataProvider();
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> m
     * ethods (or
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
    protected NomenclaturalGroupSessionBean gettaxonomy$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean) getBean("taxonomy$NomenclaturalGroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected LabelSessionBean getlabel$LabelSessionBean() {
        return (LabelSessionBean) getBean("label$LabelSessionBean");
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
    protected GatheringSessionBean getinventory$GatheringSessionBean() {
        return (GatheringSessionBean) getBean("inventory$GatheringSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ReportsSessionBean getreports$ReportsSessionBean() {
        return (ReportsSessionBean) getBean("reports$ReportsSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PersonSessionBean getadmin$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$PersonSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AccessionSessionBean getgermplasm$AccessionSessionBean() {
        return (AccessionSessionBean) getBean("germplasm$AccessionSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected TaxonomySessionBean gettaxonomy$TaxonomySessionBean() {
        return (TaxonomySessionBean) getBean("taxonomy$TaxonomySessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PassportListSessionBean getgermplasm$PassportListSessionBean() {
        return (PassportListSessionBean) getBean("germplasm$PassportListSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ValidatorBean getutil$ValidatorBean() {
        return (ValidatorBean) getBean("util$ValidatorBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected IdentificationSessionBean getinventory$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("inventory$IdentificationSessionBean");
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
    protected PassportSessionBean getgermplasm$PassportSessionBean() {
        return (PassportSessionBean) getBean("germplasm$PassportSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("inventory$SpecimenGenerationSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SiteSessionBean getgis$SiteSessionBean() {
        return (SiteSessionBean) getBean("gis$SiteSessionBean");
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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

  

    /**
     * @return the txaLabel
     */
    public HtmlInputTextarea getTxaLabel() {
        return txaLabel;
    }

    /**
     * @param txaLabel the txaLabel to set
     */
    public void setTxaLabel(HtmlInputTextarea txaLabel) {
        this.txaLabel = txaLabel;
    }

    /**
     * @return the txaLabelHistory
     */
    public HtmlInputTextarea getTxaLabelHistory() {
        return txaLabelHistory;
    }

    /**
     * @param txaLabelHistory the txaLabelHistory to set
     */
    public void setTxaLabelHistory(HtmlInputTextarea txaLabelHistory) {
        this.txaLabelHistory = txaLabelHistory;
    }

    /**
     * @return the txaOriginalLabel
     */
    public HtmlInputTextarea getTxaOriginalLabel() {
        return txaOriginalLabel;
    }

    /**
     * @param txaOriginalLabel the txaOriginalLabel to set
     */
    public void setTxaOriginalLabel(HtmlInputTextarea txaOriginalLabel) {
        this.txaOriginalLabel = txaOriginalLabel;
    }

    /**
     * @return the txaCorrectLabel
     */
    public HtmlInputTextarea getTxaCorrectLabel() {
        return txaCorrectLabel;
    }

    /**
     * @param txaCorrectLabel the txaCorrectLabel to set
     */
    public void setTxaCorrectLabel(HtmlInputTextarea txaCorrectLabel) {
        this.txaCorrectLabel = txaCorrectLabel;
    }



    /**
     * @return the specimenTable
     */
    public Table getSpecimenTable() {
        return specimenTable;
    }

    /**
     * @param specimenTable the specimenTable to set
     */
    public void setSpecimenTable(Table specimenTable) {
        this.specimenTable = specimenTable;
    }


    /**
     * @return the tabSet
     */
    public TabSet getTabSet() {
        return tabSet;
    }

    /**
     * @param tabSet the tabSet to set
     */
    public void setTabSet(TabSet tabSet) {
        this.tabSet = tabSet;
    }

    /**
     * @return the dataTableHistoryLabels
     */
    public HtmlDataTable getDataTableHistoryLabels() {
        return dataTableHistoryLabels;
    }

    /**
     * @param dataTableHistoryLabels the dataTableHistoryLabels to set
     */
    public void setDataTableHistoryLabels(HtmlDataTable dataTableHistoryLabels) {
        this.dataTableHistoryLabels = dataTableHistoryLabels;
    }

    /**
     * @return the labelTable
     */
    public Table getLabelTable() {
        return labelTable;
    }

    /**
     * @param labelTable the labelTable to set
     */
    public void setLabelTable(Table labelTable) {
        this.labelTable = labelTable;
    }

    /**
     * @return the originalLabelTable
     */
    public Table getOriginalLabelTable() {
        return originalLabelTable;
    }

    /**
     * @param originalLabelTable the originalLabelTable to set
     */
    public void setOriginalLabelTable(Table originalLabelTable) {
        this.originalLabelTable = originalLabelTable;
    }

    /**
     * @return the tabLabel
     */
    public Tab getTabLabel() {
        return tabLabel;
    }

    /**
     * @param tabLabel the tabLabel to set
     */
    public void setTabLabel(Tab tabLabel) {
        this.tabLabel = tabLabel;
    }

    /**
     * @return the tabHistory
     */
    public Tab getTabHistory() {
        return tabHistory;
    }

    /**
     * @param tabHistory the tabHistory to set
     */
    public void setTabHistory(Tab tabHistory) {
        this.tabHistory = tabHistory;
    }

    /**
     * @return the tabOriginal
     */
    public Tab getTabOriginal() {
        return tabOriginal;
    }

    /**
     * @param tabOriginal the tabOriginal to set
     */
    public void setTabOriginal(Tab tabOriginal) {
        this.tabOriginal = tabOriginal;
    }

    /**
     * @return the tabReviser
     */
    public Tab getTabReviser() {
        return tabCorrection;
    }

    /**
     * @param tabReviser the tabReviser to set
     */
    public void setTabReviser(Tab tabReviser) {
        this.tabCorrection = tabReviser;
    }

    /**
     * @return the dataTableReviserLabels
     */
    public HtmlDataTable getDataTableReviserLabels() {
        return dataTableReviserLabels;
    }

    /**
     * @param dataTableReviserLabels the dataTableReviserLabels to set
     */
    public void setDataTableReviserLabels(HtmlDataTable dataTableReviserLabels) {
        this.dataTableReviserLabels = dataTableReviserLabels;
    }

      /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        try
           {
              quantityTotal = this.getlabel$LabelSessionBean().getQuantityTotal();
              return quantityTotal;
           }
        catch(Exception e)
        {
            return null;
        }
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * select the type of labels to display in the pages controller, type = correct label
     */
    public String  selectLabelHistory()
     {
        this.getlabel$LabelSessionBean().setVisualizeHistoryLabel(true);
        this.getlabel$LabelSessionBean().setVisualizeCorrectionLabel(false);
        this.getlabel$LabelSessionBean().initDataProvider();

        return null;

     }


    /**
     * select the type of labels to display in the pages controller, type = correct label
     */
     public String selectCorrectionLabel()
     {
        this.getlabel$LabelSessionBean().setVisualizeCorrectionLabel(true);
        this.getlabel$LabelSessionBean().setVisualizeHistoryLabel(false);
        this.getlabel$LabelSessionBean().initDataProvider();

        return null;

     }


     /**
      *  modify the style of  tinymce ,  to write new correction
      * @return
      */
     public String btnNewCorrectionLabelAction() {

         this.getTxaCorrectLabel().setStyleClass("mceSimple");
         return null;

      }
     
   /***
    * Visualizer the correction labels  asociated  a selected label
    * @return
    */
    public String btnViewCorrectionLabelAction() {

        System.out.println("correctores............");

        this.getTxaCorrectLabel().setStyleClass("mceAdvanced");
        
        int n = this.getDataTableReviserLabels().getRowCount();
        ArrayList<LabelDTO> selectedLabels = new ArrayList();
        
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableReviserLabels().setRowIndex(i);
            LabelDTO thislabel = (LabelDTO) this.getDataTableReviserLabels().getRowData();
            if (thislabel.isSelected()) {
                selectedLabels .add(thislabel);
            }
        }
        if(selectedLabels  == null || selectedLabels .size() == 0){ //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedLabels .size() == 1 ){ //En caso de que solo se seleccione un elemento
            this.getlabel$LabelSessionBean().setCurrentLabelReviserDTO(selectedLabels.get(0));
            System.out.println(this.getlabel$LabelSessionBean().getCurrentLabelReviserDTO().getContents());
            this.getTxaCorrectLabel().setValue(this.getlabel$LabelSessionBean().getCurrentLabelReviserDTO().getContents());
            return null;
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /***
     * cargar en el  campo de texto el contenido de la etiqueta original
     * @return
     */
    public String btnEditOriginalAction() {

       this.getlabel$LabelSessionBean().getCurrentOriginalLabelDTO().setContents(this.getTxaOriginalLabel().getValue().toString());
       return null;
          
    }
    /***
     * show the list of   history label asociated
     * @return
     */
    public String btnViewLabelHistoryAction() {

        this.btnCancel.setDisabled(true);
        System.out.println("historicassssssssss");

        int n = this.getDataTableHistoryLabels().getRowCount();
        ArrayList<HistoryLabelDTO> selectedHistoryLabel = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableHistoryLabels().setRowIndex(i);
            HistoryLabelDTO thislabel = (HistoryLabelDTO) this.getDataTableHistoryLabels().getRowData();
            if ( thislabel.isSelected()) {
                selectedHistoryLabel.add(thislabel);
            }
        }
        if(selectedHistoryLabel == null || selectedHistoryLabel.size() == 0){ //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedHistoryLabel.size() == 1 ){ //En caso de que solo se seleccione un elemento
            this.getlabel$LabelSessionBean().setCurrentLabelHistoryDTO(selectedHistoryLabel.get(0));
            this.getTxaLabelHistory().setValue(this.getlabel$LabelSessionBean().getCurrentLabelHistoryDTO().getContents());
            
            return null;
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }


    /**
     * This method save the new corrector label
     * @return
     */
    public String btnSaveCorrectionLabel() {

        String  contents = this.txaCorrectLabel.getValue().toString();
        
        if (contents != null)
        {
            this.getlabel$LabelSessionBean().createCorrectionLabel(contents);
        }
        return null;
    }


    /**
     * @return the btnCancel
     */
    public HtmlCommandButton getBtnCancel() {
        return btnCancel;
    }

    /**
     * @param btnCancel the btnCancel to set
     */
    public void setBtnCancel(HtmlCommandButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    /**
     * @return the labelTitle
     */
    public com.sun.webui.jsf.component.Label getLabelTitle() {
        return labelTitle;
    }

    /**
     * @param labelTitle the labelTitle to set
     */
    public void setLabelTitle(com.sun.webui.jsf.component.Label labelTitle) {
        this.labelTitle = labelTitle;
    }
}

