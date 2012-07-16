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
package org.inbio.ara.dto.inventory;

import java.io.Serializable;

/**
 *
 * @author asanabria
 */
public class IdentificationStatusDTO  implements Serializable {

	private Long IdentificationStatusKey;
	private String name;
	private String description;


	public IdentificationStatusDTO() {
	}

	public IdentificationStatusDTO(Long IdentificationStatusKey, String name, String description) {
		this.IdentificationStatusKey = IdentificationStatusKey;
		this.name = name;
		this.description = description;
	}

	public Long getIdentificationStatusKey() {
		return IdentificationStatusKey;
	}

	public void setIdentificationStatusKey(Long IdentificationStatusKey) {
		this.IdentificationStatusKey = IdentificationStatusKey;
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
		final IdentificationStatusDTO other = (IdentificationStatusDTO) obj;
		if (this.IdentificationStatusKey != other.IdentificationStatusKey && (this.IdentificationStatusKey == null || !this.IdentificationStatusKey.equals(other.IdentificationStatusKey))) {
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
		int hash = 3;
		hash = 79 * hash + (this.IdentificationStatusKey != null ? this.IdentificationStatusKey.hashCode() : 0);
		hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
		hash = 79 * hash + (this.description != null ? this.description.hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {

		 return "IdentificationStatusDTO" +
                "\n\tIdentification Status Name = " + IdentificationStatusKey +
                "\n\tName = " + name +
                "\n\tDescription = " + description;
	}

	
}
