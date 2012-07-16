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
public class UserNomenclaturalGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "nomenclatural_group_id")
    private Long nomenclaturalGroupId;

    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;

    @Basic(optional = false)
    @Column(name = "sequence")
    private Long sequence;

    public UserNomenclaturalGroupPK() {
    }

    public UserNomenclaturalGroupPK(Long nomenclaturalGroupId, Long userId, Long sequence) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
        this.userId = userId;
        this.sequence = sequence;
    }

    public Long getNomenclaturalGroupId() {
        return nomenclaturalGroupId;
    }

    public void setNomenclaturalGroupId(Long nomenclaturalGroupId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
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
        hash += (nomenclaturalGroupId != null ? nomenclaturalGroupId.hashCode() : 0);
        hash += (userId != null ? userId.hashCode() : 0);
        hash += (sequence != null ? sequence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserNomenclaturalGroupPK)) {
            return false;
        }
        UserNomenclaturalGroupPK other = (UserNomenclaturalGroupPK) object;
        if ((this.nomenclaturalGroupId == null && other.nomenclaturalGroupId != null) || (this.nomenclaturalGroupId != null && !this.nomenclaturalGroupId.equals(other.nomenclaturalGroupId))) {
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
        return "org.inbio.ara.persistence.taxonomy.UserNomenclaturalGroupPK[nomenclaturalGroupId=" + nomenclaturalGroupId + ", userId=" + userId + ", sequence=" + sequence + "]";
    }

}
