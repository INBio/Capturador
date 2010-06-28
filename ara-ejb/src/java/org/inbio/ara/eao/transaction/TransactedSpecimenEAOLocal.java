/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.transaction;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.transaction.TransactedSpecimen;

/**
 *
 * @author echinchilla
 */
@Local
public interface TransactedSpecimenEAOLocal extends BaseLocalEAO<TransactedSpecimen, Long> {

    Long countTransactedSpecimenByTransactionId(Long transactionId);

    List<TransactedSpecimen> getTransactedSpecimenByTransactionIdPaginated(int first, int maxResults, Long transactionId);

    int deleteTransactedSpecimen(Long transactionId, Long specimenId);

    public List<TransactedSpecimen> getTransactedSpecimenById(Long transactionId, Long specimenId);
}
