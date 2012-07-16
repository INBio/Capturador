/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.transaction;

import java.util.Collection;
import org.inbio.ara.dto.GenericDTO;
import org.inbio.ara.persistence.transaction.TransactedSpecimen;

/**
 *
 * @author echinchilla
 */
public class TransactedSpecimenStatusDTO extends GenericDTO {
    private Long transactedSpecimenStatusId;
    private String name;
    private String description;
    private Collection<TransactedSpecimen> transactedSpecimenCollection;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the transactedSpecimenCollection
     */
    public Collection<TransactedSpecimen> getTransactedSpecimenCollection() {
        return transactedSpecimenCollection;
    }

    /**
     * @param transactedSpecimenCollection the transactedSpecimenCollection to set
     */
    public void setTransactedSpecimenCollection(Collection<TransactedSpecimen> transactedSpecimenCollection) {
        this.transactedSpecimenCollection = transactedSpecimenCollection;
    }
}
