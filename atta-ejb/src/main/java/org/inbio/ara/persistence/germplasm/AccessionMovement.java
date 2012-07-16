/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "accession_movement")
public class AccessionMovement extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessionMovementPK accessionMovementPK;

    @Basic(optional = false)
    @Column(name = "weight")
    private Long weight;

    @Basic(optional = false)
    @Column(name = "responsable_person_id")
    private Long responsablePersonId;

    @Basic(optional = false)
    @Column(name = "accession_movement_type_id")
    private Long accessionMovementTypeId;

    @Column(name = "notes")
    private String notes;

    public AccessionMovement() {
    }

    public AccessionMovement(AccessionMovementPK accessionMovementPK) {
        this.accessionMovementPK = accessionMovementPK;
    }

    public AccessionMovement(AccessionMovementPK accessionMovementPK, Long weight, Long responsablePersonId, Long accessionMovementTypeId, String notes, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.accessionMovementPK = accessionMovementPK;
        this.weight = weight;
        this.responsablePersonId = responsablePersonId;
        this.accessionMovementTypeId = accessionMovementTypeId;
        this.notes = notes;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate); 
    }

    public AccessionMovement(Long accessionId, Date accessionMovementDate) {
        this.accessionMovementPK = new AccessionMovementPK(accessionId, accessionMovementDate);
    }

    public AccessionMovementPK getAccessionMovementPK() {
        return accessionMovementPK;
    }

    public void setAccessionMovementPK(AccessionMovementPK accessionMovementPK) {
        this.accessionMovementPK = accessionMovementPK;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getResponsablePersonId() {
        return responsablePersonId;
    }

    public void setResponsablePersonId(Long responsablePersonId) {
        this.responsablePersonId = responsablePersonId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessionMovementPK != null ? accessionMovementPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessionMovement)) {
            return false;
        }
        AccessionMovement other = (AccessionMovement) object;
        if ((this.accessionMovementPK == null && other.accessionMovementPK != null) || (this.accessionMovementPK != null && !this.accessionMovementPK.equals(other.accessionMovementPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.AccessionMovement[accessionMovementPK=" + accessionMovementPK + "]";
    }

    /**
     * @return the accessionMovementTypeId
     */
    public Long getAccessionMovementTypeId() {
        return accessionMovementTypeId;
    }

    /**
     * @param accessionMovementTypeId the accessionMovementTypeId to set
     */
    public void setAccessionMovementTypeId(Long accessionMovementTypeId) {
        this.accessionMovementTypeId = accessionMovementTypeId;
    }

}
