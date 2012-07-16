/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.format;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.format.ReportLayoutCategory;
import org.inbio.ara.persistence.format.ReportLayoutElement;

/**
 *
 * @author pcorrales
 */
public class ReportLayoutElementDTOFactory extends BaseEntityOrDTOFactory<ReportLayoutElement,ReportLayoutElementDTO> {

    @Override
    public ReportLayoutElement getEntityWithPlainValues(ReportLayoutElementDTO dto) {
        
       if(dto == null) return null;

        ReportLayoutElement result = new ReportLayoutElement();
        result.setCreationDate(dto.getInitialDate());
        result.setLastModificationDate(dto.getFinalDate());
        result.setCreatedBy(dto.getUserName());
        result.setDescription(dto.getDescription());
        result.setElementKeyword(dto.getElementKeyWord());
        result.setElementRequired(dto.getElementRequired());
        result.setEntity(dto.getEntity());
        result.setEntityKeyField(dto.getEntityKeyField());
        result.setEntityMainField(dto.getEntityMainField());

        ReportLayoutCategory  category = new ReportLayoutCategory(dto.getLayoutCategoryId());
        result.setReportLayoutCategoryId(category);
        result.setReportLayoutElementId(dto.getReportLayoutElementId());
        result.setReportLayoutElementSequence(dto.getLayoutElementSequence());
        
        return result;
    }

    @Override
    public ReportLayoutElement updateEntityWithPlainValues(ReportLayoutElementDTO dto, ReportLayoutElement e) {

        if(dto == null || e == null) return null;

        ReportLayoutElement result = new ReportLayoutElement();
        result.setCreationDate(dto.getInitialDate());
        result.setLastModificationDate(dto.getFinalDate());
        result.setCreatedBy(dto.getUserName());
        result.setDescription(dto.getDescription());
        result.setElementKeyword(dto.getElementKeyWord());
        result.setElementRequired(dto.getElementRequired());
        result.setEntity(dto.getEntity());
        result.setEntityKeyField(dto.getEntityKeyField());
        result.setEntityMainField(dto.getEntityMainField());

        ReportLayoutCategory  category = new ReportLayoutCategory(dto.getLayoutCategoryId());
        result.setReportLayoutCategoryId(category);
        result.setReportLayoutElementId(dto.getReportLayoutElementId());
        result.setReportLayoutElementSequence(dto.getLayoutElementSequence());

        return result;
    }

    public ReportLayoutElementDTO createDTO(ReportLayoutElement entity) {

       if(entity == null) return null;

       ReportLayoutElementDTO  result = new ReportLayoutElementDTO();
       result.setInitialDate(entity.getCreationDate());
       result.setSelected(false); //Initially must be false
       result.setFinalDate(entity.getLastModificationDate());
       result.setDescription(entity.getDescription());
       result.setElementKeyWord(entity.getElementKeyword());
       result.setElementRequired(entity.getElementRequired());
       result.setEntity(entity.getEntity());
       result.setEntityKeyField(entity.getEntityKeyField());
       result.setFinalDate(entity.getLastModificationDate());
       result.setLayoutCategoryId(entity.getReportLayoutCategoryId().getReportLayoutCategoryId());
       result.setLayoutElementSequence(entity.getReportLayoutElementSequence());
       result.setEntityMainField(entity.getEntityMainField());
       result.setReportLayoutElementId(entity.getReportLayoutElementId());

       return result;
    }

}
