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
import org.inbio.ara.persistence.germplasm.Breed;

/**
 *
 * @author dasolano
 */
public class BreedDTOFactory  extends BaseEntityOrDTOFactory<Breed ,BreedDTO>{

    @Override
    public Breed getEntityWithPlainValues(BreedDTO dto) {
        Breed e = new Breed();
        e.setName(dto.getName());
        e.setTaxonId(dto.getTaxonId());
        return e;
    }

    @Override
    public Breed updateEntityWithPlainValues(BreedDTO dto, Breed e) {
        e.setName(dto.getName());
        e.setTaxonId(dto.getTaxonId());
        return e;
    }

    public BreedDTO createDTO(Breed entity) {
        BreedDTO dto = new BreedDTO();
        dto.setBreedId(entity.getBreedId());
        dto.setName(entity.getName());
        dto.setTaxonId(entity.getTaxonId());
        return dto;
    }

}
