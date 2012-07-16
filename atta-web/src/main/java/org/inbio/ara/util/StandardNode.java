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

package org.inbio.ara.util;

import java.io.Serializable;
import org.inbio.ara.dto.reports.DwcCategoryDTO;

/**
 *
 * @author esmata
 */
public class StandardNode implements Serializable {

    //Variables
    private Long checkBoxNameId;
    private String keyword;
    private String name;
    private String selected;
    private DwcCategoryDTO category;

    //Empty constructor
    public StandardNode(){
        this.checkBoxNameId = new Long(0);
        this.keyword = null;
        this.selected = "0";
        this.category = null;
        this.name = null;
    }

    //Constructor with parameters
    public StandardNode(Long checkBoxNameId,String keyword,String selected,DwcCategoryDTO category, String name){
        this.checkBoxNameId = checkBoxNameId;
        this.keyword = keyword;
        this.selected = selected;
        this.category = category;
        this.name = name;
    }


    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the selected
     */
    public String getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(String selected) {
        this.selected = selected;
    }

    /**
     * @return the category
     */
    public DwcCategoryDTO getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(DwcCategoryDTO category) {
        this.category = category;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the checkBoxNameId
     */
    public Long getCheckBoxNameId() {
        return checkBoxNameId;
    }

    /**
     * @param checkBoxNameId the checkBoxNameId to set
     */
    public void setCheckBoxNameId(Long checkBoxNameId) {
        this.checkBoxNameId = checkBoxNameId;
    }

}
