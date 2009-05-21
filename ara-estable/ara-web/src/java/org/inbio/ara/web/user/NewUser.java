/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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
/*
 * NewUser.java
 *
 * Created on September 16, 2007, 8:50 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.user;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Alert;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageComponent;
import com.sun.webui.jsf.component.Message;
import com.sun.webui.jsf.component.PasswordField;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.MultipleSelectOptionsList;
import com.sun.webui.jsf.model.Option;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.convert.LongConverter;
import javax.faces.event.ValueChangeEvent;
import org.inbio.ara.dto.GroupLiteDTO;
import org.inbio.ara.dto.UserFullDTO;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.persistence.security.User;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.util.BundleHelper;
import org.inbio.ara.web.util.MessageBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class NewUser extends AbstractPageBean {

	// <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
	private int __placeholder;

	/**
	 * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
	 * This method is automatically generated, so any user-specified code inserted
	 * here is subject to being replaced.</p>
	 */
	private void _init() throws Exception {
	}

	private TextField fullName = new TextField();

	private TextField userName = new TextField();

	private PasswordField password = new PasswordField();

	private PasswordField password_confirmed = new PasswordField();

	private Alert userAlert = new Alert();

	private DropDown userGroup1 = new DropDown();

	// </editor-fold>
	
	/**
	 * <p>Construct a new Page bean instance.</p>
	 */
	public NewUser() {
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
			log("Module newUser Initialization Failure", e);
			throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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
		UserSessionBean usb = getUserSessionBean();
		usb.loadGroupList();
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

	public String saveAction() {

		String destiny = null;
		UserSessionBean usb = getUserSessionBean();
		SessionManager sm = getSessionManager();

		if (((String) this.getPassword().getText()).equals(
				(String) this.getPassword_confirmed().getText())) {

			UserFullDTO tUser = new UserFullDTO();

			tUser.setUserName((String) this.getUserName().getText());
			tUser.setFullName((String) this.getFullName().getText());
			tUser.setPassword((String) this.getPassword().getText());

			tUser.setSelectedNomenclaturalGroupKeys(null);
			tUser.setSelectedTaxonKeys(null);

			tUser.setCreatedBy(sm.getUser().getUserName());
			tUser.setLastModificationBy(sm.getUser().getUserName());

			tUser.setGroupKey(usb.getSelectedGroup());

			try {
				usb.getSecurityManager().addUser(tUser);
				destiny = "saveNewUser";
			} catch (Exception e) {
				this.userAlert.setType(MessageBean.getMessageFromBundle("warning"));
				this.userAlert.setSummary(MessageBean.getMessageFromBundle("save_data_error"));
				this.userAlert.setDetail(e.getMessage());
			}
		} else {
			this.userAlert.setType(MessageBean.getMessageFromBundle("warning"));
			this.userAlert.setSummary(MessageBean.getMessageFromBundle("save_data_error"));
			this.userAlert.setDetail(MessageBean.getMessageFromBundle("create_record_failed"));
		}

		return destiny;
	}

	public String cancel_action() {
		return "doCancelNewUser";
	}

	// Getters y Setters de las variables --------------------------------------

	public TextField getFullName() {
		return fullName;
	}

	public void setFullName(TextField tf) {
		this.fullName = tf;
	}

	public TextField getUserName() {
		return userName;
	}

	public void setUserName(TextField tf) {
		this.userName = tf;
	}

	public PasswordField getPassword() {
		return password;
	}

	public void setPassword(PasswordField tf) {
		this.password = tf;
	}

	public PasswordField getPassword_confirmed() {
		return password_confirmed;
	}

	public void setPassword_confirmed(PasswordField tf) {
		this.password_confirmed = tf;
	}

	public Alert getUserAlert() {
		return userAlert;
	}

	public void setUserAlert(Alert a) {
		this.userAlert = a;
	}

	public DropDown getUserGroup1() {
		return userGroup1;
	}

	public void setUserGroup1(DropDown userGroup1) {
		this.userGroup1 = userGroup1;
	}

	// Getters de Bean ---------------------------------------------------------
	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected UserSessionBean getUserSessionBean() {
		return (UserSessionBean) getBean("UserSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected GroupSessionBean getGroupSessionBean() {
		return (GroupSessionBean) getBean("group$GroupSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected SessionManager getSessionManager() {
		return (SessionManager) getBean("SessionManager");
	}
}
