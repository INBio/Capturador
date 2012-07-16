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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.inbio.ara.persistence.LogGenericEntity;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "taxon_description_stage")

public class TaxonDescriptionStage extends LogGenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "taxon_description_stage_id")
    private Long taxonDescriptionStageId;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxonDescriptionStageId", fetch = FetchType.LAZY)
    private List<TaxonDescription> taxonDescriptionCollection;

    public TaxonDescriptionStage() {
    }

    public TaxonDescriptionStage(Long taxonDescriptionStageId) {
        this.taxonDescriptionStageId = taxonDescriptionStageId;
    }

    public TaxonDescriptionStage(Long taxonDescriptionStageId, String name) {
        this.taxonDescriptionStageId = taxonDescriptionStageId;
        this.name = name;
    }

    public Long getTaxonDescriptionStageId() {
        return taxonDescriptionStageId;
    }

    public void setTaxonDescriptionStageId(Long taxonDescriptionStageId) {
        this.taxonDescriptionStageId = taxonDescriptionStageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaxonDescription> getTaxonDescriptionCollection() {
        return taxonDescriptionCollection;
    }

    public void setTaxonDescriptionCollection(List<TaxonDescription> taxonDescriptionCollection) {
        this.taxonDescriptionCollection = taxonDescriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxonDescriptionStageId != null ? taxonDescriptionStageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxonDescriptionStage)) {
            return false;
        }
        TaxonDescriptionStage other = (TaxonDescriptionStage) object;
        if ((this.taxonDescriptionStageId == null && other.taxonDescriptionStageId != null) || (this.taxonDescriptionStageId != null && !this.taxonDescriptionStageId.equals(other.taxonDescriptionStageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.taxonomy.TaxonDescriptionStage[taxonDescriptionStageId=" + taxonDescriptionStageId + "]";
    }

}
