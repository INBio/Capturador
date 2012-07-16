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
import org.inbio.ara.persistence.taxonomy.UserNomenclaturalGroup;

/**
 *
 * @author esmata
 */
@Stateless
public class UserNomenclaturalGroupEAOImpl extends BaseEAOImpl<UserNomenclaturalGroup,Long> implements UserNomenclaturalGroupEAOLocal {
    
    /**
     * Metodo para obtener la lista de user_nomenclatural_gruups para un
     * determinado usuario
     * @param userId
     * @return
     */
    public List<UserNomenclaturalGroup> getNomenclaturalGroupList(Long userId){
        String sql = "Select un ";
              sql += "from NomenclaturalGroup n, UserNomenclaturalGroup un ";
              sql += "where n.nomenclaturalGroupId = un.userNomenclaturalGroupPK.nomenclaturalGroupId" +
                      " and un.userNomenclaturalGroupPK.userId = :userId";
        Query q = em.createQuery(sql);
		q.setParameter("userId", userId);
        return (List<UserNomenclaturalGroup>)q.getResultList();
    }
 
}
