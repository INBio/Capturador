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
 * TaxonDescriptionElement.java
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
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.Set;
import javax.persistence.FetchType;

/**
 * Entity class TaxonDescriptionElement
 * 
 * @author roaguilar
 */
@Entity()
@Table(name = "taxon_description_element")
@TableGenerator(name="taxon_description_element_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="TAXON_DESCRIPTION_ELEMENT_ID",allocationSize=1)
public class TaxonDescriptionElement extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="taxon_description_element_id_gen")
    @Column(name="taxon_description_element_id", nullable = false)
    private Long id;
    
    @Column(name="name",length=80,nullable=false)
    private String name;
    
    @Column(name="description",length=200)
    private String description;
    
    @Column(name="mandatory",length=1)
    private int mandatory;
    
    @Column(name="repeatable",length=1)
    private int repeatable;
    
    @Column(name="table_name",length=30)
    private String tableName;
    
    @Column(name="key_field",length=30)
    private String keyField;
    
    @Column(name="main_field_name",length=30)
    private String mainFieldName;
    
    @Column(name="sequence")
    private Long sequence;
    
    @JoinColumn(name="taxon_description_datatype_id",referencedColumnName="taxon_description_datatype_id")
    @ManyToOne()
    private TaxonDescriptionDataType taxonDescriptionDataType;

    @JoinColumn(name="taxon_description_category_id",referencedColumnName="taxon_description_category_id")
    @ManyToOne()
    private TaxonDescriptionCategory taxonDescriptionCategory;    
    
    /*
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "taxonDescriptionElement")
    private Set<TaxonDescription> taxonDescriptionSet;
    
     */
    /** Creates a new instance of TaxonDescriptionElement */
    public TaxonDescriptionElement() {
    }

    /**
     * Gets the id of this TaxonDescriptionElement.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this TaxonDescriptionElement to the specified value.
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
     * Determines whether another object is equal to this TaxonDescriptionElement.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonDescriptionElement object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionElement)) {
            return false;
        }
        TaxonDescriptionElement other = (TaxonDescriptionElement)object;
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
        return "org.inbio.ara.persistence.species.TaxonDescriptionElement[id=" + id + "]";
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

    public int getMandatory() {
        return mandatory;
    }

    public void setMandatory(int mandatory) {
        this.mandatory = mandatory;
    }

    public int getRepeatable() {
        return repeatable;
    }

    public void setRepeatable(int repeatable) {
        this.repeatable = repeatable;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getKeyField() {
        return keyField;
    }

    public void setKeyField(String keyField) {
        this.keyField = keyField;
    }

    public String getMainFieldName() {
        return mainFieldName;
    }

    public void setMainFieldName(String mainFieldName) {
        this.mainFieldName = mainFieldName;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public TaxonDescriptionDataType getTaxonDescriptionDataType() {
        return taxonDescriptionDataType;
    }

    public void setTaxonDescriptionDataType(TaxonDescriptionDataType taxonDescriptionDataType) {
        this.taxonDescriptionDataType = taxonDescriptionDataType;
    }    

    public TaxonDescriptionCategory getTaxonDescriptionCategory() {
        return taxonDescriptionCategory;
    }

    public void setTaxonDescriptionCategory(TaxonDescriptionCategory taxonDescriptionCategory) {
        this.taxonDescriptionCategory = taxonDescriptionCategory;
    }

    /*
    public Set<TaxonDescription> getTaxonDescriptionSet() {
        return taxonDescriptionSet;
    }

    public void setTaxonDescriptionSet(Set<TaxonDescription> taxonDescriptionSet) {
        this.taxonDescriptionSet = taxonDescriptionSet;
    }
    */
}