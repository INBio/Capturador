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
 * TaxonomicalHierarchyPK.java
 *
 * Created on June 22, 2007, 11:36 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class TaxonomicalHierarchyPK for entity class TaxonomicalHierarchy
 * 
 * @author roaguilar
 */
@Embeddable
public class TaxonomicalHierarchyPK implements Serializable {

    @Column(name = "taxonomical_range_id", nullable = false)
    private Long taxonomicalRangeId;

    @Column(name = "ancestor_taxonomical_id", nullable = false)
    private Long ancestorTaxonomicalId;
    
    /** Creates a new instance of TaxonogmicalHierarchyPK */
    public TaxonomicalHierarchyPK() {
    }

    /**
     * Creates a new instance of TaxonomicalHierarchyPK with the specified values.
     * @param ancestorTaxonomicalId the ancestorTaxonomicalId of the TaxonomicalHierarchyPK
     * @param taxonomicalRangeId the taxonomicalRangeId of the TaxonomicalHierarchyPK
     */
    public TaxonomicalHierarchyPK(Long ancestorTaxonomicalId, Long taxonomicalRangeId) {
        this.ancestorTaxonomicalId = ancestorTaxonomicalId;
        this.taxonomicalRangeId = taxonomicalRangeId;
    }

    /**
     * Gets the taxonomicalRangeId of this TaxonomicalHierarchyPK.
     * @return the taxonomicalRangeId
     */
    public Long getTaxonomicalRangeId() {
        return this.taxonomicalRangeId;
    }

    /**
     * Sets the taxonomicalRangeId of this TaxonomicalHierarchyPK to the specified value.
     * @param taxonomicalRangeId the new taxonomicalRangeId
     */
    public void setTaxonomicalRangeId(Long taxonomicalRangeId) {
        this.taxonomicalRangeId = taxonomicalRangeId;
    }

    /**
     * Gets the ancestorTaxonomicalId of this TaxonomicalHierarchyPK.
     * @return the ancestorTaxonomicalId
     */
    public Long getAncestorTaxonomicalId() {
        return this.ancestorTaxonomicalId;
    }

    /**
     * Sets the ancestorTaxonomicalId of this TaxonomicalHierarchyPK to the specified value.
     * @param ancestorTaxonomicalId the new ancestorTaxonomicalId
     */
    public void setAncestorTaxonomicalId(Long ancestorTaxonomicalId) {
        this.ancestorTaxonomicalId = ancestorTaxonomicalId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.ancestorTaxonomicalId != null ? this.ancestorTaxonomicalId.hashCode() : 0);
        hash += (this.taxonomicalRangeId != null ? this.taxonomicalRangeId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this TaxonomicalHierarchyPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonomicalHierarchyPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonomicalHierarchyPK)) {
            return false;
        }
        TaxonomicalHierarchyPK other = (TaxonomicalHierarchyPK)object;
        if (this.ancestorTaxonomicalId != other.ancestorTaxonomicalId && (this.ancestorTaxonomicalId == null || !this.ancestorTaxonomicalId.equals(other.ancestorTaxonomicalId))) return false;
        if (this.taxonomicalRangeId != other.taxonomicalRangeId && (this.taxonomicalRangeId == null || !this.taxonomicalRangeId.equals(other.taxonomicalRangeId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonomicalHierarchyPK[ancestorTaxonomicalId=" + ancestorTaxonomicalId + ", taxonomicalRangeId=" + taxonomicalRangeId + "]";
    }
    
}
