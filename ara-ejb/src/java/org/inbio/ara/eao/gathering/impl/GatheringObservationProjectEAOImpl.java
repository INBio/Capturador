/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering.impl;

import org.inbio.ara.eao.gathering.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gathering.GatheringObservationProject;

/**
 *
 * @author esmata
 */
@Stateless
public class GatheringObservationProjectEAOImpl extends BaseEAOImpl<GatheringObservationProject,Long> implements GatheringObservationProjectEAOLocal {

    //Delete Projects and GatheringID
    public void deleteByGathering(Long gId) {
        Query q = em.createQuery("delete from GatheringObservationProject gop " +
                "where gop.gatheringObservationProjectPK.gatheringObservationId = :gId");
        q.setParameter("gId", gId);
        q.executeUpdate();
        em.flush();
    }
}
