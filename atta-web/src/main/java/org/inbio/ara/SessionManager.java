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

package org.inbio.ara;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.security.NomenclaturalGroupDTO;
import org.inbio.ara.dto.security.SystemUserDTO;
import org.inbio.ara.facade.agent.AdminFacadeRemote;
import org.inbio.ara.facade.security.SecurityFacadeRemote;
import org.inbio.ara.util.MD5Encrypter;
import org.inbio.ara.util.MessageBean;
 
/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class SessionManager extends AbstractSessionBean implements Serializable {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private Long currentModuleId;
	private Locale locale;
    private MD5Encrypter encrypter = new MD5Encrypter();
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    @EJB
    private SecurityFacadeRemote securityFacade;
    @EJB
    private AdminFacadeRemote adminFacade;


    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SessionManager() {
		locale = new Locale("ES");
    }
    
    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     *
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
     */
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
            log("SessionManager Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }
    
    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    public void passivate() {
    }
    
    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     *
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    public void activate() {
    }
    
    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }

    /**
     * Abrir sesion de usuario
     * @param userName
     * @param password
     * @return SystemUserDTO si el usuario existe, null en otro caso
     */
    public SystemUserDTO doLogin(String userName, String password) {

        String encryptedPass = this.encrypter.Encrypt(password);

        //Traer el usuario con el user y password indicados
        SystemUserDTO userDTO = securityFacade.getSystemUserByNameAndPass(userName, encryptedPass);

        //Si el usuario es nulo, retorno null
        if(userDTO==null)
            return null;

        //Si el usuario existe, retorno el usuario e inicio nueva session
        else{
            return userDTO;
        }
    }

    /**
     * Cerrar sesion de usuario
     */
    public void doLogoff() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().
                getExternalContext().getSession(false);
        session.invalidate();
    }

    /**
     * Metodo para obtener la lista de taxones con la que puede trabajar un
     * determinado usuario
     */
    public List<TaxonDTO> getUserTaxonList(Long userId){
        return this.adminFacade.getUserTaxonList(userId);
    }

    /**
     * Metodo para obtener la lista de grupos con la que puede trabajar un
     * determinado usuario
     */
    public List<NomenclaturalGroupDTO> getNomenclaturalGroupList(Long userId){
        return this.securityFacade.getNomenclaturalGroupList(userId);
    }

    public Long getCollecionByNomenclaturalGroup(Long nomenclatural)
    {
        return this.securityFacade.getCollecionIdByNomenclaturalGroupId(nomenclatural);
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }

    public Long getCurrentModuleId() {
        return currentModuleId;
    }

    public void setCurrentModuleId(Long currentModuleId) {
        this.currentModuleId = currentModuleId;
    }

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	
}
