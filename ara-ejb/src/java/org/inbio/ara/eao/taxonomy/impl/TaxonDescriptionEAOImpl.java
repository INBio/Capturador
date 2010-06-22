/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy.impl;

import java.util.List;
import org.inbio.ara.eao.taxonomy.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPK;

/**
 *
 * @author esmata
 */
@Stateless
public class TaxonDescriptionEAOImpl  extends BaseEAOImpl<TaxonDescription,Long>
        implements TaxonDescriptionEAOLocal {

    /**
     * This count was implemented because de count() method in BaseEAOImpl doesn't
     * work with entities that hava a java class as PK
     * @return
     */
    public Long countByPK(){
        Query q = em.createQuery("select count (td.taxonDescriptionPK.taxonId) from TaxonDescription as td");
        Long result = (Long)q.getSingleResult();
        return result;
    }

    public TaxonDescription findByPK(Long taxonId,Long sequence){
        try{
            Query q = em.createQuery("from TaxonDescription td where td.taxonDescriptionPK.taxonId = :taxonId "+
                                     "and td.taxonDescriptionPK.taxonDescriptionSequence = :sequence");
            q.setParameter("sequence", sequence);
            q.setParameter("taxonId", taxonId);
            TaxonDescription result = (TaxonDescription)q.getSingleResult();
            return result;
        }
        catch(Exception e){return null;}
    }

    public List<TaxonDescriptionPK> findByTaxonName(String taxonName) {
        Query q = em.createQuery(
                " select td.taxonDescriptionPK " +
                " from TaxonDescription td " +
                " where lower(td.taxon.defaultName) like '%"+ taxonName.toLowerCase() +"%' " +
                " order by td.taxon.defaultName");
        return q.getResultList();
    }

    public List<TaxonDescriptionPK> findByKingdomId(Long kingdomId) {
        Query q = em.createQuery(
                " select td.taxonDescriptionPK " +
                " from TaxonDescription td " +
                " where td.taxon.kingdomTaxonId = :kingdomId " +
                " order by td.taxon.defaultName");
        q.setParameter("kingdomId", kingdomId);
        return q.getResultList();
    }

    public List<TaxonDescriptionPK> findByFamilyId(Long familyId) {
        Query q = em.createQuery(
                " select td.taxonDescriptionPK " +
                " from TaxonDescription td " +
                " where td.taxon.familyTaxonId = :familyId " +
                " order by td.taxon.defaultName");
        q.setParameter("familyId", familyId);
        return q.getResultList();
    }

    public List<TaxonDescriptionPK> findByCreatedBy(String createdBy) {
        Query q = em.createQuery(
                " select td.taxonDescriptionPK " +
                " from TaxonDescription td " +
                " where lower(td.createdBy) like '%"+ createdBy.toLowerCase() +"%' " +
                " order by td.taxon.defaultName");
        return q.getResultList();
    }

    public List<TaxonDescriptionPK> findBySequence(Long sequence) {
        Query q = em.createQuery(
                " select td.taxonDescriptionPK " +
                " from TaxonDescription td " +
                " where td.taxonDescriptionPK.taxonDescriptionSequence = :sequence " +
                " order by td.taxon.defaultName");
        q.setParameter("sequence", sequence);
        return q.getResultList();
    }
 
}
