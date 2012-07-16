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
import org.inbio.ara.persistence.taxonomy.TaxonIndicator;

/**
 *
 * @author gsulca
 */
@Stateless
public class TaxonIndicatorEAOImpl extends BaseEAOImpl<TaxonIndicator, Long> implements TaxonIndicatorEAOLocal {
    

    public List<Long> getIndicatorsByTaxonId(Long taxonId)
    {
        StringBuffer query = new StringBuffer();
        query.append("select ti.taxonIndicatorPK.indicatorId from TaxonIndicator"+
                " as ti where ti.taxonIndicatorPK.taxonId = :taxonId");
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);
        return q.getResultList();
    }

    public void deleteTaxonIndicatorById(Long taxonId, Long indicatorId)
    {
        Query q = em.createQuery(
                " delete from TaxonIndicator ti " +
                " where ti.taxonIndicatorPK.indicatorId = :indicatorId and ti.taxonIndicatorPK.taxonId = :taxonId");
        q.setParameter("indicatorId", indicatorId);
        q.setParameter("taxonId", taxonId);
        q.executeUpdate();
        em.flush();
    }

    public void deleteTaxonIndicatorByTaxonId(Long taxonId)
    {
        Query q = em.createQuery(
                " delete from TaxonIndicator ti " +
                " where ti.taxonIndicatorPK.taxonId = :taxonId");
        q.setParameter("taxonId", taxonId);
        q.executeUpdate();
        em.flush();
    }
 
}
