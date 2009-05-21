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
 * SiteSessionBean.java
 *
 * Created on June 25, 2008, 11:03 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.site;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.gis.SiteRemote;
import org.inbio.ara.persistence.gis.Site;
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
public class SiteSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private SiteDataProvider siteDataProvider = new SiteDataProvider();
    private Option[] featureTypeOption;
    private Option[] projectionOption;
    private Option[] siteCalculationMethod;
    private Option[] originalProjection;
    private Long selectedFeatureType = -1L;
    private Long selectedProjection = -1L;
    private Long selectedSiteCalculationMethod = -1L;
    private Long selectedOriginalProjection = -1L;
    private CoordinateDataProvider coordinateDataProvider = new CoordinateDataProvider();
    private Site site;
    private boolean editMode;
    
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
    public SiteSessionBean() {
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
            log("SiteSessionBean Initialization Failure", e);
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
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
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
    }

    public SiteDataProvider getSiteDataProvider() {
        return siteDataProvider;
    }

    public void setSiteDataProvider(SiteDataProvider siteDataProvider) {
        this.siteDataProvider = siteDataProvider;
    }

    public Option[] getFeatureTypeOption() {
        return featureTypeOption;
    }

    public void setFeatureTypeOption(Option[] featureTypeOption) {
        this.featureTypeOption = featureTypeOption;
    }

    public Option[] getProjectionOption() {
        return projectionOption;
    }

    public void setProjectionOption(Option[] projectionOption) {
        this.projectionOption = projectionOption;
    }

    public Option[] getSiteCalculationMethod() {
        return siteCalculationMethod;
    }

    public void setSiteCalculationMethod(Option[] siteCalculationMethod) {
        this.siteCalculationMethod = siteCalculationMethod;
    }

    public Long getSelectedFeatureType() {
        return selectedFeatureType;
    }

    public void setSelectedFeatureType(Long selectedFeatureType) {
        this.selectedFeatureType = selectedFeatureType;
    }

    public Long getSelectedProjection() {
        return selectedProjection;
    }

    public void setSelectedProjection(Long selectedProjection) {
        this.selectedProjection = selectedProjection;
    }

    public Long getSelectedSiteCalculationMethod() {
        return selectedSiteCalculationMethod;
    }

    public void setSelectedSiteCalculationMethod(Long selectedSiteCalculationMethod) {
        this.selectedSiteCalculationMethod = selectedSiteCalculationMethod;
    }
    
    public Option[] getOriginalProjection() {
        return originalProjection;
    }

    public void setOriginalProjection(Option[] originalProjection) {
        this.originalProjection = originalProjection;
    }

    public Long getSelectedOriginalProjection() {
        return selectedOriginalProjection;
    }

    public void setSelectedOriginalProjection(Long selectedOriginalProjection) {
        this.selectedOriginalProjection = selectedOriginalProjection;
    }
    
    public void populateList() {
        this.setFeatureTypeOption(this.getutil$SelectionListBean().getFeatureType());
        this.setProjectionOption(this.getutil$SelectionListBean().getProjection());
        this.setSiteCalculationMethod(this.getutil$SelectionListBean().getSiteCalculationMethod());
        this.setOriginalProjection(this.getutil$SelectionListBean().getProjection());
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SelectionListBean getutil$SelectionListBean() {
        return (SelectionListBean)getBean("util$SelectionListBean");
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
    }

    private SiteRemote lookupSiteBean() {
        try {
            Context c = new InitialContext();
            return (SiteRemote) c.lookup("SiteBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public boolean create(Site site) {
        site.setBaseProjection(this.getutil$SelectionListBean().getProjectionById(this.getSelectedProjection()));
        site.setFeatureType(this.getutil$SelectionListBean().getFeatureTypeById(this.getSelectedFeatureType()));
        site.setOriginalProjection(this.getutil$SelectionListBean().getProjectionById(this.getSelectedOriginalProjection()));
        site.setSiteCalculationMethod(this.getutil$SelectionListBean().getSiteCalculationMethod(this.getSelectedSiteCalculationMethod()));
        site.setCreatedBy(this.getSessionManager().getUser().getUserName());
        site.setLastModificationBy(site.getCreatedBy());
        if (this.lookupSiteBean().create(site, this.coordinateDataProvider.getList())) {
            this.getutil$MessageBean().addSuccessMessage("Sitio creado con éxito");
            return true;
        } else {
            this.getutil$MessageBean().addErrorMessage(this.lookupSiteBean().getMessage());
            return false;
        }
    }
    
    public boolean update(Site site) {
        site.setBaseProjection(this.getutil$SelectionListBean().getProjectionById(this.getSelectedProjection()));
        site.setFeatureType(this.getutil$SelectionListBean().getFeatureTypeById(this.getSelectedFeatureType()));
        site.setOriginalProjection(this.getutil$SelectionListBean().getProjectionById(this.getSelectedOriginalProjection()));
        site.setSiteCalculationMethod(this.getutil$SelectionListBean().getSiteCalculationMethod(this.getSelectedSiteCalculationMethod()));
        site.setCreatedBy(this.getSessionManager().getUser().getUserName());
        site.setLastModificationBy(site.getCreatedBy());
        if (this.lookupSiteBean().update(site, this.coordinateDataProvider.getList())) {
            this.getutil$MessageBean().addSuccessMessage("Sitio modificado con éxito");
            return true;
        } else {
            this.getutil$MessageBean().addErrorMessage(this.lookupSiteBean().getMessage());
            return false;
        }
    }

    public CoordinateDataProvider getCoordinateDataProvider() {
        return coordinateDataProvider;
    }

    public void setCoordinateDataProvider(CoordinateDataProvider coordinateDataProvider) {
        this.coordinateDataProvider = coordinateDataProvider;
    }
    
    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
    public void delete(RowKey rowKey) {
        if (rowKey != null) {
            Site site = (Site)this.getSiteDataProvider().getObject(rowKey);
            if (this.lookupSiteBean().delete(site.getId())) {
                this.getutil$MessageBean().addSuccessMessage("Registro borrado con éxito");
            } else {
                this.getutil$MessageBean().addSuccessMessage("Error al borrar el registro: " + lookupSiteBean().getMessage());
            }                    
        } else {
            System.out.println("rowKey es nulo.");
        }
    }
    
    public void setSite(RowKey rowKey) {
        this.site = (Site)this.getSiteDataProvider().getObject(rowKey);
        this.selectedFeatureType = this.site.getFeatureType().getId();
        this.selectedOriginalProjection = this.site.getOriginalProjection().getId();
        this.selectedProjection = this.site.getBaseProjection().getId();
        this.selectedSiteCalculationMethod = this.site.getSiteCalculationMethod().getId();
        this.coordinateDataProvider.setList(this.getSite().getCoordinateList());
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }
    
    public void cleanParameters() {
        featureTypeOption = null;
        projectionOption = null;
        siteCalculationMethod = null;
        originalProjection = null;
        selectedFeatureType = -1L;
        selectedProjection = -1L;
        selectedSiteCalculationMethod = -1L;
        selectedOriginalProjection = -1L;
        coordinateDataProvider = new CoordinateDataProvider();
        site = null;
    }
}
