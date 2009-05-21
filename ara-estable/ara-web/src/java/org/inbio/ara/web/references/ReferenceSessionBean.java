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
 * ReferenceSessionBean.java
 *
 * Created on February 8, 2008, 10:14 AM
 * Copyright roaguilar
 */
package org.inbio.ara.web.references;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.reference.ReferenceRemote;
import org.inbio.ara.facade.util.SearchManagerRemote;
import org.inbio.ara.facade.util.SelectionListManagerRemote;
import org.inbio.ara.persistence.reference.Reference;
import org.inbio.ara.persistence.reference.ReferenceType;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;
import org.inbio.ara.web.species.SpeciesSessionBean;
import org.inbio.ara.web.SessionManager;
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
 */
public class ReferenceSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    public ReferenceDataProvider referenceDataProvider = new ReferenceDataProvider();
    private String ejbMessage = "";
    private Reference reference;
    private Option[] languageOptions;
    private Option[] referenceTypeOptions;
    private Long selectedLanguage;
    private Long selectedReferenceType;
    private Long selectedReferenceElement;
    private SearchManagerRemote searchManager;
    private boolean filtered = false;
    
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
    public ReferenceSessionBean() {
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
            log("ReferenceSessionBean Initialization Failure", e);
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

    public ReferenceDataProvider getReferenceDataProvider() {
        return referenceDataProvider;
    }

    public void setReferenceDataProvider(ReferenceDataProvider referenceDataProvider) {
        this.referenceDataProvider = referenceDataProvider;
    }
    
    public boolean create(Reference reference) {
        boolean created = false;
        
        if (this.lookupReferenceBean().create(reference)) {
            this.referenceDataProvider.refreshDataList();
            this.reference = this.lookupReferenceBean().getReference();
            this.populateList();
            this.setSelectedReferenceElement(-1L);
            created = true;
            this.setEjbMessage("El registro se creó con éxito.");
        } else {
            this.setEjbMessage(this.lookupReferenceBean().getMessage());
        }
        return created;
    }
    
    public boolean update(Reference reference) {
        boolean created = false;
        
        if (this.lookupReferenceBean().update(reference)) {
            this.referenceDataProvider.refreshDataList();
            created = true;
            this.setEjbMessage("El registro se creó con éxito.");
        } else {
            this.setEjbMessage(this.lookupReferenceBean().getMessage());
        }
        return created;
    }
    
    public boolean delete() {
        boolean deleted = false;
        if (this.lookupReferenceBean().remove(this.getReference().getId())) {
            getReferenceDataProvider().refreshDataList();
            deleted = true;
        } else {
            this.setEjbMessage(this.lookupReferenceBean().getMessage());
            System.out.println(getEjbMessage());
        }
        return deleted;
    }

    private ReferenceRemote lookupReferenceBean() {
        try {
            Context c = new InitialContext();
            return (ReferenceRemote) c.lookup("ReferenceBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public String getEjbMessage() {
        return ejbMessage;
    }

    public void setEjbMessage(String ejbMessage) {
        this.ejbMessage = ejbMessage;
    }
    
    private SelectionListManagerRemote lookupSelectionListManagerBean() {
        try {
            Context c = new InitialContext();
            return (SelectionListManagerRemote) c.lookup("SelectionListManagerBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public Option[] getReferenceType() {
        return this.lookupSelectionListManagerBean().getReferenceType();
    }
    
    public ReferenceType getReferenceType(Long id) {
        return this.lookupSelectionListManagerBean().getReferenceType(id);
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
    
    public void setSelectedReference(RowKey rowKey){
        if (rowKey != null) {
            setReference((Reference)getReferenceDataProvider().getObject(rowKey));
        } else {
            System.out.println("rowKey es nulo.");
        }
    }

    public Option[] getLanguageOptions() {
        return languageOptions;
    }

    public void setLanguageOptions(Option[] languageOptions) {
        this.languageOptions = languageOptions;
    }

    public Option[] getReferenceTypeOptions() {
        return referenceTypeOptions;
    }

    public void setReferenceTypeOptions(Option[] referenceTypeOptions) {
        this.referenceTypeOptions = referenceTypeOptions;
    }

    public Long getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(Long selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public Long getSelectedReferenceType() {
        return selectedReferenceType;
    }

    public void setSelectedReferenceType(Long selectedReferenceType) {
        this.selectedReferenceType = selectedReferenceType;
    }
    
    public void populateList() {
        this.setLanguageOptions(this.getspecies$SpeciesSessionBean().getLanguage());
        this.setReferenceTypeOptions(this.getReferenceType());
        this.setSelectedLanguage(this.getReference().getLanguage().getLanguageId());
        this.setSelectedReferenceType(this.getReference().getReferenceType().getId());
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SpeciesSessionBean getspecies$SpeciesSessionBean() {
        return (SpeciesSessionBean)getBean("species$SpeciesSessionBean");
    }
    
    public List getReferenceElementList() {
        List tList = this.lookupReferenceBean().getReferenceElementList();
        if (tList == null) {
            this.setEjbMessage(this.lookupReferenceBean().getMessage());
        }
        return tList;
    }
    
    public String getReferenceElementValue (Long referenceElementId) {
        return this.lookupReferenceBean().getReferenceElementValue(this.reference.getId(),referenceElementId);
    }

    public Long getSelectedReferenceElement() {
        return selectedReferenceElement;
    }

    public void setSelectedReferenceElement(Long selectedReferenceElement) {
        this.selectedReferenceElement = selectedReferenceElement;
    }
    
    public boolean updateReferenceElementValue(String contents) {
        String userName = this.getSessionManager().getUser().getUserName();
        boolean updated = this.lookupReferenceBean().updateReferenceElementValue(this.reference.getId(), this.selectedReferenceElement,contents,userName,userName);
        if (updated) {
            this.getutil$MessageBean().addSuccessMessage("Registro actualizado");
            //this.getspecies$SpeciesSessionBean().addSuccessMessage("Registro actualizado");
            return true;
        } else {
            this.getutil$MessageBean().addErrorMessage(this.lookupReferenceBean().getMessage());
            //this.getspecies$SpeciesSessionBean().addErrorMessage(this.lookupReferenceBean().getMessage());
            return false;
        }
    }
    
    protected SessionManager getSessionManager() {
        return (SessionManager)getBean("SessionManager");
    }

    

    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }
    
    
    
    
    
    public SearchManagerRemote getSearchManager() {
        return lookupSearchManagerBean();
    }

    public void setSearchManager(SearchManagerRemote searchManager) {
        this.searchManager = searchManager;
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

    public boolean isFiltered() {
        return filtered;
    }

    public void setFiltered(boolean filtered) {
        this.filtered = filtered;
    }
    
    public void initDataProvider() {
        if (!filtered) {
            this.referenceDataProvider.clearObjectList();
            this.referenceDataProvider.refreshDataList();
        }
    }
}
