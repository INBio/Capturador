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
public class GatheringObservationProjectPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "gathering_observation_id")
    private Long gatheringObservationId;

    @Basic(optional = false)
    @Column(name = "project_id")
    private Long projectId;

    public GatheringObservationProjectPK() {
    }

    public GatheringObservationProjectPK(Long gatheringObservationId, Long projectId) {
        this.gatheringObservationId = gatheringObservationId;
        this.projectId = projectId;
    }

    public Long getGatheringObservationId() {
        return gatheringObservationId;
    }

    public void setGatheringObservationId(Long gatheringObservationId) {
        this.gatheringObservationId = gatheringObservationId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gatheringObservationId != null ? gatheringObservationId.hashCode() : 0);
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringObservationProjectPK)) {
            return false;
        }
        GatheringObservationProjectPK other = (GatheringObservationProjectPK) object;
        if ((this.gatheringObservationId == null && other.gatheringObservationId != null) || (this.gatheringObservationId != null && !this.gatheringObservationId.equals(other.gatheringObservationId))) {
            return false;
        }
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.GatheringObservationProjectPK[gatheringObservationId=" + gatheringObservationId + ", projectId=" + projectId + "]";
    }

}
