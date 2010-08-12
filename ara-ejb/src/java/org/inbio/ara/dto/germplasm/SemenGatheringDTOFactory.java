/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germplasm;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.germplasm.SemenGathering;

/**
 *
 * @author dasolano
 */
public class SemenGatheringDTOFactory  extends BaseEntityOrDTOFactory<SemenGathering ,SemenGatheringDTO>{

    @Override
    public SemenGathering getEntityWithPlainValues(SemenGatheringDTO dto) {
        SemenGathering e = new SemenGathering();

        e.setSementalId(dto.getSementalId());
        e.setActiveDoses(dto.getActiveDoses());
        e.setCanisterNumber(dto.getCanisterNumber());
        e.setConcentration(dto.getConcentration());
        e.setSemenConsistencyId(dto.getSemenConsistencyId());
        e.setDilution(dto.getDilution());
        e.setGobletNumber(dto.getGobletNumber());
        e.setMassMotility(dto.getMassMotility());
        e.setMotility(dto.getMotility());
        e.setPh(dto.getPh());
        e.setPostThawMotility(dto.getPostThawMotility());
        e.setSemenColor(dto.getSemenColor());
        e.setSemenGatheringDate(dto.getSemenGatheringDate());
        e.setSemenGatheringTime(dto.getSemenGatheringTime());
        e.setSemenGatheringMethodId(dto.getSemenGatheringMethodId());
        e.setSolventId(dto.getSolventId());
        e.setStrawColor(dto.getStrawColor());
        e.setStrawQuantity(dto.getStrawQuantity());
        e.setCurrentStrawQuantity(dto.getCurrentStrawQuantity());
        e.setStrawSize(dto.getStrawSize());
        e.setTankNumber(dto.getTankNumber());
        e.setVolume(dto.getVolume());


        return e;
    }

    @Override
    public SemenGathering updateEntityWithPlainValues(SemenGatheringDTO dto, SemenGathering e) {

        e.setActiveDoses(dto.getActiveDoses());
        e.setCanisterNumber(dto.getCanisterNumber());
        e.setConcentration(dto.getConcentration());
        e.setSemenConsistencyId(dto.getSemenConsistencyId());
        e.setDilution(dto.getDilution());
        e.setGobletNumber(dto.getGobletNumber());
        e.setMassMotility(dto.getMassMotility());
        e.setMotility(dto.getMotility());
        e.setPh(dto.getPh());
        e.setPostThawMotility(dto.getPostThawMotility());
        e.setSemenColor(dto.getSemenColor());
        e.setSemenGatheringDate(dto.getSemenGatheringDate());
        e.setSemenGatheringTime(dto.getSemenGatheringTime());
        e.setSemenGatheringMethodId(dto.getSemenGatheringMethodId());
        e.setSolventId(dto.getSolventId());
        e.setStrawSize(dto.getStrawSize());
        e.setStrawColor(dto.getStrawColor());
        e.setStrawQuantity(dto.getStrawQuantity());
        e.setCurrentStrawQuantity(dto.getCurrentStrawQuantity());
        e.setTankNumber(dto.getTankNumber());
        e.setVolume(dto.getVolume());


        return e;
    }

    public SemenGatheringDTO createDTO(SemenGathering entity) {
        SemenGatheringDTO dto = new SemenGatheringDTO();

        dto.setSemenGatheringId(entity.getSemenGatheringId());
        dto.setSementalId(entity.getSementalId());
        dto.setActiveDoses(entity.getActiveDoses());
        dto.setCanisterNumber(entity.getCanisterNumber());
        dto.setConcentration(entity.getConcentration());
        dto.setSemenConsistencyId(entity.getSemenConsistencyId());
        dto.setDilution(entity.getDilution());
        dto.setGobletNumber(entity.getGobletNumber());
        dto.setMassMotility(entity.getMassMotility());
        dto.setMotility(entity.getMotility());
        dto.setPh(entity.getPh());
        dto.setPostThawMotility(entity.getPostThawMotility());
        dto.setSemenColor(entity.getSemenColor());
        dto.setSemenGatheringDate(entity.getSemenGatheringDate());
        dto.setSemenGatheringTime(entity.getSemenGatheringTime());
        dto.setSemenGatheringMethodId(entity.getSemenGatheringMethodId());
        dto.setStrawSize(entity.getStrawSize());
        dto.setSolventId(entity.getSolventId());
        dto.setStrawColor(entity.getStrawColor());
        dto.setStrawQuantity(entity.getStrawQuantity());
        dto.setCurrentStrawQuantity(entity.getCurrentStrawQuantity());
        dto.setTankNumber(entity.getTankNumber());
        dto.setVolume(entity.getVolume());


        return dto;
    }

}
