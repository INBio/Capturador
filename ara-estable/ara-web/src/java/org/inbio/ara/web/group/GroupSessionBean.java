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
 * GroupSessionBean.java
 *
 * Created on October 17, 2007, 10:32 AM
 * Copyright roaguilar
 */
package org.inbio.ara.web.group;

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
import org.inbio.ara.facade.security.GroupBeanV2Remote;
import org.inbio.ara.facade.security.OptionRemote;
import org.inbio.ara.facade.security.UserBeanV2Remote;
import org.inbio.ara.persistence.security.User;
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
public class GroupSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    public GroupDataProvider groupDataProvider = new GroupDataProvider();
    private User group;
    private String ejbMessage = "";
    private Long[] selectedOptions = new Long[]{};
    
    @EJB
    private GroupBeanV2Remote groupBean;
    
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
    public GroupSessionBean() {
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
            log("GroupSessionBean Initialization Failure", e);
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
    
    public GroupDataProvider getGroupDataProvider() {
        return groupDataProvider;
    }

    public void setGroupDataProvider(GroupDataProvider groupDataProvider) {
        this.groupDataProvider = groupDataProvider;
    }
    
    public User getUser() {
        return this.group;
    }
    
    public void setGroup(User tGroup){
        this.group = tGroup;
    }
    
    public void setGroupId(Long id) {
        System.out.println("Id a buscar: " + id);
        setSelectedGroup(groupDataProvider.findFirst(groupDataProvider.getFieldKey("id"),id));
    }

    public void setSelectedGroup(RowKey rowKey) {
        if (rowKey != null) {
            setGroup((User)groupDataProvider.getObject(rowKey));
        } else {
            System.out.println("rowKey es nulo.");
        }
    }
    
    public boolean createGroup(User tUser) {
        boolean created = false;
        
        groupBean = this.lookupGroupBean();
        if (groupBean.create(tUser,this.getSelectedOptions())) {
            setGroup(tUser);
            groupDataProvider.refreshDataList();
            created = true;
            this.getutil$MessageBean().addSuccessMessage("Registro creado con éxito!");
        } else {
            this.setEjbMessage(groupBean.getMessage());
            this.getutil$MessageBean().addErrorMessage(this.ejbMessage);
        }
        return created;
    }
    
    public void updateGroup(User tGroup, Long[] selectionArray) {
        //this.lookupUserBean().deleteAllPrivilegies(tGroup.getId());        
        groupBean = this.lookupGroupBean();
        groupBean.deleteAllPrivilegies(tGroup.getId());
        if (groupBean.update(tGroup, selectionArray)) {
            setGroup(tGroup);
            groupDataProvider.refreshDataList();
            this.getutil$MessageBean().addSuccessMessage("Registro modificado con éxito");
        } else {
            this.getutil$MessageBean().addErrorMessage(groupBean.getMessage());
        }              
    }
    
    public void deleteGroup() {
        groupBean = this.lookupGroupBean();
        if (groupBean.remove(this.group.getId())) {
            groupDataProvider.refreshDataList();
        }
        System.out.println("Respuesta del EJB: " + groupBean.getMessage());
    }
    
    /*
    public boolean changePassword(String oldPassword, String newPassword) {
        groupBean = this.lookupgroupBean();
        if (groupBean.changeUserPassword(this.group.getId(),oldPassword,newPassword)) {
            return true;
        } else {
            this.setEjbMessage(groupBean.getMessage());
            return false;
        }
    }*/
    
    /*
    public boolean disableUser(RowKey rowKey) {
        groupBean = this.lookupgroupBean();
        this.setSelectedUser(rowKey);
        this.group.setEnabled(0L);
        if (groupBean.update(this.getUser(), new Long[]{})) {
            return true;
        } else {
            this.setEjbMessage(groupBean.getMessage());
            return false;
        }
    }*/
    
    public List getGroupPrivilegies(Long groupId) {
        return this.lookupGroupBean().getGroupOptions(groupId);
    }
    
    public List getAllOptions() {
        return this.lookupOptionBean().findAll();
    }
    
    public List getAllGroups() {
        return this.lookupGroupBean().findAll();
    }
    
    public List getSelectedGroupOptions() {
        return this.lookupGroupBean().getGroupOptions(this.group.getId());
    }
    
    private GroupBeanV2Remote lookupGroupBean() {
        try {
            Context c = new InitialContext();
            return (GroupBeanV2Remote) c.lookup("GroupBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    private OptionRemote lookupOptionBean() {
        try {
            Context c = new InitialContext();
            return (OptionRemote) c.lookup("OptionBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public boolean delete() {
        boolean deleted = false;
        groupBean = this.lookupGroupBean();
        if (groupBean.remove(this.getUser().getId())) {
            groupDataProvider.refreshDataList();
            deleted = true;
            this.getutil$MessageBean().addSuccessMessage("Registro borrado con éxito");
        } else {
            this.setEjbMessage(groupBean.getMessage());
            this.getutil$MessageBean().addErrorMessage(this.ejbMessage);
        }
        return deleted;
    }
    
    public String getEjbMessage() {
        return ejbMessage;
    }

    public void setEjbMessage(String ejbMessage) {
        this.ejbMessage = ejbMessage;
    }

    public Long[] getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(Long[] selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    private UserBeanV2Remote lookupUserBean() {
        try {
            Context c = new InitialContext();
            return (UserBeanV2Remote) c.lookup("UserBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
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
