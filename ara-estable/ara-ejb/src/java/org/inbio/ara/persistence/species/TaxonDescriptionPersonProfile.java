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
 * TaxonDescriptionPersonProfile.java
 *
 * Created on October 22, 2007, 1:26 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.species;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;

/**
 * Entity class TaxonDescriptionPersonProfile
 *
 * @author roaguilar
 */
@Entity
@Table(name="taxon_description_person_profile")
public class TaxonDescriptionPersonProfile extends genericEntity {
    
    @EmbeddedId
    private TaxonDescriptionPersonProfilePK taxonDescriptionPersonProfilePK;
    
    @Column(name="sequence")
    private Long sequence;
    
    @JoinColumns(value =  {
            @JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id", insertable = false, updatable = false),
            @JoinColumn(name = "taxon_description_sequence", referencedColumnName = "taxon_description_sequence", insertable = false, updatable = false)
        })
    @ManyToOne()
    private TaxonDescription taxonDescription;
    
    /** Creates a new instance of TaxonDescriptionPersonProfile */
    public TaxonDescriptionPersonProfile() {
    }
    
    public TaxonDescriptionPersonProfile(TaxonDescriptionPersonProfilePK taxonDescriptionPersonProfilePK, Long sequence) {
        this.setTaxonDescriptionPersonProfilePK(taxonDescriptionPersonProfilePK);
        this.setSequence(sequence);
    }
    
    /*
    public TaxonDescriptionPersonProfile(Long taxonDescriptionRecordId, Long authorPersonId, Long authorProfileId, Long sequence) {
        this.setTaxonDescriptionPersonProfilePK(new TaxonDescriptionPersonProfilePK(taxonDescriptionRecordId,authorPersonId,authorProfileId));
        this.setSequence(sequence);
    }
     */
    
    public TaxonDescriptionPersonProfile(Long taxonId, Long taxonDescriptionSequence, Long authorPersonId, Long authorProfileId, Long sequence) {
        this.setTaxonDescriptionPersonProfilePK(new TaxonDescriptionPersonProfilePK(taxonId,taxonDescriptionSequence,authorPersonId,authorProfileId));
        this.setSequence(sequence);
    }
    
    public TaxonDescriptionPersonProfilePK getTaxonDescriptionPersonProfilePK() {
        return taxonDescriptionPersonProfilePK;
    }
    
    public void setTaxonDescriptionPersonProfilePK(TaxonDescriptionPersonProfilePK taxonDescriptionPersonProfilePK) {
        this.taxonDescriptionPersonProfilePK = taxonDescriptionPersonProfilePK;
    }
    
    public Long getSequence() {
        return sequence;
    }
    
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }
    
}
