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

package org.inbio.ara.util;

import com.sun.rave.web.ui.appbase.AbstractApplicationBean;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * <p>Application scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available to all users
 *  and pages in the application.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class MessageBean extends AbstractApplicationBean {
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

    private static String bundle = "org/inbio/ara/resources/global";

	/**
	 * <p>Construct a new application data bean instance.</p>
	 */
	public MessageBean() {
	}

	/**
	 * <p>This method is called when this bean is initially added to
	 * application scope.  Typically, this occurs as a result of evaluating
	 * a value binding or method binding expression, which utilizes the
	 * managed bean facility to instantiate this bean and store it into
	 * application scope.</p>
	 *
	 * <p>You may customize this method to initialize and cache application wide
	 * data values (such as the lists of valid options for dropdown list
	 * components), or to allocate resources that are required for the
	 * lifetime of the application.</p>
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
			log("MessageBean Initialization Failure", e);
			throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
		}

	// </editor-fold>
	// Perform application initialization that must complete
	// *after* managed components are initialized
	// TODO - add your own initialization code here
	}

	/**
	 * <p>This method is called when this bean is removed from
	 * application scope.  Typically, this occurs as a result of
	 * the application being shut down by its owning container.</p>
	 *
	 * <p>You may customize this method to clean up resources allocated
	 * during the execution of the <code>init()</code> method, or
	 * at any later time during the lifetime of the application.</p>
	 */
    @Override
	public void destroy() {
	}

	/**
	 * <p>Return an appropriate character encoding based on the
	 * <code>Locale</code> defined for the current JavaServer Faces
	 * view.  If no more suitable encoding can be found, return
	 * "UTF-8" as a general purpose default.</p>
	 *
	 * <p>The default implementation uses the implementation from
	 * our superclass, <code>AbstractApplicationBean</code>.</p>
	 */
    @Override
	public String getLocaleCharacterEncoding() {
		return super.getLocaleCharacterEncoding();
	}

	private static void addErrorMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("errorMessage", facesMsg);
	}

	private static void addSuccessMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage("successInfo", facesMsg);
	}


    public static void setErrorMessageFromBundle(String key,Locale locale){
        String errorMsj = ResourceBundle.getBundle(bundle,locale).getString(key);
        MessageBean.addErrorMessage(errorMsj);
    }

    public static void setSuccessMessageFromBundle(String key,Locale locale) {
        String errorMsj = ResourceBundle.getBundle(bundle,locale).getString(key);
        MessageBean.addSuccessMessage(errorMsj);
    }

    public static String getMessageFromBundle(String key,Locale locale){
        return ResourceBundle.getBundle(bundle,locale).getString(key);
    }
}
