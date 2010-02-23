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
@Table(name = "soil_color")
public class SoilColor extends SelectionListGenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="soil_color")
    @SequenceGenerator(name="soil_color", sequenceName="soil_color_seq")
    @Basic(optional = false)
    @Column(name = "soil_color_id")
    private Long soilColorId;

    public SoilColor() {
    }

    public SoilColor(Long soilColorId) {
        this.soilColorId = soilColorId;
    }

    public SoilColor(Long soilColorId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.soilColorId = soilColorId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSoilColorId() {
        return soilColorId;
    }

    public void setSoilColorId(Long soilColorId) {
        this.soilColorId = soilColorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soilColorId != null ? soilColorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoilColor)) {
            return false;
        }
        SoilColor other = (SoilColor) object;
        if ((this.soilColorId == null && other.soilColorId != null) || (this.soilColorId != null && !this.soilColorId.equals(other.soilColorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.SoilColor[soilColorId=" + soilColorId + "]";
    }

    @Override
    public Long getId() {
        return soilColorId;
    }

    @Override
    public void setId(Long id) {
        this.soilColorId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.SOIL_COLOR;
    }

}