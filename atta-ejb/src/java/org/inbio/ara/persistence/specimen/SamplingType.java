/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.gathering.GatheringObservation;

/**
 *
 * @author pcorrales
 */
@Entity
@Table(name = "sampling_type")
@NamedQueries({@NamedQuery(name = "SamplingType.findAll", query = "SELECT s FROM SamplingType s"), @NamedQuery(name = "SamplingType.findBySamplingTypeId", query = "SELECT s FROM SamplingType s WHERE s.samplingTypeId = :samplingTypeId"), @NamedQuery(name = "SamplingType.findByName", query = "SELECT s FROM SamplingType s WHERE s.name = :name"), @NamedQuery(name = "SamplingType.findByDescription", query = "SELECT s FROM SamplingType s WHERE s.description = :description"), @NamedQuery(name = "SamplingType.findByObjVersion", query = "SELECT s FROM SamplingType s WHERE s.objVersion = :objVersion"), @NamedQuery(name = "SamplingType.findByCreatedBy", query = "SELECT s FROM SamplingType s WHERE s.createdBy = :createdBy"), @NamedQuery(name = "SamplingType.findByCreationDate", query = "SELECT s FROM SamplingType s WHERE s.creationDate = :creationDate"), @NamedQuery(name = "SamplingType.findByLastModificationBy", query = "SELECT s FROM SamplingType s WHERE s.lastModificationBy = :lastModificationBy"), @NamedQuery(name = "SamplingType.findByLastModificationDate", query = "SELECT s FROM SamplingType s WHERE s.lastModificationDate = :lastModificationDate")})
public class SamplingType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sampling_type_id")
    private BigDecimal samplingTypeId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "obj_version")
    private BigInteger objVersion;
    @Basic(optional = false)
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Basic(optional = false)
    @Column(name = "last_modification_by")
    private String lastModificationBy;
    @Basic(optional = false)
    @Column(name = "last_modification_date")
    @Temporal(TemporalType.DATE)
    private Date lastModificationDate;
    @OneToMany(mappedBy = "samplingTypeId")
    private List<GatheringObservation> gatheringObservationList;

    public SamplingType() {
    }

    public SamplingType(BigDecimal samplingTypeId) {
        this.samplingTypeId = samplingTypeId;
    }

    public SamplingType(BigDecimal samplingTypeId, String name, BigInteger objVersion, String createdBy, Date creationDate, String lastModificationBy, Date lastModificationDate) {
        this.samplingTypeId = samplingTypeId;
        this.name = name;
        this.objVersion = objVersion;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastModificationBy = lastModificationBy;
        this.lastModificationDate = lastModificationDate;
    }

    public BigDecimal getSamplingTypeId() {
        return samplingTypeId;
    }

    public void setSamplingTypeId(BigDecimal samplingTypeId) {
        this.samplingTypeId = samplingTypeId;
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

    public BigInteger getObjVersion() {
        return objVersion;
    }

    public void setObjVersion(BigInteger objVersion) {
        this.objVersion = objVersion;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastModificationBy() {
        return lastModificationBy;
    }

    public void setLastModificationBy(String lastModificationBy) {
        this.lastModificationBy = lastModificationBy;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public List<GatheringObservation> getGatheringObservationList() {
        return gatheringObservationList;
    }

    public void setGatheringObservationList(List<GatheringObservation> gatheringObservationList) {
        this.gatheringObservationList = gatheringObservationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (samplingTypeId != null ? samplingTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SamplingType)) {
            return false;
        }
        SamplingType other = (SamplingType) object;
        if ((this.samplingTypeId == null && other.samplingTypeId != null) || (this.samplingTypeId != null && !this.samplingTypeId.equals(other.samplingTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.SamplingType[samplingTypeId=" + samplingTypeId + "]";
    }

}
