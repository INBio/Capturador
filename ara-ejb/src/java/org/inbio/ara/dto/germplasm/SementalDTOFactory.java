/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.dto.germplasm;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.germplasm.Semental;

/**
 *
 * @author dasolano
 */
public class SementalDTOFactory  extends BaseEntityOrDTOFactory<Semental ,SementalDTO>{

    @Override
    public Semental getEntityWithPlainValues(SementalDTO dto) {
        Semental e = new Semental();

        e.setAnimalCode(dto.getAnimalCode());
        e.setAnimalDescription(dto.getAnimalDescription());
        e.setBirthDate(dto.getBirthDate());
        e.setBreedId(dto.getBreedId());
        e.setColor(dto.getColor());
        e.setConditionId(dto.getConditionId());
        e.setFather(dto.getFather());
        e.setMother(dto.getMother());
        e.setName(dto.getName());
        e.setSiteId(dto.getSiteId());
        e.setVeterinarianStatus(dto.getVeterinarianStatus());
        return e;
    }

    @Override
    public Semental updateEntityWithPlainValues(SementalDTO dto, Semental e) {
        e.setAnimalCode(dto.getAnimalCode());
        e.setAnimalDescription(dto.getAnimalDescription());
        e.setBirthDate(dto.getBirthDate());
        e.setBreedId(dto.getBreedId());
        e.setColor(dto.getColor());
        e.setConditionId(dto.getConditionId());
        e.setFather(dto.getFather());
        e.setMother(dto.getMother());
        e.setName(dto.getName());
        e.setSiteId(dto.getSiteId());
        e.setVeterinarianStatus(dto.getVeterinarianStatus());
        return e;
    }

    public SementalDTO createDTO(Semental entity) {
        SementalDTO dto = new SementalDTO();

        dto.setSementalId(entity.getSementalId());
        dto.setAnimalCode(entity.getAnimalCode());
        dto.setAnimalDescription(entity.getAnimalDescription());
        dto.setBirthDate(entity.getBirthDate());
        dto.setBreedId(entity.getBreedId());
        dto.setColor(entity.getColor());
        dto.setConditionId(entity.getConditionId());
        dto.setFather(entity.getFather());
        dto.setMother(entity.getMother());
        dto.setName(entity.getName());
        dto.setSiteId(entity.getSiteId());
        dto.setVeterinarianStatus(entity.getVeterinarianStatus());
        return dto;
    }

}
