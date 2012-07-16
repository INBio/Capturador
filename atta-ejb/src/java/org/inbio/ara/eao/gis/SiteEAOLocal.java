/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.eao.gis;

import java.util.List;
import javax.ejb.Local;
import org.inbio.ara.eao.BaseLocalEAO;
import org.inbio.ara.persistence.gis.Site;

/**
 *
 * @author jgutierrez
 */
@Local
public interface SiteEAOLocal extends BaseLocalEAO<Site,Long> {

    public List<Long> findByDescription(String siteDescription);

    public List<Long> findByCoordinates(double latitude, double longitude, int radius);

    public java.util.List<java.lang.Long> findByGathObsId(java.lang.Long gathObsId);

    public java.util.List<java.lang.Long> getAllSitesId();

    public java.util.List<org.inbio.ara.persistence.gis.Site> findAllOrdered();

    /**
     * Get Sites for a fragment of a site description. The results are obtain in a given range
     * @param siteDescription
     * @param base
     * @param offset
     * @return List<Site>
     */
    public List<Site> getSiteByDescription(String siteDescription, int base, int offset);

}
