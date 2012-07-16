/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.label;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pcorrales
 */
@Embeddable
public class LabelHistoryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "label_id")
    private Long labelId;
    
    @Basic(optional = false)
    @Column(name = "initial_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar initialDate;

    public LabelHistoryPK() {
    }

    public LabelHistoryPK(Long labelId, Calendar initialDate) {
        this.labelId = labelId;
        this.initialDate = initialDate;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Calendar getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Calendar initialDate) {
        this.initialDate = initialDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labelId != null ? labelId.hashCode() : 0);
        hash += (initialDate != null ? initialDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabelHistoryPK)) {
            return false;
        }
        LabelHistoryPK other = (LabelHistoryPK) object;
        if ((this.labelId == null && other.labelId != null) || (this.labelId != null && !this.labelId.equals(other.labelId))) {
            return false;
        }
        if ((this.initialDate == null && other.initialDate != null) || (this.initialDate != null && !this.initialDate.equals(other.initialDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.label.LabelHistoryPK[labelId=" + labelId + ", initialDate=" + initialDate + "]";
    }

}
