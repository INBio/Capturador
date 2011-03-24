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

package org.inbio.ara.persistence.person;

/**
 * Enum para manejar los identificadores de profiles
 * @author esmata
 */
public enum ProfileEntity {

    TAXONOMIC_AUTHOR(new Long(2)),
    RECOLECTOR(new Long(3)),
    IDENTIFIER_PROFILE(new Long(4)),
    PREPARER(new Long(5)),
    LITERARY_AUTHOR(new Long(6)),
    TAXON_OBSERVER(new Long(7)),
    TAXONOMIC_INDICATORS_ESTIMATOR(new Long(8)),
    SPECIMENS_DESCRIPTOR(new Long(9)),
    GATHERING_RESPONSIBLE_PROFILE(new Long(10)),
    SPECIMENS_SCORER(new Long(11)),
    IMAGES_PROCESSOR(new Long(12)),
    OBSERVATIONS_VALIDATOR(new Long(13)),
    PUBLICATIONS_EDITOR(new Long(14)),
    PUBLICATIONS_COMPILER(new Long(15)),
    PUBLICATIONS_TRADUCTOR(new Long(16)),
    SPECIMENS_OBSERVATION_RESPONSIBLE(new Long(17)),
    IDENTIFICATION_VALIDATOR(new Long(18)),
    CULTURE_RESPONSIBLE(new Long(19)),
    CERTIFIER(new Long(20)),
    IMAGE_AUTHOR(new Long(21)),
    SPECIES_RECORD_AUTHOR(new Long(22)),
    MORPHOLOGICAL_DESCRIPTOR(new Long(23)),
    DONOR_PERSON_PROFILE(new Long(24)),
    RESPONSABLE_PERSON_GERMPLASM_PROFILE(new Long(25))
    ;
    
   
    private Long id;

    private ProfileEntity(Long id){
        this.id = id;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
