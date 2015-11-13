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

    TAXONOMIC_AUTHOR(new Long(10)),
    RECOLECTOR(new Long(13)),
    IDENTIFIER_PROFILE(new Long(17)),
    PREPARER(new Long(105)),
    LITERARY_AUTHOR(new Long(106)),
    TAXON_OBSERVER(new Long(107)),
    TAXONOMIC_INDICATORS_ESTIMATOR(new Long(108)),
    SPECIMENS_DESCRIPTOR(new Long(109)),
    GATHERING_RESPONSIBLE_PROFILE(new Long(9)),
    SPECIMENS_SCORER(new Long(1011)),
    IMAGES_PROCESSOR(new Long(1012)),
    OBSERVATIONS_VALIDATOR(new Long(1013)),
    PUBLICATIONS_EDITOR(new Long(1014)),
    PUBLICATIONS_COMPILER(new Long(1015)),
    PUBLICATIONS_TRADUCTOR(new Long(1016)),
    SPECIMENS_OBSERVATION_RESPONSIBLE(new Long(1017)),
    IDENTIFICATION_VALIDATOR(new Long(16)),
    CULTURE_RESPONSIBLE(new Long(1019)),
    CERTIFIER(new Long(18)),
    IMAGE_AUTHOR(new Long(1021)),
    SPECIES_RECORD_AUTHOR(new Long(14)),
    MORPHOLOGICAL_DESCRIPTOR(new Long(15)),
    DONOR_PERSON_PROFILE(new Long(20)),
    RESPONSABLE_PERSON_GERMPLASM_PROFILE(new Long(21))
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
