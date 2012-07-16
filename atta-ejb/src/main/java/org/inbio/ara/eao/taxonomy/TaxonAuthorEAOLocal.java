/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.taxonomy.TaxonAuthor;

/**
 *
 * @author gsulca
 */
@Local
public interface TaxonAuthorEAOLocal  extends BaseLocalEAO<TaxonAuthor,Long>{

    public void deleteTaxonAuthorByTaxonId(Long taxonId);

    public List<TaxonAuthor> findTaxonAuthorsByTaxonCategory(Long taxonId, String category);

    public void deleteTaxonAuthorByTaxonAuthorIds(Long taxonId, Long taxonAuthorPersonId, String category);

    public TaxonAuthor findTaxonAuthorByTaxonAuthorIds(Long taxonId, Long taxonAuthorPersonId, String category);


    
}
