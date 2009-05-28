/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.util;

import java.io.Serializable;
import java.math.BigDecimal;
import org.inbio.ara.persistence.specimen.DwcCategory;

/**
 *
 * @author esmata
 */
public class StandardNode implements Serializable {

    //Variables
    private BigDecimal checkBoxNameId;
    private String keyword;
    private String name;
    private String selected;
    private DwcCategory category;

    //Empty constructor
    public StandardNode(){
        this.checkBoxNameId = new BigDecimal(0);
        this.keyword = null;
        this.selected = "0";
        this.category = null;
        this.name = null;
    }

    //Constructor with parameters
    public StandardNode(BigDecimal checkBoxNameId,String keyword,String selected,DwcCategory category, String name){
        this.checkBoxNameId = checkBoxNameId;
        this.keyword = keyword;
        this.selected = selected;
        this.category = category;
        this.name = name;
    }


    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the selected
     */
    public String getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(String selected) {
        this.selected = selected;
    }

    /**
     * @return the category
     */
    public DwcCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(DwcCategory category) {
        this.category = category;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the checkBoxNameId
     */
    public BigDecimal getCheckBoxNameId() {
        return checkBoxNameId;
    }

    /**
     * @param checkBoxNameId the checkBoxNameId to set
     */
    public void setCheckBoxNameId(BigDecimal checkBoxNameId) {
        this.checkBoxNameId = checkBoxNameId;
    }

}
