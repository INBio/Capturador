/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dublincore;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.TextField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.reports.ReportsSessionBean;
import org.inbio.ara.inventory.IdentificationSessionBean;
import org.inbio.ara.security.SystemUserSessionBean;
import org.inbio.ara.germplasm.PassportSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.germplasm.AccessionMovementSessionBean;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.germplasm.BreedSessionBean;
import org.inbio.ara.germplasm.SemenGatheringSessionBean;
import org.inbio.ara.taxonomy.TaxonomySessionBean;
import org.inbio.ara.gis.SiteSessionBean;
import org.inbio.ara.admin.AdminGeographicLayersSessionBean;
import org.inbio.ara.util.ValidatorBean;
import org.inbio.ara.germplasm.PassportListSessionBean;
import org.inbio.ara.admin.AudienceSessionBean;
import org.inbio.ara.admin.SelectionListSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.taxonomy.TaxonSessionBean;
import org.inbio.ara.admin.PersonSessionBean;
import org.inbio.ara.inventory.SpecimenSessionBean;
import org.inbio.ara.admin.InstitutionSessionBean;
import org.inbio.ara.reports.SnapshotSessionBean;
import org.inbio.ara.taxonomy.SpeciesSessionBean;
import org.inbio.ara.taxonomy.NomenclaturalGroupSessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.transaction.TransactionSessionBean;
import org.inbio.ara.admin.ProfileSessionBean;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;
import org.inbio.commons.dublincore.dto.DublinCoreDTO;
import org.inbio.commons.dublincore.dto.ara.ReferenceDTO;
import org.inbio.commons.dublincore.model.ResourceTypeEnum;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListDublinCore.java
 * @version Created on 23/09/2010, 02:57:30 PM
 * @author dasolano
 */

public class ListDublinCore extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private HtmlDataTable dataTableDublinCore = new HtmlDataTable();

    private HtmlPanelGrid gridIndicator = new HtmlPanelGrid();

    private HtmlPanelGrid gridDublinCore = new HtmlPanelGrid();

    private HtmlPanelGrid indicator = new HtmlPanelGrid();

    private HtmlPanelGrid gridpAdvancedSearch = new HtmlPanelGrid();

    private HtmlInputText txSearch = new HtmlInputText();

    private TextField txTitle = new TextField();

    private TextField txYear = new TextField();

    private TextField txIdentifier = new TextField();

    private TextField txCreator = new TextField();

    private HtmlCommandButton btnSearch = new HtmlCommandButton();

    private HtmlCommandButton btnAdvSearch = new HtmlCommandButton();

    private String quantityTotal = new String();

    private String selected = new String();
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListDublinCore() {
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
            log("ListDublinCore Initialization Failure", e);
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
        //Preguntar si la bandera de busqueda avanzada esta prendida
        /*if(getdublincore$DublinCoreSessionBean().isAdvancedSearch()){

            
            this.getGridpAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
        }
        //Inicializar el dataprovider si la paginacion es nula y no es filtrado por busquedas
        else if (getdublincore$DublinCoreSessionBean().getPagination()==null) {

            getdublincore$DublinCoreSessionBean().initDataProvider();
        }*/

        if (this.getdublincore$DublinCoreSessionBean().getPagination()!=null)
        {

            getSelectedResourceIds(this.getDataTableDublinCore(), this.getdublincore$DublinCoreSessionBean().getSelectedResourcesId());
            Collection<ReferenceDTO> references = this.getdublincore$DublinCoreSessionBean().getSelectedResourcesId().values();
            for(ReferenceDTO reference: references)
            {
                setSelected(getSelected() + reference.getTitle() + "; ");
            }

        }
        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(this.getdublincore$DublinCoreSessionBean().isAdvancedSearch()){
            this.getGridpAdvancedSearch().setRendered(true);//Muestra el panel de busqueda avanzada
        }
        //Inicializar el dataprovider si la paginacion es nula y no es filtrado por busquedas
        else if (this.getdublincore$DublinCoreSessionBean().getPagination()==null) {
               this.getdublincore$DublinCoreSessionBean().initDataProvider();
               this.getdublincore$DublinCoreSessionBean().setSelectedResourcesId(new HashMap<String, ReferenceDTO>());
        }

    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }
    
    /**
     * Redirect to NewDublinCore.jsp
     * @return
     */
    public String btn_new_action()
    {
        getdublincore$DublinCoreSessionBean().resetValues();
        return "new";
    }

    /**
     * Choose the selected semental, and redirect to EditSemental.jsp
     * @return
     */
    public String btn_edit_action()
    {
        int n = this.getDataTableDublinCore().getRowCount();
        ArrayList<ReferenceDTO> selected = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableDublinCore().setRowIndex(i);
            ReferenceDTO aux = (ReferenceDTO) this.
                    getDataTableDublinCore().getRowData();
            if (aux.isSelected()) {
                selected.add(aux);
            }
        }
        if(selected == null || selected.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selected.size() == 1){ //En caso de que solo se seleccione un elemento

            getdublincore$DublinCoreSessionBean().setDublinCoreDTO(
                    getdublincore$DublinCoreSessionBean().getDublinCoreFacadeRemote().
                    findInterfaceDublincoreById(Long.parseLong(selected.get(0).getKey())));

            //Llamada al jsp encargado de la edicion de dublin core
            return "edit";

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }



    /**
     * Choose the selected Semental, search if it has associated semen_gatherings and
     * then ask if you want to delete it.
     * @return
     */
    public String btn_delete_action()
    {
        int n = this.getDataTableDublinCore().getRowCount();
        ArrayList<ReferenceDTO> selected = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableDublinCore().setRowIndex(i);
            ReferenceDTO aux = (ReferenceDTO) this.
                    getDataTableDublinCore().getRowData();
            if (aux.isSelected()) {
                selected.add(aux);
            }
        }
        if(selected == null || selected.size() == 0)
        {
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selected.size() == 1)
        { //En caso de que solo se seleccione un elemento

            
            //delete the accession
            getdublincore$DublinCoreSessionBean().getDublinCoreFacadeRemote().
                    deleteDublinCoreResource(selected.get(0).getKey());
            //refresh the list
            getdublincore$DublinCoreSessionBean().getPagination().deleteItem();
            getdublincore$DublinCoreSessionBean().getPagination().refreshList();

            
            MessageBean.setSuccessMessageFromBundle("delete_dublin_core", this.getMyLocale());
            
            return null;
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * <p>Acción que se realiza al presionar el botón de búsqueda simple</p>
     *
     * @return String
     */
    public String btnSimpleSearch_action() {

        String userInput = "";
        if(this.getTxSearch().getValue()!= null)
        {
            userInput = this.getTxSearch().getValue().toString();
        }
        userInput = userInput.trim();

        if(!this.getdublincore$DublinCoreSessionBean().getPagination().getDataProvider().getList().isEmpty())
        {
            getSelectedResourceIds(this.getDataTableDublinCore(), this.getdublincore$DublinCoreSessionBean().getSelectedResourcesId());
        }

        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getdublincore$DublinCoreSessionBean().setQueryModeSimple(false);
            this.getdublincore$DublinCoreSessionBean().setQueryMode(false);

            //Actualiza el data provider del paginador con los datos por default
            this.getdublincore$DublinCoreSessionBean().getPagination().setTotalResults
                    (getdublincore$DublinCoreSessionBean().getDublinCoreFacadeRemote().countResourceByTypeId(-1).intValue());
        }
        else{
            //Actualizar el valor del string para consulta simple del SessionBean
            this.getdublincore$DublinCoreSessionBean().setSimpleConsult(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getdublincore$DublinCoreSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getdublincore$DublinCoreSessionBean().setQueryMode(false);
            //Finalmente se inicializa el Total Results del data provider del paginador con la cantidad de resultados de la consulta
            this.getdublincore$DublinCoreSessionBean().getPagination().setTotalResults
                    (getdublincore$DublinCoreSessionBean().getDublinCoreFacadeRemote().countSimpleSearch(userInput).intValue());
        }
        //set the first result of the query
        this.getdublincore$DublinCoreSessionBean().getPagination().firstResults();

        return null;
    }

    public String btnAdvSearch_action() {

        if(!this.getdublincore$DublinCoreSessionBean().getPagination().getDataProvider().getList().isEmpty())
        {
            getSelectedResourceIds(this.getDataTableDublinCore(), this.getdublincore$DublinCoreSessionBean().getSelectedResourcesId());
        }

        boolean advanced = this.getdublincore$DublinCoreSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            this.getdublincore$DublinCoreSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearch().setRendered(false);
            this.getBtnSearch().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getdublincore$DublinCoreSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearch.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearch().setRendered(true);
            this.getBtnSearch().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearch().setValue(BundleHelper.getDefaultBundleValue("advanced_search",getMyLocale()));

        }
        this.getdublincore$DublinCoreSessionBean().getPagination().refreshList();
        return null;
    }

    public String btnProceedSearch_action() {


        if(!this.getdublincore$DublinCoreSessionBean().getPagination().getDataProvider().getList().isEmpty())
        {
            getSelectedResourceIds(this.getDataTableDublinCore(), this.getdublincore$DublinCoreSessionBean().getSelectedResourcesId());
        }

        /*
         * ARMAR EL DTO PARA REALIZAR LA BUSQUEDA
         */

        this.getdublincore$DublinCoreSessionBean().setQueryDublinCoreDTO(new DublinCoreDTO());

        if(this.getTxTitle().getText() != null && this.getTxTitle().getText() != "")
        {

            this.getdublincore$DublinCoreSessionBean().getQueryDublinCoreDTO().addElement("title",
                                                                                    this.getTxTitle().getText().toString(), "Español");
        }

        if(this.getTxCreator().getText() != null && this.getTxCreator().getText() != "")
        {


            this.getdublincore$DublinCoreSessionBean().getQueryDublinCoreDTO().addElement("creator",
                                                                                    this.getTxCreator().getText().toString(), null);
        }

        if(this.getTxIdentifier().getText() != null && this.getTxIdentifier().getText() != "")
        {

            this.getdublincore$DublinCoreSessionBean().getQueryDublinCoreDTO().addElement("identifier",
                                                                                    this.getTxIdentifier().getText().toString(), null);
        }


       if(this.getTxYear().getText() != null && this.getTxYear().getText() != "")
       {

            this.getdublincore$DublinCoreSessionBean().getQueryDublinCoreDTO().addElement("date",
                                                                                    this.getTxYear().getText().toString(), null);
       }

         //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getdublincore$DublinCoreSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getdublincore$DublinCoreSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getdublincore$DublinCoreSessionBean().getPagination().setTotalResults(
                this.getdublincore$DublinCoreSessionBean().
                getDublinCoreFacadeRemote().
                countDublinCoreAdvancedSearch(
                getdublincore$DublinCoreSessionBean().
                getQueryDublinCoreDTO()).intValue());

        this.getdublincore$DublinCoreSessionBean().getPagination().firstResults();
        this.getdublincore$DublinCoreSessionBean().getPagination().refreshList();

        this.getTxSearch().setValue("");

        return null;
    }


    /*
     *          Get's y Set's de las variables privadas
     */


    public void getSelectedResourceIds (HtmlDataTable selectedResources, Map<String, ReferenceDTO> selectedResourcesId)
    {


        int n = selectedResources.getRowCount();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            selectedResources.setRowIndex(i);
            ReferenceDTO aux = (ReferenceDTO) selectedResources.getRowData();
            
            if (aux.isSelected() && (!selectedResourcesId.containsKey(aux.getKey()))) {

                selectedResourcesId.put(aux.getKey(), aux);

            }
            else
            {
                if((!aux.isSelected()) && selectedResourcesId.containsKey(aux.getKey()))
                {

                    selectedResourcesId.remove(aux.getKey());
                }
            }
        }

    }


    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal= this.getdublincore$DublinCoreSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
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
    protected ReportsSessionBean getreports$ReportsSessionBean() {
        return (ReportsSessionBean) getBean("reports$ReportsSessionBean");
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
    protected SystemUserSessionBean getsecurity$SystemUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
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
    protected GatheringDetailSessionBean getinventory$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("inventory$GatheringDetailSessionBean");
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
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected BreedSessionBean getgermplasm$BreedSessionBean() {
        return (BreedSessionBean) getBean("germplasm$BreedSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SemenGatheringSessionBean getgermplasm$SemenGatheringSessionBean() {
        return (SemenGatheringSessionBean) getBean("germplasm$SemenGatheringSessionBean");
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
    protected SiteSessionBean getgis$SiteSessionBean() {
        return (SiteSessionBean) getBean("gis$SiteSessionBean");
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
    protected DublinCoreSessionBean getdublincore$DublinCoreSessionBean() {
        return (DublinCoreSessionBean) getBean("dublincore$DublinCoreSessionBean");
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
    protected PassportListSessionBean getgermplasm$PassportListSessionBean() {
        return (PassportListSessionBean) getBean("germplasm$PassportListSessionBean");
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
    protected SelectionListSessionBean getadmin$SelectionListSessionBean() {
        return (SelectionListSessionBean) getBean("admin$SelectionListSessionBean");
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
    protected TaxonSessionBean gettaxonomy$TaxonSessionBean() {
        return (TaxonSessionBean) getBean("taxonomy$TaxonSessionBean");
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
    protected SpecimenSessionBean getinventory$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("inventory$SpecimenSessionBean");
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
    protected SnapshotSessionBean getreports$SnapshotSessionBean() {
        return (SnapshotSessionBean) getBean("reports$SnapshotSessionBean");
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
    protected NomenclaturalGroupSessionBean gettaxonomy$NomenclaturalGroupSessionBean() {
        return (NomenclaturalGroupSessionBean) getBean("taxonomy$NomenclaturalGroupSessionBean");
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
    protected TransactionSessionBean gettransaction$TransactionSessionBean() {
        return (TransactionSessionBean) getBean("transaction$TransactionSessionBean");
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
     * @return the dataTableDublinCore
     */
    public HtmlDataTable getDataTableDublinCore() {
        return dataTableDublinCore;
    }

    /**
     * @param dataTableDublinCore the dataTableDublinCore to set
     */
    public void setDataTableDublinCore(HtmlDataTable dataTableDublinCore) {
        this.dataTableDublinCore = dataTableDublinCore;
    }

    /**
     * @return the gridIndicator
     */
    public HtmlPanelGrid getGridIndicator() {
        return gridIndicator;
    }

    /**
     * @param gridIndicator the gridIndicator to set
     */
    public void setGridIndicator(HtmlPanelGrid gridIndicator) {
        this.gridIndicator = gridIndicator;
    }

    /**
     * @return the gridDublinCore
     */
    public HtmlPanelGrid getGridDublinCore() {
        return gridDublinCore;
    }

    /**
     * @param gridDublinCore the gridDublinCore to set
     */
    public void setGridDublinCore(HtmlPanelGrid gridDublinCore) {
        this.gridDublinCore = gridDublinCore;
    }

    /**
     * @return the indicator
     */
    public HtmlPanelGrid getIndicator() {
        return indicator;
    }

    /**
     * @param indicator the indicator to set
     */
    public void setIndicator(HtmlPanelGrid indicator) {
        this.indicator = indicator;
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
     * @return the txYear
     */
    public TextField getTxYear() {
        return txYear;
    }

    /**
     * @param txYear the txYear to set
     */
    public void setTxYear(TextField txYear) {
        this.txYear = txYear;
    }

    /**
     * @return the txIdentifier
     */
    public TextField getTxIdentifier() {
        return txIdentifier;
    }

    /**
     * @param txIdentifier the txIdentifier to set
     */
    public void setTxIdentifier(TextField txIdentifier) {
        this.txIdentifier = txIdentifier;
    }

    /**
     * @return the txCreator
     */
    public TextField getTxCreator() {
        return txCreator;
    }

    /**
     * @param txCreator the txCreator to set
     */
    public void setTxCreator(TextField txCreator) {
        this.txCreator = txCreator;
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
     * @return the selected
     */
    public String getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(String selected) {
        this.selected = selected;
    }
    
}

