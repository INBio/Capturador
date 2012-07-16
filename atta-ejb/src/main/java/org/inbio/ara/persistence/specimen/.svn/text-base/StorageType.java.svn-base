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
@Table(name = "storage_type")
public class StorageType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="storage_type")
	@SequenceGenerator(name="storage_type", sequenceName="storage_type_seq")
    @Basic(optional = false)
    @Column(name = "storage_type_id")
    private Long storageTypeId;

    public StorageType() {
    }

    public StorageType(Long storageTypeId) {
        this.storageTypeId = storageTypeId;
    }

    public StorageType(Long storageTypeId, String name, String createdBy, 
            Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
       this.setId(storageTypeId);
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getStorageTypeId() {
        return storageTypeId;
    }

    public void setStorageTypeId(Long storageTypeId) {
        this.storageTypeId = storageTypeId;
    }

    @Override
    public Long getId() {
        return storageTypeId;
    }

    @Override
    public void setId(Long id) {
        this.storageTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.STORAGE_TYPE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storageTypeId != null ? storageTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StorageType)) {
            return false;
        }
        StorageType other = (StorageType) object;
        if ((this.storageTypeId == null && other.storageTypeId != null) || (this.storageTypeId != null && !this.storageTypeId.equals(other.storageTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.StorageType[storageTypeId=" + storageTypeId + "]";
    }

}
