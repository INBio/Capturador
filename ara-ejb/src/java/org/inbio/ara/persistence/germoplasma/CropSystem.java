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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "crop_system")
public class CropSystem extends SelectionListGenericEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="crop_system")
    @SequenceGenerator(name="crop_system", sequenceName="crop_system_seq")
    @Basic(optional = false)
    @Column(name = "crop_system_id")
    private Long cropSystemId;

    public CropSystem() {
    }

    public CropSystem(Long cropSystemId) {
        this.cropSystemId = cropSystemId;
    }

    public CropSystem(Long cropSystemId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.cropSystemId = cropSystemId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getCropSystemId() {
        return cropSystemId;
    }

    public void setCropSystemId(Long cropSystemId) {
        this.cropSystemId = cropSystemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cropSystemId != null ? cropSystemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CropSystem)) {
            return false;
        }
        CropSystem other = (CropSystem) object;
        if ((this.cropSystemId == null && other.cropSystemId != null) || (this.cropSystemId != null && !this.cropSystemId.equals(other.cropSystemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.CropSystem[cropSystemId=" + cropSystemId + "]";
    }

    @Override
    public Long getId() {
        return cropSystemId;
    }

    @Override
    public void setId(Long id) {
        this.cropSystemId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.CROP_SYSTEM;
    }

}