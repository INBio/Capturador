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
import org.inbio.ara.persistence.taxonomy.InteractionType;

/**
 *
 * @author esmata
 */
public class InteractionTypeDTOFactory
        extends BaseEntityOrDTOFactory<InteractionType,InteractionTypeDTO> {

    @Override
    public InteractionType getEntityWithPlainValues(InteractionTypeDTO dto) {
        if(dto==null){
            return null;
        }
        InteractionType result = new InteractionType();
        result.setInteractionTypeId(dto.getInteractionTypeId());
        result.setName(dto.getName());
        result.setDescription(dto.getDescription());
        return result;
    }

    @Override
    public InteractionType updateEntityWithPlainValues
            (InteractionTypeDTO dto, InteractionType e) {
        if(dto==null||e==null){
            return null;
        }
        else{
            e.setInteractionTypeId(dto.getInteractionTypeId());
            e.setName(dto.getName());
            e.setDescription(dto.getDescription());
            return e;
        }
    }

    public InteractionTypeDTO createDTO(InteractionType entity) {
        if(entity==null){
            return null;
        }
        InteractionTypeDTO result = new InteractionTypeDTO();
        result.setInteractionTypeId(entity.getInteractionTypeId());
        result.setDescription(entity.getDescription());
        result.setName(entity.getName());
        return result;
    }
}
