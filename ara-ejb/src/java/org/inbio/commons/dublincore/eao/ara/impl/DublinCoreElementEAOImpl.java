/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.commons.dublincore.eao.ara.impl;


/**
 *
 * @author gsulca
 */

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.commons.dublincore.eao.ara.DublinCoreElementEAOLocal;
import org.inbio.commons.dublincore.model.DublinCoreElement;


@Stateless
public class DublinCoreElementEAOImpl extends BaseEAOImpl<DublinCoreElement, Long> implements DublinCoreElementEAOLocal {

  @PersistenceContext
	public EntityManager em;

	@SuppressWarnings("unchecked")
	public List<DublinCoreElement> findAllByResourceId(int resourceId) {
		Query query = em.createQuery(
				"select dce from DublinCoreElementJPA as dce"
				+ " where dce.resourceId = :resourceId");
		query.setParameter("resourceId", resourceId);
                return query.getResultList();
	}

        @SuppressWarnings("unchecked")
	public List<Integer> findByValue(int dublinCoreElementId, String value) {
		Query query = em.createQuery(
				"select dce.resourceId from DublinCoreElementJPA as dce"
				+ " where dce.dublinCoreElementId = :dublinCoreElementId and dce.value like '%"+value+"%'");
		query.setParameter("dublinCoreElementId", dublinCoreElementId);
                return query.getResultList();
	}

    public List<DublinCoreElement> findAllByResourceIdAndDCElementId(int resourceId, int dublinCoreElementId) {
        Query query = em.createQuery(
            "select dce from DublinCoreElementJPA as dce"
            + " where dce.dublinCoreElementId = :dublinCoreElementId and " +
            " dce.resourceId = :resourceId");
        query.setParameter("dublinCoreElementId", dublinCoreElementId);
        query.setParameter("resourceId", resourceId);
        return query.getResultList();
    }

    public void deleteAllByResourceId(Long resourceId) {
        Query query = em.createQuery(
                " delete from DublinCoreElementJPA as dce" +
                " where dce.resourceId = :resourceId");
        query.setParameter("resourceId", resourceId);
        query.getResultList();
    }




}
