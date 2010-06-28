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
import org.inbio.ara.persistence.transaction.TransactedSpecimen;

/**
 *
 * @author echinchilla
 */
@Stateless
public class TransactedSpecimenEAOImpl extends BaseEAOImpl<TransactedSpecimen, Long> implements TransactedSpecimenEAOLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation").
    public Long countTransactedSpecimenByTransactionId(Long transactionId) {
        Query q = em.createQuery("select count(ts.transactedSpecimenPK.transactionId) " +
                " from TransactedSpecimen as ts " +
                "where ts.transactedSpecimenPK.transactionId= :transactionId");
        q.setParameter("transactionId", transactionId);
        return (Long) q.getSingleResult();
    }

    public List<TransactedSpecimen> getTransactedSpecimenByTransactionIdPaginated(int first,
            int maxResults, Long transactionId) {
        Query q = em.createQuery("select ts from TransactedSpecimen as ts " +
            "where ts.transactedSpecimenPK.transactionId  = :transactionId " +
            "order by creationDate");
        q.setParameter("transactionId", transactionId);
        q.setFirstResult(first);
        q.setMaxResults(maxResults);

        return q.getResultList();
    }

    /**
     *
     * @param transactionId
     * @param specimenId
     * @return
     */
    public int deleteTransactedSpecimen(Long transactionId, Long specimenId) {
        Query q = em.createQuery("delete from TransactedSpecimen as ts" +
                " where ts.transactedSpecimenPK.transactionId = :transactionId" +
                " and ts.transactedSpecimenPK.specimenId = :specimenId");
        q.setParameter("transactionId", transactionId);
        q.setParameter("specimenId", specimenId);
        return q.executeUpdate();
        //return (Long) q.getSingleResult();
    }

    public List<TransactedSpecimen> getTransactedSpecimenById(Long transactionId, Long specimenId) {
        Query q = em.createQuery("select ts from TransactedSpecimen as ts " +
            "where ts.transactedSpecimenPK.transactionId  = :transactionId " +
            "and ts.transactedSpecimenPK.specimenId = :specimenId");
        q.setParameter("transactionId", transactionId);
        q.setParameter("specimenId", specimenId);

        return q.getResultList();
    }
    
}
