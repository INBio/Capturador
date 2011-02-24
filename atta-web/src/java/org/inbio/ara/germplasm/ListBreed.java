/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.germplasm;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlPanelGrid;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.germplasm.BreedDTO;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ListBreed.java
 * @version Created on 08/04/2010, 09:25:37 AM
 * @author dasolano
 */

public class ListBreed extends AbstractPageBean {
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
    
    private HtmlDataTable dataTableBreeds = new HtmlDataTable();

    private HtmlPanelGrid alertMessage = new HtmlPanelGrid();
    private HtmlPanelGrid mainPanel = new HtmlPanelGrid();

    private HtmlCommandButton btnSimpleSearch = new HtmlCommandButton(); //Boton busqueda simple
    private HtmlInputText txSimpleSearch = new HtmlInputText(); //Input text de busqueda simple
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ListBreed() {
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
            log("ListBreed Initialization Failure", e);
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


        if(getgermplasm$BreedSessionBean().isFirstTime())
        {
            dataTableBreeds = new HtmlDataTable();
            quantityTotal = new String();
            getgermplasm$BreedSessionBean().setFirstTime(false);
        }

        //Inicializar el dataprovider la primera vez (si la paginación es nula)
        if (getgermplasm$BreedSessionBean().getPagination()==null) {
            getgermplasm$BreedSessionBean().initDataProvider();
        }
        //Actualizar los datos del paginador
        else
            getgermplasm$BreedSessionBean().getPagination().refreshList();
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
     * Redirect to the NewBreed.jsp
     * @return
     */
    public String btn_new_action()
    {
        getgermplasm$BreedSessionBean().resetValues();
        return "new";
    }

    /**
     * Choose the selected Breed and redirect to EditBreed.jsp
     * @return
     */
    public String btn_edit_action()
    {
        int n = this.getDataTableBreeds().getRowCount();
        ArrayList<BreedDTO> selected = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableBreeds().setRowIndex(i);
            BreedDTO aux = (BreedDTO) this.
                    getDataTableBreeds().getRowData();
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

            
            getgermplasm$BreedSessionBean().setBreedDTO(selected.get(0));

            //Llamada al jsp encargado de la edicion de accessiones
            return "edit";

        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Choose the selected breed, search if it has sementals associated. Then
     * ask if you want to delete the selected breed with his sementals or not
     * @return
     */
    public String btn_delete_action()
    {
        int n = this.getDataTableBreeds().getRowCount();
        ArrayList<BreedDTO> selected = new ArrayList();
        for (int i = 0; i < n; i++) { //Obtener elementos seleccionados
            this.getDataTableBreeds().setRowIndex(i);
            BreedDTO aux = (BreedDTO) this.
                    getDataTableBreeds().getRowData();
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

            //si tiene hijos o asociacions despliega el mensaje de alerta
            if(getgermplasm$BreedSessionBean().getGermplasmFacadeRemote().
                    haveSementals(
                    selected.get(0).getBreedId()))
            {
                this.getAlertMessage().setRendered(true);
                this.getMainPanel().setRendered(false);
                getgermplasm$BreedSessionBean().setDeleteBreed(
                        selected.get(0).getBreedId());
            }
            else
            {
                //delete the breed
                getgermplasm$BreedSessionBean().getGermplasmFacadeRemote().
                        deleteBreed(selected.get(0).getBreedId());
                //refresh the list
                getgermplasm$BreedSessionBean().getPagination().refreshList();
                MessageBean.setSuccessMessageFromBundle("delete_breed_success", this.getMyLocale());
            }

            return null;
        }
        else{ //En caso de que sea seleccion multiple
            MessageBean.setErrorMessageFromBundle("not_yet", this.getMyLocale());
            return null;
        }
    }

    /**
     * Confirm the delete breed
     * @return
     */
    public String btn_confirm_delete_action()
    {
        //delete the accession
        getgermplasm$BreedSessionBean().getGermplasmFacadeRemote().
                deleteBreed(
                getgermplasm$BreedSessionBean().getDeleteBreed());
        //refresh the list
        getgermplasm$BreedSessionBean().getPagination().refreshList();
        getgermplasm$SementalSessionBean().getPagination().refreshList();

        //show and hidde panels
        this.getMainPanel().setRendered(true);
        this.getAlertMessage().setRendered(false);
        MessageBean.setSuccessMessageFromBundle("delete_breed_success", this.getMyLocale());
        return null;
    }

    /**
     * Cancel the delete action
     * @return
     */
    public String btn_cancel_delete_action()
    {
        //show and hidde panels
        this.getMainPanel().setRendered(true);
        this.getAlertMessage().setRendered(false);
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
        System.out.println(1);
        if(userInput.length()==0){
            //Se desabilitan las banderas de busqueda simple y avanzada
            this.getgermplasm$BreedSessionBean().setQueryModeSimple(false);
        }
        else{
            //Setear el string para consulta simple del SessionBean
            this.getgermplasm$BreedSessionBean().setConsultaSimple(userInput);
            //Indicarle al SessionBean que el paginador debe "trabajar" en modo busqueda simple
            this.getgermplasm$BreedSessionBean().setQueryModeSimple(true);
        }
        //set the first result of the query
        this.getgermplasm$BreedSessionBean().getPagination().firstResults();
        return null;
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
     * @return the quantityTotal
     */
    public String getQuantityTotal() {
        quantityTotal = this.getgermplasm$BreedSessionBean().getQuantityTotal();
        return quantityTotal;
    }

    /**
     * @param quantityTotal the quantityTotal to set
     */
    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    

    /**
     * @return the dataTableBreeds
     */
    public HtmlDataTable getDataTableBreeds() {
        return dataTableBreeds;
    }

    /**
     * @param dataTableBreeds the dataTableBreeds to set
     */
    public void setDataTableBreeds(HtmlDataTable dataTableBreeds) {
        this.dataTableBreeds = dataTableBreeds;
    }

    protected BreedSessionBean getgermplasm$BreedSessionBean() {
        return (BreedSessionBean) getBean("germplasm$BreedSessionBean");
    }

    protected SementalSessionBean getgermplasm$SementalSessionBean() {
        return (SementalSessionBean) getBean("germplasm$SementalSessionBean");
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

