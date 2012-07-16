/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering.impl;

import org.inbio.ara.eao.gathering.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gathering.GatheringObservationCollection;

/**
 *
 * @author esmata
 */
@Stateless
public class GatheringObservationCollectionEAOImpl extends BaseEAOImpl<GatheringObservationCollection,Long> implements GatheringObservationCollectionEAOLocal {
    
    //Delete Collections by GatheringID
    public void deleteByGathering(Long gId) {
        Query q = em.createQuery("delete from GatheringObservationCollection goc " +
                "where goc.gatheringObservationCollectionPK.gatheringObservationId = :gId");
        q.setParameter("gId", gId);
        q.executeUpdate();
        em.flush();
    } 
}
