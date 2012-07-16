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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "bioprospecting_project_sample")
public class BioprospectingProjectSample extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BioprospectingProjectSamplePK bioprospectingProjectSamplePK;
    

    public BioprospectingProjectSample() {
    }

    public BioprospectingProjectSample(BioprospectingProjectSamplePK bioprospectingProjectSamplePK) {
        this.bioprospectingProjectSamplePK = bioprospectingProjectSamplePK;
    }

    public BioprospectingProjectSample(BioprospectingProjectSamplePK bioprospectingProjectSamplePK, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.bioprospectingProjectSamplePK = bioprospectingProjectSamplePK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public BioprospectingProjectSample(Long bioprospectingProjectId, Long sampleId) {
        this.bioprospectingProjectSamplePK = new BioprospectingProjectSamplePK(bioprospectingProjectId, sampleId);
    }

    public BioprospectingProjectSamplePK getBioprospectingProjectSamplePK() {
        return bioprospectingProjectSamplePK;
    }

    public void setBioprospectingProjectSamplePK(BioprospectingProjectSamplePK bioprospectingProjectSamplePK) {
        this.bioprospectingProjectSamplePK = bioprospectingProjectSamplePK;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bioprospectingProjectSamplePK != null ? bioprospectingProjectSamplePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BioprospectingProjectSample)) {
            return false;
        }
        BioprospectingProjectSample other = (BioprospectingProjectSample) object;
        if ((this.bioprospectingProjectSamplePK == null && other.bioprospectingProjectSamplePK != null) || (this.bioprospectingProjectSamplePK != null && !this.bioprospectingProjectSamplePK.equals(other.bioprospectingProjectSamplePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.BioprospectingProjectSample[bioprospectingProjectSamplePK=" + bioprospectingProjectSamplePK + "]";
    }

}
