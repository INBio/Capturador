/* Ara - capture species and specimen data
 * 
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad)
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
 * GenericEntity.java
 *
 * Created on June 6, 2007, 4:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;
import java.util.GregorianCalendar;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


/**
 * Entity class GenericEntity
 * 
 * @author Wilmer "El pato" Lopez
 */
@MappedSuperclass
public abstract class GenericEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

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
    

    /** Creates a new instance of GenericEntity */
    public GenericEntity() {
    }

    @PrePersist
    public void prePersist(){
        this.creationDate = new GregorianCalendar();
        this.createdBy="alambred";
        this.lastModificationDate = new GregorianCalendar();
        this.lastModificationBy="alambred";
    }

    @PreUpdate
    public void preUpdate(){
        this.creationDate = new GregorianCalendar();
        this.createdBy="alambred";
        this.lastModificationDate = new GregorianCalendar();
        this.lastModificationBy="alambred";
    }



    /**
     * @return the creationDate
     */
    public Calendar getCreationDate() {
        return creationDate;
    }


    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }


    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }


    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    /**
     * @return the lastModificationDate
     */
    public Calendar getLastModificationDate() {
        return lastModificationDate;
    }


    /**
     * @param lastModificationDate the lastModificationDate to set
     */
    public void setLastModificationDate(Calendar lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }


    /**
     * @return the lastModificationBy
     */
    public String getLastModificationBy() {
        return lastModificationBy;
    }


    /**
     * @param lastModificationBy the lastModificationBy to set
     */
    public void setLastModificationBy(String lastModificationBy) {
        this.lastModificationBy = lastModificationBy;
    }
  
}