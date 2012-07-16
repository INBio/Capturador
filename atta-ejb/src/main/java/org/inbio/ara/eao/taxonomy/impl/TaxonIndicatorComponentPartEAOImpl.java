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
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorComponentPart;

/**
 *
 * @author gsulca
 */
@Stateless
public class TaxonIndicatorComponentPartEAOImpl extends BaseEAOImpl<TaxonIndicatorComponentPart,Long> implements TaxonIndicatorComponentPartEAOLocal {
    
    public List<Long> findComponentPartByTaxonIndicatorIds(Long taxonId, Long indicatorId)
    {
        StringBuffer query = new StringBuffer();
        query.append("select tic.taxonIndicatorComponentPartPK.componentPartId from TaxonIndicatorComponentPart as tic"+
                " where tic.taxonIndicatorComponentPartPK.taxonId = :taxonId "
                +" and tic.taxonIndicatorComponentPartPK.indicatorId = :indicatorId");
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);
        q.setParameter("indicatorId", indicatorId);

        return q.getResultList();
    }

    public void deleteTaxonIndicatorComponentPartById(Long taxonId, Long indicatorId, Long componentPartId)
    {
        Query q = em.createQuery(
                " delete from TaxonIndicatorComponentPart tic " +
                " where tic.taxonIndicatorComponentPartPK.indicatorId = :indicatorId and tic.taxonIndicatorComponentPartPK.taxonId = :taxonId and tic.taxonIndicatorComponentPartPK.componentPartId = :componentPartId");
        q.setParameter("indicatorId", indicatorId);
        q.setParameter("taxonId", taxonId);
        q.setParameter("componentPartId", componentPartId);
        q.executeUpdate();
        em.flush();
    }

    public void deleteTaxonIndicatorComponentPartByTaxonId(Long taxonId)
    {
        Query q = em.createQuery(
                " delete from TaxonIndicatorComponentPart tic " +
                " where tic.taxonIndicatorComponentPartPK.taxonId = :taxonId");

        q.setParameter("taxonId", taxonId);
        q.executeUpdate();
        em.flush();
    }

    public void deleteTaxonIndicatorComponentPartByTaxonIndicator(Long taxonId, Long indicatorId)
    {
        Query q = em.createQuery(
                " delete from TaxonIndicatorComponentPart tic " +
                " where tic.taxonIndicatorComponentPartPK.indicatorId = :indicatorId"+
                " and tic.taxonIndicatorComponentPartPK.taxonId = :taxonId");

        q.setParameter("indicatorId", indicatorId);
        q.setParameter("taxonId", taxonId);
        q.executeUpdate();
        em.flush();
    }

}
