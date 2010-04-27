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
        System.out.println("---> Apply to parts (facade) "+result.getAppliesToParts());
        return result;
    }

     public IndicatorDTO saveNewIndicator(IndicatorDTO iDTO)
     {

       
         
        indicatorEAOImpl.create(indicatorDTOFactory.createPlainEntity(iDTO));
       
        //Actualizar el CurrentDTO con el id asignado
        //IndicatorDTO result = indicatorDTOFactory.createDTO(indicator);


        //Retornar el nuevo dto
        return null;
    }

     public IndicatorDTO updateIndicator(IndicatorDTO iDTO)
     {
         Indicator indicator = indicatorEAOImpl.findById(Indicator.class, iDTO.getIndicatorId());
System.out.println("indicator id (facade impl) = "+ indicator.getIndicatorId());
         indicator.setName(iDTO.getName());
         indicator.setDescription(iDTO.getDescription());
         indicator.setAppliesToParts(iDTO.getAppliesToParts());
         indicator.setIndicatorAncestorId(iDTO.getIndicatorAncestorId());
System.out.println("indicator name (facade impl) = "+ indicator.getName());
System.out.println("indicator description (facade impl) = "+ indicator.getDescription());
System.out.println("indicator apply to parts (facade impl) = "+ indicator.getAppliesToParts());
System.out.println("indicator ancestor id (facade impl) = "+ indicator.getIndicatorAncestorId());

         indicatorEAOImpl.update(indicator);

         return null;
     }

 
}
