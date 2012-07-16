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

package org.inbio.ara.persistence.gis;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "site_coordinate")
public class SiteCoordinate extends GenericEntity {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SiteCoordinate")
	@SequenceGenerator(name="SiteCoordinate", sequenceName="site_coordinate_seq")
    @Basic(optional = false)
    @Column(name = "site_coordinate_id")
    private Long siteCoordinateId;

    @Basic(optional = false)
    @Column(name = "longitude")
    private Double longitude;

    @Basic(optional = false)
    @Column(name = "latitude")
    private Double latitude;

    @Basic(optional = false)
    @Column(name = "sequence")
    private Long sequence;

    @Column(name = "original_x")
    private String originalX;

    @Column(name = "original_y")
    private String originalY;


    @JoinColumn(name = "site_id", referencedColumnName = "site_id")
    @ManyToOne()
    private Site site;

    public SiteCoordinate() {
    }

    public SiteCoordinate(Long siteCoordinateId) {
        this.siteCoordinateId = siteCoordinateId;
    }

    public SiteCoordinate(Long siteCoordinateId, Double longitude,
            Double latitude, Long sequence, String createdBy,
            Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.siteCoordinateId = siteCoordinateId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.sequence = sequence;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSiteCoordinateId() {
        return siteCoordinateId;
    }

    public void setSiteCoordinateId(Long siteCoordinateId) {
        this.siteCoordinateId = siteCoordinateId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getOriginalX() {
        return originalX;
    }

    public void setOriginalX(String originalX) {
        this.originalX = originalX;
    }

    public String getOriginalY() {
        return originalY;
    }

    public void setOriginalY(String originalY) {
        this.originalY = originalY;
    }

//    public Long getObjVersion() {
//        return objVersion;
//    }
//
//    public void setObjVersion(Long objVersion) {
//        this.objVersion = objVersion;
//    }

    public Site getSiteId() {
        return site;
    }

    public void setSiteId(Site siteId) {
        this.site = siteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteCoordinateId != null ? siteCoordinateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteCoordinate)) {
            return false;
        }
        SiteCoordinate other = (SiteCoordinate) object;
        if ((this.siteCoordinateId == null && other.siteCoordinateId != null) || (this.siteCoordinateId != null && !this.siteCoordinateId.equals(other.siteCoordinateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.SiteCoordinate[siteCoordinateId=" + siteCoordinateId + "]";
    }

}
