/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germoplasma;


import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.germoplasma.Passport;

/**
 *
 * @author dasolano
 */
public class PassportDTOFactory extends BaseEntityOrDTOFactory<Passport ,PassportDTO>{

    public PassportDTO createDTO(Passport entity) {
        PassportDTO passportDTO = new PassportDTO();
        passportDTO.setCropSystemId(entity.getCropSystemId());
        passportDTO.setCropTypeId(entity.getCropTypeId());
        passportDTO.setCultivationPracticeId(entity.getCultivationPracticeId());
        passportDTO.setDonorInstitutionId(entity.getDonorInstitutionId());
        passportDTO.setDonorPersonId(entity.getDonorPersonId());
        passportDTO.setGatheringSourceId(entity.getGatheringSourceId());
        passportDTO.setGatheringId(entity.getGatheringId());
        passportDTO.setHarvestingSeasonDate(entity.getHarvestingSeasonDate());
        passportDTO.setMaterialTypeId(entity.getMaterialTypeId());
        passportDTO.setMissionNumber(entity.getMissionNumber());
        passportDTO.setPassportId(entity.getPassportId());
        passportDTO.setPlantNurseryDate(entity.getPlantNurseryDate());
        passportDTO.setPlantingSeasonDate(entity.getPlantingSeasonDate());
        passportDTO.setRemarks(entity.getRemarks());
        passportDTO.setResistant(entity.getResistant());
        passportDTO.setSampleStatusId(entity.getSampleStatusId());
        passportDTO.setSoilColorId(entity.getSoilColorId());
        passportDTO.setSoilTextureId(entity.getSoilTextureId());
        passportDTO.setTaxonId(entity.getTaxonId());

        return passportDTO;
    }


    @Override
    public Passport getEntityWithPlainValues(PassportDTO dto) {
        if(dto==null){
            return null;
        }
        Passport passport = new Passport();

        passport.setCropSystemId(dto.getCropSystemId());
        passport.setCropTypeId(dto.getCropTypeId());
        passport.setCultivationPracticeId(dto.getCultivationPracticeId());
        passport.setDonorInstitutionId(dto.getDonorInstitutionId());
        passport.setDonorPersonId(dto.getDonorPersonId());
        passport.setGatheringId(dto.getGatheringId());
        passport.setGatheringSourceId(dto.getGatheringSourceId());
        passport.setHarvestingSeasonDate(dto.getHarvestingSeasonDate());
        passport.setMaterialTypeId(dto.getMaterialTypeId());
        passport.setMissionNumber(dto.getMissionNumber());
        passport.setPlantNurseryDate(dto.getPlantNurseryDate());
        passport.setPlantingSeasonDate(dto.getPlantingSeasonDate());
        passport.setRemarks(dto.getRemarks());
        passport.setResistant(dto.getResistant());
        passport.setSampleStatusId(dto.getSampleStatusId());
        passport.setSoilColorId(dto.getSoilColorId());
        passport.setSoilTextureId(dto.getSoilTextureId());
        passport.setTaxonId(dto.getTaxonId());


        return passport;
    }

    @Override
    public Passport updateEntityWithPlainValues(PassportDTO dto, Passport e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}