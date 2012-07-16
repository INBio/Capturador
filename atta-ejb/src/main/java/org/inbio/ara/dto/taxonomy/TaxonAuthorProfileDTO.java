/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.taxonomy;

/**
 *
 * @author gsulca
 */
public class TaxonAuthorProfileDTO
{
     /** Id TaxonAuthorProfile ENUM */
    private Long taxonAuthorProfileId;
    /** nameProperty that sholud be resolved in a properties file */
    private String nameAsProperty;

    private String identifier;



    public TaxonAuthorProfileDTO(Long taxonAuthorProfileId, String nameAsProperty, String identifier)
    {
        this.taxonAuthorProfileId = taxonAuthorProfileId;
        this.nameAsProperty = nameAsProperty;
        this.identifier = identifier;
    }

    /**
     * @return the taxonAuthorProfileId
     */
    public Long getTaxonAuthorProfileId() {
        return taxonAuthorProfileId;
    }

    /**
     * @param taxonAuthorProfileId the taxonAuthorProfileId to set
     */
    public void setTaxonAuthorProfileId(Long taxonAuthorProfileId) {
        this.taxonAuthorProfileId = taxonAuthorProfileId;
    }

    /**
     * @return the nameAsProperty
     */
    public String getNameAsProperty() {
        return nameAsProperty;
    }

    /**
     * @param nameAsProperty the nameAsProperty to set
     */
    public void setNameAsProperty(String nameAsProperty) {
        this.nameAsProperty = nameAsProperty;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    


}
