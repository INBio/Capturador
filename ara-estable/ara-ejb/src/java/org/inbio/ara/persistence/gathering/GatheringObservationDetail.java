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
 * GatheringDetail.java
 *
 * Created on October 28, 2007, 5:14 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.person.Person;
/**
 * Entity class GatheringDetail
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="gathering_observation_detail")
@TableGenerator(name="gathering_observation_detail_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="gathering_observation_detail_id",allocationSize=1)
public class GatheringObservationDetail extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="gathering_observation_detail_gen")
    @Column(name = "gathering_observation_detail_id", nullable = false)
    private Long id;
    
    
    @Column(name="gathering_observation_detail_number")
    private String gatheringObservationDetailNumber;
    
    @JoinColumn(name="morphological_description_id", referencedColumnName="morphological_description_id")
    @ManyToOne()
    private MorphologicalDescription morphologicalDescription;
    
    @JoinColumn(name="label_id", referencedColumnName="label_id")
    @ManyToOne()
    private Label label;    
    
    @JoinColumn(name="original_label_id", referencedColumnName="original_label_id")
    @ManyToOne()
    private OriginalLabel originalLabel;
    
    @JoinColumn(name="gathering_observation_id", referencedColumnName="gathering_observation_id")
    @ManyToOne()
    private GatheringObservation gatheringObservation;
    
    @Transient
    private String summary;
    /*
    @Column(name="specimen_count")
    private Long specimenCount;
    */
    /*
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "gatheringDetail")
    private Set<Specimen> specimenSet;
    */
    
    /*
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "gatheringDetail")
    private Set<SpecimenGatheringDetail> specimenSet;
    */
    @JoinColumn(name = "gathering_observation_detail_person_id", referencedColumnName = "person_id")
    @ManyToOne()
    private Person person;
    
    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id")
    @ManyToOne()
    private Collection collection;    
    
    @Transient
    private String responsiblePersonName;
    
    @Transient
    private String collectionName;
    
    /** Creates a new instance of GatheringDetail */
    public GatheringObservationDetail() {
    }

    /*
    public GatheringObservationDetail(GatheringDetailPK gatheringDetailPK) {
        this.gatheringDetailPK = gatheringDetailPK;
    }
    
    public GatheringObservationDetail(Long gatheringDetailPersonId, String gatheringNumber, Long collectionId) {
        this.gatheringDetailPK = new GatheringDetailPK(gatheringDetailPersonId, gatheringNumber,  collectionId);
    }

    public GatheringDetailPK getGatheringDetailPK() {
        return gatheringDetailPK;
    }
     */

    public MorphologicalDescription getMorphologicalDescription() {
        return morphologicalDescription;
    }

    public void setMorphologicalDescription(MorphologicalDescription morphologicalDescription) {
        this.morphologicalDescription = morphologicalDescription;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public OriginalLabel getOriginalLabel() {
        return originalLabel;
    }

    public void setOriginalLabel(OriginalLabel originalLabel) {
        this.originalLabel = originalLabel;
    }

    /*
    public Long getSpecimenCount() {
        return specimenCount;
    }

    public void setSpecimenCount(Long specimenCount) {
        this.specimenCount = specimenCount;
    }
    */
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this PersonProfile.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonProfile object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringObservationDetail)) {
            return false;
        }
        GatheringObservationDetail other = (GatheringObservationDetail)object;
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
        return "org.inbio.ara.persistence.gathering.gatheringObservationDetail[id=" + id + "]";
    }    

    /*
    public Set<Specimen> getSpecimenSet() {
        return specimenSet;
    }

    public void setSpecimenSet(Set<Specimen> specimenSet) {
        this.specimenSet = specimenSet;
    }
     */
    /*
    public Set<SpecimenGatheringDetail> getSpecimenSet() {
        return specimenSet;
    }

    public void setSpecimenSet(Set<SpecimenGatheringDetail> specimenSet) {
        this.specimenSet = specimenSet;
    }
    */
    public Long getId() {
        return id;
    }

    public String getGatheringObservationDetailNumber() {
        return gatheringObservationDetailNumber;
    }

    public void setGatheringObservationDetailNumber(String gatheringObservationDetailNumber) {
        this.gatheringObservationDetailNumber = gatheringObservationDetailNumber;
    }

    public GatheringObservation getGatheringObservation() {
        return gatheringObservation;
    }

    public void setGatheringObservation(GatheringObservation gatheringObservation) {
        this.gatheringObservation = gatheringObservation;
    }

    public String getResponsiblePersonName() {
        return responsiblePersonName;
    }

    public String getCollectionName() {
        return collectionName;
    }
    
    @PostLoad
    public void postLoad(){
        this.responsiblePersonName = this.person.getFormalFullName();
        this.collectionName = this.collection.getName();
        this.summary = this.responsiblePersonName + " " + this.getGatheringObservationDetailNumber() + ".";
    }
    
    public String getSummary() {
        String summary;
        
        summary = "Id: " + this.getId() + ", ";
        summary += this.getResponsiblePersonName() + " " + this.getGatheringObservationDetailNumber();
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
