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


package org.inbio.ara.dto.taxonomy;

import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author esmata
 */
public class TaxonDescriptionRecordReferenceDTO extends GenericDTO {

    public TaxonDescriptionRecordReferenceDTO(){}

    private Long taxonDescriptionRecordId;
    private Long referenceId;

    /**
     * @return the taxonDescriptionRecordId
     */
    public Long getTaxonDescriptionRecordId() {
        return taxonDescriptionRecordId;
    }

    /**
     * @param taxonDescriptionRecordId the taxonDescriptionRecordId to set
     */
    public void setTaxonDescriptionRecordId(Long taxonDescriptionRecordId) {
        this.taxonDescriptionRecordId = taxonDescriptionRecordId;
    }

    /**
     * @return the referenceId
     */
    public Long getReferenceId() {
        return referenceId;
    }

    /**
     * @param referenceId the referenceId to set
     */
    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }
}
