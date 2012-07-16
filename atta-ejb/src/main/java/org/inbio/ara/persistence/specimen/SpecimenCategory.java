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
@Table(name = "specimen_category")
public class SpecimenCategory extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="specimen_category")
	@SequenceGenerator(name="specimen_category", sequenceName="specimen_category_seq")
    @Basic(optional = false)
    @Column(name = "specimen_category_id")
    private Long specimenCategoryId;

    public SpecimenCategory() {
    }

    public SpecimenCategory(Long specimenCategoryId) {
        this.specimenCategoryId = specimenCategoryId;
    }

    public SpecimenCategory(Long specimenCategoryId, String name, 
            String createdBy, Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.specimenCategoryId = specimenCategoryId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSpecimenCategoryId() {
        return specimenCategoryId;
    }

    public void setSpecimenCategoryId(Long specimenCategoryId) {
        this.specimenCategoryId = specimenCategoryId;
    }

      @Override
    public Long getId() {
        return specimenCategoryId;
    }

    @Override
    public void setId(Long specimenCategoryId) {
        this.specimenCategoryId = specimenCategoryId;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.SPECIMEN_CATEGORY;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specimenCategoryId != null ? specimenCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecimenCategory)) {
            return false;
        }
        SpecimenCategory other = (SpecimenCategory) object;
        if ((this.specimenCategoryId == null && other.specimenCategoryId != null) || (this.specimenCategoryId != null && !this.specimenCategoryId.equals(other.specimenCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.SpecimenCategory[specimenCategoryId=" + specimenCategoryId + "]";
    }

}
