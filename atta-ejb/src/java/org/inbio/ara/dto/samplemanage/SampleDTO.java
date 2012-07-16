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


package org.inbio.ara.dto.samplemanage;

import java.util.Calendar;
import java.util.List;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author dasolano
 */
public class SampleDTO extends GenericDTO{

    private Long sampleId;

    private String witness;

    private String description;

    private Calendar gatheringDate;

    private Calendar receptionDate;

    private Long sampleAltitude;

    private Long gatheringObservationId;

    private String microFome;

    private Long microFomeId;

    private String microMethod;

    private Long microMethodId;

    private String microQuality;

    private Long microQualityId;

    private String microSource;

    private Long microSourceTypeId;

    private String permission;

    private Long permissionId;

    private String sampleClass;

    private Long sampleClassId;

    private Long ph;

    private Long tempeture;

    private Long salinity;

    private Long sampleQuantity;

    private Long sampleQuantityMeasurementUnitId;

    private Long sampleStatusId;

    private String site;

    private Long siteId;

    private String taxon;
    
    private Long taxonId;

    private List<EnviromentalDataDTO> enviromentalDataDTOList;

    private List<HostInformationDTO> hostInformationDTOList;

    /* For Graphical Inteface purposes */
    private boolean selected;

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
     * @return the witness
     */
    public String getWitness() {
        return witness;
    }

    /**
     * @param witness the witness to set
     */
    public void setWitness(String witness) {
        this.witness = witness;
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
     * @return the gatheringDate
     */
    public Calendar getGatheringDate() {
        return gatheringDate;
    }

    /**
     * @param gatheringDate the gatheringDate to set
     */
    public void setGatheringDate(Calendar gatheringDate) {
        this.gatheringDate = gatheringDate;
    }

    /**
     * @return the sampleAltitude
     */
    public Long getSampleAltitude() {
        return sampleAltitude;
    }

    /**
     * @param sampleAltitude the sampleAltitude to set
     */
    public void setSampleAltitude(Long sampleAltitude) {
        this.sampleAltitude = sampleAltitude;
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
     * @return the microFome
     */
    public String getMicroFome() {
        return microFome;
    }

    /**
     * @param microFome the microFome to set
     */
    public void setMicroFome(String microFome) {
        this.microFome = microFome;
    }

    /**
     * @return the microFomeId
     */
    public Long getMicroFomeId() {
        return microFomeId;
    }

    /**
     * @param microFomeId the microFomeId to set
     */
    public void setMicroFomeId(Long microFomeId) {
        this.microFomeId = microFomeId;
    }

    /**
     * @return the microMethod
     */
    public String getMicroMethod() {
        return microMethod;
    }

    /**
     * @param microMethod the microMethod to set
     */
    public void setMicroMethod(String microMethod) {
        this.microMethod = microMethod;
    }

    /**
     * @return the microMethodId
     */
    public Long getMicroMethodId() {
        return microMethodId;
    }

    /**
     * @param microMethodId the microMethodId to set
     */
    public void setMicroMethodId(Long microMethodId) {
        this.microMethodId = microMethodId;
    }

    /**
     * @return the microQuality
     */
    public String getMicroQuality() {
        return microQuality;
    }

    /**
     * @param microQuality the microQuality to set
     */
    public void setMicroQuality(String microQuality) {
        this.microQuality = microQuality;
    }

    /**
     * @return the microQualityId
     */
    public Long getMicroQualityId() {
        return microQualityId;
    }

    /**
     * @param microQualityId the microQualityId to set
     */
    public void setMicroQualityId(Long microQualityId) {
        this.microQualityId = microQualityId;
    }

    /**
     * @return the microSource
     */
    public String getMicroSource() {
        return microSource;
    }

    /**
     * @param microSource the microSource to set
     */
    public void setMicroSource(String microSource) {
        this.microSource = microSource;
    }

    /**
     * @return the microSourceTypeId
     */
    public Long getMicroSourceTypeId() {
        return microSourceTypeId;
    }

    /**
     * @param microSourceTypeId the microSourceTypeId to set
     */
    public void setMicroSourceTypeId(Long microSourceTypeId) {
        this.microSourceTypeId = microSourceTypeId;
    }

    /**
     * @return the permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission the permission to set
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * @return the permissionId
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId the permissionId to set
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @return the sampleClass
     */
    public String getSampleClass() {
        return sampleClass;
    }

    /**
     * @param sampleClass the sampleClass to set
     */
    public void setSampleClass(String sampleClass) {
        this.sampleClass = sampleClass;
    }

    /**
     * @return the sampleClassId
     */
    public Long getSampleClassId() {
        return sampleClassId;
    }

    /**
     * @param sampleClassId the sampleClassId to set
     */
    public void setSampleClassId(Long sampleClassId) {
        this.sampleClassId = sampleClassId;
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
     * @return the taxon
     */
    public String getTaxon() {
        return taxon;
    }

    /**
     * @param taxon the taxon to set
     */
    public void setTaxon(String taxon) {
        this.taxon = taxon;
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
     * @return the sampleQuantity
     */
    public Long getSampleQuantity() {
        return sampleQuantity;
    }

    /**
     * @param sampleQuantity the sampleQuantity to set
     */
    public void setSampleQuantity(Long sampleQuantity) {
        this.sampleQuantity = sampleQuantity;
    }

    /**
     * @return the sampleQuantityMeasurementUnitId
     */
    public Long getSampleQuantityMeasurementUnitId() {
        return sampleQuantityMeasurementUnitId;
    }

    /**
     * @param sampleQuantityMeasurementUnitId the sampleQuantityMeasurementUnitId to set
     */
    public void setSampleQuantityMeasurementUnitId(Long sampleQuantityMeasurementUnitId) {
        this.sampleQuantityMeasurementUnitId = sampleQuantityMeasurementUnitId;
    }

    /**
     * @return the receptionDate
     */
    public Calendar getReceptionDate() {
        return receptionDate;
    }

    /**
     * @param receptionDate the receptionDate to set
     */
    public void setReceptionDate(Calendar receptionDate) {
        this.receptionDate = receptionDate;
    }

    /**
     * @return the sampleStatusId
     */
    public Long getSampleStatusId() {
        return sampleStatusId;
    }

    /**
     * @param sampleStatusId the sampleStatusId to set
     */
    public void setSampleStatusId(Long sampleStatusId) {
        this.sampleStatusId = sampleStatusId;
    }

    /**
     * @return the enviromentalDataDTOList
     */
    public List<EnviromentalDataDTO> getEnviromentalDataDTOList() {
        return enviromentalDataDTOList;
    }

    /**
     * @param enviromentalDataDTOList the enviromentalDataDTOList to set
     */
    public void setEnviromentalDataDTOList(List<EnviromentalDataDTO> enviromentalDataDTOList) {
        this.enviromentalDataDTOList = enviromentalDataDTOList;
    }

    /**
     * @return the hostInformationDTOList
     */
    public List<HostInformationDTO> getHostInformationDTOList() {
        return hostInformationDTOList;
    }

    /**
     * @param hostInformationDTOList the hostInformationDTOList to set
     */
    public void setHostInformationDTOList(List<HostInformationDTO> hostInformationDTOList) {
        this.hostInformationDTOList = hostInformationDTOList;
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
