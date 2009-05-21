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
 * SpecimenLifeStageSexPK.java
 *
 * Created on October 29, 2007, 10:24 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roaguilar
 */
@Embeddable
public class SpecimenLifeStageSexPK implements Serializable {
    
    @Column(name="specimen_id",nullable=false)
    private Long specimenId;
    
    @Column(name="life_stage_id",nullable=false)
    private Long lifeStageId;
    
    @Column(name="sex_id",nullable=false)
    private Long sexId;
    
    /**
     * Creates a new instance of SpecimenLifeStageSexPK
     */
    public SpecimenLifeStageSexPK() {
    }
    
    public SpecimenLifeStageSexPK(Long specimenId, Long lifeStageId, Long sexId) {
        this.setSpecimenId(specimenId);
        this.setLifeStageId(lifeStageId);
        this.setSexId(sexId);
    }

    public Long getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Long specimenId) {
        this.specimenId = specimenId;
    }

    public Long getLifeStageId() {
        return lifeStageId;
    }

    public void setLifeStageId(Long lifeStageId) {
        this.lifeStageId = lifeStageId;
    }

    public Long getSexId() {
        return sexId;
    }

    public void setSexId(Long sexId) {
        this.sexId = sexId;
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
        hash += (this.lifeStageId != null ? this.lifeStageId.hashCode() : 0);
        hash += (this.sexId != null ? this.sexId.hashCode() : 0);
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
        if (!(object instanceof SpecimenLifeStageSexPK)) {
            return false;
        }
        SpecimenLifeStageSexPK other = (SpecimenLifeStageSexPK)object;
        if (this.specimenId != other.specimenId && (this.specimenId == null || !this.specimenId.equals(other.specimenId))) return false;
        if (this.lifeStageId != other.lifeStageId && (this.lifeStageId == null || !this.lifeStageId.equals(other.lifeStageId))) return false;
        if (this.sexId != other.sexId && (this.sexId == null || !this.sexId.equals(other.sexId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.SpecimenLifeStageSexPK[specimenId=" + specimenId + ", lifeStageId=" + lifeStageId + ", sexId=" + sexId + "]";
    }
}
