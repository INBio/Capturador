/* Ara - capture species and specimen data
 *
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

package org.inbio.ara.dto.agent;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.person.Profile;

/**
 *
 * @author esmata
 */
public class ProfileDTOFactory extends BaseEntityOrDTOFactory<Profile,ProfileDTO>{

    @Override
    public Profile getEntityWithPlainValues(ProfileDTO dto) {
        if(dto==null){
            return null;
        }
        Profile result = new Profile();
        result.setProfileId(dto.getProfileId());
        result.setDescription(dto.getDescription());
        result.setName(dto.getName());
        return result;
    }

    @Override
    public Profile updateEntityWithPlainValues(ProfileDTO dto, Profile e) {
        if(dto==null||e==null){
            return null;
        }
        else{
            e.setDescription(dto.getDescription());
            e.setName(dto.getName());
            e.setProfileId(dto.getProfileId());
            return e;
        }
    }

    public ProfileDTO createDTO(Profile entity) {
        if(entity==null){
            return null;
        }
        ProfileDTO result = new ProfileDTO();
        result.setDescription(entity.getDescription());
        result.setName(entity.getName());
        result.setProfileId(entity.getProfileId());
        result.setSelected(false); //Inicialmente debe ser false
        return result;
    }

}
