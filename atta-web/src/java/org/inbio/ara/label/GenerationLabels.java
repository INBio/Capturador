/*
 * this class is responsible to generate and print labels specimen that the user has selected for processing.
 * pcorrales
 */

package org.inbio.ara.label;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.reports.SnapshotSessionBean;
import org.inbio.ara.admin.AdminGeographicLayersSessionBean;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.statistics.StatisticsSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.admin.InstitutionSessionBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.dto.format.ReportLayoutDTO;
import org.inbio.ara.germplasm.AccessionMovementSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.germplasm.AccessionSessionBean;
import org.inbio.ara.taxonomy.SpeciesSessionBean;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.reports.ReportsSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.germplasm.PassportListSessionBean;
import org.inbio.ara.germplasm.PassportSessionBean;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;
import org.inbio.ara.util.TypeLabels;
import javax.faces.component.html.HtmlInputTextarea;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version GenerationLabels.java
 * @version Created on 21/04/2010, 04:25:34 PM
 * @author paulacorrales
 */

public class GenerationLabels extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>


    private boolean  firstTime = true;

    private DropDown ddTypeLabel = new DropDown();
    private DropDown ddTypeFormat = new DropDown();
    private SingleSelectOptionsList typeLabelData = new SingleSelectOptionsList();
    private SingleSelectOptionsList typeFormatLabelData = new SingleSelectOptionsList();

    private HtmlCommandButton btnExportWithFormat = new HtmlCommandButton();
    private HtmlCommandButton btnExportWithoutFormat = new HtmlCommandButton();

    
    private HtmlInputTextarea txaFormatLabel = new HtmlInputTextarea();



    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public GenerationLabels() {
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
            log("GenerationLabels Initialization Failure", e);
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
    public void prerender()
    {
         if(this.firstTime){
             this.setTypeFormatDropDownData();
             this.setTypeLabelsDropDownData();
            
            firstTime = false;
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
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
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
    protected SnapshotSessionBean getreports$SnapshotSessionBean() {
        return (SnapshotSessionBean) getBean("reports$SnapshotSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AdminGeographicLayersSessionBean getadmin$AdminGeographicLayersSessionBean() {
        return (AdminGeographicLayersSessionBean) getBean("admin$AdminGeographicLayersSessionBean");
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
    protected SelectionListSessionBean getadmin$SelectionListSessionBean() {
        return (SelectionListSessionBean) getBean("admin$SelectionListSessionBean");
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
    protected ValidatorBean getutil$ValidatorBean() {
        return (ValidatorBean) getBean("util$ValidatorBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected InstitutionSessionBean getadmin$InstitutionSessionBean() {
        return (InstitutionSessionBean) getBean("admin$InstitutionSessionBean");
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
    protected LabelSessionBean getlabel$LabelSessionBean() {
        return (LabelSessionBean) getBean("label$LabelSessionBean");
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
    protected AccessionMovementSessionBean getgermplasm$AccessionMovementSessionBean() {
        return (AccessionMovementSessionBean) getBean("germplasm$AccessionMovementSessionBean");
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
    protected AccessionSessionBean getgermplasm$AccessionSessionBean() {
        return (AccessionSessionBean) getBean("germplasm$AccessionSessionBean");
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
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("inventory$SpecimenGenerationSessionBean");
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
    protected GatheringSessionBean getinventory$GatheringSessionBean() {
        return (GatheringSessionBean) getBean("inventory$GatheringSessionBean");
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
    protected PassportSessionBean getgermplasm$PassportSessionBean() {
        return (PassportSessionBean) getBean("germplasm$PassportSessionBean");
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
     * @return the ddTypeLabel
     */
    public DropDown getDdTypeLabel() {
        return ddTypeLabel;
    }

    /**
     * @param ddTypeLabel the ddTypeLabel to set
     */
    public void setDdTypeLabel(DropDown ddTypeLabel) {
        this.ddTypeLabel = ddTypeLabel;
    }

    /**
     * @return the ddTypeFormat
     */
    public DropDown getDdTypeFormat() {
        return ddTypeFormat;
    }

    /**
     * @param ddTypeFormat the ddTypeFormat to set
     */
    public void setDdTypeFormat(DropDown ddTypeFormat) {
        this.ddTypeFormat = ddTypeFormat;
    }



    /**
     * @return the typeLabelData
     */
    public SingleSelectOptionsList getTypeLabelData() {
        return typeLabelData;
    }

    /**
     * @param typeLabelData the typeLabelData to set
     */
    public void setTypeLabelData(SingleSelectOptionsList typeLabelData) {
        this.typeLabelData = typeLabelData;
    }

    /**
     * @return the typeFormatLabelData
     */
    public SingleSelectOptionsList getTypeFormatLabelData() {
        return typeFormatLabelData;
    }

    /**
     * @param typeFormatLabelData the typeFormatLabelData to set
     */
    public void setTypeFormatLabelData(SingleSelectOptionsList typeFormatLabelData) {
        this.typeFormatLabelData = typeFormatLabelData;
    }


   /**
     * Obtener los datos del drop down de instituciones
     * se cargarn del enum TypeLabels
     */
    public void setTypeLabelsDropDownData()
    {
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
      
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);


        // get the values of the TypeLabels
        for (TypeLabels ta : TypeLabels.values()) {
            option = new Option(ta.getId(),BundleHelper.getDefaultBundleValue(ta.getResource(),getMyLocale()));
            if(!(ta.getId().equals(ta.CORRECTION_LABEL.getId())))
                allOptions.add(option);
        }
        
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.getTypeLabelData().setOptions(allOptions.toArray(allOptionsInArray));

        
    }

    public void setTypeFormatDropDownData()
    {
         List<ReportLayoutDTO> reportLayoutDTOList = this.getlabel$LabelSessionBean().SetReportLayoutDropDownData();

         ArrayList<Option> allOptions = new ArrayList<Option>();
         Option[] allOptionsInArray;
         Option option;

         
         if(reportLayoutDTOList!=null)
         {
                //Crear opcion titulo
                option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
                allOptions.add(option);
                
                //Crear todas las opciones del drop down
                for(ReportLayoutDTO report : reportLayoutDTOList)
                {
                    option = new Option(report.getReportLayoutId(), report.getReportLayoutkeyWord());
                    allOptions.add(option);
                }

          }


        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        this.getTypeFormatLabelData().setOptions(allOptions.toArray(allOptionsInArray));

    }

    


   /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    
    /**
     * @return the btnExportWithFormat
     */
    public HtmlCommandButton getBtnExportWithFormat() {
        return btnExportWithFormat;
    }

    /**
     * @param btnExportWithFormat the btnExportWithFormat to set
     */
    public void setBtnExportWithFormat(HtmlCommandButton btnExportWithFormat) {
        this.btnExportWithFormat = btnExportWithFormat;
    }

    /**
     * @return the btnExportWithoutFormat
     */
    public HtmlCommandButton getBtnExportWithoutFormat() {
        return btnExportWithoutFormat;
    }

    /**
     * @param btnExportWithoutFormat the btnExportWithoutFormat to set
     */
    public void setBtnExportWithoutFormat(HtmlCommandButton btnExportWithoutFormat) {
        this.btnExportWithoutFormat = btnExportWithoutFormat;
    }


    /**
     * imprimir y generar sin formato
     * @return
     */
    public String btnExportWithoutFormat_action() {
        return null;
     }

    /**
   * generated the labels  and send the message about the  result of the generated label (succesfull or error)
   * @return
   */
    public String btnGenerated_action() {

      //parser the format
      Long formatId = this.getlabel$LabelSessionBean().getSelectedTypeFormat();
      Long typeLabelId = this.getlabel$LabelSessionBean().getSelectedTypeLabel();
      String contents =  this.txaFormatLabel.getValue().toString();
    
      
      if(formatId != null  &&  typeLabelId  != null)
      {
          
            if (this.getlabel$LabelSessionBean().createLabels(formatId, typeLabelId,contents))
            {
                MessageBean.setSuccessMessageFromBundle("confirmation_created_label", this.getMyLocale());
                return null;
            }
            else
            {
                MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            }
      }
      else
      {
          MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
      }

      return null;
     
    }

    
    /**
     * print the  label of selected specimen
     * @return
     */
    public String btnPrint_action()
    {
       this.getlabel$LabelSessionBean().PrintLabel();
       return null;
   }

   

    /**
     * @return the txaFormatLabel
     */
    public HtmlInputTextarea getTxaFormatLabel() {
        return txaFormatLabel;
    }

    /**
     * @param txaFormatLabel the txaFormatLabel to set
     */
    public void setTxaFormatLabel(HtmlInputTextarea txaFormatLabel) {
        this.txaFormatLabel = txaFormatLabel;
    }

    

    public  String  getFormatLabelContents()
    {

        if(this.getlabel$LabelSessionBean().getSelectedTypeFormat()  !=  null)
        {
            Long id = new Long(this.getlabel$LabelSessionBean().getSelectedTypeFormat());
            this.getTxaFormatLabel().setValue(this.getlabel$LabelSessionBean().getFormatFacade().getReportLayoutContents(id));
        }

       return null;
    }
    
}

