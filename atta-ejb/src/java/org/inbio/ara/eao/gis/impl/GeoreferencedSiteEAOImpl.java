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

import java.util.List;
import org.inbio.ara.eao.gis.GeoreferencedSiteEAOLocal;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.gis.GeoreferencedSite;
import org.inbio.ara.persistence.gis.GeoreferencedSitePK;

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
 
}
