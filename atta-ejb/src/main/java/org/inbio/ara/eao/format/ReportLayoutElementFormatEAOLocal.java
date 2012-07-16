/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.format;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.format.ReportLayoutElementFormat;

/**
 *
 * @author pcorrales
 */
@Local
public interface ReportLayoutElementFormatEAOLocal extends BaseLocalEAO<ReportLayoutElementFormat,Long> {
    
}
