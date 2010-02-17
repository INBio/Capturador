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

    public List<Long> findByGathObsId(Long gathObsId) {
        String query = "select gd.gatheringObservationDetailId from GatheringObservationDetail as gd where " +
                "gd.gatheringObservationId = :gathObsId";
        Query q = em.createQuery(query);
        q.setParameter("gathObsId", gathObsId);
        return q.getResultList();
    }
 
}
