/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.germplasm;

import java.util.Calendar;
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
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "moisture_method_type")
public class MoistureMethodType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="moisture_method_type")
    @SequenceGenerator(name="moisture_method_type", sequenceName="moisture_method_type_seq")
    @Basic(optional = false)
    @Column(name = "moisture_method_type_id")
    private Long moistureMethodTypeId;

    public MoistureMethodType() {
    }

    public MoistureMethodType(Long moistureMethodTypeId) {
        this.moistureMethodTypeId = moistureMethodTypeId;
    }

    public MoistureMethodType(Long moistureMethodTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.moistureMethodTypeId = moistureMethodTypeId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getMoistureMethodTypeId() {
        return moistureMethodTypeId;
    }

    public void setMoistureMethodTypeId(Long moistureMethodTypeId) {
        this.moistureMethodTypeId = moistureMethodTypeId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moistureMethodTypeId != null ? moistureMethodTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoistureMethodType)) {
            return false;
        }
        MoistureMethodType other = (MoistureMethodType) object;
        if ((this.moistureMethodTypeId == null && other.moistureMethodTypeId != null) || (this.moistureMethodTypeId != null && !this.moistureMethodTypeId.equals(other.moistureMethodTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.MoistureMethodType[moistureMethodTypeId=" + moistureMethodTypeId + "]";
    }

    @Override
    public Long getId() {
        return this.moistureMethodTypeId;
    }

    @Override
    public void setId(Long id) {
        this.moistureMethodTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.MOISTURE_METHOD_TYPE;
    }

}
