/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

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
@Table(name = "semen_consistency")
public class SemenConsistency extends SelectionListGenericEntity  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="semen_consistency")
    @SequenceGenerator(name="semen_consistency", sequenceName="semen_consistency_seq")
    @Basic(optional = false)
    @Column(name = "semen_consistency_id")
    private Long semenConsistencyId;


    public SemenConsistency() {
    }

    public SemenConsistency(Long semenConsistencyId) {
        this.semenConsistencyId = semenConsistencyId;
    }

    public SemenConsistency(Long semenConsistencyId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.semenConsistencyId = semenConsistencyId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semenConsistencyId != null ? semenConsistencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemenConsistency)) {
            return false;
        }
        SemenConsistency other = (SemenConsistency) object;
        if ((this.semenConsistencyId == null && other.semenConsistencyId != null) || (this.semenConsistencyId != null && !this.semenConsistencyId.equals(other.semenConsistencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germplasm.SemenConsistency[id=" + semenConsistencyId + "]";
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.SEMEN_CONSISTENCY;
    }

    /**
     * @return the semenConsistencyId
     */
    public Long getSemenConsistencyId() {
        return semenConsistencyId;
    }

    /**
     * @param semenConsistencyId the semenConsistencyId to set
     */
    public void setSemenConsistencyId(Long semenConsistencyId) {
        this.semenConsistencyId = semenConsistencyId;
    }

    @Override
    public Long getId() {
        return semenConsistencyId;
    }

    @Override
    public void setId(Long id) {
        this.semenConsistencyId = id;
    }

}
