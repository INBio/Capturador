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
 * TaxonDescriptionReference.java
 *
 * Created on August 1, 2007, 1:34 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.reference;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.species.TaxonDescriptionRecord;
/**
 * Entity class TaxonDescriptionReference
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "taxon_description_record_reference")
public class TaxonDescriptionRecordReference extends genericEntity {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected TaxonDescriptionRecordReferencePK taxonDescriptionReferencePK;
    
    @JoinColumn(name = "taxon_description_record_id", referencedColumnName = "taxon_description_record_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private TaxonDescriptionRecord taxonDescriptionRecord;
    
    /** Creates a new instance of TaxonDescriptionReference */
    public TaxonDescriptionRecordReference() {
    }

    /**
     * Creates a new instance of TaxonDescriptionReference with the specified values.
     * @param taxonDescriptionReferencePK the taxonDescriptionReferencePK of the TaxonDescriptionReference
     */
    public TaxonDescriptionRecordReference(TaxonDescriptionRecordReferencePK taxonDescriptionReferencePK) {
        this.taxonDescriptionReferencePK = taxonDescriptionReferencePK;
    }

    /**
     * Creates a new instance of TaxonDescriptionReferencePK with the specified values.
     * @param referenceElementId the referenceElementId of the TaxonDescriptionReferencePK
     * @param referenceId the referenceId of the TaxonDescriptionReferencePK
     * @param taxonDescriptionId the taxonDescriptionId of the TaxonDescriptionReferencePK
     */
    public TaxonDescriptionRecordReference(Long referenceId, Long taxonDescriptionId) {
        this.taxonDescriptionReferencePK = new TaxonDescriptionRecordReferencePK(referenceId, taxonDescriptionId);
    }

    /**
     * Gets the taxonDescriptionReferencePK of this TaxonDescriptionReference.
     * @return the taxonDescriptionReferencePK
     */
    public TaxonDescriptionRecordReferencePK getTaxonDescriptionReferencePK() {
        return this.taxonDescriptionReferencePK;
    }

    /**
     * Sets the taxonDescriptionReferencePK of this TaxonDescriptionReference to the specified value.
     * @param taxonDescriptionReferencePK the new taxonDescriptionReferencePK
     */
    public void setTaxonDescriptionReferencePK(TaxonDescriptionRecordReferencePK taxonDescriptionReferencePK) {
        this.taxonDescriptionReferencePK = taxonDescriptionReferencePK;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.taxonDescriptionReferencePK != null ? this.taxonDescriptionReferencePK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this TaxonDescriptionReference.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonDescriptionReference object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionRecordReference)) {
            return false;
        }
        TaxonDescriptionRecordReference other = (TaxonDescriptionRecordReference)object;
        if (this.taxonDescriptionReferencePK != other.taxonDescriptionReferencePK && (this.taxonDescriptionReferencePK == null || !this.taxonDescriptionReferencePK.equals(other.taxonDescriptionReferencePK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.reference.TaxonDescriptionReference[taxonDescriptionReferencePK=" + taxonDescriptionReferencePK + "]";
    }

    public TaxonDescriptionRecord getTaxonDescriptionRecord() {
        return taxonDescriptionRecord;
    }

    public void setTaxonDescriptionRecord(TaxonDescriptionRecord taxonDescriptionRecord) {
        this.taxonDescriptionRecord = taxonDescriptionRecord;
    }
}
