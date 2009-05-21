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
 * GatheringObservationEcologicalVar.java
 *
 * Created on April 23, 2008, 10:26 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gathering;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.specimen.*;

/**
 *
 * @author roaguilar
 */
@Entity()
@Table(name="gathering_observation_ecological_var")
public class GatheringObservationEcologicalVar {
    
    @EmbeddedId
    private GatheringObservationEcologicalVarPK gatheringObservationEcologicalVarPK;
    
    @JoinColumn(name="gathering_observation_id", referencedColumnName="gathering_observation_id", insertable = false, updatable=false)
    @ManyToOne()
    private GatheringObservation gatheringObservation;
    
    @JoinColumn(name="ecological_variable_value_id", referencedColumnName="ecological_variable_value_id", insertable = false, updatable=false)
    @ManyToOne()
    private EcologicalVariableValue ecologicalVariableValue;
    
    @Column(name="value")
    private String value;
    
    /** Creates a new instance of GatheringObservationEcologicalVar */
    public GatheringObservationEcologicalVar() {
    }
    
    public GatheringObservationEcologicalVar(GatheringObservationEcologicalVarPK gatheringObservationEcologicalVarPK) {
        this.setGatheringObservationEcologicalVarPK(gatheringObservationEcologicalVarPK);
    }
    
    public GatheringObservationEcologicalVar(Long gatheringObservationId, Long ecologicalVariableValueId) {
        //this.setSpecimenDescriptionPK(new SpecimenDescriptionPK(specimenId, specimenVariableValueId));
        this.setGatheringObservationEcologicalVarPK(new GatheringObservationEcologicalVarPK(gatheringObservationId, ecologicalVariableValueId));
    }

    public GatheringObservation getGatheringObservation() {
        return gatheringObservation;
    }

    public void setGatheringObservation(GatheringObservation gatheringObservation) {
        this.gatheringObservation = gatheringObservation;
    }

    public EcologicalVariableValue getEcologicalVariableValue() {
        return ecologicalVariableValue;
    }

    public void setEcologicalVariableValue(EcologicalVariableValue ecologicalVariableValue) {
        this.ecologicalVariableValue = ecologicalVariableValue;
    }

    public GatheringObservationEcologicalVarPK getGatheringObservationEcologicalVarPK() {
        return gatheringObservationEcologicalVarPK;
    }

    public void setGatheringObservationEcologicalVarPK(GatheringObservationEcologicalVarPK gatheringObservationEcologicalVarPK) {
        this.gatheringObservationEcologicalVarPK = gatheringObservationEcologicalVarPK;
    }

    
}
