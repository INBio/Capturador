/* Ara - capture species and specimen data
 * 
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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
/*
 * SpecimenLifeForm.java
 *
 * Created on October 30, 2007, 2:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.genericEntity;

/**
 * Entity class TransactedSpecimen
 * 
 * @author roaguilar
 */
@Entity()
@Table(name="transacted_specimen")
public class TransactedSpecimen extends genericEntity {

    @EmbeddedId
    private TransactedSpecimenPK specimenTransactionPK;
    
    @JoinColumn(name="specimen_id", referencedColumnName="specimen_id", insertable = false, updatable=false)
    @ManyToOne()
    private Specimen specimen;
    
    @JoinColumn(name="transaction_id", referencedColumnName="transaction_id", insertable = false, updatable=false)
    @ManyToOne()
    private Transaction transaction;
    
    @Temporal(TemporalType.DATE)
    @Column(name="delivery_date", nullable = false)
    private Date deliveryDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name="receiving_date", nullable = true)
    private Date receivingDate;
    
    @JoinColumn(name="transacted_specimen_status_id", referencedColumnName="transacted_specimen_status_id")
    @ManyToOne()
    private TransactedSpecimenStatus transactedSpecimenStatus;
    
    @JoinColumn(name="transaction_type_id", referencedColumnName="transaction_type_id")
    @ManyToOne()
    private TransactionType transactionType;
    
    /** Creates a new instance of TransactedSpecimen */
    public TransactedSpecimen() {
    }
    
    public TransactedSpecimen(TransactedSpecimenPK specimenTransactionPK) {
        this.setTransactedSpecimenPK(specimenTransactionPK);
    }
    
    public TransactedSpecimen(Long specimenId, Long transactionId) {
        this.setTransactedSpecimenPK(new TransactedSpecimenPK(specimenId, transactionId));
    }

    public TransactedSpecimenPK getTransactedSpecimenPK() {
        return specimenTransactionPK;
    }

    public void setTransactedSpecimenPK(TransactedSpecimenPK specimenTransactionPK) {
        this.specimenTransactionPK = specimenTransactionPK;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.specimenTransactionPK != null ? this.specimenTransactionPK.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this PersonProfile.  The result is 
     * <code>true</code> if and only if the argument is not null and is a PersonProfile object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactedSpecimen)) {
            return false;
        }
        TransactedSpecimen other = (TransactedSpecimen)object;
        if (this.specimenTransactionPK != other.specimenTransactionPK && (this.specimenTransactionPK == null || !this.specimenTransactionPK.equals(other.specimenTransactionPK))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.TransactedSpecimen[specimenTransactionPK=" + specimenTransactionPK + "]";
    } 

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    public TransactedSpecimenStatus getTransactedSpecimenStatus() {
        return transactedSpecimenStatus;
    }

    public void setTransactedSpecimenStatus(TransactedSpecimenStatus transactedSpecimenStatus) {
        this.transactedSpecimenStatus = transactedSpecimenStatus;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
