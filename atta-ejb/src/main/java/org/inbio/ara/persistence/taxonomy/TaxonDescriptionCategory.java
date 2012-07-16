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
@Table(name = "taxon_description_category")
public class TaxonDescriptionCategory extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "taxon_description_category_id")
    private Long taxonDescriptionCategoryId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "sequence")
    private int sequence;

    @Column(name = "ancestor_id")
    private Long ancestorId;

    @Column(name = "repeatable")
    private boolean repeatable;

    @Column(name = "mandatory")
    private boolean mandatory;

    @Column(name = "standard_concept")
    private String standardConcept;

    @OneToMany(mappedBy = "taxonDescriptionCategoryId", fetch = FetchType.LAZY)
    private Set<TaxonDescriptionElement> taxonDescriptionElements;

    
    public TaxonDescriptionCategory() {
    }

    public TaxonDescriptionCategory(Long taxonDescriptionCategoryId) {
        this.taxonDescriptionCategoryId = taxonDescriptionCategoryId;
    }

    public TaxonDescriptionCategory(Long taxonDescriptionCategoryId,
            String name) {
        this.taxonDescriptionCategoryId = taxonDescriptionCategoryId;
        this.name = name;
    }

    public Long getTaxonDescriptionCategoryId() {
        return taxonDescriptionCategoryId;
    }

    public void setTaxonDescriptionCategoryId(Long taxonDescriptionCategoryId) {
        this.taxonDescriptionCategoryId = taxonDescriptionCategoryId;
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

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Long getAncestorId() {
        return ancestorId;
    }

    public void setAncestorId(Long ancestorId) {
        this.ancestorId = ancestorId;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getStandardConcept() {
        return standardConcept;
    }

    public void setStandardConcept(String standardConcept) {
        this.standardConcept = standardConcept;
    }
    
    public Set<TaxonDescriptionElement>
            getTaxonDescriptionElementCollection() {
        return taxonDescriptionElements;
    }

    public void setTaxonDescriptionElementCollection(
        Set<TaxonDescriptionElement> taxonDescriptionElementCollection) {
        this.taxonDescriptionElements = taxonDescriptionElementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonDescriptionCategoryId != null ?
            taxonDescriptionCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionCategory)) {
            return false;
        }
        TaxonDescriptionCategory other = (TaxonDescriptionCategory) object;
        if ((this.taxonDescriptionCategoryId == null && 
                other.taxonDescriptionCategoryId != null) ||
                (this.taxonDescriptionCategoryId != null &&
                !this.taxonDescriptionCategoryId.equals(other.
                taxonDescriptionCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionCategory[" +
                "taxonDescriptionCategoryId=" +taxonDescriptionCategoryId + "]";
    }

}
