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
import java.util.Calendar;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 * @author esmata
 */
@Entity
@Table(name = "taxon_description_record_reference")

public class TaxonDescriptionRecordReference
        extends LogGenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TaxonDescriptionRecordReferencePK taxonDescriptionRecordReferencePK;

    @JoinColumn(name = "reference_id", referencedColumnName = "reference_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Reference reference;

    @JoinColumn(name = "taxon_description_record_id", referencedColumnName = "taxon_description_record_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TaxonDescriptionRecord taxonDescriptionRecord;

    public TaxonDescriptionRecordReference() {
    }

    public TaxonDescriptionRecordReference(TaxonDescriptionRecordReferencePK taxonDescriptionRecordReferencePK) {
        this.taxonDescriptionRecordReferencePK = taxonDescriptionRecordReferencePK;
    }

    public TaxonDescriptionRecordReference(TaxonDescriptionRecordReferencePK taxonDescriptionRecordReferencePK, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.taxonDescriptionRecordReferencePK = taxonDescriptionRecordReferencePK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public TaxonDescriptionRecordReference(Long taxonDescriptionRecordId, Long referenceId) {
        this.taxonDescriptionRecordReferencePK =
                new TaxonDescriptionRecordReferencePK(taxonDescriptionRecordId, referenceId);
    }

    public TaxonDescriptionRecordReferencePK getTaxonDescriptionRecordReferencePK() {
        return taxonDescriptionRecordReferencePK;
    }

    public void setTaxonDescriptionRecordReferencePK
            (TaxonDescriptionRecordReferencePK taxonDescriptionRecordReferencePK) {
        this.taxonDescriptionRecordReferencePK = taxonDescriptionRecordReferencePK;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public TaxonDescriptionRecord getTaxonDescriptionRecord() {
        return taxonDescriptionRecord;
    }

    public void setTaxonDescriptionRecord(TaxonDescriptionRecord taxonDescriptionRecord) {
        this.taxonDescriptionRecord = taxonDescriptionRecord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonDescriptionRecordReferencePK != null ? taxonDescriptionRecordReferencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionRecordReference)) {
            return false;
        }
        TaxonDescriptionRecordReference other = (TaxonDescriptionRecordReference) object;
        if ((this.taxonDescriptionRecordReferencePK == null && other.taxonDescriptionRecordReferencePK != null) || (this.taxonDescriptionRecordReferencePK != null && !this.taxonDescriptionRecordReferencePK.equals(other.taxonDescriptionRecordReferencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecordReference[taxonDescriptionRecordReferencePK=" + taxonDescriptionRecordReferencePK + "]";
    }

}
