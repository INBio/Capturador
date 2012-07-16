/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.transaction;

import java.util.Calendar;
//import java.util.Collection;
import javax.persistence.Basic;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
//import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author echinchilla
 */
@Entity
@Table(name = "transaction_type")
public class TransactionType extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
        @GeneratedValue(strategy=GenerationType.AUTO, generator="TransactionType")
	@SequenceGenerator(name="TransactionType", sequenceName="transaction_type_seq")
    @Basic(optional = false)
    @Column(name = "transaction_type_id")
    private Long transactionTypeId;
    /*@Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionTypeId", fetch = FetchType.LAZY)
    private Collection<Transaction> transactionCollection;

    @OneToMany(mappedBy = "transactionTypeId", fetch = FetchType.LAZY)
    private Collection<TransactedSpecimen> transactedSpecimenCollection;*/
    public TransactionType() {
    }

    public TransactionType(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public TransactionType(Long transactionTypeId, String name, String createdBy,
            Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.setId(transactionTypeId);
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

     @Override
    public Long getId() {
         return transactionTypeId;
    }

    @Override
    public void setId(Long id) {
        this.transactionTypeId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.TRANSACTION_TYPE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionTypeId != null ? transactionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionType)) {
            return false;
        }
        TransactionType other = (TransactionType) object;
        if ((this.transactionTypeId == null && other.transactionTypeId != null) || (this.transactionTypeId != null && !this.transactionTypeId.equals(other.transactionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.transaction.TransactionType[transactionTypeId=" + transactionTypeId + "]";
    }

}
