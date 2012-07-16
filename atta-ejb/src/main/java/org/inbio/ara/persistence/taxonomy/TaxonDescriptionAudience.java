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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "taxon_description_audience")

public class TaxonDescriptionAudience extends LogGenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TaxonDescriptionAudiencePK taxonDescriptionAudiencePK;

    public TaxonDescriptionAudience() {
    }

    public TaxonDescriptionAudience(TaxonDescriptionAudiencePK taxonDescriptionAudiencePK) {
        this.taxonDescriptionAudiencePK = taxonDescriptionAudiencePK;
    }

    public TaxonDescriptionAudience(TaxonDescriptionAudiencePK taxonDescriptionAudiencePK, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.taxonDescriptionAudiencePK = taxonDescriptionAudiencePK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public TaxonDescriptionAudience(Long taxonId, Long taxonDescriptionSequence, Long audienceId) {
        this.taxonDescriptionAudiencePK = new TaxonDescriptionAudiencePK(taxonId, taxonDescriptionSequence, audienceId);
    }

    public TaxonDescriptionAudiencePK getTaxonDescriptionAudiencePK() {
        return taxonDescriptionAudiencePK;
    }

    public void setTaxonDescriptionAudiencePK(TaxonDescriptionAudiencePK taxonDescriptionAudiencePK) {
        this.taxonDescriptionAudiencePK = taxonDescriptionAudiencePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonDescriptionAudiencePK != null ? taxonDescriptionAudiencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionAudience)) {
            return false;
        }
        TaxonDescriptionAudience other = (TaxonDescriptionAudience) object;
        if ((this.taxonDescriptionAudiencePK == null && other.taxonDescriptionAudiencePK != null) || (this.taxonDescriptionAudiencePK != null && !this.taxonDescriptionAudiencePK.equals(other.taxonDescriptionAudiencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionAudience[taxonDescriptionAudiencePK=" + taxonDescriptionAudiencePK + "]";
    }

}
