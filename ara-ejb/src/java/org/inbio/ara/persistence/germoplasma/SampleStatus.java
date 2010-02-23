/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germoplasma;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "sample_status")
public class SampleStatus extends SelectionListGenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="sample_status")
    @SequenceGenerator(name="sample_status", sequenceName="sample_status_seq")
    @Basic(optional = false)
    @Column(name = "sample_status_id")
    private Long sampleStatusId;

    public SampleStatus() {
    }

    public SampleStatus(Long sampleStatusId) {
        this.sampleStatusId = sampleStatusId;
    }

    public SampleStatus(Long sampleStatusId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.sampleStatusId = sampleStatusId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSampleStatusId() {
        return sampleStatusId;
    }

    public void setSampleStatusId(Long sampleStatusId) {
        this.sampleStatusId = sampleStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sampleStatusId != null ? sampleStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SampleStatus)) {
            return false;
        }
        SampleStatus other = (SampleStatus) object;
        if ((this.sampleStatusId == null && other.sampleStatusId != null) || (this.sampleStatusId != null && !this.sampleStatusId.equals(other.sampleStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.SampleStatus[sampleStatusId=" + sampleStatusId + "]";
    }

    @Override
    public Long getId() {
        return sampleStatusId;
    }

    @Override
    public void setId(Long id) {
        this.sampleStatusId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.SAMPLE_STATUS;
    }

}