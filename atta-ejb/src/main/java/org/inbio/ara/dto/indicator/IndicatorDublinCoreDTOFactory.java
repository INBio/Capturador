/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.indicator;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.indicator.IndicatorDublinCore;
import org.inbio.ara.persistence.indicator.IndicatorDublinCorePK;

/**
 *
 * @author gsulca
 */
public class IndicatorDublinCoreDTOFactory extends BaseEntityOrDTOFactory<IndicatorDublinCore ,IndicatorDublinCoreDTO> {

    @Override
    public IndicatorDublinCore getEntityWithPlainValues(IndicatorDublinCoreDTO dto) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if(dto==null){
            return null;
        }
        IndicatorDublinCore indicatorDublinCore = new IndicatorDublinCore();
        IndicatorDublinCorePK newIndicatorDublinCorePK = new IndicatorDublinCorePK(dto.getDublinCoreId(), dto.getIndicatorId());
        indicatorDublinCore.setIndicatorDublinCorePK(newIndicatorDublinCorePK);

        return indicatorDublinCore;
    }

    @Override
    public IndicatorDublinCore updateEntityWithPlainValues(IndicatorDublinCoreDTO dto, IndicatorDublinCore e) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    public IndicatorDublinCoreDTO createDTO(IndicatorDublinCore entity) {
        //throw new UnsupportedOperationException("Not supported yet.");
         IndicatorDublinCoreDTO indicatorDublinCoreDTO = new IndicatorDublinCoreDTO();

        indicatorDublinCoreDTO.setDublinCoreId(entity.getIndicatorDublinCorePK().getDublinCoreId());

        indicatorDublinCoreDTO.setIndicatorId(entity.getIndicatorDublinCorePK().getIndicatorId());

        return indicatorDublinCoreDTO;
    }

}
