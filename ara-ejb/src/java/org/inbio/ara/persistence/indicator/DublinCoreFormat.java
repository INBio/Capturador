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
@Table(name = "dublin_core_format")
@NamedQueries({@NamedQuery(name = "DublinCoreFormat.findAll", query = "SELECT d FROM DublinCoreFormat d"), @NamedQuery(name = "DublinCoreFormat.findByDublinCoreFormatId", query = "SELECT d FROM DublinCoreFormat d WHERE d.dublinCoreFormatId = :dublinCoreFormatId"), @NamedQuery(name = "DublinCoreFormat.findByName", query = "SELECT d FROM DublinCoreFormat d WHERE d.name = :name"), @NamedQuery(name = "DublinCoreFormat.findByDescription", query = "SELECT d FROM DublinCoreFormat d WHERE d.description = :description"), @NamedQuery(name = "DublinCoreFormat.findByCreationDate", query = "SELECT d FROM DublinCoreFormat d WHERE d.creationDate = :creationDate"), @NamedQuery(name = "DublinCoreFormat.findByCreatedBy", query = "SELECT d FROM DublinCoreFormat d WHERE d.createdBy = :createdBy"), @NamedQuery(name = "DublinCoreFormat.findByLastModificationDate", query = "SELECT d FROM DublinCoreFormat d WHERE d.lastModificationDate = :lastModificationDate"), @NamedQuery(name = "DublinCoreFormat.findByLastModificationBy", query = "SELECT d FROM DublinCoreFormat d WHERE d.lastModificationBy = :lastModificationBy")})
public class DublinCoreFormat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dublin_core_format_id")
    private BigDecimal dublinCoreFormatId;
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

    public DublinCoreFormat() {
    }

    public DublinCoreFormat(BigDecimal dublinCoreFormatId) {
        this.dublinCoreFormatId = dublinCoreFormatId;
    }

    public DublinCoreFormat(BigDecimal dublinCoreFormatId, String name) {
        this.dublinCoreFormatId = dublinCoreFormatId;
        this.name = name;
    }

    public BigDecimal getDublinCoreFormatId() {
        return dublinCoreFormatId;
    }

    public void setDublinCoreFormatId(BigDecimal dublinCoreFormatId) {
        this.dublinCoreFormatId = dublinCoreFormatId;
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
        hash += (dublinCoreFormatId != null ? dublinCoreFormatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DublinCoreFormat)) {
            return false;
        }
        DublinCoreFormat other = (DublinCoreFormat) object;
        if ((this.dublinCoreFormatId == null && other.dublinCoreFormatId != null) || (this.dublinCoreFormatId != null && !this.dublinCoreFormatId.equals(other.dublinCoreFormatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.indicator.DublinCoreFormat[dublinCoreFormatId=" + dublinCoreFormatId + "]";
    }

}
