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
 * Language.java
 *
 * Created on June 21, 2007, 2:56 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Transient;
import org.inbio.ara.persistence.genericEntity;
import javax.persistence.PostLoad;


/**
 * Entity class Language
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "language")
@TableGenerator(name="language_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="language_id",allocationSize=1)
public class Language extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="language_id_gen")
    @Column(name = "language_id", nullable = false)
    private Long languageId;

    @JoinColumn(name = "concept_id", referencedColumnName = "concept_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Concept conceptId;
    
    @Transient
    private String languageName;
    
    /** Creates a new instance of Language */
    public Language() {
    }

    /**
     * Creates a new instance of Language with the specified values.
     * @param languageId the languageId of the Language
     */
    public Language(Long languageId) {
        this.languageId = languageId;
    }

    /**
     * Gets the languageId of this Language.
     * @return the languageId
     */
    public Long getLanguageId() {
        return this.languageId;
    }

    /**
     * Sets the languageId of this Language to the specified value.
     * @param languageId the new languageId
     */
    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }


    /**
     * Gets the conceptId of this Language.
     * @return the conceptId
     */
    public Concept getConceptId() {
        return this.conceptId;
    }

    /**
     * Sets the conceptId of this Language to the specified value.
     * @param conceptId the new conceptId
     */
    public void setConceptId(Concept conceptId) {
        this.conceptId = conceptId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.languageId != null ? this.languageId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Language.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Language object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language)object;
        if (this.languageId != other.languageId && (this.languageId == null || !this.languageId.equals(other.languageId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.Language[languageId=" + languageId + "]";
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @PostLoad
    public void postLoad() {
        this.setLanguageName(this.conceptId.getName());
    }
}
