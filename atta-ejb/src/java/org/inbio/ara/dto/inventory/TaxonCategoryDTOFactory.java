/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.taxonomy.TaxonCategory;

/**
 *
 * @author esmata
 */
public class TaxonCategoryDTOFactory extends BaseDTOFactory<TaxonCategory,TaxonCategoryDTO>{

    public TaxonCategoryDTO createDTO(TaxonCategory entity) {
        if(entity==null){
            return null;
        }

        TaxonCategoryDTO result = new TaxonCategoryDTO();

        result.setTaxonCategoryId(entity.getTaxonCategoryId());
        result.setName(entity.getName());
        result.setDescription(entity.getDescription());

        return result;
    }

}
