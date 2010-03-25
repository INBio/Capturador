/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germplasm;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.germplasm.PassportNomenclaturalGroup;
import org.inbio.ara.persistence.germplasm.PassportNomenclaturalGroupPK;

/**
 *
 * @author dasolano
 */
public class PassportNomenclaturalGroupDTOFactory extends BaseEntityOrDTOFactory<PassportNomenclaturalGroup ,PassportNomenclaturalGroupDTO>{

    @Override
    public PassportNomenclaturalGroup getEntityWithPlainValues(PassportNomenclaturalGroupDTO dto) {
        PassportNomenclaturalGroup entity = new PassportNomenclaturalGroup();
        PassportNomenclaturalGroupPK newPNGPK =
                new PassportNomenclaturalGroupPK(dto.getPassportId(), dto.getNomenclaturalGroupId());
        entity.setPassportNomenclaturalGroupPK(newPNGPK);

        return entity;
    }

    @Override
    public PassportNomenclaturalGroup updateEntityWithPlainValues(PassportNomenclaturalGroupDTO dto, PassportNomenclaturalGroup e) {
        /*e.getPassportNomenclaturalGroupPK().setNomenclaturalGroupId(
               dto.getNomenclaturalGroupId());
        e.getPassportNomenclaturalGroupPK().setPassportId(
                dto.getPassportId());*/


        throw new UnsupportedOperationException("Not supported yet.");
    }

    public PassportNomenclaturalGroupDTO createDTO(PassportNomenclaturalGroup entity) {
        PassportNomenclaturalGroupDTO pngdto = new PassportNomenclaturalGroupDTO();

        pngdto.setNomenclaturalGroupId(entity.getPassportNomenclaturalGroupPK().
                getNomenclaturalGroupId());
        pngdto.setPassportId(entity.getPassportNomenclaturalGroupPK().
                getPassportId());

        return pngdto;
    }

}