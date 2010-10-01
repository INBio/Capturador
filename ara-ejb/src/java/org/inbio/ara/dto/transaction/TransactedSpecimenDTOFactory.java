/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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
        entity.setDeliveryDate(dto.getDeliveryDate());
        entity.setReceivingDate(dto.getReceivingDate());
        entity.setDescription(dto.getDescription());
        entity.setWaitingForReturn(dto.getWaitingForReturn());
        entity.setCreationDateAndTime(dto.getCrationDateAndTime());
        entity.setTransactedSpecimenStatusId(dto.getTransactedSpecimenStatusId());
        entity.setTransactionTypeId(dto.getTransactionTypeId());
        return entity;
    }

    @Override
    public TransactedSpecimen updateEntityWithPlainValues(TransactedSpecimenDTO dto, TransactedSpecimen e) {
        if (dto == null || e == null) {
            return null;
        }
        e.setTransactedSpecimenPK(dto.getTransactedSpecimenPK());
        e.setDeliveryDate(dto.getDeliveryDate());
        e.setReceivingDate(dto.getReceivingDate());
        e.setDescription(dto.getDescription());
        e.setWaitingForReturn(dto.getWaitingForReturn());
        e.setCreationDateAndTime(dto.getCrationDateAndTime());
        e.setTransactedSpecimenStatusId(dto.getTransactedSpecimenStatusId());
        e.setTransactionTypeId(dto.getTransactionTypeId());
        return e;
    }

    public TransactedSpecimenDTO createDTO(TransactedSpecimen entity) {
        if (entity == null) {
            return null;
        }
        TransactedSpecimenDTO dto = new TransactedSpecimenDTO();
        dto.setTransactedSpecimenPK(entity.getTransactedSpecimenPK());
        dto.setDeliveryDate(entity.getDeliveryDate());
        dto.setReceivingDate(entity.getReceivingDate());
        dto.setDescription(entity.getDescription());
        dto.setWaitingForReturn(entity.getWaitingForReturn());
        dto.setCrationDateAndTime(entity.getCreationDateAndTime());
        dto.setTransactedSpecimenStatusId(entity.getTransactedSpecimenStatusId());
        dto.setTransactionTypeId(entity.getTransactionTypeId());
        return dto;
    }
}
