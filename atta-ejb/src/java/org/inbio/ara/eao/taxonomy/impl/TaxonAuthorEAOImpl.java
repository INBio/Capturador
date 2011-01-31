/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy.impl;

import org.inbio.ara.eao.taxonomy.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.taxonomy.TaxonAuthor;

/**
 *
 * @author gsulca
 */
@Stateless
public class TaxonAuthorEAOImpl extends BaseEAOImpl<TaxonAuthor, Long> implements TaxonAuthorEAOLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

    public void deleteTaxonAuthorByTaxonId(Long taxonId)
    {
        Query q = em.createQuery(
                " delete from TaxonAuthor ta " +
                " where ta.taxonAuthorPK.taxonId = :taxonId");
        q.setParameter("taxonId", taxonId);
        q.executeUpdate();
        em.flush();
    }
 
}
