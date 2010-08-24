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

package org.inbio.ara.dto.germplasm;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author dasolano
 */
public class PassportNomenclaturalGroupDTO extends GenericDTO {

    private Long passportId;

    private Long nomenclaturalGroupId;

    private String nomenclaturalGroupName;


    /**
     * @return the passportId
     */
    public Long getPassportId() {
        return passportId;
    }

    /**
     * @param passportId the passportId to set
     */
    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    /**
     * @return the nomenclaturalGroupId
     */
    public Long getNomenclaturalGroupId() {
        return nomenclaturalGroupId;
    }

    /**
     * @param nomenclaturalGroupId the nomenclaturalGroupId to set
     */
    public void setNomenclaturalGroupId(Long nomenclaturalGroupId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
    }

    /**
     * @return the nomenclaturalGroupName
     */
    public String getNomenclaturalGroupName() {
        return nomenclaturalGroupName;
    }

    /**
     * @param nomenclaturalGroupName the nomenclaturalGroupName to set
     */
    public void setNomenclaturalGroupName(String nomenclaturalGroupName) {
        this.nomenclaturalGroupName = nomenclaturalGroupName;
    }

}