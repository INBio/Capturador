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
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author pcorrales
 */
@Entity
@Table(name = "report_layout_category")
public class ReportLayoutCategory extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "report_layout_category_id")
    private Long reportLayoutCategoryId;
    @Basic(optional = false)
    @Column(name = "category_keyword")
    private String categoryKeyword;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;


    public ReportLayoutCategory() {
    }

    public ReportLayoutCategory(Long reportLayoutCategoryId) {
        this.reportLayoutCategoryId = reportLayoutCategoryId;
    }

    public ReportLayoutCategory(Long reportLayoutCategoryId, String categoryKeyword, String description, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.reportLayoutCategoryId = reportLayoutCategoryId;
        this.categoryKeyword = categoryKeyword;
        this.description = description;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
       
    }

    public Long getReportLayoutCategoryId() {
        return reportLayoutCategoryId;
    }

    public void setReportLayoutCategoryId(Long reportLayoutCategoryId) {
        this.reportLayoutCategoryId = reportLayoutCategoryId;
    }

    public String getCategoryKeyword() {
        return categoryKeyword;
    }

    public void setCategoryKeyword(String categoryKeyword) {
        this.categoryKeyword = categoryKeyword;
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
        hash += (reportLayoutCategoryId != null ? reportLayoutCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportLayoutCategory)) {
            return false;
        }
        ReportLayoutCategory other = (ReportLayoutCategory) object;
        if ((this.reportLayoutCategoryId == null && other.reportLayoutCategoryId != null) || (this.reportLayoutCategoryId != null && !this.reportLayoutCategoryId.equals(other.reportLayoutCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.format.ReportLayoutCategory[reportLayoutCategoryId=" + reportLayoutCategoryId + "]";
    }

}
