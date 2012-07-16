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
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecordReference;

/**
 *
 * @author esmata
 */
@Stateless
public class TaxonDescriptionRecordReferenceEAOImpl 
        extends BaseEAOImpl<TaxonDescriptionRecordReference, Long>
        implements TaxonDescriptionRecordReferenceEAOLocal {
    
    public List<TaxonDescriptionRecordReference> getTaxonDescriptionRecordReference
            (Long taxonDescriptionRecordId){
        try{
            String hql = "from TaxonDescriptionRecordReference as o ";
            hql += "where o.taxonDescriptionRecordReferencePK.taxonDescriptionRecordId= :taxonDescriptionRecordId";
            Query q = em.createQuery(hql);
            q.setParameter("taxonDescriptionRecordId", taxonDescriptionRecordId);
            return (List<TaxonDescriptionRecordReference>)q.getResultList();
        }
        catch(Exception e){return null;}
    }
 
}
