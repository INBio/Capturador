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
import org.inbio.ara.persistence.germplasm.Breed;

/**
 *
 * @author dasolano
 */
@Stateless
public class BreedEAOImpl extends BaseEAOImpl<Breed, Long> implements BreedEAOLocal  {

    public List<Long> findByBreedName(String breedName) {
        Query q = em.createQuery(
                " Select b.breedId " +
                " from Breed b " +
                " where lower(b.name) like '%"+breedName.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }

    public List<Long> findByScientificName(String scientificName) {
        Query q = em.createQuery(
                " Select b.breedId " +
                " from Breed b, Taxon t " +
                " where b.taxonId = t.taxonId and " +
                " lower(t.defaultName) like '%"+ scientificName.toLowerCase() +"%'"
               );
        return  q.getResultList();
    }
    
 
}
