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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author esmata
 */
@Embeddable
public class TaxonDescriptionInstitutionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "taxon_id")
    private Long taxonId;

    @Basic(optional = false)
    @Column(name = "taxon_description_sequence")
    private Long taxonDescriptionSequence;

    @Basic(optional = false)
    @Column(name = "institution_id")
    private Long institutionId;

    public TaxonDescriptionInstitutionPK() {
    }

    public TaxonDescriptionInstitutionPK(Long taxonId, Long taxonDescriptionSequence, Long institutionId) {
        this.taxonId = taxonId;
        this.taxonDescriptionSequence = taxonDescriptionSequence;
        this.institutionId = institutionId;
    }

    public Long getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    public Long getTaxonDescriptionSequence() {
        return taxonDescriptionSequence;
    }

    public void setTaxonDescriptionSequence(Long taxonDescriptionSequence) {
        this.taxonDescriptionSequence = taxonDescriptionSequence;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonId != null ? taxonId.hashCode() : 0);
        hash += (taxonDescriptionSequence != null ? taxonDescriptionSequence.hashCode() : 0);
        hash += (institutionId != null ? institutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionInstitutionPK)) {
            return false;
        }
        TaxonDescriptionInstitutionPK other = (TaxonDescriptionInstitutionPK) object;
        if ((this.taxonId == null && other.taxonId != null) || (this.taxonId != null && !this.taxonId.equals(other.taxonId))) {
            return false;
        }
        if ((this.taxonDescriptionSequence == null && other.taxonDescriptionSequence != null) || (this.taxonDescriptionSequence != null && !this.taxonDescriptionSequence.equals(other.taxonDescriptionSequence))) {
            return false;
        }
        if ((this.institutionId == null && other.institutionId != null) || (this.institutionId != null && !this.institutionId.equals(other.institutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionInstitutionPK[taxonId=" + taxonId + ", taxonDescriptionSequence=" + taxonDescriptionSequence + ", institutionId=" + institutionId + "]";
    }

}
