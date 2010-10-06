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
import org.inbio.ara.persistence.taxonomy.TaxonIndicatorDublinCore;

/**
 *
 * @author gsulca
 */
@Stateless
public class TaxonIndicatorDublinCoreEAOImpl extends BaseEAOImpl<TaxonIndicatorDublinCore,Long> implements TaxonIndicatorDublinCoreEAOLocal {
    
    public List<Long> findDublinCoreByTaxonIndicatorIds(Long taxonId, Long indicatorId)
    {
        StringBuffer query = new StringBuffer();
        query.append("select tidc.taxonIndicatorDublinCorePK.dublinCoreId from TaxonIndicatorDublinCore as tidc"+
                " where tidc.taxonIndicatorDublinCorePK.taxonId = :taxonId "
                +" and tidc.taxonIndicatorDublinCorePK.indicatorId = :indicatorId");
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);
        q.setParameter("indicatorId", indicatorId);

        return q.getResultList();
    }

    public void deleteTaxonIndicatorDublinCoreById(Long taxonId, Long indicatorId, Long dublinCoreId)
    {
        Query q = em.createQuery(
                " delete from TaxonIndicatorDublinCore tidc " +
                " where tidc.taxonIndicatorDublinCorePK.indicatorId = :indicatorId and tidc.taxonIndicatorDublinCorePK.taxonId = :taxonId and tidc.taxonIndicatorDublinCorePK.dublinCoreId = :dublinCoreId");
        q.setParameter("indicatorId", indicatorId);
        q.setParameter("taxonId", taxonId);
        q.setParameter("dublinCoreId", dublinCoreId);
        q.executeUpdate();
        em.flush();
    }

 
    public void deleteTaxonIndicatorDublinCoreByTaxonId(Long taxonId)
    {
        Query q = em.createQuery(
                " delete from TaxonIndicatorDublinCore tidc " +
                " where tidc.taxonIndicatorDublinCorePK.taxonId = :taxonId");
        
        q.setParameter("taxonId", taxonId);
        
        q.executeUpdate();
        em.flush();
    }

}
