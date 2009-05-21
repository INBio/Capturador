/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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

package org.inbio.ara.dto.factory;

import org.inbio.ara.dto.LifeStageSexDTO;
import org.inbio.ara.persistence.specimen.LifeStage;
import org.inbio.ara.persistence.specimen.Sex;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSex;

/**
 *
 * @author jgutierrez
 */
public class LifeStageSexDTOFactory extends BaseDTOFactory{

    public LifeStageSexDTO createDTO(LifeStage lifeStage, Sex sex, String quantity) {
        if(lifeStage == null || sex == null)
            return null;

        LifeStageSexDTO lssDTO = new LifeStageSexDTO();
        lssDTO.setLifeStageKey(lifeStage.getId());
        lssDTO.setSexKey(sex.getId());
        lssDTO.setLifeStageName(lifeStage.getName());
        lssDTO.setSexName(sex.getName());
        lssDTO.setQuantity(quantity);

        return lssDTO;
    }

    public Object createDTO(Object entity) {
        if(entity == null)
            return null;

        SpecimenLifeStageSex slss = (SpecimenLifeStageSex) entity;

        LifeStageSexDTO lssDTO = new LifeStageSexDTO();
        lssDTO.setLifeStageKey(slss.getLifeStage().getId());
        lssDTO.setSexKey(slss.getSex().getId());
        lssDTO.setLifeStageName(slss.getLifeStage().getName());
        lssDTO.setSexName(slss.getSex().getName());
        lssDTO.setQuantity(slss.getQuantity().toString());

        return lssDTO;
    }

}
