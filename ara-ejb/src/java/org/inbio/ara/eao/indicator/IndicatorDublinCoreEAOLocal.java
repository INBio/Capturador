/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.indicator;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.indicator.IndicatorDublinCore;

/**
 *
 * @author gsulca
 */
@Local
public interface IndicatorDublinCoreEAOLocal extends BaseLocalEAO<IndicatorDublinCore,Long>{

    public Long countDublinCoreByIndicator(Long indicatorId);

    public List<Long> getDublinCoreByIndicator(
            Long indicatorId);

    public void deleteByIndicatorId(Long indicatorId);
    
}
