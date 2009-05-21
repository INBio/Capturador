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
 * StageTransitionDatePK.java
 *
 * Created on October 22, 2007, 12:17 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.species;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author roaguilar
 */
@Embeddable
public class StageTransitionDatePK implements Serializable {
    
    @Column(name="taxon_id")
    private Long taxonId;
    
    @Column(name="taxon_description_sequence")
    private Long taxonDescriptionSequence;
    
    @Column(name="taxon_description_stage_id")
    private Long taxonDescriptionStageId;
    
    @Temporal(TemporalType.DATE)
    @Column(name="transition_date", nullable = false)
    private Date transitionDate;
    
    /** Creates a new instance of StageTransitionDatePK */
    public StageTransitionDatePK() {
    }
    
    public StageTransitionDatePK(Long taxonId, Long taxonDescriptionSequence, Long taxonDescriptionStageId, Date transitionDate){
        this.taxonId = taxonId;
        this.taxonDescriptionSequence = taxonDescriptionSequence;
        this.taxonDescriptionStageId = taxonDescriptionStageId;
        this.transitionDate = transitionDate;
    }

    public Long getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    public Long getTaxonDescriptionSequence() {
        return taxonDescriptionSequence;
    }

    public void setTaxonDescriptionSequence(Long taxonDescriptionSequence) {
        this.taxonDescriptionSequence = taxonDescriptionSequence;
    }

    public Long getTaxonDescriptionStageId() {
        return taxonDescriptionStageId;
    }

    public void setTaxonDescriptionStageId(Long taxonDescriptionStageId) {
        this.taxonDescriptionStageId = taxonDescriptionStageId;
    }

    public Date getTransitionDate() {
        return transitionDate;
    }

    public void setTransitionDate(Date transitionDate) {
        this.transitionDate = transitionDate;
    }
    
}
