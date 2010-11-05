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


package org.inbio.ara.eao.taxonomy.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.NonUniqueResultException;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.eao.taxonomy.TaxonEAOLocal;
import org.inbio.ara.persistence.taxonomy.Taxon;


/**
 *
 * @author jgutierrez
 */
@Stateless
public class TaxonEAOImpl extends BaseEAOImpl<Taxon,Long> implements TaxonEAOLocal {
    
    public Taxon findBySpecimenId(Long specimenId) throws NonUniqueResultException {
        
            Query q = em.createQuery("select i.taxon"
                + " from Identification as i"
                + " where i.identificationPK.specimenId = :specimenId");
            q.setParameter("specimenId", specimenId);
            try
            {
                return (Taxon) q.getSingleResult();
            }
            catch(Exception e)
            {
                return null;
            }
        
    }

    public List<Long> findByTaxonName(String name) {
        StringBuffer query = new StringBuffer();
        query.append("select t.taxonId from Taxon as t where t.defaultName ");
        query.append("like '%"+name+"%'");
        Query q = em.createQuery(query.toString());
        return q.getResultList();
    }

    public List<Taxon> findByTaxononimcalRange(Long taxonomicalRangeId) {
        StringBuffer query = new StringBuffer();
        query.append("from Taxon as t where t.taxonomicalRangeId = :taxonomicalRangeId" +
                " order by t.defaultName");
        Query q = em.createQuery(query.toString());
		q.setParameter("taxonomicalRangeId", taxonomicalRangeId);
        return q.getResultList();
    }

     
    /**
     * Metodo para obtener la lista de taxones con la que puede trabajar un
     * determinado usuario
     * @param userId
     * @return
     */
    public List<Taxon> getTaxonListByUser(Long userId){
        String sql = "Select t ";
              sql += "from Taxon t, UserTaxon ut ";
              sql += "where t.taxonId = ut.userTaxonPK.taxonId and ut.userTaxonPK.userId = :userId";
        Query q = em.createQuery(sql);
		q.setParameter("userId", userId);
        return (List<Taxon>)q.getResultList();
    }

    public List<Taxon> getTaxonListByNomenclaturalGroup(Long nomenclaturalId){
        String sql = "Select t ";
              sql += "from Taxon t, TaxonNomenclaturalGroup tng ";
              sql += "where t.taxonId = tng.taxonNomenclaturalGroupPK.taxonId and tng.taxonNomenclaturalGroupPK.nomenclaturalGroupId = :nomenclaturalId";
        Query q = em.createQuery(sql);
		q.setParameter("nomenclaturalId", nomenclaturalId);
        return (List<Taxon>)q.getResultList();
    }

    /**
     * Obtiene los taxones de especies.Utilizado para crear nuevos
     * registros de especies
     * @return
     */
    public List<Taxon> getAllSpecies(){
        //Taxones de especies,subespecie,variedad,forma con categoria "Aceptados"
        String sql = "Select t "+
                     "from Taxon t "+
                     "where (t.taxonomicalRangeId >=18 and t.taxonomicalRangeId <=22) "+
                     "and t.taxonCategoryId = 1 order by t.defaultName";
        Query q = em.createQuery(sql);
        return (List<Taxon>)q.getResultList();
    }

	/**
	 * returns a list of all the taxon objects that has taxonId parameter value
	 * in the property ancestor_id
	 * @param taxonId
	 * @return List<Taxon>
	 */
    public List<Taxon> findByAncestor(Long taxonId){
        String sql = "Select t "+
                     "from Taxon t "+
                     "where t.ancestorId = :taxonId "+
                     "order by t.defaultName ";

        Query q = em.createQuery(sql);
		q.setParameter("taxonId", taxonId);
        return (List<Taxon>)q.getResultList();
	}

    /**
     * Return the descendant quantity of an specified node (nodeId)
     * @param taxonId
     * @return
     */
    public Long findByAncestorCount(Long taxonId){

        String sql = "Select Count(t) "+
                     "from Taxon t "+
                     "where t.ancestorId = :taxonId ";
        Query q = em.createQuery(sql);
		q.setParameter("taxonId", taxonId);
        return (Long)q.getSingleResult();
	}


    public List<Taxon> getTaxonsByCollectionIdAndTaxonomicalRangeId(Long collectionId, Long taxonomicalRangeId) {
        Query q = em.createQuery("from Taxon t "+
                     " where t.collectionId = :collectionId and " +
                     " t.taxonomicalRangeId = :taxonomicalRangeId");
		q.setParameter("collectionId", collectionId);
                q.setParameter("taxonomicalRangeId", taxonomicalRangeId);
        return (List<Taxon>)q.getResultList();
    }

    public List<Taxon> getTaxonsByKingdomNameAndTaxonomicalRangeId(String kingdomName, Long taxonomicalRangeId)
    {
        Query q = em.createQuery(" select t1 " +
                     " from Taxon t1, Taxon t2 "+
                     " where t1.kingdomTaxonId = t2.taxonId and " +
                     " t2.currentName = '" + kingdomName + "' and " +
                     " t1.taxonomicalRangeId = :taxonomicalRangeId");
                q.setParameter("taxonomicalRangeId", taxonomicalRangeId);
        return (List<Taxon>)q.getResultList();
    }

    /*
     *select t.current_name, tr.taxonomical_hierarchy_level
            from ara.taxon t, ara.taxonomical_range tr
            where t.taxonomical_range_id = tr.taxonomical_range_id
            and t.collection_id = 9
            order by tr.taxonomical_hierarchy_level
            limit 1
     */
    public Taxon getTaxonRootByCollectionId(Long collectionId)
    {
        Query q = em.createQuery(" select t " +
                     " from Taxon t, TaxonomicalRange tr "+
                     " where t.taxonomicalRangeId = tr.taxonomicalRangeId and " +
                     " t.collectionId = :collectionId " +
                     " order by tr.taxonomicalRangeId");               
                q.setParameter("collectionId", collectionId);
                q.setMaxResults(1);
        return (Taxon) q.getSingleResult();
    }


    public Long findTaxonomicalRangeIdByTaxonId(Long taxonId)
    {
        Query q = em.createQuery(" select t.taxonomicalRangeId " +
                     " from Taxon t "+
                     " where t.taxonId = :taxonId");
                q.setParameter("taxonId", taxonId);
                return (Long)q.getSingleResult();

    }

}
