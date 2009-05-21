/* Ara - capture species and specimen data
 *
 * Copyright (C) 2009  INBio ( Instituto Naciona de Biodiversidad )
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

package org.inbio.ara.dto;

/**
 * Esta clase esta hecha para sustitur las tablas de la base de datos para el
 * manejo de modulos en el sistema. Espero que luega pueda sustituirse por un
 * XML, pero por ahora esta bien así...
 * 
 * @author jgutierrez
 */
public enum SystemModuleEntity {

    TAXONOMY(3, "menuSubsystemTaxonomy"),
    INVENTORY(1,"menuSubsystemInventory"),
    GEOGRAPHICAL_INFORMATION(2,"menuSubsystemGeographicalInformation"),
    ADMINISTRATION(5,"menuSubsystemAdministration"),
    SECURITY(7,"menuSubsystemSecurity"),
    REPORTS(4, "menuSubsystemReports");

    private int id;
    private String nameI18NKey;


    /**
     * 
     * @param id
     * @param nameI18NKey
     */
    private SystemModuleEntity(int id, String nameI18NKey) {
        this.id = id;
        this.nameI18NKey = nameI18NKey;
    }



    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nameI18NKey
     */
    public String getNameI18NKey() {
        return nameI18NKey;
    }

    /**
     * @param nameI18NKey the nameI18NKey to set
     */
    public void setNameI18NKey(String nameI18NKey) {
        this.nameI18NKey = nameI18NKey;
    }

}
