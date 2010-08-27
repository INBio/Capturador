/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inbio.ara.facade.inventory;

import org.inbio.ara.dto.inventory.SpecimenDTO;

import java.util.List;
import javax.ejb.Remote;
import org.inbio.ara.dto.agent.CollectionDTO;
import org.inbio.ara.dto.inventory.GatheringObservationDTO;
import org.inbio.ara.dto.inventory.IdentificationDTO;
import org.inbio.ara.dto.inventory.IdentificationStatusDTO;
import org.inbio.ara.dto.inventory.IdentificationTypeDTO;
import org.inbio.ara.dto.inventory.PersonDTO;
import org.inbio.ara.dto.inventory.SelectionListDTO;
import org.inbio.ara.dto.inventory.TaxonDTO;
import org.inbio.ara.dto.inventory.TaxonomicalRangeDTO;

/**
 *
 * @author jgutierrez
 */
@Remote
public interface InventoryFacadeRemote {

    public List<CollectionDTO> getAllCollectionPaginated(int firstResult, int maxResults);

    /**
     * Retorna un listado de especimenes
     * @deprecated use instead:
     * public List<SpecimenDTO> getAllSpecimenPaginated(int first,
     *      int totalResults, int collectionId)
     */
    public List<SpecimenDTO> getAllSpecimenPaginated(int first, int totalResults);

    public List<SpecimenDTO> getAllSpecimenPaginated(int first,
            int totalResults, Long collectionId);

    public Long countSpecimens();

    /**
     * @param selectionListEntityId look for the Id of a element of the ENUM SelectionListEntity
     * @return
     * @see org.inbio.ara.dto.inventory.SelectionListEntity
     */
    public List<SelectionListDTO> getAllSelectionListElements(Long selectionListEntityId);

    /**
     * @param selectionListEntityId look for the Id of a element of the ENUM SelectionListEntity
     * @param collectionId corresponds to the Id of the current collection
     * @return
     * @see org.inbio.ara.dto.inventory.SelectionListEntity
     */
    public List<SelectionListDTO> getAllSelectionListElementsByCollection(Long selectionListEntityId, Long collectionId);

    /**
     * Persist and Specimen. Checks if the specimen is new and create it or if the
     * specimen allready exists just update it.
     *
     * If the LifeStageSexDTO list contains the same lifestageId, sexId but diferent quantities,
     * thos quantities would be added in the implementation
     *
     * @param specimenDTO
     * @throws java.lang.IllegalArgumentException if there is a missing mandatory field
     */
    public void saveSpecimen(SpecimenDTO specimenDTO) throws IllegalArgumentException;

    /**
     * Retorna un SpecimenDTO dado su ID
     *
     * @param specimenId
     * @return
     */
    public SpecimenDTO getSpecimenById(Long specimenId);

    /**
     * Retorna un listado de la recolecciones
     * @deprecated use instead:
     * public List<GatheringObservationDTO>
     *       getAllGatheringObservationPaginated(int first, int totalResults,
     *       int collectionId)
     */
    public List<GatheringObservationDTO> getAllGatheringObservationPaginated(int first, int totalResults);

    public List<GatheringObservationDTO>
            getAllGatheringObservationPaginated(int first, int totalResults,
            Long collectionId);

    public Long countGatheringObservations();

    /**
     * Retorna el total de collecciones existentes en la BD.in
     *
     * @return
     */
    public Long countCollections();

    public List<SpecimenDTO> updateCountryAndProvinceName(List<SpecimenDTO> sDTOList);

    public List<IdentificationStatusDTO> getAllIdentificationStatus();

    public List<IdentificationTypeDTO> getAllIdentificationTypes();

    public List<TaxonomicalRangeDTO> getAllTaxonomicalRage();

    public List<PersonDTO> getAllIdentifiers();

    public List<TaxonDTO> getAllTaxonByTaxononimcalRange(Long taxonomicalRange);

    public void reIdentify(List<IdentificationDTO> selectedIdentifications);

    public java.util.List<org.inbio.ara.dto.inventory.PersonDTO> getAllResponsibles();

    public java.util.List<org.inbio.ara.dto.inventory.PersonDTO> getAllColectors();

    public java.util.List<org.inbio.ara.dto.inventory.ProjectDTO> getAllProjects();

    public Long countIdentifications();

    /**
     * Used in ListIdentification.jsp
     * @param first
     * @param totalResults
     * @return IdentificationDTOs listed
     * @deprecated Use instead the method below:
     * public List<IdentificationDTO> getAllIdentificationPaginated(int first,
     *       int totalResults, <b>int collectionId</b>)
     */
    public List<IdentificationDTO> getAllIdentificationPaginated(int first, int totalResults);

    public List<IdentificationDTO> getAllIdentificationPaginated(int first,
            int totalResults, Long collectionId);

    public boolean matchCollectionProtocol(java.lang.Long collectionId, java.lang.Long protocolAtributeId, java.lang.String value);

    public org.inbio.ara.dto.inventory.GatheringObservationDTO saveGathering(org.inbio.ara.dto.inventory.GatheringObservationDTO gDTO);

    public java.lang.Long countGatheringDetail();

    public java.util.List<org.inbio.ara.dto.inventory.GatheringObservationDetailDTO> getDetailPaginatedByGathering(int first, int totalResults, java.lang.Long gathId);

    public java.util.List<org.inbio.ara.dto.inventory.PersonDTO> getAllDescriptors();

    public java.util.List<org.inbio.ara.dto.inventory.PersonDTO> getCollectorsByGathering(java.lang.Long gathid);

    public org.inbio.ara.dto.inventory.GatheringObservationDetailDTO saveGatheringDetail(org.inbio.ara.dto.inventory.GatheringObservationDetailDTO gdDTO);

    public org.inbio.ara.dto.inventory.GatheringObservationDetailDTO updateGatheringDetail(org.inbio.ara.dto.inventory.GatheringObservationDetailDTO gdDTO);

    public void updateGathering(org.inbio.ara.dto.inventory.GatheringObservationDTO gDTO);

    public void deleteAsociatedListByGatheringId(java.lang.Long gId);

    public int specimenGenerator(SpecimenDTO sDTO, IdentificationDTO iDTO,
            List<Long> lifeForms, int quantity)
            throws IllegalArgumentException;

    public java.util.List<org.inbio.ara.dto.inventory.PersonDTO> getAllValidators();

    public java.util.List<org.inbio.ara.dto.inventory.TaxonCategoryDTO> getAllTaxonCategories();

    public java.util.List<org.inbio.ara.dto.inventory.TaxonDTO> getAllTaxon();

    public int findSpecimensByGathObsId(java.lang.Long gId);

    public int findSpecimensByGathObsDetailId(java.lang.Long gId);

    public void deleteGatheringById(java.lang.Long gId);

    public void deleteGatheringDetailById(java.lang.Long gId);

    public int findDetailsByGathObsId(java.lang.Long gId);

    public List<GatheringObservationDTO> updateGathObsCountryAndProvinceName(List<GatheringObservationDTO> gDTOList);

    public List<SpecimenDTO> updateScientificName(List<SpecimenDTO> list);



    

    public List<GatheringObservationDTO> getGathObsBySiteId(java.lang.Long siteId);
}

