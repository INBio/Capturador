/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.samplemanage;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author dasolano
 */
public class HostInformationDTO extends GenericDTO{

    private Long hostInformationId;

    private String healthComment;

    private Long sampleId;

    private Long diameter;

    private Long taxonId;

    private String taxon;

    /* For Graphical Inteface purposes */
    private boolean selected;

    /**
     * @return the hostInformationId
     */
    public Long getHostInformationId() {
        return hostInformationId;
    }

    /**
     * @param hostInformationId the hostInformationId to set
     */
    public void setHostInformationId(Long hostInformationId) {
        this.hostInformationId = hostInformationId;
    }

    /**
     * @return the healthComment
     */
    public String getHealthComment() {
        return healthComment;
    }

    /**
     * @param healthComment the healthComment to set
     */
    public void setHealthComment(String healthComment) {
        this.healthComment = healthComment;
    }

    /**
     * @return the sampleId
     */
    public Long getSampleId() {
        return sampleId;
    }

    /**
     * @param sampleId the sampleId to set
     */
    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
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
     * @return the taxon
     */
    public String getTaxon() {
        return taxon;
    }

    /**
     * @param taxon the taxon to set
     */
    public void setTaxon(String taxon) {
        this.taxon = taxon;
    }

    /**
     * @return the diameter
     */
    public Long getDiameter() {
        return diameter;
    }

    /**
     * @param diameter the diameter to set
     */
    public void setDiameter(Long diameter) {
        this.diameter = diameter;
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
