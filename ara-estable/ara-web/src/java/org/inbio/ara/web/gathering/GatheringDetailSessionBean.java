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
 * GatheringDetailSessionBean.java
 *
 * Created on June 8, 2008, 9:17 PM
 * Copyright roaguilar
 */
package org.inbio.ara.web.gathering;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.gathering.GatheringDetailRemote;
import org.inbio.ara.facade.gathering.MorphologicalDescriptionRemote;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
import org.inbio.ara.persistence.gathering.MorphologicalDescription;
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
public class GatheringDetailSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private Option[] collectors;
    private Long selectedCollector;
    private Option[] descriptors;
    private Long selectedDescriptor;
    private MorphologicalDescription morpho;
    private GatheringObservationDetail detail;
    
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
    public GatheringDetailSessionBean() {
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
            log("GatheringDetailSessionBean Initialization Failure", e);
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1)getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected MessageBean getutil$MessageBean() {
        return (MessageBean)getBean("util$MessageBean");
    }

    public Long getSelectedCollector() {
        return selectedCollector;
    }

    public void setSelectedCollector(Long selectedCollector) {
        this.selectedCollector = selectedCollector;
    }

    public Option[] getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(Option[] descriptors) {
        this.descriptors = descriptors;
    }

    public Long getSelectedDescriptor() {
        return selectedDescriptor;
    }

    public void setSelectedDescriptor(Long selectedDescriptor) {
        this.selectedDescriptor = selectedDescriptor;
    }

    private GatheringDetailRemote lookupGatheringDetailBean() {
        try {
            Context c = new InitialContext();
            return (GatheringDetailRemote) c.lookup("GatheringDetailBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    private MorphologicalDescriptionRemote lookupMorphologicalDescriptionBean() {
        try {
            Context c = new InitialContext();
            return (MorphologicalDescriptionRemote) c.lookup("MorphologicalDescriptionBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }
    
    public boolean createGatheringObservationDetail(GatheringObservationDetail detail) {
        if (detail != null) {
            if (getMorpho()!= null) {
                detail.setMorphologicalDescription(getMorpho());
            }
            if (this.lookupGatheringDetailBean().create(detail)) {
                this.detail = lookupGatheringDetailBean().getGatheringDetail();
                this.getutil$MessageBean().addSuccessMessage("Detalle de recolección creado con éxito.");
                return true;
            } else {
                this.lookupMorphologicalDescriptionBean().delete(this.morpho.getId());
                this.getutil$MessageBean().addErrorMessage(lookupGatheringDetailBean().getMessage());
                return false;
            }
        } else {
            this.lookupMorphologicalDescriptionBean().delete(this.morpho.getId());
            this.getutil$MessageBean().addErrorMessage("GatheringDetailSessionBean: la entidad 'detail' es nula");
            return false;
        }
    }

    public boolean updateGatheringObservationDetail() {
        if (detail != null) {
            if (getMorpho()!= null) {
                detail.setMorphologicalDescription(getMorpho());
            }
            if (this.lookupGatheringDetailBean().update(detail)) {
                this.detail = lookupGatheringDetailBean().getGatheringDetail();
                this.getgathering$GatheringSessionBeanV2().getGatherinDetailDataProvider().refreshDataList();
                this.getutil$MessageBean().addSuccessMessage("Detalle de recolección modificado con éxito.");
                return true;
            } else {
                this.getutil$MessageBean().addErrorMessage(lookupGatheringDetailBean().getMessage());
                return false;
            }
        } else {
            this.getutil$MessageBean().addErrorMessage("GatheringDetailSessionBean: la entidad 'detail' es nula");
            return false;
        }
    }
    
    public boolean createMorphologicalDescription(MorphologicalDescription morpho) {
        if (this.lookupMorphologicalDescriptionBean().create(morpho)) {
            this.setMorpho(this.lookupMorphologicalDescriptionBean().getMorphologicalDescription());
            this.getgathering$GatheringSessionBeanV2().getGatherinDetailDataProvider().refreshDataList();
            //this.getutil$MessageBean().addSuccessMessage("Descripción morfológica creada con éxito.");
            return true;
        } else{
            this.getutil$MessageBean().addErrorMessage(this.lookupMorphologicalDescriptionBean().getMessage());
            return false;
        }
    }

    public boolean updateMorphologicalDescription() {
        if (morpho != null) {
            if (this.lookupMorphologicalDescriptionBean().update(morpho)) {
                this.getutil$MessageBean().addSuccessMessage("Descripción morfológica modificada con éxito.");
                return true;
            } else {
                this.getutil$MessageBean().addErrorMessage(lookupGatheringDetailBean().getMessage());
                return false;
            }
        } else {
            this.getutil$MessageBean().addErrorMessage("GatheringDetailSessionBean: la entidad 'morpho' es nula");
            return false;
        }
    }
    
    public void delete() {
        if (detail != null) {
            if (this.lookupGatheringDetailBean().delete(this.detail.getId())) {
                this.getutil$MessageBean().addSuccessMessage("El detalle de recolección fué borrado con éxito.");
                if (this.detail.getMorphologicalDescription() != null) {
                    if (this.lookupMorphologicalDescriptionBean().delete(this.detail.getMorphologicalDescription().getId())) {
                        this.getutil$MessageBean().addSuccessMessage("La descripción morfológica fué borrada con éxito.");
                    } else {
                        this.getutil$MessageBean().addErrorMessage(this.lookupMorphologicalDescriptionBean().getMessage());
                    }
                }
                this.morpho = null;
                this.detail = null;
            } else {
                this.getutil$MessageBean().addErrorMessage(this.lookupGatheringDetailBean().getMessage());
            }
        } else {
            this.getutil$MessageBean().addErrorMessage("GatheringDetailSessionBean: la entidad 'detail' es nula, no es posible borrar");
        }
    }
    
    public MorphologicalDescription getMorpho() {
        return morpho;
    }

    public void setMorpho(MorphologicalDescription morpho) {
        this.morpho = morpho;
    }

    public GatheringObservationDetail getDetail() {
        return detail;
    }

    public void setDetail(GatheringObservationDetail detail) {
        this.detail = detail;
        if (detail.getMorphologicalDescription() != null) {
            //this.morpho = this.lookupMorphologicalDescriptionBean().getMorphologicalDescription(detail.getMorphologicalDescription().getId());
            this.morpho = this.detail.getMorphologicalDescription();
        } else {
            this.morpho = null;
        }
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected GatheringSessionBeanV2 getgathering$GatheringSessionBeanV2() {
        return (GatheringSessionBeanV2)getBean("gathering$GatheringSessionBeanV2");
    }

    public Option[] getCollectors() {
        return collectors;
    }

    public void setCollectors(Option[] collectors) {
        this.collectors = collectors;
    }

}
