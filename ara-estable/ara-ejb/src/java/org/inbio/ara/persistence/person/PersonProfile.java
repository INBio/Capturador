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
import javax.persistence.Column;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.taxonomy.TaxonAuthor;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.inbio.ara.persistence.species.SpeciesRecordStageProfile;
//import org.inbio.ara.persistence.species.SpeciesRecordPerson;
import org.inbio.ara.persistence.species.TaxonDescriptionPersonProfile;

/**
 * Entity class PersonProfile
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "person_profile")
public class PersonProfile extends genericEntity {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected PersonProfilePK personProfilePK;
    
    @Column(name = "short_name")
    private String shortName;

    @Column(name = "valid_from")
    private Long validFrom;

    @Column(name = "valid_to")
    private Long validTo;
    
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;

    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Profile profile;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "personProfile")
    private Set<TaxonAuthor> taxonAuthorSet;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "personProfile")
    private Set<PersonProfileTaxon> personProfileTaxonSet;
    
    //@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "personProfile")
    //private Set<SpeciesRecordStageProfile> SpeciesRecordStageProfileSet;
    
    /*
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "personProfile")
    private Set<SpeciesRecordPersonProfile> speciesRecordPersonSet;
     */
    
    /** Creates a new instance of PersonProfile */
    public PersonProfile() {
    }

     /**
     * Creates a new instance of PersonProfile with the specified values.
     * @param personProfilePK the personProfilePK of the PersonProfile
     */
    public PersonProfile(PersonProfilePK personProfilePK) {
        this.personProfilePK = personProfilePK;
    }
    
    /**
     * Creates a new instance of PersonProfilePK with the specified values.
     * @param profileId the profileId of the PersonProfilePK
     * @param personId the personId of the PersonProfilePK
     */
    public PersonProfile(Long profileId, Long personId) {
        this.personProfilePK = new PersonProfilePK(profileId, personId);
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
    public PersonProfilePK getPersonProfilePK() {
        return this.personProfilePK;
    }

    /**
     * Sets the personProfilePK of this PersonProfile to the specified value.
     * @param personProfilePK the new personProfilePK
     */
    public void setPersonProfilePK(PersonProfilePK personProfilePK) {
        this.personProfilePK = personProfilePK;
    }
    
    /**
     * Gets the shortName of this PersonProfile.
     * @return the shortName
     */
    public String getShortName() {
        return this.shortName;
    }

    /**
     * Sets the shortName of this PersonProfile to the specified value.
     * @param shortName the new shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Gets the validFrom of this PersonProfile.
     * @return the validFrom
     */
    public Long getValidFrom() {
        return this.validFrom;
    }

    /**
     * Sets the validFrom of this PersonProfile to the specified value.
     * @param validFrom the new validFrom
     */
    public void setValidFrom(Long validFrom) {
        this.validFrom = validFrom;
    }

    /**
     * Gets the validTo of this PersonProfile.
     * @return the validTo
     */
    public Long getValidTo() {
        return this.validTo;
    }

    /**
     * Sets the validTo of this PersonProfile to the specified value.
     * @param validTo the new validTo
     */
    public void setValidTo(Long validTo) {
        this.validTo = validTo;
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
    public Profile getProfile() {
        return this.profile;
    }

    /**
     * Sets the profile of this PersonProfile to the specified value.
     * @param profile the new profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.personProfilePK != null ? this.personProfilePK.hashCode() : 0);
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
        if (!(object instanceof PersonProfile)) {
            return false;
        }
        PersonProfile other = (PersonProfile)object;
        if (this.personProfilePK != other.personProfilePK && (this.personProfilePK == null || !this.personProfilePK.equals(other.personProfilePK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.person.PersonProfile[personProfilePK=" + personProfilePK + "]";
    }

    public Set<TaxonAuthor> getTaxonAuthorSet() {
        return taxonAuthorSet;
    }

    public void setTaxonAuthorSet(Set<TaxonAuthor> taxonAuthorSet) {
        this.taxonAuthorSet = taxonAuthorSet;
    }

    public Set<PersonProfileTaxon> getPersonProfileTaxonSet() {
        return personProfileTaxonSet;
    }

    public void setPersonProfileTaxonSet(Set<PersonProfileTaxon> personProfileTaxonSet) {
        this.personProfileTaxonSet = personProfileTaxonSet;
    }

    /*
    public Set<SpeciesRecordPersonProfile> getSpeciesRecordPersonSet() {
        return speciesRecordPersonSet;
    }

    public void setSpeciesRecordPersonSet(Set<SpeciesRecordPersonProfile> speciesRecordPersonSet) {
        this.speciesRecordPersonSet = speciesRecordPersonSet;
    }
    */
}
