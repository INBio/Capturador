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
 * Concept.java
 *
 * Created on June 21, 2007, 2:56 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.util;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.inbio.ara.persistence.selectionListEntity;

/**
 * Entity class Concept
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "concept")
@TableGenerator(name="concept_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="concept_id",allocationSize=1)
public class Concept extends selectionListEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="concept_id_gen")
    @Column(name = "concept_id", nullable = false)
    private Long conceptId;


    @OneToMany(mappedBy = "conceptId")
    private Set<Language> languageSet;
    
    /** Creates a new instance of Concept */
    public Concept() {
    }

    /**
     * Creates a new instance of Concept with the specified values.
     * @param conceptId the conceptId of the Concept
     */
    public Concept(Long conceptId) {
        this.conceptId = conceptId;
    }

    /**
     * Gets the conceptId of this Concept.
     * @return the conceptId
     */
    public Long getId() {
        return this.conceptId;
    }

    /**
     * Sets the conceptId of this Concept to the specified value.
     * @param conceptId the new conceptId
     */
    public void setId(Long conceptId) {
        this.conceptId = conceptId;
    }

    /**
     * Gets the languageSet of this Concept.
     * @return the languageSet
     */
    public Set<Language> getLanguageSet() {
        return this.languageSet;
    }

    /**
     * Sets the languageSet of this Concept to the specified value.
     * @param languageSet the new languageSet
     */
    public void setLanguageSet(Set<Language> languageSet) {
        this.languageSet = languageSet;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.conceptId != null ? this.conceptId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Concept.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Concept object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concept)) {
            return false;
        }
        Concept other = (Concept)object;
        if (this.conceptId != other.conceptId && (this.conceptId == null || !this.conceptId.equals(other.conceptId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.Concept[conceptId=" + conceptId + "]";
    }
    
}
