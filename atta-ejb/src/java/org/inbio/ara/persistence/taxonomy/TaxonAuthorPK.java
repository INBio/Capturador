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
public class TaxonAuthorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "taxon_id")
    private Long taxonId;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @Column(name = "taxon_author_sequence")
    private Long taxonAuthorSequence;

    public TaxonAuthorPK() {
    }

    public TaxonAuthorPK(Long taxonId, String category, Long taxonAuthorSequence) {
        this.taxonId = taxonId;
        this.category = category;
        this.taxonAuthorSequence = taxonAuthorSequence;
    }

    public Long getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getTaxonAuthorSequence() {
        return taxonAuthorSequence;
    }

    public void setTaxonAuthorSequence(Long taxonAuthorSequence) {
        this.taxonAuthorSequence = taxonAuthorSequence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonId != null ? taxonId.hashCode() : 0);
        hash += (category != null ? category.hashCode() : 0);
        hash += (taxonAuthorSequence != null ? taxonAuthorSequence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonAuthorPK)) {
            return false;
        }
        TaxonAuthorPK other = (TaxonAuthorPK) object;
        if ((this.taxonId == null && other.taxonId != null) || (this.taxonId != null && !this.taxonId.equals(other.taxonId))) {
            return false;
        }
        if ((this.category == null && other.category != null) || (this.category != null && !this.category.equals(other.category))) {
            return false;
        }
        if ((this.taxonAuthorSequence == null && other.taxonAuthorSequence != null) || (this.taxonAuthorSequence != null && !this.taxonAuthorSequence.equals(other.taxonAuthorSequence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonAuthorPK[taxonId=" + taxonId + ", category=" + category + ", taxonAuthorSequence=" + taxonAuthorSequence + "]";
    }

}
