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

package org.inbio.ara.security;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.PasswordField;
import com.sun.webui.jsf.component.TextField;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.inbio.ara.AraSessionBean;
import org.inbio.ara.util.MD5Encrypter;
import org.inbio.ara.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ChangePassword.java
 * @version Created on 24/09/2009, 02:22:20 PM
 * @author esmata
 */

public class ChangePassword extends AbstractPageBean {
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

    //Binding de los componentes graficos
    private TextField txFullName = new TextField();
    private TextField txUserName = new TextField();
    private PasswordField pfPassword = new PasswordField();
    private PasswordField pfConfirmPass = new PasswordField();
    private PasswordField pfCurrent = new PasswordField();

    private MD5Encrypter encrypter = new MD5Encrypter();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ChangePassword() {
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
            log("ChangePassword Initialization Failure", e);
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
        String fullName  = this.getUserSessionBean().getCurrentUser().getFullname();
        String userName = this.getUserSessionBean().getCurrentUser().getUsername();
        this.getTxFullName().setText(fullName);
        this.getTxUserName().setText(userName);
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

    protected SystemUserSessionBean getUserSessionBean() {
        return (SystemUserSessionBean) getBean("security$SystemUserSessionBean");
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
     * Metodo ejecutado por el boton de cambiar contrasena
     * @return
     */
    public String btnChangePassword_action() {

        SystemUserSessionBean usb = this.getUserSessionBean();

        String actual =null,nueva=null,confirm=null,actual_encrypted="";
        actual = (String)this.getPfCurrent().getText();
        nueva = (String)this.getPfPassword().getText();
        confirm = (String)this.getPfConfirmPass().getText();
        if(actual!=null){
            actual_encrypted = this.getEncrypter().Encrypt(actual);
        }

        //Verificar la contrasena actual
        if(!actual_encrypted.equals(usb.getCurrentUser().getPasswd())){
            MessageBean.setErrorMessageFromBundle
                    ("invalid_actual_password", this.getMyLocale());
            return null;
        }

        //Verificar que las nuevas coincidan
        if(!nueva.equals(confirm)){
            MessageBean.setErrorMessageFromBundle
                    ("new_password_dont_match", this.getMyLocale());
            return null;
        }

        //Setear el DTO con los nuevos datos
        usb.getCurrentUser().setPasswd(this.getEncrypter().Encrypt(nueva));

        //Persistir los cambios
        usb.updateSystemUser();

        //Notificar al usuario
        MessageBean.setSuccessMessageFromBundle
                ("updated_succes", this.getMyLocale());

        return null;
    }

    /**
     * @return the txFullName
     */
    public TextField getTxFullName() {
        return txFullName;
    }

    /**
     * @param txFullName the txFullName to set
     */
    public void setTxFullName(TextField txFullName) {
        this.txFullName = txFullName;
    }

    /**
     * @return the txUserName
     */
    public TextField getTxUserName() {
        return txUserName;
    }

    /**
     * @param txUserName the txUserName to set
     */
    public void setTxUserName(TextField txUserName) {
        this.txUserName = txUserName;
    }

    /**
     * @return the pfPassword
     */
    public PasswordField getPfPassword() {
        return pfPassword;
    }

    /**
     * @param pfPassword the pfPassword to set
     */
    public void setPfPassword(PasswordField pfPassword) {
        this.pfPassword = pfPassword;
    }

    /**
     * @return the pfConfirmPass
     */
    public PasswordField getPfConfirmPass() {
        return pfConfirmPass;
    }

    /**
     * @param pfConfirmPass the pfConfirmPass to set
     */
    public void setPfConfirmPass(PasswordField pfConfirmPass) {
        this.pfConfirmPass = pfConfirmPass;
    }

    /**
     * @return the myLocale
     */
    public Locale getMyLocale() {
		return this.getAraSessionBean().getCurrentLocale();
    }

    /**
     * @return the pfCurrent
     */
    public PasswordField getPfCurrent() {
        return pfCurrent;
    }

    /**
     * @param pfCurrent the pfCurrent to set
     */
    public void setPfCurrent(PasswordField pfCurrent) {
        this.pfCurrent = pfCurrent;
    }

    /**
     * @return the encrypter
     */
    public MD5Encrypter getEncrypter() {
        return encrypter;
    }

    /**
     * @param encrypter the encrypter to set
     */
    public void setEncrypter(MD5Encrypter encrypter) {
        this.encrypter = encrypter;
    }

    public void pfCurrent_processValueChange(ValueChangeEvent event) {
    }

    public void pfPassword_processValueChange(ValueChangeEvent event) {
    }

    public void pfConfirmPass_processValueChange(ValueChangeEvent event) {
    }
    
}

