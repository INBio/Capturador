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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionStage;

/**
 *
 * @author esmata
 */
public class TaxonDescriptionStageDTOFactory extends
        BaseEntityOrDTOFactory<TaxonDescriptionStage,TaxonDescriptionStageDTO>{

    @Override
    public TaxonDescriptionStage getEntityWithPlainValues(TaxonDescriptionStageDTO dto) {
        if(dto==null){
            return null;
        }
        TaxonDescriptionStage result = new TaxonDescriptionStage();
        result.setTaxonDescriptionStageId(dto.getTaxonDescriptionStageId());
        result.setDescription(dto.getDescription());
        result.setName(dto.getName());
        return result;
    }

    @Override
    public TaxonDescriptionStage updateEntityWithPlainValues
            (TaxonDescriptionStageDTO dto, TaxonDescriptionStage e) {
        if(dto==null||e==null){
            return null;
        }
        e.setDescription(dto.getDescription());
        e.setName(dto.getName());
        e.setTaxonDescriptionStageId(dto.getTaxonDescriptionStageId());
        return e;
    }

    public TaxonDescriptionStageDTO createDTO(TaxonDescriptionStage entity) {
        if(entity==null){
            return null;
        }
        TaxonDescriptionStageDTO result = new TaxonDescriptionStageDTO();
        result.setDescription(entity.getDescription());
        result.setName(entity.getName());
        result.setTaxonDescriptionStageId(entity.getTaxonDescriptionStageId());
        return result;
    }

}
