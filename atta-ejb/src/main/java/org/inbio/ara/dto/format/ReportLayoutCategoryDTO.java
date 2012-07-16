/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.dto.format;

import java.util.Calendar;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author pcorrales
 */
public class ReportLayoutCategoryDTO extends GenericDTO {

    //for GUI (List) proposity
    private boolean selected;

    private Long reportLayoutCategoryId;
    private String description;
    private String categoryKeyword;
    private Calendar initialDate;
    private Calendar finalDate;

    /**
     * @return the reportLayoutCategoryId
     */
    public Long getReportLayoutCategoryId() {
        return reportLayoutCategoryId;
    }

    /**
     * @param reportLayoutCategoryId the reportLayoutCategoryId to set
     */
    public void setReportLayoutCategoryId(Long reportLayoutCategoryId) {
        this.reportLayoutCategoryId = reportLayoutCategoryId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the initialDate
     */
    public Calendar getInitialDate() {
        return initialDate;
    }

    /**
     * @param initialDate the initialDate to set
     */
    public void setInitialDate(Calendar initialDate) {
        this.initialDate = initialDate;
    }

    /**
     * @return the finalDate
     */
    public Calendar getFinalDate() {
        return finalDate;
    }

    /**
     * @param finalDate the finalDate to set
     */
    public void setFinalDate(Calendar finalDate) {
        this.finalDate = finalDate;
    }

    /**
     * @return the categoryKeyword
     */
    public String getCategoryKeyword() {
        return categoryKeyword;
    }

    /**
     * @param categoryKeyword the categoryKeyword to set
     */
    public void setCategoryKeyword(String categoryKeyword) {
        this.categoryKeyword = categoryKeyword;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
