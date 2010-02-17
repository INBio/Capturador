/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.security;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "system_user_type")

public class SystemUserType extends GenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_type_id")
    private Long userTypeId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userTypeId", fetch = FetchType.LAZY)
    private List<SystemUser> systemUserCollection;

    public SystemUserType() {
    }

    public SystemUserType(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public SystemUserType(Long userTypeId, String name, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.userTypeId = userTypeId;
        this.name = name;
        this.setCreationDate(creationDate);
        this.setCreatedBy(createdBy);
        this.setLastModificationDate(lastModificationDate);
        this.setLastModificationBy(lastModificationBy);
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
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

    public List<SystemUser> getSystemUserCollection() {
        return systemUserCollection;
    }

    public void setSystemUserCollection(List<SystemUser> systemUserCollection) {
        this.systemUserCollection = systemUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userTypeId != null ? userTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemUserType)) {
            return false;
        }
        SystemUserType other = (SystemUserType) object;
        if ((this.userTypeId == null && other.userTypeId != null) || (this.userTypeId != null && !this.userTypeId.equals(other.userTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.security.SystemUserType[userTypeId=" + userTypeId + "]";
    }

}
