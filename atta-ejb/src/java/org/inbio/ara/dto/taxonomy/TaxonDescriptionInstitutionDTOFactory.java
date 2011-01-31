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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionInstitution;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionInstitutionPK;

/**
 *
 * @author esmata
 */
public class TaxonDescriptionInstitutionDTOFactory 
        extends BaseEntityOrDTOFactory<TaxonDescriptionInstitution,TaxonDescriptionInstitutionDTO>{

    @Override
    public TaxonDescriptionInstitution getEntityWithPlainValues
            (TaxonDescriptionInstitutionDTO dto) {
        if(dto==null){
            return null;
        }
        TaxonDescriptionInstitutionPK pk = new TaxonDescriptionInstitutionPK
                (dto.getTaxonId(), dto.getTaxonDescriptionSequence(), dto.getInstitutionId());
        TaxonDescriptionInstitution result = new TaxonDescriptionInstitution(pk);
        result.setSequence(dto.getSequence());
        result.setDescription(dto.getDescription());
        return result;
    }

    @Override
    public TaxonDescriptionInstitution updateEntityWithPlainValues
            (TaxonDescriptionInstitutionDTO dto, TaxonDescriptionInstitution e) {
        if(dto==null||e==null){
            return null;
        }
        e.setDescription(dto.getDescription());
        e.setSequence(dto.getSequence());
        e.getTaxonDescriptionInstitutionPK().setInstitutionId(dto.getInstitutionId());
        e.getTaxonDescriptionInstitutionPK().setTaxonDescriptionSequence
                (dto.getTaxonDescriptionSequence());
        e.getTaxonDescriptionInstitutionPK().setTaxonId(dto.getTaxonId());
        return e;
    }

    public TaxonDescriptionInstitutionDTO createDTO(TaxonDescriptionInstitution entity) {
        if(entity==null){
            return null;
        }
        TaxonDescriptionInstitutionDTO result = new TaxonDescriptionInstitutionDTO();
        result.setDescription(entity.getDescription());
        result.setInstitutionId(entity.getTaxonDescriptionInstitutionPK().getInstitutionId());
        result.setSequence(entity.getSequence());
        result.setTaxonDescriptionSequence
                (entity.getTaxonDescriptionInstitutionPK().getTaxonDescriptionSequence());
        result.setTaxonId(entity.getTaxonDescriptionInstitutionPK().getTaxonId());
        return result;
    }

}
