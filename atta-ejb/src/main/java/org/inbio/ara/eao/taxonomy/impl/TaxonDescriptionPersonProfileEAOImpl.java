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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPersonProfile;

/**
 *
 * @author esmata
 */
@Stateless
public class TaxonDescriptionPersonProfileEAOImpl extends BaseEAOImpl<TaxonDescriptionPersonProfile,Long>
        implements TaxonDescriptionPersonProfileEAOLocal {
    
    //Delete authors by taxonDesciptionPK
    public void deleteByTaxonDesciptionPK(Long taxonId,Long taxonDescriptionSequenceId) {
        Query q = em.createQuery("delete from TaxonDescriptionPersonProfile tda " +
                "where tda.taxonDescriptionPersonProfilePK.taxonId = :taxonId and " +
                "tda.taxonDescriptionPersonProfilePK.taxonDescriptionSequence = :taxonDescriptionSequenceId");
        q.setParameter("taxonId", taxonId);
        q.setParameter("taxonDescriptionSequenceId", taxonDescriptionSequenceId);
        q.executeUpdate();
        em.flush();
    }

    public List<TaxonDescriptionPersonProfile> getPersonsByTaxonDescription(Long taxonId,
            Long taxonDescriptionSequence){
        try{
            String sql = "from TaxonDescriptionPersonProfile tdpp ";
            sql += "where tdpp.taxonDescriptionPersonProfilePK.taxonId = :taxonId " +
                    "and tdpp.taxonDescriptionPersonProfilePK.taxonDescriptionSequence = :taxonDescriptionSequence";
            Query q = em.createQuery(sql);
            q.setParameter("taxonId", taxonId);
            q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
            return (List<TaxonDescriptionPersonProfile>)q.getResultList();
        }
        catch(Exception e){return null;}
    } 
}
