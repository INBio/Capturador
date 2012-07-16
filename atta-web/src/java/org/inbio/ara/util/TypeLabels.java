/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.util;


/**
 * Enum para manejar los identificadores y los nombres de la lista de los tipos de etiquetas, 
 * @author pcorrales
 */
public enum TypeLabels {
    
    LABEL(new Long(1),new String("label")),
    ERASE_LABEL(new Long(2),new String("eraser_history")),
    CORRECTION_LABEL(new Long(3),new String("correction_Label"));
    
    private Long id;
    private String resource;

    private  TypeLabels(Long id,String resource){
        this.id = id;
        this.resource = resource;
       
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * @param resource the resource to set
     */
    public void setResource(String resource) {
        this.resource = resource;
    }
}
