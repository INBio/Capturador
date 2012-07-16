/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.security;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "system_user")

public class SystemUser extends GenericEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SystemUser")
	@SequenceGenerator(name="SystemUser", sequenceName="system_user_seq")
    @Basic(optional = false)
    @Column(name = "user_id")
    private Long userId;

    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    @Basic(optional = false)
    @Column(name = "fullname")
    private String fullname;

    @Basic(optional = false)
    @Column(name = "passwd")
    private String passwd;

    @Basic(optional = false)
    @Column(name = "enabled")
    private Long enabled;

    @Basic(optional = false)
    @Column(name = "user_type_id")
    private Long userTypeId;
    
    /*@JoinColumn(name = "user_type_id", referencedColumnName = "user_type_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SystemUserType userTypeId;*/

    @Basic(optional = true)
    @Column(name = "user_group_id")
    private Long userGroupId;

    /*@JoinColumn(name = "user_group_id", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SystemUser userGroupId;*/

    public SystemUser() {
    }

    public SystemUser(Long userId) {
        this.userId = userId;
    }

    public SystemUser(Long userId, String username, String fullname, String passwd, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate, Long enabled) {
        this.userId = userId;
        this.username = username;
        this.fullname = fullname;
        this.passwd = passwd;
        this.enabled = enabled;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Long getEnabled() {
        return enabled;
    }

    public void setEnabled(Long enabled) {
        this.enabled = enabled;
    }

    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemUser)) {
            return false;
        }
        SystemUser other = (SystemUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.security.SystemUser[userId=" + userId + "]";
    }

}
