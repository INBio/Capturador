/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Naciona de Biodiversidad)
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

import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "reference_type")

public class ReferenceType extends LogGenericEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "reference_type_id")
    private Long referenceTypeId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenceTypeId", fetch = FetchType.LAZY)
    private List<Reference> referenceCollection;

    public ReferenceType() {
    }

    public ReferenceType(Long referenceTypeId) {
        this.referenceTypeId = referenceTypeId;
    }

    public ReferenceType(Long referenceTypeId, String name, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.referenceTypeId = referenceTypeId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationDate(lastModificationDate);
        this.setLastModificationBy(lastModificationBy);
    }

    public Long getReferenceTypeId() {
        return referenceTypeId;
    }

    public void setReferenceTypeId(Long referenceTypeId) {
        this.referenceTypeId = referenceTypeId;
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

    public List<Reference> getReferenceCollection() {
        return referenceCollection;
    }

    public void setReferenceCollection(List<Reference> referenceCollection) {
        this.referenceCollection = referenceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referenceTypeId != null ? referenceTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReferenceType)) {
            return false;
        }
        ReferenceType other = (ReferenceType) object;
        if ((this.referenceTypeId == null && other.referenceTypeId != null) || (this.referenceTypeId != null && !this.referenceTypeId.equals(other.referenceTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.ReferenceType[referenceTypeId=" + referenceTypeId + "]";
    }

}
