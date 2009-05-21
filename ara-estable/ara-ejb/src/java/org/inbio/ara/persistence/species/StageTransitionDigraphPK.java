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
 * StageTransitionDigraphPK.java
 *
 * Created on July 22, 2007, 2:13 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.species;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class StageTransitionDigraphPK for entity class StageTransitionDigraph
 * 
 * @author roaguilar
 */
@Embeddable
public class StageTransitionDigraphPK implements Serializable {

    @Column(name = "species_record_stage_from_id", nullable = false)
    private Long speciesRecordStageFromId;

    @Column(name = "species_record_stage_to_id", nullable = false)
    private Long speciesRecordStageToId;
    
    /** Creates a new instance of StageTransitionDigraphPK */
    public StageTransitionDigraphPK() {
    }

    /**
     * Creates a new instance of StageTransitionDigraphPK with the specified values.
     * @param speciesRecordStageToId the speciesRecordStageToId of the StageTransitionDigraphPK
     * @param speciesRecordStageFromId the speciesRecordStageFromId of the StageTransitionDigraphPK
     */
    public StageTransitionDigraphPK(Long speciesRecordStageToId, Long speciesRecordStageFromId) {
        this.speciesRecordStageToId = speciesRecordStageToId;
        this.speciesRecordStageFromId = speciesRecordStageFromId;
    }

    /**
     * Gets the speciesRecordStageFromId of this StageTransitionDigraphPK.
     * @return the speciesRecordStageFromId
     */
    public Long getSpeciesRecordStageFromId() {
        return this.speciesRecordStageFromId;
    }

    /**
     * Sets the speciesRecordStageFromId of this StageTransitionDigraphPK to the specified value.
     * @param speciesRecordStageFromId the new speciesRecordStageFromId
     */
    public void setSpeciesRecordStageFromId(Long speciesRecordStageFromId) {
        this.speciesRecordStageFromId = speciesRecordStageFromId;
    }

    /**
     * Gets the speciesRecordStageToId of this StageTransitionDigraphPK.
     * @return the speciesRecordStageToId
     */
    public Long getSpeciesRecordStageToId() {
        return this.speciesRecordStageToId;
    }

    /**
     * Sets the speciesRecordStageToId of this StageTransitionDigraphPK to the specified value.
     * @param speciesRecordStageToId the new speciesRecordStageToId
     */
    public void setSpeciesRecordStageToId(Long speciesRecordStageToId) {
        this.speciesRecordStageToId = speciesRecordStageToId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.speciesRecordStageToId != null ? this.speciesRecordStageToId.hashCode() : 0);
        hash += (this.speciesRecordStageFromId != null ? this.speciesRecordStageFromId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this StageTransitionDigraphPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a StageTransitionDigraphPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StageTransitionDigraphPK)) {
            return false;
        }
        StageTransitionDigraphPK other = (StageTransitionDigraphPK)object;
        if (this.speciesRecordStageToId != other.speciesRecordStageToId && (this.speciesRecordStageToId == null || !this.speciesRecordStageToId.equals(other.speciesRecordStageToId))) return false;
        if (this.speciesRecordStageFromId != other.speciesRecordStageFromId && (this.speciesRecordStageFromId == null || !this.speciesRecordStageFromId.equals(other.speciesRecordStageFromId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.species.StageTransitionDigraphPK[speciesRecordStageToId=" + speciesRecordStageToId + ", speciesRecordStageFromId=" + speciesRecordStageFromId + "]";
    }
    
}
