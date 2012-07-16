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
public class TaxonCountryPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "taxon_id")
    private Long taxonId;
    @Basic(optional = false)
    @Column(name = "country_id")
    private Long countryId;

    public TaxonCountryPK() {
    }

    public TaxonCountryPK(Long taxonId, Long countryId) {
        this.taxonId = taxonId;
        this.countryId = countryId;
    }

    public Long getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonId != null ? taxonId.hashCode() : 0);
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonCountryPK)) {
            return false;
        }
        TaxonCountryPK other = (TaxonCountryPK) object;
        if ((this.taxonId == null && other.taxonId != null) || (this.taxonId != null && !this.taxonId.equals(other.taxonId))) {
            return false;
        }
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonCountryPK[taxonId=" + taxonId + ", countryId=" + countryId + "]";
    }

}
