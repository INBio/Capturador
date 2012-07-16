/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorComponentPart;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorComponentPartPK;

/**
 *
 * @author gsulca
 */
public class TaxonIndicatorComponentPartDTOFactory extends BaseEntityOrDTOFactory<TaxonIndicatorComponentPart ,TaxonIndicatorComponentPartDTO>{

    @Override
    public TaxonIndicatorComponentPart getEntityWithPlainValues(TaxonIndicatorComponentPartDTO dto) {
       if(dto==null){
            return null;
        }

        TaxonIndicatorComponentPart taxonIndicatorComponentPart = new TaxonIndicatorComponentPart();
        TaxonIndicatorComponentPartPK newTaxonIndicatorComponentPartPK = new TaxonIndicatorComponentPartPK(dto.getComponentPartId(), dto.getIndicatorId(), dto.getTaxonId());
        taxonIndicatorComponentPart.setTaxonIndicatorComponentPartPK(newTaxonIndicatorComponentPartPK);

        return taxonIndicatorComponentPart;

    }

    @Override
    public TaxonIndicatorComponentPart updateEntityWithPlainValues(TaxonIndicatorComponentPartDTO dto, TaxonIndicatorComponentPart e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TaxonIndicatorComponentPartDTO createDTO(TaxonIndicatorComponentPart entity) {
        TaxonIndicatorComponentPartDTO taxonIndicatorComponentPartDTO = new TaxonIndicatorComponentPartDTO();
        taxonIndicatorComponentPartDTO.setTaxonId(entity.getTaxonIndicatorComponentPartPK().getTaxonId());
        taxonIndicatorComponentPartDTO.setIndicatorId(entity.getTaxonIndicatorComponentPartPK().getIndicatorId());
        taxonIndicatorComponentPartDTO.setComponentPartId(entity.getTaxonIndicatorComponentPartPK().getComponentPartId());
        return taxonIndicatorComponentPartDTO;

    }

}
