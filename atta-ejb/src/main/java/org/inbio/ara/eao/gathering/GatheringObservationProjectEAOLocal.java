/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.gathering.GatheringObservationProject;

/**
 *
 * @author esmata
 */
@Local
public interface GatheringObservationProjectEAOLocal extends BaseLocalEAO<GatheringObservationProject,Long>{

    public void deleteByGathering(java.lang.Long gId);
    
}
