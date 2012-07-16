/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorDublinCore;

/**
 *
 * @author gsulca
 */
@Local
public interface TaxonIndicatorDublinCoreEAOLocal extends BaseLocalEAO<TaxonIndicatorDublinCore,Long> {

    public List<Long> findDublinCoreByTaxonIndicatorIds(Long taxonId, Long indicatorId);

    public void deleteTaxonIndicatorDublinCoreById(Long taxonId, Long indicatorId, Long dublinCoreId);

    public void deleteTaxonIndicatorDublinCoreByTaxonId(Long taxonId);

    public void deleteTaxonIndicatorDublinCoreByTaxonIndicator(Long taxonId, Long indicatorId);
    
}
