/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.inventory.GatheringSessionBean;
import org.inbio.ara.taxonomy.TaxonomySessionBean;
import org.inbio.ara.SessionManager;
import org.inbio.ara.dto.germplasm.AccessionDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.inventory.SpecimenGenerationSessionBean;
import org.inbio.ara.inventory.GatheringDetailSessionBean;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListAccession.java
 * @version Created on 03/03/2010, 11:38:55 AM
 * @author dasolano
 */

public class ListAccession extends AbstractPageBean {
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
    private String quantityTotalAccession = new String();
    //Data table binding para la tabla que muetra los passport
    private HtmlDataTable dataTableAccession = new HtmlDataTable();


    /**busquedas avanzadas**/
    //listado

    /*Componentes para las busquedas*/
    private HtmlInputText txSearchAccession = new HtmlInputText(); //Input text de busqueda simple
    private HtmlPanelGrid gridpAdvancedSearchAccession = new HtmlPanelGrid();
    private HtmlCommandButton btnSearchAccession = new HtmlCommandButton(); //Boton busqueda simple
    private HtmlCommandButton btnAdvSearchAccession = new HtmlCommandButton(); //Boton busqueda avanzada

    //componentes para busuqedas avanzadas    
    
    private SingleSelectOptionsList responsablePerson = new SingleSelectOptionsList();
    private SingleSelectOptionsList germinationMethod = new SingleSelectOptionsList();


    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListAccession() {
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
            log("ListAccession Initialization Failure", e);
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

        responsablePerson.setOptions(this.SetResponsibleDropDownData());
        germinationMethod.setOptions(
                this.getSelectionListDropDownData(
                SelectionListEntity.GERMINATION_METHOD_TYPE.getId()));

        //Preguntar si la bandera de busqueda avanzada esta prendida
        if(getgermplasm$AccessionSessionBean().isAdvancedSearch()){
            this.getGridpAdvancedSearchAccession().setRendered(true);//Muestra el panel de busqueda avanzada
        }
        //Inicializar el dataprovider si la paginacion es nula y no es filtrado por busquedas
        else if (getgermplasm$AccessionSessionBean().getPagination()==null) {
            getgermplasm$AccessionSessionBean().initDataProvider();
        }
    }

    /**
     * Metodo ejecutado por el boton de busqueda simple
     * @return
     */
    public String btnAccessionSearch_action() {
        String userInput = "";
        if(this.getTxSearchAccession().getValue()!= null)
            userInput = this.getTxSearchAccession().getValue().toString();
        userInput = userInput.trim();
        System.out.println(1);
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getgermplasm$AccessionSessionBean().setQueryModeSimple(false);
            this.getgermplasm$AccessionSessionBean().setQueryMode(false);
            //Finalmente se setea el data provider del paginador con los datos por default
            this.getgermplasm$AccessionSessionBean().getPagination().setTotalResults
                    (getgermplasm$AccessionSessionBean().getGermplasmFacadeRemote().
                    countAccessions().intValue());
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.getgermplasm$AccessionSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getgermplasm$AccessionSessionBean().setQueryModeSimple(true);
            //Desabilitar la bandera de busqueda avanzada
            this.getgermplasm$AccessionSessionBean().setQueryMode(false);
            //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
            this.getgermplasm$AccessionSessionBean().getPagination().setTotalResults
                    (getgermplasm$AccessionSessionBean().getGermplasmFacadeRemote().
                    countAccessionSimpleSearch(
                    userInput,
                    getAraSessionBean().getGlobalCollectionId()).intValue());
        }
        //set the first result of the query
        this.getgermplasm$AccessionSessionBean().getPagination().firstResults();
        return null;
    }

    /**
     * Metodo ejecutado por el boton que muestra el panel de busqueda avanzada
     * Su funcion es mostrar y esconder dicho panel
     * @return
     */
    public String btnAdvAccessiontSearch_action() {
        boolean advanced = getgermplasm$AccessionSessionBean().isAdvancedSearch();
        if(advanced==false){ //Mostrar panel de busqueda avanzada
            getgermplasm$AccessionSessionBean().setAdvancedSearch(true);
            //Deshabilitar busqueda simple
            this.getTxSearchAccession().setRendered(false);
            this.getBtnSearchAccession().setRendered(false);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearchAccession().setValue(BundleHelper.getDefaultBundleValue("advanced_search_specimen_back",getMyLocale()));
            return null;
        }
        else if(advanced==true){
            this.getgermplasm$AccessionSessionBean().setAdvancedSearch(false);
            //Ocultar el panel
            this.gridpAdvancedSearchAccession.setRendered(false);
            //Habilitar busqueda simple
            this.getTxSearchAccession().setRendered(true);
            this.getBtnSearchAccession().setRendered(true);
            //Cambia el text del boton de busqueda avanzada
            this.getBtnAdvSearchAccession().setValue(BundleHelper.getDefaultBundleValue("advanced_search",getMyLocale()));

            //Reestablecer los valores por defecto de los textfields
            getgermplasm$AccessionSessionBean().setQueryAccessionDTO(new AccessionDTO());
        }
        return null;
    }

    /**
     * Metodo para obtener los datos a mostrar en los drop downs de la
     * ventana de generacion que pertenecen a listas de seleccion
     * @param selectionListEntityId que es el id del enum de listas de seleccion
     * @return
     */
    public Option[] getSelectionListDropDownData(Long selectionListEntityId) {

        //getAllSelectionListElementsByCollection
        List<SelectionListDTO> DTOList = this.getgermplasm$AccessionSessionBean().
                getInventoryFacadeRemote().
                getAllSelectionListElementsByCollection(selectionListEntityId, getAraSessionBean().getGlobalCollectionId());
        /*List<SelectionListDTO> DTOList = this.getPassportSessionBean().
        getGermplasmFacadeRemote().getElementsForSelectionList(selectionListEntityId);*/


        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null, " -- " + BundleHelper.getDefaultBundleValue("drop_down_default", getMyLocale()) + " --");
        allOptions.add(option);

        //Crear todas las opciones del drop down
        for (SelectionListDTO slDTO : DTOList) {
            option = new Option(slDTO.getValueId(), slDTO.getValueName());
            allOptions.add(option);
        }

        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * Obtener los datos del drop down de responsables
     */
    public Option[] SetResponsibleDropDownData(){
        List<PersonDTO> personDTOList = this.getgermplasm$AccessionSessionBean().
                getGermplasmFacadeRemote().getDonorPersons();
        ArrayList<Option> allOptions = new ArrayList<Option>();
        Option[] allOptionsInArray;
        Option option;
        //Crear opcion titulo
        option = new Option(null," -- "+BundleHelper.getDefaultBundleValue("drop_down_default",getMyLocale())+" --");
        allOptions.add(option);
        //Crear todas las opciones del drop down
        for(PersonDTO perDTO : personDTOList){

            option = new Option(perDTO.getPersonKey(), perDTO.getNaturalLongName().trim());
            allOptions.add(option);
        }
        //Sets the elements in the SingleSelectedOptionList Object
        allOptionsInArray = new Option[allOptions.size()];
        return allOptions.toArray(allOptionsInArray);
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
        return this.getAraSessionBean().getCurrentLocale();
    }


    

    /**
     * Redirect to New Passport
     * @return
     */
    public String btn_new_action() {
        getgermplasm$AccessionSessionBean().resetValues();
        return "new";
    }



    public String btn_edit_action(){
        int n = this.getDataTableAccession().getRowCount();
        ArrayList<AccessionDTO> selectedAccession = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableAccession().setRowIndex(i);
            AccessionDTO aux = (AccessionDTO) this.
                    getDataTableAccession().getRowData();
            if (aux.isSelected()) {
                selectedAccession.add(aux);
            }
        }
        if(selectedAccession == null || selectedAccession.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedAccession.size() == 1){ //En caso de que solo se seleccione un elemento

            //reset values
            getgermplasm$AccessionSessionBean().resetValues();
            //set the AccessionDTO
            getgermplasm$AccessionSessionBean().setEditAccessionDTO(selectedAccession.get(0));
            
            //Llamada al jsp encargado de la edicion de accessiones
            return "edit";

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    public String btnAdvSearchAccession_action()
    {
        //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda avanzada
        this.getgermplasm$AccessionSessionBean().setQueryMode(true);
        //Desabilitar la bandera de busqueda simple
        this.getgermplasm$AccessionSessionBean().setQueryModeSimple(false);
        //Finalmente se inicializa el data provider del paginador con los resultados de la consulta
        this.getgermplasm$AccessionSessionBean().getPagination().setTotalResults(
                this.getgermplasm$AccessionSessionBean().
                getGermplasmFacadeRemote().
                countAccessionAdvancedSearch(
                getgermplasm$AccessionSessionBean().
                getQueryAccessionDTO(), getAraSessionBean().
                getGlobalCollectionId()).intValue());

        this.getgermplasm$AccessionSessionBean().getPagination().firstResults();

        this.getTxSearchAccession().setValue("");
        
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
    @Override
    public void destroy() {
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
    protected AccessionSessionBean getgermplasm$AccessionSessionBean() {
        return (AccessionSessionBean) getBean("germplasm$AccessionSessionBean");
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
    protected TaxonomySessionBean gettaxonomy$TaxonomySessionBean() {
        return (TaxonomySessionBean) getBean("taxonomy$TaxonomySessionBean");
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
    protected SpecimenGenerationSessionBean getinventory$SpecimenGenerationSessionBean() {
        return (SpecimenGenerationSessionBean) getBean("inventory$SpecimenGenerationSessionBean");
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
     * @return the quantityTotalAccession
     */
    public String getQuantityTotalAccession() {
        quantityTotalAccession = this.getgermplasm$AccessionSessionBean().getQuantityTotal();
        return quantityTotalAccession;
    }

    /**
     * @param quantityTotalAccession the quantityTotalAccession to set
     */
    public void setQuantityTotalAccession(String quantityTotalAccession) {
        this.quantityTotalAccession = quantityTotalAccession;
    }

    /**
     * @return the dataTableAccession
     */
    public HtmlDataTable getDataTableAccession() {
        return dataTableAccession;
    }

    /**
     * @param dataTableAccession the dataTableAccession to set
     */
    public void setDataTableAccession(HtmlDataTable dataTableAccession) {
        this.dataTableAccession = dataTableAccession;
    }

    /**
     * @return the txSearchAccession
     */
    public HtmlInputText getTxSearchAccession() {
        return txSearchAccession;
    }

    /**
     * @param txSearchAccession the txSearchAccession to set
     */
    public void setTxSearchAccession(HtmlInputText txSearchAccession) {
        this.txSearchAccession = txSearchAccession;
    }

    /**
     * @return the gridpAdvancedSearchAccession
     */
    public HtmlPanelGrid getGridpAdvancedSearchAccession() {
        return gridpAdvancedSearchAccession;
    }

    /**
     * @param gridpAdvancedSearchAccession the gridpAdvancedSearchAccession to set
     */
    public void setGridpAdvancedSearchAccession(HtmlPanelGrid gridpAdvancedSearchAccession) {
        this.gridpAdvancedSearchAccession = gridpAdvancedSearchAccession;
    }

    /**
     * @return the btnSearchAccession
     */
    public HtmlCommandButton getBtnSearchAccession() {
        return btnSearchAccession;
    }

    /**
     * @param btnSearchAccession the btnSearchAccession to set
     */
    public void setBtnSearchAccession(HtmlCommandButton btnSearchAccession) {
        this.btnSearchAccession = btnSearchAccession;
    }

    /**
     * @return the btnAdvSearchAccession
     */
    public HtmlCommandButton getBtnAdvSearchAccession() {
        return btnAdvSearchAccession;
    }

    /**
     * @param btnAdvSearchAccession the btnAdvSearchAccession to set
     */
    public void setBtnAdvSearchAccession(HtmlCommandButton btnAdvSearchAccession) {
        this.btnAdvSearchAccession = btnAdvSearchAccession;
    }

    /**
     * @return the responsablePerson
     */
    public SingleSelectOptionsList getResponsablePerson() {
        return responsablePerson;
    }

    /**
     * @param responsablePerson the responsablePerson to set
     */
    public void setResponsablePerson(SingleSelectOptionsList responsablePerson) {
        this.responsablePerson = responsablePerson;
    }

    /**
     * @return the germinationMethod
     */
    public SingleSelectOptionsList getGerminationMethod() {
        return germinationMethod;
    }

    /**
     * @param germinationMethod the germinationMethod to set
     */
    public void setGerminationMethod(SingleSelectOptionsList germinationMethod) {
        this.germinationMethod = germinationMethod;
    }

    
    
}

