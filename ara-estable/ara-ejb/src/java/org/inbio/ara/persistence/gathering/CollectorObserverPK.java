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
 * CollectorPK.java
 *
 * Created on October 28, 2007, 4:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roaguilar
 */
@Embeddable
public class CollectorObserverPK implements Serializable{
    
    @Column(name = "gathering_observation_id", nullable = false)
    private Long gatheringObservationId;

    @Column(name = "collector_person_id", nullable = false)
    private Long personId;
    
    /** Creates a new instance of CollectorPK */
    public CollectorObserverPK() {
    }
    
    public CollectorObserverPK(Long gatheringObservationId, Long personId) {
        this.setgatheringObservationId(gatheringObservationId);
        this.setPersonId(personId);
    }
    
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getgatheringObservationId() != null ? this.getgatheringObservationId().hashCode() : 0);
        hash += (this.getPersonId() != null ? this.getPersonId().hashCode() : 0);
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
        if (!(object instanceof CollectorObserverPK)) {
            return false;
        }
        CollectorObserverPK other = (CollectorObserverPK)object;
        if (this.getgatheringObservationId() != other.getgatheringObservationId() && (this.getgatheringObservationId() == null || !this.getgatheringObservationId().equals(other.getgatheringObservationId()))) return false;
        if (this.getPersonId() != other.getPersonId()&& (this.getPersonId()== null || !this.getPersonId().equals(other.getPersonId()))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.CollectorPK[gatheringObservationId=" + getgatheringObservationId() + ", personId=" + getPersonId() + "]";
    }

    public Long getgatheringObservationId() {
        return gatheringObservationId;
    }

    public void setgatheringObservationId(Long gatheringObservationId) {
        this.gatheringObservationId = gatheringObservationId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
