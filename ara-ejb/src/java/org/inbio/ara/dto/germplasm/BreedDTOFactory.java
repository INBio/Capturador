/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germplasm;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.germplasm.Breed;

/**
 *
 * @author dasolano
 */
public class BreedDTOFactory  extends BaseEntityOrDTOFactory<Breed ,BreedDTO>{

    @Override
    public Breed getEntityWithPlainValues(BreedDTO dto) {
        Breed e = new Breed();
        e.setName(dto.getName());
        e.setTaxonId(dto.getTaxonId());
        return e;
    }

    @Override
    public Breed updateEntityWithPlainValues(BreedDTO dto, Breed e) {
        e.setName(dto.getName());
        e.setTaxonId(dto.getTaxonId());
        return e;
    }

    public BreedDTO createDTO(Breed entity) {
        BreedDTO dto = new BreedDTO();
        dto.setBreedId(entity.getBreedId());
        dto.setName(entity.getName());
        dto.setTaxonId(entity.getTaxonId());
        return dto;
    }

}
