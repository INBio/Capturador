/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.transaction;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.specimen.Specimen;

/**
 *
 * @author echinchilla
 */
@Entity
@Table(name = "transacted_specimen")
public class TransactedSpecimen extends LogGenericEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransactedSpecimenPK transactedSpecimenPK;
    @Basic(optional = false)
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Calendar deliveryDate;
    @Column(name = "receiving_date")
    @Temporal(TemporalType.DATE)
    private Calendar receivingDate;
    @Column(name = "description")
    private String description;

    /*@JoinColumn(name = "specimen_id", referencedColumnName = "specimen_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Specimen specimen;*/

    /*@Column (name = "specimen_id")
    private Long specimenId;*/

    /*@JoinColumn(name = "transacted_specimen_status_id", referencedColumnName = "transacted_specimen_status_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TransactedSpecimenStatus transactedSpecimenStatusId;*/
    @Column (name = "transacted_specimen_status_id")
    private Long transactedSpecimenStatusId;

    /*@JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Transaction transaction;*/
    /*@Column (name = "transaction_id")
    private Long transactionId;*/

    /*@JoinColumn(name = "transaction_type_id", referencedColumnName = "transaction_type_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TransactionType transactionTypeId;*/
    @Column(name = "transaction_type_id")
    private Long transactionTypeId;

    public TransactedSpecimen() {
    }

    public TransactedSpecimen(TransactedSpecimenPK transactedSpecimenPK) {
        this.transactedSpecimenPK = transactedSpecimenPK;
    }

    public TransactedSpecimen(TransactedSpecimenPK transactedSpecimenPK, Calendar deliveryDate) {
        this.transactedSpecimenPK = transactedSpecimenPK;
        this.deliveryDate = deliveryDate;
    }

    public TransactedSpecimen(Long specimenId, Long transactionId) {
        this.transactedSpecimenPK = new TransactedSpecimenPK(specimenId, transactionId);
    }

    public TransactedSpecimenPK getTransactedSpecimenPK() {
        return transactedSpecimenPK;
    }

    public void setTransactedSpecimenPK(TransactedSpecimenPK transactedSpecimenPK) {
        this.transactedSpecimenPK = transactedSpecimenPK;
    }

    public Calendar getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Calendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Calendar getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Calendar receivingDate) {
        this.receivingDate = receivingDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /*public Long getSpecimenId() {
    return specimenId;
    }

    public void setSpecimenId(Long specimenId) {
    this.specimenId = specimenId;
    }*/

    public Long getTransactedSpecimenStatusId() {
        return transactedSpecimenStatusId;
    }

    public void setTransactedSpecimenStatusId(Long transactedSpecimenStatusId) {
        this.transactedSpecimenStatusId = transactedSpecimenStatusId;
    }

    /*public Long getTransactionId() {
    return transactionId;
    }

    public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
    }*/

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactedSpecimenPK != null ? transactedSpecimenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactedSpecimen)) {
            return false;
        }
        TransactedSpecimen other = (TransactedSpecimen) object;
        if ((this.transactedSpecimenPK == null && other.transactedSpecimenPK != null) || (this.transactedSpecimenPK != null && !this.transactedSpecimenPK.equals(other.transactedSpecimenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.transaction.TransactedSpecimen[transactedSpecimenPK=" + transactedSpecimenPK + "]";
    }

}
