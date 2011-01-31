/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

/**
 *
 * @author gsulca
 */
public enum TaxonAuthorProfile {

    ORIGINALS(new Long(0), "original_author", "o"),
    MODIFICATORS(new Long(1), "modificator_author", "m");

    private Long id;
    private String nameAsProperty;
    private String identifier;

    private TaxonAuthorProfile(Long id, String nameProperty, String identifier)
    {
        this.id = id;
        this.nameAsProperty = nameProperty;
        this.identifier = identifier;
        
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
