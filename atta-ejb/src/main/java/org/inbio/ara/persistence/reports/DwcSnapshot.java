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

package org.inbio.ara.persistence.reports;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "dwc_snapshot")

public class DwcSnapshot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "globaluniqueidentifier")
    private String globaluniqueidentifier;

    @Column(name = "datelastmodified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastmodified;
    @Column(name = "institutioncode")
    private String institutioncode;
    @Column(name = "collectioncode")
    private String collectioncode;
    @Basic(optional = false)
    @Column(name = "catalognumber")
    private String catalognumber;
    @Column(name = "scientificname")
    private String scientificname;
    @Column(name = "basisofrecord")
    private String basisofrecord;
    @Column(name = "informationwithheld")
    private String informationwithheld;
    @Column(name = "phylum")
    private String phylum;
    @Column(name = "highertaxon")
    private String highertaxon;
    @Column(name = "kingdom")
    private String kingdom;
    @Column(name = "class")
    private String class1;
    @Column(name = "orders")
    private String orders;
    @Column(name = "family")
    private String family;
    @Column(name = "genus")
    private String genus;
    @Column(name = "specificepithet")
    private String specificepithet;
    @Column(name = "infraspecificepithet")
    private String infraspecificepithet;
    @Column(name = "infraspecificrank")
    private String infraspecificrank;
    @Column(name = "authoryearofscientificname")
    private String authoryearofscientificname;
    @Column(name = "nomenclaturalcode")
    private String nomenclaturalcode;
    @Column(name = "identificationqualifier")
    private String identificationqualifier;
    @Column(name = "collectingmethod")
    private String collectingmethod;
    @Column(name = "validdistributionflag")
    private String validdistributionflag;
    @Column(name = "collector")
    private String collector;
    @Column(name = "earliestdatecollected")
    @Temporal(TemporalType.TIMESTAMP)
    private Date earliestdatecollected;
    @Column(name = "latestdatecollected")
    @Temporal(TemporalType.TIMESTAMP)
    private Date latestdatecollected;
    @Column(name = "dayofyear")
    private Long dayofyear;
    @Column(name = "highergeography")
    private String highergeography;
    @Column(name = "continent")
    private String continent;
    @Column(name = "waterbody")
    private String waterbody;
    @Column(name = "islandgroup")
    private String islandgroup;
    @Column(name = "island")
    private String island;
    @Column(name = "country")
    private String country;
    @Column(name = "stateprovince")
    private String stateprovince;
    @Column(name = "county")
    private String county;
    @Column(name = "locality")
    private String locality;
    @Column(name = "minimumelevationinmeters")
    private Double minimumelevationinmeters;
    @Column(name = "maximumelevationinmeters")
    private Double maximumelevationinmeters;
    @Column(name = "minimumdepthinmeters")
    private Double minimumdepthinmeters;
    @Column(name = "maximumdepthinmeters")
    private Double maximumdepthinmeters;
    @Column(name = "sex")
    private String sex;
    @Column(name = "lifestage")
    private String lifestage;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "attributes")
    private String attributes;
    @Column(name = "imageurl")
    private String imageurl;
    @Column(name = "relatedinformation")
    private String relatedinformation;

    public DwcSnapshot() {
    }

    public DwcSnapshot(String globaluniqueidentifier) {
        this.globaluniqueidentifier = globaluniqueidentifier;
    }

    public DwcSnapshot(String globaluniqueidentifier, String catalognumber) {
        this.globaluniqueidentifier = globaluniqueidentifier;
        this.catalognumber = catalognumber;
    }

    public String getGlobaluniqueidentifier() {
        return globaluniqueidentifier;
    }

    public void setGlobaluniqueidentifier(String globaluniqueidentifier) {
        this.globaluniqueidentifier = globaluniqueidentifier;
    }

    public Date getDatelastmodified() {
        return datelastmodified;
    }

    public void setDatelastmodified(Date datelastmodified) {
        this.datelastmodified = datelastmodified;
    }

    public String getInstitutioncode() {
        return institutioncode;
    }

    public void setInstitutioncode(String institutioncode) {
        this.institutioncode = institutioncode;
    }

    public String getCollectioncode() {
        return collectioncode;
    }

    public void setCollectioncode(String collectioncode) {
        this.collectioncode = collectioncode;
    }

    public String getCatalognumber() {
        return catalognumber;
    }

    public void setCatalognumber(String catalognumber) {
        this.catalognumber = catalognumber;
    }

    public String getScientificname() {
        return scientificname;
    }

    public void setScientificname(String scientificname) {
        this.scientificname = scientificname;
    }

    public String getBasisofrecord() {
        return basisofrecord;
    }

    public void setBasisofrecord(String basisofrecord) {
        this.basisofrecord = basisofrecord;
    }

    public String getInformationwithheld() {
        return informationwithheld;
    }

    public void setInformationwithheld(String informationwithheld) {
        this.informationwithheld = informationwithheld;
    }

    public String getPhylum() {
        return phylum;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    public String getHighertaxon() {
        return highertaxon;
    }

    public void setHighertaxon(String highertaxon) {
        this.highertaxon = highertaxon;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecificepithet() {
        return specificepithet;
    }

    public void setSpecificepithet(String specificepithet) {
        this.specificepithet = specificepithet;
    }

    public String getInfraspecificepithet() {
        return infraspecificepithet;
    }

    public void setInfraspecificepithet(String infraspecificepithet) {
        this.infraspecificepithet = infraspecificepithet;
    }

    public String getInfraspecificrank() {
        return infraspecificrank;
    }

    public void setInfraspecificrank(String infraspecificrank) {
        this.infraspecificrank = infraspecificrank;
    }

    public String getAuthoryearofscientificname() {
        return authoryearofscientificname;
    }

    public void setAuthoryearofscientificname(String authoryearofscientificname) {
        this.authoryearofscientificname = authoryearofscientificname;
    }

    public String getNomenclaturalcode() {
        return nomenclaturalcode;
    }

    public void setNomenclaturalcode(String nomenclaturalcode) {
        this.nomenclaturalcode = nomenclaturalcode;
    }

    public String getIdentificationqualifier() {
        return identificationqualifier;
    }

    public void setIdentificationqualifier(String identificationqualifier) {
        this.identificationqualifier = identificationqualifier;
    }

    public String getCollectingmethod() {
        return collectingmethod;
    }

    public void setCollectingmethod(String collectingmethod) {
        this.collectingmethod = collectingmethod;
    }

    public String getValiddistributionflag() {
        return validdistributionflag;
    }

    public void setValiddistributionflag(String validdistributionflag) {
        this.validdistributionflag = validdistributionflag;
    }

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public Date getEarliestdatecollected() {
        return earliestdatecollected;
    }

    public void setEarliestdatecollected(Date earliestdatecollected) {
        this.earliestdatecollected = earliestdatecollected;
    }

    public Date getLatestdatecollected() {
        return latestdatecollected;
    }

    public void setLatestdatecollected(Date latestdatecollected) {
        this.latestdatecollected = latestdatecollected;
    }

    public Long getDayofyear() {
        return dayofyear;
    }

    public void setDayofyear(Long dayofyear) {
        this.dayofyear = dayofyear;
    }

    public String getHighergeography() {
        return highergeography;
    }

    public void setHighergeography(String highergeography) {
        this.highergeography = highergeography;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getWaterbody() {
        return waterbody;
    }

    public void setWaterbody(String waterbody) {
        this.waterbody = waterbody;
    }

    public String getIslandgroup() {
        return islandgroup;
    }

    public void setIslandgroup(String islandgroup) {
        this.islandgroup = islandgroup;
    }

    public String getIsland() {
        return island;
    }

    public void setIsland(String island) {
        this.island = island;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateprovince() {
        return stateprovince;
    }

    public void setStateprovince(String stateprovince) {
        this.stateprovince = stateprovince;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Double getMinimumelevationinmeters() {
        return minimumelevationinmeters;
    }

    public void setMinimumelevationinmeters(Double minimumelevationinmeters) {
        this.minimumelevationinmeters = minimumelevationinmeters;
    }

    public Double getMaximumelevationinmeters() {
        return maximumelevationinmeters;
    }

    public void setMaximumelevationinmeters(Double maximumelevationinmeters) {
        this.maximumelevationinmeters = maximumelevationinmeters;
    }

    public Double getMinimumdepthinmeters() {
        return minimumdepthinmeters;
    }

    public void setMinimumdepthinmeters(Double minimumdepthinmeters) {
        this.minimumdepthinmeters = minimumdepthinmeters;
    }

    public Double getMaximumdepthinmeters() {
        return maximumdepthinmeters;
    }

    public void setMaximumdepthinmeters(Double maximumdepthinmeters) {
        this.maximumdepthinmeters = maximumdepthinmeters;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLifestage() {
        return lifestage;
    }

    public void setLifestage(String lifestage) {
        this.lifestage = lifestage;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getRelatedinformation() {
        return relatedinformation;
    }

    public void setRelatedinformation(String relatedinformation) {
        this.relatedinformation = relatedinformation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (globaluniqueidentifier != null ? globaluniqueidentifier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DwcSnapshot)) {
            return false;
        }
        DwcSnapshot other = (DwcSnapshot) object;
        if ((this.globaluniqueidentifier == null && other.globaluniqueidentifier != null) || (this.globaluniqueidentifier != null && !this.globaluniqueidentifier.equals(other.globaluniqueidentifier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.reports.DwcSnapshot[globaluniqueidentifier=" + globaluniqueidentifier + "]";
    }

}
