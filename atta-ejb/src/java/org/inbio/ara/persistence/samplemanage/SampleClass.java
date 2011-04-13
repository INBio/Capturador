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
@Table(name = "sample_class")
public class SampleClass extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="sample_class")
    @SequenceGenerator(name="sample_class", sequenceName="sample_class_seq")
    @Basic(optional = false)
    @Column(name = "sample_class_id")
    private Long sampleClassId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public SampleClass() {
    }

    public SampleClass(Long sampleClassId) {
        this.sampleClassId = sampleClassId;
    }

    public SampleClass(Long sampleClassId, String name, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.sampleClassId = sampleClassId;
        this.name = name;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getSampleClassId() {
        return sampleClassId;
    }

    public void setSampleClassId(Long sampleClassId) {
        this.sampleClassId = sampleClassId;
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
        hash += (sampleClassId != null ? sampleClassId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SampleClass)) {
            return false;
        }
        SampleClass other = (SampleClass) object;
        if ((this.sampleClassId == null && other.sampleClassId != null) || (this.sampleClassId != null && !this.sampleClassId.equals(other.sampleClassId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.samplemanage.SampleClass[sampleClassId=" + sampleClassId + "]";
    }

    @Override
    public Long getId() {
        return this.sampleClassId;
    }

    @Override
    public void setId(Long id) {
        this.sampleClassId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.SAMPLE_CLASS;
    }

}
