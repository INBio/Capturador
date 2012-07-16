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
import org.inbio.ara.persistence.reports.DwcCategory;

/**
 *
 * @author esmata
 */
public class DwcCategoryDTOFactory {

    public DwcCategoryDTO createDTO(DwcCategory entity) {
        if(entity==null){
            return null;
        }
        DwcCategoryDTO result = new DwcCategoryDTO();
        result.setCategoryId(entity.getCategoryId());
        result.setCategoryKeyword(entity.getCategoryKeyword());
        result.setCategoryName(entity.getCategoryName());
        return result;
    }

	public List<DwcCategoryDTO> createDTOList(List<DwcCategory> entitiesList) {
		if(entitiesList==null)
			return null;
		List<DwcCategoryDTO> dtoList = new ArrayList<DwcCategoryDTO>();
		for (DwcCategory entity: entitiesList)
			dtoList.add((DwcCategoryDTO) createDTO(entity));
		return dtoList;
	}

}
