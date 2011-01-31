/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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

package org.inbio.ara.persistence.identification;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author asanabria
 */
@Entity
@Table(name = "identification_type")
public class IdentificationType extends GenericEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "identification_type_id")
	private Long identificationTypeId;
	@Basic(optional = false)
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;

	/*
		@OneToMany(mappedBy = "identificationTypeId", fetch = FetchType.LAZY)
		private Set<Identification> identificationCollection;
	*/
	public IdentificationType() {
	}

	public IdentificationType(Long identificationTypeId) {
		this.identificationTypeId = identificationTypeId;
	}

	public IdentificationType(Long identificationTypeId, String name, 
                String createdBy, Calendar creationDate,
                String lastModificationBy, Calendar lastModificationDate) {
		this.identificationTypeId = identificationTypeId;
		this.name = name;
		this.setCreatedBy(createdBy);
		this.setCreationDate(creationDate);
		this.setLastModificationBy(lastModificationBy);
		this.setLastModificationDate(lastModificationDate);
	}

	public Long getIdentificationTypeId() {
		return identificationTypeId;
	}

	public void setIdentificationTypeId(Long identificationTypeId) {
		this.identificationTypeId = identificationTypeId;
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
		hash += (identificationTypeId != null ? identificationTypeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof IdentificationType)) {
			return false;
		}
		IdentificationType other = (IdentificationType) object;
		if ((this.identificationTypeId == null && other.identificationTypeId != null) || (this.identificationTypeId != null && !this.identificationTypeId.equals(other.identificationTypeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.inbio.ara.persistence.taxonomy.IdentificationType[identificationTypeId=" + identificationTypeId + "]";
	}

}
