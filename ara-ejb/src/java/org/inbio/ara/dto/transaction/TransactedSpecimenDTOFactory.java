/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.transaction;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.transaction.TransactedSpecimen;

/**
 *
 * @author echinchilla
 */
public class TransactedSpecimenDTOFactory extends BaseEntityOrDTOFactory<TransactedSpecimen, TransactedSpecimenDTO> {

    @Override
    public TransactedSpecimen getEntityWithPlainValues(TransactedSpecimenDTO dto) {
        if (dto == null) {
            return null;
        }

        TransactedSpecimen entity = new TransactedSpecimen();
        entity.setTransactedSpecimenPK(dto.getTransactedSpecimenPK());
        //entity.setSpecimenId(dto.getSpecimenId());
        //entity.setTransactionId(dto.getTransactionId());
        entity.setDeliveryDate(dto.getDeliveryDate());
        entity.setReceivingDate(dto.getReceivingDate());
        entity.setDescription(dto.getDescription());
        entity.setTransactedSpecimenStatusId(dto.getTransactedSpecimenStatusId());
        entity.setTransactionTypeId(dto.getTransactionTypeId());

        return entity;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TransactedSpecimen updateEntityWithPlainValues(TransactedSpecimenDTO dto, TransactedSpecimen e) {
        if (dto == null || e == null) {
            return null;
        }

        e.setTransactedSpecimenPK(dto.getTransactedSpecimenPK());
        //e.setSpecimenId(dto.getSpecimenId());
        //e.setTransactionId(dto.getTransactionId());
        e.setDeliveryDate(dto.getDeliveryDate());
        e.setReceivingDate(dto.getReceivingDate());
        e.setDescription(dto.getDescription());
        e.setTransactedSpecimenStatusId(dto.getTransactedSpecimenStatusId());
        e.setTransactionTypeId(dto.getTransactionTypeId());

        return e;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public TransactedSpecimenDTO createDTO(TransactedSpecimen entity) {
        if (entity == null) {
            return null;
        }

        TransactedSpecimenDTO dto = new TransactedSpecimenDTO();
        dto.setTransactedSpecimenPK(entity.getTransactedSpecimenPK());
        //dto.setSpecimenId(entity.getSpecimenId());
        //dto.setTransactionId(entity.getTransactionId());
        dto.setDeliveryDate(entity.getDeliveryDate());
        dto.setReceivingDate(entity.getReceivingDate());
        dto.setDescription(entity.getDescription());
        dto.setTransactedSpecimenStatusId(entity.getTransactedSpecimenStatusId());
        dto.setTransactionTypeId(entity.getTransactionTypeId());

        return dto;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
