/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.format;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.format.ReportLayoutElement;
import org.inbio.ara.persistence.format.ReportLayoutElementFormat;
import org.inbio.ara.persistence.format.ReportLayoutElementFormatPK;

/**
 *
 * @author pcorrales
 */
public class ReportLayoutElementFormatDTOFactory extends BaseEntityOrDTOFactory<ReportLayoutElementFormat,ReportLayoutElementFormatDTO> {

    @Override
    public ReportLayoutElementFormat getEntityWithPlainValues(ReportLayoutElementFormatDTO dto) {
        
        if(dto == null) return null;

        ReportLayoutElementFormat result = new ReportLayoutElementFormat();
        result.setCreationDate(dto.getInitialDate());
        result.setLastModificationDate(dto.getFinalDate());
        result.setCreatedBy(dto.getUserName());
        result.setReportLayoutElement(new ReportLayoutElement(dto.getReportLayoutElementId()));
        result.setReportLayoutElementFormatPK(new ReportLayoutElementFormatPK(dto.getElementFormatId(),dto.getReportLayoutElementId()));
      
        return result;
    }

    @Override
    public ReportLayoutElementFormat updateEntityWithPlainValues(ReportLayoutElementFormatDTO dto, ReportLayoutElementFormat e) {
         if(dto == null || e == null) return null;

            ReportLayoutElementFormat result = new ReportLayoutElementFormat();
            result.setCreationDate(dto.getInitialDate());
            result.setLastModificationDate(dto.getFinalDate());
            result.setCreatedBy(dto.getUserName());
            result.setReportLayoutElement(new ReportLayoutElement(dto.getReportLayoutElementId()));
            result.setReportLayoutElementFormatPK(new ReportLayoutElementFormatPK(dto.getElementFormatId(),dto.getReportLayoutElementId()));

            return result;

    }

    public ReportLayoutElementFormatDTO createDTO(ReportLayoutElementFormat entity) {
         if(entity == null) return null;

           ReportLayoutElementFormatDTO result = new ReportLayoutElementFormatDTO();
           result.setInitialDate(entity.getCreationDate());
           result.setSelected(false); //Initially must be false
           result.setFinalDate(entity.getLastModificationDate());
           result.setFinalDate(entity.getLastModificationDate());
           result.setReportLayoutElementId(entity.getReportLayoutElement().getReportLayoutElementId());
           result.setElementFormatId(entity.getReportLayoutElementFormatPK().getElementFormatId());


       return result;
    }

}
