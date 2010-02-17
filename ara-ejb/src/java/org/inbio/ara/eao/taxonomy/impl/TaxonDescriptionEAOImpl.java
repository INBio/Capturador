/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.taxonomy.impl;

import org.inbio.ara.eao.taxonomy.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.taxonomy.TaxonDescription;

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
 
}
