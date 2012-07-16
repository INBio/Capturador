/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import java.util.Calendar;
import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
import org.inbio.ara.persistence.gathering.MorphologicalDescription;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author esmata
 */
public class GatheringObservationDetailDTOFactory extends BaseDTOFactory<GatheringObservationDetail, GatheringObservationDetailDTO> {

    public GatheringObservationDetailDTO createDTO(GatheringObservationDetail entity) {
        if(entity==null)
            return null;
        GatheringObservationDetailDTO godDTO = new GatheringObservationDetailDTO();

        godDTO.setGatheringObservationDetailId(entity.getGatheringObservationDetailId());

        Person colector = entity.getGatheringObservationDetailPerson();
        if(colector!=null){
            godDTO.setGatheringObservationDetailPersonId(colector.getPersonId());
            godDTO.setGatheringObservationDetailPersonName(colector.getNaturalFullName());
        }
        
        godDTO.setGatheringObservationDetailNumber(entity.getGatheringObservationDetailNumber());

        godDTO.setCollectionId(entity.getCollectionId());

        godDTO.setGatheringObservationId(entity.getGatheringObservationId());

        MorphologicalDescription md = entity.getMorphologicalDescription();
        if(md!=null){
            godDTO.setMorphologicalDescriptionId(md.getMorphologicalDescriptionId());
            godDTO.setMorphologicalContents(md.getContents());
            godDTO.setDescriptionDate(md.getDescriptionDate());
            Person descriptor = md.getDescriptionPerson();
            if(descriptor!=null){
                godDTO.setDescriptorId(descriptor.getPersonId());
            }
        }

        godDTO.setSelected(false); //Inicialmente debe ser falso

        return godDTO;
    }

    public GatheringObservationDetail createEntity(GatheringObservationDetailDTO gdDTO){
        if(gdDTO==null)
            return null;

        GatheringObservationDetail result = new GatheringObservationDetail();

        result.setGatheringObservationDetailId(gdDTO.getGatheringObservationDetailId());

        Long colectorId = gdDTO.getGatheringObservationDetailPersonId();
        if(colectorId!=null){
            Person colector = new Person();
            colector.setPersonId(colectorId);
            result.setGatheringObservationDetailPerson(colector);
        }

        result.setGatheringObservationDetailNumber(gdDTO.getGatheringObservationDetailNumber());

        result.setCollectionId(gdDTO.getCollectionId());

        result.setGatheringObservationId(gdDTO.getGatheringObservationId());

        return result;
    }

    public MorphologicalDescription createMorphologicalDescription(GatheringObservationDetailDTO gdDTO){
        if(gdDTO==null)
            return null;

        MorphologicalDescription result = new MorphologicalDescription();

        String contents = gdDTO.getMorphologicalContents();
        Long id = gdDTO.getMorphologicalDescriptionId();
        Calendar date = gdDTO.getDescriptionDate();
        Long aux = gdDTO.getDescriptorId();

        result.setMorphologicalDescriptionId(id);
        result.setContents(contents);
        result.setDescriptionDate(date);
        
        if(aux!=null){
            Person descriptor = new Person();
            descriptor.setPersonId(aux);
            result.setDescriptionPerson(descriptor);
        }

        return result;
    }

}
