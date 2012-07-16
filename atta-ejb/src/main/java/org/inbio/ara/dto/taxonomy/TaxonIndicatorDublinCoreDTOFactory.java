/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorDublinCore;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorDublinCorePK;

/**
 *
 * @author gsulca
 */
public class TaxonIndicatorDublinCoreDTOFactory extends BaseEntityOrDTOFactory<TaxonIndicatorDublinCore ,TaxonIndicatorDublinCoreDTO> {

    @Override
    public TaxonIndicatorDublinCore getEntityWithPlainValues(TaxonIndicatorDublinCoreDTO dto) {
        if(dto==null){
            return null;
        }

        TaxonIndicatorDublinCore taxonIndicatorDublinCore = new TaxonIndicatorDublinCore();
        TaxonIndicatorDublinCorePK newTaxonIndicatorDublinCorePK = new TaxonIndicatorDublinCorePK(dto.getDublinCoreId() ,dto.getIndicatorId(), dto.getTaxonId());
        taxonIndicatorDublinCore.setTaxonIndicatorDublinCorePK(newTaxonIndicatorDublinCorePK);

        return taxonIndicatorDublinCore;
    }

    @Override
    public TaxonIndicatorDublinCore updateEntityWithPlainValues(TaxonIndicatorDublinCoreDTO dto, TaxonIndicatorDublinCore e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TaxonIndicatorDublinCoreDTO createDTO(TaxonIndicatorDublinCore entity) {

        TaxonIndicatorDublinCoreDTO taxonIndicatorDublinCoreDTO = new TaxonIndicatorDublinCoreDTO();
        taxonIndicatorDublinCoreDTO.setTaxonId(entity.getTaxonIndicatorDublinCorePK().getTaxonId());
        taxonIndicatorDublinCoreDTO.setIndicatorId(entity.getTaxonIndicatorDublinCorePK().getIndicatorId());
        taxonIndicatorDublinCoreDTO.setDublinCoreId(entity.getTaxonIndicatorDublinCorePK().getDublinCoreId());
        return taxonIndicatorDublinCoreDTO;
        
    }


}
