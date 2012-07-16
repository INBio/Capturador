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

package org.inbio.ara.dto.gis;

/**
 *
 * @author esmata
 */
public class SiteCalculationMethodDTO {

    //Constructor
    public SiteCalculationMethodDTO(){
    }

    private Long siteCalculationMethodId;
    private String name;
    private String description;

    /**
     * @return the siteCalculationMethodId
     */
    public Long getSiteCalculationMethodId() {
        return siteCalculationMethodId;
    }

    /**
     * @param siteCalculationMethodId the siteCalculationMethodId to set
     */
    public void setSiteCalculationMethodId(Long siteCalculationMethodId) {
        this.siteCalculationMethodId = siteCalculationMethodId;
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

}
