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
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.germplasm.SemenGathering;

/**
 *
 * @author dasolano
 */
@Local
public interface SemenGatheringEAOLocal extends BaseLocalEAO<SemenGathering,Long> {

    public Long countAllBySementalId(Long sementalId);

    public List<SemenGathering> findAllBySementalId(Long sementalId, int firstResult, int maxtResult);

    public List<Long> findBySemenGatheringDate(Calendar semenGatheringDate, Calendar finalSemenGatheringDate, Long sementalId);

    public List<Long> findBySemenGatheringTime(String time, Long sementalId);

    public List<Long> findByVolume(Double volume, Long sementalId);

    public List<Long> findByMotility(Long motility, Long sementalId);

    public List<Long> findByConcentration(Long concentration, Long sementalId);

    public List<Long> findByStrawQuantity(Long strawQuantity, Long sementalId);

    public List<Long> findByDilution(String dilution, Long sementalId);

    public List<Long> findByTankNumber(Long tankNumber, Long sementalId);

    public List<Long> findByCanisterNumber(Long canisterNumber, Long sementalId);

    public List<Long> findByGobletNumber(Long gobletNumber, Long sementalId);

    public List<Long> findByStrawColor(String strawColor, Long sementalId);

    public List<Long> findByPostThawMotility(Long postThawMotility, Long sementalId);

    public List<Long> findByActiveDoses(Long activeDoses, Long sementalId);

    public List<Long> findByStrawSize(Double strawSize, Long sementalId);

    public List<Long> findBySemenGatheringMethod(Long gatheringSemenMethod, Long sementalId);

    public List<Long> findByConsistency(String consistence, Long sementalId);

    public List<Long> findBySemenColor(String semenColor, Long sementalId);

    public List<Long> findByPH(Long ph, Long sementalId);

    public List<Long> findByMassMotility(Long massMotility, Long sementalId);

    public List<Long> findBySolvent(Long solvent, Long sementalId);

    public Long countCumulativeStrawQuantity(Long sementalId);
}
