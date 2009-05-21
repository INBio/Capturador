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
 * genericEntity.java
 *
 * Created on June 6, 2007, 4:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


/**
 * Entity class genericEntity
 * 
 * @author roaguilar
 */
@MappedSuperclass
public abstract class selectionListEntity extends genericEntity {

    @Column(name="name",nullable = false)
    private String name;
    
    @Column(name="description")
    private String description;
    
    /** Creates a new instance of selectionListEntity */
    public selectionListEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public abstract Long getId();

    public abstract void setId(Long id);
    
}