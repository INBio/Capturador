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

package org.inbio.ara.persistence.specimen;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
import org.inbio.ara.persistence.gathering.GatheringObservationMethod;
import org.inbio.ara.persistence.gathering.MorphologicalDescription;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.institution.Institution;

/**
 * Entity class Specimen
 *
 */

@Entity()
@Table(name = "specimen")
@TableGenerator(name="specimen_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="specimen_id",allocationSize=1)
public class Specimen extends genericEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="specimen_gen")
    @Column(name = "specimen_id", nullable = false)
    private Long id;

    @JoinColumn(name="institution_id", referencedColumnName="institution_id", nullable = false)
    @ManyToOne
    private Institution institution;

    @Column(name = "catalog_number", nullable = false)
    private Long catalogNumber;

    @JoinColumn(name="gathering_observation_detail_id", referencedColumnName="gathering_observation_detail_id")
    @ManyToOne()
    private GatheringObservationDetail gatheringObservationDetail;

    @JoinColumn(name="specimen_category_id", referencedColumnName="specimen_category_id")
    @ManyToOne()
    private SpecimenCategory specimenCategory;
    
    @JoinColumn(name="specimen_type_id", referencedColumnName="specimen_type_id")
    @ManyToOne()
    private SpecimenType specimenType;
    
    @JoinColumn(name="storage_type_id", referencedColumnName="storage_type_id")
    @ManyToOne()
    private StorageType storageType;
    
    @JoinColumn(name="substrate_id", referencedColumnName="substrate_id")
    @ManyToOne()
    private Substrate substrate;
    
    @JoinColumn(name="origin_id", referencedColumnName="origin_id")
    @ManyToOne()
    private Origin origin;
    
    @JoinColumn(name="preservation_medium_id", referencedColumnName="preservation_medium_id")
    @ManyToOne()
    private PreservationMedium preservationMedium;
    
    @JoinColumn(name="gathering_observation_id", referencedColumnName="gathering_observation_id")
    @ManyToOne()
    private GatheringObservation gatheringObservation;
    
    @JoinColumn(name="morphological_description_id", referencedColumnName="morphological_description_id")
    @ManyToOne()
    private MorphologicalDescription morphologicalDescription;
    
    @JoinColumn(name="collection_id", referencedColumnName="collection_id")
    @ManyToOne()
    private Collection collection;
    
    @JoinColumn(name="life_stage_id", referencedColumnName="life_stage_id")
    @ManyToOne()
    private LifeStage lifeStage;
    
    @JoinColumn(name="sex_id", referencedColumnName="sex_id")
    @ManyToOne()
    private Sex sex;
    
    @JoinColumn(name="gathering_observation_method_id", referencedColumnName="gathering_observation_method_id")
    @ManyToOne()
    private GatheringObservationMethod gatheringObservationMethod;
    
    
    @JoinColumn(name="extraction_type_id", referencedColumnName="extraction_type_id")
    @ManyToOne()
    private ExtractionType extractionType;

    /*
    @JoinColumn(name="project_id", referencedColumnName="project_id")
    @ManyToOne()
    private Project project;
    */
    @Column(name="discarded", length = 1)
    private String discarded;
    
    @Column(name="number_whole")
    private Long numberWhole;
    
    @Column(name="number_fragments")
    private Long numberFragments;
    
    @Column(name="external_specimen")
    private String externalSpecimen;
    
    @Column(name="certainty_level")
    private Long certaintyLevel;
    
    @Temporal(TemporalType.DATE)
    @Column(name="date_time")
    private Date dateTime;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "specimen")
    private Set<SpecimenLifeStageSex> specimenLifeStageSexSet;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "specimen")
    private Set<Component> componentSet;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "specimen")
    private Set<Identification> identificationSet;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "specimen")
    private Set<TransactedSpecimen> transactedSpecimenSet;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "specimen")
    private Set<SpecimenAnnotation> specimenAnnotationSet;
    
    
    @Transient
    private boolean selected;
    @Transient
    private Long gatheringObservationId;
    @Transient
    private String collectionName;
    @Transient
    private String specimenCategoryName;
    @Transient
    private String specimenTypeName;
    @Transient
    private String originName;
    @Transient
    private String preservationMediumName;
    @Transient
    private String substrateName;
    @Transient
    private String storageName;
    @Transient
    private String extractionMethodName;    
    @Transient
    private String gatheringObservationMethodName;
    @Transient
    private String institutionCode;

    @PostLoad
    public void postLoad(){
        if(this.gatheringObservation != null)
            this.gatheringObservationId = this.gatheringObservation.getId();
        if(this.collection != null)
            this.collectionName = this.collection.getName();
        if(this.specimenCategory != null)
            this.specimenCategoryName = this.specimenCategory.getName();
        if(this.specimenType != null)
            this.specimenTypeName = this.specimenType.getName();
        if(this.origin != null)
            this.originName = this.origin.getName();
        if(this.preservationMedium != null)
            this.preservationMediumName = this.preservationMedium.getName();
        if(this.substrate != null)
            this.substrateName = this.substrate.getName();
        if(this.storageType != null)
            this.storageName = this.storageType.getName();
        if(this.extractionType != null)
            this.extractionMethodName = this.extractionType.getName();        
        if(this.gatheringObservationMethod != null)
            this.gatheringObservationMethodName = this.gatheringObservationMethod.getName();
        if(this.institution != null)
            this.institutionCode = this.institution.getInstitutionCode();
    }
    
    /** Creates a new instance of Specimen */
    public Specimen() {
    }
    
    /**
     * Gets the id of this Specimen.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }
    
    /**
     * Sets the id of this Specimen to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Returns a hash code value for the object.  This implementation computes
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this Specimen.  The result is
     * <code>true</code> if and only if the argument is not null and is a Specimen object that
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specimen)) {
            return false;
        }
        Specimen other = (Specimen)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.Specimen[id=" + id + "]";
    }
    
    
    public GatheringObservationDetail getGatheringObservationDetail() {
        return gatheringObservationDetail;
    }
     
    public void setGatheringObservationDetail(GatheringObservationDetail gatheringObservationDetail) {
        this.gatheringObservationDetail = gatheringObservationDetail;
    }
    
    public SpecimenCategory getSpecimenCategory() {
        return specimenCategory;
    }
    
    public void setSpecimenCategory(SpecimenCategory specimenCategory) {
        this.specimenCategory = specimenCategory;
    }
    
    public SpecimenType getSpecimenType() {
        return specimenType;
    }
    
    public void setSpecimenType(SpecimenType specimenType) {
        this.specimenType = specimenType;
    }
    
    public StorageType getStorageType() {
        return storageType;
    }
    
    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
    }
    
    public Substrate getSubstrate() {
        return substrate;
    }
    
    public void setSubstrate(Substrate subtrate) {
        this.substrate = subtrate;
    }
    
    public Origin getOrigin() {
        return origin;
    }
    
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }
    
    public PreservationMedium getPreservationMedium() {
        return preservationMedium;
    }
    
    public void setPreservationMedium(PreservationMedium preservationMedium) {
        this.preservationMedium = preservationMedium;
    }
    
    public GatheringObservation getGatheringObservation() {
        return gatheringObservation;
    }
     
    public void setGatheringObservation(GatheringObservation gatheringObservation) {
        this.gatheringObservation = gatheringObservation;
    }
    
    public MorphologicalDescription getMorphologicalDescription() {
        return morphologicalDescription;
    }
    
    public void setMorphologicalDescription(MorphologicalDescription morphologicalDescription) {
        this.morphologicalDescription = morphologicalDescription;
    }
    
    public Collection getCollection() {
        return collection;
    }
    
    public void setCollection(Collection collection) {
        this.collection = collection;
    }
    
    public LifeStage getLifeStage() {
        return lifeStage;
    }
    
    public void setLifeStage(LifeStage lifeStage) {
        this.lifeStage = lifeStage;
    }
    
    public Sex getSex() {
        return sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    
    
    public ExtractionType getExtractionType() {
        return extractionType;
    }
    
    public void setExtractionType(ExtractionType extractionType) {
        this.extractionType = extractionType;
    }
    
    /*
    public Project getProject() {
        return project;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    */
    public String getDiscarded() {
        return discarded;
    }
    
    public void setDiscarded(String discarded) {
        this.discarded = discarded;
    }
    
    public Long getNumberWhole() {
        return numberWhole;
    }
    
    public void setNumberWhole(Long numberWhole) {
        this.numberWhole = numberWhole;
    }
    
    public Long getNumberFragments() {
        return numberFragments;
    }
    
    public void setNumberFragments(Long numberFragments) {
        this.numberFragments = numberFragments;
    }
    
    public Set<Component> getComponentSet() {
        return componentSet;
    }
    
    public void setComponentSet(Set<Component> componentSet) {
        this.componentSet = componentSet;
    }
    
    public Set<Identification> getIdentificationSet() {
        return identificationSet;
    }
    
    public void setIdentificationSet(Set<Identification> identificationSet) {
        this.identificationSet = identificationSet;
    }
    
    public Set<TransactedSpecimen> getTransactedSpecimenSet() {
        return transactedSpecimenSet;
    }
    
    public void setTransactedSpecimenSet(Set<TransactedSpecimen> transactedSpecimenSet) {
        this.transactedSpecimenSet = transactedSpecimenSet;
    }
    
    public Set<SpecimenAnnotation> getSpecimenAnnotationSet() {
        return specimenAnnotationSet;
    }
    
    public void setSpecimenAnnotationSet(Set<SpecimenAnnotation> specimenAnnotationSet) {
        this.specimenAnnotationSet = specimenAnnotationSet;
    }
    
    public GatheringObservationMethod getGatheringObservationMethod() {
        return gatheringObservationMethod;
    }
    
    public void setGatheringObservationMethod(GatheringObservationMethod gatheringObservationMethod) {
        this.gatheringObservationMethod = gatheringObservationMethod;
    }
    
    public String getExternalSpecimen() {
        return externalSpecimen;
    }
    
    public void setExternalSpecimen(String externalSpecimen) {
        this.externalSpecimen = externalSpecimen;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    
    public String getCollectionName() {
        return collectionName;
    }

    public String getSpecimenCategoryName() {
        return specimenCategoryName;
    }

    public String getSpecimenTypeName() {
        return specimenTypeName;
    }

    public String getOriginName() {
        return originName;
    }

    public String getPreservationMediumName() {
        return preservationMediumName;
    }

    public String getSubstrateName() {
        return substrateName;
    }

    public String getStorageName() {
        return storageName;
    }

    public String getExtractionMethodName() {
        return extractionMethodName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Long getGatheringObservationId() {
        return gatheringObservationId;
    }

    public void setGatheringObservationId(Long gathering_observation_id) {
        this.gatheringObservationId = gathering_observation_id;
    }

    public String getGatheringObservationMethodName() {
        return gatheringObservationMethodName;
    }

    public void setGatheringObservationMethodName(String gatheringObservationMethodName) {
        this.gatheringObservationMethodName = gatheringObservationMethodName;
    }

    /**
     * @return the catalogNumber
     */
    public Long getCatalogNumber() {
        return catalogNumber;
    }

    /**
     * @param catalogNumber the catalogNumber to set
     */
    public void setCatalogNumber(Long catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    /**
     * @return the institution
     */
    public Institution getInstitution() {
        return institution;
    }

    /**
     * @param institution the institution to set
     */
    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    /**
     * @return the institutionCode
     */
    public String getInstitutionCode() {
        return institutionCode;
    }

    /**
     * @param institutionCode the institutionCode to set
     */
    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }
}
