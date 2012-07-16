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

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author jgutierrez
 */
@Entity
@Table(name = "specimen_type")
public class SpecimenType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="specimen_type")
	@SequenceGenerator(name="specimen_type", sequenceName="specimen_type_seq")
    @Basic(optional = false)
    @Column(name = "specimen_type_id")
    private Long specimenTypeId;

    public SpecimenType() {
    }

    public SpecimenType(Long specimenTypeId) {
        this.specimenTypeId = specimenTypeId;
    }

    public SpecimenType(Long specimenTypeId, String name, String createdBy, 
            Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.specimenTypeId = specimenTypeId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSpecimenTypeId() {
        return specimenTypeId;
    }

    public void setSpecimenTypeId(Long specimenTypeId) {
        this.specimenTypeId = specimenTypeId;
    }

    @Override
    public Long getId() {
        return specimenTypeId;
    }

    @Override
    public void setId(Long id) {
        this.specimenTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.SPECIMEN_TYPE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specimenTypeId != null ? specimenTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecimenType)) {
            return false;
        }
        SpecimenType other = (SpecimenType) object;
        if ((this.specimenTypeId == null && other.specimenTypeId != null) || (this.specimenTypeId != null && !this.specimenTypeId.equals(other.specimenTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.SpecimenType[specimenTypeId=" + specimenTypeId + "]";
    }

}
