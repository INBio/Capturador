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
@Table(name = "substrate")
public class Substrate extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="substrate")
	@SequenceGenerator(name="substrate", sequenceName="substrate_seq")
    @Basic(optional = false)
    @Column(name = "substrate_id")
    private Long substrateId;

    public Substrate() {
    }

    public Substrate(Long substrateId) {
        this.substrateId = substrateId;
    }

    public Substrate(Long substrateId, String name, String createdBy,
            Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.setId(substrateId);
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSubstrateId() {
        return substrateId;
    }

    public void setSubstrateId(Long substrateId) {
        this.substrateId = substrateId;
    }

   @Override
    public Long getId() {
       return substrateId;
    }

    @Override
    public void setId(Long id) {
        this.substrateId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.SUBSTRATE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (substrateId != null ? substrateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Substrate)) {
            return false;
        }
        Substrate other = (Substrate) object;
        if ((this.substrateId == null && other.substrateId != null) || (this.substrateId != null && !this.substrateId.equals(other.substrateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.Substrate[substrateId=" + substrateId + "]";
    }

}
