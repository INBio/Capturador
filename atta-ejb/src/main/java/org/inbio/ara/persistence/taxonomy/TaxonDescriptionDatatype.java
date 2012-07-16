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

import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "taxon_description_datatype")
public class TaxonDescriptionDatatype extends LogGenericEntity  {

    @Id
    @Basic(optional = false)
    @Column(name = "taxon_description_datatype_id")
    private Long taxonDescriptionDatatypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    

    @OneToMany(mappedBy = "taxonDescriptionDatatypeId", fetch = FetchType.LAZY)
    private Set<TaxonDescriptionElement> taxonDescriptionElementCollection;

    public TaxonDescriptionDatatype() {
    }

    public TaxonDescriptionDatatype(Long taxonDescriptionDatatypeId) {
        this.taxonDescriptionDatatypeId = taxonDescriptionDatatypeId;
    }

    public Long getTaxonDescriptionDatatypeId() {
        return taxonDescriptionDatatypeId;
    }

    public void setTaxonDescriptionDatatypeId(Long taxonDescriptionDatatypeId) {
        this.taxonDescriptionDatatypeId = taxonDescriptionDatatypeId;
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
    
    public Set<TaxonDescriptionElement>
            getTaxonDescriptionElementCollection() {
        return taxonDescriptionElementCollection;
    }

    public void setTaxonDescriptionElementCollection(
            Set<TaxonDescriptionElement> taxonDescriptionElementCollection) {
        this.taxonDescriptionElementCollection =
                taxonDescriptionElementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonDescriptionDatatypeId != null ?
            taxonDescriptionDatatypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionDatatype)) {
            return false;
        }
        TaxonDescriptionDatatype other = (TaxonDescriptionDatatype) object;
        if ((this.taxonDescriptionDatatypeId == null && 
                other.taxonDescriptionDatatypeId != null) ||
                (this.taxonDescriptionDatatypeId != null &&
                !this.taxonDescriptionDatatypeId.equals(
                other.taxonDescriptionDatatypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionDatatype[" +
                "taxonDescriptionDatatypeId=" + taxonDescriptionDatatypeId +"]";
    }

}
