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

package org.inbio.ara.eao.transaction.impl;

import java.util.Calendar;
import java.util.List;
import org.inbio.ara.eao.transaction.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.transaction.Transaction;

/**
 *
 * @author echinchilla
 */
@Stateless
public class TransactionEAOImpl extends BaseEAOImpl<Transaction, Long> implements TransactionEAOLocal {

    /**
     * Get the total number of transactions associated to a collectionId
     * @param collectionId the id of the collection
     * @return number of Transactions
     */
    public Long countTransactionByCollecionId(Long collectionId) {
        Query q = em.createQuery("select count(t.transactionId) " +
                " from Transaction as t " +
                "where t.collectionId= :collectionId");
        q.setParameter("collectionId", collectionId);
        return (Long) q.getSingleResult();
    }

    /**
     * Search a transaction by its id and collectionId.
     * @param transactionId the transaction id
     * @param collectionId the collection id
     * @return true id transaction exists, false if not.
     */
    public boolean existsTransactionId(Long transactionId, Long collectionId) {
        Query q = em.createQuery("select count(t.transactionId) " +
                "from Transaction as t " +
                "where t.transactionId = :transactionId and t.collectionId = :collectionId");
        q.setParameter("transactionId", transactionId);
        q.setParameter("collectionId", collectionId);
        boolean exists = ((Long)q.getSingleResult()).intValue() == 1;
        return exists;
    }

    /**
     * Get all the transaction id's filtered by invoiceNumber and collectionId
     * @param invoiceNumber the invoice number to search
     * @param collectionId the collection id
     * @return List of transaction id's
     */
    public List<Long> findByInvoiceNumber(String invoiceNumber, Long collectionId) {
        String lowerInvoiceNumber = invoiceNumber.toLowerCase();
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where lower(t.invoiceNumber) = '" + lowerInvoiceNumber + "' and t.collectionId = :collectionId");
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by description and collectionId
     * @param description the description to search
     * @param collectionId the collection id
     * @return List of transaction id's
     */
    public List<Long> findByDescription(String description, Long collectionId) {
        String lowerDescription = description.toLowerCase();
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where lower(t.description) like '%" + lowerDescription + "%' and t.collectionId = :collectionId");
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by estimatedSpecimenCount and collectionId
     * @param estimatedSpecimenCount the estimated specimen count to search
     * @param collectionId the collection id
     * @return List of transaction id's
     */
    public List<Long> findByEstimatedSpecimenCount(Long estimatedSpecimenCount, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.estimatedSpecimenCount = :estimatedSpecimenCount and t.collectionId = :collectionId");
        q.setParameter("estimatedSpecimenCount", estimatedSpecimenCount);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by senderInstitutionId and collectionId
     * @param senderInstitutionId the sender institution id to search
     * @param collectionId the collection id
     * @return List of transaction id's
     */
    public List<Long> findBySenderInstitutionId(Long senderInstitutionId, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.senderInstitutionId = :senderInstitutionId and t.collectionId = :collectionId");
        q.setParameter("senderInstitutionId", senderInstitutionId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by senderPersonId and collectionId
     * @param senderPersonId the sender person id to search
     * @param collectionId the collection id
     * @return List of transaction id's
     */
    public List<Long> findBySenderPersonId(Long senderPersonId, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.senderPersonId = :senderPersonId and t.collectionId = :collectionId");
        q.setParameter("senderPersonId", senderPersonId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by receiverInstitutionId and collectionId
     * @param receiverInstitutionId the receiver institution id to search
     * @param collectionId the collection id
     * @return List of transaction id's
     */
    public List<Long> findByReceiverInstitutionId(Long receiverInstitutionId, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.receiverInstitutionId = :receiverInstitutionId and t.collectionId = :collectionId");
        q.setParameter("receiverInstitutionId", receiverInstitutionId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by receiverPersonId and collectionId
     * @param receiverPersonId the receiver person id to search
     * @param collectionId the collection id
     * @return List of transaction id's
     */
    public List<Long> findByReceiverPersonId(Long receiverPersonId, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.receiverPersonId = :receiverPersonId and t.collectionId = :collectionId");
        q.setParameter("receiverPersonId", receiverPersonId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by transactionTypeId and collectionId
     * @param transactionTypeId the transactiontype id to search
     * @param collectionId the collection id
     * @return List of transaction id's
     */
    public List<Long> findByTransactionTypeId(Long transactionTypeId, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.transactionTypeId = :transactionTypeId and t.collectionId = :collectionId");
        q.setParameter("transactionTypeId", transactionTypeId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered collectionId
     * @param collectionId the collection id
     * @return List of transaction id's
     */
    public List<Long> findByCollectionId(Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.collectionId = :collectionId");
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    /**
     * Get all the people id's filtered by their name.<br/>Input data is
     * compared with a Person's firstName, lastName and secondLastName
     * @param name the name to search
     * @return List of people id's
     */
    public List<Long> findPersonIdByPersonName(String name) {
        String lowerName = name.toLowerCase();
        Query q = em.createQuery("select p.id from Person as p where lower(p.firstName) " +
                "like '%" + lowerName +"%' " +
                "or lower(p.lastName) like '%" + lowerName + "%'" +
                "or lower(p.secondLastName) like '%" + lowerName + "%'");
        return q.getResultList();
    }

    /**
     * Get all the institution id's filtered by their institutionCode.
     * @param institutionCode the institution code to search
     * @return List of institution id's
     */
    public List<Long> findInstitutionIdByInstitutionCode(String institutionCode) {
        String lowerInstitutionCode = institutionCode.toLowerCase();
        Query q = em.createQuery("select i.id from Institution as i " +
                "where lower(i.institutionCode) = '" + lowerInstitutionCode + "'");
        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by initialTransactionDate,
     * finalTransactionDate and collectionId
     * @param initialTransactionDate the initial transaction date
     * @param finalTransactionDate the final transaction date
     * @param collectionId the collection id
     * @return List of transactions id's
     */
    public List<Long> findByTransactionDateRange(Calendar initialTransactionDate, Calendar finalTransactionDate, Long collectionId) {
        StringBuffer sb = new StringBuffer("select t.id from Transaction as t where ");

        if(initialTransactionDate != null) {
            sb.append("t.transactionDate >= :initialTransactionDate ");
            if(finalTransactionDate != null) {
                sb.append("and t.transactionDate <= :finalTransactionDate ");
            }
        }
        else {
            sb.append("t.transactionDate <= :finalTransactionDate ");
        }
        sb.append("and t.collectionId = :collectionId");

        Query q = em.createQuery(sb.toString());
        q.setParameter("collectionId", collectionId);
        
        if(initialTransactionDate != null) {
            q.setParameter("initialTransactionDate", initialTransactionDate);
            if(finalTransactionDate != null) {
                q.setParameter("finalTransactionDate", finalTransactionDate);
            }
        }
        else {
            q.setParameter("finalTransactionDate", finalTransactionDate);
        }

        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by initialExpirationDate,
     * finalExpirationDate and collectionId
     * @param initialExpirationDate the initial expiration date
     * @param finalExpirationDate the final expiration date
     * @param collectionId the collection id
     * @return List of transactions id's
     */
    public List<Long> findByExpirationDateRange(Calendar initialExpirationDate, Calendar finalExpirationDate, Long collectionId) {
        StringBuffer sb = new StringBuffer("select t.id from Transaction as t where ");

        if(initialExpirationDate != null) {
            sb.append("t.expirationDate >= :initialExpirationDate ");
            if(finalExpirationDate != null) {
                sb.append("and t.expirationDate <= :finalExpirationDate ");
            }
        }
        else {
            sb.append("t.expirationDate <= :finalExpirationDate ");
        }
        sb.append("and t.collectionId = :collectionId");

        Query q = em.createQuery(sb.toString());
        q.setParameter("collectionId", collectionId);

        if(initialExpirationDate != null) {
            q.setParameter("initialExpirationDate", initialExpirationDate);
            if(finalExpirationDate != null) {
                q.setParameter("finalExpirationDate", finalExpirationDate);
            }
        }
        else {
            q.setParameter("finalExpirationDate", finalExpirationDate);
        }

        return q.getResultList();
    }



    /**
     * Método que consulta la lista completa de instituciones registradas en
     * el sistema.
     * @return lista de todas las instituciones.
     */
    public List<Institution> getAllInstitutions() {
        String sql = "Select i ";
              sql += "from Institution i";
        Query q = em.createQuery(sql);
        return (List<Institution>)q.getResultList();
    }

    /**
     * Este método devuelve la lista de personas que están asociadas a un id de
     * insitución específico.
     * @param institutionId el id de la institución para filtrar las personas
     * @return Lista de personas asociadas a la institución
     */
    public List<Person> getPersonsByInstitution(Long institutionId){
        String sql = "Select p ";
              sql += "from Person p, PersonInstitution pi ";
              sql += "where p.personId = pi.personInstitutionPK.personId " +
                      "and pi.personInstitutionPK.institutionId = :institutionId";
        Query q = em.createQuery(sql);
		q.setParameter("institutionId", institutionId);
        return (List<Person>)q.getResultList();
    }

    /**
     * Este método devuelve la lista de personas que no están asociadas a
     * ninguna insititución.
     * @return lista de personas sin instituciones asociadas
     */
    public List<Person> getPersonsWithoutInstitution(){
        String sql = "Select p ";
              sql += "from Person p ";
              sql += "where p.personId not in ";
              sql += "(select pi.personInstitutionPK.personId " +
                      "from PersonInstitution pi)";
        Query q = em.createQuery(sql);
        return (List<Person>)q.getResultList();
    }

    public List<Long> findBySpecimenId (Long collectionId, Long specimenId) {
        Query q = em.createQuery("select t.transactionId from Transaction as t " +
                "where t.collectionId = :collectionId and t.transactionId in " +
                "(select distinct ts.transactedSpecimenPK.transactionId from TransactedSpecimen as ts " +
                "where ts.transactedSpecimenPK.specimenId = :specimenId)");
        q.setParameter("collectionId", collectionId);
        q.setParameter("specimenId", specimenId);
        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by initialDeliveryDate,
     * finalDeliveryDate and collectionId
     * @param initialDeliveryDate the initial delivery date
     * @param finalDeliveryDate the final delivery date
     * @param collectionId the collection id
     * @return List of transactions id's
     */
    public List<Long> findByDeliveryDateRange(Calendar initialDeliveryDate, Calendar finalDeliveryDate, Long collectionId) {
        StringBuffer sb = new StringBuffer("select t.transactionId from Transaction as t " +
                "where t.collectionId = :collectionId and t.transactionId in " +
                "(select distinct ts.transactedSpecimenPK.transactionId from TransactedSpecimen as ts where ");

        if(initialDeliveryDate != null) {
            sb.append("ts.deliveryDate >= :initialDeliveryDate ");
            if(finalDeliveryDate != null) {
                sb.append("and ts.deliveryDate <= :finalDeliveryDate");
            }
            sb.append(")");
        }
        else {
            sb.append("ts.deliveryDate <= :finalDeliveryDate)");
        }

        Query q = em.createQuery(sb.toString());
        q.setParameter("collectionId", collectionId);

        if(initialDeliveryDate != null) {
            q.setParameter("initialDeliveryDate", initialDeliveryDate);
            if(finalDeliveryDate != null) {
                q.setParameter("finalDeliveryDate", finalDeliveryDate);
            }
        }
        else {
            q.setParameter("finalDeliveryDate", finalDeliveryDate);
        }

        return q.getResultList();
    }

    /**
     * Get all the transaction id's filtered by initialReceivingDate,
     * finalReceivingDate and collectionId
     * @param initialReceivingDate the initial receiving date
     * @param finalReceivingDate the final receiving date
     * @param collectionId the collection id
     * @return List of transactions id's
     */
    public List<Long> findByReceivingDateRange(Calendar initialReceivingDate, Calendar finalReceivingDate, Long collectionId) {
        StringBuffer sb = new StringBuffer("select t.transactionId from Transaction as t " +
                "where t.collectionId = :collectionId and t.transactionId in " +
                "(select distinct ts.transactedSpecimenPK.transactionId from TransactedSpecimen as ts where ");

        if(initialReceivingDate != null) {
            sb.append("ts.receivingDate >= :initialReceivingDate ");
            if(finalReceivingDate != null) {
                sb.append("and ts.receivingDate <= :finalReceivingDate");
            }
            sb.append(")");
        }
        else {
            sb.append("ts.receivingDate <= :finalReceivingDate)");
        }

        Query q = em.createQuery(sb.toString());
        q.setParameter("collectionId", collectionId);

        if(initialReceivingDate != null) {
            q.setParameter("initialReceivingDate", initialReceivingDate);
            if(finalReceivingDate != null) {
                q.setParameter("finalReceivingDate", finalReceivingDate);
            }
        }
        else {
            q.setParameter("finalReceivingDate", finalReceivingDate);
        }

        return q.getResultList();
    }

    public List<Long> findByTransactedSpecimenStatusId (Long transactedSpecimenStatusId, Long collectionId) {
        Query q = em.createQuery("select t.transactionId from Transaction as t " +
                "where t.collectionId = :collectionId and t.transactionId in " +
                "(select distinct ts.transactedSpecimenPK.transactionId from TransactedSpecimen as ts " +
                "where ts.transactedSpecimenStatusId = :transactedSpecimenStatusId)");
        q.setParameter("transactedSpecimenStatusId", transactedSpecimenStatusId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    public List<Long> findByTransactedSpecimenDescription(String description, Long collectionId) {
        String lowerDescription = description.toLowerCase();
        Query q = em.createQuery("select t.transactionId from Transaction as t " +
                "where t.collectionId = :collectionId and t.transactionId in " +
                "(select distinct ts.transactedSpecimenPK.transactionId from TransactedSpecimen as ts " +
                "where lower(ts.description) like '%" + lowerDescription + "%')");
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }
}
