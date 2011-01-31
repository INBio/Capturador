/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.identification;

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
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author asanabria
 */
@Entity
@Table(name = "identification_history")
public class IdentificationHistory extends GenericEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IdentificationHistory")
	@SequenceGenerator(name="IdentificationHistory", sequenceName="identification_history_seq")
	@Basic(optional = false)
	@Column(name = "identification_history_id")
	private Long identificationHistoryId;
	
	@Column(name = "specimen_id")
	private Long specimenId;
	@Column(name = "identification_sequence")
	private Long identificationSequence;
	@Column(name = "identification_history_date")
	@Temporal(TemporalType.DATE)
	private Calendar identificationHistoryDate;
	@Column(name = "initial_timestamp")
	@Temporal(TemporalType.DATE)
	private Calendar initialTimestamp;
	@Column(name = "final_timestamp")
	@Temporal(TemporalType.DATE)
	private Calendar finalTimestamp;
	@Column(name = "identification_type_id")
	private Long identificationTypeId;
	@Column(name = "taxon_id")
	private Long taxonId;
	@Column(name = "valuer_person_id")
	private Long valuerPersonId;
	@Column(name = "data_entry_error")
	private String dataEntryError;


	public IdentificationHistory() {
	}

	public IdentificationHistory(String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
	}

	public Long getIdentificationHistoryId() {
		return identificationHistoryId;
	}

	public void setIdentificationHistoryId(Long identificationHistoryId) {
		this.identificationHistoryId = identificationHistoryId;
	}

	public Long getSpecimenId() {
		return specimenId;
	}

	public void setSpecimenId(Long specimenId) {
		this.specimenId = specimenId;
	}

	public Long getIdentificationSequence() {
		return identificationSequence;
	}

	public void setIdentificationSequence(Long identificationSequence) {
		this.identificationSequence = identificationSequence;
	}

	public Calendar getIdentificationHistoryDate() {
		return identificationHistoryDate;
	}

	public void setIdentificationHistoryDate(Calendar identificationHistoryDate) {
		this.identificationHistoryDate = identificationHistoryDate;
	}

	public Calendar getInitialTimestamp() {
		return initialTimestamp;
	}

	public void setInitialTimestamp(Calendar initialTimestamp) {
		this.initialTimestamp = initialTimestamp;
	}

	public Calendar getFinalTimestamp() {
		return finalTimestamp;
	}

	public void setFinalTimestamp(Calendar finalTimestamp) {
		this.finalTimestamp = finalTimestamp;
	}

	public Long getIdentificationTypeId() {
		return identificationTypeId;
	}

	public void setIdentificationTypeId(Long identificationTypeId) {
		this.identificationTypeId = identificationTypeId;
	}

	public Long getTaxonId() {
		return taxonId;
	}

	public void setTaxonId(Long taxonId) {
		this.taxonId = taxonId;
	}

	public Long getValuerPersonId() {
		return valuerPersonId;
	}

	public void setValuerPersonId(Long valuerPersonId) {
		this.valuerPersonId = valuerPersonId;
	}

	public String getDataEntryError() {
		return dataEntryError;
	}

	public void setDataEntryError(String dataEntryError) {
		this.dataEntryError = dataEntryError;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (identificationHistoryId != null ? identificationHistoryId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof IdentificationHistory)) {
			return false;
		}
		IdentificationHistory other = (IdentificationHistory) object;
		if ((this.identificationHistoryId == null && other.identificationHistoryId != null) || (this.identificationHistoryId != null && !this.identificationHistoryId.equals(other.identificationHistoryId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.inbio.ara.persistence.identification.IdentificationHistory[identificationHistoryId=" + identificationHistoryId + "]";
	}

}
