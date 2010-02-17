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

package org.inbio.ara.dto.inventory;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author esmata
 */
public class GatheringObservationDetailDTO implements Serializable{

    private Long gatheringObservationDetailId;
    private Long gatheringObservationDetailPersonId;
    private String gatheringObservationDetailPersonName;
    private String gatheringObservationDetailNumber;
    private Long collectionId;
    private Long gatheringObservationId;
    private Long morphologicalDescriptionId;

    private String morphologicalContents;
    private Calendar descriptionDate;
    private Long descriptorId;

    //Para propositos de GUI (Listado)
    private boolean selected;

    /* Constructor */
    public GatheringObservationDetailDTO(){
    }

    /**
     * @return the gatheringObservationDetailId
     */
    public Long getGatheringObservationDetailId() {
        return gatheringObservationDetailId;
    }

    /**
     * @param gatheringObservationDetailId the gatheringObservationDetailId to set
     */
    public void setGatheringObservationDetailId(Long gatheringObservationDetailId) {
        this.gatheringObservationDetailId = gatheringObservationDetailId;
    }

    /**
     * @return the gatheringObservationDetailPersonId
     */
    public Long getGatheringObservationDetailPersonId() {
        return gatheringObservationDetailPersonId;
    }

    /**
     * @param gatheringObservationDetailPersonId the gatheringObservationDetailPersonId to set
     */
    public void setGatheringObservationDetailPersonId(Long gatheringObservationDetailPersonId) {
        this.gatheringObservationDetailPersonId = gatheringObservationDetailPersonId;
    }

    /**
     * @return the gatheringObservationDetailNumber
     */
    public String getGatheringObservationDetailNumber() {
        return gatheringObservationDetailNumber;
    }

    /**
     * @param gatheringObservationDetailNumber the gatheringObservationDetailNumber to set
     */
    public void setGatheringObservationDetailNumber(String gatheringObservationDetailNumber) {
        this.gatheringObservationDetailNumber = gatheringObservationDetailNumber;
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
     * @return the gatheringObservationId
     */
    public Long getGatheringObservationId() {
        return gatheringObservationId;
    }

    /**
     * @param gatheringObservationId the gatheringObservationId to set
     */
    public void setGatheringObservationId(Long gatheringObservationId) {
        this.gatheringObservationId = gatheringObservationId;
    }

    /**
     * @return the morphologicalDescriptionId
     */
    public Long getMorphologicalDescriptionId() {
        return morphologicalDescriptionId;
    }

    /**
     * @param morphologicalDescriptionId the morphologicalDescriptionId to set
     */
    public void setMorphologicalDescriptionId(Long morphologicalDescriptionId) {
        this.morphologicalDescriptionId = morphologicalDescriptionId;
    }

    /**
     * @return the morphologicalContents
     */
    public String getMorphologicalContents() {
        return morphologicalContents;
    }

    /**
     * @param morphologicalContents the morphologicalContents to set
     */
    public void setMorphologicalContents(String morphologicalContents) {
        this.morphologicalContents = morphologicalContents;
    }

    /**
     * @return the descriptionDate
     */
    public Calendar getDescriptionDate() {
        return descriptionDate;
    }

    /**
     * @param descriptionDate the descriptionDate to set
     */
    public void setDescriptionDate(Calendar descriptionDate) {
        this.descriptionDate = descriptionDate;
    }

    /**
     * @return the descriptorId
     */
    public Long getDescriptorId() {
        return descriptorId;
    }

    /**
     * @param descriptorId the descriptorId to set
     */
    public void setDescriptorId(Long descriptorId) {
        this.descriptorId = descriptorId;
    }

    /**
     * @return the gatheringObservationDetailPersonName
     */
    public String getGatheringObservationDetailPersonName() {
        return gatheringObservationDetailPersonName;
    }

    /**
     * @param gatheringObservationDetailPersonName the gatheringObservationDetailPersonName to set
     */
    public void setGatheringObservationDetailPersonName(String gatheringObservationDetailPersonName) {
        this.gatheringObservationDetailPersonName = gatheringObservationDetailPersonName;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
