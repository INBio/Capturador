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
public class IdentifierHistoryDTO  implements Serializable {

	private Long identifierHistoryId;
	private Long specimenId;
	private Long identificationSequence;
	private Long identifierSequence;
	private Calendar initialTimestamp;
	private Long identifierPersonId;

	public IdentifierHistoryDTO() {
	}

	public IdentifierHistoryDTO(Long identifierHistoryId, Long specimenId, Long identificationSequence, Long identifierSequence, Calendar initialTimestamp, Long identifierPersonId) {
		this.identifierHistoryId = identifierHistoryId;
		this.specimenId = specimenId;
		this.identificationSequence = identificationSequence;
		this.identifierSequence = identifierSequence;
		this.initialTimestamp = initialTimestamp;
		this.identifierPersonId = identifierPersonId;
	}

	public Long getIdentificationSequence() {
		return identificationSequence;
	}

	public void setIdentificationSequence(Long identificationSequence) {
		this.identificationSequence = identificationSequence;
	}

	public Long getIdentifierHistoryId() {
		return identifierHistoryId;
	}

	public void setIdentifierHistoryId(Long identifierHistoryId) {
		this.identifierHistoryId = identifierHistoryId;
	}

	public Long getIdentifierPersonId() {
		return identifierPersonId;
	}

	public void setIdentifierPersonId(Long identifierPersonId) {
		this.identifierPersonId = identifierPersonId;
	}

	public Long getIdentifierSequence() {
		return identifierSequence;
	}

	public void setIdentifierSequence(Long identifierSequence) {
		this.identifierSequence = identifierSequence;
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
}
