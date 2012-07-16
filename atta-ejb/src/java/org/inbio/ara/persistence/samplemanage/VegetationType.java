/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.persistence.samplemanage;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "vegetation_type")
public class VegetationType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="vegetation_type")
    @SequenceGenerator(name="vegetation_type", sequenceName="vegetation_type_seq")
    @Basic(optional = false)
    @Column(name = "vegetation_type_id")
    private Long vegetationTypeId;
    

    public VegetationType() {
    }

    public VegetationType(Long vegetationTypeId) {
        this.vegetationTypeId = vegetationTypeId;
    }

    public VegetationType(Long vegetationTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.vegetationTypeId = vegetationTypeId;
        this.setName(name);;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getVegetationTypeId() {
        return vegetationTypeId;
    }

    public void setVegetationTypeId(Long vegetationTypeId) {
        this.vegetationTypeId = vegetationTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vegetationTypeId != null ? vegetationTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VegetationType)) {
            return false;
        }
        VegetationType other = (VegetationType) object;
        if ((this.vegetationTypeId == null && other.vegetationTypeId != null) || (this.vegetationTypeId != null && !this.vegetationTypeId.equals(other.vegetationTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.VegetationType[vegetationTypeId=" + vegetationTypeId + "]";
    }

    @Override
    public Long getId() {
        return this.vegetationTypeId;
    }

    @Override
    public void setId(Long id) {
        this.vegetationTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.VEGETATION_TYPE;
    }

}
