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
 * Reference.java
 *
 * Created on November 21, 2007, 10:39 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.reference;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.util.Language;

/**
 * Entity class Reference
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "reference")
@TableGenerator(name="reference_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="reference_id",allocationSize=1)
public class Reference extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="reference_id_gen")
    @Column(name = "reference_id", nullable = false)
    private Long id;
    
    @Column(name="title", nullable=false)
    private String title;
    
    @Column(name="description")
    private String description;
    
    @Temporal(TemporalType.DATE)
    @Column(name="publication_date")
    private Date publicationDate;
    
    @Column(name="identifier")
    private String identifier;
    
    @JoinColumn(name = "reference_type_id", referencedColumnName = "reference_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private ReferenceType referenceType;
    
    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Language language;
    
    //@Column(name="textual_reference", nullable = false)
    @Transient
    private String textualReference;
    
    @Transient
    private String languageName;
    
    @Transient
    private String referenceTypeName;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "reference")
    private Set<ReferenceElementValue> referenceElementValueSet;
    
    /** Creates a new instance of Reference */
    public Reference() {
    }

    /**
     * Gets the id of this Reference.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Reference to the specified value.
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
     * Determines whether another object is equal to this Reference.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Reference object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reference)) {
            return false;
        }
        Reference other = (Reference)object;
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
        return "org.inbio.ara.persistence.reference.Reference[id=" + id + "]";
    }

    public String getTextualReference() {
        return textualReference;
    }

    public void setTextualReference(String textualReference) {
        this.textualReference = textualReference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ReferenceType getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(ReferenceType referenceType) {
        this.referenceType = referenceType;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
    
    @PostLoad
    public void postLoad(){
        this.languageName = this.language.getLanguageName();
        this.setReferenceTypeName(this.referenceType.getName());
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getReferenceTypeName() {
        return referenceTypeName;
    }

    public void setReferenceTypeName(String referenceTypeName) {
        this.referenceTypeName = referenceTypeName;
    }
    
}
