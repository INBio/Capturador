/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.indicator.impl;


import java.util.List;
import org.inbio.ara.eao.indicator.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.indicator.IndicatorDublinCore;

/**
 *
 * @author gsulca
 */
@Stateless
public class IndicatorDublinCoreEAOImpl extends BaseEAOImpl<IndicatorDublinCore, Long> implements IndicatorDublinCoreEAOLocal {



    public Long countDublinCoreByIndicator(Long indicatorId) {
        StringBuffer query = new StringBuffer();
        query.append("select count(*) from IndicatorDublinCore"+
                " as idc where idc.indicatorDublinCorePK.indicatorId = :indicatorId");
        Query q = em.createQuery(query.toString());
        q.setParameter("indicatorId", indicatorId);
        return (Long)q.getSingleResult();
    }


    public List<Long> getDublinCoreByIndicator(Long indicatorId){
         StringBuffer query = new StringBuffer();
        query.append("select idc.indicatorDublinCorePK.dublinCoreId from IndicatorDublinCore"+
                " as idc where idc.indicatorDublinCorePK.indicatorId = :indicatorId");
        Query q = em.createQuery(query.toString());
        q.setParameter("indicatorId", indicatorId);
        return q.getResultList();
    }

    public void deleteByIndicatorId(Long indicatorId)
    {
        Query q = em.createQuery(
                " delete from IndicatorDublinCore idc " +
                " where idc.indicatorDublinCorePK.indicatorId = :indicatorId");
        q.setParameter("indicatorId", indicatorId);
        q.executeUpdate();
        em.flush();
    }
      
 
}
