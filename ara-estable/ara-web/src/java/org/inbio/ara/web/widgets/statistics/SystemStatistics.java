/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.web.widgets.statistics;

import com.sun.data.provider.impl.ListDataProvider;
import com.sun.data.provider.impl.MapDataProvider;
import com.sun.data.provider.impl.TableRowDataProvider;
import com.sun.rave.web.ui.appbase.AbstractFragmentBean;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import javax.faces.FacesException;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.specimen.EditSpecimenSessionBean;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.util.ValidatorHelper;
import org.inbio.ara.web.site.SiteSessionBean;
import org.inbio.ara.web.identification.IdentificationSessionBean;
import org.inbio.ara.web.user.UserSessionBean;
import org.inbio.ara.web.gathering.SpecimenGenerationSessionBean;
import org.inbio.ara.web.admin.selectionlist.SelectionListSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.SessionBean1;
import org.inbio.ara.web.admin.collection.AdminCollectionSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.gathering.GatheringDetailSessionBean;
import org.inbio.ara.web.audience.AudienceSessionBean;
import org.inbio.ara.web.util.SelectionListBean;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.RequestBean1;
import org.inbio.ara.web.AraRequestBean;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.group.GroupSessionBean;

/**
 * <p>Fragment bean that corresponds to a similarly named JSP page
 * fragment.  This class contains component definitions (and initialization
 * code) for all components that you have defined on this fragment, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version SystemStatistics.java
 * @version Created on 26/03/2009, 04:05:26 PM
 * @author asanabria
 */
public class SystemStatistics extends AbstractFragmentBean {
	// <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

	/**
	 * <p>Automatically managed component initialization. <strong>WARNING:</strong>
	 * This method is automatically generated, so any user-specified code inserted
	 * here is subject to being replaced.</p>
	 */
	private void _init() throws Exception {
	}
	private ListDataProvider listDataProvider1 = new ListDataProvider();

	public ListDataProvider getListDataProvider1() {
		return listDataProvider1;
	}

	public void setListDataProvider1(ListDataProvider ldp) {
		this.listDataProvider1 = ldp;
	}

	// </editor-fold>

	public SystemStatistics() {
	}

	/**
	 * <p>Callback method that is called whenever a page containing
	 * this page fragment is navigated to, either directly via a URL,
	 * or indirectly via page navigation.  Override this method to acquire
	 * resources that will be needed for event handlers and lifecycle methods.</p>
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
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
	}

	/**
	 * <p>Callback method that is called after rendering is completed for
	 * this request, if <code>init()</code> was called.  Override this
	 * method to release resources acquired in the <code>init()</code>
	 * resources that will be needed for event handlers and lifecycle methods.</p>
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void destroy() {
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
		return (SpeciesSessionBean) getBean("species$SpeciesSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected EditSpecimenSessionBean getspecimen$EditSpecimenSessionBean() {
		return (EditSpecimenSessionBean) getBean("specimen$EditSpecimenSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected ApplicationBean1 getApplicationBean1() {
		return (ApplicationBean1) getBean("ApplicationBean1");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected ValidatorHelper getutil$ValidatorHelper() {
		return (ValidatorHelper) getBean("util$ValidatorHelper");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected SiteSessionBean getsite$SiteSessionBean() {
		return (SiteSessionBean) getBean("site$SiteSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected IdentificationSessionBean getidentification$IdentificationSessionBean() {
		return (IdentificationSessionBean) getBean("identification$IdentificationSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected UserSessionBean getuser$UserSessionBean() {
		return (UserSessionBean) getBean("user$UserSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected SpecimenGenerationSessionBean getgathering$SpecimenGenerationSessionBean() {
		return (SpecimenGenerationSessionBean) getBean("gathering$SpecimenGenerationSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected SelectionListSessionBean getadmin$selectionlist$SelectionListSessionBean() {
		return (SelectionListSessionBean) getBean("admin$selectionlist$SelectionListSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
		return (ReferenceSessionBean) getBean("references$ReferenceSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected SessionBean1 getSessionBean1() {
		return (SessionBean1) getBean("SessionBean1");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected AdminCollectionSessionBean getadmin$collection$AdminCollectionSessionBean() {
		return (AdminCollectionSessionBean) getBean("admin$collection$AdminCollectionSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected IdentificationSearchSessionBean getidentification$IdentificationSearchSessionBean() {
		return (IdentificationSearchSessionBean) getBean("identification$IdentificationSearchSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
		return (GatheringDetailSessionBean) getBean("gathering$GatheringDetailSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected AudienceSessionBean getaudience$AudienceSessionBean() {
		return (AudienceSessionBean) getBean("audience$AudienceSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected SelectionListBean getutil$SelectionListBean() {
		return (SelectionListBean) getBean("util$SelectionListBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected NomenclaturalGroupSessionBean getnomenclaturalgroup$NomenclaturalGroupSessionBean() {
		return (NomenclaturalGroupSessionBean) getBean("nomenclaturalgroup$NomenclaturalGroupSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected RequestBean1 getRequestBean1() {
		return (RequestBean1) getBean("RequestBean1");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected AraRequestBean getAraRequestBean() {
		return (AraRequestBean) getBean("AraRequestBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected SpecimenSessionBean getspecimen$SpecimenSessionBean() {
		return (SpecimenSessionBean) getBean("specimen$SpecimenSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected SystemStatisticsSessionBean getwidgets$statistics$SystemStatisticsSessionBean() {
		return (SystemStatisticsSessionBean) getBean("widgets$statistics$SystemStatisticsSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected ProfileSessionBean getadmin$profile$ProfileSessionBean() {
		return (ProfileSessionBean) getBean("admin$profile$ProfileSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected SessionManager getSessionManager() {
		return (SessionManager) getBean("SessionManager");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected AraApplicationBean getAraApplicationBean() {
		return (AraApplicationBean) getBean("AraApplicationBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected MessageBean getutil$MessageBean() {
		return (MessageBean) getBean("util$MessageBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
		return (InstitutionSessionBean) getBean("admin$institution$InstitutionSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected PersonSessionBean getadmin$person$PersonSessionBean() {
		return (PersonSessionBean) getBean("admin$person$PersonSessionBean");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
		return (GatheringSessionBeanV2) getBean("gathering$GatheringSessionBeanV2");
	}

	/**
	 * <p>Return a reference to the scoped data bean.</p>
	 *
	 * @return reference to the scoped data bean
	 */
	protected GroupSessionBean getgroup$GroupSessionBean() {
		return (GroupSessionBean) getBean("group$GroupSessionBean");
	}
	private TableRowGroup tableRowGroup1 = new TableRowGroup();

	public TableRowGroup getTableRowGroup1() {
		return tableRowGroup1;
	}

	public void setTableRowGroup1(TableRowGroup trg) {
		this.tableRowGroup1 = trg;
	}
	private TableColumn tableColumn1 = new TableColumn();

	public TableColumn getTableColumn1() {
		return tableColumn1;
	}

	public void setTableColumn1(TableColumn tc) {
		this.tableColumn1 = tc;
	}
}
