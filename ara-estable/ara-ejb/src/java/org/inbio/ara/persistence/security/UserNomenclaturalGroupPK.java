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
 * UserNomenclaturalGroupPK.java
 *
 * Created on April 28, 2008, 12:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.security;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roaguilar
 */
@Embeddable
public class UserNomenclaturalGroupPK implements Serializable{
    
    @Column(name="user_id")
    private Long userId;
    
    @Column(name="nomenclatural_group_id")
    private Long nomenclaturalGroupId;
    
    @Column(name="sequence")
    private Long sequence;
    
    /** Creates a new instance of UserNomenclaturalGroupPK */
    public UserNomenclaturalGroupPK() {
    }
    
    public UserNomenclaturalGroupPK(Long userId, Long nomenclaturalGroupId, Long sequence) {
        this.setUserId(userId);
        this.setNomenclaturalGroupId(nomenclaturalGroupId);
        this.setSequence(sequence);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNomenclaturalGroupId() {
        return nomenclaturalGroupId;
    }

    public void setNomenclaturalGroupId(Long nomenclaturalGroupId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }
    
    
}
