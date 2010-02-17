/*
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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
package org.inbio.ara.dto.security;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;

/**
 *
 * @author esmata
 */
public class NomenclaturalGroupDTOFactory extends
        BaseEntityOrDTOFactory<NomenclaturalGroup, NomenclaturalGroupDTO> {

    public NomenclaturalGroupDTO createDTO(NomenclaturalGroup entity) {
        if(entity == null) return null;

        NomenclaturalGroupDTO result = new NomenclaturalGroupDTO();
        result.setCollectionId(entity.getCollectionId());
        result.setDescription(entity.getDescription());
        result.setName(entity.getName());
        result.setNomenclaturalGroupId(entity.getNomenclaturalGroupId());
        result.setTemporality(entity.getTemporality());
        result.setCommonName(entity.getCommonName());
        result.setCertificatorPersonId(entity.getCertificatorPersonId());
        result.setNotes(entity.getNotes());
        return result;
    }

//    public NomenclaturalGroup createEntity(NomenclaturalGroupDTO dto) {
//        if(dto == null) {
//            return null;
//        }
//        NomenclaturalGroup entity = new NomenclaturalGroup();
//        entity.setName(dto.getName());
//        entity.setDescription(dto.getDescription());
//        entity.setTemporality(dto.getTemporality());
//        entity.setCommonName(dto.getCommonName());
//        entity.setCertificatorPersonId(dto.getCertificatorPersonId());
//        entity.setCollectionId(dto.getCollectionId());
//        entity.setNotes(dto.getNotes());
//        return entity;
//    }

    @Override
    public NomenclaturalGroup getEntityWithPlainValues(
            NomenclaturalGroupDTO dto) {
        if(dto == null) return null;

        NomenclaturalGroup entity = new NomenclaturalGroup();
        entity.setNomenclaturalGroupId(dto.getNomenclaturalGroupId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setTemporality(dto.getTemporality());
        entity.setCommonName(dto.getCommonName());
        entity.setCertificatorPersonId(dto.getCertificatorPersonId());
        entity.setCollectionId(dto.getCollectionId());
        entity.setNotes(dto.getNotes());
        return entity;
    }

    @Override
    public NomenclaturalGroup updateEntityWithPlainValues(
            NomenclaturalGroupDTO dto, NomenclaturalGroup entity) {
        if(dto == null || entity == null) return null;

        entity.setNomenclaturalGroupId(dto.getNomenclaturalGroupId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setTemporality(dto.getTemporality());
        entity.setCommonName(dto.getCommonName());
        entity.setCertificatorPersonId(dto.getCertificatorPersonId());
        entity.setCollectionId(dto.getCollectionId());
        entity.setNotes(dto.getNotes());
        return entity;
    }

}
