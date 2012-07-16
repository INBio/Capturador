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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author herson
 */
@Entity
@Table(name = "taxon_description_record")
public class TaxonDescriptionRecord extends LogGenericEntity {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TaxonDescriptionRecord")
	@SequenceGenerator(name="TaxonDescriptionRecord", sequenceName="taxon_description_record_seq")
    @Basic(optional = false)
    @Column(name = "taxon_description_record_id")
    private Long taxonDescriptionRecordId;

    @Basic(optional = false)
    @Column(name = "sequence")
    private Long sequence;

    @Column(name = "contents_text")
    private String contentsText;

    @Column(name = "contents_numeric")
    private Long contentsNumeric;

    @Basic(optional = false)
    @Column(name = "taxonomical_timestamp")
    @Temporal(TemporalType.DATE)
    private Calendar taxonomicalTimestamp;

    @JoinColumns({@JoinColumn(name = "taxon_id", referencedColumnName =
    "taxon_id"), @JoinColumn(name = "taxon_description_sequence",
            referencedColumnName = "taxon_description_sequence")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TaxonDescription taxonDescription;
    
//    @JoinColumn(name = "taxon_description_element_id", referencedColumnName =
//    "taxon_description_element_id")
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private TaxonDescriptionElement taxonDescriptionElementId;
    @Basic(optional = false)
    @Column(name = "taxon_description_element_id")
    private Long taxonDescriptionElementId;

    public TaxonDescriptionRecord() {
    }

    public TaxonDescriptionRecord(Long taxonDescriptionRecordId) {
        this.taxonDescriptionRecordId = taxonDescriptionRecordId;
    }

    public TaxonDescriptionRecord(Long taxonDescriptionRecordId, Long sequence,
            Calendar taxonomicalTimestamp) {
        this.taxonDescriptionRecordId = taxonDescriptionRecordId;
        this.sequence = sequence;
        this.taxonomicalTimestamp = taxonomicalTimestamp;
    }

    public Long getTaxonDescriptionRecordId() {
        return taxonDescriptionRecordId;
    }

    public void setTaxonDescriptionRecordId(Long taxonDescriptionRecordId) {
        this.taxonDescriptionRecordId = taxonDescriptionRecordId;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getContentsText() {
        return contentsText;
    }

    public void setContentsText(String contentsText) {
        this.contentsText = contentsText;
    }

    public Long getContentsNumeric() {
        return contentsNumeric;
    }

    public void setContentsNumeric(Long contentsNumeric) {
        this.contentsNumeric = contentsNumeric;
    }

    public Calendar getTaxonomicalTimestamp() {
        return taxonomicalTimestamp;
    }

    public void setTaxonomicalTimestamp(Calendar taxonomicalTimestamp) {
        this.taxonomicalTimestamp = taxonomicalTimestamp;
    }

    public TaxonDescription getTaxonDescription() {
        return taxonDescription;
    }

    public void setTaxonDescription(TaxonDescription taxonDescription) {
        this.taxonDescription = taxonDescription;
    }

    public Long getTaxonDescriptionElementId() {
        return taxonDescriptionElementId;
    }

    public void setTaxonDescriptionElementId(Long taxonDescriptionElementId) {
        this.taxonDescriptionElementId = taxonDescriptionElementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonDescriptionRecordId != null ? taxonDescriptionRecordId.
                hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionRecord)) {
            return false;
        }
        TaxonDescriptionRecord other = (TaxonDescriptionRecord) object;
        if ((this.taxonDescriptionRecordId == null && 
                other.taxonDescriptionRecordId != null) ||
                (this.taxonDescriptionRecordId != null &&
                !this.taxonDescriptionRecordId.equals(other.
                taxonDescriptionRecordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionRecord[" +
                "taxonDescriptionRecordId=" + taxonDescriptionRecordId + "]";
    }

}
