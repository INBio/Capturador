/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonCountry;

/**
 *
 * @author gsulca
 */
@Local
public interface TaxonCountryEAOLocal extends BaseLocalEAO<TaxonCountry,Long>{

    

    public void deleteTaxonCountryById(java.lang.Long taxonId, java.lang.Long countryId);

    public void deleteTaxonCountryByTaxonId(java.lang.Long taxonId);

    public java.util.List<org.inbio.ara.persistence.taxonomy.TaxonCountry> findCountriesByTaxonId(java.lang.Long taxonId);

    public org.inbio.ara.persistence.taxonomy.TaxonCountry findTaxonCountryByTaxonCountryIds(java.lang.Long taxonId, java.lang.Long countryId);
    
}
