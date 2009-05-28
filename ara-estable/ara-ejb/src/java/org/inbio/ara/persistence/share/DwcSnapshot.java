/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.share;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author esmata
 */
@Entity
@Table(name = "dwc_snapshot")
@NamedQueries({@NamedQuery(name = "DwcSnapshot.findAll", query = "SELECT d FROM DwcSnapshot d"), @NamedQuery(name = "DwcSnapshot.findByGlobaluniqueidentifier", query = "SELECT d FROM DwcSnapshot d WHERE d.globaluniqueidentifier = :globaluniqueidentifier"), @NamedQuery(name = "DwcSnapshot.findByDatelastmodified", query = "SELECT d FROM DwcSnapshot d WHERE d.datelastmodified = :datelastmodified"), @NamedQuery(name = "DwcSnapshot.findByInstitutioncode", query = "SELECT d FROM DwcSnapshot d WHERE d.institutioncode = :institutioncode"), @NamedQuery(name = "DwcSnapshot.findByCollectioncode", query = "SELECT d FROM DwcSnapshot d WHERE d.collectioncode = :collectioncode"), @NamedQuery(name = "DwcSnapshot.findByCatalognumber", query = "SELECT d FROM DwcSnapshot d WHERE d.catalognumber = :catalognumber"), @NamedQuery(name = "DwcSnapshot.findByScientificname", query = "SELECT d FROM DwcSnapshot d WHERE d.scientificname = :scientificname"), @NamedQuery(name = "DwcSnapshot.findByBasisofrecord", query = "SELECT d FROM DwcSnapshot d WHERE d.basisofrecord = :basisofrecord"), @NamedQuery(name = "DwcSnapshot.findByInformationwithheld", query = "SELECT d FROM DwcSnapshot d WHERE d.informationwithheld = :informationwithheld"), @NamedQuery(name = "DwcSnapshot.findByPhylum", query = "SELECT d FROM DwcSnapshot d WHERE d.phylum = :phylum"), @NamedQuery(name = "DwcSnapshot.findByHighertaxon", query = "SELECT d FROM DwcSnapshot d WHERE d.highertaxon = :highertaxon"), @NamedQuery(name = "DwcSnapshot.findByKingdom", query = "SELECT d FROM DwcSnapshot d WHERE d.kingdom = :kingdom"), @NamedQuery(name = "DwcSnapshot.findByClass1", query = "SELECT d FROM DwcSnapshot d WHERE d.class1 = :class1"), @NamedQuery(name = "DwcSnapshot.findByOrders", query = "SELECT d FROM DwcSnapshot d WHERE d.orders = :orders"), @NamedQuery(name = "DwcSnapshot.findByFamily", query = "SELECT d FROM DwcSnapshot d WHERE d.family = :family"), @NamedQuery(name = "DwcSnapshot.findByGenus", query = "SELECT d FROM DwcSnapshot d WHERE d.genus = :genus"), @NamedQuery(name = "DwcSnapshot.findBySpecificepithet", query = "SELECT d FROM DwcSnapshot d WHERE d.specificepithet = :specificepithet"), @NamedQuery(name = "DwcSnapshot.findByInfraspecificepithet", query = "SELECT d FROM DwcSnapshot d WHERE d.infraspecificepithet = :infraspecificepithet"), @NamedQuery(name = "DwcSnapshot.findByInfraspecificrank", query = "SELECT d FROM DwcSnapshot d WHERE d.infraspecificrank = :infraspecificrank"), @NamedQuery(name = "DwcSnapshot.findByAuthoryearofscientificname", query = "SELECT d FROM DwcSnapshot d WHERE d.authoryearofscientificname = :authoryearofscientificname"), @NamedQuery(name = "DwcSnapshot.findByNomenclaturalcode", query = "SELECT d FROM DwcSnapshot d WHERE d.nomenclaturalcode = :nomenclaturalcode"), @NamedQuery(name = "DwcSnapshot.findByIdentificationqualifier", query = "SELECT d FROM DwcSnapshot d WHERE d.identificationqualifier = :identificationqualifier"), @NamedQuery(name = "DwcSnapshot.findByCollectingmethod", query = "SELECT d FROM DwcSnapshot d WHERE d.collectingmethod = :collectingmethod"), @NamedQuery(name = "DwcSnapshot.findByValiddistributionflag", query = "SELECT d FROM DwcSnapshot d WHERE d.validdistributionflag = :validdistributionflag"), @NamedQuery(name = "DwcSnapshot.findByCollector", query = "SELECT d FROM DwcSnapshot d WHERE d.collector = :collector"), @NamedQuery(name = "DwcSnapshot.findByEarliestdatecollected", query = "SELECT d FROM DwcSnapshot d WHERE d.earliestdatecollected = :earliestdatecollected"), @NamedQuery(name = "DwcSnapshot.findByLatestdatecollected", query = "SELECT d FROM DwcSnapshot d WHERE d.latestdatecollected = :latestdatecollected"), @NamedQuery(name = "DwcSnapshot.findByDayofyear", query = "SELECT d FROM DwcSnapshot d WHERE d.dayofyear = :dayofyear"), @NamedQuery(name = "DwcSnapshot.findByHighergeography", query = "SELECT d FROM DwcSnapshot d WHERE d.highergeography = :highergeography"), @NamedQuery(name = "DwcSnapshot.findByContinent", query = "SELECT d FROM DwcSnapshot d WHERE d.continent = :continent"), @NamedQuery(name = "DwcSnapshot.findByWaterbody", query = "SELECT d FROM DwcSnapshot d WHERE d.waterbody = :waterbody"), @NamedQuery(name = "DwcSnapshot.findByIslandgroup", query = "SELECT d FROM DwcSnapshot d WHERE d.islandgroup = :islandgroup"), @NamedQuery(name = "DwcSnapshot.findByIsland", query = "SELECT d FROM DwcSnapshot d WHERE d.island = :island"), @NamedQuery(name = "DwcSnapshot.findByCountry", query = "SELECT d FROM DwcSnapshot d WHERE d.country = :country"), @NamedQuery(name = "DwcSnapshot.findByStateprovince", query = "SELECT d FROM DwcSnapshot d WHERE d.stateprovince = :stateprovince"), @NamedQuery(name = "DwcSnapshot.findByCounty", query = "SELECT d FROM DwcSnapshot d WHERE d.county = :county"), @NamedQuery(name = "DwcSnapshot.findByLocality", query = "SELECT d FROM DwcSnapshot d WHERE d.locality = :locality"), @NamedQuery(name = "DwcSnapshot.findByMinimumelevationinmeters", query = "SELECT d FROM DwcSnapshot d WHERE d.minimumelevationinmeters = :minimumelevationinmeters"), @NamedQuery(name = "DwcSnapshot.findByMaximumelevationinmeters", query = "SELECT d FROM DwcSnapshot d WHERE d.maximumelevationinmeters = :maximumelevationinmeters"), @NamedQuery(name = "DwcSnapshot.findByMinimumdepthinmeters", query = "SELECT d FROM DwcSnapshot d WHERE d.minimumdepthinmeters = :minimumdepthinmeters"), @NamedQuery(name = "DwcSnapshot.findByMaximumdepthinmeters", query = "SELECT d FROM DwcSnapshot d WHERE d.maximumdepthinmeters = :maximumdepthinmeters"), @NamedQuery(name = "DwcSnapshot.findBySex", query = "SELECT d FROM DwcSnapshot d WHERE d.sex = :sex"), @NamedQuery(name = "DwcSnapshot.findByLifestage", query = "SELECT d FROM DwcSnapshot d WHERE d.lifestage = :lifestage"), @NamedQuery(name = "DwcSnapshot.findByRemarks", query = "SELECT d FROM DwcSnapshot d WHERE d.remarks = :remarks"), @NamedQuery(name = "DwcSnapshot.findByAttributes", query = "SELECT d FROM DwcSnapshot d WHERE d.attributes = :attributes"), @NamedQuery(name = "DwcSnapshot.findByImageurl", query = "SELECT d FROM DwcSnapshot d WHERE d.imageurl = :imageurl"), @NamedQuery(name = "DwcSnapshot.findByRelatedinformation", query = "SELECT d FROM DwcSnapshot d WHERE d.relatedinformation = :relatedinformation")})
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
    private BigInteger dayofyear;
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

    public BigInteger getDayofyear() {
        return dayofyear;
    }

    public void setDayofyear(BigInteger dayofyear) {
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
        return "org.inbio.ara.persistence.share.DwcSnapshot[globaluniqueidentifier=" + globaluniqueidentifier + "]";
    }

}
