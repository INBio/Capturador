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
 * SelectionListBean.java
 *
 * Created on April 29, 2008, 10:39 AM
 * Copyright roaguilar
 */
package org.inbio.ara.web.util;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.inbio.ara.facade.util.SelectionListManagerRemote;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.Exposition;
import org.inbio.ara.persistence.gathering.GatheringObservationMethod;
import org.inbio.ara.persistence.gis.FeatureType;
import org.inbio.ara.persistence.gis.Projection;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.gis.SiteCalculationMethod;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.selectionListEntity;
import org.inbio.ara.persistence.specimen.ExtractionType;
import org.inbio.ara.persistence.specimen.IdentificationStatus;
import org.inbio.ara.persistence.specimen.IdentificationType;
import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Sex;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.web.ApplicationBean1;
import org.inbio.ara.web.AraApplicationBean;

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
public class SelectionListBean extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
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
    public SelectionListBean() {
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
            log("SelectionListBean Initialization Failure", e);
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
    protected AraApplicationBean getAraApplicationBean() {
        return (AraApplicationBean)getBean("AraApplicationBean");
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
    protected org.inbio.ara.web.SessionManager getSessionManager() {
        return (org.inbio.ara.web.SessionManager)getBean("SessionManager");
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
    
    public Collection getCollectionByTaxon(Long taxonId) {
        return this.lookupSelectionListManagerBean().getCollectionByTaxonId(taxonId);
    }
    
    public Collection getCollectionByNomenclaturalGroup(Long groupId) {
        return this.lookupSelectionListManagerBean().getCollectionByNomenclaturalGroupId(groupId);
    }
    
    public Site getSite(Long id) {
        return this.lookupSelectionListManagerBean().getSite(id);
    }
    
    public Person getPerson(Long id) {
        return this.lookupSelectionListManagerBean().getPerson(id);
    }
    
    public GatheringObservationMethod getGatheringObservationMethod(Long id) {
        return this.lookupSelectionListManagerBean().getGatheringObservationMethodbyId(id);
    }
    
    public Exposition getExpositionById(Long id) {
        return this.lookupSelectionListManagerBean().getExpositionById(id);
    }
    
    public NomenclaturalGroup getNomenclaturalGroupById(Long id) {
        return this.lookupSelectionListManagerBean().getNomenclaturalGroupById(id);
    }
    /**
     * En esta secci�n se definen los m�todos que devuelven un arreglo de Option para construir las listas de selecci�n
     */
    
    public Option[] getTaxons() {
        return this.lookupSelectionListManagerBean().getTaxons();
    }
    
    public Option[] getTaxonByCollection(Long collectionId) {
        return this.lookupSelectionListManagerBean().getTaxonsByCollection(collectionId);
    }
    
    public Option[] getNomenclaturalGroups() {
        return this.lookupSelectionListManagerBean().getNomenclaturalGroups();
    }
    
    public Long[] getSelectedUserTaxon(Long userId) {
        return this.lookupSelectionListManagerBean().getSelectedUserTaxon(userId);
        //return new Long[0];
    }
    
    public Long[] getSelectedUserNomenclaturalGroup(Long userId) {
        return this.lookupSelectionListManagerBean().getSelectedUserNomenclaturalGroup(userId);
        //return new Long[0];
    }
    
    public Long[] getCollectorsByGatheringId(Long gatheringId) {
        return this.lookupSelectionListManagerBean().getSelectedCollectors(gatheringId);
    }
    
    public Long[] getCollectionsByGatheringId(Long gatheringId) {
        return this.lookupSelectionListManagerBean().getSelectedCollections(gatheringId);
    }

    public Long[] getProjectByGatheringId(Long gatheringId) {
        return this.lookupSelectionListManagerBean().getSelectedProjects(gatheringId);
    }
    
    public Option[] getSite() {
        return this.lookupSelectionListManagerBean().getSites();
    }
    
    public Option[] getGatheringResponsible() {
        return this.lookupSelectionListManagerBean().getGatheringResponsible();
    }
    
    public Option[] getCollector() {
        return this.lookupSelectionListManagerBean().getCollectors();
    }
    
    public Option[] getNomenclaturalGroupCertificator() {
        return this.lookupSelectionListManagerBean().getNomenclaturalGroupCertificator();
    }
    
    public Option[] getExposition() {
        return this.lookupSelectionListManagerBean().getExposition();
    }
    
    public Option[] getProject() {
        return this.lookupSelectionListManagerBean().getProjects();
    }
    
    public Option[] getCollection() {
        return this.lookupSelectionListManagerBean().getCollections();
    }
    
    public Option[] getRegion() {
        return this.lookupSelectionListManagerBean().getRegion();
    }
    
    public Collection getCollectionById(Long id) {
        return this.lookupSelectionListManagerBean().getCollection(id);
    }
    
    /**
     * hesquivel
     * Este metodo sustituye los otros 19 que habian aqui.
     * Ej. de uso: getOptions(SpecimenType.class)
     * Trae todos SpecimenTypes que aplican para la coleccion que se esta 
     * trabajando actualmente. El id de la coleccion lo trae a traves del 
     * SessionManaver
     *
     * @param clazz Clase (java.lang.Class) de objetos de los cuales se desea
     *        obtener las opciones disponibles.
     * @return com.sun.webui.jsf.model.Option[] Opciones que se le pasan a los 
     *         componentes graficos de JSF para que los muestre (comunmente
     *         DropDowns).
     */
    public <T extends selectionListEntity> Option[] getOptions(Class<T> clazz, Locale locale) {
        Long collectionId = this.getSessionManager().getCollection().getId();
        Option[] listOptions = this.lookupSelectionListManagerBean().
                                    getOptionsByCollection(clazz, collectionId);
        for (int i = 0; i < listOptions.length; i++) {
            System.out.println(listOptions[i].getLabel());
            try{
                String msg = ResourceBundle.getBundle("org/inbio/ara/web/util/resources", locale).
                        getString(listOptions[i].getLabel());
                listOptions[i].setLabel(msg);
            } catch(java.util.MissingResourceException e){
                System.out.println("Missing resource");
            }
        }
        return listOptions;
    }
    
    public Option[] getGatheringObservationMethod() {
        return this.lookupSelectionListManagerBean().getGatheringObservationMethod(this.getSessionManager().getCollection().getId());
    }
    
    public Option[] getAllGatheringObservationMethod() {
        return this.lookupSelectionListManagerBean().getAllGatheringObservationMethod();
    }
    
    public Option[] getCollectorsByGatheringObservation(Long gatheringId) {
        return this.lookupSelectionListManagerBean().getCollectorsByGatheringObservation(gatheringId);
    }
    
    public Option[] getDescriptors() {
        return this.lookupSelectionListManagerBean().getDescriptors();
    }

    private Long getCurrentCollectionId() {
        return this.getSessionManager().getCollection().getId();
    }
    
    public Option[] getSpecimenCategory() {
        return this.lookupSelectionListManagerBean().getSpecimenCategory(this.getCurrentCollectionId());
    }
    
    public Option[] getSpecimenType() {
        return this.lookupSelectionListManagerBean().getSpecimenType(this.getCurrentCollectionId());
    }
    
    public Option[] getOrigin() {
        return this.lookupSelectionListManagerBean().getOrigin(this.getCurrentCollectionId());
    }
    
    public Option[] getPreservationMedium() {
        return this.lookupSelectionListManagerBean().getPreservationMedium(this.getCurrentCollectionId());
    }
    
    public Option[] getStorageType() {
        return this.lookupSelectionListManagerBean().getStorageType(this.getCurrentCollectionId());
    }
    
    public Option[] getSubstrate() {
        return this.lookupSelectionListManagerBean().getSubstrate(this.getCurrentCollectionId());
    }
    
    public Option[] getLifeForm() {
        return this.lookupSelectionListManagerBean().getLifeForm(this.getCurrentCollectionId());
    }
    
    public Option[] getLifeStage() {
        return this.lookupSelectionListManagerBean().getLifeStage(this.getCurrentCollectionId());
    }
    
    public Option[] getSex() {
        return this.lookupSelectionListManagerBean().getSex(this.getCurrentCollectionId());
    }
    
    public Option[] getTaxonomicalRange() {
        return this.lookupSelectionListManagerBean().getTaxonomicalRange();
    }
    
    public Option[] getTypeSpecimenType() {
        return this.lookupSelectionListManagerBean().getTypeSpecimenType();
    }
    
    public Option[] getTaxonCategory() {
        return this.lookupSelectionListManagerBean().getTaxonCategory();
    }
    
    
    public Option[] getFilteredTaxonList(Long taxonomicalRangeId, Long taxonCategoryId) {
        Long ancestorTaxonId = this.getSessionManager().getCurrentTaxon().getTaxonId();
        Long ancestorTaxonomicalRangeId = this.getSessionManager().getCurrentTaxon().getTaxonomicalRange().getId();
        return this.lookupSelectionListManagerBean().getFilteredTaxonList(taxonomicalRangeId, taxonCategoryId, ancestorTaxonId, ancestorTaxonomicalRangeId);
    }
    
    public Option[] getIdentificationStatus() {
        return this.lookupSelectionListManagerBean().getIdentificationStatus();
    }
    
    public Option[] getIdentificationType() {
        return this.lookupSelectionListManagerBean().getIdentificationType(this.getCurrentCollectionId());
    }
    
    public Option[] getIdentificationValidator() {
        return this.lookupSelectionListManagerBean().getIdentificationValidator();
    }

    public Option[] getIdentifier() {
        return this.lookupSelectionListManagerBean().getIdentifiers();
    }
    
    public Option[] getInstitution() {
        return this.lookupSelectionListManagerBean().getInstitution();
    }
    
    public Institution getInstitution(Long id) {
        return this.lookupSelectionListManagerBean().getInstitution(id);
    }

    public Taxon getTaxon(Long taxonId) {
        return this.lookupSelectionListManagerBean().getTaxon(taxonId);
    }
    
    public IdentificationStatus getIdentificationStatus(Long identificationStatusId) {
        return this.lookupSelectionListManagerBean().getIdentificationStatus(identificationStatusId);
    }
    
    public IdentificationType getIdentificationTypeById(Long identificationTypeId) {
        return this.lookupSelectionListManagerBean().getIdentificationTypeById(identificationTypeId);
    }
    
    public LifeStage getLifeStageById(Long id) {
        return this.lookupSelectionListManagerBean().getLifeStageById(id);
    }
    
    public Sex getSexById(Long id) {
        return this.lookupSelectionListManagerBean().getSexById(id);
    }
    
    public Option[] getExtractionType() {
        return this.lookupSelectionListManagerBean().getExtractionType(this.getCurrentCollectionId());
    }
    
    public ExtractionType getExtractionTypeById(Long extractionTypeId) {
        return this.lookupSelectionListManagerBean().getExtractionById(extractionTypeId);
    }
    
    public Option[] getFeatureType() {
        return this.lookupSelectionListManagerBean().getFeatureType();
    }
    
    public Option[] getProjection() {
        return this.lookupSelectionListManagerBean().getProjection();
    }
    
    public Option[] getSiteCalculationMethod() {
        return this.lookupSelectionListManagerBean().getSiteCalculationMethod();
    }
    
    public FeatureType getFeatureTypeById(Long id) {
        return this.lookupSelectionListManagerBean().getFeatureTypeById(id);
    }
    
    public Projection getProjectionById(Long id) {
        return this.lookupSelectionListManagerBean().getProjectionId(id);
    }
    
    public SiteCalculationMethod getSiteCalculationMethod(Long id) {
        return this.lookupSelectionListManagerBean().getSiteCalculationMethodById(id);
    }
}
