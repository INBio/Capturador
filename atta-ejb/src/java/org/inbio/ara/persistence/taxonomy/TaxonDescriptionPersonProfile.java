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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "taxon_description_person_profile")

public class TaxonDescriptionPersonProfile extends LogGenericEntity 
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TaxonDescriptionPersonProfilePK taxonDescriptionPersonProfilePK;

    @Basic(optional = false)
    @Column(name = "sequence")
    private Long sequence;

    public TaxonDescriptionPersonProfile() {
    }

    public TaxonDescriptionPersonProfile(TaxonDescriptionPersonProfilePK taxonDescriptionPersonProfilePK) {
        this.taxonDescriptionPersonProfilePK = taxonDescriptionPersonProfilePK;
    }

    public TaxonDescriptionPersonProfile(TaxonDescriptionPersonProfilePK taxonDescriptionPersonProfilePK, Long sequence, String createdBy, Calendar creationDate, String lastModificationBy, Calendar lastModificationDate) {
        this.taxonDescriptionPersonProfilePK = taxonDescriptionPersonProfilePK;
        this.sequence = sequence;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
        this.setLastModificationDate(lastModificationDate);
    }

    public TaxonDescriptionPersonProfile(Long taxonId, Long taxonDescriptionSequence, Long personId, Long profileId) {
        this.taxonDescriptionPersonProfilePK = new TaxonDescriptionPersonProfilePK(taxonId, taxonDescriptionSequence, personId, profileId);
    }

    public TaxonDescriptionPersonProfilePK getTaxonDescriptionPersonProfilePK() {
        return taxonDescriptionPersonProfilePK;
    }

    public void setTaxonDescriptionPersonProfilePK(TaxonDescriptionPersonProfilePK taxonDescriptionPersonProfilePK) {
        this.taxonDescriptionPersonProfilePK = taxonDescriptionPersonProfilePK;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonDescriptionPersonProfilePK != null ? taxonDescriptionPersonProfilePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionPersonProfile)) {
            return false;
        }
        TaxonDescriptionPersonProfile other = (TaxonDescriptionPersonProfile) object;
        if ((this.taxonDescriptionPersonProfilePK == null && other.taxonDescriptionPersonProfilePK != null) || (this.taxonDescriptionPersonProfilePK != null && !this.taxonDescriptionPersonProfilePK.equals(other.taxonDescriptionPersonProfilePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionPersonProfile[taxonDescriptionPersonProfilePK=" + taxonDescriptionPersonProfilePK + "]";
    }

}
