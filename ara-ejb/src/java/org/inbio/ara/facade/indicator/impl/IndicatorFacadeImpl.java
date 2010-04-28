/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.indicator.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.facade.indicator.*;
import javax.ejb.Stateless;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.dto.indicator.IndicatorDTOFactory;
import org.inbio.ara.eao.indicator.IndicatorEAOLocal;
import org.inbio.ara.persistence.indicator.Indicator;


/**
 *
 * @author gsulca
 */
@Stateless
public class IndicatorFacadeImpl implements IndicatorFacadeRemote {

      //Injections
     @EJB
     private IndicatorEAOLocal indicatorEAOImpl;


    //DTO factories
    private IndicatorDTOFactory indicatorDTOFactory = new IndicatorDTOFactory();

    public List<IndicatorDTO> getChildrenByIndicatorId(Long indicatorId) {
        
        List<Long> indicators = indicatorEAOImpl.findChildrenByIndicatorId(indicatorId);
        
        List<IndicatorDTO> indicatorChildren = new ArrayList() ;
        if(indicators!=null && indicators.size() !=0){
            for(Long indicatorChildId: indicators){
                Indicator child =  (Indicator) indicatorEAOImpl.findById (Indicator.class, indicatorChildId);
                //System.out.println(indicatorChildId+" -> "+child.getName());
                indicatorChildren.add(indicatorDTOFactory.createDTO(child));
            }
        }
        else
        {
         //indicatorChildren.add(new IndicatorDTO());
            indicatorChildren = null;
        }
        return indicatorChildren;
    }


    public IndicatorDTO getIndicatorByIndicatorId(Long indicatorId) {
        IndicatorDTO result;
        Indicator child =  (Indicator) indicatorEAOImpl.findById (Indicator.class, indicatorId);
        if(child !=null)
        {
         result = indicatorDTOFactory.createDTO(child);
        }
        else
        {
            result = null;
        }
        //System.out.println("---> Apply to parts (facade) "+result.getAppliesToParts());
        return result;
    }

    public Long countChildrenByIndicatorId(Long indicatorId)
    {
        return indicatorEAOImpl.countByIndicatorId(indicatorId);
    }

     public IndicatorDTO saveNewIndicator(IndicatorDTO iDTO)
     {

       
        Indicator indicator = indicatorDTOFactory.createPlainEntity(iDTO);
        indicatorEAOImpl.create(indicator);
       
        //Actualizar el CurrentDTO con el id asignado
        IndicatorDTO result = indicatorDTOFactory.createDTO(indicator);


        //Retornar el nuevo dto
        return result;
    }

     public IndicatorDTO updateIndicator(IndicatorDTO iDTO)
     {
         Indicator indicator = indicatorEAOImpl.findById(Indicator.class, iDTO.getIndicatorId());
         //System.out.println("************** Create by "+indicator.getCreatedBy());
         indicator = indicatorDTOFactory.updateEntityWithPlainValues(iDTO, indicator);

         indicatorEAOImpl.update(indicator);

         return null;
     }

    public void deletePassport(Long IndicatorId) {
        Indicator indicator = indicatorEAOImpl.findById(Indicator.class, IndicatorId);
        indicatorEAOImpl.delete(indicator);
    }

 
}
