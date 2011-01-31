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

package org.inbio.ara.eao.gis.impl;

import java.util.List;
import org.inbio.ara.eao.gis.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.dto.gis.GeographicLayerDTO;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gis.Province;

/**
 *
 * @author esmata
 */
@Stateless
public class ProvinceEAOImpl extends BaseEAOImpl<Province,Long> implements ProvinceEAOLocal {
    
    public List<GeographicLayerDTO> getProvincesByCountry(Long countryId) {
        Query query = em.createQuery("select new org.inbio.ara.dto.gis.GeographicLayerDTO(p.value,p.provinceId) from Province as p where p.countryId = :param");
        query.setParameter("param", (Long)countryId);
        return query.getResultList();
    }

    public List<Province> listAllByContryId(Long countryId) {
        Query q = em .createQuery("select p"
                                + " from Province as p"
                                + " where p.countryId = :countryId"
                                + " order by p.value");
        q.setParameter("countryId", countryId);
        return q.getResultList();
    }

    public List<Province> listAll(){
        Query q = em .createQuery("select p from Province as p order by p.value asc");
        return q.getResultList();
    }
}
