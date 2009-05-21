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
 * NomenclaturalGroup.java
 *
 * Created on April 29, 2008, 12:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.selectionListEntity;

/**
 *
 * @author roaguilar
 */

@Entity
@Table(name = "nomenclatural_group")

@TableGenerator(name="nomenclatural_group_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="nomenclatural_group_id",allocationSize=1)
public class NomenclaturalGroup extends selectionListEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="nomenclatural_group_id_gen")
    @Column(name = "nomenclatural_group_id", nullable = false)
    private Long id;
    
    @Column(name="common_name")
    private String commonName;
    
    @Column(name="notes")
    private String notes;
    
    @Column(name="temporality")
    private String temporality;
    
    @JoinColumn(name="certificator_person_id", referencedColumnName="person_id", insertable = true, updatable = true, nullable = true)
    @ManyToOne()
    private Person person;
        
    @JoinColumn(name="collection_id", referencedColumnName="collection_id")
    @ManyToOne()
    private Collection collection;
    
    @Transient
    private String certificatorPersonName;
    
    @Transient
    private String collectionName;
    
    @OneToMany(mappedBy = "nomenclaturalGroup", cascade = CascadeType.REMOVE)
    private List<TaxonNomenclaturalGroup> taxonNomenclaturalGroupList;    
    
    @OneToMany(mappedBy = "nomenclaturalGroup", cascade = CascadeType.REMOVE)
    private List<NomenclaturalGroupRegion> nomenclaturalGroupRegionList;
    
    @Transient
    private Long firstTaxonId;
    
    @Transient
    private Taxon firstTaxon;
    
    /** Creates a new instance of NomenclaturalGroup */
    public NomenclaturalGroup() {
    }
    
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this NomenclaturalGroup.  The result is 
     * <code>true</code> if and only if the argument is not null and is a NomenclaturalGroup object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NomenclaturalGroup)) {
            return false;
        }
        NomenclaturalGroup other = (NomenclaturalGroup)object;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.NomenclaturalGroup[id=" + getId() + "]";
    }        

    public Long getId() {
        return id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    @PostLoad
    public void postLoad(){
		if(this.getPerson() != null){
			this.setCertificatorPersonName(this.getPerson().getFormalLongName());
		}
		
        this.setCollectionName(this.collection.getName());
        
        try {
            if (taxonNomenclaturalGroupList != null) {
                if (taxonNomenclaturalGroupList.size() > 0) {
                    //this.setFirstTaxonId(this.getTaxonNomenclaturalGroupList().get(0).getTaxon().getTaxonId());
                    this.setFirstTaxon(this.getTaxonNomenclaturalGroupList().get(0).getTaxon());
                } else {
                    this.setFirstTaxon(null);
                }
            } else {
                this.setFirstTaxon(null);
            }
        } catch (Exception ex1) {
            this.setFirstTaxon(null);
        }   
    }

    public String getCertificatorPersonName() {
        return certificatorPersonName;
    }

    public void setCertificatorPersonName(String certificatorPersonName) {
        this.certificatorPersonName = certificatorPersonName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTemporality() {
        return temporality;
    }

    public void setTemporality(String temporality) {
        this.temporality = temporality;
    }

    public List<TaxonNomenclaturalGroup> getTaxonNomenclaturalGroupList() {
        return taxonNomenclaturalGroupList;
    }

    public void setTaxonNomenclaturalGroupList(List<TaxonNomenclaturalGroup> taxonNomenclaturalGroupList) {
        this.taxonNomenclaturalGroupList = taxonNomenclaturalGroupList;
    }

    public List<NomenclaturalGroupRegion> getNomenclaturalGroupRegionList() {
        return nomenclaturalGroupRegionList;
    }

    public void setNomenclaturalGroupRegionList(List<NomenclaturalGroupRegion> nomenclaturalGroupRegionList) {
        this.nomenclaturalGroupRegionList = nomenclaturalGroupRegionList;
    }

    public Long getFirstTaxonId() {
        return firstTaxonId;
    }

    public void setFirstTaxonId(Long firstTaxonId) {
        this.firstTaxonId = firstTaxonId;
    }

    public Taxon getFirstTaxon() {
        return firstTaxon;
    }

    public void setFirstTaxon(Taxon firstTaxon) {
        this.firstTaxon = firstTaxon;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
