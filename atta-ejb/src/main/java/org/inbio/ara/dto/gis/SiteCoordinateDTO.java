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

import java.io.Serializable;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author esmata
 */
public class SiteCoordinateDTO extends GenericDTO implements Serializable{

    
    //Constructor
    public SiteCoordinateDTO(){
    }

    private Long siteCoordinateId;
    private Double longitude;
    private Double latitude;
    private Long sequence;
    private String originalX;
    private String originalY;
    private String verbatimLongitude;
    private String verbatimLatitude;
    private Long siteId;

    /**
     * @return the siteCoordinateId
     */
    public Long getSiteCoordinateId() {
        return siteCoordinateId;
    }

    /**
     * @param siteCoordinateId the siteCoordinateId to set
     */
    public void setSiteCoordinateId(Long siteCoordinateId) {
        this.siteCoordinateId = siteCoordinateId;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the sequence
     */
    public Long getSequence() {
        return sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    /**
     * @return the originalX
     */
    public String getOriginalX() {
        return originalX;
    }

    /**
     * @param originalX the originalX to set
     */
    public void setOriginalX(String originalX) {
        this.originalX = originalX;
    }

    /**
     * @return the originalY
     */
    public String getOriginalY() {
        return originalY;
    }

    /**
     * @param originalY the originalY to set
     */
    public void setOriginalY(String originalY) {
        this.originalY = originalY;
    }

    /**
     * @return the siteId
     */
    public Long getSiteId() {
        return siteId;
    }

    /**
     * @param siteId the siteId to set
     */
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * @return the verbatimLongitude
     */
    public String getVerbatimLongitude() {
        return verbatimLongitude;
    }

    /**
     * @param verbatimLongitude the verbatimLongitude to set
     */
    public void setVerbatimLongitude(String verbatimLongitude) {
        this.verbatimLongitude = verbatimLongitude;
    }

    /**
     * @return the verbatimLatitude
     */
    public String getVerbatimLatitude() {
        return verbatimLatitude;
    }

    /**
     * @param verbatimLatitude the verbatimLatitude to set
     */
    public void setVerbatimLatitude(String verbatimLatitude) {
        this.verbatimLatitude = verbatimLatitude;
    }

}
