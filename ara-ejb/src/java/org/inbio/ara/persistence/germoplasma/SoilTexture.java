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
import org.inbio.ara.persistence.GenericEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "soil_texture")
public class SoilTexture extends SelectionListGenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="soil_texture")
    @SequenceGenerator(name="soil_texture", sequenceName="soil_texture_seq")
    @Basic(optional = false)
    @Column(name = "soil_texture_id")
    private Long soilTextureId;

    public SoilTexture() {
    }

    public SoilTexture(Long soilTextureId) {
        this.soilTextureId = soilTextureId;
    }

    public SoilTexture(Long soilTextureId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.soilTextureId = soilTextureId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSoilTextureId() {
        return soilTextureId;
    }

    public void setSoilTextureId(Long soilTextureId) {
        this.soilTextureId = soilTextureId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soilTextureId != null ? soilTextureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoilTexture)) {
            return false;
        }
        SoilTexture other = (SoilTexture) object;
        if ((this.soilTextureId == null && other.soilTextureId != null) || (this.soilTextureId != null && !this.soilTextureId.equals(other.soilTextureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.SoilTexture[soilTextureId=" + soilTextureId + "]";
    }

    @Override
    public Long getId() {
        return soilTextureId;
    }

    @Override
    public void setId(Long id) {
        this.soilTextureId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.SOIL_TEXTURE;
    }

}