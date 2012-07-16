/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.taxonomy.TaxonomicalRange;

/**
 *
 * @author asanabria
 */
public class TaxonomicalRangeDTOFactory extends BaseDTOFactory<TaxonomicalRange, TaxonomicalRangeDTO> {

	public TaxonomicalRangeDTO createDTO(TaxonomicalRange entity) {

		if(entity == null)
			return null;

		TaxonomicalRangeDTO trDTO = new TaxonomicalRangeDTO();

		trDTO.setTaxonomicalRangeKey(entity.getTaxonomicalRangeId());
		trDTO.setName(entity.getName());

		return trDTO;
	}
}
