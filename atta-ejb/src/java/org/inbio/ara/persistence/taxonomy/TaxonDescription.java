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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "taxon_description")

public class TaxonDescription extends LogGenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TaxonDescriptionPK taxonDescriptionPK;
    
    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "institution_id")
    private Long institutionId;

    @JoinColumn(name = "taxon_id", referencedColumnName = "taxon_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Taxon taxon;

    @Column(name = "taxon_description_stage_id")
    private Long taxonDescriptionStageId;

    public TaxonDescription() {
    }

    public TaxonDescription(TaxonDescriptionPK taxonDescriptionPK) {
        this.taxonDescriptionPK = taxonDescriptionPK;
    }

    public TaxonDescription(TaxonDescriptionPK taxonDescriptionPK, String createdBy, Calendar creationDate, String lastModificationBy) {
        this.taxonDescriptionPK = taxonDescriptionPK;
        this.setCreatedBy(createdBy);
        this.setCreationDate(creationDate);
        this.setLastModificationBy(lastModificationBy);
    }

    public TaxonDescription(Long taxonId, Long taxonDescriptionSequence) {
        this.taxonDescriptionPK = new TaxonDescriptionPK(taxonId, taxonDescriptionSequence);
    }

    public TaxonDescriptionPK getTaxonDescriptionPK() {
        return taxonDescriptionPK;
    }

    public void setTaxonDescriptionPK(TaxonDescriptionPK taxonDescriptionPK) {
        this.taxonDescriptionPK = taxonDescriptionPK;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public Taxon getTaxon() {
        return taxon;
    }

    public void setTaxon(Taxon taxon) {
        this.taxon = taxon;
    }

    public Long getTaxonDescriptionStageId() {
        return taxonDescriptionStageId;
    }

    public void setTaxonDescriptionStageId(Long taxonDescriptionStageId) {
        this.taxonDescriptionStageId = taxonDescriptionStageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonDescriptionPK != null ? taxonDescriptionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescription)) {
            return false;
        }
        TaxonDescription other = (TaxonDescription) object;
        if ((this.taxonDescriptionPK == null && other.taxonDescriptionPK != null) || (this.taxonDescriptionPK != null && !this.taxonDescriptionPK.equals(other.taxonDescriptionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescription[taxonDescriptionPK=" + taxonDescriptionPK + "]";
    }

    /**
     * @return the institutionId
     */
    public Long getInstitutionId() {
        return institutionId;
    }

    /**
     * @param institutionId the institutionId to set
     */
    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

}
