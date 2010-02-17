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

/**
 * Enum para manejar los rangos taxonómicos obligatorios
 * @author esmata
 */
public enum TaxonomicalRangeEntity {
    ROOT(new Long(0)),
    KINGDOM(new Long(1)),
    FHYLUN(new Long(2)),
    CLASS(new Long(4)),
    ORDER(new Long(6)),
    FAMILY(new Long(9)),
    GENUS(new Long(13)),
    SPECIES(new Long(18)),
    DOMAIN(new Long(23));

    private Long id;

    private TaxonomicalRangeEntity(Long id){
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
