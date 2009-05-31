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
 * GatheringSessionBeanV2.java
 *
 * Created on May 11, 2008, 8:27 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.gathering;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.gathering.GatheringRemote;
import org.inbio.ara.facade.util.SearchManagerRemote;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
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
public class GatheringSessionBeanV2 extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    // private GatheringDataProvider gatheringDataProvider = new GatheringDataProvider(this.getSessionManager().getCollection().getId());
    private GatheringDataProvider gatheringDataProvider;
    private GatheringObservation gatheringObservation;
    private Option[] sites;
    private Long selectedSite;
    private Option[] responsiblePersons;
    private Long selectedResponsiblePerson;
    private Option[] expositions;
    private Long selectedExposition;
    private Option[] collectors;
    private Long[] selectedCollectors;
    private Option[] projects;
    private Long[] selectedProjects;
    private Option[] collections;
    private Long[] selectedCollections;
    private boolean editMode = false;
    private GatheringDetailDataProvider gatheringDetailDataProvider = new GatheringDetailDataProvider();
    private boolean filtered = false; //Usada en la busqueda de recolecciones/observaciones
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        gatheringDataProvider = new GatheringDataProvider(this.getSessionManager().getCollection().getId());
    }
    // </editor-fold>
    
    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public GatheringSessionBeanV2() {
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
            log("GatheringSessionBeanV2 Initialization Failure", e);
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
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
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
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
    }

    public GatheringDataProvider getGatheringDataProvider() {
        return gatheringDataProvider;
    }

    public void setGatheringDataProvider(GatheringDataProvider gatheringDataProvider) {
        this.gatheringDataProvider = gatheringDataProvider;
    }

    public GatheringObservation getGatheringObservation() {
        return gatheringObservation;
    }

    public void setGatheringObservation(GatheringObservation gatheringObservation) {
        this.gatheringObservation = gatheringObservation;
    }

    public Option[] getSites() {
        return sites;
    }

    public void setSites(Option[] sites) {
        this.sites = sites;
    }

    public Long getSelectedSite() {
        return selectedSite;
    }

    public void setSelectedSite(Long selectedSite) {
        this.selectedSite = selectedSite;
    }

    public Option[] getResponsiblePersons() {
        return responsiblePersons;
    }

    public void setResponsiblePersons(Option[] responsiblePersons) {
        this.responsiblePersons = responsiblePersons;
    }

    public Long getSelectedResponsiblePerson() {
        return selectedResponsiblePerson;
    }

    public void setSelectedResponsiblePerson(Long selectedResponsiblePerson) {
        this.selectedResponsiblePerson = selectedResponsiblePerson;
    }

    public Option[] getExpositions() {
        return expositions;
    }

    public void setExpositions(Option[] expositions) {
        this.expositions = expositions;
    }

    public Long getSelectedExposition() {
        return selectedExposition;
    }

    public void setSelectedExposition(Long selectedExposition) {
        this.selectedExposition = selectedExposition;
    }

    private GatheringRemote lookupGatheringBean() {
        try {
            Context c = new InitialContext();
            return (GatheringRemote) c.lookup("GatheringBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public Option[] getCollectors() {
        return collectors;
    }

    public void setCollectors(Option[] collectors) {
        this.collectors = collectors;
    }

    public Long[] getSelectedCollectors() {
        return selectedCollectors;
    }

    public void setSelectedCollectors(Long[] selectedCollectors) {
        this.selectedCollectors = selectedCollectors;
    }

    public Option[] getProjects() {
        return projects;
    }

    public void setProjects(Option[] projects) {
        this.projects = projects;
    }

    public Long[] getSelectedProjects() {
        return selectedProjects;
    }

    public void setSelectedProjects(Long[] selectedProjects) {
        this.selectedProjects = selectedProjects;
    }

    public Option[] getCollections() {
        return collections;
    }

    public void setCollections(Option[] collections) {
        this.collections = collections;
    }

    public Long[] getSelectedCollections() {
        return selectedCollections;
    }

    public void setSelectedCollections(Long[] selectedCollections) {
        this.selectedCollections = selectedCollections;
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SelectionListBean getSelectionListBean() {
        return (SelectionListBean)getBean("util$SelectionListBean");
    }
    
    public void populateList() {
        this.setSites(this.getSelectionListBean().getSite());
        this.setResponsiblePersons(this.getSelectionListBean().getGatheringResponsible());
        this.setExpositions(this.getSelectionListBean().getExposition());
        this.setCollectors(this.getSelectionListBean().getCollector());
        this.setProjects(this.getSelectionListBean().getProject());
        this.setCollections(this.getSelectionListBean().getCollection());
        if (this.gatheringObservation != null) {
            if(this.getSessionManager().useGatheringDetail()) {
                this.gatheringDetailDataProvider.refreshDataList(this.getGatheringObservation().getId(), this.getSessionManager().getCollection().getId());
            }
        }
    }
    
    public boolean create(GatheringObservation newObj) {
        boolean created = false;
        
        if (this.lookupGatheringBean().create(newObj, this.getSelectedCollectors(), this.selectedProjects, this.selectedCollections)) {
            this.gatheringDataProvider.refreshDataList(this.getSessionManager().getCollection().getId());;
            this.gatheringObservation = this.lookupGatheringBean().getGathering();
            this.populateList();
            created = true;
            this.getutil$MessageBean().addSuccessMessage("El registro se cre� con �xito");
        } else {
            this.getutil$MessageBean().addErrorMessage(this.lookupGatheringBean().getMessage());
        }
        return created;
    }
    
    public boolean update(GatheringObservation newObj) {
        boolean update = false;
        
        
        /*if (this.lookupGatheringBean().update(newObj, this.getSelectedCollectors(), this.selectedProjects, this.selectedCollections)) {
            this.gatheringDataProvider.refreshDataList(this.getSessionManager().getCollection().getId());;
            this.gatheringObservation = this.lookupGatheringBean().getGathering();
            this.populateList();
            update = true;
            this.getutil$MessageBean().addSuccessMessage("El registro se modific� con �xito");
        } else {
            this.getutil$MessageBean().addErrorMessage(this.lookupGatheringBean().getMessage());
        }*/
        
        /*if (this.lookupGatheringBean().update(newObj)) {
            this.lookupGatheringBean().updateAssociatedInformation(this.getSelectedCollectors(), this.selectedProjects, this.selectedCollections);
         */
        if (this.lookupGatheringBean().update(newObj, this.getSelectedCollectors(), this.selectedProjects, this.selectedCollections)) {        
            this.gatheringDataProvider.refreshDataList(this.getSessionManager().getCollection().getId());
            this.gatheringObservation = this.lookupGatheringBean().getGathering();
            this.populateList();
            update = true;
            if (this.lookupGatheringBean().getMessage()!= null) {
                this.getutil$MessageBean().addErrorMessage(this.lookupGatheringBean().getMessage());
            }
            this.getutil$MessageBean().addSuccessMessage("El registro se modific� con �xito");
        } else {
            this.getutil$MessageBean().addErrorMessage(this.lookupGatheringBean().getMessage());
        }
        return update;
    }
    
    public boolean createCollectors() {
        if (this.lookupGatheringBean().createCollectors(this.getSelectedCollectors())) {
            this.getutil$MessageBean().addSuccessMessage("Colectores creados.");
            return true;
        } else {
            this.getutil$MessageBean().addErrorMessage(this.lookupGatheringBean().getMessage());
            return false;
        }
    }
    
    public void setSelectedGathering(RowKey rowKey){
        if (rowKey != null) {
            this.setGatheringObservation((GatheringObservation)this.getGatheringDataProvider().getObject(rowKey));
            //this.gatheringDetailDataProvider = new GatheringDetailDataProvider(this.gatheringObservation.getId(), this.getSessionManager().getCollection().getId());
        } else {
            System.out.println("rowKey es nulo.");
        }
    }
    
    public boolean delete() {
        boolean deleted = false;
        if (this.lookupGatheringBean().delete(this.getGatheringObservation().getId())) {
            this.gatheringDataProvider.refreshDataList(this.getSessionManager().getCollection().getId());
            deleted = true;
            this.getutil$MessageBean().addSuccessMessage("Registro borrado con �xito");
        } else {
            this.getutil$MessageBean().addErrorMessage(this.lookupGatheringBean().getMessage());
        }
        return deleted;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public GatheringDetailDataProvider getGatherinDetailDataProvider() {
        return gatheringDetailDataProvider;
    }

    public void setGatherinDetailDataProvider(GatheringDetailDataProvider gatheringDetailDataProvider) {
        this.gatheringDetailDataProvider = gatheringDetailDataProvider;
    }
    
    public GatheringObservationDetail getGatheringObservationDetail(RowKey rowkey) {
        if (rowkey != null) {
            return (GatheringObservationDetail)this.gatheringDetailDataProvider.getObject(rowkey);
        } else {
            this.getutil$MessageBean().addErrorMessage("Rowkey es nulo");
            return null;
        }
    }
    
    public void cleanParameters() {
        gatheringObservation = null;
        sites = null;
        selectedSite = null;
        responsiblePersons = null;
        selectedResponsiblePerson = null;
        expositions = null;
        selectedExposition = null;
        collectors = null;
        selectedCollectors = null;
        projects = null;
        selectedProjects = null;
        collections = null;
        selectedCollections = null;
        gatheringDetailDataProvider = new GatheringDetailDataProvider();
    }

    private SearchManagerRemote lookupSearchManagerBean() {
        try {
            Context c = new InitialContext();
            return (SearchManagerRemote) c.lookup("SearchManagerBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public SearchManagerRemote getSearchManager() {
        return this.lookupSearchManagerBean();
    }

    /**
     * @return the filtered
     */
    public boolean isFiltered() {
        return filtered;
    }

    /**
     * @param filtered the filtered to set
     */
    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }

    public void initDataProvider() {
        if (!filtered) {
            this.gatheringDataProvider.clearObjectList();
            this.gatheringDataProvider.refreshDataList(getSessionManager().
                    getCollection().getId());
        }
    }
    
}
