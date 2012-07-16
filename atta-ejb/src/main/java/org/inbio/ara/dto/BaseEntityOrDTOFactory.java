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
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author jgutierrez
 *
 * Based on dmartin code, in the GBIF customizable portal.
 */
public abstract class BaseEntityOrDTOFactory <Entity extends LogGenericEntity,
        DTO extends GenericDTO> implements EntityOrDTOFactory  <Entity,DTO> {

    /**
     * Este método no está pensando para 'setear' en el entity solo los valores
     * primivos o los objectos de primitivos. Osea, int Integer, long, Long,
     * String, etc.
     * Esto es muy importante porque si un objecto tiene como atributo otro
     * objeto este estará en NULL!!!!
     *
     * @return
     */
    public abstract Entity getEntityWithPlainValues(DTO dto);

    public abstract Entity updateEntityWithPlainValues(DTO dto, Entity e);

    /**
     *
     * @param dto
     * @return
     */
    public Entity createPlainEntity(DTO dto) {
        if(dto == null)
            return null;

        Entity e= getEntityWithPlainValues(dto);
        e.setLastModificationBy(dto.getUserName());
        e.setLastModificationDate(new GregorianCalendar());
        System.out.println("Created by = "+e.getCreatedBy());
        return e;
    }

    /**
     *
     * @param dto
     * @return
     */
    public Entity updatePlainEntity(DTO dto, Entity e) {
        if(dto == null)
            return null;

        e= updateEntityWithPlainValues(dto,e);
        e.setLastModificationBy(dto.getUserName());
        e.setLastModificationDate(new GregorianCalendar());
        return e;
    }

    
    /**
     *
     * @param dtoList
     * @return
     */
	public List<Entity> createEntityList(List<DTO> dtoList) {
		if(dtoList==null)
			return null;
		List<Entity> entityList = new ArrayList<Entity>();
		for (DTO dto : dtoList)
			entityList.add((Entity) createPlainEntity(dto));
		return entityList;
	}

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