/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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


package org.inbio.ara.eao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import org.inbio.ara.dto.UserTypeEntity;
import org.inbio.ara.eao.UserLocalEAO;
import org.inbio.ara.persistence.security.User;
import org.inbio.ara.persistence.security.UserNomenclaturalGroup;
import org.inbio.ara.persistence.security.UserNomenclaturalGroupPK;
import org.inbio.ara.persistence.security.UserTaxon;
import org.inbio.ara.persistence.security.UserTaxonPK;
import org.inbio.ara.persistence.security.UserType;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;
import org.inbio.ara.persistence.taxonomy.Taxon;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class UserEAOImpl extends BaseEAOImpl implements UserLocalEAO {

    private static Long userTypeId = new Long(UserTypeEntity.USER_TYPE.getId());

    public List<User> listAllUser() {
        Query q = em .createQuery("select u" +
                " from User as u " +
                "where u.userType.id = :typeId");
        q.setParameter("typeId", userTypeId);
        return q.getResultList();
    }

    @Override
    public void delete(Class entityClass, Object entityId) {

        //rehacer esto
        this.deleteNomenclaturalGroupList((Long)entityId);
        this.deleteTaxonList((Long)entityId);

        em.remove(em.find(entityClass, entityId));
        em.flush();
    }


    /**
     * @deprecated
     * @param userId
     */
    public void deleteNomenclaturalGroupList(Long userId) {
		Query q;
		q = em.createNativeQuery("delete from ara.user_nomenclatural_group where user_id = " + userId);
		q.executeUpdate();

	}


    /**
     * @deprecated
     * @param userId
     */
	public void deleteTaxonList(Long userId) {
		Query q;
		q = em.createNativeQuery("delete from ara.user_taxon where user_id = " + userId);
		q.executeUpdate();
		}

	/**
     * @deprecated
     * @param userTypeId
	 * TODO: Quitar esto de aquí
     */
	@Override
	public UserType getUserTypeById(int userTypeId) {
		return (UserType)em.find(UserType.class,new Long(userTypeId));
	}

	/**
	 * @deprecated
	 * @param taxonArray
	 * @param user
	 */
	@Override
	public void updateTaxonList(Long[] taxonArray, User user) {
		UserTaxon userTaxon;
		Taxon taxon;
		Long i = 1L;
		System.out.println("Procediendo a crear taxones");

		if (taxonArray.length > 0) {
			for (Long taxonId : taxonArray) {
				taxon = (Taxon) em.find(Taxon.class, taxonId);
				UserTaxonPK pk = new UserTaxonPK();

				pk.setTaxonId(taxon.getTaxonId());
				pk.setUserId(user.getId());
				pk.setSequence(i);

				userTaxon = new UserTaxon();
				userTaxon.setUserTaxonPK(pk);
				userTaxon.setCreatedBy(user.getLastModificationBy());
				userTaxon.setLastModificationBy(user.getLastModificationBy());

				try {
					em.persist(userTaxon);
				} catch (EntityExistsException entityExistEx) {
					//setMessage("El registro ya existe en la base de datos.");
				} catch (IllegalStateException illegalStateEx) {
					//setMessage("La conexión con la base de datos fue cerrada.");
				} catch (IllegalArgumentException illegalArgumentEx) {
					//setMessage("El objeto a persistir no es una entidad válida.");
				} catch (TransactionRequiredException transactionRequiredEx) {
					//setMessage("No se puede ejecutar la acción debido a que no hay una transacción activa");
				}
				i++;
			}
		}
	}

	/**
	 * @deprecated 
	 * @param groupArray
	 * @param user
	 */
	@Override
	public void updateNomenclaturalGroupList(Long[] groupArray, User user) {
		UserNomenclaturalGroup userNGroup;
		NomenclaturalGroup group;
		Long i = 1L;
		System.out.println("Procediendo a crear grupos nomenclaturales");

		if (groupArray.length > 0) {
			for (Long groupId : groupArray) {
				group = (NomenclaturalGroup) em.find(NomenclaturalGroup.class, groupId);
				UserNomenclaturalGroupPK pk = new UserNomenclaturalGroupPK();

				pk.setNomenclaturalGroupId(group.getId());
				pk.setUserId(user.getId());
				pk.setSequence(i);

				userNGroup = new UserNomenclaturalGroup();
				userNGroup.setUserNomenclaturalGroupPK(pk);
				userNGroup.setCreatedBy(user.getCreatedBy());
				userNGroup.setLastModificationBy(user.getLastModificationBy());

				try {
					em.persist(userNGroup);
				} catch (EntityExistsException entityExistEx) {
					//setMessage("El registro ya existe en la base de datos.");
				} catch (IllegalStateException illegalStateEx) {
					//setMessage("La conexión con la base de datos fue cerrada.");
				} catch (IllegalArgumentException illegalArgumentEx) {
					//setMessage("El objeto a persistir no es una entidad válida.");
				} catch (TransactionRequiredException transactionRequiredEx) {
					//setMessage("No se puede ejecutar la acción debido a que no hay una transacción activa");
				}
				i++;
			}
		}
	}


}
