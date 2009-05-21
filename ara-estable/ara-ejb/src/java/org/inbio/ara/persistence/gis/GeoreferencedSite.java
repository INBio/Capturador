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
 * GeoreferencedSite.java
 *
 * Created on April 22, 2008, 10:49 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gis;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity class GeoreferencedSite
 * 
 * @author roaguilar
 */
@Entity
public class GeoreferencedSite implements Serializable {

    @EmbeddedId
    private GeoreferencedSitePK georeferencedSitePK;
    
    @JoinColumn(name="site_id", referencedColumnName="site_id", insertable = false, updatable = false)
    @ManyToOne()
    private Site site;
    
    @JoinColumn(name="geographic_layer_id", referencedColumnName="geographic_layer_id", insertable = false, updatable = false)
    @ManyToOne()
    private GeographicLayer geographicLayer;
    
    /** Creates a new instance of GeoreferencedSite */
    public GeoreferencedSite() {
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.georeferencedSitePK != null ? this.georeferencedSitePK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this GeoreferencedSite.  The result is 
     * <code>true</code> if and only if the argument is not null and is a GeoreferencedSite object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeoreferencedSite)) {
            return false;
        }
        GeoreferencedSite other = (GeoreferencedSite)object;
        if (this.georeferencedSitePK != other.georeferencedSitePK && (this.georeferencedSitePK == null || !this.georeferencedSitePK.equals(other.georeferencedSitePK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.GeoreferencedSite[id=" + georeferencedSitePK.toString() + "]";
    }

    public GeoreferencedSitePK getGeoreferencedSitePK() {
        return georeferencedSitePK;
    }

    public void setGeoreferencedSitePK(GeoreferencedSitePK georeferencedSitePK) {
        this.georeferencedSitePK = georeferencedSitePK;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public GeographicLayer getGeographicLayer() {
        return geographicLayer;
    }

    public void setGeographicLayer(GeographicLayer geographicLayer) {
        this.geographicLayer = geographicLayer;
    }
    
}
