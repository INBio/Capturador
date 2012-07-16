/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author esmata
 */

@Entity
@Table(name = "collector_observer")

public class CollectorObserver extends GenericEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CollectorObserverPK collectorObserverPK;

    @Basic(optional = false)
    @Column(name = "sequence")
    private Long sequence;

    @JoinColumn(name="collector_person_id", referencedColumnName="person_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    @JoinColumn(name="gathering_observation_id", referencedColumnName="gathering_observation_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GatheringObservation gatheringObservation;

    public CollectorObserver() {
    }

    public CollectorObserver(CollectorObserverPK collectorObserverPK) {
        this.collectorObserverPK = collectorObserverPK;
    }

    public CollectorObserver(CollectorObserverPK collectorObserverPK, Long sequence, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.collectorObserverPK = collectorObserverPK;
        this.sequence = sequence;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public CollectorObserver(Long gatheringObservationId, Long collectorPersonId) {
        this.collectorObserverPK = new CollectorObserverPK(gatheringObservationId, collectorPersonId);
    }

    public CollectorObserverPK getCollectorObserverPK() {
        return collectorObserverPK;
    }

    public void setCollectorObserverPK(CollectorObserverPK collectorObserverPK) {
        this.collectorObserverPK = collectorObserverPK;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectorObserverPK != null ? collectorObserverPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollectorObserver)) {
            return false;
        }
        CollectorObserver other = (CollectorObserver) object;
        if ((this.collectorObserverPK == null && other.collectorObserverPK != null) || (this.collectorObserverPK != null && !this.collectorObserverPK.equals(other.collectorObserverPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.inventory.CollectorObserver[collectorObserverPK=" + collectorObserverPK + "]";
    }

    /**
     * @return the gatheringObservation
     */
    public GatheringObservation getGatheringObservation() {
        return gatheringObservation;
    }

    /**
     * @param gatheringObservation the gatheringObservation to set
     */
    public void setGatheringObservation(GatheringObservation gatheringObservation) {
        this.gatheringObservation = gatheringObservation;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

}
