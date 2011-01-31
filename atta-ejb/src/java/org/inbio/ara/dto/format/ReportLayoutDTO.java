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
public class ReportLayoutDTO  extends GenericDTO {

      //for GUI (List) proposity
    private boolean selected;


    private String contents;
    private String description;
    private String reportLayoutkeyWord;
    private Calendar finalTimestand;
    private Calendar initialTimestand;
    private Long     reportLayoutId;
    private Long     funcionalityTypeId;


      //Constructores de la clase
    public ReportLayoutDTO(){
    }
    public ReportLayoutDTO (String keyWord,Long id){
        this.reportLayoutId = id;
        this.reportLayoutkeyWord =  keyWord;
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
     * @return the contents
     */
    public String getContents() {
        return contents;
    }

    /**
     * @param contents the contents to set
     */
    public void setContents(String contents) {
        this.contents = contents;
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
     * @return the reportLayoutkeyWord
     */
    public String getReportLayoutkeyWord() {
        return reportLayoutkeyWord;
    }

    /**
     * @param reportLayoutkeyWord the reportLayoutkeyWord to set
     */
    public void setReportLayoutkeyWord(String reportLayoutkeyWord) {
        this.reportLayoutkeyWord = reportLayoutkeyWord;
    }
    
}
