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
 * InstitutionSessionBean.java
 *
 * Created on October 9, 2007, 9:39 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.admin.institution;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.institution.InstitutionRemote;
import org.inbio.ara.facade.util.SearchManagerRemote;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
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
 */
public class InstitutionSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private InstitutionDataProvider institutionDataProvider = new InstitutionDataProvider();
    private String ejbMessage;
    private Institution institution;
    private boolean isFiltered = false;
    
    @EJB
    InstitutionRemote institutionBean;
    private SearchManagerRemote searchManager;
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
    public InstitutionSessionBean() {
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
            log("InstitutionSessionBean Initialization Failure", e);
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
    
    public boolean create(Institution institution) {
        boolean created = false;
        
        institutionBean = this.lookupInstitutionBean();
        if (institutionBean.create(institution)) {
            //setUser(tUser);
            getInstitutionDataProvider().refreshDataList();
            created = true;
            this.getutil$MessageBean().addSuccessMessage("Registro creado con éxito");
        } else {
            this.setEjbMessage(institutionBean.getMessage());
            this.getutil$MessageBean().addErrorMessage(institutionBean.getMessage());
        }
        return created;
    }    
    
    public boolean update(Institution institution) {
        boolean updated = false;
        
        institutionBean = this.lookupInstitutionBean();
        if (institutionBean.update(institution)) {
            setInstitution(institution);
            getInstitutionDataProvider().refreshDataList();
            updated = true;
            this.getutil$MessageBean().addSuccessMessage("Registro modificado con éxito");
        } else {
            this.setEjbMessage(institutionBean.getMessage());
            this.getutil$MessageBean().addErrorMessage(institutionBean.getMessage());
        }
        return updated;
    }
    
    public boolean delete() {
        boolean deleted = false;
        institutionBean = this.lookupInstitutionBean();
        if (institutionBean.remove(this.getInstitution().getId())) {
            getInstitutionDataProvider().refreshDataList();
            deleted = true;
            this.getutil$MessageBean().addSuccessMessage("El registro fué borrado con éxito.");
        } else {
            this.setEjbMessage(institutionBean.getMessage());
            this.getutil$MessageBean().addErrorMessage(institutionBean.getMessage());
        }
        return deleted;
    }
    
    public void setSelectedInstitution(RowKey rowKey){
        if (rowKey != null) {
            setInstitution((Institution)getInstitutionDataProvider().getObject(rowKey));
        } else {
            System.out.println("rowKey es nulo.");
        }
    }
    
    public List getAllInstitutions() {
        institutionBean = this.lookupInstitutionBean();
        return institutionBean.findAll();
    }

    private InstitutionRemote lookupInstitutionBean() {
        try {
            Context c = new InitialContext();
            return (InstitutionRemote) c.lookup("InstitutionBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public InstitutionDataProvider getInstitutionDataProvider() {
        return institutionDataProvider;
    }

    public void setInstitutionDataProvider(InstitutionDataProvider institutionDataProvider) {
        this.institutionDataProvider = institutionDataProvider;
    }

    public String getEjbMessage() {
        return ejbMessage;
    }

    public void setEjbMessage(String ejbMessage) {
        this.ejbMessage = ejbMessage;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
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

    public boolean isIsFiltered() {
        return isFiltered;
    }

    public void setIsFiltered(boolean isFiltered) {
        this.isFiltered = isFiltered;
    }
    
    public void initDataProvider() {
        if (!isFiltered) {
            this.getInstitutionDataProvider().clearObjectList();
            this.getInstitutionDataProvider().refreshDataList();
        }
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected org.inbio.ara.web.ApplicationBean1 getApplicationBean1() {
        return (org.inbio.ara.web.ApplicationBean1)getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }
}
