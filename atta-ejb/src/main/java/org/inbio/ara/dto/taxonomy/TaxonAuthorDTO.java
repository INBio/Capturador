/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author gsulca
 */
public class TaxonAuthorDTO extends GenericDTO{
    private boolean selected;
    private Long taxonId;
    private String category;
    private Long taxonAuthorSequence;
    private Long taxonAuthorConnectorId;
    private Long taxonAuthorPersonId;
    private String taxonAuthorName;
    private String taxonAuthorConnector;
    /**
     * @return the taxonId
     */
    public Long getTaxonId() {
        return taxonId;
    }

    /**
     * @param taxonId the taxonId to set
     */
    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the taxonAuthorSequence
     */
    public Long getTaxonAuthorSequence() {
        return taxonAuthorSequence;
    }

    /**
     * @param taxonAuthorSequence the taxonAuthorSequence to set
     */
    public void setTaxonAuthorSequence(Long taxonAuthorSequence) {
        this.taxonAuthorSequence = taxonAuthorSequence;
    }

    /**
     * @return the taxonAuthorConnectorId
     */
    public Long getTaxonAuthorConnectorId() {
        return taxonAuthorConnectorId;
    }

    /**
     * @param taxonAuthorConnectorId the taxonAuthorConnectorId to set
     */
    public void setTaxonAuthorConnectorId(Long taxonAuthorConnectorId) {
        this.taxonAuthorConnectorId = taxonAuthorConnectorId;
    }

    /**
     * @return the taxonAuthorPersonId
     */
    public Long getTaxonAuthorPersonId() {
        return taxonAuthorPersonId;
    }

    /**
     * @param taxonAuthorPersonId the taxonAuthorPersonId to set
     */
    public void setTaxonAuthorPersonId(Long taxonAuthorPersonId) {
        this.taxonAuthorPersonId = taxonAuthorPersonId;
    }

    /**
     * @return the seleted
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param seleted the seleted to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the taxonAuthorName
     */
    public String getTaxonAuthorName() {
        return taxonAuthorName;
    }

    /**
     * @param taxonAuthorName the taxonAuthorName to set
     */
    public void setTaxonAuthorName(String taxonAuthorName) {
        this.taxonAuthorName = taxonAuthorName;
    }

    /**
     * @return the taxonAuthorConnector
     */
    public String getTaxonAuthorConnector() {
        return taxonAuthorConnector;
    }

    /**
     * @param taxonAuthorConnector the taxonAuthorConnector to set
     */
    public void setTaxonAuthorConnector(String taxonAuthorConnector) {
        this.taxonAuthorConnector = taxonAuthorConnector;
    }

}
