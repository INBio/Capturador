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

    public List<Long> findBySemenGatheringDate(Calendar semenGatheringDate, Calendar finalSemenGatheringDate);

    public List<Long> findBySemenGatheringTime(String time);

    public List<Long> findByVolume(Long volume);

    public List<Long> findByMotility(Long motility);

    public List<Long> findByConcentration(Long concentration);

    public List<Long> findByStrawQuantity(Long strawQuantity);

    public List<Long> findByDilution(String dilution);

    public List<Long> findByTankNumber(Long tankNumber);

    public List<Long> findByCanisterNumber(Long canisterNumber);

    public List<Long> findByGobletNumber(Long gobletNumber);

    public List<Long> findByStrawColor(String strawColor);

    public List<Long> findByPostThawMotility(Long postThawMotility);

    public List<Long> findByActiveDoses(Long activeDoses);

    public List<Long> findByStrawSize(Double strawSize);

    public List<Long> findBySemenGatheringMethod(Long gatheringSemenMethod);

    public List<Long> findByConsistency(String consistence);

    public List<Long> findBySemenColor(String semenColor);

    public List<Long> findByPH(Long ph);

    public List<Long> findByMassMotility(Long massMotility);

    public List<Long> findBySolvent(Long solvent);
}
