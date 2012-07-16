/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Nacional de Biodiversidad)
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

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "language")

public class Language extends LogGenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "language_id")
    private Long languageId;

    @JoinColumn(name = "concept_id", referencedColumnName = "concept_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Concept concept;

    public Language() {
    }

    public Language(Long languageId) {
        this.languageId = languageId;
    }

    public Language(Long languageId, Calendar creationDate,
            Calendar lastModificationDate, String createdBy, String lastModificationBy) {
        this.languageId = languageId;
        this.setCreationDate(creationDate);
        this.setLastModificationDate(lastModificationDate);
        this.setCreatedBy(createdBy);
        this.setLastModificationBy(lastModificationBy);
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept conceptId) {
        this.concept = conceptId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languageId != null ? languageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.languageId == null && other.languageId != null) || (this.languageId != null && !this.languageId.equals(other.languageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.Language[languageId=" + languageId + "]";
    }

}
