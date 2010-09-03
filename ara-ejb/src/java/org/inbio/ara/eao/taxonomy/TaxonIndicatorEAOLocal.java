/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonIndicator;

/**
 *
 * @author gsulca
 */
@Local
public interface TaxonIndicatorEAOLocal extends BaseLocalEAO<TaxonIndicator,Long> {

    public List<Long> getIndicatorsByTaxonId(Long taxonId);

    public void deleteTaxonIndicatorById(Long taxonId, Long indicatorId);

    
}
