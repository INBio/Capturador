/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.dto.germplasm;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.germplasm.PassportNomenclaturalGroup;
import org.inbio.ara.persistence.germplasm.PassportNomenclaturalGroupPK;

/**
 *
 * @author dasolano
 */
public class PassportNomenclaturalGroupDTOFactory extends BaseEntityOrDTOFactory<PassportNomenclaturalGroup ,PassportNomenclaturalGroupDTO>{

    @Override
    public PassportNomenclaturalGroup getEntityWithPlainValues(PassportNomenclaturalGroupDTO dto) {
        PassportNomenclaturalGroup entity = new PassportNomenclaturalGroup();
        PassportNomenclaturalGroupPK newPNGPK =
                new PassportNomenclaturalGroupPK(dto.getPassportId(), dto.getNomenclaturalGroupId());
        entity.setPassportNomenclaturalGroupPK(newPNGPK);

        return entity;
    }

    @Override
    public PassportNomenclaturalGroup updateEntityWithPlainValues(PassportNomenclaturalGroupDTO dto, PassportNomenclaturalGroup e) {
        /*e.getPassportNomenclaturalGroupPK().setNomenclaturalGroupId(
               dto.getNomenclaturalGroupId());
        e.getPassportNomenclaturalGroupPK().setPassportId(
                dto.getPassportId());*/


        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PassportNomenclaturalGroupDTO createDTO(PassportNomenclaturalGroup entity) {
        PassportNomenclaturalGroupDTO pngdto = new PassportNomenclaturalGroupDTO();

        pngdto.setNomenclaturalGroupId(entity.getPassportNomenclaturalGroupPK().
                getNomenclaturalGroupId());
        pngdto.setPassportId(entity.getPassportNomenclaturalGroupPK().
                getPassportId());

        return pngdto;
    }

}