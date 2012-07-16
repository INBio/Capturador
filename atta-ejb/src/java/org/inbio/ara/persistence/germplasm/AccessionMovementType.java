/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "accession_movement_type")
public class AccessionMovementType extends SelectionListGenericEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="accession_movement_type")
    @SequenceGenerator(name="accession_movement_type", sequenceName="accession_movement_type_seq")
    @Basic(optional = false)
    @Column(name = "accession_movement_type_id")
    private Long accessionMovementTypeId;



    public AccessionMovementType() {
    }

    public AccessionMovementType(Long accessionMovementTypeId) {
        this.accessionMovementTypeId = accessionMovementTypeId;
    }

    public AccessionMovementType(Long accessionMovementTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.accessionMovementTypeId = accessionMovementTypeId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getAccessionMovementTypeId() {
        return accessionMovementTypeId;
    }

    public void setAccessionMovementTypeId(Long accessionMovementTypeId) {
        this.accessionMovementTypeId = accessionMovementTypeId;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessionMovementTypeId != null ? accessionMovementTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessionMovementType)) {
            return false;
        }
        AccessionMovementType other = (AccessionMovementType) object;
        if ((this.accessionMovementTypeId == null && other.accessionMovementTypeId != null) || (this.accessionMovementTypeId != null && !this.accessionMovementTypeId.equals(other.accessionMovementTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.AccessionMovementType[accessionMovementTypeId=" + accessionMovementTypeId + "]";
    }

    @Override
    public Long getId() {
        return accessionMovementTypeId;
    }

    @Override
    public void setId(Long id) {
        this.accessionMovementTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.ACCESSION_MOVEMENT_TYPE;
    }

}
