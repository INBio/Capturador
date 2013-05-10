/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.admin;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.faces.FacesException;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.util.AddRemoveList;
import org.inbio.ara.util.MessageBean;

/**
 *
 * @author gsulca
 */
public class NewProject extends AbstractPageBean  {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>
    
    private TextField txName = new TextField();
    private TextArea txDescription = new TextArea();
    private TextField txProjectManager = new TextField();
    private Calendar initial_date = new com.sun.webui.jsf.component.Calendar();
    private Calendar final_date = new com.sun.webui.jsf.component.Calendar();
    
    public NewProject()
    {
        
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
            log("NewPerson Initialization Failure", e);
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
        if(this.getProjectSessionBean().getCurrentProject() == null)
        {
            this.getTxDescription().setText(null);
            this.getTxProjectManager().setText(null);  
            this.getInitial_date().setText(null);  
            this.getFinal_date().setText(null);  
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
    
    public String btnSaveProject_action() {
        
        ProjectSessionBean psb = this.getProjectSessionBean();
        psb.getCurrentProject().setDescription((String)getTxDescription().getText());
        psb.getCurrentProject().setProjectManagerName((String) this.getTxProjectManager().getText());
        
        GregorianCalendar iniCal = new GregorianCalendar();
        GregorianCalendar finCal = new GregorianCalendar();    
        Date iniDate = this.getInitial_date().getSelectedDate();
        Date finDate = this.getFinal_date().getSelectedDate();
        if (iniDate != null) {
            iniCal.setTime(iniDate);
            psb.getCurrentProject().setInitialDate(iniCal);
        }
        if (finDate != null) {
            finCal.setTime(finDate);
            psb.getCurrentProject().setFinalDate(finCal);
        }
        psb.getCurrentProject().setUserName(this.getAraSessionBean().getGlobalUserName());
        //Persistir el DTO
        try{
            //Mandar a persistir
            psb.saveProjectDTO();
                        
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }
        this.getTxDescription().setText(null);
        this.getTxProjectManager().setText(null);  
        this.getInitial_date().setText(null);  
        this.getFinal_date().setText(null);  
        
        psb.getPagination().refreshList();
        
        //Notificar al usuario        
        MessageBean.setSuccessMessageFromBundle("create_project_success", this.getMyLocale());
        
        return null;
    }

    /**
     * @return the txName
     */
    public TextField getTxName() {
        return txName;
    }

    /**
     * @param txName the txName to set
     */
    public void setTxName(TextField txName) {
        this.txName = txName;
    }



    /**
     * @return the txProjectManager
     */
    public TextField getTxProjectManager() {
        return txProjectManager;
    }

    /**
     * @param txProjectManager the txProjectManager to set
     */
    public void setTxProjectManager(TextField txProjectManager) {
        this.txProjectManager = txProjectManager;
    }

   
    /**
     * @return the txDescription
     */
    public TextArea getTxDescription() {
        return txDescription;
    }

    /**
     * @param txDescription the txDescription to set
     */
    public void setTxDescription(TextArea txDescription) {
        this.txDescription = txDescription;
    }

    /**
     * @return the initial_date
     */
    public Calendar getInitial_date() {
        return initial_date;
    }

    /**
     * @param initial_date the initial_date to set
     */
    public void setInitial_date(Calendar initial_date) {
        this.initial_date = initial_date;
    }

    /**
     * @return the final_date
     */
    public Calendar getFinal_date() {
        return final_date;
    }

    /**
     * @param final_date the final_date to set
     */
    public void setFinal_date(Calendar final_date) {
        this.final_date = final_date;
    }

    
     /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }  
}
