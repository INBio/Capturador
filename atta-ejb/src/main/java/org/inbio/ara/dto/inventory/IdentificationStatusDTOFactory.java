/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.identification.IdentificationStatus;

/**
 *
 * @author asanabria
 */
public class IdentificationStatusDTOFactory extends BaseDTOFactory<IdentificationStatus, IdentificationStatusDTO> {

	public IdentificationStatusDTO createDTO(IdentificationStatus entity) {
		IdentificationStatusDTO aISDTO = null;

		if(entity != null){
			aISDTO = new IdentificationStatusDTO();
			aISDTO.setIdentificationStatusKey(entity.getIdentificationStatusId());
			aISDTO.setName(entity.getName());
			aISDTO.setDescription(entity.getDescription());
		}
		return aISDTO;
	}
}
