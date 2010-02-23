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
@Table(name = "material_type")
public class MaterialType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="material_type")
    @SequenceGenerator(name="material_type", sequenceName="material_type_seq")
    @Basic(optional = false)
    @Column(name = "material_type_id")
    private Long materialTypeId;


    public MaterialType() {
    }

    public MaterialType(Long materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public MaterialType(Long materialTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.materialTypeId = materialTypeId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Long materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialTypeId != null ? materialTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialType)) {
            return false;
        }
        MaterialType other = (MaterialType) object;
        if ((this.materialTypeId == null && other.materialTypeId != null) || (this.materialTypeId != null && !this.materialTypeId.equals(other.materialTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.MaterialType[materialTypeId=" + materialTypeId + "]";
    }

    @Override
    public Long getId() {
        return materialTypeId;
    }

    @Override
    public void setId(Long id) {
        this.materialTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.MATERIAL_TYPE;
    }

}