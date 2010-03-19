/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.eao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jgutierrez
 */
public class BaseEAOImpl<E extends Object,I extends Object>
    implements BaseLocalEAO<E,I>{

    @PersistenceContext
    public EntityManager em;


    public void create(E entity) {
        em.persist(entity);
        em.flush();
    }

    public void delete(E entity) {
        em.remove(entity);
        em.flush();
    }

    public void update(E entity) {
        em.merge(entity);
        em.flush();
    }

    public E findById(Class<E> entityClass, I entityId) {
         return em.find(entityClass, entityId);
    }

    public List<E> findAll(Class<E> entityClass) {
        Query q = em.createQuery("select e from "+entityClass.getName()+" as e");
        return q.getResultList();
    }

    public Long count(Class<E> entityClass){
        Query q = em.createQuery("select count (e.id) from "+entityClass.getName()+" as e");
        Long result = (Long)q.getSingleResult();
        return result;
    }
     

    /**
     *
     * This method does 3 things:
     * 1. Paginate the output
     * 2. Filter by collection
     * 3. Order the results using one o more fields.
     *
     * @param entityClass Type of returned elements
     * @param base First result of the returned list of elements
     * @param offset Maximum number of results to be returned in the list.
     * @param orderByFields The criteria for the "order by" of the results. This
     * will be an array of String, each one value containing the name of the field
     * in the *entity*. ei: String[] orderByFields = {specimenId}.
     * @param collectionId CollectionId to be used as filter
     * @return List of paginated, Filterd by collection and freely order by elements
     */
    public List<E> findAllPaginatedFilterAndOrderBy(Class<E> entityClass, int base,
            int offset, String[] orderByFields, Long collectionId) {
        StringBuffer query = new StringBuffer();
        boolean firstField = true;

        query.append("from " + entityClass.getName() + " as e");
        
        if(collectionId != null)
            query.append(" where e.collectionId = :collectionId");
        
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

        //System.out.println(query.toString());
        Query q = em.createQuery(query.toString());
        if(collectionId != null)
            q.setParameter("collectionId", collectionId);
        q.setFirstResult(base);
        q.setMaxResults(offset);
        return q.getResultList();
    }

}
