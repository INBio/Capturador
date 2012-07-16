/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.transaction;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.transaction.TransactedSpecimenStatus;

/**
 *
 * @author echinchilla
 */
public class TransactedSpecimenStatusDTOFactory { // extends BaseEntityOrDTOFactory<TransactedSpecimenStatus, TransactedSpecimenStatusDTO> {

  //  @Override
    public TransactedSpecimenStatus getEntityWithPlainValues(TransactedSpecimenStatusDTO dto) {
        if (dto == null) {
            return null;
        }

        TransactedSpecimenStatus entity = new TransactedSpecimenStatus();
        entity.setTransactedSpecimenStatusId(dto.getTransactedSpecimenStatusId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        return entity;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

   // @Override
    public TransactedSpecimenStatus updateEntityWithPlainValues(TransactedSpecimenStatusDTO dto, TransactedSpecimenStatus e) {
        if (dto == null || e == null) {
            return null;
        }

        e.setTransactedSpecimenStatusId(dto.getTransactedSpecimenStatusId());
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());

        return e;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public TransactedSpecimenStatusDTO createDTO(TransactedSpecimenStatus entity) {
        if (entity == null) {
            return null;
        }

        TransactedSpecimenStatusDTO dto = new TransactedSpecimenStatusDTO();
        dto.setTransactedSpecimenStatusId(entity.getTransactedSpecimenStatusId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());

        return dto;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
