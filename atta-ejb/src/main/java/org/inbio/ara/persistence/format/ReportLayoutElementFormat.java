/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.format;

import java.util.Calendar;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author pcorrales
 */
@Entity
@Table(name = "report_layout_element_format")
public class ReportLayoutElementFormat extends LogGenericEntity  {

    
    @EmbeddedId
    protected ReportLayoutElementFormatPK reportLayoutElementFormatPK;
   
    @JoinColumn(name = "report_layout_element_id", referencedColumnName = "report_layout_element_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ReportLayoutElement reportLayoutElement;

    public ReportLayoutElementFormat() {
    }

    public ReportLayoutElementFormat(ReportLayoutElementFormatPK reportLayoutElementFormatPK) {
        this.reportLayoutElementFormatPK = reportLayoutElementFormatPK;
    }

    public ReportLayoutElementFormat(ReportLayoutElementFormatPK reportLayoutElementFormatPK, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.reportLayoutElementFormatPK = reportLayoutElementFormatPK;
         this.setCreatedBy(createdBy);
         this.setCreationDate(creationDate);
         this.setLastModificationBy(lastModificationBy);
         this.setLastModificationDate(lastModificationDate);
    }

    public ReportLayoutElementFormat(Long elementFormatId, Long reportLayoutElementId) {
        this.reportLayoutElementFormatPK = new ReportLayoutElementFormatPK(elementFormatId, reportLayoutElementId);
    }

    public ReportLayoutElementFormatPK getReportLayoutElementFormatPK() {
        return reportLayoutElementFormatPK;
    }

    public void setReportLayoutElementFormatPK(ReportLayoutElementFormatPK reportLayoutElementFormatPK) {
        this.reportLayoutElementFormatPK = reportLayoutElementFormatPK;
    }

 

    public ReportLayoutElement getReportLayoutElement() {
        return reportLayoutElement;
    }

    public void setReportLayoutElement(ReportLayoutElement reportLayoutElement) {
        this.reportLayoutElement = reportLayoutElement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportLayoutElementFormatPK != null ? reportLayoutElementFormatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportLayoutElementFormat)) {
            return false;
        }
        ReportLayoutElementFormat other = (ReportLayoutElementFormat) object;
        if ((this.reportLayoutElementFormatPK == null && other.reportLayoutElementFormatPK != null) || (this.reportLayoutElementFormatPK != null && !this.reportLayoutElementFormatPK.equals(other.reportLayoutElementFormatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.format.ReportLayoutElementFormat[reportLayoutElementFormatPK=" + reportLayoutElementFormatPK + "]";
    }

}
