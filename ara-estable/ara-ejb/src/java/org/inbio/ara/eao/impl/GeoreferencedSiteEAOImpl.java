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
import org.inbio.ara.eao.GeoreferencedSiteLocalEAO;
import org.inbio.ara.persistence.gis.GeoreferencedSite;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class GeoreferencedSiteEAOImpl extends BaseEAOImpl implements GeoreferencedSiteLocalEAO{

    
    @Override
    public List<GeoreferencedSite> findAllBySiteId(Long siteId) {
        Query q = em.createQuery("select gs"
                + " from GeoreferencedSite as gs"
                + " where gs.georeferencedSitePK.siteId = :siteId");
        q.setParameter("siteId", siteId);
        return q.getResultList();
    }

    @Override
    public List<GeoreferencedSite> findAllBySiteAndLayer(Long siteId, Long layerId) {
        Query q = em.createQuery("select gs"
                + " from GeoreferencedSite as gs"
                + " where gs.georeferencedSitePK.siteId = :siteId"
                + " and gs.georeferencedSitePK.geographicLayerId  = :layerId");
        q.setParameter("siteId", siteId);
        q.setParameter("layerId", layerId);
        return q.getResultList();
    }

}
