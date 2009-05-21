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
 * SpeciesRecordAudience.java
 *
 * Created on October 22, 2007, 12:56 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.species;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roaguilar
 */
@Embeddable
public class TaxonDescriptionAudiencePK implements Serializable{
    
    @Column(name="taxon_id")
    private Long taxonId;
    
    @Column(name="taxon_description_sequence")
    private Long taxonDescriptionSequence;
    
    @Column(name="audience_id")
    private Long audienceId;
    
    /** Creates a new instance of SpeciesRecordAudience */
    public TaxonDescriptionAudiencePK() {
    }

    public TaxonDescriptionAudiencePK(Long taxonId, Long taxonDescriptionSequecen, Long audienceId) {
        this.setAudienceId(audienceId);
        this.setTaxonDescriptionSequence(taxonDescriptionSequence);
        this.setTaxonId(taxonId);
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

    public Long getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(Long audienceId) {
        this.audienceId = audienceId;
    }
    
}
