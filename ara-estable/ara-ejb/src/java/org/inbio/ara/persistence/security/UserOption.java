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
 * UserOption.java
 *
 * Created on September 23, 2007, 6:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.security;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class UserOption
 * 
 * @author roaguilar
 */
@Entity
@Table(name = "system_user_option")
public class UserOption extends genericEntity {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    private UserOptionPK userOptionPK;
    
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne()
    private User user;

    @JoinColumn(name = "option_id", referencedColumnName = "option_id", insertable = false, updatable = false)
    @ManyToOne()
    private SystemOption option;
    
    /** Creates a new instance of UserOption */
    public UserOption() {
    }

     /**
     * Creates a new instance of UserOption with the specified values.
     * @param personProfilePK the personProfilePK of the UserOption
     */
    public UserOption(UserOptionPK userOptionPK) {
        this.userOptionPK = userOptionPK;
    }
    
    /**
     * Creates a new instance of UserOptionPK with the specified values.
     * @param profileId the profileId of the UserOptionPK
     * @param personId the personId of the UserOptionPK
     */
    public UserOption(Long userId, Long optionId) {
        this.userOptionPK = new UserOptionPK(userId, optionId);
    }
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    
    /**
     * Gets the personProfilePK of this UserOption.
     * @return the personProfilePK
     */
    public UserOptionPK getUserOptionPK() {
        return this.userOptionPK;
    }

    /**
     * Sets the personProfilePK of this UserOption to the specified value.
     * @param personProfilePK the new personProfilePK
     */
    public void setUserOptionPK(UserOptionPK userOptionPK) {
        this.userOptionPK = userOptionPK;
    }
    
    /**
     * Gets the user of this UserOption.
     * @return the user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Sets the user of this UserOption to the specified value.
     * @param user the new user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the option of this UserOption.
     * @return the option
     */
    public SystemOption getOption() {
        return this.option;
    }

    /**
     * Sets the option of this UserOption to the specified value.
     * @param option the new option
     */
    public void setOption(SystemOption option) {
        this.option = option;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.userOptionPK != null ? this.userOptionPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this UserOption.  The result is 
     * <code>true</code> if and only if the argument is not null and is a UserOption object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserOption)) {
            return false;
        }
        UserOption other = (UserOption)object;
        if (this.userOptionPK != other.userOptionPK && (this.userOptionPK == null || !this.userOptionPK.equals(other.userOptionPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.security.UserOption[userOptionPK=" + userOptionPK + "]";
    }  
}
