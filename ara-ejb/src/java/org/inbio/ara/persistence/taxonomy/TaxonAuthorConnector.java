/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.taxonomy;


import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author gsulca
 */
@Entity
@Table(name = "taxon_author_connector")

public class TaxonAuthorConnector extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "taxon_author_connector_id")
    private Long taxonAuthorConnectorId;
  

    
    public TaxonAuthorConnector() {
    }

    public TaxonAuthorConnector(Long taxonAuthorConnectorId) {
        this.taxonAuthorConnectorId = taxonAuthorConnectorId;
    }

    public TaxonAuthorConnector(Long taxonAuthorConnectorId, String name, String description, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.taxonAuthorConnectorId = taxonAuthorConnectorId;
        this.setName(name);

        this.setDescription(description);

        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
        
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
        hash += (taxonAuthorConnectorId != null ? taxonAuthorConnectorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonAuthorConnector)) {
            return false;
        }
        TaxonAuthorConnector other = (TaxonAuthorConnector) object;
        if ((this.taxonAuthorConnectorId == null && other.taxonAuthorConnectorId != null) || (this.taxonAuthorConnectorId != null && !this.taxonAuthorConnectorId.equals(other.taxonAuthorConnectorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonAuthorConnector[taxonAuthorConnectorId=" + taxonAuthorConnectorId + "]";
    }

    @Override
    public Long getId() {
        return this.getTaxonAuthorConnectorId();
    }

    @Override
    public void setId(Long id) {
        this.setTaxonAuthorConnectorId(id);
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.TAXON_AUTHOR_CONNECTOR;
    }

}
