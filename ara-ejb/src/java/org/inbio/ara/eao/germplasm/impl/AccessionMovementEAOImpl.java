/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germplasm.impl;

import java.util.Date;
import java.util.List;
import org.inbio.ara.eao.germplasm.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.germplasm.AccessionMovement;

/**
 *
 * @author dasolano
 */
@Stateless
public class AccessionMovementEAOImpl extends BaseEAOImpl<AccessionMovement, Long> implements AccessionMovementEAOLocal {

    public List<AccessionMovement> findAllPaginatedByAccessionId(Long accessionId) {
        Query q = em.createQuery(
                " from AccessionMovement as a " +
                " where a.accessionMovementPK.accessionId = :accessionId "
               );
        q.setParameter("accessionId", accessionId);
        return  q.getResultList();
    }

    public Long countAllByAccessionId(Long accessionId) {
        Query q = em.createQuery(
                " Select count(a.accessionMovementPK.accessionId) " +
                " from AccessionMovement as a " +
                " where a.accessionMovementPK.accessionId = :accessionId "
               );
        q.setParameter("accessionId", accessionId);
        return  (Long)q.getSingleResult();
    }

    public AccessionMovement findByAccessionIdAndDateTime(Long accessionId, Date datetimeAux) {
        Query q = em.createQuery(
                " from AccessionMovement as a " +
                " where a.accessionMovementPK.accessionId = :accessionId and" +
                " a.accessionMovementPK.accessionMovementDate =:datetimeAux"
               );
        q.setParameter("accessionId", accessionId);
        q.setParameter("datetimeAux", datetimeAux);
        return  (AccessionMovement)q.getResultList().get(0);
    }
    
}
