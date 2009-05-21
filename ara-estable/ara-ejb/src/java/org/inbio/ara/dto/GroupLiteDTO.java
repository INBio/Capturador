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
public class GroupLiteDTO implements Serializable {


    /** Group key */
    private Long groupKey;

    private String groupName;

    private String password;
    
    /**
     *
     */
    public GroupLiteDTO() {
    }

    /**
     * 
     * @param groupKey
     * @param groupName
     * @param password
     */
    public GroupLiteDTO(Long groupKey, String groupName, String password) {
        this.groupKey = groupKey;
        this.groupName = groupName;
        this.password = password;
    }


    /**
     * @return the groupKey
     */
    public Long getGroupKey() {
        return groupKey;
    }

    /**
     * @param groupKey the groupKey to set
     */
    public void setGroupKey(Long groupKey) {
        this.groupKey = groupKey;
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


}
