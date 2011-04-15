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

package org.inbio.ara.persistence.samplemanage;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "sample")
public class Sample extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="sample")
    @SequenceGenerator(name="sample", sequenceName="sample_seq")
    @Basic(optional = false)
    @Column(name = "sample_id")
    private Long sampleId;

    @Basic(optional = false)
    @Column(name = "witness")
    private String witness;

    @Column(name = "description")
    private String description;

    @Column(name = "gathering_date")
    @Temporal(TemporalType.DATE)
    private Date gatheringDate;

    @Column(name = "sample_altitude")
    private Long sampleAltitude;

    @Column(name = "gathering_observation_id")
    private Long gatheringObservationId;

    @Column(name = "micro_fome_id")
    private Long microFomeId;

    @Column(name = "micro_method_id")
    private Long microMethodId;

    @Column(name = "micro_quality_id")
    private Long microQualityId;

    @Column(name = "micro_source_type_id")
    private Long microSourceTypeId;

    @Column(name = "permission_id")
    private Long permissionId;

    @Column(name = "sample_class_id")
    private Long sampleClassId;

    @Column(name = "site_id")
    private Long siteId;


    @Column(name = "taxon_id")
    private Long taxonId;

    public Sample() {
    }

    public Sample(Long sampleId) {
        this.sampleId = sampleId;
    }

    public Sample(Long sampleId, String witness, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.sampleId = sampleId;
        this.witness = witness;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    public String getWitness() {
        return witness;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getGatheringDate() {
        return gatheringDate;
    }

    public void setGatheringDate(Date gatheringDate) {
        this.gatheringDate = gatheringDate;
    }

    public Long getSampleAltitude() {
        return sampleAltitude;
    }

    public void setSampleAltitude(Long sampleAltitude) {
        this.sampleAltitude = sampleAltitude;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sampleId != null ? sampleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sample)) {
            return false;
        }
        Sample other = (Sample) object;
        if ((this.sampleId == null && other.sampleId != null) || (this.sampleId != null && !this.sampleId.equals(other.sampleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.Sample[sampleId=" + sampleId + "]";
    }

    /**
     * @return the gatheringObservationId
     */
    public Long getGatheringObservationId() {
        return gatheringObservationId;
    }

    /**
     * @param gatheringObservationId the gatheringObservationId to set
     */
    public void setGatheringObservationId(Long gatheringObservationId) {
        this.gatheringObservationId = gatheringObservationId;
    }

    /**
     * @return the microFomeId
     */
    public Long getMicroFomeId() {
        return microFomeId;
    }

    /**
     * @param microFomeId the microFomeId to set
     */
    public void setMicroFomeId(Long microFomeId) {
        this.microFomeId = microFomeId;
    }

    /**
     * @return the microMethodId
     */
    public Long getMicroMethodId() {
        return microMethodId;
    }

    /**
     * @param microMethodId the microMethodId to set
     */
    public void setMicroMethodId(Long microMethodId) {
        this.microMethodId = microMethodId;
    }

    /**
     * @return the microQualityId
     */
    public Long getMicroQualityId() {
        return microQualityId;
    }

    /**
     * @param microQualityId the microQualityId to set
     */
    public void setMicroQualityId(Long microQualityId) {
        this.microQualityId = microQualityId;
    }

    /**
     * @return the microSourceTypeId
     */
    public Long getMicroSourceTypeId() {
        return microSourceTypeId;
    }

    /**
     * @param microSourceTypeId the microSourceTypeId to set
     */
    public void setMicroSourceTypeId(Long microSourceTypeId) {
        this.microSourceTypeId = microSourceTypeId;
    }

    /**
     * @return the permissionId
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId the permissionId to set
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @return the sampleClassId
     */
    public Long getSampleClassId() {
        return sampleClassId;
    }

    /**
     * @param sampleClassId the sampleClassId to set
     */
    public void setSampleClassId(Long sampleClassId) {
        this.sampleClassId = sampleClassId;
    }

    /**
     * @return the siteId
     */
    public Long getSiteId() {
        return siteId;
    }

    /**
     * @param siteId the siteId to set
     */
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * @return the taxonId
     */
    public Long getTaxonId() {
        return taxonId;
    }

    /**
     * @param taxonId the taxonId to set
     */
    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

}
