/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.transaction;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.transaction.TransactedSpecimenStatus;

/**
 *
 * @author echinchilla
 */
@Local
public interface TransactedSpecimenStatusEAOLocal extends BaseLocalEAO<TransactedSpecimenStatus, Long> {
    
}
