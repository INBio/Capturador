/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.label;

import java.util.GregorianCalendar;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.label.LabelHistory;
import org.inbio.ara.persistence.label.LabelHistoryPK;

/**
 *
 * @author paulacorrales
 */
public class HistoryLabelDTOFactory  extends BaseEntityOrDTOFactory<LabelHistory,HistoryLabelDTO>{

    @Override
    public LabelHistory getEntityWithPlainValues(HistoryLabelDTO dto) {
        if(dto == null) return null;

        LabelHistoryPK primaryKey =  new LabelHistoryPK(dto.getLabelId(),new GregorianCalendar());
        LabelHistory  result = new LabelHistory (primaryKey);
        
        result.setFinalDate(new GregorianCalendar());
        result.setContents(dto.getContents());
        result.setCreatedBy(dto.getUserName());
        result.setAncestorLabelId(dto.getAncestorLabelId());
       
        return result;
    }

    @Override
    public LabelHistory updateEntityWithPlainValues(HistoryLabelDTO dto, LabelHistory e) {
        if(dto == null || e == null) return null;

        LabelHistoryPK primaryKey =  new LabelHistoryPK(dto.getLabelId(),new GregorianCalendar());
        primaryKey.setInitialDate(dto.getInitialTimestand());
        primaryKey.setLabelId(dto.getLabelId());
        
        e.setContents(dto.getContents());
        e.setFinalDate(new GregorianCalendar());
        e.setCreatedBy(dto.getUserName());
        e.setLabelHistoryPK(primaryKey);
        e.setAncestorLabelId(dto.getAncestorLabelId());
        return e;
    }

    public HistoryLabelDTO createDTO(LabelHistory entity) {
        if(entity == null) return null;

        HistoryLabelDTO result = new  HistoryLabelDTO ();
        
        result.setSelected(false); //Initially must be false
        result.setContents(entity.getContents());
        result.setUserName(entity.getCreatedBy());
        result.setInitialTimestand(entity.getLabelHistoryPK().getInitialDate());
        result.setLabelId(entity.getLabelHistoryPK().getLabelId());
        result.setFinalTimestand(entity.getFinalDate());
        result.setAncestorLabelId(entity.getAncestorLabelId());
        return result;
    }
}