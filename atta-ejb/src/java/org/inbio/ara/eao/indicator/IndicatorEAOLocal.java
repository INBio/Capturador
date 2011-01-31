/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.indicator;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.indicator.Indicator;


/**
 *
 * @author gsulca
 */
@Local
public interface IndicatorEAOLocal extends BaseLocalEAO<Indicator,Long>{

    public List<Long> findChildrenByIndicatorId(java.lang.Long indicatorId);

    public Long countByIndicatorId(Long indicatorNodeId);
    
}
