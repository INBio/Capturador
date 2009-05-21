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
 * TaxonNameHistory.java
 *
 * Created on October 31, 2007, 1:56 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class TaxonNameHistory
 * 
 * @author roaguilar
 */
@Entity
@Table(name="taxon_name_history")
public class TaxonNameHistory extends genericEntity {

    @EmbeddedId
    private TaxonNameHistoryPK taxonNameHistoryPK;

    @JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id", insertable= false, updatable=false)
    @ManyToOne()
    private Taxon taxon;

    @Column(name="historic_name",length=80)
    private String historicName;
    
    /** Creates a new instance of TaxonNameHistory */
    public TaxonNameHistory() {
    }

    public TaxonNameHistory(TaxonNameHistoryPK taxonNameHistoryPK) {
        this.setTaxonNameHistoryPK(taxonNameHistoryPK);
    }
    
    public TaxonNameHistory(Long taxonId, Date initialTimeStamp, Date finalTimeStamp) {
        this.setTaxonNameHistoryPK(new TaxonNameHistoryPK(taxonId, initialTimeStamp, finalTimeStamp));
    }

    public TaxonNameHistoryPK getTaxonNameHistoryPK() {
        return taxonNameHistoryPK;
    }

    public void setTaxonNameHistoryPK(TaxonNameHistoryPK taxonNameHistoryPK) {
        this.taxonNameHistoryPK = taxonNameHistoryPK;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.taxonNameHistoryPK != null ? this.taxonNameHistoryPK.hashCode() : 0);
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
        if (!(object instanceof TaxonNameHistory)) {
            return false;
        }
        TaxonNameHistory other = (TaxonNameHistory)object;
        if (this.taxonNameHistoryPK != other.taxonNameHistoryPK && (this.taxonNameHistoryPK == null || !this.taxonNameHistoryPK.equals(other.taxonNameHistoryPK))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonNameHistory[TaxonNameHistoryPK=" + taxonNameHistoryPK + "]";
    } 

    public String getHistoricName() {
        return historicName;
    }

    public void setHistoricName(String historicName) {
        this.historicName = historicName;
    }
}
