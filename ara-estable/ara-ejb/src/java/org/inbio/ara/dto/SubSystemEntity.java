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
 * manejo de modulos en el sub sistema. Espero que luega pueda sustituirse por un
 * XML, pero por ahora esta bien así...
 * 
 * @author jgutierrez
 */
public enum SubSystemEntity {

    //TAXONOMY MODULE
    NOMENCLATURAL_GROUPS(7, 3, "menuModuleNomenclaturalGroups","listNomenclaturalGroup"),
    SPECIES(8, 3, "menuModuleSpecies","listSpecies"),
    TAXA(6, 3, "menuModuleTaxa","listTaxon"),
    
    //INVENTORY MODULE
    GATHERING_OBSERVATIONS(1, 1, "menuModuleGatheringsObservations", "listGathering"),
    IDENTIFICATIONS(3, 1,"menuModuleIdentifications","listIdentification"),
    SPECIMENS(2, 1, "menuModuleSpecimens","listSpecimen"),
    
    //GEOGRAPHICAL INFORMATION MODULE
    LOCATIONS(5, 2, "menuModuleLocations","listSite"),
    
    //ADMINISTRATION MODULE
    COLLECTIONS(21, 5, "menuModuleAdminCollections", "adminCollections"),
    AUDIENCES(19, 5, "menuModuleAudiences", "listAudience"),
    CHANGE_PASSWORD(17, 5, "menuModuleChangePassword", "changePassword"),
    INSTITUTIONS(14, 5, "menuModuleInstitutions", "listInstitution"),
    PEOPLE(13, 5, "menuModulePeople", "listPerson"),
    PROFILES(16, 5, "menuModuleProfiles", "listProfile"),
    REFERENCES(18, 5, "menuModuleReferences", "listReference"),
    SELECTION_LIST(20, 5, "menuModuleSelectionLists", "listSelectionList"),
    STAGES(15, 5, "menuModuleStages", "listStage"),
    
    //SECURITY
    GROUP(10, 7, "menuModuleGroups", "listGroup"),
    USER(9, 7, "menuModuleUsers", "listUser"),

    //REPORTS
    SPECIMENS_REPORT(22, 4, "menuModuleReportsSpecimen", "reportSpecimen");

    private int id;
    private int systemModuleId;
    private String nameI18NKey;
    private String navigationRule;


    /**
     * 
     * @param id
     * @param nameI18NKey
     * @param navigationRule
     */
    private SubSystemEntity(int id, int systemModuleId, String nameI18NKey, String navigationRule) {
        this.id = id;
        this.systemModuleId = systemModuleId;
        this.nameI18NKey = nameI18NKey;
        this.navigationRule = navigationRule;
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

    /**
     * @return the navigationRule
     */
    public String getNavigationRule() {
        return navigationRule;
    }

    /**
     * @param navigationRule the navigationRule to set
     */
    public void setNavigationRule(String navigationRule) {
        this.navigationRule = navigationRule;
    }

    /**
     * @return the systemModuleId
     */
    public int getSystemModuleId() {
        return systemModuleId;
    }

    /**
     * @param systemModuleId the systemModuleId to set
     */
    public void setSystemModuleId(int systemModuleId) {
        this.systemModuleId = systemModuleId;
    }

}
