/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germplasm;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author dasolano
 */
public class PassportDTO extends GenericDTO {

    private Long passportId;

    private String person;

    private Long donorPersonId;

    private String institution;

    private Long donorInstitutionId;

    private Long gatheringId;

    private String materialType;

    private Long materialTypeId;

    private String sampleStatus;

    private Long sampleStatusId;

    private String gatheringSource;

    private Long gatheringSourceId;

    private Long missionNumber;

    private String soilColor;

    private Long soilColorId;

    private String soilTexture;

    private Long soilTextureId;

    private String cultivationPractice;

    private Long cultivationPracticeId;

    private Calendar plantNurseryDate;

    private Calendar plantingSeasonDate;

    private Calendar harvestingSeasonDate;

    private String cropSystem;

    private Long cropSystemId;

    private String resistant;

    private String remarks;

    private String cropType;

    private Long cropTypeId;

    private Long taxonId;

    private List<PassportNomenclaturalGroupDTO> passportNomenclaturalGroupList;


    /* For Graphical Inteface purposes */
    private boolean selected;

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
     * @return the person
     */
    public String getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(String person) {
        this.person = person;
    }

    /**
     * @return the donorPersonId
     */
    public Long getDonorPersonId() {
        return donorPersonId;
    }

    /**
     * @param donorPersonId the donorPersonId to set
     */
    public void setDonorPersonId(Long donorPersonId) {
        this.donorPersonId = donorPersonId;
    }

    /**
     * @return the institution
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * @param institution the institution to set
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * @return the donorInstitutionId
     */
    public Long getDonorInstitutionId() {
        return donorInstitutionId;
    }

    /**
     * @param donorInstitutionId the donorInstitutionId to set
     */
    public void setDonorInstitutionId(Long donorInstitutionId) {
        this.donorInstitutionId = donorInstitutionId;
    }

    /**
     * @return the gatheringId
     */
    public Long getGatheringId() {
        return gatheringId;
    }

    /**
     * @param gatheringId the gatheringId to set
     */
    public void setGatheringId(Long gatheringId) {
        this.gatheringId = gatheringId;
    }

    /**
     * @return the materialType
     */
    public String getMaterialType() {
        return materialType;
    }

    /**
     * @param materialType the materialType to set
     */
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    /**
     * @return the materialTypeId
     */
    public Long getMaterialTypeId() {
        return materialTypeId;
    }

    /**
     * @param materialTypeId the materialTypeId to set
     */
    public void setMaterialTypeId(Long materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    /**
     * @return the sampleStatus
     */
    public String getSampleStatus() {
        return sampleStatus;
    }

    /**
     * @param sampleStatus the sampleStatus to set
     */
    public void setSampleStatus(String sampleStatus) {
        this.sampleStatus = sampleStatus;
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
     * @return the gatheringSource
     */
    public String getGatheringSource() {
        return gatheringSource;
    }

    /**
     * @param gatheringSource the gatheringSource to set
     */
    public void setGatheringSource(String gatheringSource) {
        this.gatheringSource = gatheringSource;
    }

    /**
     * @return the gatheringSourceId
     */
    public Long getGatheringSourceId() {
        return gatheringSourceId;
    }

    /**
     * @param gatheringSourceId the gatheringSourceId to set
     */
    public void setGatheringSourceId(Long gatheringSourceId) {
        this.gatheringSourceId = gatheringSourceId;
    }

    /**
     * @return the missionNumber
     */
    public Long getMissionNumber() {
        return missionNumber;
    }

    /**
     * @param missionNumber the missionNumber to set
     */
    public void setMissionNumber(Long missionNumber) {
        this.missionNumber = missionNumber;
    }

    /**
     * @return the soilColor
     */
    public String getSoilColor() {
        return soilColor;
    }

    /**
     * @param soilColor the soilColor to set
     */
    public void setSoilColor(String soilColor) {
        this.soilColor = soilColor;
    }

    /**
     * @return the soilColorId
     */
    public Long getSoilColorId() {
        return soilColorId;
    }

    /**
     * @param soilColorId the soilColorId to set
     */
    public void setSoilColorId(Long soilColorId) {
        this.soilColorId = soilColorId;
    }

    /**
     * @return the soilTexture
     */
    public String getSoilTexture() {
        return soilTexture;
    }

    /**
     * @param soilTexture the soilTexture to set
     */
    public void setSoilTexture(String soilTexture) {
        this.soilTexture = soilTexture;
    }

    /**
     * @return the soilTextureId
     */
    public Long getSoilTextureId() {
        return soilTextureId;
    }

    /**
     * @param soilTextureId the soilTextureId to set
     */
    public void setSoilTextureId(Long soilTextureId) {
        this.soilTextureId = soilTextureId;
    }

    /**
     * @return the cultivationPractice
     */
    public String getCultivationPractice() {
        return cultivationPractice;
    }

    /**
     * @param cultivationPractice the cultivationPractice to set
     */
    public void setCultivationPractice(String cultivationPractice) {
        this.cultivationPractice = cultivationPractice;
    }

    /**
     * @return the cultivationPracticeId
     */
    public Long getCultivationPracticeId() {
        return cultivationPracticeId;
    }

    /**
     * @param cultivationPracticeId the cultivationPracticeId to set
     */
    public void setCultivationPracticeId(Long cultivationPracticeId) {
        this.cultivationPracticeId = cultivationPracticeId;
    }

    /**
     * @return the plantNurseryDate
     */
    public Calendar getPlantNurseryDate() {
        return plantNurseryDate;
    }

    /**
     * @param plantNurseryDate the plantNurseryDate to set
     */
    public void setPlantNurseryDate(Calendar plantNurseryDate) {
        this.plantNurseryDate = plantNurseryDate;
    }

    /**
     * @return the plantingSeasonDate
     */
    public Calendar getPlantingSeasonDate() {
        return plantingSeasonDate;
    }

    /**
     * @param plantingSeasonDate the plantingSeasonDate to set
     */
    public void setPlantingSeasonDate(Calendar plantingSeasonDate) {
        this.plantingSeasonDate = plantingSeasonDate;
    }

    /**
     * @return the harvestingSeasonDate
     */
    public Calendar getHarvestingSeasonDate() {
        return harvestingSeasonDate;
    }

    /**
     * @param harvestingSeasonDate the harvestingSeasonDate to set
     */
    public void setHarvestingSeasonDate(Calendar harvestingSeasonDate) {
        this.harvestingSeasonDate = harvestingSeasonDate;
    }

    /**
     * @return the cropSystem
     */
    public String getCropSystem() {
        return cropSystem;
    }

    /**
     * @param cropSystem the cropSystem to set
     */
    public void setCropSystem(String cropSystem) {
        this.cropSystem = cropSystem;
    }

    /**
     * @return the cropSystemId
     */
    public Long getCropSystemId() {
        return cropSystemId;
    }

    /**
     * @param cropSystemId the cropSystemId to set
     */
    public void setCropSystemId(Long cropSystemId) {
        this.cropSystemId = cropSystemId;
    }

    /**
     * @return the resistant
     */
    public String getResistant() {
        return resistant;
    }

    /**
     * @param resistant the resistant to set
     */
    public void setResistant(String resistant) {
        this.resistant = resistant;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return the cropType
     */
    public String getCropType() {
        return cropType;
    }

    /**
     * @param cropType the cropType to set
     */
    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    /**
     * @return the cropTypeId
     */
    public Long getCropTypeId() {
        return cropTypeId;
    }

    /**
     * @param cropTypeId the cropTypeId to set
     */
    public void setCropTypeId(Long cropTypeId) {
        this.cropTypeId = cropTypeId;
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
     * @return the passportNomenclaturalGroupList
     */
    public List<PassportNomenclaturalGroupDTO> getPassportNomenclaturalGroupList() {
        return passportNomenclaturalGroupList;
    }

    /**
     * @param passportNomenclaturalGroupList the passportNomenclaturalGroupList to set
     */
    public void setPassportNomenclaturalGroupList(List<PassportNomenclaturalGroupDTO> passportNomenclaturalGroupList) {
        this.passportNomenclaturalGroupList = passportNomenclaturalGroupList;
    }
}