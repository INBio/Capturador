/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author gsulca
 */
@Embeddable
public class TaxonIndicatorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "indicator_id")
    private Long indicatorId;
    @Basic(optional = false)
    @Column(name = "taxon_id")
    private Long taxonId;

    public TaxonIndicatorPK() {
    }

    public TaxonIndicatorPK(Long indicatorId, Long taxonId) {
        this.indicatorId = indicatorId;
        this.taxonId = taxonId;
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
        hash += (indicatorId != null ? indicatorId.hashCode() : 0);
        hash += (taxonId != null ? taxonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonIndicatorPK)) {
            return false;
        }
        TaxonIndicatorPK other = (TaxonIndicatorPK) object;
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
        return "org.inbio.ara.persistence.taxonomy.TaxonIndicatorPK[indicatorId=" + indicatorId + ", taxonId=" + taxonId + "]";
    }

}
