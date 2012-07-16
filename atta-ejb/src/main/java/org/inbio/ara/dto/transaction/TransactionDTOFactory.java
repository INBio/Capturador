/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.transaction;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.transaction.Transaction;

/**
 *
 * @author echinchilla
 */
public class TransactionDTOFactory extends BaseEntityOrDTOFactory<Transaction, TransactionDTO> {

    @Override
    public Transaction getEntityWithPlainValues(TransactionDTO dto) {
        if (dto == null) {
            return null;
        }

        Transaction entity = new Transaction();
        entity.setTransactionId(dto.getTransactionId());
        entity.setTransactionDate(dto.getTransactionDate());
        entity.setInvoiceNumber(dto.getInvoiceNumber());
        entity.setEstimatedSpecimenCount(dto.getEstimatedSpecimenCount());
        entity.setDescription(dto.getDescription());
        entity.setExpirationDate(dto.getExpirationDate());
        entity.setSenderPersonId(dto.getSenderPersonId());
        entity.setSenderInstitutionId(dto.getSenderInstitutionId());
        entity.setReceiverPersonId(dto.getReceiverPersonId());
        entity.setReceiverInstitutionId(dto.getReceiverInstitutionId());
        entity.setCollectionId(dto.getCollectionId());
        entity.setTransactionTypeId(dto.getTransactionTypeId());

        return entity;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Transaction updateEntityWithPlainValues(TransactionDTO dto, Transaction e) {
        if (dto == null || e == null) {
            return null;
        }

        e.setTransactionId(dto.getTransactionId());
        e.setTransactionDate(dto.getTransactionDate());
        e.setInvoiceNumber(dto.getInvoiceNumber());
        e.setEstimatedSpecimenCount(dto.getEstimatedSpecimenCount());
        e.setDescription(dto.getDescription());
        e.setExpirationDate(dto.getExpirationDate());
        e.setSenderPersonId(dto.getSenderPersonId());
        e.setSenderInstitutionId(dto.getSenderInstitutionId());
        e.setReceiverPersonId(dto.getReceiverPersonId());
        e.setReceiverInstitutionId(dto.getReceiverInstitutionId());
        e.setCollectionId(dto.getCollectionId());
        e.setTransactionTypeId(dto.getTransactionTypeId());

        return e;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public TransactionDTO createDTO(Transaction entity) {
        if (entity == null) {
            return null;
        }

        TransactionDTO dto = new TransactionDTO();
        dto.setTransactionId(entity.getTransactionId());
        dto.setTransactionDate(entity.getTransactionDate());
        dto.setInvoiceNumber(entity.getInvoiceNumber());
        dto.setEstimatedSpecimenCount(entity.getEstimatedSpecimenCount());
        dto.setDescription(entity.getDescription());
        dto.setExpirationDate(entity.getExpirationDate());
        dto.setSenderPersonId(entity.getSenderPersonId());
        dto.setSenderInstitutionId(entity.getSenderInstitutionId());
        dto.setReceiverPersonId(entity.getReceiverPersonId());
        dto.setReceiverInstitutionId(entity.getReceiverInstitutionId());
        dto.setCollectionId(entity.getCollectionId());
        dto.setTransactionTypeId(entity.getTransactionTypeId());
        dto.setSelected(false);

        return dto;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
