/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.persistence.taxonomy;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "taxon_description_element")
public class TaxonDescriptionElement extends LogGenericEntity {
    
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TaxonDescriptionElement")
	@SequenceGenerator(name="TaxonDescriptionElement", sequenceName="taxon_description_element_seq")
    @Basic(optional = false)
    @Column(name = "taxon_description_element_id")
    private Long taxonDescriptionElementId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "mandatory")
    private Short mandatory;

    @Column(name = "description")
    private String description;

    @Column(name = "repeatable")
    private Short repeatable;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "key_field")
    private String keyField;

    @Column(name = "main_field_name")
    private String mainFieldName;

    @Column(name = "sequence")
    private Long sequence;

//    @JoinColumn(name = "taxon_description_category_id", referencedColumnName = "taxon_description_category_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private TaxonDescriptionCategory taxonDescriptionCategoryId;
    @Column(name = "taxon_description_category_id")
    private Long taxonDescriptionCategoryId;

//    @JoinColumn(name = "taxon_description_datatype_id", referencedColumnName = "taxon_description_datatype_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private TaxonDescriptionDatatype taxonDescriptionDatatypeId;
    @Column(name = "taxon_description_datatype_id")
    private Long taxonDescriptionDatatypeId;

    public TaxonDescriptionElement() {
    }

    public TaxonDescriptionElement(Long taxonDescriptionElementId) {
        this.taxonDescriptionElementId = taxonDescriptionElementId;
    }

    public TaxonDescriptionElement(Long taxonDescriptionElementId, 
            String name) {
        this.taxonDescriptionElementId = taxonDescriptionElementId;
        this.name = name;
    }

    public Long getTaxonDescriptionElementId() {
        return taxonDescriptionElementId;
    }

    public void setTaxonDescriptionElementId(Long taxonDescriptionElementId) {
        this.taxonDescriptionElementId = taxonDescriptionElementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getMandatory() {
        return mandatory;
    }

    public void setMandatory(Short mandatory) {
        this.mandatory = mandatory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getRepeatable() {
        return repeatable;
    }

    public void setRepeatable(Short repeatable) {
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

    public Long getTaxonDescriptionCategoryId() {
        return taxonDescriptionCategoryId;
    }

    public void setTaxonDescriptionCategoryId(Long taxonDescriptionCategoryId) {
        this.taxonDescriptionCategoryId = taxonDescriptionCategoryId;
    }

    public Long getTaxonDescriptionDatatypeId() {
        return taxonDescriptionDatatypeId;
    }

    public void setTaxonDescriptionDatatypeId(Long taxonDescriptionDatatypeId) {
        this.taxonDescriptionDatatypeId = taxonDescriptionDatatypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonDescriptionElementId != null ? taxonDescriptionElementId.
                hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof TaxonDescriptionElement)) {
            return false;
        }
        TaxonDescriptionElement other = (TaxonDescriptionElement) object;
        if ((this.taxonDescriptionElementId == null && 
                other.taxonDescriptionElementId != null) ||
                (this.taxonDescriptionElementId != null &&
                !this.taxonDescriptionElementId.
                equals(other.taxonDescriptionElementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionElement[" +
                "taxonDescriptionElementId=" + taxonDescriptionElementId + "]";
    }

}
