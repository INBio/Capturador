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

package org.inbio.ara.eao.gathering.impl;

import java.util.List;
import org.inbio.ara.eao.gathering.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;

/**
 *
 * @author esmata
 */
@Stateless
public class GatheringObservationDetailEAOImpl extends BaseEAOImpl<GatheringObservationDetail,Long> implements GatheringObservationDetailEAOLocal {
    
    public List<GatheringObservationDetail> getDetailPaginatedByGathering(int firstResult,int maxResults,Long gathId){
        Query q = em.createQuery("from GatheringObservationDetail god " +
                "where god.gatheringObservationId = :gId");
        q.setParameter("gId", gathId);
        q.setFirstResult(firstResult);
        q.setMaxResults(maxResults);
        return (List<GatheringObservationDetail>)q.getResultList();
    }

    public void deleteById(Long gId) {
        Query q = em.createQuery("delete from GatheringObservationDetail god " +
                "where god.gatheringObservationDetailId = :gId");
        q.setParameter("gId", gId);
        q.executeUpdate();
        em.flush();
    }

    public List<Long> findByGathObsDetailId(Long gathObsId) {
        String query = "select gd.gatheringObservationDetailId from GatheringObservationDetail as gd where " +
                "gd.gatheringObservationId = :gathObsId";
        Query q = em.createQuery(query);
        q.setParameter("gathObsId", gathObsId);
        return q.getResultList();
    }
    
    /**
     * Ej. select gathering_observation.gathering_observation_id from
     * ara.gathering_observation where
     *          gathering_observation.responsible_person_id = 128;
     * @param personId
     * @return Gatherings & Observations carried out by some responsible person
     */
    public List<Long> findByResponsibleId(Long personId, Long initialGathObserDetail, Long finalGathObserDetail) {
        Query q = em.createQuery("select go.gatheringObservationId from " +
                "GatheringObservationDetail as go"
                + " where go.gatheringObservationDetailPerson.personId = :personId and go.gatheringObservationDetailId between :initialGathDetail  and  :finalGathDetail");
        q.setParameter("personId", personId);
        q.setParameter("initialGathDetail", initialGathObserDetail);
        q.setParameter("finalGathDetail", finalGathObserDetail);
        return q.getResultList();
    }

    public List<Long> findByResponsibleId(Long personId) {
        Query q = em.createQuery("select go.gatheringObservationId from " +
                "GatheringObservationDetail as go"
                + " where go.gatheringObservationDetailPerson.personId = :personId");
        q.setParameter("personId", personId);
        return q.getResultList();
    }

    public List<Long> findByResponsibleId(Long personId, Long initialGathObserDetail) {
        Query q = em.createQuery("select go.gatheringObservationId from " +
                "GatheringObservationDetail as go"
                + " where go.gatheringObservationDetailPerson.personId = :personId and go.gatheringObservationDetailId = :initialGathDetail");
        q.setParameter("personId", personId);
        q.setParameter("initialGathDetail", initialGathObserDetail);
        return q.getResultList();
    }

   

 
}
