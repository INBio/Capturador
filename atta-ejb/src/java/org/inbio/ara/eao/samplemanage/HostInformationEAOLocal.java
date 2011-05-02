/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.samplemanage;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.samplemanage.HostInformation;

/**
 *
 * @author dasolano
 */
@Local
public interface HostInformationEAOLocal extends BaseLocalEAO<HostInformation ,Long>{
    
}
