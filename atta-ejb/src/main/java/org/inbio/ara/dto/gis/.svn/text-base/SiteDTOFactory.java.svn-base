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


package org.inbio.ara.dto.gis;

import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.gis.GeographicLayerEntity;
import org.inbio.ara.persistence.gis.GeoreferencedSite;
import org.inbio.ara.persistence.gis.Site;

/**
 *
 * @author esmata
 */
public class SiteDTOFactory extends BaseDTOFactory<Site, SiteDTO> {

    public SiteDTO createDTO(Site entity) {
        if(entity==null){
            return null;
        }
        SiteDTO sdto = new SiteDTO();
        sdto.setSiteId(entity.getSiteId());
        sdto.setDescription(entity.getDescription());
        sdto.setCoordinates(entity.getCoordinatesAsString());
        sdto.setCoordinatesList(entity.getSiteCoordinates());
        sdto.setPrecision(entity.getPrecision());
        sdto.setGeodeticDatum(entity.getGeodeticDatum());
        sdto.setFeatureTypeId(entity.getFeatureTypeId());
        sdto.setBaseProjectionId(entity.getBaseProjectionId());
        sdto.setOriginalProjectionId(entity.getOriginalProjectionId());
        sdto.setSiteCalculationMethodId(entity.getSiteCalculationMethodId());
        sdto.setName(entity.getName());

        for(GeoreferencedSite gs : entity.getGeoreferencedSites()){

            if(GeographicLayerEntity.COUNTRY.equals
                    (gs.getGeoreferencedSitePK().getGeographicLayerId()))
                sdto.setCountryId(gs.getGeoreferencedSitePK().getGeographicSiteId());

            else if(GeographicLayerEntity.PROVINCE.equals
                    (gs.getGeoreferencedSitePK().getGeographicLayerId()))
                sdto.setProvinceId(gs.getGeoreferencedSitePK().getGeographicSiteId());
        }
        sdto.setSelected(false); //Inicialmente debe ir en false (no seleccionado)
        return sdto;
    }
    
}
