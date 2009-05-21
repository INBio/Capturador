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
 * SessionManager.java
 *
 * Created on October 2, 2007, 2:41 AM
 * Copyright roaguilar
 */
package org.inbio.ara.web;

import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import org.inbio.ara.facade.collection.CollectionRemote;
import org.inbio.ara.facade.security.UserBeanV2Remote;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.collection.CollectionProtocol;
import org.inbio.ara.persistence.security.SimpleModule;
import org.inbio.ara.persistence.security.SimpleSubsystem;
import org.inbio.ara.persistence.security.User;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.Taxon;
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
public class SessionManager extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private User user;
    private String ejbMessage;
    private List collectionProtocolAttribute;
    private Collection collection;
    private Taxon currentTaxon;
    private NomenclaturalGroup currentNomenclaturalGroup;
    private SubsystemDataProvider subSystemDataProvider;
    private ModuleDataProvider moduleDataProvider;
    private Long currentModuleId;
	private Locale locale;
    
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
    public SessionManager() {
		locale = new Locale("ES");
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
            log("SessionManager Initialization Failure", e);
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

    public boolean doLogin(String userName, String password) {
        //userBean = this.lookupUserBean();
        this.user = this.lookupUserBean().getUser(userName, password);
        if (this.user != null) {
            if (this.user.getEnabled() == 0) {
                this.ejbMessage = "Su usuario ha sido bloqueado.";
                return false;
            }
            if(this.user.getUserType().getId() == 1L) {
                this.ejbMessage = "No puede ingresar al sistema como un grupo";
                return false;
            }
            return true;
        } else {
            this.ejbMessage = this.lookupUserBean().getMessage();
            return false;
        }
    }
    
    public void doLogoff() {
        /*
        this.user = null;
        this.userBean = null;
        this.ejbMessage = "";
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.release();
         */
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
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

    public User getUser() {
        return user;
    }

    public String getEjbMessage() {
        return ejbMessage;
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }

    public List getCollectionProtocolAttribute() {
        return collectionProtocolAttribute;
    }

    public void setCollectionProtocolAttribute(List collectionProtocolAttribute) {
        this.collectionProtocolAttribute = collectionProtocolAttribute;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
        this.setCollectionProtocolAttribute(this.lookupCollectionBean().getCollectionProtocols(this.collection.getId()));
        this.subSystemDataProvider = new SubsystemDataProvider(this.getUser().getUserGroup().getId());
    }
    
    public boolean useGatheringDetail() {
        CollectionProtocol collectionProtocol = this.getCollectionProtocol(1L);
        if (collectionProtocol != null) {
           /*return Boolean.getBoolean(collectionProtocol.getValue());-*/
            if (collectionProtocol.getValue().equals("true")) {
                return true;
            } else {
                return false;
            }
        } else {
           return false;
        }
    }
    
    public boolean useSpecimenObservation() {
        CollectionProtocol collectionProtocol = this.getCollectionProtocol(9L);
        if (collectionProtocol != null) {
            //if (collectionProtocol.getValue().equals("true")) {
            if (collectionProtocol.getValue().equals("true")) {
                return true;
            } else {
                return false;
            }
        } else {
           return false;
        }
    }
    
    public Long getDefaultProjection() {
        CollectionProtocol collectionProtocol = this.getCollectionProtocol(2L);
        if (collectionProtocol != null) {
           return Long.parseLong(collectionProtocol.getValue());
        } else {
           return -1L;
        }
    }
    
    public Long getDefaultGatheringMethod() {
        CollectionProtocol collectionProtocol = this.getCollectionProtocol(3L);
        if (collectionProtocol != null) {
           return Long.parseLong(collectionProtocol.getValue());
        } else {
           return -1L;
        }
    }
    
    public boolean canIdentifyWithSynonyms() {
        CollectionProtocol collectionProtocol = this.getCollectionProtocol(4L);
        if (collectionProtocol != null) {
            if (collectionProtocol.getValue().equals("true")) {
                return true;
            } else {
                return false;
            } 
        } else {
           return false;
        }
    }
    
    public boolean useLifeForms() {
        CollectionProtocol collectionProtocol = this.getCollectionProtocol(5L);
        if (collectionProtocol != null) {
            if (collectionProtocol.getValue().equals("true")) {
                return true;
            } else {
                return false;
            }            
        } else {
           return false;
        }
    }
    
    public String morphologicalDescriptionModuleName() {
        CollectionProtocol collectionProtocol = this.getCollectionProtocol(6L);
        if (collectionProtocol != null) {
           return (String)collectionProtocol.getValue();
        } else {
           return null;
        }
    }
    
    public boolean reIdentifyOnTaxonRename() {
        CollectionProtocol collectionProtocol = this.getCollectionProtocol(10L);
        if (collectionProtocol != null) {
           //return Boolean.getBoolean(collectionProtocol.getValue());
            if (collectionProtocol.getValue().equals("true")) {
                return true;
            } else {
                return false;
            }
        } else {
           return false;
        }
    }
    
    public boolean useCultures() {
        CollectionProtocol collectionProtocol = this.getCollectionProtocol(7L);
        if (collectionProtocol != null) {
           //return Boolean.getBoolean(collectionProtocol.getValue());
            if (collectionProtocol.getValue().equals("true")) {
                return true;
            } else {
                return false;
            }
        } else {
           return false;
        }
    }
    
    public boolean sharesGatheringDetailNumber() {
        CollectionProtocol collectionProtocol = this.getCollectionProtocol(8L);
        if (collectionProtocol != null) {
           //return Boolean.getBoolean(collectionProtocol.getValue());
            if (collectionProtocol.getValue().equals("true")) {
                return true;
            } else {
                return false;
            }
        } else {
           return false;
        }
    }

    private CollectionRemote lookupCollectionBean() {
        try {
            Context c = new InitialContext();
            return (CollectionRemote) c.lookup("CollectionBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    private CollectionProtocol getCollectionProtocol(Long protocolAttributeId) {
        List<CollectionProtocol> tList = this.getCollectionProtocolAttribute();
        CollectionProtocol rObject = null;
        for (CollectionProtocol tObject: tList) {
            Long tId = tObject.getCollectionProtocolPK().getProtocolAttributeId();
            if (tId.compareTo(protocolAttributeId)== 0) {
                return tObject;
            }
        }
        return rObject;
    }

    public Taxon getCurrentTaxon() {
        return currentTaxon;
    }

    public void setCurrentTaxon(Taxon currentTaxon) {
        this.currentTaxon = currentTaxon;
    }

    public NomenclaturalGroup getCurrentNomenclaturalGroup() {
        return currentNomenclaturalGroup;
    }

    public void setCurrentNomenclaturalGroup(NomenclaturalGroup currentNomenclaturalGroup) {
        this.currentNomenclaturalGroup = currentNomenclaturalGroup;
    }
    
    public SubsystemDataProvider getSubSystemDataProvider() {
        return subSystemDataProvider;
    }

    public void setSubSystemDataProvider(SubsystemDataProvider subSystemDataProvider) {
        this.subSystemDataProvider = subSystemDataProvider;
    }

    public ModuleDataProvider getModuleDataProvider() {
        return moduleDataProvider;
    }

    public void setModuleDataProvider(ModuleDataProvider moduleDataProvider) {
        this.moduleDataProvider = moduleDataProvider;
    }
    
    public void setCurrentSubsystem(RowKey rowKey) {
        if (rowKey != null) {
            SimpleSubsystem tmp = (SimpleSubsystem)this.subSystemDataProvider.getObject(rowKey);
            Long groupId = this.user.getUserGroup().getId();
            Long subsystemId = tmp.getId();
            this.setModuleDataProvider(new ModuleDataProvider(groupId, subsystemId));
        } else {
            System.out.println("rowKey es nulo.");
        }
    }
    
    public String getSelectedModuleNavigationRule(RowKey rowKey) {
        if (rowKey != null) {
            SimpleModule tmp = (SimpleModule)this.moduleDataProvider.getObject(rowKey);
            this.setCurrentModuleId(tmp.getId());
            String navigationRule = tmp.getNavigationRule();
            System.out.println(navigationRule);
            return navigationRule;
        } else {
            System.out.println("rowKey es nulo.");
            return null;
        }
    }

    public Long getCurrentModuleId() {
        return currentModuleId;
    }

    public void setCurrentModuleId(Long currentModuleId) {
        this.currentModuleId = currentModuleId;
    }
    
    public String canAdd() {
        return this.lookupUserBean().canAdd(this.user.getId(), this.currentModuleId);
    }
    
    public String canModify() {
        return this.lookupUserBean().canModify(this.user.getId(), this.currentModuleId);
    }
    
    public String canDelete() {
        return this.lookupUserBean().canDelete(this.user.getId(), this.currentModuleId);
    }

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	
}
