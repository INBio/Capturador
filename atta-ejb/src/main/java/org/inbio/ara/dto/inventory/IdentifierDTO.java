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
import java.util.Calendar;

/**
 *
 * @author asanabria
 */
public class IdentifierDTO  implements Serializable {

	private Long identifierKey;
	private String identifierName;
	private Calendar initialTimeStamp;

	public IdentifierDTO() {
	}

	public IdentifierDTO(Long identifierKey) {
		this.identifierKey = identifierKey;
	}

	public IdentifierDTO(String identifierName) {
		this.identifierName = identifierName;
	}

	public IdentifierDTO(Long identifierKey, String identifierName) {
		this.identifierKey = identifierKey;
		this.identifierName = identifierName;
	}

	public Long getIdentifierKey() {
		return identifierKey;
	}

	public void setIdentifierKey(Long identifierKey) {
		this.identifierKey = identifierKey;
	}

	public String getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(String identifierName) {
		this.identifierName = identifierName;
	}

	public Calendar getInitialTimeStamp() {
		return initialTimeStamp;
	}

	public void setInitialTimeStamp(Calendar initialTimeStamp) {
		this.initialTimeStamp = initialTimeStamp;
	}

	@Override
	public String toString() {
		return "IdentifierDTO " +
		       "\n\tIdentifier id" + identifierKey +
		       "\n\tIdentifier Name " + identifierName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final IdentifierDTO other = (IdentifierDTO) obj;
		if (this.identifierKey != other.identifierKey && (this.identifierKey == null || !this.identifierKey.equals(other.identifierKey))) {
			return false;
		}
		if ((this.identifierName == null) ? (other.identifierName != null) : !this.identifierName.equals(other.identifierName)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}
}
