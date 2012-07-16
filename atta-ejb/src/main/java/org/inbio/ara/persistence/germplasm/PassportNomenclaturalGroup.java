/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "passport_nomenclatural_group")
public class PassportNomenclaturalGroup extends LogGenericEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PassportNomenclaturalGroupPK passportNomenclaturalGroupPK;



    public PassportNomenclaturalGroup() {
    }

    public PassportNomenclaturalGroup(PassportNomenclaturalGroupPK passportNomenclaturalGroupPK) {
        this.passportNomenclaturalGroupPK = passportNomenclaturalGroupPK;
    }

    public PassportNomenclaturalGroup(PassportNomenclaturalGroupPK passportNomenclaturalGroupPK, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.passportNomenclaturalGroupPK = passportNomenclaturalGroupPK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public PassportNomenclaturalGroup(Long passportId, Long nomenclaturalGroupId) {
        this.passportNomenclaturalGroupPK = new PassportNomenclaturalGroupPK(passportId, nomenclaturalGroupId);
    }

    public PassportNomenclaturalGroupPK getPassportNomenclaturalGroupPK() {
        return passportNomenclaturalGroupPK;
    }

    public void setPassportNomenclaturalGroupPK(PassportNomenclaturalGroupPK passportNomenclaturalGroupPK) {
        this.passportNomenclaturalGroupPK = passportNomenclaturalGroupPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passportNomenclaturalGroupPK != null ? passportNomenclaturalGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PassportNomenclaturalGroup)) {
            return false;
        }
        PassportNomenclaturalGroup other = (PassportNomenclaturalGroup) object;
        if ((this.passportNomenclaturalGroupPK == null && other.passportNomenclaturalGroupPK != null) || (this.passportNomenclaturalGroupPK != null && !this.passportNomenclaturalGroupPK.equals(other.passportNomenclaturalGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.PassportNomenclaturalGroup[passportNomenclaturalGroupPK=" + passportNomenclaturalGroupPK + "]";
    }

}