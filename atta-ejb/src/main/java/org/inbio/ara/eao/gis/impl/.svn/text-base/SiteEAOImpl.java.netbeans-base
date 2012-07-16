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
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.eao.gis.SiteEAOLocal;
import org.inbio.ara.persistence.gis.Site;

/**
 *
 * @author jgutierrez
 */
@Stateless
public class SiteEAOImpl extends BaseEAOImpl<Site,Long> implements SiteEAOLocal {
    /**
     * Ej.
     * select * from ara.site where lower(site.description) like '%victoria%';
     * @param siteDescription Pattern to search
     * @return Sites with a similar description
     */
    public List<Long> findByDescription(String siteDescription) {
        Query q = em.createQuery("select s.siteId from Site as s " +
                "where lower(s.description) like '%" +
                siteDescription.toLowerCase() +"%'");
        return q.getResultList();
    }

    public List<Long>
            findByCoordinates(double latitude, double longitude, int radius) {
        final double COORDS2MTS = 30.5;
        String latDifference = "( ("+latitude+"*3600) - (sc.latitude*3600))";
        String lonDifference = "( ("+longitude+"*3600) - (sc.longitude*3600))";
        Query q = em.createQuery("select sc.site.siteId from SiteCoordinate as sc" +
                " where sqrt("+ latDifference+" * "+ latDifference + " + " +
                    lonDifference+" * "+ lonDifference+") *" + COORDS2MTS +
                    " <= " + radius + ")");
        return q.getResultList();
    }

    public List<Long> findByGathObsId(Long gathObsId) {
        Query q = em.createQuery("select go.site.siteId " +
                "from GatheringObservation as go"
                + " where go.gatheringObservationId = :gathObsId");
        q.setParameter("gathObsId", gathObsId);
        return q.getResultList();
    }

    /**
     * Get all sites id
     * @return List of sites id
     */
    public List<Long> getAllSitesId() {
        Query q = em.createQuery("select s.siteId from Site s");
        return q.getResultList();
    }

    /**
     * Ordenados alfabeticamente
     * @return
     */
    public List<Site> findAllOrdered(){
        Query q = em.createQuery("from Site s order by s.description");
        return q.getResultList();
    }
    
    public List<Site> getSiteByDescription(String siteDescription, int base, int offset)
    {
        Query q = em.createQuery(
                " from Site as s " +
                " where lower(s.description) like :siteDescription");

        q.setParameter("siteDescription", "%"+siteDescription.toLowerCase()+"%");
        q.setFirstResult(base);
        q.setMaxResults(offset);
        return q.getResultList();
    }

}
