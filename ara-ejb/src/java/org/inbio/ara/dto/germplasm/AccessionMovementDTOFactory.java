/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
