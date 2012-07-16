/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.format;

import java.util.GregorianCalendar;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.format.FuncionalityType;
import org.inbio.ara.persistence.format.ReportLayout;

/**
 *
 * @author pcorrales
 */
public class ReportLayoutDTOFactory  extends BaseEntityOrDTOFactory<ReportLayout,ReportLayoutDTO>{
    
 @Override
    public ReportLayout getEntityWithPlainValues(ReportLayoutDTO dto) {
         if(dto == null) return null;

        ReportLayout result = new ReportLayout();
        result.setReportLayoutId(dto.getReportLayoutId());
        result.setContents(dto.getContents());
        result.setDescription(dto.getDescription());
        result.setReportLayoutKeyWord(dto.getReportLayoutkeyWord());
        result.setCreatedBy(dto.getUserName());
        result.setFuncionalityTypeId( new FuncionalityType(dto.getFuncionalityTypeId()));
        result.setLastModificationDate(new GregorianCalendar());
        return result;
    }

    @Override
    public ReportLayout updateEntityWithPlainValues(ReportLayoutDTO dto, ReportLayout e) {
        if(dto == null || e == null) return null;

        e.setReportLayoutId(dto.getReportLayoutId());
        e.setContents(dto.getContents());
        e.setReportLayoutKeyWord(dto.getReportLayoutkeyWord());
        e.setDescription(dto.getDescription());
        e.setCreatedBy(dto.getUserName());
        e.setFuncionalityTypeId( new FuncionalityType(dto.getFuncionalityTypeId()));
        e.setLastModificationDate(new GregorianCalendar());
        return e;
    }


    /**
     * create the LabelDTO with the information of entity label
     * @param entity
     * @return
     */
    public ReportLayoutDTO createDTO(ReportLayout entity) {
          if(entity == null) return null;

            ReportLayoutDTO result = new ReportLayoutDTO();
            result.setReportLayoutId(entity.getReportLayoutId());
            result.setContents(entity.getContents());
            result.setDescription(entity.getDescription());
            result.setReportLayoutkeyWord(entity.getReportLayoutKeyWord());
            result.setFuncionalityTypeId(entity.getFuncionalityTypeId().getFuncionalityTypeId());
            result.setSelected(false); //Initially must be false
            result.setFinalTimestand(entity.getLastModificationDate());
        return result;
    }


}
