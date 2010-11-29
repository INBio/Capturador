/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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


package org.inbio.ara.dto.label;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.label.OriginalLabel;

/**
 *
 * @author pcorrales
 */
public class OriginalLabelDTOFactory  extends BaseEntityOrDTOFactory<OriginalLabel,OriginalLabelDTO>{

    @Override
    public OriginalLabel getEntityWithPlainValues(OriginalLabelDTO dto) {
         if(dto == null) return null;

        OriginalLabel result = new OriginalLabel();
        result.setOriginalLabelId(dto.getOriginalLabelID());
        result.setContents(dto.getContents());
        return result;
    }

    @Override
    public OriginalLabel updateEntityWithPlainValues(OriginalLabelDTO dto, OriginalLabel e) {
        if(dto == null || e == null) return null;

        e.setOriginalLabelId(dto.getOriginalLabelID());
        e.setContents(dto.getContents());
        return e;
    }

    /**
     *  create the OriginalLabelDTO with the information of entity Originallabel
     * @param entity
     * @return
     */
    public OriginalLabelDTO createDTO(OriginalLabel entity) {
        if(entity == null) return null;

        OriginalLabelDTO result = new OriginalLabelDTO();
        result.setOriginalLabelID(entity.getOriginalLabelId());
        result.setContents(entity.getContents());
        result.setSelected(false); //Initially must be false
        return result;
    }
}