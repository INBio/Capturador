/* Ara - capture species and specimen data
 * 
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.persistence;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import org.inbio.ara.dto.inventory.SelectionListEntity;


/**
 * Entity class SelectionListGenericEntity
 *
 * Para que sea extendida por todas las listas de selección. 
 * 
 * Cada lista de selección debe mapear el elemento Id y SelectionListEntity e
 * implementar los métodos getId,  setId y getSelectionListEntity.
 *
 * Ejemplo:
 * El enum SelectionListEntity:
 * "private static final SelectionListEntity selectionListEntity = SelectionListEntity.SELECTION_LIST;"
 * Donde SELECTION_LIST es el tipo de lista de seleccion
 * 
 * @author jgutierrez
 */
@MappedSuperclass
public abstract class SelectionListGenericEntity extends GenericEntity {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;


    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description")
    private String description;


    /** Creates a new instance of selectionListEntity */
    public SelectionListGenericEntity() {
    }

    public abstract Long getId();

    public abstract void setId(Long id);

    public abstract SelectionListEntity getSelectionListEntity();

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
}