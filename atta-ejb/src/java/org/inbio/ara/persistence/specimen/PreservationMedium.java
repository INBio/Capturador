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
@Table(name = "preservation_medium")
public class PreservationMedium extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="preservation_medium")
	@SequenceGenerator(name="preservation_medium", sequenceName="preservation_medium_seq")
    @Basic(optional = false)
    @Column(name = "preservation_medium_id")
    private Long preservationMediumId;

    public PreservationMedium() {
    }

    public PreservationMedium(Long preservationMediumId) {
        this.preservationMediumId = preservationMediumId;
    }

    public PreservationMedium(Long preservationMediumId, String name, 
            String createdBy, Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.setId(preservationMediumId);
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getPreservationMediumId() {
        return preservationMediumId;
    }

    public void setPreservationMediumId(Long preservationMediumId) {
        this.preservationMediumId = preservationMediumId;
    }

    @Override
    public Long getId() {
        return preservationMediumId;
    }

    @Override
    public void setId(Long id) {
        this.preservationMediumId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.PRESERVATION_MEDIUM;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preservationMediumId != null ? preservationMediumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreservationMedium)) {
            return false;
        }
        PreservationMedium other = (PreservationMedium) object;
        if ((this.preservationMediumId == null && other.preservationMediumId != null) || (this.preservationMediumId != null && !this.preservationMediumId.equals(other.preservationMediumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.PreservationMedium[preservationMediumId=" + preservationMediumId + "]";
    }

}
