/* Ara - capture species and specimen data
 *
 * Copyright © 2010 INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.persistence.identification;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author asanabria
 */
@Embeddable
public class IdentifierPK implements Serializable {
    @Basic(optional=false)
    @Column(name = "specimen_id")
    private Long specimenId;

    @Basic(optional = false)
    @Column(name = "identification_sequence", updatable=false, insertable=false)
    private Long identificationSequence;

    @Basic(optional = false)
    @Column(name = "initial_timestamp")
    @Temporal(TemporalType.DATE)
    private Calendar initialTimestamp;

//    @Basic(optional = false)
//    @Column(name = "identifier_person_id")
//    private Long identifierPersonId;
    @JoinColumn(name = "identifier_person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person identifierPerson;


    public IdentifierPK() {
    }

    public IdentifierPK(Long specimenId, Long identificationSequence,
            Calendar initialTimestamp, Person identifierPerson) {
        this.specimenId = specimenId;
        this.identificationSequence = identificationSequence;
        this.initialTimestamp = initialTimestamp;
        this.identifierPerson = identifierPerson;
    }

    public Long getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Long specimenId) {
        this.specimenId = specimenId;
    }

    public Long getIdentificationSequence() {
        return identificationSequence;
    }

    public void setIdentificationSequence(Long identificationSequence) {
        this.identificationSequence = identificationSequence;
    }

    public Calendar getInitialTimestamp() {
        return initialTimestamp;
    }

    public void setInitialTimestamp(Calendar initialTimestamp) {
        this.initialTimestamp = initialTimestamp;
    }

    public Person getIdentifierPerson() {
        return identifierPerson;
    }

    public void setIdentifierPerson(Person identifierPersonId) {
        this.identifierPerson = identifierPersonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specimenId != null ? specimenId.hashCode() : 0);
        hash += (identificationSequence != null ? identificationSequence.hashCode() : 0);
        hash += (initialTimestamp != null ? initialTimestamp.hashCode() : 0);
        hash += (identifierPerson != null ? identifierPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentifierPK)) {
            return false;
        }
        IdentifierPK other = (IdentifierPK) object;
        if ((this.specimenId == null && other.specimenId != null) || (this.specimenId != null && !this.specimenId.equals(other.specimenId))) {
            return false;
        }
        if ((this.identificationSequence == null && other.identificationSequence != null) || (this.identificationSequence != null && !this.identificationSequence.equals(other.identificationSequence))) {
            return false;
        }
        if ((this.initialTimestamp == null && other.initialTimestamp != null) || (this.initialTimestamp != null && !this.initialTimestamp.equals(other.initialTimestamp))) {
            return false;
        }
        if ((this.identifierPerson == null && other.identifierPerson != null) || (this.identifierPerson != null && !this.identifierPerson.equals(other.identifierPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.IdentifierPK[specimenId=" + specimenId + ", identificationSequence=" + identificationSequence + ", initialTimestamp=" + initialTimestamp + ", identifierPersonId=" + identifierPerson + "]";
    }

}
