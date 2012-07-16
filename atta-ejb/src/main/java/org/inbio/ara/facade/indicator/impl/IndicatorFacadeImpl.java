/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.indicator.impl;


import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.inbio.ara.facade.indicator.*;
import javax.ejb.Stateless;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.dto.indicator.IndicatorDTOFactory;
import org.inbio.ara.dto.indicator.IndicatorDublinCoreDTO;
import org.inbio.ara.dto.indicator.IndicatorDublinCoreDTOFactory;
import org.inbio.ara.eao.indicator.IndicatorDublinCoreEAOLocal;
import org.inbio.ara.eao.indicator.IndicatorEAOLocal;
import org.inbio.ara.persistence.indicator.Indicator;
import org.inbio.ara.persistence.indicator.IndicatorDublinCore;




/**
 *
 * @author gsulca
 */
@Stateless
public class IndicatorFacadeImpl implements IndicatorFacadeRemote {

      //Injections
     @EJB
     private IndicatorEAOLocal indicatorEAOImpl;

     @EJB
     private IndicatorDublinCoreEAOLocal indicatorDublinCoreEAOImpl;

     

    //DTO factories
    private IndicatorDTOFactory indicatorDTOFactory = new IndicatorDTOFactory();

    private IndicatorDublinCoreDTOFactory indicatorDublinCoreDTOFactory = new IndicatorDublinCoreDTOFactory();


    

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

    public void deleteIndicator(Long IndicatorId) {
        try
        {
            indicatorDublinCoreEAOImpl.deleteByIndicatorId(IndicatorId);
        }
        catch(Exception e)
        {
            System.out.println("NO TIENE RELACIONES CON DUBLIN CORE");
        }

        Indicator indicator = indicatorEAOImpl.findById(Indicator.class, IndicatorId);
        indicatorEAOImpl.delete(indicator);
    }

    public void saveIndicatorDublinCores(Long indicatorId, List<String> dublinCoreIds, String userName)
    {
        for(String dublinCoreId: dublinCoreIds)
        {
            IndicatorDublinCoreDTO newDTO = new IndicatorDublinCoreDTO();
            newDTO.setDublinCoreId(new Long(dublinCoreId));
            newDTO.setIndicatorId(indicatorId);
            newDTO.setUserName(userName);

            IndicatorDublinCore indicatorDublinCore = indicatorDublinCoreDTOFactory.createPlainEntity(newDTO);
            indicatorDublinCoreEAOImpl.create(indicatorDublinCore);
        }

    }

    public void deleteIndicatorDublinCoreByIndicator(Long indicatorId)
    {
        indicatorDublinCoreEAOImpl.deleteByIndicatorId(indicatorId);
        
    }


    public void deleteIndicatorDublinCoreById(Long indicatorId, Long dublinCoreId)
    {
        indicatorDublinCoreEAOImpl.deleteIndicatorDublinCoreById(indicatorId, dublinCoreId);
    }


    public void deleteIndicatorDublinCoreByIds(Long indicatorId, List<String> dublinCoreIds)
    {
        for(String dublinCoreId: dublinCoreIds)
        {
            indicatorDublinCoreEAOImpl.deleteIndicatorDublinCoreById(indicatorId, new Long(dublinCoreId));
        }
    }


    public Long countDublinCoreByIndicator(Long indicatorId)
    {
        return indicatorDublinCoreEAOImpl.countDublinCoreByIndicator(indicatorId);
    }

    

    public List<Long> getDublinCoreIdsByIndicator(Long indicatorId)
    {
        
        return indicatorDublinCoreEAOImpl.getDublinCoreByIndicator(indicatorId);
        
    }


}
