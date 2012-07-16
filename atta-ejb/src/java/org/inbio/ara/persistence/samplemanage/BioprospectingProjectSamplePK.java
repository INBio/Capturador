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

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dasolano
 */
@Embeddable
public class BioprospectingProjectSamplePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "bioprospecting_project_id")
    private Long bioprospectingProjectId;
    
    @Basic(optional = false)
    @Column(name = "sample_id")
    private Long sampleId;

    public BioprospectingProjectSamplePK() {
    }

    public BioprospectingProjectSamplePK(Long bioprospectingProjectId, Long sampleId) {
        this.bioprospectingProjectId = bioprospectingProjectId;
        this.sampleId = sampleId;
    }

    public Long getBioprospectingProjectId() {
        return bioprospectingProjectId;
    }

    public void setBioprospectingProjectId(Long bioprospectingProjectId) {
        this.bioprospectingProjectId = bioprospectingProjectId;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bioprospectingProjectId != null ? bioprospectingProjectId.hashCode() : 0);
        hash += (sampleId != null ? sampleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BioprospectingProjectSamplePK)) {
            return false;
        }
        BioprospectingProjectSamplePK other = (BioprospectingProjectSamplePK) object;
        if ((this.bioprospectingProjectId == null && other.bioprospectingProjectId != null) || (this.bioprospectingProjectId != null && !this.bioprospectingProjectId.equals(other.bioprospectingProjectId))) {
            return false;
        }
        if ((this.sampleId == null && other.sampleId != null) || (this.sampleId != null && !this.sampleId.equals(other.sampleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.BioprospectingProjectSamplePK[bioprospectingProjectId=" + bioprospectingProjectId + ", sampleId=" + sampleId + "]";
    }

}
