/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.indicator;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.indicator.Indicator;

/**
 *
 * @author gsulca
 */
public class IndicatorDTOFactory extends BaseEntityOrDTOFactory<Indicator ,IndicatorDTO>{

   

    @Override
    public Indicator updateEntityWithPlainValues(IndicatorDTO dto, Indicator e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public IndicatorDTO createDTO(Indicator entity) {
        IndicatorDTO indicatorDTO = new IndicatorDTO();
        indicatorDTO.setIndicatorId(entity.getIndicatorId());
        indicatorDTO.setName(entity.getName());
        indicatorDTO.setDescription(entity.getDescription());
        indicatorDTO.setAppliesToParts(entity.getAppliesToParts());
        Long indicatorAncestor = entity.getIndicatorAncestorId();
        if(indicatorAncestor != null)
        {
            indicatorDTO.setIndicatorAncestorId(indicatorAncestor);
        }
        return indicatorDTO;
    }


    @Override
    public Indicator getEntityWithPlainValues(IndicatorDTO dto) {
        if(dto==null){
            return null;
        }
        Indicator indicator = new Indicator();

        indicator.setName(dto.getName());
        indicator.setDescription(dto.getDescription());
        indicator.setAppliesToParts(dto.getAppliesToParts());
        indicator.setIndicatorAncestorId(dto.getIndicatorAncestorId());



        return indicator;
    }



}
