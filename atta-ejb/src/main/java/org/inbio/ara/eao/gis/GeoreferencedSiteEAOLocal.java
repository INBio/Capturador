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

package org.inbio.ara.eao.gis;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.gis.GeoreferencedSite;
import org.inbio.ara.persistence.gis.GeoreferencedSitePK;

/**
 *
 * @author herson
 */
@Local
public interface GeoreferencedSiteEAOLocal
        extends BaseLocalEAO<GeoreferencedSite, GeoreferencedSitePK>  {

    public java.util.List<java.lang.Long> findSiteByGeoLayerId(java.lang.Long geoLayerType, java.lang.Long geoLayerId);

    public java.util.List<org.inbio.ara.persistence.gis.GeoreferencedSite> findAllBySiteAndLayer(java.lang.Long siteId, java.lang.Long layerId);

    public void deleteBySiteId(Long sId);
    
}
