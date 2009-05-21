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
 * SiteCoordinate.java
 *
 * Created on April 22, 2008, 10:24 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gis;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class SiteCoordinate
 * 
 * @author roaguilar
 */
@Entity
@Table(name="site_coordinate")
@TableGenerator(name="site_coordinate_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="site_coordinate_id",allocationSize=1)
public class SiteCoordinate extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="site_coordinate_id_gen")
    @Column(name = "site_coordinate_id", nullable = false)
    private Long id;
    
    @Column(name="longitude", nullable = false)
    private Float longitude;
    
    @Column(name="latitude", nullable = false)
    private Float latitude;
    
    @Column(name="original_x", nullable = true)
    private Long originalX;
    
    @Column(name="original_y", nullable = true)
    private Long originalY;

    @Column(name="sequence", nullable = false)
    private int sequence;
    
    @JoinColumn(name="site_id", referencedColumnName="site_id")
    @ManyToOne()
    private Site site;
    
    /** Creates a new instance of SiteCoordinate */
    public SiteCoordinate() {
    }

    /**
     * Gets the id of this SiteCoordinate.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this SiteCoordinate to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this SiteCoordinate.  The result is 
     * <code>true</code> if and only if the argument is not null and is a SiteCoordinate object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteCoordinate)) {
            return false;
        }
        SiteCoordinate other = (SiteCoordinate)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.SiteCoordinate[id=" + id + "]";
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Long getOriginalX() {
        return originalX;
    }

    public void setOriginalX(Long originalX) {
        this.originalX = originalX;
    }

    public Long getOriginalY() {
        return originalY;
    }

    public void setOriginalY(Long originalY) {
        this.originalY = originalY;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
}
