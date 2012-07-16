/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.TaxonCountry;
import org.inbio.ara.persistence.taxonomy.TaxonCountryPK;

/**
 *
 * @author gsulca
 */
public class TaxonCountryDTOFactory extends BaseEntityOrDTOFactory<TaxonCountry ,TaxonCountryDTO>{

    @Override
    public TaxonCountry getEntityWithPlainValues(TaxonCountryDTO dto) {
         if(dto==null){
            return null;
        }

        TaxonCountry taxonCountry = new TaxonCountry();
        TaxonCountryPK newTaxonCountryPK = new TaxonCountryPK(dto.getTaxonId(),dto.getCountryId());
        taxonCountry.setTaxonCountryPK(newTaxonCountryPK);
        taxonCountry.setDescription(dto.getDescription());

        return taxonCountry;
    }

    @Override
    public TaxonCountry updateEntityWithPlainValues(TaxonCountryDTO dto, TaxonCountry entity) {
        if(dto == null || entity == null)
        {
            return null;
        }
        else
        {
            entity.getTaxonCountryPK().setTaxonId(dto.getTaxonId());
            entity.getTaxonCountryPK().setCountryId(dto.getCountryId());
            entity.setDescription(dto.getDescription());


            return entity;
        }
    }

    public TaxonCountryDTO createDTO(TaxonCountry entity) {
        TaxonCountryDTO taxonCountryDTO = new TaxonCountryDTO();
        taxonCountryDTO.setTaxonId(entity.getTaxonCountryPK().getTaxonId());
        taxonCountryDTO.setCountryId(entity.getTaxonCountryPK().getCountryId());
        taxonCountryDTO.setDescription(entity.getDescription());
        return taxonCountryDTO;
    }

}
