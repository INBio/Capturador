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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "region")
public class Region extends LogGenericEntity {
    
    @Id
    @Basic(optional = false)
    @Column(name = "region_id")
    private Long regionId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regionId")
//    private List<NomenclaturalGroupRegion> nomenclaturalGroupRegionList;

    public Region() {
    }

    public Region(Long regionId) {
        this.regionId = regionId;
    }

    public Region(Long regionId, String name) {
        this.regionId = regionId;
        this.name = name;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<NomenclaturalGroupRegion> getNomenclaturalGroupRegionList() {
//        return nomenclaturalGroupRegionList;
//    }
//
//    public void setNomenclaturalGroupRegionList(List<NomenclaturalGroupRegion>
//            nomenclaturalGroupRegionList) {
//        this.nomenclaturalGroupRegionList = nomenclaturalGroupRegionList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionId != null ? regionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.regionId == null && other.regionId != null) || 
                (this.regionId != null &&
                    !this.regionId.equals(other.regionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.Region[regionId=" +
                regionId + "]";
    }

}
