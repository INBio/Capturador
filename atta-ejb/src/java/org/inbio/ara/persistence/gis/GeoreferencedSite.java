/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.gis;

import java.util.Calendar;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author jgutierrez
 */
@Entity
@Table(name = "georeferenced_site")
public class GeoreferencedSite extends GenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private GeoreferencedSitePK georeferencedSitePK;

    @JoinColumn(name = "site_id", referencedColumnName = "site_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Site site;



    public GeoreferencedSite() {
    }

    public GeoreferencedSite(GeoreferencedSitePK georeferencedSitePK) {
        this.georeferencedSitePK = georeferencedSitePK;
    }

    public GeoreferencedSite(GeoreferencedSitePK georeferencedSitePK, 
            Long objVersion, String createdBy, Calendar creationDate,
            String lastModificationBy, Calendar lastModificationDate) {
        this.georeferencedSitePK = georeferencedSitePK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public GeoreferencedSite(Long siteId, Long geographicLayerId, Long geographicSiteId) {
        this.georeferencedSitePK = new GeoreferencedSitePK(siteId, geographicLayerId, geographicSiteId);
    }

    public GeoreferencedSitePK getGeoreferencedSitePK() {
        return georeferencedSitePK;
    }

    public void setGeoreferencedSitePK(GeoreferencedSitePK georeferencedSitePK) {
        this.georeferencedSitePK = georeferencedSitePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getGeoreferencedSitePK() != null ? getGeoreferencedSitePK().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeoreferencedSite)) {
            return false;
        }
        GeoreferencedSite other = (GeoreferencedSite) object;
        if ((this.getGeoreferencedSitePK() == null && other.getGeoreferencedSitePK() != null) || (this.getGeoreferencedSitePK() != null && !this.georeferencedSitePK.equals(other.georeferencedSitePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.GeoreferencedSite[georeferencedSitePK=" + getGeoreferencedSitePK() + "]";
    }

    /**
     * @return the site
     */
    public Site getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(Site site) {
        this.site = site;
    }



}
