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

package org.inbio.ara.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author jgutierrez
 *
 * Based on dmartin code, in the GBIF customizable portal.
 */
public abstract class BaseDTOFactory <Entity extends GenericEntity, DTO extends Object> implements DTOFactory  <Entity,DTO>{


    /**
     *
     * @param entitiesList
     * @return
     */
	public List<DTO> createDTOList(List<Entity> entitiesList) {
		if(entitiesList==null)
			return null;
		List<DTO> dtoList = new ArrayList<DTO>();
		for (Entity entity: entitiesList)
			dtoList.add((DTO) createDTO(entity));
		return dtoList;
	}

	/**
     *
     * @param entitiesList
     * @return
     */
	public List<DTO> createDTOList(Set<Entity> entitiesSet) {
		return this.createDTOList(new ArrayList<Entity>(entitiesSet));
	}
}