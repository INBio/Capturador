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
@Table(name = "geographic_catalogue")

public class GeographicCatalogue extends LogGenericEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "geographic_catalogue_id")
    private Long geographicCatalogueId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public GeographicCatalogue() {
    }

    public GeographicCatalogue(Long geographicCatalogueId) {
        this.geographicCatalogueId = geographicCatalogueId;
    }

    public GeographicCatalogue(Long geographicCatalogueId, String name) {
        this.geographicCatalogueId = geographicCatalogueId;
        this.name = name;
    }

    public Long getGeographicCatalogueId() {
        return geographicCatalogueId;
    }

    public void setGeographicCatalogueId(Long geographicCatalogueId) {
        this.geographicCatalogueId = geographicCatalogueId;
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
        hash += (geographicCatalogueId != null ? geographicCatalogueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeographicCatalogue)) {
            return false;
        }
        GeographicCatalogue other = (GeographicCatalogue) object;
        if ((this.geographicCatalogueId == null && other.geographicCatalogueId != null) || (this.geographicCatalogueId != null && !this.geographicCatalogueId.equals(other.geographicCatalogueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.GeographicCatalogue[geographicCatalogueId=" + geographicCatalogueId + "]";
    }

}
