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
 * TaxonomicalHierarchy.java
 *
 * Created on June 22, 2007, 11:36 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import org.inbio.ara.persistence.genericEntity;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class TaxonomicalHierarchy
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "taxonomical_hierarchy")
public class TaxonomicalHierarchy extends genericEntity {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected TaxonomicalHierarchyPK taxonomicalHierarchyPK;

    @JoinColumn(name = "ancestor_taxonomical_id", referencedColumnName = "taxonomical_range_id", insertable = false, updatable = false)
    @ManyToOne()
    private TaxonomicalRange taxonomicalRange;

    @JoinColumn(name = "taxonomical_range_id", referencedColumnName = "taxonomical_range_id", insertable = false, updatable = false)
    @ManyToOne()
    private TaxonomicalRange taxonomicalRange1;
    
    /** Creates a new instance of TaxonomicalHierarchy */
    public TaxonomicalHierarchy() {
    }

    /**
     * Creates a new instance of TaxonomicalHierarchy with the specified values.
     * @param taxonomicalHierarchyPK the taxonomicalHierarchyPK of the TaxonomicalHierarchy
     */
    public TaxonomicalHierarchy(TaxonomicalHierarchyPK taxonomicalHierarchyPK) {
        this.taxonomicalHierarchyPK = taxonomicalHierarchyPK;
    }

    /**
     * Creates a new instance of TaxonomicalHierarchyPK with the specified values.
     * @param ancestorTaxonomicalId the ancestorTaxonomicalId of the TaxonomicalHierarchyPK
     * @param taxonomicalRangeId the taxonomicalRangeId of the TaxonomicalHierarchyPK
     */
    public TaxonomicalHierarchy(Long ancestorTaxonomicalId, Long taxonomicalRangeId) {
        this.taxonomicalHierarchyPK = new TaxonomicalHierarchyPK(ancestorTaxonomicalId, taxonomicalRangeId);
    }

    /**
     * Gets the taxonomicalHierarchyPK of this TaxonomicalHierarchy.
     * @return the taxonomicalHierarchyPK
     */
    public TaxonomicalHierarchyPK getTaxonomicalHierarchyPK() {
        return this.taxonomicalHierarchyPK;
    }

    /**
     * Sets the taxonomicalHierarchyPK of this TaxonomicalHierarchy to the specified value.
     * @param taxonomicalHierarchyPK the new taxonomicalHierarchyPK
     */
    public void setTaxonomicalHierarchyPK(TaxonomicalHierarchyPK taxonomicalHierarchyPK) {
        this.taxonomicalHierarchyPK = taxonomicalHierarchyPK;
    }

    /**
     * Gets the taxonomicalRange of this TaxonomicalHierarchy.
     * @return the taxonomicalRange
     */
    public TaxonomicalRange getTaxonomicalRange() {
        return this.taxonomicalRange;
    }

    /**
     * Sets the taxonomicalRange of this TaxonomicalHierarchy to the specified value.
     * @param taxonomicalRange the new taxonomicalRange
     */
    public void setTaxonomicalRange(TaxonomicalRange taxonomicalRange) {
        this.taxonomicalRange = taxonomicalRange;
    }

    /**
     * Gets the taxonomicalRange1 of this TaxonomicalHierarchy.
     * @return the taxonomicalRange1
     */
    public TaxonomicalRange getAncestorTaxonomicalRange() {
        return this.taxonomicalRange1;
    }

    /**
     * Sets the taxonomicalRange1 of this TaxonomicalHierarchy to the specified value.
     * @param taxonomicalRange1 the new taxonomicalRange1
     */
    public void setAncestorTaxonomicalRange(TaxonomicalRange taxonomicalRange1) {
        this.taxonomicalRange1 = taxonomicalRange1;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.taxonomicalHierarchyPK != null ? this.taxonomicalHierarchyPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this TaxonomicalHierarchy.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonomicalHierarchy object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonomicalHierarchy)) {
            return false;
        }
        TaxonomicalHierarchy other = (TaxonomicalHierarchy)object;
        if (this.taxonomicalHierarchyPK != other.taxonomicalHierarchyPK && (this.taxonomicalHierarchyPK == null || !this.taxonomicalHierarchyPK.equals(other.taxonomicalHierarchyPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonomicalHierarchy[taxonomicalHierarchyPK=" + taxonomicalHierarchyPK + "]";
    }
    
}
