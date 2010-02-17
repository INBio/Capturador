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

package org.inbio.ara.dto.security;

import org.inbio.ara.dto.GenericDTO;
import java.io.Serializable;

/**
 *
 * @author esmata
 */
public class NomenclaturalGroupDTO extends GenericDTO implements Serializable{


    //for GUI use
    private boolean selected;

    private Long nomenclaturalGroupId;
    private String name;
    private String description;
    private Long collectionId;
    private String temporality;
    private Character commonName;
    private Long certificatorPersonId;
    private String notes;


    public NomenclaturalGroupDTO(){
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the collectionId
     */
    public Long getCollectionId() {
        return collectionId;
    }

    /**
     * @param collectionId the collectionId to set
     */
    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * @return the temporality
     */
    public String getTemporality() {
        return temporality;
    }

    /**
     * @param temporality the temporality to set
     */
    public void setTemporality(String temporality) {
        this.temporality = temporality;
    }

    /**
     * @return the commonName
     */
    public Character getCommonName() {
        return commonName;
    }

    /**
     * @param commonName the commonName to set
     */
    public void setCommonName(Character commonName) {
        this.commonName = commonName;
    }

    /**
     * @return the certificatorPersonId
     */
    public Long getCertificatorPersonId() {
        return certificatorPersonId;
    }

    /**
     * @param certificatorPersonId the certificatorPersonId to set
     */
    public void setCertificatorPersonId(Long certificatorPersonId) {
        this.certificatorPersonId = certificatorPersonId;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return selected value
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected value to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
