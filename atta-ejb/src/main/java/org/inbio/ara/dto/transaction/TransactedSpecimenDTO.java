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

package org.inbio.ara.dto.transaction;

import java.util.Calendar;
import org.inbio.ara.dto.GenericDTO;
import org.inbio.ara.persistence.transaction.TransactedSpecimenPK;

/**
 *
 * @author echinchilla
 */
public class TransactedSpecimenDTO extends GenericDTO {
    private TransactedSpecimenPK transactedSpecimenPK;
    private Calendar deliveryDate;
    private Calendar receivingDate;
    private String description;
    private Boolean waitingForReturn;
    private Calendar crationDateAndTime;
    private Long transactedSpecimenStatusId;
    private Long transactionTypeId;

    private boolean selected;

    // <editor-fold defaultstate="collapsed" desc="Variables Read-Only">
    private String catalogNumber;
    private String taxonName;
    private String transactedSpecimenStatus;
    private Calendar finalDeliveryDate;
    private Calendar finalReceivingDate;
    // </editor-fold>

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
     * @return the waitingForReturn
     */
    public Boolean getWaitingForReturn() {
        return waitingForReturn;
    }

    /**
     * @param waitingForReturn the waitingForReturn to set
     */
    public void setWaitingForReturn(Boolean waitingForReturn) {
        this.waitingForReturn = waitingForReturn;
    }

    /**
     * @return the crationDateAndTime
     */
    public Calendar getCrationDateAndTime() {
        return crationDateAndTime;
    }

    /**
     * @param crationDateAndTime the crationDateAndTime to set
     */
    public void setCrationDateAndTime(Calendar crationDateAndTime) {
        this.crationDateAndTime = crationDateAndTime;
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

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the catalogNumber
     */
    public String getCatalogNumber() {
        return catalogNumber;
    }

    /**
     * @param catalogNumber the catalogNumber to set
     */
    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    /**
     * @return the taxonName
     */
    public String getTaxonName() {
        return taxonName;
    }

    /**
     * @param taxonName the taxonName to set
     */
    public void setTaxonName(String taxonName) {
        this.taxonName = taxonName;
    }

    /**
     * @return the transactedSpecimenStatus
     */
    public String getTransactedSpecimenStatus() {
        return transactedSpecimenStatus;
    }

    /**
     * @param transactedSpecimenStatus the transactedSpecimenStatus to set
     */
    public void setTransactedSpecimenStatus(String transactedSpecimenStatus) {
        this.transactedSpecimenStatus = transactedSpecimenStatus;
    }

    /**
     * @return the finalDeliveryDate
     */
    public Calendar getFinalDeliveryDate() {
        return finalDeliveryDate;
    }

    /**
     * @param finalDeliveryDate the finalDeliveryDate to set
     */
    public void setFinalDeliveryDate(Calendar finalDeliveryDate) {
        this.finalDeliveryDate = finalDeliveryDate;
    }

    /**
     * @return the finalReceivingDate
     */
    public Calendar getFinalReceivingDate() {
        return finalReceivingDate;
    }

    /**
     * @param finalReceivingDate the finalReceivingDate to set
     */
    public void setFinalReceivingDate(Calendar finalReceivingDate) {
        this.finalReceivingDate = finalReceivingDate;
    }
}
