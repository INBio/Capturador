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
public class AccessionDTO extends GenericDTO {

    private Long accessionId;

    private String accessionNumber;

    private Long packages;

    private Long originalWeigth;

    private Long multiplicationRegeneration;

    private Long currentWeigth;

    private String location;

    private Calendar germinationDate;

    private Long germinationRate;

    private Long germinationViability;

    private Long moisture;

    private Calendar storageDate;

    private String notes;

    private Long accessionParentId;

    private String accessionParent;

    private Long collectionTypeId;

    private String collectionType;

    private Long germinationMethodTypeId;

    private String germinationMethodType;

    private Long moistureMethodTypeId;

    private String moistureMethodType;

    private Long passportId;

    private Long responsablePersonId;

    private String responsablePerson;

    /* For Graphical Inteface purposes */
    private boolean selected;
    
    /**
     * @return the accessionId
     */
    public Long getAccessionId() {
        return accessionId;
    }

    /**
     * @param accessionId the accessionId to set
     */
    public void setAccessionId(Long accessionId) {
        this.accessionId = accessionId;
    }

    /**
     * @return the accessionNumber
     */
    public String getAccessionNumber() {
        return accessionNumber;
    }

    /**
     * @param accessionNumber the accessionNumber to set
     */
    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    /**
     * @return the packages
     */
    public Long getPackages() {
        return packages;
    }

    /**
     * @param packages the packages to set
     */
    public void setPackages(Long packages) {
        this.packages = packages;
    }


    /**
     * @return the multiplicationRegeneration
     */
    public Long getMultiplicationRegeneration() {
        return multiplicationRegeneration;
    }

    /**
     * @param multiplicationRegeneration the multiplicationRegeneration to set
     */
    public void setMultiplicationRegeneration(Long multiplicationRegeneration) {
        this.multiplicationRegeneration = multiplicationRegeneration;
    }

  

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the germinationDate
     */
    public Calendar getGerminationDate() {
        return germinationDate;
    }

    /**
     * @param germinationDate the germinationDate to set
     */
    public void setGerminationDate(Calendar germinationDate) {
        this.germinationDate = germinationDate;
    }

    /**
     * @return the germinationRate
     */
    public Long getGerminationRate() {
        return germinationRate;
    }

    /**
     * @param germinationRate the germinationRate to set
     */
    public void setGerminationRate(Long germinationRate) {
        this.germinationRate = germinationRate;
    }

    /**
     * @return the germinationViability
     */
    public Long getGerminationViability() {
        return germinationViability;
    }

    /**
     * @param germinationViability the germinationViability to set
     */
    public void setGerminationViability(Long germinationViability) {
        this.germinationViability = germinationViability;
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
     * @return the storageDate
     */
    public Calendar getStorageDate() {
        return storageDate;
    }

    /**
     * @param storageDate the storageDate to set
     */
    public void setStorageDate(Calendar storageDate) {
        this.storageDate = storageDate;
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
     * @return the accessionParentId
     */
    public Long getAccessionParentId() {
        return accessionParentId;
    }

    /**
     * @param accessionParentId the accessionParentId to set
     */
    public void setAccessionParentId(Long accessionParentId) {
        this.accessionParentId = accessionParentId;
    }

    /**
     * @return the collectionTypeId
     */
    public Long getCollectionTypeId() {
        return collectionTypeId;
    }

    /**
     * @param collectionTypeId the collectionTypeId to set
     */
    public void setCollectionTypeId(Long collectionTypeId) {
        this.collectionTypeId = collectionTypeId;
    }

    /**
     * @return the germinationMethodTypeId
     */
    public Long getGerminationMethodTypeId() {
        return germinationMethodTypeId;
    }

    /**
     * @param germinationMethodTypeId the germinationMethodTypeId to set
     */
    public void setGerminationMethodTypeId(Long germinationMethodTypeId) {
        this.germinationMethodTypeId = germinationMethodTypeId;
    }

    /**
     * @return the moistureMethodTypeId
     */
    public Long getMoistureMethodTypeId() {
        return moistureMethodTypeId;
    }

    /**
     * @param moistureMethodTypeId the moistureMethodTypeId to set
     */
    public void setMoistureMethodTypeId(Long moistureMethodTypeId) {
        this.moistureMethodTypeId = moistureMethodTypeId;
    }

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
     * @return the responsablePersonId
     */
    public Long getResponsablePersonId() {
        return responsablePersonId;
    }

    /**
     * @param responsablePersonId the responsablePersonId to set
     */
    public void setResponsablePersonId(Long responsablePersonId) {
        this.responsablePersonId = responsablePersonId;
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

    /**
     * @return the originalWeigth
     */
    public Long getOriginalWeigth() {
        return originalWeigth;
    }

    /**
     * @param originalWeigth the originalWeigth to set
     */
    public void setOriginalWeigth(Long originalWeigth) {
        this.originalWeigth = originalWeigth;
    }

    /**
     * @return the currentWeigth
     */
    public Long getCurrentWeigth() {
        return currentWeigth;
    }

    /**
     * @param currentWeigth the currentWeigth to set
     */
    public void setCurrentWeigth(Long currentWeigth) {
        this.currentWeigth = currentWeigth;
    }

    /**
     * @return the collectionType
     */
    public String getCollectionType() {
        return collectionType;
    }

    /**
     * @param collectionType the collectionType to set
     */
    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    /**
     * @return the moistureMethodType
     */
    public String getMoistureMethodType() {
        return moistureMethodType;
    }

    /**
     * @param moistureMethodType the moistureMethodType to set
     */
    public void setMoistureMethodType(String moistureMethodType) {
        this.moistureMethodType = moistureMethodType;
    }

    /**
     * @return the responsablePerson
     */
    public String getResponsablePerson() {
        return responsablePerson;
    }

    /**
     * @param responsablePerson the responsablePerson to set
     */
    public void setResponsablePerson(String responsablePerson) {
        this.responsablePerson = responsablePerson;
    }

    /**
     * @return the germinationMethodType
     */
    public String getGerminationMethodType() {
        return germinationMethodType;
    }

    /**
     * @param germinationMethodType the germinationMethodType to set
     */
    public void setGerminationMethodType(String germinationMethodType) {
        this.germinationMethodType = germinationMethodType;
    }

    /**
     * @return the accessionParent
     */
    public String getAccessionParent() {
        return accessionParent;
    }

    /**
     * @param accessionParent the accessionParent to set
     */
    public void setAccessionParent(String accessionParent) {
        this.accessionParent = accessionParent;
    }

}
