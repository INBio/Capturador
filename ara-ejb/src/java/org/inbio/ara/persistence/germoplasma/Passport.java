/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germoplasma;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "passport")
public class Passport extends LogGenericEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="passport")
    @SequenceGenerator(name="passport", sequenceName="passport_seq")
    @Basic(optional = false)
    @Column(name = "passport_id")
    private Long passportId;

    
    @Column(name = "donor_person_id")
    private Long donorPersonId;

    
    @Column(name = "donor_institution_id")
    private Long donorInstitutionId;

    @Column(name = "gathering_id")
    private Long gatheringId;

    
    @Basic(optional = false)
    @Column(name = "material_type_id")
    private Long materialTypeId;

    
    @Column(name = "sample_status_id")
    private Long sampleStatusId;

    
    @Column(name = "gathering_source_id")
    private Long gatheringSourceId;

    @Column(name = "mission_number")
    private Long missionNumber;

    
    @Column(name = "soil_color_id")
    private Long soilColorId;

    
    @Column(name = "soil_texture_id")
    private Long soilTextureId;

    
    @Column(name = "cultivation_practice_id")
    private Long cultivationPracticeId;

    @Column(name = "plant_nursery_date")
    @Temporal(TemporalType.DATE)
    private Calendar plantNurseryDate;

    @Column(name = "planting_season_date")
    @Temporal(TemporalType.DATE)
    private Calendar plantingSeasonDate;

    @Column(name = "harvesting_season_date")
    @Temporal(TemporalType.DATE)
    private Calendar harvestingSeasonDate;

    
    @Column(name = "crop_system_id")
    private Long cropSystemId;

    @Column(name = "resistant")
    private String resistant;

    @Column(name = "remarks")
    private String remarks;

    
    @Column(name = "crop_type_id")
    private Long cropTypeId;

    @Column(name = "taxon_id")
    private Long taxonId;

    public Passport() {
    }

    public Passport(Long passportId) {
        this.passportId = passportId;
    }

    public Passport(Long passportId, Long materialTypeId, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.passportId = passportId;
        this.materialTypeId = materialTypeId;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public Long getDonorPersonId() {
        return donorPersonId;
    }

    public void setDonorPersonId(Long donorPersonId) {
        this.donorPersonId = donorPersonId;
    }

    public Long getDonorInstitutionId() {
        return donorInstitutionId;
    }

    public void setDonorInstitutionId(Long donorInstitutionId) {
        this.donorInstitutionId = donorInstitutionId;
    }

    public Long getGatheringId() {
        return gatheringId;
    }

    public void setGatheringId(Long gatheringId) {
        this.gatheringId = gatheringId;
    }

    public Long getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Long materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public Long getSampleStatusId() {
        return sampleStatusId;
    }

    public void setSampleStatusId(Long sampleStatusId) {
        this.sampleStatusId = sampleStatusId;
    }

    public Long getGatheringSourceId() {
        return gatheringSourceId;
    }

    public void setGatheringSourceId(Long gatheringSourceId) {
        this.gatheringSourceId = gatheringSourceId;
    }

    public Long getMissionNumber() {
        return missionNumber;
    }

    public void setMissionNumber(Long missionNumber) {
        this.missionNumber = missionNumber;
    }

    public Long getSoilColorId() {
        return soilColorId;
    }

    public void setSoilColorId(Long soilColorId) {
        this.soilColorId = soilColorId;
    }

    public Long getSoilTextureId() {
        return soilTextureId;
    }

    public void setSoilTextureId(Long soilTextureId) {
        this.soilTextureId = soilTextureId;
    }

    public Long getCultivationPracticeId() {
        return cultivationPracticeId;
    }

    public void setCultivationPracticeId(Long cultivationPracticeId) {
        this.cultivationPracticeId = cultivationPracticeId;
    }

    public Calendar getPlantNurseryDate() {
        return plantNurseryDate;
    }

    public void setPlantNurseryDate(Calendar plantNurseryDate) {
        this.plantNurseryDate = plantNurseryDate;
    }

    public Calendar getPlantingSeasonDate() {
        return plantingSeasonDate;
    }

    public void setPlantingSeasonDate(Calendar plantingSeasonDate) {
        this.plantingSeasonDate = plantingSeasonDate;
    }

    public Calendar getHarvestingSeasonDate() {
        return harvestingSeasonDate;
    }

    public void setHarvestingSeasonDate(Calendar harvestingSeasonDate) {
        this.harvestingSeasonDate = harvestingSeasonDate;
    }

    public Long getCropSystemId() {
        return cropSystemId;
    }

    public void setCropSystemId(Long cropSystemId) {
        this.cropSystemId = cropSystemId;
    }

    public String getResistant() {
        return resistant;
    }

    public void setResistant(String resistant) {
        this.resistant = resistant;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getCropTypeId() {
        return cropTypeId;
    }

    public void setCropTypeId(Long cropTypeId) {
        this.cropTypeId = cropTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (passportId != null ? passportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passport)) {
            return false;
        }
        Passport other = (Passport) object;
        if ((this.passportId == null && other.passportId != null) || (this.passportId != null && !this.passportId.equals(other.passportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.Passport[passportId=" + passportId + "]";
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



}