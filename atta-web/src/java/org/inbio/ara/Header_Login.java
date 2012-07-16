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

import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.ImageComponent;
import com.sun.webui.jsf.component.Link;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlOutputLink;
import javax.faces.context.FacesContext;

/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Header_Login extends AbstractFragmentBean {
	// <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

	private int __placeholder;

	/**
	 * <p>Automatically managed component initialization. <strong>WARNING:</strong>
	 * This method is automatically generated, so any user-specified code inserted
	 * here is subject to being replaced.</p>
	 */
	private void _init() throws Exception {
	}
	private ImageComponent image1 = new ImageComponent();

	public ImageComponent getImage1() {
		return image1;
	}

	public void setImage1(ImageComponent ic) {
		this.image1 = ic;
	}
	private HtmlOutputLink hyperlink1 = new HtmlOutputLink();

	public HtmlOutputLink getHyperlink1() {
		return hyperlink1;
	}

	public void setHyperlink1(HtmlOutputLink hol) {
		this.hyperlink1 = hol;
	}
	// </editor-fold>

	public Header_Login() {
	}

	/**
	 * <p>Callback method that is called whenever a page containing
	 * this page fragment is navigated to, either directly via a URL,
	 * or indirectly via page navigation.  Override this method to acquire
	 * resources that will be needed for event handlers and lifecycle methods.</p>
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	public void init() {
		// Perform initializations inherited from our superclass
		super.init();
		// Perform application initialization that must complete
		// *before* managed components are initialized
		// TODO - add your own initialiation code here


		// <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
		// Initialize automatically managed components
		// *Note* - this logic should NOT be modified
		try {
			_init();
		} catch (Exception e) {
			log("Module page1 Initialization Failure", e);
			throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
		}

		// </editor-fold>
		// Perform application initialization that must complete
		// *after* managed components are initialized
		// TODO - add your own initialization code here

		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(getSessionManager().getLocale());

	}

	/**
	 * <p>Callback method that is called after rendering is completed for
	 * this request, if <code>init()</code> was called.  Override this
	 * method to release resources acquired in the <code>init()</code>
	 * resources that will be needed for event handlers and lifecycle methods.</p>
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	public void destroy() {
	}

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager) getBean("SessionManager");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraSessionBean getAraSessionBean() {
        return (AraSessionBean) getBean("AraSessionBean");
    }

    /**
     * Metodo ejecutado por el link de cambio de idioma a inglés
     * @return
     */
	public String englishLink1_action() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(Locale.ENGLISH);
		this.getSessionManager().setLocale(Locale.ENGLISH);
        this.getAraSessionBean().setCurrentLocale(Locale.ENGLISH);
		return null;
	}

    /**
     * Metodo ejecutado por el link de cambio de idioma a español
     * @return
     */
	public String spanishLink1_action() {
		FacesContext context = FacesContext.getCurrentInstance();
		Locale l = new Locale("ES");
		context.getViewRoot().setLocale(l);
		this.getSessionManager().setLocale(l);
        this.getAraSessionBean().setCurrentLocale(l);
		return null;
	}

    /**
     * Metodo ejecutado por el link de cambio de idioma a francés
     * @return
     */
	public String frenchLink1_action() {
        FacesContext context = FacesContext.getCurrentInstance();
        Locale l = new Locale("FR");
        context.getViewRoot().setLocale(l);
        this.getSessionManager().setLocale(l);
        this.getAraSessionBean().setCurrentLocale(l);
        return null;
    }

	private Head head1 = new Head();

	public Head getHead1() {
		return head1;
	}

	public void setHead1(Head h) {
		this.head1 = h;
	}
	private Link link1 = new Link();

	public Link getLink1() {
		return link1;
	}

	public void setLink1(Link l) {
		this.link1 = l;
	}
}
