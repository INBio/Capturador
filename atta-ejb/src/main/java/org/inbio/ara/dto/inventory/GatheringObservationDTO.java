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
import java.util.List;
import org.inbio.ara.dto.GenericDTO;
import org.inbio.ara.dto.agent.CollectionDTO;

/**
 *
 * @author mvargas
 */
public class GatheringObservationDTO extends GenericDTO implements Serializable {

    /**
    * Para ser mostrado en el list gathering
    **/
    private String responsibleName;
    private String coordinates;
    private String localityDescription; //Description of gathering.site
    private String provinceName;
    private String countryName;
    private Long gatheringObservationId; /* Also persisted */
    private Long countryId;
    private Long provinceId;

    /**
     * Para ser persistido al crear un nuevo gathering
     **/
    private Calendar initialDateTime;
    private Calendar finalDateTime;    
    private Long localityId;
    private Long responsibleId;
    private Long expositionId;
    private Long gradient;
    private Double minimumElevation;
    private Double maximumElevation;
    private Double maximumDepth;
    private Double minimumDepth;
    private String surroundingDescription;
    private String siteDescription; //Description from the gathering table
    private Long collectionId;
    private List<PersonDTO> colectorsList; /* Colectors list */
    private List<ProjectDTO> projectsList; /* Projects list */
    private List<CollectionDTO> collectionsList; /* Collection list */

    /* For Graphical Inteface purposes */
    private boolean selected;

    /**
     * For Quering purposes
     **/
    private Integer radio;
    private Double latitude;
    private Double longitude;    
    
    public GatheringObservationDTO() {
    }

    @Override
    public String toString() {

        return "GatheringDTO" +
                "\n\tGatheringObservation id = " + getGatheringObservationId() +
                "\n\tCountry id = " + getCountryId() +
                "\n\tCountry name = " + getCountryName() +
                "\n\tProvince id = " + getProvinceId() +
                "\n\tProvince name = " + getProvinceName() +
                "\n\tLocality description = " + getLocalityDescription() +
                "\n\tCoordinates = " + getCoordinates() +
                "\n\tMinimumElevation = " + getMinimumElevation() +
                "\n\tMaximumElevation = " + getMaximumElevation() +
                "\n\tResponsible Id = " + getResponsibleId() +
                "\n\tResponsible Name = " + getResponsibleName() +
                "\n\tInitialDateTime = " + getInitialDateTime() +
                "\n\tFinalDateTime = " + getFinalDateTime()
                ;
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
     * @return the countryId
     */
    public Long getCountryId() {
        return countryId;
    }

    /**
     * @param countryId the countryId to set
     */
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the provinceId
     */
    public Long getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId the provinceId to set
     */
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return the provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * @return the localityDescription
     */
    public String getLocalityDescription() {
        return localityDescription;
    }

    /**
     * @param localityDescription the localityDescription to set
     */
    public void setLocalityDescription(String localityDescription) {
        this.localityDescription = localityDescription;
    }

    /**
     * @return the coordinates
     */
    public String getCoordinates() {
        return coordinates;
    }

    /**
     * @param coordinates the coordinates to set
     */
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @return the responsibleId
     */
    public Long getResponsibleId() {
        return responsibleId;
    }

    /**
     * @param responsibleId the responsibleId to set
     */
    public void setResponsibleId(Long responsibleId) {
        this.responsibleId = responsibleId;
    }

    /**
     * @return the responsibleName
     */
    public String getResponsibleName() {
        return responsibleName;
    }

    /**
     * @param responsibleName the responsibleName to set
     */
    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    /**
     * @return the initialDateTime
     */
    public Calendar getInitialDateTime() {
        return initialDateTime;
    }

    /**
     * @param initialDateTime the initialDateTime to set
     */
    public void setInitialDateTime(Calendar initialDateTime) {
        this.initialDateTime = initialDateTime;
    }

    /**
     * @return the finalDateTime
     */
    public Calendar getFinalDateTime() {
        return finalDateTime;
    }

    /**
     * @param finalDateTime the finalDateTime to set
     */
    public void setFinalDateTime(Calendar finalDateTime) {
        this.finalDateTime = finalDateTime;
    }

    /**
     * @return the minimumElevation
     */
    public Double getMinimumElevation() {
        return minimumElevation;
    }

    /**
     * @param minimumElevation the minimumElevation to set
     */
    public void setMinimumElevation(Double minimumElevation) {
        this.minimumElevation = minimumElevation;
    }

    /**
     * @return the maximumElevation
     */
    public Double getMaximumElevation() {
        return maximumElevation;
    }

    /**
     * @param maximumElevation the maximumElevation to set
     */
    public void setMaximumElevation(Double maximumElevation) {
        this.maximumElevation = maximumElevation;
    }

    /**
     * @return the radio
     */
    public Integer getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(Integer radio) {
        this.radio = radio;
    }

    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the localityId
     */
    public Long getLocalityId() {
        return localityId;
    }

    /**
     * @param localityId the localityId to set
     */
    public void setLocalityId(Long localityId) {
        this.localityId = localityId;
    }

    /**
     * @return the expositionId
     */
    public Long getExpositionId() {
        return expositionId;
    }

    /**
     * @param expositionId the expositionId to set
     */
    public void setExpositionId(Long expositionId) {
        this.expositionId = expositionId;
    }

    /**
     * @return the gradient
     */
    public Long getGradient() {
        return gradient;
    }

    /**
     * @param gradient the gradient to set
     */
    public void setGradient(Long gradient) {
        this.gradient = gradient;
    }

    /**
     * @return the maximumDepth
     */
    public Double getMaximumDepth() {
        return maximumDepth;
    }

    /**
     * @param maximumDepth the maximumDepth to set
     */
    public void setMaximumDepth(Double maximumDepth) {
        this.maximumDepth = maximumDepth;
    }

    /**
     * @return the minimumDepth
     */
    public Double getMinimumDepth() {
        return minimumDepth;
    }

    /**
     * @param minimumDepth the minimumDepth to set
     */
    public void setMinimumDepth(Double minimumDepth) {
        this.minimumDepth = minimumDepth;
    }

    /**
     * @return the surroundingDescription
     */
    public String getSurroundingDescription() {
        return surroundingDescription;
    }

    /**
     * @param surroundingDescription the surroundingDescription to set
     */
    public void setSurroundingDescription(String SurroundingDescription) {
        this.surroundingDescription = SurroundingDescription;
    }

    /**
     * @return the colectorsList
     */
    public List<PersonDTO> getColectorsList() {
        return colectorsList;
    }

    /**
     * @param colectorsList the colectorsList to set
     */
    public void setColectorsList(List<PersonDTO> colectorsList) {
        this.colectorsList = colectorsList;
    }

    /**
     * @return the projectsList
     */
    public List<ProjectDTO> getProjectsList() {
        return projectsList;
    }

    /**
     * @param projectsList the projectsList to set
     */
    public void setProjectsList(List<ProjectDTO> projectsList) {
        this.projectsList = projectsList;
    }

    /**
     * @return the collectionsList
     */
    public List<CollectionDTO> getCollectionsList() {
        return collectionsList;
    }

    /**
     * @param collectionsList the collectionsList to set
     */
    public void setCollectionsList(List<CollectionDTO> collectionsList) {
        this.collectionsList = collectionsList;
    }

    /**
     * @return the siteDescription
     */
    public String getSiteDescription() {
        return siteDescription;
    }

    /**
     * @param siteDescription the siteDescription to set
     */
    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
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
