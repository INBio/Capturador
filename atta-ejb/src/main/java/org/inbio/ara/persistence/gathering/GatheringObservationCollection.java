/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "gathering_observation_collection")

public class GatheringObservationCollection extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected GatheringObservationCollectionPK gatheringObservationCollectionPK;

    @JoinColumn(name = "gathering_observation_id", referencedColumnName = "gathering_observation_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GatheringObservation gatheringObservation;

    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Collection collection;

    public GatheringObservationCollection() {
    }

    public GatheringObservationCollection(GatheringObservationCollectionPK gatheringObservationCollectionPK) {
        this.gatheringObservationCollectionPK = gatheringObservationCollectionPK;
    }

    public GatheringObservationCollection(GatheringObservationCollectionPK gatheringObservationCollectionPK, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.gatheringObservationCollectionPK = gatheringObservationCollectionPK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public GatheringObservationCollection(Long gatheringObservationId, Long collectionId) {
        this.gatheringObservationCollectionPK = new GatheringObservationCollectionPK(gatheringObservationId, collectionId);
    }

    public GatheringObservationCollectionPK getGatheringObservationCollectionPK() {
        return gatheringObservationCollectionPK;
    }

    public void setGatheringObservationCollectionPK(GatheringObservationCollectionPK gatheringObservationCollectionPK) {
        this.gatheringObservationCollectionPK = gatheringObservationCollectionPK;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public GatheringObservation getGatheringObservation() {
        return gatheringObservation;
    }

    public void setGatheringObservation(GatheringObservation gatheringObservation) {
        this.gatheringObservation = gatheringObservation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gatheringObservationCollectionPK != null ? gatheringObservationCollectionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringObservationCollection)) {
            return false;
        }
        GatheringObservationCollection other = (GatheringObservationCollection) object;
        if ((this.gatheringObservationCollectionPK == null && other.gatheringObservationCollectionPK != null) || (this.gatheringObservationCollectionPK != null && !this.gatheringObservationCollectionPK.equals(other.gatheringObservationCollectionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.GatheringObservationCollection[gatheringObservationCollectionPK=" + gatheringObservationCollectionPK + "]";
    }

}
