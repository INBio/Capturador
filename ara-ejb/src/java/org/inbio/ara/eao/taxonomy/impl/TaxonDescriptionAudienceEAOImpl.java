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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionAudience;

/**
 *
 * @author esmata
 */
@Stateless
public class TaxonDescriptionAudienceEAOImpl extends BaseEAOImpl<TaxonDescriptionAudience,Long>
        implements TaxonDescriptionAudienceEAOLocal {
    
    //Delete audiendes by taxonDesciptionPK
    public void deleteByTaxonDesciptionPK(Long taxonId,Long taxonDescriptionSequenceId) {
        Query q = em.createQuery("delete from TaxonDescriptionAudience tda " +
                "where tda.taxonDescriptionAudiencePK.taxonId = :taxonId and " +
                "tda.taxonDescriptionAudiencePK.taxonDescriptionSequence = :taxonDescriptionSequenceId");
        q.setParameter("taxonId", taxonId);
        q.setParameter("taxonDescriptionSequenceId", taxonDescriptionSequenceId);
        q.executeUpdate();
        em.flush();
    }

    public List<TaxonDescriptionAudience> getTDAudiencesByTaxonDescription(Long taxonId,
            Long taxonDescriptionSequence){
        try{
            String sql = "from TaxonDescriptionAudience tda ";
            sql += "where tda.taxonDescriptionAudiencePK.taxonId = :taxonId " +
                    "and tda.taxonDescriptionAudiencePK.taxonDescriptionSequence = :taxonDescriptionSequence";
            Query q = em.createQuery(sql);
            q.setParameter("taxonId", taxonId);
            q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
            return (List<TaxonDescriptionAudience>) q.getResultList();
        }
        catch(Exception e){return null;}
    } 
}
