/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germplasm;

import java.util.Calendar;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author dasolano
 */
public class SementalDTO extends GenericDTO {

    /* For Graphical Inteface purposes */
    private boolean selected;

    private Long sementalId;

    private String name;

    private String animalCode;

    private String color;

    private Calendar birthDate;

    private String veterinarianStatus;

    private String animalDescription;

    private String father;

    private String mother;

    private Long breedId;

    private String breed;

    private Long conditionId;

    private String condition;

    private Long siteId;

    private String site;

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

    /**
     * @return the sementalId
     */
    public Long getSementalId() {
        return sementalId;
    }

    /**
     * @param sementalId the sementalId to set
     */
    public void setSementalId(Long sementalId) {
        this.sementalId = sementalId;
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
     * @return the animalCode
     */
    public String getAnimalCode() {
        return animalCode;
    }

    /**
     * @param animalCode the animalCode to set
     */
    public void setAnimalCode(String animalCode) {
        this.animalCode = animalCode;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the birthDate
     */
    public Calendar getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the veterinarianStatus
     */
    public String getVeterinarianStatus() {
        return veterinarianStatus;
    }

    /**
     * @param veterinarianStatus the veterinarianStatus to set
     */
    public void setVeterinarianStatus(String veterinarianStatus) {
        this.veterinarianStatus = veterinarianStatus;
    }

    /**
     * @return the animalDescription
     */
    public String getAnimalDescription() {
        return animalDescription;
    }

    /**
     * @param animalDescription the animalDescription to set
     */
    public void setAnimalDescription(String animalDescription) {
        this.animalDescription = animalDescription;
    }

    /**
     * @return the father
     */
    public String getFather() {
        return father;
    }

    /**
     * @param father the father to set
     */
    public void setFather(String father) {
        this.father = father;
    }

    /**
     * @return the mother
     */
    public String getMother() {
        return mother;
    }

    /**
     * @param mother the mother to set
     */
    public void setMother(String mother) {
        this.mother = mother;
    }

    /**
     * @return the breedId
     */
    public Long getBreedId() {
        return breedId;
    }

    /**
     * @param breedId the breedId to set
     */
    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    /**
     * @return the conditionId
     */
    public Long getConditionId() {
        return conditionId;
    }

    /**
     * @param conditionId the conditionId to set
     */
    public void setConditionId(Long conditionId) {
        this.conditionId = conditionId;
    }

    /**
     * @return the siteId
     */
    public Long getSiteId() {
        return siteId;
    }

    /**
     * @param siteId the siteId to set
     */
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    

    /**
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @param breed the breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * @return the condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(String site) {
        this.site = site;
    }
}
