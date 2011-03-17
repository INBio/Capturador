/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy.impl;

import java.util.List;
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
    

    public void deleteTaxonAuthorByTaxonId(Long taxonId)
    {
        Query q = em.createQuery(
                " delete from TaxonAuthor ta " +
                " where ta.taxonAuthorPK.taxonId = :taxonId");
        q.setParameter("taxonId", taxonId);
        q.executeUpdate();
        em.flush();
    }

    public void deleteTaxonAuthorByTaxonAuthorIds(Long taxonId, Long taxonAuthorPersonId, String category)
    {
        Query q = em.createQuery(
                " delete from TaxonAuthor ta " +
                " where ta.taxonAuthorPK.taxonId = :taxonId"+
                " and ta.taxonAuthorPK.category = :category"+
                " and ta.taxonAuthorPersonId = :taxonAuthorPersonId"
                );
        q.setParameter("taxonId", taxonId);
        q.setParameter("category", category);
        q.setParameter("taxonAuthorPersonId", taxonAuthorPersonId);
        q.executeUpdate();
        em.flush();
    }

    public List<TaxonAuthor> findTaxonAuthorsByTaxonCategory(Long taxonId, String category)
    {
        StringBuffer query = new StringBuffer();
        query.append("select ta from TaxonAuthor"+
                " as ta where ta.taxonAuthorPK.taxonId = :taxonId and ta.taxonAuthorPK.category = :category order by ta.taxonAuthorPK.taxonAuthorSequence");
        Query q = em.createQuery(query.toString());

        q.setParameter("taxonId", taxonId);
        q.setParameter("category", category);
        return q.getResultList();
    }

    public TaxonAuthor findTaxonAuthorByTaxonAuthorIds(Long taxonId, Long taxonAuthorSequence, String category)
    {
        StringBuffer query = new StringBuffer();
        query.append("select ta from TaxonAuthor as ta"+
                " where ta.taxonAuthorPK.taxonId = :taxonId"+
                " and ta.taxonAuthorPK.category = :category"+
                " and ta.taxonAuthorPK.taxonAuthorSequence = :taxonAuthorSequence");
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);
        q.setParameter("category", category);
        q.setParameter("taxonAuthorSequence", taxonAuthorSequence);
        System.out.println("*** QUERY ***");
        System.out.println("select ta from TaxonAuthor as ta"+
                " where ta.taxonAuthorPK.taxonId = "+ taxonId+
                " and ta.taxonAuthorPK.category = "+ category +
                " and ta.taxonAuthorPK.taxonAuthorSequence = " + taxonAuthorSequence);
        System.out.println("*** END QUERY ***");
        return (TaxonAuthor)q.getSingleResult();
    }

    public void updateTaxonAuthorByTaxonAuthorIds(Long taxonId, Long taxonAuthorPersonId, String category)
    {
        StringBuffer query = new StringBuffer();
        query.append("update TaxonAuthor ta set"+
                " where ta.taxonAuthorPK.taxonId = :taxonId"+
                " and ta.taxonAuthorPK.category = :category"+
                " and ta.taxonAuthorPersonId = :taxonAuthorPersonId");
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);
        q.setParameter("category", category);
        q.setParameter("taxonAuthorPersonId", taxonAuthorPersonId);

    }
 
}
