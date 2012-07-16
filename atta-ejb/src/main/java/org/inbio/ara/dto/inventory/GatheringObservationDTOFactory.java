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

package org.inbio.ara.dto.inventory;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.inbio.ara.dto.BaseDTOFactory;
import org.inbio.ara.dto.BaseEntityOrDTOFactory;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.persistence.collection.Collection;
import org.inbio.ara.persistence.gathering.CollectorObserver;
import org.inbio.ara.persistence.gathering.CollectorObserverPK;
import org.inbio.ara.persistence.gathering.GatheringObservation;
import org.inbio.ara.persistence.gathering.GatheringObservationCollection;
import org.inbio.ara.persistence.gathering.GatheringObservationCollectionPK;
import org.inbio.ara.persistence.gathering.GatheringObservationProject;
import org.inbio.ara.persistence.gathering.GatheringObservationProjectPK;
import org.inbio.ara.persistence.gathering.Project;
import org.inbio.ara.persistence.gis.GeographicLayerEntity;
import org.inbio.ara.persistence.gis.GeoreferencedSite;
import org.inbio.ara.persistence.gis.Site;
import org.inbio.ara.persistence.person.Person;

/**
 *
 * @author mvargas
 */
public class GatheringObservationDTOFactory extends BaseEntityOrDTOFactory<GatheringObservation, GatheringObservationDTO> {

    /**
     * Resive una DTO y lo canvierte en una entidad
     * @param gDTO
     * @return
     */
    public GatheringObservation createEntity(GatheringObservationDTO gDTO){
         if(gDTO == null)
            return null;

         GatheringObservation gEntity = new GatheringObservation();

         gEntity.setGatheringObservationId(gDTO.getGatheringObservationId());
         Site site = new Site();
         site.setSiteId(gDTO.getLocalityId());
         gEntity.setSite(site);
         gEntity.setInitialDate(gDTO.getInitialDateTime());
         gEntity.setFinalDate(gDTO.getFinalDateTime());
         gEntity.setResponsiblePersonId(gDTO.getResponsibleId());
         gEntity.setExpositionId(gDTO.getExpositionId());
         gEntity.setGradientPercentage(gDTO.getGradient());
         gEntity.setMaximumElevation(gDTO.getMaximumElevation());
         gEntity.setMinimumElevation(gDTO.getMinimumElevation());
         gEntity.setMaximumDepth(gDTO.getMaximumDepth());
         gEntity.setMinimumDepth(gDTO.getMinimumDepth());
         gEntity.setSurroundingsDescription(gDTO.getSurroundingDescription());
         gEntity.setSiteDescription(gDTO.getSiteDescription());
         gEntity.setCollectionId(gDTO.getCollectionId());

         /* Lista de colectores */
         List<PersonDTO> colectorDTOList = gDTO.getColectorsList();
         List<CollectorObserver> newList = new ArrayList();
         Long secuence = new Long(1);
         for(PersonDTO pDTO : colectorDTOList){
             CollectorObserverPK pk = new CollectorObserverPK(gDTO.getGatheringObservationId(), pDTO.getPersonKey());
             CollectorObserver newEntry = new CollectorObserver(pk);
             newEntry.setSequence(secuence);
             newList.add(newEntry);
             secuence++;
         }
         gEntity.setCollectorObserverList(newList);

         /* Lista de projectos */
         List<ProjectDTO> projectDTOList = gDTO.getProjectsList();
         List<GatheringObservationProject> newProjects = new ArrayList();
         for(ProjectDTO proDTO : projectDTOList){
             GatheringObservationProjectPK pk = new GatheringObservationProjectPK(gDTO.getGatheringObservationId(), proDTO.getProjectId());
             GatheringObservationProject newEntry = new GatheringObservationProject(pk);
             newProjects.add(newEntry);
         }
         gEntity.setGatheringProjectlist(newProjects);

         /* Lista de colecciones asociadas */
         List<CollectionDTO> collDTOList = gDTO.getCollectionsList();
         List<GatheringObservationCollection> newCollections = new ArrayList();
         for(CollectionDTO colDTO : collDTOList){
             GatheringObservationCollectionPK pk = new GatheringObservationCollectionPK(gDTO.getGatheringObservationId(), colDTO.getCollectionId());
             GatheringObservationCollection newEntry = new GatheringObservationCollection(pk);
             newCollections.add(newEntry);
         }
         gEntity.setGatheringCollectionList(newCollections);

         return gEntity;
    }

     /**
     * Resive una DTO y lo convierte en una entidad sin listas asociadas
     * @param gDTO
     * @return
     */
    public GatheringObservation createSimpleEntity(GatheringObservationDTO gDTO){
         if(gDTO == null)
            return null;

         GatheringObservation gEntity = new GatheringObservation();

         Site site = new Site();
         site.setSiteId(gDTO.getLocalityId());
         gEntity.setSite(site);
         gEntity.setInitialDate(gDTO.getInitialDateTime());
         gEntity.setFinalDate(gDTO.getFinalDateTime());
         gEntity.setResponsiblePersonId(gDTO.getResponsibleId());
         gEntity.setExpositionId(gDTO.getExpositionId());
         gEntity.setGradientPercentage(gDTO.getGradient());
         gEntity.setMaximumElevation(gDTO.getMaximumElevation());
         gEntity.setMinimumElevation(gDTO.getMinimumElevation());
         gEntity.setMaximumDepth(gDTO.getMaximumDepth());
         gEntity.setMinimumDepth(gDTO.getMinimumDepth());
         gEntity.setSurroundingsDescription(gDTO.getSurroundingDescription());
         gEntity.setSiteDescription(gDTO.getSiteDescription());
         gEntity.setCollectionId(gDTO.getCollectionId());
         
         return gEntity;
    }


    /**
     * Resive una entidad y la convierte en DTO
     * @param g es la entidad de recolecciones
     * @return un DTO de recolecciones
     */
    public GatheringObservationDTO createDTO(GatheringObservation g) {
         if(g == null)
            return null;

         GatheringObservationDTO gDTO = new GatheringObservationDTO();
         gDTO.setGatheringObservationId(g.getGatheringObservationId());

         Site site = g.getSite();
         if(site!=null){
            gDTO.setLocalityDescription(site.getDescription());
            gDTO.setCoordinates(site.getCoordinatesAsString());
            gDTO.setLocalityId(site.getSiteId());

            for(GeoreferencedSite gs : site.getGeoreferencedSites()){

                if(GeographicLayerEntity.COUNTRY.equals(gs.getGeoreferencedSitePK().getGeographicLayerId()))
                    gDTO.setCountryId(gs.getGeoreferencedSitePK().getGeographicSiteId());

                else if(GeographicLayerEntity.PROVINCE.equals(gs.getGeoreferencedSitePK().getGeographicLayerId()))
                    gDTO.setProvinceId(gs.getGeoreferencedSitePK().getGeographicSiteId());

            }
         }

         gDTO.setGradient(g.getGradientPercentage());
         gDTO.setMinimumElevation(g.getMinimumElevation());
         gDTO.setMaximumElevation(g.getMaximumElevation());
         gDTO.setMaximumDepth(g.getMaximumDepth());
         gDTO.setMinimumDepth(g.getMinimumDepth());

         Person responsiblePerson = g.getResponsiblePerson();
         if(responsiblePerson!=null){
            gDTO.setResponsibleName(responsiblePerson.getNaturalLongName());
            gDTO.setResponsibleId(responsiblePerson.getPersonId());
         }

         gDTO.setInitialDateTime(g.getInitialDate());
         gDTO.setFinalDateTime(g.getFinalDate());
         gDTO.setSiteDescription(g.getSiteDescription());
         gDTO.setSurroundingDescription(g.getSurroundingsDescription());
         gDTO.setCollectionId(g.getCollectionId());
         gDTO.setExpositionId(g.getExpositionId());

         /* Lista de colectores */
         List<CollectorObserver> colectores = g.getCollectorObserverList();
         List<PersonDTO> newColectores = new ArrayList();
         for(CollectorObserver aux : colectores){
             Person persona = aux.getPerson();
             PersonDTO newPersona = new PersonDTO();
             newPersona.setPersonKey(persona.getPersonId());
             newPersona.setNaturalLongName(persona.getNaturalLongName());
             newColectores.add(newPersona);
         }
         gDTO.setColectorsList(newColectores);

         /* Lista de proyectos */
         List<GatheringObservationProject> proyectos = g.getGatheringProjectList();
         List<ProjectDTO> newProyectos = new ArrayList();
         for(GatheringObservationProject aux : proyectos){
             Project proyecto = aux.getProject();
             ProjectDTO newProyecto = new ProjectDTO();
             newProyecto.setProjectId(proyecto.getProjectId());
             newProyecto.setDescription(proyecto.getDescription());
             newProyectos.add(newProyecto);
         }
         gDTO.setProjectsList(newProyectos);

         /* Lista de colecciones asociadas */
         List<GatheringObservationCollection> colecciones = g.getGatheringCollectionList();
         List<CollectionDTO> newColecciones = new ArrayList();
         for(GatheringObservationCollection aux : colecciones){
             Collection col = aux.getCollection();
             CollectionDTO newcol = new CollectionDTO();
             newcol.setCollectionId(col.getCollectionId());
             newcol.setCollectionName(col.getName());
             newColecciones.add(newcol);
         }
         gDTO.setCollectionsList(newColecciones);

        //seleted is used in the Graphical Interface, should be set in false
        gDTO.setSelected(false);

         return gDTO;
    }

    @Override
    public GatheringObservation getEntityWithPlainValues(GatheringObservationDTO gDTO) {
         if(gDTO == null)
            return null;

         GatheringObservation gEntity = new GatheringObservation();

         Site site = new Site();
         site.setSiteId(gDTO.getLocalityId());
         gEntity.setSite(site);
         gEntity.setInitialDate(gDTO.getInitialDateTime());
         gEntity.setFinalDate(gDTO.getFinalDateTime());
         gEntity.setResponsiblePersonId(gDTO.getResponsibleId());
         gEntity.setExpositionId(gDTO.getExpositionId());
         gEntity.setGradientPercentage(gDTO.getGradient());
         gEntity.setMaximumElevation(gDTO.getMaximumElevation());
         gEntity.setMinimumElevation(gDTO.getMinimumElevation());
         gEntity.setMaximumDepth(gDTO.getMaximumDepth());
         gEntity.setMinimumDepth(gDTO.getMinimumDepth());
         gEntity.setSurroundingsDescription(gDTO.getSurroundingDescription());
         gEntity.setSiteDescription(gDTO.getSiteDescription());
         gEntity.setCollectionId(gDTO.getCollectionId());

         System.out.println("desde dtoFactory "+gDTO.getUserName());
         
         return gEntity;
    }

    @Override
    public GatheringObservation updateEntityWithPlainValues(GatheringObservationDTO gDTO, GatheringObservation gEntity) {
        if(gDTO == null)
            return null;

         //GatheringObservation gEntity = new GatheringObservation();

         gEntity.setGatheringObservationId(gDTO.getGatheringObservationId());
         Site site = new Site();
         site.setSiteId(gDTO.getLocalityId());
         gEntity.setSite(site);
         gEntity.setInitialDate(gDTO.getInitialDateTime());
         gEntity.setFinalDate(gDTO.getFinalDateTime());
         gEntity.setResponsiblePersonId(gDTO.getResponsibleId());
         gEntity.setExpositionId(gDTO.getExpositionId());
         gEntity.setGradientPercentage(gDTO.getGradient());
         gEntity.setMaximumElevation(gDTO.getMaximumElevation());
         gEntity.setMinimumElevation(gDTO.getMinimumElevation());
         gEntity.setMaximumDepth(gDTO.getMaximumDepth());
         gEntity.setMinimumDepth(gDTO.getMinimumDepth());
         gEntity.setSurroundingsDescription(gDTO.getSurroundingDescription());
         gEntity.setSiteDescription(gDTO.getSiteDescription());
         gEntity.setCollectionId(gDTO.getCollectionId());

         /* Lista de colectores */
         List<PersonDTO> colectorDTOList = gDTO.getColectorsList();
         List<CollectorObserver> newList = new ArrayList();
         Long secuence = new Long(1);
         for(PersonDTO pDTO : colectorDTOList){
             CollectorObserverPK pk = new CollectorObserverPK(gDTO.getGatheringObservationId(), pDTO.getPersonKey());
             CollectorObserver newEntry = new CollectorObserver(pk);
             newEntry.setSequence(secuence);
             newList.add(newEntry);
             secuence++;
         }
         gEntity.setCollectorObserverList(newList);

         /* Lista de projectos */
         List<ProjectDTO> projectDTOList = gDTO.getProjectsList();
         List<GatheringObservationProject> newProjects = new ArrayList();
         for(ProjectDTO proDTO : projectDTOList){
             GatheringObservationProjectPK pk = new GatheringObservationProjectPK(gDTO.getGatheringObservationId(), proDTO.getProjectId());
             GatheringObservationProject newEntry = new GatheringObservationProject(pk);
             newProjects.add(newEntry);
         }
         gEntity.setGatheringProjectlist(newProjects);

         /* Lista de colecciones asociadas */
         List<CollectionDTO> collDTOList = gDTO.getCollectionsList();
         List<GatheringObservationCollection> newCollections = new ArrayList();
         for(CollectionDTO colDTO : collDTOList){
             GatheringObservationCollectionPK pk = new GatheringObservationCollectionPK(gDTO.getGatheringObservationId(), colDTO.getCollectionId());
             GatheringObservationCollection newEntry = new GatheringObservationCollection(pk);
             newCollections.add(newEntry);
         }
         gEntity.setGatheringCollectionList(newCollections);

         gEntity.setLastModificationBy(gDTO.getUserName());
         gEntity.setLastModificationDate(new GregorianCalendar());

         return gEntity;
    }
}
