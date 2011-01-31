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
    
    /**
     * Método que cuenta los especímenes transados de una transacción
     * @param transactionId
     * @return
     */
    public Long countTransactedSpecimenByTransactionId(Long transactionId) {
        Query q = em.createQuery("select count(ts.transactedSpecimenPK.transactionId) " +
                " from TransactedSpecimen as ts " +
                "where ts.transactedSpecimenPK.transactionId= :transactionId");
        q.setParameter("transactionId", transactionId);
        return (Long) q.getSingleResult();
    }

    /**
     * Método que obtiene los especímenes transados paginados de una transacción
     * @param first
     * @param maxResults
     * @param transactionId
     * @return
     */
    public List<TransactedSpecimen> getTransactedSpecimenByTransactionIdPaginated(int first,
            int maxResults, Long transactionId) {
        Query q = em.createQuery("select ts from TransactedSpecimen as ts " +
            "where ts.transactedSpecimenPK.transactionId  = :transactionId " +
            "order by creationDateAndTime");
        q.setParameter("transactionId", transactionId);
        q.setFirstResult(first);
        q.setMaxResults(maxResults);

        return q.getResultList();
    }

    /**
     * Método para borrar un espécimen transado
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
    }

    /**
     * Método que obtiene un espécimen transado por su id y el de su transacción asociada
     * @param transactionId
     * @param specimenId
     * @return
     */
    public List<TransactedSpecimen> getTransactedSpecimenById(Long transactionId, Long specimenId) {
        Query q = em.createQuery("select ts from TransactedSpecimen as ts " +
            "where ts.transactedSpecimenPK.transactionId  = :transactionId " +
            "and ts.transactedSpecimenPK.specimenId = :specimenId");
        q.setParameter("transactionId", transactionId);
        q.setParameter("specimenId", specimenId);
        return q.getResultList();
    }

    /**
     * Método para saber si se espera que un espécimen transado sea devuelto o no (caso de donaciones)
     * @param specimenId
     * @return
     */
    public TransactedSpecimen getWaitingForReturnTransactionId(Long specimenId) {
        Query q = em.createQuery("select ts from TransactedSpecimen as ts " +
            "where ts.transactedSpecimenPK.specimenId = :specimenId " +
            "and ts.waitingForReturn = true");
        q.setParameter("specimenId", specimenId);
        try {
            return (TransactedSpecimen)q.getSingleResult();
        }
        catch(Exception e) {
            return null;
        }
    }
    
}
