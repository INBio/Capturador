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

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author esmata
 */
public class LanguageDTO extends GenericDTO{

    private Long languageId;
    private Long concepId;
    private String concepName;

    public LanguageDTO(){}

    /**
     * @return the languageId
     */
    public Long getLanguageId() {
        return languageId;
    }

    /**
     * @param languageId the languageId to set
     */
    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    /**
     * @return the concepId
     */
    public Long getConcepId() {
        return concepId;
    }

    /**
     * @param concepId the concepId to set
     */
    public void setConcepId(Long concepId) {
        this.concepId = concepId;
    }

    /**
     * @return the concepName
     */
    public String getConcepName() {
        return concepName;
    }

    /**
     * @param concepName the concepName to set
     */
    public void setConcepName(String concepName) {
        this.concepName = concepName;
    }

}
