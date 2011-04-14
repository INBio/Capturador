/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
