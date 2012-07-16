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

import java.io.Serializable;
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
 * @author esmata
 */
@Entity
@Table(name = "exposition")
public class Exposition extends SelectionListGenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="exposition")
	@SequenceGenerator(name="exposition", sequenceName="exposition_seq")
    @Basic(optional = false)
    @Column(name = "exposition_id")
    private Long expositionId;

    public Exposition() {
    }

    public Exposition(Long expositionId) {
        this.expositionId = expositionId;
    }

    public Exposition(Long expositionId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.setId(expositionId);
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    @Override
    public Long getId() {
        return expositionId;
    }

    @Override
    public void setId(Long expositionId) {
        this.expositionId = expositionId;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.EXPOSITION;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expositionId != null ? expositionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exposition)) {
            return false;
        }
        Exposition other = (Exposition) object;
        if ((this.expositionId == null && other.expositionId != null) || (this.expositionId != null && !this.expositionId.equals(other.expositionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gathering.Exposition[expositionId=" + expositionId + "]";
    }
}
