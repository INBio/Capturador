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
package org.inbio.ara.persistence.taxonomy;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "interaction_type")

public class InteractionType extends LogGenericEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "interaction_type_id")
    private Long interactionTypeId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public InteractionType() {
    }

    public InteractionType(Long interactionTypeId) {
        this.interactionTypeId = interactionTypeId;
    }

    public InteractionType(Long interactionTypeId, String name) {
        this.interactionTypeId = interactionTypeId;
        this.name = name;
    }

    public Long getInteractionTypeId() {
        return interactionTypeId;
    }

    public void setInteractionTypeId(Long interactionTypeId) {
        this.interactionTypeId = interactionTypeId;
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
        hash += (interactionTypeId != null ? interactionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InteractionType)) {
            return false;
        }
        InteractionType other = (InteractionType) object;
        if ((this.interactionTypeId == null && other.interactionTypeId != null) || (this.interactionTypeId != null && !this.interactionTypeId.equals(other.interactionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.InteractionType[interactionTypeId=" + interactionTypeId + "]";
    }

}
