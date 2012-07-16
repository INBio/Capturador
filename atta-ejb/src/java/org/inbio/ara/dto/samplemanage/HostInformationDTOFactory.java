/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.samplemanage;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.samplemanage.HostInformation;

/**
 *
 * @author dasolano
 */
public class HostInformationDTOFactory extends BaseEntityOrDTOFactory<HostInformation ,HostInformationDTO>{


    public HostInformation getEntityWithPlainValues(HostInformationDTO dto) {
        HostInformation e = new HostInformation();

        e.setHealthComment(dto.getHealthComment());
        e.setSampleId(dto.getSampleId());
        e.setDiameter(dto.getDiameter());
        e.setTaxonId(dto.getTaxonId());

        return e;
    }

    @Override
    public HostInformation updateEntityWithPlainValues(HostInformationDTO dto, HostInformation e) {
        e.setHealthComment(dto.getHealthComment());
        e.setSampleId(dto.getSampleId());
        e.setDiameter(dto.getDiameter());
        e.setTaxonId(dto.getTaxonId());

        return e;
    }

    public HostInformationDTO createDTO(HostInformation entity) {
        HostInformationDTO dto = new HostInformationDTO();

        dto.setHealthComment(entity.getHealthComment());
        dto.setSampleId(entity.getSampleId());
        dto.setDiameter(entity.getDiameter());
        dto.setTaxonId(entity.getTaxonId());

        return dto;
    }

}
