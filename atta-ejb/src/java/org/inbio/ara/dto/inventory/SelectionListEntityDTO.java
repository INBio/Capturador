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
 * @author jgutierrez
 */
public class SelectionListEntityDTO  implements Serializable {

    /** Id of the selection list on the SelectionListEntity ENUM */
    private Long selectionListEntityId;
    /** codeName of the SLE as code that sholud be resolved in a properties file */
    private String codeName;



    public SelectionListEntityDTO(Long selectionListEntityId, String codeName) {
        this.selectionListEntityId = selectionListEntityId;
        this.codeName = codeName;
    }

    /**
     * @return the selectionListEntityId
     */
    public Long getSelectionListEntityId() {
        return selectionListEntityId;
    }

    /**
     * @param selectionListEntityId the selectionListEntityId to set
     */
    public void setSelectionListEntityId(Long selectionListEntityId) {
        this.selectionListEntityId = selectionListEntityId;
    }

    /**
     * @return the codeName
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * @param codeName the codeName to set
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }



}
