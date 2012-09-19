/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.eao.gis.GeoreferencedSiteEAOLocal;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.dto.gis.SiteCoordinateDTO;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gis.FeatureTypeEnum;
import org.inbio.ara.persistence.gis.GeoreferencedSite;
import org.inbio.ara.persistence.gis.GeoreferencedSitePK;
import org.inbio.ara.persistence.gis.SiteCoordinate;

/**
 *
 * @author herson
 */
@Stateless
public class GeoreferencedSiteEAOImpl 
        extends BaseEAOImpl<GeoreferencedSite, GeoreferencedSitePK>
        implements GeoreferencedSiteEAOLocal {

    /**
     * Ej. findSiteByGeoLayerId(GeographicLayerEntity.PROVINCE.getId(), 3L);
     * @param geoLayerType Ej. country, province, etc.
     * @param geoLayerId countryId, provinceId, etc
     * @return List of siteIds within the geographical layer
     */
    public List<Long> findSiteByGeoLayerId(Long geoLayerType, Long geoLayerId) {
        StringBuffer query = new StringBuffer();
        query.append("select gs.georeferencedSitePK.siteId from " +
                "GeoreferencedSite as gs where gs.georeferencedSitePK." +
                   "geographicLayerId = " + geoLayerType +  " AND " +
                   "gs.georeferencedSitePK.geographicSiteId = :geoLayerId");
        Query q = em.createQuery(query.toString());
        q.setParameter("geoLayerId", geoLayerId);
        return q.getResultList();
    }

    public List<GeoreferencedSite> findAllBySiteAndLayer(Long siteId, Long layerId) {
        Query q = em.createQuery("select gs"
                + " from GeoreferencedSite as gs"
                + " where gs.georeferencedSitePK.siteId = :siteId"
                + " and gs.georeferencedSitePK.geographicLayerId  = :layerId");
        q.setParameter("siteId", siteId);
        q.setParameter("layerId", layerId);
        return q.getResultList();
    }

    public void deleteBySiteId(Long sId){
        Query q = em.createQuery("delete from GeoreferencedSite gs " +
                "where gs.georeferencedSitePK.siteId = :sId");
        q.setParameter("sId", sId);
        q.executeUpdate();
        em.flush();
    }
 
    
    public List<String> findGeoreferencedSitesByCoordinate(String tableName, String mainKey,List<SiteCoordinateDTO> coordinates, Long type)
    {
                
        List<String> result = new ArrayList<String>();
        
        String georeferencedString = "";
        String coordinatesString ="";
        
        //String georeferencedPoint ="select "+mainKey+" from "+tableName+"  where ST_Intersects(the_geom, ST_GEOMFROMEWKT('SRID=4326;POINT("+coordinatesString+")'));";
        //String georeferencedLine ="select "+mainKey+" from "+tableName+"  where ST_Intersects(gadm.the_geom, ST_GEOMFROMEWKT('SRID=4326;LINESTRING("+coordinatesString+")'));";
        //String georeferencedPolygon ="select "+mainKey+" from "+tableName+"  where ST_Intersects(the_geom, ST_GEOMFROMEWKT('SRID=4326;POLYGON(("+coordinatesString+"))'));";
        //Connection connPostgis;
        
        if(type.equals(FeatureTypeEnum.POINT.getId()))
        {
            
            coordinatesString = coordinates.get(0).getLongitude()+" "+coordinates.get(0).getLatitude();
            
            georeferencedString = "select distinct("+mainKey+") from "+tableName+"  where ST_Intersects(the_geom, ST_GEOMFROMEWKT('SRID=4326;POINT("+coordinatesString+")'));";;
        }
        
        if(type.equals(FeatureTypeEnum.LINE.getId()))
        {
            for(SiteCoordinateDTO siteCoordinate: coordinates)
            {
                coordinatesString += siteCoordinate.getLongitude()+" "+siteCoordinate.getLatitude()+",";
                
            }
            coordinatesString = coordinatesString.substring(0, coordinatesString.length()-1);
            georeferencedString = "select distinct("+mainKey+") from "+tableName+"  where ST_Intersects(the_geom, ST_GEOMFROMEWKT('SRID=4326;LINESTRING("+coordinatesString+")'));";
        }
        
        if(type.equals(FeatureTypeEnum.POLYGON.getId()))
        {
            for(SiteCoordinateDTO siteCoordinate: coordinates)
            {
                coordinatesString += siteCoordinate.getLongitude()+" "+siteCoordinate.getLatitude()+",";
                
            }
            coordinatesString += coordinates.get(0).getLongitude()+" "+coordinates.get(0).getLatitude();
            georeferencedString = "select distinct("+mainKey+") from "+tableName+"  where ST_Intersects(the_geom, ST_GEOMFROMEWKT('SRID=4326;POLYGON(("+coordinatesString+"))'));";
        }
        
        try
        { 
            Query reprojectionQuery = em.createNativeQuery(georeferencedString);
            
            result = reprojectionQuery.getResultList();            
            
        }
        catch(Exception e)
        {
            System.out.println(georeferencedString);
            System.out.println("Error al realizar la consulta;");
            e.printStackTrace();            
        }
        return result;
    }
    
}
