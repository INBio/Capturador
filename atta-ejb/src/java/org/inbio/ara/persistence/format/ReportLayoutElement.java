/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.format;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author pcorrales
 */
@Entity
@Table(name = "report_layout_element")
public class ReportLayoutElement  extends LogGenericEntity{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "report_layout_element_id")
    private Long reportLayoutElementId;
    @Basic(optional = false)
    @Column(name = "report_layout_element_sequence")
    private Long reportLayoutElementSequence;
    @Basic(optional = false)
    @Column(name = "element_keyword")
    private String elementKeyword;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "element_required")
    private Long elementRequired;
    @Column(name = "entity")
    private String entity;
    @Column(name = "entity_key_field")
    private String entityKeyField;
    @Column(name = "entity_main_field")
    private String entityMainField;
    @JoinColumn(name = "report_layout_category_id", referencedColumnName = "report_layout_category_id")
    @ManyToOne(optional = false)
    private ReportLayoutCategory reportLayoutCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportLayoutElement")
    private Collection<ReportLayoutElementFormat> reportLayoutElementFormatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportLayoutElementId")
    private Collection<ReportLayoutSelectedElement> reportLayoutSelectedElementCollection;

    public ReportLayoutElement() {
    }

    public ReportLayoutElement(Long reportLayoutElementId) {
        this.reportLayoutElementId = reportLayoutElementId;
    }

    public ReportLayoutElement(Long reportLayoutElementId, Long reportLayoutElementSequence, String elementKeyword, String description, Long elementRequired, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.reportLayoutElementId = reportLayoutElementId;
        this.reportLayoutElementSequence = reportLayoutElementSequence;
        this.elementKeyword = elementKeyword;
        this.description = description;
        this.elementRequired = elementRequired;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
       
    }

    public Long getReportLayoutElementId() {
        return reportLayoutElementId;
    }

    public void setReportLayoutElementId(Long reportLayoutElementId) {
        this.reportLayoutElementId = reportLayoutElementId;
    }

    public Long getReportLayoutElementSequence() {
        return reportLayoutElementSequence;
    }

    public void setReportLayoutElementSequence(Long reportLayoutElementSequence) {
        this.reportLayoutElementSequence = reportLayoutElementSequence;
    }

    public String getElementKeyword() {
        return elementKeyword;
    }

    public void setElementKeyword(String elementKeyword) {
        this.elementKeyword = elementKeyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getElementRequired() {
        return elementRequired;
    }

    public void setElementRequired(Long elementRequired) {
        this.elementRequired = elementRequired;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getEntityKeyField() {
        return entityKeyField;
    }

    public void setEntityKeyField(String entityKeyField) {
        this.entityKeyField = entityKeyField;
    }

    public String getEntityMainField() {
        return entityMainField;
    }

    public void setEntityMainField(String entityMainField) {
        this.entityMainField = entityMainField;
    }

    public ReportLayoutCategory getReportLayoutCategoryId() {
        return reportLayoutCategoryId;
    }

    public void setReportLayoutCategoryId(ReportLayoutCategory reportLayoutCategoryId) {
        this.reportLayoutCategoryId = reportLayoutCategoryId;
    }

    public Collection<ReportLayoutElementFormat> getReportLayoutElementFormatCollection() {
        return reportLayoutElementFormatCollection;
    }

    public void setReportLayoutElementFormatCollection(Collection<ReportLayoutElementFormat> reportLayoutElementFormatCollection) {
        this.reportLayoutElementFormatCollection = reportLayoutElementFormatCollection;
    }

    public Collection<ReportLayoutSelectedElement> getReportLayoutSelectedElementCollection() {
        return reportLayoutSelectedElementCollection;
    }

    public void setReportLayoutSelectedElementCollection(Collection<ReportLayoutSelectedElement> reportLayoutSelectedElementCollection) {
        this.reportLayoutSelectedElementCollection = reportLayoutSelectedElementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportLayoutElementId != null ? reportLayoutElementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportLayoutElement)) {
            return false;
        }
        ReportLayoutElement other = (ReportLayoutElement) object;
        if ((this.reportLayoutElementId == null && other.reportLayoutElementId != null) || (this.reportLayoutElementId != null && !this.reportLayoutElementId.equals(other.reportLayoutElementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.format.ReportLayoutElement[reportLayoutElementId=" + reportLayoutElementId + "]";
    }

}
