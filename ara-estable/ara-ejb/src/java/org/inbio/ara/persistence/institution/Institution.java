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
 * Institution.java
 *
 * Created on July 18, 2007, 11:52 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.institution;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.person.PersonInstitution;


/**
 * Entity class Institution
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "institution")
@TableGenerator(name="institution_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="institution_id",allocationSize=1)
public class Institution extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="institution_id_gen")
    @Column(name = "institution_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

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

    @Column(name = "acronym")
    private String acronym;

    @Column(name = "url")
    private String url;

    @Column(name = "multimedia_id")
    private Long multimediaId;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "institution", fetch = FetchType.LAZY)
    private Set<PersonInstitution> personInstitutionSet;

    //@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "institution")
    //private Set<SpeciesRecordInstitution> speciesRecordInstitutionSet;
    
    /** Creates a new instance of Institution */
    public Institution() {
    }

    /**
     * Creates a new instance of Institution with the specified values.
     * @param id the id of the Institution
     */
    public Institution(Long id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Institution with the specified values.
     * @param id the id of the Institution
     * @param name the name of the Institution
     */
    public Institution(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Institution(String name) {
        this.name = name;
    }

    /**
     * Gets the id of this Institution.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Institution to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of this Institution.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this Institution to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the telephone of this Institution.
     * @return the telephone
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     * Sets the telephone of this Institution to the specified value.
     * @param telephone the new telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Gets the fax of this Institution.
     * @return the fax
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * Sets the fax of this Institution to the specified value.
     * @param fax the new fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Gets the streetAddress of this Institution.
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return this.streetAddress;
    }

    /**
     * Sets the streetAddress of this Institution to the specified value.
     * @param streetAddress the new streetAddress
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets the city of this Institution.
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city of this Institution to the specified value.
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the stateProvince of this Institution.
     * @return the stateProvince
     */
    public String getStateProvince() {
        return this.stateProvince;
    }

    /**
     * Sets the stateProvince of this Institution to the specified value.
     * @param stateProvince the new stateProvince
     */
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    /**
     * Gets the country of this Institution.
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Sets the country of this Institution to the specified value.
     * @param country the new country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the acronym of this Institution.
     * @return the acronym
     */
    public String getAcronym() {
        return this.acronym;
    }

    /**
     * Sets the acronym of this Institution to the specified value.
     * @param acronym the new acronym
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * Gets the url of this Institution.
     * @return the url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Sets the url of this Institution to the specified value.
     * @param url the new url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the multimediaId of this Institution.
     * @return the multimediaId
     */
    public Long getMultimediaId() {
        return this.multimediaId;
    }

    /**
     * Sets the multimediaId of this Institution to the specified value.
     * @param multimediaId the new multimediaId
     */
    public void setMultimediaId(Long multimediaId) {
        this.multimediaId = multimediaId;
    }


    
    /**
     * Gets the speciesRecordInstitutionSet of this Institution.
     * @return the speciesRecordInstitutionSet
     */
    /*public Set<SpeciesRecordInstitution> getSpeciesRecordInstitutionSet() {
        return this.speciesRecordInstitutionSet;
    }*/

    /**
     * Sets the speciesRecordInstitutionSet of this Institution to the specified value.
     * @param speciesRecordInstitutionSet the new speciesRecordInstitutionSet
     */
    /*public void setSpeciesRecordInstitutionSet(Set<SpeciesRecordInstitution> speciesRecordInstitutionSet) {
        this.speciesRecordInstitutionSet = speciesRecordInstitutionSet;
    }*/

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
     * Determines whether another object is equal to this Institution.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Institution object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institution)) {
            return false;
        }
        Institution other = (Institution)object;
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
        return "org.inbio.ara.persistence.institution.Institution[id=" + id + "]";
    }

    public Set<PersonInstitution> getPersonInstitutionSet() {
        return personInstitutionSet;
    }

    public void setPersonInstitutionSet(Set<PersonInstitution> personInstitutionSet) {
        this.personInstitutionSet = personInstitutionSet;
    }

    /*public Set<SpeciesRecordInstitution> getSpeciesRecordInstitutionSet() {
        return speciesRecordInstitutionSet;
    }

    public void setSpeciesRecordInstitutionSet(Set<SpeciesRecordInstitution> speciesRecordInstitutionSet) {
        this.speciesRecordInstitutionSet = speciesRecordInstitutionSet;
    }*/
    
}
