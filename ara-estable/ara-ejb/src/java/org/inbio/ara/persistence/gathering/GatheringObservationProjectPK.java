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
 * GatheringCollectionPK.java
 *
 * Created on October 28, 2007, 2:43 PM
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
public class GatheringObservationProjectPK implements Serializable{
    
    @Column(name = "gathering_observation_id", nullable = false)
    private Long gatheringObservationId;

    @Column(name = "project_id", nullable = false)
    private Long projectId;
    
    /** Creates a new instance of GatheringCollectionPK */
    public GatheringObservationProjectPK() {
    }
    
    public GatheringObservationProjectPK(Long gatheringObservationId, Long projectId) {
        this.setGatheringObservationId(gatheringObservationId);
        this.setProjectId(projectId);
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
    
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.projectId != null ? this.projectId.hashCode() : 0);
        hash += (this.gatheringObservationId != null ? this.gatheringObservationId.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this GatheringCollectionPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a GatheringCollectionPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringObservationProjectPK)) {
            return false;
        }
        GatheringObservationProjectPK other = (GatheringObservationProjectPK)object;
        if (this.projectId != other.projectId && (this.projectId == null || !this.projectId.equals(other.projectId))) return false;
        if (this.gatheringObservationId != other.gatheringObservationId&& (this.gatheringObservationId== null || !this.gatheringObservationId.equals(other.gatheringObservationId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.GatheringObservationProjectPK[gatheringObservationId=" + gatheringObservationId + ", projectId=" + projectId + "]";
    }
}
