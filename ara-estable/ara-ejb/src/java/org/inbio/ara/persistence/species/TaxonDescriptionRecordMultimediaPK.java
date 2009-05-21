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
 * TaxonDescriptionRecordMultimedia.java
 *
 * Created on October 22, 2007, 1:32 AM
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
public class TaxonDescriptionRecordMultimediaPK implements Serializable{
    
    @Column(name="taxon_description_record_id")
    private Long taxonDescriptionRecordId;
    
    @Column(name="multimedia_id")
    private Long multimediaId;
    
    /** Creates a new instance of TaxonDescriptionRecordMultimedia */
    public TaxonDescriptionRecordMultimediaPK() {
    }
    
    public TaxonDescriptionRecordMultimediaPK(Long taxonDescriptionRecordId, Long multimediaId) {
        this.setMultimediaId(multimediaId);
        this.setTaxonDescriptionRecordId(taxonDescriptionRecordId);
    }

    public Long getTaxonDescriptionRecordId() {
        return taxonDescriptionRecordId;
    }

    public void setTaxonDescriptionRecordId(Long taxonDescriptionRecordId) {
        this.taxonDescriptionRecordId = taxonDescriptionRecordId;
    }

    public Long getMultimediaId() {
        return multimediaId;
    }

    public void setMultimediaId(Long multimediaId) {
        this.multimediaId = multimediaId;
    }
    
}
