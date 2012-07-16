/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.format;

import java.util.GregorianCalendar;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.format.FuncionalityType;

/**
 *
 * @author pcorrales
 */

public class FuncionalityTypeDTOFactory extends BaseEntityOrDTOFactory<FuncionalityType,FuncionalityTypeDTO>{


    @Override
    public FuncionalityType getEntityWithPlainValues(FuncionalityTypeDTO dto) {

        FuncionalityType result = new FuncionalityType();
        result.setDescription(dto.getDescription());
        result.setFuncionalityTypeKeyword(dto.getFuncionalityTypeKeyWord());
        result.setCreatedBy(dto.getUserName());
        result.setFuncionalityTypeId(dto.getFuncionalityTypeId());
        result.setLastModificationDate(new GregorianCalendar());
        return result;
    }

    @Override
    public FuncionalityType updateEntityWithPlainValues(FuncionalityTypeDTO dto, FuncionalityType e) {
        
        FuncionalityType result = new FuncionalityType();
        result.setDescription(dto.getDescription());
        result.setFuncionalityTypeKeyword(dto.getFuncionalityTypeKeyWord());
        result.setCreatedBy(dto.getUserName());
        result.setFuncionalityTypeId(dto.getFuncionalityTypeId());
        result.setLastModificationDate(new GregorianCalendar());
        return result;
    }

    public FuncionalityTypeDTO createDTO(FuncionalityType entity) {

        FuncionalityTypeDTO result = new FuncionalityTypeDTO();
        result.setDescription(entity.getDescription());
        result.setFuncionalityTypeKeyWord(entity.getFuncionalityTypeKeyword());
        result.setFuncionalityTypeId(entity.getFuncionalityTypeId());
        result.setSelected(false); //Initially must be false
        result.setFinalTimestand(entity.getLastModificationDate());
        return result;
    }

}
