/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.persistence.specimen;

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
 * @author herson
 */
@Entity
@Table(name = "darwin_core_1_4")
@NamedQueries({@NamedQuery(name = "DarwinCore14.findAll", query = "SELECT d FROM DarwinCore14 d"), @NamedQuery(name = "DarwinCore14.findByGlobaluniqueidentifier", query = "SELECT d FROM DarwinCore14 d WHERE d.globaluniqueidentifier = :globaluniqueidentifier"), @NamedQuery(name = "DarwinCore14.findByDatelastmodified", query = "SELECT d FROM DarwinCore14 d WHERE d.datelastmodified = :datelastmodified"), @NamedQuery(name = "DarwinCore14.findByInstitutioncode", query = "SELECT d FROM DarwinCore14 d WHERE d.institutioncode = :institutioncode"), @NamedQuery(name = "DarwinCore14.findByCollectioncode", query = "SELECT d FROM DarwinCore14 d WHERE d.collectioncode = :collectioncode"), @NamedQuery(name = "DarwinCore14.findByCatalognumber", query = "SELECT d FROM DarwinCore14 d WHERE d.catalognumber = :catalognumber"), @NamedQuery(name = "DarwinCore14.findByCatalognumbernumeric", query = "SELECT d FROM DarwinCore14 d WHERE d.catalognumbernumeric = :catalognumbernumeric"), @NamedQuery(name = "DarwinCore14.findByScientificname", query = "SELECT d FROM DarwinCore14 d WHERE d.scientificname = :scientificname"), @NamedQuery(name = "DarwinCore14.findByBasisofrecord", query = "SELECT d FROM DarwinCore14 d WHERE d.basisofrecord = :basisofrecord"), @NamedQuery(name = "DarwinCore14.findByInformationwithheld", query = "SELECT d FROM DarwinCore14 d WHERE d.informationwithheld = :informationwithheld"), @NamedQuery(name = "DarwinCore14.findByKingdomid", query = "SELECT d FROM DarwinCore14 d WHERE d.kingdomid = :kingdomid"), @NamedQuery(name = "DarwinCore14.findByPhylumId", query = "SELECT d FROM DarwinCore14 d WHERE d.phylumId = :phylumId"), @NamedQuery(name = "DarwinCore14.findByClassId", query = "SELECT d FROM DarwinCore14 d WHERE d.classId = :classId"), @NamedQuery(name = "DarwinCore14.findByOrdersId", query = "SELECT d FROM DarwinCore14 d WHERE d.ordersId = :ordersId"), @NamedQuery(name = "DarwinCore14.findByFamilyId", query = "SELECT d FROM DarwinCore14 d WHERE d.familyId = :familyId"), @NamedQuery(name = "DarwinCore14.findByGenusId", query = "SELECT d FROM DarwinCore14 d WHERE d.genusId = :genusId"), @NamedQuery(name = "DarwinCore14.findBySpecificepithetId", query = "SELECT d FROM DarwinCore14 d WHERE d.specificepithetId = :specificepithetId"), @NamedQuery(name = "DarwinCore14.findByInfraspecificepithetId", query = "SELECT d FROM DarwinCore14 d WHERE d.infraspecificepithetId = :infraspecificepithetId"), @NamedQuery(name = "DarwinCore14.findByHighertaxon", query = "SELECT d FROM DarwinCore14 d WHERE d.highertaxon = :highertaxon"), @NamedQuery(name = "DarwinCore14.findByKingdom", query = "SELECT d FROM DarwinCore14 d WHERE d.kingdom = :kingdom"), @NamedQuery(name = "DarwinCore14.findByPhylum", query = "SELECT d FROM DarwinCore14 d WHERE d.phylum = :phylum"), @NamedQuery(name = "DarwinCore14.findByClass1", query = "SELECT d FROM DarwinCore14 d WHERE d.class1 = :class1"), @NamedQuery(name = "DarwinCore14.findByOrders", query = "SELECT d FROM DarwinCore14 d WHERE d.orders = :orders"), @NamedQuery(name = "DarwinCore14.findByFamily", query = "SELECT d FROM DarwinCore14 d WHERE d.family = :family"), @NamedQuery(name = "DarwinCore14.findByGenus", query = "SELECT d FROM DarwinCore14 d WHERE d.genus = :genus"), @NamedQuery(name = "DarwinCore14.findBySpecificepithet", query = "SELECT d FROM DarwinCore14 d WHERE d.specificepithet = :specificepithet"), @NamedQuery(name = "DarwinCore14.findByInfraspecificepithet", query = "SELECT d FROM DarwinCore14 d WHERE d.infraspecificepithet = :infraspecificepithet"), @NamedQuery(name = "DarwinCore14.findByInfraspecificrank", query = "SELECT d FROM DarwinCore14 d WHERE d.infraspecificrank = :infraspecificrank"), @NamedQuery(name = "DarwinCore14.findByAuthoryearofscientificname", query = "SELECT d FROM DarwinCore14 d WHERE d.authoryearofscientificname = :authoryearofscientificname"), @NamedQuery(name = "DarwinCore14.findByNomenclaturalcode", query = "SELECT d FROM DarwinCore14 d WHERE d.nomenclaturalcode = :nomenclaturalcode"), @NamedQuery(name = "DarwinCore14.findByIdentificationqualifier", query = "SELECT d FROM DarwinCore14 d WHERE d.identificationqualifier = :identificationqualifier"), @NamedQuery(name = "DarwinCore14.findByIdentifiedby", query = "SELECT d FROM DarwinCore14 d WHERE d.identifiedby = :identifiedby"), @NamedQuery(name = "DarwinCore14.findByDateidentified", query = "SELECT d FROM DarwinCore14 d WHERE d.dateidentified = :dateidentified"), @NamedQuery(name = "DarwinCore14.findByTypestatus", query = "SELECT d FROM DarwinCore14 d WHERE d.typestatus = :typestatus"), @NamedQuery(name = "DarwinCore14.findByCollectingmethod", query = "SELECT d FROM DarwinCore14 d WHERE d.collectingmethod = :collectingmethod"), @NamedQuery(name = "DarwinCore14.findByValiddistributionflag", query = "SELECT d FROM DarwinCore14 d WHERE d.validdistributionflag = :validdistributionflag"), @NamedQuery(name = "DarwinCore14.findByCollectornumber", query = "SELECT d FROM DarwinCore14 d WHERE d.collectornumber = :collectornumber"), @NamedQuery(name = "DarwinCore14.findByFieldnumber", query = "SELECT d FROM DarwinCore14 d WHERE d.fieldnumber = :fieldnumber"), @NamedQuery(name = "DarwinCore14.findByCollector", query = "SELECT d FROM DarwinCore14 d WHERE d.collector = :collector"), @NamedQuery(name = "DarwinCore14.findByEarliestdatecollected", query = "SELECT d FROM DarwinCore14 d WHERE d.earliestdatecollected = :earliestdatecollected"), @NamedQuery(name = "DarwinCore14.findByLatestdatecollected", query = "SELECT d FROM DarwinCore14 d WHERE d.latestdatecollected = :latestdatecollected"), @NamedQuery(name = "DarwinCore14.findByVerbatimcollectingdate", query = "SELECT d FROM DarwinCore14 d WHERE d.verbatimcollectingdate = :verbatimcollectingdate"), @NamedQuery(name = "DarwinCore14.findByDayofyear", query = "SELECT d FROM DarwinCore14 d WHERE d.dayofyear = :dayofyear"), @NamedQuery(name = "DarwinCore14.findByFieldnotes", query = "SELECT d FROM DarwinCore14 d WHERE d.fieldnotes = :fieldnotes"), @NamedQuery(name = "DarwinCore14.findByHighergeography", query = "SELECT d FROM DarwinCore14 d WHERE d.highergeography = :highergeography"), @NamedQuery(name = "DarwinCore14.findByContinent", query = "SELECT d FROM DarwinCore14 d WHERE d.continent = :continent"), @NamedQuery(name = "DarwinCore14.findByWaterbody", query = "SELECT d FROM DarwinCore14 d WHERE d.waterbody = :waterbody"), @NamedQuery(name = "DarwinCore14.findByIslandgroup", query = "SELECT d FROM DarwinCore14 d WHERE d.islandgroup = :islandgroup"), @NamedQuery(name = "DarwinCore14.findByIsland", query = "SELECT d FROM DarwinCore14 d WHERE d.island = :island"), @NamedQuery(name = "DarwinCore14.findByCountry", query = "SELECT d FROM DarwinCore14 d WHERE d.country = :country"), @NamedQuery(name = "DarwinCore14.findByStateprovince", query = "SELECT d FROM DarwinCore14 d WHERE d.stateprovince = :stateprovince"), @NamedQuery(name = "DarwinCore14.findByCounty", query = "SELECT d FROM DarwinCore14 d WHERE d.county = :county"), @NamedQuery(name = "DarwinCore14.findByLocality", query = "SELECT d FROM DarwinCore14 d WHERE d.locality = :locality"), @NamedQuery(name = "DarwinCore14.findByDecimallongitude", query = "SELECT d FROM DarwinCore14 d WHERE d.decimallongitude = :decimallongitude"), @NamedQuery(name = "DarwinCore14.findByVerbatimlongitude", query = "SELECT d FROM DarwinCore14 d WHERE d.verbatimlongitude = :verbatimlongitude"), @NamedQuery(name = "DarwinCore14.findByDecimallatitude", query = "SELECT d FROM DarwinCore14 d WHERE d.decimallatitude = :decimallatitude"), @NamedQuery(name = "DarwinCore14.findByVerbatimlatitude", query = "SELECT d FROM DarwinCore14 d WHERE d.verbatimlatitude = :verbatimlatitude"), @NamedQuery(name = "DarwinCore14.findByGeodeticdatum", query = "SELECT d FROM DarwinCore14 d WHERE d.geodeticdatum = :geodeticdatum"), @NamedQuery(name = "DarwinCore14.findByVerbatimcoordinatesystem", query = "SELECT d FROM DarwinCore14 d WHERE d.verbatimcoordinatesystem = :verbatimcoordinatesystem"), @NamedQuery(name = "DarwinCore14.findByGeoreferenceprotocol", query = "SELECT d FROM DarwinCore14 d WHERE d.georeferenceprotocol = :georeferenceprotocol"), @NamedQuery(name = "DarwinCore14.findByCoordinateuncertaintyinmeters", query = "SELECT d FROM DarwinCore14 d WHERE d.coordinateuncertaintyinmeters = :coordinateuncertaintyinmeters"), @NamedQuery(name = "DarwinCore14.findByGeoreferenceremarks", query = "SELECT d FROM DarwinCore14 d WHERE d.georeferenceremarks = :georeferenceremarks"), @NamedQuery(name = "DarwinCore14.findByFootprintwkt", query = "SELECT d FROM DarwinCore14 d WHERE d.footprintwkt = :footprintwkt"), @NamedQuery(name = "DarwinCore14.findByMinimumelevationinmeters", query = "SELECT d FROM DarwinCore14 d WHERE d.minimumelevationinmeters = :minimumelevationinmeters"), @NamedQuery(name = "DarwinCore14.findByMaximumelevationinmeters", query = "SELECT d FROM DarwinCore14 d WHERE d.maximumelevationinmeters = :maximumelevationinmeters"), @NamedQuery(name = "DarwinCore14.findByVerbatimelevation", query = "SELECT d FROM DarwinCore14 d WHERE d.verbatimelevation = :verbatimelevation"), @NamedQuery(name = "DarwinCore14.findByMinimumdepthinmeters", query = "SELECT d FROM DarwinCore14 d WHERE d.minimumdepthinmeters = :minimumdepthinmeters"), @NamedQuery(name = "DarwinCore14.findByMaximumdepthinmeters", query = "SELECT d FROM DarwinCore14 d WHERE d.maximumdepthinmeters = :maximumdepthinmeters"), @NamedQuery(name = "DarwinCore14.findBySex", query = "SELECT d FROM DarwinCore14 d WHERE d.sex = :sex"), @NamedQuery(name = "DarwinCore14.findByLifestage", query = "SELECT d FROM DarwinCore14 d WHERE d.lifestage = :lifestage"), @NamedQuery(name = "DarwinCore14.findByPreparations", query = "SELECT d FROM DarwinCore14 d WHERE d.preparations = :preparations"), @NamedQuery(name = "DarwinCore14.findByIndividualcount", query = "SELECT d FROM DarwinCore14 d WHERE d.individualcount = :individualcount"), @NamedQuery(name = "DarwinCore14.findByGenbanknum", query = "SELECT d FROM DarwinCore14 d WHERE d.genbanknum = :genbanknum"), @NamedQuery(name = "DarwinCore14.findByOthercatalognumbers", query = "SELECT d FROM DarwinCore14 d WHERE d.othercatalognumbers = :othercatalognumbers"), @NamedQuery(name = "DarwinCore14.findByRelatedcatalogitems", query = "SELECT d FROM DarwinCore14 d WHERE d.relatedcatalogitems = :relatedcatalogitems"), @NamedQuery(name = "DarwinCore14.findByRemarks", query = "SELECT d FROM DarwinCore14 d WHERE d.remarks = :remarks"), @NamedQuery(name = "DarwinCore14.findByAttributes", query = "SELECT d FROM DarwinCore14 d WHERE d.attributes = :attributes"), @NamedQuery(name = "DarwinCore14.findByImageurl", query = "SELECT d FROM DarwinCore14 d WHERE d.imageurl = :imageurl"), @NamedQuery(name = "DarwinCore14.findByRelatedinformation", query = "SELECT d FROM DarwinCore14 d WHERE d.relatedinformation = :relatedinformation"), @NamedQuery(name = "DarwinCore14.findByDisposition", query = "SELECT d FROM DarwinCore14 d WHERE d.disposition = :disposition"), @NamedQuery(name = "DarwinCore14.findByPointradiusspatialfit", query = "SELECT d FROM DarwinCore14 d WHERE d.pointradiusspatialfit = :pointradiusspatialfit"), @NamedQuery(name = "DarwinCore14.findByFootprintspatialfit", query = "SELECT d FROM DarwinCore14 d WHERE d.footprintspatialfit = :footprintspatialfit"), @NamedQuery(name = "DarwinCore14.findByVerbatimcoordinates", query = "SELECT d FROM DarwinCore14 d WHERE d.verbatimcoordinates = :verbatimcoordinates"), @NamedQuery(name = "DarwinCore14.findByGeoreferencesources", query = "SELECT d FROM DarwinCore14 d WHERE d.georeferencesources = :georeferencesources"), @NamedQuery(name = "DarwinCore14.findByGeoreferenceverificationstatus", query = "SELECT d FROM DarwinCore14 d WHERE d.georeferenceverificationstatus = :georeferenceverificationstatus")})
public class DarwinCore14 implements Serializable {
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
    @Column(name = "catalognumber")
    private String catalognumber;
    @Column(name = "catalognumbernumeric")
    private BigInteger catalognumbernumeric;
    @Column(name = "scientificname")
    private String scientificname;
    @Column(name = "basisofrecord")
    private String basisofrecord;
    @Column(name = "informationwithheld")
    private String informationwithheld;
    @Column(name = "kingdomid")
    private BigInteger kingdomid;
    @Column(name = "phylum_id")
    private BigInteger phylumId;
    @Column(name = "class_id")
    private BigInteger classId;
    @Column(name = "orders_id")
    private BigInteger ordersId;
    @Column(name = "family_id")
    private BigInteger familyId;
    @Column(name = "genus_id")
    private BigInteger genusId;
    @Column(name = "specificepithet_id")
    private BigInteger specificepithetId;
    @Column(name = "infraspecificepithet_id")
    private BigInteger infraspecificepithetId;
    @Column(name = "highertaxon")
    private String highertaxon;
    @Column(name = "kingdom")
    private String kingdom;
    @Column(name = "phylum")
    private String phylum;
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
    @Column(name = "identifiedby")
    private String identifiedby;
    @Column(name = "dateidentified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateidentified;
    @Column(name = "typestatus")
    private String typestatus;
    @Column(name = "collectingmethod")
    private String collectingmethod;
    @Column(name = "validdistributionflag")
    private String validdistributionflag;
    @Column(name = "collectornumber")
    private String collectornumber;
    @Column(name = "fieldnumber")
    private String fieldnumber;
    @Column(name = "collector")
    private String collector;
    @Column(name = "earliestdatecollected")
    @Temporal(TemporalType.TIMESTAMP)
    private Date earliestdatecollected;
    @Column(name = "latestdatecollected")
    @Temporal(TemporalType.TIMESTAMP)
    private Date latestdatecollected;
    @Column(name = "verbatimcollectingdate")
    private String verbatimcollectingdate;
    @Column(name = "dayofyear")
    private BigInteger dayofyear;
    @Column(name = "fieldnotes")
    private String fieldnotes;
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
    @Column(name = "decimallongitude")
    private String decimallongitude;
    @Column(name = "verbatimlongitude")
    private String verbatimlongitude;
    @Column(name = "decimallatitude")
    private String decimallatitude;
    @Column(name = "verbatimlatitude")
    private String verbatimlatitude;
    @Column(name = "geodeticdatum")
    private String geodeticdatum;
    @Column(name = "verbatimcoordinatesystem")
    private String verbatimcoordinatesystem;
    @Column(name = "georeferenceprotocol")
    private String georeferenceprotocol;
    @Column(name = "coordinateuncertaintyinmeters")
    private String coordinateuncertaintyinmeters;
    @Column(name = "georeferenceremarks")
    private String georeferenceremarks;
    @Column(name = "footprintwkt")
    private String footprintwkt;
    @Column(name = "minimumelevationinmeters")
    private Double minimumelevationinmeters;
    @Column(name = "maximumelevationinmeters")
    private Double maximumelevationinmeters;
    @Column(name = "verbatimelevation")
    private String verbatimelevation;
    @Column(name = "minimumdepthinmeters")
    private Double minimumdepthinmeters;
    @Column(name = "maximumdepthinmeters")
    private Double maximumdepthinmeters;
    @Column(name = "sex")
    private String sex;
    @Column(name = "lifestage")
    private String lifestage;
    @Column(name = "preparations")
    private String preparations;
    @Column(name = "individualcount")
    private BigInteger individualcount;
    @Column(name = "genbanknum")
    private String genbanknum;
    @Column(name = "othercatalognumbers")
    private String othercatalognumbers;
    @Column(name = "relatedcatalogitems")
    private String relatedcatalogitems;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "attributes")
    private String attributes;
    @Column(name = "imageurl")
    private String imageurl;
    @Column(name = "relatedinformation")
    private String relatedinformation;
    @Column(name = "disposition")
    private String disposition;
    @Column(name = "pointradiusspatialfit")
    private BigInteger pointradiusspatialfit;
    @Column(name = "footprintspatialfit")
    private BigInteger footprintspatialfit;
    @Column(name = "verbatimcoordinates")
    private String verbatimcoordinates;
    @Column(name = "georeferencesources")
    private String georeferencesources;
    @Column(name = "georeferenceverificationstatus")
    private String georeferenceverificationstatus;

    public DarwinCore14() {
    }

    public DarwinCore14(String globaluniqueidentifier) {
        this.globaluniqueidentifier = globaluniqueidentifier;
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

    public BigInteger getCatalognumbernumeric() {
        return catalognumbernumeric;
    }

    public void setCatalognumbernumeric(BigInteger catalognumbernumeric) {
        this.catalognumbernumeric = catalognumbernumeric;
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

    public BigInteger getKingdomid() {
        return kingdomid;
    }

    public void setKingdomid(BigInteger kingdomid) {
        this.kingdomid = kingdomid;
    }

    public BigInteger getPhylumId() {
        return phylumId;
    }

    public void setPhylumId(BigInteger phylumId) {
        this.phylumId = phylumId;
    }

    public BigInteger getClassId() {
        return classId;
    }

    public void setClassId(BigInteger classId) {
        this.classId = classId;
    }

    public BigInteger getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(BigInteger ordersId) {
        this.ordersId = ordersId;
    }

    public BigInteger getFamilyId() {
        return familyId;
    }

    public void setFamilyId(BigInteger familyId) {
        this.familyId = familyId;
    }

    public BigInteger getGenusId() {
        return genusId;
    }

    public void setGenusId(BigInteger genusId) {
        this.genusId = genusId;
    }

    public BigInteger getSpecificepithetId() {
        return specificepithetId;
    }

    public void setSpecificepithetId(BigInteger specificepithetId) {
        this.specificepithetId = specificepithetId;
    }

    public BigInteger getInfraspecificepithetId() {
        return infraspecificepithetId;
    }

    public void setInfraspecificepithetId(BigInteger infraspecificepithetId) {
        this.infraspecificepithetId = infraspecificepithetId;
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

    public String getPhylum() {
        return phylum;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
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

    public String getIdentifiedby() {
        return identifiedby;
    }

    public void setIdentifiedby(String identifiedby) {
        this.identifiedby = identifiedby;
    }

    public Date getDateidentified() {
        return dateidentified;
    }

    public void setDateidentified(Date dateidentified) {
        this.dateidentified = dateidentified;
    }

    public String getTypestatus() {
        return typestatus;
    }

    public void setTypestatus(String typestatus) {
        this.typestatus = typestatus;
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

    public String getCollectornumber() {
        return collectornumber;
    }

    public void setCollectornumber(String collectornumber) {
        this.collectornumber = collectornumber;
    }

    public String getFieldnumber() {
        return fieldnumber;
    }

    public void setFieldnumber(String fieldnumber) {
        this.fieldnumber = fieldnumber;
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

    public String getVerbatimcollectingdate() {
        return verbatimcollectingdate;
    }

    public void setVerbatimcollectingdate(String verbatimcollectingdate) {
        this.verbatimcollectingdate = verbatimcollectingdate;
    }

    public BigInteger getDayofyear() {
        return dayofyear;
    }

    public void setDayofyear(BigInteger dayofyear) {
        this.dayofyear = dayofyear;
    }

    public String getFieldnotes() {
        return fieldnotes;
    }

    public void setFieldnotes(String fieldnotes) {
        this.fieldnotes = fieldnotes;
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

    public String getDecimallongitude() {
        return decimallongitude;
    }

    public void setDecimallongitude(String decimallongitude) {
        this.decimallongitude = decimallongitude;
    }

    public String getVerbatimlongitude() {
        return verbatimlongitude;
    }

    public void setVerbatimlongitude(String verbatimlongitude) {
        this.verbatimlongitude = verbatimlongitude;
    }

    public String getDecimallatitude() {
        return decimallatitude;
    }

    public void setDecimallatitude(String decimallatitude) {
        this.decimallatitude = decimallatitude;
    }

    public String getVerbatimlatitude() {
        return verbatimlatitude;
    }

    public void setVerbatimlatitude(String verbatimlatitude) {
        this.verbatimlatitude = verbatimlatitude;
    }

    public String getGeodeticdatum() {
        return geodeticdatum;
    }

    public void setGeodeticdatum(String geodeticdatum) {
        this.geodeticdatum = geodeticdatum;
    }

    public String getVerbatimcoordinatesystem() {
        return verbatimcoordinatesystem;
    }

    public void setVerbatimcoordinatesystem(String verbatimcoordinatesystem) {
        this.verbatimcoordinatesystem = verbatimcoordinatesystem;
    }

    public String getGeoreferenceprotocol() {
        return georeferenceprotocol;
    }

    public void setGeoreferenceprotocol(String georeferenceprotocol) {
        this.georeferenceprotocol = georeferenceprotocol;
    }

    public String getCoordinateuncertaintyinmeters() {
        return coordinateuncertaintyinmeters;
    }

    public void setCoordinateuncertaintyinmeters(String coordinateuncertaintyinmeters) {
        this.coordinateuncertaintyinmeters = coordinateuncertaintyinmeters;
    }

    public String getGeoreferenceremarks() {
        return georeferenceremarks;
    }

    public void setGeoreferenceremarks(String georeferenceremarks) {
        this.georeferenceremarks = georeferenceremarks;
    }

    public String getFootprintwkt() {
        return footprintwkt;
    }

    public void setFootprintwkt(String footprintwkt) {
        this.footprintwkt = footprintwkt;
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

    public String getVerbatimelevation() {
        return verbatimelevation;
    }

    public void setVerbatimelevation(String verbatimelevation) {
        this.verbatimelevation = verbatimelevation;
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

    public String getPreparations() {
        return preparations;
    }

    public void setPreparations(String preparations) {
        this.preparations = preparations;
    }

    public BigInteger getIndividualcount() {
        return individualcount;
    }

    public void setIndividualcount(BigInteger individualcount) {
        this.individualcount = individualcount;
    }

    public String getGenbanknum() {
        return genbanknum;
    }

    public void setGenbanknum(String genbanknum) {
        this.genbanknum = genbanknum;
    }

    public String getOthercatalognumbers() {
        return othercatalognumbers;
    }

    public void setOthercatalognumbers(String othercatalognumbers) {
        this.othercatalognumbers = othercatalognumbers;
    }

    public String getRelatedcatalogitems() {
        return relatedcatalogitems;
    }

    public void setRelatedcatalogitems(String relatedcatalogitems) {
        this.relatedcatalogitems = relatedcatalogitems;
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

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public BigInteger getPointradiusspatialfit() {
        return pointradiusspatialfit;
    }

    public void setPointradiusspatialfit(BigInteger pointradiusspatialfit) {
        this.pointradiusspatialfit = pointradiusspatialfit;
    }

    public BigInteger getFootprintspatialfit() {
        return footprintspatialfit;
    }

    public void setFootprintspatialfit(BigInteger footprintspatialfit) {
        this.footprintspatialfit = footprintspatialfit;
    }

    public String getVerbatimcoordinates() {
        return verbatimcoordinates;
    }

    public void setVerbatimcoordinates(String verbatimcoordinates) {
        this.verbatimcoordinates = verbatimcoordinates;
    }

    public String getGeoreferencesources() {
        return georeferencesources;
    }

    public void setGeoreferencesources(String georeferencesources) {
        this.georeferencesources = georeferencesources;
    }

    public String getGeoreferenceverificationstatus() {
        return georeferenceverificationstatus;
    }

    public void setGeoreferenceverificationstatus(String georeferenceverificationstatus) {
        this.georeferenceverificationstatus = georeferenceverificationstatus;
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
        if (!(object instanceof DarwinCore14)) {
            return false;
        }
        DarwinCore14 other = (DarwinCore14) object;
        if ((this.globaluniqueidentifier == null && other.globaluniqueidentifier != null) || (this.globaluniqueidentifier != null && !this.globaluniqueidentifier.equals(other.globaluniqueidentifier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.inbio.ara.persistence.specimen.DarwinCore14[globaluniqueidentifier=" + globaluniqueidentifier + "]";
    }

}
