/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.indicator;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author gsulca
 */
public class IndicatorDublinCoreDTO extends GenericDTO {
    private Long dublinCoreId;
    private Long indicatorId;



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

    
}
