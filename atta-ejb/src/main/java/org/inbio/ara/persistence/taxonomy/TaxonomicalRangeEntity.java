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
    ROOT(new Long(0), ""),
    KINGDOM(new Long(1), "kingdomTaxonId"),
    FHYLUM(new Long(2), "phylumDivisionTaxonId"),
    SUBFHYLUM(new Long(3), "subphylumSubdivisionTaxonId"),
    CLASS(new Long(4),"classTaxonId"),
    SUBCLASS(new Long(5),"subclassTaxonId"),
    ORDER(new Long(6),"orderTaxonId"),
    SUBORDEN(new Long(7),"suborderTaxonId"),
    SUPERFAMILY(new Long(8),"superfamilyTaxonId"),
    FAMILY(new Long(9),"familyTaxonId"),
    SUBFAMILY(new Long(10),"subfamilyTaxonId"),
    TRIBE(new Long(11),"tribeTaxonId"),
    SUBTRIBE(new Long(12),"subtribeTaxonId"),
    GENUS(new Long(13),"genusTaxonId"),
    SUBGENUS(new Long(14),"subgenusTaxonId"),
    SECTION(new Long(15),"sectionTaxonId"),
    SUBSECTION(new Long(16),"subsectionTaxonId"),
    STIRPS(new Long(17),"stirpsTaxonId"),
    SPECIES(new Long(18),"speciesTaxonId"),
    SUBSPECIES(new Long(19),"subspeciesTaxonId"),
    VARIETY(new Long(20),"varietyTaxonId"),
    FORM(new Long(22),""),
    DOMAIN(new Long(23),"dominiumTaxonId");

    private Long id;
    private String column;

    private TaxonomicalRangeEntity(Long id, String column){
        this.id = id;
        this.column = column;
    }

    public static TaxonomicalRangeEntity getById(Long id) {

        TaxonomicalRangeEntity[] all = TaxonomicalRangeEntity.values();
        for (TaxonomicalRangeEntity tre : all) {
            System.out.println(tre.getId()+" = "+id);
            if (tre.getId().equals(id)) {
                System.out.println(tre.getColumn());
                return tre;
            }
        }
        return null;

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

    /**
     * @return the column
     */
    public String getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(String column) {
        this.column = column;
    }
}
