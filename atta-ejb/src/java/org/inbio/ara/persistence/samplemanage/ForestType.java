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
@Table(name = "forest_type")
public class ForestType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="forest_type")
    @SequenceGenerator(name="forest_type", sequenceName="forest_type_seq")
    @Basic(optional = false)
    @Column(name = "forest_type_id")
    private Long forestTypeId;


    public ForestType() {
    }

    public ForestType(Long forestTypeId) {
        this.forestTypeId = forestTypeId;
    }

    public ForestType(Long forestTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.forestTypeId = forestTypeId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getForestTypeId() {
        return forestTypeId;
    }

    public void setForestTypeId(Long forestTypeId) {
        this.forestTypeId = forestTypeId;
    }

    

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forestTypeId != null ? forestTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForestType)) {
            return false;
        }
        ForestType other = (ForestType) object;
        if ((this.forestTypeId == null && other.forestTypeId != null) || (this.forestTypeId != null && !this.forestTypeId.equals(other.forestTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.ForestType[forestTypeId=" + forestTypeId + "]";
    }

    @Override
    public Long getId() {
        return this.forestTypeId;
    }

    @Override
    public void setId(Long id) {
        this.forestTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.FOREST_TYPE;
    }

}
