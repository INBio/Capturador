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
import java.util.Date;
import java.util.List;
import org.inbio.ara.dto.GenericDTO;

/**
 * The fields will the comment "read only" will be ignored on persistence tasks
 *
 * @author jgutierrez
 */

enum CoordType {DECIMAL,LAMBERT};

public class SpecimenDTO extends GenericDTO implements Serializable{

    /* null when the specimen is new*/
    private Long specimenKey;


    /*catalogNumber is read only */
    private String catalogNumber;
    /*institutionCode is read only*/
    private String institutionCode;
    /*institutionId is read only*/
    private Long institutionId;
    /*collectionName is read only */
    private String collectionName;
    /*collectionId is read only */
    private Long collectionId;
    /*taxonName is read only */
    private String taxonName;
    /*taxonId is read only */
    private Long taxonId;
    /*localityDescription is read only */
    private String localityDescription;
    /*coordinates is read only */
    private String coordinates;
    /*countryName is read only */
    private String countryName;
    /*countryId is read only */
    private Long countryId;
    /*provinceName is read only */
    private String provinceName;
    /*provinceId is read only */
    private Long provinceId;
    /*responsibleName is read only */
    private String responsibleName;
    /*responsibleId is read only */
    private Long responsibleId;
    /*gatheringObsevationId is read only */
    private Long gatheringObsevationId;

    private Long gatheringObservationDetailId;
    /*labelId is read only */
    private Long labelId;
    /*originalLabelId is read only */
    private Long originalLabelId;

    /* For Graphical Inteface purposes */
    private boolean selected;

    
    /*categoryName is read only */
    private String categoryName;
    /*persited*/
    private Long categoryId;

    /* typeName is read only*/
    private String typeName;
    /*persited*/
    private Long typeId;

    /* gatheringMethodName is read only*/
    private String gatheringMethodName;
    /*persited*/
    private Long gatheringMethodId;

    /* substrateName is read only*/
    private String substrateName;
    /*persited*/
    private Long substrateId;
    
    /*persited*/
    private Long numberWhole;

    /* extractionTypeName is read only*/
    private String extractionTypeName;
    /*persited*/
    private Long extractionTypeId;

    /* originName is read only*/
    private String originName;
    /*persited*/
    private Long originId;

    /* preservationMediumName is read only*/
    private String preservationMediumName;
    /*persited*/
    private Long preservationMediumId;

    /* storageTypeName is read only*/
    private String storageTypeName;
    /*persited*/
    private Long storageTypeId;

    /*persited*/
    private Long numberFragments;

    /*persited*/
    private boolean discarded;

    //Added to generate specimens
    private Long certaintyLevel;
    private Date dateTime;

    /*persited ignoring the valueName of the SelectionListDTO's*/
    private List<LifeStageSexDTO> lifeStageSexList;

    private String gathObsDetailNumber;
    private Long collectorGathObsDetail;
    private String collectorNameGathObsDetail;
    
    /** For Quering purposes **/
    private Integer radio;
    private Double latitude;
    private Double longitude;



    
    public SpecimenDTO() {
    }

    @Override
    public String toString() {

        String lssToString="";
        if(getLifeStageSexList() != null)
        {
            for(LifeStageSexDTO lssDTO :getLifeStageSexList() )
                lssToString = lssToString + lssDTO.toString();
        }

        return "SpecimenDTO" +
                "\n\tSpecimen id = " + specimenKey +
                "\n\tCatalog number = " + getCatalogNumber() +
                "\n\tInstitution code = " + institutionCode +
                "\n\tInstitution id = " + institutionId +
                "\n\tCollection name = " + collectionName +
                "\n\tCollection id = " + collectionId +
                "\n\tspecimen Type Id = " + this.getTypeId() +
                "\n\tspecimen Type Name = " + this.getTypeName() +
                "\n\tspecimen Category Id = " + this.getCategoryId() +
                "\n\tspecimen Category Name = " + this.getCategoryName() +
                "\n\tTaxon name = " + taxonName +
                "\n\tLocality = " + localityDescription +
                "\n\tCoordinates = " + coordinates +
                "\n\tCountry name = " + countryName +
                "\n\tCountry id = " + countryId +
                "\n\tProvince name = " + provinceName +
                "\n\tProvince id = " + provinceId +
                "\n\tResponsible = " + responsibleName+
                "\n\tLongitude = " + getLongitude()+
                "\n\tLatitude = " + getLatitude()+
                "\n\tRadio = " + getRadio()+
                "\n\tDiscarted = " + isDiscarded()+
                "\n\tDateTime = " +dateTime+
                "\n\tLifeStafeSexDTO = \n" + lssToString +
                "\n\tlabelID = " + labelId  +
                "\n\tOriginalLabelID = " +originalLabelId                
                ;
    }

    /**
     * @return the collectionName
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * @param collectionName the collectionName to set
     */
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getLocalityDescription() {
        return localityDescription;
    }

    public void setLocalityDescription(String localityDescription) {
        this.localityDescription = localityDescription;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }


    public Long getSpecimenKey() {
        return specimenKey;
    }

    public void setSpecimenKey(Long specimenKey) {
        this.specimenKey = specimenKey;
    }

    public String getTaxonName() {
        return taxonName;
    }

    public void setTaxonName(String taxonName) {
        this.taxonName = taxonName;
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
     * @return the catalogNumber
     */
    public String getCatalogNumber() {
        return catalogNumber;
    }

    /**
     * @param catalogNumber the catalogNumber to set
     */
    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    /**
     * @return the institutionId
     */
    public Long getInstitutionId() {
        return institutionId;
    }

    /**
     * @param institutionId the institutionId to set
     */
    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
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
     * @return the taxonId
     */
    public Long getTaxonId() {
        return taxonId;
    }

    /**
     * @param taxonId the taxonId to set
     */
    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
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
     * @return the gatheringObsevationId
     */
    public Long getGatheringObsevationId() {
        return gatheringObsevationId;
    }

    /**
     * @param gatheringObsevationId the gatheringObsevationId to set
     */
    public void setGatheringObsevationId(Long gatheringObsevationId) {
        this.gatheringObsevationId = gatheringObsevationId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the categoryId
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the extractionTypeName
     */
    public String getExtractionTypeName() {
        return extractionTypeName;
    }

    /**
     * @param extractionTypeName the extractionTypeName to set
     */
    public void setExtractionTypeName(String extractionTypeName) {
        this.extractionTypeName = extractionTypeName;
    }

    /**
     * @return the extractionTypeId
     */
    public Long getExtractionTypeId() {
        return extractionTypeId;
    }

    /**
     * @param extractionTypeId the extractionTypeId to set
     */
    public void setExtractionTypeId(Long extractionTypeId) {
        this.extractionTypeId = extractionTypeId;
    }

    /**
     * @return the typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * @return the typeId
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * @return the originName
     */
    public String getOriginName() {
        return originName;
    }

    /**
     * @param originName the originName to set
     */
    public void setOriginName(String originName) {
        this.originName = originName;
    }

    /**
     * @return the originId
     */
    public Long getOriginId() {
        return originId;
    }

    /**
     * @param originId the originId to set
     */
    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    /**
     * @return the preservationMediumName
     */
    public String getPreservationMediumName() {
        return preservationMediumName;
    }

    /**
     * @param preservationMediumName the preservationMediumName to set
     */
    public void setPreservationMediumName(String preservationMediumName) {
        this.preservationMediumName = preservationMediumName;
    }

    /**
     * @return the preservationMediumId
     */
    public Long getPreservationMediumId() {
        return preservationMediumId;
    }

    /**
     * @param preservationMediumId the preservationMediumId to set
     */
    public void setPreservationMediumId(Long preservationMediumId) {
        this.preservationMediumId = preservationMediumId;
    }

    /**
     * @return the storageTypeName
     */
    public String getStorageTypeName() {
        return storageTypeName;
    }

    /**
     * @param storageTypeName the storageTypeName to set
     */
    public void setStorageTypeName(String storageTypeName) {
        this.storageTypeName = storageTypeName;
    }

    /**
     * @return the storageTypeId
     */
    public Long getStorageTypeId() {
        return storageTypeId;
    }

    /**
     * @param storageTypeId the storageTypeId to set
     */
    public void setStorageTypeId(Long storageTypeId) {
        this.storageTypeId = storageTypeId;
    }

    /**
     * @return the numberWhole
     */
    public Long getNumberWhole() {
        return numberWhole;
    }

    /**
     * @param numberWhole the numberWhole to set
     */
    public void setNumberWhole(Long numberWhole) {
        this.numberWhole = numberWhole;
    }

    /**
     * @return the gatheringMethodName
     */
    public String getGatheringMethodName() {
        return gatheringMethodName;
    }

    /**
     * @param gatheringMethodName the gatheringMethodName to set
     */
    public void setGatheringMethodName(String gatheringMethodName) {
        this.gatheringMethodName = gatheringMethodName;
    }

    /**
     * @return the gatheringMethodId
     */
    public Long getGatheringMethodId() {
        return gatheringMethodId;
    }

    /**
     * @param gatheringMethodId the gatheringMethodId to set
     */
    public void setGatheringMethodId(Long gatheringMethodId) {
        this.gatheringMethodId = gatheringMethodId;
    }

    /**
     * @return the numberFragments
     */
    public Long getNumberFragments() {
        return numberFragments;
    }

    /**
     * @param numberFragments the numberFragments to set
     */
    public void setNumberFragments(Long numberFragments) {
        this.numberFragments = numberFragments;
    }

    /**
     * @return the discarded
     */
    public boolean isDiscarded() {
        return discarded;
    }

    /**
     * @param discarded the discarded to set
     */
    public void setDiscarded(boolean discarded) {
        this.discarded = discarded;
    }

    /**
     * @return the lifeStageSexList
     */
    public List<LifeStageSexDTO> getLifeStageSexList() {
        return lifeStageSexList;
    }

    /**
     * @param lifeStageSexList the lifeStageSexList to set
     */
    public void setLifeStageSexList(List<LifeStageSexDTO> lifeStageSexList) {
        this.lifeStageSexList = lifeStageSexList;
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
     * @return the substrateName
     */
    public String getSubstrateName() {
        return substrateName;
    }

    /**
     * @param substrateName the substrateName to set
     */
    public void setSubstrateName(String substrateName) {
        this.substrateName = substrateName;
    }

    /**
     * @return the substrateId
     */
    public Long getSubstrateId() {
        return substrateId;
    }

    /**
     * @param substrateId the substrateId to set
     */
    public void setSubstrateId(Long substrateId) {
        this.substrateId = substrateId;
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
     * @return the certaintyLevel
     */
    public Long getCertaintyLevel() {
        return certaintyLevel;
    }

    /**
     * @param certaintyLevel the certaintyLevel to set
     */
    public void setCertaintyLevel(Long certaintyLevel) {
        this.certaintyLevel = certaintyLevel;
    }

    /**
     * @return the dateTime
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the labelID
     */
    public Long getLabelId() {
        return labelId;
    }

    /**
     * @param labelID the labelID to set
     */
    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    /**
     * @return the originalLabelId
     */
    public Long getOriginalLabelId() {
        return originalLabelId;
    }

    /**
     * @param originalLabelId the originalLabelId to set
     */
    public void setOriginalLabelId(Long originalLabelId) {
        this.originalLabelId = originalLabelId;
    }

    /**
     * @return the gathObsDetailNumber
     */
    public String getGathObsDetailNumber() {
        return gathObsDetailNumber;
    }

    /**
     * @param gathObsDetailNumber the gathObsDetailNumber to set
     */
    public void setGathObsDetailNumber(String gathObsDetailNumber) {
        this.gathObsDetailNumber = gathObsDetailNumber;
    }

    /**
     * @return the collectorGathObsDetail
     */
    public Long getCollectorGathObsDetail() {
        return collectorGathObsDetail;
    }

    /**
     * @param collectorGathObsDetail the collectorGathObsDetail to set
     */
    public void setCollectorGathObsDetail(Long collectorGathObsDetail) {
        this.collectorGathObsDetail = collectorGathObsDetail;
    }

    /**
     * @return the collectorNameGathObsDetail
     */
    public String getCollectorNameGathObsDetail() {
        return collectorNameGathObsDetail;
    }

    /**
     * @param collectorNameGathObsDetail the collectorNameGathObsDetail to set
     */
    public void setCollectorNameGathObsDetail(String collectorNameGathObsDetail) {
        this.collectorNameGathObsDetail = collectorNameGathObsDetail;
    }
}

