/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

    public Long countTransactionByCollecionId(Long collectionId) {
        Query q = em.createQuery("select count(t.transactionId) " +
                " from Transaction as t " +
                "where t.collectionId= :collectionId");
        q.setParameter("collectionId", collectionId);
        return (Long) q.getSingleResult();
    }

    public boolean existsTransactionId(Long transactionId, Long collectionId) {
        Query q = em.createQuery("select count(t.transactionId) " +
                "from Transaction as t " +
                "where t.transactionId = :transactionId and t.collectionId = :collectionId");
        q.setParameter("transactionId", transactionId);
        q.setParameter("collectionId", collectionId);
        boolean exists = ((Long)q.getSingleResult()).intValue() == 1;
        return exists;
    }

    public List<Long> findByInvoiceNumber(String invoiceNumber, Long collectionId) {
        String lowerInvoiceNumber = invoiceNumber.toLowerCase();
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where lower(t.invoiceNumber) = '" + lowerInvoiceNumber + "' and t.collectionId = :collectionId");
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    public List<Long> findByDescription(String description, Long collectionId) {
        String lowerDescription = description.toLowerCase();
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where lower(t.description) like '%" + lowerDescription + "%' and t.collectionId = :collectionId");
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    public List<Long> findByEstimatedSpecimenCount(Long estimatedSpecimenCount, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.estimatedSpecimenCount = :estimatedSpecimenCount and t.collectionId = :collectionId");
        q.setParameter("estimatedSpecimenCount", estimatedSpecimenCount);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    public List<Long> findBySenderInstitutionId(Long senderInstitutionId, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.senderInstitutionId = :senderInstitutionId and t.collectionId = :collectionId");
        q.setParameter("senderInstitutionId", senderInstitutionId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    public List<Long> findBySenderPersonId(Long senderPersonId, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.senderPersonId = :senderPersonId and t.collectionId = :collectionId");
        q.setParameter("senderPersonId", senderPersonId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    public List<Long> findByReceiverInstitutionId(Long receiverInstitutionId, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.receiverInstitutionId = :receiverInstitutionId and t.collectionId = :collectionId");
        q.setParameter("receiverInstitutionId", receiverInstitutionId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    public List<Long> findByReceiverPersonId(Long receiverPersonId, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.receiverPersonId = :receiverPersonId and t.collectionId = :collectionId");
        q.setParameter("receiverPersonId", receiverPersonId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    public List<Long> findByTransactionTypeId(Long transactionTypeId, Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.transactionTypeId = :transactionTypeId and t.collectionId = :collectionId");
        q.setParameter("transactionTypeId", transactionTypeId);
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    public List<Long> findByCollectionId(Long collectionId) {
        Query q = em.createQuery("select t.id from Transaction as t " +
                "where t.collectionId = :collectionId");
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

    /**
     * Input data is compared with the firstName, lastName and secondLastName
     * @param name to search
     * @return List of people whom matched
     */
    public List<Long> findPersonIdByPersonName(String name) {
        String lowerName = name.toLowerCase();
        Query q = em.createQuery("select p.id from Person as p where lower(p.firstName) " +
                "like '%" + lowerName +"%' " +
                "or lower(p.lastName) like '%" + lowerName + "%'" +
                "or lower(p.secondLastName) like '%" + lowerName + "%'");
        return q.getResultList();
    }
    
    public List<Long> findInstitutionIdByInstitutionCode(String institutionCode) {
        String lowerInstitutionCode = institutionCode.toLowerCase();
        Query q = em.createQuery("select i.id from Institution as i " +
                "where lower(i.institutionCode) = '" + lowerInstitutionCode + "'");
        return q.getResultList();
    }

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
 
}
