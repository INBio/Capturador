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
 * TaxonDescriptionReferencePK.java
 *
 * Created on August 1, 2007, 1:34 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.reference;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class TaxonDescriptionReferencePK for entity class TaxonDescriptionReference
 * 
 * @author roaguilar
 */
@Embeddable
public class TaxonDescriptionRecordReferencePK implements Serializable {

    @Column(name = "taxon_description_record_id", nullable = false)
    private Long taxonDescriptionRecordId;

    @Column(name = "reference_id", nullable = false)
    private Long referenceId;
    
    /** Creates a new instance of TaxonDescriptionReferencePK */
    public TaxonDescriptionRecordReferencePK() {
    }

    /**
     * Creates a new instance of TaxonDescriptionReferencePK with the specified values.
     * @param referenceElementId the referenceElementId of the TaxonDescriptionReferencePK
     * @param referenceId the referenceId of the TaxonDescriptionReferencePK
     * @param taxonDescriptionRecordId the taxonDescriptionRecordId of the TaxonDescriptionReferencePK
     */
    public TaxonDescriptionRecordReferencePK(Long referenceId, Long taxonDescriptionRecordId) {
        this.referenceId = referenceId;
        this.taxonDescriptionRecordId = taxonDescriptionRecordId;
    }

    /**
     * Gets the taxonDescriptionRecordId of this TaxonDescriptionReferencePK.
     * @return the taxonDescriptionRecordId
     */
    public Long gettaxonDescriptionRecordId() {
        return this.taxonDescriptionRecordId;
    }

    /**
     * Sets the taxonDescriptionRecordId of this TaxonDescriptionReferencePK to the specified value.
     * @param taxonDescriptionRecordId the new taxonDescriptionRecordId
     */
    public void settaxonDescriptionRecordId(Long taxonDescriptionRecordId) {
        this.taxonDescriptionRecordId = taxonDescriptionRecordId;
    }

    /**
     * Gets the referenceId of this TaxonDescriptionReferencePK.
     * @return the referenceId
     */
    public Long getReferenceId() {
        return this.referenceId;
    }

    /**
     * Sets the referenceId of this TaxonDescriptionReferencePK to the specified value.
     * @param referenceId the new referenceId
     */
    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }


    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.referenceId != null ? this.referenceId.hashCode() : 0);
        hash += (this.taxonDescriptionRecordId != null ? this.taxonDescriptionRecordId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this TaxonDescriptionReferencePK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonDescriptionReferencePK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionRecordReferencePK)) {
            return false;
        }
        TaxonDescriptionRecordReferencePK other = (TaxonDescriptionRecordReferencePK)object;
        if (this.referenceId != other.referenceId && (this.referenceId == null || !this.referenceId.equals(other.referenceId))) return false;
        if (this.taxonDescriptionRecordId != other.taxonDescriptionRecordId && (this.taxonDescriptionRecordId == null || !this.taxonDescriptionRecordId.equals(other.taxonDescriptionRecordId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.reference.TaxonDescriptionReferencePK[referenceId=" + referenceId + ", taxonDescriptionRecordId=" + taxonDescriptionRecordId + "]";
    }
    
}
