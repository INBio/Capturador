/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.format;


import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "report_layout")

public class ReportLayout extends LogGenericEntity   {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "report_layout_id")
    private Long reportLayoutId;
    @Basic(optional = false)
    @Column(name = "report_layout_keyword")
    private String reportLayoutKeyWord;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "contents")
    private String contents;
    @JoinColumn(name = "funcionality_type_id", referencedColumnName = "funcionality_type_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private FuncionalityType funcionalityTypeId;

    public ReportLayout() {
    }

    public ReportLayout(Long reportLayoutId) {
        this.reportLayoutId = reportLayoutId;
    }

    public ReportLayout(Long reportLayoutId, String reportLayoutKeyWord , String description, String contents, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.reportLayoutId = reportLayoutId;
        this.reportLayoutKeyWord = reportLayoutKeyWord;
        this.description = description;
        this.contents = contents;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getReportLayoutId() {
        return reportLayoutId;
    }

    public void setReportLayoutId(Long reportLayoutId) {
        this.reportLayoutId = reportLayoutId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public FuncionalityType getFuncionalityTypeId() {
        return funcionalityTypeId;
    }

    public void setFuncionalityTypeId(FuncionalityType funcionalityTypeId) {
        this.funcionalityTypeId = funcionalityTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportLayoutId != null ? reportLayoutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportLayout)) {
            return false;
        }
        ReportLayout other = (ReportLayout) object;
        if ((this.reportLayoutId == null && other.reportLayoutId != null) || (this.reportLayoutId != null && !this.reportLayoutId.equals(other.reportLayoutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.formats.ReportLayout[reportLayoutId=" + reportLayoutId + "]";
    }

    /**
     * @return the reportLayoutKeyWord
     */
    public String getReportLayoutKeyWord() {
        return reportLayoutKeyWord;
    }

    /**
     * @param reportLayoutKeyWord the reportLayoutKeyWord to set
     */
    public void setReportLayoutKeyWord(String reportLayoutKeyWord) {
        this.reportLayoutKeyWord = reportLayoutKeyWord;
    }

}
