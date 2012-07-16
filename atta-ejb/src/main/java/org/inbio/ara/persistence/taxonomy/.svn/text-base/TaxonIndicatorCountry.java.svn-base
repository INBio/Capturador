/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;


import java.util.Calendar;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "taxon_indicator_country")

public class TaxonIndicatorCountry extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TaxonIndicatorCountryPK taxonIndicatorCountryPK;
    
    //private TaxonIndicator taxonIndicator;

    public TaxonIndicatorCountry() {
    }

    public TaxonIndicatorCountry(TaxonIndicatorCountryPK taxonIndicatorCountryPK) {
        this.taxonIndicatorCountryPK = taxonIndicatorCountryPK;
    }

    public TaxonIndicatorCountry(TaxonIndicatorCountryPK taxonIndicatorCountryPK, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.taxonIndicatorCountryPK = taxonIndicatorCountryPK;

        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
        
    }

    public TaxonIndicatorCountry(Long countryId, Long indicatorId, Long taxonId) {
        this.taxonIndicatorCountryPK = new TaxonIndicatorCountryPK(countryId, indicatorId, taxonId);
    }

    public TaxonIndicatorCountryPK getTaxonIndicatorCountryPK() {
        return taxonIndicatorCountryPK;
    }

    public void setTaxonIndicatorCountryPK(TaxonIndicatorCountryPK taxonIndicatorCountryPK) {
        this.taxonIndicatorCountryPK = taxonIndicatorCountryPK;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonIndicatorCountryPK != null ? taxonIndicatorCountryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonIndicatorCountry)) {
            return false;
        }
        TaxonIndicatorCountry other = (TaxonIndicatorCountry) object;
        if ((this.taxonIndicatorCountryPK == null && other.taxonIndicatorCountryPK != null) || (this.taxonIndicatorCountryPK != null && !this.taxonIndicatorCountryPK.equals(other.taxonIndicatorCountryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonIndicatorCountry[taxonIndicatorCountryPK=" + taxonIndicatorCountryPK + "]";
    }

}
