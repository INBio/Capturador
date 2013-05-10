/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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
package org.inbio.ara.admin;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import java.util.*;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.dto.agent.InstitutionDTO;
import org.inbio.ara.dto.agent.ProfileDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.ProjectDTO;
import org.inbio.ara.util.BundleHelper;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditPerson.java
 * @version Created on 07/10/2009, 03:05:16 PM
 * @author esmata
 */

public class EditProject extends AbstractPageBean {
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

    //Bindings de los componentes graficos
    private TextField txName = new TextField();
    private TextArea txDescription = new TextArea();
    private TextField txProjectManager = new TextField();
    private Calendar initial_date = new com.sun.webui.jsf.component.Calendar();
    private Calendar final_date = new com.sun.webui.jsf.component.Calendar();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditProject() {
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
            log("EditPerson Initialization Failure", e);
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
        
        if(psb.isFirstTime())
        {
            //Cargar los datos
            ProjectDTO projectTmp = psb.getCurrentProject();
            //Textos
            this.getTxDescription().setText(projectTmp.getDescription());
            this.getTxProjectManager().setText(projectTmp.getProjectManagerName());
            //fechas
            java.util.Calendar ini = projectTmp.getInitialDate();
            java.util.Calendar fin = projectTmp.getFinalDate();
            if(ini!=null)
                this.getInitial_date().setSelectedDate(ini.getTime());
            if(fin!=null)
                this.getFinal_date().setSelectedDate(fin.getTime());
            //Settear variables
            psb.setFirstTime(false);
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
     * Metodo ejecutado por el boton de actualizar persona
     * @return
     */
    public String btnUpdateProject_action() {
        //Capturar nuevos datos de la pantalla
        
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
        else
        {
            psb.getCurrentProject().setInitialDate(null);
        }
        if (finDate != null) {
            finCal.setTime(finDate);
            psb.getCurrentProject().setFinalDate(finCal);
        }
        else
        {
            psb.getCurrentProject().setFinalDate(null);
        }
        psb.getCurrentProject().setUserName(this.getAraSessionBean().getGlobalUserName());
        //Persistir el DTO
        try{
            //Mandar a persistir
            psb.updateProjectDTO();                        
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
        MessageBean.setSuccessMessageFromBundle("edit_project_success", this.getMyLocale());
        
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
     * @return the context
     */
    public FacesContext getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(FacesContext context) {
        this.context = context;
    }

    /**
     * @param myLocale the myLocale to set
     */
    public void setMyLocale(Locale myLocale) {
        this.myLocale = myLocale;
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
}


