/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.agent;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.audiences.Audience;

/**
 *
 * @author esmata
 */
@Local
public interface AudienceEAOLocal extends BaseLocalEAO<Audience,Long>{

    public java.util.List<org.inbio.ara.persistence.audiences.Audience> getAudiencesByTaxonDescription(java.lang.Long taxonId, java.lang.Long taxonDescriptionSequence);
    
}
