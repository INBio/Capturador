/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gathering;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.gathering.GatheringObservation;

/**
 *
 * @author jgutierrez
 */
@Local
public interface GatheringObservationEAOLocal extends BaseLocalEAO<GatheringObservation,Long>{

    public List<Long> findBySiteId(Long siteId);

    public List<Long> findByResponsibleId(Long personId);

    public List<Long> findByInitialDate(Calendar initialDate);

    public List<Long> findByFinalDate(Calendar finalDate);

    public void deleteById(java.lang.Long gId);

    public java.util.List<org.inbio.ara.persistence.gathering.GatheringObservation> findGathObsBySiteId(java.lang.Long siteId);

    public java.util.List<java.lang.Long> findBySpecimenId(java.lang.Long specimenId);

    public java.util.List<java.lang.Long> findByCollectionId(java.lang.Long collectionId);

}
