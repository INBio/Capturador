/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.format;

import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.format.ElementFormat;
import org.inbio.ara.persistence.format.ReportLayout;
import org.inbio.ara.persistence.format.ReportLayoutElement;
import org.inbio.ara.persistence.format.ReportLayoutSelectedElement;

/**
 *
 * @author pcorrales
 */
public class ReportLayoutSelectedElementDTOFactory  extends BaseEntityOrDTOFactory<ReportLayoutSelectedElement,ReportLayoutSelectedElementDTO> {

    @Override
    public ReportLayoutSelectedElement getEntityWithPlainValues(ReportLayoutSelectedElementDTO dto) {
        if(dto == null) return null;

        ReportLayoutSelectedElement result = new ReportLayoutSelectedElement();
        result.setCreationDate(dto.getInitialDate());
        result.setLastModificationDate(dto.getFinalDate());
        result.setCreatedBy(dto.getUserName());
        result.setReportLayoutId(new ReportLayout(dto.getReportLayoutId()));
        result.setReportLayoutElementId( new ReportLayoutElement(dto.getReportLayoutElementId()));
        result.setElementFormatId(new ElementFormat(dto.getElementFormatId()));
        result.setReportLayoutSelectedElementId(dto.getElementFormatId());

        return result;
    }

    @Override
    public ReportLayoutSelectedElement updateEntityWithPlainValues(ReportLayoutSelectedElementDTO dto, ReportLayoutSelectedElement e) {

        if(dto == null || e == null) return null;
        ReportLayoutSelectedElement result = new ReportLayoutSelectedElement();
        result.setCreationDate(dto.getInitialDate());
        result.setLastModificationDate(dto.getFinalDate());
        result.setCreatedBy(dto.getUserName());
        result.setReportLayoutId(new ReportLayout(dto.getReportLayoutId()));
        result.setReportLayoutElementId( new ReportLayoutElement(dto.getReportLayoutElementId()));
        result.setElementFormatId(new ElementFormat(dto.getElementFormatId()));
        result.setReportLayoutSelectedElementId(dto.getElementFormatId());

        return result;


    }

    public ReportLayoutSelectedElementDTO createDTO(ReportLayoutSelectedElement entity) {

       if(entity == null) return null;

      ReportLayoutSelectedElementDTO result = new ReportLayoutSelectedElementDTO();
       result.setInitialDate(entity.getCreationDate());
       result.setSelected(false); //Initially must be false
       result.setFinalDate(entity.getLastModificationDate());
       result.setFinalDate(entity.getLastModificationDate());
       result.setReportLayoutId(entity.getReportLayoutElementId().getReportLayoutElementId());
       result.setReportLayoutElementId(entity.getReportLayoutSelectedElementId());
       result.setElementFormatId(entity.getElementFormatId().getElementFormatId());
       result.setReportLayoutSelectedId(entity.getReportLayoutSelectedElementId());


       return result;
    }

}
