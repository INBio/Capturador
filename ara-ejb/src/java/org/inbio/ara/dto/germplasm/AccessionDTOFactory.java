/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germplasm;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.germplasm.Accession;

/**
 *
 * @author dasolano
 */
public class AccessionDTOFactory extends BaseEntityOrDTOFactory<Accession ,AccessionDTO>{

    @Override
    public Accession getEntityWithPlainValues(AccessionDTO dto) {

        if(dto==null){
            return null;
        }
        
        Accession entity = new Accession();
        entity.setAccessionNumber(dto.getAccessionNumber());
        entity.setAccessionParentId(dto.getAccessionParentId());
        entity.setCollectionTypeId(dto.getCollectionTypeId());
        entity.setCurrentWeigth(dto.getCurrentWeigth());
        entity.setGerminationDate(dto.getGerminationDate());
        entity.setGerminationMethodTypeId(dto.getGerminationMethodTypeId());
        entity.setGerminationRate(dto.getGerminationRate());
        entity.setGerminationViability(dto.getGerminationViability());
        entity.setLocation(dto.getLocation());
        entity.setMoisture(dto.getMoisture());
        entity.setMoistureMethodTypeId(dto.getMoistureMethodTypeId());
        entity.setMultiplicationRegeneration(dto.getMultiplicationRegeneration());
        entity.setNotes(dto.getNotes());
        entity.setOriginalWeigth(dto.getOriginalWeigth());
        entity.setPackages(dto.getPackages());
        entity.setPassportId(dto.getPassportId());
        entity.setResponsablePersonId(dto.getResponsablePersonId());
        entity.setStorageDate(dto.getStorageDate());
        
        return entity;

    }

    @Override
    public Accession updateEntityWithPlainValues(AccessionDTO dto, Accession e) {

        e.setAccessionNumber(dto.getAccessionNumber());
        e.setAccessionParentId(dto.getAccessionParentId());
        e.setCollectionTypeId(dto.getCollectionTypeId());
        e.setGerminationDate(dto.getGerminationDate());
        e.setGerminationMethodTypeId(dto.getGerminationMethodTypeId());
        e.setGerminationRate(dto.getGerminationRate());
        e.setGerminationViability(dto.getGerminationViability());
        e.setLocation(dto.getLocation());
        e.setMoisture(dto.getMoisture());
        e.setMoistureMethodTypeId(dto.getMoistureMethodTypeId());
        e.setMultiplicationRegeneration(dto.getMultiplicationRegeneration());
        e.setNotes(dto.getNotes());
        e.setPackages(dto.getPackages());
        e.setPassportId(dto.getPassportId());
        e.setResponsablePersonId(dto.getResponsablePersonId());
        e.setStorageDate(dto.getStorageDate());
        e.setOriginalWeigth(dto.getOriginalWeigth());

        return e;
    }

    public AccessionDTO createDTO(Accession entity) {
        AccessionDTO accessionDTO = new AccessionDTO();

        accessionDTO.setAccessionId(entity.getAccessionId());
        accessionDTO.setAccessionNumber(entity.getAccessionNumber());
        accessionDTO.setAccessionParentId(entity.getAccessionParentId());
        accessionDTO.setCollectionTypeId(entity.getCollectionTypeId());
        accessionDTO.setCurrentWeigth(entity.getCurrentWeigth());
        accessionDTO.setGerminationDate(entity.getGerminationDate());
        accessionDTO.setGerminationMethodTypeId(entity.getGerminationMethodTypeId());
        accessionDTO.setGerminationRate(entity.getGerminationRate());
        accessionDTO.setGerminationViability(entity.getGerminationViability());
        accessionDTO.setLocation(entity.getLocation());
        accessionDTO.setMoisture(entity.getMoisture());
        accessionDTO.setMultiplicationRegeneration(entity.getMultiplicationRegeneration());
        accessionDTO.setNotes(entity.getNotes());
        accessionDTO.setOriginalWeigth(entity.getOriginalWeigth());
        accessionDTO.setPackages(entity.getPackages());
        accessionDTO.setPassportId(entity.getPassportId());
        accessionDTO.setResponsablePersonId(entity.getResponsablePersonId());
        accessionDTO.setStorageDate(entity.getStorageDate());

        return accessionDTO;
    }

}
