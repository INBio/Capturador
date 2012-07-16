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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.indicator.ComponentPart;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "taxon_indicator_component_part")

public class TaxonIndicatorComponentPart extends LogGenericEntity  {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TaxonIndicatorComponentPartPK taxonIndicatorComponentPartPK;
    
    public TaxonIndicatorComponentPart() {
    }

    public TaxonIndicatorComponentPart(TaxonIndicatorComponentPartPK taxonIndicatorComponentPartPK) {
        this.taxonIndicatorComponentPartPK = taxonIndicatorComponentPartPK;
    }

    public TaxonIndicatorComponentPart(TaxonIndicatorComponentPartPK taxonIndicatorComponentPartPK, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.taxonIndicatorComponentPartPK = taxonIndicatorComponentPartPK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public TaxonIndicatorComponentPart(Long componentPartId, Long indicatorId, Long taxonId) {
        this.taxonIndicatorComponentPartPK = new TaxonIndicatorComponentPartPK(componentPartId, indicatorId, taxonId);
    }

    public TaxonIndicatorComponentPartPK getTaxonIndicatorComponentPartPK() {
        return taxonIndicatorComponentPartPK;
    }

    public void setTaxonIndicatorComponentPartPK(TaxonIndicatorComponentPartPK taxonIndicatorComponentPartPK) {
        this.taxonIndicatorComponentPartPK = taxonIndicatorComponentPartPK;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonIndicatorComponentPartPK != null ? taxonIndicatorComponentPartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonIndicatorComponentPart)) {
            return false;
        }
        TaxonIndicatorComponentPart other = (TaxonIndicatorComponentPart) object;
        if ((this.taxonIndicatorComponentPartPK == null && other.taxonIndicatorComponentPartPK != null) || (this.taxonIndicatorComponentPartPK != null && !this.taxonIndicatorComponentPartPK.equals(other.taxonIndicatorComponentPartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonIndicatorComponentPart[taxonIndicatorComponentPartPK=" + taxonIndicatorComponentPartPK + "]";
    }

}
