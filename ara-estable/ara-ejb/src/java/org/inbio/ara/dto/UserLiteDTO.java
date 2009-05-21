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

package org.inbio.ara.dto;

import java.io.Serializable;

/**
 *
 * @author jgutierrez
 */
public class UserLiteDTO implements Serializable {


    /** User key */
    private Long userKey;

    private String userName;

    private String fullName;

    /**
     * 
     */
    public UserLiteDTO() {
    }

    /**
     * 
     * @param userKey
     * @param userName
     * @param fullName
     * @param password
	 * @param groupUserKey 
     */
    public UserLiteDTO(Long userKey, String userName, String fullName) {
        this.userKey = userKey;
        this.userName = userName;
        this.fullName = fullName;
    }


    /**
     * @return the userKey
     */
    public Long getUserKey() {
        return userKey;
    }

    /**
     * @param userKey the userKey to set
     */
    public void setUserKey(Long userKey) {
        this.userKey = userKey;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
