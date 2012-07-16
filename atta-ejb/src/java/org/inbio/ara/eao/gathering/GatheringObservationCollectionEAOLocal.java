/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.gathering.GatheringObservationCollection;

/**
 *
 * @author esmata
 */
@Local
public interface GatheringObservationCollectionEAOLocal extends BaseLocalEAO<GatheringObservationCollection,Long> {

    public void deleteByGathering(java.lang.Long gId);
    
}
