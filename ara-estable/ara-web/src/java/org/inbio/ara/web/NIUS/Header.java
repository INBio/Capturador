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
 * Header.java
 *
 * Created on July 9, 2007, 7:31 AM
 * Copyright jgutierrez
 */
package org.inbio.ara.web.NIUS;

import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import com.sun.webui.jsf.component.ImageComponent;
import java.util.Locale;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.AraRequestBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.RequestBean1;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.NIUS.SpeciesTabular;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.util.MessageBean;

/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Header extends AbstractFragmentBean {
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
	// </editor-fold>

	public Header() {
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
			log("Page1 Initialization Failure", e);
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
	protected AraRequestBean getAraRequestBean() {
		return (AraRequestBean) getBean("AraRequestBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
		return (SpeciesSessionBean) getBean("species$SpeciesSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected AraApplicationBean getAraApplicationBean() {
		return (AraApplicationBean) getBean("AraApplicationBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected UserSessionBean getuser$UserSessionBean() {
		return (UserSessionBean) getBean("user$UserSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
		return (ProfileSessionBean) getBean("admin$profile$ProfileSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected SpeciesTabular getNIUS$SpeciesTabular() {
		return (SpeciesTabular) getBean("NIUS$SpeciesTabular");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected PersonSessionBean getadmin$person$PersonSessionBean() {
		return (PersonSessionBean) getBean("admin$person$PersonSessionBean");
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
	protected org.inbio.ara.web.admin.institution.InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
		return (org.inbio.ara.web.admin.institution.InstitutionSessionBean) getBean("admin$institution$InstitutionSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected GroupSessionBean getgroup$GroupSessionBean() {
		return (GroupSessionBean) getBean("group$GroupSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected AudienceSessionBean getaudience$AudienceSessionBean() {
		return (AudienceSessionBean) getBean("audience$AudienceSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
		return (ReferenceSessionBean) getBean("references$ReferenceSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected org.inbio.ara.web.SessionBean1 getSessionBean1() {
		return (org.inbio.ara.web.SessionBean1) getBean("SessionBean1");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected RequestBean1 getRequestBean1() {
		return (RequestBean1) getBean("RequestBean1");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected ApplicationBean1 getApplicationBean1() {
		return (ApplicationBean1) getBean("ApplicationBean1");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected MessageBean getutil$MessageBean() {
		return (MessageBean) getBean("util$MessageBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected org.inbio.ara.web.util.SelectionListBean getutil$SelectionListBean() {
		return (org.inbio.ara.web.util.SelectionListBean) getBean("util$SelectionListBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
		return (GatheringSessionBeanV2) getBean("gathering$GatheringSessionBeanV2");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected org.inbio.ara.web.gathering.GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
		return (org.inbio.ara.web.gathering.GatheringDetailSessionBean) getBean("gathering$GatheringDetailSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected org.inbio.ara.web.gathering.SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
		return (org.inbio.ara.web.gathering.SpecimenGenerationSessionBean) getBean("gathering$SpecimenGenerationSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected org.inbio.ara.web.identification.IdentificationSessionBean getidentification$IdentificationSessionBean() {
		return (org.inbio.ara.web.identification.IdentificationSessionBean) getBean("identification$IdentificationSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected org.inbio.ara.web.site.SiteSessionBean getsite$SiteSessionBean() {
		return (org.inbio.ara.web.site.SiteSessionBean) getBean("site$SiteSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected NomenclaturalGroupSessionBean getnomenclaturalgroup$NomenclaturalGroupSessionBean() {
		return (NomenclaturalGroupSessionBean) getBean("nomenclaturalgroup$NomenclaturalGroupSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected IdentificationSearchSessionBean getidentification$IdentificationSearchSessionBean() {
		return (IdentificationSearchSessionBean) getBean("identification$IdentificationSearchSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 */
	protected SpecimenSessionBean getspecimen$SpecimenSessionBean() {
		return (SpecimenSessionBean) getBean("specimen$SpecimenSessionBean");
	}

	public String englishLink1_action() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(Locale.ENGLISH);

		getSessionManager().setLocale(Locale.ENGLISH);
		System.out.println("--------->>>"+getSessionManager().getLocale().toString());
		
		return null;
	}

	public String spanishLink1_action() {
		FacesContext context = FacesContext.getCurrentInstance();
		Locale l = new Locale("ES");
		context.getViewRoot().setLocale(l);

		getSessionManager().setLocale(l);
		System.out.println("--------->>>"+getSessionManager().getLocale().toString());

		return null;
	}
}
