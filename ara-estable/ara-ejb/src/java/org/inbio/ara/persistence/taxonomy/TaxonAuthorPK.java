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
 * TaxonAuthorPK.java
 *
 * Created on June 22, 2007, 2:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class TaxonAuthorPK for entity class TaxonAuthor
 * 
 * @author roaguilar
 */
@Embeddable
public class TaxonAuthorPK implements Serializable {

    @Column(name = "taxon_id", nullable = false)
    private Long taxonId;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "taxon_author_sequence", nullable = false)
    private Long taxonAuthorSequence;
    
    /** Creates a new instance of TaxonAuthorPK */
    public TaxonAuthorPK() {
    }

    /**
     * Creates a new instance of TaxonAuthorPK with the specified values.
     * @param taxonAuthorSequence the taxonAuthorSequence of the TaxonAuthorPK
     * @param category the category of the TaxonAuthorPK
     * @param taxonId the taxonId of the TaxonAuthorPK
     */
    public TaxonAuthorPK(Long taxonAuthorSequence, String category, Long taxonId) {
        this.taxonAuthorSequence = taxonAuthorSequence;
        this.category = category;
        this.taxonId = taxonId;
    }

    /**
     * Gets the taxonId of this TaxonAuthorPK.
     * @return the taxonId
     */
    public Long getTaxonId() {
        return this.taxonId;
    }

    /**
     * Sets the taxonId of this TaxonAuthorPK to the specified value.
     * @param taxonId the new taxonId
     */
    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    /**
     * Gets the category of this TaxonAuthorPK.
     * @return the category
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Sets the category of this TaxonAuthorPK to the specified value.
     * @param category the new category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the taxonAuthorSequence of this TaxonAuthorPK.
     * @return the taxonAuthorSequence
     */
    public Long getTaxonAuthorSequence() {
        return this.taxonAuthorSequence;
    }

    /**
     * Sets the taxonAuthorSequence of this TaxonAuthorPK to the specified value.
     * @param taxonAuthorSequence the new taxonAuthorSequence
     */
    public void setTaxonAuthorSequence(Long taxonAuthorSequence) {
        this.taxonAuthorSequence = taxonAuthorSequence;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.taxonAuthorSequence != null ? this.taxonAuthorSequence.hashCode() : 0);
        hash += (this.category != null ? this.category.hashCode() : 0);
        hash += (this.taxonId != null ? this.taxonId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this TaxonAuthorPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonAuthorPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonAuthorPK)) {
            return false;
        }
        TaxonAuthorPK other = (TaxonAuthorPK)object;
        if (this.taxonAuthorSequence != other.taxonAuthorSequence && (this.taxonAuthorSequence == null || !this.taxonAuthorSequence.equals(other.taxonAuthorSequence))) return false;
        if (this.category != other.category && (this.category == null || !this.category.equals(other.category))) return false;
        if (this.taxonId != other.taxonId && (this.taxonId == null || !this.taxonId.equals(other.taxonId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonAuthorPK[taxonAuthorSequence=" + taxonAuthorSequence + ", category=" + category + ", taxonId=" + taxonId + "]";
    }
    
}
