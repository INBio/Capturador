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
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;
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


    @WebMethod(operationName = "getTaxonRootByCollectionId")
    public String getTaxonRootByCollectionId(@WebParam(name = "collectionId")
    String collectionId) {
        TaxonDTO taxonRoot = taxonFacade.getTaxonRootByCollectionId(new Long(collectionId));
        TaxonomicalRangeDTO taxonomicalName = taxonFacade.getTaxonRangeName(taxonRoot.getTaxonomicalRangeId());

        String result = "<taxonRoot>";
        if(taxonRoot != null){
                result += "<taxon>";
                result += "<id>"+taxonRoot.getTaxonKey()+"</id>";
                result += "<name><![CDATA["+taxonRoot.getCurrentName()+" ("+taxonomicalName.getName()+")]]>"+"</name>";
                result += "</taxon>\n";
        }
        result += "</taxonRoot>";
        return result;
    }


    @WebMethod(operationName = "getChildrenByTaxonId")
    public List<TaxonDTO> getChildrenByTaxonId(@WebParam(name = "taxonId")
    String taxonId) {
        List<TaxonDTO> children = taxonFacade.getTaxonChildren(new Long(taxonId));
        System.out.println("children = "+children);
        
        for(TaxonDTO child: children)
        {
            TaxonomicalRangeDTO taxonomicalName = taxonFacade.getTaxonRangeName(child.getTaxonomicalRangeId());                     
            child.setCurrentName(child.getCurrentName()+" ("+taxonomicalName.getName()+")");            

        }
        
        /*
        String result = "<taxonomy>";
        if(children != null){
            for(TaxonDTO child: children)
            {
                TaxonomicalRangeDTO taxonomicalName = taxonFacade.getTaxonRangeName(child.getTaxonomicalRangeId());
                result += "<taxon>";
                result += "<id>"+child.getTaxonKey()+"</id>";
                result += "<name><![CDATA["+child.getCurrentName()+" ("+taxonomicalName.getName()+")]]>"+"</name>";
                result += "</taxon>\n";

            }
        }
        result += "</taxonomy>";
        return result;
         */
        return children;

    }

    @WebMethod(operationName = "getAllTaxonByRange")
    public String getAllTaxonByRange(@WebParam(name = "rangeId")
    String rangeId) {

        List<TaxonDTO> taxonDTOList = taxonFacade.getAllTaxonByRange(new Long(rangeId));

        String result = "<taxonomy>";
        if(taxonDTOList != null){
            for(TaxonDTO taxonDTO : taxonDTOList){
                TaxonomicalRangeDTO taxonomicalName = taxonFacade.getTaxonRangeName(taxonDTO.getTaxonomicalRangeId());
                result += "<taxon>";
                result += "<id>"+taxonDTO.getTaxonKey()+"</id>";
                result += "<name>"+taxonDTO.getCurrentName()+" ("+taxonomicalName.getName()+")"+"</name>";
                result += "</taxon>\n";

            }
        }
        result += "</taxonomy>";
        return result;

    }


    @WebMethod(operationName = "getNextLevelsByTaxon")
    public String getNextLevelsByTaxon(@WebParam(name = "taxonId")
    String taxonId) {

        List<TaxonomicalRangeDTO> taxonomicalRangeDTOList = taxonFacade.getNextLevelsByTaxonId(new Long(taxonId));

        String result = "<taxonomyRanges>";
        if(taxonomicalRangeDTOList != null){
            for(TaxonomicalRangeDTO taxonomicalRange : taxonomicalRangeDTOList){
                result += "<taxonRange>";
                result += "<id>"+taxonomicalRange.getTaxonomicalRangeKey()+"</id>";
                result += "<name>"+taxonomicalRange.getName()+"</name>";
                result += "</taxonRange>\n";
            }
        }
        result += "</taxonomyRanges>";
        return result;

    }


}
