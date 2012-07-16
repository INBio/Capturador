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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionInstitution;

/**
 *
 * @author esmata
 */
@Stateless
public class TaxonDescriptionInstitutionEAOImpl extends BaseEAOImpl<TaxonDescriptionInstitution,Long>
        implements TaxonDescriptionInstitutionEAOLocal {
    
    //Delete institutions by taxonDesciptionPK
    public void deleteByTaxonDesciptionPK(Long taxonId,Long taxonDescriptionSequenceId) {
        Query q = em.createQuery("delete from TaxonDescriptionInstitution tdi " +
                "where tdi.taxonDescriptionInstitutionPK.taxonId = :taxonId and " +
                "tdi.taxonDescriptionInstitutionPK.taxonDescriptionSequence = :taxonDescriptionSequenceId");
        q.setParameter("taxonId", taxonId);
        q.setParameter("taxonDescriptionSequenceId", taxonDescriptionSequenceId);
        q.executeUpdate();
        em.flush();
    }

    public List<TaxonDescriptionInstitution> getTDInstitutionsByTaxonDescription
            (Long taxonId, Long taxonDescriptionSequence){
        try{
            String sql = "from TaxonDescriptionInstitution tdi ";
            sql += "where tdi.taxonDescriptionInstitutionPK.taxonId = :taxonId " +
                    "and tdi.taxonDescriptionInstitutionPK.taxonDescriptionSequence = :taxonDescriptionSequence";
            Query q = em.createQuery(sql);
            q.setParameter("taxonId", taxonId);
            q.setParameter("taxonDescriptionSequence", taxonDescriptionSequence);
            return (List<TaxonDescriptionInstitution>)q.getResultList();
        }
        catch(Exception e){return null;}
    } 
}
