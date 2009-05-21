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
 * AraApplicationBean.java
 *
 * Created on September 28, 2007, 3:10 PM
 * Copyright mvargas
 */
package org.inbio.ara.web;

import com.sun.rave.web.ui.appbase.AbstractApplicationBean;
import com.sun.webui.jsf.model.Option;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.profile.ProfileRemote;
import org.inbio.ara.facade.util.SelectionListManagerRemote;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.taxon.service.TaxonServiceRemote;
import org.inbio.ara.web.stage.StagesDataProvider;

/**
 * <p>Application scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available to all users
 *  and pages in the application.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class AraApplicationBean extends AbstractApplicationBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    @EJB
    private SelectionListManagerRemote SLMRemote;
    private ProfileRemote profileRemote;
    
    
    
    private StagesDataProvider stagesDP = new StagesDataProvider();
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    
    /**
     * <p>Construct a new application data bean instance.</p>
     */
    public AraApplicationBean() {
    }
    
    /**
     * <p>This method is called when this bean is initially added to
     * application scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * application scope.</p>
     *
     * <p>You may customize this method to initialize and cache application wide
     * data values (such as the lists of valid options for dropdown list
     * components), or to allocate resources that are required for the
     * lifetime of the application.</p>
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
            log("ApplicationBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }
    
    /**
     * <p>This method is called when this bean is removed from
     * application scope.  Typically, this occurs as a result of
     * the application being shut down by its owning container.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }
    
    /**
     * <p>Return an appropriate character encoding based on the
     * <code>Locale</code> defined for the current JavaServer Faces
     * view.  If no more suitable encoding can be found, return
     * "UTF-8" as a general purpose default.</p>
     *
     * <p>The default implementation uses the implementation from
     * our superclass, <code>AbstractApplicationBean</code>.</p>
     */
    public String getLocaleCharacterEncoding() {
        return super.getLocaleCharacterEncoding();
    }
    
    public String getTaxonKingdomName(String taxonId) {
        Taxon taxon = lookupTaxonServiceBean().findTaxonById(new Long(taxonId));
 
        // return taxon.getKingdomTaxon().getDefaultName();
        return "Plantae";
    }    
    
    private TaxonServiceRemote lookupTaxonServiceBean() {
        try {
            Context c = new InitialContext();
            return (TaxonServiceRemote) c.lookup("TaxonServiceBean");
        } catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
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

    public SelectionListManagerRemote getSLMRemote() {
        return lookupSelectionListManagerBean();
    }

    public void setSLMRemote(SelectionListManagerRemote SLMRemote) {
        this.SLMRemote = SLMRemote;
    }

    public StagesDataProvider getStagesDP() {
        return stagesDP;
    }

    private ProfileRemote lookupProfileBean() {
        try {
            Context c = new InitialContext();
            return (ProfileRemote) c.lookup("ProfileBean");
        }
        catch(NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught" ,ne);
            throw new RuntimeException(ne);
        }
    }

    public ProfileRemote getProfileRemote() {
        return this.lookupProfileBean();
    }

    public void setProfileRemote(ProfileRemote profileRemote) {
        this.profileRemote = profileRemote;
    }
    
}
