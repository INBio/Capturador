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
 * StageTransitionDate.java
 *
 * Created on October 22, 2007, 12:16 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.species;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;

/**
 * Entity class StageTransitionDate
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="stage_transition_date")
public class StageTransitionDate extends genericEntity {

    @EmbeddedId
    private StageTransitionDatePK stageTransitionDatePK;
    
    @JoinColumn(name = "taxon_description_stage_id", referencedColumnName = "taxon_description_stage_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private TaxonDescriptionStage stage;
    
    @JoinColumns(value =  {
            @JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id", insertable = false, updatable = false),
            @JoinColumn(name = "taxon_description_sequence", referencedColumnName = "taxon_description_sequence", insertable = false, updatable = false)
        })
    @ManyToOne()
    private TaxonDescription taxonDescription;
    
    @Transient
    private String stageName;
    
    /** Creates a new instance of StageTransitionDate */
    public StageTransitionDate() {
    }

    public StageTransitionDate(StageTransitionDatePK stageTransitionDatePK) {
        this.setStageTransitionDatePK(stageTransitionDatePK);
    }
    
    public StageTransitionDate(Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionStageId, Date transitionDate) {
        this.setStageTransitionDatePK(new StageTransitionDatePK(taxonId, taxonDescriptionSequence, taxonDescriptionStageId, transitionDate));
    }

    public TaxonDescriptionStage getStage() {
        return stage;
    }

    public void setStage(TaxonDescriptionStage stage) {
        this.stage = stage;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
    
    @PostLoad
    public void postLoad(){
        this.setStageName(stage.getName());
    }

    public StageTransitionDatePK getStageTransitionDatePK() {
        return stageTransitionDatePK;
    }

    public void setStageTransitionDatePK(StageTransitionDatePK stageTransitionDatePK) {
        this.stageTransitionDatePK = stageTransitionDatePK;
    }
}
