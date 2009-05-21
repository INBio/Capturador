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
 * PersonProfile.java
 *
 * Created on June 7, 2007, 6:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.person;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class PersonInstitution
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "person_institution")
public class PersonInstitution extends genericEntity {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected PersonInstitutionPK personInstitutionPK;
    
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;

    @JoinColumn(name = "institution_id", referencedColumnName = "institution_id", insertable = false, updatable = false)
    @ManyToOne
    private Institution institution;
    
    /** Creates a new instance of PersonProfile */
    public PersonInstitution() {
    }

     /**
     * Creates a new instance of PersonProfile with the specified values.
     * @param personProfilePK the personProfilePK of the PersonProfile
     */
    public PersonInstitution(PersonInstitutionPK personInstitutionPK) {
        this.personInstitutionPK = personInstitutionPK;
    }
    
    /**
     * Creates a new instance of PersonProfilePK with the specified values.
     * @param profileId the profileId of the PersonProfilePK
     * @param personId the personId of the PersonProfilePK
     */
    public PersonInstitution(Long institutionId, Long personId) {
        this.personInstitutionPK = new PersonInstitutionPK(institutionId, personId);
    }
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    
    /**
     * Gets the personProfilePK of this PersonProfile.
     * @return the personProfilePK
     */
    public PersonInstitutionPK getPersonProfilePK() {
        return this.personInstitutionPK;
    }

    /**
     * Sets the personProfilePK of this PersonProfile to the specified value.
     * @param personProfilePK the new personProfilePK
     */
    public void setPersonInstitutionPK(PersonInstitutionPK personInstitutionPK) {
        this.personInstitutionPK = personInstitutionPK;
    }
    
    /**
     * Gets the person of this PersonProfile.
     * @return the person
     */
    public Person getPerson() {
        return this.person;
    }

    /**
     * Sets the person of this PersonProfile to the specified value.
     * @param person the new person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Gets the profile of this PersonProfile.
     * @return the profile
     */
    public Institution getInstitution() {
        return this.institution;
    }

    /**
     * Sets the profile of this PersonProfile to the specified value.
     * @param profile the new profile
     */
    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.personInstitutionPK != null ? this.personInstitutionPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this PersonProfile.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonProfile object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonInstitution)) {
            return false;
        }
        PersonInstitution other = (PersonInstitution)object;
        if (this.personInstitutionPK != other.personInstitutionPK && (this.personInstitutionPK == null || !this.personInstitutionPK.equals(other.personInstitutionPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.person.PersonInstitution[personInstitutionPK=" + personInstitutionPK + "]";
    }
}
