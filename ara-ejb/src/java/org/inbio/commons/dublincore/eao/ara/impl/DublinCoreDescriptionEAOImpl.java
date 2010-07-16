/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.commons.dublincore.eao.ara.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.commons.dublincore.eao.ara.DublinCoreDescriptionEAOLocal;
import org.inbio.commons.dublincore.model.DublinCoreDescription;

/**
 *
 * @author gsulca
 */
@Stateless
public class DublinCoreDescriptionEAOImpl extends BaseEAOImpl<DublinCoreDescription, Long> implements DublinCoreDescriptionEAOLocal {
    
    

	/* (non-Javadoc)
	 * @see org.inbio.commons.dublincore.dao.DublinCoreElementDAO#findAllByResourceId(int)
	 */
	@SuppressWarnings("unchecked")
	public Long countResourceByTypeId(int resourceTypeId) {
		Query query = em.createQuery(
				"select count(dcd) from DublinCoreDescriptionJPA as dcd"
				+ " where dcd.resourceTypeId = :resourceTypeId");
		query.setParameter("resourceTypeId", resourceTypeId);
		
            return (Long)query.getSingleResult();
	}


        @SuppressWarnings("unchecked")
	public Long findAllByTypeId(int resourceTypeId) {
		Query query = em.createQuery(
				"select dcd.resourceId from DublinCoreDescriptionJPA as dcd"
				+ " where dcd.resourceTypeId = :resourceTypeId");
		query.setParameter("resourceTypeId", resourceTypeId);
		
            return (Long)query.getSingleResult();
	}


        @SuppressWarnings("unchecked")
      public List<DublinCoreDescription> findAllPaginated( int resourceTypeId ,int base, int offset) {
        
        Query query = em.createQuery(
				"select dcd from DublinCoreDescriptionJPA as dcd"
				+ " where dcd.resourceTypeId = :resourceTypeId");
		query.setParameter("resourceTypeId", resourceTypeId);

        query.setFirstResult(base);
        query.setMaxResults(offset);
        return query.getResultList();
    }

    public DublinCoreDescription findById(int arg0) {
        return this.findById(DublinCoreDescription.class, new Long(arg0));
    }






}
