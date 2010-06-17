/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.commons.dublincore.persistence.ara;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.PrePersist;
import javax.persistence.Table;



import org.inbio.commons.dublincore.model.DublinCoreElement;
/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "dublin_core_element")

public class DublinCoreElementJPA extends DublinCoreElement {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "resource_id")
    private int resourceId;
    @Basic(optional = false)
    @Column(name = "dublin_core_element_id")
    private int dublinCoreElementId;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    @Column(name = "language")
    private String language;



  /*
    public DublinCoreElementJPA() {
    }

    public DublinCoreElementJPA(Integer id) {
        this.id = id;
    }

    public DublinCoreElementJPA(Integer id, int resourceId, int dublinCoreElementId, String value, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.id = id;
        this.resourceId = resourceId;
        this.dublinCoreElementId = dublinCoreElementId;
        this.value = value;       
    }
*/

    @PrePersist
    public void prePersist(){
        this.setCreationDate(this.getLastModificationDate());
        this.setCreatedBy(this.getLastModificationBy());
        //this.creationDate = this.lastModificationDate;
        //this.createdBy= this.lastModificationBy;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getDublinCoreElementId() {
        return dublinCoreElementId;
    }

    public void setDublinCoreElementId(int dublinCoreElementId) {
        this.dublinCoreElementId = dublinCoreElementId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DublinCoreElementJPA)) {
            return false;
        }
        DublinCoreElementJPA other = (DublinCoreElementJPA) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.commons.dublincore.persistence.ara.DublinCoreElement[id=" + id + "]";
    }

}
