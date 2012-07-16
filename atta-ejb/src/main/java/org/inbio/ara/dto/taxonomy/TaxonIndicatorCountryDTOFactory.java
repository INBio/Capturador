/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorCountry;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorCountryPK;

/**
 *
 * @author gsulca
 */
public class TaxonIndicatorCountryDTOFactory extends BaseEntityOrDTOFactory<TaxonIndicatorCountry ,TaxonIndicatorCountryDTO>{

    @Override
    public TaxonIndicatorCountry getEntityWithPlainValues(TaxonIndicatorCountryDTO dto) {
         if(dto==null){
            return null;
        }

        TaxonIndicatorCountry taxonIndicatorCountry = new TaxonIndicatorCountry();
        TaxonIndicatorCountryPK newTaxonIndicatorCountryPK = new TaxonIndicatorCountryPK(dto.getCountryId(), dto.getIndicatorId(), dto.getTaxonId());
        taxonIndicatorCountry.setTaxonIndicatorCountryPK(newTaxonIndicatorCountryPK);            
        
        return taxonIndicatorCountry;
        
    }

    @Override
    public TaxonIndicatorCountry updateEntityWithPlainValues(TaxonIndicatorCountryDTO dto, TaxonIndicatorCountry e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TaxonIndicatorCountryDTO createDTO(TaxonIndicatorCountry entity) {

        TaxonIndicatorCountryDTO taxonIndicatorCountryDTO = new TaxonIndicatorCountryDTO();
        taxonIndicatorCountryDTO.setTaxonId(entity.getTaxonIndicatorCountryPK().getTaxonId());
        taxonIndicatorCountryDTO.setIndicatorId(entity.getTaxonIndicatorCountryPK().getIndicatorId());
        taxonIndicatorCountryDTO.setCountryId(entity.getTaxonIndicatorCountryPK().getCountryId());
        return taxonIndicatorCountryDTO;
        
    }

}
