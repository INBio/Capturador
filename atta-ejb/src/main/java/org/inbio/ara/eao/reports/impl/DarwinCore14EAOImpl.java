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

package org.inbio.ara.eao.reports.impl;

import java.util.LinkedList;
import java.util.List;
import org.inbio.ara.eao.reports.*;
import javax.ejb.Stateless;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.reports.DarwinCore14;
import org.inbio.ara.util.QueryNode;

/**
 *
 * @author esmata
 */
@Stateless
public class DarwinCore14EAOImpl extends BaseEAOImpl<DarwinCore14,String>
        implements DarwinCore14EAOLocal {

    /**
     * Metodo que realiza el snapshot darwin core primario, el cual será
     * utilizado para los reportes y para crear snapshots personalizados
     */
    public boolean reloadDarwinCoreTable(String dbSchema) {
        
        String creationString = "create table "+dbSchema+".DARWIN_CORE_1_4" +
                                "( GlobalUniqueIdentifier varchar," +
                                " DateLastModified timestamp," +
                                " InstitutionCode varchar," +
                                " CollectionCode varchar," +
                                " CatalogNumber varchar," +
                                " CatalogNumberNumeric  numeric," +
                                " ScientificName varchar," +
                                " BasisOfRecord varchar," +
                                " InformationWithheld varchar," +
                                " KingdomId numeric, " +
                                " Phylum_id numeric, " +
                                " Class_id numeric, " +
                                " Orders_id numeric, " +
                                " Family_id numeric, " +
                                " Genus_id numeric, " +
                                " SpecificEpithet_id numeric, " +
                                " InfraSpecificEpithet_id numeric," +
                                " HigherTaxon varchar," +
                                " Kingdom varchar," +
                                " Phylum varchar," +
                                " Class varchar," +
                                " Orders varchar," +
                                " Family varchar," +
                                " Genus varchar," +
                                " SpecificEpithet varchar, " +
                                " InfraSpecificEpithet varchar," +
                                " InfraspecificRank varchar," +
                                " AuthorYearOfScientificName varchar," +
                                " NomenclaturalCode varchar," +
                                " IdentificationQualifier varchar," +
                                " IdentifiedBy varchar," +
                                " DateIdentified timestamp, " +
                                " TypeStatus varchar," +
                                " CollectingMethod varchar," +
                                " ValidDistributionFlag varchar," +
                                " CollectorNumber varchar," +
                                " FieldNumber  varchar," +
                                " Collector varchar," +
                                " EarliestDateCollected timestamp," +
                                " LatestDateCollected timestamp," +
                                " VerbatimCollectingDate varchar," +
                                " DayOfYear numeric," +
                                " FieldNotes varchar," +
                                " HigherGeography varchar," +
                                " Continent varchar," +
                                " WaterBody varchar," +
                                " IslandGroup varchar," +
                                " Island varchar," +
                                " Country varchar," +
                                " StateProvince  varchar," +
                                " County varchar," +
                                " Locality varchar," +
                                " DecimalLongitude varchar," +
                                " VerbatimLongitude varchar," +
                                " DecimalLatitude varchar," +
                                " VerbatimLatitude varchar," +
                                " GeodeticDatum varchar," +
                                " VerbatimCoordinateSystem varchar," +
                                " GeoreferenceProtocol varchar," +
                                " CoordinateUncertaintyInMeters varchar," +
                                " GeoreferenceRemarks varchar," +
                                " FootprintWKT varchar," +
                                " MinimumElevationInMeters double precision," +
                                " MaximumElevationInMeters double precision," +
                                " VerbatimElevation double precision," +
                                " MinimumDepthInMeters double precision," +
                                " MaximumDepthInMeters double precision," +
                                " Sex varchar," +
                                " LifeStage varchar," +
                                " Preparations varchar," +
                                " IndividualCount numeric," +
                                " GenBankNum varchar," +
                                " OtherCatalogNumbers varchar," +
                                " RelatedCatalogItems varchar," +
                                " Remarks varchar," +
                                " Attributes  varchar," +
                                " ImageURL varchar," +
                                " RelatedInformation varchar," +
                                " Disposition varchar," +
                                " PointRadiusSpatialFit decimal," +
                                " FootprintSpatialFit  decimal," +
                                " VerbatimCoordinates varchar," +
                                " GeoreferenceSources varchar," +
                                " GeoreferenceVerificationStatus varchar," +
                                " PRIMARY KEY ( GlobalUniqueIdentifier));";

        String insertString = " insert into "+dbSchema+".DARWIN_CORE_1_4" +
                              " ( GlobalUniqueIdentifier," +
                                " DateLastModified ," +
                                " InstitutionCode," +
                                " CollectionCode," +
                                " CatalogNumber," +
                                " CatalogNumberNumeric ," +
                                " ScientificName," +
                                " BasisOfRecord," +
                                " InformationWithheld," +
                                " KingdomId," +
                                " Phylum_id ," +
                                " Class_id ," +
                                " Orders_id ," +
                                " Family_id ," +
                                " Genus_id," +
                                " SpecificEpithet_id ," +
                                " InfraSpecificEpithet_id ," +
                                " HigherTaxon," +
                                " Kingdom," +
                                " Phylum ," +
                                " Class ," +
                                " Orders," +
                                " Family ," +
                                " Genus," +
                                " SpecificEpithet ," +
                                " InfraSpecificEpithet," +
                                " InfraspecificRank ," +
                                " AuthorYearOfScientificName," +
                                " NomenclaturalCode," +
                                " IdentificationQualifier," +
                                " IdentifiedBy ," +
                                " DateIdentified ," +
                                " TypeStatus ," +
                                " CollectingMethod," +
                                " ValidDistributionFlag ," +
                                " CollectorNumber," +
                                " FieldNumber ," +
                                " Collector ," +
                                " EarliestDateCollected ," +
                                " LatestDateCollected ," +
                                " VerbatimCollectingDate  ," +
                                " DayOfYear ," +
                                " FieldNotes," +
                                " HigherGeography ," +
                                " Continent ," +
                                " WaterBody ," +
                                " IslandGroup ," +
                                " Island ," +
                                " Country," +
                                " StateProvince ," +
                                " County ," +
                                " Locality ," +
                                " DecimalLongitude ," +
                                " VerbatimLongitude ," +
                                " DecimalLatitude ," +
                                " VerbatimLatitude ," +
                                " GeodeticDatum ," +
                                " VerbatimCoordinateSystem," +
                                " GeoreferenceProtocol ," +
                                " CoordinateUncertaintyInMeters ," +
                                " GeoreferenceRemarks ," +
                                " FootprintWKT ," +
                                " MinimumElevationInMeters," +
                                " MaximumElevationInMeters ," +
                                " VerbatimElevation," +
                                " MinimumDepthInMeters ," +
                                " MaximumDepthInMeters ," +
                                " Sex," +
                                " LifeStage," +
                                " Preparations," +
                                " IndividualCount," +
                                " GenBankNum ," +
                                " OtherCatalogNumbers," +
                                " RelatedCatalogItems ," +
                                " Remarks," +
                                " Attributes," +
                                " ImageURL," +
                                " RelatedInformation," +
                                " Disposition," +
                                " PointRadiusSpatialFit," +
                                " FootprintSpatialFit," +
                                " VerbatimCoordinates," +
                                " GeoreferenceSources," +
                                " GeoreferenceVerificationStatus)" +
                                " select ins.INSTITUTION_CODE ||':' || col.name ||':' || s.CATALOG_NUMBER as GlobalUniqueIdentifier," +
                                  " current_date as DateLastModified," +
                                  " ins.INSTITUTION_CODE as InstitutionCode," +
                                  " col.name as CollectionCode ," +
                                  " s.CATALOG_NUMBER as CatalogNumber," +
                                  " null as CatalogNumberNumeric ," +
                                  " t.default_name as ScientificName," +
                                  " case specimen_category_id when 1 then 'HumanObservation' Else 'PreservedSpecimen' end as BasisOfRecord," +
                                  " null as InformationWithheld," +
                                  " r.taxon_id as KingdomId," +
                                  " fl.taxon_id as Phylum_id," +
                                  " c.taxon_id as Class_id," +
                                  " tor.taxon_id as Orders_id," +
                                  " tf.taxon_id as Family_id," +
                                  " g.taxon_id as Genus_id," +
                                  " sp.taxon_id as SpecificEpithet_id," +
                                  " subsp.taxon_id as InfraSpecificEpithet_id ," +
                                  " null as HigherTaxon," +
                                  " r.default_name as Kingdom," +
                                  " fl.default_name as Phylum," +
                                  " c.default_name as Class," +
                                  " tor.default_name as Orders," +
                                  " tf.default_name as Family," +
                                  " g.default_name as genus," +
                                  " sp.default_name as SpecificEpithet," +
                                  " subsp.default_name as InfraSpecificEpithet ," +
                                  " null as InfraspecificRank," +
                                  " null as AuthorYearOfScientificName," +
                                  " null as NomenclaturalCode," +
                                  " it.name as IdentificationQualifier," +
                                  " coalesce(rtrim(perid.FIRST_NAME), '') || ' '|| coalesce(rtrim(perid.initials), '') || ' '|| coalesce(rtrim(perid.last_name), '') as IdentifiedBy," +
                                  " i.identification_date as DateIdentified," +
                                  " null as TypeStatus," +
                                  " cm.name as CollectingMethod," +
                                  " null as ValidDistributionFlag," +
                                  " god.gathering_observation_detail_number as CollectorNumber," +
                                  " to_char(gat.gathering_observation_id, '00000000000000') as FieldNumber," +
                                  " coalesce(rtrim(percol.FIRST_NAME), '') || ' '|| coalesce(rtrim(percol.initials),'') || ' '|| coalesce(rtrim(percol.last_name),'')  as collector," +
                                  " gat.initial_date as  EarliestDateCollected," +
                                  " gat.final_DATE as  LatestDateCollected," +
                                  " to_char(gat.initial_date,'Mon DD, YYYY') as VerbatimCollectingDate," +
                                  " null as DayOfYear," +
                                  " null as FieldNotes," +
                                  " null as HigherGeography," +
                                  " null as Continent," +
                                  " null as WaterBody ," +
                                  " null as IslandGroup," +
                                  " null as Island," +
                                  " coun.value as Country," +
                                  " prov.value as StateProvince," +
                                  " null as County," +
                                  " sit.description as Locality," +
                                  " sitCoor.longitude as DecimalLongitude," +
                                  " to_char(sitCoor.Longitude, '999999999.999999') as VerbatimLongitude," +
                                  " sitCoor.latitude as DecimalLatitude," +
                                  " to_char(sitCoor.Latitude, '999999999.999999') as VerbatimLatitude," +
                                  " sit.geodetic_datum as GeodeticDatum," +
                                  " 'Decimal degrees' as VerbatimCoordinateSystem ," +
                                  " scm.name as GeoreferenceProtocol," +
                                  " to_char(sit.precision, '999999')  as CoordinateUncertaintyInMeters," +
                                  " null as georeferenceremarks," +
                                  " null as FootprintWKT," +
                                  " gat.minimum_elevation as MinimumElevationInMeters," +
                                  " gat.maximum_elevation as MaximumElevationInMeters," +
                                  " null as VerbatimElevation," +
                                  " gat.minimum_depth as MinimumDepthInMeters," +
                                  " gat.maximum_depth as MaximumDepthInMeters," +
                                  " null as Sex," +
                                  " null as LifeStage," +
                                  " pm.name as Preparations ," +
                                  " null as individualcount," +
                                  " null as GenBankNum," +
                                  " null as OtherCatalogNumbers," +
                                  " null as RelatedCatalogItems," +
                                  " null as Remarks," +
                                  " null as Attributes," +
                                  " null as ImageURL," +
                                  " null as RelatedInformation," +
                                  " null as Disposition," +
                                  " null as PointRadiusSpatialFit," +
                                  " null as FootprintSpatialFit," +
                                  " null as VerbatimCoordinates," +
                                  " null as GeoreferenceSources," +
                                  " null as GeoreferenceVerificationStatus" +
                               " from "+dbSchema+".specimen s left outer join "+dbSchema+".identification i on (s.specimen_id = i.specimen_id)" +
                                  " left outer join "+dbSchema+".taxon t on (t.taxon_id = i.taxon_id)" +
                                  " left outer join "+dbSchema+".taxon r on (r.taxon_id = t.kingdom_taxon_id)" +
                                  " left outer join "+dbSchema+".taxon fl on (fl.taxon_id = t.phylum_division_taxon_id)" +
                                  " left outer join "+dbSchema+".taxon c  on (c.taxon_id = t.class_taxon_id )" +
                                  " left outer join "+dbSchema+".taxon tor on (tor.taxon_id = t.order_taxon_id )" +
                                  " left outer join "+dbSchema+".taxon tf on (tf.taxon_id = t.family_taxon_id)" +
                                  " left outer join "+dbSchema+".taxon g on (g.taxon_id = t.genus_taxon_id)" +
                                  " left outer join "+dbSchema+".taxon sp on (sp.taxon_id = t.species_taxon_id)" +
                                  " left outer join "+dbSchema+".taxon subsp on (subsp.taxon_id = t.subspecies_taxon_id)" +
                                  " left outer join "+dbSchema+".gathering_observation_detail god on (s.GATHERING_OBSERVATION_DETAIL_ID =   god.GATHERING_OBSERVATION_DETAIL_ID)" +
                                  " left outer join "+dbSchema+".gathering_observation gat on (gat.gathering_observation_id = s.gathering_observation_id)" +
                                  " left outer join "+dbSchema+".collector_observer colObs on (colObs.gathering_observation_id = gat.gathering_observation_id and  colObs.SEQUENCE = 1)" +
                                  " left outer join "+dbSchema+".site sit on (sit.site_id = gat.site_id)" +
                                  " left outer join "+dbSchema+".georeferenced_site gsit on (gsit.site_id = sit.site_id and gsit.geographic_layer_id = 1)" +
                                  " left outer join "+dbSchema+".country coun on (coun.country_id = gsit.geographic_site_id and gsit.geographic_layer_id = 1)" +
                                  " left outer join "+dbSchema+".georeferenced_site gsitp on (gsitp.site_id = sit.site_id and gsitp.geographic_layer_id = 2)" +
                                  " left outer join "+dbSchema+".province prov on (prov.province_id = gsitp.geographic_site_id and gsitp.geographic_layer_id = 2)" +
                                  " left outer join "+dbSchema+".site_coordinate sitCoor on (sit.site_id = sitCoor.site_id and  sitCoor.SEQUENCE = 1)" +
                                  " left outer join "+dbSchema+".preservation_medium pm on (s.preservation_medium_id = pm.preservation_medium_id )" +
                                  " left outer join "+dbSchema+".collection col on (s.collection_id = col.collection_id )" +
                                  " left outer join "+dbSchema+".gathering_observation_method cm on (cm.gathering_observation_method_id = s.gathering_observation_method_id)" +
                                  " left outer join "+dbSchema+".person percol on (percol.person_id = colObs.collector_person_id)" +
                                  " left outer join "+dbSchema+".site_calculation_method scm on (sit.site_calculation_method_id = scm.site_calculation_method_id)" +
                                  " left outer join "+dbSchema+".identifier sid on (s.specimen_id = sid.specimen_id and sid.identification_sequence = 1 and sid.identifier_sequence = 1)" +
                                  " left outer join "+dbSchema+".person perid on (perid.person_id = sid.identifier_person_id)" +
                                  " left outer join "+dbSchema+".identification_type it on (i.identification_type_id = it.identification_type_id)" +
                                  " left outer join "+dbSchema+".institution ins on (ins.institution_id = s.institution_id)";
                                 //+" where specimen_category_id <> 4;";
        System.out.println("Se crearon todos los String");
        try{

            Query q1 = em.createNativeQuery("drop table "+dbSchema+".darwin_core_1_4;");
            System.out.println(q1.executeUpdate() + " drop dwc1_4");
        }
        catch(Exception e){
            System.err.print(e);
            System.out.println("Error al borrar la tabla darwin_core_1_4;");
            return false;}
        try{
            Query q2 = em.createNativeQuery(creationString);
            System.out.println(q2.executeUpdate() + " create dwc1_4");
        }
        catch(Exception e){
            System.out.println("Error al crear la tabla darwin_core_1_4;");
            return false;}
        try{
            Query q3 = em.createNativeQuery(insertString);
            System.out.println(q3.executeUpdate() + " inserts dwc1_4");
        }
        catch(Exception e)
        {System.out.println(e.getCause());
         System.out.println("Error al insertar datos en la tabla darwin_core_1_4;");
         return false;}
        return true;

    }

    /**
     * @param jpqlQuery is the query
     * @return the quantity of elements that match with the query
     */
    public Long countQueryElements(String jpqlQuery){
        try{
            Query q = em.createQuery(jpqlQuery);
            Long ret = (Long) q.getSingleResult();
            return ret;
        }
        catch(Exception e){return new Long(0);}
    }

    public List findAllDwCPaginated(int first, int amount) {
        try{
            Query q = em.createQuery("from DarwinCore14 as o");
            q.setFirstResult(first);
            q.setMaxResults(amount);
            List ret = (List) q.getResultList();
            return ret;
        }
        catch(Exception e){return null;}
    }

     public List makePaginatedQuery(LinkedList<QueryNode> sll, int first, int amount) {
        String jpqlQuery = "from DarwinCore14 as o where ";

        //Mandatory
        QueryNode qn = sll.getFirst();
        jpqlQuery += "lower(o." + qn.getDwcElement() + ")";
        jpqlQuery += " " + qn.getComparator() + " ";
        if (qn.getComparator().equals("like")) {
            jpqlQuery += "'%" + qn.getUserEntry().toLowerCase() + "%'";
        } else {
            jpqlQuery += "'" + qn.getUserEntry().toLowerCase() + "'";
        }

        //Optional
        for (int i = 1; i < sll.size(); i++) {
            qn = sll.get(i);
            jpqlQuery += " " + qn.getLogicalOperator() + " ";
            jpqlQuery += "lower(o." + qn.getDwcElement() + ")";
            jpqlQuery += " " + qn.getComparator() + " ";
            if (qn.getComparator().equals("like")) {
                jpqlQuery += "'%" + qn.getUserEntry().toLowerCase() + "%'";
            } else {
                jpqlQuery += "'" + qn.getUserEntry().toLowerCase() + "'";
            }
        }

        jpqlQuery += " order by o.globaluniqueidentifier ";

        try{
            Query q = em.createQuery(jpqlQuery);
            q.setFirstResult(first);
            q.setMaxResults(amount);
            List elements = (List) q.getResultList();
            return elements;
        }
        catch(Exception e){return null;}
    }

    /**
     * To get the number of DarwinCore14 entities that exists on data base
     * @return an int that represent tha quantity of DarwinCore14 entities
     */
    public Long findTotalDwc() {
        em.setFlushMode(FlushModeType.COMMIT);
        Query query = em.createQuery ("SELECT COUNT (dwc) FROM DarwinCore14 dwc");
        Long num = (Long)query.getSingleResult();
        em.setFlushMode(FlushModeType.AUTO);
        return num;
    }
}
