/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio (Instituto Naciona de Biodiversidad)
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
public class TaxonDescriptionRecordReferencePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "taxon_description_record_id")
    private Long taxonDescriptionRecordId;

    @Basic(optional = false)
    @Column(name = "reference_id")
    private Long referenceId;

    public TaxonDescriptionRecordReferencePK() {
    }

    public TaxonDescriptionRecordReferencePK(Long taxonDescriptionRecordId, Long referenceId) {
        this.taxonDescriptionRecordId = taxonDescriptionRecordId;
        this.referenceId = referenceId;
    }

    public Long getTaxonDescriptionRecordId() {
        return taxonDescriptionRecordId;
    }

    public void setTaxonDescriptionRecordId(Long taxonDescriptionRecordId) {
        this.taxonDescriptionRecordId = taxonDescriptionRecordId;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonDescriptionRecordId != null ? taxonDescriptionRecordId.hashCode() : 0);
        hash += (referenceId != null ? referenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionRecordReferencePK)) {
            return false;
        }
        TaxonDescriptionRecordReferencePK other = (TaxonDescriptionRecordReferencePK) object;
        if ((this.taxonDescriptionRecordId == null && other.taxonDescriptionRecordId != null) || (this.taxonDescriptionRecordId != null && !this.taxonDescriptionRecordId.equals(other.taxonDescriptionRecordId))) {
            return false;
        }
        if ((this.referenceId == null && other.referenceId != null) || (this.referenceId != null && !this.referenceId.equals(other.referenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecordReferencePK[taxonDescriptionRecordId=" + taxonDescriptionRecordId + ", referenceId=" + referenceId + "]";
    }

}
