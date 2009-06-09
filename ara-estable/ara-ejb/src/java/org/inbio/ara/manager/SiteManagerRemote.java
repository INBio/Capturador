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

package org.inbio.ara.manager;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.GeographicLayerDTO;
import org.inbio.ara.dto.GeographicLayerValueDTO;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.util.Country;
import org.inbio.ara.persistence.util.Province;
/**
 *
 * @author jgutierrez
 */
@Remote
public interface SiteManagerRemote {

    public static Long COUNTRY_LAYER = new Long(1);
    public static Long PROVINCE_LAYER = new Long(2);


    public List<Country> getAllCountries();

    public GeographicLayerDTO getAllGeographicalLayer(Long geographicLayerId);

    public GeographicLayerValueDTO getAllGeographicalLayerValueForGeographicLayerAndId(Long geographicLayerId, Long geographicLayerValueId);

    public List<GeographicLayerDTO> getAllGeographicalLayers();

    public List<GeographicLayerValueDTO> getAllGeographicalLayerValuesForGeographicLayer(Long geographicLayerId);

    public List<GeographicLayerValueDTO> getAllGeographicalLayerValuesForGeographicLayerAndAncestor(Long geographicLayerId, Long ancestorGeographicValueId);

    public List<Province> getAllProvinces();

    public Country getCountry(Long countryId);

    public Country getCountryForSite(Long siteId);

    public Province getProvince(Long provinceId);

    public Province getProvinceForSite(Long siteId);

    public List<Province> getAllProvincesForContry(Long countryId);

    public void saveOrUpdateGeographicLayerValue(GeographicLayerValueDTO geographicLayerValueDTO);

    public void saveOrUpdateGeoreferenceForSite(Long siteId, Long layerId, Long value);

    public void deleteGeoreferenceForSite(Long siteId, Long layerId);

    public void deleteForSite(Long siteId);

    /**
     * @param firstResult a partir de cual fila comenzara a devolver (la primera fila es la 0)
     * @param maxResults cantidad de elementos a devolver (pueden ser menos)
     * @return
     */
    public List<Site> getSitesPaginated(int firstResult, int maxResults);

    public Integer getAllSitesCount();
}
