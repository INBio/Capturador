/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.gathering.CollectorObserver;

/**
 *
 * @author esmata
 */
@Local
public interface CollectorObserverEAOLocal extends BaseLocalEAO<CollectorObserver,Long>{

    public java.util.List<org.inbio.ara.persistence.person.Person> getCollectorsByGathering(java.lang.Long GathId);

    public void deleteByGathering(java.lang.Long gId);

    public java.util.List<java.lang.Long> getGatheringByCollector(java.lang.Long collectorId);


}
