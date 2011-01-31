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
public class FuncionalityTypeDTO extends GenericDTO {

      //for GUI (List) proposity
    private boolean selected;

    
    private String description;
    private String funcionalityTypeKeyWord;
    private Calendar finalTimestand;
    private Calendar initialTimestand;
    private Long     funcionalityTypeId;

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
     * @return the finalTimestand
     */
    public Calendar getFinalTimestand() {
        return finalTimestand;
    }

    /**
     * @param finalTimestand the finalTimestand to set
     */
    public void setFinalTimestand(Calendar finalTimestand) {
        this.finalTimestand = finalTimestand;
    }

    /**
     * @return the initialTimestand
     */
    public Calendar getInitialTimestand() {
        return initialTimestand;
    }

    /**
     * @param initialTimestand the initialTimestand to set
     */
    public void setInitialTimestand(Calendar initialTimestand) {
        this.initialTimestand = initialTimestand;
    }

    /**
     * @return the funcionalityTypeId
     */
    public Long getFuncionalityTypeId() {
        return funcionalityTypeId;
    }

    /**
     * @param funcionalityTypeId the funcionalityTypeId to set
     */
    public void setFuncionalityTypeId(Long funcionalityTypeId) {
        this.funcionalityTypeId = funcionalityTypeId;
    }

    /**
     * @return the funcionalityTypeKeyWord
     */
    public String getFuncionalityTypeKeyWord() {
        return funcionalityTypeKeyWord;
    }

    /**
     * @param funcionalityTypeKeyWord the funcionalityTypeKeyWord to set
     */
    public void setFuncionalityTypeKeyWord(String funcionalityTypeKeyWord) {
        this.funcionalityTypeKeyWord = funcionalityTypeKeyWord;
    }
}
