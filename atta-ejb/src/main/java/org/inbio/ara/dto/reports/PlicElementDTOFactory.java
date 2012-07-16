/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.dto.reports;

import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.persistence.reports.PlicElement;

/**
 *
 * @author esmata
 */
public class PlicElementDTOFactory {

    public PlicElementDTO createDTO(PlicElement entity) {
        if(entity==null){
            return null;
        }
        PlicElementDTO result = new PlicElementDTO();
        result.setElementId(entity.getElementId());
        result.setElementKeyword(entity.getElementKeyword());
        result.setElementName(entity.getElementName());
        result.setElementRequired(entity.getElementRequired());
        return result;
    }

	public List<PlicElementDTO> createDTOList(List<PlicElement> entitiesList) {
		if(entitiesList==null)
			return null;
		List<PlicElementDTO> dtoList = new ArrayList<PlicElementDTO>();
		for (PlicElement entity: entitiesList)
			dtoList.add((PlicElementDTO) createDTO(entity));
		return dtoList;
	}

}
