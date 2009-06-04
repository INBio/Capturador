/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.inbio.ara.facade.share;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.inbio.ara.eao.ShareEAOLocal;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationDetail;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.gis.SiteCalculationMethod;
import org.inbio.ara.persistence.gis.SiteCoordinate;
import org.inbio.ara.persistence.share.DwcSnapshot;
import org.inbio.ara.persistence.share.PliElement;
import org.inbio.ara.persistence.specimen.DarwinCore14;
import org.inbio.ara.persistence.specimen.DwcCategory;
import org.inbio.ara.persistence.specimen.DwcElement;
import org.inbio.ara.persistence.specimen.Identification;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSex;
import org.inbio.ara.persistence.taxonomy.TaxonAuthor;
import org.inbio.ara.util.QueryNode;

/**
 *
 * @author esmata
 */
@Stateless
public class ShareBean implements ShareRemote, ShareLocal {

    //Injection
    @EJB private ShareEAOLocal SEAOL;

    //Constants
    Long CERO = new Long(0);
    Long UNO = new Long(1);
    Long DOS = new Long(2);

    @Override
    public String makeDcwSnapshotAll(){
        try{
            //Delete all snapshot entries
            SEAOL.truncateDwcSnapshot();

            //Retrive information
            List<DarwinCore14> dwcInfo = SEAOL.retriveInformationDcwAll();
            System.out.println(dwcInfo.size()); //To check content

            for (DarwinCore14 dwcAux : dwcInfo){
                DwcSnapshot snapshotEntry = new DwcSnapshot();
                snapshotEntry.setGlobaluniqueidentifier(dwcAux.getGlobaluniqueidentifier());
                snapshotEntry.setDatelastmodified(dwcAux.getDatelastmodified());
                snapshotEntry.setInstitutioncode(dwcAux.getInstitutioncode());
                snapshotEntry.setCollectioncode(dwcAux.getCollectioncode());
                snapshotEntry.setCatalognumber(dwcAux.getCatalognumber());
                snapshotEntry.setScientificname(dwcAux.getScientificname());
                snapshotEntry.setBasisofrecord(dwcAux.getBasisofrecord());
                snapshotEntry.setInformationwithheld(dwcAux.getInformationwithheld());
                snapshotEntry.setPhylum(dwcAux.getPhylum());
                snapshotEntry.setHighertaxon(dwcAux.getHighertaxon());
                snapshotEntry.setKingdom(dwcAux.getKingdom());
                snapshotEntry.setClass1(dwcAux.getClass1());
                snapshotEntry.setOrders(dwcAux.getOrders());
                snapshotEntry.setFamily(dwcAux.getFamily());
                snapshotEntry.setGenus(dwcAux.getGenus());
                snapshotEntry.setSpecificepithet(dwcAux.getSpecificepithet());
                snapshotEntry.setInfraspecificepithet(dwcAux.getInfraspecificepithet());
                snapshotEntry.setInfraspecificrank(dwcAux.getInfraspecificrank());
                snapshotEntry.setAuthoryearofscientificname(dwcAux.getAuthoryearofscientificname());
                snapshotEntry.setNomenclaturalcode(dwcAux.getNomenclaturalcode());
                snapshotEntry.setIdentificationqualifier(dwcAux.getIdentificationqualifier());
                snapshotEntry.setCollectingmethod(dwcAux.getCollectingmethod());
                snapshotEntry.setValiddistributionflag(dwcAux.getValiddistributionflag());
                snapshotEntry.setCollector(dwcAux.getCollector());
                snapshotEntry.setEarliestdatecollected(dwcAux.getEarliestdatecollected());
                snapshotEntry.setLatestdatecollected(dwcAux.getLatestdatecollected());
                snapshotEntry.setDayofyear(dwcAux.getDayofyear());
                snapshotEntry.setHighergeography(dwcAux.getHighergeography());
                snapshotEntry.setContinent(dwcAux.getContinent());
                snapshotEntry.setWaterbody(dwcAux.getWaterbody());
                snapshotEntry.setIslandgroup(dwcAux.getIslandgroup());
                snapshotEntry.setIsland(dwcAux.getIsland());
                snapshotEntry.setCountry(dwcAux.getCountry());
                snapshotEntry.setStateprovince(dwcAux.getStateprovince());
                snapshotEntry.setCounty(dwcAux.getCounty());
                snapshotEntry.setLocality(dwcAux.getLocality());
                snapshotEntry.setMinimumelevationinmeters(dwcAux.getMinimumelevationinmeters());
                snapshotEntry.setMaximumelevationinmeters(dwcAux.getMaximumelevationinmeters());
                snapshotEntry.setMinimumdepthinmeters(dwcAux.getMinimumdepthinmeters());
                snapshotEntry.setMaximumdepthinmeters(dwcAux.getMaximumdepthinmeters());
                snapshotEntry.setSex(dwcAux.getSex());
                snapshotEntry.setLifestage(dwcAux.getLifestage());
                snapshotEntry.setRemarks(dwcAux.getRemarks());
                snapshotEntry.setAttributes(dwcAux.getAttributes());
                snapshotEntry.setImageurl(dwcAux.getImageurl());
                snapshotEntry.setRelatedinformation(dwcAux.getRelatedinformation());
                SEAOL.create(snapshotEntry);
            }
            return "success";
        }
        catch(Exception e){
            System.out.println(e);
            return "fail";
        }
    }
    
    @Override
    public String makeDcwSnapshot(LinkedList<QueryNode> qnlist,LinkedList<String> elist, int validate){
        try{
            //Delete all snapshot entries
            SEAOL.truncateDwcSnapshot();

            //Make "Select" query
            String select = makeQueryString(qnlist,elist,validate);
            //System.out.println(select); //To check string

            //Retrive information
            List<DarwinCore14> dwcInfo = SEAOL.retriveInformationDcw(select);
            //System.out.println(dwcInfo.size()); //To check content

            //Populate snapshot and persist the entries (entities)
            for (DarwinCore14 dwcAux : dwcInfo){
                DwcSnapshot snapshotEntry = new DwcSnapshot();
                for(int i=0;i<elist.size();i++){                    
                    String value = elist.get(i);
                    if(value.equals("globaluniqueidentifier"))
                        snapshotEntry.setGlobaluniqueidentifier(dwcAux.getGlobaluniqueidentifier());
                    else if(value.equals("datelastmodified"))
                        snapshotEntry.setDatelastmodified(dwcAux.getDatelastmodified());
                    else if(value.equals("institutioncode"))
                        snapshotEntry.setInstitutioncode(dwcAux.getInstitutioncode());
                    else if(value.equals("collectioncode"))
                        snapshotEntry.setCollectioncode(dwcAux.getCollectioncode());
                    else if(value.equals("catalognumber"))
                        snapshotEntry.setCatalognumber(dwcAux.getCatalognumber());
                    else if(value.equals("scientificname"))
                        snapshotEntry.setScientificname(dwcAux.getScientificname());
                    else if(value.equals("basisofrecord"))
                        snapshotEntry.setBasisofrecord(dwcAux.getBasisofrecord());
                    else if(value.equals("informationwithheld"))
                        snapshotEntry.setInformationwithheld(dwcAux.getInformationwithheld());
                    else if(value.equals("phylum"))
                        snapshotEntry.setPhylum(dwcAux.getPhylum());
                    else if(value.equals("highertaxon"))
                        snapshotEntry.setHighertaxon(dwcAux.getHighertaxon());
                    else if(value.equals("kingdom"))
                        snapshotEntry.setKingdom(dwcAux.getKingdom());
                    else if(value.equals("class1"))
                        snapshotEntry.setClass1(dwcAux.getClass1());
                    else if(value.equals("orders"))
                        snapshotEntry.setOrders(dwcAux.getOrders());
                    else if(value.equals("family"))
                        snapshotEntry.setFamily(dwcAux.getFamily());
                    else if(value.equals("genus"))
                        snapshotEntry.setGenus(dwcAux.getGenus());
                    else if(value.equals("specificepithet"))
                        snapshotEntry.setSpecificepithet(dwcAux.getSpecificepithet());
                    else if(value.equals("infraspecificepithet"))
                        snapshotEntry.setInfraspecificepithet(dwcAux.getInfraspecificepithet());
                    else if(value.equals("infraspecificrank"))
                        snapshotEntry.setInfraspecificrank(dwcAux.getInfraspecificrank());
                    else if(value.equals("authoryearofscientificname"))
                        snapshotEntry.setAuthoryearofscientificname(dwcAux.getAuthoryearofscientificname());
                    else if(value.equals("nomenclaturalcode"))
                        snapshotEntry.setNomenclaturalcode(dwcAux.getNomenclaturalcode());
                    else if(value.equals("identificationqualifier"))
                        snapshotEntry.setIdentificationqualifier(dwcAux.getIdentificationqualifier());
                    else if(value.equals("collectingmethod"))
                        snapshotEntry.setCollectingmethod(dwcAux.getCollectingmethod());
                    else if(value.equals("validdistributionflag"))
                        snapshotEntry.setValiddistributionflag(dwcAux.getValiddistributionflag());
                    else if(value.equals("collector"))
                        snapshotEntry.setCollector(dwcAux.getCollector());
                    else if(value.equals("earliestdatecollected"))
                        snapshotEntry.setEarliestdatecollected(dwcAux.getEarliestdatecollected());
                    else if(value.equals("latestdatecollected"))
                        snapshotEntry.setLatestdatecollected(dwcAux.getLatestdatecollected());
                    else if(value.equals("dayofyear"))
                        snapshotEntry.setDayofyear(dwcAux.getDayofyear());
                    else if(value.equals("highergeography"))
                        snapshotEntry.setHighergeography(dwcAux.getHighergeography());
                    else if(value.equals("continent"))
                        snapshotEntry.setContinent(dwcAux.getContinent());
                    else if(value.equals("waterbody"))
                        snapshotEntry.setWaterbody(dwcAux.getWaterbody());
                    else if(value.equals("islandgroup"))
                        snapshotEntry.setIslandgroup(dwcAux.getIslandgroup());
                    else if(value.equals("island"))
                        snapshotEntry.setIsland(dwcAux.getIsland());
                    else if(value.equals("country"))
                        snapshotEntry.setCountry(dwcAux.getCountry());
                    else if(value.equals("stateprovince"))
                        snapshotEntry.setStateprovince(dwcAux.getStateprovince());
                    else if(value.equals("county"))
                        snapshotEntry.setCounty(dwcAux.getCounty());
                    else if(value.equals("locality"))
                        snapshotEntry.setLocality(dwcAux.getLocality());
                    else if(value.equals("minimumelevationinmeters"))
                        snapshotEntry.setMinimumelevationinmeters(dwcAux.getMinimumelevationinmeters());
                    else if(value.equals("maximumelevationinmeters"))
                        snapshotEntry.setMaximumelevationinmeters(dwcAux.getMaximumelevationinmeters());
                    else if(value.equals("minimumdepthinmeters"))
                        snapshotEntry.setMinimumdepthinmeters(dwcAux.getMinimumdepthinmeters());
                    else if(value.equals("maximumdepthinmeters"))
                        snapshotEntry.setMaximumdepthinmeters(dwcAux.getMaximumdepthinmeters());
                    else if(value.equals("sex"))
                        snapshotEntry.setSex(dwcAux.getSex());
                    else if(value.equals("lifestage"))
                        snapshotEntry.setLifestage(dwcAux.getLifestage());
                    else if(value.equals("remarks"))
                        snapshotEntry.setRemarks(dwcAux.getRemarks());
                    else if(value.equals("attributes"))
                        snapshotEntry.setAttributes(dwcAux.getAttributes());
                    else if(value.equals("imageurl"))
                        snapshotEntry.setImageurl(dwcAux.getImageurl());
                    else if(value.equals("relatedinformation"))
                        snapshotEntry.setRelatedinformation(dwcAux.getRelatedinformation());
                }
                    //Persist the new entity
                    SEAOL.create(snapshotEntry);
            } // Ending of "for"
            return "success";
        }
        catch(Exception e){
            System.out.println(e);
            return "fail";
        }
    }

    //Contruc the select String for darwin core snapshot
    @Override
	public String makeQueryString(LinkedList<QueryNode> llqn,LinkedList<String> lls, int validate) {
        String jpqlQuery;
        if(llqn.size() == 1 && validate == 2){ //The firs filter is unique and empty
            jpqlQuery = "from DarwinCore14 as dc";
            return jpqlQuery;
        }
        else{
            jpqlQuery = "from DarwinCore14 as dc where ";
            //Mandatory
            QueryNode qn = llqn.getFirst();
            jpqlQuery += "lower(dc." + qn.getDwcElement()+")";
            jpqlQuery += " " + qn.getComparator() + " ";
            if (qn.getComparator().equals("like")) {
                jpqlQuery += "'%" + qn.getUserEntry().toLowerCase() + "%'";
            } else {
                jpqlQuery += "'" + qn.getUserEntry().toLowerCase() + "'";
            }
            //Optional
            for(int i = 1; i < llqn.size(); i++) {
                qn = llqn.get(i);
                jpqlQuery += " " + qn.getLogicalOperator() + " ";
                jpqlQuery += "lower(dc." + qn.getDwcElement()+")";
                jpqlQuery += " " + qn.getComparator() + " ";
                if (qn.getComparator().equals("like")) {
                    jpqlQuery += "'%" + qn.getUserEntry().toLowerCase() + "%'";
                } else {
                    jpqlQuery += "'" + qn.getUserEntry().toLowerCase() + "'";
                }
            }
            return jpqlQuery;
        }
	}

    //Method to get a especifica darwin core element
    @Override
	public DwcElement getDwCElementByIdB(BigDecimal id) {
		return SEAOL.getDwCElementById(id);
	}

    //Method to get a list of darwin core elements
    @Override
	public List<DwcElement> getDwCElementsB() {
        return SEAOL.getDwCElements();
	}

    //Method to get a list of darwin core categories
    @Override
	public List<DwcCategory> getDwCCategoriesB() {
		return SEAOL.getDwCCategories();
	}

    //Method to get a list of darwin core elements
    @Override
	public List<PliElement> getPliElementsB() {
        return SEAOL.getPliElements();
	}

    //Method to get a especific plinian core element
    @Override
	public PliElement getPliElementByIdB(BigDecimal id) {
		return SEAOL.getPliElementById(id);
	}

    //Method to create the darwin core 1.4 table
    @Override
    public String createDwCTable(){
        //Lists of each kind of specimen id
        List<Long> specimenIdListIndObs = SEAOL.getSpecimenIdList();
        List<Long> specimenIdListAgruUnitaxon = SEAOL.getSpecimenIdListAU();
        List<Long> specimenIdListAgruMultitax = SEAOL.getSpecimenIdListAM();
        Calendar calendar = new GregorianCalendar(); //To get curret date
        Long actualTaxon = new Long(0);
        String actualAYofSN = "";
        try{            
            SEAOL.truncateDwcTable(); //Delete all Dwc14 entries = "truncate"

            /***********************************************************************************
             ******** If specimenCategory.id is equal to 1(Observation) or 2(individuals)
             ***********************************************************************************/
              //Iterate over specimen id list to create a DarwinCore14 objects
            for(int i=0;i<specimenIdListIndObs.size();i++){                
                Long sId = specimenIdListIndObs.get(i);
                Specimen specimen = (Specimen) SEAOL.findSpecimen(sId);
                if(specimen != null){
                    DarwinCore14 newDwcEntry = new DarwinCore14();//Create an instance of DarwinCore14 object
                    newDwcEntry.setGlobaluniqueidentifier(specimen.getCollection().getName()+":"+to_char(sId,"000000000000"));
                    newDwcEntry.setDatelastmodified(calendar.getTime());
                    //TODO:IstitutionCode
                    newDwcEntry.setCollectioncode(specimen.getCollection().getName());
                    newDwcEntry.setCatalognumber(to_char(sId,"000000000000"));
                    newDwcEntry.setCatalognumbernumeric(BigInteger.valueOf(sId));
                    newDwcEntry.setCollectingmethod(specimen.getGatheringObservationMethodName());
                    GatheringObservationDetail god = specimen.getGatheringObservationDetail();
                    if(god != null){
                        newDwcEntry.setCollectornumber(god.getGatheringObservationDetailNumber());}
                    GatheringObservation gat = specimen.getGatheringObservation();
                    if (gat != null) {
                        Site sit = gat.getSite();
                        if (sit != null) {
                            List<SiteCoordinate> scl = sit.getCoordinateList();
                            if (scl != null && scl.size() > 0) {
                                SiteCoordinate sitCoor = scl.get(0); //Get the first site coordinate
                                if (sitCoor.getLongitude() != null) {
                                    newDwcEntry.setDecimallongitude(sitCoor.getLongitude().toString());
                                    newDwcEntry.setVerbatimlongitude(to_char(sitCoor.getLongitude(), "#########.######"));
                                }
                                if (sitCoor.getLatitude() != null) {
                                    newDwcEntry.setDecimallatitude(sitCoor.getLatitude().toString());
                                    newDwcEntry.setVerbatimlatitude(to_char(sitCoor.getLatitude(), "#########.######"));
                                }
                            }
                            if(sit.getGeodeticDatum() != null){
                                newDwcEntry.setGeodeticdatum(sit.getGeodeticDatum().toString());
                            }
                            SiteCalculationMethod scm = sit.getSiteCalculationMethod();
                            if(scm != null){
                                newDwcEntry.setGeoreferenceprotocol(scm.getName());
                            }
                            if(sit.getPrecision() != null){
                                newDwcEntry.setCoordinateuncertaintyinmeters(sit.getPrecision().toString());
                            }
                        } //sit end
                        newDwcEntry.setFieldnumber(to_char(gat.getId(), "000000000000"));
                        newDwcEntry.setCollector(gat.getFirstCollectorObserverName());
                        newDwcEntry.setEarliestdatecollected(gat.getInitialDate());
                        newDwcEntry.setLatestdatecollected(gat.getFinalDate());
                        newDwcEntry.setVerbatimcollectingdate(to_char_date(gat.getInitialDate(),"MMM dd, yyyy"));
                        if(gat.getMinimumElevation() != null){
                            newDwcEntry.setMinimumelevationinmeters(gat.getMinimumElevation().doubleValue());
                        }
                        if(gat.getMaximumElevation() != null){
                            newDwcEntry.setMaximumelevationinmeters(gat.getMaximumElevation().doubleValue());
                        }
                        if(gat.getMinimumDepth() != null){
                            newDwcEntry.setMinimumdepthinmeters(gat.getMinimumDepth().doubleValue());
                        }
                        if(gat.getMaximumDepth() != null){
                            newDwcEntry.setMaximumdepthinmeters(gat.getMaximumDepth().doubleValue());
                        }
                    } //gat end
                    if (specimen.getSpecimenCategory() != null) {
                        Long specimenCategory = specimen.getSpecimenCategory().getId();
                        if (specimenCategory != null && specimenCategory.equals(UNO)) {
                            newDwcEntry.setBasisofrecord("Observation");
                        }
                        if (specimenCategory != null && specimenCategory.equals(DOS)) {
                            newDwcEntry.setBasisofrecord("Preserved specimen");
                        }
                    }
                    newDwcEntry.setVerbatimcoordinatesystem("Decimal degrees");                    
                    newDwcEntry.setSex(getSexOrLifeStage(sId,1));//Sex
                    newDwcEntry.setLifestage(getSexOrLifeStage(sId,2));//LifeStage
                    newDwcEntry.setPreparations(specimen.getPreservationMediumName());
                    /* Everything related with specimen identification */
                    newDwcEntry.setDateidentified(SEAOL.getIdentificationDate(sId));
                    newDwcEntry.setIdentifiedby(SEAOL.getIdentifiedBy(sId));
                    newDwcEntry.setIdentificationqualifier(SEAOL.getIdentificationqualifier(sId));
                    /* Now, everiting related with the taxonomy tree (taxon info from identification by specimenId) */
                    Long taxonId = SEAOL.getTaxonIdentificationId(sId);
                    if(taxonId!=null){
                        if(!actualTaxon.equals(taxonId)){
                            actualAYofSN = taxonAuthorList(taxonId,2,SEAOL.getTaxonDescriptionYear(taxonId),SEAOL.getTaxonAuthorFormatParenthesis(taxonId));
                            actualTaxon = taxonId;
                        }
                        newDwcEntry.setAuthoryearofscientificname(actualAYofSN);
                        newDwcEntry.setScientificname(SEAOL.getTaxonDefaultName(taxonId));
                        Object[] kingdom = SEAOL.getTaxomonyIds(taxonId, 'a');
                        Object[] phylumDivision = SEAOL.getTaxomonyIds(taxonId, 'b');
                        Object[] classt = SEAOL.getTaxomonyIds(taxonId, 'c');
                        Object[] order = SEAOL.getTaxomonyIds(taxonId, 'd');
                        Object[] family = SEAOL.getTaxomonyIds(taxonId, 'e');
                        Object[] genus = SEAOL.getTaxomonyIds(taxonId, 'f');
                        Object[] species = SEAOL.getTaxomonyIds(taxonId, 'g');
                        Object[] subspecies = SEAOL.getTaxomonyIds(taxonId, 'h');
                        if(kingdom!=null){
                            newDwcEntry.setKingdomid(BigInteger.valueOf((Long)kingdom[0]));
                            newDwcEntry.setKingdom((String)kingdom[1]);
                        }
                        if(phylumDivision!=null){
                            newDwcEntry.setPhylumId(BigInteger.valueOf((Long)phylumDivision[0]));
                            newDwcEntry.setPhylum((String)phylumDivision[1]);
                        }
                        if(classt!=null){
                            newDwcEntry.setClassId(BigInteger.valueOf((Long)classt[0]));
                            newDwcEntry.setClass1((String)classt[1]);
                        }
                        if(order!=null){
                            newDwcEntry.setOrdersId(BigInteger.valueOf((Long)order[0]));
                            newDwcEntry.setOrders((String)order[1]);
                        }
                        if(family!=null){
                            newDwcEntry.setFamilyId(BigInteger.valueOf((Long)family[0]));
                            newDwcEntry.setFamily((String)family[1]);
                        }
                        if(genus!=null){
                            newDwcEntry.setGenusId(BigInteger.valueOf((Long)genus[0]));
                            newDwcEntry.setGenus((String)genus[1]);
                        }
                        if(species!=null){
                            newDwcEntry.setSpecificepithetId(BigInteger.valueOf((Long)species[0]));
                            newDwcEntry.setSpecificepithet((String)species[1]);
                        }
                        if(subspecies!=null){
                            newDwcEntry.setInfraspecificepithetId(BigInteger.valueOf((Long)subspecies[0]));
                            newDwcEntry.setInfraspecificepithet((String)subspecies[1]);
                        }
                    }
                    //Persist the new Darwin core entry
                    SEAOL.create(newDwcEntry);
                }
            } //"for" ending

            /***********************************************************************************
             ********* If specimenCategory.id is equal to 3(Agrupados unitaxon)
             ***********************************************************************************/
            actualTaxon = new Long(0);
            actualAYofSN = "";
            for(int i=0;i<specimenIdListAgruUnitaxon.size();i++){
                Long sId = specimenIdListAgruUnitaxon.get(i);
                Specimen specimen = (Specimen) SEAOL.findSpecimen(sId);
                if(specimen != null){
                    String Globaluniqueidentifier,IstitutionCode,Collectioncode,Catalognumber,Collectingmethod;
                    Globaluniqueidentifier = specimen.getCollection().getName()+":"+to_char(sId,"000000000000");
                    //TODO:IstitutionCode
                    Collectioncode = specimen.getCollection().getName();
                    Catalognumber = to_char(sId,"000000000000");
                    BigInteger Catalognumbernumeric = BigInteger.valueOf(sId);
                    Collectingmethod = specimen.getGatheringObservationMethodName();
                    String Collectornumber = null,Fieldnumber = null,Collector = null,Verbatimcollectingdate = null;
                    Date Earliestdatecollected = null,Latestdatecollected = null;
                    GatheringObservationDetail god = specimen.getGatheringObservationDetail();
                    if(god != null){
                        Collectornumber = god.getGatheringObservationDetailNumber();}
                    String Decimallongitude = null,Verbatimlongitude = null,Decimallatitude = null,Verbatimlatitude = null,Geodeticdatum = null;
                    String Coordinateuncertaintyinmeters = null,Georeferenceprotocol = null;
                    Double Minimumelevationinmeters = null,Maximumelevationinmeters = null,Minimumdepthinmeters = null,Maximumdepthinmeters = null;
                    GatheringObservation gat = specimen.getGatheringObservation();
                    if (gat != null) {
                        Site sit = gat.getSite();
                        if (sit != null) {
                            List<SiteCoordinate> scl = sit.getCoordinateList();
                            if (scl != null && scl.size() > 0) {
                                SiteCoordinate sitCoor = scl.get(0); //Get the first site coordinate
                                if (sitCoor.getLongitude() != null) {
                                    Decimallongitude = sitCoor.getLongitude().toString();
                                    Verbatimlongitude = to_char(sitCoor.getLongitude(), "#########.######");
                                }
                                if (sitCoor.getLatitude() != null) {
                                    Decimallatitude = sitCoor.getLatitude().toString();
                                    Verbatimlatitude = to_char(sitCoor.getLatitude(), "#########.######");
                                }
                            }
                            if(sit.getGeodeticDatum() != null){
                                Geodeticdatum = sit.getGeodeticDatum().toString();
                            }
                            SiteCalculationMethod scm = sit.getSiteCalculationMethod();
                            if(scm != null){
                                Georeferenceprotocol = scm.getName();
                            }
                            if(sit.getPrecision() != null){
                                Coordinateuncertaintyinmeters = sit.getPrecision().toString();
                            }
                        } //sit end
                        Fieldnumber = to_char(gat.getId(), "000000000000");
                        Collector = gat.getFirstCollectorObserverName();
                        Earliestdatecollected = gat.getInitialDate();
                        Latestdatecollected = gat.getFinalDate();
                        Verbatimcollectingdate = to_char_date(gat.getInitialDate(),"MMM dd, yyyy");                        
                        if(gat.getMinimumElevation() != null){
                            Minimumelevationinmeters = gat.getMinimumElevation().doubleValue();
                        }
                        if(gat.getMaximumElevation() != null){
                            Maximumelevationinmeters = gat.getMaximumElevation().doubleValue();
                        }
                        if(gat.getMinimumDepth() != null){
                            Minimumdepthinmeters = gat.getMinimumDepth().doubleValue();
                        }
                        if(gat.getMaximumDepth() != null){
                            Maximumdepthinmeters = gat.getMaximumDepth().doubleValue();
                        }
                    } //gat end
                    String Basisofrecord = null,Verbatimcoordinatesystem,Preparations;
                    if (specimen.getSpecimenCategory() != null) {
                        Long specimenCategory = specimen.getSpecimenCategory().getId();
                        if (specimenCategory != null && specimenCategory.equals(UNO)) {
                            Basisofrecord = "Observation";
                        }
                        if (specimenCategory != null && specimenCategory.equals(DOS)) {
                            Basisofrecord = "Preserved specimen";
                        }
                    }
                    Verbatimcoordinatesystem = "Decimal degrees";
                    Preparations = specimen.getPreservationMediumName();
                    /* Everything related with specimen identification */
                    Date Dateidentified;
                    String Identifiedby,Identificationqualifier;
                    Dateidentified = SEAOL.getIdentificationDate(sId);
                    Identifiedby = SEAOL.getIdentifiedBy(sId);
                    Identificationqualifier = SEAOL.getIdentificationqualifier(sId);
                    /* Now, everiting related with the taxonomy tree (taxon info from identification by specimenId) */
                    Long taxonId = SEAOL.getTaxonIdentificationId(sId);
                    String Scientificname = null,Kingdom = null,Phylum = null,Class1 = null,Orders = null,Family = null,Genus = null,Specificepithet = null,Infraspecificepithet = null;
                    BigInteger KingdomId = null,PhylumId = null,Class1Id = null,OrdersId = null,FamilyId = null,GenusId = null,SpecificepithetId = null,InfraspecificepithetId = null;
                    if(taxonId!=null){
                        if(!actualTaxon.equals(taxonId)){
                            actualAYofSN = taxonAuthorList(taxonId,2,SEAOL.getTaxonDescriptionYear(taxonId),SEAOL.getTaxonAuthorFormatParenthesis(taxonId));
                            actualTaxon = taxonId;
                        }
                        Scientificname = SEAOL.getTaxonDefaultName(taxonId);
                        Object[] kingdom = SEAOL.getTaxomonyIds(taxonId, 'a');
                        Object[] phylumDivision = SEAOL.getTaxomonyIds(taxonId, 'b');
                        Object[] classt = SEAOL.getTaxomonyIds(taxonId, 'c');
                        Object[] order = SEAOL.getTaxomonyIds(taxonId, 'd');
                        Object[] family = SEAOL.getTaxomonyIds(taxonId, 'e');
                        Object[] genus = SEAOL.getTaxomonyIds(taxonId, 'f');
                        Object[] species = SEAOL.getTaxomonyIds(taxonId, 'g');
                        Object[] subspecies = SEAOL.getTaxomonyIds(taxonId, 'h');
                        if(kingdom!=null){
                            KingdomId = BigInteger.valueOf((Long)kingdom[0]);
                            Kingdom = (String)kingdom[1];
                        }
                        if(phylumDivision!=null){
                            PhylumId = BigInteger.valueOf((Long)phylumDivision[0]);
                            Phylum = (String)phylumDivision[1];
                        }
                        if(classt!=null){
                            Class1Id = BigInteger.valueOf((Long)classt[0]);
                            Class1 = (String)classt[1];
                        }
                        if(order!=null){
                            OrdersId = BigInteger.valueOf((Long)order[0]);
                            Orders = (String)order[1];
                        }
                        if(family!=null){
                            FamilyId = BigInteger.valueOf((Long)family[0]);
                            Family = (String)family[1];
                        }
                        if(genus!=null){
                            GenusId = BigInteger.valueOf((Long)genus[0]);
                            Genus = (String)genus[1];
                        }
                        if(species!=null){
                            SpecificepithetId = BigInteger.valueOf((Long)species[0]);
                            Specificepithet = (String)species[1];
                        }
                        if(subspecies!=null){
                            InfraspecificepithetId = BigInteger.valueOf((Long)subspecies[0]);
                            Infraspecificepithet = (String)subspecies[1];
                        }
                    }
                    //Generate specimens based on life stage and sex
                    List<SpecimenLifeStageSex> LSSList = SEAOL.getSLsSListBySpecimen(sId); //Get a list of life stage and sex by specific specimen Id
                    int sequence = 1;
                    for(SpecimenLifeStageSex slssAux : LSSList){
                        int count = slssAux.getQuantity().intValue(); //How many specimens
                        String sex = slssAux.getSexName();
                        String lifeStage = slssAux.getLifeStageName();
                        String sexid = slssAux.getSex().getId().toString();
                        String lifestageid = slssAux.getLifeStage().getId().toString();
                        for(int a=0;a<count;a++){
                            DarwinCore14 newDwcEntry = new DarwinCore14(); //Create an instance of DarwinCore14 object
                            newDwcEntry.setGlobaluniqueidentifier(Globaluniqueidentifier+"_"+sexid+"_"+lifestageid+"_"+sequence);
                            newDwcEntry.setDatelastmodified(calendar.getTime());
                            //TODO:IstitutionCode
                            newDwcEntry.setCollectioncode(Collectioncode);
                            newDwcEntry.setCatalognumber(Catalognumber);
                            newDwcEntry.setCatalognumbernumeric(Catalognumbernumeric);
                            newDwcEntry.setCollectingmethod(Collectingmethod);
                            newDwcEntry.setCollectornumber(Collectornumber);
                            newDwcEntry.setDecimallongitude(Decimallongitude);
                            newDwcEntry.setVerbatimlongitude(Verbatimlongitude);
                            newDwcEntry.setDecimallatitude(Decimallatitude);
                            newDwcEntry.setVerbatimlatitude(Verbatimlatitude);
                            newDwcEntry.setGeodeticdatum(Geodeticdatum);
                            newDwcEntry.setGeoreferenceprotocol(Georeferenceprotocol);
                            newDwcEntry.setCoordinateuncertaintyinmeters(Coordinateuncertaintyinmeters);
                            newDwcEntry.setFieldnumber(Fieldnumber);
                            newDwcEntry.setCollector(Collector);
                            newDwcEntry.setEarliestdatecollected(Earliestdatecollected);
                            newDwcEntry.setLatestdatecollected(Latestdatecollected);
                            newDwcEntry.setVerbatimcollectingdate(Verbatimcollectingdate);
                            newDwcEntry.setMinimumelevationinmeters(Minimumelevationinmeters);
                            newDwcEntry.setMaximumelevationinmeters(Maximumelevationinmeters);
                            newDwcEntry.setMinimumdepthinmeters(Minimumdepthinmeters);
                            newDwcEntry.setMaximumdepthinmeters(Maximumdepthinmeters);
                            newDwcEntry.setBasisofrecord(Basisofrecord);
                            newDwcEntry.setVerbatimcoordinatesystem(Verbatimcoordinatesystem);
                            newDwcEntry.setSex(sex);
                            newDwcEntry.setLifestage(lifeStage);
                            newDwcEntry.setPreparations(Preparations);
                            newDwcEntry.setDateidentified(Dateidentified);
                            newDwcEntry.setIdentifiedby(Identifiedby);
                            newDwcEntry.setIdentificationqualifier(Identificationqualifier);
                            newDwcEntry.setAuthoryearofscientificname(actualAYofSN);
                            newDwcEntry.setScientificname(Scientificname);
                            newDwcEntry.setKingdomid(KingdomId);
                            newDwcEntry.setKingdom(Kingdom);
                            newDwcEntry.setPhylumId(PhylumId);
                            newDwcEntry.setPhylum(Phylum);
                            newDwcEntry.setClassId(Class1Id);
                            newDwcEntry.setClass1(Class1);
                            newDwcEntry.setOrdersId(OrdersId);
                            newDwcEntry.setOrders(Orders);
                            newDwcEntry.setFamilyId(FamilyId);
                            newDwcEntry.setFamily(Family);
                            newDwcEntry.setGenusId(GenusId);
                            newDwcEntry.setGenus(Genus);
                            newDwcEntry.setSpecificepithetId(SpecificepithetId);
                            newDwcEntry.setSpecificepithet(Specificepithet);
                            newDwcEntry.setInfraspecificepithetId(InfraspecificepithetId);
                            newDwcEntry.setInfraspecificepithet(Infraspecificepithet);
                            SEAOL.create(newDwcEntry); //Persist the new Darwin core entry
                            sequence+=1;
                        } //Iterate over lifestagesex quantity
                    } //Iterate over SpecimenLifeStageSex list
                }
            } //"for" ending, Iterate over Specimen

            /***********************************************************************************
             ******** If specimenCategory.id is equal to 4(Agrupados multitaxon)
             ***********************************************************************************/
            for(int i=0;i<specimenIdListAgruMultitax.size();i++){
                Long sId = specimenIdListAgruMultitax.get(i);
                Specimen specimen = (Specimen) SEAOL.findSpecimen(sId);
                if(specimen != null){
                    String Globaluniqueidentifier,IstitutionCode,Collectioncode,Catalognumber,Collectingmethod;
                    Globaluniqueidentifier = specimen.getCollection().getName()+":"+to_char(sId,"000000000000");
                    //TODO:IstitutionCode
                    Collectioncode = specimen.getCollection().getName();
                    Catalognumber = to_char(sId,"000000000000");
                    BigInteger Catalognumbernumeric = BigInteger.valueOf(sId);
                    Collectingmethod = specimen.getGatheringObservationMethodName();
                    String Collectornumber = null,Fieldnumber = null,Collector = null,Verbatimcollectingdate = null;
                    Date Earliestdatecollected = null,Latestdatecollected = null;
                    GatheringObservationDetail god = specimen.getGatheringObservationDetail();
                    if(god != null){
                        Collectornumber = god.getGatheringObservationDetailNumber();}
                    String Decimallongitude = null,Verbatimlongitude = null,Decimallatitude = null,Verbatimlatitude = null,Geodeticdatum = null;
                    String Coordinateuncertaintyinmeters = null,Georeferenceprotocol = null;
                    Double Minimumelevationinmeters = null,Maximumelevationinmeters = null,Minimumdepthinmeters = null,Maximumdepthinmeters = null;
                    GatheringObservation gat = specimen.getGatheringObservation();
                    if (gat != null) {
                        Site sit = gat.getSite();
                        if (sit != null) {
                            List<SiteCoordinate> scl = sit.getCoordinateList();
                            if (scl != null && scl.size() > 0) {
                                SiteCoordinate sitCoor = scl.get(0); //Get the first site coordinate
                                if (sitCoor.getLongitude() != null) {
                                    Decimallongitude = sitCoor.getLongitude().toString();
                                    Verbatimlongitude = to_char(sitCoor.getLongitude(), "#########.######");
                                }
                                if (sitCoor.getLatitude() != null) {
                                    Decimallatitude = sitCoor.getLatitude().toString();
                                    Verbatimlatitude = to_char(sitCoor.getLatitude(), "#########.######");
                                }
                            }
                            if(sit.getGeodeticDatum() != null){
                                Geodeticdatum = sit.getGeodeticDatum().toString();
                            }
                            SiteCalculationMethod scm = sit.getSiteCalculationMethod();
                            if(scm != null){
                                Georeferenceprotocol = scm.getName();
                            }
                            if(sit.getPrecision() != null){
                                Coordinateuncertaintyinmeters = sit.getPrecision().toString();
                            }
                        } //sit end
                        Fieldnumber = to_char(gat.getId(), "000000000000");
                        Collector = gat.getFirstCollectorObserverName();
                        Earliestdatecollected = gat.getInitialDate();
                        Latestdatecollected = gat.getFinalDate();
                        Verbatimcollectingdate = to_char_date(gat.getInitialDate(),"MMM dd, yyyy");
                        if(gat.getMinimumElevation() != null){
                            Minimumelevationinmeters = gat.getMinimumElevation().doubleValue();
                        }
                        if(gat.getMaximumElevation() != null){
                            Maximumelevationinmeters = gat.getMaximumElevation().doubleValue();
                        }
                        if(gat.getMinimumDepth() != null){
                            Minimumdepthinmeters = gat.getMinimumDepth().doubleValue();
                        }
                        if(gat.getMaximumDepth() != null){
                            Maximumdepthinmeters = gat.getMaximumDepth().doubleValue();
                        }
                    } //gat end
                    String Basisofrecord = null,Verbatimcoordinatesystem,Preparations;
                    if (specimen.getSpecimenCategory() != null) {
                        Long specimenCategory = specimen.getSpecimenCategory().getId();
                        if (specimenCategory != null && specimenCategory.equals(UNO)) {
                            Basisofrecord = "Observation";
                        }
                        if (specimenCategory != null && specimenCategory.equals(DOS)) {
                            Basisofrecord = "Preserved specimen";
                        }
                    }
                    Verbatimcoordinatesystem = "Decimal degrees";
                    Preparations = specimen.getPreservationMediumName();

                    //Iterate over specimen identification list
                    List<Identification> identificationsList = SEAOL.getIdentificationList(sId);
                    for(Identification identiAux : identificationsList){
                        DarwinCore14 newDwcEntry = new DarwinCore14(); //Create an instance of DarwinCore14 object
                        Long sequence = identiAux.getIdentificationPK().getIdentificationSequence();
                        /* ------ Set specimen info ------ */
                        newDwcEntry.setGlobaluniqueidentifier(Globaluniqueidentifier+"_"+sequence);
                        newDwcEntry.setDatelastmodified(calendar.getTime());
                        //TODO:IstitutionCode
                        newDwcEntry.setCollectioncode(Collectioncode);
                        newDwcEntry.setCatalognumber(Catalognumber);
                        newDwcEntry.setCatalognumbernumeric(Catalognumbernumeric);
                        newDwcEntry.setCollectingmethod(Collectingmethod);
                        newDwcEntry.setCollectornumber(Collectornumber);
                        newDwcEntry.setDecimallongitude(Decimallongitude);
                        newDwcEntry.setVerbatimlongitude(Verbatimlongitude);
                        newDwcEntry.setDecimallatitude(Decimallatitude);
                        newDwcEntry.setVerbatimlatitude(Verbatimlatitude);
                        newDwcEntry.setGeodeticdatum(Geodeticdatum);
                        newDwcEntry.setGeoreferenceprotocol(Georeferenceprotocol);
                        newDwcEntry.setCoordinateuncertaintyinmeters(Coordinateuncertaintyinmeters);
                        newDwcEntry.setFieldnumber(Fieldnumber);
                        newDwcEntry.setCollector(Collector);
                        newDwcEntry.setEarliestdatecollected(Earliestdatecollected);
                        newDwcEntry.setLatestdatecollected(Latestdatecollected);
                        newDwcEntry.setVerbatimcollectingdate(Verbatimcollectingdate);
                        newDwcEntry.setMinimumelevationinmeters(Minimumelevationinmeters);
                        newDwcEntry.setMaximumelevationinmeters(Maximumelevationinmeters);
                        newDwcEntry.setMinimumdepthinmeters(Minimumdepthinmeters);
                        newDwcEntry.setMaximumdepthinmeters(Maximumdepthinmeters);
                        newDwcEntry.setBasisofrecord(Basisofrecord);
                        newDwcEntry.setVerbatimcoordinatesystem(Verbatimcoordinatesystem);
                        newDwcEntry.setPreparations(Preparations);
                        /* ------ Set identification info (Depends on identification) ------*/
                        newDwcEntry.setDateidentified(identiAux.getIdentificationDate());
                        newDwcEntry.setIdentifiedby(identiAux.getIdentifierPersonName());
                        newDwcEntry.setIdentificationqualifier(identiAux.getIdentificationTypeName());
                        /* ------ Set taxonomy info (Depends on identification) ------*/
                        Long taxonId = SEAOL.getTaxonIdentificationIdAM(sId,sequence);
                        if(taxonId!=null){
                            newDwcEntry.setAuthoryearofscientificname(taxonAuthorList(taxonId,2,SEAOL.getTaxonDescriptionYear(taxonId),SEAOL.getTaxonAuthorFormatParenthesis(taxonId)));
                            newDwcEntry.setScientificname(SEAOL.getTaxonDefaultName(taxonId));
                            Object[] kingdom = SEAOL.getTaxomonyIds(taxonId, 'a');
                            Object[] phylumDivision = SEAOL.getTaxomonyIds(taxonId, 'b');
                            Object[] classt = SEAOL.getTaxomonyIds(taxonId, 'c');
                            Object[] order = SEAOL.getTaxomonyIds(taxonId, 'd');
                            Object[] family = SEAOL.getTaxomonyIds(taxonId, 'e');
                            Object[] genus = SEAOL.getTaxomonyIds(taxonId, 'f');
                            Object[] species = SEAOL.getTaxomonyIds(taxonId, 'g');
                            Object[] subspecies = SEAOL.getTaxomonyIds(taxonId, 'h');
                            if(kingdom!=null){
                                newDwcEntry.setKingdomid(BigInteger.valueOf((Long)kingdom[0]));
                                newDwcEntry.setKingdom((String)kingdom[1]);
                            }
                            if(phylumDivision!=null){
                                newDwcEntry.setPhylumId(BigInteger.valueOf((Long)phylumDivision[0]));
                                newDwcEntry.setPhylum((String)phylumDivision[1]);
                            }
                            if(classt!=null){
                                newDwcEntry.setClassId(BigInteger.valueOf((Long)classt[0]));
                                newDwcEntry.setClass1((String)classt[1]);
                            }
                            if(order!=null){
                                newDwcEntry.setOrdersId(BigInteger.valueOf((Long)order[0]));
                                newDwcEntry.setOrders((String)order[1]);
                            }
                            if(family!=null){
                                newDwcEntry.setFamilyId(BigInteger.valueOf((Long)family[0]));
                                newDwcEntry.setFamily((String)family[1]);
                            }
                            if(genus!=null){
                                newDwcEntry.setGenusId(BigInteger.valueOf((Long)genus[0]));
                                newDwcEntry.setGenus((String)genus[1]);
                            }
                            if(species!=null){
                                newDwcEntry.setSpecificepithetId(BigInteger.valueOf((Long)species[0]));
                                newDwcEntry.setSpecificepithet((String)species[1]);
                            }
                            if(subspecies!=null){
                                newDwcEntry.setInfraspecificepithetId(BigInteger.valueOf((Long)subspecies[0]));
                                newDwcEntry.setInfraspecificepithet((String)subspecies[1]);
                            }
                        }
                        /* ------ Persist the new entity ------ */
                        SEAOL.create(newDwcEntry);
                    } //identification "for" ending
                }
            } //"for" ending
            
        } //"try" ending
        catch(Exception e){return e.toString();}

        //If everything was ok, return success
        return "success";
    }

    /** Methot to get the sex (1) or lifestage (2) from specific speciem identifier
     * Just for individuals and observations
     * @param sId specimen identifier
     * @param type indicates if you want sex or lifestage from specimen
     * @return the sex or lifestage for the specified specimen
     */
    private String getSexOrLifeStage(Long sId, int type){
        List<SpecimenLifeStageSex> slssl = SEAOL.getSLsSListBySpecimen(sId);
        if (slssl.size() >= 1){
            SpecimenLifeStageSex slss = (SpecimenLifeStageSex)slssl.get(0);
            if(type == 1){
                return slss.getSexName();
            }
            else
                return  slss.getLifeStageName();
        }
        else
            return null;
    }

    /** Method to get the list of original and modifiers authors by taxon_id
     * @param tId it is the taxon identifier
     * @param form Here there are 2 posibilities -> 1 = without date at end adn 2 = with date at end
     * @param year it is the year of taxon identification
     * @param parentesis set if parentesis are needed 1 = needed and 0 = don't needed
     * @return a String with the list of authors
     */
    @Override
    public String taxonAuthorList(Long tId, int form, Long year,Long parentesis){
        List<TaxonAuthor> cursorOrig = SEAOL.getTaxonAuthorList(tId, "o");
        List<TaxonAuthor> cursorModif = SEAOL.getTaxonAuthorList(tId, "m");
        String nameTemp = ""; // for original authors
        String modifTemp = ""; //for modifiers
        if(year == null){
            year = CERO;
        }
        // Fill the nametemp String
        int count = 1;
        for(TaxonAuthor ta : cursorOrig){
            String conector = "";
            if(ta.getTaxonAuthorConnectorId() != null){conector = ta.getTaxonAuthorConnectorId().getName();}
            String author = "";
            if(ta.getTaxonAuthorPersonId() != null){author = ta.getTaxonAuthorPersonId().getNaturalShortName();}
            if (nameTemp.equals("")){
                nameTemp = conector+" "+author;
            }
            else if(count == 2 && conector.equals("")){ // 2 es el penultimo author
                nameTemp = author+" & "+nameTemp;
            }
            else if(conector.equals("")){
                nameTemp = author+", "+nameTemp;
            }
            else{
                nameTemp = author+" "+conector+" "+nameTemp;
            }
            count = count+1;
        }
        //Fill the modifTemp String
        count = 1;
        for(TaxonAuthor ta : cursorModif){
            String conector = "";
            if(ta.getTaxonAuthorConnectorId() != null){conector = ta.getTaxonAuthorConnectorId().getName();}
            String author = "";
            if(ta.getTaxonAuthorPersonId() != null){author = ta.getTaxonAuthorPersonId().getNaturalShortName();}
            if (modifTemp.equals("")){
                modifTemp = conector+" "+author;
            }
            else if(count == 2 && conector.equals("")){ // 2 es el penultimo
                modifTemp = author+" & "+modifTemp;
            }
            else if(conector.equals("")){
                modifTemp = author+", "+modifTemp;
            }
            else{
                modifTemp = author+" "+conector+" "+modifTemp;
            }
            count = count+1;
        }
        //Check if parentesis and year are needed
        if((parentesis == UNO || modifTemp.trim().length() > 0) && (nameTemp.trim().length() > 0)){
            if(form == 2 && year > CERO){
                nameTemp = "("+nameTemp.trim()+", "+year+")";
            }
            else
                nameTemp = "("+nameTemp.trim()+")";
        }
        else{
           if(form == 2 && year > CERO && nameTemp.trim().length() > 0){
               nameTemp = nameTemp+", "+year;
           }
        }
        //Concat the originals with modifiers
        return nameTemp.trim()+" "+modifTemp.trim();
    }

    //Implementation of to_char (Long) postgres function
    private String to_char(Object number, String format) {
        if(number != null){
            DecimalFormat df = new DecimalFormat(format);
            return df.format(number);
        }
        else return format;
    }

    //Implementation of to_char (Date) postgres function
    private String to_char_date(Date date, String format) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        }
        else return "";
    }

    /**
     * @return the SEAOL
     */
    public ShareEAOLocal getSEAOL() {
        return SEAOL;
    }

    /**
     * @param SEAOL the SEAOL to set
     */
    public void setSEAOL(ShareEAOLocal SEAOL) {
        this.SEAOL = SEAOL;
    }
 
}
