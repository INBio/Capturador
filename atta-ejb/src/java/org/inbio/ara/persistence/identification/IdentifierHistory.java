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
@Table(name = "identifier_history")
public class IdentifierHistory extends GenericEntity {
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO, generator="IdentifierHistory")
	@SequenceGenerator(name="IdentifierHistory", sequenceName="identifier_history_seq")
	@Basic(optional = false)
	@Column(name = "identifier_history_id")
	private Long identifierHistoryId;
	@Basic(optional = false)
	@Column(name = "specimen_id")
	private Long specimenId;
	@Basic(optional = false)
	@Column(name = "identification_sequence")
	private Long identificationSequence;
	@Basic(optional = false)
	@Column(name = "identifier_sequence")
	private Long identifierSequence;
	@Basic(optional = false)
	@Column(name = "initial_timestamp")
	@Temporal(TemporalType.DATE)
	private Calendar initialTimestamp;
	@Basic(optional = false)
	@Column(name = "identifier_person_id")
	private Long identifierPersonId;

	public IdentifierHistory() {
	}

	public IdentifierHistory(Long identifierHistoryId) {
		this.identifierHistoryId = identifierHistoryId;
	}

	public IdentifierHistory(Long identifierHistoryId, Long specimenId, Long identificationSequence, Long identifierSequence, Calendar initialTimestamp, Long identifierPersonId,  String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
		this.identifierHistoryId = identifierHistoryId;
		this.specimenId = specimenId;
		this.identificationSequence = identificationSequence;
		this.identifierSequence = identifierSequence;
		this.initialTimestamp = initialTimestamp;
		this.identifierPersonId = identifierPersonId;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
	}

	public Long getIdentifierHistoryId() {
		return identifierHistoryId;
	}

	public void setIdentifierHistoryId(Long identifierHistoryId) {
		this.identifierHistoryId = identifierHistoryId;
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

	public Long getIdentifierPersonId() {
		return identifierPersonId;
	}

	public void setIdentifierPersonId(Long identifierPersonId) {
		this.identifierPersonId = identifierPersonId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (identifierHistoryId != null ? identifierHistoryId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof IdentifierHistory)) {
			return false;
		}
		IdentifierHistory other = (IdentifierHistory) object;
		if ((this.identifierHistoryId == null && other.identifierHistoryId != null) || (this.identifierHistoryId != null && !this.identifierHistoryId.equals(other.identifierHistoryId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "org.inbio.ara.persistence.identification.IdentifierHistory[identifierHistoryId=" + identifierHistoryId + "]";
	}

}
