/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.collection.impl;

import java.util.List;
import org.inbio.ara.eao.collection.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.collection.Collection;


/**
 *
 * @author jgutierrez
 */
@Stateless
public class CollectionEAOImpl extends BaseEAOImpl<Collection,Long> implements CollectionEAOLocal  {

    /**
    * Contar los especimenes por coleccion, utilizado en las pantalla
    * de estadisticas
    */
	public Long getSpecimensCountByCollectionId(Long collectionId) {

		Query q = em.createQuery(
				"select count(s) as specimen_count"
				+ " from Specimen as s "
				+ " left join s.collection c "
				+ " where s.collection.collectionId = c.collectionId "
				+ " and c.collectionId = :collectionId");
		q.setParameter("collectionId", collectionId);
		return (Long) q.getSingleResult();
	}

    /**
    * Contar las especies por coleccion, utilizado en las pantalla
    * de estadisticas
    */
	public Long getSpeciesCountByCollectionId(Long collectionId) {

		Query q = em.createQuery(
				"select count(t) as taxon_count"
				+ " from Taxon as t "
				+ " left join t.collection c "
				+ " where t.collection.collectionId = c.collectionId "
				+ " and c.collectionId = :collectionId");
		q.setParameter("collectionId", collectionId);
		return (Long) q.getSingleResult();
	}

    public List<Collection> finAllBySelectionListValue(Long selectedSelectionListEntityId, Long selectedSelectionListValueId) {
		Query q = em.createQuery("select ltc.collection " +
				"from ListTableCollection as ltc " +
				"where ltc.selectionListCollectionPK.selectionListEntityId = :selectionListEntityId " +
				"and ltc.selectionListCollectionPK.selectionListValueId = :selectionListValueId");
		q.setParameter("selectionListEntityId", selectedSelectionListEntityId);
		q.setParameter("selectionListValueId", selectedSelectionListValueId);
		return q.getResultList();

	}

    /**
     * Busca colectiones dado un nombre
     * @param collectionName corresponde al nombre (collectionCode)
     * @return lista de coleciones encontradas
     */
    public List<Collection> findByCollectionName(String collectionName){
        Query q = em.createQuery("from Collection c where c.name = '" + collectionName + "'");
		return q.getResultList();
    }
    
}
