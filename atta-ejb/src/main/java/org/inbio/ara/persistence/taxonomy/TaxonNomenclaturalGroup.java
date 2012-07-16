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

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "taxon_nomenclatural_group")
public class TaxonNomenclaturalGroup extends LogGenericEntity {

    @EmbeddedId
    protected TaxonNomenclaturalGroupPK taxonNomenclaturalGroupPK;

    @Column(name = "taxonomical_timestamp")
    @Temporal(TemporalType.DATE)
    private Calendar taxonomicalTimestamp;

    @Basic(optional = false)
    @Column(name = "sequence")
    private int sequence;

//      Both elements are in the Primary Key
//    @JoinColumn(name = "nomenclatural_group_id", referencedColumnName = "nomenclatural_group_id", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private NomenclaturalGroup nomenclaturalGroup;
//    private Long nomenclaturalGroupId;

//    @JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Taxon taxon;
//    private Long taxonId;

    public TaxonNomenclaturalGroup() {
    }

    public TaxonNomenclaturalGroup(TaxonNomenclaturalGroupPK
            taxonNomenclaturalGroupPK) {
        this.taxonNomenclaturalGroupPK = taxonNomenclaturalGroupPK;
    }

    public TaxonNomenclaturalGroup(TaxonNomenclaturalGroupPK 
            taxonNomenclaturalGroupPK, int sequence) {
        this.taxonNomenclaturalGroupPK = taxonNomenclaturalGroupPK;
        this.sequence = sequence;
    }

    public TaxonNomenclaturalGroup(Long nomenclaturalGroupId, Long taxonId) {
        this.taxonNomenclaturalGroupPK = new
                TaxonNomenclaturalGroupPK(nomenclaturalGroupId, taxonId);
    }

    public TaxonNomenclaturalGroupPK getTaxonNomenclaturalGroupPK() {
        return taxonNomenclaturalGroupPK;
    }

    public void setTaxonNomenclaturalGroupPK(TaxonNomenclaturalGroupPK
            taxonNomenclaturalGroupPK) {
        this.taxonNomenclaturalGroupPK = taxonNomenclaturalGroupPK;
    }

    public Calendar getTaxonomicalTimestamp() {
        return taxonomicalTimestamp;
    }

    public void setTaxonomicalTimestamp(Calendar taxonomicalTimestamp) {
        this.taxonomicalTimestamp = taxonomicalTimestamp;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonNomenclaturalGroupPK != null ? taxonNomenclaturalGroupPK.
                hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof TaxonNomenclaturalGroup)) {
            return false;
        }
        TaxonNomenclaturalGroup other = (TaxonNomenclaturalGroup) object;
        if ((this.taxonNomenclaturalGroupPK == null && 
            other.taxonNomenclaturalGroupPK != null) ||
                (this.taxonNomenclaturalGroupPK != null &&
                !this.taxonNomenclaturalGroupPK.equals(other.
                taxonNomenclaturalGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonNomenclaturalGroup" +
                "[taxonNomenclaturalGroupPK=" + taxonNomenclaturalGroupPK + "]";
    }

    /**
     * @return the nomenclaturalGroupId
     */
//    public Long getNomenclaturalGroupId() {
//        return nomenclaturalGroupId;
//    }

    /**
     * @param nomenclaturalGroupId the nomenclaturalGroupId to set
     */
//    public void setNomenclaturalGroupId(Long nomenclaturalGroupId) {
//        this.nomenclaturalGroupId = nomenclaturalGroupId;
//    }

    /**
     * @return the taxonId
     */
//    public Long getTaxonId() {
//        return taxonId;
//    }
//
//    /**
//     * @param taxonId the taxonId to set
//     */
//    public void setTaxonId(Long taxonId) {
//        this.taxonId = taxonId;
//    }

}
