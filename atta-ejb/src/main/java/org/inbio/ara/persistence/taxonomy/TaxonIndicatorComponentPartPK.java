/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author gsulca
 */
@Embeddable
public class TaxonIndicatorComponentPartPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "component_part_id")
    private Long componentPartId;
    @Basic(optional = false)
    @Column(name = "indicator_id")
    private Long indicatorId;
    @Basic(optional = false)
    @Column(name = "taxon_id")
    private Long taxonId;

    public TaxonIndicatorComponentPartPK() {
    }

    public TaxonIndicatorComponentPartPK(Long componentPartId, Long indicatorId, Long taxonId) {
        this.componentPartId = componentPartId;
        this.indicatorId = indicatorId;
        this.taxonId = taxonId;
    }

    public Long getComponentPartId() {
        return componentPartId;
    }

    public void setComponentPartId(Long componentPartId) {
        this.componentPartId = componentPartId;
    }

    public Long getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(Long indicatorId) {
        this.indicatorId = indicatorId;
    }

    public Long getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componentPartId != null ? componentPartId.hashCode() : 0);
        hash += (indicatorId != null ? indicatorId.hashCode() : 0);
        hash += (taxonId != null ? taxonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonIndicatorComponentPartPK)) {
            return false;
        }
        TaxonIndicatorComponentPartPK other = (TaxonIndicatorComponentPartPK) object;
        if ((this.componentPartId == null && other.componentPartId != null) || (this.componentPartId != null && !this.componentPartId.equals(other.componentPartId))) {
            return false;
        }
        if ((this.indicatorId == null && other.indicatorId != null) || (this.indicatorId != null && !this.indicatorId.equals(other.indicatorId))) {
            return false;
        }
        if ((this.taxonId == null && other.taxonId != null) || (this.taxonId != null && !this.taxonId.equals(other.taxonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonIndicatorComponentPartPK[componentPartId=" + componentPartId + ", indicatorId=" + indicatorId + ", taxonId=" + taxonId + "]";
    }

}
