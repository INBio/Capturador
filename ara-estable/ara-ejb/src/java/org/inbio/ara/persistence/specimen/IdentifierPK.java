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
 * IdentifierPK.java
 *
 * Created on October 31, 2007, 12:34 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author roaguilar
 */
@Embeddable
public class IdentifierPK implements Serializable {
    
    @Column(name="specimen_id")
    private Long specimenId;
            
    @Column(name="identification_sequence")
    private Long identificationSequence;
    
    @Temporal(TemporalType.DATE)
    @Column(name="initial_timestamp", nullable = false)
    private Date initialTimeStamp;
    
    @Column(name="identifier_person_id")
    private Long identifierPersonId;
    
    /**
     * Creates a new instance of IdentifierPK
     */
    public IdentifierPK() {
    }
    
    public IdentifierPK(Long specimenId, Long identificationSequence, Date initialTimeStamp, Long identifierPersonId) {
        this.setSpecimenId(specimenId);
        this.setIdentificationSequence(identificationSequence);
        this.setInitialTimeStamp(initialTimeStamp);
        this.setIdentifierPersonId(identifierPersonId);
    }

    public Long getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Long specimenId) {
        this.specimenId = specimenId;
    }

    public Long getIdentificationSequence() {
        return identificationSequence;
    }

    public void setIdentificationSequence(Long identificationSequence) {
        this.identificationSequence = identificationSequence;
    }

    public Date getInitialTimeStamp() {
        return initialTimeStamp;
    }

    public void setInitialTimeStamp(Date initialTimeStamp) {
        this.initialTimeStamp = initialTimeStamp;
    }

    public Long getIdentifierPersonId() {
        return identifierPersonId;
    }

    public void setIdentifierPersonId(Long identifierPersonId) {
        this.identifierPersonId = identifierPersonId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.specimenId != null ? this.specimenId.hashCode() : 0);
        hash += (this.identificationSequence != null ? this.identificationSequence.hashCode() : 0);
        hash += (this.initialTimeStamp != null ? this.initialTimeStamp.hashCode() : 0);
        hash += (this.identifierPersonId != null ? this.identifierPersonId.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this IdentifierPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a IdentifierPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentifierPK)) {
            return false;
        }
        IdentifierPK other = (IdentifierPK)object;
        if (this.specimenId != other.specimenId && (this.specimenId == null || !this.specimenId.equals(other.specimenId))) return false;
        if (this.identificationSequence != other.identificationSequence && (this.identificationSequence == null || !this.identificationSequence.equals(other.identificationSequence))) return false;
        if (this.initialTimeStamp != other.initialTimeStamp && (this.initialTimeStamp == null || !this.initialTimeStamp.equals(other.initialTimeStamp))) return false;
        if (this.identifierPersonId != other.identifierPersonId && (this.identifierPersonId == null || !this.identifierPersonId.equals(other.identifierPersonId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.IdentifierPK[specimenId=" + specimenId + ", IdentificationSequence=" + identificationSequence + ", initialTimeStamp=" + initialTimeStamp + ",identifierPersonId="+ identifierPersonId + "]";
    }
}
