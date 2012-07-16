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
    FHYLUM(new Long(2)),
    SUBFHYLUM(new Long(3)),
    CLASS(new Long(4)),
    SUBCLASS(new Long(5)),
    ORDER(new Long(6)),
    SUBORDEN(new Long(7)),
    SUPERFAMILY(new Long(8)),
    FAMILY(new Long(9)),
    SUBFAMILY(new Long(10)),
    TRIBE(new Long(11)),
    SUBTRIBE(new Long(12)),
    GENUS(new Long(13)),
    SUBGENUS(new Long(14)),
    SECTION(new Long(15)),
    SUBSECTION(new Long(16)),
    STIRPS(new Long(18)),
    SPECIES(new Long(19)),
    SUBSPECIES(new Long(20)),
    VARIETY(new Long(21)),
    FORM(new Long(22)),
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
