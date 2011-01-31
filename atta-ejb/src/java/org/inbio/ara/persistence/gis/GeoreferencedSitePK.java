/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gis;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jgutierrez
 */
@Embeddable
public class GeoreferencedSitePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "site_id")
    private Long siteId;
    @Basic(optional = false)
    @Column(name = "geographic_layer_id")
    private Long geographicLayerId;
    @Basic(optional = false)
    @Column(name = "geographic_site_id")
    private Long geographicSiteId;

    public GeoreferencedSitePK() {
    }

    public GeoreferencedSitePK(Long siteId, Long geographicLayerId, Long geographicSiteId) {
        this.siteId = siteId;
        this.geographicLayerId = geographicLayerId;
        this.geographicSiteId = geographicSiteId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getGeographicLayerId() {
        return geographicLayerId;
    }

    public void setGeographicLayerId(Long geographicLayerId) {
        this.geographicLayerId = geographicLayerId;
    }

    public Long getGeographicSiteId() {
        return geographicSiteId;
    }

    public void setGeographicSiteId(Long geographicSiteId) {
        this.geographicSiteId = geographicSiteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteId != null ? siteId.hashCode() : 0);
        hash += (geographicLayerId != null ? geographicLayerId.hashCode() : 0);
        hash += (geographicSiteId != null ? geographicSiteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeoreferencedSitePK)) {
            return false;
        }
        GeoreferencedSitePK other = (GeoreferencedSitePK) object;
        if ((this.siteId == null && other.siteId != null) || (this.siteId != null && !this.siteId.equals(other.siteId))) {
            return false;
        }
        if ((this.geographicLayerId == null && other.geographicLayerId != null) || (this.geographicLayerId != null && !this.geographicLayerId.equals(other.geographicLayerId))) {
            return false;
        }
        if ((this.geographicSiteId == null && other.geographicSiteId != null) || (this.geographicSiteId != null && !this.geographicSiteId.equals(other.geographicSiteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.GeoreferencedSitePK[siteId=" + siteId + ", geographicLayerId=" + geographicLayerId + ", geographicSiteId=" + geographicSiteId + "]";
    }

}
