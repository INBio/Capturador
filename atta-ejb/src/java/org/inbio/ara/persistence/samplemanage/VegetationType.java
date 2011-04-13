/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.samplemanage;

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
@Table(name = "vegetation_type")
public class VegetationType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="vegetation_type")
    @SequenceGenerator(name="vegetation_type", sequenceName="vegetation_type_seq")
    @Basic(optional = false)
    @Column(name = "vegetation_type_id")
    private Long vegetationTypeId;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public VegetationType() {
    }

    public VegetationType(Long vegetationTypeId) {
        this.vegetationTypeId = vegetationTypeId;
    }

    public VegetationType(Long vegetationTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.vegetationTypeId = vegetationTypeId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getVegetationTypeId() {
        return vegetationTypeId;
    }

    public void setVegetationTypeId(Long vegetationTypeId) {
        this.vegetationTypeId = vegetationTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vegetationTypeId != null ? vegetationTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VegetationType)) {
            return false;
        }
        VegetationType other = (VegetationType) object;
        if ((this.vegetationTypeId == null && other.vegetationTypeId != null) || (this.vegetationTypeId != null && !this.vegetationTypeId.equals(other.vegetationTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.VegetationType[vegetationTypeId=" + vegetationTypeId + "]";
    }

    @Override
    public Long getId() {
        return this.vegetationTypeId;
    }

    @Override
    public void setId(Long id) {
        this.vegetationTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.VEGETATION_TYPE;
    }

}
