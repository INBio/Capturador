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
import org.inbio.ara.persistence.taxonomy.GeographicEntity;

/**
 *
 * @author esmata
 */
public class GeographicEntityDTOFactory 
        extends BaseEntityOrDTOFactory<GeographicEntity,GeographicEntityDTO>{

    @Override
    public GeographicEntity getEntityWithPlainValues(GeographicEntityDTO dto) {
        if(dto==null){
            return null;
        }
        GeographicEntity result = new GeographicEntity();
        result.setGeographicEntityId(dto.getGeographicEntityId());
        result.setDescription(dto.getDescription());
        result.setName(dto.getName());
        return result;
    }

    @Override
    public GeographicEntity updateEntityWithPlainValues
            (GeographicEntityDTO dto, GeographicEntity e) {
        if(dto==null||e==null){
            return null;
        }
        else{
            e.setGeographicEntityId(dto.getGeographicEntityId());
            e.setDescription(dto.getDescription());
            e.setName(dto.getName());
            return e;
        }
    }

    public GeographicEntityDTO createDTO(GeographicEntity entity) {
        if(entity==null){
            return null;
        }
        GeographicEntityDTO result = new GeographicEntityDTO();
        result.setGeographicEntityId(entity.getGeographicEntityId());
        result.setDescription(entity.getDescription());
        result.setName(entity.getName());
        return result;
    }

}
