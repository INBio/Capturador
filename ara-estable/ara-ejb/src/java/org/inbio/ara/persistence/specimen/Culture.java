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
 * Culture.java
 *
 * Created on October 30, 2007, 1:44 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.person.PersonProfile;

/**
 * Entity class Culture
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="culture")
public class Culture extends genericEntity {

    @EmbeddedId
    private CulturePK culturePK;
    
    @Temporal(TemporalType.DATE)
    @Column(name="culture_date", nullable = false)
    private Date cultureDate;
    
    @Column(name="description")
    private String description;
    
    @JoinColumns({
        @JoinColumn(name="responsible_person_id", referencedColumnName="person_id"),
        @JoinColumn(name="responsible_profile_id", referencedColumnName="profile_id")})    
    @ManyToOne()
    private PersonProfile personProfile;
    
    @JoinColumn(name="culture_storage_medium_id", referencedColumnName="culture_storage_medium_id")
    @ManyToOne()
    private CultureStorageMedium cultureStorageMedium;
    
    @JoinColumn(name="culture_medium_id", referencedColumnName="culture_medium_id")
    @ManyToOne()
    private CultureMedium cultureMedium;    
        
    /** Creates a new instance of Culture */
    public Culture() {
    }
    
    public Culture(CulturePK culturePK) {
        this.culturePK = culturePK;
    }
    
    public Culture(Long specimenId, Long replicaNumber) {
        this.culturePK = new CulturePK(specimenId, replicaNumber);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.culturePK != null ? this.culturePK.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this PersonProfile.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonProfile object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Culture)) {
            return false;
        }
        Culture other = (Culture)object;
        if (this.culturePK != other.culturePK && (this.culturePK == null || !this.culturePK.equals(other.culturePK))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.Culture[CulturePK=" + culturePK + "]";
    }     
}
