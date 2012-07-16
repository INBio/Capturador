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
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.germplasm.Accession;

/**
 *
 * @author dasolano
 */
@Stateless
public class AccessionEAOImpl extends BaseEAOImpl<Accession, Long> implements AccessionEAOLocal {

    public List<Long> findByAccessionNumber(String accessionNumber) {
        Query q = em.createQuery(
                " Select a.accessionId " +
                " from Accession as a " +
                " where a.accessionNumber = :accessionNumber "
               );
        q.setParameter("accessionNumber", accessionNumber);
        return  q.getResultList();
    }

    public List<Long> findByPackages(Long packages) {
        Query q = em.createQuery(
                " Select a.accessionId " +
                " from Accession as a " +
                " where a.packages = :packages "
               );
        q.setParameter("packages", packages);
        return  q.getResultList();
    }

    public List<Long> findByOriginalWeigth(Long originalWeigth) {
        Query q = em.createQuery(
                " Select a.accessionId " +
                " from Accession as a " +
                " where a.originalWeigth = :originalWeigth "
               );
        q.setParameter("originalWeigth", originalWeigth);
        return  q.getResultList();
    }

    public List<Long> findByCurrentWeigth(Long currentWeigth) {
        Query q = em.createQuery(
                " Select a.accessionId " +
                " from Accession as a " +
                " where a.currentWeigth = :currentWeigth "
               );
        q.setParameter("currentWeigth", currentWeigth);
        return  q.getResultList();
    }

    public List<Long> findByPassportId(Long passportId) {
        Query q = em.createQuery(
                " Select a.accessionId " +
                " from Accession as a " +
                " where a.passportId = :passportId "
               );
        q.setParameter("passportId", passportId);
        return  q.getResultList();
    }

    public List<Long> findByResponsablePersonId(Long responsablePersonId) {
        Query q = em.createQuery(
                " Select a.accessionId " +
                " from Accession as a " +
                " where a.responsablePersonId = :responsablePersonId "
               );
        q.setParameter("responsablePersonId", responsablePersonId);
        return  q.getResultList();
    }

    public List<Long> findByAccessionParentId(Long accessionParentId) {
        Query q = em.createQuery(
                " Select a.accessionId " +
                " from Accession as a " +
                " where a.accessionParentId = :accessionParentId "
               );
        q.setParameter("accessionParentId", accessionParentId);
        return  q.getResultList();
    }

    public List<Long> findByGerminationMethodId(Long germinationMethodId) {
        Query q = em.createQuery(
                " Select a.accessionId " +
                " from Accession as a " +
                " where a.germinationMethodTypeId = :germinationMethodId "
               );
        q.setParameter("germinationMethodTypeId", germinationMethodId);
        return  q.getResultList();
    }

    public List<Long> findByGerminationRate(Long germinationRate)
    {
        Query q = em.createQuery(
                " Select a.accessionId " +
                " from Accession as a " +
                " where a.germinationRate = :germinationRate "
               );
        q.setParameter("germinationRate", germinationRate);
        return  q.getResultList();
    }
 
}
