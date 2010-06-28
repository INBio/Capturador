/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

}
