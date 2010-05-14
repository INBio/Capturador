/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.indicator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "dublin_core_type")

public class DublinCoreType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="dublin_core_type")
    @SequenceGenerator(name="dublin_core_type", sequenceName="dublin_core_type_seq")
    @Basic(optional = false)
    @Column(name = "dublin_core_type_id")
    private Long dublinCoreTypeId;


    public DublinCoreType() {
    }

    public DublinCoreType(Long dublinCoreTypeId) {
        this.dublinCoreTypeId = dublinCoreTypeId;
    }

    public DublinCoreType(Long dublinCoreTypeId, String name, String description, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.dublinCoreTypeId = dublinCoreTypeId;
        this.setName(name);
        this.setDescription(description);

        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getDublinCoreTypeId() {
        return dublinCoreTypeId;
    }

    public void setDublinCoreTypeId(Long dublinCoreTypeId) {
        this.dublinCoreTypeId = dublinCoreTypeId;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dublinCoreTypeId != null ? dublinCoreTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DublinCoreType)) {
            return false;
        }
        DublinCoreType other = (DublinCoreType) object;
        if ((this.dublinCoreTypeId == null && other.dublinCoreTypeId != null) || (this.dublinCoreTypeId != null && !this.dublinCoreTypeId.equals(other.dublinCoreTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.indicator.DublinCoreType[dublinCoreTypeId=" + dublinCoreTypeId + "]";
    }

    @Override
    public Long getId() {
        return this.dublinCoreTypeId;
    }

    @Override
    public void setId(Long id) {
        this.dublinCoreTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.DUBLIN_CORE_TYPE;
    }

}
