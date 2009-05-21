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
 * PersonSessionBean.java
 *
 * Created on September 30, 2007, 1:42 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.admin.person;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.person.PersonRemote;
import org.inbio.ara.facade.util.SearchManagerRemote;
import org.inbio.ara.facade.util.SelectionListManagerRemote;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.person.Profile;
import org.inbio.ara.web.ApplicationBean1;
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
public class PersonSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    public PersonDataProvider personDataProvider = new PersonDataProvider();
    private String ejbMessage;
    private Person person;

    private Option[] institutionList;
    private Option[] profileList;
    private Long[] selectedProfiles = new Long[]{};
    private Long[] selectedInstitutions = new Long[]{};
    private boolean isFiltered = false;
    
    @EJB
    private PersonRemote personBean;
    private SearchManagerRemote searchManager;
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
    public PersonSessionBean() {
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
            log("PersonSessionBean Initialization Failure", e);
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
    
    private PersonRemote lookupPersonBean() {
        try {
            Context c = new InitialContext();
            return (PersonRemote) c.lookup("PersonBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public boolean create(Person person) {
        boolean created = false;
        
        personBean = this.lookupPersonBean();
        if (personBean.create(person, this.getSelectedProfiles(), this.getSelectedInstitutions())) {
            //setUser(tUser);
            getPersonDataProvider().refreshDataList();
            created = true;
        } else {
            this.setEjbMessage(personBean.getMessage());
        }
        return created;
    }
    
    public boolean create(Person person, Long[] profileArray, Long[] institutionArray) {
        boolean created = false;
        
        personBean = this.lookupPersonBean();
        if (personBean.create(person, profileArray, institutionArray)) {
            //setUser(tUser);
            getPersonDataProvider().refreshDataList();
            created = true;
        } else {
            this.setEjbMessage(personBean.getMessage());
        }
        return created;        
    }
    
    public boolean update(Person person) {
        boolean updated = false;
        
        personBean = this.lookupPersonBean();
        if (personBean.update(person)) {
            setPerson(personBean.getPerson());
            getPersonDataProvider().refreshDataList();
            updated = true;
        } else {
            this.setEjbMessage(personBean.getMessage());
        }
        return updated;
    }
    
    public boolean update(Person person, Long[] profileArray, Long[] institutionArray) {
        boolean updated = false;
        
        personBean = this.lookupPersonBean();
        //userBean.deleteAllPrivilegies(tUser.getId());
        personBean.deleteInstitutions(person.getId());
        personBean.deleteProfiles(person.getId());
        if (personBean.update(person,profileArray,institutionArray)) {
            setPerson(personBean.getPerson());
            getPersonDataProvider().refreshDataList();
            updated = true;
            cleanLists();
            this.setEjbMessage(personBean.getMessage());
        } else {
            this.setEjbMessage(personBean.getMessage());
        }

        return updated;        
    }
    
    public void cleanLists() {
        selectedProfiles = new Long[]{};
        selectedInstitutions = new Long[]{};
    }
    
    public boolean delete() {
        boolean deleted = false;
        personBean = this.lookupPersonBean();

		personBean.deleteProfiles(this.person.getId());
		personBean.deleteInstitutions(this.person.getId());
		
        if (personBean.remove(this.getPerson().getId())) {
            getPersonDataProvider().refreshDataList();
            deleted = true;
        } else {
            this.setEjbMessage(personBean.getMessage());
            System.out.println(getEjbMessage());
        }
        return deleted;
    }

    public String getEjbMessage() {
        return ejbMessage;
    }

    public void setEjbMessage(String ejbMessage) {
        this.ejbMessage = ejbMessage;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void setSelectedPerson(RowKey rowKey){
        if (rowKey != null) {
            setPerson((Person)getPersonDataProvider().getObject(rowKey));
        } else {
            System.out.println("rowKey es nulo.");
        }
    }

    public List getSelectedPersonProfiles() {
        List tList;
        tList = this.lookupPersonBean().getSelectedProfiles(this.person.getId()); 
        if (tList == null) {
            this.setEjbMessage(lookupPersonBean().getMessage());
        }
        return tList;
    }
    
    public List getSelectedPersonInstitutions() {
        List tList;
        tList = this.lookupPersonBean().getSelectedInstitutions(this.person.getId()); 
        if (tList == null) {
            this.setEjbMessage(lookupPersonBean().getMessage());
        }
        return tList;        
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
    }

    public Long[] getSelectedProfiles() {
        return selectedProfiles;
    }

    public void setSelectedProfiles(Long[] selectedProfiles) {
        this.selectedProfiles = selectedProfiles;
    }

    public Long[] getSelectedInstitutions() {
        return selectedInstitutions;
    }

    public void setSelectedInstitutions(Long[] selectedInstitutions) {
        this.selectedInstitutions = selectedInstitutions;
    }
    
    public void populateLists() {
        //this.profileList = this.lookupSelectionListManagerBean().getProfile();
        //this.institutionList = this.lookupSelectionListManagerBean().getInstitution();
        this.selectedProfiles = this.lookupSelectionListManagerBean().getPersonProfile(this.person.getId());
        this.selectedInstitutions = this.lookupSelectionListManagerBean().getPersonInstitution(this.person.getId());
    }
    
    private void populateCurrentSelectedInstitutionList() {
        int i;
        List<Institution> tList;
        tList = this.getSelectedPersonInstitutions();
        if (tList != null) {
            if (tList.size() > 0) {
                this.setSelectedInstitutions(new Long[tList.size()]);
                i = 0;
                for (Institution tInstitution: tList) {
                    this.selectedInstitutions[i] = tInstitution.getId();
                    i++;
                }
            }            
        }
    }
    
    private void populateCurrentSelectedProfileList() {
        int i;
        List<Profile> tList;
        tList = this.getSelectedPersonProfiles();
        if (tList != null) {
            if (tList.size() > 0) {
                this.setSelectedProfiles(new Long[tList.size()]);
                i = 0;
                for (Profile tProfile: tList) {
                    this.selectedProfiles[i] = tProfile.getId();
                    i++;
                }
            }            
        }        
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

    public void setSearchManager(SearchManagerRemote searchManager) {
        this.searchManager = searchManager;
    }

    public boolean isIsFiltered() {
        return isFiltered;
    }

    public void setIsFiltered(boolean isFiltered) {
        this.isFiltered = isFiltered;
    }
    
    public void initDataProvider() {
        if (!isFiltered) {
            this.getPersonDataProvider().clearObjectList();
            this.getPersonDataProvider().refreshDataList();
        }
    }

    public PersonDataProvider getPersonDataProvider() {
        return personDataProvider;
    }

    public void setPersonDataProvider(PersonDataProvider personDataProvider) {
        this.personDataProvider = personDataProvider;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
    }

    public Option[] getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(Option[] institutionList) {
        this.institutionList = institutionList;
    }

    public Option[] getProfileList() {
        return profileList;
    }

    public void setProfileList(Option[] profileList) {
        this.profileList = profileList;
    }

    private SelectionListManagerRemote lookupSelectionListManagerBean() {
        try {
            Context c = new InitialContext();
            return (SelectionListManagerRemote) c.lookup("SelectionListManagerBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }
}
