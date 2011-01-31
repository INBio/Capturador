/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author esmata
 */
@Embeddable
public class CollectorObserverPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "gathering_observation_id")
    private Long gatheringObservationId;

    @Basic(optional = false)
    @Column(name = "collector_person_id")
    private Long collectorPersonId;

    public CollectorObserverPK() {
    }

    public CollectorObserverPK(Long gatheringObservationId, Long collectorPersonId) {
        this.gatheringObservationId = gatheringObservationId;
        this.collectorPersonId = collectorPersonId;
    }

    public Long getGatheringObservationId() {
        return gatheringObservationId;
    }

    public void setGatheringObservationId(Long gatheringObservationId) {
        this.gatheringObservationId = gatheringObservationId;
    }

    public Long getCollectorPersonId() {
        return collectorPersonId;
    }

    public void setCollectorPersonId(Long collectorPersonId) {
        this.collectorPersonId = collectorPersonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gatheringObservationId != null ? gatheringObservationId.hashCode() : 0);
        hash += (collectorPersonId != null ? collectorPersonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollectorObserverPK)) {
            return false;
        }
        CollectorObserverPK other = (CollectorObserverPK) object;
        if ((this.gatheringObservationId == null && other.gatheringObservationId != null) || (this.gatheringObservationId != null && !this.gatheringObservationId.equals(other.gatheringObservationId))) {
            return false;
        }
        if ((this.collectorPersonId == null && other.collectorPersonId != null) || (this.collectorPersonId != null && !this.collectorPersonId.equals(other.collectorPersonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.inventory.CollectorObserverPK[gatheringObservationId=" + gatheringObservationId + ", collectorPersonId=" + collectorPersonId + "]";
    }

}
