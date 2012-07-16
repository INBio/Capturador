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

package org.inbio.ara.persistence.gathering;

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
@Table(name = "extraction_type")
public class ExtractionType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="extraction_type")
	@SequenceGenerator(name="extraction_type", sequenceName="extraction_type_seq")
    @Basic(optional = false)
    @Column(name = "extraction_type_id")
    private Long extractionTypeId;

    public ExtractionType() {
    }

    public ExtractionType(Long extractionTypeId) {
        this.extractionTypeId = extractionTypeId;
    }

    public ExtractionType(Long extractionTypeId, String name, String createdBy,
            Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.setId(extractionTypeId);
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getExtractionTypeId() {
        return extractionTypeId;
    }

    public void setExtractionTypeId(Long extractionTypeId) {
        this.extractionTypeId = extractionTypeId;
    }

   @Override
    public Long getId() {
       return extractionTypeId;
    }

    @Override
    public void setId(Long id) {
        this.extractionTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.EXTRACTION_TYPE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (extractionTypeId != null ? extractionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExtractionType)) {
            return false;
        }
        ExtractionType other = (ExtractionType) object;
        if ((this.extractionTypeId == null && other.extractionTypeId != null) || (this.extractionTypeId != null && !this.extractionTypeId.equals(other.extractionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.ExtractionType[extractionTypeId=" + extractionTypeId + "]";
    }

}
