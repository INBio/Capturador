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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "geographic_entity")

public class GeographicEntity extends LogGenericEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "geographic_entity_id")
    private Long geographicEntityId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public GeographicEntity() {
    }

    public GeographicEntity(Long geographicEntityId) {
        this.geographicEntityId = geographicEntityId;
    }

    public GeographicEntity(Long geographicEntityId, String name) {
        this.geographicEntityId = geographicEntityId;
        this.name = name;
    }

    public Long getGeographicEntityId() {
        return geographicEntityId;
    }

    public void setGeographicEntityId(Long geographicEntityId) {
        this.geographicEntityId = geographicEntityId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geographicEntityId != null ? geographicEntityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeographicEntity)) {
            return false;
        }
        GeographicEntity other = (GeographicEntity) object;
        if ((this.geographicEntityId == null && other.geographicEntityId != null) || (this.geographicEntityId != null && !this.geographicEntityId.equals(other.geographicEntityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.GeographicEntity[geographicEntityId=" + geographicEntityId + "]";
    }

}
