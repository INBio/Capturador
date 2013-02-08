/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.inbio.ara.dto.inventory;

import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.identification.Identification;

/**
 *
 * @author asanabria
 */
public class IdentificationDTOFactory extends BaseDTOFactory<Identification, IdentificationDTO> {

	/**
     *
     * @param entitiesList
     * @return
     */
	@Override
	public List<IdentificationDTO> createDTOList(List identifcationsList) {
		if(identifcationsList==null)
			return null;

		List<IdentificationDTO> dtoList = new ArrayList<IdentificationDTO>();
		
		for (Object entity: identifcationsList)
			dtoList.add(this.createDTO((ArrayList<Identification>)entity));

		return dtoList;
	}

	/**
	 *
	 * @param s
	 * @return
	 */
	public IdentificationDTO createDTO(List<Identification> iList) {

		List<TaxonDTO> tList = null;
		TaxonDTOFactory taxonDTOFactory = null;

		IdentificationDTO iDTO = null;

		
		if (iList == null || iList.size() == 0) {
			return null;
		}

		// crea el DTO a retornar.
		iDTO = new IdentificationDTO();

        if(iList.size() > 1){
            iDTO.setMultitaxon(true);
        }

		// Toma el primer valor de la identificacion y lo guarda.
		Identification i = iList.get(0);

		if (i.getIdentificationPK() != null) {
			iDTO.setSpecimenKey(i.getIdentificationPK().getSpecimenId());
			iDTO.setInitialTimeStamp(i.getIdentificationPK().getInitialTimestamp());
		}

		if (i.getSpecimen() != null) {
			iDTO.setCatalogNumber(i.getSpecimen().getCatalogNumber());
                        iDTO.setGatheringObservationId(i.getSpecimen().getGatheringObservation().getGatheringObservationId());
		}

		if (i.getIdentificationStatus() != null) {
			iDTO.setStatusName(i.getIdentificationStatus().getName());
			iDTO.setStatusId(i.getIdentificationStatus().getIdentificationStatusId());
		}

		if (i.getIdentificationType() != null) {
			iDTO.setTypeName(i.getIdentificationType().getName());
			iDTO.setTypeId(i.getIdentificationType().getIdentificationTypeId());
		}

		PersonDTOFactory personDTOFactory = new PersonDTOFactory();

		if(i.getValuerPerson() != null){
			iDTO.setValuerPerson(personDTOFactory.createDTO(i.getValuerPerson()));
			iDTO.setValuerPersonName(i.getValuerPerson().getNaturalLongName());
		}

		iDTO.setDataEntryError(i.getDataEntryError());

		if (i.getIdentifiers() != null) {
			IdentifierDTOFactory iDTOF = new IdentifierDTOFactory();
			iDTO.setIdentifiers(iDTOF.createDTOList(i.getIdentifiers()));
		}
		
		/* en el caso de que sea multitaxon se asignan todos los taxones a la
		 * misma lista del DTO
		 */
		tList = new ArrayList<TaxonDTO>();
		taxonDTOFactory = new TaxonDTOFactory();

		for (Identification ident : iList) {
			tList.add(taxonDTOFactory.createDTO(ident.getTaxon()));
		}
		iDTO.setTaxa(tList);

		return iDTO;
	}
	/**
	 *
	 * @deprecated No USAR: al ser Multi-Taxon las identificaciones se deben
	 * manejar como <code>List<Identification></code>
	 * @param entity
	 * @return
	 */
	public IdentificationDTO createDTO(Identification i) {
		//throw new UnsupportedOperationException("Not supported yet.");
            List<TaxonDTO> tList = null;
            TaxonDTOFactory taxonDTOFactory = null;
            IdentificationDTO iDTO = new IdentificationDTO();
            if (i.getIdentificationPK() != null) {
			iDTO.setSpecimenKey(i.getIdentificationPK().getSpecimenId());
			iDTO.setInitialTimeStamp(i.getIdentificationPK().getInitialTimestamp());
		}

		if (i.getSpecimen() != null) {
			iDTO.setCatalogNumber(i.getSpecimen().getCatalogNumber());
                        iDTO.setGatheringObservationId(i.getSpecimen().getGatheringObservation().getGatheringObservationId());
		}

		if (i.getIdentificationStatus() != null) {
			iDTO.setStatusName(i.getIdentificationStatus().getName());
			iDTO.setStatusId(i.getIdentificationStatus().getIdentificationStatusId());
		}

		if (i.getIdentificationType() != null) {
			iDTO.setTypeName(i.getIdentificationType().getName());
			iDTO.setTypeId(i.getIdentificationType().getIdentificationTypeId());
		}

		PersonDTOFactory personDTOFactory = new PersonDTOFactory();

		if(i.getValuerPerson() != null){
			iDTO.setValuerPerson(personDTOFactory.createDTO(i.getValuerPerson()));
			iDTO.setValuerPersonName(i.getValuerPerson().getNaturalLongName());
		}

		iDTO.setDataEntryError(i.getDataEntryError());

		if (i.getIdentifiers() != null) {
			IdentifierDTOFactory iDTOF = new IdentifierDTOFactory();
			iDTO.setIdentifiers(iDTOF.createDTOList(i.getIdentifiers()));
		}

                tList = new ArrayList<TaxonDTO>();
		taxonDTOFactory = new TaxonDTOFactory();

		tList.add(taxonDTOFactory.createDTO(i.getTaxon()));

		iDTO.setTaxa(tList);


            return iDTO;
	}
	
}