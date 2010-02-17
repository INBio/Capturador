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
@Table(name = "taxon_category")

public class TaxonCategory extends GenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "taxon_category_id")
    private Long taxonCategoryId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxonCategoryId", fetch = FetchType.LAZY)
    private List<Taxon> taxonCollection;

    public TaxonCategory() {
    }

    public TaxonCategory(Long taxonCategoryId) {
        this.taxonCategoryId = taxonCategoryId;
    }

    public TaxonCategory(Long taxonCategoryId, String name) {
        this.taxonCategoryId = taxonCategoryId;
        this.name = name;
    }

    public Long getTaxonCategoryId() {
        return taxonCategoryId;
    }

    public void setTaxonCategoryId(Long taxonCategoryId) {
        this.taxonCategoryId = taxonCategoryId;
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

    public List<Taxon> getTaxonCollection() {
        return taxonCollection;
    }

    public void setTaxonCollection(List<Taxon> taxonCollection) {
        this.taxonCollection = taxonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonCategoryId != null ? taxonCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonCategory)) {
            return false;
        }
        TaxonCategory other = (TaxonCategory) object;
        if ((this.taxonCategoryId == null && other.taxonCategoryId != null) || (this.taxonCategoryId != null && !this.taxonCategoryId.equals(other.taxonCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonCategory[taxonCategoryId=" + taxonCategoryId + "]";
    }

}
