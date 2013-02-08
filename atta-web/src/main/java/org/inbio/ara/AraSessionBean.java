/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.FacesException;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;
import org.inbio.ara.facade.taxonomy.TaxonomyFacadeRemote;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version AraSessionBean.java
 * @version Created on 29/09/2009, 01:50:11 PM
 * @author esmata
 */

public class AraSessionBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

     @EJB
    private TaxonomyFacadeRemote taxonomyFacade;
    
    private String globalUserName = new String();
    private Long globalCollectionId = new Long(-1);
    private Long globalTaxonCollectionId = new Long(-1);
    private Long globalTaxonRangeCollection = new Long(-1);
    private Long globalNomenclaturalGroupId = new Long(-1);
    private Long globalUserNameId = new Long(-1);    
    private Locale currentLocale = new Locale("ES");
    private String globalDataBaseSchema = new String("atta");
    private String globalDataSource = new String("jdbc/_Atta");
    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public AraSessionBean() {
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
    @Override
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
            log("AraSessionBean Initialization Failure", e);
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
    @Override
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
    @Override
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
    @Override
    public void destroy() {
    }

    /**
     * @return the globalUserName
     */
    public String getGlobalUserName() {
        return globalUserName;
    }

    /**
     * @param globalUserName the globalUserName to set
     */
    public void setGlobalUserName(String globalUserName) {
        this.globalUserName = globalUserName;
    }

    /**
     * @return the globalCollectionId
     */
    public Long getGlobalCollectionId() {
        return globalCollectionId;
    }

    /**
     * @param globalCollectionId the globalCollectionId to set
     */
    public void setGlobalCollectionId(Long globalCollectionId) {
        this.globalCollectionId = globalCollectionId;
        TaxonDTO taxonCollection = taxonomyFacade.getTaxonByCollection(globalCollectionId);
        this.globalTaxonCollectionId = taxonCollection.getTaxonKey();
        this.globalTaxonRangeCollection = taxonCollection.getTaxonomicalRangeId();
    }

    /**
     * @return the globalUserNameId
     */
    public Long getGlobalUserNameId() {
        return globalUserNameId;
    }

    /**
     * @param globalUserNameId the globalUserNameId to set
     */
    public void setGlobalUserNameId(Long globalUserNameId) {
        this.globalUserNameId = globalUserNameId;
    }

    /**
     * @return the currentLocale
     */
    public Locale getCurrentLocale() {
        return currentLocale;
    }

    /**
     * @param currentLocale the currentLocale to set
     */
    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    /**
     * @return the globalNomenclaturalGroupId
     */
    public Long getGlobalNomenclaturalGroupId() {
        return globalNomenclaturalGroupId;
    }

    /**
     * @param globalNomenclaturalGroupId the globalNomenclaturalGroupId to set
     */
    public void setGlobalNomenclaturalGroupId(Long globalNomenclaturalGroupId) {
        this.globalNomenclaturalGroupId = globalNomenclaturalGroupId;
    }

    /**
     * @return the globalDataBaseSchema
     */
    public String getGlobalDataBaseSchema() {
        return globalDataBaseSchema;
    }

    /**
     * @param globalDataBaseSchema the globalDataBaseSchema to set
     */
    public void setGlobalDataBaseSchema(String globalDataBaseSchema) {
        this.globalDataBaseSchema = globalDataBaseSchema;
    }

    /**
     * @return the globalDataSource
     */
    public String getGlobalDataSource() {
        return globalDataSource;
    }

    /**
     * @param globalDataSource the globalDataSource to set
     */
    public void setGlobalDataSource(String globalDataSource) {
        this.globalDataSource = globalDataSource;
    }

    /**
     * @return the globalTaxonCollectionId
     */
    public Long getGlobalTaxonCollectionId() {
        return globalTaxonCollectionId;
    }

    /**
     * @param globalTaxonCollectionId the globalTaxonCollectionId to set
     */
    public void setGlobalTaxonCollectionId(Long globalTaxonCollectionId) {
        this.globalTaxonCollectionId = globalTaxonCollectionId;
    }

    /**
     * @return the globalTaxonRangeCollection
     */
    public Long getGlobalTaxonRangeCollection() {
        return globalTaxonRangeCollection;
    }

    /**
     * @param globalTaxonRangeCollection the globalTaxonRangeCollection to set
     */
    public void setGlobalTaxonRangeCollection(Long globalTaxonRangeCollection) {
        this.globalTaxonRangeCollection = globalTaxonRangeCollection;
    }
    
}
