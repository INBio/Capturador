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
import org.inbio.ara.persistence.gis.Country;

/**
 *
 * @author esmata
 */
@Stateless
public class CountryEAOImpl extends BaseEAOImpl<Country,Long> implements CountryEAOLocal {

    @Deprecated
    public List<GeographicLayerDTO> getAllCountries() {
        Query query = em.createQuery("select new org.inbio.ara.dto.gis.GeographicLayerDTO(c.value,c.countryId) from Country as c");
        return query.getResultList();
    }

    public List<Country> allCountryOrderByValue(){
        Query q = em.createQuery("from Country order by value");
        return (List<Country>)q.getResultList();
    }

    public List<Country> listAll(){
        Query q = em .createQuery("select c from Country as c order by c.value asc");
        return q.getResultList();
    }
 
}
