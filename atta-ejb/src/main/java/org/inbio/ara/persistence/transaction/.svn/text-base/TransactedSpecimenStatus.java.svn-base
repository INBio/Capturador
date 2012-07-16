/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.transaction;

import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.inbio.ara.dto.inventory.SelectionListEntity;
import org.inbio.ara.persistence.LogGenericEntity;
import org.inbio.ara.persistence.SelectionListGenericEntity;

/**
 *
 * @author echinchilla
 */
@Entity
@Table(name = "transacted_specimen_status")
public class TransactedSpecimenStatus extends SelectionListGenericEntity {
    private static final long serialVersionUID = 1L;
    @Id
        @GeneratedValue(strategy=GenerationType.AUTO, generator="TransactedSpecimenStatus")
	@SequenceGenerator(name="TransactedSpecimenStatus", sequenceName="transacted_specimen_status_seq")
    @Basic(optional = false)
    @Column(name = "transacted_specimen_status_id")
    private Long transactedSpecimenStatusId;
    /*@Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactedSpecimenStatusId", fetch = FetchType.LAZY)
    private Collection<TransactedSpecimen> transactedSpecimenCollection;*/

    public TransactedSpecimenStatus() {
    }

    public TransactedSpecimenStatus(Long transactedSpecimenStatusId) {
        this.transactedSpecimenStatusId = transactedSpecimenStatusId;
    }

    public TransactedSpecimenStatus(Long transactedSpecimenStatusId, String name,
            String createdBy, Calendar creationDate, String lastModificationBy,
            Calendar lastModificationDate) {
        this.setId(transactedSpecimenStatusId);
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public Long getTransactedSpecimenStatusId() {
        return transactedSpecimenStatusId;
    }

    public void setTransactedSpecimenStatusId(Long transactedSpecimenStatusId) {
        this.transactedSpecimenStatusId = transactedSpecimenStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactedSpecimenStatusId != null ? transactedSpecimenStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactedSpecimenStatus)) {
            return false;
        }
        TransactedSpecimenStatus other = (TransactedSpecimenStatus) object;
        if ((this.transactedSpecimenStatusId == null && other.transactedSpecimenStatusId != null) || (this.transactedSpecimenStatusId != null && !this.transactedSpecimenStatusId.equals(other.transactedSpecimenStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.transaction.TransactedSpecimenStatus[transactedSpecimenStatusId=" + transactedSpecimenStatusId + "]";
    }

    @Override
    public Long getId() {
        return transactedSpecimenStatusId;
    }

    @Override
    public void setId(Long id) {
        this.transactedSpecimenStatusId = id;
    }

    @Override
    public SelectionListEntity getSelectionListEntity() {
        return SelectionListEntity.TRANSACTED_SPECIMEN_STATUS;
    }

}
