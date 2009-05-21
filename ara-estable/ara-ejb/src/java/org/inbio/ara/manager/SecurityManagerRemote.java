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

package org.inbio.ara.manager;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.GroupLiteDTO;
import org.inbio.ara.dto.UserFullDTO;
import org.inbio.ara.dto.UserLiteDTO;

/**
 *
 * @author jgutierrez
 */
@Remote
public interface SecurityManagerRemote {

    
    /**
     * 
     * @return
     */
    public List<UserLiteDTO> listAllUserLite();

    /**
     * 
     * @return
     */
    public List<GroupLiteDTO> listAllGroupsList();

    /**
     * Este método asume que el userLiteDTO viene con sus campos instanciados!
     *
     * @param userLiteDTO
     */
    public void addUser(UserFullDTO userDTO);

    /**
     * 
     * @param userKey
     */
    public void deleteUser(Long userKey);

	public UserFullDTO findById(Long id);

	public void updateUser(UserFullDTO id);

	public boolean verifyPassword(Long userId, String password);

	public void updatePassword(Long userId, String password);

}
