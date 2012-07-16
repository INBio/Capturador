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
 * @author herson
 */
public class TaxonDescriptionElementDTO  extends GenericDTO {
    public TaxonDescriptionElementDTO() {}

    private Long taxonDescriptionElementId;
    private String name;
    private String description;
    private String tableName;
    private Long taxonDescriptionCategoryId;
    private Long taxonDescriptionDatatypeId;
    private String mainFieldName;
    private String keyField;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getTaxonDescriptionCategoryId() {
        return taxonDescriptionCategoryId;
    }

    public void setTaxonDescriptionCategoryId(Long taxonDescriptionCategoryId) {
        this.taxonDescriptionCategoryId = taxonDescriptionCategoryId;
    }

    public Long getTaxonDescriptionDatatypeId() {
        return taxonDescriptionDatatypeId;
    }

    public void setTaxonDescriptionDatatypeId(Long taxonDescriptionDatatypeId) {
        this.taxonDescriptionDatatypeId = taxonDescriptionDatatypeId;
    }

    public Long getTaxonDescriptionElementId() {
        return taxonDescriptionElementId;
    }

    public void setTaxonDescriptionElementId(Long taxonDescriptionElementId) {
        this.taxonDescriptionElementId = taxonDescriptionElementId;
    }

    /**
     * @return the mainFieldName
     */
    public String getMainFieldName() {
        return mainFieldName;
    }

    /**
     * @param mainFieldName the mainFieldName to set
     */
    public void setMainFieldName(String mainFieldName) {
        this.mainFieldName = mainFieldName;
    }

    /**
     * @return the keyField
     */
    public String getKeyField() {
        return keyField;
    }

    /**
     * @param keyField the keyField to set
     */
    public void setKeyField(String keyField) {
        this.keyField = keyField;
    }

    
}
