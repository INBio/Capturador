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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionElement;

/**
 *
 * @author herson
 */
public class TaxonDescriptionElementDTOFactory
        extends BaseEntityOrDTOFactory<TaxonDescriptionElement,
        TaxonDescriptionElementDTO> {

    @Override
    public TaxonDescriptionElement
            getEntityWithPlainValues(TaxonDescriptionElementDTO dto) {
        if(dto == null) return null;

        TaxonDescriptionElement result = new TaxonDescriptionElement();
        result.setTaxonDescriptionElementId(dto.getTaxonDescriptionElementId());
        result.setName(dto.getName());
        result.setDescription(dto.getDescription());
        result.setTableName(dto.getTableName());
        result.setTaxonDescriptionCategoryId(dto.
                getTaxonDescriptionCategoryId());
        result.setTaxonDescriptionDatatypeId(dto.
                getTaxonDescriptionDatatypeId());
        result.setMainFieldName(dto.getMainFieldName());
        result.setKeyField(dto.getKeyField());
        return result;
    }

    @Override
    public TaxonDescriptionElement
            updateEntityWithPlainValues(TaxonDescriptionElementDTO dto,
            TaxonDescriptionElement e) {
        if(dto == null || e == null)  return null;        
        
        e.setTaxonDescriptionElementId(dto.getTaxonDescriptionElementId());
        e.setDescription(dto.getDescription());
        e.setName(dto.getName());
        e.setTableName(dto.getTableName());
        e.setTaxonDescriptionCategoryId(dto.getTaxonDescriptionCategoryId());
        e.setTaxonDescriptionDatatypeId(dto.getTaxonDescriptionDatatypeId());
        e.setMainFieldName(dto.getMainFieldName());
        e.setKeyField(dto.getKeyField());
        return e;
    }

    public TaxonDescriptionElementDTO
            createDTO(TaxonDescriptionElement entity) {
        if(entity == null) return null;

        TaxonDescriptionElementDTO dto = new TaxonDescriptionElementDTO();
        dto.setTaxonDescriptionElementId(entity.getTaxonDescriptionElementId());
        dto.setDescription(entity.getDescription());
        dto.setName(entity.getName());
        dto.setTableName(entity.getTableName());
        dto.setTaxonDescriptionCategoryId(entity.
                getTaxonDescriptionCategoryId());
        dto.setTaxonDescriptionDatatypeId(entity.
                getTaxonDescriptionDatatypeId());
        dto.setMainFieldName(entity.getMainFieldName());
        dto.setKeyField(entity.getKeyField());
        return dto;
    }

}
