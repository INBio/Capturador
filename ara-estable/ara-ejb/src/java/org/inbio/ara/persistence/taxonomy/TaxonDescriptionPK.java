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
 * TaxonDescriptionPK.java
 *
 * Created on October 22, 2007, 1:05 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roaguilar
 */
@Embeddable
public class TaxonDescriptionPK implements Serializable{
    
    @Column(name="taxon_id")
    private Long taxonId;
    
    @Column(name="taxon_description_sequence")
    private Long taxonDescriptionSequence;
    
    /** Creates a new instance of TaxonDescriptionPK */
    public TaxonDescriptionPK() {
    }
    
    public TaxonDescriptionPK(Long taxonId, Long taxonDescriptionSequence) {
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
    
}
