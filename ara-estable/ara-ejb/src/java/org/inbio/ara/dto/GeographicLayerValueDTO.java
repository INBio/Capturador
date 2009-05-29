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
public class GeographicLayerValueDTO implements Serializable {


    /** Id del layer Actual, en tabla georeferencedSite**/
    private Long geographicLayerKey;

    /** El id en la tabla a la cual pertenece, en tabla pais, provincia, etc */
    private Long geographicLayerValueKey;

    private String name;

    /** El id en la tabla a la cual pertenece, en tabla pais, etc */
    private Long ancestorGeographicLayerValueKey;

    private String ancestorName;
    
    /**
     *
     */
    public GeographicLayerValueDTO() {
    }

    /**
     * 
     * @param geographicLayerKey
     * @param geographicLayerValueKey
     * @param name
     * @param ancestorGeographicLayerValueKey
     * @param ancestorName
     */
    public GeographicLayerValueDTO(Long geographicLayerKey, Long geographicLayerValueKey, String name, Long ancestorGeographicLayerValueKey, String ancestorName) {
        this.geographicLayerKey = geographicLayerKey;
        this.geographicLayerValueKey = geographicLayerValueKey;
        this.name = name;
        this.ancestorGeographicLayerValueKey = ancestorGeographicLayerValueKey;
        this.ancestorName = ancestorName;
    }

   
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the ancestorGeographicLayerValueKey
     */
    public Long getAncestorGeographicLayerValueKey() {
        return ancestorGeographicLayerValueKey;
    }

    /**
     * @param ancestorGeographicLayerValueKey the ancestorGeographicLayerValueKey to set
     */
    public void setAncestorGeographicLayerValueKey(Long ancestorGeographicLayerValueKey) {
        this.ancestorGeographicLayerValueKey = ancestorGeographicLayerValueKey;
    }

    /**
     * @return the ancestorName
     */
    public String getAncestorName() {
        return ancestorName;
    }

    /**
     * @param ancestorName the ancestorName to set
     */
    public void setAncestorName(String ancestorName) {
        this.ancestorName = ancestorName;
    }

    /**
     * @return the geographicLayerValueKey
     */
    public Long getGeographicLayerValueKey() {
        return geographicLayerValueKey;
    }

    /**
     * @param geographicLayerValueKey the geographicLayerValueKey to set
     */
    public void setGeographicLayerValueKey(Long geographicalLayerValueKey) {
        this.geographicLayerValueKey = geographicalLayerValueKey;
    }

    /**
     * @return the geographicLayerKey
     */
    public Long getGeographicLayerKey() {
        return geographicLayerKey;
    }

    /**
     * @param geographicLayerKey the geographicLayerKey to set
     */
    public void setGeographicLayerKey(Long geographicLayerKey) {
        this.geographicLayerKey = geographicLayerKey;
    }

}