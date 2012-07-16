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

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "specimen_life_form")
public class SpecimenLifeForm extends GenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SpecimenLifeFormPK specimenLifeFormPK;
    
    public SpecimenLifeForm() {
    }

    public SpecimenLifeForm(SpecimenLifeFormPK specimenLifeFormPK) {
        this.specimenLifeFormPK = specimenLifeFormPK;
    }

    public SpecimenLifeForm(Long specimenId, Long lifeFormId) {
        this.specimenLifeFormPK =
                new SpecimenLifeFormPK(specimenId, lifeFormId);
    }

    public SpecimenLifeFormPK getSpecimenLifeFormPK() {
        return specimenLifeFormPK;
    }

    public void setSpecimenLifeFormPK(SpecimenLifeFormPK specimenLifeFormPK) {
        this.specimenLifeFormPK = specimenLifeFormPK;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specimenLifeFormPK != null ?
            specimenLifeFormPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        //not set
        if (!(object instanceof SpecimenLifeForm)) {
            return false;
        }
        SpecimenLifeForm other = (SpecimenLifeForm) object;
        if ((this.specimenLifeFormPK == null &&
                other.specimenLifeFormPK != null) ||
                (this.specimenLifeFormPK != null &&
                !this.specimenLifeFormPK.equals(other.specimenLifeFormPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.SpecimenLifeForm " +
                "[specimenLifeFormPK=" + specimenLifeFormPK + "]";
    }

}
