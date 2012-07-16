/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.transaction;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.transaction.TransactionType;

/**
 *
 * @author echinchilla
 */
public class TransactionTypeDTOFactory { //extends BaseEntityOrDTOFactory<TransactionType, TransactionTypeDTO> {

   // @Override
    public TransactionType getEntityWithPlainValues(TransactionTypeDTO dto) {
        if (dto == null) {
            return null;
        }

        TransactionType entity = new TransactionType();
        entity.setTransactionTypeId(dto.getTransactionTypeId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        return entity;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

  //  @Override
    public TransactionType updateEntityWithPlainValues(TransactionTypeDTO dto, TransactionType e) {
        if (dto == null || e == null) {
            return null;
        }
        
        e.setTransactionTypeId(dto.getTransactionTypeId());
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        
        return e;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public TransactionTypeDTO createDTO(TransactionType entity) {
        if (entity == null) {
            return null;
        }

        TransactionTypeDTO dto = new TransactionTypeDTO();
        dto.setTransactionTypeId(entity.getTransactionTypeId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());

        return dto;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
