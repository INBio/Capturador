/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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

package org.inbio.ara.eao.impl;

import java.util.List;
import org.inbio.ara.eao.SpecimenLocalEAO;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.persistence.specimen.Specimen;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class SpecimenEAOImpl extends BaseEAOImpl implements SpecimenLocalEAO{


    /**
     * @deprecated
     * @param specimenId
     * @return
     */
    public Specimen getSpecimenById(Long specimenId) {
        Query q = em.createQuery("select s " +
                "from Specimen as s " +
                "where s.id = :specimenId");
        q.setParameter("specimenId", specimenId);
        return (Specimen) q.getSingleResult();
    }
    
    /**
     * 
     * @return
     */
    public List<Specimen> findAll() {
        Query q = em.createQuery("from Specimen as o");
		return q.getResultList();
    }

    public Specimen getSpecimenByCatalogNumber(Long catalogNumber) {
        try {
            Query q = em.createQuery("from Specimen as s " +
                    "where s.catalogNumber = :catalogNumber");
            q.setParameter("catalogNumber", catalogNumber);
            return (Specimen) q.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.err.println(e.toString());
            return null;
        } catch (javax.persistence.NonUniqueResultException e2) {
            System.err.println(e2.toString());
            return null;
        }
    }

}
