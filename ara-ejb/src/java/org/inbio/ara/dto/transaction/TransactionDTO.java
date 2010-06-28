/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.transaction;

import java.util.Calendar;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author echinchilla
 */
public class TransactionDTO extends GenericDTO {

    private Long transactionId;
    private Calendar transactionDate;
    private String invoiceNumber;
    private Long estimatedSpecimenCount;
    private String description;
    private Calendar expirationDate;
    private Long collectionId;
    private Long receiverInstitutionId;
    private Long senderInstitutionId;
    private Long receiverPersonId;
    private Long senderPersonId;
    private Long transactionTypeId;

    private boolean selected;

// <editor-fold defaultstate="collapsed" desc="Read-only variables, not persisted">
    private String senderPersonName;
    private String senderInstitutionName;
    private String receiverPersonName;
    private String receiverInstitutionName;
    private String collectionName;
    private String transactionType;

    //Variables utilizadas para búsqueda avanzada
    private Calendar finalTransactionDate;
    private Calendar finalExpirationDate;
    private String catalogNumber;
// </editor-fold>

    /**
     * @return the transactionId
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the transactionDate
     */
    public Calendar getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * @return the invoiceNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * @param invoiceNumber the invoiceNumber to set
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * @return the estimatedSpecimenCount
     */
    public Long getEstimatedSpecimenCount() {
        return estimatedSpecimenCount;
    }

    /**
     * @param estimatedSpecimenCount the estimatedSpecimenCount to set
     */
    public void setEstimatedSpecimenCount(Long estimatedSpecimenCount) {
        this.estimatedSpecimenCount = estimatedSpecimenCount;
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
     * @return the expirationDate
     */
    public Calendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * @return the collectionId
     */
    public Long getCollectionId() {
        return collectionId;
    }

    /**
     * @param collectionId the collectionId to set
     */
    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * @return the receiverInstitutionId
     */
    public Long getReceiverInstitutionId() {
        return receiverInstitutionId;
    }

    /**
     * @param receiverInstitutionId the receiverInstitutionId to set
     */
    public void setReceiverInstitutionId(Long receiverInstitutionId) {
        this.receiverInstitutionId = receiverInstitutionId;
    }

    /**
     * @return the senderInstitutionId
     */
    public Long getSenderInstitutionId() {
        return senderInstitutionId;
    }

    /**
     * @param senderInstitutionId the senderInstitutionId to set
     */
    public void setSenderInstitutionId(Long senderInstitutionId) {
        this.senderInstitutionId = senderInstitutionId;
    }

    /**
     * @return the receiverPersonId
     */
    public Long getReceiverPersonId() {
        return receiverPersonId;
    }

    /**
     * @param receiverPersonId the receiverPersonId to set
     */
    public void setReceiverPersonId(Long receiverPersonId) {
        this.receiverPersonId = receiverPersonId;
    }

    /**
     * @return the senderPersonId
     */
    public Long getSenderPersonId() {
        return senderPersonId;
    }

    /**
     * @param senderPersonId the senderPersonId to set
     */
    public void setSenderPersonId(Long senderPersonId) {
        this.senderPersonId = senderPersonId;
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
     * @return the senderPersonName
     */
    public String getSenderPersonName() {
        return senderPersonName;
    }

    /**
     * @param senderPersonName the senderPersonName to set
     */
    public void setSenderPersonName(String senderPersonName) {
        this.senderPersonName = senderPersonName;
    }

    /**
     * @return the senderInstitutionName
     */
    public String getSenderInstitutionName() {
        return senderInstitutionName;
    }

    /**
     * @param senderInstitutionName the senderInstitutionName to set
     */
    public void setSenderInstitutionName(String senderInstitutionName) {
        this.senderInstitutionName = senderInstitutionName;
    }

    /**
     * @return the receiverPersonName
     */
    public String getReceiverPersonName() {
        return receiverPersonName;
    }

    /**
     * @param receiverPersonName the receiverPersonName to set
     */
    public void setReceiverPersonName(String receiverPersonName) {
        this.receiverPersonName = receiverPersonName;
    }

    /**
     * @return the receiverInstitutionName
     */
    public String getReceiverInstitutionName() {
        return receiverInstitutionName;
    }

    /**
     * @param receiverInstitutionName the receiverInstitutionName to set
     */
    public void setReceiverInstitutionName(String receiverInstitutionName) {
        this.receiverInstitutionName = receiverInstitutionName;
    }

    /**
     * @return the collectionName
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * @param collectionName the collectionName to set
     */
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    /**
     * @return the transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * @return the finalTransactionDate
     */
    public Calendar getFinalTransactionDate() {
        return finalTransactionDate;
    }

    /**
     * @param finalTransactionDate the finalTransactionDate to set
     */
    public void setFinalTransactionDate(Calendar finalTransactionDate) {
        this.finalTransactionDate = finalTransactionDate;
    }

    /**
     * @return the finalExpirationDate
     */
    public Calendar getFinalExpirationDate() {
        return finalExpirationDate;
    }

    /**
     * @param finalExpirationDate the finalExpirationDate to set
     */
    public void setFinalExpirationDate(Calendar finalExpirationDate) {
        this.finalExpirationDate = finalExpirationDate;
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
}
