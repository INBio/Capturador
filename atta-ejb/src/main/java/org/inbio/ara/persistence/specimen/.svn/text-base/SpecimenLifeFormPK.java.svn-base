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

package org.inbio.ara.persistence.specimen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author herson
 */
@Embeddable
public class SpecimenLifeFormPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "specimen_id")
    private Long specimenId;

    @Basic(optional = false)
    @Column(name = "life_form_id")
    private Long lifeFormId;

    public SpecimenLifeFormPK() {
    }

    public SpecimenLifeFormPK(Long specimenId, Long lifeFormId) {
        this.specimenId = specimenId;
        this.lifeFormId = lifeFormId;
    }

    public Long getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Long specimenId) {
        this.specimenId = specimenId;
    }

    public Long getLifeFormId() {
        return lifeFormId;
    }

    public void setLifeFormId(Long lifeFormId) {
        this.lifeFormId = lifeFormId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specimenId != null ? specimenId.hashCode() : 0);
        hash += (lifeFormId != null ? lifeFormId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof SpecimenLifeFormPK)) {
            return false;
        }
        SpecimenLifeFormPK other = (SpecimenLifeFormPK) object;
        if ((this.specimenId == null && other.specimenId != null) || 
                (this.specimenId != null &&
                !this.specimenId.equals(other.specimenId))) {
            return false;
        }
        if ((this.lifeFormId == null && other.lifeFormId != null) || 
                (this.lifeFormId != null &&
                !this.lifeFormId.equals(other.lifeFormId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen." +
                "SpecimenLifeFormPK[specimenId=" + specimenId +
                ", lifeFormId=" + lifeFormId + "]";
    }

}
