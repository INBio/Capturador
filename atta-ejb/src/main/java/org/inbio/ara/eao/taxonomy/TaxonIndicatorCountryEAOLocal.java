/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorCountry;

/**
 *
 * @author gsulca
 */
@Local
public interface TaxonIndicatorCountryEAOLocal extends BaseLocalEAO<TaxonIndicatorCountry,Long>{

    
    public List<java.lang.Long> findCountriesByTaxonIndicatorIds(Long taxonId, Long indicatorId);

    public void deleteTaxonIndicatorCountryById(Long taxonId, Long indicatorId, Long countryId);

    public void deleteTaxonIndicatorCountryByTaxonId(Long taxonId);

    public void deleteTaxonIndicatorCountryByTaxonIndicator(Long taxonId, Long indicatorId);
    
}
