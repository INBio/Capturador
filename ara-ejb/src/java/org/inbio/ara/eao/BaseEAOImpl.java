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

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.persistence.identification.Identification;
import org.inbio.ara.persistence.person.Person;

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
     * @param entityClass
     * @param firstResult
     * @param maxResults
     * @return Ordered list of elements
     * @deprecated Use instead:
     *  public List<E> findAllPaginated(Class<E> entityClass, int firstResult,
     *      int maxResults, int collectionId)
     */
    public List<E> findAllPaginated(Class<E> entityClass, int firstResult,
            int maxResults) {        
        if(entityClass == Identification.class) {
            try {
                Field field1 = entityClass.getDeclaredField("identificationPK");
                Field[] fields = {field1};
                return findAllPaginatedOrderBy(entityClass, firstResult,
                        maxResults, fields);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(entityClass == GatheringObservation.class) {
            try {
                Field field1 = entityClass.getDeclaredField("gatheringObservationId");
                Field[] fields = {field1};
                return findAllPaginatedOrderBy(entityClass, firstResult,
                        maxResults, fields);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(entityClass == Specimen.class) {
            try {
                Field field1 = entityClass.getDeclaredField("specimenId");
                Field[] fields = {field1};
                return findAllPaginatedOrderBy(entityClass, firstResult,
                        maxResults, fields);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(entityClass == Site.class) {
            try {
                Field field1 = entityClass.getDeclaredField("description");
                Field[] fields = {field1};
                return findAllPaginatedOrderBy(entityClass, firstResult,
                        maxResults, fields);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(entityClass == Person.class) {
            try {
                Field field1 = entityClass.getDeclaredField("firstName");
                Field[] fields = {field1};
                return findAllPaginatedOrderBy(entityClass, firstResult,
                        maxResults, fields);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //If it's another... without order
        Query q = em.createQuery("select e from " + entityClass.getName() +
                " as e");
        q.setFirstResult(firstResult);
        q.setMaxResults(maxResults);
        return q.getResultList();
    }

    /**
     *
     * @param entityClass
     * @param firstResult
     * @param maxResults
     * @return Ordered list of elements
     */
    public List<E> findAllPaginated(Class<E> entityClass, int firstResult,
            int maxResults, Long collectionId) {
        if(entityClass == Identification.class) {
            try {
                Field field1 = entityClass.getDeclaredField("identificationPK");
                Field[] fields = {field1};
                return findAllPaginatedOrderBy(entityClass, firstResult,
                        maxResults, fields, collectionId);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(entityClass == GatheringObservation.class) {
            try {
                Field field1 = entityClass.getDeclaredField("gatheringObservationId");
                Field[] fields = {field1};
                return findAllPaginatedOrderBy(entityClass, firstResult,
                        maxResults, fields, collectionId);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(entityClass == Specimen.class) {
            try {
                Field field1 = entityClass.getDeclaredField("specimenId");
                Field[] fields = {field1};
                return findAllPaginatedOrderBy(entityClass, firstResult,
                        maxResults, fields, collectionId);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(BaseEAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //If it's another... without order
        Query q = em.createQuery("select e from " + entityClass.getName() +
                " as e");
        q.setFirstResult(firstResult);
        q.setMaxResults(maxResults);
        return q.getResultList();

    }


    /**
     *
     * @param entityClass
     * @param base
     * @param offset
     * @param fields
     * @return
     * @deprecated use instead:
     * private List<E> findAllPaginatedOrderBy(Class<E> entityClass, int base,
     *      int offset, Field[] fields, <b>int collectionId</b>)
     */
    private List<E> findAllPaginatedOrderBy(Class<E> entityClass, int base,
            int offset, Field[] fields) {
        StringBuffer query = new StringBuffer();
        boolean firstField = true;
        query.append("from " + entityClass.getName() + " as e ");
        query.append("order by ");
        for (Field field : fields) {
            if(firstField) {
                query.append("e."+field.getName() + " asc");
                firstField = false;
            } else {
                query.append(", e."+field.getName() + " asc");
            }
        }
        System.out.println(query.toString());
        Query q = em.createQuery(query.toString());
        q.setFirstResult(base);
        q.setMaxResults(offset);
        return q.getResultList();
    }

    /**
     *
     * @param entityClass
     * @param base
     * @param offset
     * @param fields
     * @param collectionId
     * @return
     */
    private List<E> findAllPaginatedOrderBy(Class<E> entityClass, int base,
            int offset, Field[] fields, Long collectionId) {
        StringBuffer query = new StringBuffer();
        boolean firstField = true;
        query.append("from " + entityClass.getName() + " as e ");
        query.append("where e.collectionId = :collectionId order by ");
        for (Field field : fields) {
            if(firstField) {
                query.append("e."+field.getName() + " asc");
                firstField = false;
            } else {
                query.append(", e."+field.getName() + " asc");
            }
        }
        System.out.println(query.toString());
        Query q = em.createQuery(query.toString());
        q.setParameter("collectionId", collectionId);
        q.setFirstResult(base);
        q.setMaxResults(offset);
        return q.getResultList();
    }

}
