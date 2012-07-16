/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author herson
 */
@Embeddable
public class NomenclaturalGroupRegionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "nomenclatural_group_id")
    private Long nomenclaturalGroupId;

    @Basic(optional = false)
    @Column(name = "region_id")
    private Long regionId;

    public NomenclaturalGroupRegionPK() {
    }

    public NomenclaturalGroupRegionPK(Long nomenclaturalGroupId, Long regionId){
        this.nomenclaturalGroupId = nomenclaturalGroupId;
        this.regionId = regionId;
    }

    public Long getNomenclaturalGroupId() {
        return nomenclaturalGroupId;
    }

    public void setNomenclaturalGroupId(Long nomenclaturalGroupId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomenclaturalGroupId != null ? nomenclaturalGroupId.hashCode()
                : 0);
        hash += (regionId != null ? regionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof NomenclaturalGroupRegionPK)) {
            return false;
        }
        NomenclaturalGroupRegionPK other = (NomenclaturalGroupRegionPK) object;
        if ((this.nomenclaturalGroupId == null && other.nomenclaturalGroupId != 
                null) || (this.nomenclaturalGroupId != null &&
                !nomenclaturalGroupId.equals(other.nomenclaturalGroupId))) {
            return false;
        }
        if ((this.regionId == null && other.regionId != null) || 
                (this.regionId != null &&
                !this.regionId.equals(other.regionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.NomenclaturalGroupRegionPK" +
                "[nomenclaturalGroupId=" + nomenclaturalGroupId +
                ", regionId=" + regionId + "]";
    }

}
