/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy.impl;



import org.inbio.ara.persistence.taxonomy.TaxonIndicatorCountry;
import java.util.List;
import org.inbio.ara.eao.taxonomy.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gis.Country;


/**
 *
 * @author gsulca
 */
@Stateless
public class TaxonIndicatorCountryEAOImpl extends BaseEAOImpl<TaxonIndicatorCountry,Long> implements TaxonIndicatorCountryEAOLocal {


     public List<Long> findCountriesByTaxonIndicatorIds(Long taxonId, Long indicatorId)
    {
        StringBuffer query = new StringBuffer();
        query.append("select tic.taxonIndicatorCountryPK.countryId from TaxonIndicatorCountry as tic"+
                " where tic.taxonIndicatorCountryPK.taxonId = :taxonId "
                +" and tic.taxonIndicatorCountryPK.indicatorId = :indicatorId");
        Query q = em.createQuery(query.toString());
        q.setParameter("taxonId", taxonId);
        q.setParameter("indicatorId", indicatorId);

        return q.getResultList();
    }

    public void deleteTaxonIndicatorCountryById(Long taxonId, Long indicatorId, Long countryId)
    {
        Query q = em.createQuery(
                " delete from TaxonIndicatorCountry tic " +
                " where tic.taxonIndicatorCountryPK.indicatorId = :indicatorId and tic.taxonIndicatorCountryPK.taxonId = :taxonId and tic.taxonIndicatorCountryPK.countryId = :countryId");
        q.setParameter("indicatorId", indicatorId);
        q.setParameter("taxonId", taxonId);
        q.setParameter("countryId", countryId);
        q.executeUpdate();
        em.flush();
    }

    public void deleteTaxonIndicatorCountryByTaxonId(Long taxonId)
    {
        Query q = em.createQuery(
                " delete from TaxonIndicatorCountry tic " +
                " where tic.taxonIndicatorCountryPK.taxonId = :taxonId");

        q.setParameter("taxonId", taxonId);
        q.executeUpdate();
        em.flush();
    }

    public void deleteTaxonIndicatorCountryByTaxonIndicator(Long taxonId, Long indicatorId)
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


}
