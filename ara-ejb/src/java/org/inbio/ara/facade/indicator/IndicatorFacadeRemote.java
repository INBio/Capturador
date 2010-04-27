/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.indicator;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.persistence.indicator.ComponentPart;

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


    
}
