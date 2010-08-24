/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

    public List<Long> findBySemenGatheringDate(Calendar semenGatheringDate, Calendar finalSemenGatheringDate, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.semenGatheringDate >= :semenGatheringDate and " +
                " s.semenGatheringDate <= :finalSemenGatheringDate and" +
                " s.sementalId = :sementalId"
               );
        q.setParameter("semenGatheringDate", semenGatheringDate);
        q.setParameter("finalSemenGatheringDate", finalSemenGatheringDate);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findBySemenGatheringTime(String time, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.semenGatheringTime = '"+time +"' and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByVolume(Long volume, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.volume = :volume  and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("volume", volume);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByMotility(Long motility, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.motility = :motility  and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("motility", motility);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByConcentration(Long concentration, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.concentration = :concentration  and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("concentration", concentration);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByStrawQuantity(Long strawQuantity, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.strawQuantity = :strawQuantity  and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("strawQuantity", strawQuantity);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByDilution(String dilution, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.dilution like '%"+ dilution+ "%' and " +
                " s.sementalId = :sementalId"
               );

        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByTankNumber(Long tankNumber, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.tankNumber = :tankNumber  and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("tankNumber", tankNumber);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByCanisterNumber(Long canisterNumber, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.canisterNumber = :canisterNumber  and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("canisterNumber", canisterNumber);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByGobletNumber(Long gobletNumber, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.gobletNumber = :gobletNumber  and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("gobletNumber", gobletNumber);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByStrawColor(String strawColor, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.strawColor like '%"+strawColor + "%'"
               );

        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByPostThawMotility(Long postThawMotility, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.postThawMotility = :postThawMotility  and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("postThawMotility", postThawMotility);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByActiveDoses(Long activeDoses, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.activeDoses = :activeDoses  and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("activeDoses", activeDoses);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByStrawSize(Double strawSize, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.strawSize = :strawSize  and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("strawSize", strawSize);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findBySemenGatheringMethod(Long semenGatheringMethod, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering s, SemenGatheringMethod sgm " +
                " where s.semenGatheringMethodId = sgm.semenGatheringMethodId and " +
                " sgm.semenGatheringMethod = '"+semenGatheringMethod+" and " +
                " s.sementalId = :sementalId"
               );

        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByConsistency(String consistence, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.consistence = '"+consistence+"' and " +
                " s.sementalId = :sementalId"
               );

        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findBySemenColor(String semenColor, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.semenColor like '%"+semenColor+"%' and " +
                " s.sementalId = :sementalId"
               );

        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByPH(Long ph, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.ph = :ph and " +
                " s.sementalId = :sementalId"
               );
        q.setParameter("ph", ph);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findByMassMotility(Long massMotility, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering as s " +
                " where s.massMotility = :massMotility and" +
                " s.sementalId = :sementalId"
               );
        q.setParameter("massMotility", massMotility);
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    public List<Long> findBySolvent(Long solvent, Long sementalId) {
        Query q = em.createQuery(
                " Select s.semenGatheringId " +
                " from SemenGathering s, Solvent so " +
                " where s.solventId = so.solventId and " +
                " so.name = '"+solvent+"' and "+
                " so.sementalId = :sementalId"
               );
        q.setParameter("sementalId", sementalId);

        return  q.getResultList();
    }

    

}
