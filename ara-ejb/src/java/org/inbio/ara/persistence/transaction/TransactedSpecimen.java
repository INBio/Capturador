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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;

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
    @Column(name = "waiting_for_return")
    private Boolean waitingForReturn;
    @Column(name = "creation_date_and_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationDateAndTime;

    @Column (name = "transacted_specimen_status_id")
    private Long transactedSpecimenStatusId;

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

    /**
     * @return the transactedSpecimenPK
     */
    public TransactedSpecimenPK getTransactedSpecimenPK() {
        return transactedSpecimenPK;
    }

    /**
     * @param transactedSpecimenPK the transactedSpecimenPK to set
     */
    public void setTransactedSpecimenPK(TransactedSpecimenPK transactedSpecimenPK) {
        this.transactedSpecimenPK = transactedSpecimenPK;
    }

    /**
     * @return the deliveryDate
     */
    public Calendar getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(Calendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return the receivingDate
     */
    public Calendar getReceivingDate() {
        return receivingDate;
    }

    /**
     * @param receivingDate the receivingDate to set
     */
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

    /**
     *
     * @return the waitingForReturn
     */
    public Boolean getWaitingForReturn() {
        return waitingForReturn;
    }

    /**
     *
     * @param waitingForReturn the waitingForReturn to set
     */
    public void setWaitingForReturn(Boolean waitingForReturn) {
        this.waitingForReturn = waitingForReturn;
    }

    /**
     * @return the creationDateAndTime
     */
    public Calendar getCreationDateAndTime() {
        return creationDateAndTime;
    }

    /**
     * @param creationDateAndTime the creationDateAndTime to set
     */
    public void setCreationDateAndTime(Calendar creationDateAndTime) {
        this.creationDateAndTime = creationDateAndTime;
    }

    /**
     * @return the transactedSpecimenStatusId
     */
    public Long getTransactedSpecimenStatusId() {
        return transactedSpecimenStatusId;
    }

    /**
     * @param transactedSpecimenStatusId the transactedSpecimenStatusId to set
     */
    public void setTransactedSpecimenStatusId(Long transactedSpecimenStatusId) {
        this.transactedSpecimenStatusId = transactedSpecimenStatusId;
    }

    /**
     * @return the transactionTypeId
     */
    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    /**
     * @param transactionTypeId the transactionTypeId to set
     */
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
