/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.eao.collection.impl;

import java.util.List;
import org.inbio.ara.eao.collection.*;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.collection.Collection;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class CollectionEAOImpl extends BaseEAOImpl<Collection, Long> implements CollectionEAOLocal {

    /**
     * Contar los especimenes por coleccion, utilizado en las pantalla
     * de estadisticas
     */
    public Long getSpecimensCountByCollectionId(Long collectionId) {

        Query q = em.createQuery(
                "select count(s) as specimen_count" + " from Specimen as s " + " left join s.collection c " + " where s.collection.collectionId = c.collectionId " + " and c.collectionId = :collectionId");
        q.setParameter("collectionId", collectionId);
        return (Long) q.getSingleResult();
    }

    /**
     * retorna el taxon_id del taxón asociado a una colección (el padre de la jerarquía asociada a una colección).
     */
    public Long getTaxonFatherOfCollection(Long collectionId) {
        
        Query q = em.createQuery(
                "select t.taxonId as taxonId" +
                " from Taxon as t " +
                " inner join t.collection c " +
                " where t.collection.collectionId = c.collectionId " +
                " and c.collectionId = :collectionId");

        q.setParameter("collectionId", collectionId);

        Long result = null;

        try{
            result = (Long) q.getSingleResult();
        }catch(NoResultException ex){
            result = new Long(0);
        }

        return result;
    }

    /**
     * Obtiene la cantidad de especies que estan bajo determinado taxon
     *
     * Este metodo fue  creado pensando en ser utilizado junto con
     * getTaxonFatherOfCollection para realizar un conteo de las especies por
     * colección
     */
    public Long getSpeciesCountUnderTaxonId(Long taxonId) {

        Query q = em.createQuery(" select count(t) as taxonCount " +
                " from Taxon t " +
                " where t.taxonomicalRangeId >= 18 and " +
                " :taxonId in  " +
                " (t.dominiumTaxonId " +
                " , t.kingdomTaxonId " +
                " , t.kingdomTaxonId " +
                " , t.phylumDivisionTaxonId " +
                " , t.subphylumSubdivisionTaxonId " +
                " , t.classTaxonId " +
                " , t.subclassTaxonId " +
                " , t.orderTaxonId " +
                " , t.suborderTaxonId " +
                " , t.superfamilyTaxonId " +
                " , t.subfamilyTaxonId " +
                " , t.tribeTaxonId " +
                " , t.subtribeTaxonId " +
                " , t.genusTaxonId " +
                " , t.subgenusTaxonId " +
                " , t.sectionTaxonId " +
                " , t.subsectionTaxonId " +
                " , t.stirpsTaxonId " +
                " , t.speciesTaxonId " +
                " , t.subspeciesTaxonId " +
                " ,t.varietyTaxonId) ");

        q.setParameter("taxonId", taxonId);
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
    public List<Collection> findByCollectionName(String collectionName) {
        Query q = em.createQuery("from Collection c where c.name = '" + collectionName + "'");
        return q.getResultList();
    }
}
