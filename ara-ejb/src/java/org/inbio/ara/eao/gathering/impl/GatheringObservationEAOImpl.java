/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering.impl;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.eao.gathering.GatheringObservationEAOLocal;
import org.inbio.ara.persistence.gathering.GatheringObservation;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class GatheringObservationEAOImpl 
        extends BaseEAOImpl<GatheringObservation,Long>
        implements GatheringObservationEAOLocal {
        /**
     * Ej. select * from ara.gathering_observation where
     *          gathering_observation.site_id = 919;
     * @param siteId
     * @return Gatherings & Observations carried out in siteId
     */
    public List<Long> findBySiteId(Long siteId) {
        Query q = em.createQuery("select go.gatheringObservationId " +
                "from GatheringObservation as go"
                + " where go.site.siteId = :siteId");
        q.setParameter("siteId", siteId);
        return q.getResultList();
    }

    /**
     * Ej. select * from ara.gathering_observation where
     *          gathering_observation.site_id = 919;
     * @param siteId
     * @return Gatherings & Observations carried out in siteId
     */
     public List<GatheringObservation> findGathObsBySiteId(Long siteId) {
        Query q = em.createQuery("from GatheringObservation go"
                + " where go.site.siteId = :siteId");
        q.setParameter("siteId", siteId);        
        return q.getResultList();
    }

    /**
     * Ej. select gathering_observation.gathering_observation_id from
     * ara.gathering_observation where
     *          gathering_observation.responsible_person_id = 128;
     * @param personId
     * @return Gatherings & Observations carried out by some responsible person
     */
    public List<Long> findByResponsibleId(Long personId) {
        Query q = em.createQuery("select go.gatheringObservationId from " +
                "GatheringObservation as go"
                + " where go.responsiblePerson.personId = :personId");
        q.setParameter("personId", personId);
        return q.getResultList();
    }

    public List<Long> findByInitialDate(Calendar initialDate) {
        Query q = em.createQuery("select go.gatheringObservationId from " +
                "GatheringObservation as go"
                + " where go.initialDate = :initialDate");
        q.setParameter("initialDate", initialDate);
        return q.getResultList();
    }

    public List<Long> findByFinalDate(Calendar finalDate) {
        Query q = em.createQuery("select go.gatheringObservationId from " +
                "GatheringObservation as go"
                + " where go.finalDate = :finalDate");
        q.setParameter("finalDate", finalDate);
        return q.getResultList();
    }
    

    public void deleteById(Long gId) {
        Query q = em.createQuery("delete from GatheringObservation go " +
                "where go.gatheringObservationId = :gId");
        q.setParameter("gId", gId);
        q.executeUpdate();
        em.flush();
    }

    public List<Long> findBySpecimenId(Long specimenId) {
        Query q = em.createQuery("select " +
                "s.gatheringObservation.gatheringObservationId from Specimen "
                + "as s where s.specimenId = :specimenId");
        q.setParameter("specimenId", specimenId);
        return q.getResultList();
    }

    public List<Long> findByCollectionId(Long collectionId) {
        Query q = em.createQuery("select " +
                "s.gatheringObservation.gatheringObservationId from Specimen "
                + "as s where s.collection.collectionId = :collectionId");
        q.setParameter("collectionId", collectionId);
        return q.getResultList();
    }

}
