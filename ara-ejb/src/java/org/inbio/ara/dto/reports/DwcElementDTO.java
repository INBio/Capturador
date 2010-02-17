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

/**
 *
 * @author esmata
 */
public class DwcElementDTO {

    private Long elementId;
    private String elementName;
    private String elementKeyword;
    private String elementRequired;
    private Long elementCategoryId;
    private String elementCategoryName;

    public DwcElementDTO(){}

    /**
     * @return the elementId
     */
    public Long getElementId() {
        return elementId;
    }

    /**
     * @param elementId the elementId to set
     */
    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    /**
     * @return the elementName
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * @param elementName the elementName to set
     */
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    /**
     * @return the elementKeyword
     */
    public String getElementKeyword() {
        return elementKeyword;
    }

    /**
     * @param elementKeyword the elementKeyword to set
     */
    public void setElementKeyword(String elementKeyword) {
        this.elementKeyword = elementKeyword;
    }

    /**
     * @return the elementRequired
     */
    public String getElementRequired() {
        return elementRequired;
    }

    /**
     * @param elementRequired the elementRequired to set
     */
    public void setElementRequired(String elementRequired) {
        this.elementRequired = elementRequired;
    }

    /**
     * @return the elementCategoryId
     */
    public Long getElementCategoryId() {
        return elementCategoryId;
    }

    /**
     * @param elementCategoryId the elementCategoryId to set
     */
    public void setElementCategoryId(Long elementCategoryId) {
        this.elementCategoryId = elementCategoryId;
    }

    /**
     * @return the elementCategoryNAme
     */
    public String getElementCategoryName() {
        return elementCategoryName;
    }

    /**
     * @param elementCategoryNAme the elementCategoryNAme to set
     */
    public void setElementCategoryName(String elementCategoryNAme) {
        this.elementCategoryName = elementCategoryNAme;
    }

}
