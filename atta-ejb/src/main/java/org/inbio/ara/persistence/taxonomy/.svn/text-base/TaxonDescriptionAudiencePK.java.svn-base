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
public class TaxonDescriptionAudiencePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "taxon_id")
    private Long taxonId;

    @Basic(optional = false)
    @Column(name = "taxon_description_sequence")
    private Long taxonDescriptionSequence;

    @Basic(optional = false)
    @Column(name = "audience_id")
    private Long audienceId;

    public TaxonDescriptionAudiencePK() {
    }

    public TaxonDescriptionAudiencePK(Long taxonId, Long taxonDescriptionSequence, Long audienceId) {
        this.taxonId = taxonId;
        this.taxonDescriptionSequence = taxonDescriptionSequence;
        this.audienceId = audienceId;
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

    public Long getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(Long audienceId) {
        this.audienceId = audienceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonId != null ? taxonId.hashCode() : 0);
        hash += (taxonDescriptionSequence != null ? taxonDescriptionSequence.hashCode() : 0);
        hash += (audienceId != null ? audienceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionAudiencePK)) {
            return false;
        }
        TaxonDescriptionAudiencePK other = (TaxonDescriptionAudiencePK) object;
        if ((this.taxonId == null && other.taxonId != null) || (this.taxonId != null && !this.taxonId.equals(other.taxonId))) {
            return false;
        }
        if ((this.taxonDescriptionSequence == null && other.taxonDescriptionSequence != null) || (this.taxonDescriptionSequence != null && !this.taxonDescriptionSequence.equals(other.taxonDescriptionSequence))) {
            return false;
        }
        if ((this.audienceId == null && other.audienceId != null) || (this.audienceId != null && !this.audienceId.equals(other.audienceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionAudiencePK[taxonId=" + taxonId + ", taxonDescriptionSequence=" + taxonDescriptionSequence + ", audienceId=" + audienceId + "]";
    }

}
