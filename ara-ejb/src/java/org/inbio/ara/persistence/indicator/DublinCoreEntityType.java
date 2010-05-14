/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.indicator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "dublin_core_entity_type")
@NamedQueries({@NamedQuery(name = "DublinCoreEntityType.findAll", query = "SELECT d FROM DublinCoreEntityType d"), @NamedQuery(name = "DublinCoreEntityType.findByDublinCoreEntityTypeId", query = "SELECT d FROM DublinCoreEntityType d WHERE d.dublinCoreEntityTypeId = :dublinCoreEntityTypeId"), @NamedQuery(name = "DublinCoreEntityType.findByName", query = "SELECT d FROM DublinCoreEntityType d WHERE d.name = :name"), @NamedQuery(name = "DublinCoreEntityType.findByDescription", query = "SELECT d FROM DublinCoreEntityType d WHERE d.description = :description"), @NamedQuery(name = "DublinCoreEntityType.findByCreationDate", query = "SELECT d FROM DublinCoreEntityType d WHERE d.creationDate = :creationDate"), @NamedQuery(name = "DublinCoreEntityType.findByCreatedBy", query = "SELECT d FROM DublinCoreEntityType d WHERE d.createdBy = :createdBy"), @NamedQuery(name = "DublinCoreEntityType.findByLastModificationDate", query = "SELECT d FROM DublinCoreEntityType d WHERE d.lastModificationDate = :lastModificationDate"), @NamedQuery(name = "DublinCoreEntityType.findByLastModificationBy", query = "SELECT d FROM DublinCoreEntityType d WHERE d.lastModificationBy = :lastModificationBy")})
public class DublinCoreEntityType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dublin_core_entity_type_id")
    private BigDecimal dublinCoreEntityTypeId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "last_modification_date")
    @Temporal(TemporalType.DATE)
    private Date lastModificationDate;
    @Column(name = "last_modification_by")
    private String lastModificationBy;

    public DublinCoreEntityType() {
    }

    public DublinCoreEntityType(BigDecimal dublinCoreEntityTypeId) {
        this.dublinCoreEntityTypeId = dublinCoreEntityTypeId;
    }

    public DublinCoreEntityType(BigDecimal dublinCoreEntityTypeId, String name) {
        this.dublinCoreEntityTypeId = dublinCoreEntityTypeId;
        this.name = name;
    }

    public BigDecimal getDublinCoreEntityTypeId() {
        return dublinCoreEntityTypeId;
    }

    public void setDublinCoreEntityTypeId(BigDecimal dublinCoreEntityTypeId) {
        this.dublinCoreEntityTypeId = dublinCoreEntityTypeId;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getLastModificationBy() {
        return lastModificationBy;
    }

    public void setLastModificationBy(String lastModificationBy) {
        this.lastModificationBy = lastModificationBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dublinCoreEntityTypeId != null ? dublinCoreEntityTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DublinCoreEntityType)) {
            return false;
        }
        DublinCoreEntityType other = (DublinCoreEntityType) object;
        if ((this.dublinCoreEntityTypeId == null && other.dublinCoreEntityTypeId != null) || (this.dublinCoreEntityTypeId != null && !this.dublinCoreEntityTypeId.equals(other.dublinCoreEntityTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.indicator.DublinCoreEntityType[dublinCoreEntityTypeId=" + dublinCoreEntityTypeId + "]";
    }

}
