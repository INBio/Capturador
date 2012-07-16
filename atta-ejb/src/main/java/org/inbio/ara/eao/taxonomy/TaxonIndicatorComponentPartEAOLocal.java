/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorComponentPart;

/**
 *
 * @author gsulca
 */
@Local
public interface TaxonIndicatorComponentPartEAOLocal extends BaseLocalEAO<TaxonIndicatorComponentPart,Long> {

    public List<Long> findComponentPartByTaxonIndicatorIds(Long taxonId, Long indicatorId);

    public void deleteTaxonIndicatorComponentPartById(Long taxonId, Long indicatorId, Long componentPartId);

    public void deleteTaxonIndicatorComponentPartByTaxonId(Long taxonId);

    public void deleteTaxonIndicatorComponentPartByTaxonIndicator(Long taxonId, Long indicatorId);
    
    
}
