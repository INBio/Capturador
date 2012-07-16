/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 *
 * @author gsulca
 */
public class SynonymDTOFactory extends BaseEntityOrDTOFactory<Taxon,SynonymDTO>{

    @Override
    public Taxon getEntityWithPlainValues(SynonymDTO dto) {
         if(dto==null){
            return null;
        }

        Taxon taxon = new Taxon();
        taxon.setTaxonId(dto.getTaxonKey());
        taxon.setCurrentName(dto.getCurrentName());
        taxon.setDefaultName(dto.getDefaultName());

        return taxon;
    }

    @Override
    public Taxon updateEntityWithPlainValues(SynonymDTO dto, Taxon entity) {
        if(dto == null || entity == null)
        {
            return null;
        }
        else
        {
            entity.setTaxonId(dto.getTaxonKey());
            entity.setCurrentName(dto.getCurrentName());
            entity.setDefaultName(dto.getDefaultName());

            return entity;
        }
    }

    public SynonymDTO createDTO(Taxon entity) {
        SynonymDTO synonymDTO = new SynonymDTO();
        synonymDTO.setTaxonKey(entity.getTaxonId());
        synonymDTO.setCurrentName(entity.getCurrentName());
        synonymDTO.setDefaultName(entity.getDefaultName());
        return synonymDTO;
    }

}
