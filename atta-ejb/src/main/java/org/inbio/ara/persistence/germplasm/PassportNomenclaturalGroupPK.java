/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dasolano
 */
@Embeddable
public class PassportNomenclaturalGroupPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "passport_id")
    private Long passportId;

    @Basic(optional = false)
    @Column(name = "nomenclatural_group_id")
    private Long nomenclaturalGroupId;

    public PassportNomenclaturalGroupPK() {
    }

    public PassportNomenclaturalGroupPK(Long passportId, Long nomenclaturalGroupId) {
        this.passportId = passportId;
        this.nomenclaturalGroupId = nomenclaturalGroupId;
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public Long getNomenclaturalGroupId() {
        return nomenclaturalGroupId;
    }

    public void setNomenclaturalGroupId(Long nomenclaturalGroupId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passportId != null ? passportId.hashCode() : 0);
        hash += (nomenclaturalGroupId != null ? nomenclaturalGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PassportNomenclaturalGroupPK)) {
            return false;
        }
        PassportNomenclaturalGroupPK other = (PassportNomenclaturalGroupPK) object;
        if ((this.passportId == null && other.passportId != null) || (this.passportId != null && !this.passportId.equals(other.passportId))) {
            return false;
        }
        if ((this.nomenclaturalGroupId == null && other.nomenclaturalGroupId != null) || (this.nomenclaturalGroupId != null && !this.nomenclaturalGroupId.equals(other.nomenclaturalGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.PassportNomenclaturalGroupPK[passportId=" + passportId + ", nomenclaturalGroupId=" + nomenclaturalGroupId + "]";
    }

}