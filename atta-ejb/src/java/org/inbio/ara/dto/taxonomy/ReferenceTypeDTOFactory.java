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
import org.inbio.ara.persistence.taxonomy.ReferenceType;

/**
 *
 * @author esmata
 */
public class ReferenceTypeDTOFactory extends BaseEntityOrDTOFactory<ReferenceType,ReferenceTypeDTO>{

    @Override
    public ReferenceType getEntityWithPlainValues(ReferenceTypeDTO dto) {
        if(dto==null){
            return null;
        }
        ReferenceType result = new ReferenceType();
        result.setReferenceTypeId(dto.getReferenceTypeId());
        result.setDescription(dto.getDescription());
        result.setName(dto.getName());
        return result;
    }

    @Override
    public ReferenceType updateEntityWithPlainValues
            (ReferenceTypeDTO dto, ReferenceType e) {
        if(dto==null||e==null){
            return null;
        }
        else{
            e.setReferenceTypeId(dto.getReferenceTypeId());
            e.setName(dto.getName());
            e.setDescription(dto.getDescription());
            return e;
        }
    }

    public ReferenceTypeDTO createDTO(ReferenceType entity) {
        if(entity==null){
            return null;
        }
        ReferenceTypeDTO result = new ReferenceTypeDTO();
        result.setDescription(entity.getDescription());
        result.setName(entity.getName());
        result.setReferenceTypeId(entity.getReferenceTypeId());
        return result;
    }

}
