/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
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

package org.inbio.ara.eao.gathering.impl;

import org.inbio.ara.eao.gathering.*;
import javax.ejb.Stateless;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gathering.CollectionProtocol;
import javax.persistence.Query;

/**
 *
 * @author esmata
 */
@Stateless
public class CollectionProtocolEAOImpl extends BaseEAOImpl<CollectionProtocol,Long> implements CollectionProtocolEAOLocal {
    
    /**
     * To get a specific entry by PK = collectionId,protocolAtributeId
     * En este caso especifico ocupo que retorne null en caso de que
     * no encuentre coincidencias (que en realidad es una unica coincidencia)
     */
    public CollectionProtocol findCollectionProtocolByPK(Long collectionId,Long protocolAtributeId){
        try{
            Query q = em.createQuery("from CollectionProtocol cp " +
                    "where cp.collectionProtocolPK.collectionId = :colleId and " +
                    "cp.collectionProtocolPK.protocolAttributeId = :proId");
            q.setParameter("colleId", collectionId);
            q.setParameter("proId", protocolAtributeId);
            return (CollectionProtocol)q.getSingleResult();
        }
        catch(Exception e){return null;}
    } 
}
