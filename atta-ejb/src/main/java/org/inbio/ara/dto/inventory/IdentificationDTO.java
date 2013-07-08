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
import java.util.Iterator;
import java.util.List;
import org.inbio.ara.dto.GenericDTO;

/**
 * The fields will the comment "read only" will be ignored on persistence tasks
 *
 * @author asanabria
 */
public class IdentificationDTO extends GenericDTO implements Serializable {

    private boolean selected = false;
    private boolean multitaxon = false;
    private Long specimenKey;
    private Long gatheringObservationId;
    private Calendar initialTimeStamp;
    private String catalogNumber; /*Para ser mostrado en el list*/

    private Long statusId;
    private String statusName;  /*Para ser mostrado en el list*/

    private String dataEntryError;
    private PersonDTO valuerPerson;
    private String valuerPersonName;
    private String typeName;  /*Para ser mostrado en el list*/

    private Long typeId;
    private Calendar identificationDate;
    private List<IdentifierDTO> identifiers;
    private List<TaxonDTO> taxa;
    
    private String gathObsDetailNumber;
    private Long collectorGathObsDetail;
    private String collectorNameGathObsDetail;
    
    /**
     * OJO: este atributo debera ser "seteado" en el facade correspondiente
     * con un string formado por los diferentes identificadores que se
     * encuentren en la lista identifiers
     * @ReadOnly
     */
    private String identifierString;
    /**
     * OJO: este atributo debera ser "seteado" en el facade correspondiente
     * con un string formado por los diferentes nombres sientíficos que se
     * encuentran en la lista de taxones
     * @ReadOnly
     */
    private String taxonString;

    //Used in advanced search to filter by collection
    private Long collectionId;

    public IdentificationDTO() {
    }

    @Override
    public String toString() {
        return "IdentificationDTO " +
                "\n\tSpecimen id " + specimenKey +
                "\n\tCatalog number " + catalogNumber;
    }

    /**
     *
     * @return catalogNumber
     */
    public String getCatalogNumber() {
        return catalogNumber;
    }

    /**
     *
     * @param catalogNumber
     */
    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    /**
     *
     * @return specimenKey
     *
     */
    public Long getSpecimenKey() {
        return specimenKey;
    }

    /**
     *
     * @param specimenKey
     */
    public void setSpecimenKey(Long specimenKey) {
        this.specimenKey = specimenKey;
    }

    /**
     *
     * @return identifiers
     */
    public List<IdentifierDTO> getIdentifiers() {
        return identifiers;
    }

    /**
     *
     * @param identifiers
     */
    public void setIdentifiers(List<IdentifierDTO> identifiers) {
        this.identifiers = identifiers;
        this.identifierString = "";

        for (Iterator<IdentifierDTO> it = identifiers.iterator(); it.hasNext();) {
            IdentifierDTO identifierDTO = it.next();
            this.identifierString += identifierDTO.getIdentifierName();
            if (it.hasNext()) {
                this.identifierString += ", ";
            }
        }
    }

    /**
     * @return the statusName
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * @param statusName the statusName to set
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    /**
     * @return the statusId
     */
    public Long getStatusId() {
        return statusId;
    }

    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
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
     * @return the identifierString
     */
    public String getIdentifierString() {
        return identifierString;
    }

    /**
     * @param identifierString the identifierString to set
     */
    public void setIdentifierString(String identifierString) {
        this.identifierString = identifierString;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Calendar getInitialTimeStamp() {
        return initialTimeStamp;
    }

    public void setInitialTimeStamp(Calendar initialTimeStamp) {
        this.initialTimeStamp = initialTimeStamp;
    }

    public String getTaxonString() {
        return taxonString;
    }

    public void setTaxonString(String taxonString) {
        this.taxonString = taxonString;
    }

    public String getDataEntryError() {
        return dataEntryError;
    }

    public void setDataEntryError(String dataEntryError) {
        this.dataEntryError = dataEntryError;
    }

    public PersonDTO getValuerPerson() {
        return valuerPerson;
    }

    public void setValuerPerson(PersonDTO valuerPerson) {
        this.valuerPerson = valuerPerson;
    }

    public List<TaxonDTO> getTaxa() {
        return taxa;
    }

    public void setTaxa(List<TaxonDTO> taxa) {
        this.taxa = taxa;
        this.taxonString = "";

        for (Iterator<TaxonDTO> it = taxa.iterator(); it.hasNext();) {
            TaxonDTO taxonDTO = it.next();
            this.taxonString += taxonDTO.getDefaultName();
            if (it.hasNext()) {
                this.taxonString += ", ";
            }
        }
    }

    public String getValuerPersonName() {
        return valuerPersonName;
    }

    public void setValuerPersonName(String valuerPersonName) {
        this.valuerPersonName = valuerPersonName;
    }

    /**
     * @return the identificationDate
     */
    public Calendar getIdentificationDate() {
        return identificationDate;
    }

    /**
     * @param identificationDate the identificationDate to set
     */
    public void setIdentificationDate(Calendar identificationDate) {
        this.identificationDate = identificationDate;
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
     * 
     * @return
     */
    public boolean isMultitaxon() {
        return multitaxon;
    }

    /**
     *
     * @param multitaxon
     */
    public void setMultitaxon(boolean multitaxon) {
        this.multitaxon = multitaxon;
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
