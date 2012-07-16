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

package org.inbio.ara.persistence.person;

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
 * @author asanabria
 * modified by esmata (2009.10.05)
 */
@Entity
@Table(name = "profile")
public class Profile extends LogGenericEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="Profile")
	@SequenceGenerator(name="Profile", sequenceName="profile_seq")
	@Basic(optional = false)
	@Column(name = "profile_id")
	private Long profileId;

	@Basic(optional = false)
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;
	

	public Profile() {
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

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (profileId != null ? profileId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Profile)) {
			return false;
		}
		Profile other = (Profile) object;
		if ((this.profileId == null && other.profileId != null) || (this.profileId != null && !this.profileId.equals(other.profileId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.inbio.ara.persistence.person.Profile[profileId=" + profileId + "]";
	}
}
