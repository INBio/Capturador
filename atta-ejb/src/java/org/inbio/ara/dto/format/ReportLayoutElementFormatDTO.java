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
public class ReportLayoutElementFormatDTO extends GenericDTO  {

  
   //for GUI (List) proposity
    private boolean selected;

    private Long   reportLayoutElementId;
    private Long   elementFormatId;
    private Calendar initialDate;
    private Calendar finalDate;

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



}
