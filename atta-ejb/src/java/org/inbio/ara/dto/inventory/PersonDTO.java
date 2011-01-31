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

package org.inbio.ara.dto.inventory;


import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author asanabria
 * modified by esmata
 */
public class PersonDTO extends GenericDTO {

	private	Long personKey;
	private String naturalLongName;

    private String firstName;
    private String lastName;
    private String secondLastName;
    private String initials;
    private Long birthYear;
    private Long deathYear;
    private String occupation;
    private String telephone;
    private String fax;
    private String streetAddress;
    private String city;
    private String stateProvince;
    private String country;
    private String email;
    private String url;

    //Para propositos de GUI (Listado)
    private boolean selected;

	public PersonDTO() {
	}

	public PersonDTO(Long personKey) {
		this.personKey = personKey;
	}

	public String getNaturalLongName() {
		return naturalLongName;
	}

	public void setNaturalLongName(String naturalLongName) {
		this.naturalLongName = naturalLongName;
	}

	public Long getPersonKey() {
		return personKey;
	}

	public void setPersonKey(Long personKey) {
		this.personKey = personKey;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PersonDTO other = (PersonDTO) obj;
		if (this.personKey != other.personKey && (this.personKey == null || !this.personKey.equals(other.personKey))) {
			return false;
		}
		if ((this.naturalLongName == null) ? (other.naturalLongName != null) : !this.naturalLongName.equals(other.naturalLongName)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 41 * hash + (this.personKey != null ? this.personKey.hashCode() : 0);
		hash = 41 * hash + (this.naturalLongName != null ? this.naturalLongName.hashCode() : 0);
		return hash;
	}

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the secondLastName
     */
    public String getSecondLastName() {
        return secondLastName;
    }

    /**
     * @param secondLastName the secondLastName to set
     */
    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    /**
     * @return the initials
     */
    public String getInitials() {
        return initials;
    }

    /**
     * @param initials the initials to set
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }

    /**
     * @return the birthYear
     */
    public Long getBirthYear() {
        return birthYear;
    }

    /**
     * @param birthYear the birthYear to set
     */
    public void setBirthYear(Long birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * @return the deathYear
     */
    public Long getDeathYear() {
        return deathYear;
    }

    /**
     * @param deathYear the deathYear to set
     */
    public void setDeathYear(Long deathYear) {
        this.deathYear = deathYear;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the stateProvince
     */
    public String getStateProvince() {
        return stateProvince;
    }

    /**
     * @param stateProvince the stateProvince to set
     */
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
