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
 * EditUserv2.java
 *
 * Created on April 15, 2008, 5:25 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.user;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import javax.faces.FacesException;
import org.inbio.ara.dto.UserFullDTO;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.util.SelectionListBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EditUser extends AbstractPageBean {


	// <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
	private int __placeholder;

	/**
	 * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
	 * This method is automatically generated, so any user-specified code inserted
	 * here is subject to being replaced.</p>
	 */
	private void _init() throws Exception {
	}

	// </editor-fold>
	/**
	 * <p>Construct a new Page bean instance.</p>
	 */
	public EditUser() {
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
			log("Module EditUserv2 Initialization Failure", e);
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
	public void prerender() {

		// Traer la información del usuario seleccionado
		UserSessionBean usb = getUserSessionBean();

		usb.loadGroupList();
		usb.loadData();



	}

	/**
	 * <p>Callback method that is called after rendering is completed for
	 * this request, if <code>init()</code> was called (regardless of whether
	 * or not this was the page that was actually rendered).  Customize this
	 * method to release resources acquired in the <code>init()</code>,
	 * <code>preprocess()</code>, or <code>prerender()</code> methods (or
	 * acquired during execution of an event handler).</p>
	 */
	public void destroy() {
	}

	public String saveAction() {

		UserFullDTO tUser = new UserFullDTO();
		UserSessionBean usb = getUserSessionBean();
		SessionManager sm = getSessionManager();

		tUser.setUserKey(usb.getUserId());
		tUser.setUserName((String) usb.getUserNameTextField().getText());
		tUser.setFullName((String) usb.getFullNameTextField().getText());
		tUser.setGroupKey(usb.getSelectedGroup());
		tUser.setLastModificationBy(sm.getUser().getUserName());

		Long[] selected = usb.getSelectedGroups();
		ArrayList<Long> selectedList = new ArrayList<Long>();

		for(Long nomenclaturalGroupId : selected){
			selectedList.add(nomenclaturalGroupId);
		}
		tUser.setSelectedNomenclaturalGroupKeys(selectedList);
		
		selected = usb.getSelectedTaxa();
		selectedList = new ArrayList<Long>();

		for(Long taxonId : selected){
			selectedList.add(taxonId);
		}
		tUser.setSelectedTaxonKeys(selectedList);

		this.getUserSessionBean().getSecurityManager().updateUser(tUser);

		return "doSaveUser";
	}

	// Getters y Setters de Variables ------------------------------------------
	// Getters de Beans --------------------------------------------------------
	protected UserSessionBean getUserSessionBean() {
		return (UserSessionBean) getBean("UserSessionBean");
	}

	protected SessionManager getSessionManager() {
		return (SessionManager) getBean("SessionManager");
	}

	protected SelectionListBean getSelectionListBean() {
		return (SelectionListBean) getBean("util$SelectionListBean");
	}

	protected GroupSessionBean getGroupSessionBean() {
		return (GroupSessionBean) getBean("group$GroupSessionBean");
	}
}