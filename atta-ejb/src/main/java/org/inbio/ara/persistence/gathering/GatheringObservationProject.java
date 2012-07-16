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

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "gathering_observation_project")

public class GatheringObservationProject extends GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected GatheringObservationProjectPK gatheringObservationProjectPK;

    @JoinColumn(name = "gathering_observation_id", referencedColumnName = "gathering_observation_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GatheringObservation gatheringObservation;

    @JoinColumn(name = "project_id", referencedColumnName = "project_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Project project;

    public GatheringObservationProject() {
    }

    public GatheringObservationProject(GatheringObservationProjectPK gatheringObservationProjectPK) {
        this.gatheringObservationProjectPK = gatheringObservationProjectPK;
    }

    public GatheringObservationProject(GatheringObservationProjectPK gatheringObservationProjectPK, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.gatheringObservationProjectPK = gatheringObservationProjectPK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public GatheringObservationProject(Long gatheringObservationId, Long projectId) {
        this.gatheringObservationProjectPK = new GatheringObservationProjectPK(gatheringObservationId, projectId);
    }

    public GatheringObservationProjectPK getGatheringObservationProjectPK() {
        return gatheringObservationProjectPK;
    }

    public void setGatheringObservationProjectPK(GatheringObservationProjectPK gatheringObservationProjectPK) {
        this.gatheringObservationProjectPK = gatheringObservationProjectPK;
    }

    public GatheringObservation getGatheringObservation() {
        return gatheringObservation;
    }

    public void setGatheringObservation(GatheringObservation gatheringObservation) {
        this.gatheringObservation = gatheringObservation;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gatheringObservationProjectPK != null ? gatheringObservationProjectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringObservationProject)) {
            return false;
        }
        GatheringObservationProject other = (GatheringObservationProject) object;
        if ((this.gatheringObservationProjectPK == null && other.gatheringObservationProjectPK != null) || (this.gatheringObservationProjectPK != null && !this.gatheringObservationProjectPK.equals(other.gatheringObservationProjectPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.GatheringObservationProject[gatheringObservationProjectPK=" + gatheringObservationProjectPK + "]";
    }

}
