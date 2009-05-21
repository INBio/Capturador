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
 * ReferenceElementValue.java
 *
 * Created on October 31, 2007, 2:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.reference;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class ReferenceElementValue
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "reference_element_value")
public class ReferenceElementValue extends genericEntity {

    @EmbeddedId
    protected ReferenceElementValuePK referenceElementValuePK;
    
    @Column(name="sequence")
    private Long sequence;
    
    @Column(name="contents")
    private String contents;
    
    @JoinColumn(name = "reference_element_id", referencedColumnName = "reference_element_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private ReferenceElement referenceElement;
    
    @JoinColumn(name = "reference_id", referencedColumnName = "reference_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Reference reference;
    
    /** Creates a new instance of ReferenceElementValue */
    public ReferenceElementValue() {
    }

    /**
     * Creates a new instance of TaxonDescriptionReference with the specified values.
     * @param taxonDescriptionReferencePK the taxonDescriptionReferencePK of the TaxonDescriptionReference
     */
    public ReferenceElementValue(ReferenceElementValuePK referenceElementValuePK) {
        this.referenceElementValuePK = referenceElementValuePK;
    }

    /**
     * Creates a new instance of TaxonDescriptionReferencePK with the specified values.
     * @param referenceElementId the referenceElementId of the TaxonDescriptionReferencePK
     * @param referenceId the referenceId of the TaxonDescriptionReferencePK
     * @param taxonDescriptionId the taxonDescriptionId of the TaxonDescriptionReferencePK
     */
    public ReferenceElementValue(Long referenceId, Long referenceElementId) {
        this.referenceElementValuePK = new ReferenceElementValuePK(referenceId, referenceElementId);
    }

    /**
     * Gets the taxonDescriptionReferencePK of this TaxonDescriptionReference.
     * @return the taxonDescriptionReferencePK
     */
    public ReferenceElementValuePK getReferenceElementValuePK() {
        return this.referenceElementValuePK;
    }

    /**
     * Sets the taxonDescriptionReferencePK of this TaxonDescriptionReference to the specified value.
     * @param taxonDescriptionReferencePK the new taxonDescriptionReferencePK
     */
    public void setReferenceElementValuePK(ReferenceElementValuePK referenceElementValuePK) {
        this.referenceElementValuePK = referenceElementValuePK;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.referenceElementValuePK != null ? this.referenceElementValuePK.hashCode() : 0);
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
        if (!(object instanceof ReferenceElementValue)) {
            return false;
        }
        ReferenceElementValue other = (ReferenceElementValue)object;
        if (this.referenceElementValuePK != other.referenceElementValuePK && (this.referenceElementValuePK == null || !this.referenceElementValuePK.equals(other.referenceElementValuePK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.reference.ReferenceElementValue[referenceElementValuePK=" + referenceElementValuePK + "]";
    }    

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public ReferenceElement getReferenceElement() {
        return referenceElement;
    }

    public void setReferenceElement(ReferenceElement referenceElement) {
        this.referenceElement = referenceElement;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
