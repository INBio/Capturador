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

import java.util.GregorianCalendar;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.label.Label;

/**
 *
 * @author pcorrales
 */
public class LabelDTOFactory extends BaseEntityOrDTOFactory<Label,LabelDTO>
 {

    @Override
    public Label getEntityWithPlainValues(LabelDTO dto) {

        if(dto == null) return null;

        Label result = new Label();
        result.setLabelId(dto.getLabelId());
        result.setContents(dto.getContents());
        result.setInitialDate(new GregorianCalendar());
        result.setLabelTypeId(dto.getLabelTypeId());
        result.setCreatedBy(dto.getUserName());
        result.setLastModificationDate(new GregorianCalendar());
        result.setAncestorLabelId(dto.getAncestorLabelId());
        return result;
    }

    @Override
    public Label updateEntityWithPlainValues(LabelDTO dto, Label e) {

        if(dto == null || e == null) return null;

        e.setLabelId(dto.getLabelId());
        e.setContents(dto.getContents());
        e.setInitialDate(dto.getInitialTimestand());
        e.setLastModificationBy(dto.getUserName());
        e.setLastModificationDate(new GregorianCalendar());
        e.setLabelTypeId(dto.getLabelTypeId());
        e.setAncestorLabelId(dto.getAncestorLabelId());
        return e;
    }


    /**
     * create the LabelDTO with the information of entity label
     * @param entity
     * @return
     */
    public LabelDTO createDTO(Label entity) {

        
        if(entity == null) return null;

        LabelDTO result = new LabelDTO();
        result.setLabelId(entity.getLabelId());
        result.setContents(entity.getContents());
        result.setInitialTimestand(entity.getInitialDate());
        result.setLabelTypeId(entity.getLabelTypeId());
        result.setSelected(false); //Initially must be false
        result.setFinalTimestand(entity.getLastModificationDate());
        result.setAncestorLabelId(entity.getAncestorLabelId());
        result.setUserName(entity.getCreatedBy());
        return result;
    }

}