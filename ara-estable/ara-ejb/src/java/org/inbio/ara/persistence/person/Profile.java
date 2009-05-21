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
 * Profile.java
 *
 * Created on June 7, 2007, 11:56 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.person;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.inbio.ara.persistence.genericEntity;
/**
 * Entity class Profile
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "profile")
@TableGenerator(name="profile_id_gen",table="ID_GEN",pkColumnName="GEN_KEY",valueColumnName="GEN_VALUE",pkColumnValue="profile_id",allocationSize=1)
public class Profile extends genericEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE,generator="profile_id_gen")
    @Column(name = "profile_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "profile")
    private Set<PersonProfile> personProfileSet;
    
    /** Creates a new instance of Profile */
    public Profile() {
    }


    /**
     * Creates a new instance of Profile with the specified values.
     * @param profileId the profileId of the Profile
     * @param name the name of the Profile
     */
    public Profile(String name) {
        this.name = name;
    }

    /**
     * Gets the profileId of this Profile.
     * @return the profileId
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the profileId of this Profile to the specified value.
     * @param profileId the new profileId
     */
    public void setId(Long profileId) {
        this.id = id;
    }

    /**
     * Gets the name of this Profile.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this Profile to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of this Profile.
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of this Profile to the specified value.
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Gets the personProfileSet of this Profile.
     * @return the personProfileSet
     */
    public Set<PersonProfile> getPersonProfileSet() {
        return this.personProfileSet;
    }

    /**
     * Sets the personProfileSet of this Profile to the specified value.
     * @param personProfileSet the new personProfileSet
     */
    public void setPersonProfileSet(Set<PersonProfile> personProfileSet) {
        this.personProfileSet = personProfileSet;
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
     * Determines whether another object is equal to this Profile.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Profile object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile)object;
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
        return "org.inbio.ara.persistence.person.Profile[id=" + id + "]";
    }
    
}
