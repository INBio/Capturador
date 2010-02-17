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


package org.inbio.ara.dto.agent;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.institution.Institution;

/**
 *
 * @author esmata
 */
public class InstitutionDTOFactory extends BaseDTOFactory<Institution,InstitutionDTO>{

    public InstitutionDTO createDTO(Institution entity) {
        if(entity==null){
            return null;
        }

        InstitutionDTO result = new InstitutionDTO();

        result.setInstitutionId(entity.getInstitutionId());
        result.setInstitutionName(entity.getName());
        result.setInstitutionCode(entity.getInstitutionCode());
        result.setAcronym(entity.getAcronym());
        result.setCity(entity.getCity());
        result.setCountry(entity.getCountry());
        result.setFax(entity.getFax());        
        result.setMultimediaId(entity.getMultimediaId());
        result.setStateProvince(entity.getStateProvince());
        result.setStreetAddress(entity.getStreetAddress());
        result.setTelephone(entity.getTelephone());
        result.setUrl(entity.getUrl());
        //seleted is used in the Graphical Interface, should be set in false
        result.setSelected(false);

        return result;
    }

    public Institution createEntity(InstitutionDTO dto) {
        if(dto==null){
            return null;
        }

        Institution result = new Institution();

        result.setInstitutionId(dto.getInstitutionId());
        result.setName(dto.getInstitutionName());
        result.setInstitutionCode(dto.getInstitutionCode());
        result.setAcronym(dto.getAcronym());
        result.setCity(dto.getCity());
        result.setCountry(dto.getCountry());
        result.setFax(dto.getFax());
        result.setMultimediaId(dto.getMultimediaId());
        result.setStateProvince(dto.getStateProvince());
        result.setStreetAddress(dto.getStreetAddress());
        result.setTelephone(dto.getTelephone());
        result.setUrl(dto.getUrl());

        return result;
    }

}
