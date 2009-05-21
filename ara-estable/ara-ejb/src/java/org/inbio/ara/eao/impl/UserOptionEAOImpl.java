/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.eao.impl;

import java.util.List;
import org.inbio.ara.eao.UserOptionLocalEAO;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.persistence.security.UserOption;

/**
 *
 * @author asanabria
 */
@Stateless
public class UserOptionEAOImpl extends BaseEAOImpl implements UserOptionLocalEAO {

	// Add business logic below. (Right-click in editor and choose
	// "Insert Code > Add Business Method" or "Web Service > Add Operation")

	/**
	 * Retorna todos los UserOptions que utiliza un determinado grupo
	 * @param groupId
	 * @return
	 */

	@Override
	public List<UserOption> findAllByGroupId(Long groupId) {

		Query q = em.createQuery(
				"select uo"
				+ " from UserOption as uo"
				+ " where uo.user.id = :groupId");

		
		q.setParameter("groupId", groupId);
		return q.getResultList();
	}

	/**
	 * Retorna todos los UserOptions que utiliza un determinado usuario
	 * @param groupId
	 * @return
	 */
	@Override
	public List<UserOption> findAllByUserId(Long userId) {

		Query q = em.createQuery(
				"select uo"
				+ " from UserOption as uo"
				+ " where uo.user.id = :userId");

		q.setParameter("userId", userId);
		return q.getResultList();
	}

	/**
	 * Borra todos los permisos que le fueron asignados a un usuario.
	 * @param userId
	 * @deprecated 
	 */

	@Override
	public void deleteAllByUserId(Long userId){

		//toma las opciones de los grupos
		List<UserOption> groupOptions = this.findAllByUserId(userId);

		if(groupOptions != null){
			for(UserOption uo : groupOptions){
				em.remove(uo);
			}
		}
	}
}
