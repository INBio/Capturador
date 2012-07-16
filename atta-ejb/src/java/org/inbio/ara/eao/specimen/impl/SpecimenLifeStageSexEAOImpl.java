/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Nacional de Biodiversidad )
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

package org.inbio.ara.eao.specimen.impl;

import java.util.Set;
import org.inbio.ara.eao.specimen.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSex;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSexPK;

/**
 *
 * @author esmata
 */
@Stateless
public class SpecimenLifeStageSexEAOImpl extends BaseEAOImpl<SpecimenLifeStageSex,SpecimenLifeStageSexPK> implements SpecimenLifeStageSexEAOLocal {
    
    public Set<SpecimenLifeStageSex> getAllBySpecimenId(Long specimenId) {
        Query q = em.createQuery("select slss " +
                "from SpecimenLifeStageSex as slss " +
                "where slss.specimenLifeStageSexPK.specimenId = :specimenId");
        q.setParameter("specimenId", specimenId);
        return (Set<SpecimenLifeStageSex>) q.getResultList();
    }
 
}
