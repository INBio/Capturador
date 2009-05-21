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
 * TaxonDescriptionCategory.java
 *
 * Created on June 7, 2007, 6:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Column;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class TaxonDescriptionCategory
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "taxon_description_category")
@TableGenerator(name="taxon_description_category_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="TAXON_DESCRIPTION_CATEGORY_ID",allocationSize=1)
public class TaxonDescriptionCategory extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="taxon_description_category_id_gen")
    @Column(name="taxon_description_category_id", nullable = false)
    private Long id;

    @Column(name="name",nullable=false)
    private String name;
    
    @Column(name="description")
    private String description;
    
    @Column(name="sequence")
    private int sequence;
    
    //@JoinColumn(name = "ancestor_id", referencedColumnName = "taxon_description_category_id")
    //@ManyToOne
    //private TaxonDescriptionCategory Ancestor;
    
    @Column(name="ancestor_id")
    private Long ancestor;    
    
    //@OneToMany(mappedBy="Ancestor")
    //private Set<TaxonDescriptionCategory> taxonDescriptionCategoryChildSet;
    
    //@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "taxonDescriptionCategory")
    //private Set<TaxonDescriptionElement> taxonDescriptionElementSet;
    
    @Column(name="repeatable")
    private Long repeatable;
    
    @Column(name="mandatory")
    private Long mandatory;
    
    /** Creates a new instance of TaxonDescriptionCategory */
    public TaxonDescriptionCategory() {
    }

    /**
     * Gets the id of this TaxonDescriptionCategory.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this TaxonDescriptionCategory to the specified value.
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
     * Determines whether another object is equal to this TaxonDescriptionCategory.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonDescriptionCategory object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionCategory)) {
            return false;
        }
        TaxonDescriptionCategory other = (TaxonDescriptionCategory)object;
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
        return "org.inbio.ara.persistence.species.TaxonDescriptionCategory[id=" + id + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    /*
    public TaxonDescriptionCategory getAncestor() {
        return Ancestor;
    }

    public void setAncestor(TaxonDescriptionCategory Ancestor) {
        this.Ancestor = Ancestor;
    }

     */
    /*
    public Set<TaxonDescriptionCategory> getTaxonDescriptionCategoryChildSet() {
        return taxonDescriptionCategoryChildSet;
    }

    public void setTaxonDescriptionCategoryChildSet(Set<TaxonDescriptionCategory> taxonDescriptionCategoryChildSet) {
        this.taxonDescriptionCategoryChildSet = taxonDescriptionCategoryChildSet;
    }
    */
    public Long getRepeatable() {
        return repeatable;
    }

    public void setRepeatable(Long repeatable) {
        this.repeatable = repeatable;
    }

    public Long getMandatory() {
        return mandatory;
    }

    public void setMandatory(Long mandatory) {
        this.mandatory = mandatory;
    }
/*
    public Set<TaxonDescriptionElement> getTaxonDescriptionElementSet() {
        return taxonDescriptionElementSet;
    }

    public void setTaxonDescriptionElementSet(Set<TaxonDescriptionElement> taxonDescriptionElementSet) {
        this.taxonDescriptionElementSet = taxonDescriptionElementSet;
    }
  */  

    public Long getAncestor() {
        return ancestor;
    }

    public void setAncestor(Long ancestor) {
        this.ancestor = ancestor;
    }
}
