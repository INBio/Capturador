/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.format;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.format.ReportLayoutCategory;

/**
 *
 * @author pcorrales
 */
public class ReportLayoutCategoryDTOFactory extends BaseEntityOrDTOFactory<ReportLayoutCategory,ReportLayoutCategoryDTO>{

    @Override
    public ReportLayoutCategory getEntityWithPlainValues(ReportLayoutCategoryDTO dto) {

            if(dto == null) return null;

            ReportLayoutCategory result = new ReportLayoutCategory();
            result.setLastModificationBy(dto.getUserName());
            result.setLastModificationDate(dto.getFinalDate());
            result.setCategoryKeyword(dto.getCategoryKeyword());
            result.setCreationDate(dto.getInitialDate());
            result.setDescription(dto.getDescription());
            result.setReportLayoutCategoryId(dto.getReportLayoutCategoryId());

            return result;
    }

    @Override
    public ReportLayoutCategory updateEntityWithPlainValues(ReportLayoutCategoryDTO dto, ReportLayoutCategory e) {
        
        if(dto == null || e == null) return null;

         ReportLayoutCategory result = new ReportLayoutCategory();
         result.setLastModificationBy(dto.getUserName());
         result.setLastModificationDate(dto.getFinalDate());
         result.setCategoryKeyword(dto.getCategoryKeyword());
         result.setCreationDate(dto.getInitialDate());
         result.setDescription(dto.getDescription());
         result.setReportLayoutCategoryId(dto.getReportLayoutCategoryId());

         return result;
    }

    public ReportLayoutCategoryDTO createDTO(ReportLayoutCategory entity) {
        
       if(entity == null) return null;

       ReportLayoutCategoryDTO result = new ReportLayoutCategoryDTO();
       result.setInitialDate(entity.getCreationDate());
       result.setSelected(false); //Initially must be false
       result.setFinalDate(entity.getLastModificationDate());
       result.setDescription(entity.getDescription());
       result.setReportLayoutCategoryId(entity.getReportLayoutCategoryId());
       return result;
    }

}
