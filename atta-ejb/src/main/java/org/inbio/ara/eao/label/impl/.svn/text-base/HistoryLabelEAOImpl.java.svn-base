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

package org.inbio.ara.eao.label.impl;

import java.util.List;
import org.inbio.ara.eao.label.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.label.LabelHistory;
import org.inbio.ara.dto.label.LabelDTO;

/**
 *
 * @author pcorrales
 */
@Stateless
public class HistoryLabelEAOImpl  extends BaseEAOImpl<LabelHistory,Long> implements HistoryLabelEAOLocal{
    

public List<LabelHistory> findLabelHistoryPaginatedFilterAndOrderByAncestorId(Long labelId, int base,
            int offset, String[] orderByFields, Long collectionId) {


        StringBuffer query = new StringBuffer();
        boolean firstField = true;

        query.append("from LabelHistory as e ");
        query.append("where e.labelHistoryPK.labelId   = :labelId  or e.ancestorLabelId  = :labelId ");

        if(orderByFields != null){
          query.append(" order by ");
          for (String field : orderByFields) {
            if(firstField) {
                query.append("e."+field + " asc");
                firstField = false;
            } else {
                query.append(", e."+field + " asc");
            }
          }
        }

        System.out.println(query.toString());
        Query q = em.createQuery(query.toString());
        q.setParameter("labelId",labelId );
        q.setFirstResult(base);
        q.setMaxResults(offset);
        return q.getResultList();
    }
}