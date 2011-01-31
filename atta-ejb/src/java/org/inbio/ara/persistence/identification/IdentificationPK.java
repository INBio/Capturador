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

package org.inbio.ara.persistence.identification;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author herson
 */
@Embeddable
public class IdentificationPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "specimen_id")
    private Long specimenId;

    @Basic(optional = false)
    @Column(name = "identification_sequence")
    private Long identificationSequence;

    @Basic(optional = false)
    @Column(name = "initial_timestamp")
    @Temporal(TemporalType.DATE)
    private Calendar initialTimestamp;

    public IdentificationPK() {
    }

    public IdentificationPK(Long specimenId, Long identificationSequence, Calendar initialTimestamp) {
        this.specimenId = specimenId;
        this.identificationSequence = identificationSequence;
        this.initialTimestamp = initialTimestamp;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specimenId != null ? specimenId.hashCode() : 0);
        hash += (identificationSequence != null ? identificationSequence.hashCode() : 0);
        hash += (initialTimestamp != null ? initialTimestamp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificationPK)) {
            return false;
        }
        IdentificationPK other = (IdentificationPK) object;
        if ((this.specimenId == null && other.specimenId != null) || (this.specimenId != null && !this.specimenId.equals(other.specimenId))) {
            return false;
        }
        if ((this.identificationSequence == null && other.identificationSequence != null) || (this.identificationSequence != null && !this.identificationSequence.equals(other.identificationSequence))) {
            return false;
        }
        if ((this.initialTimestamp == null && other.initialTimestamp != null) || (this.initialTimestamp != null && !this.initialTimestamp.equals(other.initialTimestamp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.IdentificationPK[specimenId=" + specimenId + ", identificationSequence=" + identificationSequence + ", initialTimestamp=" + initialTimestamp + "]";
    }

}
