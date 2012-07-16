/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import java.util.Calendar;
import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.identification.Identification;
import org.inbio.ara.persistence.identification.IdentificationHistory;

/**
 *
 * @author asanabria
 */
public class IdentificationHistoryDTOFactory extends BaseDTOFactory<IdentificationHistory, IdentificationHistoryDTO> {

	public IdentificationHistoryDTO createDTO(IdentificationHistory entity) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public IdentificationHistory createEntity(Identification anIdentification){
		
		if(anIdentification == null)
			return null;

		// Crea el objeto de historial y le asigna los datos.
			IdentificationHistory anIdentificationHistory = new IdentificationHistory();
			anIdentificationHistory.setFinalTimestamp(Calendar.getInstance());
			anIdentificationHistory.setIdentificationHistoryDate(anIdentification.getIdentificationDate());

			if(anIdentification.getIdentificationPK() != null){
				anIdentificationHistory.setIdentificationSequence(anIdentification.getIdentificationPK().getIdentificationSequence());
				anIdentificationHistory.setInitialTimestamp(anIdentification.getIdentificationPK().getInitialTimestamp());
			}

			if(anIdentification.getIdentificationType() != null )
				anIdentificationHistory.setIdentificationTypeId(anIdentification.getIdentificationType().getIdentificationTypeId());

			if(anIdentification.getSpecimen() != null)
				anIdentificationHistory.setSpecimenId(anIdentification.getSpecimen().getSpecimenId());

			if(anIdentification.getTaxon() != null)
				anIdentificationHistory.setTaxonId(anIdentification.getTaxon().getTaxonId());

			if(anIdentification.getValuerPerson() != null)
				anIdentificationHistory.setValuerPersonId(anIdentification.getValuerPerson().getPersonId());

			anIdentificationHistory.setDataEntryError(anIdentification.getDataEntryError());
			anIdentificationHistory.setCreatedBy(anIdentification.getCreatedBy());
			anIdentificationHistory.setCreationDate(anIdentification.getCreationDate());
			anIdentificationHistory.setLastModificationBy(anIdentification.getLastModificationBy());
			anIdentificationHistory.setLastModificationDate(anIdentification.getLastModificationDate());

			return anIdentificationHistory;
	}
}
