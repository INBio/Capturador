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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionAudience;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionAudiencePK;

/**
 *
 * @author esmata
 */
public class TaxonDescriptionAudienceDTOFactory 
        extends BaseEntityOrDTOFactory<TaxonDescriptionAudience,TaxonDescriptionAudienceDTO>{

    @Override
    public TaxonDescriptionAudience getEntityWithPlainValues
            (TaxonDescriptionAudienceDTO dto) {
        if(dto==null){
            return null;
        }
        TaxonDescriptionAudiencePK pk = new TaxonDescriptionAudiencePK
                (dto.getTaxonId(), dto.getTaxonDescriptionSequence(), dto.getAudienceId());
        TaxonDescriptionAudience result = new TaxonDescriptionAudience(pk);
        return result;
    }

    @Override
    public TaxonDescriptionAudience updateEntityWithPlainValues
            (TaxonDescriptionAudienceDTO dto, TaxonDescriptionAudience e) {
        if(dto==null||e==null){
            return null;
        }
        e.getTaxonDescriptionAudiencePK().setAudienceId(dto.getAudienceId());
        e.getTaxonDescriptionAudiencePK().setTaxonDescriptionSequence
                (dto.getTaxonDescriptionSequence());
        e.getTaxonDescriptionAudiencePK().setTaxonId(dto.getTaxonId());
        return e;
    }

    public TaxonDescriptionAudienceDTO createDTO(TaxonDescriptionAudience entity) {
        if(entity==null){
            return null;
        }
        TaxonDescriptionAudienceDTO result = new TaxonDescriptionAudienceDTO();
        result.setAudienceId(entity.getTaxonDescriptionAudiencePK().getAudienceId());
        result.setTaxonDescriptionSequence
                (entity.getTaxonDescriptionAudiencePK().getTaxonDescriptionSequence());
        result.setTaxonId(entity.getTaxonDescriptionAudiencePK().getTaxonId());
        return result;
    }

}
