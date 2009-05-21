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
 * TaxonCategory.java
 *
 * Created on June 21, 2007, 4:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.inbio.ara.persistence.selectionListEntity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.Set;
import javax.persistence.FetchType;

/**
 * Entity class TaxonCategory
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "taxon_category")

@NamedQueries ({
    @NamedQuery(name ="TaxonCategory.findByTaxonCategoryId", query = "SELECT c FROM TaxonCategory c WHERE c.id = :taxonCategoryId")
})

@TableGenerator(name="taxon_category_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="taxon_category_id",allocationSize=1)
public class TaxonCategory extends selectionListEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="taxon_category_id_gen")
    @Column(name = "taxon_category_id", nullable = false)
    private Long id;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "taxonCategory")
    private Set<Taxon> TaxonSet;
    
    /** Creates a new instance of TaxonCategory */
    public TaxonCategory() {
        super();
    }

    /**
     * Gets the id of this TaxonCategory.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this TaxonCategory to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this TaxonCategory.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonCategory object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonCategory)) {
            return false;
        }
        TaxonCategory other = (TaxonCategory)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonCategory[id=" + id + "]";
    }

    public Set<Taxon> getTaxonSet() {
        return TaxonSet;
    }

    public void setTaxonSet(Set<Taxon> TaxonSet) {
        this.TaxonSet = TaxonSet;
    }
    
}
