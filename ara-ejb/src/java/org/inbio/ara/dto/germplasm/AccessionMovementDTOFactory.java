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
import org.inbio.ara.persistence.germplasm.AccessionMovement;
import org.inbio.ara.persistence.germplasm.AccessionMovementPK;

/**
 *
 * @author dasolano
 */
public class AccessionMovementDTOFactory extends BaseEntityOrDTOFactory<AccessionMovement ,AccessionMovementDTO> {

    @Override
    public AccessionMovement getEntityWithPlainValues(AccessionMovementDTO dto) {
        AccessionMovement accessionMovement = new AccessionMovement();

        AccessionMovementPK accessionMovementPK =
                new AccessionMovementPK(dto.getAccessionId(),
                dto.getAccessionMovementDate());

        accessionMovement.setAccessionMovementPK(accessionMovementPK);
        accessionMovement.setAccessionMovementTypeId(dto.getAccessionMovementTypeId());
        accessionMovement.setNotes(dto.getNotes());
        accessionMovement.setResponsablePersonId(dto.getResponsablePersonId());
        accessionMovement.setWeight(dto.getWeight());

        return accessionMovement;
    }

    @Override
    public AccessionMovement updateEntityWithPlainValues(AccessionMovementDTO dto, AccessionMovement e) {
        e.setAccessionMovementTypeId(dto.getAccessionMovementTypeId());
        e.setNotes(dto.getNotes());
        e.setResponsablePersonId(dto.getResponsablePersonId());
        e.setWeight(dto.getWeight());

        return e;
    }

    public AccessionMovementDTO createDTO(AccessionMovement entity) {
        AccessionMovementDTO dto = new AccessionMovementDTO();
        dto.setAccessionId(entity.getAccessionMovementPK().getAccessionId());
        dto.setAccessionMovementDate(entity.getAccessionMovementPK().getAccessionMovementDate());
        dto.setAccessionMovementTypeId(entity.getAccessionMovementTypeId());
        dto.setNotes(entity.getNotes());
        dto.setResponsablePersonId(entity.getResponsablePersonId());
        dto.setWeight(entity.getWeight());
        return dto;
    }

}
