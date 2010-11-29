/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.format.impl;

import java.util.List;
import javax.persistence.Query;
import org.inbio.ara.eao.format.*;
import javax.ejb.Stateless;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.dto.format.ReportLayoutDTO;
import org.inbio.ara.persistence.format.ReportLayout;

/**
 *
 * @author pcorrales
 */
@Stateless
public class ReportLayoutEAOImpl extends BaseEAOImpl<ReportLayout,Long> implements ReportLayoutEAOLocal{


    public List<ReportLayoutDTO> getAllReportLayoutByFuncionality(Long funcionalityTypeId) {
        Query query = em.createQuery("select new org.inbio.ara.dto.format.ReportLayoutDTO(i.reportLayoutKeyWord,i.reportLayoutId) from ReportLayout as i");
        return query.getResultList();
    }
 
}
