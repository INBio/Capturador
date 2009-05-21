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
 * TaxonDescriptionRecord.java
 *
 * Created on October 22, 2007, 1:38 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.species;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.reference.TaxonDescriptionRecordReference;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionElement;

/**
 * Entity class TaxonDescriptionRecord
 * 
 * @author roaguilar
 */
@Entity()
@Table(name = "taxon_description_record")
@TableGenerator(name="taxon_description_record_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="taxon_description_record_id",allocationSize=1)
public class TaxonDescriptionRecord extends genericEntity {


    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="taxon_description_record_id_gen")
    @Column(name = "taxon_description_record_id", nullable = false)
    private Long id;
    
    @JoinColumns(value =  {
            @JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id", insertable = true, updatable = true),
            @JoinColumn(name = "taxon_description_sequence", referencedColumnName = "taxon_description_sequence", insertable = true, updatable = true)
        })
    @ManyToOne()
    private TaxonDescription taxonDescription;
    
    @JoinColumn(name = "taxon_description_element_id", referencedColumnName="taxon_description_element_id")
    @ManyToOne()
    private TaxonDescriptionElement taxonDescriptionElement;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "taxonDescriptionRecord")
    private Set<TaxonDescriptionRecordReference> taxonDescriptionRecordReferenceSet;
    
    @Column(name="sequence")
    private Long sequence;
    
    @Column(name="contents_text")
    private String contentsText;
    
    @Column(name="contents_numeric")
    private Long contentsNumeric;
    
    @Column(name="taxonomical_timestamp")
    @Temporal(TemporalType.DATE)
    private Date taxonomicalTimestamp;
    
    /*
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "taxonDescriptionRecord")
    private Set<TaxonDescriptionRecordReference> taxonDescriptionRecordReferenceSet;
     */
    
    /** Creates a new instance of TaxonDescriptionRecord */
    public TaxonDescriptionRecord() {
    }
    
    /**
     * Gets the id of this TaxonDescriptionRecord.
     * @return the id
     */
    public Long getId() {
        return this.id;
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
     * Determines whether another object is equal to this TaxonDescriptionRecord.  The result is 
     * <code>true</code> if and only if the argument is not null and is a TaxonDescriptionRecord object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionRecord)) {
            return false;
        }
        TaxonDescriptionRecord other = (TaxonDescriptionRecord)object;
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
        return "org.inbio.ara.persistence.species.TaxonDescriptionRecord[id=" + id + "]";
    }

    public TaxonDescription getTaxonDescription() {
        return taxonDescription;
    }

    public void setTaxonDescription(TaxonDescription taxonDescription) {
        this.taxonDescription = taxonDescription;
    }

    public TaxonDescriptionElement getTaxonDescriptionElement() {
        return taxonDescriptionElement;
    }

    public void setTaxonDescriptionElement(TaxonDescriptionElement taxonDescriptionElement) {
        this.taxonDescriptionElement = taxonDescriptionElement;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getContentsText() {
        return contentsText;
    }

    public void setContentsText(String contentsText) {
        this.contentsText = contentsText;
    }

    public Long getContentsNumeric() {
        return contentsNumeric;
    }

    public void setContentsNumeric(Long contentsNumeric) {
        this.contentsNumeric = contentsNumeric;
    }

    public Date getTaxonomicalTimestamp() {
        return taxonomicalTimestamp;
    }

    public void setTaxonomicalTimestamp(Date taxonomicalTimestamp) {
        this.taxonomicalTimestamp = taxonomicalTimestamp;
    }

    /*
    public Set<TaxonDescriptionRecordReference> getTaxonDescriptionRecordReferenceSet() {
        return taxonDescriptionRecordReferenceSet;
    }

    public void setTaxonDescriptionRecordReferenceSet(Set<TaxonDescriptionRecordReference> taxonDescriptionRecordReferenceSet) {
        this.taxonDescriptionRecordReferenceSet = taxonDescriptionRecordReferenceSet;
    }
    */
}
