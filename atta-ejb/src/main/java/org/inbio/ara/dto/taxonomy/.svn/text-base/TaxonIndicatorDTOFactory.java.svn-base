/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.TaxonIndicator;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorPK;

/**
 *
 * @author gsulca
 */
public class TaxonIndicatorDTOFactory extends BaseEntityOrDTOFactory<TaxonIndicator ,TaxonIndicatorDTO>{

     @Override
    public TaxonIndicator getEntityWithPlainValues(TaxonIndicatorDTO dto) {
        //throw new UnsupportedOperationException("Not supported yet.");
        if(dto==null){
            return null;
        }
        
        TaxonIndicator taxonIndicator = new TaxonIndicator();
        TaxonIndicatorPK newTaxonIndicatorPK = new TaxonIndicatorPK(dto.getIndicatorId(), dto.getTaxonId());
        taxonIndicator.setTaxonIndicatorPK(newTaxonIndicatorPK);
        
        taxonIndicator.setValuerPersonId(dto.getValuerPersonId());


        taxonIndicator.setCertaintyLevel(null);
        taxonIndicator.setEvaluationCriteria(null);
        taxonIndicator.setNotes(null);
        taxonIndicator.setRegionality(null);
        taxonIndicator.setTemporality(null);
        //taxonIndicator.setValuerPersonId(null);

        
        return taxonIndicator;
    }

    @Override
    public TaxonIndicator updateEntityWithPlainValues(TaxonIndicatorDTO dto, TaxonIndicator e) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    public TaxonIndicatorDTO createDTO(TaxonIndicator entity) {
        //throw new UnsupportedOperationException("Not supported yet.");
        
         TaxonIndicatorDTO taxonIndicatorDTO = new TaxonIndicatorDTO();

        taxonIndicatorDTO.setTaxonId(entity.getTaxonIndicatorPK().getTaxonId());

        taxonIndicatorDTO.setIndicatorId(entity.getTaxonIndicatorPK().getIndicatorId());

        taxonIndicatorDTO.setCertainLevel(entity.getCertaintyLevel());
        taxonIndicatorDTO.setEvaluationCriteria(entity.getEvaluationCriteria());
        taxonIndicatorDTO.setNotes(entity.getNotes());
        taxonIndicatorDTO.setRegionality(entity.getRegionality());
        taxonIndicatorDTO.setValuerPersonId(entity.getValuerPersonId());
        
        return taxonIndicatorDTO;
    }


}
