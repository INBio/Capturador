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

package org.inbio.ara.dto.reports;

import java.util.Date;

/**
 *
 * @author esmata
 */
public class DwcSnapshotDTO {

    public DwcSnapshotDTO(){}

    private String globaluniqueidentifier;
    private Date datelastmodified;
    private String institutioncode;
    private String collectioncode;
    private String catalognumber;
    private String scientificname;
    private String basisofrecord;
    private String informationwithheld;
    private String phylum;
    private String highertaxon;
    private String kingdom;
    private String class1;
    private String orders;
    private String family;
    private String genus;
    private String specificepithet;
    private String infraspecificepithet;
    private String infraspecificrank;
    private String authoryearofscientificname;
    private String nomenclaturalcode;
    private String identificationqualifier;
    private String collectingmethod;
    private String validdistributionflag;
    private String collector;
    private Date earliestdatecollected;
    private Date latestdatecollected;
    private Long dayofyear;
    private String highergeography;
    private String continent;
    private String waterbody;
    private String islandgroup;
    private String island;
    private String country;
    private String stateprovince;
    private String county;
    private String locality;
    private Double minimumelevationinmeters;
    private Double maximumelevationinmeters;
    private Double minimumdepthinmeters;
    private Double maximumdepthinmeters;
    private String sex;
    private String lifestage;
    private String remarks;
    private String attributes;
    private String imageurl;
    private String relatedinformation;

    /**
     * @return the globaluniqueidentifier
     */
    public String getGlobaluniqueidentifier() {
        return globaluniqueidentifier;
    }

    /**
     * @param globaluniqueidentifier the globaluniqueidentifier to set
     */
    public void setGlobaluniqueidentifier(String globaluniqueidentifier) {
        this.globaluniqueidentifier = globaluniqueidentifier;
    }

    /**
     * @return the datelastmodified
     */
    public Date getDatelastmodified() {
        return datelastmodified;
    }

    /**
     * @param datelastmodified the datelastmodified to set
     */
    public void setDatelastmodified(Date datelastmodified) {
        this.datelastmodified = datelastmodified;
    }

    /**
     * @return the institutioncode
     */
    public String getInstitutioncode() {
        return institutioncode;
    }

    /**
     * @param institutioncode the institutioncode to set
     */
    public void setInstitutioncode(String institutioncode) {
        this.institutioncode = institutioncode;
    }

    /**
     * @return the collectioncode
     */
    public String getCollectioncode() {
        return collectioncode;
    }

    /**
     * @param collectioncode the collectioncode to set
     */
    public void setCollectioncode(String collectioncode) {
        this.collectioncode = collectioncode;
    }

    /**
     * @return the catalognumber
     */
    public String getCatalognumber() {
        return catalognumber;
    }

    /**
     * @param catalognumber the catalognumber to set
     */
    public void setCatalognumber(String catalognumber) {
        this.catalognumber = catalognumber;
    }

    /**
     * @return the scientificname
     */
    public String getScientificname() {
        return scientificname;
    }

    /**
     * @param scientificname the scientificname to set
     */
    public void setScientificname(String scientificname) {
        this.scientificname = scientificname;
    }

    /**
     * @return the basisofrecord
     */
    public String getBasisofrecord() {
        return basisofrecord;
    }

    /**
     * @param basisofrecord the basisofrecord to set
     */
    public void setBasisofrecord(String basisofrecord) {
        this.basisofrecord = basisofrecord;
    }

    /**
     * @return the informationwithheld
     */
    public String getInformationwithheld() {
        return informationwithheld;
    }

    /**
     * @param informationwithheld the informationwithheld to set
     */
    public void setInformationwithheld(String informationwithheld) {
        this.informationwithheld = informationwithheld;
    }

    /**
     * @return the phylum
     */
    public String getPhylum() {
        return phylum;
    }

    /**
     * @param phylum the phylum to set
     */
    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    /**
     * @return the highertaxon
     */
    public String getHighertaxon() {
        return highertaxon;
    }

    /**
     * @param highertaxon the highertaxon to set
     */
    public void setHighertaxon(String highertaxon) {
        this.highertaxon = highertaxon;
    }

    /**
     * @return the kingdom
     */
    public String getKingdom() {
        return kingdom;
    }

    /**
     * @param kingdom the kingdom to set
     */
    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    /**
     * @return the class1
     */
    public String getClass1() {
        return class1;
    }

    /**
     * @param class1 the class1 to set
     */
    public void setClass1(String class1) {
        this.class1 = class1;
    }

    /**
     * @return the orders
     */
    public String getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(String orders) {
        this.orders = orders;
    }

    /**
     * @return the family
     */
    public String getFamily() {
        return family;
    }

    /**
     * @param family the family to set
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /**
     * @return the genus
     */
    public String getGenus() {
        return genus;
    }

    /**
     * @param genus the genus to set
     */
    public void setGenus(String genus) {
        this.genus = genus;
    }

    /**
     * @return the specificepithet
     */
    public String getSpecificepithet() {
        return specificepithet;
    }

    /**
     * @param specificepithet the specificepithet to set
     */
    public void setSpecificepithet(String specificepithet) {
        this.specificepithet = specificepithet;
    }

    /**
     * @return the infraspecificepithet
     */
    public String getInfraspecificepithet() {
        return infraspecificepithet;
    }

    /**
     * @param infraspecificepithet the infraspecificepithet to set
     */
    public void setInfraspecificepithet(String infraspecificepithet) {
        this.infraspecificepithet = infraspecificepithet;
    }

    /**
     * @return the infraspecificrank
     */
    public String getInfraspecificrank() {
        return infraspecificrank;
    }

    /**
     * @param infraspecificrank the infraspecificrank to set
     */
    public void setInfraspecificrank(String infraspecificrank) {
        this.infraspecificrank = infraspecificrank;
    }

    /**
     * @return the authoryearofscientificname
     */
    public String getAuthoryearofscientificname() {
        return authoryearofscientificname;
    }

    /**
     * @param authoryearofscientificname the authoryearofscientificname to set
     */
    public void setAuthoryearofscientificname(String authoryearofscientificname) {
        this.authoryearofscientificname = authoryearofscientificname;
    }

    /**
     * @return the nomenclaturalcode
     */
    public String getNomenclaturalcode() {
        return nomenclaturalcode;
    }

    /**
     * @param nomenclaturalcode the nomenclaturalcode to set
     */
    public void setNomenclaturalcode(String nomenclaturalcode) {
        this.nomenclaturalcode = nomenclaturalcode;
    }

    /**
     * @return the identificationqualifier
     */
    public String getIdentificationqualifier() {
        return identificationqualifier;
    }

    /**
     * @param identificationqualifier the identificationqualifier to set
     */
    public void setIdentificationqualifier(String identificationqualifier) {
        this.identificationqualifier = identificationqualifier;
    }

    /**
     * @return the collectingmethod
     */
    public String getCollectingmethod() {
        return collectingmethod;
    }

    /**
     * @param collectingmethod the collectingmethod to set
     */
    public void setCollectingmethod(String collectingmethod) {
        this.collectingmethod = collectingmethod;
    }

    /**
     * @return the validdistributionflag
     */
    public String getValiddistributionflag() {
        return validdistributionflag;
    }

    /**
     * @param validdistributionflag the validdistributionflag to set
     */
    public void setValiddistributionflag(String validdistributionflag) {
        this.validdistributionflag = validdistributionflag;
    }

    /**
     * @return the collector
     */
    public String getCollector() {
        return collector;
    }

    /**
     * @param collector the collector to set
     */
    public void setCollector(String collector) {
        this.collector = collector;
    }

    /**
     * @return the earliestdatecollected
     */
    public Date getEarliestdatecollected() {
        return earliestdatecollected;
    }

    /**
     * @param earliestdatecollected the earliestdatecollected to set
     */
    public void setEarliestdatecollected(Date earliestdatecollected) {
        this.earliestdatecollected = earliestdatecollected;
    }

    /**
     * @return the latestdatecollected
     */
    public Date getLatestdatecollected() {
        return latestdatecollected;
    }

    /**
     * @param latestdatecollected the latestdatecollected to set
     */
    public void setLatestdatecollected(Date latestdatecollected) {
        this.latestdatecollected = latestdatecollected;
    }

    /**
     * @return the dayofyear
     */
    public Long getDayofyear() {
        return dayofyear;
    }

    /**
     * @param dayofyear the dayofyear to set
     */
    public void setDayofyear(Long dayofyear) {
        this.dayofyear = dayofyear;
    }

    /**
     * @return the highergeography
     */
    public String getHighergeography() {
        return highergeography;
    }

    /**
     * @param highergeography the highergeography to set
     */
    public void setHighergeography(String highergeography) {
        this.highergeography = highergeography;
    }

    /**
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * @param continent the continent to set
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * @return the waterbody
     */
    public String getWaterbody() {
        return waterbody;
    }

    /**
     * @param waterbody the waterbody to set
     */
    public void setWaterbody(String waterbody) {
        this.waterbody = waterbody;
    }

    /**
     * @return the islandgroup
     */
    public String getIslandgroup() {
        return islandgroup;
    }

    /**
     * @param islandgroup the islandgroup to set
     */
    public void setIslandgroup(String islandgroup) {
        this.islandgroup = islandgroup;
    }

    /**
     * @return the island
     */
    public String getIsland() {
        return island;
    }

    /**
     * @param island the island to set
     */
    public void setIsland(String island) {
        this.island = island;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the stateprovince
     */
    public String getStateprovince() {
        return stateprovince;
    }

    /**
     * @param stateprovince the stateprovince to set
     */
    public void setStateprovince(String stateprovince) {
        this.stateprovince = stateprovince;
    }

    /**
     * @return the county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county the county to set
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * @return the locality
     */
    public String getLocality() {
        return locality;
    }

    /**
     * @param locality the locality to set
     */
    public void setLocality(String locality) {
        this.locality = locality;
    }

    /**
     * @return the minimumelevationinmeters
     */
    public Double getMinimumelevationinmeters() {
        return minimumelevationinmeters;
    }

    /**
     * @param minimumelevationinmeters the minimumelevationinmeters to set
     */
    public void setMinimumelevationinmeters(Double minimumelevationinmeters) {
        this.minimumelevationinmeters = minimumelevationinmeters;
    }

    /**
     * @return the maximumelevationinmeters
     */
    public Double getMaximumelevationinmeters() {
        return maximumelevationinmeters;
    }

    /**
     * @param maximumelevationinmeters the maximumelevationinmeters to set
     */
    public void setMaximumelevationinmeters(Double maximumelevationinmeters) {
        this.maximumelevationinmeters = maximumelevationinmeters;
    }

    /**
     * @return the minimumdepthinmeters
     */
    public Double getMinimumdepthinmeters() {
        return minimumdepthinmeters;
    }

    /**
     * @param minimumdepthinmeters the minimumdepthinmeters to set
     */
    public void setMinimumdepthinmeters(Double minimumdepthinmeters) {
        this.minimumdepthinmeters = minimumdepthinmeters;
    }

    /**
     * @return the maximumdepthinmeters
     */
    public Double getMaximumdepthinmeters() {
        return maximumdepthinmeters;
    }

    /**
     * @param maximumdepthinmeters the maximumdepthinmeters to set
     */
    public void setMaximumdepthinmeters(Double maximumdepthinmeters) {
        this.maximumdepthinmeters = maximumdepthinmeters;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the lifestage
     */
    public String getLifestage() {
        return lifestage;
    }

    /**
     * @param lifestage the lifestage to set
     */
    public void setLifestage(String lifestage) {
        this.lifestage = lifestage;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return the attributes
     */
    public String getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the imageurl
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * @param imageurl the imageurl to set
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * @return the relatedinformation
     */
    public String getRelatedinformation() {
        return relatedinformation;
    }

    /**
     * @param relatedinformation the relatedinformation to set
     */
    public void setRelatedinformation(String relatedinformation) {
        this.relatedinformation = relatedinformation;
    }
}
