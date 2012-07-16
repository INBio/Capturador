/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.format;

import java.util.GregorianCalendar;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.format.ElementFormat;

/**
 *
 * @author pcorrales
 */
public class ElementFormatDTOFactory extends BaseEntityOrDTOFactory<ElementFormat,ElementFormatDTO>{

    @Override
    public ElementFormat getEntityWithPlainValues(ElementFormatDTO dto) {

        if(dto == null) return null;

        ElementFormat result = new ElementFormat();
        result.setElementFormatId(dto.getElementFormatId());
        result.setElementFormatKeyword(dto.getFormatKeyWord());
        result.setLastModificationDate(new GregorianCalendar());
        result.setLastModificationBy(dto.getUserName());
        return result;
    }

    @Override
    public ElementFormat updateEntityWithPlainValues(ElementFormatDTO dto, ElementFormat e) {

        if(dto == null || e == null) return null;

        e.setElementFormatId(dto.getElementFormatId());
        e.setElementFormatKeyword(dto.getFormatKeyWord());
        e.setCreatedBy(dto.getUserName());
        e.setLastModificationDate(new GregorianCalendar());
        e.setCreationDate(dto.getInitialDate());
        return e;
    }

    @Override
    public ElementFormatDTO createDTO(ElementFormat entity) {

        if(entity == null) return null;
        
        ElementFormatDTO result = new ElementFormatDTO();
        result.setSelected(false);
        result.setElementFormatId(entity.getElementFormatId());
        result.setFormatKeyWord(entity.getElementFormatKeyword());
        result.setUserName(entity.getCreatedBy());
        result.setInitialDate(entity.getCreationDate());
        result.setFinalDate(entity.getLastModificationDate());
        return result;

   }
}
