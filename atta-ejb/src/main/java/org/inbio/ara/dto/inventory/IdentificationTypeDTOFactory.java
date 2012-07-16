/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.identification.IdentificationType;

/**
 *
 * @author asanabria
 */
public class IdentificationTypeDTOFactory extends BaseDTOFactory<IdentificationType, IdentificationTypeDTO> {

	public IdentificationTypeDTO createDTO(IdentificationType entity) {
		IdentificationTypeDTO aITDTO = null;

		if(entity != null){
			aITDTO = new IdentificationTypeDTO();
			aITDTO.setIdentificationTypeKey(entity.getIdentificationTypeId());
			aITDTO.setName(entity.getName());
			aITDTO.setDescription(entity.getDescription());
		}
		return aITDTO;
	}
}
