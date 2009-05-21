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
 * UserOptionPK.java
 *
 * Created on June 7, 2007, 11:56 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.security;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class UserOptionPK for entity class UserOption
 * 
 * @author roaguilar
 */
@Embeddable
public class UserOptionPK implements Serializable {

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "option_id", nullable = false)
    private Long optionId;
    
    /** Creates a new instance of UserOptionPK */
    public UserOptionPK() {
    }

    /**
     * Creates a new instance of UserOptionPK with the specified values.
     * @param userId the userId of the UserOptionPK
     * @param optionId the optionId of the UserOptionPK
     */
    public UserOptionPK(Long userId, Long optionId) {
        this.userId = userId;
        this.optionId = optionId;
    }

    /**
     * Gets the optionId of this UserOptionPK.
     * @return the optionId
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * Sets the optionId of this UserOptionPK to the specified value.
     * @param optionId the new optionId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the userId of this UserOptionPK.
     * @return the userId
     */
    public Long getOptionId() {
        return this.optionId;
    }

    /**
     * Sets the userId of this UserOptionPK to the specified value.
     * @param userId the new userId
     */
    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.userId != null ? this.userId.hashCode() : 0);
        hash += (this.optionId != null ? this.optionId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this UserOptionPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a UserOptionPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserOptionPK)) {
            return false;
        }
        UserOptionPK other = (UserOptionPK)object;
        if (this.userId != other.userId && (this.userId == null || !this.userId.equals(other.userId))) return false;
        if (this.optionId != other.optionId && (this.optionId == null || !this.optionId.equals(other.optionId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.person.UserOptionPK[userId=" + userId + ", optionId=" + optionId + "]";
    }
    
}
