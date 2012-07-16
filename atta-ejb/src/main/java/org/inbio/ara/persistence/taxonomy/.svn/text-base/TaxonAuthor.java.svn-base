/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import java.math.BigDecimal;
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
import org.inbio.ara.persistence.person.PersonProfile;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "taxon_author")

public class TaxonAuthor extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TaxonAuthorPK taxonAuthorPK;

    @Column(name = "taxon_author_person_id")
    private Long taxonAuthorPersonId;

    @Column(name = "taxon_author_connector_id")
    private Long taxonAuthorConnectorId;
        

    public TaxonAuthor() {
    }

    public TaxonAuthor(TaxonAuthorPK taxonAuthorPK) {
        this.taxonAuthorPK = taxonAuthorPK;
    }

    public TaxonAuthor(TaxonAuthorPK taxonAuthorPK, Long taxonAuthorPersonId, Long taxonAuthorConnectorId , String createdBy, Calendar creationDate,
            String lastModificationBy, Calendar lastModificationDate) {

        this.taxonAuthorPK = taxonAuthorPK;
        this.taxonAuthorPersonId = taxonAuthorPersonId;
        this.taxonAuthorConnectorId = taxonAuthorConnectorId;
        
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);

        
    }

    public TaxonAuthor(Long taxonId, String category, Long taxonAuthorSequence) {
        this.taxonAuthorPK = new TaxonAuthorPK(taxonId, category, taxonAuthorSequence);
    }

    public TaxonAuthorPK getTaxonAuthorPK() {
        return taxonAuthorPK;
    }

    public void setTaxonAuthorPK(TaxonAuthorPK taxonAuthorPK) {
        this.taxonAuthorPK = taxonAuthorPK;
    }

    

    public Long getTaxonAuthorConnectorId() {
        return taxonAuthorConnectorId;
    }

    public void setTaxonAuthorConnectorId(Long taxonAuthorConnectorId) {
        this.taxonAuthorConnectorId = taxonAuthorConnectorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonAuthorPK != null ? taxonAuthorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonAuthor)) {
            return false;
        }
        TaxonAuthor other = (TaxonAuthor) object;
        if ((this.taxonAuthorPK == null && other.taxonAuthorPK != null) || (this.taxonAuthorPK != null && !this.taxonAuthorPK.equals(other.taxonAuthorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonAuthor[taxonAuthorPK=" + taxonAuthorPK + "]";
    }

    /**
     * @return the taxonAuthorPersonId
     */
    public Long getTaxonAuthorPersonId() {
        return taxonAuthorPersonId;
    }

    /**
     * @param taxonAuthorPersonId the taxonAuthorPersonId to set
     */
    public void setTaxonAuthorPersonId(Long taxonAuthorPersonId) {
        this.taxonAuthorPersonId = taxonAuthorPersonId;
    }

}
