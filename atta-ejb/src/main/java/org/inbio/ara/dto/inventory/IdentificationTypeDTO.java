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

package org.inbio.ara.dto.inventory;

import java.io.Serializable;


/**
 *
 * @author asanabria
 */
public class IdentificationTypeDTO implements Serializable{

	private Long IdentificationTypeKey;
	private String name;
	private String description;

	public IdentificationTypeDTO() {
	}

	public IdentificationTypeDTO(Long IdentificationTypeKey, String name, String description) {
		this.IdentificationTypeKey = IdentificationTypeKey;
		this.name = name;
		this.description = description;
	}

	public Long getIdentificationTypeKey() {
		return IdentificationTypeKey;
	}

	public void setIdentificationTypeKey(Long IdentificationTypeKey) {
		this.IdentificationTypeKey = IdentificationTypeKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final IdentificationTypeDTO other = (IdentificationTypeDTO) obj;
		if (this.IdentificationTypeKey != other.IdentificationTypeKey && (this.IdentificationTypeKey == null || !this.IdentificationTypeKey.equals(other.IdentificationTypeKey))) {
			return false;
		}
		if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
			return false;
		}
		if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 43 * hash + (this.IdentificationTypeKey != null ? this.IdentificationTypeKey.hashCode() : 0);
		hash = 43 * hash + (this.name != null ? this.name.hashCode() : 0);
		hash = 43 * hash + (this.description != null ? this.description.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {

		return "IdentificationTypeDTO" +
                "\n\tIdentification Status Name = " + IdentificationTypeKey +
                "\n\tName = " + name +
                "\n\tDescription = " + description;
	}
}
