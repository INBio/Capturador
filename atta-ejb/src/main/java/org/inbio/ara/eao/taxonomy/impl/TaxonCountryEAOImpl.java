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
import org.inbio.ara.persistence.taxonomy.TaxonCountry;

/**
 *
 * @author gsulca
 */
@Stateless
public class TaxonCountryEAOImpl extends BaseEAOImpl<TaxonCountry,Long> implements TaxonCountryEAOLocal {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    public List<TaxonCountry> findCountriesByTaxonId(Long taxonId)
    {
        System.out.println("taxonId = "+taxonId );
        StringBuffer query = new StringBuffer();
        query.append("select tc from TaxonCountry as tc"+
                " where tc.taxonCountryPK.taxonId = :taxonId "
                );
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);

        return q.getResultList();
    }

    public void deleteTaxonCountryById(Long taxonId, Long countryId)
    {
        Query q = em.createQuery(
                " delete from TaxonCountry tc " +
                " where tc.taxonCountryPK.taxonId = :taxonId and tc.taxonCountryPK.countryId = :countryId");

        q.setParameter("taxonId", taxonId);
        q.setParameter("countryId", countryId);
        q.executeUpdate();
        em.flush();
    }

    public void deleteTaxonCountryByTaxonId(Long taxonId)
    {
        Query q = em.createQuery(
                " delete from TaxonCountry tc " +
                " where tic.taxonCountryPK.taxonId = :taxonId");

        q.setParameter("taxonId", taxonId);
        q.executeUpdate();
        em.flush();
    }


    public TaxonCountry findTaxonCountryByTaxonCountryIds(Long taxonId, Long countryId)
    {
        StringBuffer query = new StringBuffer();
        query.append("select tc from TaxonCountry as tc"+
                " where tc.taxonCountryPK.taxonId = :taxonId"+
                " and tc.taxonCountryPK.countryId = :countryId");
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);
        q.setParameter("countryId", countryId);

        return (TaxonCountry)q.getSingleResult();
    }



    /*
    public void deleteTaxonCountryByTaxon(Long taxonId, Long indicatorId)
    {
        Query q = em.createQuery(
                " delete from TaxonIndicatorCountry tic " +
                " where tic.taxonIndicatorCountryPK.indicatorId = :indicatorId"+
                " and tic.taxonIndicatorCountryPK.taxonId = :taxonId");

        q.setParameter("indicatorId", indicatorId);
        q.setParameter("taxonId", taxonId);
        q.executeUpdate();
        em.flush();
    }
*/
 
}
