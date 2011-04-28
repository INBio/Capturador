/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package org.inbio.ara.dto.samplemanage;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.samplemanage.Sample;

/**
 *
 * @author dasolano
 */
public class SampleDTOFactory  extends BaseEntityOrDTOFactory<Sample ,SampleDTO>{

    @Override
    public Sample getEntityWithPlainValues(SampleDTO dto) {
        Sample e = new Sample();
        e.setDescription(dto.getDescription());
        e.setGatheringDate(dto.getGatheringDate());
        e.setReceptionDate(dto.getReceptionDate());
        e.setGatheringObservationId(dto.getGatheringObservationId());
        e.setMicroFomeId(dto.getMicroFomeId());
        e.setMicroMethodId(dto.getMicroMethodId());
        e.setMicroQualityId(dto.getMicroQualityId());
        e.setMicroSourceTypeId(dto.getMicroSourceTypeId());
        e.setPermissionId(dto.getPermissionId());
        e.setSampleAltitude(dto.getSampleAltitude());
        e.setSampleClassId(dto.getSampleClassId());
        e.setPh(dto.getPh());
        e.setTempeture(dto.getTempeture());
        e.setSalinity(dto.getSalinity());
        e.setSiteId(dto.getSiteId());
        e.setTaxonId(dto.getTaxonId());
        e.setWitness(dto.getWitness());
       
        return e;
    }

    @Override
    public Sample updateEntityWithPlainValues(SampleDTO dto, Sample e) {
        e.setDescription(dto.getDescription());
        e.setGatheringDate(dto.getGatheringDate());
        e.setReceptionDate(dto.getReceptionDate());
        e.setGatheringObservationId(dto.getGatheringObservationId());
        e.setMicroFomeId(dto.getMicroFomeId());
        e.setMicroMethodId(dto.getMicroMethodId());
        e.setMicroQualityId(dto.getMicroQualityId());
        e.setMicroSourceTypeId(dto.getMicroSourceTypeId());
        e.setPermissionId(dto.getPermissionId());
        e.setSampleAltitude(dto.getSampleAltitude());
        e.setSampleClassId(dto.getSampleClassId());
        e.setPh(dto.getPh());
        e.setTempeture(dto.getTempeture());
        e.setSalinity(dto.getSalinity());
        e.setSiteId(dto.getSiteId());
        e.setTaxonId(dto.getTaxonId());
        e.setWitness(dto.getWitness());

        return e;
    }

    public SampleDTO createDTO(Sample entity) {
        SampleDTO dto = new SampleDTO();
        dto.setDescription(entity.getDescription());
        dto.setGatheringDate(entity.getGatheringDate());
        dto.setReceptionDate(entity.getReceptionDate());
        dto.setGatheringObservationId(entity.getGatheringObservationId());
        dto.setMicroFomeId(entity.getMicroFomeId());
        dto.setMicroMethodId(entity.getMicroMethodId());
        dto.setMicroQualityId(entity.getMicroQualityId());
        dto.setMicroSourceTypeId(entity.getMicroSourceTypeId());
        dto.setPermissionId(entity.getPermissionId());
        dto.setSampleAltitude(entity.getSampleAltitude());
        dto.setSampleClassId(entity.getSampleClassId());
        dto.setPh(entity.getPh());
        dto.setTempeture(entity.getTempeture());
        dto.setSalinity(entity.getSalinity());
        dto.setSiteId(entity.getSiteId());
        dto.setTaxonId(entity.getTaxonId());
        dto.setWitness(entity.getWitness());

        return dto;
    }

}
