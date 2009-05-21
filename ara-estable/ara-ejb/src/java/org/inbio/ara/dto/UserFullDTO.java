/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto;

import java.util.List;

/**
 *
 * @author jgutierrez
 */
public class UserFullDTO extends UserLiteDTO {

    private Long groupKey;

	private String createdBy;

	private String lastModificationBy;
	
    private String password;

    private List<Long> selectedTaxonKeys;

    private List<Long> selectedNomenclaturalGroupKeys;

    
    /**
     * 
     */
    public UserFullDTO() {
        super();
    }

    /**
     * 
     * @param userKey
     * @param userName
     * @param fullName
     * @param password 
     * @param groupKey
     * @param selectedTaxonKeys
     * @param selectedNomenclaturalGroupKeys
     */
    public UserFullDTO(Long userKey, String userName, String fullName, String password, Long groupKey, List<Long> selectedTaxonKeys, List<Long> selectedNomenclaturalGroupKeys) {
        super(userKey, userName, fullName);
        this.groupKey = groupKey;
        this.selectedTaxonKeys = selectedTaxonKeys;
        this.selectedNomenclaturalGroupKeys = selectedNomenclaturalGroupKeys;
		this.password = password;
    }
    

    /**
     * @return the groupKey
     */
    public Long getGroupKey() {
        return groupKey;
    }

    /**
     * @param groupKey the groupKey to set
     */
    public void setGroupKey(Long groupKey) {
        this.groupKey = groupKey;
    }

    /**
     * @return the selectedTaxonKeys
     */
    public List<Long> getSelectedTaxonKeys() {
        return selectedTaxonKeys;
    }

    /**
     * @param selectedTaxonKeys the selectedTaxonKeys to set
     */
    public void setSelectedTaxonKeys(List<Long> selectedTaxonKeys) {
        this.selectedTaxonKeys = selectedTaxonKeys;
    }

    /**
     * @return the selectedNomenclaturalGroupKeys
     */
    public List<Long> getSelectedNomenclaturalGroupKeys() {
        return selectedNomenclaturalGroupKeys;
    }

    /**
     * @param selectedNomenclaturalGroupKeys the selectedNomenclaturalGroupKeys to set
     */
    public void setSelectedNomenclaturalGroupKeys(List<Long> selectedNomenclaturalGroupKeys) {
        this.selectedNomenclaturalGroupKeys = selectedNomenclaturalGroupKeys;
    }

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the lastModificationBy
	 */
	public String getLastModificationBy() {
		return lastModificationBy;
	}

	/**
	 * @param lastModificationBy the lastModificationBy to set
	 */
	public void setLastModificationBy(String lastModificationBy) {
		this.lastModificationBy = lastModificationBy;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
