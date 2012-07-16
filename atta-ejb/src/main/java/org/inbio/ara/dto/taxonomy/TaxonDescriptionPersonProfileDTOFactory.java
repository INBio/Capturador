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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPersonProfile;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPersonProfilePK;

/**
 *
 * @author esmata
 */
public class TaxonDescriptionPersonProfileDTOFactory 
        extends BaseEntityOrDTOFactory<TaxonDescriptionPersonProfile,TaxonDescriptionPersonProfileDTO>{

    @Override
    public TaxonDescriptionPersonProfile getEntityWithPlainValues
            (TaxonDescriptionPersonProfileDTO dto) {
        if(dto==null){
            return null;
        }
        TaxonDescriptionPersonProfilePK pk = new TaxonDescriptionPersonProfilePK
                (dto.getTaxonId(),dto.getTaxonDescriptionSequence(),dto.getPersonId(),dto.getProfileId());
        TaxonDescriptionPersonProfile result = new TaxonDescriptionPersonProfile(pk);
        result.setSequence(dto.getSequence());
        return result;
    }

    @Override
    public TaxonDescriptionPersonProfile updateEntityWithPlainValues
            (TaxonDescriptionPersonProfileDTO dto, TaxonDescriptionPersonProfile e) {
        if(dto==null||e==null){
            return null;
        }
        e.setSequence(dto.getSequence());
        e.getTaxonDescriptionPersonProfilePK().setPersonId(dto.getPersonId());
        e.getTaxonDescriptionPersonProfilePK().setProfileId(dto.getProfileId());
        e.getTaxonDescriptionPersonProfilePK().setTaxonDescriptionSequence
                (dto.getTaxonDescriptionSequence());
        e.getTaxonDescriptionPersonProfilePK().setTaxonId(dto.getTaxonId());
        return e;
    }

    public TaxonDescriptionPersonProfileDTO createDTO(TaxonDescriptionPersonProfile entity) {
        if(entity==null){
            return null;
        }
        TaxonDescriptionPersonProfileDTO result = new TaxonDescriptionPersonProfileDTO();
        result.setPersonId(entity.getTaxonDescriptionPersonProfilePK().getPersonId());
        result.setProfileId(entity.getTaxonDescriptionPersonProfilePK().getProfileId());
        result.setSequence(entity.getSequence());
        result.setTaxonDescriptionSequence
                (entity.getTaxonDescriptionPersonProfilePK().getTaxonDescriptionSequence());
        result.setTaxonId(entity.getTaxonDescriptionPersonProfilePK().getTaxonId());
        return result;


    }

}
