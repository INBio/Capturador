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

import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.persistence.gis.GeographicLayerEntity;
import org.inbio.ara.persistence.gis.GeoreferencedSite;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.gis.SiteCoordinate;

/**
 *
 * @author esmata
 */
public class SiteDTOFactory extends BaseEntityOrDTOFactory<Site, SiteDTO> {
    
    private SiteCoordinateDTOFactory siteCoordinateDTOFactory = new SiteCoordinateDTOFactory();
    

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
        
        sdto.setCoordinatesListDTO(siteCoordinateDTOFactory.createDTOList(entity.getSiteCoordinates()));

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

    @Override
    public Site getEntityWithPlainValues(SiteDTO dto) {
        if(dto == null) return null;
        System.out.println("Desde el Factory ="+dto.getUserName());
        Site newSite = new Site();
        newSite.setBaseProjectionId(dto.getBaseProjectionId());
        newSite.setDescription(dto.getDescription());
        newSite.setFeatureTypeId(dto.getFeatureTypeId());
        newSite.setGeodeticDatum(dto.getGeodeticDatum());
        newSite.setName(dto.getName());
        newSite.setOriginalProjectionId(dto.getOriginalProjectionId());
        newSite.setPrecision(dto.getPrecision());
        newSite.setSiteCalculationMethodId(dto.getSiteCalculationMethodId());
        newSite.setSiteId(  dto.getSiteId());     
        
        //Estos se persisten por aparte en el Facade
        newSite.setSiteCoordinates(new ArrayList<SiteCoordinate>());      
        
        
        newSite.setGeoreferencedSites(new ArrayList<GeoreferencedSite>());
        System.out.println("Desde el Factory, antes del return ="+newSite.getCreatedBy());
        return newSite;
        
    }

    @Override
    public Site updateEntityWithPlainValues(SiteDTO dto, Site e) {
        if(dto == null || e == null) return null;
        e.setBaseProjectionId(dto.getBaseProjectionId());
        e.setDescription(dto.getDescription());
        e.setFeatureTypeId(dto.getFeatureTypeId());
        e.setGeodeticDatum(dto.getGeodeticDatum());
        e.setName(dto.getName());
        e.setOriginalProjectionId(dto.getOriginalProjectionId());
        e.setPrecision(dto.getPrecision());
        e.setSiteCalculationMethodId(dto.getSiteCalculationMethodId());
        e.setSiteId(dto.getSiteId());     
        
        //Estos se persisten por aparte en el Facade
        e.setSiteCoordinates(new ArrayList<SiteCoordinate>());      
        
        e.setGeoreferencedSites(new ArrayList<GeoreferencedSite>());
        
        return e;
        
    }
    
}
