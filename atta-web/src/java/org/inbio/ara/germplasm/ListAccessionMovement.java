/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Label;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.gis.SiteSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.dto.germplasm.AccessionMovementDTO;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.taxonomy.SpeciesSessionBean;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;
import org.inbio.ara.admin.CollectionSessionBean;
import org.inbio.ara.taxonomy.NomenclaturalGroupSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version AccessionMovement.java
 * @version Created on 10/03/2010, 04:04:22 PM
 * @author dasolano
 */

public class ListAccessionMovement extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();
    //Data table binding para la tabla que muetra los passport
    private HtmlDataTable dataTableAccessionMovements = new HtmlDataTable();


    private Label lbTitle = new Label();
    private Label lbTitle2 = new Label();


    /*Componentes para las busquedas*/
    private HtmlInputText txSearch = new HtmlInputText(); //Input text de busqueda simple
    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();
    private HtmlCommandButton btnSearch = new HtmlCommandButton(); //Boton busqueda simple
    private HtmlCommandButton btnAdvSearch = new HtmlCommandButton(); //Boton busqueda avanzada

    //componentes para busuqedas avanzadas

    /*private TextField textfieldGatheringId = new TextField();
    private TextField textfieldPassportId = new TextField();
    private Calendar plantNurseryDate = new Calendar();
    private Calendar plantingSeasonDate = new Calendar();
    private Calendar harvestingSeasonDate = new Calendar();
    private SingleSelectOptionsList donorPersons = new SingleSelectOptionsList();
    private SingleSelectOptionsList donorInstitutions = new SingleSelectOptionsList();
    private SingleSelectOptionsList materialTypes = new SingleSelectOptionsList();
    private SingleSelectOptionsList sampleStatus = new SingleSelectOptionsList();*/
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListAccessionMovement() {
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
            log("AccessionMovement Initialization Failure", e);
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
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
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
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {

        if(get$AccessionMovementSessionBean().getAccessionDTO().getAccessionNumber() != null)
            getLbTitle().setText(BundleHelper.getDefaultBundleValue("accession_movements", this.getMyLocale()) + "  " +
                    get$AccessionMovementSessionBean().getAccessionDTO().getAccessionNumber());
        
        if(get$AccessionMovementSessionBean().getAccessionDTO().getCurrentWeigth() != null)
            getLbTitle2().setText(BundleHelper.getDefaultBundleValue("current_weigth", this.getMyLocale()) + "  " +
                    get$AccessionMovementSessionBean().getAccessionDTO().getCurrentWeigth());


        if(get$AccessionMovementSessionBean().isFirstTime())
        {
          
            dataTableAccessionMovements = new HtmlDataTable();
            quantityTotal = new String();
            get$AccessionMovementSessionBean().setFirstTime(false);
        }

        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(get$AccessionMovementSessionBean().isAdvancedSearch()){
          
            this.getGridpAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
        }

        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        if (get$AccessionMovementSessionBean().getPagination()==null) {
            get$AccessionMovementSessionBean().initDataProvider();
        }
        //Actualizar los datos del paginador
        else
            get$AccessionMovementSessionBean().getPagination().refreshList();

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

    public String btn_new_action()
    {
        //resetValues
        get$AccessionMovementSessionBean().setAccessionMovementDTO(
                new AccessionMovementDTO());
        return "new";
    }

    public String btn_edit_action()
    {
        //reset values
        get$AccessionMovementSessionBean().setAccessionMovementDTO(
                new AccessionMovementDTO());

        //set the movement
        int n = this.getDataTableAccessionMovements().getRowCount();
        ArrayList<AccessionMovementDTO> selectedAccessionMovement = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableAccessionMovements().setRowIndex(i);
            AccessionMovementDTO aux = (AccessionMovementDTO) this.
                    getDataTableAccessionMovements().getRowData();
            if (aux.isSelected()) {
                selectedAccessionMovement.add(aux);
            }
        }
        if(selectedAccessionMovement == null || selectedAccessionMovement.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedAccessionMovement.size() == 1){ //En caso de que solo se seleccione un elemento

            //set the AccessionMovementDTO
            get$AccessionMovementSessionBean().setAccessionMovementDTO(selectedAccessionMovement.get(0));

            //set the original weight of the movement
            get$AccessionMovementSessionBean().setActualWeight(selectedAccessionMovement.get(0).getWeight());
            //Llamada al jsp encargado de la edicion de accessiones
            return "edit";

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }


    public String btn_delete_action()
    {
        //reset values
        get$AccessionMovementSessionBean().setAccessionMovementDTO(
                new AccessionMovementDTO());

        //set the movement
        int n = this.getDataTableAccessionMovements().getRowCount();
        ArrayList<AccessionMovementDTO> selectedAccessionMovement = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableAccessionMovements().setRowIndex(i);
            AccessionMovementDTO aux = (AccessionMovementDTO) this.
                    getDataTableAccessionMovements().getRowData();
            if (aux.isSelected()) {
                selectedAccessionMovement.add(aux);
            }
        }
        if(selectedAccessionMovement == null || selectedAccessionMovement.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedAccessionMovement.size() == 1)
        { //En caso de que solo se seleccione un elemento

            get$AccessionMovementSessionBean().setAccessionDTO(
            get$AccessionMovementSessionBean().getGermplasmFacadeRemote().
                    deleteAccessionMovement(selectedAccessionMovement.get(0)));

            get$AccessionSessionBean().setEditAccessionDTO(
                    get$AccessionMovementSessionBean().getAccessionDTO());

            //refresh the list
            get$AccessionMovementSessionBean().getPagination().refreshList();
            
            return null;

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }

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
    protected PassportSessionBean getgermplasm$PassportSessionBean() {
        return (PassportSessionBean) getBean("germplasm$PassportSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AccessionMovementSessionBean get$AccessionMovementSessionBean() {
        return (AccessionMovementSessionBean) getBean("germplasm$AccessionMovementSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected AccessionSessionBean get$AccessionSessionBean() {
        return (AccessionSessionBean) getBean("germplasm$AccessionSessionBean");
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
    protected GatheringSessionBean getinventory$GatheringSessionBean() {
        return (GatheringSessionBean) getBean("inventory$GatheringSessionBean");
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
    protected ValidatorBean getutil$ValidatorBean() {
        return (ValidatorBean) getBean("util$ValidatorBean");
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
    protected IdentificationSessionBean getinventory$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("inventory$IdentificationSessionBean");
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
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal= this.get$AccessionMovementSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the txSearch
     */
    public HtmlInputText getTxSearch() {
        return txSearch;
    }

    /**
     * @param txSearch the txSearch to set
     */
    public void setTxSearch(HtmlInputText txSearch) {
        this.txSearch = txSearch;
    }

    /**
     * @return the gridpAdvancedSearch
     */
    public HtmlPanelGrid getGridpAdvancedSearch() {
        return gridpAdvancedSearch;
    }

    /**
     * @param gridpAdvancedSearch the gridpAdvancedSearch to set
     */
    public void setGridpAdvancedSearch(HtmlPanelGrid gridpAdvancedSearch) {
        this.gridpAdvancedSearch = gridpAdvancedSearch;
    }

    /**
     * @return the btnSearch
     */
    public HtmlCommandButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @param btnSearch the btnSearch to set
     */
    public void setBtnSearch(HtmlCommandButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    /**
     * @return the btnAdvSearch
     */
    public HtmlCommandButton getBtnAdvSearch() {
        return btnAdvSearch;
    }

    /**
     * @param btnAdvSearch the btnAdvSearch to set
     */
    public void setBtnAdvSearch(HtmlCommandButton btnAdvSearch) {
        this.btnAdvSearch = btnAdvSearch;
    }

    /**
     * @return the dataTableAccessionMovements
     */
    public HtmlDataTable getDataTableAccessionMovements() {
        return dataTableAccessionMovements;
    }

    /**
     * @param dataTableAccessionMovements the dataTableAccessionMovements to set
     */
    public void setDataTableAccessionMovements(HtmlDataTable dataTableAccessionMovements) {
        this.dataTableAccessionMovements = dataTableAccessionMovements;
    }

    /**
     * @return the lbTitle
     */
    public Label getLbTitle() {
        return lbTitle;
    }

    /**
     * @param lbTitle the lbTitle to set
     */
    public void setLbTitle(Label lbTitle) {
        this.lbTitle = lbTitle;
    }

    /**
     * @return the lbTitle2
     */
    public Label getLbTitle2() {
        return lbTitle2;
    }

    /**
     * @param lbTitle2 the lbTitle2 to set
     */
    public void setLbTitle2(Label lbTitle2) {
        this.lbTitle2 = lbTitle2;
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
    protected NomenclaturalGroupSessionBean gettaxonomy$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean) getBean("taxonomy$NomenclaturalGroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected GatheringDetailSessionBean getinventory$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("inventory$GatheringDetailSessionBean");
    }
    
}

