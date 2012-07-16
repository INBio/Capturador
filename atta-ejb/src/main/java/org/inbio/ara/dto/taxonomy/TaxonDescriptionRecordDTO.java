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

import java.util.Calendar;
import org.inbio.ara.dto.GenericDTO;

/**
 *
 * @author herson
 */
public class TaxonDescriptionRecordDTO extends GenericDTO {
    private Long taxonDescriptionRecordId;
    private Long sequence;
    private String contentsText;
    private Long contentsNumeric;
    private Long taxonDescriptionElementId;

    private Calendar taxonomicalTimestamp;

    public TaxonDescriptionRecordDTO() {
    }

    public Long getContentsNumeric() {
        return contentsNumeric;
    }

    public void setContentsNumeric(Long contentsNumeric) {
        this.contentsNumeric = contentsNumeric;
    }

    public String getContentsText() {
        return contentsText;
    }

    public void setContentsText(String contentsText) {
        this.contentsText = contentsText;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public Long getTaxonDescriptionElementId() {
        return taxonDescriptionElementId;
    }

    public void setTaxonDescriptionElementId(Long taxonDescriptionElementId) {
        this.taxonDescriptionElementId = taxonDescriptionElementId;
    }

    public Long getTaxonDescriptionRecordId() {
        return taxonDescriptionRecordId;
    }

    public void setTaxonDescriptionRecordId(Long taxonDescriptionRecordId) {
        this.taxonDescriptionRecordId = taxonDescriptionRecordId;
    }

    /**
     * @return the taxonomicalTimestamp
     */
    public Calendar getTaxonomicalTimestamp() {
        return taxonomicalTimestamp;
    }

    /**
     * @param taxonomicalTimestamp the taxonomicalTimestamp to set
     */
    public void setTaxonomicalTimestamp(Calendar taxonomicalTimestamp) {
        this.taxonomicalTimestamp = taxonomicalTimestamp;
    }
    
}
