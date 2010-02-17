/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.webService.taxonomy;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;
import org.inbio.ara.facade.taxonomy.TaxonomyFacadeRemote;

/**
 *
 * @author gsulca
 */
@WebService()
@Stateless()

public class TaxonomyWebService {
    //Injection
    @EJB
    private TaxonomyFacadeRemote taxonFacade;

    /**
     * Web service
     */
    @WebMethod(operationName = "getTaxonByGatheringObservation")
    public String getTaxonByGatheringObservation(@WebParam(name = "gathObsId")
    String gathObsId) {
        List<String> scientificNames = taxonFacade.getDefaultNameByGathObsId(Long.parseLong(gathObsId));
        String result = scientificNames.toString();
        return result.substring(1, result.length()-1);
    }


}
