/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "taxon_country")
public class TaxonCountry extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TaxonCountryPK taxonCountryPK;
    @Column(name = "description")
    private String description;
    

    public TaxonCountry() {
    }

    public TaxonCountry(TaxonCountryPK taxonCountryPK) {
        this.taxonCountryPK = taxonCountryPK;
    }

    public TaxonCountry(TaxonCountryPK taxonCountryPK, String description ,Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.taxonCountryPK = taxonCountryPK;
        this.description = description;

        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public TaxonCountry(Long taxonId, Long countryId) {
        this.taxonCountryPK = new TaxonCountryPK(taxonId, countryId);
    }

    public TaxonCountryPK getTaxonCountryPK() {
        return taxonCountryPK;
    }

    public void setTaxonCountryPK(TaxonCountryPK taxonCountryPK) {
        this.taxonCountryPK = taxonCountryPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonCountryPK != null ? taxonCountryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonCountry)) {
            return false;
        }
        TaxonCountry other = (TaxonCountry) object;
        if ((this.taxonCountryPK == null && other.taxonCountryPK != null) || (this.taxonCountryPK != null && !this.taxonCountryPK.equals(other.taxonCountryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonCountry[taxonCountryPK=" + taxonCountryPK + "]";
    }

}
