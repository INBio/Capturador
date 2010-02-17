/*
 *  Ara - Capture Species and Specimen Data
 *
 * Copyright © 2009  INBio (Instituto Nacional de Biodiversidad).
 * Heredia, Costa Rica.
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

package org.inbio.ara.dto.inventory;

import java.util.ArrayList;
import java.util.List;
import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.ExtractionType;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationMethod;
import org.inbio.ara.persistence.gis.GeographicLayerEntity;
import org.inbio.ara.persistence.gis.GeoreferencedSite;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.institution.Institution;
import org.inbio.ara.persistence.person.Person;
import org.inbio.ara.persistence.specimen.Origin;
import org.inbio.ara.persistence.specimen.PreservationMedium;
import org.inbio.ara.persistence.specimen.Specimen;
import org.inbio.ara.persistence.specimen.SpecimenCategory;
import org.inbio.ara.persistence.specimen.SpecimenLifeStageSex;
import org.inbio.ara.persistence.specimen.SpecimenType;
import org.inbio.ara.persistence.specimen.StorageType;
import org.inbio.ara.persistence.specimen.Substrate;

/**
 *
 * @author jgutierrez
 */
public class SpecimenDTOFactory extends BaseDTOFactory<Specimen,SpecimenDTO> {

    /**
     * 
     * @param s
     * @return
     */
    public SpecimenDTO createDTO(Specimen s) {
         if(s == null)
            return null;

         Institution institution = s.getInstitution();
         Collection collection = s.getCollection();
         GatheringObservation gatheringObservation = s.getGatheringObservation();
         GatheringObservationMethod gatheringObservationMethod = s.getGatheringObservationMethod();
         ExtractionType extractionType = s.getExtractionType();
         Origin origin = s.getOrigin();
         StorageType storageType = s.getStorageType();
         SpecimenCategory specimenCategory = s.getSpecimenCategory();
         SpecimenType specimenType = s.getSpecimenType();
         PreservationMedium preservationMedium = s.getPreservationMedium();
//         Taxon taxon = s.getTaxon();
         Substrate substrate = s.getSubstrate();

         Person responsiblePerson=null;
         Site site = null;
         if(gatheringObservation!=null){
            site = gatheringObservation.getSite();
            responsiblePerson = gatheringObservation.getResponsiblePerson();
         }
         

         SpecimenDTO sDTO = new SpecimenDTO();
         //seleted is used in the Graphical Interface, should be set in false
         sDTO.setSelected(false);
         sDTO.setSpecimenKey(s.getSpecimenId());
         sDTO.setCatalogNumber(s.getCatalogNumber());
       
         //discarded
        if(s.getDiscarded()==0)
            sDTO.setDiscarded(false);
         else //s.getDiscarded()==1
            sDTO.setDiscarded(true);

         if(institution!=null){
             sDTO.setInstitutionCode(s.getInstitution().getInstitutionCode());
             sDTO.setInstitutionId(s.getInstitution().getInstitutionId());
         }
         if(collection!=null){
            sDTO.setCollectionName(collection.getName());
            sDTO.setCollectionId(collection.getCollectionId());
         }

//         if(taxon!=null){
//             sDTO.setTaxonId(taxon.getTaxonId());
//             sDTO.setTaxonName(taxon.getDefaultName());
//         }


         if(site!=null){
            sDTO.setLocalityDescription(site.getDescription());
            sDTO.setCoordinates(site.getCoordinatesAsString());

            for(GeoreferencedSite gs : site.getGeoreferencedSites()){

                if(GeographicLayerEntity.COUNTRY.equals(gs.getGeoreferencedSitePK().getGeographicLayerId()))
                    sDTO.setCountryId(gs.getGeoreferencedSitePK().getGeographicSiteId());

                else if(GeographicLayerEntity.PROVINCE.equals(gs.getGeoreferencedSitePK().getGeographicLayerId()))
                    sDTO.setProvinceId(gs.getGeoreferencedSitePK().getGeographicSiteId());
                
            }
         }
         

         if(responsiblePerson!=null){
            sDTO.setResponsibleName(responsiblePerson.getNaturalLongName());
            sDTO.setResponsibleId(responsiblePerson.getPersonId());
         }

         if(gatheringObservation!=null){
            sDTO.setGatheringObsevationId(gatheringObservation.getGatheringObservationId());
         }

         sDTO.setNumberWhole(s.getNumberWhole());
         sDTO.setNumberFragments(s.getNumberFragments());

         if(extractionType!=null){
            sDTO.setExtractionTypeName(extractionType.getName());
            sDTO.setExtractionTypeId(extractionType.getExtractionTypeId());
         }

         if(gatheringObservationMethod!=null){
             sDTO.setGatheringMethodName(gatheringObservationMethod.getName());
             sDTO.setGatheringMethodId(gatheringObservationMethod.getGatheringObservationMethodId());
         }

         if(origin!=null){
             sDTO.setOriginName(origin.getName());
             sDTO.setOriginId(origin.getOriginId());
         }

         if(storageType!=null){
             sDTO.setStorageTypeId(storageType.getStorageTypeId());
             sDTO.setStorageTypeName(storageType.getName());
         }

         if(specimenCategory!=null){
             sDTO.setCategoryId(specimenCategory.getSpecimenCategoryId());
             sDTO.setCategoryName(specimenCategory.getName());
         }

         if(specimenType!=null){
             sDTO.setTypeId(specimenType.getSpecimenTypeId());
             sDTO.setTypeName(specimenType.getName());
         }

         if(preservationMedium!=null){
             sDTO.setPreservationMediumId(preservationMedium.getPreservationMediumId());
             sDTO.setPreservationMediumName(preservationMedium.getName());
         }

         if(substrate!=null){
             sDTO.setSubstrateId(substrate.getId());
             sDTO.setSubstrateName(substrate.getName());
         }

         sDTO.setGatheringObservationDetailId(s.getGatheringObservationDetailId());

         List<LifeStageSexDTO> lssDTOList = new ArrayList<LifeStageSexDTO>();
         SelectionListDTO lifeStageDTO;
         SelectionListDTO sexDTO;
         for(SpecimenLifeStageSex slss : s.getSpecimenLifeStageSexList()){
             if(slss.getLifeStage()!=null && slss.getSex()!=null){
                 lifeStageDTO = new SelectionListDTO(slss.getLifeStage().getSelectionListEntity().getId(), slss.getLifeStage().getId(), slss.getLifeStage().getName(),slss.getLifeStage().getDescription());
                 sexDTO = new SelectionListDTO(slss.getSex().getSelectionListEntity().getId(), slss.getSex().getId(), slss.getSex().getName(), slss.getSex().getDescription());
                 lssDTOList.add(new LifeStageSexDTO(lifeStageDTO, sexDTO, slss.getQuantity()));
             }
         }
         sDTO.setLifeStageSexList(lssDTOList);

         
         return sDTO;
    }



}
