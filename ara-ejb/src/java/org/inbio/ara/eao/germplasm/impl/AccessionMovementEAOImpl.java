/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.eao.germplasm.impl;

import java.util.Date;
import java.util.List;
import org.inbio.ara.eao.germplasm.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.germplasm.AccessionMovement;

/**
 *
 * @author dasolano
 */
@Stateless
public class AccessionMovementEAOImpl extends BaseEAOImpl<AccessionMovement, Long> implements AccessionMovementEAOLocal {

    public List<AccessionMovement> findAllPaginatedByAccessionId(Long accessionId) {
        Query q = em.createQuery(
                " from AccessionMovement as a " +
                " where a.accessionMovementPK.accessionId = :accessionId "
               );
        q.setParameter("accessionId", accessionId);
        return  q.getResultList();
    }

    public Long countAllByAccessionId(Long accessionId) {
        Query q = em.createQuery(
                " Select count(a.accessionMovementPK.accessionId) " +
                " from AccessionMovement as a " +
                " where a.accessionMovementPK.accessionId = :accessionId "
               );
        q.setParameter("accessionId", accessionId);
        return  (Long)q.getSingleResult();
    }

    public AccessionMovement findByAccessionIdAndDateTime(Long accessionId, Date datetimeAux) {
        Query q = em.createQuery(
                " from AccessionMovement as a " +
                " where a.accessionMovementPK.accessionId = :accessionId and" +
                " a.accessionMovementPK.accessionMovementDate =:datetimeAux"
               );
        q.setParameter("accessionId", accessionId);
        q.setParameter("datetimeAux", datetimeAux);
        return  (AccessionMovement)q.getResultList().get(0);
    }
    
}
