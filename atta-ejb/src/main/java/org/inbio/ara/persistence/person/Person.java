/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.persistence.person;

import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.gathering.GatheringObservation;

/**
 *
 * @author herson
 * modified by esmata
 */
@Entity
@Table(name = "person")
public class Person extends LogGenericEntity {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="Person")
	@SequenceGenerator(name="Person", sequenceName="person_seq")
    @Basic(optional = false)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "initials")
    private String initials;

    @Column(name = "birth_year")
    private Long birthYear;

    @Column(name = "death_year")
    private Long deathYear;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @Column(name = "country")
    private String country;

    @Column(name = "email")
    private String email;

    @Column(name = "url")
    private String url;

    @Column(name = "second_last_name")
    private String secondLastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsiblePersonId", fetch = FetchType.LAZY)
    private List<GatheringObservation> gatheringObservationCollection;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
		name = "person_profile",
		joinColumns = {@JoinColumn(name ="person_id")},
		inverseJoinColumns = {@JoinColumn(name = "profile_id")}
	)
	private Set<Profile> profiles;


    public Person() {
    }

    public Person(Long personId) {
        this.personId = personId;
    }

    public Person(Long personId, String lastName, String createdBy, String lastModificationBy) {
        this.personId = personId;
        this.lastName = lastName;
        this.setCreatedBy(createdBy);
        this.setLastModificationBy(lastModificationBy);
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Long getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Long birthYear) {
        this.birthYear = birthYear;
    }

    public Long getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Long deathYear) {
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

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
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

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

//    public Long getObjVersion() {
//        return objVersion;
//    }
//
//    public void setObjVersion(Long objVersion) {
//        this.objVersion = objVersion;
//    }

    public List<GatheringObservation> getGatheringObservationCollection() {
        return gatheringObservationCollection;
    }

    public void setGatheringObservationCollection(List<GatheringObservation> gatheringObservationCollection) {
        this.gatheringObservationCollection = gatheringObservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.person.Person[personId=" + personId + "]";
    }

    /**
     * 
     * 
     * @return "lastName, initials"
     */
      public String getFormalShortName() {
        String tLastName = "";
        String tInitials = "";

        if (this.lastName != null) tLastName = this.lastName;
        if (this.initials != null) tInitials = this.initials;

        return tLastName + ", " + tInitials;
    }
    
    /**
     *
     * @return "initials lastName"
     */
    public String getNaturalShortName() {
        String tLastName = "";
        String tInitials = "";

        if (this.lastName != null) tLastName = this.lastName;
        if (this.initials != null) tInitials = this.initials;

        return tInitials + " " + tLastName;
    }

    /**
     * 
     * @return "lastName, firstName"
     */
    public String getFormalLongName() {
        String tLastName = "";
        String tFirstName = "";

        if (this.lastName != null) tLastName = this.lastName;
        if (this.firstName != null) tFirstName = this.firstName;

        return tLastName + ", " + tFirstName;
    
    }

    /**
     * @return "firstName lastName"
     */
    public String getNaturalLongName() {
        String tLastName = "";
        String tFirstName = "";

        if (this.lastName != null) tLastName = this.lastName;
        if (this.firstName != null) tFirstName = this.firstName;

        return tFirstName + " " + tLastName;
    }

    /**
     * @return "lastName secondLastName, firstName"
     */
    public String getFormalFullName() {
        String tLastName = "";
        String tFirstName = "";
        String tSecondLastName = "";

        if (this.lastName != null) tLastName = this.lastName;
        if (this.firstName != null) tFirstName = this.firstName;
        if (this.secondLastName != null) tSecondLastName = this.secondLastName;

        return tLastName + " " + tSecondLastName + ", " + tFirstName;
    }

    /**
     * @return "firstName secondLastName lastName"
     */
    public String getNaturalFullName() {
       
        String tLastName = "";
        String tFirstName = "";
        String tSecondLastName = "";

        if (this.lastName != null)
            tLastName = this.lastName;
        if (this.firstName != null)
            tFirstName = this.firstName;
        if (this.secondLastName != null)
            tSecondLastName = this.secondLastName;

        return tFirstName + " " + tSecondLastName + " " + tLastName;
    }

    /**
     *
     * @return "inicial lastName"
     */
    public String getAbreviatedName() {
        String tInitial = "";
        String tLastName = "";

        if (this.firstName != null)
            tInitial = "" + this.firstName.charAt(0) + ".";
        if (this.lastName != null)
            tLastName = this.lastName;

        return tInitial + " " + tLastName;
    }

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
}
