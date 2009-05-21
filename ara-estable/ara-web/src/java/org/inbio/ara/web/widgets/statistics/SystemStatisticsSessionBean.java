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
package org.inbio.ara.web.widgets.statistics;

import com.sun.data.provider.impl.ObjectListDataProvider;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.SystemStatisticsDTO;
import org.inbio.ara.facade.systemstatistics.SystemStatisticsManagerRemote;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.util.ValidatorHelper;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.util.MessageBean;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version SystemStatisticsSessionBean.java
 * @version Created on 26/03/2009, 12:23:28 PM
 * @author asanabria
 */
public class SystemStatisticsSessionBean extends AbstractSessionBean {
	// <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

	/**
	 * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
	 * This method is automatically generated, so any user-specified code inserted
	 * here is subject to being replaced.</p>
	 */
	private void _init() throws Exception {
	}
	// </editor-fold>

	/**
     * Managers
     */
    @EJB
    private SystemStatisticsManagerRemote systemStatisticManager;


	private ObjectListDataProvider speciesDataProvider;
	private ObjectListDataProvider specimenDataProvider;

	/**
	 * <p>Construct a new session data bean instance.</p>
	 */
	public SystemStatisticsSessionBean() {
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
			log("SystemStatisticsSessionBean Initialization Failure", e);
			throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
		}

	// </editor-fold>
	// Perform application initialization that must complete
	// *after* managed components are initialized
	// TODO - add your own initialization code here

		

		 speciesDataProvider = new ObjectListDataProvider(SystemStatisticsDTO.class);
		 specimenDataProvider = new ObjectListDataProvider(SystemStatisticsDTO.class);

		 speciesDataProvider.setList(systemStatisticManager.getSpeciesCountByCollection());
		 specimenDataProvider.setList(systemStatisticManager.getSpecimenCountByCollection());

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
	@Override
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
	@Override
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
	@Override
	public void destroy() {
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

	public ObjectListDataProvider getSpeciesDataProvider() {
		return speciesDataProvider;
	}

	public void setSpeciesDataProvider(ObjectListDataProvider speciesDataProvider) {
		this.speciesDataProvider = speciesDataProvider;
	}

	public ObjectListDataProvider getSpecimenDataProvider() {
		return specimenDataProvider;
	}

	public void setSpecimenDataProvider(ObjectListDataProvider specimenDataProvider) {
		this.specimenDataProvider = specimenDataProvider;
	}
}
