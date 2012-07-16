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
import org.inbio.ara.persistence.reports.DwcElement;

/**
 *
 * @author esmata
 */
public class DwcElementDTOFactory {

    public DwcElementDTO createDTO(DwcElement entity) {
        if(entity==null){
            return null;
        }
        DwcElementDTO result = new DwcElementDTO();
        result.setElementCategoryId(entity.getElementCategoryId().getCategoryId());
        result.setElementCategoryName(entity.getElementCategoryId().getCategoryName());
        result.setElementId(entity.getElementId());
        result.setElementKeyword(entity.getElementKeyword());
        result.setElementName(entity.getElementName());
        result.setElementRequired(entity.getElementRequired());
        return result;
    }

	public List<DwcElementDTO> createDTOList(List<DwcElement> entitiesList) {
		if(entitiesList==null)
			return null;
		List<DwcElementDTO> dtoList = new ArrayList<DwcElementDTO>();
		for (DwcElement entity: entitiesList)
			dtoList.add((DwcElementDTO) createDTO(entity));
		return dtoList;
	}
    
}
