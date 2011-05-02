/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.samplemanage;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "host_information")
public class HostInformation extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="host_information")
    @SequenceGenerator(name="host_information", sequenceName="host_information_seq")
    @Basic(optional = false)
    @Column(name = "host_information_id")
    private Long hostInformationId;

    @Column(name = "health_comment")
    private String healthComment;

    @Column(name = "sample_id")
    private Long sampleId;

    @Column(name = "taxon_id")
    private Long taxonId;

    public HostInformation() {
    }

    public HostInformation(Long hostId) {
        this.hostInformationId = hostId;
    }

    public HostInformation(Long hostId, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.hostInformationId = hostId;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getHostId() {
        return hostInformationId;
    }

    public void setHostId(Long hostInformationId) {
        this.hostInformationId = hostInformationId;
    }

    public String getHealthComment() {
        return healthComment;
    }

    public void setHealthComment(String healthComment) {
        this.healthComment = healthComment;
    }

    

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    public Long getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hostInformationId != null ? hostInformationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HostInformation)) {
            return false;
        }
        HostInformation other = (HostInformation) object;
        if ((this.hostInformationId == null && other.hostInformationId != null) || (this.hostInformationId != null && !this.hostInformationId.equals(other.hostInformationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.Host[hostId=" + hostInformationId + "]";
    }

}
