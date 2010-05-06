/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "semen_gathering_method")
public class SemenGatheringMethod extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="semen_gathering_method")
    @SequenceGenerator(name="semen_gathering_method", sequenceName="semen_gathering_method_seq")
    @Basic(optional = false)
    @Column(name = "semen_gathering_method_id")
    private Long semenGatheringMethodId;
    

    public SemenGatheringMethod() {
    }

    public SemenGatheringMethod(Long semenGatheringMethodId) {
        this.semenGatheringMethodId = semenGatheringMethodId;
    }

    public SemenGatheringMethod(Long semenGatheringMethodId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.semenGatheringMethodId = semenGatheringMethodId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSemenGatheringMethodId() {
        return semenGatheringMethodId;
    }

    public void setSemenGatheringMethodId(Long semenGatheringMethodId) {
        this.semenGatheringMethodId = semenGatheringMethodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semenGatheringMethodId != null ? semenGatheringMethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemenGatheringMethod)) {
            return false;
        }
        SemenGatheringMethod other = (SemenGatheringMethod) object;
        if ((this.semenGatheringMethodId == null && other.semenGatheringMethodId != null) || (this.semenGatheringMethodId != null && !this.semenGatheringMethodId.equals(other.semenGatheringMethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germplasm.SemenGatheringMethod[semenGatheringMethodId=" + semenGatheringMethodId + "]";
    }

    @Override
    public Long getId() {
        return semenGatheringMethodId;
    }

    @Override
    public void setId(Long id) {
        this.semenGatheringMethodId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.SEMEN_GATHERING_METHOD;
    }

}
