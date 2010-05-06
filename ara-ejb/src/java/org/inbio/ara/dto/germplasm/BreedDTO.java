/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.germplasm;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author dasolano
 */
public class BreedDTO extends GenericDTO {

    /* For Graphical Inteface purposes */
    private boolean selected;

    private Long breedId;

    private String name;

    private Long taxonId;

    private String taxonName;

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
     * @return the breedId
     */
    public Long getBreedId() {
        return breedId;
    }

    /**
     * @param breedId the breedId to set
     */
    public void setBreedId(Long breedId) {
        this.breedId = breedId;
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
     * @return the taxonName
     */
    public String getTaxonName() {
        return taxonName;
    }

    /**
     * @param taxonName the taxonName to set
     */
    public void setTaxonName(String taxonName) {
        this.taxonName = taxonName;
    }
}
