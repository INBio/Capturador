/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.identification.Identifier;

/**
 *
 * @author asanabria
 */
public class IdentifierDTOFactory extends BaseDTOFactory<Identifier, IdentifierDTO> {

	    public IdentifierDTO createDTO(Identifier i) {

		    IdentifierDTO iDTO = new IdentifierDTO();

		    if(i.getIdentifierPK() != null && i.getIdentifierPK().getIdentifierPerson() != null){
			    iDTO.setIdentifierKey(i.getIdentifierPK().getIdentifierPerson().getPersonId());
			    iDTO.setIdentifierName(i.getIdentifierPK().getIdentifierPerson().getNaturalFullName());
			    iDTO.setInitialTimeStamp(i.getIdentifierPK().getInitialTimestamp());
		    }

		    return iDTO;
	    }
}
