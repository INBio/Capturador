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
public class GatheringObservationCollectionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "gathering_observation_id")
    private Long gatheringObservationId;

    @Basic(optional = false)
    @Column(name = "collection_id")
    private Long collectionId;

    public GatheringObservationCollectionPK() {
    }

    public GatheringObservationCollectionPK(Long gatheringObservationId, Long collectionId) {
        this.gatheringObservationId = gatheringObservationId;
        this.collectionId = collectionId;
    }

    public Long getGatheringObservationId() {
        return gatheringObservationId;
    }

    public void setGatheringObservationId(Long gatheringObservationId) {
        this.gatheringObservationId = gatheringObservationId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gatheringObservationId != null ? gatheringObservationId.hashCode() : 0);
        hash += (collectionId != null ? collectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringObservationCollectionPK)) {
            return false;
        }
        GatheringObservationCollectionPK other = (GatheringObservationCollectionPK) object;
        if ((this.gatheringObservationId == null && other.gatheringObservationId != null) || (this.gatheringObservationId != null && !this.gatheringObservationId.equals(other.gatheringObservationId))) {
            return false;
        }
        if ((this.collectionId == null && other.collectionId != null) || (this.collectionId != null && !this.collectionId.equals(other.collectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.GatheringObservationCollectionPK[gatheringObservationId=" + gatheringObservationId + ", collectionId=" + collectionId + "]";
    }

}
