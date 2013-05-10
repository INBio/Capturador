/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.admin;


import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;

import org.inbio.ara.dto.inventory.ProjectDTO;
import org.inbio.ara.util.MessageBean;



/**
 *
 * @author gsulca
 */
public class ListProject extends AbstractPageBean{
    
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

    //Binding de la tabla
    private HtmlDataTable projectTable = new HtmlDataTable();

    //Variable que contiene los datos de la paginacion para ser mostrados en la tabla
    private String quantityTotal = new String();

    //Variable que contiene los datos de la pagina


    private HtmlPanelGrid alertMessage = new HtmlPanelGrid();
    private HtmlPanelGrid mainPanel = new HtmlPanelGrid();

    private HtmlCommandButton btnSimpleSearch = new HtmlCommandButton(); //Boton busqueda simple
    private HtmlInputText txSimpleSearch = new HtmlInputText(); //Input text de busqueda simple
    
     /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListProject() {
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
            log("ListProject Initialization Failure", e);
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
        
        ProjectSessionBean psb = this.getProjectSessionBean();
        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        
        if (psb.getPagination()==null) {                    
            psb.initDataProvider();        
        }
        //Actualizar los datos del paginador
        else
            psb.getPagination().refreshList();
        
        
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
    
    
    
    public String btnProjectNew(){
        //Limpiar el current DTO        
        this.getProjectSessionBean().setCurrentProject(new ProjectDTO());
        //Set graphic elements                
        return "new";
        
    }

    /**
     * Metodo ejecutado por el boton para editar persona
     * @return
     */
    public String btnProjectEdit(){
        ProjectSessionBean psb = this.getProjectSessionBean();
        int n = this.getProjectTable().getRowCount();
        ArrayList<ProjectDTO> selectedProjects = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getProjectTable().setRowIndex(i);
            ProjectDTO aux = (ProjectDTO) this.getProjectTable().getRowData();
            if (aux.isSelected()) {
                selectedProjects.add(aux);
            }
        }
        if(selectedProjects == null || selectedProjects.isEmpty()){
            //En caso de que no se seleccione ningun elemento            
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            
            return null;
        }
        else if(selectedProjects.size() == 1){ //En caso de que solo se seleccione un elemento
            psb.setCurrentProject(selectedProjects.get(0));            
            //Le indico al prerender del edit que solo cargue una ves los selected de addremove
            psb.setFirstTime(true);
            return "edit";
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }                
    }

    /**
     * Metodo ejecutado por el boton para eliminar una persona
     * @return
     */
    public String btnProjectDelete(){
        /*
        int n = this.getPersonTable().getRowCount();
        ArrayList<PersonDTO> selectedPersons = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getPersonTable().setRowIndex(i);
            PersonDTO aux = (PersonDTO) this.getPersonTable().getRowData();
            if (aux.isSelected()) {
                selectedPersons.add(aux);
            }
        }
        if(selectedPersons == null || selectedPersons.size() == 0){
            //En caso de que no se seleccione ningun elemento
            MessageBean.setErrorMessageFromBundle("not_selected", this.getMyLocale());
            return null;
        }
        else if(selectedPersons.size() == 1){ //En caso de que solo se seleccione un elemento
            PersonDTO selected = selectedPersons.get(0);
            //Mandar a borrar la audiencia
            try{
                this.getPersonSessionBean().deletePerson(selected.getPersonKey());
            }
            catch(Exception e){
                MessageBean.setErrorMessageFromBundle("imposible_to_delete", this.getMyLocale());
                return null;
            }

            //Refrescar la lista de personas
            PersonSessionBean psb = this.getPersonSessionBean();
            psb.getPagination().refreshList();

            //Notificar al usuario
            MessageBean.setSuccessMessageFromBundle("delete_success", this.getMyLocale());
            return null;
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
        */
        return null;
    }

    /**
     * Performed the simple search
     * @return
     */
    public String btnSimpleSearch_action()
    {
        
        String userInput = "";
        
        if(this.getTxSimpleSearch().getValue()!= null)
            userInput = this.getTxSimpleSearch().getValue().toString();
        userInput = userInput.trim();
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getProjectSessionBean().setQueryModeSimple(false);
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.getProjectSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getProjectSessionBean().setQueryModeSimple(true);
        }
        //Set the first result of the query
        
        this.getProjectSessionBean().getPagination().firstResults();
        
        return null;
        
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ProjectSessionBean getProjectSessionBean() {
        return (ProjectSessionBean) getBean("admin$ProjectSessionBean");
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
     * @param myLocale the myLocale to set
     */
    public void setMyLocale(Locale myLocale) {
        this.myLocale = myLocale;
    }

    /**
     * @return the projectTable
     */
    public HtmlDataTable getProjectTable() {
        return projectTable;
    }

    /**
     * @param projectTable the projectTable to set
     */
    public void setProjectTable(HtmlDataTable projectTable) {
        this.projectTable = projectTable;
    }

    /**
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    /**
     * @return the alertMessage
     */
    public HtmlPanelGrid getAlertMessage() {
        return alertMessage;
    }

    /**
     * @param alertMessage the alertMessage to set
     */
    public void setAlertMessage(HtmlPanelGrid alertMessage) {
        this.alertMessage = alertMessage;
    }

    /**
     * @return the mainPanel
     */
    public HtmlPanelGrid getMainPanel() {
        return mainPanel;
    }

    /**
     * @param mainPanel the mainPanel to set
     */
    public void setMainPanel(HtmlPanelGrid mainPanel) {
        this.mainPanel = mainPanel;
    }

    /**
     * @return the btnSimpleSearch
     */
    public HtmlCommandButton getBtnSimpleSearch() {
        return btnSimpleSearch;
    }

    /**
     * @param btnSimpleSearch the btnSimpleSearch to set
     */
    public void setBtnSimpleSearch(HtmlCommandButton btnSimpleSearch) {
        this.btnSimpleSearch = btnSimpleSearch;
    }

    /**
     * @return the txSimpleSearch
     */
    public HtmlInputText getTxSimpleSearch() {
        return txSimpleSearch;
    }

    /**
     * @param txSimpleSearch the txSimpleSearch to set
     */
    public void setTxSimpleSearch(HtmlInputText txSimpleSearch) {
        this.txSimpleSearch = txSimpleSearch;
    }

    
}
