/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.indicator;

import java.util.GregorianCalendar;
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
        e.setName(dto.getName());
        e.setDescription(dto.getDescription());
        e.setAppliesToParts(dto.getAppliesToParts());
        e.setIndicatorAncestorId(dto.getIndicatorAncestorId());

        e.setLastModificationBy(dto.getUserName());
        e.setLastModificationDate(new GregorianCalendar());


        return e;
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
