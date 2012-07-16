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

package org.inbio.ara.eao.gis;

import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.gis.Country;

/**
 *
 * @author esmata
 */
@Local
public interface CountryEAOLocal extends BaseLocalEAO<Country,Long>{

    @Deprecated
    public java.util.List<org.inbio.ara.dto.gis.GeographicLayerDTO> getAllCountries();

    public java.util.List<org.inbio.ara.persistence.gis.Country> allCountryOrderByValue();

    public java.util.List<org.inbio.ara.persistence.gis.Country> listAll();
    
}
