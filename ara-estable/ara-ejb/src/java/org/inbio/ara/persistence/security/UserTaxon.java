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
 * UserTaxon.java
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
@Table(name = "user_taxon")
public class UserTaxon extends genericEntity{
    
    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    private UserTaxonPK userTaxonPK;
    
    /** Creates a new instance of UserTaxon */
    public UserTaxon() {
    }
    
     /**
     * Creates a new instance of UserTaxon with the specified values.
     * @param userTaxonPK the userTaxonPK of the UserTaxon
     */
    public UserTaxon(UserTaxonPK userTaxonPK) {
        this.userTaxonPK = userTaxonPK;
    }
    
    public UserTaxon(Long userId, Long taxonId, Long sequence) {
        this.userTaxonPK = new UserTaxonPK(userId, taxonId, sequence);
    }

    public UserTaxonPK getUserTaxonPK() {
        return userTaxonPK;
    }

    public void setUserTaxonPK(UserTaxonPK userTaxonPK) {
        this.userTaxonPK = userTaxonPK;
    }
}
