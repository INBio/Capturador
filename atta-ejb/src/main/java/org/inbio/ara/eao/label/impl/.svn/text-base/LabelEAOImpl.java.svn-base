/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.Calendar;
import javax.persistence.TemporalType;
import org.inbio.ara.eao.label.*;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.label.Label;


/**
 *
 * @author pcorrales
 */
@Stateless
public class LabelEAOImpl  extends BaseEAOImpl<Label,Long> implements LabelEAOLocal {

  
    /**
     * obtain the list of labels type correction
     */
    public List<Long> findByLabelTypeId(Long TypeId, Calendar InitialDate, Calendar FinalDate){

        
        StringBuffer query = new StringBuffer();
        query.append("select l.labelId from Label as l "+
                "where l.labelTypeId = :TypeId  and  l.creationDate  between :InitialDate  and  :FinalDate");
        Query q = em.createQuery(query.toString());
        q.setParameter("TypeId", TypeId);
        q.setParameter("InitialDate", InitialDate,TemporalType.DATE);
        q.setParameter("FinalDate", FinalDate,TemporalType.DATE);
        return q.getResultList();
    }


    /**
     * get  in order  the list of labels  associated with a current label
     * @param labelId
     * @param base
     * @param offset
     * @param orderByFields
     * @param collectionId
     * @param labelTypeId
     * @return
     */
    public List<Label> findAllPaginatedFilterAndOrderByAncestorId(Long labelId, int base,
            int offset, String[] orderByFields, Long collectionId,Long labelTypeId) {
        StringBuffer query = new StringBuffer();
        boolean firstField = true;

        query.append("from  Label as e ");
        query.append("where e.ancestorLabelId = :labelId   and  e.labelTypeId = :labelTypeId");
        
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
        System.out.println(labelId);
        System.out.println(labelTypeId);
        

        Query q = em.createQuery(query.toString());
        q.setParameter("labelId", labelId);
        q.setParameter("labelTypeId", labelTypeId);
        q.setFirstResult(base);
        q.setMaxResults(offset);
        return q.getResultList();
    }

}