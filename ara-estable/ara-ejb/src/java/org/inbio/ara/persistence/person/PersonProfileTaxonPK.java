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
 * PersonProfileTaxonPK.java
 *
 * Created on June 22, 2007, 3:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.person;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class PersonProfileTaxonPK for entity class PersonProfileTaxon
 * 
 * @author roaguilar
 */
@Embeddable
public class PersonProfileTaxonPK implements Serializable {

    @Column(name = "person_id", nullable = false)
    private Long personId;

    @Column(name = "profile_id", nullable = false)
    private Long profileId;

    @Column(name = "taxon_id", nullable = false)
    private Long taxonId;
    
    /** Creates a new instance of PersonProfileTaxonPK */
    public PersonProfileTaxonPK() {
    }

    /**
     * Creates a new instance of PersonProfileTaxonPK with the specified values.
     * @param taxonId the taxonId of the PersonProfileTaxonPK
     * @param profileId the profileId of the PersonProfileTaxonPK
     * @param personId the personId of the PersonProfileTaxonPK
     */
    public PersonProfileTaxonPK(Long taxonId, Long profileId, Long personId) {
        this.taxonId = taxonId;
        this.profileId = profileId;
        this.personId = personId;
    }

    /**
     * Gets the personId of this PersonProfileTaxonPK.
     * @return the personId
     */
    public Long getPersonId() {
        return this.personId;
    }

    /**
     * Sets the personId of this PersonProfileTaxonPK to the specified value.
     * @param personId the new personId
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * Gets the profileId of this PersonProfileTaxonPK.
     * @return the profileId
     */
    public Long getProfileId() {
        return this.profileId;
    }

    /**
     * Sets the profileId of this PersonProfileTaxonPK to the specified value.
     * @param profileId the new profileId
     */
    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    /**
     * Gets the taxonId of this PersonProfileTaxonPK.
     * @return the taxonId
     */
    public Long getTaxonId() {
        return this.taxonId;
    }

    /**
     * Sets the taxonId of this PersonProfileTaxonPK to the specified value.
     * @param taxonId the new taxonId
     */
    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.taxonId != null ? this.taxonId.hashCode() : 0);
        hash += (this.profileId != null ? this.profileId.hashCode() : 0);
        hash += (this.personId != null ? this.personId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this PersonProfileTaxonPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonProfileTaxonPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonProfileTaxonPK)) {
            return false;
        }
        PersonProfileTaxonPK other = (PersonProfileTaxonPK)object;
        if (this.taxonId != other.taxonId && (this.taxonId == null || !this.taxonId.equals(other.taxonId))) return false;
        if (this.profileId != other.profileId && (this.profileId == null || !this.profileId.equals(other.profileId))) return false;
        if (this.personId != other.personId && (this.personId == null || !this.personId.equals(other.personId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.person.PersonProfileTaxonPK[taxonId=" + taxonId + ", profileId=" + profileId + ", personId=" + personId + "]";
    }
    
}
