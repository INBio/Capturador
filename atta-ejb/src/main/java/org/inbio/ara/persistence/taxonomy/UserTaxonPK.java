/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author esmata
 */
@Embeddable

public class UserTaxonPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "taxon_id")
    private Long taxonId;

    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;

    @Basic(optional = false)
    @Column(name = "sequence")
    private Long sequence;

    public UserTaxonPK() {
    }

    public UserTaxonPK(Long taxonId, Long userId, Long sequence) {
        this.taxonId = taxonId;
        this.userId = userId;
        this.sequence = sequence;
    }

    public Long getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonId != null ? taxonId.hashCode() : 0);
        hash += (userId != null ? userId.hashCode() : 0);
        hash += (sequence != null ? sequence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTaxonPK)) {
            return false;
        }
        UserTaxonPK other = (UserTaxonPK) object;
        if ((this.taxonId == null && other.taxonId != null) || (this.taxonId != null && !this.taxonId.equals(other.taxonId))) {
            return false;
        }
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        if ((this.sequence == null && other.sequence != null) || (this.sequence != null && !this.sequence.equals(other.sequence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.UserTaxonPK[taxonId=" + taxonId + ", userId=" + userId + ", sequence=" + sequence + "]";
    }

}
