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
 * Identifier.java
 *
 * Created on October 31, 2007, 12:47 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.genericEntity;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.person.PersonProfile;

/**
 * Entity class Identifier
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="identifier")
public class Identifier extends genericEntity {

    @EmbeddedId
    private IdentifierPK identifierPK;
    
    @Column(name="identifier_sequence",nullable=false)
    private Long identifierSequence;
    
    @JoinColumns({
        @JoinColumn(name="specimen_id", referencedColumnName="specimen_id", insertable= false, updatable=false),
        @JoinColumn(name="identification_sequence", referencedColumnName="identification_sequence", insertable= false, updatable=false),
        @JoinColumn(name="initial_timestamp", referencedColumnName="initial_timestamp", insertable= false, updatable=false)})    
    @ManyToOne()
    private Identification identification;
        
    @JoinColumn(name="identifier_person_id", referencedColumnName="person_id", insertable= false, updatable=false)
    @ManyToOne()
    private Person person;        
    
    /** Creates a new instance of Identifier */
    public Identifier() {
    }

    public Identifier(IdentifierPK identifierPK) {
        this.setIdentifierPK(identifierPK);
    }
    
    public Identifier(Long specimenId, Long identificationSequence, Date initialTimeStamp, Long identifierPersonId) {
        this.setIdentifierPK(new IdentifierPK(specimenId, identificationSequence, initialTimeStamp, identifierPersonId));
    }

    public IdentifierPK getIdentifierPK() {
        return identifierPK;
    }

    public void setIdentifierPK(IdentifierPK identifierPK) {
        this.identifierPK = identifierPK;
    }

    public Long getIdentifierSequence() {
        return identifierSequence;
    }

    public void setIdentifierSequence(Long identifierSequence) {
        this.identifierSequence = identifierSequence;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.identifierPK != null ? this.identifierPK.hashCode() : 0);
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
        if (!(object instanceof Identifier)) {
            return false;
        }
        Identifier other = (Identifier)object;
        if (this.identifierPK != other.identifierPK && (this.identifierPK == null || !this.identifierPK.equals(other.identifierPK))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.Identifier[identifierPK=" + identifierPK + "]";
    }         

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
