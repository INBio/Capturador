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

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.Region;

/**
 *
 * @author esmata
 */
public class RegionDTOFactory
        extends BaseEntityOrDTOFactory<Region, RegionDTO> {

    @Override
    public Region getEntityWithPlainValues(RegionDTO dto) {
        if(dto==null){
            return null;
        }
        else{
            Region result = new Region();
            result.setDescription(dto.getDescription());
            result.setName(dto.getName());
            result.setRegionId(dto.getRegionId());
            return result;
        }
    }

    @Override
    public Region updateEntityWithPlainValues(RegionDTO dto, Region e) {
        if(dto==null||e==null){
            return null;
        }
        else{
            e.setDescription(dto.getDescription());
            e.setName(dto.getName());
            e.setRegionId(dto.getRegionId());
            return e;
        }
    }

    public RegionDTO createDTO(Region entity) {
        if(entity==null){
            return null;
        }
        else{
            RegionDTO result = new RegionDTO();
            result.setDescription(entity.getDescription());
            result.setName(entity.getName());
            result.setRegionId(entity.getRegionId());
            return result;
        }
    }

}
