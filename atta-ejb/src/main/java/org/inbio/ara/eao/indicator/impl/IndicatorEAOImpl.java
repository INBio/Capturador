/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
                " where i.indicatorAncestorId ="+indicatorId+
                "order by i.name"
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
