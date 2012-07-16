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
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "component_part")

public class ComponentPart extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="component_part")
    @SequenceGenerator(name="component_part", sequenceName="component_part_seq")
    @Basic(optional = false)
    @Column(name = "component_part_id")
    private Long componentPartId;


    public ComponentPart() {
    }

    public ComponentPart(Long componentPartId) {
        this.componentPartId = componentPartId;
    }

    public ComponentPart(Long componentPartId, String name, String description, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.componentPartId = componentPartId;
        this.setName(name);
        this.setDescription(description);
        
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getComponentPartId() {
        return componentPartId;
    }

    public void setComponentPartId(Long componentPartId) {
        this.componentPartId = componentPartId;
    }

      

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getComponentPartId() != null ? getComponentPartId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComponentPart)) {
            return false;
        }
        ComponentPart other = (ComponentPart) object;
        if ((this.getComponentPartId() == null && other.getComponentPartId() != null) || (this.getComponentPartId() != null && !this.componentPartId.equals(other.componentPartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.indicator.ComponentPart[componentPartId=" + getComponentPartId() + "]";
    }

    @Override
    public Long getId() {
        return this.getComponentPartId();
    }

    @Override
    public void setId(Long id) {
        this.componentPartId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.COMPONENT_PART;
    }

}
