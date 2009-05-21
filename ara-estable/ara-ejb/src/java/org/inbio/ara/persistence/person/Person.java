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
 * Person.java
 *
 * Created on June 6, 2007, 10:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.TableGenerator;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import java.util.Set;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class Person
 * 
 * @author Róger Aguilar P.
 */
@Entity()
@Table(name = "person")
@TableGenerator(name="person_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="person_id",allocationSize=1)
//@NamedQuery(name="getTaxonDescriptionAuthors", query = "")
public class Person extends genericEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="person_id_gen")
    @Column(name="person_id", nullable = false)
    private Long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name",nullable = false)
    private String lastName;
    
    @Column(name="second_last_name")
    private String secondLastName;
    
    @Column(name="initials")
    private String initials;
    
    @Column(name="birth_year")
    private Integer birthYear;
    
    @Column(name="death_year")
    private Integer deathYear;
    
    @Column(name="occupation")
    private String occupation;
    
    @Column(name="telephone")
    private String telephone;
    
    @Column(name="fax")
    private String fax;
    
    @Column(name="street_address")
    private String streetAddress;
    
    @Column(name="city")
    private String city;
    
    @Column(name="state_province")
    private String stateName;
    
    @Column(name="country")
    private String country;
    
    @Column(name="email")
    private String email;
    
    @Column(name="url")
    private String url;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "person")
    private Set<PersonProfile> personProfileSet;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "person")
    private Set<PersonInstitution> personInstitutionSet;
    
    @Transient
    private String formalShortName;
    
    @Transient
    private String naturalShortName;
    
    @Transient
    private String formalLongName;
    
    @Transient
    private String naturalLongName;
    
    @Transient
    private String formalFullName;
    
    @Transient
    private String naturalFullName;
    
    @Transient
    private String abreviatedName;
    
    /** Creates a new instance of Person */
    public Person() {
    }

     public Person(String aLastName){
        this.setLastname(aLastName);
    }
    
    /**
     * Gets the id of this Person.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Person to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String aFirstName) {
        this.firstName = aFirstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastname(String aLastName) {
        this.setLastName(aLastName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Set<PersonProfile> getPersonProfileSet() {
        return this.personProfileSet;
    }

    /**
     * Sets the personProfileSet of this Person to the specified value.
     * @param personProfileSet the new personProfileSet
     */
    public void setPersonProfileSet(Set<PersonProfile> personProfileSet) {
        this.personProfileSet = personProfileSet;
    }
    
    public Set<PersonInstitution> getPersonInstitutionSet() {
        return this.personInstitutionSet;
    }

    /**
     * Sets the personInstitutionSet of this Person to the specified value.
     * @param personInstitutionSet the new personInstitutionSet
     */
    public void setPersonInstitutionSet(Set<PersonInstitution> personInstitutionSet) {
        this.personInstitutionSet = personInstitutionSet;
    }
    
    private void setCalculatedValues() {
        setFormalShortName();
        setNaturalShortName();
        setFormalLongName();
        setNaturalLongName();
        setFormalFullName();
        setNaturalFullName();
        setAbbreviatedName();
    }
    
    @PostLoad
    public void postLoad() {
        this.setCalculatedValues();
        //super.postLoad();
    }

    @PostPersist
    public void postPersist() {
        this.setCalculatedValues();
    }
    
    @PostUpdate
    public void postUpdate(){
        this.setCalculatedValues();
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
     * Determines whether another object is equal to this Person.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Person object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person)object;
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
        return "org.inbio.ara.persistence.person[id=" + id + "]";
    }
    

    public String getFormalShortName() {
        return formalShortName;
    }

    public void setFormalShortName() {
        String tmp;
        String tLastName = "";
        String tInitials = "";
        
        if (this.lastName != null) tLastName = this.lastName;
        if (this.initials != null) tInitials = this.initials;
        
        tmp = tLastName + ", " + tInitials;
        this.formalShortName = tmp;
    }

    public String getNaturalShortName() {
        return naturalShortName;
    }

    public void setNaturalShortName() {
        String tmp;
        String tLastName = "";
        String tInitials = "";
        
        if (this.lastName != null) tLastName = this.lastName;
        if (this.initials != null) tInitials = this.initials;
        
        tmp = tInitials + " " + tLastName;
        this.naturalShortName = tmp;
    }

    
    public String getFormalLongName() {
        return formalLongName;
    }

    public void setFormalLongName() {
        String tmp;
        String tLastName = "";
        String tFirstName = "";
        
        if (this.lastName != null) tLastName = this.lastName;
        if (this.firstName != null) tFirstName = this.firstName;
        
        tmp = tLastName + ", " + tFirstName;
        this.formalLongName = tmp;
    }

    public String getNaturalLongName() {
        return naturalLongName;
    }

    public void setNaturalLongName() {
        String tmp;
        String tLastName = "";
        String tFirstName = "";
        
        if (this.lastName != null) tLastName = this.lastName;
        if (this.firstName != null) tFirstName = this.firstName;
        
        tmp = tFirstName + " " + tLastName;
        this.naturalLongName = tmp;        
    }

    public String getFormalFullName() {
        return formalFullName;
    }

    public void setFormalFullName() {
        String tmp;
        String tLastName = "";
        String tFirstName = "";
        String tSecondLastName = "";
        
        if (this.lastName != null) tLastName = this.lastName;
        if (this.firstName != null) tFirstName = this.firstName;
        if (this.secondLastName != null) tSecondLastName = this.secondLastName;
        
        tmp = tLastName + " " + tSecondLastName + ", " + tFirstName;
        this.formalFullName = tmp;
    }

    public String getNaturalFullName() {
        return naturalFullName;
    }

    public void setNaturalFullName() {
        String tmp;
        String tLastName = "";
        String tFirstName = "";
        String tSecondLastName = "";
        
        if (this.lastName != null) tLastName = this.lastName;
        if (this.firstName != null) tFirstName = this.firstName;
        if (this.secondLastName != null) tSecondLastName = this.secondLastName;
        
        tmp = tFirstName + " " + tSecondLastName + " " + tLastName;
        this.naturalFullName = tmp;
    }

    public String getAbreviatedName() {
        return abreviatedName;
    }

    public void setAbbreviatedName() {
        String tmp;
        String tInitial = "";
        String tLastName = "";
        
        if (this.firstName != null) tInitial = "" + this.firstName.charAt(0) + ".";
        if (this.lastName != null) tLastName = this.lastName;
        
        tmp = tInitial + " " + tLastName;
        this.abreviatedName = tmp;
    }


}
