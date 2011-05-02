/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.samplemanage;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.samplemanage.EnviromentalData;

/**
 *
 * @author dasolano
 */
public class EnviromentalDataDTOFactory  extends BaseEntityOrDTOFactory<EnviromentalData ,EnviromentalDataDTO>{

    @Override
    public EnviromentalData getEntityWithPlainValues(EnviromentalDataDTO dto) {
        EnviromentalData e = new EnviromentalData();

        e.setHabitat(dto.getHabitat());
        e.setLuminosity(dto.getLuminosity());
        e.setMoisture(dto.getMoisture());
        e.setPh(dto.getPh());
        e.setSalinity(dto.getSalinity());
        e.setSampleId(dto.getSampleId());
        e.setTempeture(dto.getTempeture());
        e.setVegetationTypeId(dto.getVegetationTypeId());
        e.setVerticalStrataId(dto.getVerticalStrataId());

        return e;
    }

    @Override
    public EnviromentalData updateEntityWithPlainValues(EnviromentalDataDTO dto, EnviromentalData e) {

        e.setHabitat(dto.getHabitat());
        e.setLuminosity(dto.getLuminosity());
        e.setMoisture(dto.getMoisture());
        e.setPh(dto.getPh());
        e.setSalinity(dto.getSalinity());
        e.setSampleId(dto.getSampleId());
        e.setTempeture(dto.getTempeture());
        e.setVegetationTypeId(dto.getVegetationTypeId());
        e.setVerticalStrataId(dto.getVerticalStrataId());

        return e;
    }

    public EnviromentalDataDTO createDTO(EnviromentalData entity) {

        EnviromentalDataDTO dto = new EnviromentalDataDTO();

        dto.setHabitat(entity.getHabitat());
        dto.setLuminosity(entity.getLuminosity());
        dto.setMoisture(entity.getMoisture());
        dto.setPh(entity.getPh());
        dto.setSalinity(entity.getSalinity());
        dto.setSampleId(entity.getSampleId());
        dto.setTempeture(entity.getTempeture());
        dto.setVegetationTypeId(entity.getVegetationTypeId());
        dto.setVerticalStrataId(entity.getVerticalStrataId());

        return dto;

    }

}
