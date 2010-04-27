/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.webService.indicator;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;
import org.inbio.ara.dto.indicator.IndicatorDTO;
import org.inbio.ara.facade.indicator.IndicatorFacadeRemote;

/**
 *
 * @author gsulca
 */
@WebService()
@Stateless()
public class IndicatorWebService {
//Injection
    @EJB
    private IndicatorFacadeRemote indicatorFacade;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getChildrenByIndicatorId")
    public String getChildrenByIndicatorId(@WebParam(name = "indicatorId")
    long indicatorId) {
        List<IndicatorDTO> indicatorChildren = indicatorFacade.getChildrenByIndicatorId(new Long(indicatorId));
        //System.out.print("Trajo la lista de indicadores hijo al WS");
        String result = "<indicatorChildren>";
        if(indicatorChildren != null){
            for(IndicatorDTO indicatorChild: indicatorChildren)
            {
                result += "<indicator>";
                result += "<id>"+indicatorChild.getIndicatorId()+"</id>";
                result += "<name>"+indicatorChild.getName()+"</name>";
                result += "</indicator>\n";
            }
        }
        result += "</indicatorChildren>";
        return result;
    }


    @WebMethod(operationName = "getIndicatorByIndicatorId")
    public String getIndicatorByIndicatorId(@WebParam(name = "indicatorId")
    long indicatorId) {
        IndicatorDTO indicatorChild = indicatorFacade.getIndicatorByIndicatorId(new Long(indicatorId));
        String result = "<indicatorNode>";
        if(indicatorChild != null){
            result += "<indicator>";
            result += "<id>"+indicatorChild.getIndicatorId()+"</id>";
            result += "<name>"+indicatorChild.getName()+"</name>";
            result += "<description>"+indicatorChild.getDescription()+"</description>";
            result += "<applyToParts>"+indicatorChild.getAppliesToParts()+"</applyToParts>";
            result += "</indicator>\n";            
        }
        result += "</indicatorNode>";
        return result;
    }
}
