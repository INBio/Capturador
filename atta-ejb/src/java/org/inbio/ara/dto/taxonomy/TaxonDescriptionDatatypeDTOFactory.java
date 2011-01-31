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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionDatatype;

/**
 *
 * @author herson
 */
public class TaxonDescriptionDatatypeDTOFactory
        extends BaseEntityOrDTOFactory<TaxonDescriptionDatatype,
                                        TaxonDescriptionDatatypeDTO> {

    @Override
    public TaxonDescriptionDatatype
            getEntityWithPlainValues(TaxonDescriptionDatatypeDTO dto) {
        TaxonDescriptionDatatype result = new TaxonDescriptionDatatype();
        return updateEntityWithPlainValues(dto, result);
    }

    @Override
    public TaxonDescriptionDatatype
            updateEntityWithPlainValues(TaxonDescriptionDatatypeDTO dto,
                                        TaxonDescriptionDatatype e) {
        if(dto == null || e == null) return null;

        e.setTaxonDescriptionDatatypeId(dto.
                getTaxonDescriptionDatatypeId());
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        return e;
    }

    public TaxonDescriptionDatatypeDTO createDTO(TaxonDescriptionDatatype e) {
        if(e == null) return null;

        TaxonDescriptionDatatypeDTO result = new TaxonDescriptionDatatypeDTO();
        result.setTaxonDescriptionDatatypeId(e.getTaxonDescriptionDatatypeId());
        result.setDescription(e.getDescription());
        result.setName(e.getName());
        return result;
    }


}
