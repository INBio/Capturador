/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2010  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.inbio.ara.eao.security.impl;

import java.util.List;
import org.inbio.ara.eao.security.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.taxonomy.NomenclaturalGroup;

/**
 *
 * @author esmata
 */
@Stateless
public class NomenclaturalGroupEAOImpl 
        extends BaseEAOImpl<NomenclaturalGroup,Long>
        implements NomenclaturalGroupEAOLocal {
    
    /**
     * Metodo para obtener la lista de grupos con la que puede trabajar un
     * determinado usuario
     * @param userId
     * @return
     */
    public List<NomenclaturalGroup> getNomenclaturalGroupList(Long userId){
        String sql = "Select n ";
               sql += "from NomenclaturalGroup n, UserNomenclaturalGroup un ";
               sql += "where n.nomenclaturalGroupId = " +
                      "un.userNomenclaturalGroupPK.nomenclaturalGroupId" +
                      " and un.userNomenclaturalGroupPK.userId = :userId";
        Query q = em.createQuery(sql);
        q.setParameter("userId", userId);
        return (List<NomenclaturalGroup>)q.getResultList();
    }
 
}
