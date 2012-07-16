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

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPK;

/**
 *
 * @author esmata
 */
public class TaxonDescriptionDTOFactory extends BaseEntityOrDTOFactory<TaxonDescription,TaxonDescriptionDTO> {

    @Override
    public TaxonDescription getEntityWithPlainValues(TaxonDescriptionDTO dto) {
        if(dto==null){
            return null;
        }
        TaxonDescriptionPK pk = new TaxonDescriptionPK
                (dto.getTaxonId(), dto.getTaxonDescriptionSequence());
        TaxonDescription result = new TaxonDescription(pk);
        result.setUrl(dto.getUrl());
        result.setTitle(dto.getTitle());
        result.setLanguageId(dto.getLanguageId());
        result.setTaxonDescriptionStageId(dto.getTaxonDescriptionStageId());
        result.setInstitutionId(dto.getInstitutionId());
        return result;
    }

    @Override
    public TaxonDescription updateEntityWithPlainValues(TaxonDescriptionDTO dto, TaxonDescription e) {
        if(dto==null||e==null){
            return null;
        }
        else{
            e.getTaxonDescriptionPK().setTaxonId(dto.getTaxonId());
            e.getTaxonDescriptionPK().setTaxonDescriptionSequence
                    (dto.getTaxonDescriptionSequence());
            e.setUrl(dto.getUrl());
            e.setTitle(dto.getTitle());
            e.setLanguageId(dto.getLanguageId());
            e.setTaxonDescriptionStageId(dto.getTaxonDescriptionStageId());
            e.setInstitutionId(dto.getInstitutionId());
            return e;
        }
    }

    public TaxonDescriptionDTO createDTO(TaxonDescription entity) {
        if(entity==null){
            return null;
        }
        TaxonDescriptionDTO dto = new TaxonDescriptionDTO();

        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreationDate(entity.getCreationDate());
        dto.setFamilyId(entity.getTaxon().getFamilyTaxonId());
        dto.setKingdomId(entity.getTaxon().getKingdomTaxonId());
        dto.setLanguageId(entity.getLanguageId());
        dto.setSelected(false); //Inicialmente debe ser false
        dto.setTaxonDefaultName(entity.getTaxon().getDefaultName());
        dto.setTaxonDescriptionSequence
                (entity.getTaxonDescriptionPK().getTaxonDescriptionSequence());
        dto.setTaxonDescriptionStageId(entity.getTaxonDescriptionStageId());
        dto.setTaxonId(entity.getTaxon().getTaxonId());
        dto.setTitle(entity.getTitle());
        dto.setUrl(entity.getUrl());
        dto.setInstitutionId(entity.getInstitutionId());
        return dto;
    }

}
