/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.samplemanage;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author dasolano
 */
public class EnviromentalDataDTO extends GenericDTO{

    private Long enviromentalDataId;

    private Long sampleId;

    private Long elevation;

    private Long ph;

    private Long luminosity;

    private Long tempeture;

    private Long moisture;

    private String habitat;

    private Long salinity;

    private Long verticalStrataId;

    private String verticalStrata;

    private Long vegetationTypeId;

    private String vegetationType;

    /* For Graphical Inteface purposes */
    private boolean selected;
    
    /**
     * @return the enviromentalDataId
     */
    public Long getEnviromentalDataId() {
        return enviromentalDataId;
    }

    /**
     * @param enviromentalDataId the enviromentalDataId to set
     */
    public void setEnviromentalDataId(Long enviromentalDataId) {
        this.enviromentalDataId = enviromentalDataId;
    }

    /**
     * @return the sampleId
     */
    public Long getSampleId() {
        return sampleId;
    }

    /**
     * @param sampleId the sampleId to set
     */
    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    /**
     * @return the elevation
     */
    public Long getElevation() {
        return elevation;
    }

    /**
     * @param elevation the elevation to set
     */
    public void setElevation(Long elevation) {
        this.elevation = elevation;
    }

    
    /**
     * @return the ph
     */
    public Long getPh() {
        return ph;
    }

    /**
     * @param ph the ph to set
     */
    public void setPh(Long ph) {
        this.ph = ph;
    }

    /**
     * @return the luminosity
     */
    public Long getLuminosity() {
        return luminosity;
    }

    /**
     * @param luminosity the luminosity to set
     */
    public void setLuminosity(Long luminosity) {
        this.luminosity = luminosity;
    }

    /**
     * @return the tempeture
     */
    public Long getTempeture() {
        return tempeture;
    }

    /**
     * @param tempeture the tempeture to set
     */
    public void setTempeture(Long tempeture) {
        this.tempeture = tempeture;
    }

    /**
     * @return the moisture
     */
    public Long getMoisture() {
        return moisture;
    }

    /**
     * @param moisture the moisture to set
     */
    public void setMoisture(Long moisture) {
        this.moisture = moisture;
    }

    /**
     * @return the habitat
     */
    public String getHabitat() {
        return habitat;
    }

    /**
     * @param habitat the habitat to set
     */
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    /**
     * @return the salinity
     */
    public Long getSalinity() {
        return salinity;
    }

    /**
     * @param salinity the salinity to set
     */
    public void setSalinity(Long salinity) {
        this.salinity = salinity;
    }

    /**
     * @return the verticalStrataId
     */
    public Long getVerticalStrataId() {
        return verticalStrataId;
    }

    /**
     * @param verticalStrataId the verticalStrataId to set
     */
    public void setVerticalStrataId(Long verticalStrataId) {
        this.verticalStrataId = verticalStrataId;
    }

    /**
     * @return the vegetationTypeId
     */
    public Long getVegetationTypeId() {
        return vegetationTypeId;
    }

    /**
     * @param vegetationTypeId the vegetationTypeId to set
     */
    public void setVegetationTypeId(Long vegetationTypeId) {
        this.vegetationTypeId = vegetationTypeId;
    }

    /**
     * @return the verticalStrata
     */
    public String getVerticalStrata() {
        return verticalStrata;
    }

    /**
     * @param verticalStrata the verticalStrata to set
     */
    public void setVerticalStrata(String verticalStrata) {
        this.verticalStrata = verticalStrata;
    }

    /**
     * @return the vegetationType
     */
    public String getVegetationType() {
        return vegetationType;
    }

    /**
     * @param vegetationType the vegetationType to set
     */
    public void setVegetationType(String vegetationType) {
        this.vegetationType = vegetationType;
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
