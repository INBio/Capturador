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
 * IdentificationSearchSessionBean.java
 *
 * Created on July 15, 2008, 12:48 AM
 * Copyright roaguilar
 */
package org.inbio.ara.web.identification;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.specimen.IdentificationRemote;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.SessionManager;
import org.inbio.ara.web.util.MessageBean;
import org.inbio.ara.web.util.SelectionListBean;

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
public class IdentificationSearchSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    private Option[] taxonomicalRangeOption;
    private Long selectedTaxonomicalRange = -1L;
    private Option[] taxonCategoryOption;
    private Long selectedTaxonCategory = -1L;
    private Option[] taxonList;
    private Long selectedTaxon;
    private int specimenCount = 0;
    private Option[] collectors;
    private Long selectedCollector;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    
    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public IdentificationSearchSessionBean() {
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
            log("IdentificationSearchSessionBean Initialization Failure", e);
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
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
    }

    private IdentificationRemote lookupIdentificationBean() {
        try {
            Context c = new InitialContext();
            return (IdentificationRemote) c.lookup("IdentificationBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public Option[] getTaxonomicalRangeOption() {
        return taxonomicalRangeOption;
    }

    public void setTaxonomicalRangeOption(Option[] taxonomicalRangeOption) {
        this.taxonomicalRangeOption = taxonomicalRangeOption;
    }

    public Long getSelectedTaxonomicalRange() {
        return selectedTaxonomicalRange;
    }

    public void setSelectedTaxonomicalRange(Long selectedTaxonomicalRange) {
        this.selectedTaxonomicalRange = selectedTaxonomicalRange;
    }

    public Option[] getTaxonCategoryOption() {
        return taxonCategoryOption;
    }

    public void setTaxonCategoryOption(Option[] taxonCategoryOption) {
        this.taxonCategoryOption = taxonCategoryOption;
    }

    public Long getSelectedTaxonCategory() {
        return selectedTaxonCategory;
    }

    public void setSelectedTaxonCategory(Long selectedTaxonCategory) {
        this.selectedTaxonCategory = selectedTaxonCategory;
    }

    public Option[] getTaxonList() {
        return taxonList;
    }

    public void setTaxonList(Option[] taxonList) {
        this.taxonList = taxonList;
    }
    
    public void populateTaxonOptions() {
        if (this.getSelectedTaxonomicalRange() != -1L) {
            if (this.getSelectedTaxonCategory() != -1L) {
                this.setTaxonList(this.getSelectionListBean().getFilteredTaxonList(this.getSelectedTaxonomicalRange(), this.getSelectedTaxonCategory()));
                if (this.taxonList == null) {
                    this.specimenCount = 0;
                }
                if (this.taxonList.length == 0) {
                    this.specimenCount = 0;
                }
                if (this.getSelectedTaxon() != null) {
                    this.searchByTaxon();
                }
            }
        }
    }
    
    public void populateGatheringDetailOptions() {
        this.collectors = this.getutil$SelectionListBean().getCollector();
    }    
    
    public void searchByTaxon() {
        this.setSpecimenCount(this.lookupIdentificationBean().getSpecimenCountByTaxon(this.getSelectedTaxon(), this.getSessionManager().getCollection().getId()));
    }
    
    public void searchByGatheringId(Long gatheringId) {
        this.setSpecimenCount(this.lookupIdentificationBean().getSpecimenCountByGathering(gatheringId, this.getSessionManager().getCollection().getId()));
    }
    
    public void searchByGatheringDetail(String gatheringNumber) {
        this.setSpecimenCount(this.lookupIdentificationBean().getSpecimenCountByGatheringDetail(this.selectedCollector, gatheringNumber, this.getSessionManager().getCollection().getId()));
    }
    
    public void getSpecimenArrayByTaxon() {
        this.getidentification$IdentificationSessionBean().addSpecimens(this.lookupIdentificationBean().getSpecimenByTaxon(this.getSelectedTaxon(), this.getSessionManager().getCollection().getId()));
    }
    
    public void getSpecimenArrayByGatheringObservation(Long gatheringId) {
        this.getidentification$IdentificationSessionBean().addSpecimens(this.lookupIdentificationBean().getSpecimenByGathering(gatheringId, this.getSessionManager().getCollection().getId()));
    }
    
    public void getSpecimenArrayByGatheringDetail(String gatheringNumber) {
        this.getidentification$IdentificationSessionBean().addSpecimens(this.lookupIdentificationBean().getSpecimenByGatheringDetail(this.selectedCollector, gatheringNumber, this.getSessionManager().getCollection().getId()));
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SelectionListBean getSelectionListBean() {
        return (SelectionListBean)getBean("util$SelectionListBean");
    }

    public int getSpecimenCount() {
        return specimenCount;
    }

    public void setSpecimenCount(int specimenCount) {
        this.specimenCount = specimenCount;
    }

    public Long getSelectedTaxon() {
        return selectedTaxon;
    }

    public void setSelectedTaxon(Long selectedTaxon) {
        this.selectedTaxon = selectedTaxon;
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected IdentificationSessionBean getidentification$IdentificationSessionBean() {
        return (IdentificationSessionBean)getBean("identification$IdentificationSessionBean");
    }
    
    public void cleanParameters() {
        taxonomicalRangeOption = null;
        selectedTaxonomicalRange = -1L;
        taxonCategoryOption = null;
        selectedTaxonCategory = -1L;
        taxonList = null;
        selectedTaxon = null;
        specimenCount = 0;
        collectors = null;
        selectedCollector = null;
        
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
    }

    public Option[] getCollectors() {
        return collectors;
    }

    public void setCollectors(Option[] collectors) {
        this.collectors = collectors;
    }

    public Long getSelectedCollector() {
        return selectedCollector;
    }

    public void setSelectedCollector(Long selectedCollector) {
        this.selectedCollector = selectedCollector;
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SelectionListBean getutil$SelectionListBean() {
        return (SelectionListBean)getBean("util$SelectionListBean");
    }
}
