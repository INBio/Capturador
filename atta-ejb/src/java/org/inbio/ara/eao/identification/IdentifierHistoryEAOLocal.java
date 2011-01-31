/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.identification;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.identification.IdentifierHistory;

/**
 *
 * @author asanabria
 */
@Local
public interface IdentifierHistoryEAOLocal 
		extends BaseLocalEAO<IdentifierHistory,Long>{
    
}
