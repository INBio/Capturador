/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.GenericEntity;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.ExtractionType;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationMethod;
import org.inbio.ara.persistence.identification.Identification;
import org.inbio.ara.persistence.institution.Institution;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "specimen")
public class Specimen extends GenericEntity {

    private static long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)//Added
    @GeneratedValue(strategy=GenerationType.AUTO, generator="specimen")
    @SequenceGenerator(name="specimen", sequenceName="specimen_seq")
    @Basic(optional = false)
    @Column(name = "specimen_id")
    private Long specimenId;

    @Basic(optional = false)
    @Column(name = "catalog_number")
    private String catalogNumber;

    //@Enumerated(EnumType.STRING)
    @Column(name = "discarded", nullable=false)
    //private CustomBoolean discarded;
    private int discarded;

    @Column(name = "number_whole")
    private Long numberWhole;

    @Column(name = "number_fragments")
    private Long numberFragments;

    @Column(name = "external_specimen")
    private String externalSpecimen;

    @Column(name = "certainty_level")
    private Long certaintyLevel;

    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Collection collection;

    @Column(name="collection_id")
    private Long collectionId;
   
    @JoinColumn(name = "extraction_type_id", referencedColumnName = "extraction_type_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ExtractionType extractionType;
    @Column(name = "extraction_type_id")
    private Long extractionTypeId;

    @JoinColumn(name = "gathering_observation_id", referencedColumnName = "gathering_observation_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GatheringObservation gatheringObservation;

    @Column(name = "gathering_observation_detail_id")
    private Long gatheringObservationDetailId;

    @JoinColumn(name = "gathering_observation_method_id", referencedColumnName = "gathering_observation_method_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GatheringObservationMethod gatheringObservationMethod;
    @Column(name = "gathering_observation_method_id")
    private Long gatheringObservationMethodId;

    @JoinColumn(name = "institution_id", referencedColumnName = "institution_id",insertable=false, updatable=false)
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    private Institution institution;
    @Column(name = "institution_id")
    private Long institutionId;

//    @JoinColumn(name = "morphological_description_id", referencedColumnName = "morphological_description_id")
//    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "morphological_description_id")
    private Long morphologicalDescriptionId;

    @JoinColumn(name = "origin_id", referencedColumnName = "origin_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Origin origin;
    @Column(name = "origin_id")
    private Long originId;

    @JoinColumn(name = "preservation_medium_id", referencedColumnName = "preservation_medium_id", updatable=false, insertable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private PreservationMedium preservationMedium;
    @Column(name = "preservation_medium_id")
    private Long preservationMediumId;


    @JoinColumn(name = "specimen_category_id", referencedColumnName = "specimen_category_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private SpecimenCategory specimenCategory;
    @Column(name = "specimen_category_id")
    private Long specimenCategoryId;


    @JoinColumn(name = "specimen_type_id", referencedColumnName = "specimen_type_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private SpecimenType specimenType;
    @Column(name = "specimen_type_id")
    private Long specimenTypeId;

    @JoinColumn(name = "storage_type_id", referencedColumnName = "storage_type_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private StorageType storageType;
    @Column(name = "storage_type_id")
    private Long storageTypeId;

    @JoinColumn(name = "substrate_id", referencedColumnName = "substrate_id", insertable=false, updatable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Substrate substrate;
    @Column(name = "substrate_id")
    private Long substrateId;

    @OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="specimen")
    private Set<SpecimenLifeStageSex> specimenLifeStageSexList;

    @JoinColumn(name = "specimen_id", referencedColumnName = "specimen_id",
                insertable=false, updatable=false)
    @OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Set<Identification> identificationList;

    public Specimen() {
    }

    public Specimen(Long specimenId) {
        this.specimenId = specimenId;
    }

    public Specimen(Long specimenId, String catalogNumber, int discarded, 
            String createdBy, Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.specimenId = specimenId;
        this.catalogNumber = catalogNumber;
        this.discarded = discarded;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Long specimenId) {
        this.specimenId = specimenId;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public int getDiscarded() {
        return discarded;
    }

    public void setDiscarded(int discarded) {
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

    public String getExternalSpecimen() {
        return externalSpecimen;
    }

    public void setExternalSpecimen(String externalSpecimen) {
        this.externalSpecimen = externalSpecimen;
    }

    public Long getCertaintyLevel() {
        return certaintyLevel;
    }

    public void setCertaintyLevel(Long certaintyLevel) {
        this.certaintyLevel = certaintyLevel;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public ExtractionType getExtractionType() {
        return extractionType;
    }

    public void setExtractionType(ExtractionType extractionType) {
        this.extractionType = extractionType;
    }

    public GatheringObservation getGatheringObservation() {
        return gatheringObservation;
    }

    public void setGatheringObservation(GatheringObservation gatheringObservation) {
        this.gatheringObservation = gatheringObservation;
    }

    public Long getGatheringObservationDetailId() {
        return gatheringObservationDetailId;
    }

    public void setGatheringObservationDetailId(Long gatheringObservationDetailId) {
        this.gatheringObservationDetailId = gatheringObservationDetailId;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Long getMorphologicalDescriptionId() {
        return morphologicalDescriptionId;
    }

    public void setMorphologicalDescriptionId(Long morphologicalDescriptionId) {
        this.morphologicalDescriptionId = morphologicalDescriptionId;
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

    public void setSubstrate(Substrate substrate) {
        this.substrate = substrate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getSpecimenId() != null ? getSpecimenId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specimen)) {
            return false;
        }
        Specimen other = (Specimen) object;
        if ((this.getSpecimenId() == null && other.getSpecimenId() != null) || (this.getSpecimenId() != null && !this.specimenId.equals(other.specimenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.Specimen[specimenId=" + getSpecimenId() + "]";
    }

    /**
     * @return the gatheringObservationMethod
     */
    public GatheringObservationMethod getGatheringObservationMethod() {
        return gatheringObservationMethod;
    }

    /**
     * @param gatheringObservationMethod the gatheringObservationMethod to set
     */
    public void setGatheringObservationMethod(GatheringObservationMethod gatheringObservationMethod) {
        this.gatheringObservationMethod = gatheringObservationMethod;
    }

    /**
     * @return the specimenLifeStageSexList
     */
    public Set<SpecimenLifeStageSex> getSpecimenLifeStageSexList() {
        return specimenLifeStageSexList;
    }

    /**
     * @param specimenLifeStageSexList the specimenLifeStageSexList to set
     */
    public void setSpecimenLifeStageSexList(Set<SpecimenLifeStageSex> specimenLifeStageSexList) {
        this.specimenLifeStageSexList = specimenLifeStageSexList;
    }

    /**
     * @return the specimenCategoryId
     */
    public Long getSpecimenCategoryId() {
        return specimenCategoryId;
    }

    /**
     * @param specimenCategoryId the specimenCategoryId to set
     */
    public void setSpecimenCategoryId(Long specimenCategoryId) {
        this.specimenCategoryId = specimenCategoryId;
    }

    /**
     * @return the specimenTypeId
     */
    public Long getSpecimenTypeId() {
        return specimenTypeId;
    }

    /**
     * @param specimenTypeId the specimenTypeId to set
     */
    public void setSpecimenTypeId(Long specimenTypeId) {
        this.specimenTypeId = specimenTypeId;
    }

    /**
     * @return the gatheringObservationMethodId
     */
    public Long getGatheringObservationMethodId() {
        return gatheringObservationMethodId;
    }

    /**
     * @param gatheringObservationMethodId the gatheringObservationMethodId to set
     */
    public void setGatheringObservationMethodId(Long gatheringObservationMethodId) {
        this.gatheringObservationMethodId = gatheringObservationMethodId;
    }

    /**
     * @return the extractionTypeId
     */
    public Long getExtractionTypeId() {
        return extractionTypeId;
    }

    /**
     * @param extractionTypeId the extractionTypeId to set
     */
    public void setExtractionTypeId(Long extractionTypeId) {
        this.extractionTypeId = extractionTypeId;
    }

    /**
     * @return the collectionId
     */
    public Long getCollectionId() {
        return collectionId;
    }

    /**
     * @param collectionId the collectionId to set
     */
    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * @return the originId
     */
    public Long getOriginId() {
        return originId;
    }

    /**
     * @param originId the originId to set
     */
    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    /**
     * @return the preservationMediumId
     */
    public Long getPreservationMediumId() {
        return preservationMediumId;
    }

    /**
     * @param preservationMediumId the preservationMediumId to set
     */
    public void setPreservationMediumId(Long preservationMediumId) {
        this.preservationMediumId = preservationMediumId;
    }

    /**
     * @return the storageTypeId
     */
    public Long getStorageTypeId() {
        return storageTypeId;
    }

    /**
     * @param storageTypeId the storageTypeId to set
     */
    public void setStorageTypeId(Long storageTypeId) {
        this.storageTypeId = storageTypeId;
    }

    /**
     * @param institution the institution to set
     */
    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    /**
     * @return the substrateId
     */
    public Long getSubstrateId() {
        return substrateId;
    }

    /**
     * @param substrateId the substrateId to set
     */
    public void setSubstrateId(Long substrateId) {
        this.substrateId = substrateId;
    }

    public Set<Identification> getIdentificationList() {
            return identificationList;
    }

    public void setIdentificationList(Set<Identification> identificationList) {
            this.identificationList = identificationList;
    }

    /**
     * @return the institutionId
     */
    public Long getInstitutionId() {
        return institutionId;
    }

    /**
     * @param institutionId the institutionId to set
     */
    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }
}
