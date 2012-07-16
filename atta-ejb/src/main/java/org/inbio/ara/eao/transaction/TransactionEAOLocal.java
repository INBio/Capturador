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

package org.inbio.ara.eao.transaction;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.transaction.Transaction;

/**
 *
 * @author echinchilla
 */
@Local
public interface TransactionEAOLocal extends BaseLocalEAO<Transaction, Long> {

    public Long countTransactionByCollecionId(Long collectionId);

    public boolean existsTransactionId(Long transactionId, Long collectionId);

    public List<org.inbio.ara.persistence.person.Person> getPersonsByInstitution(Long institutionId);

    public List<org.inbio.ara.persistence.institution.Institution> getAllInstitutions();

    public List<org.inbio.ara.persistence.person.Person> getPersonsWithoutInstitution();

    public List<java.lang.Long> findByInvoiceNumber(String invoiceNumber, Long collectionId);

    public List<Long> findByDescription(String description, Long collectionId);

    public List<Long> findByEstimatedSpecimenCount(Long estimatedSpecimenCount, Long collectionId);

    public List<Long> findBySenderInstitutionId(Long senderInstitutionId, Long collectionId);

    public List<Long> findBySenderPersonId(Long senderPersonId, Long collectionId);

    public List<Long> findByReceiverInstitutionId(Long receiverInstitutionId, Long collectionId);

    public List<Long> findByReceiverPersonId(Long receiverPersonId, Long collectionId);

    public List<Long> findByTransactionTypeId(Long transactionTypeId, Long collectionId);

    public List<Long> findByCollectionId(Long collectionId);

    public List<Long> findPersonIdByPersonName(String name);

    public List<Long> findInstitutionIdByInstitutionCode(String institutionCode);

    public List<Long> findByTransactionDateRange(Calendar initialTransactionDate, Calendar finalTransactionDate, Long collectionId);

    public List<Long> findByExpirationDateRange(Calendar initialExpirationDate, Calendar finalExpirationDate, Long collectionId);

    public List<Long> findBySpecimenId (Long collectionId, Long specimenId);

    public List<Long> findByDeliveryDateRange(Calendar initialDeliveryDate, Calendar finalDeliveryDate, Long collectionId);
    
    public List<Long> findByReceivingDateRange(Calendar initialReceivingDate, Calendar finalReceivingDate, Long collectionId);

    public List<Long> findByTransactedSpecimenStatusId (Long transactedSpecimenStatusId, Long collectionId);

    public List<Long> findByTransactedSpecimenDescription(String description, Long collectionId);

}
