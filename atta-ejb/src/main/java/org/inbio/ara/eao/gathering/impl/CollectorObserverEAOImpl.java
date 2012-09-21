/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering.impl;

import java.util.List;
import org.inbio.ara.eao.gathering.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gathering.CollectorObserver;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author esmata
 */
@Stateless
public class CollectorObserverEAOImpl extends BaseEAOImpl<CollectorObserver,Long> implements CollectorObserverEAOLocal {

    /**
     * Obtener un listado de los colectores para una recoleccion dada
     */
    public List<Person> getCollectorsByGathering(Long GathId){
        Query q = em.createQuery("Select object(per) from Person as per, CollectorObserver as co where per.personId = co.collectorObserverPK.collectorPersonId and co.collectorObserverPK.gatheringObservationId = :GathId");
		q.setParameter("GathId", GathId );
        return q.getResultList();
    }
    
     /**
     * Obtener un listado observaciones por colector
     */
    public List<Long> getGatheringByCollector(Long collectorId){
        Query q = em.createQuery("Select co.collectorObserverPK.gatheringObservationId from CollectorObserver co where co.collectorObserverPK.collectorPersonId = :collectorId");
		q.setParameter("collectorId", collectorId );
        return q.getResultList();
    }

    //Delete Collectors by GatheringID
    public void deleteByGathering(Long gId) {
        Query q = em.createQuery("delete from CollectorObserver co " +
                "where co.collectorObserverPK.gatheringObservationId = :gId");
        q.setParameter("gId", gId);
        q.executeUpdate();
        em.flush();
    }
}