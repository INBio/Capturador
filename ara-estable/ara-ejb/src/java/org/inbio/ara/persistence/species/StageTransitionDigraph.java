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
 * StageTransitionDigraph.java
 *
 * Created on October 21, 2007, 10:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.species;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class StageTransitionDigraph
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="stage_transition_digraph")
public class StageTransitionDigraph extends genericEntity {

    @EmbeddedId
    private StageTransitionDigraphPK stageTransitionDigraphPK;
    
    /** Creates a new instance of StageTransitionDigraph */
    public StageTransitionDigraph() {
    }

    public StageTransitionDigraph(StageTransitionDigraphPK stageTransitionDigraphPK) {
        this.setStageTransitionDigraphPK(stageTransitionDigraphPK);
    }
    
    public StageTransitionDigraph(Long fromId, Long toId) {
        this.setStageTransitionDigraphPK(new StageTransitionDigraphPK());
        this.stageTransitionDigraphPK.setSpeciesRecordStageFromId(fromId);
        this.stageTransitionDigraphPK.setSpeciesRecordStageToId(toId);
    }

    public StageTransitionDigraphPK getStageTransitionDigraphPK() {
        return stageTransitionDigraphPK;
    }

    public void setStageTransitionDigraphPK(StageTransitionDigraphPK stageTransitionDigraphPK) {
        this.stageTransitionDigraphPK = stageTransitionDigraphPK;
    }
    
}
