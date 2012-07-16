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

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionCategory;

/**
 *
 * @author herson
 */
public class TaxonDescriptionCategoryDTOFactory
        extends BaseEntityOrDTOFactory<TaxonDescriptionCategory,
        TaxonDescriptionCategoryDTO> {

    @Override
    public TaxonDescriptionCategory
            getEntityWithPlainValues(TaxonDescriptionCategoryDTO dto) {
        if(dto == null) return null;

        TaxonDescriptionCategory result = new TaxonDescriptionCategory();
        result.setTaxonDescriptionCategoryId(dto.
                getTaxonDescriptionCategoryId());
        result.setName(dto.getName());
        result.setDescription(dto.getDescription());
        result.setAncestorId(dto.getAncestorId());
        result.setRepeatable(dto.isRepeatable());
        result.setMandatory(dto.isMandatory());
        result.setStandardConcept(dto.getStandardConcept());
        return result;
    }

    @Override
    public TaxonDescriptionCategory 
            updateEntityWithPlainValues(TaxonDescriptionCategoryDTO dto,
            TaxonDescriptionCategory e) {
        if(dto == null || e == null) return null;

        e.setTaxonDescriptionCategoryId(dto.getTaxonDescriptionCategoryId());
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setAncestorId(dto.getAncestorId());
        e.setRepeatable(dto.isRepeatable());
        e.setMandatory(dto.isMandatory());
        e.setStandardConcept(dto.getStandardConcept());
        return e;
    }

    public TaxonDescriptionCategoryDTO
            createDTO(TaxonDescriptionCategory e) {
        if(e == null) return null;

        TaxonDescriptionCategoryDTO dto = new TaxonDescriptionCategoryDTO();
        dto.setTaxonDescriptionCategoryId(e.getTaxonDescriptionCategoryId());
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        dto.setAncestorId(e.getAncestorId());
        dto.setRepeatable(e.isRepeatable());
        dto.setMandatory(e.isMandatory());
        dto.setStandardConcept(e.getStandardConcept());
        return dto;
    }

}
