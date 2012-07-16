/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;

import java.io.Serializable;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author gsulca
 */
public class SynonymDTO extends GenericDTO implements Serializable {

    private Long taxonKey;
    private String currentName;
    private String defaultName;
    private boolean selected;

    public SynonymDTO() {
    }

    public SynonymDTO(Long taxonKey) {
        this.taxonKey = taxonKey;
    }

    public SynonymDTO(Long taxonKey, String currentName, String defaultName) {
        this.taxonKey = taxonKey;
        this.currentName = currentName;
        this.defaultName = defaultName;
    }


    /**
     * @return the taxonKey
     */
    public Long getTaxonKey() {
        return taxonKey;
    }

    /**
     * @param taxonKey the taxonKey to set
     */
    public void setTaxonKey(Long taxonKey) {
        this.taxonKey = taxonKey;
    }

    /**
     * @return the currentName
     */
    public String getCurrentName() {
        return currentName;
    }

    /**
     * @param currentName the currentName to set
     */
    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    /**
     * @return the defaultName
     */
    public String getDefaultName() {
        return defaultName;
    }

    /**
     * @param defaultName the defaultName to set
     */
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
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
