/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.format;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.dto.format.ReportLayoutDTO;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.format.ReportLayout;

/**
 *
 * @author pcorrales
 */

@Local
public interface ReportLayoutEAOLocal extends BaseLocalEAO<ReportLayout,Long>{

public List<ReportLayoutDTO> getAllReportLayoutByFuncionality(Long funcionalityTypeId);
    
}
