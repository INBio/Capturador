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
package org.inbio.ara.persistence.identification;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.GenericEntity;

/**
 *
 * @author asanabria
 */
@Entity
@Table(name = "identifier")
public class Identifier extends GenericEntity{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected IdentifierPK identifierPK;

    @Basic(optional = false)
    @Column(name = "identifier_sequence")
    private Long identifierSequence;

	@JoinColumns({
		@JoinColumn(name = "specimen_id", referencedColumnName = "specimen_id" , updatable=false, insertable=false),
		@JoinColumn(name = "identification_sequence", referencedColumnName = "identification_sequence",  updatable=false, insertable=false),
		@JoinColumn(name = "initial_timestamp", referencedColumnName = "initial_timestamp", updatable=false, insertable=false)
	})
	@ManyToOne( cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
	private Identification identification;


    public Identifier() {
    }

    public Identifier(IdentifierPK identifierPK) {
        this.identifierPK = identifierPK;
    }

    public Identifier(IdentifierPK identifierPK, Long identifierSequence, 
            String createdBy, Calendar creationDate,
            Calendar lastModificationDate, String lastModificationBy) {
            this.identifierPK = identifierPK;
            this.identifierSequence = identifierSequence;
            this.setCreatedBy(createdBy);
            this.setCreationDate(creationDate);
            this.setLastModificationDate(lastModificationDate);
            this.setLastModificationBy(lastModificationBy);
    }

    public IdentifierPK getIdentifierPK() {
        return identifierPK;
    }

    public void setIdentifierPK(IdentifierPK identifierPK) {
        this.identifierPK = identifierPK;
    }

    public Long getIdentifierSequence() {
        return identifierSequence;
    }

    public void setIdentifierSequence(Long identifierSequence) {
        this.identifierSequence = identifierSequence;
    }

	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identifierPK != null ? identifierPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Identifier)) {
            return false;
        }
        Identifier other = (Identifier) object;
        if ((this.identifierPK == null && other.identifierPK != null) || (this.identifierPK != null && !this.identifierPK.equals(other.identifierPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.Identifier[identifierPK=" + identifierPK + "]";
    }

}
