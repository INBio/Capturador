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

package org.inbio.ara.persistence.gis;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "site")
public class Site extends GenericEntity {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="Site")
	@SequenceGenerator(name="Site", sequenceName="site_seq")
    @Basic(optional = false)
    @Column(name = "site_id")
    private Long siteId;

    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    @Column(name = "precision")
    private Long precision;

    @Column(name = "name")
    private String name;

    @Column(name = "geodetic_datum")
    private Long geodeticDatum;

    @Column(name = "feature_type_id")
    private Long featureTypeId;

    @Column(name = "base_projection_id")
    private Long baseProjectionId;

    @Column(name = "original_projection_id")
    private Long originalProjectionId;

    @Column(name = "site_calculation_method_id")
    private Long siteCalculationMethodId;

    
    @OneToMany(fetch=FetchType.EAGER, mappedBy="site")
    private List<SiteCoordinate> siteCoordinates;


    @OneToMany(fetch=FetchType.LAZY, mappedBy="site")
    private List<GeoreferencedSite> georeferencedSites;


    public Site() {
    }

    public Site(Long siteId) {
        this.siteId = siteId;
    }

    public Site(Long siteId, String description, String createdBy, 
            Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.siteId = siteId;
        this.description = description;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrecision() {
        return precision;
    }

    public void setPrecision(Long precision) {
        this.precision = precision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGeodeticDatum() {
        return geodeticDatum;
    }

    public void setGeodeticDatum(Long geodeticDatum) {
        this.geodeticDatum = geodeticDatum;
    }

    public Long getFeatureTypeId() {
        return featureTypeId;
    }

    public void setFeatureTypeId(Long featureTypeId) {
        this.featureTypeId = featureTypeId;
    }

    public Long getBaseProjectionId() {
        return baseProjectionId;
    }

    public void setBaseProjectionId(Long baseProjectionId) {
        this.baseProjectionId = baseProjectionId;
    }

    public Long getOriginalProjectionId() {
        return originalProjectionId;
    }

    public void setOriginalProjectionId(Long originalProjectionId) {
        this.originalProjectionId = originalProjectionId;
    }

    public Long getSiteCalculationMethodId() {
        return siteCalculationMethodId;
    }

    public void setSiteCalculationMethodId(Long siteCalculationMethodId) {
        this.siteCalculationMethodId = siteCalculationMethodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteId != null ? siteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.siteId == null && other.siteId != null) || (this.siteId != null && !this.siteId.equals(other.siteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.gis.Site[siteId=" + siteId + "]";
    }

    /**
     * @return the siteCoordinates
     */
    public List<SiteCoordinate> getSiteCoordinates() {
        return siteCoordinates;
    }

    /**
     * @param siteCoordinates the siteCoordinates to set
     */
    public void setSiteCoordinates(List<SiteCoordinate> siteCoordinates) {
        this.siteCoordinates = siteCoordinates;
    }

    /**
     * 
     * @return
     */
    public String getCoordinatesAsString(){
        boolean firstTime = true;
        String tmpPairs = "";

        for (SiteCoordinate siteCoordinate : getSiteCoordinates()) {
            if (!firstTime) {
                tmpPairs += ", ";
            }
            tmpPairs += "(" + siteCoordinate.getLongitude() + ", " + siteCoordinate.getLatitude() + ")";
            firstTime = false;
        }

        return tmpPairs;

    }

    /**
     * @return the georeferencedSites
     */
    public List<GeoreferencedSite> getGeoreferencedSites() {
        return georeferencedSites;
    }

    /**
     * @param georeferencedSites the georeferencedSites to set
     */
    public void setGeoreferencedSites(List<GeoreferencedSite> georeferencedSites) {
        this.georeferencedSites = georeferencedSites;
    }


}
