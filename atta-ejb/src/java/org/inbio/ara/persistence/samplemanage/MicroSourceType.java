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
@Table(name = "micro_source_type")
public class MicroSourceType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="micro_source_type")
    @SequenceGenerator(name="micro_source_type", sequenceName="micro_source_type_seq")
    @Basic(optional = false)
    @Column(name = "micro_source_type_id")
    private Long microSourceTypeId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    public MicroSourceType() {
    }

    public MicroSourceType(Long microSourceTypeId) {
        this.microSourceTypeId = microSourceTypeId;
    }

    public MicroSourceType(Long microSourceTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.microSourceTypeId = microSourceTypeId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getMicroSourceTypeId() {
        return microSourceTypeId;
    }

    public void setMicroSourceTypeId(Long microSourceTypeId) {
        this.microSourceTypeId = microSourceTypeId;
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
        hash += (microSourceTypeId != null ? microSourceTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MicroSourceType)) {
            return false;
        }
        MicroSourceType other = (MicroSourceType) object;
        if ((this.microSourceTypeId == null && other.microSourceTypeId != null) || (this.microSourceTypeId != null && !this.microSourceTypeId.equals(other.microSourceTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.MicroSourceType[microSourceTypeId=" + microSourceTypeId + "]";
    }

    @Override
    public Long getId() {
        return this.microSourceTypeId;
    }

    @Override
    public void setId(Long id) {
        this.microSourceTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.MICRO_SOURCE_TYPE;
    }

}
