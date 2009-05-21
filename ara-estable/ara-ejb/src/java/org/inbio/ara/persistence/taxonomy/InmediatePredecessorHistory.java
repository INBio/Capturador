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
 * InmediatePredecessorHistory.java
 *
 * Created on October 31, 2007, 1:56 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class InmediatePredecessorHistory
 * 
 * @author roaguilar
 */
@Entity
@Table(name="inmediate_predecessor_history")
public class InmediatePredecessorHistory extends genericEntity {

    @EmbeddedId
    private InmediatePredecessorHistoryPK inmediatePredecessorHistoryPK;

    @JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id", insertable= false, updatable=false)
    @ManyToOne()
    private Taxon taxon;
    
    @JoinColumn(name = "predecessor_taxon_id", referencedColumnName = "taxon_id", insertable= false, updatable=false)
    @ManyToOne()
    private Taxon predecessorTaxon;
   
    @JoinColumn(name = "taxonomical_range_id", referencedColumnName = "taxonomical_range_id")
    @ManyToOne()
    private TaxonomicalRange taxonomicalRange;
    
    /** Creates a new instance of InmediatePredecessorHistory */
    public InmediatePredecessorHistory() {
    }

    public InmediatePredecessorHistory(InmediatePredecessorHistoryPK inmediatePredecessorHistoryPK) {
        this.setInmediatePredecessorHistoryPK(inmediatePredecessorHistoryPK);
    }
    
    public InmediatePredecessorHistory(Long taxonId, Date initialTimeStamp, Date finalTimeStamp, Long predecessorTaxonId) {
        this.setInmediatePredecessorHistoryPK(new InmediatePredecessorHistoryPK(taxonId, initialTimeStamp, finalTimeStamp, predecessorTaxonId));
    }

    public InmediatePredecessorHistoryPK getInmediatePredecessorHistoryPK() {
        return inmediatePredecessorHistoryPK;
    }

    public void setInmediatePredecessorHistoryPK(InmediatePredecessorHistoryPK inmediatePredecessorHistoryPK) {
        this.inmediatePredecessorHistoryPK = inmediatePredecessorHistoryPK;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public Taxon getPredecessorTaxon() {
        return predecessorTaxon;
    }

    public void setPredecessorTaxon(Taxon predecessorTaxon) {
        this.predecessorTaxon = predecessorTaxon;
    }

    public TaxonomicalRange getTaxonomicalRange() {
        return taxonomicalRange;
    }

    public void setTaxonomicalRange(TaxonomicalRange taxonomicalRange) {
        this.taxonomicalRange = taxonomicalRange;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.inmediatePredecessorHistoryPK != null ? this.inmediatePredecessorHistoryPK.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this PersonProfile.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonProfile object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InmediatePredecessorHistory)) {
            return false;
        }
        InmediatePredecessorHistory other = (InmediatePredecessorHistory)object;
        if (this.inmediatePredecessorHistoryPK != other.inmediatePredecessorHistoryPK && (this.inmediatePredecessorHistoryPK == null || !this.inmediatePredecessorHistoryPK.equals(other.inmediatePredecessorHistoryPK))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.InmediatePredecessorHistory[InmediatePredecessorHistoryPK=" + inmediatePredecessorHistoryPK + "]";
    } 
}
