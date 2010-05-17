/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.indicator;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "dublin_core_format")

public class DublinCoreFormat extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="dublin_core_format")
    @SequenceGenerator(name="dublin_core_format", sequenceName="dublin_core_format_seq")
    @Basic(optional = false)
    @Column(name = "dublin_core_format_id")
    private Long dublinCoreFormatId;
   
    public DublinCoreFormat() {
    }

    public DublinCoreFormat(Long dublinCoreFormatId) {
        this.dublinCoreFormatId = dublinCoreFormatId;
    }

    public DublinCoreFormat(Long dublinCoreFormatId, String name, String description, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.dublinCoreFormatId = dublinCoreFormatId;
    this.setName(name);
        this.setDescription(description);

        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
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

    @Override
    public Long getId() {
        return this.dublinCoreFormatId;
    }

    @Override
    public void setId(Long id) {
        this.dublinCoreFormatId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.DUBLIN_CORE_FORMAT;
    }

}
