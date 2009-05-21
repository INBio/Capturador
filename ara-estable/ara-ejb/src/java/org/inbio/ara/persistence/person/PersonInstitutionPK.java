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
 * PersonInstitutionPK.java
 *
 * Created on June 7, 2007, 11:56 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.person;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class PersonInstitutionPK for entity class Personinstitution
 * 
 * @author roaguilar
 */
@Embeddable
public class PersonInstitutionPK implements Serializable {

    @Column(name = "person_id", nullable = false)
    private Long personId;

    @Column(name = "institution_id", nullable = false)
    private Long institutionId;
    
    /** Creates a new instance of PersonInstitutionPK */
    public PersonInstitutionPK() {
    }

    /**
     * Creates a new instance of PersonInstitutionPK with the specified values.
     * @param institutionId the institutionId of the PersonInstitutionPK
     * @param personId the personId of the PersonInstitutionPK
     */
    public PersonInstitutionPK(Long institutionId, Long personId) {
        this.institutionId = institutionId;
        this.personId = personId;
    }

    /**
     * Gets the personId of this PersonInstitutionPK.
     * @return the personId
     */
    public Long getPersonId() {
        return this.personId;
    }

    /**
     * Sets the personId of this PersonInstitutionPK to the specified value.
     * @param personId the new personId
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * Gets the institutionId of this PersonInstitutionPK.
     * @return the institutionId
     */
    public Long getInstitutionId() {
        return this.institutionId;
    }

    /**
     * Sets the institutionId of this PersonInstitutionPK to the specified value.
     * @param institutionId the new institutionId
     */
    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.institutionId != null ? this.institutionId.hashCode() : 0);
        hash += (this.personId != null ? this.personId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this PersonInstitutionPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonInstitutionPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonInstitutionPK)) {
            return false;
        }
        PersonInstitutionPK other = (PersonInstitutionPK)object;
        if (this.institutionId != other.institutionId && (this.institutionId == null || !this.institutionId.equals(other.institutionId))) return false;
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
        return "org.inbio.ara.persistence.person.PersonInstitutionPK[institutionId=" + institutionId + ", personId=" + personId + "]";
    }
    
}
