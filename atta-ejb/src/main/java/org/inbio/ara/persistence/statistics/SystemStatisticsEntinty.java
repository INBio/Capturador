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

package org.inbio.ara.persistence.statistics;

/**
 *
 * @author asanabria
 */
public enum SystemStatisticsEntinty {

	SPECIMENS_BY_COLLECTION_COUNT(1, "specimenByCollectionCount"),
	SPECIES_BY_COLLECTION_COUNT(2, "speciesByCollectionCount");

	private int id;
	private String nameI18NKey;

	private SystemStatisticsEntinty(int aStatisticId, String aNameI18NKey) {
		id = aStatisticId;
		nameI18NKey = aNameI18NKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameI18NKey() {
		return nameI18NKey;
	}

	public void setNameI18NKey(String nameI18NKey) {
		this.nameI18NKey = nameI18NKey;
	}
}
