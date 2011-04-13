/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.samplemanage;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author dasolano
 */
@Entity
@Table(name = "micro_method")
public class MicroMethod extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="micro_method")
    @SequenceGenerator(name="micro_method", sequenceName="micro_method_seq")
    @Basic(optional = false)
    @Column(name = "micro_method_id")
    private Long microMethodId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    public MicroMethod() {
    }

    public MicroMethod(Long microMethodId) {
        this.microMethodId = microMethodId;
    }

    public MicroMethod(Long microMethodId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.microMethodId = microMethodId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getMicroMethodId() {
        return microMethodId;
    }

    public void setMicroMethodId(Long microMethodId) {
        this.microMethodId = microMethodId;
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

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (microMethodId != null ? microMethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MicroMethod)) {
            return false;
        }
        MicroMethod other = (MicroMethod) object;
        if ((this.microMethodId == null && other.microMethodId != null) || (this.microMethodId != null && !this.microMethodId.equals(other.microMethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.MicroMethod[microMethodId=" + microMethodId + "]";
    }

    @Override
    public Long getId() {
        return this.microMethodId;
    }

    @Override
    public void setId(Long id) {
        this.microMethodId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.MICRO_METHOD;
    }

}
