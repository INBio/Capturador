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
 * Collector.java
 *
 * Created on October 28, 2007, 4:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.person.Person;

/**
 * Entity class Collector
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="collector_observer")
public class CollectorObserver extends genericEntity {

    @EmbeddedId
    private CollectorObserverPK collectorPK;
    
    @Column(name="sequence")
    private
    Long sequence;
    
    @JoinColumn(name="collector_person_id", referencedColumnName="person_id", insertable = false, updatable = false)
    @ManyToOne()
    private Person person;
    
    @JoinColumn(name="gathering_observation_id", referencedColumnName="gathering_observation_id", insertable = false, updatable = false)
    @ManyToOne()
    private GatheringObservation gatheringObservation;
    
    @Transient
    private String collectorObserverName;
    
    /** Creates a new instance of Collector */
    public CollectorObserver() {
    }
    
    public CollectorObserver(CollectorObserverPK collectorPK) {
        this.setCollectorPK(collectorPK);
    }
    
    public CollectorObserver(Long gatheringObservationId, Long personId) {
        this.setCollectorPK(new CollectorObserverPK(gatheringObservationId, personId));
    }

    public CollectorObserverPK getCollectorPK() {
        return collectorPK;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getCollectorPK() != null ? this.getCollectorPK().hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Collector.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Collector object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollectorObserver)) {
            return false;
        }
        CollectorObserver other = (CollectorObserver)object;
        if (this.getCollectorPK() != other.getCollectorPK() && (this.getCollectorPK() == null || !this.getCollectorPK().equals(other.getCollectorPK()))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.collector[collectorPK=" + getCollectorPK() + "]";
    }    

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setCollectorPK(CollectorObserverPK collectorPK) {
        this.collectorPK = collectorPK;
    }

    public GatheringObservation getGatheringObservation() {
        return gatheringObservation;
    }

    public void setGatheringObservation(GatheringObservation gatheringObservation) {
        this.gatheringObservation = gatheringObservation;
    }
    
    @PostLoad
    public void postLoad(){
        this.setCollectorObserverName(this.person.getFormalLongName());
    }

    public String getCollectorObserverName() {
        return collectorObserverName;
    }

    public void setCollectorObserverName(String collectorObserverName) {
        this.collectorObserverName = collectorObserverName;
    }
}
