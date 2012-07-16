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
@Table(name = "taxon_indicator_dublin_core")

public class TaxonIndicatorDublinCore extends LogGenericEntity  {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TaxonIndicatorDublinCorePK taxonIndicatorDublinCorePK;
    
    public TaxonIndicatorDublinCore() {
    }

    public TaxonIndicatorDublinCore(TaxonIndicatorDublinCorePK taxonIndicatorDublinCorePK) {
        this.taxonIndicatorDublinCorePK = taxonIndicatorDublinCorePK;
    }

    public TaxonIndicatorDublinCore(TaxonIndicatorDublinCorePK taxonIndicatorDublinCorePK, Calendar creationDate, String createdBy, Calendar lastModificationDate, String lastModificationBy) {
        this.taxonIndicatorDublinCorePK = taxonIndicatorDublinCorePK;

        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public TaxonIndicatorDublinCore(Long dublinCoreId, Long indicatorId, Long taxonId) {
        this.taxonIndicatorDublinCorePK = new TaxonIndicatorDublinCorePK(dublinCoreId, indicatorId, taxonId);
    }

    public TaxonIndicatorDublinCorePK getTaxonIndicatorDublinCorePK() {
        return taxonIndicatorDublinCorePK;
    }

    public void setTaxonIndicatorDublinCorePK(TaxonIndicatorDublinCorePK taxonIndicatorDublinCorePK) {
        this.taxonIndicatorDublinCorePK = taxonIndicatorDublinCorePK;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonIndicatorDublinCorePK != null ? taxonIndicatorDublinCorePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonIndicatorDublinCore)) {
            return false;
        }
        TaxonIndicatorDublinCore other = (TaxonIndicatorDublinCore) object;
        if ((this.taxonIndicatorDublinCorePK == null && other.taxonIndicatorDublinCorePK != null) || (this.taxonIndicatorDublinCorePK != null && !this.taxonIndicatorDublinCorePK.equals(other.taxonIndicatorDublinCorePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonIndicatorDublinCore[taxonIndicatorDublinCorePK=" + taxonIndicatorDublinCorePK + "]";
    }

}
