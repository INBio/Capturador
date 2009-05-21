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
/*
 * UserNomenclaturalGroup.java
 *
 * Created on April 28, 2008, 12:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.security;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;

/**
 *
 * @author roaguilar
 */

@Entity
@Table(name = "user_nomenclatural_group")
public class UserNomenclaturalGroup extends genericEntity{
    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    private UserNomenclaturalGroupPK userNomenclaturalGroupPK;
    
    /** Creates a new instance of UserNomenclaturalGroup */
    public UserNomenclaturalGroup() {
    }
    
     /**
     * Creates a new instance of UserNomenclaturalGroup with the specified values.
     * @param userTaxonPK the userTaxonPK of the UserNomenclaturalGroup
     */
    public UserNomenclaturalGroup(UserNomenclaturalGroupPK userNomenclaturalGroupPK) {
        this.userNomenclaturalGroupPK = userNomenclaturalGroupPK;
    }
    
    public UserNomenclaturalGroup(Long userId, Long nomenclaturalGroupId, Long sequence) {
        this.userNomenclaturalGroupPK = new UserNomenclaturalGroupPK(userId, nomenclaturalGroupId, sequence);
    }

    public UserNomenclaturalGroupPK getUserNomenclaturalGroupPK() {
        return userNomenclaturalGroupPK;
    }

    public void setUserNomenclaturalGroupPK(UserNomenclaturalGroupPK userNomenclaturalGroupPK) {
        this.userNomenclaturalGroupPK = userNomenclaturalGroupPK;
    }
}
