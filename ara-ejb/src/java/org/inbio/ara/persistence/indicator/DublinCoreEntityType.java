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
@Table(name = "dublin_core_entity_type")

public class DublinCoreEntityType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="dublin_core_entity_type")
    @SequenceGenerator(name="dublin_core_entity_type", sequenceName="dublin_core_entity_type_seq")
    @Basic(optional = false)
    @Column(name = "dublin_core_entity_type_id")
    private Long dublinCoreEntityTypeId;
    
    public DublinCoreEntityType() {
    }

    public DublinCoreEntityType(Long dublinCoreEntityTypeId) {
        this.dublinCoreEntityTypeId = dublinCoreEntityTypeId;
    }

    public DublinCoreEntityType(Long dublinCoreEntityTypeId, String name, String description, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.dublinCoreEntityTypeId = dublinCoreEntityTypeId;
        this.setName(name);
        this.setDescription(description);

        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
        
    }

    public Long getDublinCoreEntityTypeId() {
        return dublinCoreEntityTypeId;
    }

    public void setDublinCoreEntityTypeId(Long dublinCoreEntityTypeId) {
        this.dublinCoreEntityTypeId = dublinCoreEntityTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dublinCoreEntityTypeId != null ? dublinCoreEntityTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DublinCoreEntityType)) {
            return false;
        }
        DublinCoreEntityType other = (DublinCoreEntityType) object;
        if ((this.dublinCoreEntityTypeId == null && other.dublinCoreEntityTypeId != null) || (this.dublinCoreEntityTypeId != null && !this.dublinCoreEntityTypeId.equals(other.dublinCoreEntityTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.indicator.DublinCoreEntityType[dublinCoreEntityTypeId=" + dublinCoreEntityTypeId + "]";
    }

    @Override
    public Long getId() {
        return this.dublinCoreEntityTypeId;
    }

    @Override
    public void setId(Long id) {
        this.dublinCoreEntityTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.DUBLIN_CORE_ENTITY_TYPE;
    }

}
