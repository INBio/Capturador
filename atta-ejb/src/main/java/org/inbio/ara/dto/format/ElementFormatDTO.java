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
public class ElementFormatDTO extends GenericDTO {

    private  Long elementFormatId;
    private  String formatKeyWord;


   //for GUI (List) proposity
    private boolean selected;


    /*Calendar is read only */
    private Calendar initialDate;

    private Calendar finalDate;
    
  

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
     * @return the formatKeyWord
     */
    public String getFormatKeyWord() {
        return formatKeyWord;
    }

    /**
     * @param formatKeyWord the formatKeyWord to set
     */
    public void setFormatKeyWord(String formatKeyWord) {
        this.formatKeyWord = formatKeyWord;
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
