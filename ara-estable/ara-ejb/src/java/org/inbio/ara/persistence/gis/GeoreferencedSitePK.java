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
 * GeoreferencedSitePK.java
 *
 * Created on April 22, 2008, 10:49 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gis;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 *
 * @author roaguilar
 */
@Embeddable
public class GeoreferencedSitePK implements Serializable {
    
    @Column(name = "site_id", nullable = false)
    private Long siteId;

    @Column(name = "geographic_layer_id", nullable = false)
    private Long geographicLayerId;
    
    @Column(name = "geographic_site_id", nullable = false)
    private Long geographicSiteId;    
    
    /** Creates a new instance of GeoreferencedSitePK */
    public GeoreferencedSitePK() {
    }
    
    public GeoreferencedSitePK(Long siteId, Long geographicLayerId, Long geographicSiteId) {
        this.setSiteId(siteId);
        this.setGeographicLayerId(geographicLayerId);
        this.setGeographicSiteId(geographicSiteId);
    }
    
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.siteId != null ? this.siteId.hashCode() : 0);
        hash += (this.getGeographicLayerId() != null ? this.getGeographicLayerId().hashCode() : 0);
        hash += (this.getGeographicSiteId() != null ? this.getGeographicSiteId().hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this CollectorPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a CollectorPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeoreferencedSitePK)) {
            return false;
        }
        GeoreferencedSitePK other = (GeoreferencedSitePK)object;
        if (this.getSiteId() != other.getSiteId() && (this.getSiteId() == null || !this.getSiteId().equals(other.getSiteId()))) return false;
        if (this.getGeographicLayerId() != other.getGeographicLayerId()&& (this.getGeographicLayerId()== null || !this.getGeographicLayerId().equals(other.getGeographicLayerId()))) return false;
        if (this.getGeographicSiteId() != other.getGeographicSiteId()&& (this.getGeographicSiteId()== null || !this.getGeographicSiteId().equals(other.getGeographicSiteId()))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.GeoreferencedSitePK[siteId=" + getSiteId() + ", geographicLayerId=" + getGeographicLayerId() + ", geographicSiteId=" + getGeographicSiteId() + "]";
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getGeographicLayerId() {
        return geographicLayerId;
    }

    public void setGeographicLayerId(Long geographicLayerId) {
        this.geographicLayerId = geographicLayerId;
    }

    public Long getGeographicSiteId() {
        return geographicSiteId;
    }

    public void setGeographicSiteId(Long geographicSiteId) {
        this.geographicSiteId = geographicSiteId;
    }
}
