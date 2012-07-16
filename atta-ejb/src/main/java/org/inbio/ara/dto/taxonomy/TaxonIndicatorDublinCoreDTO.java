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
public class TaxonIndicatorDublinCoreDTO extends GenericDTO{
    private Long taxonId;
    private Long indicatorId;
    private Long dublinCoreId;

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
     * @return the indicatorId
     */
    public Long getIndicatorId() {
        return indicatorId;
    }

    /**
     * @param indicatorId the indicatorId to set
     */
    public void setIndicatorId(Long indicatorId) {
        this.indicatorId = indicatorId;
    }

    /**
     * @return the dublinCoreId
     */
    public Long getDublinCoreId() {
        return dublinCoreId;
    }

    /**
     * @param dublinCoreId the dublinCoreId to set
     */
    public void setDublinCoreId(Long dublinCoreId) {
        this.dublinCoreId = dublinCoreId;
    }


}
