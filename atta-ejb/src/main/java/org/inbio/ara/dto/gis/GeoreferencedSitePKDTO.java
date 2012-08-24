 /*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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
public class GeoreferencedSitePKDTO extends GenericDTO implements Serializable{

    public GeoreferencedSitePKDTO(){
    }

    private Long siteId;
    private Long geographicLayerId;
    private Long geographicSiteId;

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
     * @return the geographicLayerId
     */
    public Long getGeographicLayerId() {
        return geographicLayerId;
    }

    /**
     * @param geographicLayerId the geographicLayerId to set
     */
    public void setGeographicLayerId(Long geographicLayerId) {
        this.geographicLayerId = geographicLayerId;
    }

    /**
     * @return the geographicSiteId
     */
    public Long getGeographicSiteId() {
        return geographicSiteId;
    }

    /**
     * @param geographicSiteId the geographicSiteId to set
     */
    public void setGeographicSiteId(Long geographicSiteId) {
        this.geographicSiteId = geographicSiteId;
    }

}
