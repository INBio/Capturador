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
public class TaxonDescriptionPersonProfileDTO extends GenericDTO{

    private Long taxonId;
    private Long taxonDescriptionSequence;
    private Long personId;
    private Long profileId;
    private Long sequence;

    public TaxonDescriptionPersonProfileDTO(){}

    /**
     * @return the taxonId
     */
    public Long getTaxonId() {
        return taxonId;
    }

    /**
     * @param taxonId the taxonId to set
     */
    public void setTaxonId(Long taxonId) {
        this.taxonId = taxonId;
    }

    /**
     * @return the taxonDescriptionSequence
     */
    public Long getTaxonDescriptionSequence() {
        return taxonDescriptionSequence;
    }

    /**
     * @param taxonDescriptionSequence the taxonDescriptionSequence to set
     */
    public void setTaxonDescriptionSequence(Long taxonDescriptionSequence) {
        this.taxonDescriptionSequence = taxonDescriptionSequence;
    }

    /**
     * @return the personId
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * @param personId the personId to set
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * @return the profileId
     */
    public Long getProfileId() {
        return profileId;
    }

    /**
     * @param profileId the profileId to set
     */
    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    /**
     * @return the sequence
     */
    public Long getSequence() {
        return sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

}
