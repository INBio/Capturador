/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.format;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author pcorrales
 */
@Embeddable
public class ReportLayoutElementFormatPK implements Serializable  {
    @Basic(optional = false)
    @Column(name = "element_format_id")
    private Long elementFormatId;
    @Basic(optional = false)
    @Column(name = "report_layout_element_id")
    private Long reportLayoutElementId;

    public ReportLayoutElementFormatPK() {
    }

    public ReportLayoutElementFormatPK(Long elementFormatId, Long reportLayoutElementId) {
        this.elementFormatId = elementFormatId;
        this.reportLayoutElementId = reportLayoutElementId;
    }

    public Long getElementFormatId() {
        return elementFormatId;
    }

    public void setElementFormatId(Long elementFormatId) {
        this.elementFormatId = elementFormatId;
    }

    public Long getReportLayoutElementId() {
        return reportLayoutElementId;
    }

    public void setReportLayoutElementId(Long reportLayoutElementId) {
        this.reportLayoutElementId = reportLayoutElementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elementFormatId != null ? elementFormatId.hashCode() : 0);
        hash += (reportLayoutElementId != null ? reportLayoutElementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportLayoutElementFormatPK)) {
            return false;
        }
        ReportLayoutElementFormatPK other = (ReportLayoutElementFormatPK) object;
        if ((this.elementFormatId == null && other.elementFormatId != null) || (this.elementFormatId != null && !this.elementFormatId.equals(other.elementFormatId))) {
            return false;
        }
        if ((this.reportLayoutElementId == null && other.reportLayoutElementId != null) || (this.reportLayoutElementId != null && !this.reportLayoutElementId.equals(other.reportLayoutElementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.format.ReportLayoutElementFormatPK[elementFormatId=" + elementFormatId + ", reportLayoutElementId=" + reportLayoutElementId + "]";
    }

}
