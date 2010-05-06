/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germplasm;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.germplasm.Semental;

/**
 *
 * @author dasolano
 */
public class SementalDTOFactory  extends BaseEntityOrDTOFactory<Semental ,SementalDTO>{

    @Override
    public Semental getEntityWithPlainValues(SementalDTO dto) {
        Semental e = new Semental();

        e.setAnimalCode(dto.getAnimalCode());
        e.setAnimalDescription(dto.getAnimalDescription());
        e.setBirthDate(dto.getBirthDate());
        e.setBreedId(dto.getBreedId());
        e.setColor(dto.getColor());
        e.setConditionId(dto.getConditionId());
        e.setFather(dto.getFather());
        e.setMother(dto.getMother());
        e.setName(dto.getName());
        e.setSiteId(dto.getSiteId());
        e.setVeterinarianStatus(dto.getVeterinarianStatus());
        return e;
    }

    @Override
    public Semental updateEntityWithPlainValues(SementalDTO dto, Semental e) {
        e.setAnimalCode(dto.getAnimalCode());
        e.setAnimalDescription(dto.getAnimalDescription());
        e.setBirthDate(dto.getBirthDate());
        e.setBreedId(dto.getBreedId());
        e.setColor(dto.getColor());
        e.setConditionId(dto.getConditionId());
        e.setFather(dto.getFather());
        e.setMother(dto.getMother());
        e.setName(dto.getName());
        e.setSiteId(dto.getSiteId());
        e.setVeterinarianStatus(dto.getVeterinarianStatus());
        return e;
    }

    public SementalDTO createDTO(Semental entity) {
        SementalDTO dto = new SementalDTO();

        dto.setSementalId(entity.getSementalId());
        dto.setAnimalCode(entity.getAnimalCode());
        dto.setAnimalDescription(entity.getAnimalDescription());
        dto.setBirthDate(entity.getBirthDate());
        dto.setBreedId(entity.getBreedId());
        dto.setColor(entity.getColor());
        dto.setConditionId(entity.getConditionId());
        dto.setFather(entity.getFather());
        dto.setMother(entity.getMother());
        dto.setName(entity.getName());
        dto.setSiteId(entity.getSiteId());
        dto.setVeterinarianStatus(entity.getVeterinarianStatus());
        return dto;
    }

}
