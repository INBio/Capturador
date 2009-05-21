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
 * TaxonomicalRange.java
 *
 * Created on June 22, 2007, 10:34 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.inbio.ara.persistence.genericEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.Set;
import javax.persistence.FetchType;
/**
 * Entity class TaxonomicalRange
 * 
 * 
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "taxonomical_range")

@NamedQueries ({
    @NamedQuery(name ="TaxonomicalRange.findByTaxonomicalRangeId", query = "SELECT r FROM TaxonomicalRange r WHERE r.id = :taxonRangeId")
})

@TableGenerator(name="taxonomical_range_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="taxonomical_range_id",allocationSize=1)
public class TaxonomicalRange extends genericEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="taxonomical_range_id_gen")
    @Column(name = "taxonomical_range_id", nullable = false)
    private Long id;
    
    @Column(name="name",length=80,nullable=false)
    private String name;
    
    @Column(name="prefix",length=20)
    private String prefix;
    
    @Column(name="parenthesis",length=1,nullable=false)
    private Long parenthesis;
    
    @Column(name="taxonomical_range_category",length=1,nullable=false)
    private String taxonomicalRangeCategory;
    
    @Column(name="field_name",length=30)
    private String fieldName;
    
    @Column(name="taxonomical_hierarchy_level")
    private Long taxonomicalHierarchyLevel;
    
    @Column(name="mandatory_level",length=1)
    private Long mandatoryLevel;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "taxonomicalRange")
    private Set<Taxon> taxonSet;
    
    /*
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "taxonomicalRange1")
    private Set<TaxonomicalRange> childTaxonomicalRangeSet;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "taxonomicalRange")
    private Set<TaxonomicalRange> ancestorTaxonomicalRangeSet;
    */
    /**
     * Creates a new instance of TaxonomicalRange
     */
    public TaxonomicalRange() {
    }
    
    public TaxonomicalRange(String name, Long parenthesis, String taxonomicalRangeCategory) {
        this.setName(name);
        this.setParenthesis(parenthesis);
        this.setTaxonomicalRangeCategory(taxonomicalRangeCategory);
    }
    
    /**
     * Gets the id of this TaxonomicalRange.
     * 
     * 
     * @return the id
     */
    public Long getId() {
        return this.id;
    }
    
    /**
     * Sets the id of this TaxonomicalRange to the specified value.
     * 
     * 
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
     * Determines whether another object is equal to this TaxonomicalRange.  The result is
     * <code>true</code> if and only if the argument is not null and is a TaxonomicalRange object that
     * has the same id field values as this object.
     * 
     * 
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonomicalRange)) {
            return false;
        }
        TaxonomicalRange other = (TaxonomicalRange)object;
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
        return "org.inbio.ara.persistence.taxonomy.TaxonomicalRange[id=" + id + "]";
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPrefix() {
        return prefix;
    }
    
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    public Long getParenthesis() {
        return parenthesis;
    }
    
    public void setParenthesis(Long parenthesis) {
        this.parenthesis = parenthesis;
    }
    
    public String getTaxonomicalRangeCategory() {
        return taxonomicalRangeCategory;
    }
    
    public void setTaxonomicalRangeCategory(String taxonomicalRangeCategory) {
        this.taxonomicalRangeCategory = taxonomicalRangeCategory;
    }
    
    public String getFieldName() {
        return fieldName;
    }
    
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    public Long getTaxonomicalHierarchyLevel() {
        return taxonomicalHierarchyLevel;
    }
    
    public void setTaxonomicalHierarchyLevel(Long taxonomicalHierarchyLevel) {
        this.taxonomicalHierarchyLevel = taxonomicalHierarchyLevel;
    }
    
    public Long getMandatoryLevel() {
        return mandatoryLevel;
    }
    
    public void setMandatoryLevel(Long mandatoryLevel) {
        this.mandatoryLevel = mandatoryLevel;
    }

    public Set<Taxon> getTaxonSet() {
        return taxonSet;
    }

    public void setTaxonSet(Set<Taxon> taxonSet) {
        this.taxonSet = taxonSet;
    }
/*
    public Set<TaxonomicalRange> getChildTaxonomicalRangeSet() {
        return childTaxonomicalRangeSet;
    }

    public void setChildTaxonomicalRangeSet(Set<TaxonomicalRange> childTaxonomicalRangeSet) {
        this.childTaxonomicalRangeSet = childTaxonomicalRangeSet;
    }

    public Set<TaxonomicalRange> getAncestorTaxonomicalRangeSet() {
        return ancestorTaxonomicalRangeSet;
    }

    public void setAncestorTaxonomicalRangeSet(Set<TaxonomicalRange> ancestorTaxonomicalRangeSet) {
        this.ancestorTaxonomicalRangeSet = ancestorTaxonomicalRangeSet;
    }

  */  
    
}
