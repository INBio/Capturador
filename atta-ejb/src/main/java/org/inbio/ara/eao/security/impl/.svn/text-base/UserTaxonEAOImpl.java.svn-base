/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.security.impl;

import java.util.List;
import org.inbio.ara.eao.security.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.taxonomy.UserTaxon;

/**
 *
 * @author esmata
 */
@Stateless
public class UserTaxonEAOImpl extends BaseEAOImpl<UserTaxon,Long> implements UserTaxonEAOLocal {
    
    /**
     * Metodo para obtener la lista de user_taxon relacionada a un
     * usuario especifico
     * @param userId
     * @return
     */
    public List<UserTaxon> getUserTaxonList(Long userId){
        String sql = "Select ut ";
              sql += "from Taxon t, UserTaxon ut ";
              sql += "where t.taxonId = ut.userTaxonPK.taxonId and ut.userTaxonPK.userId = :userId";
        Query q = em.createQuery(sql);
		q.setParameter("userId", userId);
        return (List<UserTaxon>)q.getResultList();
    }

}
