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

package org.inbio.ara.util;


/**
 * Enum para manejar los identificadores y los nombres de la lista de los tipos de etiquetas
 * @author pcorrales
 */
public enum TaxonomicalRange {


    DOMINIUM(new String("Dominio"),new String("t.dominiumTaxonId")),
    INFRAKINGDOM(new String("Infrareino"),new String("t.infrakingdomTaxonId")),
    KINGDOM(new String("Reino"),new String("t.kingdomTaxonId")),
    SUBKINGDOM(new String("Subreino"),new String("t.subkingdomTaxonId")),
    PHYLUMDIVISION(new String("Filo/Division"),new String("t.phylumDivisionTaxonId")),
    SUBPHYLUMDIVISION(new String("SubFilo/Division"),new String("t.subphylumSubdivisionTaxonId")),
    CLASS(new String("Clase"),new String("t.classTaxonId")),
    SUPERCLASS(new String("Superclase"),new String("t.superclassTaxonId")),
    ORDER(new String("Orden"),new String("t.orderTaxonId")),
    SUPERORDER(new String("Superorden"),new String("t.superorderTaxonId")),
    SUPERFAMILY(new String("Superfamilia"),new String("t.superfamilyTaxonId")),
    FAMILY(new String("Familia"),new String("t.familyTaxonId")),
    SUBFAMILY(new String("Subfamilia"),new String("t.subfamilyTaxonId")),
    TRIBE(new String("Tribu"),new String("t.tribeTaxonId")),
    SUBTRIBE(new String("Subtribu"),new String("t.subtribeTaxonId")),
    GENUS(new String("Genero"),new String("t.genusTaxonId")),
    SUBGENUS(new String("Subgenero"),new String("t.subgenusTaxonId")),
    SECTION(new String("Seccion"),new String("t.sectionTaxonId")),
    SUBSECTION(new String("Subseccion"),new String("t.subsectionTaxonId")),
    STIRPS(new String("Estirpe"),new String("t.stirpsTaxonId")),
    SPECIES(new String("Especie"),new String("t.speciesTaxonId")),
    SUBSPECIES(new String("Subespecies"),new String("t.subspeciesTaxonId")),
    VARIETY(new String("Variedad"),new String("t.varietyTaxonId")),
    TAXON(new String("Forma"),new String("t.currentName"));
    
    
    private String key;
    private String taxomicalRange;



   private TaxonomicalRange(String taxomicalRange,String key)
   {

        this.setKey(key);
        this.setTaxomicalRange(taxomicalRange);
   }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }


    /**
     * @return the taxomicalRange
     */
    public String getTaxomicalRange() {
        return taxomicalRange;
    }

    /**
     * @param taxomicalRange the taxomicalRange to set
     */
    public void setTaxomicalRange(String taxomicalRange) {
        this.taxomicalRange = taxomicalRange;
    }


   
}
