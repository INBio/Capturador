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

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author herson
 */
public class TaxonDescriptionCategoryDTO extends GenericDTO {

    public TaxonDescriptionCategoryDTO() { }

    private Long taxonDescriptionCategoryId;
    private String name;
    private String description;
    private Long ancestorId;
    private boolean repeatable;
    private boolean mandatory;
    private String standardConcept;

    public Long getAncestorId() {
        return ancestorId;
    }

    public void setAncestorId(Long ancestorId) {
        this.ancestorId = ancestorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    public String getStandardConcept() {
        return standardConcept;
    }

    public void setStandardConcept(String standardConcept) {
        this.standardConcept = standardConcept;
    }

    public Long getTaxonDescriptionCategoryId() {
        return taxonDescriptionCategoryId;
    }

    public void setTaxonDescriptionCategoryId(Long taxonDescriptionCategoryId) {
        this.taxonDescriptionCategoryId = taxonDescriptionCategoryId;
    }

    
}
