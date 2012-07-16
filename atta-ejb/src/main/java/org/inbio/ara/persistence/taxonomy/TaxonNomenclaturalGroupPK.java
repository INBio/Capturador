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

package org.inbio.ara.persistence.taxonomy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author herson
 */
@Embeddable
public class TaxonNomenclaturalGroupPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "nomenclatural_group_id")
    private Long nomenclaturalGroupId;

    @Basic(optional = false)
    @Column(name = "taxon_id")
    private Long taxonId;

    public TaxonNomenclaturalGroupPK() {
    }

    public TaxonNomenclaturalGroupPK(Long nomenclaturalGroupId, Long taxonId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
        this.taxonId = taxonId;
    }

    public Long getNomenclaturalGroupId() {
        return nomenclaturalGroupId;
    }

    public void setNomenclaturalGroupId(Long nomenclaturalGroupId) {
        this.nomenclaturalGroupId = nomenclaturalGroupId;
    }

    public Long getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomenclaturalGroupId != null ? nomenclaturalGroupId.hashCode()
                : 0);
        hash += (taxonId != null ? taxonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof TaxonNomenclaturalGroupPK)) {
            return false;
        }
        TaxonNomenclaturalGroupPK other = (TaxonNomenclaturalGroupPK) object;
        if ((this.nomenclaturalGroupId == null && other.nomenclaturalGroupId != 
                null) || (this.nomenclaturalGroupId != null &&
                !nomenclaturalGroupId.equals(other.nomenclaturalGroupId))) {
            return false;
        }
        if ((this.taxonId == null && other.taxonId != null) || (this.taxonId !=
                null && !this.taxonId.equals(other.taxonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonNomenclaturalGroupPK" +
                "[nomenclaturalGroupId=" + nomenclaturalGroupId + ", taxonId=" +
                taxonId + "]";
    }

}
