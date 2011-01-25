/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.TaxonAuthor;
import org.inbio.ara.persistence.taxonomy.TaxonAuthorPK;

/**
 *
 * @author gsulca
 */
public class TaxonAuthorDTOFactory extends BaseEntityOrDTOFactory<TaxonAuthor ,TaxonAuthorDTO> {

    @Override
    public TaxonAuthor getEntityWithPlainValues(TaxonAuthorDTO dto) {
        if(dto==null){
            return null;
        }

        TaxonAuthor taxonAuthor = new TaxonAuthor();
        TaxonAuthorPK newTaxonAuthorPK = new TaxonAuthorPK(dto.getTaxonId(),dto.getCategory(), dto.getTaxonAuthorSequence());
        taxonAuthor.setTaxonAuthorPK(newTaxonAuthorPK);

       taxonAuthor.setTaxonAuthorConnectorId(dto.getTaxonAuthorConnectorId());
       taxonAuthor.setTaxonAuthorPersonId(dto.getTaxonAuthorPersonId());


        return taxonAuthor;
    }

    @Override
    public TaxonAuthor updateEntityWithPlainValues(TaxonAuthorDTO dto, TaxonAuthor e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TaxonAuthorDTO createDTO(TaxonAuthor entity) {
        
        TaxonAuthorDTO taxonAuthorDTO = new TaxonAuthorDTO();

        taxonAuthorDTO.setTaxonId(entity.getTaxonAuthorPK().getTaxonId());
        taxonAuthorDTO.setCategory(entity.getTaxonAuthorPK().getCategory());
        taxonAuthorDTO.setTaxonAuthorSequence(entity.getTaxonAuthorPK().getTaxonAuthorSequence());

        taxonAuthorDTO.setTaxonAuthorConnectorId(entity.getTaxonAuthorConnectorId());
        taxonAuthorDTO.setTaxonAuthorPersonId(entity.getTaxonAuthorPersonId());

        

        return taxonAuthorDTO;
    }

}
