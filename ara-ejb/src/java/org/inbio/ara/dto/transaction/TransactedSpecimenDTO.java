/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
    //private Long specimenId;
    private Long transactedSpecimenStatusId;
    //private Long transactionId;
    private Long transactionTypeId;

    private boolean selected;

    // read-only
    private String catalogNumber;
    // read-only
    private String taxonName;
    // read-only
    private String transactedSpecimenStatus;

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
     * @return the specimen
     */
    /*public Long getSpecimenId() {
    return specimenId;
    }*/

    /**
     * @param specimen the specimen to set
     */
    /*public void setSpecimenId(Long specimenId) {
    this.specimenId = specimenId;
    }*/

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
     * @return the transaction
     */
    /*public Long getTransactionId() {
    return transactionId;
    }*/

    /**
     * @param transaction the transaction to set
     */
    /*public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
    }*/

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
}
