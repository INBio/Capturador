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
import org.inbio.ara.persistence.indicator.Indicator;

/**
 *
 * @author gsulca
 */
@Stateless
public class IndicatorEAOImpl extends BaseEAOImpl<Indicator, Long> implements IndicatorEAOLocal {

    public List<Long> findChildrenByIndicatorId(Long indicatorId) {
           Query q = em.createQuery(
                " Select i.indicatorId " +
                " from Indicator as i " +
                " where i.indicatorAncestorId ="+indicatorId
               );
        //q.setParameter("indicator", indicatorId);
           //System.out.println(q.getResultList().toString());
        return  q.getResultList();
        //return null;
    }

     public Long countByIndicatorId(Long indicatorNodeId) {
        StringBuffer query = new StringBuffer();
        query.append("select count(i.indicatorId) from Indicator"+
                " as i where i.indicatorAncestorId = :indicatorNodeId");
        Query q = em.createQuery(query.toString());
        q.setParameter("indicatorNodeId", indicatorNodeId);
        return (Long)q.getSingleResult();
    }
 
}
