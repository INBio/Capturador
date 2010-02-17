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

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author asanabria
 * modified by esmata
 */
public class PersonDTOFactory  extends BaseEntityOrDTOFactory<Person,PersonDTO>  {

	public PersonDTO createDTO(Person entity) {
		if(entity == null)
			return null;

		PersonDTO pDTO = new PersonDTO();

		pDTO.setPersonKey(entity.getPersonId());
		pDTO.setNaturalLongName(entity.getNaturalLongName());
        pDTO.setBirthYear(entity.getBirthYear());
        pDTO.setCity(entity.getCity());
        pDTO.setCountry(entity.getCountry());
        pDTO.setDeathYear(entity.getDeathYear());
        pDTO.setEmail(entity.getEmail());
        pDTO.setFax(entity.getFax());
        pDTO.setFirstName(entity.getFirstName());
        pDTO.setInitials(entity.getInitials());
        pDTO.setLastName(entity.getLastName());
        pDTO.setOccupation(entity.getOccupation());
        pDTO.setSecondLastName(entity.getSecondLastName());
        pDTO.setStateProvince(entity.getStateProvince());
        pDTO.setStreetAddress(entity.getStreetAddress());
        pDTO.setTelephone(entity.getTelephone());
        pDTO.setUrl(entity.getUrl());
        pDTO.setSelected(false);

		return pDTO;
	}

    @Override
    public Person getEntityWithPlainValues(PersonDTO dto) {
        if(dto==null){
            return null;
        }
        Person p = new Person();

		p.setPersonId(dto.getPersonKey());
        p.setBirthYear(dto.getBirthYear());
        p.setCity(dto.getCity());
        p.setCountry(dto.getCountry());
        p.setDeathYear(dto.getDeathYear());
        p.setEmail(dto.getEmail());
        p.setFax(dto.getFax());
        p.setFirstName(dto.getFirstName());
        p.setInitials(dto.getInitials());
        p.setLastName(dto.getLastName());
        p.setOccupation(dto.getOccupation());
        p.setSecondLastName(dto.getSecondLastName());
        p.setStateProvince(dto.getStateProvince());
        p.setStreetAddress(dto.getStreetAddress());
        p.setTelephone(dto.getTelephone());
        p.setUrl(dto.getUrl());

        return p;
    }

    @Override
    public Person updateEntityWithPlainValues(PersonDTO dto, Person e) {
        if(dto==null||e==null){
            return null;
        }
        else{
            e.setPersonId(dto.getPersonKey());
            e.setBirthYear(dto.getBirthYear());
            e.setCity(dto.getCity());
            e.setCountry(dto.getCountry());
            e.setDeathYear(dto.getDeathYear());
            e.setEmail(dto.getEmail());
            e.setFax(dto.getFax());
            e.setFirstName(dto.getFirstName());
            e.setInitials(dto.getInitials());
            e.setLastName(dto.getLastName());
            e.setOccupation(dto.getOccupation());
            e.setSecondLastName(dto.getSecondLastName());
            e.setStateProvince(dto.getStateProvince());
            e.setStreetAddress(dto.getStreetAddress());
            e.setTelephone(dto.getTelephone());
            e.setUrl(dto.getUrl());
            return e;
        }
    }
}
