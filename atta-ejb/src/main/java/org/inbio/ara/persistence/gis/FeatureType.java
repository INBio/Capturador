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

package org.inbio.ara.persistence.gis;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "feature_type")

public class FeatureType extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "feature_type_id")
    private Long featureTypeId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "featureTypeId", fetch = FetchType.LAZY)
    private List<Site> siteCollection;

    public FeatureType() {
    }

    public FeatureType(Long featureTypeId) {
        this.featureTypeId = featureTypeId;
    }

    public Long getFeatureTypeId() {
        return featureTypeId;
    }

    public void setFeatureTypeId(Long featureTypeId) {
        this.featureTypeId = featureTypeId;
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

    public List<Site> getSiteCollection() {
        return siteCollection;
    }

    public void setSiteCollection(List<Site> siteCollection) {
        this.siteCollection = siteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (featureTypeId != null ? featureTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeatureType)) {
            return false;
        }
        FeatureType other = (FeatureType) object;
        if ((this.featureTypeId == null && other.featureTypeId != null) ||
                (this.featureTypeId != null && !this.featureTypeId.equals(other.featureTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.FeatureType[featureTypeId=" + featureTypeId + "]";
    }

}
