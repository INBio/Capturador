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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecord;

/**
 *
 * @author herson
 */
public class TaxonDescriptionRecordDTOFactory
        extends BaseEntityOrDTOFactory<TaxonDescriptionRecord,
                    TaxonDescriptionRecordDTO>{

    @Override
    public TaxonDescriptionRecord
            getEntityWithPlainValues(TaxonDescriptionRecordDTO dto) {
        TaxonDescriptionRecord result = new TaxonDescriptionRecord();        
        return updateEntityWithPlainValues(dto, result);
    }

    @Override
    public TaxonDescriptionRecord
            updateEntityWithPlainValues(TaxonDescriptionRecordDTO dto,
            TaxonDescriptionRecord e) {
        if(dto == null || e == null) return null;

        e.setTaxonDescriptionRecordId(dto.getTaxonDescriptionRecordId());
        e.setSequence(dto.getSequence());
        e.setContentsText(dto.getContentsText());
        e.setContentsNumeric(dto.getContentsNumeric());
        e.setTaxonDescriptionElementId(dto.getTaxonDescriptionElementId());
        e.setTaxonomicalTimestamp(dto.getTaxonomicalTimestamp());
        return e;
    }

    public TaxonDescriptionRecordDTO createDTO(TaxonDescriptionRecord e) {
        if(e == null) return null;

        TaxonDescriptionRecordDTO result = new TaxonDescriptionRecordDTO();
        result.setTaxonDescriptionRecordId(e.getTaxonDescriptionRecordId());
        result.setSequence(e.getSequence());
        result.setContentsText(e.getContentsText());
        result.setContentsNumeric(e.getContentsNumeric());
        result.setTaxonDescriptionElementId(e.getTaxonDescriptionElementId());
        result.setTaxonomicalTimestamp(e.getTaxonomicalTimestamp());
        return result;
    }


}
