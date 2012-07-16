/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "user_nomenclatural_group")

public class UserNomenclaturalGroup extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected UserNomenclaturalGroupPK userNomenclaturalGroupPK;

    /*@JoinColumn(name = "nomenclatural_group_id", referencedColumnName = "nomenclatural_group_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NomenclaturalGroup nomenclaturalGroup;*/

    /*@JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SystemUser systemUser;*/

    public UserNomenclaturalGroup() {
    }

    public UserNomenclaturalGroup(UserNomenclaturalGroupPK userNomenclaturalGroupPK) {
        this.userNomenclaturalGroupPK = userNomenclaturalGroupPK;
    }

    public UserNomenclaturalGroup(UserNomenclaturalGroupPK userNomenclaturalGroupPK, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.userNomenclaturalGroupPK = userNomenclaturalGroupPK;
        this.setCreationDate(creationDate);
        this.setCreatedBy(createdBy);
        this.setLastModificationDate(lastModificationDate);
        this.setLastModificationBy(lastModificationBy);
    }

    public UserNomenclaturalGroup(Long nomenclaturalGroupId, Long userId, Long sequence) {
        this.userNomenclaturalGroupPK = new UserNomenclaturalGroupPK(nomenclaturalGroupId, userId, sequence);
    }

    public UserNomenclaturalGroupPK getUserNomenclaturalGroupPK() {
        return userNomenclaturalGroupPK;
    }

    public void setUserNomenclaturalGroupPK(UserNomenclaturalGroupPK userNomenclaturalGroupPK) {
        this.userNomenclaturalGroupPK = userNomenclaturalGroupPK;
    }

    /*public Long getNomenclaturalGroup() {
        return nomenclaturalGroup;
    }

    public void setNomenclaturalGroup(Long nomenclaturalGroup) {
        this.nomenclaturalGroup = nomenclaturalGroup;
    }

    public Long getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(Long systemUser) {
        this.systemUser = systemUser;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userNomenclaturalGroupPK != null ? userNomenclaturalGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserNomenclaturalGroup)) {
            return false;
        }
        UserNomenclaturalGroup other = (UserNomenclaturalGroup) object;
        if ((this.userNomenclaturalGroupPK == null && other.userNomenclaturalGroupPK != null) || (this.userNomenclaturalGroupPK != null && !this.userNomenclaturalGroupPK.equals(other.userNomenclaturalGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.UserNomenclaturalGroup[userNomenclaturalGroupPK=" + userNomenclaturalGroupPK + "]";
    }

}
