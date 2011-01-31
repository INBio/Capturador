/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.format;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author pcorrales
 */
@Entity
@Table(name = "report_layout_selected_element")
public class ReportLayoutSelectedElement extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "report_layout_selected_element_id")
    private Long reportLayoutSelectedElementId;
    @ManyToOne(optional = false)
    private ElementFormat elementFormatId;
    @JoinColumn(name = "report_layout_id", referencedColumnName = "report_layout_id")
    @ManyToOne(optional = false)
    private ReportLayout reportLayoutId;
    @JoinColumn(name = "report_layout_element_id", referencedColumnName = "report_layout_element_id")
    @ManyToOne(optional = false)
    private ReportLayoutElement reportLayoutElementId;

    public ReportLayoutSelectedElement() {
    }

    public ReportLayoutSelectedElement(Long reportLayoutSelectedElementId) {
        this.reportLayoutSelectedElementId = reportLayoutSelectedElementId;
    }

    public ReportLayoutSelectedElement(Long reportLayoutSelectedElementId, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.reportLayoutSelectedElementId = reportLayoutSelectedElementId;
       
    }

    public Long getReportLayoutSelectedElementId() {
        return reportLayoutSelectedElementId;
    }

    public void setReportLayoutSelectedElementId(Long reportLayoutSelectedElementId) {
        this.reportLayoutSelectedElementId = reportLayoutSelectedElementId;
    }


    public ElementFormat getElementFormatId() {
        return elementFormatId;
    }

    public void setElementFormatId(ElementFormat elementFormatId) {
        this.elementFormatId = elementFormatId;
    }

    public ReportLayout getReportLayoutId() {
        return reportLayoutId;
    }

    public void setReportLayoutId(ReportLayout reportLayoutId) {
        this.reportLayoutId = reportLayoutId;
    }

    public ReportLayoutElement getReportLayoutElementId() {
        return reportLayoutElementId;
    }

    public void setReportLayoutElementId(ReportLayoutElement reportLayoutElementId) {
        this.reportLayoutElementId = reportLayoutElementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportLayoutSelectedElementId != null ? reportLayoutSelectedElementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportLayoutSelectedElement)) {
            return false;
        }
        ReportLayoutSelectedElement other = (ReportLayoutSelectedElement) object;
        if ((this.reportLayoutSelectedElementId == null && other.reportLayoutSelectedElementId != null) || (this.reportLayoutSelectedElementId != null && !this.reportLayoutSelectedElementId.equals(other.reportLayoutSelectedElementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.format.ReportLayoutSelectedElement[reportLayoutSelectedElementId=" + reportLayoutSelectedElementId + "]";
    }

}
