/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.germoplasma;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.germoplasma.Passport;

/**
 *
 * @author dasolano
 */
@Local
public interface PassportEAOLocal extends BaseLocalEAO<Passport,Long>{

    /**
     * Find passports by material type id
     * @param materialTypeId
     * @return
     */
    public List<Long> findByMaterialTypeId(Long materialTypeId);

    /**
     * Find passports by gathering id
     * @param gatheringId
     * @return
     */
    public List<Long> findByGatheringId(Long gatheringId);

    /**
     * find passport by MissionNumber
     * @param missionNumber
     * @return
     */
    public List<Long> findByMissionNumber(Long missionNumber);

    /**
     * find passports by donor person id
     * @param donorPersonId
     * @return
     */
    public List<Long> findByDonorPersonId(Long donorPersonId);

    /**
     * find passport by donor institution id
     * @param donorInstitutionId
     * @return
     */
    public List<Long> findByDonorInstitutionId(Long donorInstitutionId);

    /**
     * find passports by plant nursery date
     * @param plantNurseryDate
     * @return
     */
    public List<Long> findByPlantNurseryDate(Calendar plantNurseryDate);

    /**
     * find passports by planting season date
     * @param plantingSeasonDate
     * @return
     */
    public List<Long> findByPlantingSeasonDate(Calendar plantingSeasonDate);

    /**
     * find passports by harvesting season date
     * @param harvestingSeasonDate
     * @return
     */
    public List<Long> findByHarvestingSeasonDate(Calendar harvestingSeasonDate);

    /**
     * find passports by sample status id
     * @param harvestingSeasonDate
     * @return
     */
    public List<Long> findBySampleStatusId(Long sampleStatusId);
}