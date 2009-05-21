/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */ 
/*
 * genericEntity.java
 *
 * Created on June 6, 2007, 4:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.Version;
import javax.persistence.MappedSuperclass;
import java.util.Date;


/**
 * Entity class genericEntity
 * 
 * @author roaguilar
 */
@MappedSuperclass
public class genericEntity implements Serializable {

    @Temporal(TemporalType.DATE)
    @Column(name="creation_date", nullable = false)
    private Date creationDate;
    
    @Column(name="created_by", nullable = false)
    private String createdBy;

    @Temporal(TemporalType.DATE)
    @Column(name="last_modification_date", nullable = false)
    private Date lastModificationDate;
    
    @Column(name="last_modification_by", nullable = false)
    private String lastModificationBy;
    
    @Version
    @Column(name="obj_version")
    private Long version;
    
    /** Creates a new instance of genericEntity */
    public genericEntity() {
    }
    
    /**
     * 
     * @return 
     * @see 
     * @author 
     */
    
    public Long getVersion() {
        return this.version;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }
    
    @PrePersist     
    public void prePersist(){
        setAuditDateOnInsert();
    }
    
    @PreRemove
    public void preRemove(){
        
    }
    
    @PreUpdate
    public void preUpdate(){
        setAuditDateOnUpdate();
    }
    
    @PostLoad
    public void postLoad(){
        
    }
    
    @PostPersist
    public void postPersist(){
        
    }
    
    @PostRemove
    public void postRemove(){
        
    }
    
    @PostUpdate
    public void postUpdate(){
        
    }
    
    public void setAuditDateOnInsert() {
        this.setCreationDate();
        this.setLastModificationDate();
    }
    
    
    private void setAuditDateOnUpdate() {
        this.setLastModificationDate();
    }
    
    private void setCreationDate() {
        this.creationDate = new Date();
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
    
    private void setLastModificationDate() {
        this.lastModificationDate = new Date();
    }

    public String getLastModificationBy() {
        return lastModificationBy;
    }

    public void setLastModificationBy(String lastModificationBy) {
        this.lastModificationBy = lastModificationBy;
    }
}