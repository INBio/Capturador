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
 * TaxonNameHistoryPK.java
 *
 * Created on October 31, 2007, 12:34 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

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
public class TaxonNameHistoryPK implements Serializable {
    
    @Column(name="taxon_id")
    private Long taxonId;
            
    @Temporal(TemporalType.DATE)
    @Column(name="initial_timestamp", nullable = false)
    private Date initialTimeStamp;
    
    @Temporal(TemporalType.DATE)
    @Column(name="final_timestamp", nullable = false)
    private Date finalTimeStamp;
    
    /**
     * Creates a new instance of TaxonNameHistoryPK
     */
    public TaxonNameHistoryPK() {
    }
    
    public TaxonNameHistoryPK(Long taxonId, Date initialTimeStamp, Date finalTimeStamp) {
        this.taxonId = taxonId;
        this.initialTimeStamp = initialTimeStamp;
        this.finalTimeStamp = finalTimeStamp;
    }


    
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.taxonId != null ? this.taxonId.hashCode() : 0);
        hash += (this.initialTimeStamp != null ? this.initialTimeStamp.hashCode() : 0);
        hash += (this.finalTimeStamp != null ? this.finalTimeStamp.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this TaxonNameHistoryPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonNameHistoryPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonNameHistoryPK)) {
            return false;
        }
        TaxonNameHistoryPK other = (TaxonNameHistoryPK)object;
        if (this.taxonId != other.taxonId && (this.taxonId == null || !this.taxonId.equals(other.taxonId))) return false;
        if (this.finalTimeStamp != other.finalTimeStamp && (this.finalTimeStamp == null || !this.finalTimeStamp.equals(other.finalTimeStamp))) return false;
        if (this.initialTimeStamp != other.initialTimeStamp && (this.initialTimeStamp == null || !this.initialTimeStamp.equals(other.initialTimeStamp))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonNameHistoryPK[taxonId=" + taxonId + ", finalTimeStamp=" + finalTimeStamp + ", initialTimeStamp=" + initialTimeStamp + "]";
    }
}
