/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

/**
 *
 * @author esmata
 */
public class TaxonCategoryDTO {
	private Long taxonCategoryId;
	private String name;
	private String description;

	public TaxonCategoryDTO() {
	}

	public TaxonCategoryDTO(Long taxonCategoryId, String name, String description) {
		this.taxonCategoryId = taxonCategoryId;
		this.name = name;
		this.description = description;
	}

    /**
     * @return the taxonCategoryId
     */
    public Long getTaxonCategoryId() {
        return taxonCategoryId;
    }

    /**
     * @param taxonCategoryId the taxonCategoryId to set
     */
    public void setTaxonCategoryId(Long taxonCategoryId) {
        this.taxonCategoryId = taxonCategoryId;
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
}
