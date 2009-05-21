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
import javax.persistence.Query;
import org.inbio.ara.eao.CollectionLocalEAO;
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class CollectionEAOImpl extends BaseEAOImpl implements CollectionLocalEAO {

	/**
	 *
	 * @return
	 */
	@Override
	public List<Collection> listAll() {
		Query q = em.createQuery("select c " +
				"from Collection as c ");
		return q.getResultList();
	}

	/**
	 *
	 * @param selectionListId
	 * @param selectionListValueId
	 * @return
	 */
	@Override
	public List<Collection> getCollectionsBySelectionListValue(Long selectionListId, Long selectionListValueId) {

		Query q = em.createQuery("select ltc.collection " +
				"from ListTableCollection as ltc " +
				"where ltc.listTableCollectionPK.listTableId = :selectionListId " +
				"and ltc.listTableCollectionPK.valueId = :selectionListValueId");
		q.setParameter("selectionListId", selectionListId);
		q.setParameter("selectionListValueId", selectionListValueId);
		return q.getResultList();

	}

	/**
	 * @param collectionId
	 * @return the SpecimenCount
	 */
	@Override
	public Long getSpecimensCountByCollectionId(Long collectionId) {

		Query q = em.createQuery(
				"select count(s) as specimen_count"
				+ " from Specimen as s "
				+ " left join s.collection c "
				+ " where s.collection.id = c.id "
				+ " and c.id = :collectionId");
		q.setParameter("collectionId", collectionId);
		
		return (Long) q.getSingleResult();
	}

	/**
	 * @param collectionId
	 * @return the Species Count
	 */
	@Override
	public Long getSpeciesCountByCollectionId(Long collectionId) {

		Query q = em.createQuery(
				"select count(t) as taxon_count"
				+ " from Taxon as t "
				+ " left join t.collection c "
				+ " where t.collection.id = c.id "
				+ " and c.id = :collectionId");
		q.setParameter("collectionId", collectionId);

		return (Long) q.getSingleResult();
	}
}
