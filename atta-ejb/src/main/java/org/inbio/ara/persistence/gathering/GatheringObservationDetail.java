/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
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
import org.inbio.ara.persistence.GenericEntity;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.specimen.Specimen;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "gathering_observation_detail")

public class GatheringObservationDetail extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="GatheringObservationDetail")
	@SequenceGenerator(name="GatheringObservationDetail", sequenceName="gathering_observation_detail_seq")
    @Basic(optional = false)
    @Column(name = "gathering_observation_detail_id")
    private Long gatheringObservationDetailId;

    @JoinColumn(name = "gathering_observation_detail_person_id", referencedColumnName = "person_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person gatheringObservationDetailPerson;

    @Basic(optional = false)
    @Column(name = "gathering_observation_detail_number")
    private String gatheringObservationDetailNumber;

    @Column(name = "collection_id")
    private Long collectionId;

    @Column(name = "gathering_observation_id")
    private Long gatheringObservationId;

    @JoinColumn(name = "morphological_description_id", referencedColumnName = "morphological_description_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade={CascadeType.ALL})
    private MorphologicalDescription morphologicalDescription;

    @OneToMany(mappedBy = "gatheringObservationDetailId", fetch = FetchType.LAZY)
    private List<Specimen> specimenList;

    public GatheringObservationDetail() {
    }

    public GatheringObservationDetail(Long gatheringObservationDetailId) {
        this.gatheringObservationDetailId = gatheringObservationDetailId;
    }

    public GatheringObservationDetail(Long gatheringObservationDetailId, Long gatheringObservationDetailPersonId, String gatheringObservationDetailNumber, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.gatheringObservationDetailId = gatheringObservationDetailId;
        this.gatheringObservationDetailNumber = gatheringObservationDetailNumber;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public String getGatheringObservationDetailNumber() {
        return gatheringObservationDetailNumber;
    }

    public void setGatheringObservationDetailNumber(String gatheringObservationDetailNumber) {
        this.gatheringObservationDetailNumber = gatheringObservationDetailNumber;
    }

    public Long getGatheringObservationDetailId() {
        return gatheringObservationDetailId;
    }

    public void setGatheringObservationDetailId(Long gatheringObservationDetailId) {
        this.gatheringObservationDetailId = gatheringObservationDetailId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getGatheringObservationId() {
        return gatheringObservationId;
    }

    public void setGatheringObservationId(Long gatheringObservationId) {
        this.gatheringObservationId = gatheringObservationId;
    }

    public MorphologicalDescription getMorphologicalDescription() {
        return morphologicalDescription;
    }

    public void setMorphologicalDescription(MorphologicalDescription morphologicalDescriptionId) {
        this.morphologicalDescription = morphologicalDescriptionId;
    }

    public List<Specimen> getSpecimenList() {
        return specimenList;
    }

    public void setSpecimenList(List<Specimen> specimenList) {
        this.specimenList = specimenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gatheringObservationDetailId != null ? gatheringObservationDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringObservationDetail)) {
            return false;
        }
        GatheringObservationDetail other = (GatheringObservationDetail) object;
        if ((this.gatheringObservationDetailId == null && other.gatheringObservationDetailId != null) || (this.gatheringObservationDetailId != null && !this.gatheringObservationDetailId.equals(other.gatheringObservationDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.GatheringObservationDetail[gatheringObservationDetailId=" + gatheringObservationDetailId + "]";
    }

    /**
     * @return the gatheringObservationDetailPerson
     */
    public Person getGatheringObservationDetailPerson() {
        return gatheringObservationDetailPerson;
    }

    /**
     * @param gatheringObservationDetailPerson the gatheringObservationDetailPerson to set
     */
    public void setGatheringObservationDetailPerson(Person gatheringObservationDetailPerson) {
        this.gatheringObservationDetailPerson = gatheringObservationDetailPerson;
    }
}
