/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germplasm.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.inbio.ara.eao.germplasm.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.germplasm.SemenGathering;

/**
 *
 * @author dasolano
 */
@Stateless
public class SemenGatheringEAOImpl extends BaseEAOImpl<SemenGathering, Long> implements SemenGatheringEAOLocal {

    public Long countAllBySementalId(Long sementalId) {
        Query q = em.createQuery(
                " Select count(s.sementalId) " +
                " from SemenGathering as s " +
                " where s.sementalId = :sementalId "
               );
        q.setParameter("sementalId", sementalId);
        
        return  (Long)q.getSingleResult();
    }

    public List<SemenGathering> findAllBySementalId(Long sementalId, int firstResult, int maxtResult) {
        Query q = em.createQuery(
                " from SemenGathering as s " +
                " where s.sementalId = :sementalId " +
                " order by s.semenGatheringDate"
               );
        q.setParameter("sementalId", sementalId);
        q.setFirstResult(firstResult);
        q.setMaxResults(maxtResult);
        return  q.getResultList();
    }

    public List<Long> findBySemenGatheringDate(Calendar semenGatheringDate, Calendar finalSemenGatheringDate) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.semenGatheringDate >= :semenGatheringDate and " +
                " s.semenGatheringDate <= :finalSemenGatheringDate"
               );
        q.setParameter("semenGatheringDate", semenGatheringDate);
        q.setParameter("finalSemenGatheringDate", finalSemenGatheringDate);

        return  q.getResultList();
    }

    public List<Long> findBySemenGatheringTime(String time) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.semenGatheringTime = '"+time +"'"
               );

        return  q.getResultList();
    }

    public List<Long> findByVolume(Long volume) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.volume = :volume "
               );
        q.setParameter("volume", volume);

        return  q.getResultList();
    }

    public List<Long> findByMotility(Long motility) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.motility = :motility "
               );
        q.setParameter("motility", motility);

        return  q.getResultList();
    }

    public List<Long> findByConcentration(Long concentration) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.concentration = :concentration "
               );
        q.setParameter("concentration", concentration);

        return  q.getResultList();
    }

    public List<Long> findByStrawQuantity(Long strawQuantity) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.strawQuantity = :strawQuantity "
               );
        q.setParameter("strawQuantity", strawQuantity);

        return  q.getResultList();
    }

    public List<Long> findByDilution(String dilution) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.dilution like '%"+ dilution+ "%'"
               );

        return  q.getResultList();
    }

    public List<Long> findByTankNumber(Long tankNumber) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.tankNumber = :tankNumber "
               );
        q.setParameter("tankNumber", tankNumber);

        return  q.getResultList();
    }

    public List<Long> findByCanisterNumber(Long canisterNumber) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.canisterNumber = :canisterNumber "
               );
        q.setParameter("canisterNumber", canisterNumber);

        return  q.getResultList();
    }

    public List<Long> findByGobletNumber(Long gobletNumber) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.gobletNumber = :gobletNumber "
               );
        q.setParameter("gobletNumber", gobletNumber);

        return  q.getResultList();
    }

    public List<Long> findByStrawColor(String strawColor) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.strawColor like '%"+strawColor + "%'"
               );

        return  q.getResultList();
    }

    public List<Long> findByPostThawMotility(Long postThawMotility) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.postThawMotility = :postThawMotility "
               );
        q.setParameter("postThawMotility", postThawMotility);

        return  q.getResultList();
    }

    public List<Long> findByActiveDoses(Long activeDoses) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.activeDoses = :activeDoses "
               );
        q.setParameter("activeDoses", activeDoses);

        return  q.getResultList();
    }

    public List<Long> findByStrawSize(Long strawSize) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.strawSize = :strawSize "
               );
        q.setParameter("strawSize", strawSize);

        return  q.getResultList();
    }

    public List<Long> findBySemenGatheringMethod(Long semenGatheringMethod) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering s, SemenGatheringMethod sgm " +
                " where s.semenGatheringMethodId = sgm.semenGatheringMethodId and " +
                " sgm.semenGatheringMethod = '"+semenGatheringMethod+"'"
               );

        return  q.getResultList();
    }

    public List<Long> findByConsistency(String consistence) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.consistence = '"+consistence+"'"
               );

        return  q.getResultList();
    }

    public List<Long> findBySemenColor(String semenColor) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.semenColor like '%"+semenColor+"%'"
               );

        return  q.getResultList();
    }

    public List<Long> findByPH(Long ph) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.ph = :ph "
               );
        q.setParameter("ph", ph);

        return  q.getResultList();
    }

    public List<Long> findByMassMotility(Long massMotility) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.massMotility = :massMotility "
               );
        q.setParameter("massMotility", massMotility);

        return  q.getResultList();
    }

    public List<Long> findBySolvent(Long solvent) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering s, Solvent so " +
                " where s.solventId = so.solventId and " +
                " so.name = '"+solvent+"'"
               );

        return  q.getResultList();
    }

}
