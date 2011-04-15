/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.persistence.samplemanage;

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
 * @author dasolano
 */
@Entity
@Table(name = "vertical_strata")
public class VerticalStrata extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="vertical_strata")
    @SequenceGenerator(name="vertical_strata", sequenceName="vertical_strata_seq")
    @Basic(optional = false)
    @Column(name = "vertical_strata_id")
    private Long verticalStrataId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    
    public VerticalStrata() {
    }

    public VerticalStrata(Long verticalStrataId) {
        this.verticalStrataId = verticalStrataId;
    }

    public VerticalStrata(Long verticalStrataId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.verticalStrataId = verticalStrataId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getVerticalStrataId() {
        return verticalStrataId;
    }

    public void setVerticalStrataId(Long verticalStrataId) {
        this.verticalStrataId = verticalStrataId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (verticalStrataId != null ? verticalStrataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VerticalStrata)) {
            return false;
        }
        VerticalStrata other = (VerticalStrata) object;
        if ((this.verticalStrataId == null && other.verticalStrataId != null) || (this.verticalStrataId != null && !this.verticalStrataId.equals(other.verticalStrataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.VerticalStrata[verticalStrataId=" + verticalStrataId + "]";
    }

    @Override
    public Long getId() {
        return this.verticalStrataId;
    }

    @Override
    public void setId(Long id) {
        this.verticalStrataId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.VERTICAL_STRATA;
    }

}
