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

package org.inbio.ara.web.admin.localities;

import com.sun.rave.web.ui.appbase.AbstractPageBean;

import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.RequestBean1;
import org.inbio.ara.web.SessionBean1;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.util.MessageBean;
import javax.faces.FacesException;
import org.inbio.ara.web.nomenclaturalgroup.NomenclaturalGroupSessionBean;
import org.inbio.ara.web.gathering.GatheringDetailSessionBean;
import org.inbio.ara.web.identification.IdentificationSearchSessionBean;
import org.inbio.ara.web.NIUS.Header;
import org.inbio.ara.web.widgets.statistics.SystemStatisticsSessionBean;
import org.inbio.ara.web.references.ReferenceSessionBean;
import org.inbio.ara.web.gathering.GatheringSessionBeanV2;
import org.inbio.ara.web.admin.institution.InstitutionSessionBean;
import org.inbio.ara.web.util.ValidatorHelper;
import org.inbio.ara.web.AraRequestBean;
import org.inbio.ara.web.util.SelectionListBean;
import org.inbio.ara.web.specimen.SpecimenSessionBean;
import org.inbio.ara.web.NIUS.borrar;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.specimen.EditSpecimenSessionBean;
import org.inbio.ara.web.group.GroupSessionBean;
import org.inbio.ara.web.NIUS.SpeciesTabular;
import org.inbio.ara.web.NIUS.Menu;
import org.inbio.ara.web.gathering.identificationGenerationFragment;
import org.inbio.ara.web.admin.profile.ProfileSessionBean;
import org.inbio.ara.web.identification.IdentificationSessionBean;
import org.inbio.ara.web.admin.person.PersonSessionBean;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.audience.AudienceSessionBean;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version adminGeographicalLayers.java
 * @version Created on Feb 24, 2009, 9:49:20 AM
 * @author jgutierrez
 */

public class adminGeographicalLayers extends AbstractPageBean {



    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public adminGeographicalLayers() {
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
// Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
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

    }



    /*******************
     *  Beans o varas de esas
     *
     */

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
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
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    



    /*****
     *  gets & sets
     */


    /**
     *  Basura que pone netbeans
     */
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
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
        //TODO
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
    protected GatheringDetailSessionBean getgathering$GatheringDetailSessionBean() {
        return (GatheringDetailSessionBean) getBean("gathering$GatheringDetailSessionBean");
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
    protected Header getNIUS$Header() {
        return (Header) getBean("NIUS$Header");
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
    protected ReferenceSessionBean getreferences$ReferenceSessionBean() {
        return (ReferenceSessionBean) getBean("references$ReferenceSessionBean");
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
    protected InstitutionSessionBean getadmin$institution$InstitutionSessionBean() {
        return (InstitutionSessionBean) getBean("admin$institution$InstitutionSessionBean");
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
    protected AraRequestBean getAraRequestBean() {
        return (AraRequestBean) getBean("AraRequestBean");
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
    protected SpecimenSessionBean getspecimen$SpecimenSessionBean() {
        return (SpecimenSessionBean) getBean("specimen$SpecimenSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected borrar getNIUS$borrar() {
        return (borrar) getBean("NIUS$borrar");
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
    protected GroupSessionBean getgroup$GroupSessionBean() {
        return (GroupSessionBean) getBean("group$GroupSessionBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SpeciesTabular getNIUS$SpeciesTabular() {
        return (SpeciesTabular) getBean("NIUS$SpeciesTabular");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Menu getNIUS$Menu() {
        return (Menu) getBean("NIUS$Menu");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected identificationGenerationFragment getgathering$identificationGenerationFragment() {
        return (identificationGenerationFragment) getBean("gathering$identificationGenerationFragment");
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
    protected IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (IdentificationSessionBean) getBean("identification$IdentificationSessionBean");
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
    protected PersonSessionBean getadmin$person$PersonSessionBean() {
        return (PersonSessionBean) getBean("admin$person$PersonSessionBean");
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
    protected AudienceSessionBean getaudience$AudienceSessionBean() {
        return (AudienceSessionBean) getBean("audience$AudienceSessionBean");
    }
}

