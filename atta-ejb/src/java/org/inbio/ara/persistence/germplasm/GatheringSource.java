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
@Table(name = "gathering_source")
public class GatheringSource extends SelectionListGenericEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="gathering_source")
    @SequenceGenerator(name="gathering_source", sequenceName="gathering_source_seq")
    @Basic(optional = false)
    @Column(name = "gathering_source_id")
    private Long gatheringSourceId;

    public GatheringSource() {
    }

    public GatheringSource(Long gatheringSourceId) {
        this.gatheringSourceId = gatheringSourceId;
    }

    public GatheringSource(Long gatheringSourceId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.gatheringSourceId = gatheringSourceId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getGatheringSourceId() {
        return gatheringSourceId;
    }

    public void setGatheringSourceId(Long gatheringSourceId) {
        this.gatheringSourceId = gatheringSourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gatheringSourceId != null ? gatheringSourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GatheringSource)) {
            return false;
        }
        GatheringSource other = (GatheringSource) object;
        if ((this.gatheringSourceId == null && other.gatheringSourceId != null) || (this.gatheringSourceId != null && !this.gatheringSourceId.equals(other.gatheringSourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.GatheringSource[gatheringSourceId=" + gatheringSourceId + "]";
    }

    @Override
    public Long getId() {
        return gatheringSourceId;
    }

    @Override
    public void setId(Long id) {
        this.gatheringSourceId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.GATHERING_SOURCE;
    }

}