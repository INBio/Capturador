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
 * ReferenceElementValuePK.java
 *
 * Created on October 31, 2007, 2:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.reference;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roaguilar
 */
@Embeddable
public class ReferenceElementValuePK implements Serializable {
    
    @Column(name = "reference_element_id", nullable = false)
    private Long referenceElementId;

    @Column(name = "reference_id", nullable = false)
    private Long referenceId;
    
    /** Creates a new instance of ReferenceElementValuePK */
    public ReferenceElementValuePK() {
    }
    
    public ReferenceElementValuePK(Long referenceElementId, Long referenceId) {
        this.setReferenceElementId(referenceElementId);
        this.referenceId = referenceId;
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
        hash += (this.getReferenceElementId() != null ? this.getReferenceElementId().hashCode() : 0);
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
        if (!(object instanceof ReferenceElementValuePK)) {
            return false;
        }
        ReferenceElementValuePK other = (ReferenceElementValuePK)object;
        if (this.referenceId != other.referenceId && (this.referenceId == null || !this.referenceId.equals(other.referenceId))) return false;
        if (this.getReferenceElementId() != other.getReferenceElementId() && (this.getReferenceElementId() == null || !this.getReferenceElementId().equals(other.getReferenceElementId()))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.reference.ReferenceElementValuePK[referenceId=" + referenceId + ", referenceElementId=" + getReferenceElementId() + "]";
    }

    public Long getReferenceElementId() {
        return referenceElementId;
    }

    public void setReferenceElementId(Long referenceElementId) {
        this.referenceElementId = referenceElementId;
    }
    
}
