/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
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
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.specimen.Specimen;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "morphological_description")

public class MorphologicalDescription extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="MorphologicalDescription")
	@SequenceGenerator(name="MorphologicalDescription", sequenceName="morphological_description_seq")
    @Basic(optional = false)
    @Column(name = "morphological_description_id")
    private Long morphologicalDescriptionId;

    @Column(name = "contents")
    private String contents;

    @Column(name = "description_date")
    @Temporal(TemporalType.DATE)
    private Calendar descriptionDate;

    @OneToMany(mappedBy = "morphologicalDescription")
    private List<GatheringObservationDetail> gatheringObservationDetailList;

    @OneToMany(mappedBy = "morphologicalDescriptionId", fetch = FetchType.LAZY)
    private List<Specimen> specimenList;

    @JoinColumn(name = "description_person_id", referencedColumnName = "person_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Person descriptionPerson;

    public MorphologicalDescription() {
    }

    public MorphologicalDescription(Long morphologicalDescriptionId) {
        this.morphologicalDescriptionId = morphologicalDescriptionId;
    }

    public MorphologicalDescription(Long morphologicalDescriptionId, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.morphologicalDescriptionId = morphologicalDescriptionId;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getMorphologicalDescriptionId() {
        return morphologicalDescriptionId;
    }

    public void setMorphologicalDescriptionId(Long morphologicalDescriptionId) {
        this.morphologicalDescriptionId = morphologicalDescriptionId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Calendar getDescriptionDate() {
        return descriptionDate;
    }

    public void setDescriptionDate(Calendar descriptionDate) {
        this.descriptionDate = descriptionDate;
    }

    public Person getDescriptionPerson() {
        return descriptionPerson;
    }

    public void setDescriptionPerson(Person descriptionPersonId) {
        this.descriptionPerson = descriptionPersonId;
    }

    public List<GatheringObservationDetail> getGatheringObservationDetailList() {
        return gatheringObservationDetailList;
    }

    public void setGatheringObservationDetailList(List<GatheringObservationDetail> gatheringObservationDetailList) {
        this.gatheringObservationDetailList = gatheringObservationDetailList;
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
        hash += (morphologicalDescriptionId != null ? morphologicalDescriptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MorphologicalDescription)) {
            return false;
        }
        MorphologicalDescription other = (MorphologicalDescription) object;
        if ((this.morphologicalDescriptionId == null && other.morphologicalDescriptionId != null) || (this.morphologicalDescriptionId != null && !this.morphologicalDescriptionId.equals(other.morphologicalDescriptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.MorphologicalDescription[morphologicalDescriptionId=" + morphologicalDescriptionId + "]";
    }
}
