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
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.ProvinceLocalEAO;
import org.inbio.ara.persistence.util.Province;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class ProvinceEAOImpl extends BaseEAOImpl implements ProvinceLocalEAO{

    
    /**
     * 
     * @return
     */
    public List<Province> listAll(){

        Query q = em .createQuery("select p from Province as p");
        return q.getResultList();
    }

    @Override
    public List<Province> listAllByContryId(Long countryId) {
        Query q = em .createQuery("select p"
                + " from Province as p"
                + " where p.country.id = :countryId");
        q.setParameter("countryId", countryId);
        return q.getResultList();
    }

}
