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
 * Created on October 22, 2007, 1:35 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.species;

import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;


/**
 * Entity class TaxonDescriptionRecordMultimedia
 * 
 * @author roaguilar
 */
@Entity
@Table(name="taxon_description_record_multimedia")
public class TaxonDescriptionRecordMultimedia extends genericEntity {

    @EmbeddedId
    private TaxonDescriptionRecordMultimediaPK taxonDescriptionRecordMultimediaPK;
    
    /** Creates a new instance of TaxonDescriptionRecordMultimedia */
    public TaxonDescriptionRecordMultimedia() {
    }
    
    public TaxonDescriptionRecordMultimedia(TaxonDescriptionRecordMultimediaPK taxonDescriptionRecordMultimediaPK) {
        this.setTaxonDescriptionRecordMultimediaPK(taxonDescriptionRecordMultimediaPK);
    }
    
    public TaxonDescriptionRecordMultimedia(Long taxonDescriptionRecordId, Long multimediaId) {
        this.setTaxonDescriptionRecordMultimediaPK(new TaxonDescriptionRecordMultimediaPK(taxonDescriptionRecordId, multimediaId));
    }

    public TaxonDescriptionRecordMultimediaPK getTaxonDescriptionRecordMultimediaPK() {
        return taxonDescriptionRecordMultimediaPK;
    }

    public void setTaxonDescriptionRecordMultimediaPK(TaxonDescriptionRecordMultimediaPK taxonDescriptionRecordMultimediaPK) {
        this.taxonDescriptionRecordMultimediaPK = taxonDescriptionRecordMultimediaPK;
    }
}
