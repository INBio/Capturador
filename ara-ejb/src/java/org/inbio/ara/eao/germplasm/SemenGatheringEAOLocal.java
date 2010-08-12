/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

    public List<Long> findByVolume(Long volume, Long sementalId);

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
}
