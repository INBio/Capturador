/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germoplasma.impl;

import java.util.Calendar;
import org.inbio.ara.eao.germoplasma.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.germoplasma.Passport;
import java.util.List;

/**
 *
 * @author dasolano
 */
@Stateless
public class PassportEAOImpl extends BaseEAOImpl<Passport, Long> implements PassportEAOLocal {

    /**
     * Find passports by material type id
     * @param materialTypeId
     * @return
     */
    public List<Long> findByMaterialType(Long materialTypeId) {
        Query q = em.createQuery(
                " Select p.passportId " +
                " from Passport as p " +
                " where p.materialtypeId = :materialTypeId "
               );
        q.setParameter("materialTypeId", materialTypeId);
        return  q.getResultList();
    }

    /**
     * Find passports by gathering id
     * @param gatheringId
     * @return
     */
    public List<Long> findByGatheringId(Long gatheringId) {
        Query q = em.createQuery(
                " Select p.passportId " +
                " from Passport as p " +
                " where p.gatheringId = :gatheringId "
               );
        q.setParameter("gatheringId", gatheringId);
        return  q.getResultList();
    }

    /**
     * find passport by MissionNumber
     * @param missionNumber
     * @return
     */
    public List<Long> findByMissionNumber(Long missionNumber) {
        Query q = em.createQuery(
                " Select p.passportId " +
                " from Passport as p " +
                " where p.missionNumber = :missionNumber "
               );
        q.setParameter("missionNumber", missionNumber);
        return  q.getResultList();
    }

    /**
     * find passports by donor person id
     * @param donorPersonId
     * @return
     */
    public List<Long> findByDonorPersonId(Long donorPersonId) {
        Query q = em.createQuery(
                " Select p.passportId " +
                " from Passport as p " +
                " where p.donorPersonId = :donorPersonId "
               );
        q.setParameter("donorPersonId", donorPersonId);
        return  q.getResultList();
    }

    /**
     * find passport by donor institution id
     * @param donorInstitutionId
     * @return
     */
    public List<Long> findByDonorInstitutionId(Long donorInstitutionId) {
        Query q = em.createQuery(
                " Select p.passportId " +
                " from Passport as p " +
                " where p.donorInstitutionId = :donorInstitutionId "
               );
        q.setParameter("donorInstitutionId", donorInstitutionId);
        return  q.getResultList();
    }

    /**
     * find passports by plant nursery date
     * @param plantNurseryDate
     * @return
     */
    public List<Long> findByPlantNurseryDate(Calendar plantNurseryDate) {
        Query q = em.createQuery(
                " Select p.passportId " +
                " from Passport as p " +
                " where p.plantNurseryDate = :plantNurseryDate "
               );
        q.setParameter("plantNurseryDate", plantNurseryDate);
        return  q.getResultList();
    }

    /**
     * find passports by planting season date
     * @param plantingSeasonDate
     * @return
     */
    public List<Long> findByPlantingSeasonDate(Calendar plantingSeasonDate) {
        Query q = em.createQuery(
                " Select p.passportId " +
                " from Passport as p " +
                " where p.plantingSeasonDate = :plantingSeasonDate "
               );
        q.setParameter("plantingSeasonDate", plantingSeasonDate);
        return  q.getResultList();
    }

    /**
     * find passports by harvesting season date
     * @param harvestingSeasonDate
     * @return
     */
    public List<Long> findByHarvestingSeasonDate(Calendar harvestingSeasonDate) {
        Query q = em.createQuery(
                " Select p.passportId " +
                " from Passport as p " +
                " where p.harvestingSeasonDate = :harvestingSeasonDate "
               );
        q.setParameter("harvestingSeasonDate", harvestingSeasonDate);
        return  q.getResultList();
    }

}