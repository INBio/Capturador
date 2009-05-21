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
 * TheReferences.java
 *
 * Created on July 11, 2007, 2:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence;

import java.io.Serializable;

/**
 *
 * @author jgutierrez
 */
public class TheReferences implements Serializable {
    
    private Long referenceId;
    
    private String name;
    
    /** Creates a new instance of TheReferences */
    public TheReferences() {
    }
    
    public TheReferences(Long id, String value) {
        this.referenceId = id;
        this.name =  value;
    }
    
    
    /**
     * Gets the referenceId of this Person.
     *
     * @return the referenceId
     */
    public Long getTheReferencesId() {
        return this.referenceId;
    }
    
    /**
     * Sets the referenceId of this Person to the specified value.
     *
     * @param referenceId the new referenceId
     */
    public void setTheReferencesId(Long personId) {
        this.referenceId = personId;
    }
    
    /**
     * Gets the name of this Person.
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Sets the name of this Person to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
