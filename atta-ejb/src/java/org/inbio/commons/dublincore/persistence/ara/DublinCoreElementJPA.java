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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @GeneratedValue(strategy=GenerationType.AUTO, generator="dublin_core_element")
    @SequenceGenerator(name="dublin_core_element", sequenceName="dublin_core_element_seq")
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
        this.creationDate = this.lastModificationDate;
        this.createdBy= this.lastModificationBy;
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
