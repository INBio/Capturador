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

package org.inbio.ara.eao.germplasm;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.germplasm.Passport;

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