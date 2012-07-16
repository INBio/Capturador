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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecordReference;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecordReferencePK;

/**
 *
 * @author esmata
 */
public class TaxonDescriptionRecordReferenceDTOFactory
        extends BaseEntityOrDTOFactory<TaxonDescriptionRecordReference,
        TaxonDescriptionRecordReferenceDTO> {

    @Override
    public TaxonDescriptionRecordReference getEntityWithPlainValues
            (TaxonDescriptionRecordReferenceDTO dto) {
        if(dto==null){
            return null;
        }
        TaxonDescriptionRecordReferencePK pk = new TaxonDescriptionRecordReferencePK();
        pk.setReferenceId(dto.getReferenceId());
        pk.setTaxonDescriptionRecordId(dto.getTaxonDescriptionRecordId());
        TaxonDescriptionRecordReference result = new TaxonDescriptionRecordReference(pk);
        return result;
    }

    @Override
    public TaxonDescriptionRecordReference updateEntityWithPlainValues
            (TaxonDescriptionRecordReferenceDTO dto, TaxonDescriptionRecordReference e) {
        if(dto==null||e==null){
            return null;
        }
        else{
            e.getTaxonDescriptionRecordReferencePK().setReferenceId
                    (dto.getReferenceId());
            e.getTaxonDescriptionRecordReferencePK().setTaxonDescriptionRecordId
                    (dto.getTaxonDescriptionRecordId());
            return e;
        }
    }

    public TaxonDescriptionRecordReferenceDTO createDTO
            (TaxonDescriptionRecordReference entity) {
        if(entity==null){
            return null;
        }
        TaxonDescriptionRecordReferenceDTO result = new TaxonDescriptionRecordReferenceDTO();
        result.setReferenceId
                (entity.getTaxonDescriptionRecordReferencePK().getReferenceId());
        result.setTaxonDescriptionRecordId
                (entity.getTaxonDescriptionRecordReferencePK().getTaxonDescriptionRecordId());
        return result;
    }

}
