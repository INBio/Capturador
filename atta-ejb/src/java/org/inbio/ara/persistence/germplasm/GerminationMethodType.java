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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "germination_method_type")
public class GerminationMethodType extends SelectionListGenericEntity  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="germination_method_type")
    @SequenceGenerator(name="germination_method_type", sequenceName="germination_method_type_seq")
    @Basic(optional = false)
    @Column(name = "germination_method_type_id")
    private Long germinationMethodTypeId;
    

    public GerminationMethodType() {
    }

    public GerminationMethodType(Long germinationMethodTypeId) {
        this.germinationMethodTypeId = germinationMethodTypeId;
    }

    public GerminationMethodType(Long germinationMethodTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.germinationMethodTypeId = germinationMethodTypeId;
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getGerminationMethodTypeId() {
        return germinationMethodTypeId;
    }

    public void setGerminationMethodTypeId(Long germinationMethodTypeId) {
        this.germinationMethodTypeId = germinationMethodTypeId;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (germinationMethodTypeId != null ? germinationMethodTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GerminationMethodType)) {
            return false;
        }
        GerminationMethodType other = (GerminationMethodType) object;
        if ((this.germinationMethodTypeId == null && other.germinationMethodTypeId != null) || (this.germinationMethodTypeId != null && !this.germinationMethodTypeId.equals(other.germinationMethodTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.germoplasma.GerminationMethodType[germinationMethodTypeId=" + germinationMethodTypeId + "]";
    }

    @Override
    public Long getId() {
        return this.germinationMethodTypeId;
    }

    @Override
    public void setId(Long id) {
        this.germinationMethodTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.GERMINATION_METHOD_TYPE;
    }

}
