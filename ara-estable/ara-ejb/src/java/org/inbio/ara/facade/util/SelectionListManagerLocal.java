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

package org.inbio.ara.facade.util;

import com.sun.webui.jsf.model.Option;
import javax.ejb.Local;
import org.inbio.ara.persistence.selectionListEntity;
import org.inbio.ara.persistence.taxonomy.TaxonDescriptionPK;


/**
 * This is the business interface for SelectionListManager enterprise bean.
 */
@Local
public interface SelectionListManagerLocal {
    com.sun.webui.jsf.model.Option[] getAudience();

    java.lang.Long[] getSelectedAudience(TaxonDescriptionPK pk);

    com.sun.webui.jsf.model.Option[] getSpeciesAuthor();

    java.lang.Long[] getSpeciesAuthor(TaxonDescriptionPK pk);

    com.sun.webui.jsf.model.Option[] getSpeciesInstitution();

    java.lang.Long[] getSpeciesInstitution(TaxonDescriptionPK pk);
    
    com.sun.webui.jsf.model.Option[] getSpeciesStages(TaxonDescriptionPK pk);

    com.sun.webui.jsf.model.Option[] getLanguage();

    org.inbio.ara.persistence.util.Language getLanguage(Long id);

    org.inbio.ara.persistence.species.TaxonDescriptionStage getTaxonDescriptionStage(Long id);

    com.sun.webui.jsf.model.Option[] getAvailableStages(Long stageId);

    com.sun.webui.jsf.model.Option[] getReferenceType();

    org.inbio.ara.persistence.reference.ReferenceType getReferenceType(Long id);

    org.inbio.ara.persistence.species.Audience getAudience(Long id);
    
    org.inbio.ara.persistence.person.Person getPerson(Long id);

    org.inbio.ara.persistence.institution.Institution getInstitution(Long id);

    com.sun.webui.jsf.model.Option[] getReference();

    java.lang.Long[] getTaxonDescriptionRecordReference(Long taxonDescriptionRecordId);

    com.sun.webui.jsf.model.Option[] getSpecies();

    org.inbio.ara.persistence.taxonomy.Taxon getTaxon(Long id);

    com.sun.webui.jsf.model.Option[] getInstitution();

    com.sun.webui.jsf.model.Option[] getProfile();

    java.lang.Long[] getPersonProfile(Long personId);

    java.lang.Long[] getPersonInstitution(Long personId);

    com.sun.webui.jsf.model.Option[] getUserTaxonList(Long userId);

    com.sun.webui.jsf.model.Option[] getNomenclaturalGroupList(Long userId);

    org.inbio.ara.persistence.collection.Collection getCollectionByTaxonId(Long taxonId);

    org.inbio.ara.persistence.collection.Collection getCollectionByNomenclaturalGroupId(Long nomenclaturalGroupId);

    com.sun.webui.jsf.model.Option[] getSites();

    com.sun.webui.jsf.model.Option[] getExposition();

    /**
     * Ejemplo de uso: getOptions(Substrate.class)
     * Author: hesquivel
     * 
     * @return Option[] Objetos option de jsf para llenar los dropDown
     *         null si no encuentra nada.
     * @params clazz Objeto de tipo java.lang.Class
     */
    <T extends selectionListEntity> com.sun.webui.jsf.model.Option[] getOptions(Class<T> clazz);

    /**
     * hesquivel
     * Retorna un arreglo que contiene solamente las opciones que se deben 
     * mostrar segun el <b>protocolo de coleccion.</b>
     * Ej. de uso: getOptionsByCollection(SpecimenType.class, 1L)
     * 
     * @param clazz Clase (java.lang.Class) de objetos de los cuales se desea
     *        obtener las opciones disponibles.
     * @param collectionId Numero que identifica la coleccion sobre la cual se
     *        esta trabajando
     * @return com.sun.webui.jsf.model.Option[] Opciones que se le pasan a los 
     *         componentes graficos de JSF para que los muestre (comunmente
     *         DropDowns).
     */
    <T extends selectionListEntity> Option[] getOptionsByCollection(Class<T> clazz, Long collectionId);

    org.inbio.ara.persistence.specimen.SpecimenCategory getSpecimenCategoryById(Long id);

    org.inbio.ara.persistence.specimen.SpecimenType getSpecimenTypeById(Long id);

    org.inbio.ara.persistence.specimen.StorageType getStorageTypeById(Long id);

    org.inbio.ara.persistence.specimen.Substrate getSubstrateById(Long id);

    org.inbio.ara.persistence.specimen.Origin getOriginById(Long id);

    org.inbio.ara.persistence.specimen.PreservationMedium getPreservationMediumById(Long id);

    org.inbio.ara.persistence.specimen.LifeForm getLifeFormById(Long id);

    org.inbio.ara.persistence.gathering.GatheringObservationMethod getGatheringObservationMethodbyId(Long id);

    org.inbio.ara.persistence.specimen.ExtractionType getExtractionById(Long id);

    com.sun.webui.jsf.model.Option[] getTaxonHierarchy(Long taxonId);

    org.inbio.ara.persistence.gis.Site getSite(Long id);

    org.inbio.ara.persistence.gathering.Exposition getExpositionById(Long id);

    java.lang.Long[] getSelectedCollectors(Long gatheringObservationId);

    java.lang.Long[] getSelectedCollections(Long gatheringObservationId);

    java.lang.Long[] getSelectedProjects(Long gatheringObservationId);

    com.sun.webui.jsf.model.Option[] getGatheringResponsible();

    com.sun.webui.jsf.model.Option[] getProjects();

    com.sun.webui.jsf.model.Option[] getCollections();

    org.inbio.ara.persistence.specimen.Sex getSexById(Long id);

    org.inbio.ara.persistence.specimen.LifeStage getLifeStageById(Long id);

    com.sun.webui.jsf.model.Option[] getExtractionType(Long collectionId);

    com.sun.webui.jsf.model.Option[] getIdentificationStatus();

    com.sun.webui.jsf.model.Option[] getIdentifiers();

    com.sun.webui.jsf.model.Option[] getIdentificationValidator();

    com.sun.webui.jsf.model.Option[] getIdentificationType(Long collectionId);

    com.sun.webui.jsf.model.Option[] getFilteredTaxonList(Long taxonomicalRangeId, Long taxonCategoryId, Long ancestorId, Long ancestorTaxonomicalRangeId);

    com.sun.webui.jsf.model.Option[] getTaxonCategory();

    com.sun.webui.jsf.model.Option[] getTaxonomicalRange();

    com.sun.webui.jsf.model.Option[] getSex(Long collectionId);

    com.sun.webui.jsf.model.Option[] getLifeStage(Long collectionId);

    com.sun.webui.jsf.model.Option[] getLifeForm(Long collectionId);

    com.sun.webui.jsf.model.Option[] getSubstrate(Long collectionId);

    com.sun.webui.jsf.model.Option[] getStorageType(Long collectionId);

    com.sun.webui.jsf.model.Option[] getPreservationMedium(Long collectionId);

    com.sun.webui.jsf.model.Option[] getOrigin(Long collectionId);

    com.sun.webui.jsf.model.Option[] getSpecimenType(Long collectionId);

    com.sun.webui.jsf.model.Option[] getSpecimenCategory(Long collectionId);

    com.sun.webui.jsf.model.Option[] getDescriptors();

    com.sun.webui.jsf.model.Option[] getCollectorsByGatheringObservation(Long gatheringObservationId);

    com.sun.webui.jsf.model.Option[] getGatheringObservationMethod(Long collectionId);

    com.sun.webui.jsf.model.Option[] getCollectors();

    org.inbio.ara.persistence.specimen.IdentificationStatus getIdentificationStatus(Long identificationStatusId);

    com.sun.webui.jsf.model.Option[] getTaxonsByCollection(Long collectionId);

    com.sun.webui.jsf.model.Option[] getNomenclaturalGroupCertificator();

    com.sun.webui.jsf.model.Option[] getRegion();

    org.inbio.ara.persistence.collection.Collection getCollection(Long id);

    com.sun.webui.jsf.model.Option[] getAllGatheringObservationMethod();

    com.sun.webui.jsf.model.Option[] getFeatureType();

    com.sun.webui.jsf.model.Option[] getProjection();

    com.sun.webui.jsf.model.Option[] getSiteCalculationMethod();

    org.inbio.ara.persistence.gis.FeatureType getFeatureTypeById(Long id);

    org.inbio.ara.persistence.gis.Projection getProjectionId(Long id);

    org.inbio.ara.persistence.gis.SiteCalculationMethod getSiteCalculationMethodById(Long id);

    org.inbio.ara.persistence.taxonomy.NomenclaturalGroup getNomenclaturalGroupById(Long id);

    com.sun.webui.jsf.model.Option[] getTaxons();

    com.sun.webui.jsf.model.Option[] getNomenclaturalGroups();

    java.lang.Long[] getSelectedUserTaxon(Long userId);

    java.lang.Long[] getSelectedUserNomenclaturalGroup(Long userId);
}
