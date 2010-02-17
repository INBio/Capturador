/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;

/**
 *
 * @author esmata
 */
@Local
public interface TaxonDescriptionEAOLocal extends BaseLocalEAO<TaxonDescription,Long>{

    public java.lang.Long countByPK();

    public org.inbio.ara.persistence.taxonomy.TaxonDescription findByPK(java.lang.Long taxonId, java.lang.Long sequence);
    
}
