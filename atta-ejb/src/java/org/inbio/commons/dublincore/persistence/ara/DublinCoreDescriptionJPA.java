/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.commons.dublincore.persistence.ara;

import java.io.Serializable;
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
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.commons.dublincore.model.DublinCoreDescription;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "dublin_core_description")

public class DublinCoreDescriptionJPA extends DublinCoreDescription {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="dublin_core_description")
    @SequenceGenerator(name="dublin_core_description", sequenceName="dublin_core_description_seq")
    @Basic(optional = false)
    @Column(name = "resource_id")
    private Integer resourceId;
    @Basic(optional = false)
    @Column(name = "resource_type_id")
    private int resourceTypeId;
    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name="creation_date", nullable = false)
    private Calendar creationDate;

    @Column(name="created_by", nullable = false)
    private String createdBy;

    @Temporal(TemporalType.DATE)
    @Column(name="last_modification_date", nullable = false)
    private Calendar lastModificationDate;

    @Column(name="last_modification_by", nullable = false)
    private String lastModificationBy;

    /*
    public DublinCoreDescriptionJPA() {
    }

    public DublinCoreDescriptionJPA(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public DublinCoreDescriptionJPA(Integer resourceId, int resourceTypeId, String description, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.resourceId = resourceId;
        this.resourceTypeId = resourceTypeId;
        this.description = description;

        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }
     */

    @PrePersist
    public void prePersist(){
        this.setCreationDate(this.lastModificationDate);
        this.setCreatedBy(this.lastModificationBy);
        //this.creationDate = this.lastModificationDate;
        //this.createdBy= this.lastModificationBy;
    }


    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(int resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
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
        hash += (resourceId != null ? resourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DublinCoreDescriptionJPA)) {
            return false;
        }
        DublinCoreDescriptionJPA other = (DublinCoreDescriptionJPA) object;
        if ((this.resourceId == null && other.resourceId != null) || (this.resourceId != null && !this.resourceId.equals(other.resourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.commons.dublincore.persistence.ara.DublinCoreDescription[resourceId=" + resourceId + "]";
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @param lastModificationDate the lastModificationDate to set
     */
    public void setLastModificationDate(Calendar lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    /**
     * @param lastModificationBy the lastModificationBy to set
     */
    public void setLastModificationBy(String lastModificationBy) {
        this.lastModificationBy = lastModificationBy;
    }

}
