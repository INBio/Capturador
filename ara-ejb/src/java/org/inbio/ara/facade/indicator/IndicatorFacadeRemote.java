/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.indicator;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.indicator.IndicatorDTO;

/**
 *
 * @author gsulca
 */
@Remote
public interface IndicatorFacadeRemote {

    public List<IndicatorDTO> getChildrenByIndicatorId(Long indicatorId);

    public IndicatorDTO getIndicatorByIndicatorId(Long indicatorId);

    public IndicatorDTO saveNewIndicator(IndicatorDTO iDTO);

    public IndicatorDTO updateIndicator(IndicatorDTO iDTO);

    public Long countChildrenByIndicatorId(Long indicatorId);

    public void deleteIndicator(Long IndicatorId);

    public void saveIndicatorDublinCores(Long indicatorId, List<String> dublinCoreIds, String userName);

    public Long countDublinCoreByIndicator(Long indicatorId);

    public List<Long> getDublinCoreIdsByIndicator(Long indicatorId);

    public void deleteIndicatorDublinCoreByIndicator(Long indicatorId);
    
}
