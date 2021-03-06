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

import java.util.List;
import org.inbio.ara.eao.germplasm.*;
import javax.ejb.Stateless;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.germplasm.PassportNomenclaturalGroup;
import javax.persistence.Query;

/**
 *
 * @author dasolano
 */
@Stateless
public class PassportNomenclaturalGroupEAOImpl
        extends BaseEAOImpl<PassportNomenclaturalGroup, Long>
        implements PassportNomenclaturalGroupEAOLocal {


    /**
     * Get all passportNomenclaturalGroups  by passportId
     * @param passportId
     * @return
     */
    public List<PassportNomenclaturalGroup> getAllByPassportId(Long passportId)
    {
        Query q = em.createQuery(
                " from PassportNomenclaturalGroup as png " +
                " where png.passportNomenclaturalGroupPK.passportId = :passportId");
        q.setParameter("passportId", passportId);
        return q.getResultList();
    }


    /**
     * Delete all NomenclaturalGroups associated to a passport
     * @param passportId
     */
    public void deleteByPassportId(Long passportId)
    {
        Query q = em.createQuery(
                " delete from PassportNomenclaturalGroup png " +
                " where png.passportNomenclaturalGroupPK.passportId = :passportId");
        q.setParameter("passportId", passportId);
        q.executeUpdate();
        em.flush();
    }



}