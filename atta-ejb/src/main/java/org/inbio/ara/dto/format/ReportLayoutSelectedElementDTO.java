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
public class ReportLayoutSelectedElementDTO extends GenericDTO {

    private Long reportLayoutSelectedId;
    private Long elementFormatId;
    private Long reportLayoutId;
    private Long reportLayoutElementId;

    private Calendar initialDate;
    private Calendar finalDate;

   //for GUI (List) proposity
    private boolean selected;


    /**
     * @return the reportLayoutSelectedId
     */
    public Long getReportLayoutSelectedId() {
        return reportLayoutSelectedId;
    }

    /**
     * @param reportLayoutSelectedId the reportLayoutSelectedId to set
     */
    public void setReportLayoutSelectedId(Long reportLayoutSelectedId) {
        this.reportLayoutSelectedId = reportLayoutSelectedId;
    }

    /**
     * @return the elementFormatId
     */
    public Long getElementFormatId() {
        return elementFormatId;
    }

    /**
     * @param elementFormatId the elementFormatId to set
     */
    public void setElementFormatId(Long elementFormatId) {
        this.elementFormatId = elementFormatId;
    }

    /**
     * @return the reportLayoutId
     */
    public Long getReportLayoutId() {
        return reportLayoutId;
    }

    /**
     * @param reportLayoutId the reportLayoutId to set
     */
    public void setReportLayoutId(Long reportLayoutId) {
        this.reportLayoutId = reportLayoutId;
    }

    /**
     * @return the reportLayoutElementId
     */
    public Long getReportLayoutElementId() {
        return reportLayoutElementId;
    }

    /**
     * @param reportLayoutElementId the reportLayoutElementId to set
     */
    public void setReportLayoutElementId(Long reportLayoutElementId) {
        this.reportLayoutElementId = reportLayoutElementId;
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
