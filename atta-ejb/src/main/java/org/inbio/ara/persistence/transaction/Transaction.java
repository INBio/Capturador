/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.inbio.ara.persistence.transaction;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author echinchilla
 */
@Entity
@Table(name = "transaction")
public class Transaction extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
        @GeneratedValue(strategy=GenerationType.AUTO, generator="Transaction")
	@SequenceGenerator(name="Transaction", sequenceName="transaction_seq")
    @Basic(optional = false)
    @Column(name = "transaction_id")
    private Long transactionId;
    @Basic(optional = false)
    @Column(name = "transaction_date")
    @Temporal(TemporalType.DATE)
    private Calendar transactionDate;
    @Column(name = "invoice_number")
    private String invoiceNumber;
    @Column(name = "estimated_specimen_count")
    private Long estimatedSpecimenCount;
    @Column(name = "description")
    private String description;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Calendar expirationDate;
    
    @Column(name = "collection_id")
    private Long collectionId;

    @Column(name = "receiver_institution_id")
    private Long receiverInstitutionId;

    @Column(name = "sender_institution_id")
    private Long senderInstitutionId;

    @Column(name = "receiver_person_id")
    private Long receiverPersonId;

    @Column(name = "sender_person_id")
    private Long senderPersonId;

    @Column(name = "transaction_type_id")
    private Long transactionTypeId;

    public Transaction() {
    }

    public Transaction(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Transaction(Long transactionId, Calendar transactionDate) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Calendar getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Long getEstimatedSpecimenCount() {
        return estimatedSpecimenCount;
    }

    public void setEstimatedSpecimenCount(Long estimatedSpecimenCount) {
        this.estimatedSpecimenCount = estimatedSpecimenCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getReceiverInstitutionId() {
        return receiverInstitutionId;
    }

    public void setReceiverInstitutionId(Long receiverInstitutionId) {
        this.receiverInstitutionId = receiverInstitutionId;
    }

    public Long getSenderInstitutionId() {
        return senderInstitutionId;
    }

    public void setSenderInstitutionId(Long senderInstitutionId) {
        this.senderInstitutionId = senderInstitutionId;
    }

    public Long getReceiverPersonId() {
        return receiverPersonId;
    }

    public void setReceiverPersonId(Long receiverPersonId) {
        this.receiverPersonId = receiverPersonId;
    }

    public Long getSenderPersonId() {
        return senderPersonId;
    }

    public void setSenderPersonId(Long senderPersonId) {
        this.senderPersonId = senderPersonId;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.transaction.Transaction[transactionId=" + transactionId + "]";
    }

}
