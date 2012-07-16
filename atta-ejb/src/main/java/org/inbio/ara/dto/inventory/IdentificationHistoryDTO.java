/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.dto.inventory;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author asanabria
 */
public class IdentificationHistoryDTO  implements Serializable{

	private Long identificationHistoryId;

	private Long specimenId;
	private Long identificationSequence;
	private Calendar identificationHistoryDate;
	private Calendar initialTimestamp;
	private Calendar finalTimestamp;
	private Long identificationTypeId;
	private Long taxonId;
	private Long valuerPersonId;
	private String dataEntryError;

	public IdentificationHistoryDTO() {
	}

	public IdentificationHistoryDTO(Long identificationHistoryId, Long specimenId, Long identificationSequence, Calendar identificationHistoryDate, Calendar initialTimestamp, Calendar finalTimestamp, Long identificationTypeId, Long taxonId, Long valuerPersonId, String dataEntryError) {
		this.identificationHistoryId = identificationHistoryId;
		this.specimenId = specimenId;
		this.identificationSequence = identificationSequence;
		this.identificationHistoryDate = identificationHistoryDate;
		this.initialTimestamp = initialTimestamp;
		this.finalTimestamp = finalTimestamp;
		this.identificationTypeId = identificationTypeId;
		this.taxonId = taxonId;
		this.valuerPersonId = valuerPersonId;
		this.dataEntryError = dataEntryError;
	}



	public String getDataEntryError() {
		return dataEntryError;
	}

	public void setDataEntryError(String dataEntryError) {
		this.dataEntryError = dataEntryError;
	}

	public Calendar getFinalTimestamp() {
		return finalTimestamp;
	}

	public void setFinalTimestamp(Calendar finalTimestamp) {
		this.finalTimestamp = finalTimestamp;
	}

	public Calendar getIdentificationHistoryDate() {
		return identificationHistoryDate;
	}

	public void setIdentificationHistoryDate(Calendar identificationHistoryDate) {
		this.identificationHistoryDate = identificationHistoryDate;
	}

	public Long getIdentificationHistoryId() {
		return identificationHistoryId;
	}

	public void setIdentificationHistoryId(Long identificationHistoryId) {
		this.identificationHistoryId = identificationHistoryId;
	}

	public Long getIdentificationSequence() {
		return identificationSequence;
	}

	public void setIdentificationSequence(Long identificationSequence) {
		this.identificationSequence = identificationSequence;
	}

	public Long getIdentificationTypeId() {
		return identificationTypeId;
	}

	public void setIdentificationTypeId(Long identificationTypeId) {
		this.identificationTypeId = identificationTypeId;
	}

	public Calendar getInitialTimestamp() {
		return initialTimestamp;
	}

	public void setInitialTimestamp(Calendar initialTimestamp) {
		this.initialTimestamp = initialTimestamp;
	}

	public Long getSpecimenId() {
		return specimenId;
	}

	public void setSpecimenId(Long specimenId) {
		this.specimenId = specimenId;
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
}
