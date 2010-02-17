/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2010  INBio (Instituto Nacional de Biodiversidad).
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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "nomenclatural_group_region")
public class NomenclaturalGroupRegion extends LogGenericEntity {

    @EmbeddedId
    protected NomenclaturalGroupRegionPK nomenclaturalGroupRegionPK;

    @Basic(optional = false)
    @Column(name = "sequence")
    private int sequence;

//    @JoinColumn(name = "nomenclatural_group_id", referencedColumnName = "nomenclatural_group_id", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private NomenclaturalGroup nomenclaturalGroup;
//    @Basic(optional = false)
//    @Column(name = "nomenclatural_group_id", updatable=false)
//    private Long nomenclaturalGroupId;

//    @JoinColumn(name = "region_id", referencedColumnName = "region_id", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Region region;
//    @Basic(optional = false)
//    @Column(name = "region_id", updatable=false)
//    private Long regionId;

    public NomenclaturalGroupRegion() {
    }

    public NomenclaturalGroupRegion(NomenclaturalGroupRegionPK
            nomenclaturalGroupRegionPK) {
        this.nomenclaturalGroupRegionPK = nomenclaturalGroupRegionPK;
    }

    public NomenclaturalGroupRegion(NomenclaturalGroupRegionPK 
            nomenclaturalGroupRegionPK, int sequence) {
        this.nomenclaturalGroupRegionPK = nomenclaturalGroupRegionPK;
        this.sequence = sequence;
    }

    public NomenclaturalGroupRegion(Long nomenclaturalGroupId, Long regionId) {
        this.nomenclaturalGroupRegionPK = new NomenclaturalGroupRegionPK(
                nomenclaturalGroupId, regionId);
    }

    public NomenclaturalGroupRegionPK getNomenclaturalGroupRegionPK() {
        return nomenclaturalGroupRegionPK;
    }

    public void setNomenclaturalGroupRegionPK(NomenclaturalGroupRegionPK
            nomenclaturalGroupRegionPK) {
        this.nomenclaturalGroupRegionPK = nomenclaturalGroupRegionPK;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomenclaturalGroupRegionPK != null ?
            nomenclaturalGroupRegionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof NomenclaturalGroupRegion)) {
            return false;
        }
        NomenclaturalGroupRegion other = (NomenclaturalGroupRegion) object;
        if ((this.nomenclaturalGroupRegionPK == null && 
                other.nomenclaturalGroupRegionPK != null) ||
                (this.nomenclaturalGroupRegionPK != null &&
                !this.nomenclaturalGroupRegionPK.equals(other.
                nomenclaturalGroupRegionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.NomenclaturalGroupRegion" +
                "[nomenclaturalGroupRegionPK=" + nomenclaturalGroupRegionPK +
                "]";
    }
}
