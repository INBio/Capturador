package org.inbio.ara.webService.inventory;

import com.sun.faces.renderkit.html_basic.HtmlResponseWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;
import org.inbio.ara.dto.inventory.GatheringObservationDTO;
import org.inbio.ara.facade.inventory.InventoryFacadeRemote;

/**
 *
 * @author gsulca
 */
@WebService()
@Stateless()
public class InventoryWebService {

    //Injection
    @EJB
    private InventoryFacadeRemote inventoryFacade;



    /**
     * Web service
     */
    @WebMethod(operationName = "getGathObsBySiteId")
    public String getGathObsBySiteId(@WebParam(name = "siteId")
    String siteId) {
        //TODO write your implementation code here:
        List<GatheringObservationDTO> gathObs = inventoryFacade.getGathObsBySiteId(Long.parseLong(siteId));
        String result = "<gatheringObservations>";
        for(GatheringObservationDTO gatheringObservation: gathObs)
        {
            result += "<gathering>";
            result += "<id>"+gatheringObservation.getGatheringObservationId()+"</id>";
            result += "<responsible>"+gatheringObservation.getResponsibleName().trim()+"</responsible>";
            result += "<initialDate>"+gatheringObservation.getInitialDateTime().getTime().toString()+"</initialDate>";
            result += "<finalDate>"+gatheringObservation.getFinalDateTime().getTime().toString()+"</finalDate>";
            result += "</gathering>";
        }
        result += "</gatheringObservations>";
        return result;
    }

}

