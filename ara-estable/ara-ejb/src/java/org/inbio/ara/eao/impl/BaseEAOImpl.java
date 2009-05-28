/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.inbio.ara.eao.BaseLocalEAO;

/**
 *
 * @author jgutierrez
 */
public class BaseEAOImpl implements BaseLocalEAO{

    @PersistenceContext
    public EntityManager em;


    /**
     * 
     * @param entityClass
     * @param entityId
     * @return
     */
	@Override
    public Object findById(Class entityClass, Object entityId){
        return em.find(entityClass, entityId);
    }
   
    /**
     *
     * @param entity
     */
	@Override
    public void create(Object entity){
        em.persist(entity);
        em.flush();

    }

	@Override
    public void delete(Class entityClass, Object entityId) {
        em.remove(em.find(entityClass, entityId));
        em.flush();
    }

    @Override
	public void update(Object entity) {
        em.refresh(entity);
        em.flush();
    }
}
