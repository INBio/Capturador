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
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.component.TextField;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditAudience.java
 * @version Created on 05/10/2009, 10:30:23 AM
 * @author esmata
 */

public class EditAudience extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    //Bindings de los componentes graficos
    private TextField txName = new TextField();
    private TextArea txaDescription = new TextArea();

    //Contexto utilizado para obtener el current locale
    private FacesContext context;
    private Locale myLocale;

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditAudience() {
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
            log("EditAudience Initialization Failure", e);
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
        //Setear los datos actuales en la pantalla
        this.getTxName().setText(this.getAudienceSessionBean().
                getCurrentAudienceDTO().getName());
        this.getTxaDescription().setText(this.getAudienceSessionBean().
                getCurrentAudienceDTO().getDescription());
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
     * Metodo ejecutado por el boton para editar una audiencia
     * @return
     */
    public String btnUpdateAudience_action() {
        //Capturar los nuevos datos
        String name=null,description=null;
        name = (String)this.getTxName().getText();
        description = (String)this.getTxaDescription().getText();

        //Setear el current DTO
        this.getAudienceSessionBean().getCurrentAudienceDTO().setName(name);
        this.getAudienceSessionBean().getCurrentAudienceDTO().setDescription(description);

        //Persistir nueva Audiencia
        try{
            this.getAudienceSessionBean().updateAudience
                    (this.getAudienceSessionBean().getCurrentAudienceDTO());
        }
        catch(Exception e){
            MessageBean.setErrorMessageFromBundle("error", this.getMyLocale());
            return null;
        }

        //Limpiar la pantalla
        this.getTxName().setText(null);
        this.getTxaDescription().setText(null);

        //Refrescar el paginador
        this.getAudienceSessionBean().getPagination().refreshList();

        //Notificar al usuario
        MessageBean.setSuccessMessageFromBundle("edit_audience_succces", this.getMyLocale());

        return null;
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
    protected AudienceSessionBean getAudienceSessionBean() {
        return (AudienceSessionBean) getBean("admin$AudienceSessionBean");
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
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
     * @return the txaDescription
     */
    public TextArea getTxaDescription() {
        return txaDescription;
    }

    /**
     * @param txaDescription the txaDescription to set
     */
    public void setTxaDescription(TextArea txaDescription) {
        this.txaDescription = txaDescription;
    }    
}

