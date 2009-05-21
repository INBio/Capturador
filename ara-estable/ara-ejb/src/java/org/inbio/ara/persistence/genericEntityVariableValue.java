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
 * genericEntityVariableValue.java
 *
 * Created on April 22, 2008, 5:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author roaguilar
 */
public class genericEntityVariableValue extends selectionListEntity {
    
    @Column(name="value_id",nullable = false)
    private Long valueId;
    
    /** Creates a new instance of genericEntityVariableValue */
    public genericEntityVariableValue() {
    }

    public Long getId() {
        return valueId;
    }

    public void setId(Long valueId) {
        this.valueId = valueId;
    }
    
}
