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
@Table(name = "crop_type")
public class CropType extends SelectionListGenericEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="crop_type")
    @SequenceGenerator(name="crop_type", sequenceName="crop_type_seq")
    @Basic(optional = false)
    @Column(name = "crop_type_id")
    private Long cropTypeId;

    public CropType() {
    }

    public CropType(Long cropTypeId) {
        this.cropTypeId = cropTypeId;
    }

    public CropType(Long cropTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.cropTypeId = cropTypeId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getCropTypeId() {
        return cropTypeId;
    }

    public void setCropTypeId(Long cropTypeId) {
        this.cropTypeId = cropTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cropTypeId != null ? cropTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CropType)) {
            return false;
        }
        CropType other = (CropType) object;
        if ((this.cropTypeId == null && other.cropTypeId != null) || (this.cropTypeId != null && !this.cropTypeId.equals(other.cropTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.CropType[cropTypeId=" + cropTypeId + "]";
    }

    @Override
    public Long getId() {
        return cropTypeId;
    }

    @Override
    public void setId(Long id) {
        this.cropTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.CROP_TYPE;
    }

}