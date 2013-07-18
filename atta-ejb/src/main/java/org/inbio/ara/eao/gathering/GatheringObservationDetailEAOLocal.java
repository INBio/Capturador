/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;

/**
 *
 * @author esmata
 */
@Local
public interface GatheringObservationDetailEAOLocal extends BaseLocalEAO<GatheringObservationDetail,Long> {

    public java.util.List<org.inbio.ara.persistence.gathering.GatheringObservationDetail> getDetailPaginatedByGathering(int firstResult, int maxResults, java.lang.Long gathId);

    public void deleteById(java.lang.Long gId);

    public List<Long> findByResponsibleId(Long personId, Long initialGathObserDetail, Long finalGathObserDetail);

    public List<Long> findByResponsibleId(Long personId);

    public List<Long> findByResponsibleId(Long personId, Long initialGathObserDetail);


    public List<Long> findByGathObsDetailId(Long gathObsId);

    public java.lang.Long countByGathObsId(java.lang.Long gathObsId);

    public java.util.List<java.lang.Long> findByGathObsDetailNumber(java.lang.String gathObsDetailNumber);

    public java.util.List<java.lang.Long> findByGathObsDetailNumber(java.lang.String gathObsDetailNumber, java.lang.Long collectionId);
    
}
