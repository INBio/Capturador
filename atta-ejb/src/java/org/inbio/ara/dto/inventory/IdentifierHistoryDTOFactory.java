/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.dto.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.identification.Identifier;
import org.inbio.ara.persistence.identification.IdentifierHistory;

/**
 *
 * @author asanabria
 */
public class IdentifierHistoryDTOFactory extends BaseDTOFactory<IdentifierHistory, IdentifierHistoryDTO> {

	public IdentifierHistoryDTO createDTO(IdentifierHistory entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public IdentifierHistory createEntity(Identifier ident) {

		IdentifierHistory anIdentifierHistory = new IdentifierHistory();

		anIdentifierHistory.setCreatedBy(ident.getCreatedBy());
		anIdentifierHistory.setCreationDate(ident.getCreationDate());
		anIdentifierHistory.setIdentificationSequence(ident.getIdentifierPK().getIdentificationSequence());
		anIdentifierHistory.setIdentifierPersonId(ident.getIdentifierPK().getIdentifierPerson().getPersonId());
		anIdentifierHistory.setIdentifierSequence(ident.getIdentifierSequence());
		anIdentifierHistory.setInitialTimestamp(ident.getIdentifierPK().getInitialTimestamp());
		anIdentifierHistory.setLastModificationBy(ident.getLastModificationBy());
		anIdentifierHistory.setLastModificationDate(ident.getLastModificationDate());
		anIdentifierHistory.setSpecimenId(ident.getIdentifierPK().getSpecimenId());

		return anIdentifierHistory;
	}
}
