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

package org.inbio.ara.persistence.indicator;


import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "dublin_core_entity")

public class DublinCoreEntity extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy=GenerationType.AUTO, generator="dublin_core_entity")
    @SequenceGenerator(name="dublin_core_entity", sequenceName="dublin_core_entity_seq")
    @Basic(optional = false)
    @Column(name = "dublin_core_entity_id")
    private Long dublinCoreEntityId;

    @Column(name = "institution_id")
    private Long institutionId;

    @Column(name = "person_id")
    private Long personId;

    
    @Column(name = "dublin_core_id")
    private Long dublinCoreId;

    @Column(name = "dublin_core_entity_type_id")
    private Long dublinCoreEntityTypeId;

    public DublinCoreEntity() {
    }

    public DublinCoreEntity(Long dublinCoreEntityId, Long dublinCoreId, Long institutionId, Long personId , Long dublinCoreEntityTypeId,
            String createdBy,Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.dublinCoreEntityId = dublinCoreEntityId;
        this.dublinCoreId = dublinCoreId;
        this.institutionId = institutionId;
        this.personId = personId;
        this.dublinCoreEntityTypeId = dublinCoreEntityTypeId;
        
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getDublinCoreEntityId() {
        return dublinCoreEntityId;
    }

    public void setDublinCoreEntityId(Long dublinCoreEntityId) {
        this.dublinCoreEntityId = dublinCoreEntityId;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getDublinCoreId() {
        return dublinCoreId;
    }

    public void setDublinCoreId(Long dublinCoreId) {
        this.dublinCoreId = dublinCoreId;
    }

    public Long getDublinCoreEntityTypeId() {
        return dublinCoreEntityTypeId;
    }

    public void setDublinCoreEntityTypeId(Long dublinCoreEntityTypeId) {
        this.dublinCoreEntityTypeId = dublinCoreEntityTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dublinCoreEntityId != null ? dublinCoreEntityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DublinCoreEntity)) {
            return false;
        }
        DublinCoreEntity other = (DublinCoreEntity) object;
        if ((this.dublinCoreEntityId == null && other.dublinCoreEntityId != null) || (this.dublinCoreEntityId != null && !this.dublinCoreEntityId.equals(other.dublinCoreEntityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.indicator.DublinCoreEntity[dublinCoreEntityId=" + dublinCoreEntityId + "]";
    }

}
