/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dasolano
 */
@Embeddable
public class AccessionMovementPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "accession_id")
    private Long accessionId;
    
    @Basic(optional = false)
    @Column(name = "accession_movement_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessionMovementDate;

    public AccessionMovementPK() {
    }

    public AccessionMovementPK(Long accessionId, Date accessionMovementDate) {
        this.accessionId = accessionId;
        this.accessionMovementDate = accessionMovementDate;
    }

    public Long getAccessionId() {
        return accessionId;
    }

    public void setAccessionId(Long accessionId) {
        this.accessionId = accessionId;
    }

    public Date getAccessionMovementDate() {
        return accessionMovementDate;
    }

    public void setAccessionMovementDate(Date accessionMovementDate) {
        this.accessionMovementDate = accessionMovementDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessionId != null ? accessionId.hashCode() : 0);
        hash += (accessionMovementDate != null ? accessionMovementDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessionMovementPK)) {
            return false;
        }
        AccessionMovementPK other = (AccessionMovementPK) object;
        if ((this.accessionId == null && other.accessionId != null) || (this.accessionId != null && !this.accessionId.equals(other.accessionId))) {
            return false;
        }
        if ((this.accessionMovementDate == null && other.accessionMovementDate != null) || (this.accessionMovementDate != null && !this.accessionMovementDate.equals(other.accessionMovementDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.AccessionMovementPK[accessionId=" + accessionId + ", accessionMovementDate=" + accessionMovementDate + "]";
    }

}
