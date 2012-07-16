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
@Table(name = "identification_status")
public class IdentificationStatus extends GenericEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "identification_status_id")
	private Long identificationStatusId;
	@Basic(optional = false)
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	/*
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificationStatusId", fetch = FetchType.LAZY)
        private Set<Identification> identificationCollection;
	*/

	public IdentificationStatus() {
	}

	public IdentificationStatus(Long identificationStatusId) {
		this.identificationStatusId = identificationStatusId;
	}

	public IdentificationStatus(Long identificationStatusId, String name, 
                String createdBy, Calendar creationDate,
                String lastModificationBy, Calendar lastModificationDate) {
		this.identificationStatusId = identificationStatusId;
		this.name = name;
		this.setCreatedBy(createdBy);
		this.setCreationDate(creationDate);
		this.setLastModificationBy(lastModificationBy);
		this.setLastModificationDate(lastModificationDate);
	}

	public Long getIdentificationStatusId() {
		return identificationStatusId;
	}

	public void setIdentificationStatusId(Long identificationStatusId) {
		this.identificationStatusId = identificationStatusId;
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
		hash += (identificationStatusId != null ? identificationStatusId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof IdentificationStatus)) {
			return false;
		}
		IdentificationStatus other = (IdentificationStatus) object;
		if ((this.identificationStatusId == null && other.identificationStatusId != null) || (this.identificationStatusId != null && !this.identificationStatusId.equals(other.identificationStatusId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.inbio.ara.persistence.taxonomy.IdentificationStatus[identificationStatusId=" + identificationStatusId + "]";
	}

}
