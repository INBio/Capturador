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

import org.inbio.ara.eao.reports.*;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.inbio.ara.eao.BaseEAOImpl;
import org.inbio.ara.persistence.reports.PlinianCoreFlat;

/**
 *
 * @author esmata
 */
@Stateless
public class PlinianCoreFlatEAOImpl extends BaseEAOImpl<PlinianCoreFlat,String>
        implements PlinianCoreFlatEAOLocal {
    
    /**
     * Metodo que realiza el snapshot plinian core primario, el cual será
     * utilizado para los reportes y para crear snapshots personalizados
     */
    public boolean reloadPlinianCoreTable() {
    String creationString =   "Create table ara.plinian_core_flat"+
                   "(GlobalUniqueIdentifier varchar,"+
                    "ScientificName varchar,"+
                    "InstitutionCode varchar,"+
                    "DateLastModified timestamp,"+
                    "TaxonRecordID varchar,"+
                    "Language varchar,"+
                    "Creators  varchar,"+
                    "Distribution varchar,"+
                    "Abstract varchar,"+
                    "KingdomTaxon varchar,"+
                    "PhylumTaxon varchar,"+
                    "ClassTaxon varchar,"+
                    "OrderTaxon varchar,"+
                    "FamilyTaxon varchar,"+
                    "GenusTaxon varchar,"+
                    "Synonyms varchar,"+
                    "AuthorYearOfScientificName varchar,"+
                    "SpeciesPublicationReference varchar,"+
                    "CommonNames varchar,"+
                    "Typification varchar,"+
                    "Contributors varchar,"+
                    "DateCreated timestamp, "+
                    "Habit varchar,"+
                    "LifeCycle varchar,"+
                    "Reproduction varchar,"+
                    "AnnualCycle varchar,"+
                    "ScientificDescription varchar,"+
                    "BriefDescription varchar,"+
                    "Feeding varchar,"+
                    "Behavior varchar,"+
                    "Interactions varchar,"+
                    "ChromosomicNumberN varchar,"+
                    "MolecularData varchar,"+
                    "PopulationBiology varchar,"+
                    "ThreatStatus varchar,"+
                    "Legislation varchar,"+
                    "Habitat varchar,"+
                    "Territory varchar,"+
                    "Endemicity varchar,"+
                    "TheUses varchar,"+
                    "TheManagement varchar,"+
                    "Folklore varchar,"+
                    "TheReferences varchar,"+
                    "UnstructuredDocumentation varchar,"+
                    "OtherInformationSources varchar,"+
                    "Papers varchar,"+
                    "IdentificationKeys varchar,"+
                    "MigratoryData varchar,"+
                    "EcologicalSignificance varchar,"+
                    "UnstructuredNaturalHistory varchar,"+
                    "InvasivenessData  varchar,"+
                    "TargetAudiences  varchar,"+
                    "Version  varchar,"+
                    "URLImage1  varchar,"+
                    "CaptionImage1  varchar,"+
                    "URLImage2  varchar,"+
                    "CaptionImage2  varchar,"+
                    "URLImage3  varchar,"+
                    "CaptionImage3  varchar,"+
                    "PRIMARY KEY ( GlobalUniqueIdentifier));";

    String insertString =     "Insert into  ara.plinian_core_flat"+
                      "(GlobalUniqueIdentifier,"+
                       "ScientificName,"+
                       "InstitutionCode,"+
                       "DateLastModified ,"+
                       "TaxonRecordID ,"+
                       "Language,"+
                       "Creators ,"+
                       "Distribution,"+
                       "Abstract,"+
                       "KingdomTaxon,"+
                       "PhylumTaxon,"+
                       "ClassTaxon,"+
                       "OrderTaxon,"+
                       "FamilyTaxon,"+
                       "GenusTaxon,"+
                       "Synonyms,"+
                       "AuthorYearOfScientificName,"+
                       "SpeciesPublicationReference,"+
                       "CommonNames,"+
                       "Typification,"+
                       "Contributors,"+
                       "DateCreated, "+
                       "Habit,"+
                       "LifeCycle,"+
                       "Reproduction,"+
                       "AnnualCycle,"+
                       "ScientificDescription,"+
                       "BriefDescription,"+
                       "Feeding,"+
                       "Behavior,"+
                       "Interactions,"+
                       "ChromosomicNumberN,"+
                       "MolecularData,"+
                       "PopulationBiology,"+
                       "ThreatStatus,"+
                       "Legislation,"+
                       "Habitat,"+
                       "Territory ,"+
                       "Endemicity,"+
                       "TheUses,"+
                       "TheManagement,"+
                       "Folklore,"+
                       "TheReferences,"+
                       "UnstructuredDocumentation,"+
                       "OtherInformationSources,"+
                       "Papers,"+
                       "IdentificationKeys,"+
                       "MigratoryData,"+
                       "EcologicalSignificance,"+
                       "UnstructuredNaturalHistory ,"+
                       "InvasivenessData ,"+
                       "TargetAudiences ,"+
                       "Version ,"+
                       "URLImage1,"+
                       "CaptionImage1,"+
                       "URLImage2 ,"+
                       "CaptionImage2  ,"+
                       "URLImage3  ,"+
                       "CaptionImage3 )"+
                      "select  to_char(td.taxon_id, '000000000000') || ':' || coalesce(rtrim(i.INSTITUTION_CODE), '') || ':' ||  to_char(td.taxon_description_sequence, '000000') as GlobalUniqueIdentifier,"+
                         "t.default_name as ScientificName,"+
                         "i.INSTITUTION_CODE as InstitutionCode,"+
                         "td.last_modification_date as DateLastModified,"+
                         "t.taxon_id as TaxonRecordID,"+
                         "cp.name as Language,"+
                         "ara.species_record_person(td.taxon_id, td.taxon_description_sequence,', ') as Creators,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Distribution', 0, ' ') as distribution, "+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Abstract', 0, '')  as Abstract,"+
                         "r.default_name as Kingdom,"+
                         "fl.default_name as Phylum,"+
                         "c.default_name as Class, "+
                         "tor.default_name as OrderRank,"+
                         "tf.default_name as Family,"+
                         "g.default_name as genus,"+
                         "'' as Synonyms,"+
                         "'' as AuthorYearOfScientificName,"+
                         "'' as SpeciesPublicationReference,"+
                         "ara.taxon_nomenclatural_group_list(td.taxon_id, '; ') as CommonNames,"+
                         "'' as Typification,"+
                         "'' as Contributors,"+
                         "null as DateCreated,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Habit', 0, '') as Habit,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'LifeCycle', 0, '') as LifeCycle,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Reproduction', 0, '') as Reproduction,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'AnnualCycle', 0, '') as AnnualCycle,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'ScientificDescription', 0, '') as ScientificDescription,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'BriefDescription', 0, '') as BriefDescription,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Feeding', 0, '')  as Feeding ,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Behavior', 0, '') as Behavior,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Interactions', 1, '. ') as Interactions,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'ChromosomicNumberN', 0, '') as ChromosomicNumberN,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'MolecularData', 0, '') as MolecularData,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'PopulationBiology', 0, '') as PopulationBiology,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'ThreatStatus', 1, ' ') as ThreatStatus,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Legislation', 1, ' ') as Legislation,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Habitat', 0, '') as Habitat,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Territory', 0, '') as Territory,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Endemicity', 1, ' ') as Endemicity  ,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Uses', 0, '') as theUses,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Management', 0, '') as theManagement,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Folkclore', 0, '') as Folklore,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'References', 0, '. '),"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'UnstructuredDocumentation', 0, ' ') as UnstructuredDocumentation,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'OtherInformationSources', 0, ' ') as OtherInformationSources,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'Papers', 0, ' ') as Papers,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'IdentificationKeys', 0, ' ')  as IdentificationKeys,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'MigratoryData', 0, ' ') as MigratoryData,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'EcologicalSignificance', 0, ' ') as EcologicalSignificance,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'UnstructuredNaturalHistory', 0, ' ') as  UnstructuredNaturalHistory,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'InvasivenessData', 0, ' ') as InvasivenessData,"+
                         "ara.taxon_description_audience_list(td.taxon_id, td.taxon_description_sequence ,'; ')  as TargetAudiences,"+
                         "td.taxon_description_sequence as Version ,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'URLImage1', 0, '') as URLImage1,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'CaptionImage1', 0, '') as CaptionImage1,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'URLImage2', 0, '') as URLImage2 ,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'CaptionImage2', 0, '') as CaptionImage2  ,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'URLImage3', 0, '') as URLImage3  ,"+
                         "ara.species_standard_element_content(td.taxon_id, td.taxon_description_sequence, 'CaptionImage3', 0, '') as CaptionImage3 "+
                      "from ara.taxon_description td "+
                        "left outer join ara.taxon t on (t.taxon_id = td.taxon_id)"+
                        "left outer join ara.language l on (l.language_id = td.language_id) "+
                        "left outer join ara.concept cp on (l.language_id = cp.concept_id)  "+
                        "left outer join ara.taxon r on (r.taxon_id = t.kingdom_taxon_id)"+
                        "left outer join ara.taxon fl on (fl.taxon_id = t.phylum_division_taxon_id)"+
                        "left outer join ara.taxon c  on (c.taxon_id = t.class_taxon_id )"+
                        "left outer join ara.taxon tor on (tor.taxon_id = t.order_taxon_id ) "+
                        "left outer join ara.taxon tf on (tf.taxon_id = t.family_taxon_id)"+
                        "left outer join ara.taxon g on (g.taxon_id = t.genus_taxon_id)"+
                        "left outer join ara.taxon s on (s.taxon_id = t.genus_taxon_id)"+
                        "left outer join ara.institution i on (td.institution_id = i.institution_id);";
        try{
            Query q1 = em.createNativeQuery("drop table ara.plinian_core_flat;");
            System.out.println(q1.executeUpdate() + " drop plinian_core_flat");
        }
        catch(Exception e){return false;}
        try{
            Query q2 = em.createNativeQuery(creationString);
            System.out.println(q2.executeUpdate() + " create plinian_core_flat");
        }
        catch(Exception e){return false;}
        try{
            Query q3 = em.createNativeQuery(insertString);
            System.out.println(q3.executeUpdate() + " inserts plinian_core_flat");
        }
        catch(Exception e){System.out.println(e.getCause());return false;}
        return true;

    }
 
}
