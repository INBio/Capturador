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
package org.inbio.ara.dto.statistics;

import java.io.Serializable;
import org.inbio.ara.persistence.statistics.SystemStatisticsEntinty;

/**
 *
 * @author asanabria
 */
public class SystemStatisticsDTO implements Serializable  {

	private SystemStatisticsEntinty statisticId;
	private String					name;
	private long					value;

	public SystemStatisticsDTO(){

	}

	public SystemStatisticsEntinty getStatistic() {
		return statisticId;
	}

	public void setStatistic(SystemStatisticsEntinty statistic) {
		this.statisticId = statistic;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
