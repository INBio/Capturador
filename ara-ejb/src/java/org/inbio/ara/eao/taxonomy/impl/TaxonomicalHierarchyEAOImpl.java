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
package org.inbio.ara.eao.taxonomy.impl;

import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.eao.taxonomy.TaxonomicalHierarchyEAOLocal;
import org.inbio.ara.persistence.taxonomy.TaxonomicalHierarchy;
import org.inbio.ara.persistence.taxonomy.TaxonomicalHierarchyPK;

/**
 *
 * @author asanabria
 */
@Stateless
public class TaxonomicalHierarchyEAOImpl 
        extends BaseEAOImpl<TaxonomicalHierarchy, TaxonomicalHierarchyPK>
        implements TaxonomicalHierarchyEAOLocal {

    public Long findMandatoryIdByAncestor(Long ancestorId) {
        Query q =
                em.createQuery(
                " select t.taxonomicalRange.taxonomicalRangeId" +
                " from TaxonomicalHierarchy as t" +
                " where t.taxonomicalRange.mandatoryLevel = 1 " +
                "  and  t.taxonomicalRangeAncestor.taxonomicalRangeId = " +
                ":ancestorId");

        q.setParameter("ancestorId", ancestorId);
        try {
            return (Long) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
