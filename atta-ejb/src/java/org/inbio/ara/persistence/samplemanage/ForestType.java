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
@Table(name = "forest_type")
public class ForestType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="forest_type")
    @SequenceGenerator(name="forest_type", sequenceName="forest_type_seq")
    @Basic(optional = false)
    @Column(name = "forest_type_id")
    private Long forestTypeId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    public ForestType() {
    }

    public ForestType(Long forestTypeId) {
        this.forestTypeId = forestTypeId;
    }

    public ForestType(Long forestTypeId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.forestTypeId = forestTypeId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getForestTypeId() {
        return forestTypeId;
    }

    public void setForestTypeId(Long forestTypeId) {
        this.forestTypeId = forestTypeId;
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
        hash += (forestTypeId != null ? forestTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForestType)) {
            return false;
        }
        ForestType other = (ForestType) object;
        if ((this.forestTypeId == null && other.forestTypeId != null) || (this.forestTypeId != null && !this.forestTypeId.equals(other.forestTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.ForestType[forestTypeId=" + forestTypeId + "]";
    }

    @Override
    public Long getId() {
        return this.forestTypeId;
    }

    @Override
    public void setId(Long id) {
        this.forestTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.FOREST_TYPE;
    }

}
