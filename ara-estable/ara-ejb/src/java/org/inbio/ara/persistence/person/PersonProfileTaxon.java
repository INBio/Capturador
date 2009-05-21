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
 * PersonProfileTaxon.java
 *
 * Created on June 22, 2007, 3:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.person;

import org.inbio.ara.persistence.taxonomy.Taxon;
import org.inbio.ara.persistence.genericEntity;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class PersonProfileTaxon
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "person_profile_taxon")
public class PersonProfileTaxon extends genericEntity{

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected PersonProfileTaxonPK personProfileTaxonPK;

    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @ManyToOne
    private Person person;

    @JoinColumns(value =  {
            @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false),
            @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", insertable = false, updatable = false)
        })
    @ManyToOne()
    private PersonProfile personProfile;

    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", insertable = false, updatable = false)
    @ManyToOne()
    private Profile profile;

    @JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id", insertable = false, updatable = false)
    @ManyToOne()
    private org.inbio.ara.persistence.taxonomy.Taxon taxon;
    
    /** Creates a new instance of PersonProfileTaxon */
    public PersonProfileTaxon() {
    }

    /**
     * Creates a new instance of PersonProfileTaxon with the specified values.
     * @param personProfileTaxonPK the personProfileTaxonPK of the PersonProfileTaxon
     */
    public PersonProfileTaxon(PersonProfileTaxonPK personProfileTaxonPK) {
        this.personProfileTaxonPK = personProfileTaxonPK;
    }

    /**
     * Creates a new instance of PersonProfileTaxonPK with the specified values.
     * @param taxonId the taxonId of the PersonProfileTaxonPK
     * @param profileId the profileId of the PersonProfileTaxonPK
     * @param personId the personId of the PersonProfileTaxonPK
     */
    public PersonProfileTaxon(Long taxonId, Long profileId, Long personId) {
        this.personProfileTaxonPK = new PersonProfileTaxonPK(taxonId, profileId, personId);
    }

    /**
     * Gets the personProfileTaxonPK of this PersonProfileTaxon.
     * @return the personProfileTaxonPK
     */
    public PersonProfileTaxonPK getPersonProfileTaxonPK() {
        return this.personProfileTaxonPK;
    }

    /**
     * Sets the personProfileTaxonPK of this PersonProfileTaxon to the specified value.
     * @param personProfileTaxonPK the new personProfileTaxonPK
     */
    public void setPersonProfileTaxonPK(PersonProfileTaxonPK personProfileTaxonPK) {
        this.personProfileTaxonPK = personProfileTaxonPK;
    }

    /**
     * Gets the person of this PersonProfileTaxon.
     * @return the person
     */
    public Person getPerson() {
        return this.person;
    }

    /**
     * Sets the person of this PersonProfileTaxon to the specified value.
     * @param person the new person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Gets the personProfile of this PersonProfileTaxon.
     * @return the personProfile
     */
    public PersonProfile getPersonProfile() {
        return this.personProfile;
    }

    /**
     * Sets the personProfile of this PersonProfileTaxon to the specified value.
     * @param personProfile the new personProfile
     */
    public void setPersonProfile(PersonProfile personProfile) {
        this.personProfile = personProfile;
    }

    /**
     * Gets the profile of this PersonProfileTaxon.
     * @return the profile
     */
    public Profile getProfile() {
        return this.profile;
    }

    /**
     * Sets the profile of this PersonProfileTaxon to the specified value.
     * @param profile the new profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Gets the taxon of this PersonProfileTaxon.
     * @return the taxon
     */
    public Taxon getTaxon() {
        return this.taxon;
    }

    /**
     * Sets the taxon of this PersonProfileTaxon to the specified value.
     * @param taxon the new taxon
     */
    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.personProfileTaxonPK != null ? this.personProfileTaxonPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this PersonProfileTaxon.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonProfileTaxon object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonProfileTaxon)) {
            return false;
        }
        PersonProfileTaxon other = (PersonProfileTaxon)object;
        if (this.personProfileTaxonPK != other.personProfileTaxonPK && (this.personProfileTaxonPK == null || !this.personProfileTaxonPK.equals(other.personProfileTaxonPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.person.PersonProfileTaxon[personProfileTaxonPK=" + personProfileTaxonPK + "]";
    }
    
}
