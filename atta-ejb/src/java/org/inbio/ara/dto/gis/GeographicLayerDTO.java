/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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

package org.inbio.ara.dto.gis;

import java.io.Serializable;

/**
 *
 * @author jgutierrez
 */
public class GeographicLayerDTO implements Serializable {


    /** Group key */
    private Long geographicalLayerKey;
    private String name;
    private String description;
    private Long ancestorKey;
    private String ancestorName;

    /**
     *Constructor
     */
    public GeographicLayerDTO() {
    }

    /**
     *
     * @param geographicalLayerKey
     * @param name
     * @param description
     * @param ancestorKey
     * @param ancestorName
     */
    public GeographicLayerDTO(Long geographicalLayerKey, String name, String description, Long ancestorKey, String ancestorName) {
        this.geographicalLayerKey = geographicalLayerKey;
        this.name = name;
        this.description = description;
        this.ancestorKey = ancestorKey;
        this.ancestorName = ancestorName;
    }

    public GeographicLayerDTO(String name,Long id){
        this.name = name;
        this.geographicalLayerKey = id;
    }

    /**
     * @return the geographicalLayerKey
     */
    public Long getGeographicalLayerKey() {
        return geographicalLayerKey;
    }

    /**
     * @param geographicalLayerKey the geographicalLayerKey to set
     */
    public void setGeographicalLayerKey(Long geographicalLayerKey) {
        this.geographicalLayerKey = geographicalLayerKey;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the ancestorKey
     */
    public Long getAncestorKey() {
        return ancestorKey;
    }

    /**
     * @param ancestorKey the ancestorKey to set
     */
    public void setAncestorKey(Long ancestorKey) {
        this.ancestorKey = ancestorKey;
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

}